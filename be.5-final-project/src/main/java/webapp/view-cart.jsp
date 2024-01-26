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
		<!-- header section starts -->
		<jsp:include page="header-section.jsp" />

		<!-- end header section -->

	</div>
	<!-- end hero area -->

	<!-- view cart section -->

	<h2>Your Cart</h2>

    <c:if test="${not empty cart}">
        <table border="1">
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price per Unit</th>
                    <th>Subtotal</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="entry" items="${cart}">
                    <tr>
                        <td>${entry.key.name}</td>
                        <td>${entry.value}</td>
                        <td>${entry.key.price}</td>
                        <td>${entry.key.subTotal}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p>Overall Total: $<c:out value="${total}" /></p>
        <p><a href="index.jsp">Continue Shopping</a></p>
    </c:if>

    <c:if test="${empty cart}">
        <p>Your cart is empty.</p>
        <p><a href="index.jsp">Go back to shopping</a></p>
    </c:if>

	<!-- end view cart section -->




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