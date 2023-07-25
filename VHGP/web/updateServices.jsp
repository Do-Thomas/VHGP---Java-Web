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
        <%
            Map<String, String> errorMap = (Map<String, String>) request.getAttribute("errorMap");
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Category> categories = categoryDAO.getAllCategories();

            Services item = (Services) request.getAttribute("item"); // Lấy đối tượng Services từ thuộc tính request
        %>
        <h1>Update Services</h1>
        <form action="MainController" method="POST">
            <div class="form-control">
                <label for="ServiceID" id="name-label">ID :</label>
                <input type="text" id="ServiceID" name="ServiceID" value="${empty param.ServiceID ? requestScope.item.serviceID : param.ServiceID}" readonly>
            </div>

            <div class="form-control">
                <label for="ServiceName" id="name-label">Name:</label>
                <input type="text" id="ServiceName" name="ServiceName" placeholder="Enter Service Name" value="${empty param.ServiceName ? requestScope.item.serviceName : param.ServiceName}">
                <% if (errorMap != null && errorMap.containsKey("ServiceName")) {%>
                <span class="error"><%= errorMap.get("ServiceName")%></span>
                <% } %>
            </div>
            <div class="form-control">
                <label for="ServiceDetail" id="name-label">Detail:</label>
                <input type="text" id="ServiceDetail" name="ServiceDetail" placeholder="Enter Service Detail"  value="${empty param.ServiceDetail ? requestScope.item.serviceDetail : param.ServiceDetail}">
                <% if (errorMap != null && errorMap.containsKey("ServiceDetail")) {%>
                <span class="error"><%= errorMap.get("ServiceDetail")%></span>
                <% } %>
            </div>
            <div class="form-control">
                <label for="ServiceTime" id="name-label">Time:</label>
                <input type="radio" id="time3" name="ServiceTime" value="3" <% if (item.getServiceTime() == 3) { %>checked<% } %>> 3
                <input type="radio" id="time4" name="ServiceTime" value="4" <% if (item.getServiceTime() == 4) { %>checked<% } %>> 4
                <% if (errorMap != null && errorMap.containsKey("ServiceTime")) {%>
                <span class="error"><%= errorMap.get("ServiceTime")%></span>
                <% } %>
            </div>
            <div class="form-control">
                <label for="ServicePrice" id="name-label">Price:</label>
                <input type="radio" id="price240" name="ServicePrice" value="240" <% if (item.getServicePrice() == 240) { %>checked<% } %>> 240
                <input type="radio" id="price350" name="ServicePrice" value="350" <% if (item.getServicePrice() == 350) { %>checked<% } %>> 350
                <% if (errorMap != null && errorMap.containsKey("ServicePrice")) {%>
                <span class="error"><%= errorMap.get("ServicePrice")%></span>
                <% } %>
            </div>

            <div class="form-control">
                <label for="ServicePicture" id="name-label">Picture:</label>
                <% if (item.getServicePicture() != null && !item.getServicePicture().isEmpty()) {%>
                <img src="image/<%= item.getServicePicture()%>" width="200" height="200" alt="Service Picture">
                <% } %>
                <input type="file" name="ServicePicture">
                <% if (errorMap != null && errorMap.containsKey("ServicePicture")) {%>
                <span class="error"><%= errorMap.get("ServicePicture")%></span>
                <% } %>
            </div>
            <div class="form-control">
                <label for="CatID" id="name-label">Category Name:</label>
                <select id="CatID" name="CatID">
                    <option value="">Select Category</option>
                    <% for (Category category : categories) {%>
                    <option value="<%= category.getCatID()%>"
                            <% if (request.getParameter("CatID") != null && request.getParameter("CatID").equals(category.getCatID())) { %>
                            selected
                            <% }%>
                            ><%= category.getCatName()%></option>
                    <% } %>
                </select>
                <% if (errorMap != null && errorMap.containsKey("CatID")) {%>
                <span class="error"><%= errorMap.get("CatID")%></span>
                <% }%>
            </div>
            <input type="submit" name="action" value="Update">
            </table>
        </form>
        <a href="admin">Home</a>
        <script>
            document.getElementById("time3").addEventListener("change", function () {
                document.getElementById("price240").checked = true;
            });

            document.getElementById("time4").addEventListener("change", function () {
                document.getElementById("price350").checked = true;
            });
        </script>
    </body>
</html>
