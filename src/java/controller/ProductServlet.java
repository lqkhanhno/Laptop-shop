/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.Cart_ItemDAO;
import dal.CategoryDAO;
import dal.CommentDAO;
import dal.DetailDAO;
import dal.ShoppingCartDAO;
import dal.SupplierDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.Comment;
import model.Product;
import model.ShoppingCart;
import model.Supplier;
import model.User;

/**
 *
 * @author LAM
 */
public class ProductServlet extends HttpServlet {

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
            out.println("<title>Servlet ProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductServlet at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("productid"));
        DetailDAO db = new DetailDAO();
        Product p = db.getByPid(id);
        
        SupplierDAO sp = new SupplierDAO();
        List<Supplier> splist = sp.getAll();
        
        CategoryDAO c = new CategoryDAO();
        List<Category> sclist = c.getAll();

        CommentDAO cmt = new CommentDAO();
        List<Comment> cmtlist = cmt.getAllByID(id);

        request.setAttribute("id", request.getParameter("productid"));
        request.setAttribute("sclist", sclist);
        request.setAttribute("splist", splist);
        request.setAttribute("cmtlist", cmtlist);
        

        HttpSession session = request.getSession();

            Object email = "anhpn@gmail.com";
        if(email!=null){
            ShoppingCart cart = new ShoppingCartDAO().getCartByEmail(email.toString());
            int quantityCart = new Cart_ItemDAO().getQuantityItemOfCartId(cart.getID());
            request.setAttribute("quantityCart", quantityCart);
        }else{
            request.setAttribute("quantityCart", 0);
        }
        
        
        if (p == null) {
            response.sendRedirect("home");
        } else {
            request.setAttribute("data", p);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        }
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

}
