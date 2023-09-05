<%-- 
    Document   : historyOrder
    Created on : Jun 17, 2023, 2:15:10 AM
    Author     : Asus
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.OrderDetail"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lịch sử mua hàng</title>

        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">


        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">

        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

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
            }

            .empty-list{
                text-align: center;
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
                                        <li><a href="ConfirmBillCustomerController">Hóa đơn</a></li>
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
            <style>
                @import url(http://weloveiconfonts.com/api/?family=fontawesome);
                @import url(https://fonts.googleapis.com/css?family=Open+Sans:400,300);

                /* fontawesome */
                [class*="fontawesome-"]:before {
                    font-family: 'FontAwesome', sans-serif;
                }
                .left {
                    float: left;
                }
                .clear {
                    clear: both;
                }

                .buysblock {
                    margin: 30px;
                    background: #89bb9f;
                    padding: 20px 30px;
                }
                .commentsblock {
                    background: rgb(39,183,121);
                }

                .metroblock {
                    width: 21em;
                    padding: 0em 1em 1em 1em;
                    color: #fff;
                    font-family: 'Open Sans', sans-serif;
                    margin: 1em;
                    background: #136036;
                    padding: 30px 10px;
                    margin: 30PX;
                }

                .metroblock h1, .metroblock h2, .metroblock .icon {
                    font-weight: 300;
                    margin: 0;
                    padding: 0;
                }
                .metroblock .icon {
                    font-size: 7em;
                    text-align: center;
                }
                .metroblock .icon {
                    margin-right: .2em;
                }
                h1{
                    color: white;
                    text-align: center;
                    font-size: 80px;
                }
                .form-container{
                    display: flex;
                    flex-direction: column;
                }
            </style>
            <!--            metroblock buysblock left -->

        </nav>

        <!--                                PHẦN TABLE-->
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500&display=swap');

            :root{
                --main-color: #11101d;
                --color-dark: #1D2231;
                --text-grey:  #8390A2;
            }
            .cards{
                display: grid;
                grid-template-columns: repeat(3, 1fr);
                grid-gap: 2rem;
                margin-top: 1rem;
                margin-bottom: 2rem;
            }
            .card-single{
                display: flex;
                justify-content: space-between;
                background: #b4e9b7;
                padding: 1rem 2rem ;
                border-radius: 12px;
                box-shadow: 0 5px 10px rgba(154,160,185,.05), 0 15px 40px rgba(166,173,201,.2);
            }
            .card-single div:last-child span{
                color: #212529;
            }
            .card-single div:first-child span{
                color: #212529;
                font-size: 3rem;
            }
            .card-single:last-child{
                background: #b4e9b7;
            }
            .card-single:last-child h1,
            .card-single:last-child div:first-child span,
            .card-single:last-child div:last-child span
            {
                color: #212529;
            }

            .recent-grid{
                margin-top: 3.5rem;
                display: grid;
                grid-gap: 2rem;
                grid-template-columns: 65% auto;

            }
            .card{
                background: #fff;
                border-radius: 12px;
                box-shadow: 0 5px 10px rgba(154,160,185,.05), 0 15px 40px rgba(166,173,201,.2);
                padding: 1rem;
            }
            .card-header
            {
                padding: 1rem;
            }
            .card-header{
                display: flex;
                justify-content: space-between;
                align-items: center;
                border-bottom: 1px solid #f0f0f0;
            }
            .card-header button{
                background: var(--main-color);
                border-radius: 10px;
                color: #fff;
                font-size: .8rem;
                padding: .5rem 1rem;
                border:1px solid var(--main-color);
            }
        </style>
        <div class="container">
            <div class="cards">
                <div class="card-single">
                    <div>
                        <span class="fa fa-bullhorn"></span>
                    </div>
                    <div><c:set var="CountOrder" scope="request" value="${COUNT_ORDER}" />
                        <h3 style="font-size: 40px;"><c:out value="${CountOrder}"/></h3>
                        <span></span>
                    </div>
                </div>
                <div class="card-single">
                    <div>
                        <span class="fa fa-money"></span>
                    </div>
                    <div><c:set var="CountOrder" scope="request" value="${SUM_ORDER}" />
                        <h3 style="font-size: 40px;"><c:out value="${SUM_ORDER}00 VND"/></h3>
                        <span></span>
                    </div>
                </div>
            </div>

            <div>

                <!--            TABLE-->
                <ul class="menu-mini">
                    <li class="mini"><a class="active" href="MainController?action=History&status=1">Hoạt động</a></li>
                    <li class="mini"><a href="MainController?action=History&status=2">Hoàn thành</a></li>
                    <li class="mini"><a href="MainController?action=History&status=3">Hủy</a></li>
                </ul>
                <table id="cart" class="table table-hover table-condensed">
                    <thead>
                        <tr>
                            <th style="width:30%">Dịch vụ</th>
                            <th style="width:15%">Thời gian bắt đầu</th>    
                            <th style="width:15%">Thời gian kết thúc</th>   
                            <th style="width:22%" class="text-center">Tổng</th>
                            <th style="width:22%">Trạng Thái</th>
                            <th style="width:10%"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="context" value="${pageContext.request.contextPath}"/>
                        <c:if test="${requestScope.HISTORY_ORDER != null}">
                            <c:if test="${ not empty requestScope.HISTORY_ORDER}">
                                <c:forEach items="${requestScope.HISTORY_ORDER}" var="pro" varStatus="counter">
                                    <tr>
                                        <td data-th="Product">
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <h4 class="nomargin" style="align-items: center">${pro.orderDServiceName}</h4>
                                                    <p></p>
                                                </div>
                                                <c:url value="/DirectionFeedback" var="feedback">
                                                    <c:param name="ServiceID" value="${pro.serviceID}"></c:param>
                                                    <c:param name="ServiceName" value="${pro.orderDServiceName}"></c:param>
                                                </c:url>
                                            </div>
                                        </td>
                                        <td data-th="Price"></b><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${pro.timeStart}"/></td>
                                        <td data-th="Price"></b><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${pro.timeEnd}"/></td>
                                        <td data-th="Subtotal" class="text-center">${pro.orderDServicePrice}00 VND</td>
                                        <c:set var="StatusOrder" value="${pro.status}" />
                                        <c:choose>
                                            <c:when test="${StatusOrder eq 'Hoạt động'}">
                                                <td class="actions" data-th="">
                                                    <img src="https://cdn-icons-png.flaticon.com/512/3202/3202834.png">
                                                    ${pro.status}
                                                </td>
                                                <td><a onclick="myFunction()" href="CancelOrderCustomer?OrderID=${pro.orderID}">Hủy</a> </td>
                                            </c:when>
                                            <c:when test="${StatusOrder eq 'Hoàn thành'}">
                                                <td class="actions">
                                                    <img src="https://icon-library.com/images/completed-icon/completed-icon-6.jpg">
                                                    ${pro.status}
                                                </td>

                                                <td>
                                                    <c:if test="${not empty feedbackMessage}">
                                                        <div id="feedbackMessage">${feedbackMessage}</div>
                                                    </c:if>
                                                    <a href="${feedback}" onclick="hideFeedback()">Feedback</a>
                                                </c:when>
                                                <c:when test="${StatusOrder eq 'Hủy'}">
                                                <td class="actions">
                                                    <img src="https://img.freepik.com/free-icon/multiply_318-350486.jpg">
                                                    ${pro.status}
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                        <h2 class="empty-list"> Hiện tại chưa có hóa đơn</h2>
                                        <h2 class="smile" style="font-size: 50vh; text-align:center; color:#000000">&#9786</h2>
                                    </c:otherwise>
                                </c:choose>

                                </tr>
                            </c:forEach>
                        </c:if>
                    </c:if>


                    </tbody>

                    <tfoot>
                        <tr>
                            <td><a href="MainController?action=ListService" class="btn btn-success">Trang dịch vụ</i></a></td>
                            <td colspan="2" class="hidden-xs"></td>

                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>



        <script>
            function myFunction() {
                confirm("Bạn có muốn hủy dịch vụ đã đặt");
            }

            function hideFeedback() {
                document.getElementById("feedbackMessage").style.display = "none";
            }

        </script>
    </body>
</html>
<!--https://codepen.io/bonddesign/pen/oxmerE-->