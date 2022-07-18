/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Comment;
import model.User;

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
                            "           ,[comment]\n" +
                            "           ,[date])\n" +    
                            "     VALUES (?\n" +
                            "           ,?\n" +
                            "           ,?\n" +
                            "           ,CURRENT_TIMESTAMP)";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, c.getUser().getUserID());
            st.setInt(2, c.getProdutID());
            st.setString(3, "%"+c.getComment()+"%");
            
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("e");
        }
    }
    
    
    public List<Comment> getAllByID(int ID) {
        List<Comment> list = new ArrayList<Comment>();
        try {
            String sql =    "SELECT c.userID\n" +
                            "       ,c.productID\n" +
                            "       ,c.comment\n" +
                            "       ,c.date\n" +
                            "	   ,u.username\n" +
                            "FROM Comment c inner join [User] u on c.userID=u.userID \n" +
                            "where c.productID=" + ID;
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setUsername(rs.getString("username"));
                
                Comment cmt = new Comment();
                cmt.setUser(u);
                cmt.setProdutID(rs.getInt("productID"));
                cmt.setComment(rs.getString("comment"));
                cmt.setDate(DateFormat.getDateTimeInstance().format(rs.getDate("date"))); 
                
                list.add(cmt);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
}
