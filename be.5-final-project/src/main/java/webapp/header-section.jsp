<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Basic -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- Site Metas -->
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">

<title>Giftos</title>

<!-- slider stylesheet -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

<!-- bootstrap core css -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet" />
<!-- responsive style -->
<link href="css/responsive.css" rel="stylesheet" />
</head>

<body>
	<div class="hero_area">
		<!-- header section strats -->
		<header class="header_section">
			<nav class="navbar navbar-expand-lg custom_nav-container ">
				<a class="navbar-brand" href="index.html"> <span> Giftos
				</span>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class=""></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav  ">
						<li class="nav-item active"><a class="nav-link"
							href="HomeController">Home <span class="sr-only">(current)</span></a>
						</li>
						<c:forEach items="${categories}" var="category">
							<li class="nav-item"><a class="nav-link"
								href="HomeController?action=SHOW_PRODUCT_BY_CATEGORY&categoryId=${category.id}">
									${category.name}</a></li>
						</c:forEach>
						<li class="nav-item"><a class="nav-link" href="contact.html">Contact
								Us</a></li>
					</ul>
					<div class="user_option">
						<c:if test="${empty sessionScope.user }">
							<a href="login.jsp"> <i
								class="fa fa-user" aria-hidden="true"></i> <span> Login </span></a>
						</c:if>
						<c:if test="${not empty sessionScope.user }">
							<a href="AuthenticationController?action=LOGOUT">  Hello
								${sessionScope.user.userName} <span> Logout </span></a>
						</c:if>
						<a href=""> <i class="fa fa-shopping-bag" aria-hidden="true"></i> ${sesstionScope.cart.size()}
						</a>

						<div class="col-md-6 col-lg-5 px-0">
							<form class="form-inline" action="HomeController?action=SEARCH">
								<div class="input">
									<input type="text" class="form-control" placeholder="Search"
										name="searchValue" />
									<div class="input-group-append">
										<button class="btn nav_search-btn" type="submit">
											<i class="fa fa-search" aria-hidden="true"></i>
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</nav>
		</header>
		<!-- end header section -->
<body>

</body>
</html>