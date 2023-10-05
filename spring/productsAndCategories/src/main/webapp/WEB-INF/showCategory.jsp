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
<title> ${category.name} </title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1 class="display">  ${category.name} </h1>
		</div>
		<div class="row">
			<a href="/home">HOME</a>
		</div>
		<hr />
		<div class="row">
			<h3 class="display3">Products:</h3>
			<ul>
				<c:forEach var="product" items="${assignedProducts }">
					<li>
						<a href="/product/${product.id }"> ${product.name }</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		<hr />
		<div class="row">
			<h4 class="display-5">Add A PRODUCT:</h4>
				<form action="/category/${category.id}" method="post">
					<select name="productId">
						<c:forEach var="product" items="${unassignedProducts }">
							<option value="${product.id }"> ${product.name } </option>
						</c:forEach>
					</select>
					<button class="btn btn-success" type="submit">Submit</button>
				</form>
		</div>
		
	</div>
</body>
</html>