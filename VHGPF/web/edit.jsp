<%-- 
  Document   : TestList
  Created on : May 25, 2023, 8:58:27 PM
  Author     : Asus
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Category"%>
<%@page import="model.Services"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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

        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết dịch vụ</title>
    </head>
    <body>
        <!--        <h1>Chi tiết</h1>-->
        ${requestScope.MESSAGE}</a>
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
                    <a href="listOfServices.jsp" class="logo m-0 float-start">Services</a>

                    <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end">
                        <li><a href="login.jsp">Home</a></li>
                        <li class="has-children">
                            <a href="listOfServices.jsp">Services</a>
                            <ul class="dropdown">
                                <li><a href="#">Buy Property</a></li>
                                <li><a href="#">Sell Property</a></li>
                                <li class="has-children">
                                    <a href="#">Dropdown</a>
                                    <ul class="dropdown">
                                        <li><a href="#">Sub Menu One</a></li>
                                        <li><a href="#">Sub Menu Two</a></li>
<li><a href="#">Sub Menu Three</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="services.html">Services</a></li>
                        <li><a href="about.html">About</a></li>
                        <li class="active"><a href="contact.html">Contact Us</a></li>
                        <c:set var="name" value="${LOGIN_USER.customerName}" />
                        <c:if test="${not empty name}">
                        <li class="dropdown">
                        <li class="has-children">
                            <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                </svg>  <b class="caret"> ${LOGIN_USER.customerName} </b></a>

                            <ul class="dropdown">

                                <li><a href="#">Profile</a></li>
                                <li><a href="#">Setting</a></li>
                                <li><a href="LogoutController">Logout</a></li>

                            </ul>
                        </li> 

                    </c:if>         
                    </ul>

                    <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                        <span></span>
                    </a>

                </div>
            </div>
        </div>
    </nav>
    <div class="hero page-inner overlay" style="background-image: url('image/donnha.jpg');">
        <div class="container">
            <div class="row justify-content-center align-items-center">
                <div class="col-lg-9 text-center mt-5">
                    <h1 class="heading" data-aos="fade-up">${pro.serviceID}</h1>

                    <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                        <ol class="breadcrumb text-center justify-content-center">
                            <li class="breadcrumb-item"><a href="login.jsp">Home</a></li>
                            <li class="breadcrumb-item"><a href="IndexServices">Services</a></li>
    <!--                        <li class="breadcrumb-item active text-white-50" aria-current="page">${pro.serviceID}</li>-->
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="overlay-text">
            <h2 class="text-center">Details Services</h2>
        </div>
        <style>
            .hero.page-inner {
                position: relative;
            }

            .overlay-text {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                text-align: center;
            }
            .text-center{
                color: white;

            }

            .overlay-text h2 {
                color: whitesmoke;
                /*    font-size: 24px;
                    font-weight: bold;*/
                /*    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);*/
            }
        </style>
    </div>

<c:set var="context" value="${pageContext.request.contextPath}" />
<c:if test="${requestScope.DETAILS_SERVICE != null}">
    <c:if test="${not empty requestScope.DETAILS_SERVICE}">
        <c:forEach items="${requestScope.DETAILS_SERVICE}" var="pro" varStatus="counter">
            <div class="section section-properties">
                <div class="container">
                    <div class="row justify-content-between">
                        <div class="col-lg-7">
<div class="img-property-slide-wrap">
                                <div class="img-property-slide">
                                    <a href="" class="img">
                                        <img src="image/${pro.servicePicture}" alt="Image" class="img-fluid">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">

                            <h2> <em>  <b class="meta" style="color:black">${pro.serviceName}</b></em></h2>
<!--                            <h5><I class="meta" style="color:black"></I>✓${pro.serviceDetail}</h5>-->

