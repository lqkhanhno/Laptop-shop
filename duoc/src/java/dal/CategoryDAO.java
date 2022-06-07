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
import model.Category;

/**
 *
 * @author LAM
 */
public class CategoryDAO extends DBContext{
    public List<Category> getAll() {
        List<Category> list = new ArrayList<Category>();
        try {
            String sql = "select * from Category";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Category sc = new Category();
                
                sc.setID(rs.getInt(1));
                sc.setCategoryName(rs.getString(2));
                
                
                list.add(sc);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public Category getByID(int ID) {
        try {
            String sql = "select * from Category\n"
                            + "where ID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, ID);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Category sc = new Category();
                
                sc.setID(rs.getInt(1));
                sc.setCategoryName(rs.getString(2));
               
                
                return sc;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public Category getByName(String name) {
        try {
            String sql = "select * from Category\n"
                            + "where categoryName = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Category sc = new Category();
                
                sc.setID(rs.getInt(1));
                sc.setCategoryName(rs.getString(2));
                
                
                return sc;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }
}
