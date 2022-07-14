
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html style="font-size: 16px;" lang="en"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="Faq, INTUITIVE">
    <meta name="description" content="">
    <title>FAQ</title>
    <link rel="stylesheet" href="css/nicepage.css" media="screen">
<link rel="stylesheet" href="css/FAQ.css" media="screen">
    <script class="u-script" type="text/javascript" src="js/jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="js/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 4.13.4, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
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
    
  </head>
  <body class="u-body u-xl-mode">
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
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
		</header>
      
      
    <section class="u-align-left u-clearfix u-section-1" id="carousel_223a">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h2 class="u-text u-text-1">FAQ</h2>
        <div class="u-accordion u-expanded-width u-faq u-spacing-20 u-accordion-1">
            <c:forEach items="${requestScope.list}" var="list">
                <div class="u-accordion-item">
                    <a class="active u-accordion-link u-active-grey-5 u-border-2 u-border-active-palette-1-base u-border-hover-palette-5-dark-2 u-border-no-left u-border-no-right u-border-no-top u-border-palette-5-dark-2 u-button-style u-text-body-color u-accordion-link-1" id="link-accordion-6327" aria-controls="accordion-6327" aria-selected="true">
                        <span class="u-accordion-link-text">${list.title}</span><span class="u-accordion-link-icon u-icon u-icon-circle u-text-black u-icon-1"><svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 16 16" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-2c6d"></use></svg><svg class="u-svg-content" viewBox="0 0 16 16" x="0px" y="0px" id="svg-2c6d" style=""><path d="M8,10.7L1.6,5.3c-0.4-0.4-1-0.4-1.3,0c-0.4,0.4-0.4,0.9,0,1.3l7.2,6.1c0.1,0.1,0.4,0.2,0.6,0.2s0.4-0.1,0.6-0.2l7.1-6
	c0.4-0.4,0.4-0.9,0-1.3c-0.4-0.4-1-0.4-1.3,0L8,10.7z"></path></svg></span>
                    </a>
                    <div class="u-accordion-active u-accordion-pane u-container-style u-accordion-pane-1" id="accordion-6327" aria-labelledby="link-accordion-6327">
                        <div class="u-container-layout u-container-layout-1">
                            <div class="fr-view u-clearfix u-rich-text u-text">
                                <p>${list.content}</p>
                            </div>
                        </div>
                    </div>
                </div>         
            </c:forEach>
                               
        </div>
      </div>
    </section>
          
    
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
									<li><a href="hotdeals">Hot deals</a></li>
									<li><a href="laptops">Laptops</a></li>
									<li><a href="#">Smartphones</a></li>
									<li><a href="#">Cameras</a></li>
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
									<li><a href="#">Help</a></li>
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
							<ul class="footer-payments">
								<li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
								<li><a href="#"><i class="fa fa-credit-card"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
								<li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
							</ul>
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
  
</body></html>