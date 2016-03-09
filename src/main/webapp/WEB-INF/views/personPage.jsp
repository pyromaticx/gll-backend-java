<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/style.css"
	rel="stylesheet" type="text/css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Go Live Labs</title>
</head>
<body>
	<h1>Person Page</h1>
	<form:form method="post" action="postPerson" modelAttribute="person">
		<table>
			<tr>
				<td>Person Id :</td>
				<td><form:input path="personId" value="${person.personId}"
						readonly="true" /></td>
				<td><form:errors path="personId"></form:errors></td>
			</tr>

			<tr>
				<td>Person Name :</td>
				<td><form:input path="personName" value="${person.personName}" /></td>
				<td><form:errors path="personName"></form:errors></td>
			</tr>

			<tr>
				<td>Email :</td>
				<td><form:input path="email" value="${person.email}" /></td>
				<td><form:errors path="email"></form:errors></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><form:password path="password" value="${person.password}" /></td>
				<td><form:errors path="password"></form:errors></td>
			</tr>

			<tr>
				<td>Birth Day :</td>
				<td><form:input path="birthDay" value="${person.birthDay}" /></td>
				<td><form:errors path="birthDay"></form:errors></td>
			</tr>

			<tr>
				<td>Gender :</td>
				<td><form:select path="gender">
						<form:option value="">Select Gender</form:option>
						<form:options items="${gender}" />
					</form:select></td>
				<td><form:errors path="gender"></form:errors></td>
			</tr>

			<c:forEach items="${person.address}" var="addRec" varStatus="i">
				<tr>
					<td><form:input path="address[${i.index}].addressId" value="${addRec.addressId}" readonly="true" /></td>
					<td><form:errors path="address[${i.index}].addressId"></form:errors></td>

					<td><form:input path="address[${i.index}].line1" value="${addRec.line1}" /></td>
					<td><form:errors path="address[${i.index}].line1"></form:errors></td>
		
					<td><form:input path="address[${i.index}].line2" value="${addRec.line2}" /></td>
					<td><form:errors path="address[${i.index}].line2"></form:errors></td>
		
					<td><form:input path="address[${i.index}].line3" value="${addRec.line3}" /></td>
					<td><form:errors path="address[${i.index}].line3"></form:errors></td>
	
					<td><form:input path="address[${i.index}].city" value="${addRec.city}" /></td>
					<td><form:errors path="address[${i.index}].city"></form:errors></td>

					<td><form:input path="address[${i.index}].province" value="${addRec.province}" /></td>
					<td><form:errors path="address[${i.index}].province"></form:errors></td>
	
					<td><form:input path="address[${i.index}].country" value="${addRec.country}" /></td>
					<td><form:errors path="address[${i.index}].country"></form:errors></td>
	
					<td><form:input path="address[${i.index}].otherDetails" value="${addRec.otherDetails}" /></td>
					<td><form:errors path="address[${i.index}].otherDetails"></form:errors></td>

					<td><form:select path="address[${i.index}].addressType">
							<form:option value="">Select Address Type</form:option>
							<form:option value="History Address">History Address</form:option>
							<form:option value="Current Address">Current Address</form:option>
							<%-- <form:options items="${addRec.addressType}" /> --%>
						</form:select></td>
					<td><form:errors path="address[${i.index}].addressType"></form:errors></td>
				</tr>
			</c:forEach>
			
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
				<td><a href="getPerson"> Display</a></td>
			</tr>
		</table>

	</form:form>


	<h2>List Persons</h2>
	<c:if test="${!empty personRecords}">
		<c:forEach items="${personRecords}" var="pRec">
			<br />
			<br />
			<table>
				<tr>
					<th>Person Id</th>
					<th>Person Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Birth Day</th>
					<th>Gender</th>
					<th>Address</th>
				</tr>
				<tr>
					<td><c:out value="${pRec.personId}" /></td>
					<td><c:out value="${pRec.personName}" /></td>
					<td><c:out value="${pRec.email}" /></td>
					<td><c:out value="${pRec.password}" /></td>
					<td><c:out value="${pRec.birthDay}" /></td>
					<td><c:out value="${pRec.gender}" /></td>
					<td>
						<table>
							<tr>
								<th>Address Id</th>
								<th>Line 1</th>
								<th>Line 2</th>
								<th>Line 3</th>
								<th>City</th>
								<th>Province</th>
								<th>Country</th>
								<th>Other Details</th>
								<th>Address Type</th>
							</tr>
							<c:forEach items="${pRec.address}" var="addRec" varStatus="i">
								<tr>
									<td><c:out value="${addRec.addressId}" /></td>
									<td><c:out value="${addRec.line1}" /></td>
									<td><c:out value="${addRec.line2}" /></td>
									<td><c:out value="${addRec.line3}" /></td>
									<td><c:out value="${addRec.city}" /></td>
									<td><c:out value="${addRec.province}" /></td>
									<td><c:out value="${addRec.country}" /></td>
									<td><c:out value="${addRec.otherDetails}" /></td>
									<td><c:out value="${addRec.addressType}" /></td>
								</tr>
							</c:forEach>
						</table>
					</td>
					<td><a href="putPerson?personId=${pRec.personId}">Edit</a></td>
					<td><a href="deletePerson?personId=${pRec.personId}">Delete</a></td>
				</tr>
			</table>
		</c:forEach>
	</c:if>
</body>
</html>