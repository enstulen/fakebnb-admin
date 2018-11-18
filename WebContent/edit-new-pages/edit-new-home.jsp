<%@page contentType="text/html" import="entities.Home"
	import="java.util.*"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>TIWbnb</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
<meta name="author" content="FREEHTML5.CO" />

<!-- 
	//////////////////////////////////////////////////////

	FREE HTML5 TEMPLATE 
	DESIGNED & DEVELOPED by FREEHTML5.CO
		
	Website: 		http://freehtml5.co/
	Email: 			info@freehtml5.co
	Twitter: 		http://twitter.com/fh5co
	Facebook: 		https://www.facebook.com/fh5co

	//////////////////////////////////////////////////////
	 -->

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
	rel='stylesheet' type='text/css'>

<!-- Animate.css -->
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- Superfish -->
<link rel="stylesheet" href="css/superfish.css">
<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- Date Picker -->
<link rel="stylesheet" href="css/bootstrap-datepicker.min.css">
<!-- CS Select -->
<link rel="stylesheet" href="css/cs-select.css">
<link rel="stylesheet" href="css/cs-skin-border.css">

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/admin.css">



<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	<div id="fh5co-wrapper">
		<div id="fh5co-page">
			<%@ include file="../components/Navbar.jsp"%>
			<!-- end:header-top -->
			<div>
				<h1>Home</h1>
				<p>
					<c:out value="${ requestScope.home.name }" />
				</p>
				<form METHOD="POST">
					<div class="input-field">
						<label for="from">Name</label> <input type="text"
							class="form-control" id="from-place" name="name"
							value="${requestScope.home.name}" />
					</div>
					<div class="input-field">
						<label for="from">Full description</label>
						<textarea rows="5" name="full_description" class="form-control">${requestScope.home.full_description}</textarea>
					</div>
					<div class="input-field">
						<label for="from">Short description</label> <input
							name="short_description" class="form-control"
							value="${requestScope.home.short_description}" />
					</div>
					<div class="input-field-select">
						<label for="class">Type of apartment</label> <select
							class="cs-select cs-skin-border" name="type">
							<option value="" disabled selected>Entire accommodation</option>
							<option value="entire">Entire accommodation</option>
							<option value="private">Private room</option>
							<option value="shared">Shared room</option>
						</select>
					</div>

					<div class="input-field">
						<label for="number_of_guests">Number of guests</label> <input
							name="number_of_guests" class="form-control"
							value="${requestScope.home.number_of_guests}" />
					</div>

					<div class="input-field">
						<label for="price">Price</label> <input name="price"
							class="form-control" value="${requestScope.home.price}" />
					</div>
					<div class="input-field">
						<label for="date-start">Start of stay:</label> <input type="text"
							class="form-control" id="date-start" name="date-start"
							placeholder="mm/dd/yyyy"
							value="${requestScope.home.date_available_start}" />
					</div>
					<div class="input-field">
						<label for="date-end">End of stay:</label> <input type="text"
							class="form-control" id="date-end" name="date-end"
							placeholder="mm/dd/yyyy"
							value="${requestScope.home.date_available_end}" />
					</div>

					<c:if test="${requestScope.admin == true}">
					<div class="input-field">
						<label for="user_userid">User ID</label> <input name="user_userid"
							class="form-control" value="${requestScope.home.user.userid}" />
					</div>
					</c:if>


					<div class="input-field">
						<input class="btn btn-primary btn-block" type="submit" value="Submit" />
					</div>
				</form>

			</div>

			<%@ include file="/components/Footer.jsp" %>


		</div>
		<!-- END fh5co-page -->

	</div>
	<%@ include file="/components/Modal.jsp"%>

	<!-- END fh5co-wrapper -->


	<!-- jQuery -->

	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/sticky.js"></script>

	<!-- Stellar -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Date Picker -->
	<script src="js/bootstrap-datepicker.min.js"></script>
	<!-- CS Select -->
	<script src="js/classie.js"></script>
	<script src="js/selectFx.js"></script>

	<!-- Main JS -->
	<script src="js/main.js"></script>


	<script>
		
	</script>

</body>
</html>

