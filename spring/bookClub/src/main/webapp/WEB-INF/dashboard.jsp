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
<html lang="en">
<head>
    <!-- To use bootstrap -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- For any Bootstrap that uses JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Books Login Page</title>
</head>
<body>
    <div class="container">
    		<div class="nav">
    			<div class="col">
    				<h1>Welcome <c:out value="${user.name}"/></h1>
    			</div>
    			<div class="col">
    				<a href="/logout">Logout</a>
    			</div>
    		</div>
    		<div class="main">
    			<div class="row">
	    			<div class="col">
		    			<p>Books from everyone's shelves:</p>
	    			</div>
    				<div class="col">
		    			<a href="/books/new">Add a new book!</a>
	    			</div>
    			</div>
    			<table class="table ">
    				<thead>
    					<tr>
    						<th>ID</th>
    						<th>Title</th>
    						<th>Author Name</th>
    						<th>Owner</th>
    						<th>Actions</th>
    					</tr>
    				</thead>
    				<tbody>
    					<c:forEach var="book" items="${books }">
    						<c:if test="${book.borrower == null }">
	    						<tr>
	    							<td>
	    								<c:out value="${book.id}" />
	    							</td>
	    							<td>
	    								<a href="/books/${book.id }"><c:out value="${book.title }" /></a>
	    							</td>
	    							<td>
	    								<c:out value="${book.author }" />
	    							</td>
	    							<td>
	    								<c:out value="${book.user.name }" />
	    							</td>
	    							<td>
	    								<c:choose>
	    									<c:when test="${userId == book.user.id }">
	    										<div class="d-flex">
		    										<a href="/books/${book.id}/update" class="btn btn-info">Edit</a>
		    										<form action="/books/${book.id}/delete" method="post">
		    											<input type="hidden" name="_method" value="delete" />
		    											<button type="submit" class="btn btn-warning">Delete</button>
		    										</form>
	    										</div>
	    									</c:when>
	    									<c:otherwise>
	    										<a href="/books/${book.id }/borrow" class="btn btn-success">Borrow Book</a>
	    									</c:otherwise>
	    								</c:choose>
	    								
	    							</td>
	    						</tr>
    						</c:if>
    					</c:forEach>
    				</tbody>
    			</table>
    			<hr />
    			<h2>Borrowed Books</h2>
    			<table class="table ">
    				<thead>
    					<tr>
    						<th>ID</th>
    						<th>Title</th>
    						<th>Author Name</th>
    						<th>Owner</th>
    						<th>Actions</th>
    					</tr>
    				</thead>
    				<tbody>
    					<c:forEach var="book" items="${user.borrowedBooks }">
    						<tr>
    							<td>
    								<c:out value="${book.id}" />
    							</td>
    							<td>
    								<a href="/books/${book.id }"><c:out value="${book.title }" /></a>
    							</td>
    							<td>
    								<c:out value="${book.author }" />
    							</td>
    							<td>
    								<c:out value="${book.user.name }" />
    							</td>
    							<td>
    								<a href="/books/${book.id }/return" class="btn btn-success">Return Book</a>
    							</td>
    						</tr>
    					</c:forEach>
    				</tbody>
    			</table>
    		</div>
    </div>
</body>
</html>