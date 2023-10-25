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
<script type="text/javascript" src="/js/app.js"></script>
<!-- To use bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="text-center">
			<h1 class="display-2 mt-1" >Welcome</h1>
			<h2 class="display-4">Join our growing community</h2>
		</div>
		<div class="row">
			<div class="col">
				<div class="card shadow">
					<h3 class="card-header display-6">Register</h3>
					<div class="register card-body shadow ">
						<form:form action="/user/register" method="post" modelAttribute="newUser" class="form">
							<div class="mb-3">
								<form:label path="firstName" class="form-label">First Name:</form:label>
								<form:input type="text" path="firstName" class="form-control"/>
								<form:errors path="firstName" class="form-text text-warning"></form:errors>
							</div>
							<div class="mb-3">
								<form:label path="lastName" class="form-label">Last Name:</form:label>
								<form:input type="text" path="lastName" class="form-control"/>
								<form:errors path="lastName" class="form-text text-warning"></form:errors>
							</div>
							<div class="mb-3">
								<form:label path="email" class="form-label">Email:</form:label>
								<form:input type="email" path="email" class="form-control" />
								<form:errors path="email" class="form-text text-warning"></form:errors>
							</div>
							<div class="mb-3">
								<form:label path="password" class="form-label">Password:</form:label>
								<form:input type="password" path="password" class="form-control" />
								<form:errors path="password" class="form-text text-warning"></form:errors>
							</div>
							<div class="mb-3">
								<form:label path="confirm" class="form-label">Confirm Password:</form:label>
								<form:input type="password" path="confirm" class="form-control"/>
								<form:errors path="confirm" class="form-text text-warning" ></form:errors>
							</div>
							<div class="mb-3 text-end">
								<button class="btn btn-success" type="submit">Register</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card shadow">
					<h3 class="card-header display-6">Login</h3>
					<div class="login card-body shadow ">
						<form:form action="/user/login" method="post" modelAttribute="loginUser" class="form">
							
							<div class="mb-3">
								<form:label path="email" class="form-label">Email:</form:label>
								<form:errors path="email" class="form-text text-warning" />
								<form:input type="email" path="email" class="form-control" />
							</div>
							
							<div class="mb-3">
								<form:label path="password" class="form-label">Password:</form:label>
								<form:errors path="password"  class="form-text text-warning" />
								<form:input type="password" path="password" class="form-control" />
							</div>
							
							<div class="mb-3 text-end">
								<button class="btn btn-success" type="submit">Login</button>
							</div>
							
						</form:form>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>