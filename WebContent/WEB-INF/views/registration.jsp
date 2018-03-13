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
<div style="text-align: center">
<h1>Register!</h1>		
</div>


	<form action="registrationsuccess" method="post">
	<div class="container">

	    <label for="uName"><b>User Name</b></label><br>
		<input type="text" placeholder="Enter User Name" name="username" required><br>
		
		<label for="eMail"><b>Email</b></label><br>
		<input type="text" placeholder="Enter Email" name="email"><br>
		
		<label for="password"><b>Password</b></label><br>
		<input type="password" placeholder="Enter Password" name="password" required><br>
		
		<label for="password"><b>Confirm Password</b></label><br>
		<input type="password" placeholder="Confirm Password" name="password" required><br>
		
		<label for="fName"><b>First Name</b></label><br>
		<input type="text" placeholder="Enter First Name" name="firstName" required><br>
		
		<label for="lName"><b>Last Name</b></label><br>
		<input type="text" placeholder="Enter Last Name" name="lastName" required><br>
		
		<label for="address"><b>Address</b></label><br>
		<input type="text" placeholder="Enter Address" name="address" required><br>
		
		<label for="city"><b>City</b></label><br>
		<input type="text" placeholder="Enter City" name="city" required><br>
		
		 <label for="pNumber"><b>Phone Number</b></label><br>
		<input type="text" placeholder="Enter Phone Number" name="phone" required><br>
		
		<label for="charityPref"><b>Preferred Charity</b></label><br>
		<input type="text" placeholder="Enter a Charity Name" name="charityPref" required><br><br>
		
		<input type="submit" value="Register">
		
		</div>

	</form>
${registration }
</body>
</html>