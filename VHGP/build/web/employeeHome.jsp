<%-- 
    Document   : employeeHome
    Created on : Jun 19, 2023, 11:15:11 PM
    Author     : Asus
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.OrderDetail"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nhân viên</title>

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

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800,900" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="../css/table.css" rel="stylesheet">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script>

        <style>
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
                background-color: #4dccc6;
                background-image: linear-gradient(315deg, #33a36fb5 0%, #335500 74%);
                line-height: 42px;
                padding: 0;
                border: none;
                text-align: center;
                margin-left: 50%;
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
            .container {
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
            .mdl-card__title {
                background: #0079c1;
                color: #cacaca;
                margin-bottom: 1rem;
                &-text{
                    color: white;
                }
            }



        </style>
    </head>
    <body>
        <div class="all">
            <div class="side-menu">
                <div class="logo">Trang nhân viên</div>
                <div class="menu">
                    <ul> 
                        <ul class="dropdown">
                            <li><a href="EmployeeHome"><i class="fa fa-home" aria-hidden="true"></i><span class="text"> Home</span></a></li>
                            <li><a href="MainController?action=AllJob"><i class="fa fa-star" aria-hidden="true"></i><span class="text"> Tuần</span></a></li>

                        </ul>

                    </ul>
                </div>
            </div>

            <div class="wrapper">
                <div class="main-content">
                    <div class="topmenu">
                        <div class="search">
                            <input  type='text' class='src' placeholder='Search for cards...'/>
                        </div>
                        <div class="dropdown2">
                            <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                </svg>  <b class="caret"> Nhân viên</b>
                            </a>
                            <div class="dropdown-content">
                                <a href="MainController?action=ViewA"><li class="profile">Profile</li></a>
                                <a href="#"><li class="profile">Setting</li></a>
                                <a href="LogoutController"><li class="profile">Logout</li></a>
                            </div>
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
                        background: #136036;
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
                <c:set var="CountOrder" scope="request" value="${COUNT_ORDER}" />
                <main class="s-layout__content">
                    <div class="full-wrapper">
                        <div class="slide-container">
                            <div class="form-container">
                                <div class="metroblock buysblock left ">
                                    <span class="icon fontawesome-briefcase left"></span>
                                    <h1 style="padding: 25px 0px;"> <c:out value="${CountOrder}"/></h1>
                                    <div class="clear"></div>                   
                                </div>



                                <!-- BEGIN LOGIN FORM -->
                                <%
                                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aaa");
                                    ArrayList<OrderDetail> list = (ArrayList) request.getAttribute("DETAIL_ORDER");
                                %>
                                <div class="row-emp">
                                    <form action="ConfirmWork" class="form-emp">
                                        <c:set var="context" value="${pageContext.request.contextPath}"/>
                                        <c:if test="${requestScope.EMPLOYEE_ORDER != null}">
                                            <c:if test="${ not empty requestScope.EMPLOYEE_ORDER}">
                                                <c:forEach items="${requestScope.EMPLOYEE_ORDER}" var="pro" varStatus="counter">
                                                    <c:set var="timeStart" value="${pro.orderDetail.timeStart}"/>
                                                    <c:set var="timeEnd" value="${pro.orderDetail.timeEnd}"/>
                                                    <div class="frame">
                                                        <div class="panel">
                                                            <div class="notifications clearfix">
                                                                <div class="line"></div>
                                                                <div class="notification">
                                                                    <div class="circle"></div>
                                                                    <span class="time"><b>Đơn dịch vụ: ${pro.orderID} </b></span></br>
                                                                    <p><b>Dịch vụ: ${pro.orderDetail.orderDServiceName} - ${pro.orderDetail.serviceTime}h</b></p>
                                                                    <p><b>Tên khách hàng</b> ${pro.customer.customerName}</p>
                                                                    <p><b>Địa chỉ khách hàng</b> ${pro.customerDetail.customerAddress}</p>
                                                                    <p><b>Số điện thoại</b> ${pro.customer.phone}</p>
                                                                    <p><b>Hình thức thanh toán </b>${pro.orderDetail.pay}</p>
                                                                    <p><b>Ghi chú </b>${pro.orderNote}</p>
                                                                    <p><b>Tên nhân viên</b> ${pro.employee.employeeName}</p>
                                                                    <p><b>Trạng thái</b> ${pro.status.statusName}</p>
                                                                    <p><b>Thời gian bắt đầu </b><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${timeStart}"/></p>
                                                                    <p><b>Thời gian kết thúc </b><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${timeEnd}"/></p>
                                                                    <p><b></b></p>

                                                                    <a class="button-finished" href="ConfirmWork?OrderID=${pro.orderID}">Hoàn thành</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </c:forEach>  
                                            </c:if>
                                        </c:if>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
    </body>
</html>
