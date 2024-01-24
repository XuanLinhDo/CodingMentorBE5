<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<jsp:include page="header-section.jsp" />

		<!-- end header section -->

	</div>
	<!-- end hero area -->

	<!-- shop section -->

	<section class="shop_section layout_padding">
		<div class="container">
			<div class="heading_container heading_center">
				<h2>Products</h2>
			</div>
			<div class="row">
				<c:forEach items="${productId}" var="products">
					<div class="col-sm-6 col-md-4 col-lg-3">
						<div class="box">
							<a href="ProductControllerproductId=${products.id}">
								<div class="img-box">
									<img src="images/${products.imgName}" alt="">
								</div>
								<div class="detail-box">
									<h6>${products.name}</h6>
									<h6>
										Price <span>$${products.price}</span>
									</h6>
								</div> <c:if test="${products.isNew == true}">
									<div class="new">
										<span> New </span>
									</div>
								</c:if>
							</a>
						</div>
					</div>

					<div class="col-sm-6 col-md-4 col-lg-9">
						<div class="box">
							Quantity: ${products.quantity} <br> Description:
							${products.description}
						</div>
						<form action="CartController">
							<input type="text" value="Add To Cart" name="ACTION" hidden="true">
							<input type="text" value="${products.id}" name="productId" hidden="true">
							<input type="submit" value="Add To Cart">
						</form>
					</div>
				</c:forEach>
			</div>

		</div>

	</section>

	<!-- end shop section -->




	<!-- info section -->

	<jsp:include page="footer-section.jsp" />

	<!-- end info section -->


	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
		
	</script>
	<script src="js/custom.js"></script>

</body>

</html>