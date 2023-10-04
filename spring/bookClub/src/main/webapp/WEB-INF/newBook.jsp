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


<html>
<head>
<!-- To use bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Add a new book</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>Add a new book:</h1>
			</div>
			<div class="col">
				<a href="/books">Back to the shelves</a>
			</div>
		</div>
		<div class="form">
			<form:form action="/books/save" method="post" modelAttribute="book">
				<form:input type="hidden" path="user" value="${userId }"/>
				<div class="row mb-3">
					<form:label path="title" class="form-label" >Title</form:label>
					<form:errors path="title" class="form-text text-warning"></form:errors>
					<form:input path="title" type="text" class="form-control"></form:input>
				</div>
				<div class="row mb-3">
					<form:label path="author" class="form-label">Author</form:label>
					<form:errors path="author" class="form-text text-warning"></form:errors>
					<form:input path="author" type="text" class="form-control"></form:input>
				</div>
				<div class="row mb-3">
					<form:label path="description" class="form-label">Description</form:label>
					<form:errors path="description" class="form-text text-warning"></form:errors>
					<form:textarea path="description" type="text" class="form-control" />	
				</div>
				<div class="row">
					<button type="submit" class="btn btn-success">Submit</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>