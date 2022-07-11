/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserDAO extends DBContext {

    public void insert(User user) {
        String query = "INSERT INTO [dbo].[User]\n"
                + " ([fullname], [username],[password] ,[email] ,[roleID] ,[userAddress] ,[phonenumber])\n"
                + "VALUES(?, ? ,? ,3 ,? ,?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, user.getFullname());
            pre.setString(2, user.getUsername());
            pre.setString(3, user.getPassword());
            pre.setString(4, user.getEmail());
            pre.setString(5, user.getUserAddress());
            pre.setString(6, user.getPhoneNumber());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertUserInManage(User user) {
        String query = "INSERT INTO [dbo].[User]\n"
                + " ([fullname], [username],[password] ,[email] ,[roleID] ,[userAddress] ,[phonenumber])\n"
                + "VALUES(?, ? ,? ,? ,? ,?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, user.getFullname());
            pre.setString(2, user.getUsername());
            pre.setString(3, user.getPassword());
            pre.setString(4, user.getEmail());
            pre.setString(5, String.valueOf(user.getRoleID()));
            pre.setString(6, user.getUserAddress());
            pre.setString(7, user.getPhoneNumber());
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
    
    public void updateUserInManage(User user) {
        String query = "UPDATE [dbo].[User]\n"
                + "   SET "
                + "[fullname] = ?, "
                + "[username] = ?, "
                + "[password] = ?, "
                + "[email] = ?, "
                + "[roleID] = ?, "
                + "[userAddress] = ?, "
                + "[phonenumber] = ? "
                + " WHERE userID = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, user.getFullname());
            pre.setString(2, user.getUsername());
            pre.setString(3, user.getPassword());
            pre.setString(4, user.getEmail());
            pre.setString(5, String.valueOf(user.getRoleID()));
            pre.setString(6, user.getUserAddress());
            pre.setString(7, user.getPhoneNumber());
            pre.setString(8, String.valueOf(user.getUserID()));
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
    
    public Vector<User> listAllUser(int numberEachPage, int numberOffset){
        Vector<User> listUser = new Vector<>();
        String query = "  SELECT * FROM  [User] ORDER BY [userID] OFFSET "+
                numberOffset+" ROWS FETCH NEXT "+numberEachPage+" ROWS ONLY";
        Statement state;
        try {
            state = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=state.executeQuery(query);
            while(rs.next()){
                int userID = rs.getInt(1);
                String fullname = rs.getString(2);
                String username = rs.getString(3);
                String password = rs.getString(4);
                String email = rs.getString(5);
                int roleID = rs.getInt(6);
                String userAddress = rs.getString(7);
                String phoneNumber = rs.getString(8);
                listUser.add(new User(userID, fullname, username, password, email, roleID, userAddress, phoneNumber));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listUser;
    }
    
    public int getNumberUser(){
        int numUser = -1;
        String query = "select count(*) from [User]";
        
        try {
            Statement state = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=state.executeQuery(query);
            if(rs.next()){
                numUser = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numUser;  
    }
    
    public User getUserByID(String userId){
        User u = new User();
        String query = "select * from [User] where userID = "+userId;
        
        try {
            Statement state = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=state.executeQuery(query);
            if(rs.next()){
                int userID = rs.getInt(1);
                String fullname = rs.getString(2);
                String username = rs.getString(3);
                String password = rs.getString(4);
                String email = rs.getString(5);
                int roleID = rs.getInt(6);
                String userAddress = rs.getString(7);
                String phoneNumber = rs.getString(8);
                u = new User(userID, fullname, username, password, email, roleID, userAddress, phoneNumber);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    public void deleteUser(String id) {
        String query = "delete from [User] where userID = " + id;
        try {
            Statement state = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=state.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
//        int id = new UserDAO().getIdByEmail("anhpn@gmail.com");
        User u = new UserDAO().getIn4UserByEmail("anhpn@gmail.com");
        System.out.println(u);
    }

    
}
