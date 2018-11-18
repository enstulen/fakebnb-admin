<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<header id="fh5co-header-section" class="sticky-banner">
	<div class="container">
		<div class="nav-header">
			<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle dark"><i></i></a>
			<h1 id="fh5co-logo">
				<a href="index.html"><i class="icon-airplane"></i>FakeBnB</a>
			</h1>
			<!-- START #fh5co-menu-wrap -->
			<nav id="fh5co-menu-wrap" role="navigation">
				<ul class="sf-menu" id="fh5co-primary-menu">
					<li><a href="admin.html" id="admin">Admin</a></li>
				</ul>
			</nav>
		</div>
	</div>
</header>
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
  $(document).on("click", "#Login", function () {
    $("#loginModal").modal("show");
  });
  $(document).on("click", "#Registro", function () {
    $("#RegistroModal").modal("show");
  });
  $(document).on("click", "#Logout", function () {
    $("#logoutModal").modal("show");
  });

  $(document).on("click", "#goRegistroLogin", function () {
    $("#RegistroModal").modal("hide");
    $("#loginModal").modal("show");
  });
  $(document).on("click", "#gotoRegisterFromLogin", function () {
    $("#loginModal").modal("hide");
    $("#RegistroModal").modal("show");
  });
</script>

</html>