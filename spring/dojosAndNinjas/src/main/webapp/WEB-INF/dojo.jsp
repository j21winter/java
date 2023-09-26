<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- To use JSTL Tags -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- To use Data binding and Model Attribute in our forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- To use Error messages in our forms -->
<%@ page isErrorPage="true" %>  
<html>
<head>
<meta charset="UTF-8">
<!-- To connect CSS file (create folder in src>main>resources>static> “css”) -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- To connect JS file (create folder in src>main>resources>static> “js”) -->
<script type="text/javascript" src="/js/app.js"></script>
<!-- To use bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title> <c:out value="${dojo.location }"/> Dojo</title>
</head>
<body>
	<div class="container">
		<h1> <c:out value="${dojo.location }"/> Location Ninjas</h1>
		
		<table class="table">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninja" items="${dojo.ninjas }">
					<tr>
						<td>
							<c:out value="${ninja.firstName }"/>
						</td>
						<td>
							<c:out value="${ninja.lastName }"/>
						</td>
						<td>
							<c:out value="${ninja.age }"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>