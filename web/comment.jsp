<%-- 
    Document   : comment
    Created on : Jul 5, 2022, 8:26:45 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="detail" method="post">  
          
            <input type="hidden" name="userID" value=${sessionScope.UserID}>
            <input type="hidden" name="productID" value=${sessionScope.productID}>
            <input type="text" name="comment"  placeholder="Enter comment..."><br>
            <input type="hidden" name="date" value=""    
            <input type="submit" value="Submit">
      </form>
    </body>
</html>
