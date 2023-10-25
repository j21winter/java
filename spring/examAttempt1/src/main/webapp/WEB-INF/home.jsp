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
<title>Project Home</title>
</head>
<body>
	<div class="container">
		<div class="navbar justify-content-between mb-5">
			<h1 class="display-4"> Welcome <c:out value="${user.firstName }"></c:out></h1>
			<a href="/logout" class="btn btn-warning">Logout</a>
		</div>
		<div class="card mb-3">
			<div class="card-header">
				<div class="d-flex justify-content-between align-items-center">
					<p class="display-6 m-0">All Teams</p>
					<a href="/teams/new" class="btn btn-info">+ new Team</a>
				</div>
			</div>
			<div class="card-body">
				<table class="table text-center">
					<thead>
						<tr>
							<th>Team Name</th>
							<th>Skill Level</th>
							<th>Players</th>
							<th>Game Day</th>
						</tr>
					</thead>
					<tbody class="table-group-divider">
						<!-- c:forEach through the projects -->
						<c:forEach var="team" items="${allTeams }">
							<tr>
								<td>
									<a href="/teams/${team.id }/show">${team.name }</a>
								</td>
								<td><c:out value="${team.skillLevel }"/></td>
								<td><c:out value="${team.players.size() }"/>/9</td>
	 							<td><c:out value="${team.gameDay }"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>	
			</div>
		</div>
	</div>
</body>
</html>