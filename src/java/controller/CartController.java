/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import dal.Cart_ItemDAO;
import dal.DetailDAO;
import dal.ProductDAO;
import dal.ShoppingCartDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart_Item;
import model.Product;
import model.ShoppingCart;

/**
 *
 * @author LAPTOP VINH HA
 */
public class CartController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {

            switch (service) {
                case "showCart":
                    showCart(request, response);

                    break;
                case "add2Cart":
                    add2Cart(request, response);

                    break;
                case "updateQuantity":
                    updateQuantity(request, response);

                    break;
                case "deleteProduct":
                    deleteProduct(request, response);
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

    private void showCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        HashMap<String, HashMap<String, String>> listIdPro
                = new HashMap<>();
        Object email = session.getAttribute("email");
        if(email==null){
            //yes
            dispath(request, response, "/login");
        }else{
        //get cart by email
        Object cart_id = session.getAttribute("cart_id");
        if (cart_id != null) {
            listIdPro = new Cart_ItemDAO().getCartItemByCartId(Integer.parseInt(cart_id.toString()));

            int quantityCart = new Cart_ItemDAO().getQuantityItemOfCartId(Integer.parseInt(cart_id.toString()));
            request.setAttribute("quantityCart", quantityCart);

            moveToCartView(request, response, listIdPro);

            return;
        }
        ShoppingCart cart = new ShoppingCartDAO().getCartByEmail("anhpn@gmail.com");
        if (cart != null) {
            //add session ("cart", cart_id);
            session.setAttribute("cart_id", cart.getID());
            listIdPro = new Cart_ItemDAO().getCartItemByCartId(cart.getID());

            int quantityCart = new Cart_ItemDAO().getQuantityItemOfCartId(cart.getID());
            request.setAttribute("quantityCart", quantityCart);

            moveToCartView(request, response, listIdPro);

            return;
        }
        request.setAttribute("quantityCart", 0);

        request.setAttribute("Cart", listIdPro);
        dispath(request, response, "/shoppingcart.jsp");
        //get cart item import to hashmap listidpro
            }
    }

