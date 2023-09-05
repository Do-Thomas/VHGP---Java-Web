<%-- 
    Document   : AllManage
    Created on : Jul 15, 2023, 8:58:10 AM
    Author     : Asus
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Employee"%>
<%@page import="model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="dao.OrdersDAO"%>
<%@page import="dao.OrderDetailDAO"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Customer"%>
<%@page import="model.Order"%>
<%@page import="model.OrderDetail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
Document   : ManageHome
Created on : Jul 14, 2023, 11:54:50 AM
Author     : Asus
--%>

<!DOCTYPE html>
<html>
    <head>
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
            /*            min-height: 100%;*/
            overflow: hidden;

        }
        .side-menu {
            width: 250px;
            float: left;
            background: #212529;
            height: auto;
            /*            min-height: 100%;*/
            margin-bottom: -5000px; /* any large number will do */
            padding-bottom: 5000px; 
        }

        .logo {
            background: #222;
            color: #ffffff;
            font-size: 24px;
            font-weight: bold;
            padding: 10px 0px 0px 10px;
            height: 45px;
        }
        .topmenu{
            height: 60px;
            padding: 10px 0px 0px 10px;
            background: #212529;                
            color: #e1e2fa;
            display:flex;
        }

        /*Dropdown Menu*/
        .dropdown2 {

            margin-left: 70%;
        }

        .dropdown-content {
            display:  none;
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
            display: flex;
            flex-direction: column;

        }
        .row{
            margin: 10vh 5vh;
        }
        .user-action{
            color: #fff;
        }
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #111;
        }
        .col-md-8{
            width: 150vh;
            margin-left: 15vh;
        }
        .img-cancel{
            width: 20px;
            height: 20px;
        }
    </style>
    <body>

        <div class="wrapper">
            <div class="main-content">

                <div class="topmenu"><div class="logo">Trang quản lý</div>
                    <div class="dropdown2">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                            <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                            </svg>  <b class="caret"> Manager</b>
                        </a>
                        <div class="dropdown-content">
                            <!--                            <a href=""><li class="profile">Profile</li></a>
                                                        <a href="#"><li class="profile">Setting</li></a>-->
                            <a href="LogoutController"><li class="profile">Logout</li></a>
                        </div>
                    </div>
                </div>
                <ul>
                    <li><a class="active" href="ManageHome">Manager</a></li>
                    <li><a href="LoadManage">Điều chỉnh</a></li>
                </ul>
            </div>
        </div>

        <div class="row">
            <div class="col-md-8">
                <!--                <div class="card shadow">-->
                <div class="card-header border-0">
                    <h3 class="mb-0">Bảng dịch vụ</h3>
                </div>
                <div class="table-responsive">
                    <table class="table align-items-center table-flush table-nhidesgin">
                        <div class="table-column">
                            <thead class="thead-light">
                                <tr>
                                    <th scope="col" class="column1">Khách hàng</th>
                                    <th scope="col" class="column2">Mã dịch vụ</th>
                                    <th scope="col" class="column3">Dịch vụ</th>
                                    <th scope="col" class="column4">Nhân viên</th>
                                    <th scope="col" class="column5">Bắt đầu</th>
                                    <th scope="col" class="column5">Combo</th>
                                    <th scope="col" class="column5">Trạng thái</th>
                                    <th scope="col" class="column5">Địa chỉ</th>
                                </tr>
                            </thead>
                            <c:if test="${requestScope.LIST_ORDER_CUSTOMER != null}">
                                <c:if test="${ not empty requestScope.LIST_ORDER_CUSTOMER}">
                                    <c:forEach items="${requestScope.LIST_ORDER_CUSTOMER}" var="o" varStatus="counter">
                                        <c:url value="/AllManage" var="up">
                                            <c:param name="OrderID" value="${o.orderID}"></c:param>
                                            <c:param name="EmployeeName" value="${o.employee.employeeName}"></c:param>
                                            <c:param name="TimeStart" value="${o.orderDetail.timeStart}"></c:param>
                                        </c:url>
                                        <tbody>
                                        <form action="AllManage" method="POST"> 
                                            <tr>
                                                <td><span class="mb-0 text-sm">${o.customer.customerName}</span></td>
                                                <td ><input type="text" value="${o.orderID}" name="OrderID" readonly="true" class="text-id"></td>
                                                <td >${o.orderDetail.orderDServiceName}</td>
                                                <td>${o.employee.employeeName}</td>
                                                <td>
                                                    <p><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${o.orderDetail.timeStart}"/></p>
                                                    <input type="datetime-local" value="${o.orderDetail.timeStart}" name="TimeStart" id="TimeStart">
                                                </td>
                                                <td>
                                                    <select name="ServiceTime" id="lang-select">
                                                        <option value="${o.orderDetail.serviceTime}">${o.orderDetail.serviceTime}h</option>
                                                        <option value="2">2h</option>
                                                        <option value="3">3h</option>
                                                    </select>
                                                </td>
                                                <td>${o.status.statusName}</td>
                                                <td>${o.customerDetail.customerAddress}</td>
                                                <td><span class="badge badge-dot mr-4">
                                                        <input name="submit" type="submit" value="Up" onclick="return validateDeliveryTime()"/>
                                                        <a class="btn-cancel" onclick="myFunction()" href="CancelManage?OrderID=${o.orderID}"><img class="img-cancel" src="image/icon/icon-cancel.png"></a> 
                                                    </span>
                                                </td>

                                        </form>
                                        <td>
                                            <div class="d-flex align-items-center">
                                                <span class="mr-2"></span>
                                                <div>
                                                    <div class="progress">
                                                        <div class="progress-bar bg-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>       
                                        </tr>
                                    </c:forEach>
                                    <style>
                                        .btn.btn-primary.py-2.px-3.on {
                                            background-color: #156B3F;
                                            color: white;
                                        }

                                        .btn.btn-primary.py-2.px-3.off {
                                            background-color: red;
                                            color: white;
                                        }

                                        /* Định dạng nút bật/tắt */
                                        .btn {
                                            display: inline-block;
                                            padding: 10px 20px;
                                            text-decoration: none;
                                            border-radius: 5px;
                                        }
                                        .btn-primary{
                                            width: 10px;
                                        }
                                        .text-id{
                                            width: 30px;
                                        }
                                        .btn-cancel{
                                            padding-left: 10vh;
                                            color: red;
                                        }
                                    </style>
                                </c:if>
                            </c:if>
                        </div>
                    </table>                                       
                </div>
            </div>


            <script>
                function myFunction() {

                    confirm("Bạn có muốn hủy dịch vụ đã đặt");
                }

                function validateDeliveryTime() {
                    var deliveryDateInput = document.getElementById("TimeStart");
                    var deliveryDateTime = new Date(deliveryDateInput.value);
                    var currentDateTime = new Date();

                    // Kiểm tra nếu thời gian giao hàng không sau thời điểm hiện tại
                    if (deliveryDateTime <= currentDateTime) {
                        // Thời gian giao hàng không hợp lệ
                        alert("Thời gian làm việc phải sau thời điểm hiện tại");
                        return false;
                    }

                    var deliveryHour = deliveryDateTime.getHours();

                    // Kiểm tra nếu giờ giao hàng không nằm trong khoảng từ 7h sáng đến 21h tối
                    if (deliveryHour < 7 || deliveryHour >= 21) {
                        // Thời gian giao hàng không hợp lệ
                        alert("Thời gian làm việc phải từ 7h sáng đến 21h tối");
                        return false;
                    }

                    // Các kiểm tra và xử lý khác nếu cần

                    return true; // Hoặc return false nếu không muốn submit form
                }

            </script>
    </body>
</html>


