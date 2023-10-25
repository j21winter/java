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
<title>Edit Project</title>
</head>
<body>
	<div class="container">
		<h1 class="display-3 my-4 text-center">Edit Project</h1>
		<div class="card col-6 mx-auto">
			<div class="card-body">
				<form:form action="/projects/${project.id }" method="post" modelAttribute="project">
					<input type="hidden" name="_method" value="put" />
					<div class="mb-4">
						<form:label  path="title" class="form-label">Title:</form:label>
						<form:errors path="title" class="form-text text-warning" />
						<form:input type="text" path="title" class="form-control"></form:input>
					</div>
					<div class="mb-4">
						<form:label  path="description" class="form-label">Description</form:label>
						<form:errors path="description" class="form-text text-warning" />
						<form:textarea type="text" path="description" class="form-control"></form:textarea>
					</div>
					<div class="mb-4">
						<form:label  path="dueDate" class="form-label">Due Date:</form:label>
						<form:errors path="dueDate" class="form-text text-warning" />
						<form:input type="date" path="dueDate" class="form-control"></form:input>
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