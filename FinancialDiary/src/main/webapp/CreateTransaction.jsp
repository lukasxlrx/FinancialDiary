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
<title>Insert title here</title>
</head>
<body style="text-align: center;">

<br>
	<form style="display: inline-block; size: 50px;" action="TransactionServlet/dashboard" method="post">

		<div class="form-group">
			<label for="Name">Name of the item</label> <input type="text"
				class="form-control" id="exampleInputname"
				aria-describedby="nameHelp" placeholder="Enter name of the item"
				size="60" name="name">
		</div>
		<div class="form-group">
			<label for="Price">Price</label> 
			<input type="text" class="form-control" id="exampleInputPrice"
				aria-describedby="PriceHelp" placeholder="Enter the price" name="price">
		</div>
		<div class="form-group">
			<label for="PaymentMethod">Payment Method</label> <input type="text"
				class="form-control" id="exampleInputPaymentMethod"
				aria-describedby="PaymentHelp"
				placeholder="Enter the Payment Method" name="payment">
		</div>

		<button type="submit" class="btn btn-primary" 
		>Add to list</button>

</body>
</html>