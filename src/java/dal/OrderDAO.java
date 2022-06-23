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
import model.Order;

public class OrderDAO extends DBContext{
    public int addOrder(Order o){
        int n=0;
        String query = "INSERT INTO [Order] ([userID],[totalprice], [status], [date], [note])" +
            " VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(1, o.getUserID());
            pre.setInt(2, o.getTotalPrice());
            pre.setString(3, o.getStatus());
            pre.setDate(4, o.getOrderDate());
            pre.setString(5, o.getNote());
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public int getOrderIdLates (int userId){
        int id = 0;
        String query = "select id from [Order] where userID = "+userId+" and"
                + " id = (select MAX(id) from [Order] where userID="+userId+")";
        ResultSet rs = getData(query);
        try {
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return id;
    }
    
    
}
