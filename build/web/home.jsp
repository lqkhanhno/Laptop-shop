<%-- 
    Document   : home
    Created on : Jun 2, 2022, 10:01:33 AM
    Author     : LAPTOP VINH HA
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <%String titlepage = (String) request.getAttribute("titlepage");%>
        <title><%=titlepage%></title>
    </head>
    <body>
        <%
            Vector<Product> listProduct = (Vector<Product>) request.getAttribute("listProduct");
            String notiCart = request.getParameter("notification");
        %>
        <div class="">
            <a class="fa fa-shopping-cart" style="font-size:36px" href="Cart?s=showCart">
                Cart
            </a>
        </div>
        <p style="color: green" > <%=notiCart != null ? notiCart : ""%></p>
        <table border = 1>
            <%
                for(Product p : listProduct){
            %>
                <tr>
                    <td><%= p.getProductName() %></td>
                    <td><%= p.getOriginalPrice() %></td>
                    <td><%= p.getSellPrice()%>  <%= p.getSalePercent() %>%</td>
                    <td><a href="Cart?s=add2Cart&id_product=<%= p.getProductID() %>">add2Cart</a></td>
                </tr>
            <%
                }
            %>
            
        </table>
    </body>
</html>
