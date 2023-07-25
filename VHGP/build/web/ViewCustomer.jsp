<%-- 
    Document   : ViewCustomer
    Created on : Jun 23, 2023, 10:02:27 AM
    Author     : hathao
--%>

<%@page import="model.Customer"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Role"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>UserProfile</title>
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

    <style>

        body{
            margin-top:20px;
            color: #1a202c;
            text-align: left;
            background-color: #BFEFFF;    
        }
        .main-body {
            padding: 15px;
        }
        .card {
            box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
        }

        .card {
            position: relative;
            display: flex;
            flex-direction: column;
            min-width: 0;
            word-wrap: break-word;
            background-color: #fff;
            background-clip: border-box;
            border: 0 solid rgba(0,0,0,.125);
            border-radius: .25rem;
        }

        .card-body {
            flex: 1 1 auto;
            min-height: 1px;
            padding: 1rem;
        }

        .gutters-sm {
            margin-right: -8px;
            margin-left: -8px;
        }

        .gutters-sm>.col, .gutters-sm>[class*=col-] {
            padding-right: 8px;
            padding-left: 8px;
        }
        .mb-3, .my-3 {
            margin-bottom: 1rem!important;
        }

        .bg-gray-300 {
            background-color: #e2e8f0;
        }
        .h-100 {
            height: 100%!important;
        }
        .shadow-none {
            box-shadow: none!important;
        }
        .btn-info {
            background-color: rgba(10,50,30,0.95);
        }

        .btn-info:hover
        {
            background-color: rgba(10,50,30,0.95);
        }

        .btn.btn-outline-primary:hover{
            background-color: rgba(10,50,30,0.95);
        }

        .text-secondary.mb-1{
            font-weight: 600;
        }
    </style>

</head>
<body>
    <div class="container">
        <div class="main-body">

            <!-- Breadcrumb -->
            <nav aria-label="breadcrumb" class="main-breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="MainController?action=ListService">Home</a></li>
                    <!--              <li class="breadcrumb-item"><a href="javascript:void(0)">User</a></li>-->
                    <li class="breadcrumb-item active" aria-current="page">User Profile</li>
                </ol>
            </nav>
            <!-- /Breadcrumb -->

            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" class="rounded-circle" width="150">
                                <div class="mt-3">
                                    <h4>CUSTOMER</h4>
                                    <p class="text-secondary mb-1">VHGP</p>
                                    <p class="text-muted font-size-sm">Dịch vụ vệ sinh nhà cửa VinHome Grand Park</p>
                                    <button class="btn btn-outline-primary">Message</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mt-3">
                        <ul class="list-group list-group-flush">

                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-twitter mr-2 icon-inline text-info"><path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z"></path></svg>Twitter</h6>
                                <span class="text-secondary">@bootdey</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-instagram mr-2 icon-inline text-danger"><rect x="2" y="2" width="20" height="20" rx="5" ry="5"></rect><path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"></path><line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line></svg>Instagram</h6>
                                <span class="text-secondary">bootdey</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-facebook mr-2 icon-inline text-primary"><path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z"></path></svg>Facebook</h6>
                                <span class="text-secondary">bootdey</span>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-8">
                    <div class="card mb-3">
                        <div class="card-body">
                            <c:if test="${requestScope.DETAILS_CUSTOMER != null}">
                                <c:if test="${ not empty requestScope.DETAILS_CUSTOMER}">
                                    <c:forEach items="${requestScope.DETAILS_CUSTOMER}" var="pro" varStatus="counter">

                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Name</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">${pro.customerName}</div>
                                        </div>

                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Phone</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">${pro.phone}</div>    
                                        </div>

                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Password</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">${pro.password}</div>
                                        </div>

                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">BirthDay</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">${pro.birthDay}</div>
                                        </div>

                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Email</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">${pro.email}</div>
                                        </div>

                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Address</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">${pro.customerAddress}</div>
                                        </div>

                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Gender</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">${pro.isGender() ? "Male" : "Female"}</div>
                                        </div>

                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <a href="UpdateCustomer?CustomerID=${pro.customerID}"class="btn btn-primary">Update profile</a>
                                                <button class="btn address-more" type="button" onclick="window.location.href = 'addmoreaddress.jsp'"><span class="fa fa-plus-circle"></span>Thêm địa chỉ</span></button>
                                                <button class="btn address-more" type="button" onclick="deleteAddressPhone()">Xóa địa chỉ và số điện thoại</button>

                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </c:if>

                        <input type="hidden" name="customerAddress" id="customerAddress">
                        <input type="hidden" name="phone" id="phone">
                        <input type="hidden" name="addressPhoneToDelete" id="addressPhoneToDelete">
                        <form id="deleteAddressForm" action="DeleteAddress" method="POST">
                            <input type="hidden" name="customerAddress" id="addressToDelete">
                            <input type="hidden" name="phone" id="phoneToDelete">
                        </form>
                    </div>

                </div>
            </div>

        </div>
    </div>
</div>             
<script>
    function deleteAddressPhone() {
        var selectElement = document.querySelector('select[name="addressPhone"]');
        var selectedValue = selectElement.value;
        // Extract the address and phone number from the selected value
        var addressPhone = selectedValue.split(" - ");
        var addressToDelete = document.getElementById('addressToDelete');
        var phoneToDelete = document.getElementById('phoneToDelete');

        // Set the values of the hidden form fields
        addressToDelete.value = addressPhone[0].trim();
        phoneToDelete.value = addressPhone[1].trim();

        // Submit the form to delete the address and phone number
        document.getElementById('deleteAddressForm').submit();
    }
    function updateAddressPhone(selectElement) {
        var selectedValue = selectElement.value;
        var CustomerAddress = document.getElementById('CustomerAddress');
        var Phone = document.getElementById('Phone');
        var addressPhone = selectedValue.split('-');

        CustomerAddress.value = decodeURIComponent(addressPhone[0]);
        Phone.value = decodeURIComponent(addressPhone[1]);
    }
</script>

</body>
</html>
