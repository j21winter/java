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
<title>Home</title>
</head>
<body>
	<div class="container">
		<h1>Fruit Store</h1>
		<table class="table mb-4 table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<td>Name</td>
					<td>Price</td>
				</tr>
			</thead>
			<tbody class="table table-striped">
				<c:forEach var="fruit" items="${fruits}">
					<tr class="mb-4">
						<td><c:out value="${fruit.name}"></c:out></td>
						<td>$<c:out value="${fruit.price}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
	</div>

</div>	
	
	
</body>
</html>