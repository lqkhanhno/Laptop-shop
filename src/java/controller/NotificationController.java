/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.OrderDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
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
public class NotificationController extends HttpServlet {

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
            service = "Display Notification";
        }
        try ( PrintWriter out = response.getWriter()) {
            switch (service) {
                case "Display Notification":
                    displayNotification(request, response);
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

    private void displayNotification(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Object email = session.getAttribute("email");

//        if(email == null || email.isEmpty()){
//            //dirrect to login
//            return;
//        }
        //email = "anhpn@gmail.com";
        //get user id
        int user_id = new UserDAO().getIdByEmail(email.toString());
        //get list order by user id
        Vector<Order> notiaccept = new OrderDAO().getNotiWhenAccept(user_id);
        Vector<Order> noticancel = new OrderDAO().getNotiWhenCancel(user_id);
        Vector<Order> notishipped = new OrderDAO().getNotiWhenShipped(user_id);

        request.setAttribute("listNotiacc", notiaccept);
        request.setAttribute("listNotican", noticancel);
        request.setAttribute("listNotiship", notishipped);
        dispath(request, response, "/notification.jsp");

    }

    public void dispath(HttpServletRequest request, HttpServletResponse response, String page) {
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
}
