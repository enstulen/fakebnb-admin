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
			<%@ include file="/components/Navbar.jsp"%>
			<div class="container">
				<div class="row">
					<h1 class="admin-title">Homes</h1>
					<table class="table table-hover table-custom">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Price</th>
							<th>Admin</th>
						</tr>
						<c:forEach items="${requestScope.homes}" var="home">
							<tr class='clickable-row'
								data-href='/fakebnbadmin/edit-new-home.html?id=${home.homeid}'>
								<td>${home.homeid}</td>
								<td>${home.name}</td>
								<td>${home.price}</td>
								<td>
									<form class="form-delete" method="POST">
										<input type="hidden" name="type" value="delete-home" /> <input
											type="hidden" name="homeid" value='${home.homeid}' />
										<button class="admin-delete-button" type="submit">X</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div class="col-md-2">
						<a href="/fakebnbadmin/edit-new-home.html"
							class="btn btn-primary btn-block"">Add new</a>
					</div>
				</div>
				<div class="row">
					<h1 class="admin-title">Bookings</h1>
					<table class="table table-hover table-custom">
						<tr>
							<th>ID</th>
							<th>Home</th>
							<th>Starting date</th>
							<th>Ending date</th>
							<th>Admin</th>

						</tr>
						<c:forEach items="${requestScope.bookings}" var="booking">
							<tr class='clickable-row'
								data-href='/fakebnbadmin/edit-new-booking.html?id=${booking.bookingid }'>
								<td>${booking.bookingid}</td>
								<td>${booking.home}</td>
								<td>${booking.date_start}</td>
								<td>${booking.date_end}</td>
								<td>
									<form class="form-delete" method="POST">
										<input type="hidden" name="type" value="delete-booking" /> <input
											type="hidden" name="bookingid" value='${booking.bookingid}' />
										<button class="admin-delete-button" type="submit">X</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div class="col-md-2">
						<a href="/fakebnbadmin/edit-new-booking.html"
							class="btn btn-primary btn-block"">Add new</a>
					</div>
				</div>
				<div class="row">
					<h1 class="admin-title">Users</h1>
					<table class="table table-hover table-custom">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Surname</th>
							<th>Email</th>
							<th>Admin</th>
						</tr>
						<c:forEach items="${requestScope.users}" var="user">
							<tr class='clickable-row'
								data-href='/fakebnbadmin/edit-new-user.html?id=${user.userid}'>
								<td>${user.userid}</td>
								<td>${user.name}</td>
								<td>${user.surname}</td>
								<td>${user.email}</td>
								<td>
									<form class="form-delete" method="POST">
										<input type="hidden" name="type" value="delete-user" /> <input
											type="hidden" name="userid" value='${user.userid}' />
										<button class="admin-delete-button" type="submit">X</button>
									</form>
								</td>

							</tr>
						</c:forEach>
					</table>
					<div class="col-md-2">
						<a href="/fakebnbadmin/edit-new-user.html"
							class="btn btn-primary btn-block"">Add new</a>
					</div>
				</div>
				<div class="row">
					<h1 class="admin-title">Messages</h1>
					<table class="table table-hover table-custom">
						<tr>
							<th>ID</th>
							<th>Text</th>
							<th>Sender</th>
							<th>Reciever</th>
							<th>Admin</th>
						</tr>
						<c:forEach items="${requestScope.messages}" var="message">
							<tr class='clickable-row'
								data-href='/fakebnbadmin/edit-new-message.html?id=${message.messageid}'>
								<td>${message.messageid}</td>
								<td>${message.text}</td>
								<td>${message.sender}</td>
								<td>${message.reciever}</td>
								<td>
									<form class="form-delete" method="POST">
										<input type="hidden" name="type" value="delete-message" /> <input
											type="hidden" name="messageid" value='${message.messageid}' />
										<button class="admin-delete-button" type="submit">X</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
					<div class="col-md-2">
						<a href="/fakebnbadmin/edit-new-message.html"
							class="btn btn-primary btn-block" id="bottomButton">Add new</a>
					</div>
				</div>
			</div>

			<%@ include file="/components/Footer.jsp"%>



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
	<script src="js/admin.js"></script>



	<script>
		
	</script>

</body>
</html>

