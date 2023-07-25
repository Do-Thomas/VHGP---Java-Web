<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Quản trị Admin</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="admin/css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang quản lý</title>
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

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/sidebar.css">
        <link href="js/sidebar.js">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800,900" rel="stylesheet">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="../css/table.css" rel="stylesheet">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script>
    </head>
</head>
<body>
    <style type="text/css">
        body {font-family: Helvetica, sans-serif;font-size:13px;}
        .container{max-width: 680px; margin:0 auto;}
        .logotype{background:#000;color:#fff;width:75px;height:75px;  line-height: 75px; text-align: center; font-size:11px;}
        .column-title{background:#eee;text-transform:uppercase;padding:15px 5px 15px 15px;font-size:11px}
        .column-detail{border-top:1px solid #eee;border-bottom:1px solid #eee;}
        .column-header{background:#eee;text-transform:uppercase;padding:15px;font-size:11px;border-right:1px solid #eee;}
        .row{padding:7px 14px;border-left:1px solid #eee;border-right:1px solid #eee;border-bottom:1px solid #eee;}
        .alert{background: #9bce96;padding:20px;margin:20px 0;line-height:22px;color:#333}
        .socialmedia{background:#eee;padding:20px; display:inline-block}
    </style>
    <div class="container">

        <table width="100%">
            <tr>
                <td width="300px"><div style="background: #9bce96;border-left: 15px solid #fff;padding-left: 30px;font-size: 26px;font-weight: bold;letter-spacing: -1px;height: 73px;line-height: 75px;">Hóa đơn</div></td>
                <td></td>
            </tr>
        </table> 
        <br><br>
        <c:set var="bill" value="${requestScope.INFO}"/>
        <table width="100%" style="border-collapse: collapse;">
            <tr>
                <td widdth="50%" style="background:#eee;padding:20px;">
                    <strong>Tên khách hàng:</strong> ${bill.customer.customerName}<br>
                    <strong>Số điện thoại:</strong> ${bill.customerDetail.phone}<br>
                    <strong>Địa chỉ:</strong> ${bill.customerDetail.customerAddress}<br>
                </td>
            </tr>
        </table><br>

        <table width="100%" style="border-top:1px solid #eee;border-bottom:1px solid #eee;padding:0 0 8px 0">
            <tr>
                <td><h3>Chi tiết hóa đơn</h3><td>
            </tr>
        </table><br>
        <div style="background: #9bce96 url(https://cdn4.iconfinder.com/data/icons/basic-ui-2-line/32/shopping-cart-shop-drop-trolly-128.png) no-repeat;width: 50px;height: 50px;margin-right: 10px;background-position: center;background-size: 25px;float: left; margin-bottom: 15px;"></div> 
        <h3>Dịch vụ</h3>
        <c:if test="${requestScope.BILL != null}">
            <c:if test="${ not empty requestScope.BILL}">
                <c:forEach items="${requestScope.BILL}" var="b" varStatus="counter">
                    <c:set var="timeStart" value="${b.orderDetail.timeStart}"/>
                    <c:set var="timeEnd" value="${b.orderDetail.timeEnd}"/>
                    <table width="100%" style="border-collapse: collapse;border-bottom:1px solid #eee;">
                        <tr>
                            <td width="40%" class="column-header">Dịch vụ</td>
                            <td width="20%" class="column-header">Giá</td>
                            <td width="20%" class="column-header">Bắt đầu</td>
                            <td width="20%" class="column-header">Kết thúc</td>
                        </tr>
                        <tr>
                            <td class="row">${b.orderDetail.orderDServiceName}</td>
                            <td class="row">${b.orderDetail.orderDServicePrice}</td>
                            <td class="row"><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${timeStart}"/> </td>
                            <td class="row"><fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss aaa" value="${timeEnd}"/></td>
                        </tr>

                    </table><br>
                </c:forEach>
            </c:if>
        </c:if>
        <table width="100%" style="background:#eee;padding:20px;">
            <tr>
                <td>
                    <table width="300px" style="float:right">
                        <tr>
                            <td><strong>Tổng:</strong></td>
                            <td style="text-align:right">${total}00 VND</td>
                        </tr>  
                    </table>
                </td>
            </tr>
        </table>

        <div class="alert"><a class="" href="MainController?action=ListService">Tiếp tục đặt dịch vụ</a></div>

    </div><!-- container -->
</body>

</html>
