<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Financial Diary</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<br><br><br><br>
<section class="vh-100">
  <div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img src="https://www.teampay.co/wp-content/uploads/2019/02/strategic-finance.jpg" class="img-fluid"
          alt="Sample image">
          
          <h5 style="text-align: center;">Welcome to Your Financial Diary</h5>
      </div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
        <form action="LoginServlet/login" method="post">
          <!-- Username input -->
          <div class="form-outline mb-4">
            <input type="text" name="username" class="form-control form-control-lg"
              placeholder="Enter username" />
          </div>

          <!-- Password input -->
          <div class="form-outline mb-3">
            <input type="password" name="password" class="form-control form-control-lg"
              placeholder="Enter password" />
          </div>

          <div class="text-center text-lg-start mt-4 pt-2">
            <button type="submit" class="btn btn-primary btn-lg"
              style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
              
            <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? 
            <a href="http://localhost:8090/FinancialDiary/Register.jsp" class="link-danger">Register</a></p>
          </div>

        </form>
      </div>
    </div>
  </div>
	
</section>

</body>
</html>