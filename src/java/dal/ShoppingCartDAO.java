/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ShoppingCart;

public class ShoppingCartDAO extends ConnectDB {
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
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, userID);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
}
