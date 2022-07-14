/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Comment;

/**
 *
 * @author Admin
 */
public class CommentDAO extends DBContext {
    
    public void addComment(Comment c) {
        try {
            String sql =    "INSERT INTO [dbo].[Comment]\n" +
                            "           ([userID]\n" +
                            "           ,[productID]\n" +
                            "           ,[comment])\n" +
                            "     VALUES\n" +
                            "           (?\n" +
                            "           ,?\n" +
                            "           ,?)";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, c.getUserID());
            st.setInt(2, c.getProdutID());
            st.setString(3, c.getComment());
                   
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("e");
        }
    }
}
