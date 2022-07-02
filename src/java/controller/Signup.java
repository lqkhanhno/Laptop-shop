/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import constant.Constant;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Thao Ngoc
 */
@WebServlet(name = "Signup", urlPatterns = {"/sign-up"})
public class Signup extends HttpServlet {

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
        request.getRequestDispatcher("signup.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("repassword");
        
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("address", address);
        request.setAttribute("phone", phone);

        boolean isValid = true;
        if(address.trim().isEmpty()) {
            isValid = false;
            request.setAttribute("msgAddress", "Address not blank");
        }
        if(username.trim().isEmpty()) {
            isValid = false;
            request.setAttribute("msgUsername", "Username not blank");
        }
        Pattern p = Pattern.compile(Constant.EMAIL_REGEX);
        Matcher m = p.matcher(email);
        if (!m.find()) {
            isValid = false;
            request.setAttribute("msgPassword", "Password is not valid");
        }
        p = Pattern.compile(Constant.PHONE_REGEX);
        m = p.matcher(phone);
        if(!m.find()) {
            isValid = false;
            request.setAttribute("msgPhone", "Phone number is not valid");
        }
        if(password.length() < 8) {
            isValid = false;
            request.setAttribute("msgPassword", "Password is not valid");
        }else if(!password.equals(rePassword)) {
            isValid = false;
            request.setAttribute("msgRePassword", "re-password not match");
        }
        if(isValid) {
            new UserDAO().insert(new User(0, "", username, password, email, 3, address, phone));
            response.sendRedirect("login");
        }else {
            processRequest(request, response);
        }
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

}
