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
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart_Item;
import model.Product;

public class Cart_ItemDAO extends DBContext{

    public boolean checkExist_Cart_Item_W_ID_And_PId(String cart_id, int product_id) {
        String query="select * from Cart_Item where cart_ID="+cart_id+" and product_ID="+product_id;
        ResultSet rs = getData(query);
        try {
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public int addCart_Item(Cart_Item cart_item){
        int n=0;
        String query="INSERT INTO [Cart_Item] ([cart_ID],[product_ID],[amount]) VALUES (?,?,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(1, cart_item.getCart_ID());
            pre.setInt(2, cart_item.getProduct_ID());
            pre.setInt(3, cart_item.getAmount());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int increase_1_Amount(int cart_Id, int product_Id) {
        int n=0;
        String query = "update Cart_Item set amount=amount+1 where cart_ID="+cart_Id+" and product_ID="+product_Id;
        try {
            Statement state=connection.createStatement();
            n=state.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    
    public HashMap<String, HashMap<String, String>> getCartItemByCartId(int id) {
        HashMap<String, HashMap<String,String>>listIdPro
                = new HashMap<>();
        ProductDAO dao= new ProductDAO();
        DetailDAO detail = new DetailDAO();
        String query ="select *from Cart_Item where cart_ID="+id;
        ResultSet rs = getData(query);
        try {
            while (rs.next()) {
                int cart_ID = rs.getInt(1);
                int product_ID = rs.getInt(2);
                int amount = rs.getInt(3);
                
                Product product = detail.getByPid(product_ID);
                Cart_Item c = new Cart_Item(cart_ID, product_ID, amount);
                
                HashMap<String, String> infoProduct = new HashMap<>();
                infoProduct.put("id", String.valueOf(product.getProductID()));
                infoProduct.put("image", product.getImage());
                infoProduct.put("name", product.getProductName());
                infoProduct.put("price", String.valueOf(product.getSellPrice()));
                infoProduct.put("sale_percent", String.valueOf(product.getSalePercent()));
                infoProduct.put("quantity", String.valueOf(c.getAmount()));

                //put infoProduct hashmap to listIDProduct with key (id_product)
                listIdPro.put(String.valueOf(product_ID), infoProduct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return listIdPro;
    }
  

    public int updateAmount(Cart_Item cItem) {
        int n=0;
        String query = "update Cart_Item set amount="+cItem.getAmount()+" where cart_ID = "+cItem.getCart_ID()+" and product_ID="+cItem.getProduct_ID();
        Statement state;
        try {
            state = connection.createStatement();
            n=state.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int removeProductById(int cart_id, String idDelete) {
        int n=0;
        String query = "delete from Cart_Item where cart_ID = "+cart_id+" and product_ID="+idDelete;
        try {
            Statement state = connection.createStatement();
            n=state.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public static void main(String[] args) {
        new Cart_ItemDAO().increase_1_Amount(1, 1);
    }

    public int removeListCartItemByCartId(HashMap<String, HashMap<String, String>> listIdPro, int cart_id) {
        int m=0;
        int n=0;
        Set<String> keySet = listIdPro.keySet();
        for(Object idProduct : keySet){
            n = removeProductById(cart_id, idProduct.toString());
            if(n==0){
                System.out.println("Can't not delete product:"+idProduct +"cart_id: "+cart_id);
                m=1;
                break;
            }
        }
        return m;
    }

        public int getQuantityItemOfCartId(int id) {
        String query = "select count(*) from Cart_Item where  cart_ID=" + id;
        ResultSet rs = getData(query);
        int result=0;
        try {
            if(rs.next()){
                result=rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    
}
