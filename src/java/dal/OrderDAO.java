/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
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
//        String query = "select id from [Order] where userID = "+userId+" and"
//                + " id = (select MAX(id) from [Order] where userID="+userId+")";
        String query = "select MAX(id) from [Order] where userID="+userId;
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

    public Vector<Order> getListOrderByUserID(int userid, String statusParam) {
        Vector<Order> listOrder = new Vector<>();
        String query = "select * from [Order] where userID = "+userid
                +" and status = '"+statusParam+"'";
        ResultSet rs = getData(query);
        try {
            while(rs.next()){
                int ID = rs.getInt(1);
                int userID = rs.getInt(2);
                int totalPrice = rs.getInt(3);
                String status = rs.getString(4);
                Date orderDate = rs.getDate(5);
                String note = rs.getString(6);
                Order o = new Order(ID, userID, totalPrice, status, orderDate, note);
                listOrder.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return listOrder;
    }

    public Vector<Order> getListOrderByUserID(int userid) {
        Vector<Order> listOrder = new Vector<>();
        String query = "select * from [Order] where userID = "+userid + " and status = 'Shipped' or status = 'Canceled'";
        ResultSet rs = getData(query);
        try {
            while(rs.next()){
                int ID = rs.getInt(1);
                int userID = rs.getInt(2);
                int totalPrice = rs.getInt(3);
                String status = rs.getString(4);
                Date orderDate = rs.getDate(5);
                String note = rs.getString(6);
                Order o = new Order(ID, userID, totalPrice, status, orderDate, note);
                listOrder.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return listOrder;
    }

    public String getStatus(String order_id) {
        String query = "  select status from [Order] where ID= "+order_id;
        ResultSet rs = getData(query);
        String status="";
        try {
            if(rs.next()){
                status = rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public int cancelOrder(String order_id) {
        //delete in order detail
        //int n = new Order_DetailDAO().deleteOrderDetail(order_id);
        //if(n!=0){
            //delete order
            //n = 0; //reset result
        int n=0;
        String query = "update [Order] set status = 'Canceled' where ID = " + order_id;
        Statement st;
        try {
            st = connection.createStatement();
            n = st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //}
        return n;
    }
    
    
}
