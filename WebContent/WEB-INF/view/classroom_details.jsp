<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${classroom.classroomName}</title>
		<%@ include file="include/header.jsp" %>
		<br> <br>
		<div class="row">
			<div class="col">
				<h1>
					<b>${classroom.classroomName}</b>
				</h1>
				<h4>
					<b>Adress:</b> ${classroom.adress}
				</h4>
				<h4>
					<b>Capacity:</b> ${classroom.capacity}
				</h4>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Group name</th>
							<th scope="col" >Day</th>
							<th scope="col" >Time</th>
							<th scope="col">Details</th>
						</tr>
					</thead>

					<tbody>
					<c:forEach var="group" items="${groups}">

						<tr>
							<td>${group.groupName}</td>
							<td >${group.day}</td>
							<td >${group.time}</td>
							<td><a href="${pageContext.request.contextPath}/groupDetails/?id=${group.groupID}">Details</td>
						</tr>

					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-6 col-md-3">
				<button class="btn btn-primary nav-button"
					onclick="location.href='${pageContext.request.contextPath}/edit_classroom/?id=${classroom.classroomID}'">Edit
					classroom</button>
			</div>
			<div class="col-6 col-md-3">
				<button type="button" class="btn btn-primary nav-button" data-toggle="modal" data-target="#deleteModal">
  					Delete classroom
				</button>
			</div>
		</div>

		<div class="modal fade" id="deleteModal" tabindex="-1"
			role="dialog" aria-labelledby="deleteModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="deleteModalLongTitle">Delete classroom</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Are you sure that you want to delete ${classroom.classroomName}?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancel</button>
						<button onclick="location.href='${pageContext.request.contextPath}/deleteClassroom/?id=${classroom.classroomID}'" type="button" class="btn btn-primary" >Delete</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="include/footer.jsp" %>