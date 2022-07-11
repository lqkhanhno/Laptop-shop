
package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Role;

public class RoleDAO extends DBContext{
    public Vector<Role> listAllRole(){
        String query = "select * from [Role]";
        Vector<Role> listRole = new Vector<>();
        try {
            Statement state = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=state.executeQuery(query);
            while(rs.next()){
                int roleID = rs.getInt(1);
                String roleName = rs.getString(2);
                listRole.add(new Role(roleID, roleName));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRole;
    }
}
