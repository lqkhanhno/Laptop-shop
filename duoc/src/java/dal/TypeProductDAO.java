/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.Category;

/**
 *
 * @author LAM
 */
public class TypeProductDAO extends DBContext {

    public List<Product> getTopNewest() {
        List<Product> list = new ArrayList<Product>();
        String sql = "select [productID]\n"
                + "      ,[productName]\n"
                + "      ,[decription]\n"
                + "      ,[originalPrice]\n"
                + "      ,[categoryID]\n"
                + "      ,[sellPrice]\n"
                + "      ,[salePercent]\n"
                + "      ,[amount]\n"
                + "      ,[suppliID]\n"
                + "      ,[releaseDate]\n"
                + "      ,[isSell]\n"
                + "      ,[image]\n"
                + "  FROM [LaptopShop].[dbo].[Product]\n"
                + "  order by releaseDate desc";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setDescription(rs.getString("decription"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setCategoryID(rs.getInt("categoryID"));

                p.setImage(rs.getString("image"));
                p.setIsSell(rs.getInt("isSell"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setSalePercent(rs.getInt("salePercent"));
                p.setAmount(rs.getInt("amount"));
                p.setSuppliID(rs.getInt("suppliID"));

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Product> getTopSell() {
        List<Product> list = new ArrayList<Product>();
        String sql = "select [productID]\n"
                + "      ,[productName]\n"
                + "      ,[decription]\n"
                + "      ,[originalPrice]\n"
                + "      ,[categoryID]\n"
                + "      ,[sellPrice]\n"
                + "      ,[salePercent]\n"
                + "      ,[amount]\n"
                + "      ,[suppliID]\n"
                + "      ,[releaseDate]\n"
                + "      ,[isSell]\n"
                + "      ,[image]\n"
                + "  FROM [LaptopShop].[dbo].[Product]\n"
                + "  order by isSell desc";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setDescription(rs.getString("decription"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setCategoryID(rs.getInt("categoryID"));

                p.setImage(rs.getString("image"));
                p.setIsSell(rs.getInt("isSell"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setSalePercent(rs.getInt("salePercent"));
                p.setAmount(rs.getInt("amount"));
                p.setSuppliID(rs.getInt("suppliID"));

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Product> getTopSale() {
        List<Product> list = new ArrayList<Product>();
        String sql = "select [productID]\n"
                + "      ,[productName]\n"
                + "      ,[decription]\n"
                + "      ,[originalPrice]\n"
                + "      ,[categoryID]\n"
                + "      ,[sellPrice]\n"
                + "      ,[salePercent]\n"
                + "      ,[amount]\n"
                + "      ,[suppliID]\n"
                + "      ,[releaseDate]\n"
                + "      ,[isSell]\n"
                + "      ,[image]\n"
                + "  FROM [LaptopShop].[dbo].[Product]\n"
                + "  order by salePercent desc";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setDescription(rs.getString("decription"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setCategoryID(rs.getInt("categoryID"));

                p.setImage(rs.getString("image"));
                p.setIsSell(rs.getInt("isSell"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setSalePercent(rs.getInt("salePercent"));
                p.setAmount(rs.getInt("amount"));
                p.setSuppliID(rs.getInt("suppliID"));

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Product> getDeal(int scid) {
        List<Product> list = new ArrayList<Product>();
        String sql = "select p.productID, p.productName, p.decription,p.originalPrice,p.categoryID,sc.ID,sc.categoryName ,p.sellPrice,p.salePercent, p.amount,p.suppliID, "
                + " p.salePercent,p.isSell,p.releaseDate,p.image \n"
                + "from Product p inner join category sc on p.categoryID = sc.ID"
                + "where p.salePercent > 0 and p.scid = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, scid);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("productName"));
                p.setDescription(rs.getString("decription"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setCategoryID(rs.getInt("ID"));

                Category sc = new Category();
                sc.setID(rs.getInt("ID"));
                sc.setCategoryName(rs.getString("categoryName"));
                p.setImage(rs.getString("image"));
                p.setIsSell(rs.getInt("isSell"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setSalePercent(rs.getInt("salePercent"));
                p.setAmount(rs.getInt("amount"));
                p.setSuppliID(rs.getInt("suppliID"));

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
}
