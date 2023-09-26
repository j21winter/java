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
<title>New Ninja</title>
</head>
<body>
	<div class="container">
	
	<h1>Add a Ninja</h1>
	
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
		<div>
			<form:label path="firstName">First Name</form:label>	
			<form:input type="text" path="firstName"/>
			<form:errors path="firstName"></form:errors>
		</div>
		<div>
			<form:label path="lastName">Last Name</form:label>	
			<form:input type="text" path="lastName"/>
			<form:errors path="lastName"></form:errors>
		</div>
		<div>
			<form:label path="age">Age</form:label>	
			<form:input type="number" path="age"/>
			<form:errors path="age"></form:errors>
		</div>
		<div>
			<form:select path="dojo">
				<c:forEach var="dojo" items="${allDojos }">
					<option value="${dojo.id }"> <c:out value="${dojo.location }"/></option>
				</c:forEach>
			</form:select>
		</div> 
		<div>
			<button class="btn" type="submit">Submit</button>
		</div>
	</form:form>
	
	</div>
</body>
</html>