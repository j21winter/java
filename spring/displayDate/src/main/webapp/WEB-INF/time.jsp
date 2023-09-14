<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/timeScript.js"></script>
	<title>Time</title>
</head>
</head>
<body>
	<div class="container">
		<div class="display">
			<h1> <c:out value="${time}"/> </h1>
		</div>
	</div>

</body>
</html>