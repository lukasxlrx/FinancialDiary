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
<style>
svg {
	width: *some value*
}

div {
	text-align: center
}

.hero-image {
	background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
		url("https://wallpaperaccess.com/full/96488.jpg");
	height: 50%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	position: relative;
}

.hero-text {
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: white;
}

.hero-text button {
	border: none;
	outline: 0;
	display: inline-block;
	padding: 10px 25px;
	color: black;
	background-color: #ddd;
	text-align: center;
	cursor: pointer;
}

.hero-text button:hover {
	background-color: #555;
	color: white;
}

body, html {
	height: 100%;
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

#myTable {
	border-collapse: collapse;
	width: 100%;
	border: 1px solid #ddd;
	font-size: 18px;
}

#myTable th, #myTable td {
	text-align: left;
	padding: 12px;
}

#myTable tr {
	border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
	background-color: #f1f1f1;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="hero-image">
		<div class="hero-text">
			<h1 style="font-size: 50px">Profile Page</h1>
			<p>Welcome, ${username}</p>
			<br>
			<div>
				<svg xmlns="http://www.w3.org/2000/svg" width="200" height="200"
					fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
  <path fill-rule="evenodd"
						d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
</svg>
			</div>
		</div>
	</div>
	<br>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">Account Information</h3>
			<hr>
			<a href="<%=request.getContextPath()%>/TransactionServlet/dashboard" class="nav-link">Back to Dashboard</a>
			<!-- Create a table to list out all current users information -->
			<table class="table" id="myTable">
				<thead>
					<tr>
						<th>User ID</th>
						<th>Username</th>
						<th>Password</th>
						<th>Email</th>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!--  Pass in the list of users receive via the Servlet's response to a loop -->
				<tbody>
					<c:forEach var="user" items="${listUsers}">
						<!-- For each user in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${user.userID}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.password}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.firstname}" /></td>
							<td><c:out value="${user.lastname}" /></td>
							<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a
								href="edit?username=<c:out value='${user.username}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?username=<c:out
value='${user.username}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script>
		function filterTable() {

			var input, table, tr, td, i, txtValue;
			input =
	<%=session.getAttribute("userID")%>
		;

			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");

			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[0];
				if (td) {
					txtValue = td.textContent || td.innerText;

					if (txtValue.trim().indexOf(input) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
		window.onload = filterTable;
	</script>

</body>
</html>