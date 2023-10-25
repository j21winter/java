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
<title>${team.getName() }</title>
</head>
<body>
	<div class="container">
		<div class="navbar d-flex justify-content-evently mb-5">
			<h1 class="display-4"> <c:out value="${team.name } " /></h1>
			<a href="/home" class="btn btn-secondary mx-auto"> Home </a>
			<a href="/logout" class="btn btn-warning">Logout</a>

		</div>
		<div class="d-flex justify-content-evenly">
			<div class="details w-75 text-center">
				<div class="card shadow">
					<div class="card-body">
						<p class="display-6">Team Details</p>
						<c:if test="${user.id == team.user.id }">
							<div class="d-flex justify-content-evenly">
								<div class="">
									<a href="/teams/${team.id }/edit" class="btn btn-secondary mx-auto"> Edit</a>
								</div>
								<form:form action="/teams/${team.id}" method="post" modelAttribute="team">
									<input type="hidden" name="_method" value="delete" />
									<button class="btn btn-danger" type="submit">Delete</button>
								</form:form>
							</div>
							
						</c:if>
						<table class="table table-lg">
							<tr>
								<th>Team Name: </th>
								<td>${team.name }</td>
							</tr>
							<tr>
								<th>Added By: </th>
								<td>${team.user.firstName }</td>
							</tr>
							<tr>
								<th>Skill Level: </th>
								<td>${team.skillLevel }</td>
							</tr>
							<tr>
								<th>Game Day: </th>
								<td>${team.gameDay }</td>
							</tr>
						</table>
						<div class="text-center">
							<p class="display-6 text-center">Players:</p>
							<table class="table table-sm text-start mx-auto">
								<thead>
									<tr class="w-100">
										<th>#</th>
										<th>Player Name:</th>
										<c:if test="${user.id == team.user.id }">
											<th>Actions: </th>
										</c:if>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="player" items="${team.players }" varStatus="status" >
										<tr class="w-100">
											<td>${status.count }</td>
											<td>${player.firstName } ${player.lastName } </td>
											<c:if test="${user.id == team.user.id }">
												<td> 
													<form action="/players/${player.id}/${teamId }" method="post">
														<input type="hidden" name="_method" value="delete" />
														<button class="btn btn-danger" type="submit">Remove</button>
													</form>
												</td>
											</c:if>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							
						</div>
					</div>
				</div>
			</div>
			<c:if test="${user.getId() == team.getUser().getId() }">
				<c:choose >
					<c:when test="${team.getPlayers().size() < 9 }">
						<div class="add_players w-75 text-center">
							<div class="card shadow">
								<div class="card-body">
									<p class="display-6">Add A Player</p>
									<form:form  action="/team/${team.id }/addPlayer" method="post" modelAttribute="player">
										<div class="mb-4">
											<form:label path="firstName"  class="form-label">First name: </form:label>
											<form:input path="firstName"  class="form-control" type="text" />
											<form:errors path="firstName" class="form-text text-warning" />
										</div>
										<div  class="mb-4">
											<form:label path="lastName" class="form-label">Last name:</form:label>
											<form:input path="lastName"  class="form-control" type="text" />
											<form:errors path="lastName" class="form-text text-warning" />
										</div>
										<button class="btn btn-info" type="submit">Submit</button>
									</form:form>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div>
							<p class="text-warning"> Team is already Full!</p>
						</div>
					</c:otherwise>
				</c:choose>
				</c:if>
		</div>
	</div>

</body>
</html>