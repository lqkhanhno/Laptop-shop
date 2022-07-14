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
    
    public List<FAQs> getAll() {
        List<FAQs> list = new ArrayList<FAQs>();
        String sql =    "SELECT " +
                        "      title\n" +
                        "      ,content\n" +
                        "  FROM FAQs";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                FAQs f = new FAQs();
                f.setTitle(rs.getString("title"));
                f.setContent(rs.getString("content"));                                
                list.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
}
