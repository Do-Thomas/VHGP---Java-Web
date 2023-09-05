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
        <title>Thay đổi thời gian</title>
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
            <form action="DeliveryServlet" onsubmit="return validateForm()">
                <h1>Thay đổi thời gian giao hàng</h1>
                <input type="hidden" id="madv" name="madv" value="${sessionScope.madv}" readonly=""></p>
                <input type="hidden" id="deliveryDate" name="deliveryDate" value="${sessionScope.deliveryDate}" readonly=""></p>

                <label for="deliveryDates">Thời gian mới:
                <input type="datetime-local" id="deliveryDates" name="deliveryDates" required="">
                </br>

                <a style="text-decoration: none; " class="back-button" href="/VHGP/ViewCart.jsp">&#8592;Trở về</a>
                <button type="submit" value="Gửi">Gửi</button>
            </form>
        </c:if>
        <script>
            function validateForm() {
                var deliveryDatesInput = document.getElementById("deliveryDates");
                var deliveryDates = deliveryDatesInput.value;

                // Lấy thời điểm hiện tại
                var currentDateTime = new Date();
                // Chuyển đổi thời gian mới thành đối tượng Date
                var newDateTime = new Date(deliveryDates);

                // Kiểm tra nếu thời gian mới không hợp lệ
                if (newDateTime <= currentDateTime) {
                    alert("Thời gian mới phải sau thời điểm hiện tại.");
                    event.preventDefault(); // Ngăn chặn việc gửi form
                    return;
                }

                // Kiểm tra thời gian mới nằm trong khoảng từ 7h sáng đến 21h tối
                var hours = newDateTime.getHours();
                if (hours < 7 || hours >= 21) {
                    alert("Thời gian mới phải nằm trong khoảng từ 7h sáng đến 21h tối.");
                    event.preventDefault(); // Ngăn chặn việc gửi form
                    return;
                }


    }

        </script>


    </body>
</html>