<!--                          <p class="text-black-50"> <h5>Our service ensures credibility for customers</h5></p>-->
                        <p class="text-black-50"> <h5><em>✓Tạo không gian thoáng đãng, gọn gàng và sạch sẽ.</em></h5></p>
                        <p class="text-black-50"> <h5><em>✓Tiết kiệm thời gian và công sức của bạn.</em></h5></p>
                        <p class="text-black-50"> <h5><em>✓Loại bỏ bụi bẩn và sắp xếp vật dụng một cách thông minh.</em></h5></p>
                        <p class="text-black-50"> <h5><em>✓Mang đến không gian sống thú vị và dễ sống.</em></h5></p>






            <style>
                .h5{
                    font-family: sans-serif;
                }
            </style>
                         
                            
                            <%--<c:set var="context" value="${pageContext.request.contextPath}" />--%>
                            
                                     <form action="MainController">
                                <div>
                                    <input type="hidden" name="ServiceID" value="${pro.serviceID}">
                                    <p>Thời gian:</p>
                                    <select name="ServiceTime">
                                          <option ${ba} value="3">3 tiếng</option>
                                          <option ${bon} value="4">4 tiếng</option>

                                    </select>

<!--                                        <input type="submit" name="action" value="Price">-->
                                        <b><br>${requestScope.HOUR}00 VNĐ</br></b>

                                </div>
                             <a href="MainController?id=${pro.serviceID}&action=Detail" class="btn btn-primary py-2 px-3">Back</a>
<!--                                <a class="btn btn-primary py-2 px-3" href="MainController?cmbTea=${pro.serviceID}-${pro.serviceName}-${pro.servicePrice}-${pro.serviceDetail}-${pro.serviceTime}-${pro.servicePicture}&cmbQuantity=1&action=Order">Order</a>
                            -->
                                  
                            </form>
                                
                            <c:if test="${not empty HOUR_SERVICES}">
<c:forEach items="${requestScope.HOUR_SERVICES}" var="pr" varStatus="counter">
                                
                                <p>Chọn giờ: <span id="selectedHours">${pr.hours}</span></p>
                                <p>Hiện giá: $<strong>${sessionScope.dao.getPriceByHour(pr.serviceID)}</strong></p>
                                 </c:forEach>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
</c:if>


 







    <div class="site-footer">
        <div class="container">

            <div class="row">

                <div class="col-lg-12">
                    <div class="widget">
                        <h3>CONTACT</h3>


                        <ul class="list-unstyled social">
                            <li><a href="#"><span class="icon-instagram"></span></a></li>
                            <li><a href="#"><span class="icon-twitter"></span></a></li>
                            <li><a href="#"><span class="icon-facebook"></span></a></li>
                            <li><a href="#"><span class="icon-linkedin"></span></a></li>
                            <li><a href="#"><span class="icon-pinterest"></span></a></li>
                            <li><a href="#"><span class="icon-dribbble"></span></a></li>
                        </ul>

                    </div> <!-- /.widget -->
                </div> <!-- /.col-lg-4 -->
                <style>
                    .widget{
                        text-align: center;
                        padding: 5px 0px;
                        margin-top: 50px;
                    }
                </style>
            </div> <!-- /.row -->

            <div class="row mt-5">
                <div class="col-12 text-center">

                    <div class="p">
                        <p>Copyright &copy;<script>document.write(new Date().getFullYear());</script>. All Rights Reserved. &mdash; Designed with love by  <a href="https://untree.co"a></a> <!-- License information: https://untree.co/license/ -->
                        </p>
                    </div>
                    <style>
                        .p{
                            color: black;
                        }
                    </style>
                </div>
            </div>
        </div> <!-- /.container -->
    </div> <!-- /.site-footer -->


    <!-- Preloader -->
    <div id="overlayer"></div>
    <div class="loader">
        <div class="spinner-border" role="status">
            <span class="visually-hidden">Loading...</span>
        </div>
    </div>


    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/tiny-slider.js"></script>
    <script src="js/aos.js"></script>
    <script src="js/navbar.js"></script>
    <script src="js/counter.js"></script>
    <script src="js/custom.js"></script>
</body>
</html>



</body>
</html>