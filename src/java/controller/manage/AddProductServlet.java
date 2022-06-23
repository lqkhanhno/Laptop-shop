/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manage;

import dal.ManageDAO;
import dal.CategoryDAO;
import dal.SupplierDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.Category;
import model.Supplier;

/**
 *
 * @author LAM
 */
public class AddProductServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddProductServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProductServlet at " + request.getContextPath() + "</h1>");
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
        response.sendRedirect("listmanage");
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
        
//        String pid = request.getParameter("id");
        String name = request.getParameter("name");
        String decription = request.getParameter("description");
        String oprice = request.getParameter("oprice");
        String image = request.getParameter("image");
        String cate = request.getParameter("category");
        String sprice = request.getParameter("sellprice");
        String amount = request.getParameter("amount");
        String sale = request.getParameter("sale");
        String supid = request.getParameter("supplierID");
        String rdate = request.getParameter("releasedate");
        
        
        
        int oprice1,sprice1,sale1,sup1;
        int amount1, categoryID;
        Date release_date;
        
        try {
            sup1 = Integer.parseInt(supid);
        } catch (NumberFormatException e) {
            sup1 = 0;
        }
        
        CategoryDAO c = new CategoryDAO();
        Category cate1 = c.getByName(cate);
        try {
            oprice1 = Integer.parseInt(oprice);
        } catch (NumberFormatException e) {
            oprice1 = 0;
        }
        try {
            sprice1 = Integer.parseInt(sprice);
        } catch (NumberFormatException e) {
            sprice1 = 0;
        }
        
        try {
            amount1 = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            amount1 = 0;
        }
        try {
            sale1 = Integer.parseInt(sale);
        } catch (NumberFormatException e) {
            sale1 = 0;
        }
       SupplierDAO sp = new SupplierDAO();
       Supplier s = sp.getByID(sup1);
       
        
        
        
        try {
            release_date = Date.valueOf(rdate);
        } catch (NumberFormatException e) {
            release_date = (Date) new java.util.Date();
        }
        

        
        Product p = new Product(0, name, image, decription, oprice1, cate1 ,sprice1 , sale1 ,amount1,s ,release_date ,0);
        ManageDAO mdb = new ManageDAO();
        mdb.addProduct(p);
        response.sendRedirect("listmanage");
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
