<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!-- To use JSTL Tags -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- To use Data binding and Model Attribute in our forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- To use Error messages in our forms -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<!-- To connect CSS file (create folder in src>main>resources>static> “css”) -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- To connect JS file (create folder in src>main>resources>static> “js”) -->
<script type="text/javascript" src="/js/app.js"></script>
<!-- To use bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>Authentication</title>
</head>
<body>
	<div class="container">
		<h1>Welcome</h1>
		<h2>Join our growing community</h2>
		
		<div class="d-flex justify-content-evenly">
			
			<div class="register">
				<h3>Register</h3>
				<form:form action="/user/register" method="post" modelAttribute="newUser" class="form">
					<div class="row mb-3">
						<form:label path="userName">User Name:</form:label>
						<form:input type="text" path="userName"/>
						<form:errors path="userName"></form:errors>
					</div>
					<div class="row mb-3">
						<form:label path="email">Email:</form:label>
						<form:input type="email" path="email"/>
						<form:errors path="email"></form:errors>
					</div>
					<div class="row mb-3">
						<form:label path="password">Password:</form:label>
						<form:input type="password" path="password"/>
						<form:errors path="password"></form:errors>
					</div>
					<div class="row mb-3">
						<form:label path="confirm">Confirm Password:</form:label>
						<form:input type="password" path="confirm"/>
						<form:errors path="confirm"></form:errors>
					</div>
					<div class="row mb-3">
						<button class="btn btn-success" type="submit">Register</button>
					</div>
					
				</form:form>
			</div>
			
		
			<div class="login">
				<h3>login</h3>
				<form:form action="/user/login" method="post" modelAttribute="newLogin" class="form">
					
					<div class="row mb-3">
						<form:label path="email">Email:</form:label>
						<form:input type="email" path="email"/>
						<form:errors path="email"></form:errors>
					</div>
					<div class="row mb-3">
						<form:label path="password">Password:</form:label>
						<form:input type="password" path="password"/>
						<form:errors path="password"></form:errors>
					</div>
					
					<div class="row mb-3">
						<button class="btn btn-success" type="submit">Login</button>
					</div>
					
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>