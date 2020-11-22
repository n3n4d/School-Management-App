<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit group</title>
		<%@ include file="include/header.jsp" %>
		<br> <br>
		<div class="row">
			<div class="col col-md-6">
				<form:form name='f' action='${pageContext.request.contextPath}/updateGroup' method='POST' modelAttribute="group">
					<form:hidden path="groupID"/>
					<form:hidden path="numberOfStudents" value="${group.numberOfStudents}"/>
					<c:if test="${param.error_daytime != null}">
						<span class="error">Selected classroom is ocupied at selected time and day.</span>
						<br>
						<br>
					</c:if>
					<c:if test="${param.error_capacity != null}">
						<span class="error">This group is too big for the selected classroom.</span>
						<br>
						<br>
					</c:if>
					<label for="groupName">Group name:</label> 
					<form:input path="groupName" class="form-control"
						id="groupName" type='text' name='groupName' value='' required="true"/><br>
					<label for="classroomID">Classroom:</label> 
					<form:select path="classroomID" name='classroomID' class="form-control" id="classroomSelect">
						<option value="0">None</option>
					    <c:forEach var="classroom" items="${classrooms}">
					      	<c:choose>
		    					<c:when test="${group.classroomID == classroom.classroomID}">
		    						<option value="${classroom.classroomID}" selected>${classroom.classroomName}</option>
		    					</c:when>    
		    				    <c:otherwise>
		    				    	<option value="${classroom.classroomID}">${classroom.classroomName}</option>
		    					</c:otherwise>
							</c:choose> 
					    </c:forEach>
				    </form:select><br>
				    <label for="teacherID">Teacher:</label> 
					<form:select path="teacherID" name='teacherID' class="form-control" id="teacherSelect">
						<option value="0">None</option>
					    <c:forEach var="teacher" items="${teachers}">
					      	<c:choose>
		    					<c:when test="${group.teacherID == teacher.teacherID}">
		    						<option value="${teacher.teacherID}" selected>${teacher.firstName} ${teacher.lastName}</option>
		    					</c:when>    
		    				    <c:otherwise>
		    				    	<option value="${teacher.teacherID}">${teacher.firstName} ${teacher.lastName}</option>
		    					</c:otherwise>
							</c:choose> 
					    </c:forEach>
				    </form:select><br>
					<label for="day">Day:</label> 
					<form:select path="day" name='day' class="form-control" id="day">
		    				   <option value="Monday">Monday</option>
		    				   <option value="Tuesday">Tuesday</option>
		    				   <option value="Wednesday">Wednesday</option>
		    				   <option value="Thursday">Thursday</option>
		    				   <option value="Friday">Friday</option>
		    				   <option value="Saturay">Saturday</option>
		    				   <option value="Sunday">Sunday</option>		
				    </form:select><br>
					<label for="day">Day:</label> 
					<form:select path="time" name='time' class="form-control" id="time">
		    				   <option value="10AM">10AM</option>
		    				   <option value="12PM">12PM</option>
		    				   <option value="2PM">2PM</option>
		    				   <option value="4PM">4PM</option>
		    				   <option value="6PM">6PM</option>		
				    </form:select><br>
					<input name="submit" type="submit" value="Save changes"
						class="btn btn-primary" />
					<input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form:form>
			</div>
		</div>

	</div>
	<%@ include file="include/footer.jsp" %>