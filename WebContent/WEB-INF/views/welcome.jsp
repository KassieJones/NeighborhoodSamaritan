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
	<div class="container">
	    <label for="uName"><b>User Name</b></label><br>
		<input type="text" placeholder="Enter User Name" name="uName" required><br>
		
		<label for="password"><b>Password</b></label><br>
		<input type="text" placeholder="Enter Password" name="password" required><br><br>
		
		<input type="submit" value="Sign-In">
		
		</div>
	</form>
	
	<h5>No account? <a href="http://localhost:8080/NeighborhoodSamaritan/registration">Sign Up!</a></h5>
	
${message}
</body>
</html>