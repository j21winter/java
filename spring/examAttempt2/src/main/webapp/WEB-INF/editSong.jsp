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
<title>Edit Song</title>
</head>
<body>
	<div class="container">
		<h1 class="display-3 my-4 text-center">EditSong</h1>
		<c:choose>
			<c:when test="${isCollaborator == true }">
				<div class="card col-6 mx-auto">
					<div class="card-body">
						<form:form action="/songs/${song.id }/collaborate" method="post" modelAttribute="song">
							<input type="hidden" name="_method" value="put" />
							<form:input type="hidden" path="lyrics" value="${song.lyrics }"/>
							<div class="mb-4">
								<form:label  path="title" class="form-label">Title:</form:label>
								<form:input type="text" path="title" class="form-control" />
								<form:errors path="title" class="form-text text-warning" />
							</div>
							
							<div class="mb-4">
								<form:label  path="genre" class="form-label">Genre:</form:label>
								<form:input type="text" path="genre" class="form-control" />
								<form:errors path="genre" class="form-text text-warning" />
							</div>
							
							<div class="mb-4">
								<p>Lyrics:</p>
								<p class="mx-5 fw-bold fst-italic">"${song.lyrics }..."</p>
								<label class="form-label" for="addLyrics">Add your Lyrics</label>
								<textarea class="form-control" name="addLyrics"></textarea>
							</div>
							
							<div class="mb-4 text-end">
								<button class="btn btn-info" type="submit">Submit</button>
							</div>
						</form:form>
					</div>	
				</div>		
			</c:when>
			<c:otherwise>
				<div class="card col-6 mx-auto">
					<div class="card-body">
						<form:form action="/songs/${song.id }" method="post" modelAttribute="song">
							<input type="hidden" name="_method" value="put" />
							<div class="mb-4">
								<form:label  path="title" class="form-label">Title:</form:label>
								<form:input type="text" path="title" class="form-control" />
								<form:errors path="title" class="form-text text-warning" />
							</div>
							
							<div class="mb-4">
								<form:label  path="genre" class="form-label">Genre:</form:label>
								<form:input type="text" path="genre" class="form-control" />
								<form:errors path="genre" class="form-text text-warning" />
							</div>
							
							<div class="mb-4">
								<form:label  path="lyrics" class="form-label">Lyrics:</form:label>
								<form:textarea path="lyrics" class="form-control" />
								<form:errors path="lyrics" class="form-text text-warning" />
							</div>
							
							<div class="mb-4 d-flex text-end">
								<button class="btn btn-info" type="submit">Submit</button>
							</div>
						</form:form>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		
		<div class="d-flex justify-content-around my-5 mx-auto">
			<c:if test="${userId == song.user.id }">
				<form:form action="/songs/${song.id}" method="post" modelAttribute="song">
					<input type="hidden" name="_method" value="delete" />
					<button class="btn btn-danger" type="submit">Delete</button>
				</form:form>
			</c:if>
			<div class="">
				<a href="/home" class="btn btn-secondary mx-auto">Cancel</a>	
			</div>
		</div>
	</div>
</body>
</html>