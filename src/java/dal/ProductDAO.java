/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.Product;

/**
 *
 * @author LAPTOP VINH HA
 */
public class ProductDAO extends ConnectDB{
    public Vector<Product> ListAll(String sql) {
        Vector<Product> listProduct = new Vector<>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int productID = rs.getInt(1);
                String productName = rs.getString(2);
                String description = rs.getString(3);
                int originalPrice = rs.getInt(4);
                int categoryID = rs.getInt(5);
                int sellPrice = rs.getInt(6);
                int salePercent = rs.getInt(7);
                int amount = rs.getInt(8);
                int suppliID = rs.getInt(9);
                Date releaseDate = rs.getDate(10);
                int isSell = rs.getInt(11);
                String image = rs.getString(12);

                Product product = new Product(productID, productName, 
                        description, originalPrice, categoryID, sellPrice, salePercent, amount, suppliID, releaseDate, isSell, image);
                listProduct.add(product);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listProduct;
    }
    
    public Product GetProductByID(int id){
        Product product = new Product();
        String query= "select * from Product where productID="+id;
        ResultSet rs = getData(query);
        try {
            while (rs.next()) {
                int productID = rs.getInt(1);
                String productName = rs.getString(2);
                String description = rs.getString(3);
                int originalPrice = rs.getInt(4);
                int categoryID = rs.getInt(5);
                int sellPrice = rs.getInt(6);
                int salePercent = rs.getInt(7);
                int amount = rs.getInt(8);
                int suppliID = rs.getInt(9);
                Date releaseDate = rs.getDate(10);
                int isSell = rs.getInt(11);
                String image = rs.getString(12);
                product = new Product(productID, productName, description, 
                        originalPrice, categoryID, sellPrice, salePercent, amount, suppliID, releaseDate, isSell, image);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return product;
    }
    
    
}
