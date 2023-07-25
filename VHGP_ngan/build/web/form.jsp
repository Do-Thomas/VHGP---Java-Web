<%-- 
    Document   : form
    Created on : Jun 22, 2023, 12:42:12 AM
    Author     : ASUS
--%>

<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="tea.Tea"%>
<%@page import="tea.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <style>

            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                text-align: center;

            }
            body text{

            }

            h1 {
                text-align: center;
                margin-bottom: 20px;
            }

            form {
                background-color: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                display: inline;
            }

            /* Rest of the CSS styles remain the same */


            label {
                display: block;
                margin-bottom: 10px;
            }

            input[type="time"],
            input[type="date"] {
                width: 200px;
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                outline: none;
            }

            button[type="submit"] {
                padding: 9px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            button[type="submit"]:hover {
                background-color: #45a049;
            }

            .error-message {
                color: red;
                font-size: 14px;
                margin-top: 5px;
            }
            h1 {
                text-align: center;
                margin-bottom: 20px;
            }
            .back-button {
                padding: 7.8px 20px;
                display: inline-block;
                margin-top: 30px;
                background-color: #f2f2f2;
                color: #333;
                text-decoration: none;
                border: 1px solid #ccc;
                border-radius: 4px;
                transition: background-color 0.3s, color 0.3s;
                margin-right: 20px;
            }

            .back-button:hover {
                background-color: #ccc;
                color: #fff;
            }

        </style>
        <c:set var="cart" scope="session" value="${sessionScope.CART}"/>
        <c:if test="${not empty sessionScope.CART}">
            <form action="DeliveryServlet">
                <h1>Thay đổi thời gian bắt đầu dịch vụ</h1>
                <input  type="hidden" id="madv" name="madv" value="${sessionScope.madv}" readonly=""></p>
                <input  type="hidden" id="deliveryDate" name="deliveryDate" value="${sessionScope.deliveryDate}" readonly=""></p>

                <!--        <label for="deliveryTime">Thời gian giao hàng:</label>
                        <input type="time" id="deliveryTime" name="deliveryTime" min="<?php echo date('H:i'); ?>" onchange="updateTime()" required="">
                -->


                <label for="deliveryDates">Thời gian mới :
                    <input type="datetime-local" id="deliveryDates" name="deliveryDates" min="<?php echo date('Y-m-d'); ?>" onchange="updateTime()" required="">
                    </br>

                    <a style="text-decoration: none; " class="back-button" href="ViewCart.jsp">&#8592;Trở về</a>
                    <button type="submit" value="Gửi" onclick="return validateDeliveryTime()">Gửi</button>
                    <script>
                        function validateDeliveryTime() {
                            var deliveryDateInput = document.getElementById("deliveryDates");
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

                    </script>
            </form>


        </c:if>
    </body>
</html>
