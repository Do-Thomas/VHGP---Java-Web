<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
    </head>
    <body>
        <style>
            @import url("https://fonts.googleapis.com/css?family=Montserrat:400,600&display=swap");
            * {
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }

            body {
                align-items: center;
                background-image: url("image/icon/landmark6.png");
                opacity: 0.9;
                /*                background:#89E3A7;*/
                color: rgba(0, 0, 0, 0.8);
                display: grid;
                font-family: "Montserrat", sans-serif;
                font-size: 14px;
                font-weight: 400;
                height: 100vh;
                justify-items: center;
                weight: 100vw;
            }

            .signup-container {
                display: grid;
                grid-template-areas: "left right";
                max-width: 1600px;
                background-color: rgba(255,255,255,0.13);
                border-radius: 10px;
                box-shadow: 0 14px 28px rgba(0, 0, 0, .2), 0 10px 10px rgba(0, 0, 0, .2);
            }

            .left-container {
                background: #fff;
                overflow: hidden;
                /*                padding: 40px 0 0 0;*/
                position: relative;
                text-align: center;
                width: 40vh;
                padding-top: 80px;
            }
            .left-container img {
                margin-top: 10vh;
            }
            left-container h1 {
                text-align: center;
                margin: auto;
                margin-top: 100px;
                color: rgba(0, 0, 0, 0.8);
                display: inline-block;
                font-size: 40px;
            }
            .left-container h1 i {
                margin: auto;
                background: #f7b1ab;
                border-radius: 50%;
                color: #807182;
                font-size: 24px;
                margin-right: 5px;
                padding: 10px;
                transform: rotate(-45deg);
            }
            .left-container .puppy {
                bottom: -5px;
                position: absolute;
                text-align: center;
            }
            .left-container .puppy:before {
                background: #97D1CB;
                content: "";
                height: 100%;
                left: 0;
                opacity: 0.4;
                position: absolute;
                width: 100%;
                z-index: 1;
            }
            .left-container img {
                /*                filter: sepia(100%);*/
                margin-top:10vh;
                width: 70%;
            }

            .right-container {
                /*                background: #333333;*/
                display: grid;
                grid-template-areas: "." ".";
            }
            .right-container h1:nth-of-type(1) {
                color: white;
                font-size: 28px;
                font-weight: 600;
            }
            .right-container .set {
                display: flex;
                justify-content: space-between;
                margin: 10px 0;
                color: white;
            }
            .right-container input {
                border: 1px solid rgba(0, 0, 0, 0.1);
                border-radius: 4px;
                height: 38px;
                line-height: 38px;
                padding-left: 5px;
            }
            .right-container input,
            .right-container label {
                color: rgba(0, 0, 0, 0.8);
            }
            .right-container header {
                padding: 40px;
            }
            .right-container label,
            .right-container input,
            .right-container .pets-photo {
                width: 176px;
            }
            .right-container .pets-photo {
                align-items: center;
                display: grid;
                grid-template-areas: ". .";
            }
            .right-container .pets-photo button {
                border: none;
                border-radius: 50%;
                height: 38px;
                margin-right: 10px;
                outline: none;
                width: 38px;
            }
            .right-container .pets-photo button i {
                color: rgba(0, 0, 0, 0.8);
                font-size: 16px;
            }
            .right-container .pets-weight .radio-container {
                display: flex;
                justify-content: space-between;
                width: 100%;
            }
            .right-container footer {
                align-items: center;
                /*background: #fff;*/
                display: grid;
                padding: 5px 40px;
            }
            .right-container footer button {
                border: 1px solid rgba(0, 0, 0, 0.2);
                height: 38px;
                line-height: 38px;
                width: 100px;
                border-radius: 19px;
                font-family: "Montserrat", sans-serif;
            }
            .right-container footer #back {
                background: white;
                transition: 0.2s all ease-in-out;
            }
            .right-container footer #back:hover {
                background: #005555;
                color: white;
            }
            .right-container footer #next {
                background: white;
                border: 1px solid transparent;
                color: black;
            }
            .right-container footer #next:hover {
                background: #003333;
            }

            .pets-name label{color: white;}
            .pets-name input{margin-top: 10px;}
            .pets-breed label{color: white; margin-bottom: 10px;}
            .pets-breed input{margin-top: 10px;}
            .pets-birthday label,
            .pets-gender label,
            .pets-spayed-neutered label,
            .pets-weight label {
                display: block;
                margin-bottom: 5px;
            }

            .radio-container {
                background: #fff;
                border: 1px solid rgba(0, 0, 0, 0.1);
                border-radius: 4px;
                display: inline-block;
                padding: 5px;
            }

            .radio-container label {
                background: transparent;
                border: 1px solid transparent;
                border-radius: 2px;
                display: inline-block;
                height: 26px;
                line-height: 26px;
                margin: 0;
                padding: 0;
                text-align: center;
                transition: 0.2s all ease-in-out;
                width: 80px;
            }

            .radio-container input[type=radio] {
                display: none;
            }

            .radio-container input[type=radio]:checked + label {
                background: #f7b1ab;
                border: 1px solid rgba(0, 0, 0, 0.1);
            }
            .table-cell {
                display: block;
            }
            .social-container {
                margin: 10px 0;
            }

            .social-container a {
                border: 1px solid #005555;
                border-radius: 50%;
                display: inline-flex;
                justify-content: center;
                align-items: center;
                margin: 0 5px;
                height: 40px;
                width: 40px;
            }
            .signup_link{text-align: right;color:white}
            .error{color: white;text-align: right;}
            .use{
                color:#003333;
                margin-top: 20px;
            }



            .form-box{
                width:380px;
                height:520px;
                position:relative;
                background:#fff;
                padding:5px;
                overflow:hidden;
            }
            .button-box{
                width:220px;
                margin:35px auto;
                position:relative;
                box-shadow:0 0 20px 9px #ff61241f;
                border-radius:30px;
            }
            .toggle-btn{
                padding:10px 30px;
                cursor:pointer;
                background:transparent;
                border:0;
                outline:none;
                position:relative;
            }
            #btn{
                top:0;
                left:0;
                position:absolute;
                width:110px;
                height:100%;
                background:linear-gradient(to right,#ff105f,#ffad06);
                border-radius:30px;
                transition:.5s;
            }
            .input-group{
                top:180px;
                position:absolute;
                width:280px;
                transition:.5s;
            }
            .input-field{
                width:100%;
                padding:10px 0;
                margin:5px 0;
                border-left:0;
                border-top:0;
                border-right:0;
                border-bottom:1px solid #999;
                outline:none;
                background:transparent;
            }
            .submit-btn{
                width:85%;
                padding:10px 30px;
                cursor:pointer;
                display:block;
                margin:auto;
                background:linear-gradient(to right,#ff105f,#ffad06);
                border:0;
                outline:none;
                border-radius:30px;
            }
            .check-box{
                margin:30px 10px 30px 0;
            }
            .span{
                color:#777;
                font-size:12px;
                bottom:68px;
                position:absolute;
            }
            #login{
                left:50px;
            }
            #register{
                left:450px;
            }
        </style>
        <div class="parent clearfix">
            <div class="bg-illustration">
                <!--<img src="https://grandpark-vinhomes.com/wp-content/uploads/2020/07/vinhomes-quan9-logo-1.png" alt="logo">-->

                <div class="burger-btn">
                    <span></span>
                    <span></span>
                    <span></span>
                </div>

            </div>
            <div class='signup-container'>
                <div class='left-container'>
                    <img src='https://grandpark-vinhomes.com/wp-content/uploads/2020/07/vinhomes-quan9-logo-1.png' alt='logo'>
                </div>

                <div class="form-box">
                    <div class='right-container'>
                        <header>
                            <div class="button-box">
                                <div id="btn"></div>
                                <button type="button" class="toggle-btn" onclick="login()">Log In</button>
                                <button type="button" class="toggle-btn" onclick="register()">Admin</button>
                            </div>
                            <form action='MainController' method='POST' id="login" class="input-group">

                                <span><c:out value='${requestScope.USER_ERROR.phone}' /></span>
                                <span><c:out value='${requestScope.USER_ERROR.password}' /></span>
                                <span><c:out value='${requestScope.USER_ERROR.email}' /></span>
                                <span><c:out value='${requestScope.USER_ERROR.customerAddress}' /></span>
                                <span><c:out value='${requestScope.USER_ERROR.confirm}' /></span>

                                <div class='set'>
                                    <div class='pets-breed'>
                                        <label for='Phone'></label>
                                        <input type='text' id='Phone' name='Phone' placeholder="Phone" required="" style="width:300px;">${requestScope.ERROR}
                                    </div>

                                </div><div class="error"></div>
                                <div class='set'>
                                    <div class='pets-name'>
                                        <label for='Password'></label>
                                        <input type='password' id='Password' name='Password' placeholder="Password" required="" style="width:300px;">
                                    </div>
                                </div>
                                <div class="signup_link">Not a member? <a href="register">Signup</a></div>
                                <div class="gmail" style="display:flex;  vertical-align:middle;">
                                    <div class="social-container">
                                        <a href="" class="social"><img src="https://ss-images.saostar.vn/pc/1601999087461/newgmaillogo_0(2).jpg" style="width:45px;height:41px;border-radius: 40px;"><i class="fab fa-linkedin-in"></i></a>
                                    </div>
                                    <span class="use">or use your email for registration</span>
                                </div>
                                <div class="signup_link"><a href="RegisterEmployee">Đăng kí nhân viên</a></div>
                                <footer>
                                    <div class='set'>
                                        <input type="submit" name="action" value="Login"/>
                                    </div>
                                </footer>
                            </form>

                            <!---------------------------- ADMIN ----------------------------------------------------------------------------->
                            <form action='MainController' method='POST'  id="register" class="input-group">
                                <span><c:out value='${requestScope.USER_ERROR.phone}' /></span>
                                <span><c:out value='${requestScope.USER_ERROR.password}' /></span>
                                <span><c:out value='${requestScope.USER_ERROR.email}' /></span>
                                <span><c:out value='${requestScope.USER_ERROR.customerAddress}' /></span>
                                <span><c:out value='${requestScope.USER_ERROR.confirm}' /></span>

                                <div class='set'>
                                    <div class='pets-breed'>
                                        <label for='Phone'></label>
                                        <input type='text' id='Phone' name='Phone' placeholder="Phone" required="" style="width:300px;">${requestScope.ERROR}
                                    </div>

                                </div><div class="error"></div>
                                <div class='set'>
                                    <div class='pets-name'>
                                        <label for='Password'></label>
                                        <input type='password' id='Password' name='Password' placeholder="Password" required="" style="width:300px;">
                                    </div>
                                </div>

                                <div class="gmail" style="display:flex;  vertical-align:middle;">
                                    <div class="social-container">
                                        <a href="" class="social"><img src="https://ss-images.saostar.vn/pc/1601999087461/newgmaillogo_0(2).jpg" style="width:45px;height:41px;border-radius: 40px;"><i class="fab fa-linkedin-in"></i></a>
                                    </div>
                                    <span class="use">or use your email for registration</span>
                                </div>
                                <footer>
                                    <div class='set'>
                                        <input type="submit" name="action" value="Admin"/>
                                    </div>
                                </footer>
                            </form>
                        </header>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

<script>
    var x = document.getElementById("login");
    var y = document.getElementById("register");
    var z = document.getElementById("btn");
    function register() {
        x.style.left = "-400px";
        y.style.left = "50px";
        z.style.left = "110px";
    }
    function login() {
        x.style.left = "50px";
        y.style.left = "450px";
        z.style.left = "0px";
    }
</script>
</html>     

