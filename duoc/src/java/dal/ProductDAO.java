/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.Category;

/**
 *
 * @author LAM
 */
public class ProductDAO extends DBContext{
    
    public List<Product> getAll() {
        List<Product> list = new ArrayList<Product>();
        String sql = "select p.productID, p.productName, p.decription,p.originalPrice,p.categoryID, p.sellPrice,p.salePercent, p.amount,p.suppliID, "
                        + " p.salePercent, \n" 
                        + "from products p";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Product p = new Product();
                
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setDescription(rs.getString("description"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setCategoryID(rs.getInt("categoryID"));
               
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setSalePercent(rs.getInt("salePercent"));
                p.setAmount(rs.getInt("amount"));
                p.setSuppliID(rs.getInt("suppliID"));
                
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public List<Product> checkLaptops(int[] id, String sortby){
        List<Product> list = new ArrayList<>();
        String sql ="select p.productID, p.productName, p.decription,p.originalPrice,p.categoryID, p.sellPrice,p.salePercent, p.amount,p.suppliID, "
                        + " p.salePercent, \n" 
                        + "from products p";
//        if(id != null){
//            sql += " and p.scid in(";
//            for (int i = 0; i < id.length; i++) {
//                sql += id[i] + ",";
//            }
//            if (sql.endsWith(","))
//                sql = sql.substring(0, sql.length()-1);
//            sql += ")";
//        }
        if (sortby != null && !sortby.equals("")) {
            int so;
            try {
                so = Integer.parseInt(sortby);
            } catch (NumberFormatException e) {
                so = 0;
            }
            switch (so) {
                case 0:
                    sql += "\n order by p.pid asc";
                    break;
                case 1:
                    sql += "\n order by p.Release_date desc";
                    break;
                case 2:
                    sql += "\n order by (p.price * (100 - p.sale_off) / 100)  desc";
                    break;
                case 3:
                    sql += "\n order by (p.price * (100 - p.sale_off) / 100)  asc";
                    break;
            }
        }
      
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Product p = new Product();
                
               p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setDescription(rs.getString("description"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setCategoryID(rs.getInt("categoryID"));
               
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setSalePercent(rs.getInt("salePercent"));
                p.setAmount(rs.getInt("amount"));
                p.setSuppliID(rs.getInt("suppliID"));
                
                list.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product> getByName(String name) {
        List<Product> list = new ArrayList<Product>();
        String sql = "select p.productID, p.productName, p.decription,p.originalPrice,p.categoryID, p.sellPrice,p.salePercent, p.amount,p.suppliID, "
                        + " p.salePercent, \n" 
                        + "from products p"
                        + "where name like '%" + name + "%'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Product p = new Product();
                
               p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setDescription(rs.getString("description"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setCategoryID(rs.getInt("categoryID"));
               
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setSalePercent(rs.getInt("salePercent"));
                p.setAmount(rs.getInt("amount"));
                p.setSuppliID(rs.getInt("suppliID"));
                
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
   
    public List<Product> getListByPage(List<Product> list,
            int start,int end){
        ArrayList<Product> arr = new ArrayList<>();
        for(int i = start; i < end; i++){
            arr.add(list.get(i));
        }
        return arr;
    }

}
