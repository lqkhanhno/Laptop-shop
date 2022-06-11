/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends ConnectDB{
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
    
    public static void main(String[] args) {
        int id = new UserDAO().getIdByEmail("anhpn@gmail.com");
        System.out.println(id);
    }
}
   
