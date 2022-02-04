<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Transaction Management </a>
		</div>
		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/TransactionServlet/dashboard" class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${transaction != null}">
					<form action="update" method="put">
				</c:if>
				<input type="hidden" name="TransactionID" value='${transaction.transactionID}' />
				<input type="hidden" name="UserID"  value='${transaction.userID}' /> 
				<fieldset class="form-group">
					<label>Name</label> 
					<input type="text"  value='${transaction.name}'  class="form-control" name="name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>price</label> 
					<input type="number" value='${transaction.price}' class="form-control" name="price">
				</fieldset>
				<fieldset class="form-group">
					<label>Payment</label> 
					<input type="text" value='${transaction.payment}' class="form-control" name="payment">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>