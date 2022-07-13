/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Product;
import model.Category;
import model.Supplier;

/**
 *
 * @author LAM
 */
public class ProductDAO extends DBContext {

    public List<Product> getAll() {
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
                + "  FROM [Product] p inner join Category c on p.categoryID = c.ID inner join Supplier s on p.suppliID = s.pID";
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

//    public List<Product> checkLaptops(int[] id, String sortby) {
//        List<Product> list = new ArrayList<>();
//        String sql = "select p.productID, p.productName, p.decription,p.originalPrice,p.categoryID,sc.ID,sc.categoryName ,p.sellPrice,p.salePercent, p.amount,p.suppliID, "
//                + " p.salePercent,p.isSell,p.releaseDate,p.image \n"
//                + "from Product p inner join category sc on p.categoryID = sc.ID";
//        if (id != null) {
//            sql += " and p.categoryID in(";
//            for (int i = 0; i < id.length; i++) {
//                sql += id[i] + ",";
//            }
//            if (sql.endsWith(",")) {
//                sql = sql.substring(0, sql.length() - 1);
//            }
//            sql += ")";
//        }
//        if (sortby != null && !sortby.equals("")) {
//            int so;
//            try {
//                so = Integer.parseInt(sortby);
//            } catch (NumberFormatException e) {
//                so = 0;
//            }
//            switch (so) {
//                case 0:
//                    sql += "\n order by p.productID asc";
//                    break;
//                case 1:
//                    sql += "\n order by p.releaseDate desc";
//                    break;
//                case 2:
//                    sql += "\n order by (p.price * (100 - p.salePercent) / 100)  desc";
//                    break;
//                case 3:
//                    sql += "\n order by (p.price * (100 - p.salePercent) / 100)  asc";
//                    break;
//            }
//        }
//
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//
//            ResultSet rs = st.executeQuery();
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
//                list.add(p);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//    }

//    public List<Product> getByName(String name) {
//        List<Product> list = new ArrayList<Product>();
//        String sql = "select p.productID, p.productName, p.decription,p.originalPrice,p.categoryID,sc.ID,sc.categoryName ,p.sellPrice,p.salePercent, p.amount,p.suppliID, "
//                + " p.salePercent,p.isSell,p.releaseDate,p.image \n"
//                + "from Product p inner join category sc on p.categoryID = sc.ID"
//                + "where name like '%" + name + "%'";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
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

    public List<Product> getListByPage(List<Product> list,
            int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public Product getProductByID(int productIDParam){
        Product p = new Product();
        String query = "select * from Product where productID="+productIDParam;
        ResultSet rs = getData(query);
        try {
            if(rs.next()){
                int productID = rs.getInt(1);
                String productName = rs.getString(2);
                String desciption = rs.getString(3);
                int originalPrice = rs.getInt(4);
                int categoryID = rs.getInt(5);
                Category c = new CategoryDAO().getByID(categoryID);
                int sellPrice = rs.getInt(6);
                int salePercent = rs.getInt(7);
                int amount = rs.getInt(8);
                int suppliID = rs.getInt(9);
                Supplier s = new SupplierDAO().getByID(suppliID);
                Date releaseDate = rs.getDate(10);
                int isSell = rs.getInt(11);
                String image = rs.getString(12);
                p = new Product(productID, productName, image, desciption, originalPrice, c, sellPrice, salePercent, amount, s, releaseDate, isSell);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
}
