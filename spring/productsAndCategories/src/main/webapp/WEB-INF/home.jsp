<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- To use JSTL Tags -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- To use bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Home Page</title>
</head>
<body>
	<div class="container">
		<h1 class="display">Home Page</h1>
		<div class="row">
			<div class="col">
				<h3 class="display-3"> Products</h3>
				<a href="/product/new">Add Product</a>
				<div class="list">
					<ul>
						<c:forEach var="product" items="${products }">
							<li>
								<a href="/product/${product.id}">
									<c:out value="${product.name }"/>
								</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col">
				<h3 class="display-3"> Categories</h3>
				<a href="/category/new">Add Category</a>
				<div class="list">
					<ul>
						<c:forEach var="category" items="${categories }">
							<li>
								<a href="/category/${category.id}">
									<c:out value="${category.name }"/>
								</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>