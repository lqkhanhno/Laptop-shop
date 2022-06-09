/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;

/**
 *
 * @author LAPTOP VINH HA
 */
public class ControllerCart extends HttpServlet {

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
            service = "showCart";
        }
        HttpSession session = request.getSession();

        try ( PrintWriter out = response.getWriter()) {
            if (service.equalsIgnoreCase("showCart")) {
                //get key in session
                Enumeration em = session.getAttributeNames();
//                request.setAttribute("Cart", em);
                String username = (String) session.getAttribute("username");
                HashMap<String, ArrayList<String>> listMap = new HashMap<>();

                int totalCart = 0;
                //loop to each element
                while (em.hasMoreElements()) {
                    ArrayList<String> list = new ArrayList();
                    int total = 0;
                    String key = em.nextElement().toString();
                    //check key != username and "usename"
                    if (!key.equalsIgnoreCase(username) && !key.equalsIgnoreCase("username")) {
                        Object value = session.getAttribute(key); //get value
                        list = (ArrayList<String>) value;
                        total = Integer.parseInt(list.get(0)) * Integer.parseInt(list.get(2));
                        //get value add to map
                        /*map[
                            id_product => list [amount, name, price, total]
                            "totalCart" => totalCart
                        ]
                         */

                        list.add(String.valueOf(total));

                        totalCart += total;
                        listMap.put(key, list);
                        
                    }
                }
                ArrayList<String> listTotalCart = new ArrayList();
                listTotalCart.add(String.valueOf(totalCart));
                listMap.put("totalCart", listTotalCart);
//                this.dis(listMap);
                request.setAttribute("Cart", listMap);
//                dispath(request, response, "/cart.jsp");
                dispath(request, response, "/shoppingcart.jsp");

            } else if (service.equalsIgnoreCase("add2Cart")) {
                ProductDAO dao = new ProductDAO();
                //get id product
                String id = request.getParameter("id_product");
                //find product by id 
                Product product = dao.GetProductByID(Integer.parseInt(id));
                //check exist or not
                String notification;
                if (product == null) {
                    notification = "Product is not exist";
                } else {
                    //create list
                    List<String> list = new ArrayList<>();
                    //value = check in session had product id or not
                    Object value = session.getAttribute(id);
                    if (value == null) {
                        // no:
                        //add list[amount, name, price product]
                        //add to session[product_id => list]
                        list.add("1");

                        list.add(product.getProductName());
                        list.add(String.valueOf(product.getSellPrice()));

                        session.setAttribute(id, list);
                    } else {
                        //yes:
                        //add value => list
                        //increase amount +1
                        //set list[0 => new amount]
                        list = (ArrayList<String>) value;
                        int amount = Integer.parseInt(list.get(0)) + 1;
                        list.set(0, String.valueOf(amount));
                    }
                    notification = "Add to Cart Success";
                }
                String link = "home?notification=" + notification;
                response.sendRedirect(link);

            }

        }
    }
    
    public void dispath(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {
        //select jsp to view
        RequestDispatcher dispath
                = request.getRequestDispatcher(page);
        //run
        dispath.forward(request, response);
    }

    void dis(HashMap<String, ArrayList<String>> listMap){
        Set<String> keySet = listMap.keySet();
        int totalCart=0;
        for(String key: keySet){
            ArrayList<String> product = new ArrayList();
            if(key.equalsIgnoreCase("totalCart")){
                totalCart = Integer.parseInt(listMap.get(key).get(0));
            }else{
                product = listMap.get(key);
                System.out.println(product.toString());
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

}
