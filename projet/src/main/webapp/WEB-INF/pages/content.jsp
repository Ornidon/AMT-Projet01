<%-- 
    Document   : content
    Created on : 18 oct. 2016, 21:39:43
    Author     : Ornidon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>hello</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
        <link rel="stylesheet" href="assets/css/main.css" />
        <!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
    </head>
    <body>
        <div id="page-wrapper">

            <!-- Header -->
            <div id="header-wrapper">
                <header id="header" class="container">
                    <div class="row">
                        <div class="12u">

                            <!-- Logo -->
                            <h1><a href="#" id="logo">AMT-Projet01</a></h1>

                            <!-- Nav -->
                            <nav id="nav">
                                <a href="${pageContext.request.contextPath}/login">Login</a>
                                <a href="${pageContext.request.contextPath}/register">Register</a>
                                <a href="${pageContext.request.contextPath}/content">Application</a>
                                <a href="${pageContext.request.contextPath}/logout">Logout</a>
                            </nav>

                        </div>
                    </div>
                </header>
                <div id="banner">
                    <div class="container">
                        <div class="row" height='800px'>
                            <div class="6u 12u(mobile)">
                                <h1>ACTOR FINDER!</h1>
                                Don't be shy! Enter a film name and if i know it i'll give you all his actors
                                (see the result below).

                                <form action="${pageContext.request.contextPath}/content" method="post">
                                    Film's name: <input type="text" name="filmName"><br>
                                    <input type="submit"class="button-big" value="Submit">
                                </form>
                            </div>
                            <div class="6u 12u(mobile)">

                                <!-- Banner Image -->
                                <a href="#" class="bordered-feature-image"><img src="images/banner.jpg" alt="" /></a>

                            </div>
                        </div>
                    </div>
                </div>                           
            </div>
        </div>
        <!-- Content -->
        <div id="content-wrapper">
            <div id="content">
                <div class="container">
                    <div class="row">
                        <div class="4u 12u(mobile)">

                            <!-- Box #1 -->
                            <section>
                                <p>
                                    ${data}
                                </p>
                            </section>

                        </div>
                    </div>
                </div>
            </div>
        </div>




        <!-- Copyright -->
        <div id="copyright">
            &copy; Untitled. All rights reserved. | Design: <a href="http://html5up.net">HTML5 UP</a>
        </div>

    </div>



</body>
</html>
