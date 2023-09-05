<%-- 
    Document   : DetailOrder
    Created on : Aug 3, 2023, 1:10:16 AM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết đơn hàng</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Untree.co">
        <link rel="shortcut icon" href="favicon.png">

        <meta name="description" content="" />
        <meta name="keywords" content="bootstrap, bootstrap5" />

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/sidebar.css">
        <link href="js/sidebar.js">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800,900" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="../css/table.css" rel="stylesheet">
    </head>
    <style>
        html {
            font-family: 'Nunito', sans-serif;
            height: 100%;
        }
        body {
            margin: 0px;
            height: 100%;  
            font-size: 15px;
        }
        .wrapper {
            height: auto;
            min-height: 100%;
            overflow: hidden;

        }
        .side-menu {
            width: 250px;
            float: left;
            background: #212529;
            height: auto;
            min-height: 100%;
            margin-bottom: -5000px; /* any large number will do */
            padding-bottom: 5000px; 
        }
        .topmenu{
            height: 60px;
            padding: 10px 0px 0px 10px;
            background: #212529;                
            color: #e1e2fa;
        }
        .logo {
            background: #222;
            color: #ffffff;
            font-size: 24px;
            font-weight: bold;
            padding: 10px 0px 0px 10px;
            height: 45px;
        }
        .main-section {
            height: 100%;
        }
        a {
            text-decoration: none;
            color: #e1e2fa;
        }
        .menu ul {
            list-style-type: none;
            margin-left: 0px;
            padding-left: 10px;
        }
        .menu ul li a {
            font-size: 12px;
            font-weight: 800;
            display: inline-block;
            padding-top: 50px;
            padding-bottom: 10px;
            width: 100%;
            margin-left: -5px;
            padding-left: 10px;
        }
        /*            .menu ul li a:hover {
                        background: #abccc0;
                        border-left: solid 5px #6a75eb;
                        margin-left: -10px;
                        width: 98%;
                    }*/
        .menu ul li ul {
            padding-left:0px; 
        }
        #showmenu {
            font-size: 18px;
            display: inline-block;
            padding-left: 15px;
            padding-top: 5px;
            padding-right: 15px;
            float: left;
            /*                //border-right: solid 1px #000;*/
        }
        .main-section{
            background: #f6f9fc;
            height:100%;
            margin-bottom: -5000px; /* any large number will do */
            padding-bottom: 5000px;
            margin-left: 250px;
        }
        .search {
            width: 340px;
            float: left;
            margin-top:3px;
            margin-left: 25px;
            padding-left: 10px;
            background: #505250;
            padding-top: 3px;
            padding-bottom: 3px;
            border-radius: 15px;
            color: #8089e8;
        }
        input.src {
            background: none;
            border: none;
            width: 300px;
            font-family: 'Nunito', sans-serif;
            color: #8089e8;
            font-size: 13px;
            font-weight: 600;

        }
        *:focus {
            outline: none;
        }
        ::-webkit-input-placeholder { /* Chrome/Opera/Safari */
            font-family: 'Nunito', sans-serif;
            color: #F9FDEF;
            font-size: 13px;
            font-weight: 600;
        }
        ::-moz-placeholder { /* Firefox 19+ */
            font-family: 'Nunito', sans-serif;
            color: #F9FDEF;
            font-size: 13px;
            font-weight: 600;
        }
        :-ms-input-placeholder { /* IE 10+ */
            font-family: 'Nunito', sans-serif;
            color: #F9FDEF;
            font-size: 13px;
            font-weight: 600;
        }
        :-moz-placeholder { /* Firefox 18- */
            font-family: 'Nunito', sans-serif;
            color: #F9FDEF;
            font-size: 13px;
            font-weight: 600;
        }
        .card {
            margin: 25px;
            padding: 15px;
            background: #fff;
            box-shadow: 0 6px 20px 0px #dce8f4;
        }
        .card-content {
            color: #32325d;
            font-weight: 600;
            font-size: 18px;

        }
        .author {
            color: #999999;
            font-size: 36px;
            margin-top: 20px;

        }
        .status-green {
            width: 30px;
            height: 8px;
            border-radius: 10px;
            background: #23d2ac;
            margin-bottom: 15px; 
        }
        .status-blue {
            width: 30px;
            height: 8px;
            border-radius: 10px;
            background: #33adff;
            margin-bottom: 15px; 
        }
        .status-red {
            width: 30px;
            height: 8px;
            border-radius: 10px;
            background: red;
            margin-bottom: 15px; 
        }
        .section-title {
            margin-left: 25px;
            margin-top: 10px;
            font-size: 24px;
            color: #3a3a63;
        }
        .link-function a{

        }
        * {
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }

        .buttons {
            margin: 10%;
            text-align: center;
        }

        .btn-hover {
            width: 200px;
            font-size: 16px;
            font-weight: 600;
            color: #fff;
            cursor: pointer;
            margin: 20px;
            height: 55px;
            text-align:center;
            border: none;
            background-size: 300% 100%;

            border-radius: 50px;
            moz-transition: all .4s ease-in-out;
            -o-transition: all .4s ease-in-out;
            -webkit-transition: all .4s ease-in-out;
            transition: all .4s ease-in-out;
        }

        .btn-hover:hover {
            background-position: 100% 0;
            moz-transition: all .4s ease-in-out;
            -o-transition: all .4s ease-in-out;
            -webkit-transition: all .4s ease-in-out;
            transition: all .4s ease-in-out;
        }

        .btn-hover:focus {
            outline: none;
        }

        .btn-hover.color-1 {
            background-image: linear-gradient(to right, #25aae1, #40e495, #30dd8a, #2bb673);
            box-shadow: 0 4px 15px 0 rgba(49, 196, 190, 0.75);
        }
        .img-design{
            width: 15vh;
            height: 10vh;
        }

        /*Dropdown Menu*/
        .dropdown2 {
            position: relative;
            margin-left: 85%;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            padding: 12px 16px;
            z-index: 1;
        }

        .dropdown2:hover .dropdown-content {
            display: block;
            color: #333;
            background-color:#fff;
            border-radius: 20px ;

        }

        .actions img{
            /*                background-color: #02e17a;*/
            width: 30px;
            height:30px;
        }
        .text{
            margin: 10px;
            padding: 20px 0px;
            font-size: 20px;
        }
        .profile{
            color: #222;
        }
        .fa{
            font-size: 30px;
        }

        /*            Phần menu nhỏ*/
        .menu-mini {
            list-style-type: none;
            margin: 0;
            padding: 0;
            /*                overflow: hidden;*/
            background-color: #333;
            border-radius: 10px;
            /*                display: flex;*/
            justify-content: space-around;
        }

        .mini {
            float: left;
            text-align: center;
        }
        .mini ul{
            align-content: center;
        }

        .mini a {
            display: block;
            color: white;
            text-align: center;
            padding: 18px 16px;
            text-decoration: none;

        }

        .mini a:hover {
            background-color: #1bab2e;
            width: 100%;
            height: 100%;
        }
        active:is-active{
            background-color: #21c8de;
        }



        /* PHẦN CART ITEM PRODUCTS  */
        @import url('https://fonts.googleapis.com/css?family=Abel|Aguafina+Script|Artifika|Athiti|Condiment|Dosis|Droid+Serif|Farsan|Gurajada|Josefin+Sans|Lato|Lora|Merriweather|Noto+Serif|Open+Sans+Condensed:300|Playfair+Display|Rasa|Sahitya|Share+Tech|Text+Me+One|Titillium+Web');

        body {
            background: #DFC2F2;
            background-image: linear-gradient( 135deg, #baeac2 10%, #bae9cc 100%);
            background-attachment: fixed;	
            background-size: cover;
        }

        #container{
            box-shadow: 0 15px 30px 1px rgba(128, 128, 128, 0.31);
            background: rgba(255, 255, 255, 0.90);
            text-align: center;
            border-radius: 5px;
            overflow: hidden;
            margin: 5em auto;
            height: 450px;
            width: 900px;

        }



        /* 	Product details  */
        .product-details {
            position: relative;
            text-align: left;
            overflow: hidden;
            padding: 30px;
            height: 100%;
            float: left;
            width: 40%;

        }

        /* 	Product Name */
        #container .product-details h1{
            font-family: 'Old Standard TT', serif;
            display: inline-block;
            position: relative;
            font-size: 34px;
            color: #344055;
            margin: 0;

        }

        /*        #container .product-details h1:before{
                    position: absolute;
                    content: '';
                    right: 0%; 
                    top: 0%;
                    transform: translate(25px, -15px);
                    font-family: 'Farsan', cursive;
                    display: inline-block;
                    background: #FFA69E;
                    border-radius: 5px;
                    font-size: 14px;
                    padding: 5px;
                    color: #FFF;
                    margin: 0;
                    animation: chan-sh 6s ease infinite;
        
                }*/


        @keyframes chan-sh {
            from  {content: 'free shipping';}
            to  {content: 'New';}

        }

        .information{
            padding-top: 15px;
        }

        /*Product Rating  */
        .hint-star {
            display: inline-block;
            margin-left: 0.5em;
            color: gold;
            width: 50%;
        }


        /* The most important information about the product */
        #container .product-details > p {
            font-family: 'Farsan', cursive;
            /*            text-align: center;*/
            font-size: 20px;
            color: #7d7d7d;

        }

        /* control */

        .control{
            position: absolute;
            bottom: 20%;
            left: 22.8%;

        }

        .btn {
            transform: translateY(0px);
            transition: 0.3s linear;
/*            background: #49C608;*/
            border-radius: 5px;
            position: relative;
            overflow: hidden;
            cursor: pointer;
            outline: none;
            border: none;
            color: #eee;
            padding: 0;
            margin: 0;

        }


        .btn span {
            font-family: 'Farsan', cursive;
            transition: transform 0.3s;
            display: inline-block;
            padding: 10px 20px;
            font-size: 1.2em;
            margin:0;

        }
        /* shopping cart icon */
        .btn .price, .shopping-cart{
            background: #333;
            border: 0;
            margin: 0;
        }

        .btn .price {
            padding-right: 15px;
            margin-left: 200px;
        }

        /* product image  */
        .product-image {
            transition: all 0.3s ease-out;
            display: inline-block;
            position: relative;
            overflow: hidden;
            height: 100%;
            float: right;
            width: 50%;
            display: inline-block;
        }

        #container img {width: 100%;height: 100%;}

        .info {
            background: rgba(27, 26, 26, 0.9);
            font-family: 'Farsan', cursive;
            transition: all 0.3s ease-out;
            transform: translateX(-100%);
            position: absolute;
            line-height: 1.9;
            text-align: left;
            font-size: 120%;
            cursor: no-drop;
            color: #FFF;
            height: 100%;
            width: 100%;
            left: 0;
            top: 0;
        }

        .info h2 {text-align: center}
        .product-image:hover .info{transform: translateX(0);}

        .info ul li{transition: 0.3s ease;}
        .info ul li:hover{transform: translateX(50px) scale(1.3);}

        .product-image:hover img {transition: all 0.3s ease-out;}
        .product-image:hover img {transform: scale(1.2, 1.2);}
        
        .pay{
            color: #18ac2b;
            font-family: 'Farsan', cursive;
            /*            text-align: center;*/
            font-size: 20px;
        }
    </style>
    <body>

        <div class="all">
            <div class="side-menu">
                <div class="logo">Trang quản lý</div>
                <div class="menu">
                    <ul>
                        <!--                        <li><a href="#"><i class="fa fa-server" aria-hidden="true"></i><span class="text"> Pages </span></a>-->
                        <ul class="dropdown">
                            <!--                                <li><a href="#"><i class="fa fa-bar-chart" aria-hidden="true"></i><span class="text"> Dashboard</span></a></li>-->
                            <li><a href="ListOfCategory"><i class="fa fa-arrows-alt" aria-hidden="true"></i><span class="text"> Category</span></a></li>
                            <li><a href="admin"><i class="fa fa-desktop" aria-hidden="true"></i><span class="text"> Services</span></a></li>
                            <li><a href="Dashboard"><i class="fa fa-gears" aria-hidden="true"></i><span class="text"> Dashboard</span></a></li>
                            <!--                            <li><a href="ListOfMarketing"><i class="fa fa-percent" aria-hidden="true"></i><span class="text">Voucher</span></a></li>-->
                            <li><a href="AllEmployee"><i class="fa fa-users" aria-hidden="true"></i><span class="text">Employee</span></a></li>
                            <li><a href="MainController?action=AllOrder&status=2"><i class="fa fa-window-maximize" aria-hidden="true"></i><span class="text">Order</span></a></li>
                        </ul>

                    </ul>
                </div>
            </div>

            <div class="wrapper">
                <div class="main-content">
                    <ul class="menu-mini">
                        <li class="mini"><a class="" href="MainController?action=AllOrder&status=1">Tất cả</a></li>
                        <li class="mini"><a class="active" href="MainController?action=AllOrder&status=2">Hoạt động</a></li>
                        <li class="mini"><a class="" href="MainController?action=AllOrder&status=3">Hoàn thành</a></li>
                        <li class="mini"><a class="" href="MainController?action=AllOrder&status=4">Hủy</a></li>
                    </ul>
                    <div class="topmenu">
                        <div class="dropdown2">
                            <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                </svg>  <b class="caret"> Admin</b>
                            </a>
                            <div class="dropdown-content">
                                <a href="MainController?action=ViewA"><li class="profile">Profile</li></a>
                                <a href="#"><li class="profile">Setting</li></a>
                                <a href="LogoutController"><li class="profile">Logout</li></a>
                            </div>
                        </div>

                    </div>
                </div>


                <c:set var="d" scope="request" value="${ITEM_ORDER}" />
                <div id="container">	
                    <!-- Start	Product details -->
                    <div class="product-details">
                        <!-- 	Product Name -->
                        <h1><c:out value="${d.orderDServiceName}"/></h1>
                        <p class="information">Giờ <c:out value="${d.serviceTime}h"/></p>
                        <p class="information">Giá <c:out value="${d.orderDServicePrice}00 VND"/></p>
                        <p class="information">Từ <fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${d.timeStart}"/></p>
                        <p class="information">Đến <fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${d.timeEnd}"/></p>
                        <p class="information">Trạng thái <c:out value="${d.status}"/></p>
                        <b class="information pay"><c:out value="Thanh toán khi hoàn thành"/></b>
                    </div>

                    <div class="product-image">
                        <img src="image/${d.services.servicePicture}" alt="Image" class="img-fb">
                        <!-- 	product Information-->
                    </div>
                    <!--  End product image  -->
                </div>

                <button class="btn">
                    <span class="price"><a href="MainController?action=AllOrder&status=2">Quay lại</a></span>
                    </body>
                    </html>
