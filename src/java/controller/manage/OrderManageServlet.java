/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.manage;

import com.google.gson.Gson;
import dal.OrderDAO;
import dal.OrderManageDAO;
import dal.Order_DetailDAO;
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
 * @author lqka
 */
public class OrderManageServlet extends HttpServlet {

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
            service = "Display";
        }

        try ( PrintWriter out = response.getWriter()) {
            switch (service) {
                case "ProcessCancel":
                    process_Cancel(request, response);
                    break;
                case "ProcessAccept":
                    process_Accept(request, response);
                    break;
                case "ProcessShipping":
                    process_Shipping(request, response);
                    break;
                case "Display":
                    display(request, response);
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

    private void process_Cancel(HttpServletRequest request, HttpServletResponse response) {
        String order_id = request.getParameter("order_id");
        try {
            Integer.parseInt(order_id);
        } catch (Exception e) {
            try {
                response.sendError(400, "order id is not exist");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        //get status of order id 
        String status = new OrderManageDAO().getStatus(order_id);
        //check status is wait accept or not
        if (!status.equalsIgnoreCase("Wait Accept")) {
            try {
                //error
                response.sendError(400, "This purchase order is not in the status of Wait To Accept thanks");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        int n = new OrderManageDAO().cancelOrder(order_id);
        if (n == 0) {
            try {
                //delete error
                response.sendError(400, "Can't delete this order");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //delete success 

        //get order by order_id
        try {
            Order o = new OrderDAO().getOrderByOrderId(Integer.parseInt(order_id));
            Map<String, Map<String, String>> listProductOrderDetail = new Order_DetailDAO().getListDetailByOrderID(o.getID());
            Vector vec = new Vector();
            vec.add(o);
            vec.add(listProductOrderDetail);
            //return to ajax to append
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(vec));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private Vector<Order> sortListVector(Vector<Order> vec, int type) {

        Collections.sort(vec, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {

                if (type == 1) // sap xep theo id
                {
                    if (o1.getID() < o2.getID()) {
                        return 1;
                    } else if (o1.getID() > o2.getID()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else { //sap xep theo ngay
                    if (o1.getUpdated_At().before(o2.getUpdated_At())) {
                        return 1;
                    } else if (o1.getUpdated_At().after(o2.getUpdated_At())) {
                        return -1;
                    } else {
                        return 0;
                    }
                }

            }
        });
        return vec;
    }

    private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Vector<Order> listWaitforCf = new OrderManageDAO().getListOrderByStatus("Wait Accept");
        Vector<Order> ListWaitforShip = new OrderManageDAO().getListOrderByStatus("Shipping");
        Vector<Order> listShipped = new OrderManageDAO().getListOrderByStatus("Shipped");
        Vector<Order> listCanceled = new OrderManageDAO().getListOrderByStatus("Canceled");

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
        Vector<Order> listOrder = new OrderManageDAO().getListOrder();
        Map<String, Map<String, Map<String, String>>> listOrderMap
                = new Order_DetailDAO().getOrderDetailForListOrder(listOrder);
        request.setAttribute("listOrder", listOrderMap);
        request.setAttribute("listOrderTotal", listOrder);
        pirnt(listOrderMap);

        //return list and sort
        request.setAttribute("ListWaitforShip", sortListVector(ListWaitforShip, -1));
        request.setAttribute("listWaitforCf", sortListVector(listWaitforCf, -1));
        request.setAttribute("listShipped", sortListVector(listShipped, -1));
        request.setAttribute("listCanceled", sortListVector(listCanceled, -1));
        request.getRequestDispatcher("manager/ordermanage.jsp").forward(request, response);
        //      dispath(request, response, "/order.jsp");

    }

    private void pirnt(Map<String, Map<String, Map<String, String>>> listOrder) {
        Map<String, Map<String, String>> listProductODetail
                = listOrder.get("11");
        Set<String> keySet = listProductODetail.keySet();
        for (Object objKey : keySet) {
            Map<String, String> listAtrr = listProductODetail.get(objKey);
            System.out.println(listAtrr.get("productName"));

        }
    }

    private void process_Accept(HttpServletRequest request, HttpServletResponse response) {
        String order_id = request.getParameter("order_id");
        try {
            Integer.parseInt(order_id);
        } catch (Exception e) {
            try {
                response.sendError(400, "order id is not exist");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        //get status of order id 
        String status = new OrderManageDAO().getStatus(order_id);
        //check status is wait accept or not
        if (!status.equalsIgnoreCase("Wait Accept")) {
            try {
                //error
                response.sendError(400, "This purchase order is not in the status of Wait To Accept thanks");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        
        int n = new OrderManageDAO().AcceptOrder(order_id);
        if (n == 0) {
            try {
                //delete error
                response.sendError(400, "Can't delete this order");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //delete success 

        //get order by order_id
        try {
            Order o = new OrderDAO().getOrderByOrderId(Integer.parseInt(order_id));
            Map<String, Map<String, String>> listProductOrderDetail = new Order_DetailDAO().getListDetailByOrderID(o.getID());
            Vector vec = new Vector();
            vec.add(o);
            vec.add(listProductOrderDetail);
            //return to ajax to append
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(vec));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void process_Shipping(HttpServletRequest request, HttpServletResponse response) {
        String order_id = request.getParameter("order_id");
        try {
            Integer.parseInt(order_id);
        } catch (Exception e) {
            try {
                response.sendError(400, "order id is not exist");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        //get status of order id 
        String status = new OrderManageDAO().getStatus(order_id);
        //check status is wait accept or not
        if (!status.equalsIgnoreCase("Shipping")) {
            try {
                //error
                response.sendError(400, "This purchase order is not in the status of Shipping thanks");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        int n = new OrderManageDAO().shippedOrder(order_id);
        if (n == 0) {
            try {
                //delete error
                response.sendError(400, "Can't delete this order");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //delete success 

        //get order by order_id
        
        try {
            Order o = new OrderDAO().getOrderByOrderId(Integer.parseInt(order_id));
            Map<String, Map<String, String>> listProductOrderDetail = new Order_DetailDAO().getListDetailByOrderID(o.getID());
            Vector vec = new Vector();
            vec.add(o);
            vec.add(listProductOrderDetail);
            //return to ajax to append
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(vec));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
