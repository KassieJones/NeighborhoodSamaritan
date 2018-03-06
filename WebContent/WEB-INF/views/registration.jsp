<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Favicon -->
<link rel="shortcut icon" href="https://files.slack.com/files-pri/T04UPFZ31-F9KERJV0T/finalprojecticon.png" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h1>Register!</h1>
	<form action="mainmenu" method="post">
		User Name: <input type="text" name="uName"><br>
		E-mail: <input type="text" name="eMail"><br>
		Password: <input type="password" name="password"><br>
		Confirm Password: <input type="password" name="password"><br>
		First Name: <input type="text" name="fName"><br>
		Last Name: <input type="text" name="lName"><br>
		City: <input type="text" name="city"><br>
		Phone Number: <input type="text" name="pNumber"><br>
		<input type="submit" value="Sign-Up!">
	</form>
	
	<form action="mainmenu" method="post">
	<div class="container">
	    <label for="uName"><b>User Name</b></label><br>
		<input type="text" placeholder="Enter User Name" name="uName" required><br>
		
		<label for="eMail"><b>Email</b></label><br>
		<input type="text" placeholder="Enter Email" name="eMail"><br>
		
		<label for="password"><b>Password</b></label><br>
		<input type="text" placeholder="Enter Password" name="password" required><br><br>
		
		<input type="submit" value="Sign-In">
		
		</div>
	</form>

</body>
</html>