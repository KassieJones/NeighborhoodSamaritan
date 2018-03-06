<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Favicon -->
<link rel="shortcut icon" href="https://files.slack.com/files-pri/T04UPFZ31-F9KERJV0T/finalprojecticon.png" />
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