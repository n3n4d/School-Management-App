<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${group.groupName}</title>
		<%@ include file="include/header.jsp" %>
		<br> <br>
		<div class="row">
			<div class="col">
				<h1>
					<b>${group.groupName}</b>
				</h1>
				<h4>
					<b>Teacher:</b> ${teacher}
				</h4>
				<h4>
					<b>Time:</b> ${group.day} ${group.time}
				</h4>
				<h4>
					<b>Classroom:</b> ${classroom}
				</h4>
				<br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">First name</th>
							<th scope="col">Last name</th>
							<th scope="col" class="d-none d-md-table-cell">Email</th>
							<th scope="col" class="d-none d-md-table-cell">Phone</th>
							<th scope="col">Details</th>
						</tr>
					</thead>

					<tbody>
					<c:forEach var="student" items="${students}">

						<tr>
							<td>${student.firstName}</td>
							<td>${student.lastName}</td>
							<td class="d-none d-md-table-cell">${student.email}</td>
							<td class="d-none d-md-table-cell">${student.phone}</td>
							<td><a href="${pageContext.request.contextPath}/studentDetails/?id=${student.studentID}">Details</td>
						</tr>

					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-6 col-md-3">
				<button class="btn btn-primary nav-button"
					onclick="location.href='${pageContext.request.contextPath}/edit_group/?id=${group.groupID}'">Edit
					group</button>
			</div>
			<div class="col-6 col-md-3">
				<button type="button" class="btn btn-primary nav-button" data-toggle="modal" data-target="#deleteModal">
  					Delete group
				</button>
			</div>
		</div>

		<div class="modal fade" id="deleteModal" tabindex="-1"
			role="dialog" aria-labelledby="deleteModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="deleteModalLongTitle">Delete group</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Are you sure that you want to delete ${group.groupName}?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancel</button>
						<button onclick="location.href='${pageContext.request.contextPath}/deleteGroup/?id=${group.groupID}'" type="button" class="btn btn-primary" >Delete</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="include/footer.jsp" %>