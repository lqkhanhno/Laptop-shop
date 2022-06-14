<%-- 
    Document   : master
    Created on : May 30, 2022, 4:02:06 PM
    Author     : LAPTOP VINH HA
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
        <meta charset="utf-8">
        <title>Shopping Cart | Hyper - Responsive Bootstrap 4 Admin Dashboard</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description">
        <meta content="Coderthemes" name="author">
        <!-- App favicon -->
        <link rel="shortcut icon" href="assets/images/favicon.ico">

        <!-- App css -->
        <link href="assets/css/icons.min.css" rel="stylesheet" type="text/css">
        <link href="assets/css/app-creative.min.css" rel="stylesheet" type="text/css" id="light-style">
        <link href="assets/css/app-creative-dark.min.css" rel="stylesheet" type="text/css" id="dark-style" disabled="disabled">

    </head>

    <body class="" data-layout="topnav" data-layout-config="{&quot;layoutBoxed&quot;:false,&quot;darkMode&quot;:false,&quot;showRightSidebarOnStart&quot;: true}">
        <!-- Begin page -->
        <div class="wrapper">

            <!-- ============================================================== -->
            <!-- Start Page Content here -->
            <!-- ============================================================== -->

            <div class="content-page">
                <div class="content">
                    <!-- Topbar Start -->
                    <div class="navbar-custom topnav-navbar topnav-navbar-dark">
                        <div class="container-fluid">

                            <!-- LOGO -->
                            <a href="" class="topnav-logo">
                                <span class="topnav-logo-lg">
                                    <img src="assets/images/logo-light.png" alt="" height="16">
                                </span>
                                <span class="topnav-logo-sm">
                                    <img src="assets/images/logo_sm_dark.png" alt="" height="16">
                                </span>
                            </a>

                            <ul class="list-unstyled topbar-right-menu float-right mb-0">

                                <li class="dropdown notification-list d-lg-none">
                                    <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                                        <i class="dripicons-search noti-icon"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-animated dropdown-lg p-0">
                                        <form class="p-3">
                                            <input type="text" class="form-control" placeholder="Search ..." aria-label="Recipient's username">
                                        </form>
                                    </div>
                                </li>
            
                                <li class="dropdown notification-list">
                                    <a class="nav-link dropdown-toggle nav-user arrow-none mr-0" data-toggle="dropdown" id="topbar-userdrop" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                        <span class="account-user-avatar"> 
                                            <img src="assets/images/users/avatar-1.jpg" alt="user-image" class="rounded-circle">
                                        </span>
                                        <span>
                                            <span class="account-user-name">Dominic Keller</span>
                                            <span class="account-position">Founder</span>
                                        </span>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right dropdown-menu-animated topbar-dropdown-menu profile-dropdown" aria-labelledby="topbar-userdrop">
                                        <!-- item-->
                                        <div class=" dropdown-header noti-title">
                                            <h6 class="text-overflow m-0">Welcome !</h6>
                                        </div>
    
                                        <!-- item-->
                                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                                            <i class="mdi mdi-account-circle mr-1"></i>
                                            <span>My Account</span>
                                        </a>
    
                                        <!-- item-->
                                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                                            <i class="mdi mdi-account-edit mr-1"></i>
                                            <span>Settings</span>
                                        </a>
    
                                        <!-- item-->
                                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                                            <i class="mdi mdi-lifebuoy mr-1"></i>
                                            <span>Support</span>
                                        </a>
    
                                        <!-- item-->
                                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                                            <i class="mdi mdi-lock-outline mr-1"></i>
                                            <span>Lock Screen</span>
                                        </a>
    
                                        <!-- item-->
                                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                                            <i class="mdi mdi-logout mr-1"></i>
                                            <span>Logout</span>
                                        </a>
    
                                    </div>
                                </li>

                            </ul>
                            <a class="navbar-toggle" data-toggle="collapse" data-target="#topnav-menu-content">
                                <div class="lines">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </div>
                            </a>
                            
                        </div>
                    </div>
                    <!-- end Topbar -->

                    

                    
                    <!-- Start Content-->
                    <div class="container-fluid">

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
                            HashMap<String, HashMap<String,String>> listIdPro = 
                                    (HashMap<String, HashMap<String,String>>)
                                    request.getAttribute("Cart");
                            Set<String> keySet = listIdPro.keySet();
                        %>
                        
                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-body">
                                        <%
                                            if(listIdPro.size()>0){
                                            HashMap<String,String> order_Summary 
                                                    = (HashMap<String,String>)request.getAttribute("order_Summary");
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
                                                            for(Object key: keySet){
                                                                HashMap<String, String> infoProduct = listIdPro.get(key);
                                                            %>
                                                            <tr>
                                                                <td>
                                                                    <img src="img/Laptop/<%= infoProduct.get("image") %>" alt="contact-img" title="contact-img" class="rounded mr-3" height="64">
                                                                    <p class="m-0 d-inline-block align-middle font-16">
                                                                        <a href="apps-ecommerce-products-details.html" class="text-body"><%= infoProduct.get("name") %></a>
                                                                        <br>
                                                                        <small class="mr-2"><b>Size:</b> Large </small>
                                                                        <small><b>Color:</b> Light Green
                                                                        </small>
                                                                    </p>
                                                                </td>
                                                                <td>
                                                                    <%= infoProduct.get("price") %> VND
                                                                </td>
                                                                <td>
                                                                    <input type="number" min="1" value="<%= infoProduct.get("quantity") %>" class="form-control update-quantity" 
                                                                           placeholder="Qty" style="width: 90px;" 
                                                                           data-id="<%=key.toString()%>"
                                                                    >
                                                                </td>
                                                                <td class="total">
                                                                    <%= order_Summary.get(key) %> VND
                                                                </td>
                                                                <td>
                                                                    <a class="delete-product" href="cart?s=deleteProduct" class="action-icon" data-id="<%= infoProduct.get("id") %>"> 

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
                                                                    <td>Shipping Charge :</td>
                                                                    <td>$25</td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Estimated Tax : </td>
                                                                    <td>$19.22</td>
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
                                            }else{
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
                    <!-- container -->

                </div>
                <!-- content -->

                <!-- Footer Start -->
                <footer class="footer">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-6">
                                2018 - 2020 © Hyper - Coderthemes.com
                            </div>
                            <div class="col-md-6">
                                <div class="text-md-right footer-links d-none d-md-block">
                                    <a href="javascript: void(0);">About</a>
                                    <a href="javascript: void(0);">Support</a>
                                    <a href="javascript: void(0);">Contact Us</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </footer>
                <!-- end Footer -->

            </div>

            <!-- ============================================================== -->
            <!-- End Page content -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->

        <!-- bundle -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="assets/js/vendor.min.js"></script>
        <script src="assets/js/app.min.js"></script>
        <script>

            $(".update-quantity").change(function() {
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
                .done(function(response) {
                    console.log(response);
                    Object.keys(response).forEach(function (key) {                        
                       if(key == id){
                            let parent_tr=tagInput.parents('tr');
                            let total = response[key]+" VND";
                            parent_tr.find('.total').html(total);
                       }
                    });
                    $('#totalGrand').html(response['totalGrand']+" VND");
                    $('#discount').html(response['discount'+" VND"]);
                    $('#totalCart').html(response['totalCart']+" VND");
                })
                .fail(function(error) {
                    alert(error['statusText']);
                });
                
            });

            $(".delete-product").click(function(event) {
                event.preventDefault();
                let tagInput = $(this);
                let id = tagInput.data('id');
                $.ajax({
                    url: '/Laptop-shop/cart?s=deleteProduct',
                    type: 'get',
                    data: {id_product: id},
                })
                .done(function(response) {
                    console.log(response);
                    if(response['totalGrand'] != 0){
                       tagInput.parents('tr').remove();

                        $('#totalGrand').html(response['totalGrand']+" VND");
                        $('#discount').html(response['discount'+" VND"]);
                        $('#totalCart').html(response['totalCart']+" VND"); 
                    }else{
//                        console.log(12121212);
                        tagInput.parents('tr').remove();
                        document.getElementById('cart-empty').style.display = "block";
                        document.getElementById('continue-shopping').style.display = "block";
                        document.getElementById('cart-not-empty').remove();
                    }
                    
                })
                .fail(function(error) {
                    alert(error['statusText']);
                })
                
            });
            var focused = true;
            window.onfocus = function(){
                console.log("focus");
                focused = true;
            };
            window.onblur = function(){
                console.log("lost");
                $.ajax({
                    url: '/Laptop-shop/cart?s=updateDB',
                    type: 'get',
                })
                .done(function(response) {
                    console.log("updated");
                })
                focused = false;
            };
            
        </script>
    
</body></html>