/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import model.Category;

/**
 *
 * @author LAM
 */
public class ManageDAO extends DBContext {

    public void addProduct(Product p) {
        try {
            String sql = "INSERT INTO [Product]\n"
                   
                    + "           ([productName]\n"
                    + "           ,[decription]\n"
                    + "           ,[originalPrice]\n"
                    + "           ,[categoryID]\n"
                    + "           ,[sellPrice]\n"
                    + "           ,[salePercent]\n"
                    + "           ,[amount]\n"
                    + "           ,[suppliID]\n"
                    + "           ,[releaseDate]\n"
                    + "           ,[isSell]\n"
                    + "           ,[image])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,0\n"
                    + "           ,?)";
            PreparedStatement st = connection.prepareStatement(sql);


            st.setString(1, p.getProductName());
            st.setString(2, p.getDescription());
            st.setInt(3, p.getOriginalPrice());
            st.setInt(4, p.getCategoryID());
            st.setInt(5, p.getSellPrice());
            st.setInt(6, p.getSalePercent());
            st.setInt(7, p.getAmount());
            st.setInt(8, p.getSuppliID());
            st.setDate(9, p.getReleaseDate());

            st.setString(10, p.getImage());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("e");
        }
    }

    public void addSubCategories(String name) {
        String sql = "insert into SubCategories\n"
                + "values ('?', 1)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("e");
        }
    }

    public void editProduct(Product p) {
        String sql = "update Product\n"
                + "   SET \n"
                + "      [productName] = ?\n"
                + "      ,[decription] = ?\n"
                + "      ,[originalPrice] = ?\n"
                + "      ,[categoryID] = ?\n"
                + "      ,[sellPrice] = ?\n"
                + "      ,[salePercent] = ?\n"
                + "      ,[amount] = ?\n"
                + "      ,[suppliID] = ?\n"
                + "      ,[releaseDate] = ?\n"
                + "      ,[isSell] = ?\n"
                + "      ,[image] = ?\n"
                + " where productID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, p.getProductName());
            st.setString(2, p.getDescription());
            st.setInt(3, p.getOriginalPrice());
            st.setInt(4, p.getCategoryID());
            st.setInt(5, p.getSellPrice());
            st.setInt(6, p.getSalePercent());
            st.setInt(7, p.getAmount());
            st.setInt(8, p.getSuppliID());
            st.setDate(9, p.getReleaseDate());
            st.setInt(10, p.getIsSell());
            st.setString(11, p.getImage());
            st.setInt(12, p.getProductID());
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("abcxya");
        }

    }

    public void deleteProduct(String pid) {
        String sql = "delete from Product\n"
                + "where productID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, pid);

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("e");
        }
    }

}
