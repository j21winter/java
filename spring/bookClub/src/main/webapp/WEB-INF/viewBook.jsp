<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- To use bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>View Book</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>View Book</h1>
			</div>
			<div class="col row">
				<div class="col">
					<a href="/books">Back to the shelves</a>
				</div>
			</div>
		</div>
		
		<div class="content">
			<div class="header">
				<p>
				<span class="text-primary">${book.user.name }</span>
				read 
				<span class="text-warning">${book.title }</span>
				 by
				<span class="text-info">${book.author }</span>
				</p>
			</div>
			<h2>Here are ${book.user.name }'s thoughts: </h2>
			<hr />
			<div class="description">
				<p>${book.description }</p>
			</div>
			<hr />
			<c:if test="${userId == book.user.id }">
				<a href="/books/${book.id }/update" class="btn btn-info">Edit Book</a>
				<form action="/books/${book.id }/delete" method="post">
					<input type="hidden" name="_method" value="delete" />
					<button type="submit" class="btn btn-warning">Delete</button>	
				</form>	
			</c:if>
		</div>
	</div>
</body>
</html>