<%-- 
    Document   : search
    Created on : Feb 17, 2023, 3:17:56 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Services"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
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
            .hero-slide .img {
                height:50vh;
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
    </head>
    <body>

<!--    ${requestScope.MESSAGE}</a>-->

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

                                        <li><a href="#">Profile</a></li>
                                        <li><a href="#">Setting</a></li>
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

        <div class="hero">
            <div class="hero-slide">
                <div class="img overlay tns-item img-banner" style="background-image: url('image/banner3.jpg'); height:50%"></div>
            </div>

            <div class="container">
                <div class="row justify-content-center align-items-center">
                    <div class="col-lg-9 text-center">

                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="box row  ">
                <div class="col-lg-9 text-center">
                    <form action="MainController" class="narrow-w form-search d-flex align-items-stretch mb-3 justify-content-center align-items-center" >
                        <input class=" form-search form-control px-4" type="text" name="searchName" placeholder="search..." value="${param.searchName}" />
                        <input type="submit" class="btn btn-primary search" name="action" value="search"/>  
                    </form>
                    <!--                <i class="fas fa-search"></i>-->
                </div>
                <div class="col-lg-3 justify-content-right" style="display:flex;padding-bottom: 20px">   
                    <a class="se justify-content-left"></a>
                    <a class="se justify-content-right" href="ViewCart.jsp" > 
                        <img style="width:40px; height: 40px" src="https://cdn.pixabay.com/photo/2013/07/12/14/53/cart-148964_1280.png" alt="se" style="width:20px;height:20px" /></br>
                    </a>
                    <!--                <a class="se justify-content-center" href="AccountInfoController">
                                        <img style="width:40px; height: 40px" src="image/avatar/icon2.png">
                                    </a>-->
                </div>        
            </div>
            <div class="row align-items-center">
                <div class="col-lg-6">
                    <h2 class="font-weight-bold text-primary heading">Dịch vụ được tìm thấy</h2>
                </div>
                <div class="col-lg-6 text-lg-end">
                    <p><a href="ListAllServices" target="_blank" class="btn btn-primary text-white py-3 px-4">Xem tất cả dịch vụ</a></p>
                </div>
            </div>

        </div>          


        <div class="site-mobile-menu site-navbar-target">
            <div class="site-mobile-menu-header">
                <div class="site-mobile-menu-close">
                    <span class="icofont-close js-menu-toggle"></span>
                </div>
            </div>
            <div class="site-mobile-menu-body"></div>
        </div>

        <%
            //            List<Services> list = (List<Services>) request.getAttribute("SERACH_RESULT");
            ArrayList<Services> list = (ArrayList) request.getAttribute("SEARCH_RESULT");
        %> 
        <div class="row">
            <%
                for (Services sp : list) {
            %>
            <div class="col-lg-4 mb-3 d-flex align-items-stretch">
                <div class="property-item mb-30">
                    <div class="property-item">
                        <center>
                            <a href="" class="img">
                                <img src="image/<%=sp.getServicePicture()%>" width="100%" height="400" alt="Image" class="img-fluid">
                            </a>
                        </center>
                        <div class="property-content">
                            <!--Service ID : <div class="price mb-2"><span><%=sp.getServiceID()%></span></div>-->

                            <!--<div class="price mb-2"><span><%=sp.getServicePrice()%>00 VND - <%=sp.getServiceTime()%>h</span></div>-->
                            <div>
                                <span class="city d-block mb-3"><%=sp.getServiceName()%></span>
                                <b class="city d-block mb-3 text-black-50"><%=sp.getServiceDetail()%></b>
                                <!--<a class="btn btn-primary py-2 px-3 add-to-cart" href="MainController?cmbTea=<%=sp.getServiceID()%>-<%=sp.getServiceName()%>-<%=sp.getServicePrice()%>-<%=sp.getServiceDetail()%>-<%=sp.getServiceTime()%>-<%=sp.getServicePicture()%>&action=Add">Add to cart</a>-->
                                <a href="MainController?id=<%=sp.getServiceID()%>&action=Detail" class="btn btn-primary py-2 px-3">See details</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <style>
                .property-item{
                    padding-left: 20px;
                    padding-right: 10px;
                    padding-bottom: 20px;
                    padding-top: 20px;
                }
                .img-fluid{
                    padding-left: 20px;
                    padding-right: 20px;
                    display: flex;
                    max-width: 100%;
                    height: 400px; 
                    margin-top: 20px;
                }
                .footer{
                    background:rgba(10,50,30,0.95);
                    color: white;
                    text-align: center; 
                    padding: 40px 10px;
                    font-size: 15px;
                }

            </style>  
            <%
                }
            %>
        </div>


    </tbody>

    <div class="footer">
        <b>Dịch vụ vệ sinh nhà cửa VinHome Grand Park</b></br>
        <b>Nguyễn Xiển, phường Long Thạnh Mỹ, Tp.Thủ Đức, TPHCM.</b></br>
        <a href='https://www.facebook.com/'><img style="width:40px; height: 40px; margin: 15px 0" src="image/icon/fb.png"></a>
    </div>
</body>
</html>
