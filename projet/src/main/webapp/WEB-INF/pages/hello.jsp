<%-- 
    Document   : hello
    Created on : 18 oct. 2016, 19:33:10
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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
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
							<div class="row">
								<div class="6u 12u(mobile)">

									<!-- Banner Copy -->
										<p>This is the landing page, please <a href="${pageContext.request.contextPath}/login">login</a> or <a href="${pageContext.request.contextPath}/register">register</a> to access to the content</p>
										

								</div>
								<div class="6u 12u(mobile)">

									<!-- Banner Image -->
										<a href="#" class="bordered-feature-image"><img src="images/banner.jpg" alt="" /></a>

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
											<header>
												<h2>Who We Are</h2>
											</header>
											<p>
                                                                                            We are a free service about films.
											</p>
										</section>

								</div>
								<div class="4u 12u(mobile)">

									<!-- Box #2 -->
										<section>
											<header>
												<h2>What We Do</h2>
											</header>
											<ul class="check-list">
												<li>We permit access to a large database of films.</li>
												<li>You can search for a film and the service will give you its actors.</li>
											</ul>
										</section>

								</div>
								<div class="4u 12u(mobile)">

									<!-- Box #3 -->
										<section>
											<header>
												<h2>What People Are Saying</h2>
												<h3>And a final subheading about our clients</h3>
											</header>
											<ul class="quote-list">
												<li>
													<p>"Excelent work."</p>
													<span>Jane Doe, CEO of UntitledCorp</span>
												</li>
												<li>
													<p>"Outstanding!"</p>
													<span>John Doe, President of FakeBiz</span>
												</li>
												<li>
													<p>"It's running on glassfish right?"</p>
													<span>Mary Smith, CFO of UntitledBiz</span>
												</li>
											</ul>
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
