<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students</title>
</head>
<body>
<font color="red">${error }</font>
	<form:form method="post" modelAttribute="student">
		<table>
			<tr>
				<td><form:label path="id">ID</form:label></td>
				<td><form:input type="text" path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="marks">Marks</form:label></td>
				<td><form:input type="text" path="marks" /></td>
			</tr>
			<tr>
			<td><input type="submit" value="Insert Record"></td>
			<td><input type="reset"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>