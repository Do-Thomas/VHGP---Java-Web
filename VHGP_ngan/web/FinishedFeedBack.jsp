<%-- 
    Document   : FinishedFeedBack
    Created on : Jun 25, 2023, 9:50:19 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feedback</title>
    </head>
    <style>
        .center{
            align-content: center;
        }
        body{
            /*                background-color: #000000f0;*/
        }
        .center{
/*            margin-top: 220px;*/
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
            margin: 0 90vh;
        }
        .checkout{
            float: right;
            margin-left: 125vh;
        }
        .icon{
            font-size: 20vh;
        }
    </style>

    <body>
        <h1 class="icon">&#9924;</h1>
        <h1 class="center">Cảm ơn bạn đã sử dụng dịch vụ</h1>
        <div class="btn">
            <a class="button b-orange back" href="MainController?action=ListService">Back</a>
        </div>
    </body>
</html>
