/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manage;

import dal.ProductDAO;
import dal.CategoryDAO;
import dal.SupplierDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class ListManageServlet extends HttpServlet {

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
            out.println("<title>Servlet ListManageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListManageServlet at " + request.getContextPath() + "</h1>");
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
        
        ProductDAO db = new ProductDAO();
        List<Product> list1 = db.getAll();
        
        CategoryDAO sdb = new CategoryDAO();
        List<Category> sclist = sdb.getAll();
        
        SupplierDAO sp = new SupplierDAO();
        List<Supplier> splist = sp.getAll();
        
        int page, numperpage = 10;
        int size = list1.size();
        
        int num = (size % 10 == 0 ? (size / 10) : ((size / 10)) + 1);
        
        String xpage = request.getParameter("page");
        
        if (xpage == null){
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        
        int start, end;
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);
        
        List<Product> list = db.getListByPage(list1, start, end);
        
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("data", list);
        request.setAttribute("sclist", sclist);
        request.setAttribute("splist", splist);
        request.getRequestDispatcher("manageproduct.jsp").forward(request, response);
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
    

}
