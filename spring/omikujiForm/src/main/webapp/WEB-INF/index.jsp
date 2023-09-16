<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Form</title>
</head>
<body>
	<h1>Omikuji Form</h1>
	<div class="container">
		<form action="/submitForm" class="form" method="POST">
			
			<div class="form-group">
				<label for="number" class="label">Pick any number from 5-25</label>
				<input type="number" name="number" min="5" max="25" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="city" class="label">Enter the name of any city:</label>
				<input type="text" name="city" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="personName" class="label">Enter the name of any real person:</label>
				<input type="text" name="personName" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="hobby" class="label">Enter professional endeavor or hobby:</label>
				<input type="text" name="hobby" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="livingThing" class="label">Enter any type of living thing:</label>
				<input type="text" name="livingThing" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="somethingNice" class="label">Write something nice to someone:</label>
				<textarea name="somethingNice" cols="30" rows="10" class="form-control"></textarea>
				<p>^^Send and show a friend^^</p>
			</div>
			
			<button type="submit" class="btn btn-info">Submit</button>
			
			
		</form>
	</div>
	
</body>
</html>