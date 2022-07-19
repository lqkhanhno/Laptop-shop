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

		<title>Electro - HTML Ecommerce Template</title>

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
                
                <script>
                    function change() {
                        let results = Array.from(document.querySelectorAll('.result > div')),
                            modelsChecked = document.querySelectorAll('.filter input.models:checked'),
                            processorsChecked = document.querySelectorAll('.filter input.processors:checked');
                        // Hide all results
                        results.forEach(function(result) {
                            result.style.display = 'none';
                        });
                        // Filter results to only those that meet ALL requirements:        

                        filterModelsOrProcessors(modelsChecked);

                        if (processorsChecked.length != 0) {
                            filterModelsOrProcessors(processorsChecked);
                        }

                        function filterModelsOrProcessors(modelsOrProcessorsChecked) {
                            results = Array.from(modelsOrProcessorsChecked).reduce(function(sum, input) {
                                const attrib = input.getAttribute('rel');
                                return sum.concat(results.filter(function(result) {
                                    return result.classList.contains(attrib);
                                }));
                            }, []);
                        }
                        // Show those filtered results:
                        results.forEach(function(result) {
                            result.style.display = 'block';
                        });
                    }
                    change();
                </script>
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
					<!-- ASIDE -->
					<div id="aside" class="col-md-3">
						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Categories</h3>
							<div class="checkbox-filter">
                                                            <div class="input-checkbox">
									<input type="checkbox" id="category-1">
									<label for="category-1">
										<span></span>
										NEW PRODUCTS
									</label>
								</div>                                                           							
							</div>
						</div>
						<!-- /aside Widget -->

						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Price</h3>
							<div class="price-filter">
								<div id="price-slider"></div>
								<div class="input-number price-min">
									<input id="price-min" type="number">
									<span class="qty-up">+</span>
									<span class="qty-down">-</span>
								</div>
								<span>-</span>
								<div class="input-number price-max">
									<input id="price-max" type="number">
									<span class="qty-up">+</span>
									<span class="qty-down">-</span>
								</div>
							</div>
						</div>
						<!-- /aside Widget -->						
					</div>
					<!-- /ASIDE -->

					<!-- STORE -->
					<div id="store" class="col-md-9">
						<!-- store top filter -->
						<div class="store-filter clearfix">
                                                    <div class="store-sort">
                                                            <form action="sort" method="post">
<!--                                                                <input id="type" name="type" value="${requestScope.type}">-->                                                              
                                                                <label>                                                                  
                                                                    Sort By:
                                                                    <select class="input-select" name="value" onchange="location.href = 'sort?type=' + this.value;">
                                                                        <option value="1" <%= request.getAttribute("type").toString().equalsIgnoreCase("1")?  "selected":"" %>>NEW PRODUCTS</option>                                                                  
									<option value="2" <%= request.getAttribute("type").toString().equalsIgnoreCase("2")?  "selected":"" %>>TOP SELLING</option>
                                                                        <option value="3" <%= request.getAttribute("type").toString().equalsIgnoreCase("3")?  "selected":"" %>>TOP SALE</option>	
                                                                    </select>                                                                    
								</label>
                                                                <input type="submit" hidden>
                                                            </form>								
							</div>	
						</div>
						<!-- /store top filter -->

						
						<!-- Products tab & slick -->
                    <div id="store" class="col-md-12">
                        <div class="row result">
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
                                        <c:if test="${i.salePercent != 0}">="product
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
					</div>
					<!-- /STORE -->
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
							<ul class="newsletter-follow">
								<li>
									<a href="#"><i class="fa fa-facebook"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-twitter"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-instagram"></i></a>
								</li>
								<li>
									<a href="#"><i class="fa fa-pinterest"></i></a>
								</li>
							</ul>
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

      
    </body>        
</html>
