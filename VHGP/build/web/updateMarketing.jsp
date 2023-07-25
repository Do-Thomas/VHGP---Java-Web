<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.List"%>
<%@page import="model.Services"%>
<%@page import="dao.ServicesDAO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Update Marketing</title>

        <!-- Nhúng thư viện Bootstrap và Bootstrap DateTimePicker -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.1.2/css/tempusdominus-bootstrap-4.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.1.2/js/tempusdominus-bootstrap-4.min.js"></script>

    </head>
    <body>

        <style>
            @import url('https://fonts.googleapis.com/css2?family=Varela+Round&display=swap');

            *{
                box-sizing: border-box;
            }
            body{
                background-color: #005555 ;
                color:white;
                font-family: Varela Round;
                text-align: center;
                margin: 0;
            }
            form{
                background-color: rgba(10,50,30,0.95);
                box-shadow: 2px 5px 10px rgba(0,0,0,0.4);
                border-radius:3px;
                padding: 30px 20px;
                max-width: 600px; 
                margin: 40px auto;
            }
            .form-control{
                text-align: left;
                margin-bottom: 20px;
            }
            .form-control label{
                display: block;
                margin-bottom: 6px;


            }
            .form-control input,
            .form-control select,
            .form-control textarea{
                padding: 10px;
                font-size: 14px;
                font-family: Varela Round;
                border: 1px solid black;
                border-radius: 3px;
                display: block;
                width:100%;

            }
            .form-control input[type="radio"], .form-control input[input="checkbox"]{

                display: inline-block;

                width: auto;
            }
            input[type="submit"]{
                background-color: #85B3B2;
                font-family: Orator Std;
                font-size:26px;
                border: 1px solid black;
                border-radius: 3px;
                width:100%;
                height:7vh;

            }
        </style>

        <%
            Map<String, String> errorMap = (Map<String, String>) request.getAttribute("errorMap");
            ServicesDAO servicesDAO = new ServicesDAO();
            List<Services> service = servicesDAO.getAllServices();
        %>

        <h1>Update Marketing</h1>
        <%-- Display form --%>
        <form action="MainController" method="post">

            <div class="form-control">
                <label for="Event" id="name-label">Event :</label>
                <input type="text" id="Event" name="Event" placeholder="Enter Event" value="${empty param.Event ? requestScope.item.event : param.Event}" required>
            </div>

            <div class="form-control">
                <label for="ServiceID" id="name-label">Service Name :</label>
                <select id="ServiceID" name="ServiceID" required>
                    <option value="">Select Service</option>
                    <% for (Services services : service) {%>
                    <option value="<%= services.getServiceID()%>" <% if (request.getParameter("ServiceID") != null && request.getParameter("ServiceID").equals(services.getServiceID())) { %>selected<% }%>><%= services.getServiceID()%></option>
                    <% } %>
                </select>
                <% if (errorMap != null && errorMap.containsKey("ServiceID")) {%>
                <span class="error"><%= errorMap.get("ServiceID")%></span>
                <% }%>
            </div>

            <div class="form-control">
                <label for="StartTime" id="name-label">Start Time:</label>
                <div class="input-group date" id="startTimePicker" data-target-input="nearest">
                    <input type="text" class="form-control datetimepicker-input" id="StartTime" name="StartTime" data-toggle="datetimepicker" data-target="#startTimePicker" placeholder="Enter Start Time" value="${empty param.StartTime ? requestScope.item.startTime : param.StartTime}" />
                    <div class="input-group-append" data-target="#startTimePicker" data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                </div>
            </div>


            <div class="form-control">
                <label for="EndTime" id="name-label">End Time:</label>
                <div class="input-group date" id="endTimePicker" data-target-input="nearest">
                    <input type="text" class="form-control datetimepicker-input" id="EndTime" name="EndTime" data-toggle="datetimepicker" data-target="#endTimePicker" placeholder="Enter End Time" value="${empty param.EndTime ? requestScope.item.endTime : param.EndTime}">
                    <div class="input-group-append" data-target="#endTimePicker" data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                </div>
            </div>

            <div class="form-control">
                <label for="Voucher" id="name-label">Voucher : </label>
                <input type="text" id="Voucher" name="Voucher" placeholder="Enter Service Name" value="${empty param.Voucher ? requestScope.item.voucher : param.Voucher}">              
            </div>

            <script>
                $(document).ready(function () {
                    $('#startTimePicker').datetimepicker({
                        format: 'YYYY-MM-DD HH:mm:ss.SSS',
                        icons: {
                            time: 'fa fa-clock',
                            date: 'fa fa-calendar',
                            up: 'fa fa-chevron-up',
                            down: 'fa fa-chevron-down',
                            previous: 'fa fa-chevron-left',
                            next: 'fa fa-chevron-right',
                            today: 'fa fa-calendar-check',
                            clear: 'fa fa-trash',
                            close: 'fa fa-times'
                        }
                    });

                    $('#endTimePicker').datetimepicker({
                        format: 'YYYY-MM-DD HH:mm:ss.SSS',
                        icons: {
                            time: 'fa fa-clock',
                            date: 'fa fa-calendar',
                            up: 'fa fa-chevron-up',
                            down: 'fa fa-chevron-down',
                            previous: 'fa fa-chevron-left',
                            next: 'fa fa-chevron-right',
                            today: 'fa fa-calendar-check',
                            clear: 'fa fa-trash',
                            close: 'fa fa-times'
                        },
                        useCurrent: false
                    });

                    // Xử lý sự kiện khi ngày bắt đầu thay đổi
                    $('#StartTime').on('change.datetimepicker', function (e) {
                        $('#endTimePicker').datetimepicker('minDate', e.date);
                    });

                    // Xử lý sự kiện khi ngày kết thúc thay đổi
                    $('#EndTime').on('change.datetimepicker', function (e) {
                        $('#startTimePicker').datetimepicker('maxDate', e.date);
                    });
                });
            </script>
            <!--value ghi tên của nut button-->
            <input type="submit" name="action" value="UpdateMarketing">

        </form>
    </body>
</html>
