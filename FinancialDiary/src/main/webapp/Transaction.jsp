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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#">My Financial Diary</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/Transaction.jsp">My Transaction</a></li>
		</ul>
	</div>
</nav>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">My Transaction</h3>
			<hr>
			<a href="<%=request.getContextPath()%>/CreateTransaction.jsp" class="btn btnsuccess">Add New item</a>
			<!-- Create a table to list out all current users information -->
			<table class="table table-striped table-bordered">
				<thead class="thead-dark">
					<tr>
						<th>Name</th>
						<th>Price</th>
						<th>Card/Cash</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
			</table>
		</div>
	</div>
</body>
</html>