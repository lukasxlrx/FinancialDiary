<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Transactions</title>
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li style="margin-left: 175px;" class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/TransactionServlet/dashboard">
			Transactions<span class="sr-only">(current)</span></a></li>
			
			<li class="nav-item"><a class="nav-link"
				href="#">Profile</a></li>
		</ul>
	</div>
	
</nav>

<body>
	<div class="row">
		<div class="container">	
			<br>
			 <a
				href="<%=request.getContextPath()%>/CreateTransaction.jsp"
				class="btn btn-primary">Add New item</a>
				 <br>
				 <hr>
			<!-- Create a table to list out all current users information -->
			<table class="table table-striped table-bordered">
				<thead class="thead-dark">
					<tr>
						<th>Name</th>
						<th>Price</th>
						<th>Payment Method</th>
						<th>Actions</th>

					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet’s response to a loop -->

				<tbody>
					<c:forEach var="transaction" items="${listTransactions}">
						<!-- For each user in the database, display their information accordingly -->
						<tr>
							<td><c:out value="${transaction.name}" /></td>
							<td>$<c:out value="${transaction.price}" /></td>
							<td><c:out value="${transaction.payment}" /></td>
							<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<td>
								<div>
									<button class="btn btn-success">Edit</button>
									<button class="btn btn-danger">Delete</button>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>