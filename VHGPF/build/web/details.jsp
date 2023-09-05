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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">
        <title>Chi tiết dịch vụ</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <!--        <h1>Chi tiết</h1>-->
        ${requestScope.MESSAGE}
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
                                        <li><a href="MainController?action=History">Lịch sử</a></li>
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
        <div class="hero page-inner overlay" style="background-image: url('image/donnha.jpg');">
            <div class="container">
                <div class="row justify-content-center align-items-center">
                    <div class="col-lg-9 text-center mt-5">
                        <h1 class="heading" data-aos="fade-up">${pro.serviceID}</h1>

                        <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                            <ol class="breadcrumb text-center justify-content-center">
                                <li class="breadcrumb-item"><a href="login.jsp">Home</a></li>
                                <li class="breadcrumb-item"><a href="IndexServices">Services</a></li>
                            </ol>
                        </nav>
                    </div>
                </div>
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


        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        <c:set var="context" value="${pageContext.request.contextPath}" />
        <c:if test="${requestScope.DETAILS_SERVICE != null}">
            <c:if test="${not empty requestScope.DETAILS_SERVICE}">

                <div class="row justify-content-between">
                    <div class="col-lg-8">  
                        <c:forEach items="${requestScope.DETAILS_SERVICE}" var="pro" varStatus="status">
                            <c:if test="${status.index == 0}">
                                <div class="section section-properties">
                                    <div class="container">

                                        <div class="col-lg-7">
                                            <div class="img-property-slide-wrap">
                                                <div class="img-property-slide">
                                                    <div class="anh">
                                                        <a href="" class="img">
                                                            <img src="${context}/image/${pro.servicePicture}" alt="Image" class="img-fluid enlarged-img">
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </c:if>
                        </c:forEach>
                    </div>

                    <div class="col-lg-4">

                        <c:set var="serviceName" value="" />
                        <c:forEach items="${requestScope.DETAILS_SERVICE}" var="pro" varStatus="status">
                            <c:if test="${status.index == 0}">
                                <div class="md">
                                    <c:set var="serviceName" value="${pro.serviceName}" />
                                </div>
                            </c:if>
                        </c:forEach>

                        <h2><em><b class="meta" style="color:black">${serviceName}</b></em></h2>

                        <p class="text-black-50"> <h5><em>✓Tạo không gian thoáng đãng, gọn gàng và sạch sẽ.</em></h5></p>
                        <p class="text-black-50"> <h5><em>✓Tiết kiệm thời gian và công sức của bạn.</em></h5></p>
                        <p class="text-black-50"> <h5><em>✓Loại bỏ bụi bẩn và sắp xếp vật dụng một cách thông minh.</em></h5></p>
                        <p class="text-black-50"> <h5><em>✓Mang đến không gian sống thú vị và dễ sống.</em></h5></p>
                        <p class="text-black-50"> <b><h5><em>✓Hãy chọn thời gian mà bạn muốn trải nghiệm: </em></h5></b></p>

                        <style>
                            .h5{
                                font-family: sans-serif;
                            }
                            .md{
                                padding-bottom: 60px;
                                padding-left: 50px;
                            }
                            .enlarged-img {
                                width: 150%;
                                max-width: 400%; /* Điều chỉnh kích thước ảnh theo nhu cầu */
                                height: auto;
                                margin-bottom: 50px;
                                margin-left: 50px;
                                margin-right: 20px;
                                margin-top: 50px;
                                padding-bottom: 50px;
                                /*                                padding-left: 50px;*/
                                padding-right: 50px;
                                padding-top: 5px;
                            }

                        </style>




                        <div class="wrapper">
                            <form action="MainController">

                                <!--                                <div class="title">Chọn thời gian mà bạn muốn!</div>-->
                                <c:forEach items="${requestScope.DETAILS_SERVICE}" var="pro" varStatus="counter">
                                    <div class="button-group">
                                        <div class="button-container">
                                            <input type="hidden" id="age1" name="action" value="Add" checked>
                                            <a class="btn btn-primary py-2 px-3" href="MainController?cmbTea=${pro.serviceID}-${pro.serviceName}-${pro.servicePrice}-${pro.serviceDetail}-${pro.serviceTime}-${pro.servicePicture}-<%=new java.util.Date()%>&action=Add">Add to cart<span class="cart-item"></span></a>                                    </div>
                                        <div class="button-container">
                                            <a href="MainController?id=${pro.serviceID}&action=homepage" class="btn btn-primary py-2 px-3">Back</a>
                                        </div>
                                    </div>
                                </c:forEach>


                            </form>
                        </div>
                        <style>
                            .button-container {
                                margin: 10px;

                            }

                            .box{
                                /*                                padding-top: 100px;*/
                                padding: 0px;
                                /*                                margin-top: 15px;*/
                            }

                            .button-group {
                                display: flex;
                                justify-content: center;
                                text-align: center;
                                margin-bottom: 20px; /* Thay đổi giá trị margin-bottom */
                                padding-bottom: 11px;


                            }
                            .add-to-cart{
                                padding-right: 50px;
                            }
                            .btn.btn-primary.py-2.px-3{
                                background: #156B3F;
                            }
                            .wrapper{
                                margin-bottom: 40px;
                            }


                        </style>
                        <c:forEach items="${requestScope.DETAILS_SERVICE}" var="pro" varStatus="status">
                            <c:if test="${status.index == 0}">
                                <div class="md">
                                </div>
                            </c:if>
                        </c:forEach>
                        </form>



                    </div>
                </div>

            </div>


            <style>

                .menu-bg-wrap{
                    background: rgba(10,50,30,0.95);
                }
                .btn.btn-primary{
                    background: rgba(10,50,30,0.95);
                }
                *{
                    margin: 0;
                    padding: 0;
                    box-sizing: border-box;
                    font-family: 'Poppins', sans-serif;
                }

                .wrapper{
                    width: 350px;
                    background: #fff;
                    border-radius: 10px;
                    box-shadow: 5px 5px 30px rgba(0,0,0,0.2);
                }
                .wrapper .title{
                    color: #fff;
                    line-height: 65px;
                    text-align: center;
                    background: #333;
                    font-size: 25px;
                    font-weight: 500;
                    border-radius: 10px 10px 0 0;
                }
                .wrapper .box{
                    padding: 20px 30px;
                    background: #fff;
                    border-radius: 10px;
                }
                .wrapper .box label{
                    display: flex;
                    height: 53px;
                    width: 100%;
                    align-items: center;
                    border: 1px solid lightgrey;
                    border-radius: 50px;
                    margin: 10px 0;
                    padding-left: 20px;
                    cursor: default;
                    transition: all 0.3s ease;
                }
                #option-1:checked ~ .option-1,
                #option-2:checked ~ .option-2,
                #option-3:checked ~ .option-3,
                #option-4:checked ~ .option-4{
                    background: #333;
                    border-color: #333;
                }
                .wrapper .box label .dot{
                    height: 20px;
                    width: 20px;
                    background: #d9d9d9;
                    border-radius: 50%;
                    position: relative;
                    transition: all 0.3s ease;
                }
                #option-1:checked ~ .option-1 .dot,
                #option-2:checked ~ .option-2 .dot,
                #option-3:checked ~ .option-3 .dot,
                #option-4:checked ~ .option-4 .dot{
                    background: #fff;
                }
                .box label .dot::before{
                    position: absolute;
                    content: "";
                    top: 50%;
                    left: 50%;
                    transform: translate(-50%, -50%) scale(2);
                    width: 9px;
                    height: 9px;
                    border-radius: 50%;
                    transition: all 0.3s ease;
                }
                #option-1:checked ~ .option-1 .dot::before,
                #option-2:checked ~ .option-2 .dot::before,
                #option-3:checked ~ .option-3 .dot::before,
                #option-4:checked ~ .option-4 .dot::before{
                    background: #333;
                    transform: translate(-50%, -50%) scale(1);
                }
                .wrapper .box label .text{
                    color: #333;
                    font-size: 18px;
                    font-weight: 400;
                    padding-left: 10px;
                    transition: color 0.3s ease;
                }
                #option-1:checked ~ .option-1 .text,
                #option-2:checked ~ .option-2 .text,
                #option-3:checked ~ .option-3 .text,
                #option-4:checked ~ .option-4 .text{
                    color: #fff;
                }
                .wrapper .box input[type="radio"]{
                    display: none;
                }
                .footer{
                    background:rgba(10,50,30,0.95);
                    color: white;
                    text-align: center; 
                    padding: 40px 10px;
                    font-size: 15px;
                }

            </style>
        </c:if>
    </c:if>


    <h1 class="title">Đánh giá dịch vụ</h1>
    <c:if test="${requestScope.LIST_FEEDBACK!= null}">
        <c:if test="${not empty requestScope.LIST_FEEDBACK}">
            <c:forEach items="${requestScope.LIST_FEEDBACK}" var="fb">
                <div class="container-fb">
                    <div class="feedback-box">
                        <!-- Feedback items will be dynamically added here -->
                        <b>${fb.customer.customerName}</b> - <b>${fb.service.serviceName}</b>
                        <p>${fb.reviewDate}</p>
                        <span class="fa fa-star checked" for="star5" value="${fb.reviewRating}"></span>
                        <p>${fb.comment}</p>
                    </div>
                    <div class="image-fb">
                        <img src="${context}/image/${fb.reviewPicture}" alt="Image" class="img-fb">
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </c:if>


    <style>
        @import url(//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);

        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        .container-fb {
            max-width: 800px;
            margin: 0 auto 20px;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }

        .feedback-box {
            margin-top: 20px;
            flex: 4;
            margin-right: 20px;
        }

        .feedback-item {
            background-color: #f9f9f9;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-bottom: 10px;
        }

        .feedback-item p {
            margin: 0;
        }

        .feedback-item .name {
            font-weight: bold;
        }

        .feedback-item .date {
            font-size: 12px;
            color: #999;
        }
        .title{
            margin-left: 40%;
        }
        .image-fb {
            flex: 1;
            text-align: right;
        }

        .img-fb {
            max-width: 150px; /* Adjust this as per your requirements */
            max-height: 150px; /* Adjust this as per your requirements */
        }
    </style>

    <div class="footer">
        <b>Dịch vụ vệ sinh nhà cửa VinHome Grand Park</b></br>
        <b>Nguyễn Xiển, phường Long Thạnh Mỹ, Tp.Thủ Đức, TPHCM.</b></br>
        <a href='https://www.facebook.com/'><img style="width:40px; height: 40px; margin: 15px 0" src="image/icon/fb.png"></a>
    </div>

</body>
</html>