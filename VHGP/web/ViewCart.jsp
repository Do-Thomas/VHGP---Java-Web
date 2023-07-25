<%-- 
    Document   : ViewCart
    Created on : Apr 19, 2022, 4:22:28 PM
    Author     : USER
--%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="tea.Tea"%>
<%@page import="tea.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
        <link rel="stylesheet" type="text/css" href="cart.css">
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

        <title>Property &mdash; Free Bootstrap 5 Website Template by Untree.co</title>
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
                background-color: green;
                color: white;
                border-radius: 10px;
                padding: 10px;
                background-color: #fff;
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
                color: white;
                text-align: center; 
                padding: 40px 10px;
                font-size: 15px;
            }
            .row-flex {
                display: flex;
                flex-wrap: wrap;
            }
        </style>

        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <style>
            /* Global Styles */
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;

            }
            .cart {


                overflow: hidden;
            }
            .container {
                max-width: 1200px;
                margin: 0 auto;
                padding: 20px;
                border-radius: 50px;
            }

            h1.logo {
                margin: 0;
                float: left;
                font-size: 24px;
                font-weight: bold;
            }

            .cart {
                margin-top: 20px;
            }

            .products {
                display: flex;
                flex-wrap: wrap;
                gap: 20px;
            }

            .product {
                width: 100%;
                display: flex;
                align-items: center;
                gap: 20px;
                margin-bottom: 20px;
            }

            .product img {
                width: 300px;
                height: 250px;
                object-fit: cover;
            }

            .product-info {
                flex-grow: 1;
                border: none;
                background: #f4f4f4;
            }
            .product-info input{

                background-color: #f4f4f4;
            }
            .product-name {
                margin: 0;
                font-size: 20px;
                font-weight: bold;
            }

            .product-offer {
                margin: 0;
            }

            .product-offer a {
                display: inline-block;
                margin-right: 10px;
                padding: 5px 10px;

                color: #ffffff;
                text-decoration: none;
                border-radius: 5px;
                background-color: #004848;
            }

            .product-offer a:hover {
                background-color: #f4f4f4;
            }

            .product-price {
                margin: 0;
                font-size: 18px;
            }

            .product-remove,
            .product-edit {
                margin: 0;
            }

            .cart-total {
                margin-top: 20px;
                text-align: right;
            }

            .cart-total p {
                margin: 0;
                font-size: 16px;
            }

            .add {
                margin-top: 20px;
            }

            .note {
                margin-top: 20px;
            }

            .note textarea {
                width: 100%;
                height: 100px;
                resize: vertical;
                padding: 5px;
            }

            input[type="submit"],
            a.button {
                display: inline-block;
                margin-top: 10px;
                padding: 8px 16px;
                background-color: #4CAF50;
                color: white;
                border: none;
                text-align: center;
                text-decoration: none;
                font-size: 14px;
                font-weight: bold;
                cursor: pointer;
                border-radius: 5px;
            }

            input[type="submit"]:hover,
            a.button:hover {
                background-color: #45a049;
            }

            a {
                color: #000;
                text-decoration: none;
            }

            a:hover {
                color: #666;
            }
            .note {
                margin-top: 20px;
            }

            .note textarea {
                width: 100%;
                height: 80px;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                resize: vertical;
            }

            .add {
                margin-top: 20px;
            }

            .add a {
                display: inline-block;
                padding: 10px 15px;
                background-color: #337ab7;
                color: #fff;
                text-decoration: none;
                border-radius: 4px;
            }

            .cart-total {
                margin-top: 20px;
            }

            .cart-total p {
                margin-bottom: 10px;
            }

            .cart-total span {
                font-weight: bold;
                margin-right: 10px;
            }


            .cart-total input {

                bottom: 20px;
                right: 120px;
                padding: 10px 25px;
                background-color: #004848;
                color: white;
                cursor: pointer;
                border-radius: 5px;
            }
            .cart-total input:hover{
                background-color: white;
                color: green;
                font-weight: 600;
                border: 1px solid green;
            }

            .cart-total a {

                bottom: 20px;
                right: 120px;
                padding: 10px 25px;
                background-color: #004848;
                color: white;
                cursor: pointer;
                border-radius: 5px;
            }
            .cart-total a:hover{
                background-color: white;
                color: green;
                font-weight: 600;
                border: 1px solid green;
            }
            .add a {
                display: inline-block;
                padding: 10px 25px;
                background-color: #004848;
                color: white;
                cursor: pointer;
                border-radius: 5px;
            }
            .add{
                text-align: right;
            }
            .add a:hover {
                background-color: white;
                color: green;
                font-weight: 600;
                border: 1px solid green;
            }
            .product-remove{
                padding-bottom: 10px;
            }
            .product-remove input {

                bottom: 20px;
                right: 120px;
                padding: 10px 25px;
                background-color: #004848;
                color: white;
                cursor: pointer;
                border-radius: 5px;

            }
            .product-remove input:hover{
                background-color: white;
                color: green;
                font-weight: 600;
                border: 1px solid green;
            }
            .logo {
                margin: 0;
                float: left;
                font-size: 24px;
                font-weight: bold;
            }
            #hiddenPage {

                position: absolute;
                top: 10%;
                right: 0;
                width: 50%;
                height: 100%;
                background-color:white;
                z-index: 9999;
                text-align: center;
            }

            #hiddenPage.visible {
                display: block;
            }
            .dathang{
                padding-top: 10px;
            }
            .trash-can button{
                width: 20px;
                height: 20px;
                background-color: #f2f2f2;
                border: 2px solid #999;
                border-radius: 50%;
                position: relative;
                overflow: hidden;
            }

            .trash-can button:before,
            .trash-can:after {
                content: "";
                position: absolute;
                background-color: #999;
            }

            .trash-can button:before {
                width: 2px;
                height: 10px;
                top: 5px;
                left: 9px;
            }

            .trash-can button:after {
                width: 12px;
                height: 2px;
                top: 9px;
                left: 4px;
            }
            .button-3h {
                display: inline-block;
                margin-right: 10px;
                padding: 5px 10px;
                color: #ffffff;
                text-decoration: none;
                border-radius: 5px;
                background-color: #004848;
            }

            .button-4h {
                display: inline-block;
                margin-right: 10px;
                padding: 5px 10px;
                color: #ffffff;
                text-decoration: none;
                border-radius: 5px;
                background-color: #f4f4f4;
            }

            .button-3h.selected {
                background-color: #f4f4f4;
            }

            .button-4h.selected {
                background-color: #f4f4f4;
            }

        </style>
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                const links = document.querySelectorAll('.product-offer a');

                links.forEach(function (link) {
                    link.addEventListener('click', function (event) {

                        const selectedLink = event.target;
                        const selectedCode = selectedLink.getAttribute('data-code');
                        const allLinks = document.querySelectorAll('.product-offer a');

                        allLinks.forEach(function (link) {
                            if (link.getAttribute('data-code') === selectedCode) {
                                link.classList.add('selected');

                            } else {
                                link.classList.remove('selected');

                            }
                        });
                    });
                });
            });


        </script>
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

                        <a href="" class="logo m-0 float-start">Giỏ hàng</a>

                        <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end">
                            <li class="active"><a href="IndexServices">Home</a></li>
                            <li class="has-children">
                                <a href="listServices.jsp">Category</a>
                                <ul class="dropdown">
                                    <li><a href="#">Dọn dẹp</a></li>
                                </ul>
                            </li>
                            <li><a href="listServices.jsp">Support</a></li>
                            <li><a href="listServices.jsp">About</a></li>
                            <li><a href="listServices.jsp">Contact Us</a></li>

                            <c:set var="name" value="${LOGIN_USER.customerName}" />
                            <c:if test="${not empty name}">
                                <li class="dropdown">
                                <li class="has-children">
                                    <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                        <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                        </svg>  <b class="caret"> ${LOGIN_USER.customerName} </b></a>

                                    <ul class="dropdown">

                                        <<li><a href="MainController?action=History&status=1">Lịch sử</a></li>
                                        <li><a href="ConfirmBillCustomerController">Hóa đơn</a></li>
                                        <li><a href="LogoutController">Logout</a></li>

                                    </ul>
                                </li> 

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

        <div class="box row  ">
            <div class="col-lg-9 text-center">

                <!--                <i class="fas fa-search"></i>-->
            </div>
            <div class="col-lg-3 justify-content-right" style="display:flex;padding-bottom: 20px">   
                <a class="se justify-content-left"></a>


            </div>        
        </div>


        <div class="container">

            <c:set var="cart" scope="session" value="${sessionScope.CART}"/>
            <c:if test="${not empty sessionScope.CART}">

                <c:set var="total" scope="session" value="${0}"/> 

                <c:forEach var="tea" items="${cart.getCart().values()}" varStatus="counter">
                    <c:set var="list" value="${counter.count}"/>
                    <c:set var="t" value="${ft.format(dNow) + tea.getThoigian()}"/>
                    <c:set var="total" value="${total + tea.getDongia()}"/>

                    <form action="MainController">
                        <div class="cart">

                            <div class="products">

                                <div class="product">

                                    <img src="image/${tea.hinhanh}" alt="Image" class="img-fluid" style="width:300px;height:250px">

                                    <div class="product-info">
                                        <p>Mã dịch vụ : <input style="border: none" class="product-id" type="text" name="madv" value="${tea.madv}" readonly=""></p>

                                        <h3 class="product-name">${tea.tendv}</h3>

                                        <p class="product-offer">
                                            Thời lượng: <a href="MainController?madv=${tea.madv}&tendv=${tea.tendv}&thoigian=3&code=0131491002917&deliveryDate=${tea.deliveryDate}&deliveryTime=${tea.deliveryTime}&action=Gia" data-color="4"  data-code="0131491002917" data-thoigian="240" class="box03__item item button-3h">3 tiếng</a>
                                            <a href="MainController?madv=${tea.madv}&tendv=${tea.tendv}&thoigian=4&code=0131491002918&deliveryDate=${tea.deliveryDate}&deliveryTime=${tea.deliveryTime}&action=Gia" data-color="11" data-code="0131491002918" data-thoigian="350" class="box03__item item button-4h">4 tiếng</a>

