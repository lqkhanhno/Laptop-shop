<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Cart</title>

    </head>
    <body>
        <%
            HashMap<String, ArrayList<String>> listMap = (HashMap<String, ArrayList<String>>)request.getAttribute("Cart");
            Set<String> keySet = listMap.keySet();
            
        %>
        <%
            if(listMap.size()>1){
        %>
        <table width=70% border="1"  >
            <tr>
                <th colspan="2">Product</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Remove</th>
            </tr>
        <%
            int totalCart=0;
            for(Object key: keySet){
                ArrayList<String> product = new ArrayList();
                if(key.toString().equalsIgnoreCase("totalCart")){
                    totalCart = Integer.parseInt(listMap.get(key).get(0));
                }else{
                    product = listMap.get(key);
                
        %>
            <tr>
                <td>image here</td>
                <td><%= product.get(1) %></td>
                <td><%= product.get(2) %></td>
                <td><%= product.get(0) %></td>
                <td><%= product.get(3) %></td>
                <td><a href="ShoppingCart?s=showCart&id_product=<%= key.toString() %>">remove</a></td>
            </tr>
        
        <% 
                }
            }
        %>
        </table>
        <div class="foot">
            <p>
                Total:
                <span><%=totalCart%></span>
                <span><a href="ControllerCart?s=remove_all">Remove all</a></span>
            </p>
        </div>
        <%
            }else{
        %>
            <p>Cart không có gì b oi</p>
        <%}%>
    </body>
</html>