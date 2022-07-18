/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoryDAO;
import dal.FaqDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.FAQs;
import model.User;

/**
 *
 * @author Admin
 */
public class EditFAQController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


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
        
        FaqDAO fd = new FaqDAO();
        List<FAQs> list = fd.getAll();
        
        CategoryDAO c = new CategoryDAO();
        List<Category> sclist = c.getAll();
        
        request.setAttribute("list", list);
        request.setAttribute("sclist", sclist);     
        
        request.getRequestDispatcher("editfaq.jsp").forward(request, response);
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
        
        FaqDAO db = new FaqDAO();
        
        CategoryDAO c = new CategoryDAO();
        List<Category> sclist = c.getAll();
        
        request.setAttribute("sclist", sclist); 
        
        List<FAQs> list = db.getAll();
        request.setAttribute("list", list);
                
        //add
        String ques = request.getParameter("question");
        String ans = request.getParameter("answer");
        
        HttpSession session = request.getSession();
        String e = session.getAttribute("email").toString();
                
        UserDAO dbx = new UserDAO();
        User user = dbx.getIn4UserByEmail(e);
        
        if (!ques.isEmpty() && !ans.isEmpty() && db.checkExist(ques,ans) ) {           
            FAQs faq = new FAQs();
            
            faq.setTitle(ques);
            faq.setContent(ans);
            faq.setAuthorID(user);

            db.AddFaq(faq);
            response.sendRedirect("editfaq");
        }
        else {
            response.sendRedirect("editfaq");
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
