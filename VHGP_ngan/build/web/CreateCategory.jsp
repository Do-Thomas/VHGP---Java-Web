<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
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

        <style>
            @import url('https://fonts.googleapis.com/css2?family=Varela+Round&display=swap');
            *{
                box-sizing: border-box;
            }

            body{
                background-color: #009999;
                color:white;
                font-family: Varela Round;
                text-align: center;
                margin: 0;
            }

            form{
                background-color: #363636;
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

            .form-control input{
                padding: 10px;
                font-size: 14px;
                font-family: Varela Round;
                border: 1px solid black;
                border-radius: 3px;
                display: block;
                width:100%;
            }

            .form-control select{
                padding: 10px;
                font-size:17px;
            }

            button[type="submit"]{
                width: 100%;
                height: 50px;
                border: 1px solid;
                background: #66CC99;
                border-radius: 25px;
                font-size: 18px;
                color: #e9f4fb;
                font-weight: 700;
                cursor: pointer;
                outline: none;
            }

            button[type="submit"]:hover{
                border-color: #2691d9;
                transition: .5s;
            }

            .category{
                width: 100%;
                font-size:25px;
                font-weight: 800;
            }

            .category a{
                color: black;
                text-decoration: none;
                font-family: Varela Round;
                text-align: center;
                margin: 0;
                background: white;
                padding: 10px;
                border-radius: 25px;
            }
        </style>
    </head>
    <body>
        <%
            Map<String, String> errorMap = (Map<String, String>) request.getAttribute("errorMap");
        %>

        <h1>Create New Category</h1>
        <form action="CreateCategory" method="POST">

            <form>
<!--                <div class="form-control">
                    <label for="CatID" id="id-label">ID</label>
                    <input type="text" id="CatID" name="CatID" placeholder="Enter CatID"  value="${empty param.CatID ? '' : param.catID}">
                    <% if (errorMap != null && errorMap.containsKey("CatID")) {%>
                    <span class="error"><%= errorMap.get("CatID")%></span>
                    <% } %>
                </div>-->

                <div class="form-control">
                    <label for="CatName" id="name-label">Name</label>
                    <input type="text" id="CatName" name="CatName" placeholder="Enter CatName"value="${empty param.CatName ? '' : param.catName}">
                    <% if (errorMap != null && errorMap.containsKey("CatName")) {%>
                    <span class="error"><%= errorMap.get("CatName")%></span>
                    <% }%>
                </div>

                <div class="form-control">
                    <label for="CatStatus" id="status-label">Status</label> 
                    <select id="dropdown" name="CatStatus">
                        <option value="Hoạt đông">Hoạt động</option>
                        <option value="Tạm dừng">Tạm dừng</option>
                    </select>
                </div>


                <div class="form-control">
                    <label for="CatPicture" id="picture-label">Picture</label>
                    <input type="file" id="CatPicture" name="CatPicture">
                </div>

                <div>
                    <button type="submit" name="action">Add</button>
                </div>



            </form>

            <div class="category">
                <a href="ListOfCategory">Category</a>
            </div>


    </body>
</html>

