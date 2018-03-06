<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<h1>Welcome!</h1>
	<form action="mainmenu" method="post">
		User Name: <input type="text" name="uName" required><br>
		Password: <input type="text" name="password" required><br>
		<input type="submit" value="Sign-In">
	</form>
	<a href="http://localhost:8080/NeighborhoodSamaritan/registration">Sign Up!</a>
	
${message}
</body>
</html>