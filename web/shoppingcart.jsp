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
                            <c:if test="${sessionScope.email == null}">
                            <li><a href="login.jsp"><i class="fa fa-user-o"></i> Login</a></li>
                            </c:if>

                        <c:if test="${sessionScope.email != null}">
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




        <div class="container">


            <!-- start page title -->
            <div class="row">
                <div class="col-12">
                    <div class="page-title-box">
                        <h4 class="page-title">Shopping Cart</h4>
                    </div>
                </div>
            </div>
            <!-- end page title -->
            <%
                HashMap<String, HashMap<String, String>> listIdPro
                        = (HashMap<String, HashMap<String, String>>) request.getAttribute("Cart");
                Set<String> keySet = listIdPro.keySet();
            %>

            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <%
                                if (listIdPro.size() > 0) {
                                    HashMap<String, String> order_Summary
                                            = (HashMap<String, String>) request.getAttribute("order_Summary");
                            %>
                            <div class="row" id="cart-not-empty">
                                <div class="col-lg-8 " >
                                    <div class="table-responsive">
                                        <table class="table table-borderless table-centered mb-0">
                                            <thead class="thead-light">
                                                <tr>
                                                    <th>Product</th>
                                                    <th>Price</th>
                                                    <th>Quantity</th>
                                                    <th>Total</th>
                                                    <th style="width: 50px;"></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    for (Object key : keySet) {
                                                        HashMap<String, String> infoProduct = listIdPro.get(key);
                                                %>
                                                <tr>
                                                    <td>
                                                        <img src="img/Laptop/<%= infoProduct.get("image")%>" alt="contact-img" title="contact-img" class="rounded mr-3" height="64">
                                                        <p class="m-0 d-inline-block align-middle font-16">
                                                            <a href="apps-ecommerce-products-details.html" class="text-body"><%= infoProduct.get("name")%></a>
                                                            <br>
                                                            <small class="mr-2"><b>Size:</b> Large </small>
                                                            <small><b>Color:</b> Light Green
                                                            </small>
                                                        </p>
                                                    </td>
                                                    <td>
                                                        <%= infoProduct.get("price")%> VND
                                                    </td>
                                                    <td>
                                                        <input type="number" min="1" value="<%= infoProduct.get("quantity")%>" class="form-control update-quantity" 
                                                               placeholder="Qty" style="width: 90px;" 
                                                               data-id="<%=key.toString()%>"
                                                               >
                                                    </td>
                                                    <td class="total">
                                                        <%= order_Summary.get(key)%> VND
                                                    </td>
                                                    <td>
                                                        <a class="delete-product" href="cart?s=deleteProduct" class="action-icon" data-id="<%= infoProduct.get("id")%>"> 

                                                            <i class="mdi mdi-delete"></i>
                                                        </a>
                                                    </td>
                                                </tr>
                                                <%

                                                    }
                                                %>
                                            </tbody>

                                        </table>
                                    </div> <!-- end table-responsive-->

                                    <!-- Add note input-->


                                    <!-- action buttons-->
                                    <div class="row mt-4">
                                        <div class="col-sm-6">
                                            <a href="home" class="btn text-muted d-none d-sm-inline-block btn-link font-weight-semibold">
                                                <i class="mdi mdi-arrow-left"></i> Continue Shopping </a>
                                        </div> <!-- end col -->
                                        <div class="col-sm-6">
                                            <div class="text-sm-right">
                                                <a href="checkout?s=checkOut" class="btn btn-danger">
                                                    <i class="mdi mdi-cart-plus mr-1"></i> Checkout </a>
                                            </div>
                                        </div> <!-- end col -->
                                    </div> <!-- end row-->
                                </div>
                                <!-- end col -->

                                <div class="col-lg-4">
                                    <div class="border p-3 mt-4 mt-lg-0 rounded">
                                        <h4 class="header-title mb-3">Order Summary</h4>

                                        <div class="table-responsive">
                                            <table class="table mb-0">
                                                <tbody>
                                                    <tr>
                                                        <td>Grand Total :</td>
                                                        <td id="totalGrand"><%=order_Summary.get("totalGrand")%> VND</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Discount : </td>
                                                        <td id="discount"> - <%=order_Summary.get("discount")%> VND</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Total :</th>
                                                        <th id="totalCart"><%=order_Summary.get("totalCart")%> VND</th>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- end table-responsive -->
                                    </div>





                                </div> <!-- end col -->



                            </div> <!-- end row -->
                            <p style="display: none; text-align: center;" id="cart-empty">Cart is empty. Go shopping then come back here to pay <3 </p>

                            <div class="row mt-4" id="continue-shopping" style="display: none; ">
                                <div class="col-sm-6">
                                    <a href="home" class="btn text-muted d-none d-sm-inline-block btn-link font-weight-semibold">
                                        <i class="mdi mdi-arrow-left"></i> Continue Shopping </a>
                                </div> 
                            </div>
                            <!-- end col -->

                            <%
                            } else {
                            %>
                            <p style="text-align: center" id="cart-empty">Cart is empty. Go shopping then come back here to pay <3</p>
                            <div class="row mt-4" id="continue-shopping">
                                <div class="col-sm-6">
                                    <a href="home" class="btn text-muted d-none d-sm-inline-block btn-link font-weight-semibold">
                                        <i class="mdi mdi-arrow-left"></i> Continue Shopping </a>
                                </div> 
                            </div>
                            <%}%>
                        </div> <!-- end card-body-->
                    </div> <!-- end card-->
                </div> <!-- end col -->
            </div>
            <!-- end row -->


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

    <!-- jQuery Plugins -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
                                $(".update-quantity").change(function () {
                                    let tagInput = $(this);
                                    let id = tagInput.data('id');
                                    let value = tagInput.val();
                                    console.log(id + " " + value);
                                    $.ajax({
                                        url: '/Laptop-shop/cart?s=updateQuantity',
                                        type: 'get',
                                        data: {id_product: id,
                                            quantity: value
                                        },
                                    })
                                            .done(function (response) {
                                                console.log(response);
                                                Object.keys(response).forEach(function (key) {
                                                    if (key == id) {
                                                        let parent_tr = tagInput.parents('tr');
                                                        let total = response[key] + " VND";
                                                        parent_tr.find('.total').html(total);
                                                    }
                                                });
                                                $('#totalGrand').html(response['totalGrand'] + " VND");
                                                $('#discount').html(response['discount'] + " VND");
                                                $('#totalCart').html(response['totalCart'] + " VND");
                                            })
                                            .fail(function (error) {
                                                alert(error['statusText']);
                                                if(error['statusText']=="The number of products in stock is not enough" ){
                                                    tagInput.val(1);
                                                }
                                            });

                                });
                                $(".delete-product").click(function (event) {
                                    event.preventDefault();
                                    let tagInput = $(this);
                                    let id = tagInput.data('id');
                                    $.ajax({
                                        url: '/Laptop-shop/cart?s=deleteProduct',
                                        type: 'get',
                                        data: {id_product: id},
                                    })
                                            .done(function (response) {
                                                console.log(response);
                                                if (response['totalGrand'] != 0) {
                                                    tagInput.parents('tr').remove();
                                                    $('#totalGrand').html(response['totalGrand'] + " VND");
                                                    $('#discount').html(response['discount' + " VND"]);
                                                    $('#totalCart').html(response['totalCart'] + " VND");
                                                } else {
//                        console.log(12121212);
                                                    tagInput.parents('tr').remove();
                                                    document.getElementById('cart-empty').style.display = "block";
                                                    document.getElementById('continue-shopping').style.display = "block";
                                                    document.getElementById('cart-not-empty').remove();
                                                }

                                            })
                                            .fail(function (error) {
                                                alert(error['statusText']);
                                            })

                                });
                                var focused = true;
                                window.onfocus = function () {
                                    console.log("focus");
                                    focused = true;
                                };
                                window.onblur = function () {
                                    console.log("lost");
                                    $.ajax({
                                        url: '/Laptop-shop/cart?s=updateDB',
                                        type: 'get',
                                    })
                                            .done(function (response) {
                                                console.log("updated");
                                            })
                                    focused = false;
                                };

    </script>
</body>
</html>
