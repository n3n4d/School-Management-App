<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${teacher.firstName} ${teacher.lastName}</title>
		<%@ include file="include/header.jsp" %>
		<br> <br>
		<div class="row">
			<div class="col">
				<h1>
					<b>${teacher.firstName} ${teacher.lastName}</b>
				</h1>
				<h4>
					<b>Email:</b> ${teacher.email}
				</h4>
				<h4>
					<b>Phone:</b> ${teacher.phone}
				</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-6 col-md-3">
				<button class="btn btn-primary nav-button"
					onclick="location.href='${pageContext.request.contextPath}/edit_teacher/?id=${teacher.teacherID}'">Edit
					teacher</button>
			</div>
			<div class="col-6 col-md-3">
				<button type="button" class="btn btn-primary nav-button" data-toggle="modal" data-target="#deleteModal">
  					Delete teacher
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
					<div class="modal-body">Are you sure that you want to delete ${teacher.firstName} ${teacher.lastName}?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancel</button>
						<button onclick="location.href='${pageContext.request.contextPath}/deleteTeacher/?id=${teacher.teacherID}'" type="button" class="btn btn-primary" >Delete</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="include/footer.jsp" %>