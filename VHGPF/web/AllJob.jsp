<%@page import="java.time.temporal.TemporalAdjusters"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Collections" %>
<%@page import="java.util.Comparator" %>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Calendar"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.OrderDetail"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.time.DayOfWeek, java.time.LocalDateTime, java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weekly table</title>
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
        <link rel="stylesheet" href="css/scheledu.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800,900" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="../css/table.css" rel="stylesheet">
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
            .row-emp{
                padding: 70px 50px;
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
            .time-scheledu{
                height: 80px; 
                color: #808080; 
                font-size: 15px;
                font-weight: bold;
            }
            @media only screen and (min-width: 800px) {
                .cd-schedule {
                    margin: 5em auto;
                }

                .mdl-card__title {
                    background: #0079c1;
                    color: #cacaca;
                    margin-bottom: 1rem;
                    &-text {
                        color: white;
                    }            }


                /* Định dạng bảng lịch làm việc */
                .cd-schedule table {
                    width: 100%;
                    border-collapse: collapse;
                    table-layout: fixed;
                }

                /* Định dạng cột thời gian */
                .cd-schedule th.time-scheledu {
                    /* Độ rộng cột thời gian */
                    width: 60px; 
                    text-align: left;
                    padding-left: 10px;
                }

                /* Định dạng ô công việc */
                .cd-schedule td {
                    position: relative;
                    padding: 0 10px;
                    vertical-align: top; /* Thêm thuộc tính vertical-align để căn chỉnh nội dung theo chiều dọc */
                    /*height: 100px;*/
                    /* Đặt chiều cao cố định cho ô công việc */
                }

                /* Các phần tử hiển thị công việc */
                .single-event {
                    text-align: center;
                    position: absolute;
                    top: 0;
                    left: 0;
                    right: 0;
                    bottom: 0;
                    background-color: #0079c1; /* Màu nền của ô công việc */
                    color: #fff; /* Màu chữ trong ô công việc */
                    /*padding: 5px;*/
                    font-size: 12px;
                    line-height: 1.2;
                    overflow: hidden;
                    border-radius: 5px;
                    box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
                }

                .single-event .event-name {
                    font-size: 12px;
                    max-width: 90%; /* Adjust the width as needed */
                    max-height: 50%;
                    white-space: nowrap; /* Prevent text from wrapping */
                    overflow: hidden; /* Hide any overflowing text */
                    text-overflow: ellipsis; /* Display ellipsis (...) for truncated text */
                }

                /* Định dạng thời gian trong ô công việc */
                .single-event a {
                    color: #fff;
                    background-color: #3CB371; /* bgcolor */
                    text-decoration: none;
                }

                /* Ẩn dấu mũi tên hiển thị khi không có nội dung */
                .single-event em:empty {
                    display: none;
                }

                /* Các phần tử hiển thị khi hover chuột vào ô công việc */
                .single-event:hover::before,
                .single-event:hover::after {
                    /*display: block;*/
                }

                /* Hiển thị thông tin công việc khi hover chuột vào */
                .single-event:hover::before {
                    content: attr(data-start);
                    position: absolute;
                    top: -25px;
                    left: 0;
                    width: 100%;
                    text-align: center;
                    font-size: 12px;
                    color: #0079c1; /* Màu nền của ô thông tin */
                    background-color: #fff; /* Màu chữ trong ô thông tin */
                    padding: 2px 5px;
                    border-radius: 3px;
                    box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
                }

                .single-event::before,
                .single-event::after {            /* Hiển thị các dấu mũi tên cho thông tin công việc */
                    content: "";
                    position: absolute;
                    display: none;
                }
                /* Dấu mũi tên hiển thị phía trên ô công việc */
                .single-event::before {
                    top: -5px;
                    left: 50%;
                    margin-left: -5px;
                    border-left: 5px solid transparent;
                    border-right: 5px solid transparent;
                    border-bottom: 5px solid #0079c1; /* Màu dấu mũi tên */
                }
                .single-event::after {            /* Dấu mũi tên hiển thị phía dưới ô công việc */

                    bottom: -5px;
                    left: 50%;
                    margin-left: -5px;
                    border-left: 5px solid transparent;
                    border-right: 5px solid transparent;
                    border-top: 5px solid #0079c1; /* Màu dấu mũi tên */
                }
                .event-abs-circuit {            /* Class mới để điều chỉnh chiều cao của công việc dựa trên thời gian */
                    height: 1px; /* Để không ảnh hưởng đến kích thước ban đầu của công việc */
                }

                .date-container {
                    margin: 5px 5px 5px 5px; /* Add 5px spacing between the two lines */
                }
                .current-date {
                    color: #20B2AA;
                    font-weight: bold; /* Make the text bold */
                }
                .weekday {
                    color: #000; /* Black color for weekdays */
                    font-size: 25px; /* Set the font size to 16px (you can adjust this value as needed) */
                }

            </style>
        </head>
        <script src="js/scheledu.js"></script>
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
                    <%
                        // Lấy danh sách công việc đã sắp xếp từ thuộc tính request
                        ArrayList<OrderDetail> list = (ArrayList<OrderDetail>) request.getAttribute("LIST_JOB");
                        // Sắp xếp danh sách công việc theo thời gian bắt đầu (tăng dần)
                        Collections.sort(list, new Comparator<OrderDetail>() {
                            @Override
                            public int compare(OrderDetail o1, OrderDetail o2) {
                                return o1.getTimeStart().compareTo(o2.getTimeStart());
                            }
                        });
                    %>
                    <%
                        int startHour = 7; // Giờ bắt đầu làm việc (7AM)
                        int endHour = 22; // Giờ kết thúc làm việc (10PM)
                    %> 
                    <%
                        // Định nghĩa các giờ trong ngày từ 7AM đến 10PM
                        int[] hoursOfDay = new int[endHour - startHour + 1];
                        for (int i = startHour; i <= endHour; i++) {
                            hoursOfDay[i - startHour] = i;
                        }

                        // Lưu trữ các ngày trong tuần vào một mảng
                        String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
                    %>
                    <!-- Định nghĩa các phút -->
                    <%
                        int[] minutes = new int[60];
                        for (int i = 0; i < 60; i++) {
                            minutes[i] = i;
                        }
                    %>

                    <!-- The modal to display order details -->
                    <div class="modal" id="orderDetailsModal">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Order Details</h5>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <!-- Content to display order details will be inserted here -->
                                    <p>Order ID: <span id="orderId"></span></p>
                                    <!-- Add other order details as needed -->
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="cd-schedule loading">
                        <div class="events">  <!-- Bảng hiển thị lịch công việc -->
                            <table>
                                <thead>
                                    <tr class="text-center">
                                        <th class="time-scheledu"></th>
                                            <% for (String weekday : weekdays) {%>
                                        <th>
                                            <div class="date-container">
                                                <span class="current-date"><%= getDateForDayOfWeek(weekday)%></span><br>
                                                <span class="weekday"><%= weekday%></span>
                                            </div>
                                        </th>
                                        <% } %>
                                    </tr>
                                </thead>

                                <tbody><!-- Lặp qua các giờ trong ngày -->
                                    <% for (int i = startHour; i <= endHour; i += 2) {%>
                                    <tr>
                                        <td class="time-scheledu"><%= String.format("%02d:00 %s", (i % 12 == 0) ? 12 : i % 12, (i < 12) ? "AM" : "PM")%></td>
                                        <!-- Lặp qua các ngày trong tuần -->
                                        <% for (String weekday : weekdays) { %>
                                        <td>
                                            <%
                                                // Lấy timestamp cho giờ và ngày trong tuần hiện tại
                                                Calendar calendar = Calendar.getInstance();
                                                calendar.set(Calendar.DAY_OF_WEEK, getDayOfWeekValue(weekday)); // Đặt ngày trong tuần
                                                calendar.set(Calendar.HOUR_OF_DAY, i); // Đặt giờ
                                                long timestamp = calendar.getTimeInMillis();
                                                // Lưu trữ danh sách các công việc trong khoảng thời gian này
                                                ArrayList<OrderDetail> eventsInTimeSlot = new ArrayList<>();
                                                // Duyệt qua danh sách công việc và tìm các công việc diễn ra trong khoảng thời gian này
                                                for (OrderDetail od : list) {
                                                    long startTime = od.getTimeStart().getTime();
                                                    long endTime = od.getTimeEnd().getTime();
                                                    if (startTime <= timestamp && timestamp < endTime) {
                                                        eventsInTimeSlot.add(od);
                                                    }
                                                }
                                            %>
                                            <!-- Hiển thị các công việc trong khoảng thời gian này -->
                                            <% for (OrderDetail event : eventsInTimeSlot) {
                                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
                                                    String timeStart = dateFormat.format(event.getTimeStart());
                                                    String timeEnd = dateFormat.format(event.getTimeEnd());
                                                    // Tính toán chiều cao của công việc dựa trên khoảng thời gian
                                                    long duration = event.getTimeEnd().getTime() - event.getTimeStart().getTime();
                                                    long totalMinutes = duration / (60 * 1000); // Tổng số phút của khoảng thời gian
                                                    long hours = totalMinutes / 60; // Số giờ trong khoảng thời gian
                                                    long remainingMinutes = totalMinutes % 60; // Số phút còn lại sau khi tính số giờ
                                                    int height;
                                                    if (hours <= 3) {
                                                        height = (int) ((3 * 60 + remainingMinutes) * 0.6);
                                                    } else {
                                                        height = (int) ((2 * 60 + remainingMinutes) * 0.7);
                                                    }
                                            %>
                                            <!-- Hiển thị thông tin công việc -->
                                            <div  class="single-event" data-start="<%= timeStart%>" data-end="<%= timeEnd%>"
                                                  style="height: <%= height%>px" data-content="event-abs-circuit" data-event="event-1">
                                                <a href="EmployeeHome">
                                                    <em class="event-name"><%= event.getOrderDServiceName()%></em>
                                                    <br>
                                                    <span class="event-time" style="padding: 0;"><%= timeStart.split(" ")[1]%> - <%= timeEnd.split(" ")[1]%></span>
                                                </a>
                                            </div>
                                            <% } %>
                                        </td>
                                        <% } %>
                                    </tr>
                                    <% }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <%!
                        public String getCurrentDate() {
                            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate now = LocalDate.now();
                            return now.format(dateFormat);
                        }

                        public int getDayOfWeekValue(String dayOfWeek) {
                            switch (dayOfWeek) {
                                case "Sunday":
                                    return 1;
                                case "Monday":
                                    return 2;
                                case "Tuesday":
                                    return 3;
                                case "Wednesday":
                                    return 4;
                                case "Thursday":
                                    return 5;
                                case "Friday":
                                    return 6;
                                case "Saturday":
                                    return 7;
                                default:
                                    return -1; // Nếu không phải ngày trong tuần hợp lệ, trả về giá trị không hợp lệ
                            }
                        }

                        public String getDateForDayOfWeek(String dayOfWeek) {
                            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate now = LocalDate.now();
                            int today = now.getDayOfWeek().getValue(); // 1 (Monday) to 7 (Sunday)

                            int targetDay = getDayOfWeekValue(dayOfWeek); // Get the target day (1 to 7) based on dayOfWeek parameter

                            int daysToAdd;
                            if (targetDay >= today) {
                                daysToAdd = targetDay - today - 1;
                            } else {
                                daysToAdd = targetDay - today - 1;
                            }

                            LocalDate targetDate = now.plusDays(daysToAdd);

                            return targetDate.format(dateFormat);
                        }
                    %>
                </div>
            </div>
        </body>
    </html>
