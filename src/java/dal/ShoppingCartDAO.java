/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ShoppingCart;

public class ShoppingCartDAO extends DBContext {
    public ShoppingCart getCartByEmail (String email){
        String query = "select s.* from ShoppingCart s join [user] u on u.userID=s.userID where u.email= '"+email+"'";
        ResultSet rs = getData(query);
        try {
            if (rs.next()) {
                int ID = rs.getInt(1);
                int userID = rs.getInt(2);
                ShoppingCart s = new ShoppingCart(ID, userID);
                return s;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public int createShoppingCart(int userID){
        int n=0;
        String query="INSERT INTO [ShoppingCart] " +
                    "([userID]) " +
                    "VALUES (?)";
        try {
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(1, userID);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public HashMap<String, String> getIn4Cart(HashMap<String, HashMap<String, String>> listIdProduct) {
        HashMap<String, String> listIdPro = new HashMap<>();
        Set<String> keySet = listIdProduct.keySet();
        int totalCart=0;
        int totalGrand=0;
        int discount=0;
        for(Object key: keySet){
            Map<String, String> infoProduct = listIdProduct.get(key);
            int quantity =Integer.parseInt(infoProduct.get("quantity"));
            int sale_percent =Integer.parseInt(infoProduct.get("sale_percent"));
            int price =Integer.parseInt(infoProduct.get("price"));
            int total = price * quantity;
            totalGrand+=total;
            discount+=(total*sale_percent/100);
            listIdPro.put(infoProduct.get("id"), String.valueOf(total));
        }
        totalCart= totalGrand - discount;
        listIdPro.put("totalGrand",String.valueOf(totalGrand));
        listIdPro.put("totalCart",String.valueOf(totalCart));
        listIdPro.put("discount",String.valueOf(discount));
        
        return listIdPro;
    }
}
