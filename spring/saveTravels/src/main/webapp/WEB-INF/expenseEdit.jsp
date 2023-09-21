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
<title>Edit <c:out value="${expense.expenseName }"/></title>
</head>
<body>
	<div class="container">
		
		<div class="title d-flex justify-content-between align-items-center">
			<h1>Edit <c:out value="${expense.expenseName }"/></h1>
			<a href="/expense" class="btn btn-info">My Dashboard</a>
		</div>
		
		<div class="edit-expense">
			<form:form class="form" action="/expense/${expense.id }" method="post" modelAttribute="expense">
				
				<input type="hidden" name="_method" value="put">
				
				<div class="row mb-3">
					<form:label path="expenseName">Expense Name:</form:label>
					<form:input path="expenseName"></form:input>
					<form:errors path="expenseName"></form:errors>
				</div>
				
				<div class="row mb-3">
					<form:label path="vendorName">Vendor Name:</form:label>
					<form:input path="vendorName"></form:input>
					<form:errors path="vendorName"></form:errors>
				</div>
				
				<div class="row mb-3">
					<form:label path="amount">Amount:</form:label>
					<form:input path="amount" type="number"></form:input>
					<form:errors path="amount"></form:errors>
				</div>
				
				<div class="row mb-3">
					<form:label path="description">Description:</form:label>
					<form:input path="description"></form:input>
					<form:errors path="description"></form:errors>
				</div>
				
				<div class="row mb-3">
					<button class="btn btn-info" type="submit">Submit</button>
				</div>
				
			</form:form>
		</div>
	</div>
</body>
</html>