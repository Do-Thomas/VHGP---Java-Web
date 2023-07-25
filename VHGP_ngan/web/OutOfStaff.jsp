<%-- 
    Document   : OutOfStaff
    Created on : Jun 20, 2023, 2:07:00 AM
    Author     : Asus
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lỗi</title>
        <style>
            body{
                /*                background-color: #000000f0;*/
            }
            .center{
                margin-top: 220px;
            }
            h1{
                font-size: 300%;
                /*                color: white;*/
                text-align: center;
            }
            a{
                text-decoration: none;
                padding: 25px;
                padding: 25px 40px;
                border-radius: 30px;
            }
            .b-orange, .b-orange:before {
                background: rgba(255,193,7,1);
                background: -moz-linear-gradient(45deg, rgba(255,193,7,1) 0%, rgba(255,87,34,1) 100%);
                background: -webkit-gradient(left bottom, right top, color-stop(0%, rgba(255,193,7,1)), color-stop(100%, rgba(255,87,34,1)));
                background: -webkit-linear-gradient(45deg, rgba(255,193,7,1) 0%, rgba(255,87,34,1) 100%);
                background: -o-linear-gradient(45deg, rgba(255,193,7,1) 0%, rgba(255,87,34,1) 100%);
                background: -ms-linear-gradient(45deg, rgba(255,193,7,1) 0%, rgba(255,87,34,1) 100%);
                background: linear-gradient(45deg, rgba(255,193,7,1) 0%, rgba(255,87,34,1) 100%);
                filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffc107', endColorstr='#ff5722', GradientType=1 );
            }
            .btn{
                display: flex;
                margin: 0 10vh;
            }
            .checkout{
                float: right;
                margin-left: 125vh;
            }
        </style>
    </head>
    <body>
        <div class="center">
            <c:set var="context" value="${pageContext.request.contextPath}"/>
            <c:set var = "date" scope = "session" value = "${requestScope.DATE_OF_STAFF}"/>
            <c:set var="se" value="${requestScope.SERVICE_OF_STAFF}"/>

            <c:forEach items="${requestScope.SERVICE_OF_STAFF}" var="s" varStatus="counter">
                <h1>Dịch vụ ${s.serviceName} - ${s.serviceTime}h</h1>
            </c:forEach>
            <h1>Hiện tại không còn nhân việc có thể tiếp nhận công việc.</h1>
            <h1>Xin vui lòng chờ hoặc chọn dịch vụ khác.</h1>
            <h1>Thời gian có thể đặt dịch vụ: <c:out value = "${DATE_OF_STAFF}"/></h1>
        </div>
        <div class="btn">
            
            <a class="button b-orange back" href="MainController?action=ListService">Back</a>
            <a class ="button b-orange checkout" href="checkOut.jsp">Checkout</a>   
            <c:set var="c" value="${requestScope.CART_CHECKOUT}" />
            <c:choose>
                <c:when test="${not empty requestScope.CART_CHECKOUT}">
                    <a class ="button b-orange checkout" href="checkOut.jsp">Checkout</a>
                </c:when>
            </c:choose>
        </div>


    </body>
</html>
