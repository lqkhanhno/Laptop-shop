<%@page import="model.User"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
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

        <title>Shopping Cart</title>

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
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link href="assets/css/icons.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <div class="wrapper">
            <div class="content-page">
                <div class="content">
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
                                        <li><a href="#"><i class="fa fa-user-o"></i> Hello ${sessionScope.account.user}</a></li>
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
                                            <!-- Cart -->
                                            <div class="dropdown">
                                                <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                                    <i class="fa fa-shopping-cart"></i>
                                                    <span>Your Cart</span>
                                                </a>
                                                <div class="cart-dropdown">
                                                    <div class="cart-list">
                                                        <div class="product-widget">
                                                            <div class="product-img">
                                                                <img src="./img/product01.png" alt="">
                                                            </div>
                                                            <button class="delete"><i class="fa fa-close"></i></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- /Cart -->

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

                    <!-- Start Content-->
                    <div class="container">

                        <!-- start page title -->
                        <div class="row">
                            <div class="col-12">
                                <div class="page-title-box">
                                    <div class="page-title-right">
                                        <ol class="breadcrumb m-0">
                                            <li class="breadcrumb-item"><a href="javascript: void(0);">Hyper</a></li>
                                            <li class="breadcrumb-item"><a href="javascript: void(0);">eCommerce</a></li>
                                            <li class="breadcrumb-item active">Checkout</li>
                                        </ol>
                                    </div>
                                    <h4 class="page-title">Checkout</h4>
                                </div>
                            </div>
                        </div>
                        <!-- end page title -->

                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-body">



                                        <!-- Steps Information -->
                                        <div class="tab-content">

                                            <!-- Billing Content-->
                                            <div class="tab-pane show active" id="billing-information">
                                                <div class="row">
                                                    <div class="col-lg-8">
                                                        <h4 class="mt-2">Billing information</h4>
                                                        <%
                                                            User u = (User) request.getAttribute("in4User");
                                                        %>
                                                        <form method="POST" action="checkout?s=processCheckOut">
                                                            <div class="row">
                                                                <div class="col-md-12">
                                                                    <div class="form-group">
                                                                        <label for="billing-last-name">Full Name</label>
                                                                        <input class="form-control" type="text" name="fullname" value="<%= u.getFullname()%>" placeholder="Enter your last name" id="billing-last-name">
                                                                    </div>
                                                                </div>
                                                            </div> <!-- end row -->
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <label for="billing-email-address">Email Address <span class="text-danger">*</span></label>
                                                                        <input class="form-control" type="email" name="email" value="<%= u.getEmail()%>" placeholder="Enter your email" id="billing-email-address">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <label for="billing-phone">Phone <span class="text-danger">*</span></label>
                                                                        <input class="form-control" type="text" name="phone" value="<%= u.getPhoneNumber()%>" placeholder="(xx) xxx xxxx xxx" id="billing-phone">
                                                                    </div>
                                                                </div>
                                                            </div> <!-- end row -->
                                                            <div class="row">
                                                                <div class="col-md-12">
                                                                    <div class="form-group">
                                                                        <label for="billing-address">Address</label>
                                                                        <input class="form-control" type="text" name="address" value="<%= u.getUserAddress()%>" placeholder="Enter full address" id="billing-address">
                                                                    </div>
                                                                </div>
                                                            </div> <!-- end row -->
                                                            <div class="row">
                                                                <div class="col-md-12">

                                                                    <div class="form-group mt-3">
                                                                        <label for="example-textarea">Order Notes:</label>
                                                                        <textarea class="form-control" id="example-textarea" name="note" rows="3" placeholder="Write some note.."></textarea>
                                                                    </div>
                                                                </div>
                                                            </div> <!-- end row -->

                                                            <div class="row mt-4">
                                                                <div class="col-sm-6">
                                                                    <a href="cart?s=showCart" class="btn text-muted d-none d-sm-inline-block btn-link font-weight-semibold">
                                                                        <i class="mdi mdi-arrow-left"></i> Back to Shopping Cart </a>
                                                                </div> <!-- end col -->
                                                                <div class="col-sm-6">
                                                                    <div class="text-sm-right">
                                                                        <button class="btn btn-danger" type="submit">
                                                                            <i class="mdi mdi-truck-fast mr-1"></i> Complete Checkout </button>
                                                                    </div>
                                                                </div> <!-- end col -->
                                                            </div> <!-- end row -->
                                                        </form>
                                                    </div>
                                                    <div class="col-lg-4">
                                                        <div class="border p-3 mt-4 mt-lg-0 rounded">
                                                            <h4 class="header-title mb-3">Order Summary</h4>


                                                            <div class="table-responsive">
                                                                <table class="table table-centered mb-0">
                                                                    <tbody>
                                                                        <%
                                                                            HashMap<String, HashMap<String, String>> listPro
                                                                                    = (HashMap<String, HashMap<String, String>>) request.getAttribute("listProduct");
                                                                            Set<String> keySet = listPro.keySet();
                                                                            HashMap<String, String> order_Summary = listPro.get("order_summary");
                                                                            for (Object key : keySet) {
                                                                                if (key.toString() != "order_summary") {
                                                                                    HashMap<String, String> infoProduct = listPro.get(key);

                                                                        %>
                                                                        <tr>
                                                                            <td>
                                                                                <img src="img/Laptop/<%= infoProduct.get("image")%>" alt="contact-img" title="contact-img" class="rounded mr-2" height="48">
                                                                                <p class="m-0 d-inline-block align-middle">
                                                                                    <a href="apps-ecommerce-products-details.html" class="text-body font-weight-semibold"><%= infoProduct.get("name")%></a>
                                                                                    <br>
                                                                                    <small><%= infoProduct.get("quantity")%> x <%= infoProduct.get("price")%> VND</small>
                                                                                </p>
                                                                            </td>
                                                                            <td class="text-right">
                                                                                <%= order_Summary.get(key)%>
                                                                            </td>
                                                                        </tr>

                                                                        <%}
                                                                            }%>
                                                                        <tr class="text-right">
                                                                            <td>
                                                                                <h6 class="m-0">Grand Total:</h6>
                                                                            </td>
                                                                            <td class="text-right">
                                                                                <%= order_Summary.get("totalGrand")%> VND
                                                                            </td>
                                                                        </tr>
                                                                        <tr class="text-right">
                                                                            <td>
                                                                                <h6 class="m-0">Discount:</h6>
                                                                            </td>
                                                                            <td class="text-right">
                                                                                - <%= order_Summary.get("discount")%> VND
                                                                            </td>
                                                                        </tr>
                                                                        <tr class="text-right">
                                                                            <td>
                                                                                <h5 class="m-0">Total:</h5>
                                                                            </td>
                                                                            <td class="text-right font-weight-semibold">
                                                                                <%= order_Summary.get("totalCart")%> VND
                                                                            </td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                            <!-- end table-responsive -->
                                                        </div> <!-- end .border-->

                                                    </div> <!-- end col -->            
                                                </div> <!-- end row-->
                                            </div>
                                            <!-- End Billing Information Content-->


                                        </div> <!-- end tab content-->

                                    </div> <!-- end card-body-->
                                </div> <!-- end card-->
                            </div> <!-- end col -->
                        </div>
                        <!-- end row-->

                    </div>
                    <!-- container -->

                </div>
                <!-- content -->
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
                                            <li><a href="#">My Account</a></li>
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
                                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved 
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
            </div>

            <!-- ============================================================== -->
            <!-- End Page content -->
            <!-- ============================================================== -->
        </div>
        <!-- END wrapper -->
        <!-- jQuery Plugins -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>
