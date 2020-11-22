<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Add classroom</title>
		<%@ include file="include/header.jsp" %>
		<br> <br>
		<div class="row">
			<div class="col col-md-6">
				<form:form name='f' action='${pageContext.request.contextPath}/addClassroom' method='POST' modelAttribute="classroom">
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
					<input name="submit" type="submit" value="Add classroom"
						class="btn btn-primary" />
					<input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form:form>
			</div>
		</div>

	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>