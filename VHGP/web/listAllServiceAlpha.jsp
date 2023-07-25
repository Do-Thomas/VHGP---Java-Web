<%-- 
    Document   : AllServices
    Created on : Jun 3, 2023, 9:55:47 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Category"%>
<%@page import="model.Services"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách dịch vụ</title>
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
        .menu-bg-wrap{
            background: rgba(10,50,30,0.95);
        }
        .btn.btn-primary{
            background: rgba(10,50,30,0.95);
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
        .hero-slide .img {
            height:50vh;
        }
        .collection-sortby {
            margin-bottom: 20px;
        }

        .sortby-control {
            display: inline-block;
            position: relative;
        }

        .listbox__button {
            display: flex;
            align-items: center;
            justify-content: flex-end; /* Căn phải */
            padding: 5px;
            border: 1px solid #ccc;
            cursor: pointer;
        }

        .listbox__button svg {
            width: 24px;
            height: 24px;
            margin-right: 5px;
        }

        .listbox__text {
            font-size: 14px;
        }

        .listbox__value {
            margin-left: 5px;
            font-size: 14px;
            font-weight: bold;
        }

        .listbox__list-wrapper {
            position: absolute;
            top: 100%;
            left: 0;
            background-color: #fff;
            border: 1px solid #ccc;
            border-top: none;
            width: 100%;
            display: none;
        }

        .sortby-option.show-sort {
            display: block;
        }

        .listbox__list {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .listbox__item {
            padding: 5px;
        }

        .listbox__item label {
            cursor: pointer;
        }

        .listbox__item input[type="radio"] {
            display: none;
        }

        .listbox__item.active label {
            font-weight: bold;
        }

        /* Custom select dropdown style */

        .select-dropdown {
            position: relative;
            width: 100%;
        }

        .select-dropdown select {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            outline: none;
            border: none;
            background-color: transparent;
            width: 100%;
            padding: 5px;
            cursor: pointer;
        }

        .select-dropdown select::-ms-expand {
            display: none;
        }

        .select-dropdown::before {
            content: "";
            position: absolute;
            top: 50%;
            right: 10px;
            transform: translateY(-50%);
            width: 0;
            height: 0;
            border-left: 5px solid transparent;
            border-right: 5px solid transparent;
            border-top: 5px solid #ccc;
            pointer-events: none;
        }

        .select-dropdown::after {
            content: "";
            position: absolute;
            top: 50%;
            right: 6px;
            transform: translateY(-50%);
            width: 0;
            height: 0;
            border-left: 4px solid transparent;
            border-right: 4px solid transparent;
            border-top: 4px solid #000;
            pointer-events: none;
        }

    </style>
</head>
<body>


<!--    ${requestScope.MESSAGE}</a>-->

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
                                <li><a href="MainController?action=ShowHome&id=1">Dọn dẹp</a></li>

                            </ul>
                        </li>
                        <li><a href="listServices.jsp">About</a></li>
                        <li><a href="listServices.jsp">Contact Us</a></li>
                            <c:set var="name" value="${LOGIN_USER.customerName}" />
                            <c:if test="${not empty name}">

                            <li class="has-children">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                    </svg>  <b class="caret"> ${LOGIN_USER.customerName} </b></a>
                                <ul class="dropdown">
                                    <li><a href="#">Profile</a></li>
                                    <li><a href="#">Setting</a></li>
                                    <li><a href="MainController?action=History&status=1">Lịch sử</a></li>
                                    <li><a href="LogoutController">Logout</a></li>

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

    <div class="hero"  height="50vh">
        <div class="hero-slide">
            <div class="img overlay tns-item " style="background-image: url('image/banner3.jpg');"></div>
        </div>

        <div class="container">
            <div class="row justify-content-center align-items-center">
                <div class="col-lg-9 text-center">

                </div>
            </div>
        </div>
    </div>
    <div class="drop">                       
        <div class="dropdown">
            <div class="listbox__button js-sort active">
                <svg xmlns="http://www.w3.org/2000/svg" version="1.1" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:svgjs="http://svgjs.com/svgjs" width="50" height="50" x="0" y="0" class="larger-icon" viewBox="0 0 32 32" style="enable-background:new 0 0 512 512" xml:space="preserve" class=""><
                <g>
                <path fill="#111111" fill-rule="nonzero" d="M9 7v15.584l1.293-1.291 1.414 1.414L8 26.414l-3.707-3.707 1.414-1.414L7 22.584V7zm9 15v2h-5v-2zm3-5v2h-8v-2zm3-5v2H13v-2zm3-5v2H13V7z" data-original="#111111" class=""></path>
                </g>
                </svg>

                <button class="dropbtn">Sắp xếp theo: </button>
            </div>
            <div class="dropdown-content">
                <a href="ListAllServicePriceAZ">Giá tăng dần</a>
                <a href="ListAllServicePriceZA">Giá giảm dần</a>
                <a href="ListAllServiceAlpha">A->Z</a>
                <a href="ListAllServiceAlphaZA">Z->A</a>

            </div>
        </div>
    </div>
    <style>
        .dropbtn::after {
            content: "\25BC"; 
            display: inline-block;
            margin-left: 5px;
            font-size: 12px;  
        }
        /* Dropdown Button */
        .larger-icon {
            width: 50px;
            height: 54px;
        }
        .hihi{
            height: 10px;
        }
        .drop{
            margin-top: 20px;
            float: right;
            margin-right: 50px;
        }
        .dropbtn {
            background-color: rgba(10,50,30,0.95);
            color: white;
            padding-right:16px ;
            font-size: 16px;
            border: none;
        }

        /* The container <div> - needed to position the dropdown content */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        /* Dropdown Content (Hidden by Default) */
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f1f1f1;
            min-width: 152px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            /*            margin-top: 40px;*/
            margin-right: 20px;
            margin-left: 35px;
            z-index: 1;
        }

        /* Links inside the dropdown */
        .dropdown-content a {
            color: black;
            padding: 4px 6px;
            text-decoration: none;
            display: block;
        }

        /* Change color of dropdown links on hover */
        .dropdown-content a:hover {background-color: #ddd;}

        /* Show the dropdown menu on hover */
        .dropdown:hover .dropdown-content {display: block;}

        /* Change the background color of the dropdown button when the dropdown content is shown */
        .dropdown:hover .dropbtn {background-color: #143b151;}
    </style>
    <div class="container">
        <div class="box row  ">
            <div class="col-lg-9 text-center">
                <form action="MainController" class="narrow-w form-search d-flex align-items-stretch mb-3 justify-content-center align-items-center" >
                    <input class=" form-search form-control px-4" type="text" name="search" placeholder="search..." value="${param.search}" />
                    <input type="submit" class="btn btn-primary search" name="action" value="Search"/>  
                </form>
                <!--                <i class="fas fa-search"></i>-->
            </div>
            <div class="col-lg-3 justify-content-right" style="display:flex;padding-bottom: 20px">   

                <!--                <a class="se justify-content-center">
                                    <img style="width:40px; height: 40px" src="image/avatar/icon2.png">
                                </a>-->
            </div>
        </div>
    </div>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <c:if test="${requestScope.LISTAP_SERVICES != null}">
        <c:if test="${ not empty requestScope.LISTAP_SERVICES}">                                
            <div class="row">
                <c:forEach items="${requestScope.LISTAP_SERVICES}" var="pro" varStatus="counter">
                    <div class="col-sm-4">
                        <div class="property-item mb-30">
                            <div class="property-item">
                                <center>
                                    <a href="" class="img">
                                        <img src="image/${pro.servicePicture}" width="100%" height="400" alt="Image" class="img-fluid">
                                    </a>
                                </center>
                                <div class="property-content">
                                    <div class="price mb-2"><span>${pro.servicePrice}00 VND - ${pro.serviceTime}h</span></div>
                                    <div>
<!--                                        <span class="d-block mb-2 text-black-50">${pro.serviceID} - ${pro.serviceTime}</span>-->
                                        <span class="city d-block mb-3">${pro.serviceName}</span>
                                        <b class="city d-block mb-3 text-black-50">${pro.serviceDetail}</b>
                                        <a class="btn btn-primary py-2 px-3 add-to-cart" href="MainController?cmbTea=${pro.serviceID}-${pro.serviceName}-${pro.servicePrice}-${pro.serviceDetail}-${pro.serviceTime}-${pro.servicePicture}&action=Add">Add to cart</a>
                                        <a href="MainController?id=${pro.serviceName}&action=Detail" class="btn btn-primary py-2 px-3">See details</a>
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
                        }
                        .footer{
                            background:rgba(10,50,30,0.95);
                            color: white;
                            text-align: center; 
                            padding: 40px 10px;
                            font-size: 15px;
                        }

                    </style>
                </c:forEach>
            </c:if>
        </c:if>   
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
