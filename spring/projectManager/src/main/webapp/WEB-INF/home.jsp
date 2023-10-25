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
					<p class="display-6 m-0">All Projects</p>
					<a href="/projects/new" class="btn btn-info">+ new project</a>
				</div>
			</div>
			<div class="card-body">
				<table class="table">
					<thead>
						<tr>
							<th>Project</th>
							<th>Team Lead</th>
							<th>Due Date</th>
							<th class="text-center">Actions</th>
						</tr>
					</thead>
					<tbody class="table-group-divider">
						<!-- c:forEach through the projects -->
						<c:forEach var="project" items="${possibleProjects }">
							<tr>
								<td><a href="/projects/${project.id }/show"> <c:out value="${project.title }"/> </a></td>
								<td><c:out value="${project.teamLead.firstName }"/></td>
								<td> <fmt:formatDate value="${project.dueDate }" type="date" pattern="yyyy-MM-dd" /> </td>
								<td class="text-center">
									<c:if test="${project.teamLead.id != user.id }">
										<a href="/projects/${project.id }/join">Join Team</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>	
			</div>
		</div>
		
		<div class="card mb-3">
			<div class="card-header bg-secondary text-light">
				<div class="d-flex justify-content-between align-items-center">
					<p class="display-6 m-0">Your Projects</p>
				</div>
			</div>
			<div class="card-body ">
				<table class="table table rounded rounded-2 ">
					<thead>
						<tr>
							<th>Project</th>
							<th>Team Lead</th>
							<th>Due Date</th>
							<th class="text-center">Actions</th>
						</tr>
					</thead>
					<tbody class="table-group-divider">
						<!-- c:forEach through the projects -->
						<c:forEach var="project" items="${myProjects }">
							<tr>
								<td><a href="/projects/${project.id }/show"> <c:out value="${project.title }"/> </a></td>
								<td><c:out value="${project.teamLead.firstName }"/></td>
								<td><fmt:formatDate value="${project.dueDate }" type="date" pattern="yyyy-MM-dd" /></td>
								<td>
									<div class="actions d-flex justify-content-evenly">
										<c:choose>
											<c:when test="${project.teamLead.id == user.id }">
												<a href="/projects/${project.id }/edit" class="btn btn-primary">Edit</a>
												<form action="/projects/${project.id }" method="post">
													<input type="hidden" name="_method" value="delete" />
													<button type="submit" class="btn btn-warning">Delete</button>
												</form>
											</c:when>
											<c:otherwise>
												<a href="/projects/${project.id }/leave">Leave Team</a>
											</c:otherwise>
										</c:choose>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>	
			</div>
		</div>
		
		
	</div>
</body>
</html>