<!--<a class="time" href="MainController?madv=${tea.madv}&deliveryDate=${tea.deliveryDate}&action=Show">Change Time</a>-->

                                            <input type="hidden" class="deliveryDate" name="deliveryDate" value="${tea.deliveryDate}">
                                        </p>

                                        <input type="hidden" class="deliveryTime" name="deliveryTime" value="${tea.deliveryTime}">

                                        <div class="dathang">
                                            <c:if test="${tea.thoigian ==3.0}">




                                                <p>Thời gian bắt đầu dịch vụ:
                                                    <c:set var="deliveryDate" value="${tea.deliveryDate}" />

                                                    <%
                                                        // Lấy giá trị deliveryDate từ biến trong phần JSP
                                                        Date deliveryDate = (Date) pageContext.getAttribute("deliveryDate");

                                                        // Kiểm tra nếu deliveryDate nằm trong khoảng từ 21h tới 23:59
                                                        Calendar calendar = Calendar.getInstance();
                                                        calendar.setTime(deliveryDate);
                                                        int hour = calendar.get(Calendar.HOUR_OF_DAY);

                                                        if (hour >= 21 && hour < 24) {
                                                            // Đặt giá trị deliveryDate thành 7h sáng ngày hôm sau
                                                            calendar.add(Calendar.DAY_OF_MONTH, 1);
                                                            calendar.set(Calendar.HOUR_OF_DAY, 7);
                                                            calendar.set(Calendar.MINUTE, 0);
                                                            calendar.set(Calendar.SECOND, 0);
                                                            deliveryDate = calendar.getTime();
                                                        } else if (hour >= 0 && hour < 7) {
                                                            // Đặt giá trị deliveryDate thành 7h sáng
                                                            calendar.set(Calendar.HOUR_OF_DAY, 7);
                                                            calendar.set(Calendar.MINUTE, 0);
                                                            calendar.set(Calendar.SECOND, 0);
                                                            deliveryDate = calendar.getTime();
                                                        }

                                                        // Cập nhật giá trị mới của deliveryDate vào biến trong phần JSP
                                                        pageContext.setAttribute("deliveryDate", deliveryDate);
                                                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                                        String dateString = dateFormat.format(deliveryDate);

                                                        // Chuyển đổi thành Timestamp
                                                        Timestamp timestamp = Timestamp.valueOf(dateString);
                                                        out.print(dateString);
                                                    %>

                                                </p>


                                            </c:if>
                                            <c:if test="${tea.thoigian == 4.0}">

                                                <p>Thời gian bắt đầu dịch vụ:
                                                    <c:set var="deliveryDate" value="${tea.deliveryDate}" />

                                                    <%
                                                        // Lấy giá trị deliveryDate từ biến trong phần JSP
                                                        Date deliveryDates = (Date) pageContext.getAttribute("deliveryDate");

                                                        // Kiểm tra nếu deliveryDate nằm trong khoảng từ 21h tới 23:59
                                                        Calendar calendars = Calendar.getInstance();
                                                        calendars.setTime(deliveryDates);
                                                        int hours = calendars.get(Calendar.HOUR_OF_DAY);

                                                        if (hours >= 21 && hours < 24) {
                                                            // Đặt giá trị deliveryDate thành 7h sáng ngày hôm sau
                                                            calendars.add(Calendar.DAY_OF_MONTH, 1);
                                                            calendars.set(Calendar.HOUR_OF_DAY, 7);
                                                            calendars.set(Calendar.MINUTE, 0);
                                                            calendars.set(Calendar.SECOND, 0);
                                                            deliveryDates = calendars.getTime();
                                                        } else if (hours >= 0 && hours < 7) {
                                                            // Đặt giá trị deliveryDate thành 7h sáng
                                                            calendars.set(Calendar.HOUR_OF_DAY, 7);
                                                            calendars.set(Calendar.MINUTE, 0);
                                                            calendars.set(Calendar.SECOND, 0);
                                                            deliveryDates = calendars.getTime();
                                                        }

                                                        // Cập nhật giá trị mới của deliveryDate vào biến trong phần JSP
                                                        pageContext.setAttribute("deliveryDate", deliveryDates);
                                                        SimpleDateFormat dateFormats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                                        String dateStrings = dateFormats.format(deliveryDates);

                                                        // Chuyển đổi thành Timestamp
                                                        Timestamp timestamps = Timestamp.valueOf(dateStrings);
                                                        out.print(dateStrings);
                                                    %>
                                                </p>

                                            </c:if>
                                        </div>

                                        <button type="submit" name="action" value="ShowCart">Change Time</button>
                                    </div>
                                    <p class="product-price" name="dongia" >${tea.dongia}00 VND<p>
                                    <p class="product-remove">
                                        <input class="trash-can" type="submit" name="action" value="Remove">
                                    </p>
                                </div>
                            </div>

                    </form>
                    <div class="note">
                        Tin nhắn:
                        <textarea class="ct" name="fRContent" placeholder="Lưu ý cho nhân viên..."></textarea>
                    </div>

                </c:forEach>
            </c:if>		
            <div class="add">
                <a href="ListAllServices">Add more!</a>
            </div>
            <div class="cart-total">
                <p>
                    <span>Number of Items</span>
                    <span>${list}</span>
                </p>
                <p>
                    <span>Total Price</span>
                    <span>${total}00 VND đồng</span>

                </p>
                <a class ="checkout" id="checkout" href="MainController?action=Checkout">Checkout</a>
                <input type="submit" name="action" value="RemoveAll"></input> 
            </div>
        </div>
    </div>
</body>
</html>








