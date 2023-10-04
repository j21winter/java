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
<html lang="en">
<head>
    <!-- To use bootstrap -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- For any Bootstrap that uses JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Books Login Page</title>
</head>
<body>
    <div class="container">
        <h1 class="title my-5">Welcome to the Books Website!</h1>
        <div class="row">
            <div class="register col">
                <div class="card">
                    <div class="card-body">
                        <h2>Register</h2>
                        <form:form action="/register" method="post" modelAttribute="newUser">
                       		<div class="row mb-4">
                        		<form:label path="name" class="form-label">Name:</form:label>
                        		<form:errors path="name" class="form-text text-warning" />
                        		<form:input type="text" path="name" class="form-control" />
                       		</div>
                       		<div class="row mb-4">
                        		<form:label path="email" class="form-label">Email:</form:label>
                        		<form:errors path="email" class="form-text text-warning" />
                        		<form:input type="email" path="email"  class="form-control" />
                       		</div>
                       		<div class="row mb-4">
                        		<form:label path="password" class="form-label">Password:</form:label>
                        		<form:errors path="password" class="form-text text-warning" />
                        		<form:input type="password" path="password"  class="form-control" />
                       		</div>
                       		<div class="row mb-4">
                        		<form:label path="confirm" class="form-label">Confirm Password:</form:label>
                        		<form:errors path="confirm" class="form-text text-warning" />
                        		<form:input type="password" path="confirm"  class="form-control" />
                       		</div>
                       		<div class="row mb-4">
                       			<button class="btn btn-success" type="submit">Submit</button>
                   
                       		</div>
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="login col">
                <div class="card">
                    <div class="card-body">
                        <h2>Login</h2>
                        <form:form action="/login" method="post" modelAttribute="loginUser">
                        	<div class="row mb-4">
                        		<form:label path="email" class="form-label">Email:</form:label>
                        		<form:errors path="email" class="form-text text-warning " />
                        		<form:input path="email" type="text" class="form-control" />
                        	</div>
                        	
                        	<div class="row mb-4">
                        		<form:label path="password" class="form-label">Password:</form:label>
                        		<form:errors path="password" class="form-text text-warning " />
                        		<form:input path="password" type="password" class="form-control" />
                        	</div>
                        	
                        	<div class="row mb-4">
                        		<button class="btn btn-success" type="submit">Submit</button>
                        	</div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>