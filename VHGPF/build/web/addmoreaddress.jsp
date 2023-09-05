<%-- 
    Document   : addmoreaddress
    Created on : Jul 10, 2023, 3:36:13 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Địa chỉ mới</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <!-- CSS -->
        <!-- Plugins CSS -->
        <link rel="stylesheet" href="assets/css/plugins.css">

        <!-- Main Style CSS -->
        <link rel="stylesheet" href="assets/css/style.css">


    </head>

    <body>
        <style>
            .mainsucess {
                margin: 50px auto;
                max-width: 600px;
                padding: 30px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                position: relative;
            }
            .mainsucess .add-button button {
                background-color: #3d9970;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
            .mainsucess .add-button {
                position: absolute;
                top: 0;
                right: 0;
                margin-top: 285px;
            }

            .text-center {
                text-align: center;
                color: #000000;
                margin-bottom: 20px;
            }

            .form-group {
                margin-bottom: 35px;
            }

            label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }

            .form-control {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 5px;
            }

            .error-message {
                color: red;
                margin-top: 10px;
            }
        </style>
        <div class="container">
            <div class="mainsucess">
                <h2 class="text-center">Địa chỉ mới</h2>
                <form action="AddressMore" method="POST">
<!--                    <div class="form-group">
                        <label for="CustomerAddress">Địa chỉ<span>*</span></label>
                        <input id="address" class="form-control" required name="CustomerAddress" type="text">
                    </div>-->
                    <div class="form-group">
                        Khu <select name="area" id="cars">
                            <option value="S1">S1</option>
                            <option value="S2">S2</option>
                            <option value="S3">S3</option>
                            <option value="S5">S5</option>
                            <option value="S6">S6</option>
                            <option value="S7">S7</option>
                            <option value="S8">S8</option>
                            <option value="S9">S9</option>
                            <option value="S10">S10</option>
                        </select>
                        Tòa <select name="building" id="cars">
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                        </select>
                        Tầng <select name="floor" id="cars">
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                        </select>
                        Căn hộ <select name="room" id="cars">
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                        </select>
                    </div>
                    <c:if test="${not empty error1}">
                        <div class="error-message"><h4>${error1}</h4></div>
                    </c:if>
                    <div class="form-group">
                        <label for="Phone">Số điện thoại<span>*</span></label>
                        <input id="phone" class="form-control"  name="Phone" type="text">
                    </div>
                    <c:if test="${not empty error}">
                        <div class="error-message"><h4>${error}</h4></div>
                    </c:if>
                    <div class="add-button">
                        <button type="submit" name="action" value="themmoi" >Thêm mới</button>
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>
