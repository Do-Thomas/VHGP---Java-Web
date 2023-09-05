<%-- 
    Document   : TestList
    Created on : May 25, 2023, 8:58:27 PM
    Author     : Asus
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Category"%>
<%@page import="model.Services"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Homepage</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Untree.co">
    <link rel="shortcut icon" href="favicon.png">

    <meta name="description" content="" />
    <meta name="keywords" content="bootstrap, bootstrap5" />

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">


    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="css/tiny-slider.css">
    <link rel="stylesheet" href="css/aos.css">
    <link rel="stylesheet" href="css/style.css">

    <style>
        /*Màu thanh menu*/
        .logo{
            /*            color: rgb(250 228 54 / 80%) !important;*/
        }
        /*        .btn.btn-primary {
                    color: #c6be0c;
                }*/
        .site-nav .site-navigation .site-menu > li.active a {
            /*            color: #c6be0c;*/
            font-weight: bold;
        }

        .site-nav .site-navigation .site-menu > li > a{
            /*            color: #c6be0c;*/
            font-weight: bold;
        }

        /*2 dấu down-top profile*/
        .site-nav .site-navigation .site-menu .has-children > a:before{
            color: #fff;
        }
        .dropdown-toggle::after {
            color: #fff;
        }
        /*Icon profile*/
        .user-action{
            color: #fff;
        }

        .menu-bg-wrap{
            background:  rgb(5 72 19);
        }
        /*        rgba(10,50,30,0.95)*/
        .btn.btn-primary{
            background: rgb(5 72 19);
        }
        .gg{
            padding-left:20px ;
            padding-bottom: 10px;
            padding-right: 20px;
            padding-top: 10px ; 
            border-radius: 10px;
            margin-top: 10px;
        }
        .box{
            margin-top: 100px;
            text-align: right;
        }
        .se{
            color: white;
            border-radius: 10px;
            padding: 10px;
            color: #1B9C85;
            border-radius: 40px;
        }
        body{
            /*    margin: 20px; 
                padding: 0;
                background: white;
                height: 100vh;
                display: flex;
                justify-content: space-evenly;/*
                align-items: center;
                flex-direction: column;*/
            align-items: center;
            align-content: center;
        }
        .box{
            position: relative;
        }

        .input {
            padding: 10px;
            width: 80px;
            height: 80px;
            background: none;
            border: 4px solid #ffd52d;
            border-radius: 50px;
            box-sizing: border-box;
            font-family: Comic Sans MS;
            font-size: 26px;
            color: #ffd52d;
            outline: none;
            transition: .5s;
        }
        .box i{
            position: absolute;
            top: 50%;
            right: 15px;
            transform: translate(-50%,-50%);
            font-size: 26px;
            color: #ffd52d;
            transition: .2s;
        }
        .row{
            display: flex;
        }
        .form-control{
            width: 80%;
        }
        .search{
            padding-right: 40px;
        }
        .cart-img{
            width: 40px;
            height: 40px;
        }
        .hero, .hero > .container > .row{
            height: 50vh;
        }
        .footer{
            background:rgba(10,50,30,0.95);
            color: #c6be0c;
            text-align: center; 
            padding: 40px 10px;
            font-size: 15px;
        }
        .row-flex {
            display: flex;
            flex-wrap: wrap;
        }

         /* NOTIFICATION*/

        .dropdown2 {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        .dropdown2 li {
            margin-bottom: 10px;
        }

        .dropdown2 li p {
            margin: 0;
            padding: 5px;
            background-color: #f2f2f2;
            border: 1px solid #ccc;
            font-size: 14px;
        }

        .dropdown2 li p.nomargin {
            margin: 0;
            align-items: center;
        }

        .dropdown2 li p:nth-child(odd) {
            background-color: #fff;
        }

        .dropdown2 li p:nth-child(even) {
            background-color: #f9f9f9;
        }

        .dropdown2 li p:nth-child(2) {
            color: green;
        }

        .dropdown2 li p:nth-child(3) {
            color: red;
        }
        .dropdown2 {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        .dropdown2 li {
            margin-bottom: 10px;
        }

        .dropdown2 li p {
            margin: 0;
            padding: 10px;
            background-color: #f2f2f2;
            border: 1px solid #ccc;
            font-size: 14px;
        }

        .dropdown2 li p.nomargin {
            margin: 0;
            align-items: center;
        }

        .dropdown2 li p:nth-child(odd) {
            background-color: #f9f9f9;
        }

        .dropdown2 li p:nth-child(even) {
            background-color: #f2f2f2;
        }

        .dropdown2 li p:nth-child(2) {
            color: green;
            font-weight: bold;
        }

        .dropdown2 li p:nth-child(3) {
            color: red;
            font-weight: bold;
        }

        .dropdown2 li p:before {
            content: "\2714";
            display: inline-block;
            margin-right: 5px;
            color: green;
            font-size: 12px;
            font-weight: bold;
        }

        .dropdown2 li p:nth-child(3):before {
            content: "\2718";
            color: red;
        }
    </style>
</head>
<body>
    <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.role.roleID != 'user'}">
        <c:redirect url="login.jsp">

        </c:redirect>
    </c:if>

    <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close">
                <span class="icofont-close js-menu-toggle"></span>
            </div>
        </div>
        <div class="site-mobile-menu-body"></div>
    </div>


    <nav class="site-nav">
        <div class="container">
            <div class="menu-bg-wrap">
                <div class="site-navigation">

                    <a href="" class="logo m-0 float-start">Services</a>

                    <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end">
                        <li class="active"><a href="IndexServices">Home</a></li>
                        <li class="has-children">
                            <a href="listServices.jsp">Category</a>
                            <ul class="dropdown">
                                <li><a href="MainController?action=Show&id=1">Dọn dẹp</a></li>
                            </ul>
                        </li>
<!--                        <li><a href="listServices.jsp">Support</a></li>
                        <li><a href="listServices.jsp">About</a></li>
                        <li><a href="listServices.jsp">Contact Us</a></li>-->

                        <c:set var="name" value="${LOGIN_USER.customerName}" />
                        <c:if test="${not empty name}">
                            <li class="dropdown">
                            <li class="has-children">
                                <a href="#" data-toggle="dropdown" class="user-action dropdown-toggle"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class=" user-action bi bi-person-circle" viewBox="0 0 16 16">
                                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                    </svg>  <b class="user-action caret"> ${LOGIN_USER.customerName} </b></a>

                                <ul class="dropdown" style="width: 30vh;">
                                    <li><a href="ViewCustomer">Profile</a></li>
                                    <li><a href="MainController?action=History&status=1">Lịch sử</a></li>
                                    <li><a href="ConfirmBillCustomerController">Hóa đơn</a></li>
                                    <li><a href="LogoutController">Logout</a></li>
                                </ul>
                            </li> 
                            <li class="has-children">
                                <a href="MainController?action=Notification" >
                                    <b class="user-action caret">🔔</b>
                                </a>
                                <ul class="dropdown dropdown2">
                                    <c:if test="${requestScope.CONFIRM != null}">
                                        <c:if test="${not empty requestScope.CONFIRM}">
                                            <c:forEach items="${requestScope.CONFIRM}" var="c" varStatus="counter">
                                                <li><p>Đơn hàng ${c.status.orderDetail.orderDServiceName} ĐÃ THANH TOÁN</p></li>                                             
                                                </c:forEach>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${requestScope.NOTIFICATION != null}">
                                            <c:if test="${not empty requestScope.NOTIFICATION}">
                                                <c:forEach items="${requestScope.NOTIFICATION}" var="pro" varStatus="counter">
                                                <li>
                                                    <c:set var="StatusOrder" value="${pro.status}" />
                                                    <c:choose>
                                                        <c:when test="${StatusOrder eq 'Hoạt động'}">
                                                            <p class="nomargin" style="align-items: center">
                                                                Đơn hàng ${pro.orderDServiceName} vào lúc <fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${pro.timeStart}"/> đã được đặt
                                                            </p>
                                                        </c:when>
                                                        <c:when test="${StatusOrder eq 'Hoàn thành'}">
                                                            <p class="nomargin" style="align-items: center">
                                                                Đơn hàng ${pro.orderDServiceName} vào lúc <fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${pro.timeStart}"/> đã hoàn tất
                                                            </p>
                                                        </c:when>
                                                        <c:when test="${StatusOrder eq 'Tạm dừng'}">
                                                            <p class="nomargin" style="align-items: center">
                                                                <img src="https://icon-library.com/images/completed-icon/completed-icon-6.jpg">
                                                                Đơn hàng ${pro.orderDServiceName} vào lúc <fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${pro.timeStart}"/> đã hủy
                                                            </p>
                                                        </c:when>
                                                    </c:choose>
                                                </li>
                                            </c:forEach>
                                        </c:if>
                                    </c:if>

                                </ul>
                            </li>
                            <a class="se justify-content-right" href="ViewCart.jsp" > 
                                <img style="width:40px; height: 40px" src="https://icon-library.com/images/white-shopping-cart-icon/white-shopping-cart-icon-9.jpg " alt="se" style="width:20px;height:20px" /></br>
                            </a>
                        </c:if>                    
                        </li>
                    </ul>


                    <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                        <span></span>
                    </a>

                </div>
            </div>
        </div>
    </nav>

    <div class="hero">
        <div class="hero-slide">
            <div class="img overlay tns-item img-banner" style="background-image: url('image/banner5.jpg'); height:50%"></div>
            <div class="img overlay tns-item img-banner" style="background-image: url('image/banner6.jpg'); height:50%"></div>
            <div class="img overlay tns-item img-banner" style="background-image: url('image/banner7.jpg'); height:50%"></div>
        </div>

        <div class="container">
            <div class="row justify-content-center align-items-center">
                <div class="col-lg-9 text-center">

                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="box row  ">
            <div class="col-lg-9 text-center">
                <form action="MainController" class="narrow-w form-search d-flex align-items-stretch mb-3 justify-content-center align-items-center" >
                    <input class=" form-search form-control px-4" type="text" name="searchName" placeholder="search..." value="${param.searchName}" />
                    <input type="submit" class="btn btn-primary search" name="action" value="search"/>  
                </form>
                <!--                <i class="fas fa-search"></i>-->
            </div>
            <div class="col-lg-3 justify-content-right" style="display:flex;padding-bottom: 20px">   
                <a class="se justify-content-left"></a>

            </div>        
        </div>
        <div class="row align-items-center">
            <div class="col-lg-6">
                <h2 class="font-weight-bold text-primary heading">Dịch vụ nổi bật</h2>
            </div>
            <div class="col-lg-6 text-lg-end">
                <p><a href="ListAllServices" class="btn btn-primary  py-3 px-4">Xem tất cả dịch vụ</a></p>
            </div>
        </div>

    </div>


<!--    <a>${requestScope.MESSAGE}</a>-->

    <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close">
                <span class="icofont-close js-menu-toggle"></span>
            </div>
        </div>
        <div class="site-mobile-menu-body"></div>
    </div>

    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <c:if test="${requestScope.TOP_SERVICES != null}">
        <c:if test="${ not empty requestScope.TOP_SERVICES}">                                
            <div class="row">
                <c:forEach items="${requestScope.TOP_SERVICES}" var="s" varStatus="counter">
                    <div class="col-lg-4 mb-3 d-flex align-items-stretch">
                        <div class="property-item mb-30">
                            <div class="property-item">
                                <center>
                                    <a href="" class="img">
                                        <img src="image/${s.servicePicture}" width="100%" height="400" alt="Image" class="img-fluid">
                                    </a>
                                </center>
                                <div class="property-content">
                                    <div>
                                        <span class="city d-block mb-3">${s.serviceName}</span>
                                        <b class="city d-block mb-3 text-black-50">${s.serviceDetail}</b>
                                        <a href="MainController?id=${s.serviceName}&action=Detail" class="btn btn-primary py-2 px-3 btn-details">See details</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <style>
                        .property-item{
                            padding-left: 20px;
                            padding-right: 10px;
                            padding-bottom: 20px;
                            padding-top: 20px;
                        }
                        .img-fluid{
                            padding-left: 20px;
                            padding-right: 20px;
                            display: flex;
                            max-width: 100%;
                            height: 400px; 
                            margin-top: 20px;
                            /*                                margin-right: 20%;
                                                            margin-left: 20%;*/
                            /*                                margin: 20px;*/
                        }
                    </style>
                </c:forEach>
            </c:if>
        </c:if>   
    </div>

    <div class="row justify-content-between mb-5">
        <div class="col-lg-6 mb-5 mb-lg-0 order-lg-2">
            <div class="img-about ">
                <img src="image/phongkhach.jpg" alt="Image" class="img-fluid">
            </div>
        </div>
        <div class="col-lg-6" style="padding-left: 250px">
            <div class="d-flex feature-h">
                <span class="wrap-icon me-3">
                    <span class="icon-home2"></span>
                </span>
                <div class="feature-text">
                    <h3 class="heading">Cam kết chất lượng</h3>
                    <p class="text-black-50">- Kỹ năng chuyên môn</p>
                    <p class="text-black-50">- Công cụ - dụng cụ - thiết bị</p>
                    <p class="text-black-50"> - Làm tỉ mỉ, tận tình</p>   
                </div>
            </div>

            <div class="d-flex feature-h">
                <span class="wrap-icon me-3">
                    <span class="icon-person"></span>
                </span>
                <div class="feature-text">
                    <h3 class="heading">Đúng hẹn</h3>
                    <p class="text-black-50">Chúng tôi luôn nỗ lực để đúng hẹn nhất với khách hàng</p>   
                </div>
            </div>

            <div class="d-flex feature-h">
                <span class="wrap-icon me-3">
                    <span class="icon-security"></span>
                </span>
                <div class="feature-text">
                    <h3 class="heading">Chuyên nghiệp</h3>
                    <p class="text-black-50">- Trung thực</p>
                    <p class="text-black-50">- Minh bạch</p>   
                </div>
            </div>
        </div>
    </div>

    <div class="footer">
        <b>Dịch vụ vệ sinh nhà cửa VinHome Grand Park</b></br>
        <b>Nguyễn Xiển, phường Long Thạnh Mỹ, Tp.Thủ Đức, TPHCM.</b></br>
        <a href='https://www.facebook.com/'><img style="width:40px; height: 40px; margin: 15px 0" src="image/icon/fb.png"></a>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/tiny-slider.js"></script>
    <script src="js/aos.js"></script>
    <script src="js/navbar.js"></script>
    <script src="js/counter.js"></script>
    <script src="js/custom.js"></script>
</body>
</html>
<!--<div class="item">
    <img src="http://img.tjskl.org.cn/pic/z2577d9d-200x200-1/pinarello_lungavita_2010_single_speed_bike.jpg" alt="item" />-->
