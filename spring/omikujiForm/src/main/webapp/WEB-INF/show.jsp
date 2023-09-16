<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show</title>
</head>
<body>
	<div class="container">	
		<p>
			In <c:out value="${number}"/> years your will live in <c:out value="${city}"/> with <c:out value="${personName}"/> as your roommate, <c:out value="${hobby}"/> for a living. <br>
			The next time you see a  <c:out value="${livingThing}"/> you will have good luck. <br>
			Also,  <c:out value="${somethingNice}"/>
		</p>
		<a href="/omikuji">Go Back</a>
	</div>

</body>
</html>