<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Add student</title>
		<%@ include file="include/header.jsp" %>
		<br> <br>
		<div class="row">
			<div class="col col-md-6">
				<form:form name='f' action='${pageContext.request.contextPath}/addStudent' method='POST' modelAttribute="student">
					<form:hidden path="studentID"/>
					<c:if test="${param.error_fullgroup != null}">
						<span class="error">The group you have selected is full.</span>
						<br>
						<br>
					</c:if>
					<label for="firstName">First name:</label> 
					<form:input path="firstName" class="form-control"
						id="firstName" type='text' name='firstName' value='' required="true"/><br>
					<label for="lastName">Last name:</label> 
					<form:input path="lastName" id="lastName"
						class="form-control" type='text' name='lastName' value='' required="true"/><br>
					<label for="email">Email:</label> 
					<form:input path="email" id="email"
						class="form-control" type='text' name='email' value='' required="true"/><br>
					<label for="phone">Phone:</label> 
					<form:input path="phone" id="phone"
						class="form-control" type='text' name='phone' value='' required="true"/><br>
					<label for="birthYear">Birth year:</label>
					<form:select path="birthYear" name='birthYear' class="form-control" id="birthYear">
					    <c:forEach begin="1900" end="2020" varStatus="loop">
		    				<option value="${loop.index}">${loop.index}</option>
					    </c:forEach>
				    </form:select><br>
					<label for="exampleFormControlSelect1">Select group</label>
				    <form:select path="groupID" name='groupID' class="form-control" id="groupSelect">
				    	<option value="0">None</option>
					    <c:forEach var="group" items="${groups}">
		    				<option value="${group.groupID}">${group.groupName}</option>
					    </c:forEach>
				    </form:select><br>
					<input name="submit" type="submit" value="Add student"
						class="btn btn-primary" />
					<input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form:form>
			</div>
		</div>

	</div>
	<%@ include file="include/footer.jsp" %>