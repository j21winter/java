<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- To use JSTL Tags -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- To use bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Lyrics Lab</title>
</head>
<body>
	<div class="container">
		<div class="navbar justify-content-between mb-5">
			<h1 class="display-4"> Hello, <c:out value="${user.name }"></c:out></h1>
			<a href="/logout" class="btn btn-warning">Log Out</a>
		</div>
		<div class="card mb-3">
			<div class="card-header">
				<div class="d-flex justify-content-between align-items-center">
					<p class="display-6 m-0">All Song labs</p>
					<a href="/songs/new" class="btn btn-info">+ New Song</a>
				</div>
			</div>
			<div class="card-body">
				<table class="table text-center">
					<thead>
						<tr>
							<th>Song</th>
							<th># of Collaborations</th>
						</tr>
					</thead>
					<tbody class="table-group-divider">
						<!-- c:forEach through the songs -->
						<c:forEach var="song" items="${allSongs }">
							<tr>
								<td>
									<a href="/songs/${song.id }/show">${song.title }</a>
									<p class="text-muted">Genre: <c:out value="${song.genre }"/></p>
								</td>
 	 							<td><c:out value="${song.collaborationNumber }"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>	
			</div>
		</div>
	</div>
</body>
</html>