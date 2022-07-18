/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.FAQs;

/**
 *
 * @author Admin
 */
public class FaqDAO extends DBContext {
    public void AddFaq(FAQs f) {   
        try {
            String sql =    "INSERT INTO [dbo].[FAQs]\n" +
                            "           ([authorID]\n" +
                            "           ,[title]\n" +
                            "           ,[content])\n" +
                            "     VALUES\n" +
                            "           (?\n" +
                            "           ,?\n" +
                            "           ,?)";
            PreparedStatement st = connection.prepareStatement(sql);
           
            int uid = f.getAuthorID().getUserID();
            st.setInt(1, uid);
            st.setString(2, f.getTitle());
            st.setString(3, f.getContent());
           

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("e");
        }
    }
    
    public boolean checkExist(String x, String y) {
        List<FAQs> list = getAll();
        
        for ( FAQs l : list){
            if(l.getTitle().equals(x) || l.getContent().equals(y)) {
                return false;
            }
        }
        return true;
    }
    
    public void UpdateFaq(FAQs f) {         
        try {
            String sql =    "UPDATE [dbo].[FAQs]\n" +
                        "   SET \n" +
                        "      [title] = ?\n" +
                        "      ,[content] = ?\n" +
                        " WHERE ID = ?"; 
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, f.getTitle());
            st.setString(2, f.getContent());
            st.setInt(3, f.getID());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    
    public List<FAQs> getAll() {
        List<FAQs> list = new ArrayList<FAQs>();
        String sql =    "SELECT ID " +
                        "      ,title\n" +
                        "      ,content\n" +
                        "  FROM FAQs";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                FAQs f = new FAQs();
                f.setID(rs.getInt("ID"));
                f.setTitle(rs.getString("title"));
                f.setContent(rs.getString("content"));                                
                list.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public FAQs getByID(int ID) {
        FAQs f = new FAQs();
        String sql =    "SELECT [ID]\n" +
                        "      ,[title]\n" +
                        "      ,[content]\n" +
                        "  FROM [dbo].[FAQs]" +
                        "WHERE ID=?";    
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            st.setInt(1, ID);
            while (rs.next()) {
                f.setTitle(rs.getString("title"));
                f.setContent(rs.getString("content"));                                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return f;
    }
}
