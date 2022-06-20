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
import model.Supplier;

/**
 *
 * @author LAM
 */
public class TypeProductDAO extends DBContext {

    public List<Product> getTopNewest() {
        List<Product> list = new ArrayList<Product>();
        String sql = "SELECT p.[productID]\n"
                + "      ,p.[productName]\n"
                + "      ,p.[decription]\n"
                + "      ,p.[originalPrice]\n"
                + "       ,c.[ID]\n"
                + "      ,c.[categoryName]\n"
                + "      ,p.[sellPrice]\n"
                + "      ,p.[salePercent]\n"
                + "      ,p.[amount]\n"
                + "      ,s.pID\n"
                + "      ,s.name\n"
                + "      ,s.address\n"
                + "      ,s.phone\n"
                + "      ,p.[releaseDate]\n"
                + "      ,p.[isSell]\n"
                + "      ,p.[image]\n"
                + "  FROM [Product] p inner join Category c on p.categoryID = c.ID inner join Supplier s on p.suppliID = s.pID"
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
                Category c = new Category();
                c.setID(rs.getInt("ID"));
                c.setCategoryName(rs.getString("categoryName"));
                p.setCategory(c);

                p.setImage(rs.getString("image"));
                p.setIsSell(rs.getInt("isSell"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setSalePercent(rs.getInt("salePercent"));
                p.setAmount(rs.getInt("amount"));
                Supplier s = new Supplier();
                s.setID(rs.getInt("pID"));
                s.setAddress(rs.getString("address"));
                s.setName(rs.getString("name"));
                s.setPhone(rs.getString("phone"));
                p.setSupplier(s);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Product> getTopSell() {
        List<Product> list = new ArrayList<Product>();
        String sql = "SELECT p.[productID]\n"
                + "      ,p.[productName]\n"
                + "      ,p.[decription]\n"
                + "      ,p.[originalPrice]\n"
                + "       ,c.[ID]\n"
                + "      ,c.[categoryName]\n"
                + "      ,p.[sellPrice]\n"
                + "      ,p.[salePercent]\n"
                + "      ,p.[amount]\n"
                + "      ,s.pID\n"
                + "      ,s.name\n"
                + "      ,s.address\n"
                + "      ,s.phone\n"
                + "      ,p.[releaseDate]\n"
                + "      ,p.[isSell]\n"
                + "      ,p.[image]\n"
                + "  FROM [Product] p inner join Category c on p.categoryID = c.ID inner join Supplier s on p.suppliID = s.pID"
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
                Category c = new Category();
                c.setID(rs.getInt("ID"));
                c.setCategoryName(rs.getString("categoryName"));
                p.setCategory(c);

                p.setImage(rs.getString("image"));
                p.setIsSell(rs.getInt("isSell"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setSalePercent(rs.getInt("salePercent"));
                p.setAmount(rs.getInt("amount"));
                Supplier s = new Supplier();
                s.setID(rs.getInt("pID"));
                s.setAddress(rs.getString("address"));
                s.setName(rs.getString("name"));
                s.setPhone(rs.getString("phone"));
                p.setSupplier(s);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Product> getTopSale() {
        List<Product> list = new ArrayList<Product>();
        String sql = "SELECT p.[productID]\n"
                + "      ,p.[productName]\n"
                + "      ,p.[decription]\n"
                + "      ,p.[originalPrice]\n"
                + "       ,c.[ID]\n"
                + "      ,c.[categoryName]\n"
                + "      ,p.[sellPrice]\n"
                + "      ,p.[salePercent]\n"
                + "      ,p.[amount]\n"
                + "      ,s.pID\n"
                + "      ,s.name\n"
                + "      ,s.address\n"
                + "      ,s.phone\n"
                + "      ,p.[releaseDate]\n"
                + "      ,p.[isSell]\n"
                + "      ,p.[image]\n"
                + "  FROM [Product] p inner join Category c on p.categoryID = c.ID inner join Supplier s on p.suppliID = s.pID"
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
                Category c = new Category();
                c.setID(rs.getInt("ID"));
                c.setCategoryName(rs.getString("categoryName"));
                p.setCategory(c);

                p.setImage(rs.getString("image"));
                p.setIsSell(rs.getInt("isSell"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setSalePercent(rs.getInt("salePercent"));
                p.setAmount(rs.getInt("amount"));
                Supplier s = new Supplier();
                s.setID(rs.getInt("pID"));
                s.setAddress(rs.getString("address"));
                s.setName(rs.getString("name"));
                s.setPhone(rs.getString("phone"));
                p.setSupplier(s);

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
                Category c = new Category();
                c.setID(rs.getInt("ID"));
                c.setCategoryName(rs.getString("categoryName"));
                p.setCategory(c);

                p.setImage(rs.getString("image"));
                p.setIsSell(rs.getInt("isSell"));
                p.setReleaseDate(rs.getDate("releaseDate"));
                p.setSellPrice(rs.getInt("sellPrice"));
                p.setSalePercent(rs.getInt("salePercent"));
                p.setAmount(rs.getInt("amount"));
                Supplier s = new Supplier();
                s.setID(rs.getInt("pID"));
                s.setAddress(rs.getString("address"));
                s.setName(rs.getString("name"));
                s.setPhone(rs.getString("phone"));
                p.setSupplier(s);

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
}
