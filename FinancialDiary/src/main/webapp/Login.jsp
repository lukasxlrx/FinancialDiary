<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--  <h1>testing the login page</h1> -->

<div class="col-md-2" style="text-align: center; margin: auto;">

        <form action="LoginServlet/login" method="post">
            <!-- Username -->
            <input placeholder="Username" type="text" name="username" style="margin-bottom: 10px; height: 40px; width: 200px;">
            <!-- Password --> 
            <input placeholder="Password" type="text" name="password" style="margin-bottom: 10px; height: 40px; width: 200px;">


            <button type="submit" class="btn btn-primary" value="Login">Login</button>
        </form>
        <p>	
        <a href="<%=request.getContextPath()%>/Register.jsp"> Don't 
        have an account? Register here!</a>
		</p>

    </div>
</body>
</html>