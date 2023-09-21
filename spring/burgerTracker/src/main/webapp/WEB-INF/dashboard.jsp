<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- To use bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Burger Dashboard</title>
</head>
<body>
	<div class="container">
		<div class="tracker col-8" style="margin: 0 auto;">
			<h1>Burger Tracker</h1>
			<table class="table table">
				<thead class="table-secondary">
					<tr>
						<th>Burger Name</th>
						<th>Restaurant Name</th>
						<th>Rating (out of 5)</th>
						<th>Options</th>
					</tr>
				</thead>
				<tbody class="table-striped">
					<c:forEach var="burger" items="${burgers}">
						<tr>
							<td> <c:out value="${burger.burgerName }"/> </td>
							<td> <c:out value="${burger.restaurantName }"/> </td>
							<td> <c:out value="${burger.rating }"/> </td>
							<td class="d-flex"> 
								<a class="btn btn-dark" href="/burger/show/${burger.id}">Edit Burger</a>
								<form action="/burger/${burger.id}" method="post">
    									<input type="hidden" name="_method" value="delete">
    									<input type="submit" value="Delete">
								</form>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="form">
			<h2>Add a Burger:</h2>
			<form:form action="/formSubmit" method="post" modelAttribute="burger" class="form mb-3">
				<div class="row mb-3">
					<form:label path="burgerName">Burger Name:</form:label>
					<form:input path="burgerName"/>
					<form:errors path="burgerName" />
				</div>
				<div class="row mb-3">
					<form:label path="restaurantName">Restaurant Name:</form:label>
					<form:input path="restaurantName"/>
					<form:errors path="restaurantName" />
				</div>
				<div class="row mb-3">
					<form:label path="rating">Rating (out of 5)</form:label>
					<form:input type="number" path="rating"/>
					<form:errors path="rating" />
				</div>
				<div class="row mb-3">
					<form:label path="notes">Notes:</form:label>
					<form:textarea path="notes"/>
					<form:errors path="notes" />
				</div>
				<div class="row mb-3">
					<button class="btn btn-info" type="submit">Submit</button>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>