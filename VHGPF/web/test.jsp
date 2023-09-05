<!DOCTYPE html>
<html>
    <head>
        <!-- Font Awesome Icon Library -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            #invoice-POS {
                padding: 6mm;
                margin: 0 auto;
                width: 80mm;
                background: #FFF;
            }
            #invoice-POS ::selection {
                background-color: #FFF;
                color: #FFF;
            }
            #invoice-POS ::moz-selection {
                background-color: #FFF;
                color: #FFF;
            }
            #invoice-POS h1 {
                font-size: 1.6em;
                color: #222;
            }
            #invoice-POS h2 {
                font-size: 1em;
            }
            #invoice-POS h3 {
                font-size: 1.3em;
                font-weight: 300;
                line-height: 2em;
            }
            #invoice-POS p {
                font-size: 0.9em;
                color: #666;
                line-height: 1.2em;
            }
            #invoice-POS #top, #invoice-POS #mid, #invoice-POS #bot {
                /* Targets all id with 'col-' */
                border-bottom: 1px solid #EEE;
            }
            #invoice-POS #top {
                min-height: 100px;
            }
            #invoice-POS #mid {
                min-height: 80px;
            }
            #invoice-POS #bot {
                min-height: 50px;
            }
            #invoice-POS #top .logo {
                height: 80px;
                width: 80px;
                background: url(http://michaeltruong.ca/images/logo1.png) no-repeat;
                background-size: 80px 80px;
            }
            #invoice-POS .info {
                display: block;
                margin-left: 0;
            }
            #invoice-POS .title {
                float: right;
            }
            #invoice-POS .title p {
                text-align: right;
            }
            #invoice-POS table {
                width: 100%;
                border-collapse: collapse;
            }
            #invoice-POS .tabletitle {
                font-size: 0.7em;
                background: #EEE;
            }
            #invoice-POS .service {
                border-bottom: 1px solid #EEE;
            }
            #invoice-POS .item {
                width: 24mm;
            }
            #invoice-POS .itemtext {
                font-size: 0.8em;
            }
            #invoice-POS #legalcopy {
                margin-top: 5mm;
            }

        </style>
    </head>
    <body>

        <div id="invoice-POS">

            <center id="top">
                <div class="logo"></div>
                <div class="info"> 
                    <h2>Twarrad</h2>
                </div><!--End Info-->
            </center><!--End InvoiceTop-->

            <div id="mid">
                <div class="info">
                    <h2>Contact Info</h2>
                    <p> 
                        Address : street city, state 0000</br>
                        Email   : JohnDoe@gmail.com</br>
                        Phone   : 555-555-5555</br>
                    </p>
                </div>
            </div><!--End Invoice Mid-->

            <div id="bot">

                <div id="table">
                    <table>
                        <tr class="tabletitle">
                            <td class="item"><h2>Item</h2></td>
                            <td class="Hours"><h2>Qty</h2></td>
                            <td class="Rate"><h2>Sub Total</h2></td>
                        </tr>

                        <tr class="service">
                            <td class="tableitem"><p class="itemtext">Communication</p></td>
                            <td class="tableitem"><p class="itemtext">5</p></td>
                            <td class="tableitem"><p class="itemtext">$375.00</p></td>
                        </tr>

                        <tr class="tabletitle">
                            <td></td>
                            <td class="Rate"><h2>tax</h2></td>
                            <td class="payment"><h2>$419.25</h2></td>
                        </tr>

                        <tr class="tabletitle">
                            <td></td>
                            <td class="Rate"><h2>Total</h2></td>
                            <td class="payment"><h2>$3,644.25</h2></td>
                        </tr>

                    </table>
                </div><!--End Table-->

                <div id="legalcopy">
                    <p class="legal"><strong>Thank you for your business!</strong>  lorem ipsum
                    </p>
                </div>

            </div><!--End InvoiceBot-->
        </div><!--End Invoice-->


    </body>
</html>
