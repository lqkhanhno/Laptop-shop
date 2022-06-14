<%-- 
    Document   : checkout
    Created on : Jun 5, 2022, 2:31:22 PM
    Author     : LAPTOP VINH HA
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
        <meta charset="utf-8">
        <title>Checkout | Hyper - Responsive Bootstrap 4 Admin Dashboard</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description">
        <meta content="Coderthemes" name="author">
        <!-- App favicon -->
        <link rel="shortcut icon" href="assets/images/favicon.ico">

        <!-- App css -->
        <link href="assets/css/icons.min.css" rel="stylesheet" type="text/css">
        <link href="assets/css/app-creative.min.css" rel="stylesheet" type="text/css" id="light-style">

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

                                
            
                                
    
                                <li class="dropdown notification-list">
                                    <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" id="topbar-notifydrop" role="button" aria-haspopup="true" aria-expanded="false">
                                        <i class="dripicons-bell noti-icon"></i>
                                        <span class="noti-icon-badge"></span>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right dropdown-menu-animated dropdown-lg" aria-labelledby="topbar-notifydrop">
    
                                        <!-- item-->
                                        <div class="dropdown-item noti-title">
                                            <h5 class="m-0">
                                                <span class="float-right">
                                                    <a href="javascript: void(0);" class="text-dark">
                                                        <small>Clear All</small>
                                                    </a>
                                                </span>Notification
                                            </h5>
                                        </div>
    
                                        <div style="max-height: 230px;" data-simplebar="init"><div class="simplebar-wrapper" style="margin: 0px;"><div class="simplebar-height-auto-observer-wrapper"><div class="simplebar-height-auto-observer"></div></div><div class="simplebar-mask"><div class="simplebar-offset" style="right: 0px; bottom: 0px;"><div class="simplebar-content-wrapper" style="height: auto; overflow: hidden;"><div class="simplebar-content" style="padding: 0px;">
                                            <!-- item-->
                                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                                <div class="notify-icon bg-primary">
                                                    <i class="mdi mdi-comment-account-outline"></i>
                                                </div>
                                                <p class="notify-details">Caleb Flakelar commented on Admin
                                                    <small class="text-muted">1 min ago</small>
                                                </p>
                                            </a>
    
                                            <!-- item-->
                                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                                <div class="notify-icon bg-info">
                                                    <i class="mdi mdi-account-plus"></i>
                                                </div>
                                                <p class="notify-details">New user registered.
                                                    <small class="text-muted">5 hours ago</small>
                                                </p>
                                            </a>
    
                                            <!-- item-->
                                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                                <div class="notify-icon">
                                                    <img src="assets/images/users/avatar-2.jpg" class="img-fluid rounded-circle" alt=""> </div>
                                                <p class="notify-details">Cristina Pride</p>
                                                <p class="text-muted mb-0 user-msg">
                                                    <small>Hi, How are you? What about our next meeting</small>
                                                </p>
                                            </a>
    
                                            <!-- item-->
                                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                                <div class="notify-icon bg-primary">
                                                    <i class="mdi mdi-comment-account-outline"></i>
                                                </div>
                                                <p class="notify-details">Caleb Flakelar commented on Admin
                                                    <small class="text-muted">4 days ago</small>
                                                </p>
                                            </a>
    
                                            <!-- item-->
                                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                                <div class="notify-icon">
                                                    <img src="assets/images/users/avatar-4.jpg" class="img-fluid rounded-circle" alt=""> </div>
                                                <p class="notify-details">Karen Robinson</p>
                                                <p class="text-muted mb-0 user-msg">
                                                    <small>Wow ! this admin looks good and awesome design</small>
                                                </p>
                                            </a>
    
                                            <!-- item-->
                                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                                <div class="notify-icon bg-info">
                                                    <i class="mdi mdi-heart"></i>
                                                </div>
                                                <p class="notify-details">Carlos Crouch liked
                                                    <b>Admin</b>
                                                    <small class="text-muted">13 days ago</small>
                                                </p>
                                            </a>
                                        </div></div></div></div><div class="simplebar-placeholder" style="width: 0px; height: 0px;"></div></div><div class="simplebar-track simplebar-horizontal" style="visibility: hidden;"><div class="simplebar-scrollbar" style="width: 0px; display: none;"></div></div><div class="simplebar-track simplebar-vertical" style="visibility: hidden;"><div class="simplebar-scrollbar" style="height: 0px; display: none;"></div></div></div>
    
                                        <!-- All-->
                                        <a href="javascript:void(0);" class="dropdown-item text-center text-primary notify-item notify-all">
                                            View All
                                        </a>
    
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
                            
                            
                        </div>
                    </div>
                    <!-- end Topbar -->

                    

                    
                    <!-- Start Content-->
                    <div class="container-fluid">

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
                                                            User u = (User)request.getAttribute("in4User");
                                                        %>
                                                        <form method="POST" action="checkout?s=processCheckOut">
                                                            <div class="row">
                                                                <div class="col-md-12">
                                                                    <div class="form-group">
                                                                        <label for="billing-last-name">Full Name</label>
                                                                        <input class="form-control" type="text" name="fullname" value="<%= u.getFullname() %>" placeholder="Enter your last name" id="billing-last-name">
                                                                    </div>
                                                                </div>
                                                            </div> <!-- end row -->
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <label for="billing-email-address">Email Address <span class="text-danger">*</span></label>
                                                                        <input class="form-control" type="email" name="email" value="<%= u.getEmail() %>" placeholder="Enter your email" id="billing-email-address">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group">
                                                                        <label for="billing-phone">Phone <span class="text-danger">*</span></label>
                                                                        <input class="form-control" type="text" name="phone" value="<%= u.getPhoneNumber() %>" placeholder="(xx) xxx xxxx xxx" id="billing-phone">
                                                                    </div>
                                                                </div>
                                                            </div> <!-- end row -->
                                                            <div class="row">
                                                                <div class="col-12">
                                                                    <div class="form-group">
                                                                        <label for="billing-address">Address</label>
                                                                        <input class="form-control" type="text" name="address" value="<%= u.getUserAddress() %>" placeholder="Enter full address" id="billing-address">
                                                                    </div>
                                                                </div>
                                                            </div> <!-- end row -->
                                                            <div class="row">
                                                                <div class="col-12">
                                                                    
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
                                                                            HashMap<String, HashMap<String,String>>listPro = 
                                                                                    (HashMap<String, HashMap<String,String>>)request.getAttribute("listProduct");
                                                                            Set<String> keySet = listPro.keySet();
                                                                            HashMap<String, String> order_Summary = listPro.get("order_summary");
                                                                            for(Object key: keySet){
                                                                                if(key.toString() != "order_summary"){
                                                                                    HashMap<String, String> infoProduct = listPro.get(key);
                                                                                
                                                                        %>
                                                                        <tr>
                                                                            <td>
                                                                                <img src="img/Laptop/<%= infoProduct.get("image") %>" alt="contact-img" title="contact-img" class="rounded mr-2" height="48">
                                                                                <p class="m-0 d-inline-block align-middle">
                                                                                    <a href="apps-ecommerce-products-details.html" class="text-body font-weight-semibold"><%= infoProduct.get("name") %></a>
                                                                                    <br>
                                                                                    <small><%= infoProduct.get("quantity") %> x <%= infoProduct.get("price") %> VND</small>
                                                                                </p>
                                                                            </td>
                                                                            <td class="text-right">
                                                                                <%= order_Summary.get(key) %>
                                                                            </td>
                                                                        </tr>
                                                                        
                                                                        <%}}%>
                                                                        <tr class="text-right">
                                                                            <td>
                                                                                <h6 class="m-0">Grand Total:</h6>
                                                                            </td>
                                                                            <td class="text-right">
                                                                                <%= order_Summary.get("totalGrand") %> VND
                                                                            </td>
                                                                        </tr>
                                                                        <tr class="text-right">
                                                                            <td>
                                                                                <h6 class="m-0">Discount:</h6>
                                                                            </td>
                                                                            <td class="text-right">
                                                                                - <%= order_Summary.get("discount") %> VND
                                                                            </td>
                                                                        </tr>
                                                                        <tr class="text-right">
                                                                            <td>
                                                                                <h5 class="m-0">Total:</h5>
                                                                            </td>
                                                                            <td class="text-right font-weight-semibold">
                                                                                <%= order_Summary.get("totalCart") %> VND
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
        <script>
            function submitForm(){
                document.getElementById("form-checkout").submit();
            }
        </script>
        <script src="assets/js/vendor.min.js"></script>
        <script src="assets/js/app.min.js"></script>
        
    
</body>
</html>
