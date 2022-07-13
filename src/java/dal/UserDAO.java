/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserDAO extends DBContext {

    public void insert(User user) {
        String query = "INSERT INTO [dbo].[User]\n"
                + " ([username],[password] ,[email] ,[roleID] ,[userAddress] ,[phonenumber])\n"
                + "VALUES(?,? ,? ,3 ,? ,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, user.getUsername());
            pre.setString(2, user.getPassword());
            pre.setString(3, user.getEmail());
            pre.setString(4, user.getUserAddress());
            pre.setString(5, user.getPhoneNumber());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(User user) {
        String query = "UPDATE [dbo].[User]\n"
                + "   SET  [password] =?\n"
                + " WHERE userID = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, user.getPassword());
            pre.setInt(2, user.getUserID());
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getIdByEmail(String email) {
        int userid = 0;
        String query = "select userID from [User] where email='" + email + "'";
        ResultSet rs = getData(query);
        try {
            if (rs.next()) {
                userid = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userid;
    }

    public User getIn4UserByEmail(String emailParam) {
        User u = null;
        String query = "select * from [User] where email = '" + emailParam + "'";
        ResultSet rs = getData(query);
        try {
            if (rs.next()) {
                int userID = rs.getInt("userID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int roleID = rs.getInt("roleID");
                String userAddress = rs.getString("userAddress");
                String phoneNumber = rs.getString("phonenumber");
                u = new User(userID, "", username, password, email, roleID, userAddress, phoneNumber);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }

    public static void main(String[] args) {
//        int id = new UserDAO().getIdByEmail("anhpn@gmail.com");
        User u = new UserDAO().getIn4UserByEmail("anhpn@gmail.com");
        System.out.println(u);
    }
}
