<%@page import="model.Product"%>
<%@page import="dal.ProductDAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>

<%@page import = "java.util.*" %>
<!DOCTYPE html>
<%
    //List<car> lst = (List<car>) request.getAttribute("lst");
    ProductDAO u = new ProductDAO();
    List<Product> lst = u.getAll();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Cars</title>
    </head>
    <body>
        <h2> List of Cars </h2>
        <table border="1">
            <tr>
                <td> ID </td>
                <td> Name </td>
                <td> price </td>
               
            </tr>
            <%
                for (Product x : lst) {
            %>
            <tr>
                <td><%= x.getProductID()%></td>
                <td><%= x.getProductName()%></td>
                <td><%= x.getSellPrice()%></td>
                           
            </tr>
            <% } %>
        </table>
        <p><button onclick='window.history.go(-1);'>Back to previous page</button>
        <p><a href="index.html">Back to homepage</a>    
    </body>
</html>
