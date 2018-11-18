<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<!-- Login Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h1 class="h3 mb-3 font-weight-normal">Sign in to continue</h1>
			</div>
			<div class="modal-body">
				<form class="form-signin" method="POST" action="index.html">
					<input type="email" name="email" id="loginEmail"
						class="form-control" placeholder="Email" required autofocus>
					<input name="password" type="password" id="loginPassword"
						class="form-control" placeholder="Password" required>
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="IniciaSesion">Sign in</button>
				</form>

			</div>

			<div class="modal-footer">
				<p class="text-center">
					No account?<a href="#" id="gotoRegisterFromLogin"> Register</a>
				</p>
			</div>

		</div>
	</div>
</div>

<!-- Registro Modal -->
<div class="modal fade" id="RegistroModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h1 class="h3 mb-3 font-weight-normal">Enter your details</h1>
			</div>
			<div class="modal-body">
				<form class="form-registro" method="POST" action="index.html">
					<input name="email" type="email" id="inputEmail"
						class="form-control" placeholder="Email" required autofocus>
					<input name="name" id="inputName" class="form-control"
						placeholder="Name" required> <input name="surname"
						id="inputSurname" class="form-control" placeholder="Surname"
						required> <input name="password" type="password"
						id="inputPassword" class="form-control"
						placeholder="Set a password" required>
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="Registrate">Register</button>
				</form>

			</div>

			<div class="modal-footer">
				<p class="text-center">
					You already have an account?<a href="#" id="goRegistroLogin">
						Sign in</a>
				</p>
			</div>

		</div>
	</div>
</div>

<!-- Logout Modal -->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h1 class="h3 mb-3 font-weight-normal">Are you sure you want to
					logout?</h1>
			</div>
			<div class="modal-body">
				<form class="form-signin" method="POST" action="index.html">
					<input type="hidden" name="type" value="logout" />
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="IniciaSesion">Yes</button>
				</form>
				<button class="btn btn-lg btn-primary btn-block" type="button"
					data-dismiss="modal">Cancel</button>
			</div>

		</div>
	</div>
</div>

<div class="modal fade" id="MessageModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h1 class="h3 mb-3 font-weight-normal">Send a message to
					another Fakebnb User</h1>
			</div>
			<div class="modal-body">
				<form class="form-message" method="POST" action="sendMessage.html">
					<input name="type" type="hidden" value='message' /> <input
						type="name" id="receivername" class="form-control"
						placeholder="Receiver" name="receiver" required> <input
						type="text" id="messagecontent" class="form-control"
						placeholder="Write Message Here" name="message" required>

					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="Send">Send Message</button>
				</form>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="MessageModalWithoutReciever" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h1 class="h3 mb-3 font-weight-normal">Send a message to the
					host.</h1>
			</div>
			<div class="modal-body">
				<form class="form-message" method="POST" action="sendMessage.html">
					<input name="homeid" type="hidden" value='${param.homeid}' /> <input
						name="hostid" type="hidden" value='${param.hostid}' /> <input
						name="type" type="hidden" value='messageWithoutReciever' /> <input
						type="text" id="messagecontent" class="form-control"
						placeholder="Write Message Here" name="message" required>
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="Send">Send Message</button>
				</form>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="bookModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h1 class="h3 mb-3 font-weight-normal">Write your payment
					details to request booking.</h1>
			</div>
			<div class="modal-body">
				<form class="form-message" method="POST" action="sendMessage.html">

					<div class="col-xxs-12 col-xs-12 mt alternate">
						<label for="card-number">Card number:</label> <input name="type"
							type="hidden" value='booking' /> <input name="homeid"
							type="hidden" value='${param.homeid}' /> <input name="hostid"
							type="hidden" value='${param.hostid}' /> <input
							name="card_number" type="text" id="cardNumber"
							class="form-control" placeholder="Card number" required>
					</div>
					<div class="col-xxs-12 col-xs-4 mt alternate">
						<label>Expiration month:</label> <input type="number"
							name="month_expire" id="monthExpire" class="form-control"
							placeholder="Expiration month" required>
					</div>
					<div class="col-xxs-12 col-xs-4 mt alternate">
						<label>Expiration year:</label> <input name="year_expire"
							type="number" id="yearExpire" class="form-control"
							placeholder="Expiration year" required>
					</div>
					<div class="col-xxs-12 col-xs-4 mt alternate">
						<label>CV2:</label> <input name="CV2" type="number" id="CV2"
							class="form-control" placeholder="CV2 code" required>
					</div>
					<div class="col-xxs-12 col-xs-6 mt alternate">
						<div class="input-field">
							<label for="date-end">Start of stay:</label> <input required
								type="text" class="form-control" id="date-end" name="date-start"
								placeholder="mm/dd/yyyy" />
						</div>
					</div>
					<div class="col-xxs-12 col-xs-6 mt alternate">
						<div class="input-field">
							<label for="date-end">End of stay:</label> <input required
								type="text" class="form-control" id="date-end" name="date-end"
								placeholder="mm/dd/yyyy" />
						</div>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Request
						booking</button>
				</form>
			</div>
		</div>
	</div>
</div>

</html>