/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Cart_ItemDAO;
import dal.OrderDAO;
import dal.Order_DetailDAO;
import dal.ProductDAO;
import dal.ShoppingCartDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Order;
import model.User;

/**
 *
 * @author LAPTOP VINH HA
 */
public class CheckoutController extends HttpServlet {

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
            service = "checkOut";
        }
        
        try ( PrintWriter out = response.getWriter()) {
            switch(service){
                case "checkOut":
                    checkOut(request,response);
//                    dispath(request, response, "checkout.jsp");
                    break;
                case "processCheckOut":
                    processCheckOut(request,response);
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

    private void checkOut(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        //get in4 user by email in session 
        
        //String email = session.getAttribute("email").toString();
        
        User u = new UserDAO().getIn4UserByEmail("anhpn@gmail.com");
        //get list cart by cart_id in session
        HashMap<String, HashMap<String,String>>listPro
            = new HashMap<>();
        int cart_id =  Integer.parseInt(session.getAttribute("cart_id").toString());
        listPro = new Cart_ItemDAO().getCartItemByCartId(cart_id);
        //get orderSumary to display
        HashMap<String, String> order_Summary = new ShoppingCartDAO().getIn4Cart(listPro);
        listPro.put("order_summary", order_Summary);
        
        int quantityCart = new Cart_ItemDAO().getQuantityItemOfCartId(cart_id);
        request.setAttribute("quantityCart", quantityCart);
        
        request.setAttribute("in4User", u);
        request.setAttribute("listProduct", listPro);
        
        dispath(request, response, "/checkout.jsp");
    }
    
    
    public void dispath(HttpServletRequest request, HttpServletResponse response, String page)
             {
        //select jsp to view
        RequestDispatcher dispath
                = request.getRequestDispatcher(page);
        try {
            //run
            dispath.forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void processCheckOut(HttpServletRequest request, HttpServletResponse response) {
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        int userID = new UserDAO().getIdByEmail(email);
        //get cart_id in session
        //get cart item by cart id 
        HttpSession session = request.getSession();
        HashMap<String, HashMap<String,String>>listIdPro
            = new HashMap<>();
        int cart_id =  Integer.parseInt(session.getAttribute("cart_id").toString());
        listIdPro = new Cart_ItemDAO().getCartItemByCartId(cart_id);
//        listIdPro {
//              id_product => hashmap<String, String>{
//                        'id'=> id_product,
//                        'image'=>image,
//                        'name'=>name,
//                        'price'=>sell_price
//                        'sale_percent'=>sale_percent
//                        'quantity'=>1
//                }
//        }

        //get total price from listidpro
        int toalPrice = getTotalPrice(listIdPro);
        //add order for userID
        java.util.Date utilDate = new java.util.Date();
        Date date = new Date(utilDate.getTime()); 
        String status = "Chờ xác nhận";
        Order o = new Order(userID, toalPrice, status, date, note);
        int n = new OrderDAO().addOrder(o);
        if(n==0){
            System.out.println("can't add order");
            return;
        }
        int orderId = new OrderDAO().getOrderIdLates(userID);
        //add list cart to order detail
        int m = new Order_DetailDAO().addListCart2OrderDetail(listIdPro, orderId);
        if(m==1){
            System.out.println("Can't add to Orderdetail");
            return;
        }
                
        //remove list cart in cart_item by cartId
        m = new Cart_ItemDAO().removeListCartItemByCartId(listIdPro,cart_id);
        if(m==1){
            System.out.println("Can't remove Cart Item");
        }
        
        //decrease quantity product after checkout
//        m = new ProductDAO().decreaseQuantityProductAfterCheckout(listIdPro);
        System.out.println("Checkout success");
        
        
    }
    
    private int getTotalPrice(HashMap<String, HashMap<String, String>> listIdProduct) {
        int totalPrice=0;
        Set<String> keySet = listIdProduct.keySet();
        for(Object key: keySet){
            Map<String, String> infoProduct = listIdProduct.get(key);
            int quantity =Integer.parseInt(infoProduct.get("quantity"));
            int sale_percent =Integer.parseInt(infoProduct.get("sale_percent"));
            int price =Integer.parseInt(infoProduct.get("price"));
            int total = price * quantity;
            totalPrice+= total-(quantity*price*sale_percent);
        }
        
        return totalPrice;
    }

    
}
