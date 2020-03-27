<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students</title>
</head>
<body>
	<font color="green">${message }</font>
	<table>
		<caption>Students</caption>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Marks</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students }" var="student">
				<tr>
					<td>${student.id }</td>
					<td>${student.name }</td>
					<td>${student.marks }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/mvc-student">Click Here For CRUD Operations</a>
</body>
</html>