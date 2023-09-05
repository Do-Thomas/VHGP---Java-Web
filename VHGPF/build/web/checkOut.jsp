<%-- 
    Document   : checkout
    Created on : May 27, 2023, 4:31:08 PM
    Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin đơn hàng</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <!-- Demo CSS (No need to include it into your project) -->
        <link rel="stylesheet" href="css/demo.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">


        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">
        <style>
            @import url('https://fonts.googleapis.com/css?family=Roboto&display=swap');
            @import url('https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css');
            *{ margin: 0; padding: 0;}
            body{
                font-family: 'Roboto', sans-serif;
                font-style: normal;
                font-weight: 300;
                font-smoothing: antialiased;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;
                font-size: 15px;
                background: #fff;
            }
            .menu-bg-wrap{
                background: rgba(10,50,30,0.95);
            }

            .intro{
                background: #fff;
                padding: 60px 30px;
                color: #333;
                margin-bottom: 15px;
                line-height: 1.5;
                text-align: center;
            }
            .intro h1 {
                font-size: 18pt;
                padding-bottom: 15px;

            }
            .intro p{
                font-size: 14px;
            }

            .action{
                text-align: center;
                display: block;
                margin-top: 20px;
            }
            .btn{
                border-radius: 30px;
            }
            .btn-primary{
                background-color: rgba(10,50,30,0.95);
                border-color: rgba(10,50,30,0.95);
            }
            a.btn {
                text-decoration: none;
                color: #fff;
                border: 2px solid #fff;
                padding: 10px 15px;
                display: inline-block;
                margin-left: 5px;
            }
            a.btn:hover{
                background: #666;
                color: #fff;
                transition: .3s;
                -webkit-transition: .3s;
            }
            /*            .insert a{
                            background-color: rgba(10,50,30,0.95);
                            color: white;
                            border-radius: 25px;
                            padding: 10px;
                            border-collapse: 20px;
                            text-decoration: none;
                            font-size: 15px;
                        }*/
            .insert{
                /*                text-align: right;*/
                margin-bottom: 80px;
            }
            .insert .order{
                float:left;
            }
            .insert .cancel{
                float: right;
                /*                padding-left: 25px;    
                                padding-right: 25px;*/
            }
            .btn:before{
                font-family: FontAwesome;
                font-weight: normal;
                margin-right: 10px;
            }
            .btn-primary:hover{
                background-color: #198754;
                border-color: #198754;
            }
            .github:before{content: "\f09b"}
            .down:before{content: "\f019"}
            .back:before{content:"\f112"}
            .credit{
                background: #fff;
                padding: 12px;
                font-size: 9pt;
                text-align: center;
                color: #333;
                margin-top: 40px;

            }
            .credit span:before{
                font-family: FontAwesome;
                color: #e41b17;
                content: "\f004";


            }
            .credit a{
                color: #333;
                text-decoration: none;
            }
            .credit a:hover{
                color: #1DBF73; 
            }
            .credit a:hover:after{
                font-family: FontAwesome;
                content: "\f08e";
                font-size: 9pt;
                position: absolute;
                margin: 3px;
            }
            main{
                background: #fff;
                padding: 20px;

            }

            article li{
                color: #444;
                font-size: 15px;
                margin-left: 33px;
                line-height: 1.5;
                padding: 5px;
            }
            article h1,
            article h2,
            article h3,
            article h4,
            article p{
                padding: 14px;
                color: #333;
            }
            article p{
                font-size: 15px;
                line-height: 1.5;
            }

            @media only screen and (min-width: 1280px){
                main{
                    max-width: 960px;
                    margin-left: auto;
                    margin-right: auto; 
                    padding: 24px;
                }


            }

            .set-overlayer,
            .set-glass,
            .set-sticky {
                cursor: pointer;
                height: 45px;
                line-height: 45px;
                padding: 0 15px;
                color: #333;
                font-size: 16px;
            }
            .set-overlayer:after,
            .set-glass:after,
            .to-active:after,
            .set-sticky:after {
                font-family: FontAwesome;
                font-size: 18pt;
                position: relative;
                float: right;
            }
            .set-overlayer:after,
            .set-glass:after,
            .set-sticky:after {
                content: "\f204";
                transition: .6s;
            }

            .to-active:after {
                content: "\f205";
                color: #008080;
                transition: .6s;
            }
            .set-overlayer,
            .set-glass,
            .set-sticky,
            .source,
            .theme-tray {
                margin: 10px;
                background: #f2f2f2;
                border-radius: 5px;
                border: 2px solid #f1f1f1;
                box-sizing: border-box;
            }
            /* Syntax Highlighter*/

            pre.prettyprint {
                padding: 15px !important;
                margin: 10px;
                border: 0 !important;
                background: #f2f2f2;
                overflow: auto;
            }

            .source {
                white-space: pre;
                overflow: auto;
                max-height: 400px;
            }
            code{
                border:1px solid #ddd;
                padding: 2px;
                border-radius: 2px;
            }
            .sidebar{
                width: 100%;
                padding: 100px 0 ;
            }
            .momo img{
                height: 20px;
                width: 20px;
            }
            .acb{
                float:right;
            }

            .pay .option-input {
                -webkit-appearance: none;
                -moz-appearance: none;
                -ms-appearance: none;
                -o-appearance: none;
                appearance: none;
                position: relative;
                top: 13.33333px;
                right: 0;
                bottom: 0;
                left: 0;
                height: 20px;
                width: 20px;
                transition: all 0.15s ease-out 0s;
                background: #cbd1d8;
                border: none;
                color: #fff;
                cursor: pointer;
                display: inline-block;
                margin-right: 0.5rem;
                outline: none;
                position: relative;
                z-index: 1000;
            }
            .pay .option-input:hover {
                background: #9faab7;
            }
            .pay .option-input:checked {
                background: #40e0d0;
            }
            .pay .option-input:checked::before {
                width: 40px;
                height: 40px;
                display:flex;
                content: '\f00c';
                font-size: 25px;
                font-weight:bold;
                position: absolute;
                align-items:center;
                justify-content:center;
                font-family:'Font Awesome 5 Free';
            }
            .pay .option-input:checked::after {
                -webkit-animation: click-wave 0.65s;
                -moz-animation: click-wave 0.65s;
                animation: click-wave 0.65s;
                background: #40e0d0;
                content: '';
                display: block;
                position: relative;
                z-index: 100;
            }
            .pay .option-input.radio {
                border-radius: 50%;
            }
            .pay .option-input.radio::after {
                border-radius: 50%;
            }
            .pay{
                margin-bottom: 30px;
            }
            .address-more{
                background:#c1e3c1;
                margin-left: 20%;
            }
            .select-address{
                background: #ebf2eb;
            }
            .cancel{
                margin-right: 430px;
                border-style: solid ;
                border-radius: 45px;
                border-color: rgba(10,50,30,0.95);
            }


        </style>
    </head>
    <body>
        <div class="sidebar"> 
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

                                <c:set var="name" value="${LOGIN_USER.customerName}" />
                                <c:if test="${not empty name}">
                                    <li class="dropdown">
                                    <li class="has-children">
                                        <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                            <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                            </svg>  <b class="caret"> ${LOGIN_USER.customerName} </b></a>
                                        <ul class="dropdown">
                                            <li><a href="ViewCustomer">Profile</a></li>
                                            <li><a href="LogoutController">Logout</a></li>
                                            <li><a href="MainController?action=History&status=1">Lịch sử</a></li>
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
        </div>

        <div class="container"> 
            <div class="row">
                <div class="col-md-4 order-md-2 mb-4">
                    <c:set var="cart" value="${requestScope.CART_CHECKOUT}"/>
                    <c:if test="${not empty requestScope.CART_CHECKOUT}">
                        <c:set var="total" scope="session" value="${0}"/> 
                        <h4 class="d-flex justify-content-between align-items-center mb-3">
                            <span class="text-muted">Thông tin dịch vụ</span>
                            <span class="badge badge-secondary badge-pill">3</span>
                        </h4>
                        <c:forEach var="tea" items="${requestScope.CART_CHECKOUT}" varStatus="counter">
                            <c:set var="total" value="${total + tea.orderDServicePrice}"/>
                            <ul class="list-group mb-3">
                                <li class="list-group-item d-flex justify-content-between lh-condensed">
                                    <div>
                                        <h6 class="my-0">${tea.orderDServiceName}</h6>
                                        <small class="text-muted">${tea.serviceTime} h</small>
                                    </div>
                                    <span class="text-muted">${tea.orderDServicePrice}</span>
                                </li> 
                            </c:forEach>
                        </c:if>
                        <li class="list-group-item d-flex justify-content-between">
                            <span>Tổng </span>
                            <strong>${total}00 VND</strong>
                        </li>
                    </ul> 
                    <div class="note" >
                        Tin nhắn: <br>
                        <textarea style="width: 100%" class="ct" name="fRContent" placeholder="Lưu ý cho nhân viên..."></textarea>
                    </div>

                    <br>
                    <!--<a class="btn btn-primary btn-lg btn-block" style="border-radius: 10px; padding: 5px 5px;" href="ViewCart.jsp">Quay lại giỏ hàng</a>-->
                    <br></br>
                    <div style=" justify-content: space-around" >
                        <p style="color: black">   Hình thức thanh toán </p> 
                        <input style="margin-top: 4px;" type="radio" id="COD" class="pay option-input radio" name="Pay" value="COD"><label for="html">Thanh toán khi hoàn thành</label>
                    </div>

                </div>
                <!--        Thông tin người đặt dịch vụ-->
                <div class="col-md-8 order-md-1">
                    <h4 class="mb-3">Thông tin cá nhân</h4>
                    <form action="MainController" method="POST">
                        <div class="mb-3">
                            <label for="username">Họ và tên</label>
                            <input type="text" class="form-control" id="username" placeholder="" value="${LOGIN_USER.customerName}" required>
                            <div class="invalid-feedback" style="width: 100%;">
                                Valid first name is required.
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="email">Email <span class="text-muted"></span></label>
                            <input type="email" class="form-control" id="email" value="${LOGIN_USER.email}">
                            <div class="invalid-feedback">
                                Please enter a valid email address for shipping updates.
                            </div>
                        </div>
                        <label>Địa chỉ<span></span></label>
                        <select style="padding: 5px 5px;"  class="btn select-address" required name="Address" onchange="updateAddressPhone(this)">
                            <c:forEach items="${Listaddress}" var="users">
                                <option value="${users.customerAddress}">
                                    ${users.customerAddress}
                                </option>
                            </c:forEach>
                        </select>


                        <label style="margin-left: 50px;">Số điện thoại<span></span></label>
                        <select style="padding: 5px 5px;" class="btn select-address" required name="Phone" onchange="updateAddressPhone(this)">
                            <c:forEach items="${Listaddress}" var="users">
                                <option value="${users.phone}">
                                    ${users.phone}
                                </option>
                            </c:forEach>
                        </select>
                        <br>

                        </div>

                        </div>
                        <br>

                        <br>
                        <div class="insert">
                            <a class="order" href=""><input class="btn btn-primary btn-lg btn-block" type="submit" name="action" value="Payment"/></a>
                            <a class="cancel" href=""><input style="background: white; color: black; " class="btn btn-primary btn-lg btn-block" type="submit" name="action" value="Cancel"></a>
                        </div>
                    </form> 
                </div>
            </div>
        </div>
        <script>
            function showCustomer(str) {
                var xhttp;

                xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("txtHint").innerHTML = this.responseText;
                    }
                };
                xhttp.open("GET", "payment.jsp", true);
                xhttp.send();
            }

            function updateAddressPhone(selectElement) {
                var selectedValue = selectElement.value;
                var CustomerAddress = document.getElementById('CustomerAddress');
                var Phone = document.getElementById('Phone');
                var addressPhone = selectedValue.split('-');

                CustomerAddress.value = decodeURIComponent(addressPhone[0]);
                Phone.value = decodeURIComponent(addressPhone[1]);
            }
        </script>
    </body>
</html>


