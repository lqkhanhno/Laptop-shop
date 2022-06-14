/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manage;

import dal.CategoryDAO;
import dal.ManageDAO;
import dal.SupplierDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;
import model.Supplier;

/**
 *
 * @author LAM
 */
public class EditProductServlet extends HttpServlet {

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
            out.println("<title>Servlet EditProductServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProductServlet at " + request.getContextPath() + "</h1>");
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
        SupplierDAO sp = new SupplierDAO();
         CategoryDAO c = new CategoryDAO();
        List<Category> sclist = c.getAll();
        
        List<Supplier> splist = sp.getAll();

        request.setAttribute("sclist", sclist);
        request.setAttribute("splist", splist);
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.getRequestDispatcher("editproduct.jsp?id=" + id).forward(request, response);
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
        
        String pid = request.getParameter("id");
        String name = request.getParameter("name");
        String decription = request.getParameter("description");
        String oprice = request.getParameter("oprice");
        String image = request.getParameter("image");
        String cate = request.getParameter("category");
        String sprice = request.getParameter("sellprice");
        String amount = request.getParameter("amount");
        String sale = request.getParameter("sale");
        String supid = request.getParameter("suppliID");
        String rdate = request.getParameter("releasedate");
        String issell = request.getParameter("issell");
        
        
        
        int oprice1,sprice1,sale1,supid1;
        int amount1,id1;
        int issell1;
        Date release_date;
        try {
            issell1 = Integer.parseInt(issell);
        } catch (NumberFormatException e) {
            issell1 = 0;
        }
        try {
            id1 = Integer.parseInt(pid);
        } catch (NumberFormatException e) {
            id1 = 0;
        }
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
        try {
            supid1 = Integer.parseInt(supid);
        } catch (NumberFormatException e) {
            supid1 = 0;
        }
        
        CategoryDAO c = new CategoryDAO();
        Category cate1 = c.getByName(cate);
        SupplierDAO sp = new SupplierDAO();
        Supplier s = sp.getByID(supid1);
        
        try {
            release_date = Date.valueOf(rdate);
        } catch (NumberFormatException e) {
            release_date = (Date) new java.util.Date();
        }
        
        
        
        
        ManageDAO mdb = new ManageDAO();
        Product p = new Product(id1,name, image, decription, oprice1, cate1,sprice1 , sale1 ,amount1,s ,release_date ,issell1);
        mdb.editProduct(p);
        
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
