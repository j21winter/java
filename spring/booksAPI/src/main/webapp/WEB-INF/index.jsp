<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<td>ID</td>
					<td>Title</td>
					<td>Language</td>
					<td># Pages</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${allBooks}">
					<tr>
						<td> <c:out value="${book.id}"/> </td>
						<td> <a href="/books/${book.id}"> <c:out value="${book.title}"/>  </a> </td>
						<td> <c:out value="${book.language}"/> </td>
						<td> <c:out value="${book.numberOfPages}"/> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>