<!DOCTYPE html>
<html>
    <head>
        <style>
            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                padding: 12px 16px;
                z-index: 1;
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }
        </style>
    </head>
    <body>
        <!DOCTYPE html>
    <html>
        <style>
            th,td {
                padding: 5px;
            }
        </style>
        <body>

            <h2>The XMLHttpRequest Object</h2>

            <div id="demo">
                <p>Let AJAX change this text.</p>
                <button type="button" onclick="loadDoc()">Change Content</button>
            </div>

            <script>
                function loadDoc() {
                    const xhttp = new XMLHttpRequest();
                    xhttp.onload = function () {
                        document.getElementById("demo").innerHTML = this.responseText;
                    }
                    xhttp.open("GET", "OutOfStaff.jsp");
                    xhttp.send();
                }
            </script>
        </body>
    </html>


</body>
</html>

<!--

    <c:set var="message" value="Hello from Java" />

    <script>
        var jsMessage = '${message}';
        console.log(jsMessage);
    </script>-->
