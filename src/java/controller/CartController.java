/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;

/**
 *
 * @author LAPTOP VINH HA
 */
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
                
        
        String service = request.getParameter("s");
        if (service == null) {
            service = "showCart";
        }
        try ( PrintWriter out = response.getWriter()) {
            
            switch (service) {
                case "showCart":
                    ShowCart(request,response);
                    break;
                case "add2Cart":
                    Add2Cart(request,response);
                    
                    break;
                case "updateQuantity":
                    UpdateQuantity(request,response);
                    
                    break;
                case "deleteProduct":
                    DeleteProduct(request,response);
                    
                    break;
            }

        }
    }

    private void ShowCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        HashMap<String, HashMap<String,String>>listIdPro
            = (HashMap<String, HashMap<String,String>>)
            session.getAttribute("Cart");
        HashMap<String, String> order_Summary = getIn4Cart(listIdPro);
        request.setAttribute("order_Summary", order_Summary);
        request.setAttribute("Cart", listIdPro);
        try {
            dispath(request, response, "/shoppingcart.jsp");
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void Add2Cart(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, HashMap<String,String>>listIdProduct
                                = new HashMap<>();
        HttpSession session = request.getSession();
        ProductDAO dao = new ProductDAO();
        //get id product
        String id = request.getParameter("id_product");
        //find product by id 
        Product product = dao.GetProductByID(Integer.parseInt(id));
        //check exist or not
        String notification;
        if (product == null) {
            notification = "Product is not exist";
        } else {
            //get Cart in session  
            listIdProduct=(HashMap<String, HashMap<String,String>>)
                    session.getAttribute("Cart");
            /*
            "Cart" => hashmap(String id_product,hashmap) {
                        id_product => hashmap<String, String>{
                                        'id'=> id_product,
                                        'image'=>image,
                                        'name'=>name,
                                        'price'=>sell_price
                                        'sale_percent'=>sale_percent
                                        'quantity'=>1
                                }
                    }
            */
            // seach in cart have product_id or not, or Cart is empty
            if(listIdProduct==null){

                //create infoProduct new hashmap {id,image,name,price,sale_percent,quantity} of product
                HashMap<String, String> infoProduct = new HashMap<>();
                infoProduct.put("id", String.valueOf(id));
                infoProduct.put("image", product.getImage());
                infoProduct.put("name", product.getProductName());
                infoProduct.put("price", String.valueOf(product.getSellPrice()));
                infoProduct.put("sale_percent", String.valueOf(product.getSalePercent()));
                infoProduct.put("quantity", String.valueOf(1));

                //put infoProduct hashmap to listIDProduct with key (id_product)
                HashMap<String, HashMap<String,String>>listIdProduct1= new HashMap<>();
                listIdProduct1.put(id, infoProduct);
                session.setAttribute("Cart", listIdProduct1);
            }else{
                if(!checkIdInListIdProduct(listIdProduct,id)){
               //create infoProduct new hashmap {id,image,name,price,sale_percent,quantity} of product
                    HashMap<String, String> infoProduct = new HashMap<>();
                    infoProduct.put("id", String.valueOf(id));
                    infoProduct.put("image", product.getImage());
                    infoProduct.put("name", product.getProductName());
                    infoProduct.put("price", String.valueOf(product.getSellPrice()));
                    infoProduct.put("sale_percent", String.valueOf(product.getSalePercent()));
                    infoProduct.put("quantity", String.valueOf(1));

                    //put infoProduct hashmap to listIDProduct with key (id_product)
                    listIdProduct.put(id, infoProduct);
                }else{
                    //yes
                    HashMap<String, String> infoProduct = listIdProduct.get(id);
                    int quantity = Integer.parseInt(infoProduct.get("quantity"))+1;
                    infoProduct.put("quantity", String.valueOf(quantity));
                }
            }

            notification = "Add to Cart Success";
        }
        String link = "home?notification=" + notification;
        try {
            response.sendRedirect(link);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void UpdateQuantity(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, HashMap<String,String>>listIdProduct
                                = new HashMap<>();
        HttpSession session = request.getSession();
        //get
        String id_product = request.getParameter("id_product");
        String quantity = request.getParameter("quantity");
        listIdProduct=(HashMap<String, HashMap<String,String>>)
                    session.getAttribute("Cart");
        try {
            if(Integer.parseInt(quantity)<1){
            response.sendError(400,"Ow quantity cannot be less than 0!!");

            }else{
                if(listIdProduct==null){
                    response.sendError(400,"Cart is empty bru!!");
                }else{
                    if(!checkIdInListIdProduct(listIdProduct,id_product)){
                        response.setCharacterEncoding("UTF-8");
                        response.sendError(400,"Product is not in Cart bru, Are u s?e !!");
                    }else{
                        HashMap<String, String> infoProduct = listIdProduct.get(id_product);
                        infoProduct.put("quantity", String.valueOf(quantity));
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");

                        HashMap<String, String> order_summary = getIn4Cart(listIdProduct);
                        response.getWriter().write(new Gson().toJson(order_summary));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void DeleteProduct(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, HashMap<String,String>>listIdProduct
                                = new HashMap<>();
        HttpSession session = request.getSession();
        String idDelete = request.getParameter("id_product");
        listIdProduct=(HashMap<String, HashMap<String,String>>)
                    session.getAttribute("Cart");
        try {
            if(checkExistProduct(listIdProduct,idDelete)){
                listIdProduct.remove(idDelete);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                HashMap<String, String> order_summary = getIn4Cart(listIdProduct);
                response.getWriter().write(new Gson().toJson(order_summary));
            }else{
                response.sendError(400,"Cart does not have this product to delete !!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void dispath(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {
        //select jsp to view
        RequestDispatcher dispath
                = request.getRequestDispatcher(page);
        //run
        dispath.forward(request, response);
    }

    void dis(HashMap<String, ArrayList<String>> listMap) {
        Set<String> keySet = listMap.keySet();
        int totalCart = 0;
        for (String key : keySet) {
            ArrayList<String> product = new ArrayList();
            if (key.equalsIgnoreCase("totalCart")) {
                totalCart = Integer.parseInt(listMap.get(key).get(0));
            } else {
                product = listMap.get(key);
                System.out.println(product.toString());
            }
        }
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean checkIdInListIdProduct(HashMap<String, HashMap<String, String>> listIdProduct, String id) {
        Set<String> keySet = listIdProduct.keySet();
        for(Object key: keySet){
            if(key.toString().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }

    private HashMap<String, String> getIn4Cart(HashMap<String, HashMap<String, String>> listIdProduct) {
        HashMap<String, String> listIdPro = new HashMap<>();
        Set<String> keySet = listIdProduct.keySet();
        int totalCart=0;
        int totalGrand=0;
        int discount=0;
        for(Object key: keySet){
            Map<String, String> infoProduct = listIdProduct.get(key);
            int quantity =Integer.parseInt(infoProduct.get("quantity"));
            int sale_percent =Integer.parseInt(infoProduct.get("sale_percent"));
            int price =Integer.parseInt(infoProduct.get("price"));
            int total = price * quantity;
            totalGrand+=total;
            discount+=quantity*price*sale_percent;
            totalCart+= total-(quantity*price*sale_percent);
            listIdPro.put(infoProduct.get("id"), String.valueOf(total));
        }
        listIdPro.put("totalGrand",String.valueOf(totalGrand));
        listIdPro.put("totalCart",String.valueOf(totalCart));
        listIdPro.put("discount",String.valueOf(discount));
        
        return listIdPro;
    }

    private boolean checkExistProduct(HashMap<String, HashMap<String, String>> listIdProduct, String idDelete) {
        Set<String> keySet = listIdProduct.keySet();
        for(Object key: keySet){
            if(key.toString().equalsIgnoreCase(idDelete)){
                return true;
            }
        }
        return false;
        
        
        
    }
}
