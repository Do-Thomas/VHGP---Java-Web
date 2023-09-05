<%-- 
    Document   : FeedBack
    Created on : Jun 25, 2023, 11:27:27 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FeedBack</title>
        <style>
            @import url(//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css);

            html {
                font: 300 100%/1.5 Ubuntu, sans-serif;
                color: #333;
                overflow-x: hidden;
            }
            h2 {
                
                color: #8495a5;
                font-size: 2.5em;
                font-weight: 300;
            }
            #contact-form {
                max-width: 1208px;
                max-width: 75.5rem;
                margin: 0 auto;
            }
            #contact, label, input[name="submit"] {
                position: relative;
            }
            label > span, input, textarea, button {
                box-sizing: border-box;
            }
            label {
                display: block;
            }
            label > span {
                display: none;
            }
            input, textarea, button {
                width: 100%;
                padding: 0.5em;
                border: none;
                font: 300 100%/1.2 Ubuntu, sans-serif;
            }
            input[type="text"], input[type="email"], textarea {
                margin: 0 0 1em;
                border: 1px solid #ccc;
                outline: none;
            }
            input.invalid, textarea.invalid {
                border-color: #d5144d;
            }
            textarea {
                height: 6em;
            }
            input[type="submit"], button {
                background: #a7cd80;
                color: #333;
            }
            input[type="submit"]:hover, button:hover {
                background: #91b36f;
            }


            fieldset, label { margin: 0; padding: 0; }
            body{ margin: 20px; }
            h1 { font-size: 1.5em; margin: 10px; }

            /****** Style Star Rating Widget *****/

            .rating { 
                border: none;
                float: left;
            }

            .rating > input { display: none; } 
            .rating > label:before { 
                margin: 5px;
                font-size: 1.25em;
                font-family: FontAwesome;
                display: inline-block;
                content: "\f005";
            }

            .rating > .half:before { 
                content: "\f089";
                position: absolute;
            }

            .rating > label { 
                color: #ddd; 
                float: right; 
            }

            /***** CSS Magic to Highlight Stars on Hover *****/

            .rating > input:checked ~ label, /* show gold star when clicked */
            .rating:not(:checked) > label:hover, /* hover current star */
            .rating:not(:checked) > label:hover ~ label { color: #FFD700;  } /* hover previous stars in list */

            .rating > input:checked + label:hover, /* hover current star when changing rating */
            .rating > input:checked ~ label:hover,
            .rating > label:hover ~ input:checked ~ label, /* lighten current selection */
            .rating > input:checked ~ label:hover ~ label { color: #FFED85;  } 
            @media screen and (min-width: 30em) {
                #contact-form h2 {
                    margin-left: 26.3736%;
                    font-size: 2em;
                    line-height: 1.5;
                }
                label > span {
                    vertical-align: top;
                    display: inline-block;
                    width: 26.3736%;
                    padding: 0.5em;
                    border: 1px solid transparent;
                    text-align: right;
                }
                input, textarea, button {
                    width: 73.6263%;
                    line-height: 1.5;
                }
                textarea {
                    height: 10em;
                }
                input[type="submit"], button {
                    margin-left: 26.3736%;
                }
            }
            @media screen and (min-width: 48em) {
                #contact-form {
                    text-align: justify;
                    line-height: 0;
                }
                #contact-form:after {
                    content: '';
                    display: inline-block;
                    width: 100%;
                }
                #contact-form h2 {
                    margin-left: 17.2661%;
                }
                #contact-form form, #contact-form aside {
                    vertical-align: top;
                    display: inline-block;
                    width: 65.4676%;
                    text-align: left;
                    line-height: 1.5;
                }
                #contact-form aside {
                    width: 30.9353%;
                }
            }
            .star{
                margin-left: 25%;
                margin-bottom: 5%;
            }
            .nhicss{
                margin-bottom: 50px;
            }
        </style>
    </head>
    <body>
        <section id="contact-form">
            <h2>FeedBack</h2>
           
            <form action="FeedBack" id="contact" name="contact" accept-charset="utf-8">
                 <div class="nhicss">
                <label><span>Dịch vụ</span><input name="title" type="text" placeholder="Name" value="${param.ServiceName}"/></label>
                <!--                <label><span>Chi tiết</span><input name="email" type="email" placeholder="Email"/></label>-->

                <label>
                    <span>Hình ảnh</span><input type="file" id="" name="picture" >
                </label>
                <label><span>Chi tiết</span><textarea name="message" placeholder="Message"></textarea></label>
                <div class="star">
                    <fieldset class="rating">
                    <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
<!--                    <input type="radio" id="star4half" name="rating" value="4 and a half" /><label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>-->
                    <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
<!--                    <input type="radio" id="star3half" name="rating" value="3 and a half" /><label class="half" for="star3half" title="Meh - 3.5 stars"></label>-->
                    <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
<!--                    <input type="radio" id="star2half" name="rating" value="2 and a half" /><label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>-->
                    <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
<!--                    <input type="radio" id="star1half" name="rating" value="1 and a half" /><label class="half" for="star1half" title="Meh - 1.5 stars"></label>-->
                    <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
<!--                    <input type="radio" id="starhalf" name="rating" value="half" /><label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>-->
                </fieldset>
                </div>
                <label></label>
                </div>
                <input name="submit" type="submit" value="Send"/>
            </form>
            
            <aside>

            </aside>
        </section>
    </body>
</html>
