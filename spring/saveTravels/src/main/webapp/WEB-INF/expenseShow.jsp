<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- To use JSTL Tags -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- To use Data binding and Model Attribute in our forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>Show <c:out value="${expense.expenseName }"/></title>
</head>
<body>
	<div class="container">
		<div class="title">
			<h1>Your Expense</h1>
		</div>
		<div class="options d-flex">
			<a href="/expense" class="btn btn-info">My Dashboard</a>
			<a href="/expense/${expense.id }/edit" class="btn btn-warning">Edit</a>
			<form action="/expense/${expense.id }" method="post">
				<input type="hidden" name="_method" value="delete" />
				<button class="btn btn-danger">Delete</button>
			</form>
		</div>
		
		<div class="display">
			<table class="table">
				<tr>
					<th>Expense:</th>
					<td> <c:out value="${expense.expenseName }"/></td>
				</tr>
				<tr>
					<th>Vendor:</th>
					<td> <c:out value="${expense.vendorName }"/></td>
				</tr>
				<tr>
					<th>Amount:</th>
					<td> <c:out value="${expense.amount }"/></td>
				</tr>
				<tr>
					<th>Description:</th>
					<td> <c:out value="${expense.description }"/></td>
				</tr>
				<tr>
					<th>Date Added:</th>
					<td> <c:out value="${expense.createdAt }"/></td>
				</tr>
				<tr>
					<th>Last Updated:</th>
					<td> <c:out value="${expense.updatedAt }"/></td>
				</tr>
				
			</table>
		</div>
	</div>
</body>
</html>