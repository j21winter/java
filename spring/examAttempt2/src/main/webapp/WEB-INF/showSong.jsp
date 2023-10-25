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
<title>${song.getTitle() }</title>
</head>
<body>
	<div class="container">
		<div class="navbar d-flex justify-content-evently mb-5">
			<a href="/home" class="btn btn-secondary mx-auto"> Home </a>
			<a href="/logout" class="btn btn-warning">Logout</a>

		</div>
		<div class="d-flex justify-content-evenly">
			<div class="details w-75 text-start">
				<div class="card shadow">
					<div class="card-header">
						<h1 class="display-3 fst-italic">${song.getTitle() }</h1>
						<h2 class="text-muted fs-2">(Started by ${song.getUser().getName() })</h2>
					</div>
					<div class="card-body">
						<div class="details">
							<p class="fs-4">Genre: ${song.getGenre() }</p>
							<p class="fs-4">Lyrics:</p>
							<p class="fs-5 mx-5">${song.getLyrics() }</p>
						</div>
						<a href="/songs/${song.id }/contribute" class="btn btn-success"> < Contribute</a>
						<hr />
						<div>
							<p class="fs-4">Collaborators:</p>
							<ul class="list-unstyled">
								<c:forEach var="user" items="${song.collaborators }" varStatus="status" >
									<li  class="fs-5">${user.name }</li>
								</c:forEach>
							</ul>		
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>