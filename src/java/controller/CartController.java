/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import dal.Cart_ItemDAO;
import dal.ProductDAO;
import dal.ShoppingCartDAO;
import dal.UserDAO;
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
import model.Cart_Item;
import model.Product;
import model.ShoppingCart;

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
                    showCart(request,response);
                    break;
                case "add2Cart":
                    add2Cart(request,response);
                    
                    break;
                case "updateQuantity":
                    updateQuantity(request,response);
                    
                    break;
                case "deleteProduct":
                    deleteProduct(request,response);
                    break;
                case "checkOut":
                    checkOut(request,response);
                    break;
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


    private void showCart(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            HashMap<String, HashMap<String,String>>listIdPro
                = new HashMap<>();
//            Object email = session.getAttribute("email");
//            if(email==null){
//                //yes
//                dispath(request, response, "/index.html");
//            }else{
                //get cart by email
                int cart_id =  Integer.parseInt(session.getAttribute("cart_id").toString());
//                ShoppingCart cart = new ShoppingCartDAO().GetCartByEmail(email.toString());
                //get cart item import to hashmap listidpro
                listIdPro = new Cart_ItemDAO().getCartItemByCartId(cart_id);
//            }



            HashMap<String, String> order_Summary = getIn4Cart(listIdPro);
            request.setAttribute("order_Summary", order_Summary);
            request.setAttribute("Cart", listIdPro);

            dispath(request, response, "/shoppingcart.jsp");
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void add2Cart(HttpServletRequest request, HttpServletResponse response) {
//        "Cart" => hashmap(String id_product,hashmap) {
//                id_product => hashmap<String, String>{
//                        'id'=> id_product,
//                        'image'=>image,
//                        'name'=>name,
//                        'price'=>sell_price
//                        'sale_percent'=>sale_percent
//                        'quantity'=>1
//                }
//        }
        
        ProductDAO dao = new ProductDAO();
        HttpSession session = request.getSession();
        //check session have email or not
//        Object email = session.getAttribute("email");
        Object email = "anhpn@gmail.com";
//        if(email==null){
//            //yes:
//                System.out.println("You need login to shopping");
//                //return: "You need login to shopping"
//        }else{
            //yes
            //get product_id
            int product_id = Integer.parseInt(request.getParameter("id_product"));
            
            if(!checkExistProduct(product_id)){//check product exist or not
                //no: return : ""Product is not exist";
                System.out.println("Product is not exist");
            }else{
                //yes:
                    //check in session have cartid or not
                Object cartID = session.getAttribute("cart_id");
                if(cartID==null){
                    //getcart by email
                    ShoppingCart cart = new ShoppingCartDAO().getCartByEmail(email.toString());
                    //check exist or not
                    if(cart==null){
                        int userID = new UserDAO().getIdByEmail(email.toString());
                        //create new shopping cart
                        int a = new ShoppingCartDAO().createShoppingCart(userID);
                        if(a==0){
                            System.out.println("Can't add shoppingcart");
                        }else{
                            cart = new ShoppingCartDAO().getCartByEmail(email.toString());
                            cartID=cart.getID();
                        }
                    }
                    //add session ("cart", cart_id);
                    session.setAttribute("cart_id", cart.getID());
                }
                
                 //check in cart_item by cart_id vs product_id
                if(!new Cart_ItemDAO().checkExist_Cart_Item_W_ID_And_PId(cartID.toString(), product_id)){
                    //no
                    //add new to cart_item
                    Cart_Item cart_item = new Cart_Item(Integer.parseInt(cartID.toString()), product_id,1);
                    int n = new Cart_ItemDAO().addCart_Item(cart_item);
                    if(n==0){
                        System.out.println("Can't add cart item");
                    }
                }else{
                    //yes:
                    //update amount to cart_item
                    int n = new Cart_ItemDAO().increase_1_Amount(Integer.parseInt(cartID.toString()), product_id);
                    if(n==0){
                        System.out.println("Can't increace ");
                    }
                }
            }
//        }
    }

    private void updateQuantity(HttpServletRequest request, HttpServletResponse response) {
        //get cart id in session
        HttpSession session = request.getSession();
        int cart_id =  Integer.parseInt(session.getAttribute("cart_id").toString());
        //get cart 
        HashMap<String, HashMap<String,String>>listIdProduct
                    =new Cart_ItemDAO().getCartItemByCartId(cart_id);
        
        //get
        String id_product = request.getParameter("id_product");
        String quantity = request.getParameter("quantity");
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
                        //update amount in db
                        Cart_Item cItem = new Cart_Item(cart_id, Integer.parseInt(id_product), Integer.parseInt(quantity));
                        int n = new Cart_ItemDAO().updateAmount(cItem);
                        if(n==0){
                            System.out.println("Can't not update amount");
                        }
                        //update amount in list to display for user
                        HashMap<String, String> infoProduct = listIdProduct.get(id_product);
                        infoProduct.put("quantity", String.valueOf(quantity));
                        HashMap<String, String> order_summary = getIn4Cart(listIdProduct);
                        
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");

                        
                        response.getWriter().write(new Gson().toJson(order_summary));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
         //get cart id in session
        HttpSession session = request.getSession();
        int cart_id =  Integer.parseInt(session.getAttribute("cart_id").toString());
        //get cart 
        HashMap<String, HashMap<String,String>>listIdProduct
                    =new Cart_ItemDAO().getCartItemByCartId(cart_id);
        
        String idDelete = request.getParameter("id_product");
        try {
            if(checkExistProduct1(listIdProduct,idDelete)){
                //remove product in cart_item
                int n = new Cart_ItemDAO().removeProductById(cart_id,idDelete);
                
                //remove in list
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

    private boolean checkExistProduct1(HashMap<String, HashMap<String, String>> listIdProduct, String idDelete) {
        Set<String> keySet = listIdProduct.keySet();
        for(Object key: keySet){
            if(key.toString().equalsIgnoreCase(idDelete)){
                return true;
            }
        }
        return false;
        
        
        
    }

    private boolean checkExistProduct(int product_id) {
        ProductDAO dao = new ProductDAO();
        Product p = dao.GetProductByID(product_id);
        if(p!=null){
            return true;
        }
        return false;
    }

    private void checkOut(HttpServletRequest request, HttpServletResponse response) {
        
    }
    
    

}
