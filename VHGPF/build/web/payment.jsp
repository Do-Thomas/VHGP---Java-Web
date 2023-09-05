<%-- 
    Document   : test1
    Created on : Jul 4, 2023, 3:12:56 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thanh toán</title>
    </head>
    <style>
        html { 
            background: url() no-repeat center center fixed;
            background-size: cover;
            font-family: 'Raleway', sans-serif;
            text-transform: uppercase;
        }

        p {
            color: rgba(0,0,0,0.7);
        }

        body {
            position: relative;
        }

        .words {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            text-align: center;
            position: absolute;
            left: 0;
        }

        .overlay {
            font-size: 40vh;
            color: white;
            opacity: .6;
            margin-top: 0px;
            text-align: center;
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 100%;
            z-index: 1;
        }


        .wrap {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-orient: vertical;
            -webkit-box-direction: normal;
            -webkit-flex-direction: column;
            -ms-flex-direction: column;
            flex-direction: column;
            height: 100vh;
            -webkit-box-align: center;
            -webkit-align-items: center;
            -ms-flex-align: center;
            align-items: center;
            -webkit-box-pack: center;
            -webkit-justify-content: center;
            -ms-flex-pack: center;
            justify-content: center;

        }

        .paymentdeets {
            background-color: white;
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-orient: vertical;
            -webkit-box-direction: normal;
            -webkit-flex-direction: column;
            -ms-flex-direction: column;
            flex-direction: column;
            background-color: #298efa;
            width: 70%;
            min-width: 400px;
            max-width: 800px;
            -webkit-flex-wrap: wrap;
            -ms-flex-wrap: wrap;
            flex-wrap: wrap;
            border-radius: 10px;
            box-shadow: 10px 10px 20px rgba(0,0,0,0.7);
            z-index: 2;

        }

        .head {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-pack: justify;
            -webkit-justify-content: space-between;
            -ms-flex-pack: justify;
            justify-content: space-between;
            color: white;
            padding: 40px;
            -webkit-box-align: center;
            -webkit-align-items: center;
            -ms-flex-align: center;
            align-items: center;
        }

        .logo {
            height: 50px;
        }

        .formtop {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-pack: justify;
            -webkit-justify-content: space-between;
            -ms-flex-pack: justify;
            justify-content: space-between;
            padding: 40px;
            background-color: white;
            -webkit-box-flex: 1;
            -webkit-flex: 1 1;
            -ms-flex: 1 1;
            flex: 1 1;
            -webkit-flex-wrap: wrap;
            -ms-flex-wrap: wrap;
            flex-wrap: wrap;
        }

        .formbottom {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-pack: justify;
            -webkit-justify-content: space-between;
            -ms-flex-pack: justify;
            justify-content: space-between;
            padding: 40px;
            background-color: white;
            -webkit-box-flex: 1;
            -webkit-flex: 1 1;
            -ms-flex: 1 1;
            flex: 1 1;
            -webkit-flex-wrap: wrap;
            -ms-flex-wrap: wrap;
            flex-wrap: wrap;
        }

        .formtop > * {
            -webkit-box-flex: 1;
            -webkit-flex: 1 1;
            -ms-flex: 1 1;
            flex: 1 1;
        }

        .name, .number  {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-orient: vertical;
            -webkit-box-direction: normal;
            -webkit-flex-direction: column;
            -ms-flex-direction: column;
            flex-direction: column;
            -webkit-box-align: start;
            -webkit-align-items: flex-start;
            -ms-flex-align: start;
            align-items: flex-start;
        }

        input {
            font-size: 16px;
            line-height: 2;
            border: none;
            border-bottom: 1px solid #298efa;
        }

        .name > input, .number > input {
            width: 300px;
            line-height: 2;
            border: none;
            border-bottom: 1px solid #298efa;
        }

        .expiration {
            padding: 0px;
        }
        .select-style {
            border-bottom: 1px solid #298efa;
            width: 120px;
            overflow: hidden;
        }

        .select-style select {
            padding: 5px 8px;
            width: 130%;
            font-size: 16px;
            border: none;
            box-shadow: none;
            background: transparent;
            background-image: none;
            -webkit-appearance: none;
        }

        .select-style select:focus {
            outline: none;
        }

        .c2a {
            background-color: #298efa;
            width:100%;
            border: none;
            color: white;
            padding: 20px;
            font-size: 20px;
            border-bottom-left-radius: 10px;
            border-bottom-right-radius: 10px;
        }

        *:focus {
            outline: none;
        }



    </style>
    <body>

    <html>
        <head>
            <title></title>
            <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
            <link rel="stylesheet" type="text/css" href="build/styles.css">
        </head>
        <body>

            <!--            <div class="words">
                            <h1 class="overlay">ACB</h1>
                        </div>-->


            <div class="wrap">
                <div class="paymentdeets">
                    <div class="head">
                        <h1></h1>
                        <img class="logo" src="image/icon/acb.png" alt="">
                    </div>

                    <form action="MainController" method="POST">
                        <div class="formtop">
                            <c:set var="card" value="${requestScope.LOGIN_USER}"/>
                            <div class="name">
                                <p>Tên chủ thẻ</p>
                                <input type="text" name="cardName" value="${LOGIN_USER.customerName}"></input>
                            </div>
                            <div class="number">
                                <p>Số thẻ</p>
                                <input type="number" name="cardID"></input>
                            </div>
                        </div>

                        <div class="formbottom">
                            <div class="number">
                                <p>Ngày phát hành</p>
                                <input type="date" name="cardDate"></input>
                            </div>
                            <div class="cvv">
                                <p>Mật khẩu OTP</p>
                                <input type="password" name="cardPass"></input>
                            </div>
                        </div>

                        <div class="submit">
                            <button class="c2a" type="submit" name="action" value="Payment">Thanh toán</button>
                        </div>
                    </form>
                </div>
            </div>
        </body>
    </html>
</body>
</html>
<!--https://codepen.io/hamholla/pen/MyavOQ-->