/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.OrderDetail;
import model.Product;

public class Order_DetailDAO extends DBContext{
    public int addOrder_Detail(OrderDetail od){
        int n=0;
        String query = "INSERT INTO [Order_detail] ([orderID],[productID],[productName]" 
                +",[productPrice],[quantity]) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(query);
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

    public int deleteOrderDetail(String order_id) {
        String query = "delete from [Order_detail] where orderID = "+order_id;
        int n=0;
        try {
            Statement st = connection.createStatement();
            n = st.executeUpdate(query);
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

   public Map<String, Map<String, Map<String, String>>> getOrderDetailForListOrder(Vector<Order> listOrder) {
        /*
        order detail
        map<order_id, map<product_id,map<String,String>>>
        {
            1:{
                    #11 :{
                            "image": 
                            "productName":
                            "productPrice".
                            "quantity"
                    }
                    }
                    -1 :{
                            "total"
                    }
            }
        }
        */
        Map<String, Map<String, Map<String, String>>> listO = new HashMap<>();
        for(Order o : listOrder){
            String query = "  select * from Order_detail where orderID = " + o.getID();
            ResultSet rs = getData(query);
            Map<String, Map<String,String>> listProductOrderDetail = new HashMap<>();
            try {
                
                while(rs.next()){
                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    String price = rs.getString("productPrice");
                    String quantity = rs.getString("quantity");
                    
                    Product p = new ProductDAO().getProductByID(productID);
                    String image = p.getImage();
                    
                    Map<String,String> listAttributeOfProductOrder = new HashMap<>();
                    listAttributeOfProductOrder.put("image", image);
                    listAttributeOfProductOrder.put("productName", productName);
                    listAttributeOfProductOrder.put("productPrice", price);
                    listAttributeOfProductOrder.put("quantity", quantity);
                    
                    listProductOrderDetail.put(""+productID, listAttributeOfProductOrder);
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            listO.put(""+o.getID(), listProductOrderDetail);
        }
        return listO;
        
    }
    
    
}
