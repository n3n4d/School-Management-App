<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Teachers</title>
		<%@ include file="include/header.jsp" %>
		<br>
		<br>
		<div class="row">
			<div class="col">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">First name</th>
							<th scope="col">Last name</th>
							<th scope="col">Details</th>
						</tr>
					</thead>

					<tbody>
					<c:forEach var="teacher" items="${teachers}">

						<tr>
							<td>${teacher.firstName}</td>
							<td>${teacher.lastName}</td>
							<td><a href="${pageContext.request.contextPath}/teacherDetails/?id=${teacher.teacherID}">Details</td>
						</tr>

					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-6 col-md-3">
				<button class="btn btn-primary nav-button"
					onclick="location.href='${pageContext.request.contextPath}/add_teacher'">Add teacher</button>
			</div>
		</div>

	</div>
	<%@ include file="include/footer.jsp" %>