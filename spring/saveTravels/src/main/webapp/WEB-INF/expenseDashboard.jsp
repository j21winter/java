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
<title>Save Travels Dashboard</title>
</head>
<body>
	<div class="container">
		
		
		<div class="title">
			<h1>Save Travels</h1>
		</div>
		
		
		<div class="all-expenses">
			<table class="table">
				<thead>
					<tr>
						<th>Expense</th>
						<th>Vendor</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="expense" items="${allExpenses}">
						<tr>
							<td>
								<a href="/expense/${expense.id }/show">
									<c:out value="${expense.expenseName }"/>	
								</a>
							</td>
							<td>
								<c:out value="${expense.vendorName }"/>
							</td>
							<td>
								<c:out value="${expense.amount}"/>
							</td>
							<td class="d-flex">
								<a href="/expense/${expense.id }/edit" class="btn btn-warning">Edit</a>
								<form action="/expense/${expense.id }" method="post">
									<input type="hidden" name="_method" value="delete" />
									<button class="btn btn-danger">Delete</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="add-expense">
			<h2>Add an expense:</h2>
			<form:form class="form" action="/expense" method="post" modelAttribute="expense">
				
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