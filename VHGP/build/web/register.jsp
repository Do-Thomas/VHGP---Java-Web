<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Register</title>
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
                background: #005555;
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
                max-width: 900px;
            }

            .left-container {
                background: #769393;
                overflow: hidden;
                padding: 40px 0 0 0;
                position: relative;
                text-align: center;
                width: 300px;
                font-size: 20px;

            }
            left-container h1 {
                text-align: center;
                margin: auto;
                margin-top: 100px;
                color: rgba(0, 0, 0, 0.8);
                display: inline-block;
                /*font-size: 100px;*/
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
                filter: sepia(100%);
                width: 90%;
                /*height: 100%;*/
            }

            .right-container {
                background: #333333;
                display: grid;
                grid-template-areas: "." ".";
                width: 500px;
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
                background: #0E8385;
                color: white;
            }
            .right-container footer #next {
                background: white;
                border: 1px solid transparent;
                color: black;
            }
            .right-container footer #next:hover {
                background: #171a2b;
            }

            .pets-name label,
            .pets-breed label,
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
                display: inline-block;padding: 5px;
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
                    <h1>
                        <!--<i class='fas fa-paw'></i>-->
                        Register
                    </h1>
                    <div class='puppy'>
                        <img src='https://grandpark-vinhomes.com/wp-content/uploads/2020/07/vinhomes-quan9-logo-1.png' alt='logo'>
                    </div>
                </div>
                <div class='right-container'>
                    <header>
                        <h1>Please fill out the registration form below</h1>
                        <form action='register' method='POST'>
                            <div class='set'>
                                <div class='pets-name'>
                                    <!--<label for='CustomerName'>Name</label>-->
                                    <input type='text' id='CustomerName' name='CustomerName' placeholder="Full name">
                                </div>
                                <div class='pets-breed'>
                                    <!--<label for='Phone'>Phone</label>-->
                                    +84: <input type='text' id='Phone' name='Phone' placeholder="Phone">
                                </div>
                            </div>
                            <div class='set'>
                                <span><c:out value='${requestScope.USER_ERROR.customerName}' /><br></span>
                                <span><c:out value='${requestScope.USER_ERROR.phone}' /><br></span>
                            </div>
                            <div class='set'>
                                <div class='pets-name'>
                                    <!--<label for='Password'>Password</label>-->
                                    <input type='password' id='Password' name='Password' placeholder="Customer's password">
                                </div>
                                <div class='pets-breed'>
                                    <!--<label for='confirm'>Confirm Password</label>-->
                                    <input type='password' id='confirm' name='confirm' placeholder='Confirm password'>
                                </div>
                            </div>
                            <div class='set'>
                                <span><c:out value='${requestScope.USER_ERROR.password}' /><br></span>
                                <span><c:out value='${requestScope.USER_ERROR.confirm}' /><br></span>

                            </div>
                            <div class='set'>
                                <div class='pets-name'>
                                    <!--<label for='Email'>Email</label>-->
                                    <input type='email' id='Email' name='Email' placeholder="Email">
                                </div>
                                <div class='pets-gender'>
                                    <!--<label for='male'>Gender</label>-->
                                    <div class='radio-container'>
                                        <input type='radio' id='male' name='Gender' value='male'>
                                        <label for='male'>Male</label>
                                        <input type='radio' id='female' name='Gender' value='female'>
                                        <label for='female'>Female</label>
                                    </div>
                                </div>
                            </div>
                            <div class='set'>
                                <span><c:out value='${requestScope.USER_ERROR.email}' /><br></span>
                            </div>
                            <div class='set'>
                                <div class='pets-name'>
                                    <!--<label for='CustomerAddress'>Address</label>-->
                                    <input type='text' id='CustomerAddress' name='CustomerAddress' placeholder="Address">
                                </div>
                                <div class='pets-birthday'>
                                    <!--<label for='BirthDay'>Birthday</label>-->
                                    <input type='date' id='BirthDay' name='BirthDay' placeholder=Birthday>
                                </div>
                            </div>
                            <div class='set'>
                                <span><c:out value='${requestScope.USER_ERROR.customerAddress}' /><br></span>
                                <span><c:out value='${requestScope.USER_ERROR.birthDay}' /><br></span>

                            </div>
                            <footer>
                                <div class='set'>
                                    <button id='back'><a href="login.jsp" style="text-decoration: none">Login</a></button>
                                    <button id='next'>Register</button>
                                </div>
                            </footer>
                        </form>
                    </header>
                </div>
            </div>
        </div>
    </div>


</body>
</html>