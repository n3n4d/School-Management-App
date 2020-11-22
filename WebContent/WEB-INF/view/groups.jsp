<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Groups</title>
		<%@ include file="include/header.jsp" %>
		<br>
		<br>
		<div class="row">
			<div class="col">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Group name</th>
							<th scope="col" class="d-none d-md-table-cell">Number of students</th>
							<th scope="col" >Day</th>
							<th scope="col" >Time</th>
							<th scope="col">Details</th>
						</tr>
					</thead>

					<tbody>
					<c:forEach var="group" items="${groups}">

						<tr>
							<td>${group.groupName}</td>
							<td class="d-none d-md-table-cell">${group.numberOfStudents}</td>
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
					onclick="location.href='${pageContext.request.contextPath}/add_group'">Add group</button>
			</div>
		</div>

	</div>
	<%@ include file="include/footer.jsp" %>