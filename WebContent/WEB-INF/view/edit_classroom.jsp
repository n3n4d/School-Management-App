<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit classroom</title>
		<%@ include file="include/header.jsp" %>
		<br> <br>
		<div class="row">
			<div class="col col-md-6">
				<form:form name='f' action='${pageContext.request.contextPath}/updateClassroom' method='POST' modelAttribute="classroom">
					<form:hidden path="classroomID"/>
					<label for="classroomName">Classroom name:</label> 
					<form:input path="classroomName" class="form-control"
						id="classroomName" type='text' name='classroomName' value='' required="true"/><br>
					<label for="adress">Adress:</label> 
					<form:input path="adress" id="adress"
						class="form-control" type='text' name='adress' value='' required="true"/><br>
					<label for="capacity">Capacity:</label> 
					<form:input path="capacity" id="capacity"
						class="form-control" type='text' name='capacity' value='' required="true"/><br>
					<input name="submit" type="submit" value="Save changes"
						class="btn btn-primary" />
					<input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form:form>
			</div>
		</div>

	</div>
	<%@ include file="include/footer.jsp" %>