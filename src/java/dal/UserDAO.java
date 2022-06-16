/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class UserDAO extends DBContext{
    public int getIdByEmail(String email){
        int userid=0;
        String query="select userID from [User] where email='"+email+"'";
        ResultSet rs = getData(query);
        try {
            if(rs.next()){
                userid = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userid;
    }
    
    public User getIn4UserByEmail(String emailParam){
        User u = null;
        String query = "select * from [User] where email = '" + emailParam + "'";
        ResultSet rs = getData(query);
        try {
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
   
