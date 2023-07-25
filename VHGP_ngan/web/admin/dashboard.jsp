<%@page import="dao.OrderDetailDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Quản trị Admin</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="admin/css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
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
        /*            .menu ul li a:hover {
                        background: #abccc0;
                        border-left: solid 5px #6a75eb;
                        margin-left: -10px;
                        width: 98%;
                    }*/
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

        .btn-hover.color-1 {
            background-image: linear-gradient(to right, #25aae1, #40e495, #30dd8a, #2bb673);
            box-shadow: 0 4px 15px 0 rgba(49, 196, 190, 0.75);
        }
        .img-design{
            width: 15vh;
            height: 10vh;
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

        .actions img{
            /*                background-color: #02e17a;*/
            width: 30px;
            height:30px;
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
        .app-content{
            margin-left: 0px;
        }
    </style>
</head>
<body>

    <div class="all">
        <div class="side-menu">
            <div class="logo">Trang quản lý</div>
            <div class="menu">
                <ul>
                    <!--                        <li><a href="#"><i class="fa fa-server" aria-hidden="true"></i><span class="text"> Pages </span></a>-->
                    <ul class="dropdown">
                        <!--                                <li><a href="#"><i class="fa fa-bar-chart" aria-hidden="true"></i><span class="text"> Dashboard</span></a></li>-->
                        <li><a href="ListOfCategory"><i class="fa fa-arrows-alt" aria-hidden="true"></i><span class="text"> Category</span></a></li>
                        <li><a href="admin"><i class="fa fa-desktop" aria-hidden="true"></i><span class="text"> Services</span></a></li>
                        <li><a href="#"><i class="fa fa-calendar" aria-hidden="true"></i><span class="text"> Statics</span></a></li>
                        <li><a href="#"><i class="fa fa-gears" aria-hidden="true"></i><span class="text"> Setting</span></a></li>
                        <li><a href="Dashboard"><i class="fa fa-gears" aria-hidden="true"></i><span class="text"> Dashboard</span></a></li>
                        <li><a href="ListOfMarketing"><i class="fa fa-percent" aria-hidden="true"></i><span class="text">Voucher</span></a></li>
                        <li><a href="AllEmployee"><i class="fa fa-users" aria-hidden="true"></i><span class="text">Employee</span></a></li>
                        <li><a href="MainController?action=AllOrder&status=2"><i class="fa fa-window-maximize" aria-hidden="true"></i><span class="text">Order</span></a></li>
                    </ul>

                </ul>
            </div>
        </div>
        <div class="wrapper">
            <div class="main-content">
                <div class="topmenu">
                    <!--                        <div class="search">
                                                <input  type='text' class='src' placeholder='Search for cards...'/>
                                            </div>-->
                    <div class="dropdown2">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle user-action"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                            <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                            </svg>  <b class="caret"> Admin</b>
                        </a>
                        <div class="dropdown-content">
                            <a href="MainController?action=ViewA"><li class="profile">Profile</li></a>
                            <a href="#"><li class="profile">Setting</li></a>
                            <a href="LogoutController"><li class="profile">Logout</li></a>
                        </div>
                    </div>
                </div>
            </div>

            <body onload="time()" class="app sidebar-mini rtl">
                <main class="app-content">
                    <div class="row">
                        <!--Left-->
                        <div class="col-md-12 col-lg-6">
                            <div class="row">
                                <!-- col-6 -->
                                <div class="col-md-6">
                                    <div class="widget-small primary coloured-icon"><i class='icon bx bxs-user-account fa-3x'></i>
                                        <div class="info">
                                            <h4>Tổng khách hàng</h4>
                                            <p><b>${requestScope.sizecustomer} khách hàng</b></p>
                                            <p class="info-tong">Tổng số khách đặt dịch vụ.</p>
                                        </div>
                                    </div>
                                </div>
                                <!-- col-6 -->
                                <div class="col-md-6">
                                    <div class="widget-small info coloured-icon"><i class='icon bx bxs-data fa-3x'></i>
                                        <div class="info">
                                            <h4>Tổng dịch vụ</h4>
                                            <p><b>${requestScope.sizeser} dịch vụ</b></p>
                                            <p class="info-tong">Tổng số dịch vụ.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="widget-small warning coloured-icon"><i class='icon bx bxs-shopping-bags fa-3x'></i>
                                        <div class="info">
                                            <h4>Tổng đơn hàng</h4>
                                            <p><b>${requestScope.sizebill} đơn hàng</b></p>
                                            <p class="info-tong">Tổng số hóa đơn trong tháng.</p>
                                        </div>
                                    </div>
                                </div>         
                                <div class="col-md-6">
                                    <div class="widget-small primary coloured-icon"><i class='icon fa-3x bx bxs-chart' ></i>
                                        <div class="info">
                                            <h4>Tổng thu nhập</h4>
                                            <p><b>${requestScope.moneymonth}đ</b></p>
                                            <p class="info-tong">Tổng số tiền trong tháng.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12 col-lg-6">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="tile">
                                        <h3 class="tile-title">Tiền 6 tháng đầu năm</h3>
                                        <div class="embed-responsive embed-responsive-16by9">
                                            <canvas class="embed-responsive-item" id="barChartDemo"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>


                        <form method="get" action="Dashboard">
                            <h4>DOANH THU:</h4>
                            <div class="nav">

                                <label for="startDate">Từ ngày:</label>
                                <input type="date" id="startDate" name="startDate" required>
                                <label for="endDate" class="pa">Đến ngày:</label>
                                <input type="date" id="endDate" name="endDate" required>
                                <button type="submit" class="pe">Xem doanh thu</button>
                            </div>
                        </form>

                        <%-- Hiển thị kết quả doanh thu --%>
                        <div class="container" style="color: white;">
                            <% if (request.getParameter("startDate") != null && request.getParameter("endDate") != null && request.getAttribute("totalRevenue") != null) {%>
                            <p>Từ ngày: <%= request.getParameter("startDate")%></p>
                            <p class="pa">Đến ngày: <%= request.getParameter("endDate")%></p>
                            <p>Tổng doanh thu: <%= request.getAttribute("totalRevenue")%></p>
                            <% } else if (request.getParameter("targetDate") != null && request.getAttribute("totalRevenue") != null) {%>
                            <p>Ngày đã chọn: <%= request.getParameter("targetDate")%></p>
                            <p>Tổng doanh thu: <%= request.getAttribute("totalRevenue")%></p>
                            <% }%>
                        </div>
                        <style>
                            .container {
                                background-color: #f8f8f8;
                                color: #333;
                                padding: 20px;
                                border-radius: 8px;
                                text-align: center;
                                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                            }

                            .title {
                                font-size: 24px;
                                font-weight: bold;
                                margin-bottom: 20px;
                            }

                            .subtitle {
                                font-size: 18px;
                                margin-bottom: 10px;
                            }

                            .description {
                                margin-bottom: 20px;
                            }

                            .button {
                                display: inline-block;
                                background-color: #3498db;
                                color: white;
                                padding: 10px 20px;
                                border-radius: 4px;
                                text-decoration: none;
                                transition: background-color 0.3s ease-in-out;
                            }

                            .button:hover {
                                background-color: #2980b9;
                            }
                        </style>

                        <form method="get" action="Dashboard">
                            <style>
                                .nav{
                                    margin-right: 50px;
                                }
                                .container {
                                    border: 1px solid #ccc;
                                    padding: 20px;
                                    border-radius: 5px;
                                    /*  background-color: #f2f2f2;*/
                                    width: 300px;
                                    margin-left: 150px;
                                    background-color: #4CAF50;
                                    color: #ffffff;
                                    /*                                    color: #333;*/
                                    /*                                    margin: 5px 0;*/

                                }
                                .pa{
                                    margin-left: 50px;
                                }
                                .pe{
                                    margin-left: 30px;
                                }
                                .container:hover {
                                    box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
                                }
                                .container:focus {
                                    outline: 2px solid blue;
                                }
                                .container p {
                                    margin: 10px 0;
                                    /*                                    color: #333;*/
                                    color: #ffffff;
                                }

                                .container p.date {
                                    color: blue;
                                }

                                .container p.revenue {
                                    color: green;
                                }

                                /* CSS cho form */
                                form {
                                    margin-bottom: 20px;
                                }

                                label {
                                    display: block;
                                    margin-bottom: 5px;
                                }

                                input[type="date"] {
                                    padding: 5px;
                                    border-radius: 3px;
                                    border: 1px solid #ccc;
                                }

                                button[type="submit"] {
                                    padding: 5px 10px;
                                    background-color: #4CAF50;
                                    color: #fff;
                                    border: none;
                                    border-radius: 3px;
                                    cursor: pointer;
                                }

                                /* CSS cho kết quả doanh thu */
                                .result {
                                    margin-top: 20px;
                                    padding: 10px;
                                    background-color: #f2f2f2;
                                    border: 1px solid #ccc;
                                }

                                .result p {
                                    margin: 5px 0;
                                }
                            </style>

                            </body>
                    </div>
                </main>
                <script src="admin/js/jquery-3.2.1.min.js"></script>
                <!--===============================================================================================-->
                <script src="admin/js/popper.min.js"></script>
                <script src="https://unpkg.com/boxicons@latest/dist/boxicons.js"></script>
                <!--===============================================================================================-->
                <script src="admin/js/bootstrap.min.js"></script>
                <!--===============================================================================================-->
                <script src="admin/js/main.js"></script>
                <!--===============================================================================================-->
                <script src="admin/js/plugins/pace.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

                <!--===============================================================================================-->
                <script type="text/javascript" src="admin/js/plugins/chart.js"></script>
                <!--===============================================================================================-->
                <script>
                var ctx = document.getElementById("barChartDemo").getContext('2d');
                var barChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7'],
                        datasets: [{
                                label: 'Doanh thu',
                                data: [
                    ${requestScope.tien1},
                    ${requestScope.tien2},
                    ${requestScope.tien3},
                    ${requestScope.tien4},
                    ${requestScope.tien5},
                    ${requestScope.tien6},
                    ${requestScope.tien7}
                                ],
                                backgroundColor: 'rgba(54, 162, 235, 0.5)',
                                borderColor: 'rgba(54, 162, 235, 1)',
                                borderWidth: 1
                            }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true,
                                ticks: {
                                    stepSize: 100000
                                }
                            }
                        }
                    }
                });
                </script>
                <!-- Thêm đoạn mã HTML cho biểu đồ -->
                <!--                <canvas id="weeklyChart"></canvas>-->

                <!-- Đoạn mã JavaScript để tạo biểu đồ -->
                <!--                <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
                                <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
                                <canvas id="barChart"></canvas>
                                <script>
                                var ctx = document.getElementById('barChart').getContext('2d');
                                var barChart = new Chart(ctx, {
                                    type: 'bar',
                                    data: {
                                        labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6'],
                                        datasets: [{
                                                label: 'Doanh thu',
                                                data: [5000, 7000, 3000, 9000, 6000, 4000],
                                                backgroundColor: 'rgba(54, 162, 235, 0.5)',
                                                borderColor: 'rgba(54, 162, 235, 1)',
                                                borderWidth: 1
                                            }]
                                    },
                                    options: {
                                        scales: {
                                            y: {
                                                beginAtZero: true,
                                                ticks: {
                                                    stepSize: 1000
                                                }
                                            }
                                        }
                                    }
                                });
                
                                </script>
                
                
                                <div style="width: 150px;">
                                    <canvas id="weeklyChart"></canvas>
                                </div>
                
                                <style>
                                    .chart-container {
                                        width: 300px;
                                        margin: 20px auto;
                                    }
                                </style>-->

            </body>

            </html>
