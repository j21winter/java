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
<meta charset="UTF-8">
<!-- To use bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>New Category</title>
</head>
<body>
	<div class="container">
		<h1 class="display-1">Add A New Category</h1>
		<form:form action="/category/new" method="post" modelAttribute="category">
			<div class="row mb-4">
				<form:label  path="name" class="form-label">Name</form:label>
				<form:input type="text" path="name" class="form-controller" />
				<form:errors path="name" class="form-text text-warning" />
			</div>
			<div class="row mb-4">
				<button class="btn btn-info" type="submit">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>