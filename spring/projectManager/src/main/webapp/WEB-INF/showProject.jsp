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
<title>${project.getTitle() }</title>
</head>
<body>
	<div class="container">
		<div class="navbar d-flex justify-content-evently mb-5">
			<h1 class="display-4"> <c:out value="${project.getTitle() } " /></h1>
			<a href="/home" class="btn btn-secondary mx-auto"> Home </a>
			<a href="/logout" class="btn btn-warning">Logout</a>
		</div>
		<div class="d-flex justify-content-evenly">
			<div class="details w-75 text-center">
				<div class="card shadow">
					<div class="card-body">
						<p class="display-6">Team Details</p>
						<c:if test="${userId == project.teamLead.id }">
							<div class="d-flex justify-content-evenly">
								<div class="">
									<a href="/projects/${project.id }/edit" class="btn btn-secondary mx-auto"> Edit</a>
								</div>
								<form action="/projects/${project.id }" method="post">
									<input type="hidden" name="_method" value="delete" />
									<button class="btn btn-danger" type="submit">Delete</button>
								</form>
							</div>
							
						</c:if>
						<table class="table table-lg">
							<tr>
								<th>Title: </th>
								<td>${project.title }</td>
							</tr>
							<tr>
								<th>Description: </th>
								<td>${project.description }</td>
							</tr>
							<tr>
								<th>Team Lead: </th>
								<td>${project.teamLead.firstName } ${project.teamLead.lastName }</td>
							</tr>
							<tr>
								<th>Due Date: </th>
								<td>${project.dueDate }</td>
							</tr>
						</table>
						<div class="text-center">
							<p class="display-6 text-center">Team Members:</p>
							<table class="table table-sm text-start mx-auto">
								<thead>
									<tr class="w-100">
										<th>#</th>
										<th>Member:</th>
										<c:if test="${userId == project.teamLead.id }">
											<th>Actions: </th>
										</c:if>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="member" items="${project.projectMembers }" varStatus="status" >
										<tr class="w-100">
											<td>${status.count }</td>
											<td>${member.firstName } ${member.lastName } </td>
											<c:if test="${userId == project.teamLead.id}">
												<td> 
													<c:if test="${project.teamLead.id != member.id}">
														<a href="/projects/${project.id }/remove/${member.id}">Remove From Team</a>
													</c:if>
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
				<div class="card shadow">
					<div class="card-body">
						<p class="display-6">Tasks</p>
						<p>Add a task:</p>
						<form:form action="/projects/${project.id }/add_task" method="post" modelAttribute="task">
							<div class="mb-4">
								<form:label  path="description" class="form-label">Description</form:label>
								<form:errors path="description" class="form-text text-warning" />
								<form:textarea type="text" path="description" class="form-control"></form:textarea>
							</div>
							<div class="mb-4 text-end">
								<button class="btn btn-info" type="submit">Submit</button>
							</div>
						</form:form>
						<hr />
						<c:forEach var="task" items="${project.tasks }">
							<c:if test="${task.complete != true }">
								<div class="card shadow">
									<div class="card-header d-flex">
										<div class="">
											<p class="card-title">Added By ${task.user.firstName } </p>
											<p class="card-subtitle text-muted mb-2">${task.createdAt }</p>
										</div>
										<div class="">
											<a href="/projects/${task.project.id}/task/${task.id}/complete" class="btn btn-success">Mark Complete</a>
										</div>
									</div>
									<div class="card-body">
										<p class="card-text">${task.description} </p>
									</div>
								</div>
							</c:if>
						</c:forEach>
								
					</div>
				</div>
		</div>
	</div>

</body>
</html>