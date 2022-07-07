<%-- 
    Document   : noti
    Created on : Jul 2, 2022, 1:18:47 PM
    Author     : Thao Ngoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    </head>
    <style>

        body {
            font-family: 'Rubik', sans-serif;
            background: linear-gradient(180deg, rgb(255, 166, 166), #fff);
            background-repeat:no-repeat;

        }

        .container{
            margin-top: 100px !important;
        }

        h3{
            color: #9E9E9E;
            font-size: calc(20px + 6 * ((100vw - 320px) / 680));
        }


        button:focus {
            box-shadow: none !important;
            outline-width: 0;
        }

        .card{
            border-radius:0;
            width: calc(475px + 10 * ((100vw - 320px) / 680)) ;
            box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.8) ;
        }

        .card-header{
            background-color:#F44236 !important;
            color: #fff;
        }

        img{
            width: 180px !important;
        }

        .btn-primary{
            background:	#B52AB4;
            color: #fff !important;
            border-radius:0 !important;
            letter-spacing: 1px;
        }


        .btn-primary:hover{
            background:	#B52AB4;
        }
        .btn-primary:focus{
            background:	#B52AB4 !important;
        }

        .btn-success{
            border: 1px solid #B52AB4;
            padding: 8px 20px 8px 20px !important;
            border-radius: 20px !important;

        }

        .btn-success:hover{
            background:	#B52AB4;
            color:#fff !important;
            border-color: 	#B52AB4 !important;
        }
        .btn-success:focus{
            background:	#B52AB4 !important;
            color:#fff !important;
        }

        .btn-success{
            background:	#B52AB4 !important;

        }
        .inner li {
            list-style-type: disc !important;
        }

        .fa-times-circle{
            vertical-align: middle !important;
            cursor: pointer !important;
        }


        @media (max-width: 654px) {
            .card{
                width: unset;
            }
        }
    </style>
    <body>
        
    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</html>
