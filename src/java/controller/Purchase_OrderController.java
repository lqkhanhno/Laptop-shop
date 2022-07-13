/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import dal.OrderDAO;
import dal.Order_DetailDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Order;

/**
 *
 * @author LAPTOP VINH HA
 */
public class Purchase_OrderController extends HttpServlet {

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
        if(service == null){
            service = "Display";
        }
        
        try ( PrintWriter out = response.getWriter()) {
            switch (service) {
                case "Process Cancel":
                    process_Cancel(request,response);
                    break;
                case "Display":
                    display(request,response);
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

    public void dispath(HttpServletRequest request, HttpServletResponse response, String page) {
        //select jsp to view
        RequestDispatcher dispath
                = request.getRequestDispatcher(page);
        try {
            //run
            dispath.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void process_Cancel(HttpServletRequest request, HttpServletResponse response) {
        String order_id = request.getParameter("order_id");
        try {
            Integer.parseInt(order_id);
        } catch (Exception e) {
            try {
                response.sendError(400,"order id is not exist");
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        //get status of order id 
        String status = new OrderDAO().getStatus(order_id);
        //check status is wait accept or not
        if(!status.equalsIgnoreCase("Wait Accept") ){
            try {
                //error
                response.sendError(400,"This purchase order is not in the status of Wait To Accept thanks");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        int n = new OrderDAO().cancelOrder(order_id);
        if(n == 0){
            try {
                //delete error
                response.sendError(400,"Can't delete this order");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //delete success 
        
        //get order by order_id
        Order o = new OrderDAO().getOrderByOrderId(Integer.parseInt(order_id));
        try {
            //return to ajax to append
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(o));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    private Vector<Order> sortListVector(Vector<Order> vec, int type) {
        
        Collections.sort(vec, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                
                if(type == 1) // sap xep theo id
                {
                    if(o1.getID() < o2.getID()){
                        return 1;
                    }else if(o1.getID() > o2.getID()){
                        return -1;
                    }else{
                        return 0;
                    }
                }else{ //sap xep theo ngay
                    if(o1.getUpdated_At().before(o2.getUpdated_At()) ){
                        return 1;
                    }else if(o1.getUpdated_At().after(o2.getUpdated_At())){
                        return -1;
                    }else{
                        return 0;
                    }
                }
                
            }
        });        
        return vec;
    }

    private void display(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
//        if(email == null || email.isEmpty()){
//            dispath(request, response, "/login.jsp");
//            return;
//        }
        email = "anhpn@gmail.com";
        int userid = new UserDAO().getIdByEmail(email);
        Vector<Order> listShipping = new OrderDAO().getListOrderByUserIDAndStatus(userid,"Shipping");
        Vector<Order> listWait = new OrderDAO().getListOrderByUserIDAndStatus(userid,"Wait Accept");
        Vector<Order> listShipped = new OrderDAO().getListOrderByUserIDAndStatus(userid,"Shipped");
        Vector<Order> listCanceled = new OrderDAO().getListOrderByUserIDAndStatus(userid,"Canceled");
        
        /*
        order detail
        map<order_id, map<product_id,map<String,String>>>
        {
            1:{
                    #11 :{
                            "image": 
                            "productName":
                            "productPrice".
                            "quantity"
                    }

                    #05 :{

                    }
            }
        }
        */
        Vector<Order> listOrderTotal = new OrderDAO().getListOrderByUserID(userid);
        Map<String, Map<String,Map<String,String>>> listOrder = 
                new Order_DetailDAO().getOrderDetailForListOrder(listOrderTotal);
        request.setAttribute("listOrder", listOrder);
        request.setAttribute("listOrderTotal", listOrderTotal);
        print(listOrder);
        
        //return list and sort
        request.setAttribute("listShipping", sortListVector(listShipping, -1));
        request.setAttribute("listWait", sortListVector(listWait, 1));
        request.setAttribute("listShipped", sortListVector(listShipped, -1));
        request.setAttribute("listCanceled", sortListVector(listCanceled, -1));
        
        dispath(request, response, "/order.jsp");
        
    }
    
    private void print( Map<String, Map<String,Map<String,String>>> listOrder ){
        Map<String,Map<String,String>> listProductODetail =
            listOrder.get("11");
        Set<String> keySet = listProductODetail.keySet();
        for(Object objKey : keySet){
            Map<String,String> listAtrr = listProductODetail.get(objKey.toString());
            System.out.println(listAtrr.get("productName"));
            
        }
    }
}
