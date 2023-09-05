<%-- 
    Document   : TestList
    Created on : May 25, 2023, 8:58:27 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Category"%>
<%@page import="model.Services"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang quản lý</title>
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
        <link rel="stylesheet" href="css/sidebar.css">
        <link href="js/sidebar.js">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800,900" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="../css/table.css" rel="stylesheet">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script>
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
        </style>
    </head>
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

                        <!--                        <div class="search">
                                                    <input  type='text' class='src' placeholder='Search for cards...'/>
                                                </div>-->

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

                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card shadow">
                                <div class="card-header border-0">
                                    <img　class="img-dondep" src="image/icon/iconorder.jpg" alt="Icon-don-dep">
                                    <h3 class="mb-0">Danh sách đặt dịch vụ</h3>
                                </div>
                                <div class="table-responsive">
                                    <table class="table align-items-center table-flush table-nhidesgin">
                                        <div class="table-column">
                                            <thead class="thead-light">
                                                <tr>
                                                    <th scope="col" class="column1">Mã</th>
                                                    <th scope="col" class="column2">Mã dịch vụ</th>
                                                    <th scope="col" class="column3">Ngày đặt hàng</th>
                                                    <th scope="col" class="column3">Tên nhân viên</th>
                                                    <th scope="col" class="column3">Số điện thoại</th>
                                                    <th scope="col" class="column5">Trạng thái</th>
                                                    <th scope="col" class="column5">Chi tiết</th>
                                                </tr>
                                            </thead>
                                            <c:if test="${requestScope.LIST_ALL_ORDER != null}">
                                                <c:if test="${ not empty requestScope.LIST_ALL_ORDER}">
                                                    <c:forEach items="${requestScope.LIST_ALL_ORDER}" var="o" varStatus="counter">
                                                        <tbody>
                                                            <tr>
                                                                <td>${o.statusID}</td>
                                                                <td>${o.order.orderID} </td>
                                                                <td>${o.orderDate}</td>
                                                                <td>${o.employee.employeeName}</td>
                                                                <td>${o.employee.employeePhone}</td>
                                                                <c:set var="StatusOrder" value="${o.statusName}" />
                                                                <c:choose>
                                                                    <c:when test="${StatusOrder eq 'Hoạt động'}">
                                                                        <td class="actions" data-th="">
                                                                            <img src="https://cdn-icons-png.flaticon.com/512/3202/3202834.png">
                                                                            ${o.statusName}
                                                                        </td>    
                                                                    </c:when>
                                                                    <c:when test="${StatusOrder eq 'Hoàn thành'}">
                                                                        <td class="actions">
                                                                            <img src="https://icon-library.com/images/completed-icon/completed-icon-6.jpg">
                                                                            ${o.statusName}
                                                                        </td>
                                                                    </c:when>
                                                                    <c:when test="${StatusOrder eq 'Hủy'}">
                                                                        <td class="actions">
                                                                            <img src="https://img.freepik.com/free-icon/multiply_318-350486.jpg">
                                                                            ${o.statusName}
                                                                        </td>
                                                                    </c:when>
                                                                </c:choose>
                                                                <td><a href="DetailOrder?OrderID=${o.order.orderID}">Chi tiết</a></td>
                                                            </tr>
                                                        </tbody>
                                                    </c:forEach>
                                                </c:if>
                                            </c:if>
                                        </div>
                                    </table>                                       
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <style>
                    .card-header {
                        display: flex;
                    }
                    .img-ranhroi{
                        width: 30px;
                        height: 30p;
                    }
                    .custom-btn {
                        width: 130px;
                        height: 40px;
                        color: #fff;
                        border-radius: 5px;
                        padding: 10px 25px;
                        font-family: 'Lato', sans-serif;
                        font-weight: 500;
                        background: transparent;
                        cursor: pointer;
                        transition: all 0.3s ease;
                        position: relative;
                        display: inline-block;
                        box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
                            7px 7px 20px 0px rgba(0,0,0,.1),
                            4px 4px 5px 0px rgba(0,0,0,.1);
                        outline: none;
                    }
                    /* 4 */
                    .btn-4 {
                        background-color: #4dccc6;
                        background-image: linear-gradient(315deg, #4dccc6 0%, #96e4df 74%);
                        line-height: 42px;
                        padding: 0;
                        border: none;
                        text-align: center;
                        margin-left: 75vh;
                    }
                    .btn-4:hover{
                        background-color: #89d8d3;
                        background-image: linear-gradient(315deg, #89d8d3 0%, #03c8a8 74%);
                    }
                    .btn-4 span {
                        position: relative;
                        display: block;
                        width: 100%;
                        height: 100%;
                    }
                    .btn-4:before,
                    .btn-4:after {
                        position: absolute;
                        content: "";
                        right: 0;
                        top: 0;
                        box-shadow:  4px 4px 6px 0 rgba(255,255,255,.9),
                            -4px -4px 6px 0 rgba(116, 125, 136, .2), 
                            inset -4px -4px 6px 0 rgba(255,255,255,.9),
                            inset 4px 4px 6px 0 rgba(116, 125, 136, .3);
                        transition: all 0.3s ease;
                    }
                    .btn-4:before {
                        height: 0%;
                        width: .1px;
                    }
                    .btn-4:after {
                        width: 0%;
                        height: .1px;
                    }
                    .btn-4:hover:before {
                        height: 100%;
                    }
                    .btn-4:hover:after {
                        width: 100%;
                    }
                    .btn-4 span:before,
                    .btn-4 span:after {
                        position: absolute;
                        content: "";
                        left: 0;
                        bottom: 0;
                        box-shadow:  4px 4px 6px 0 rgba(255,255,255,.9),
                            -4px -4px 6px 0 rgba(116, 125, 136, .2), 
                            inset -4px -4px 6px 0 rgba(255,255,255,.9),
                            inset 4px 4px 6px 0 rgba(116, 125, 136, .3);
                        transition: all 0.3s ease;
                    }
                    .btn-4 span:before {
                        width: .1px;
                        height: 0%;
                    }
                    .btn-4 span:after {
                        width: 0%;
                        height: .1px;
                    }
                    .btn-4 span:hover:before {
                        height: 100%;
                    }
                    .btn-4 span:hover:after {
                        width: 100%;
                    }

                </style>

            </div>
        </div>
    </body>
    <script type="text/javascript">
        $(document).ready(function () {
            //jquery for toggle sub menus
            $('.caret').click(function () {
                $(this).next('.sub-menu').slideToggle();
                $(this).find('.dropdown').toggleClass('rotate');
            });
        });
    </script>
</html>

