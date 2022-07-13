/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.Order;

/**
 *
 * @author lqka
 */
public class OrderManageDAO extends DBContext {

    public Vector<Order> getOrderbyStatus(String statusParam) {
        Vector<Order> list = new Vector<>();

        String query = "select * from [Order] where status = '"+ statusParam + "'";
        ResultSet rs = getData(query);
        try {
            while (rs.next()) {
                int ID = rs.getInt(1);
                int userID = rs.getInt(2);
                int totalPrice = rs.getInt(3);
                String status = rs.getString(4);
                Date orderDate = rs.getDate(5);
                String note = rs.getString(6);
                Order o = new Order(ID, userID, totalPrice, status, orderDate, note);
                list.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
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

    public int acceptOrder(String order_id) {
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
