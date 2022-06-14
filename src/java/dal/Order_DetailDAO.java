/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.OrderDetail;

public class Order_DetailDAO extends ConnectDB{
    public int addOrder_Detail(OrderDetail od){
        int n=0;
        String query = "INSERT INTO [Order_detail] ([orderID],[productID],[productName]" 
                +",[productPrice],[quantity]) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, od.getOrderID());
            pre.setInt(2, od.getProductID());
            pre.setString(3, od.getProductName());
            pre.setInt(4, od.getProductPrice());
            pre.setInt(5, od.getQuantity());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return n;
    }

    public int addListCart2OrderDetail(HashMap<String, HashMap<String, String>> listIdPro, int orderId) {
        Set<String> keySet = listIdPro.keySet();
        int m=0;
        int n=0;
        for(Object key: keySet){
            HashMap<String, String> infoProduct = listIdPro.get(key);
            int productID = Integer.parseInt(infoProduct.get("id"));
            String productName = infoProduct.get("name");
            int productPrice = Integer.parseInt(infoProduct.get("price"));
            int quantity = Integer.parseInt(infoProduct.get("quantity"));
            OrderDetail od = new OrderDetail(orderId, productID, productName, productPrice, quantity);
            n = addOrder_Detail(od);
            if(n==0){
                System.out.println("can't add order detail product :"+productID);
                m=1;
                break;
                
            }
            n=0;
        }
        return m;
    }
    
    
}
