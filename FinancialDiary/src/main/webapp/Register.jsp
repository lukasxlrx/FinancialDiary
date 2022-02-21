<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
body {
	background-image:
		url('https://euromed-economists.org/wp-content/uploads/2018/01/moneyfinance-1.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>

</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1"
		style="text-align: center; margin: auto;">

		<div class="card">
			<div class="card-body">
				
				<p style="text-align: left;">
					<a href="http://localhost:8090/FinancialDiary/Login.jsp">Back to Login</a>
				</p>

				<form action="RegisterServlet" method="post">

					<div class="form-outline mb-4">
						<input placeholder="Username" type="text" name="username"
							class="form-control form-control-lg">
					</div>

					<div class="form-outline mb-4">
						<input placeholder="Password" type="text" name="password"
							class="form-control form-control-lg">
					</div>

					<div class="form-outline mb-4">
						<input placeholder="Email" type="text" name="email"
							class="form-control form-control-lg">
					</div>

					<div class="form-outline mb-4">
						<input placeholder="First Name" type="text" name="firstname"
							class="form-control form-control-lg">
					</div>

					<div class="form-outline mb-4">
						<input placeholder="Last Name" type="text" name="lastname"
							class="form-control form-control-lg">
					</div>

					<button type="submit" class="btn btn-primary btn-lg" name="register">Register</button>
				</form>

			</div>
		</div>

	</div>


</body>
</html>