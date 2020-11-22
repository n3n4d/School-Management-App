<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${student.firstName} ${student.lastName}</title>
		<%@ include file="include/header.jsp" %>
		<br> <br>
		<div class="row">
			<div class="col">
				<h1>
					<b>${student.firstName} ${student.lastName}</b>
				</h1>
				<h4>
					<b>Birthyear:</b> ${student.birthYear}
				</h4>
				<h4>
					<b>Email:</b> ${student.email}
				</h4>
				<h4>
					<b>Phone:</b> ${student.phone}
				</h4>
				<h4>
					<c:choose>
						<c:when test="${student.groupID == 0}">
							<b>Group:</b> None
						</c:when>
						<c:otherwise>
							<b>Group:</b> ${group.groupName}
						</c:otherwise>
					</c:choose>
				</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-6 col-md-3">
				<button class="btn btn-primary nav-button"
					onclick="location.href='${pageContext.request.contextPath}/edit_student/?id=${student.studentID}'">Edit
					student</button>
			</div>
			<div class="col-6 col-md-3">
				<button type="button" class="btn btn-primary nav-button" data-toggle="modal" data-target="#deleteModal">
  					Delete student
				</button>
			</div>
		</div>

		<div class="modal fade" id="deleteModal" tabindex="-1"
			role="dialog" aria-labelledby="deleteModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="deleteModalLongTitle">Delete student</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Are you sure that you want to delete ${student.firstName} ${student.lastName}?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancel</button>
						<button onclick="location.href='${pageContext.request.contextPath}/deleteStudent/?id=${student.studentID}'" type="button" class="btn btn-primary" >Delete</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="include/footer.jsp" %>