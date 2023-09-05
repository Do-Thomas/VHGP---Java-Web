<%@page import="model.Category"%>
<%@page import="dao.CategoryDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
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
        %>

        <h1 id="title">Create New Service</h1>
        <form action="CreateServices" method="POST">
            <div class="form-control">
                <label for="ServiceName" id="name-label">Name:</label>
                <input type="text" id="ServiceName" name="ServiceName" placeholder="Enter Service Name" value="${empty param.ServiceName ? '' : param.ServiceName}">
                <% if (errorMap != null && errorMap.containsKey("ServiceName")) {%>
                <span class="error"><%= errorMap.get("ServiceName")%></span>
                <% } %>
            </div>
            <div class="form-control">
                <label for="ServiceDetail" id="name-label">Detail:</label>
                <textarea id="ServiceDetail" name="ServiceDetail" placeholder="Enter Service Detail">${empty param.ServiceDetail ? '' : param.ServiceDetail}</textarea>
                <% if (errorMap != null && errorMap.containsKey("ServiceDetail")) {%>
                <span class="error"><%= errorMap.get("ServiceDetail")%></span>
                <% } %>
            </div>

            <div class="form-control">
                <label for="ServiceTime" id="name-label">Time:</label>
                <input type="radio" id="time3" name="ServiceTime" value="3" <% if (request.getParameter("ServiceTime") != null && request.getParameter("ServiceTime").equals("3")) { %>checked<% } %>> 3
                <input type="radio" id="time4" name="ServiceTime" value="4" <% if (request.getParameter("ServiceTime") != null && request.getParameter("ServiceTime").equals("4")) { %>checked<% } %>> 4
                <% if (errorMap != null && errorMap.containsKey("ServiceTime")) {%>
                <span class="error"><%= errorMap.get("ServiceTime")%></span>
                <% } %>
            </div>
            <div class="form-control">
                <label for="ServicePrice" id="name-label">Price:</label>
                <input type="radio" id="price240" name="ServicePrice" value="240" <% if (request.getParameter("ServicePrice") != null && request.getParameter("ServicePrice").equals("240")) { %>checked<% } %>> 240
                <input type="radio" id="price350" name="ServicePrice" value="350" <% if (request.getParameter("ServicePrice") != null && request.getParameter("ServicePrice").equals("350")) { %>checked<% } %>> 350
                <% if (errorMap != null && errorMap.containsKey("ServicePrice")) {%>
                <span class="error"><%= errorMap.get("ServicePrice")%></span>
                <% } %>
            </div>
            <div class="form-control">
                <label for="ServicePicture" id="name-label">Picture:</label>
                <input type="file" id="ServicePicture" name="ServicePicture">
                <% if (request.getParameter("ServicePicture") != null) {%>
                <script>
                    document.getElementById("ServicePicture").value = "<%= request.getParameter("ServicePicture")%>";
                </script>
                <% } %>
            </div>

            <div class="form-control">
                <label for="CatID" id="name-label">Category Name:</label>
                <select id="CatID" name="CatID">
                    <option value="">Select Category</option>
                    <% for (Category category : categories) {%>
                    <option value="<%= category.getCatID()%>" <% if (request.getParameter("CatID") != null && request.getParameter("CatID").equals(category.getCatID())) { %>selected<% }%>><%= category.getCatName()%></option>
                    <% } %>
                </select>
                <% if (errorMap != null && errorMap.containsKey("CatID")) {%>
                <span class="error"><%= errorMap.get("CatID")%></span>
                <% }%>
            </div>
            <input type="submit" id="submit" value="Create">
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
