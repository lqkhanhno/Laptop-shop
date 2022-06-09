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
import model.Category;
import model.Product;

/**
 *
 * @author LAM
 */
public class DetailDAO extends DBContext {

    public Product getByPid(int pid) {
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
                + "where productID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
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

                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

//    public Category getCat(int pid) {
//        String sql = "select c.ID, c.categoryName\n"
//                + "from product p inner join category sc on p.categoryID = sc.ID "
//                + "where p.productID = ?";
//
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, pid);
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//                Category c = new Category();
//
//                c.setID(rs.getInt(1));
//                c.setCategoryName(rs.getString(2));
//
//                return c;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return null;
//    }

//    public SubCategories getSubCat(int pid) {
//        String sql = "select sc.scid, sc.scname, sc.cid\n"
//                    + "from products p inner join subcategories sc on p.scid = sc.scid "
//                    + "where p.pid = ?";
//        
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, pid);
//            ResultSet rs = st.executeQuery();
//            
//            while (rs.next()) {
//                SubCategories sc = new SubCategories();
//                
//                sc.setScid(rs.getInt(1));
//                sc.setScname(rs.getString(2));
//                sc.setCid(rs.getInt(3));
//                
//                return sc;
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        
//        return null;
//    }
//    public List<Product> getRelated(int pid) {
//        List<Product> list = new ArrayList<Product>();
//        String sql = "select p.productID, p.productName, p.decription,p.originalPrice,p.categoryID,sc.ID,sc.categoryName ,p.sellPrice,p.salePercent, p.amount,p.suppliID, "
//                + " p.salePercent,p.isSell,p.releaseDate,p.image \n"
//                + "from Product p inner join category sc on p.categoryID = sc.ID"
//                + "where sc.ID = ? and p.productID != ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            int cid = new DetailDAO().getCat(pid).getID();
//            st.setInt(1, cid);
//            st.setInt(2, pid);
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//                Product p = new Product();
//
//                p.setProductID(rs.getInt("productID"));
//                p.setProductName(rs.getString("productName"));
//                p.setDescription(rs.getString("decription"));
//                p.setOriginalPrice(rs.getInt("originalPrice"));
//                p.setCategoryID(rs.getInt("ID"));
//
//                Category sc = new Category();
//                sc.setID(rs.getInt("ID"));
//                sc.setCategoryName(rs.getString("categoryName"));
//                p.setImage(rs.getString("image"));
//                p.setIsSell(rs.getInt("isSell"));
//                p.setReleaseDate(rs.getDate("releaseDate"));
//                p.setSellPrice(rs.getInt("sellPrice"));
//                p.setSalePercent(rs.getInt("salePercent"));
//                p.setAmount(rs.getInt("amount"));
//                p.setSuppliID(rs.getInt("suppliID"));
//
//                list.add(p);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return list;
//    }

    public static void main(String[] args) {
        DetailDAO db = new DetailDAO();
        Product p = db.getByPid(25);
        System.out.println(p);
    }
}
