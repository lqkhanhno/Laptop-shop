
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

        <title>Electro.vn</title>

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
                        <li><a href="#"><i class="fa fa-envelope-o"></i> khanhlq@fpt.edu.vn</a></li>
                        <li><a href="#"><i class="fa fa-map-marker"></i> FPT</a></li>
                    </ul>
                    <ul class="header-links pull-right">
                        <li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
                            <c:if test="${sessionScope.email == null}">
                            <li><a href="login.jsp"><i class="fa fa-user-o"></i> Login</a></li>
                            </c:if>

                        <c:if test="${sessionScope.email != null}">
                            <li><a href="#"><i class="fa fa-user-o"></i> ${sessionScope.username}</a></li>
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
                        <div class="col-md-5">
                            <div class="header-search">
                                <form action="search">
                                    <input name="searchname" class="input" placeholder="Search here">
                                    <button type="submit" class="search-btn"><i class="fa fa-search" aria-hidden="true"></i></button>
                                </form>
                            </div>
                        </div>
                        <!-- /SEARCH BAR -->

                        <!-- ACCOUNT -->
                        <div class="col-md-4 clearfix">
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

        <!-- NAVIGATION -->
        <nav id="navigation">
            <!-- container -->
            <div class="container">
                <!-- responsive-nav -->
                <div id="responsive-nav">
                    <!-- NAV -->
                    <ul class="main-nav nav navbar-nav">
                        <li class="active"><a href="home">Home</a></li>

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
        <!-- /NAVIGATION -->
        
        <!-- SECTION -->
	<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="./img/shop01.png" alt="">
							</div>
							<div class="shop-body">
								<h3>NEW PRODUCTS</h3>
								<a href="sort?type=1" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->

					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="./img/shop03.png" alt="">
							</div>
							<div class="shop-body">
								<h3>TOP SELLING</h3>
								<a href="sort?type=2" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div> 
					<!-- /shop -->

					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="./img/shop02.png" alt="">
							</div>
							<div class="shop-body">
								<h3>TOP SALE</h3>
								<a href="sort?type=3" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>	
        <!-- /SECTION -->

        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">               
                <!-- /row -->
                <div class="row">

                    <!-- section title -->
                    <div class="col-md-10">
                        <div class="section-title">
                            <h3 class="title">All Product</h3>
                        </div>
                    </div>
                    <!-- /section title -->

                    <!-- Products tab & slick -->
                    <div id="store" class="col-md-12">
                        <div class="row">
                            <c:forEach items="${requestScope.data}" var="i">
                                <div class="col-md-3 col-xs-6">
                                <!-- product -->
                                <div class="product">
                                    <div class="product-img">
                                        <img src="./img/Laptop/${i.image}" alt="">
                                        <div class="product-label">
                                            <c:if test="${i.salePercent != 0}">
                                                <span class="sale">-${i.salePercent}%</span>
                                            </c:if>
                                            <c:if test="${i.releaseDate > ourDate}">
                                                <span class="new">NEW</span>
                                            </c:if>
                                        </div>
                                    </div>
                                                 
                                    <div class="product-body">
                                        <p class="product-category">${i.category.categoryName}</p>
                                        <h3 class="product-name"><a href="product?productid=${i.productID}">${i.productName}</a></h3>
                                        <c:if test="${i.salePercent != 0}">
                                            <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.sellPrice * (100 - i.salePercent) / 100}" type = "currency"/>
                                                <del class="product-old-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.sellPrice}" type = "currency"/></del>
                                            </h4>
                                        </c:if>
                                        <c:if test="${i.salePercent == 0}">
                                            <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.sellPrice}" type = "currency"/></h4>
                                        </c:if>
                                    </div>
                                </div>  
                                </div>  
                                <!-- /product -->
                            </c:forEach>  
                        </div>
                    </div>
                    <!-- Products tab & slick -->
                </div>
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->



        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">

                    <!-- section title -->
                    <div class="col-md-12">
                        <div class="section-title">
                            <h3 class="title">New Products</h3>
                            <div class="section-nav">
                                <!--								<ul class="section-tab-nav tab-nav">
                                                                                                        <li class="active"><a data-toggle="tab" href="#tab1">Laptops</a></li>
                                                                                                        <li><a data-toggle="tab" href="#tab1">Smartphones</a></li>
                                                                                                        <li><a data-toggle="tab" href="#tab1">Cameras</a></li>
                                                                                                </ul>-->
                            </div>
                        </div>
                    </div>
                    <!-- /section title -->

                    <!-- Products tab & slick -->
                    <div class="col-md-12">
                        <div class="row">
                            <div class="products-tabs">
                                <!-- tab -->
                                <div id="tab1" class="tab-pane active">
                                    <%--<fmt:formatDate value="${ourDate}" pattern="dd/MM/yyyy"/>--%>
                                    <div class="products-slick" data-nav="#slick-nav-1">

                                        <c:forEach items="${requestScope.data1}" var="i">

                                            <!-- product -->
                                            <div class="product">
                                                <div class="product-img">
                                                    <img src="./img/Laptop/${i.image}" alt="">
                                                    <div class="product-label">
                                                        <c:if test="${i.salePercent != 0}">
                                                            <span class="sale">-${i.salePercent}%</span>
                                                        </c:if>
                                                        <c:if test="${i.releaseDate > ourDate}">
                                                            <span class="new">NEW</span>
                                                        </c:if>

                                                    </div>
                                                </div>
                                                <div class="product-body">
                                                    <p class="product-category">${i.category.categoryName}</p>
                                                    <h3 class="product-name"><a href="product?productid=${i.productID}">${i.productName}</a></h3>
                                                        <c:if test="${i.salePercent != 0}">
                                                        <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.sellPrice * (100 - i.salePercent) / 100}" type = "currency"/>
                                                            <del class="product-old-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.sellPrice}" type = "currency"/></del>
                                                        </h4>
                                                    </c:if>
                                                    <c:if test="${i.salePercent == 0}">
                                                        <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.sellPrice}" type = "currency"/></h4>
                                                    </c:if>

                                                </div>

                                            </div>
                                            <!-- /product -->
                                        </c:forEach>

                                    </div>
                                    <div id="slick-nav-1" class="products-slick-nav"></div>
                                </div>
                                <!-- /tab -->
                            </div>
                        </div>
                    </div>
                    <!-- Products tab & slick -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        

        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">

                    <!-- section title -->
                    <div class="col-md-12">
                        <div class="section-title">
                            <h3 class="title">Top selling</h3>
                            <div class="section-nav">
                                <!--								<ul class="section-tab-nav tab-nav">
                                                                                                        <li class="active"><a data-toggle="tab" href="#tab2">Laptops</a></li>
                                                                                                        <li><a data-toggle="tab" href="#tab2">Smartphones</a></li>
                                                                                                        <li><a data-toggle="tab" href="#tab2">Cameras</a></li>
                                                                                                </ul>-->
                            </div>
                        </div>
                    </div>
                    <!-- /section title -->

                    <!-- Products tab & slick -->
                    <div class="col-md-12">
                        <div class="row">
                            <div class="products-tabs">
                                <!-- tab -->
                                <div id="tab2" class="tab-pane fade in active">
                                    <div class="products-slick" data-nav="#slick-nav-2">
                                        <!-- product -->
                                        <c:forEach items="${requestScope.data2}" var="i">
                                            <div class="product">
                                                <div class="product-img">
                                                    <img src="./img/Laptop/${i.image}" alt="">
                                                    <div class="product-label">
                                                        <c:if test="${i.salePercent != 0}">
                                                            <span class="sale">-${i.salePercent}%</span>
                                                        </c:if>
                                                        <c:if test="${i.releaseDate > ourDate}">
                                                            <span class="new">NEW</span>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="product-body">
                                                    <p class="product-category">${i.category.categoryName}</p>
                                                    <h3 class="product-name"><a href="product?productid=${i.productID}">${i.productName}</a></h3>
                                                        <c:if test="${i.salePercent != 0}">
                                                        <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.sellPrice * (100 - i.salePercent) / 100}" type = "currency"/>
                                                            <del class="product-old-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.sellPrice}" type = "currency"/></del>
                                                        </h4>
                                                    </c:if>
                                                    <c:if test="${i.salePercent == 0}">
                                                        <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.sellPrice}" type = "currency"/></h4>
                                                    </c:if>
                                                </div>

                                            </div>
                                            <!-- /product -->
                                        </c:forEach>
                                    </div>
                                    <div id="slick-nav-2" class="products-slick-nav"></div>
                                </div>
                                <!-- /tab -->
                            </div>
                        </div>
                    </div>
                    <!-- /Products tab & slick -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">

                    <!-- section title -->
                    <div class="col-md-12">
                        <div class="section-title">
                            <h3 class="title">Top sale</h3>
                            <div class="section-nav">
                                <!--								<ul class="section-tab-nav tab-nav">
                                                                                                        <li class="active"><a data-toggle="tab" href="#tab2">Laptops</a></li>
                                                                                                        <li><a data-toggle="tab" href="#tab2">Smartphones</a></li>
                                                                                                        <li><a data-toggle="tab" href="#tab2">Cameras</a></li>
                                                                                                </ul>-->
                            </div>
                        </div>
                    </div>
                    <!-- /section title -->

                    <!-- Products tab & slick -->
                    <div class="col-md-12">
                        <div class="row">
                            <div class="products-tabs">
                                <!-- tab -->
                                <div id="tab2" class="tab-pane fade in active">
                                    <div class="products-slick" data-nav="#slick-nav-3">
                                        <!-- product -->
                                        <c:forEach items="${requestScope.data3}" var="i">
                                            <div class="product">
                                                <div class="product-img">
                                                    <img src="./img/Laptop/${i.image}" alt="">
                                                    <div class="product-label">
                                                        <c:if test="${i.salePercent != 0}">
                                                            <span class="sale">-${i.salePercent}%</span>
                                                        </c:if>
                                                        <c:if test="${i.releaseDate > ourDate}">
                                                            <span class="new">NEW</span>
                                                        </c:if>
                                                    </div>
                                                </div>
                                                <div class="product-body">
                                                    <p class="product-category">${i.category.categoryName}</p>
                                                    <h3 class="product-name"><a href="product?productid=${i.productID}">${i.productName}</a></h3>
                                                        <c:if test="${i.salePercent != 0}">
                                                        <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.sellPrice * (100 - i.salePercent) / 100}" type = "currency"/>
                                                            <del class="product-old-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.sellPrice}" type = "currency"/></del>
                                                        </h4>
                                                    </c:if>
                                                    <c:if test="${i.salePercent == 0}">
                                                        <h4 class="product-price"><fmt:setLocale value = "en_US"/><fmt:formatNumber value = "${i.sellPrice}" type = "currency"/></h4>
                                                    </c:if>
                                                </div>

                                            </div>
                                            <!-- /product -->
                                        </c:forEach>
                                    </div>
                                    <div id="slick-nav-3" class="products-slick-nav"></div>
                                </div>
                                <!-- /tab -->
                            </div>
                        </div>
                    </div>
                    <!-- /Products tab & slick -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- NEWSLETTER -->
        <div id="newsletter" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="newsletter">
                            <p>Sign Up for the <strong>NEWSLETTER</strong></p>
                            <form>
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
                        <div class="col-md-4 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">About Us</h3>
                                <ul class="footer-links">
                                    <li><a href="#"><i class="fa fa-map-marker"></i>162 Thai Ha</a></li>
                                    <li><a href="#"><i class="fa fa-phone"></i>+84-369-909-625</a></li>
                                    <li><a href="#"><i class="fa fa-envelope-o"></i>fpt@fpt.edu.vn</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-md-4 col-xs-6">
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
                     

                        <div class="col-md-4 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Service</h3>
                                <ul class="footer-links">
                                    <li><a href="userprofile">My Account</a></li>
                                    <li><a href="cart">View Cart</a></li>
                                    <li><a href="checkout">Checkout</a></li>
                                    <li><a href="order">Track My Order</a></li>
                                    <li><a href="faq">Help</a></li>
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
// Set the date we're counting down to
                                    var countDownDate = new Date("Nov 14, 2021 23:59:59").getTime();

// Update the count down every 1 second
                                    var x = setInterval(function () {

// Get today's date and time
                                        var now = new Date().getTime();

// Find the distance between now and the count down date
                                        var distance = countDownDate - now;

// Time calculations for days, hours, minutes and seconds
                                        var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                                        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                                        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                                        var seconds = Math.floor((distance % (1000 * 60)) / 1000);

// Output the result in an element with id="demo"
                                        document.getElementById("days").innerHTML = days + "";
                                        document.getElementById("hours").innerHTML = hours + "";
                                        document.getElementById("mins").innerHTML = minutes + "";
                                        document.getElementById("secs").innerHTML = seconds + "";

// If the count down is over, write some text 
                                        if (distance < 0) {
                                            clearInterval(x);
                                            document.getElementById("days").innerHTML = "EXPIRED";
                                            document.getElementById("hours").innerHTML = "EXPIRED";
                                            document.getElementById("mins").innerHTML = "EXPIRED";
                                            document.getElementById("secs").innerHTML = "EXPIRED";
                                        }
                                    }, 1000);
        </script>
    </body>
</html>
