<%-- 
    Document   : ManageHome
    Created on : Jul 14, 2023, 11:54:50 AM
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
        .form-filter{
            margin-top: 20px;
        }
        .nhi-css{
            display: flex;
        }
    </style>
    <body>
        <div id="demo">
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
            <div class="drop3">                       
                <div class="dropdown3">
                    <div class="listbox__button js-sort active ">
                        <div class="nhi-css">
                            <svg xmlns="http://www.w3.org/2000/svg" version="1.1" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:svgjs="http://svgjs.com/svgjs" width="50" height="50" x="0" y="0" class="larger-icon" viewBox="0 0 32 32" style="enable-background:new 0 0 512 512" xml:space="preserve" class=""><
                            <g>
                            <path fill="#111111" fill-rule="nonzero" d="M9 7v15.584l1.293-1.291 1.414 1.414L8 26.414l-3.707-3.707 1.414-1.414L7 22.584V7zm9 15v2h-5v-2zm3-5v2h-8v-2zm3-5v2H13v-2zm3-5v2H13V7z" data-original="#111111" class=""></path>
                            </g>
                            </svg>

                            <!--                    <button class="dropbtn">Sắp xếp theo: </button>-->
                            <div class="form-filter">
                                <form action=""> 
                                    <select name="Building" onchange="loadBuidling(this.value)" id="Building">
                                        <option value="">Sắp xếp theo tòa: ${param.Building}</option>
                                        <option value="S1">S1</option>
                                        <option value="S2">S2</option>
                                        <option value="S3">S3</option>
                                        <option value="S4">S4</option>
                                        <option value="S5">S5</option>
                                        <option value="S6">S6</option>
                                        <option value="S7">S7</option>
                                        <option value="S8">S8</option>
                                        <option value="S9">S9</option>
                                        <option value="S10">S10</option>
                                    </select>
                                </form>
                            </div>
                        </div>
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
                .drop3{
                    margin-top: 20px;
                    float: right;
                    margin-right: 50px;
                }

                /* Dropdown Content (Hidden by Default) */
                .dropdown-content {
                    display: none;
                    position: absolute;
                    background-color: #f1f1f1;
                    min-width: 152px;
                    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                    /* margin-top: 40px;*/
                    /*            margin-right: 20px;*/
                    margin-left: 35px;
                    margin-bottom: 70px;
                    z-index: 1;
                }

                /* Links inside the dropdown */
                .dropdown-content a {
                    color:black;
                    padding: 4px 6px;
                    text-decoration: none;
                    display: block;
                }

                /* Change color of dropdown links on hover */
                .dropdown-content a:hover {background-color: #ddd;}

                /* Show the dropdown menu on hover */
                .dropdown3:hover .dropdown-content {display: block;}

                /* Change the background color of the dropdown button when the dropdown content is shown */
                .dropdown3:hover .dropbtn {background-color: #143b15;}

                /*Button addtocart and details*/
                .button-add{
                    display: flex;
                }
                .btn-details{
                    margin-left: 15vh;
                }
            </style>

            <div class="row">
                <div class="">
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
                                        <th scope="col" class="column5">Hủy</th>
                                    </tr>
                                </thead>
                                <c:if test="${requestScope.LIST_BUIDING != null}">
                                    <c:if test="${ not empty requestScope.LIST_BUIDING}">
                                        <c:forEach items="${requestScope.LIST_BUIDING}" var="o" varStatus="counter">
                                            <c:url value="/ChangeEmployee" var="up">
                                                <c:param name="OrderID" value="${o.orderID}"></c:param>
                                                <c:param name="CustomerAddress" value="${o.customerDetail.customerAddress}"></c:param>
                                            </c:url>
                                            <form action="DivideWorkController" method="POST"> 
                                                <tbody>
                                                    <tr>
                                                        <td>${o.customerDetail.customer.customerName}</td>
                                                        <td ><input type="text" value="${o.orderID}" name="OrderID" id="OrderID" readonly="true" class="text-id"></td>
                                                        <td >${o.orderDServiceName}</td>
                                                        <td>
                                                            <input type="hidden" value="${o.customerDetail.customerAddress}" id="CustomerAddress">
                                                            <button type="button"><a href="${up}">Chọn nhân viên</a></button>
                                                        </td>
                                                        <td>
                                                            <p><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${o.timeStart}"/></p>
                                                        </td>
                                                        <td>
                                                            <select name="ServiceTime">
                                                                <option value="${o.serviceTime}">${o.serviceTime}h</option>
                                                                <option value="3">3h</option>
                                                                <option value="4">4h</option>
                                                            </select>
                                                        </td>
                <!--                                                <td><input type="datetime-local" value="${o.timeEnd}"></td>-->
                                                        <td>${o.status}</td>
                                                        <td>${o.customerDetail.customerAddress}</td>
                                                        <td><span class="badge badge-dot mr-4">                                                      
                                                                <a class="btn-cancel" onclick="myFunction()" href="CancelManage?OrderID=${o.orderID}"><img src="image/icon/icon-cancel.png"></a> 
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
                                            .btn-cancel img{
                                                margin-left: 2vh;
                                                width:20px;
                                                height: 20px;
                                            }
                                        </style>
                                    </c:if>
                                </c:if>
                            </div>
                        </table>                                       
                    </div>
                </div>

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
                    alert("Thời gian giao hàng phải sau thời điểm hiện tại");
                    return false;
                }

                var deliveryHour = deliveryDateTime.getHours();

                // Kiểm tra nếu giờ giao hàng không nằm trong khoảng từ 7h sáng đến 21h tối
                if (deliveryHour < 7 || deliveryHour >= 21) {
                    // Thời gian giao hàng không hợp lệ
                    alert("Thời gian giao hàng phải từ 7h sáng đến 21h tối");
                    return false;
                }

                // Các kiểm tra và xử lý khác nếu cần

                return true; // Hoặc return false nếu không muốn submit form
            }

            function loadBuidling(str) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("demo").innerHTML =
                                this.responseText;
                    }
                };
                xhttp.open("GET", "FilterBuildingController?Building=" + str, true);
                xhttp.send();
            }
        </script>
    </body>
</html>
