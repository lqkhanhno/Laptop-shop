<%-- 
    Document   : login
    Created on : Jul 2, 2022, 3:53:13 AM
    Author     : Thao Ngoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Design by foolishdeveloper.com -->
    <title>Glassmorphism login Form Tutorial in html css</title>
 
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    <!--Stylesheet-->
    <style media="screen">
      *,
*:before,
*:after{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}
body{
    background-color: #080710;
}
.background{
    width: 430px;
    height: 520px;
    position: absolute;
    transform: translate(-50%,-50%);
    left: 50%;
    top: 50%;
}
.background .shape{
    height: 200px;
    width: 200px;
    position: absolute;
    border-radius: 50%;
}
.shape:first-child{
    background: linear-gradient(
        #1845ad,
        #23a2f6
    );
    left: -80px;
    top: -80px;
}
.shape:last-child{
    background: linear-gradient(
        to right,
        #ff512f,
        #f09819
    );
    right: -30px;
    bottom: -80px;
}
form{
    height: fit-content;
    width: 400px;
    background-color: rgba(255,255,255,0.13);
    position: absolute;
    transform: translate(-50%,-50%);
    top: 50%;
    left: 50%;
    border-radius: 10px;
    backdrop-filter: blur(10px);
    border: 2px solid rgba(255,255,255,0.1);
    box-shadow: 0 0 40px rgba(8,7,16,0.6);
    padding: 50px 35px;
    margin-top: 170px;
    margin-bottom: 20px
}
form *{
    font-family: 'Poppins',sans-serif;
    color: #ffffff;
    letter-spacing: 0.5px;
    outline: none;
    border: none;
}
form h3{
    font-size: 32px;
    font-weight: 500;
    line-height: 42px;
    text-align: center;
}

label{
    display: block;
    margin-top: 30px;
    font-size: 16px;
    font-weight: 500;
}
input{
    display: block;
    height: 50px;
    width: 100%;
    background-color: rgba(255,255,255,0.07);
    border-radius: 3px;
    padding: 0 10px;
    margin-top: 8px;
    font-size: 14px;
    font-weight: 300;
}
::placeholder{
    color: #e5e5e5;
}
button{
    margin-top: 50px;
    width: 100%;
    background-color: #ffffff;
    color: #080710;
    padding: 15px 0;
    font-size: 18px;
    font-weight: 600;
    border-radius: 5px;
    cursor: pointer;
}
.social{
  margin-top: 30px;
  display: flex;
}
.social div{
  background: red;
  width: 150px;
  border-radius: 3px;
  padding: 5px 10px 10px 5px;
  background-color: rgba(255,255,255,0.27);
  color: #eaf0fb;
  text-align: center;
}
.social div:hover{
  background-color: rgba(255,255,255,0.47);
}
.social .fb{
  margin-left: 25px;
}
.social i{
  margin-right: 4px;
}

    </style>
</head>
<body>
    <div class="background">
        <div class="shape"></div>
        <div class="shape"></div>
    </div>
    <form action="sign-up" method="post">
        <h3>Sign up</h3>
        <label for="username">Username</label>
        <input type="text" value="${username}" name="username" placeholder="Username" id="username">
        <label style="color:red;margin-top: 0px" >${msgUsername}</label>
        
        <label for="fullname">Fullname</label>
        <input type="text" value="${fullname}" name="fullname" placeholder="Fullname" id="fullname">
        <label style="color:red;margin-top: 0px" >${msgFullname}</label>
        
        <label for="email">Email</label>
        <input type="text" value="${email}" name="email" placeholder="Email" id="email">
        <label style="color:red;margin-top: 0px" >${msgEmail}</label>
        
        <label for="address">Address</label>
        <input name="address" value="${address}" type="text" placeholder="Address" id="address">
        <label style="color:red;margin-top: 0px" >${msgAddress}</label>

        <label for="phone">Phone number</label>
        <input name="phone" value="${phone}" type="text" placeholder="Phone" id="phone">
        <label style="color:red;margin-top: 0px" >${msgPhone}</label>
        
        <label for="password">Password</label>
        <input name="password" value="${password}" type="password" placeholder="Password" id="password">
        <label style="color:red;margin-top: 0px" >${msgPassword}</label>
        
         <label for="repassword">Re-Password</label>
        <input name="repassword" value="${repassword}" type="password" placeholder="Re-Enter Password" id="repassword">
        <label style="color:red;margin-top: 0px" >${msgRePassword}</label>
        
        
        <button type="submit">Create</button>
       
    </form>
</body>
</html>

