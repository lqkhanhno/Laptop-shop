<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Vector"%>
<%@page import="model.Order"%>
<html lang="en"><head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Electro - HTML Ecommerce Template</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css">
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css">

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css">

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css">

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
                        <li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
                        <li><a href="#"><i class="fa fa-envelope-o"></i> email@email.com</a></li>
                        <li><a href="#"><i class="fa fa-map-marker"></i> 1734 Stonecoal Road</a></li>
                    </ul>
                    <ul class="header-links pull-right">
                        <li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
                        <li><a href="#"><i class="fa fa-user-o"></i> My Account</a></li>
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

                        </div>
                        <!-- /SEARCH BAR -->

                        <!-- ACCOUNT -->
                        <div class="col-md-3 clearfix">
                            <div class="header-ctn">
                                <!-- Wishlist -->
                                <div>
                                    <a href="#">
                                        <i class="fa fa-heart-o"></i>
                                        <span>Your Wishlist</span>
                                        <div class="qty">2</div>
                                    </a>
                                </div>
                                <!-- /Wishlist -->

                                <!-- Cart -->
                                <div class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                        <i class="fa fa-shopping-cart"></i>
                                        <span>Your Cart</span>
                                        <div class="qty">3</div>
                                    </a>
                                    <div class="cart-dropdown">
                                        <div class="cart-list">
                                            <div class="product-widget">
                                                <div class="product-img">
                                                    <img src="./img/product01.png" alt="">
                                                </div>
                                                <div class="product-body">
                                                    <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                                    <h4 class="product-price"><span class="qty">1x</span>$980.00</h4>
                                                </div>
                                                <button class="delete"><i class="fa fa-close"></i></button>
                                            </div>

                                            <div class="product-widget">
                                                <div class="product-img">
                                                    <img src="./img/product02.png" alt="">
                                                </div>
                                                <div class="product-body">
                                                    <h3 class="product-name"><a href="#">product name goes here</a></h3>
                                                    <h4 class="product-price"><span class="qty">3x</span>$980.00</h4>
                                                </div>
                                                <button class="delete"><i class="fa fa-close"></i></button>
                                            </div>
                                        </div>
                                        <div class="cart-summary">
                                            <small>3 Item(s) selected</small>
                                            <h5>SUBTOTAL: $2940.00</h5>
                                        </div>
                                        <div class="cart-btns">
                                            <a href="#">View Cart</a>
                                            <a href="#">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
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
                            <li><a href="${o.categoryName.toLowerCase()}" value="${o.categoryName}">${o.categoryName}</a></li>
                            </c:forEach>

                        <li><a href="laptops">Laptops</a></li>

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
                <div class="row">
                    <ul class="nav nav-pills bg-nav-pills nav-justified mb-3">
                        <li class="nav-item">
                            <a href="#billing-information" data-toggle="tab" aria-expanded="false" class="nav-link rounded-0 tab-page" id="tab-wait">
                                <i class="mdi mdi-account-circle font-18"></i>
                                <span class="d-none d-lg-block">Wait To Accept</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="#shipping-information" data-toggle="tab" aria-expanded="true" class="nav-link rounded-0 tab-page" id="tab-shipping">
                                <i class="mdi mdi-truck-fast font-18"></i>
                                <span class="d-none d-lg-block">Shipping</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="#payment-information" data-toggle="tab" aria-expanded="false" class="nav-link rounded-0 tab-page" id="tab-shipped">
                                <i class="mdi mdi-cash-multiple font-18"></i>
                                <span class="d-none d-lg-block">Shipped</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="#payment-information" data-toggle="tab" aria-expanded="false" class="nav-link rounded-0 tab-page" id="tab-canceled">
                                <i class="mdi mdi-cash-multiple font-18"></i>
                                <span class="d-none d-lg-block">Canceled</span>
                            </a>
                        </li>
                    </ul>
                </div>
                <%
                    Locale vn = new Locale("vi", "VN");
                    // Create a formatter given the Locale
                    NumberFormat vnFormat = NumberFormat.getCurrencyInstance(vn);
                %>
                <!-- row wait -->
                <div class="row" id="div-wait">
                    
                    <%
                        Vector<Order> listWait = (Vector<Order>) request.getAttribute("listWait");
                        if (!listWait.isEmpty()) {
                    %>
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-centered mb-0">
                                        <thead class="thead-light">
                                            <tr>
                                                <th>Order ID</th>
                                                <th>Date</th>
                                                <th>Total</th>
                                                <th>Order Status</th>
                                                <th>X</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Order o : listWait) {%>
                                            <tr>
                                                <td><a href="apps-ecommerce-orders-details.html" class="text-body font-weight-bold">#<%= o.getID()%></a> </td>
                                                <td>
                                                    <%= o.getOrderDate()%> 
                                                    <!--                                                    <small class="text-muted">10:29 PM</small>-->
                                                </td>
                                                <td>

                                                    <%= vnFormat.format(o.getTotalPrice())%>
                                                </td>
                                                <td>
                                                    <h5><span class="badge badge-info-lighten"><%= o.getStatus()%></span></h5>
                                                </td>
                                                </td>
                                                <td>
                                                    <a href="#" data-id="<%= o.getID()%>" class="btn btn-danger btnCancel">Cancel</a>
                                                </td>

                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div> <!-- end card-body-->
                        </div> <!-- end card-->
                    </div> 
                    <!-- end col -->
                    <%

                    } else {%>
                    <h4>List Wait Accept Empty</h4>
                    <%}%>
                </div>
                <!-- /row wait -->
                
                <!-- row shipping-->
                <div class="row" id="div-shipping">
                    <%
                        Vector<Order> listShipping = (Vector<Order>) request.getAttribute("listShipping");
                        if (!listShipping.isEmpty()) {
                    %>
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-centered mb-0">
                                        <thead class="thead-light">
                                            <tr>
                                                <th>Order ID</th>
                                                <th>Date</th>
                                                <th>Total</th>
                                                <th>Order Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Order o : listShipping) {%>
                                            <tr>
                                                <td><a href="apps-ecommerce-orders-details.html" class="text-body font-weight-bold">#<%= o.getID()%></a> </td>
                                                <td>
                                                    <%= o.getOrderDate()%> 
                                                    <!--                                                    <small class="text-muted">10:29 PM</small>-->
                                                </td>
                                                <td>

                                                    <%= vnFormat.format(o.getTotalPrice())%>
                                                </td>
                                                <td>
                                                    <h5><span class="badge badge-info-lighten"><%= o.getStatus()%></span></h5>
                                                </td>
                                                </td>

                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div> <!-- end card-body-->
                        </div> <!-- end card-->
                    </div> 
                    <!-- end col -->
                    <%

                    } else {%>
                    <h4>List Empty</h4>
                    <%}%>
                </div>
                <!-- /row -->
                
                <!-- row -->
                <div class="row" id="div-shipped">
                    
                    <%
                        Vector<Order> listShipped = (Vector<Order>) request.getAttribute("listShipped");
                        if (!listShipped.isEmpty()) {
                    %>
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-centered mb-0">
                                        <thead class="thead-light">
                                            <tr>
                                                <th>Order ID</th>
                                                <th>Date</th>
                                                <th>Total</th>
                                                <th>Order Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Order o : listShipped) {%>
                                            <tr>
                                                <td><a href="apps-ecommerce-orders-details.html" class="text-body font-weight-bold">#<%= o.getID()%></a> </td>
                                                <td>
                                                    <%= o.getOrderDate()%> 
                                                    <!--                                                    <small class="text-muted">10:29 PM</small>-->
                                                </td>
                                                <td>

                                                    <%= vnFormat.format(o.getTotalPrice())%>
                                                </td>
                                                <td>
                                                    <h5><span class="badge badge-info-lighten"><%= o.getStatus()%></span></h5>
                                                </td>
                                                </td>

                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div> <!-- end card-body-->
                        </div> <!-- end card-->
                    </div> 
                    <!-- end col -->
                    <%

                    } else {%>
                    <h4>List Empty</h4>
                    <%}%>
                </div>
                <!-- /row -->
                
                <!-- row canceled -->
                <div class="row" id="div-canceled">
                    
                    <%
                        Vector<Order> listCanceled = (Vector<Order>) request.getAttribute("listCanceled");
                        if (!listCanceled.isEmpty()) {
                    %>
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-centered mb-0">
                                        <thead class="thead-light">
                                            <tr>
                                                <th>Order ID</th>
                                                <th>Date</th>
                                                <th>Total</th>
                                                <th>Order Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Order o : listCanceled) {%>
                                            <tr>
                                                <td><a href="apps-ecommerce-orders-details.html" class="text-body font-weight-bold">#<%= o.getID()%></a> </td>
                                                <td>
                                                    <%= o.getOrderDate()%> 
                                                    <!--                                                    <small class="text-muted">10:29 PM</small>-->
                                                </td>
                                                <td>

                                                    <%= vnFormat.format(o.getTotalPrice())%>
                                                </td>
                                                <td>
                                                    <h5><span class="badge badge-info-lighten"><%= o.getStatus()%></span></h5>
                                                </td>
                                                </td>

                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div> <!-- end card-body-->
                        </div> <!-- end card-->
                    </div> 
                    <!-- end col -->
                    <%

                    } else {%>
                    <h4>List Empty</h4>
                    <%}%>
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
                                    <li><a href="#"><i class="fa fa-map-marker"></i>1734 Stonecoal Road</a></li>
                                    <li><a href="#"><i class="fa fa-phone"></i>+021-95-51-84</a></li>
                                    <li><a href="#"><i class="fa fa-envelope-o"></i>email@email.com</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Categories</h3>
                                <ul class="footer-links">
                                    <li><a href="#">Hot deals</a></li>
                                    <li><a href="#">Laptops</a></li>
                                    <li><a href="#">Smartphones</a></li>
                                    <li><a href="#">Cameras</a></li>
                                    <li><a href="#">Accessories</a></li>
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
                                    <li><a href="#">Terms &amp; Conditions</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-md-3 col-xs-6">
                            <div class="footer">
                                <h3 class="footer-title">Service</h3>
                                <ul class="footer-links">
                                    <li><a href="#">My Account</a></li>
                                    <li><a href="#">View Cart</a></li>
                                    <li><a href="#">Wishlist</a></li>
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
                                <a target="_blank" href="https://www.templateshub.net">Templates Hub</a>
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
        <script type="text/javascript">
            $(document).ready(function () {
                $('.btnCancel').click(function (event) {
                    event.preventDefault();
                    let btn = $(this);
                    let order_id = btn.data('id');
                    if (confirm('Are you sure you want to cancel this?')) {
                        console.log(1);
                        $.ajax({
                            url: '/Laptop-shop/order?s=Process Cancel',
                            type: "POST",
                            data: {
                                order_id: order_id
                            },
                        })
                                .done(function () {
                                    btn.parents('tr').remove();
                                })
                                .fail(function (error) {
                                    alert(error['statusText']);
                                })

                    }
                });
                
                
                $("#tab-wait").parents('li').addClass('active');
                $("#div-wait").show();
                $("#div-shipping").hide();
                $("#div-shipped").hide();
                $("#div-canceled").hide();
                

                $(".tab-page").click(function(){
                      let idthis= $(this).attr('id');
                  //let idthis = this.data('id');
                  if(idthis == 'tab-wait'){
                      $("#div-wait").show();
                      $("#div-shipping").hide();
                      $("#div-shipped").hide();
                      $("#div-canceled").hide();
                      
                  }else if(idthis == 'tab-shipping'){
                      $("#div-wait").hide();
                      $("#div-shipping").show();
                      $("#div-shipped").hide();
                      $("#div-canceled").hide();
                  }else if(idthis == 'tab-shipped'){
                      $("#div-wait").hide();
                      $("#div-shipping").hide();
                      $("#div-shipped").show();
                      $("#div-canceled").hide();
                  }
                  else{
                      $("#div-wait").hide();
                      $("#div-shipping").hide();
                      $("#div-shipped").hide();
                      $("#div-canceled").show();
                  }

                  });
            });
        </script>


    </body></html>