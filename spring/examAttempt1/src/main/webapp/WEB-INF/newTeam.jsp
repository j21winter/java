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
<title>New Team</title>
</head>
<body>
	<div class="container">
		<h1 class="display-3 my-4 text-center">Add A New Team</h1>
		<div class="card col-6 mx-auto">
			<div class="card-body">
				<form:form action="/teams/new" method="post" modelAttribute="team">
					<div class="mb-4">
						<form:label  path="name" class="form-label">Team Name:</form:label>
						<form:input type="text" path="name" class="form-control" />
						<form:errors path="name" class="form-text text-warning" />
					</div>
					<div class="mb-4">
						<form:label  path="skillLevel" class="form-label">Skill Level: (Beginner 1 - 5 Expert)</form:label>
						<form:select path="skillLevel" class="form-control" >
							<option value="0" >- - Select - -</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</form:select>
						<form:errors path="skillLevel" class="form-text text-warning" />
					</div>
<!-- 					Could Change these days to integers if I have time  -->
					<div class="mb-4">
						<form:label  path="gameDay" class="form-label">Game Day:</form:label>
						<form:select path="gameDay" class="form-control" >
							<option value=" " >- - Select - -</option>
							<option value="monday">Monday </option>
							<option value="tuesday">Tuesday</option>
							<option value="wednesday">Wednesday</option>
							<option value="thursday">Thursday</option>
							<option value="friday">Friday</option>
							<option value="saturday">Saturday</option>
							<option value="sunday">Sunday</option>
						</form:select>
						<form:errors path="gameDay" class="form-text text-warning" />
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