<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Visit Count</title>
</head>
<body>
	<div class="container">
		<p>You have visited <a href="/">localhost:8080</a> <c:out value="${count }"></c:out> times.</p>
		<a href="/reset">Reset your counter?</a>
	</div>

</body>
</html>