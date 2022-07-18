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
import java.sql.Timestamp;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;

/**
 *
 * @author lqka
 */
public class OrderManageDAO extends DBContext {

    public Vector<Order> getListOrderByStatus(String statusParam) {
        Vector<Order> listOrder = new Vector<>();
        String query = "select * from [Order] where and status = '"+statusParam+"'";
        ResultSet rs = getData(query);
        try {
            while(rs.next()){
                int ID = rs.getInt(1);
                int userID = rs.getInt(2);
                int totalPrice = rs.getInt(3);
                String status = rs.getString(4);
                Date orderDate = rs.getDate(5);
                String note = rs.getString(6);
                Timestamp updated_At = rs.getTimestamp(7);
                Order o = new Order(ID, userID, totalPrice, status, orderDate, note, updated_At);
                listOrder.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listOrder;
    }
    public Vector<Order> getListOrder() {
        Vector<Order> listOrder = new Vector<>();
        String query = "select * from [Order]";
        ResultSet rs = getData(query);
        try {
            while(rs.next()){
                int ID = rs.getInt(1);
                int userID = rs.getInt(2);
                int totalPrice = rs.getInt(3);
                String status = rs.getString(4);
                Date orderDate = rs.getDate(5);
                String note = rs.getString(6);
                Timestamp updated_At = rs.getTimestamp(7);
                Order o = new Order(ID, userID, totalPrice, status, orderDate, note, updated_At);
                listOrder.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return listOrder;
    }
    public Order getOrderByOrderId (int orderId){
        Order o = null;
//        String query = "select id from [Order] where userID = "+userId+" and"
//                + " id = (select MAX(id) from [Order] where userID="+userId+")";
        String query = "select * from [Order] where ID="+orderId;
        ResultSet rs = getData(query);
        try {
            if(rs.next()){
                int ID = rs.getInt(1);
                int userID = rs.getInt(2);
                int totalPrice = rs.getInt(3);
                String status = rs.getString(4);
                Date orderDate = rs.getDate(5);
                String note = rs.getString(6);
                Timestamp updated_At = rs.getTimestamp(7);
                o = new Order(ID, userID, totalPrice, status, orderDate, note, updated_At);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return o;
    }

//    public List<Order> OrderCf() {
//        List<Order> listcfing = new ArrayList<>();
//        try {
//            String sql = "select * from [Order] where status = 'Shipping'";
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//                Order sc = new Order();
//
//                sc.setID(rs.getInt("ID"));
//                sc.setUserID(rs.getInt("userID"));
//                sc.setTotalPrice(rs.getInt("totalprice"));
//                sc.setStatus(rs.getString("status"));
//                sc.setOrderDate(rs.getDate("date"));
//                sc.setNote(rs.getString("note"));
//                listcfing.add(sc);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return listcfing;
//    }
//
//    public List<Order> Ordercfed() {
//        List<Order> listcfed = new ArrayList<>();
//        try {
//            String sql = "select * from [Order] where status = 'Shipped'";
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//                Order sc = new Order();
//
//                sc.setID(rs.getInt("ID"));
//                sc.setUserID(rs.getInt("userID"));
//                sc.setTotalPrice(rs.getInt("totalprice"));
//                sc.setStatus(rs.getString("status"));
//                sc.setOrderDate(rs.getDate("date"));
//                sc.setNote(rs.getString("note"));
//                listcfed.add(sc);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return listcfed;
//    }
//
//    public List<Order> Ordercanceled() {
//        List<Order> listcanceled = new ArrayList<>();
//        try {
//            String sql = "select * from [Order] where status = 'Canceled'";
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//                Order sc = new Order();
//
//                sc.setID(rs.getInt("ID"));
//                sc.setUserID(rs.getInt("userID"));
//                sc.setTotalPrice(rs.getInt("totalprice"));
//                sc.setStatus(rs.getString("status"));
//                sc.setOrderDate(rs.getDate("date"));
//                sc.setNote(rs.getString("note"));
//                listcanceled.add(sc);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return listcanceled;
//    }

    public int cancelOrder(String order_id) {
        //delete in order detail
        //int n = new Order_DetailDAO().deleteOrderDetail(order_id);
        //if(n!=0){
        //delete order
        //n = 0; //reset result
        int n = 0;
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
    public int AcceptOrder(String order_id) {
        //delete in order detail
        //int n = new Order_DetailDAO().deleteOrderDetail(order_id);
        //if(n!=0){
        //delete order
        //n = 0; //reset result
        int n = 0;
        String query = "update [Order] set status = 'Shipping' where ID = " + order_id;
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

    public int shippedOrder(String order_id) {
        //delete in order detail
        //int n = new Order_DetailDAO().deleteOrderDetail(order_id);
        //if(n!=0){
        //delete order
        //n = 0; //reset result
        int n = 0;
        String query = "update [Order] set status = 'Shipped' where ID = " + order_id;
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

    public String getStatus(String order_id) {
        String query = "  select status from [Order] where ID= " + order_id;
        ResultSet rs = getData(query);
        String status = "";
        try {
            if (rs.next()) {
                status = rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }
}
