/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Cart_ItemDAO;
import dal.CategoryDAO;
import dal.ProductDAO;
import dal.ShoppingCartDAO;
import dal.TypeProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.Product;
import model.ShoppingCart;

/**
 *
 * @author Admin
 */
public class SortController extends HttpServlet {

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
            out.println("<title>Servlet SortController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SortController at " + request.getContextPath() + "</h1>");
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
        TypeProductDAO db = new TypeProductDAO();
        String type = request.getParameter("type");
        String value = request.getParameter("value");
        int id;
        
        if(type==null) {
            id = 1;
        }       
        else if (value!= null) {
            id=Integer.parseInt(value);
        }
        else {
            id =Integer.parseInt(type);
        }     
        
        request.setAttribute("type", type);
        
        List<Product> list1 = db.getTopNewest();
        List<Product> list2 = db.getTopSell();
        List<Product> list3 = db.getTopSale();
 
        request.setAttribute("data1", list1);
        request.setAttribute("data2", list2);
        request.setAttribute("data3", list3);
        
        List<Product> list = new ArrayList<Product>();
        if(id==1) {
            list=list1;
        }
        else if(id==2) {
            list=list2;
        }
        else if(id==3)  {
            list=list3;
        }
        request.setAttribute("data", list);

        CategoryDAO c = new CategoryDAO();
        List<Category> sclist = c.getAll();
        
        int productsInCart=0;
        HttpSession session = request.getSession();
//        Object email = session.getAttribute("email");
            Object email = "anhpn@gmail.com";
        if(email!=null){
            ShoppingCart cart = new ShoppingCartDAO().getCartByEmail(email.toString());
            int quantityCart = new Cart_ItemDAO().getQuantityItemOfCartId(cart.getID());
            request.setAttribute("quantityCart", quantityCart);
        }else{
            request.setAttribute("quantityCart", 0);
        }

        request.setAttribute("sclist", sclist);

        request.getRequestDispatcher("sort.jsp").forward(request, response);
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
