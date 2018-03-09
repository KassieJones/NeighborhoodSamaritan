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
<h1>User Info</h1>
<div>
User Name: ${user.username}<br>
Name: ${user.firstName}${user.lastName}<br>
Email: ${user.email}<br>
Phone Number: ${user.phone}<br>
Address: ${user.address} ${user.city}, MI<br>

</div>

</body>
</html>