    private void add2Cart(HttpServletRequest request, HttpServletResponse response) {
//        "Cart" => hashmap(String id_product,hashmap) {
//                id_product => hashmap<String, String>{
//                        'id'=> id_product,
//                        'image'=>image,
//                        'name'=>name,
//                        'price'=>sell_price
//                        'sale_percent'=>sale_percent
//                        'quantity'=>1
//                }
//        }

        ProductDAO dao = new ProductDAO();
        HttpSession session = request.getSession();
        //check session have email or not
//        Object email = session.getAttribute("email");
        Object email = "anhpn@gmail.com";
//        if(email==null){
//            //yes:
//                System.out.println("You need login to shopping");
//                //return: "You need login to shopping"
//        }else{
        //yes
        //get product_id
        int product_id = -1 ;
        try {
            product_id = Integer.parseInt(request.getParameter("id_product"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        if (!checkExistProduct(product_id)) {
            try {
                //check product exist or not
                //no: return : ""Product is not exist";
                response.sendError(400, "Product is not exist");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        //yes:
        //check in session have cartid or not
        Object cartID = session.getAttribute("cart_id");
        if (cartID == null) {
            //getcart by email
            ShoppingCart cart = new ShoppingCartDAO().getCartByEmail(email.toString());
            //check exist or not
            if (cart == null) {
                int userID = new UserDAO().getIdByEmail(email.toString());
                //create new shopping cart
                int a = new ShoppingCartDAO().createShoppingCart(userID);
                if (a == 0) {
                    System.out.println("Can't add shoppingcart");
                } else {
                    cart = new ShoppingCartDAO().getCartByEmail(email.toString());
                    cartID = cart.getID();
                }
            }
            //add session ("cart", cart_id);
            session.setAttribute("cart_id", cart.getID());
        }

        //check in cart_item by cart_id vs product_id
        if (!new Cart_ItemDAO().checkExist_Cart_Item_W_ID_And_PId(cartID.toString(), product_id)) {
            //no
            //add new to cart_item
            Cart_Item cart_item = new Cart_Item(Integer.parseInt(cartID.toString()), product_id, 1);
            int n = new Cart_ItemDAO().addCart_Item(cart_item);
            if (n == 0) {
                System.out.println("Can't add cart item");
                return;
            }
        } 
        else{
            //yes:
            //update amount to cart_item
            int n = new Cart_ItemDAO().increase_1_Amount(Integer.parseInt(cartID.toString()), product_id);
            if (n == 0) {
                System.out.println("Can't increace ");
                return;
            }
        }
        int quantityCart = new Cart_ItemDAO().getQuantityItemOfCartId(Integer.parseInt(cartID.toString()));
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(quantityCart));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        }
    }

    private void updateQuantity(HttpServletRequest request, HttpServletResponse response) {
        //get cart id in session
        HttpSession session = request.getSession();
        Object cartID = session.getAttribute("cart_id");
        int cart_id = 0;
        if (cartID != null) {
            cart_id = Integer.parseInt(cartID.toString());
        }
        //get cart 
        HashMap<String, HashMap<String, String>> listIdProduct
                = new Cart_ItemDAO().getCartItemByCartId(cart_id);

        //get
        String id_product = request.getParameter("id_product");
        String quantity = request.getParameter("quantity");
        
        Product p = new DetailDAO().getByPid(Integer.parseInt(id_product));
        
        
        try {
            //check quantity empty or not
            if(quantity.isEmpty()){
                response.sendError(400,"Quantity can not be empty");
                return;
            }
            
            int quantityInt = 0;
            //check quantity number or not
            try {
                quantityInt = Integer.parseInt(quantity);
            } catch (Exception e) {
                response.sendError(400,"Quantity must be a number type");
                e.printStackTrace();
            }
            //check id product exist or not
            if(p==null){
                response.sendError(400, "Product is not exist");
                return;
            }
            if (quantityInt < 1) {
                response.sendError(400, "Ow quantity cannot be less than 0!!");
                return;
            } 
            if (listIdProduct == null) {
                response.sendError(400, "Cart is empty bru!!");
                return;
            } 
            if (!checkIdInListIdProduct(listIdProduct, id_product)) {
                response.setCharacterEncoding("UTF-8");
                response.sendError(400, "Product is not in Cart bru, Are u s?e !!");
                return;
            }
            if(quantityInt > p.getAmount()){ //quantity update > in DB 
                Cart_Item cItem = new Cart_Item(cart_id, Integer.parseInt(id_product), 1);
                new Cart_ItemDAO().updateAmount(cItem);
                HashMap<String, String> infoProduct = listIdProduct.get(id_product);
                infoProduct.put("quantity", "1");

                //response.getWriter().write(new Gson().toJson(1));
                response.sendError(400, "The number of products in stock is not enough");

                return;
            }

            //update amount in db
            Cart_Item cItem = new Cart_Item(cart_id, Integer.parseInt(id_product), quantityInt);
            int n = new Cart_ItemDAO().updateAmount(cItem);
            if (n == 0) {
                System.out.println("Can't not update amount");
            }
            //update amount in list to display for user
            HashMap<String, String> infoProduct = listIdProduct.get(id_product);
            infoProduct.put("quantity", String.valueOf(quantity));
            HashMap<String, String> order_summary = new ShoppingCartDAO().getIn4Cart(listIdProduct);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            response.getWriter().write(new Gson().toJson(order_summary));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        //get cart id in session
        HttpSession session = request.getSession();
        int cart_id = Integer.parseInt(session.getAttribute("cart_id").toString());
        //get cart 
        HashMap<String, HashMap<String, String>> listIdProduct
                = new Cart_ItemDAO().getCartItemByCartId(cart_id);

        String idDelete = request.getParameter("id_product");
        try {
            if (checkExistProductInList(listIdProduct, idDelete)) {
                //remove product in cart_item
                int n = new Cart_ItemDAO().removeProductById(cart_id, idDelete);

                //remove in list
                listIdProduct.remove(idDelete);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                HashMap<String, String> order_summary = new ShoppingCartDAO().getIn4Cart(listIdProduct);
                response.getWriter().write(new Gson().toJson(order_summary));
            } else {
                response.sendError(400, "Cart does not have this product to delete !!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dispath(HttpServletRequest request, HttpServletResponse response, String page) {
        //select jsp to view
        RequestDispatcher dispath
                = request.getRequestDispatcher(page);
        try {
            //run
            dispath.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean checkIdInListIdProduct(HashMap<String, HashMap<String, String>> listIdProduct, String id) {
        Set<String> keySet = listIdProduct.keySet();
        for (Object key : keySet) {
            if (key.toString().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkExistProductInList(HashMap<String, HashMap<String, String>> listIdProduct, String idDelete) {
        Set<String> keySet = listIdProduct.keySet();
        for (Object key : keySet) {
            if (key.toString().equalsIgnoreCase(idDelete)) {
                return true;
            }
        }
        return false;

    }

    private boolean checkExistProduct(int product_id) {
        DetailDAO dao = new DetailDAO();
        Product p = dao.getByPid(product_id);
        if (p != null) {
            return true;
        }
        return false;
    }

    private void moveToCartView(HttpServletRequest request, HttpServletResponse response, HashMap<String, HashMap<String, String>> listIdPro) {
        HashMap<String, String> order_Summary = new ShoppingCartDAO().getIn4Cart(listIdPro);
        request.setAttribute("order_Summary", order_Summary);
        request.setAttribute("Cart", listIdPro);

        dispath(request, response, "/shoppingcart.jsp");

    }

}
