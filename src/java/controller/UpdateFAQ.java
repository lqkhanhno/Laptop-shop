/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoryDAO;
import dal.FaqDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.FAQs;

/**
 *
 * @author Admin
 */
public class UpdateFAQ extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateFAQ</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateFAQ at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.sendRedirect("editfaq");
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
        
        //edit       
        String ques = request.getParameter("ques");
        String ans = request.getParameter("ans");

        String fid = request.getParameter("fid");
        
        int faqid = Integer.parseInt(fid);

        FAQs f = new FAQs();
        f.setTitle(ques);
        f.setContent(ans);
        f.setID(faqid);
        
        request.setAttribute("f", f);

        db.UpdateFaq(f);        
        response.sendRedirect("editfaq");
        
//        if (fid != null && eans!= null && eques!=null) {
//            int faqid = Integer.parseInt(fid);
//            FAQs faq1 = db.getByID(faqid);
//            if(!eques.equals(faq1.getTitle()) && !eans.equals(faq1.getContent())) {
//                FAQs f = new FAQs();
//                f.setTitle(eques);
//                f.setContent(eans);
//                f.setAuthorID(faq1.getAuthorID());
//                f.setID(faqid);
//
//                db.UpdateFaq(f);
//                response.sendRedirect("editfaq");
//            }
//        }
//        else {
//            response.sendRedirect("editfaq");
//        }  
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
