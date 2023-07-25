
<%@page import="dao.CategoryDAO"%>
<%@page import="model.Category"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Services"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                background-color: #333333;
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
        <h1>Update Status</h1>
        <form action="MainController" method="POST">
            <div class="form-control">
                <label for="ServiceID" id="name-label">ID :</label>
                <input type="text" id="ServiceNID" name="ServiceID" value="${empty param.ServiceID ? requestScope.item.serviceID : param.ServiceID}"readonly>
            </div>

            <label for="ServiceStatus">Service Status:</label>
            <select id="ServiceStatus" name="ServiceStatus">
                <option value="Hoạt động" <c:if test="${item.serviceStatus == 'Hoạt động'}">selected</c:if>>Hoạt động</option>
                <option value="Tạm dừng" <c:if test="${item.serviceStatus == 'Tạm dừng'}">selected</c:if>>Tạm dừng</option>
            </select>

            <br/><br/>

            <input type="submit" name= "action" value="CanSer">
        </form>

        <a href="admin">Home</a>
    </body>


</html>


</body>
</html>

