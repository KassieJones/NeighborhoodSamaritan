<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
</head>
<body>
<div id="content">
			<br> <br> <br> <br> <br>
			<h3>User Info</h3>
			<br>

			<table border="1" align="center">
				<tr>
					<th>User Name</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Address</th>
					<th>Hours Donated</th>
				
					<th></th>
				</tr>
				User Name:
				Name:
				Email:
				Phone:
				Address:
				Hours Donated

				<c:forEach var="myVar" items="${taskList}">

					<tr>
						<td>${myVar.usernameHost}</td>
						<td>${myVar.title}</td>
						<td>${myVar.date}</td>
						<td>${myVar.time}</td>
						<td>${myVar.estimatedTime}</td>
						<td>${myVar.city}</td>
						<td>${myVar.id}</td>
					</tr>
				</c:forEach>
			</table>

</body>
</html>