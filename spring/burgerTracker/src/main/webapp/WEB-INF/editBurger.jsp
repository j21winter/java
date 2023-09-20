<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- To use bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Edit Burger</title>
</head>
<body>
	<div class="container">
		<div class="form">
			<h2>Edit Burger:</h2>
			<form:form action="/burger/${burger.id }" method="post" modelAttribute="burger" class="form mb-3">
				<input type="hidden" name="_method" value="put">
		
				<div class="row mb-3">
					<form:label path="burgerName">Burger Name:</form:label>
					<form:input path="burgerName"/>
					<form:errors path="burgerName" />
				</div>
				<div class="row mb-3">
					<form:label path="restaurantName">Restaurant Name:</form:label>
					<form:input path="restaurantName"/>
					<form:errors path="restaurantName" />
				</div>
				<div class="row mb-3">
					<form:label path="rating">Rating (out of 5)</form:label>
					<form:input type="number" path="rating"/>
					<form:errors path="rating" />
				</div>
				<div class="row mb-3">
					<form:label path="notes">Notes:</form:label>
					<form:textarea path="notes"/>
					<form:errors path="notes" />
				</div>
				<div class="row mb-3">
					<button class="btn btn-info" type="submit">Submit</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>