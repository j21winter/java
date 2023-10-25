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
<title>New Song</title>
</head>
<body>
	<div class="container">
		<h1 class="display-3 my-4 text-center">Add A New Song</h1>
		<div class="card col-6 mx-auto">
			<div class="card-body">
				<form:form action="/songs/new" method="post" modelAttribute="song">
					<div class="mb-4">
						<form:label  path="title" class="form-label">Title:</form:label>
						<form:input type="text" path="title" class="form-control" />
						<form:errors path="title" class="form-text text-warning" />
					</div>
					
					<div class="mb-4">
						<form:label  path="genre" class="form-label">Genre:</form:label>
						<form:input type="text" path="genre" class="form-control" />
						<form:errors path="genre" class="form-text text-warning" />
					</div>
					
					<div class="mb-4">
						<form:label  path="lyrics" class="form-label">Lyrics:</form:label>
						<form:textarea path="lyrics" class="form-control" />
						<form:errors path="lyrics" class="form-text text-warning" />
					</div>
					
					<div class="mb-4 text-end">
						<button class="btn btn-info" type="submit">Submit</button>
					</div>
				</form:form>
			</div>	
		</div>	
		<div class="d-flex justify-content-center my-5">
			<a href="/home" class="btn btn-secondary mx-auto">Home</a>
		</div>
	</div>
</body>
</html>