<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Classrooms</title>
		<%@ include file="include/header.jsp" %>
		<br>
		<br>
		<div class="row">
			<div class="col">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Classroom name</th>
							<th scope="col" class="d-none d-md-table-cell">Adress</th>
							<th scope="col">Capacity</th>
							<th scope="col">Details</th>
						</tr>
					</thead>

					<tbody>
					<c:forEach var="classroom" items="${classrooms}">

						<tr>
							<td>${classroom.classroomName}</td>
							<td class="d-none d-md-table-cell">${classroom.adress}</td>
							<td>${classroom.capacity}</td>
							<td><a href="${pageContext.request.contextPath}/classroomDetails/?id=${classroom.classroomID}">Details</td>
						</tr>

					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-6 col-md-3">
				<button class="btn btn-primary nav-button"
					onclick="location.href='${pageContext.request.contextPath}/add_classroom'">Add classroom</button>
			</div>
		</div>

	</div>
	<%@ include file="include/footer.jsp" %>