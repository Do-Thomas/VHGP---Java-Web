<%-- 
    Document   : ConfirmBillCustomer
    Created on : Jul 11, 2023, 11:57:07 PM
    Author     : Asus
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.ConfirmPay"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hóa đơn thanh toán</title>

        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">


        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">

        <style>

            .site-nav {
                position: inherit;
                margin-bottom: 200px;
            }
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

            /*            Phần menu nhỏ*/
            .menu-mini {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
                border-radius: 10px;
                display: flex;
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
                padding: 14px 16px;
                text-decoration: none;

            }

            .mini a:hover {
                background-color: #111;
            }

            /*Phần Table */ 
            .table>tbody>tr>td,
            .table>tfoot>tr>td {
                vertical-align: middle;
            }

            @media screen and (max-width: 600px) {
                table#cart tbody td .form-control {
                    width: 20%;
                    display: inline !important;
                }
                .actions .btn {
                    width: 36%;
                    margin: 1.5em 0;
                }
                .actions .btn-info {
                    float: left;
                }
                .actions .btn-danger {
                    float: right;
                }
                table#cart thead {
                    display: none;
                }
                table#cart tbody td {
                    display: block;
                    padding: .6rem;
                    min-width: 320px;
                }
                table#cart tbody tr td:first-child {
                    background: #333;
                    color: #fff;
                }
                table#cart tbody td:before {
                    content: attr(data-th);
                    font-weight: bold;
                    display: inline-block;
                    width: 8rem;
                }
                table#cart tfoot td {
                    display: block;
                }
                table#cart tfoot td .btn {
                    display: block;
                }
            }
            .status-icon {
                height: 10px;
                width: 10px;
                display: inline-block;
                border-radius: 50%;
                margin-right: 5px;
            }
            .actions img{
                /*                background-color: #02e17a;*/
                width: 30px;
                height:30px;
            }

            .btn-success{
                background-color: rgba(10,50,30,0.95);
                margin-left: 43%;
                padding: 30px 50px;
                border-radius: 50px;
            }

        </style>
    </head>
    <body>
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
                            <!--                            <li><a href="listServices.jsp">Support</a></li>
                                                        <li><a href="listServices.jsp">About</a></li>
                                                        <li><a href="listServices.jsp">Contact Us</a></li>-->
                            <c:set var="name" value="${LOGIN_USER.customerName}" />
                            <c:if test="${not empty name}">

                                <li class="has-children">
                                    <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                        <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                        </svg>  <b class="caret"> ${LOGIN_USER.customerName} </b></a>
                                    <ul class="dropdown">
                                        <li><a href="ViewCustomer">Profile</a></li>
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

        <style>
            .form-container{
                display: flex;
                flex-direction: column;
            }
            @import url(https://fonts.googleapis.com/css?family=Open+Sans:600,400);

            $blue: #5F98CD;
            $blue-dark: #264057;
            $blue-light: #B2DAFF;

            .frame {
                position: absolute;
                top: 50%;
                left: 50%;
                width: 400px;
                height: 400px;
                margin-top: -200px;
                margin-left: -200px;
                border-radius: 2px;
                box-shadow: 1px 2px 10px 0px rgba(0,0,0,0.3);
                background: $blue-dark;
                color: #666666;
                font-family: 'Open Sans', Helvetica, sans-serif;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;
                overflow: hidden;
            }

            .panel {
                /*                position: absolute;*/
                z-index: 2;
                /*                height: 300px;*/
                top: 50px;
                left: 50px;
                background: #fff;
                border-radius: 3px;
                overflow: hidden;
                box-shadow: 10px 10px 15px 0 rgba(0,0,0,0.3);
                transition: all .5s ease-in-out;
                margin: 40px;
                width: 100vh;
                margin-left: 15%;

                &.show-menu {
                    transform: translate3d(150px,0,0);
                }

                .notifications {
                    position: relative;
                    height: 100%;
                    overflow: hidden;

                    .line {
                        position: absolute;
                        top: 0;
                        left: 27px;
                        bottom: 0;
                        width: 3px;
                        background: #EBEBEB;
                    }

                    .notification {
                        position: relative;
                        z-index: 2;
                        margin: 25px 20px 25px 43px;
                        &:hover {
                            color: $blue;
                            cursor: pointer;
                        }

                        .circle {
                            box-sizing: border-box;
                            position: absolute;
                            height: 11px;
                            width: 11px;
                            background: #fff;
                            border: 2px solid $blue;
                            box-shadow: 0 0 0 3px #fff;
                            border-radius: 6px;
                            top: 0;
                            left: -20px;
                        }

                        .time {
                            display: block;
                            font-size: 15px;
                            line-height: 11px;
                            margin-bottom: 2px;
                        }

                        p {
                            font-size: 15px;
                            line-height: 20px;
                            margin: 0;

                            b {
                                font-weight: 600;
                            }
                        }

                    }

                }

            }

            .form-emp{
                display:flex;
            }
            .button-finished{

                width: 150px;
                height: 50px;
                color: #fff;
                border-radius: 5px;
                padding: 10px 25px;
                font-size: 20px;
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
                background-color: #4dccc6;
                background-image: linear-gradient(315deg, #33a36fb5 0%, #335500 74%);
                line-height: 42px;
                padding: 0;
                border: none;
                text-align: center;
                margin-left: 80%;
                margin-top: 10px;
            }

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
            .menu ul li a:hover {
                background: #abccc0;
                border-left: solid 5px #6a75eb;
                margin-left: -10px;
                width: 98%;
            }
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

            /*            .btn-hover.color-1 {
                            background-image: linear-gradient(to right, #25aae1, #40e495, #30dd8a, #2bb673);
                            box-shadow: 0 4px 15px 0 rgba(49, 196, 190, 0.75);
                        }*/



            /*            @import url('https://fonts.googleapis.com/css?family=Heebo|Shrikhand');*/
            body {
                background-color: #fefefe;
                font-family: heebo, sans-serif;
            }
            .mdl-card {
                padding: 0;
                /*                margin: 0 2rem 2rem;*/
                min-height: 100px;
                max-width: 40rem;
            }
            @media(min-width: 1080px){
                .mdl-card {
                    flex-basis: calc(33% - 4rem);
                }
            }
            .mdl-card__supporting-text {
                /*                padding: 1rem 3rem 4rem;*/
                /*                width: calc(100% - 6rem);*/
            }
            .container2 {
                color: #414141;
                /*                padding-top: 15vh;*/
                /*                display: flex;*/
                flex-wrap: wrap;
                justify-content: center;
                margin: 0 auto;
                border: solid;
                border-color: green;
            }
            @media (min-width: 60rem) {
                .container {
                    justify-content: flex-start;
                }
            }
            ol, ul {
                margin: 0;
                padding: 0 0 0 1rem;
            }
            li {
                line-height: 1.45rem;
            }
            .primary {
                text-align: center;
                font-size: 4rem;
                margin: 4rem 0 5rem;
                color: #0079c1;
                font-family: 'Shrikhand', heebo, sans-serif;
            }

            .attention {
                color: #ff0000;
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

            .row-emp{
                vertical-align: middle;
            }

            smile{
                font-size: 50vh;
                text-align: center;
            }
            .empty-list{
                text-align: center;
            }
            
            

            /*Invoice*/
            #invoice-POS {
                padding: 6mm;
                margin: 0 auto;
                width: 35%;
                background: #FFF;
            }
            #invoice-POS ::selection {
                background-color: #FFF;
                color: #FFF;
            }
            #invoice-POS ::moz-selection {
                background-color: #FFF;
                color: #FFF;
            }
            #invoice-POS h1 {
                font-size: 1.6em;
                color: #222;
            }
            #invoice-POS h2 {
                font-size: 1em;
            }
            #invoice-POS h3 {
                font-size: 1.3em;
                font-weight: 300;
                line-height: 2em;
            }
            #invoice-POS p {
                font-size: 0.9em;
                color: #000;
                line-height: 1.2em;
            }
            #invoice-POS #top, #invoice-POS #mid, #invoice-POS #bot {
                /* Targets all id with 'col-' */
                border-bottom: 1px solid #EEE;
            }
            #invoice-POS #top {
                min-height: 100px;
            }
            #invoice-POS #mid {
                min-height: 80px;
            }
            #invoice-POS #bot {
                min-height: 50px;
            }
            #invoice-POS #top .logo {
                height: 80px;
                width: 80px;
                background: url(image/logo.jpg) no-repeat;
                background-size: 80px 80px;
            }
            #invoice-POS .info {
                display: block;
                margin-left: 0;
            }
            #invoice-POS .title {
                float: right;
            }
            #invoice-POS .title p {
                text-align: right;
            }
            #invoice-POS table {
                width: 100%;
                border-collapse: collapse;
            }
            #invoice-POS .tabletitle {
                font-size: 0.7em;
                background: #EEE;
            }
            #invoice-POS .service {
                border-bottom: 1px solid #EEE;
            }
            #invoice-POS .item {
                width: 24mm;
            }
            #invoice-POS .itemtext {
                font-size: 0.8em;
            }
            #invoice-POS #legalcopy {
                margin-top: 5mm;
            }
            .legal{
               
            }
            .mdl-card__title {
                background: #0079c1;
                color: #cacaca;
                margin-bottom: 1rem;
                &-text{
                    color: white;
                }
            }
        </style>

        <div id="invoice-POS">

            <center id="top">
                <div class="logo"></div>
                <div class="info"> 
                    <h2>VHGP</h2>
                </div><!--End Info-->
            </center><!--End InvoiceTop-->
            <c:if test="${requestScope.BILL_CONFIRM != null}">
                <c:if test="${ not empty requestScope.BILL_CONFIRM}">
                    <c:forEach items="${requestScope.BILL_CONFIRM}" var="b" varStatus="counter">
                        <c:set var="timeStart" value="${b.status.orderDetail.timeStart}"/>
                        <c:set var="timeEnd" value="${b.status.orderDetail.timeEnd}"/>
                        <c:set var="price" value="${b.status.orderDetail.orderDServicePrice}"/>
                        <c:set var="total" value="${total + price}"/>
                        <div id="mid">
                            <div class="info">
                                <p> 
                                <b class="info">Tên khách hàng ${b.customer.customerName}</b>
                                <b class="info">Số điện thoại ${b.customer.phone}</b>   
                                <b class="info">Nhân viên ${b.status.employee.employeeName}</b>
                                </p>
                            </div>
                        </div><!--End Invoice Mid-->

                        <div id="bot">

                            <div id="table">
                                <table>
                                    <tr class="tabletitle">
                                        <td class="item"><h2>Dịch vụ</h2></td>
                                        <td class="Hours"><h2>Thời gian</h2></td>
                                        <td></td>
                                    </tr>

                                    <tr class="service">
                                        <td class="tableitem"><p class="itemtext">${b.status.orderDetail.orderDServiceName}</p></td>
                                        <td class="tableitem"><p class="itemtext"><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${timeStart}"/>  - <fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${timeEnd}"/></p></td>
                                        
                                    </tr>
                                    <tr class="tabletitle">
                                        <td></td>
                                        <td class="Rate"><h2>Hình thức thanh toán</h2></td>
                                        <td>${b.status.orderDetail.pay}</td>
                                    </tr>
                                    <tr class="tabletitle">
                                        <td></td>
                                        <td class="Rate"><h2>Tổng</h2></td>
                                        <td class="payment"><h2>${total}00 VND</h2></td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </c:if>

                    </table>
                </div><!--End Table-->

                <div id="legalcopy">
                    <p class="legal" style="color: #c3c344; text-align: center"><strong>ĐÃ THANH TOÁN</strong>
                    </p>
                </div>

            </div><!--End InvoiceBot-->
        </div><!--End Invoice-->

    <tfoot>
        <tr>
            <td><a href="MainController?action=ListService" class="btn btn-success">Trang dịch vụ</i></a></td>
        <td colspan="2" class="hidden-xs"></td>

    </tr>
</tfoot>
</table>
</div>


</div>
</body>
</html>
