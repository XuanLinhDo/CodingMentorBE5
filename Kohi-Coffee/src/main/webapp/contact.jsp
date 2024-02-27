<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">

<title>Kohi</title>

<!-- CSS FILES -->
<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@100;300;400;700;900&display=swap"
	rel="stylesheet">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-icons.css" rel="stylesheet">

<link rel="stylesheet" href="css/slick.css" />

<link href="css/tooplate-little-fashion.css" rel="stylesheet">

<!--

Kohi

https://www.tooplate.com/view/2127-little-fashion

-->
</head>

<body>

	<main>
		<jsp:include page="header-section.jsp" />

		<header class="site-header section-padding-img site-header-image">
			<div class="container">
				<div class="row">

					<div class="col-lg-10 col-12 header-info">
						<h1>
							<span class="d-block text-dark">24/7 LET'S TALK</span> <span
								class="d-block text-dark">COFFEE</span>
						</h1>
					</div>
				</div>
			</div>

			<img src="images/header/talk-about-coffee.jpg"
				class="header-image img-fluid" alt="coffee">
		</header>

		<section class="contact section-padding">
			<div class="container">
				<div class="row">

					<div class="col-lg-6 col-12">
						<h2 class="mb-4">What's your enquiry?</h2>

						<form class="contact-form me-lg-5 pe-lg-3" role="form">

							<div class="form-floating">
								<input type="text" name="name" id="name" class="form-control"
									placeholder="Full name" required> <label for="name">Full
									name</label>
							</div>

							<div class="form-floating my-4">
								<input type="email" name="email" id="email"
									pattern="[^ @]*@[^ @]*" class="form-control"
									placeholder="Email address" required> <label
									for="email">Email address</label>
							</div>

							<div class="form-floating my-4">
								<input type="subject" name="subject" id="subject"
									class="form-control" placeholder="Subject" required> <label
									for="subject">Phone Number</label>
							</div>

							<div class="form-floating mb-4">
								<textarea id="message" name="message" class="form-control"
									placeholder="Leave a comment here" required
									style="height: 160px"></textarea>

								<label for="message">Tell us about your enquiry here</label>
							</div>

							<div class="col-lg-5 col-6">
								<button type="submit" class="form-control">SUBMIT</button>
							</div>
						</form>
					</div>

					<div class="col-lg-6 col-12 mt-5 ms-auto">
						<div class="row">
							<div class="col-6 border-end contact-info">
								<h6 class="mb-3">Talk To a Human</h6>

								<p class="text-muted">+61 414 747 358</p>
							</div>

							<div class="col-6 contact-info">
								<h6 class="mb-3">Email To Us</h6>

								<a href="mailto:kohi@gmail.com" class="custom-link">
									kohi@gmail.com <i class="bi-arrow-right ms-2"></i>
								</a>
							</div>

							<div class="col-6 border-top border-end contact-info">
								<h6 class="mb-3">Visit Us In Store</h6>

								<p class="text-muted">123 Bourke Street, Surry Hills, NSW
									2010</p>
							</div>

							<div class="col-6 border-top contact-info">
								<h6 class="mb-3">Follow Us</h6>

								<ul class="social-icon">

									<li><a href="#" class="social-icon-link bi-instagram"></a></li>

								</ul>
							</div>
						</div>
					</div>

				</div>
			</div>
		</section>
	</main>

	<jsp:include page="footer-section.jsp" />
	<!-- JAVASCRIPT FILES -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/Headroom.js"></script>
	<script src="js/jQuery.headroom.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/custom.js"></script>
</body>
</html>