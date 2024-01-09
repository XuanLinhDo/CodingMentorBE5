<%@page import="entity.User"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<%
String first_name = request.getParameter("first_name");
String last_name = request.getParameter("last_name");
String user_name = request.getParameter("user_name");
String password = request.getParameter("password");
String email = request.getParameter("email");

User user = new User();
user.setFirstName(first_name);
user.setLastName(last_name);
user.setUserName(user_name);
user.setPassword(password);
user.setEmail(email);

UserDAO userDao = new UserDAO();

String result = userDao.register(user);

pageContext.getResponse();

%>
<head>
<!-- Basic -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Site Metas -->
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">

<title>Giftos</title>

<!-- Slider stylesheet -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet" />
<!-- Responsive style -->
<link href="css/responsive.css" rel="stylesheet" />
</head>

<body>
	<div class="hero_area">
		<!-- Header section starts -->
		<header class="header_section">
			<nav class="navbar navbar-expand-lg custom_nav-container ">
				<a class="navbar-brand" href="index.html"> <span>Giftos</span>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class=""></span>
				</button>

				<div class="collapse navbar-collapse innerpage_navbar"
					id="navbarSupportedContent">
					<ul class="navbar-nav  ">
						<!-- Add 'active' class to the current page in the navigation -->
						<li class="nav-item"><a class="nav-link" href="index.html">Home</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="shop.html">Shop</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="why.html">Why
								Us</a></li>
						<li class="nav-item"><a class="nav-link"
							href="testimonial.html">Testimonials</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="contact.html">Contact Us</a></li>
					</ul>
					<div class="user_option">
						<a href="#"> <i class="fa fa-user" aria-hidden="true"></i> <span>Login</span>
						</a> <a href="login.jsp"> <i class="fa fa-shopping-bag"
							aria-hidden="true"></i>
						</a>
						<form class="form-inline ">
							<button class="btn nav_search-btn" type="submit">
								<i class="fa fa-search" aria-hidden="true"></i>
							</button>
						</form>
					</div>
				</div>
			</nav>
		</header>
		<!-- End header section -->
	</div>
	<!-- End hero area -->

	<!-- Login section -->
	<section class="contact_section layout_padding">
		<div class="container px-0">
			<div class="heading_container text-center ">
				<h2 class="">Register</h2>
			</div>
		</div>
		<div class="container container-bg">
			<div class="row">
				<div class="col-lg-4 col-md-6 px-0"></div>
				<div class="col-md-6 col-lg-4 px-0">
					<form action="#" method="post">
						<div>
							<input type="text" name="first_name" placeholder="FirstName" />
						</div>
						<div>
							<input type="text" name="last_name" placeholder="LastName" />
						</div>
						<div>
							<input type="text" name="user_name" placeholder="UserName" />
						</div>
						<div>
							<input type="password" name="password" placeholder="Password" />
						</div>
						<div>
							<input type="email" name="email" placeholder="Email" />
						</div>
						<div class="d-flex">
							<button>Submit</button>
						</div>
						<p class="text-center">
							Already have an account? <a href="login.jsp">Login</a>
						</p>
					</form>
				</div>
			</div>
		</div>

	</section>
	<!-- End login section -->

	<!-- Info section -->
	<section class="info_section layout_padding2-top">
		<div class="social_container">
			<div class="social_box">
				<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a> <a
					href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a> <a
					href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a> <a
					href="#"><i class="fa fa-youtube" aria-hidden="true"></i></a>
			</div>
		</div>
		<div class="info_container">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-lg-3">
						<h6>ABOUT US</h6>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed doLorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed doLorem ipsum dolor sit amet,</p>
					</div>
					<div class="col-md-6 col-lg-3">
						<div class="info_form ">
							<h5>Newsletter</h5>
							<form action="#">
								<input type="email" placeholder="Enter your email">
								<button>Subscribe</button>
							</form>
						</div>
					</div>
					<div class="col-md-6 col-lg-3">
						<h6>NEED HELP</h6>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed doLorem ipsum dolor sit amet, consectetur adipiscing elit,
							sed doLorem ipsum dolor sit amet,</p>
					</div>
					<div class="col-md-6 col-lg-3">
						<h6>CONTACT US</h6>
						<div class="info_link-box">
							<a href=""> <i class="fa fa-map-marker" aria-hidden="true"></i>
								<span> Gb road 123 london Uk </span>
							</a> <a href=""> <i class="fa fa-phone" aria-hidden="true"></i> <span>+01
									12345678901</span>
							</a> <a href=""> <i class="fa fa-envelope" aria-hidden="true"></i>
								<span> demo@gmail.com</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- footer section -->
		<footer class=" footer_section">
			<div class="container">
				<p>
					&copy; <span id="displayYear"></span> All Rights Reserved By <a
						href="https://html.design/">Free Html Templates</a>
				</p>
			</div>
		</footer>
		<!-- footer section -->

	</section>

	<!-- end info section -->


	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
		
	</script>
	<script src="js/custom.js"></script>

</body>

</html>