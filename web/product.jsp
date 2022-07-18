
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="ourDate" class="java.util.Date"/>
<jsp:setProperty name="ourDate" property="time" value="${ourDate.time - 86400000*270}"/>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Product Detail</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css"/>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <!-- HEADER -->
        <header>
            <!-- TOP HEADER -->
            <div id="top-header">
                <div class="container">
                    <ul class="header-links pull-left">
                        <li><a href="#"><i class="fa fa-phone"></i> +84-369-909-625</a></li>
                        <li><a href="#"><i class="fa fa-envelope-o"></i> electrovn@gmail.com</a></li>
                        <li><a href="#"><i class="fa fa-map-marker"></i> 162 Thai Ha</a></li>
                    </ul>
                    <ul class="header-links pull-right">
                        <li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
                            <c:if test="${sessionScope.account == null}">
                            <li><a href="login.jsp"><i class="fa fa-user-o"></i> Login</a></li>
                            </c:if>

                        <c:if test="${sessionScope.account != null}">
                            <c:if test="${sessionScope.account.role == 0}">
                                <li><a href="listmanage"><i class="fa fa-user-o"></i> Hello ${sessionScope.account.user}</a></li>
                                </c:if>
                                <c:if test="${sessionScope.account.role == 1}">
                                <li><a href="profile"><i class="fa fa-user-o"></i> Hello ${sessionScope.account.user}</a></li>
                                </c:if>
                            <li><a href="logout"><i class="fa fa-user-o"></i> Logout</a></li>
                            </c:if>

                    </ul>
                </div>
            </div>
            <!-- /TOP HEADER -->

            <!-- MAIN HEADER -->
            <div id="header">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- LOGO -->
                        <div class="col-md-3">
                            <div class="header-logo">
                                <a href="home" class="logo">
                                    <img src="./img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <!-- /LOGO -->

                        <!-- SEARCH BAR -->
                        <div class="col-md-6">
                            <div class="header-search">
                                <form action="search">
                                    <input name="searchname" class="input" placeholder="Search here">
                                    <button type="submit" class="search-btn"><i class="fa fa-search" aria-hidden="true"></i></button>
                                </form>
                            </div>
                        </div>
                        <!-- /SEARCH BAR -->

                        <!-- ACCOUNT -->
                        <div class="col-md-3 clearfix">
                            <div class="header-ctn">
                                <!-- Noti -->
                                <div >
                                    <a href="notification">
                                        <i class="fa fa-bell"></i>
                                        <span>Notification</span>
                                    </a>
                                </div>
                                
                                
                                <!-- Cart -->
                                <div >
                                    <a href="cart">
                                        <i class="fa fa-shopping-cart"></i>
                                        <span>Your Cart</span>
                                        <% int qty = Integer.parseInt(request.getAttribute("quantityCart").toString());%>
                                        <div class="qty"><%= qty%></div>
                                    </a>

                                </div>
                                <!-- /Cart -->
                                
                                <!-- order list -->
                                <div >
                                    <a href="order">
                                        <i class="fa fa-bank"></i>
                                        <span>Order List</span>
                                    </a>

                                </div>

                                <!-- Menu Toogle -->
                                <div class="menu-toggle">
                                    <a href="#">
                                        <i class="fa fa-bars"></i>
                                        <span>Menu</span>
                                    </a>
                                </div>
                                <!-- /Menu Toogle -->
                            </div>
                        </div>
                        <!-- /ACCOUNT -->
                    </div>
                    <!-- row -->
                </div>
                <!-- container -->
            </div>
            <!-- /MAIN HEADER -->
        </header>
        <!-- /HEADER -->

        <nav id="navigation">
            <!-- container -->
            <div class="container">
                <!-- responsive-nav -->
                <div id="responsive-nav">
                    <!-- NAV -->
                    <ul class="main-nav nav navbar-nav">
                        <li><a href="home">Home</a></li>

                        <c:forEach items="${requestScope.sclist}" var="o">
                            <li><a href="catelist?id=${o.ID}" value="${o.ID}">${o.categoryName}</a></li>                       
                        </c:forEach>                      
                    </ul>
                    <!-- /NAV -->
                </div>
                <!-- /responsive-nav -->
            </div>
            <!-- /container -->
        </nav>



        <!-- SECTION -->
        <div class="section">   
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <!-- Product main img -->
                    <div class="col-md-5 col-md-push-2">
                        <div id="product-main-img">
                            <div class="product-preview">
                                <img src="./img/Laptop/${requestScope.data.image}" alt="">
                            </div>
                        </div>
                    </div>
                    <!-- /Product main img -->
                    <div class="col-md-3"></div>

                    <!-- Product details -->
                    <div  class="col-md-4">
                        <div class="product-details">
                            <h2 class="product-name">${requestScope.data.productName}</h2>
                            <div class="product-body">
                                <c:if test="${requestScope.data.salePercent != 0}">
                                    <h3 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${requestScope.data.sellPrice * (100 - requestScope.data.salePercent) / 100}" type = "currency"/>
                                        <del class="product-old-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${requestScope.data.sellPrice}" type = "currency"/></del>
                                    </h3>
                                </c:if>
                                <c:if test="${requestScope.data.salePercent == 0}">
                                    <h3 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${requestScope.data.sellPrice}" type = "currency"/></h3>
                                </c:if>


                            </div>
                            <p>${requestScope.data.description}</p>

                            <c:if test="${requestScope.data.amount > 0}">
                                <div class="add-to-cart">
                                    <% Product p = (Product) request.getAttribute("data");%>
                                    <a id="btn-add2cart" data-id="<%= p.getProductID()%>"  href="cart?s=add2Cart"  class="btn btn-danger"><i class="fa fa-shopping-cart"></i> Add to cart</a>
                                </div>
                            </c:if>
                            <c:if test="${requestScope.data.amount <= 0}">
                                <div class="add-to-cart">
                                    <a class="btn btn-danger"><i class="fa fa-shopping-cart"></i>Out of stock</a>
                                </div>
                            </c:if>


                        </div>	
                    </div>
                    <!-- /Product details -->

                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        
        
        <section class="content-item" id="comments">
            <div class="container">   
                <div class="row">
                    <div class="col-sm-8" id="comments-body">   
                            <h3 class="pull-left">New Comment : </h3>
                            <form action="addcomment" method="post">
                                <fieldset>
                                    <div class="row">
                                        <div class="col-sm-3 col-lg-2 hidden-xs">
                                        </div>
                                        <div class="form-group col-xs-12 col-sm-9 col-lg-10">
                                            <textarea class="form-control" id="comment" name="comment"  placeholder="Your message" maxlength="1000" title="Not over 1000 word"  required  ></textarea>
                                            <input type="hidden" name="pid" value="${requestScope.id}" >
                                            <input type="submit" value="Comment" class="btn btn-normal  btn-outline-success pull-right">                                         
                                        </div>
                                    </div>  	                                  
                                </fieldset>
                            </form>
                            <a id="pid" value="${requestScope.id}" hidden=""></a>
                        <br/><h3> Comments</h3>
                        <div id="mediaes">
                            <!-- COMMENT 1 - START -->
                        <c:forEach items="${requestScope.cmtlist}" var="c" >
                        <div class="media">
                            <div class="media-body">
                                <h5 class="media-heading">${c.user.username}</h5>
                                <p>${c.comment}</p>
                                <ul class="list-unstyled list-inline media-detail pull-left">
                                    <li><sup>${c.date}</sup></li>
                                </ul>
                                <ul class="list-unstyled list-inline media-detail pull-right">
                                </ul>
                            </div>
                        </div>    
                        </c:forEach>
                        
                        <!-- COMMENT 1 - END -->
                        </div>
                    </div>
                </div>
            </div>
        </section>
       

        <!-- NEWSLETTER -->
        <div id="newsletter" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="newsletter">
                            <p>Sign Up for the <strong>NEWSLETTER</strong></p>
                            <form action="home">
                                <input class="input" type="email" placeholder="Enter Your Email">
                                <button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
                            </form>
                            
                        </div>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /NEWSLETTER -->
        
        

        <!-- FOOTER -->
        <footer id="footer">
            <!-- top footer -->
            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">About Us</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>
                                <ul class="footer-links">
                                    <li><a href="#"><i class="fa fa-map-marker"></i>162 Thai Ha</a></li>
                                    <li><a href="#"><i class="fa fa-phone"></i>+84-369-909-625</a></li>
                                    <li><a href="#"><i class="fa fa-envelope-o"></i>electrovn@gmail.com</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Categories</h3>
                                <ul class="footer-links">
                                    <c:forEach items="${requestScope.sclist}" var="o">
                                        <li><a href="catelist?id=${o.ID}" value="${o.ID}">${o.categoryName}</a></li>                       
                                    </c:forEach>  
                                </ul>
                            </div>
                        </div>

                        <div class="clearfix visible-xs"></div>

                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Information</h3>
                                <ul class="footer-links">
                                    <li><a href="#">About Us</a></li>
                                    <li><a href="#">Contact Us</a></li>
                                    <li><a href="#">Privacy Policy</a></li>
                                    <li><a href="#">Orders and Returns</a></li>
                                    <li><a href="#">Terms & Conditions</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Service</h3>
                                <ul class="footer-links">
                                    <li><a href="profile">My Account</a></li>
                                    <li><a href="#">View Cart</a></li>
                                    <li><a href="#">Checkout</a></li>
                                    <li><a href="#">Track My Order</a></li>
                                    <li><a href="editfaq">Help</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </div>
            <!-- /top footer -->

            <!-- bottom footer -->
            <div id="bottom-footer" class="section">
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <span class="copyright">
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            </span>
                        </div>
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </div>
            <!-- /bottom footer -->
        </footer>
        <!-- /FOOTER -->
        
                    
        


        <!-- jQuery Plugins -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>
        <script>
                $('#btn-add2cart').click(function(event) {
                    event.preventDefault();
                    let btn_add2cart = $(this);
                    let id = btn_add2cart.data('id');
                    $.ajax({
                         url: '/Laptop-shop/cart?s=add2Cart',
                         type: 'get',
                         data: {id_product: id},
                     })
                     .done(function(respond) {
    //                     let qty = $('#quantityCart').data('value');
                         console.log("servel" + respond) ;
                         $('#quantityCart').html(respond);
                         $('#quantityCart').data('value',respond);
                         

                     })
                     .fail(function(error) {
                         console.log(error);
                         alert(error['statusText']);
                     })


                });
            
        </script>
        <script src="js/productDetail.js"></script>

    </body>
</html>
