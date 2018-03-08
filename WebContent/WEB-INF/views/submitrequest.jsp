<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Favicon -->
<link rel="shortcut icon" href="https://files.slack.com/files-pri/T04UPFZ31-F9KERJV0T/finalprojecticon.png" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit a New Request</title>
</head>
<body>
<h3>Submit a New Request</h3>
<br>
<p>Please enter the information associated with your request.</p>
<br>
	<form action="submitsuccess" method="post">
		Title: <input type="text" name="title"><br>
		Username: <input type="text" name="usernameHost"><br>
		Date: <input type="text" name="date"><br>
		Time: <input type="text" name="time"><br>
		Estimated Job Length: <input type="text" name="estimatedTime"><br>
		Required Skills: <input type="text" name="skillsNeeded"><br>
		Address: <input type="text" name="address"><br>
		City: <input type="text" name="city"><br>
		<input type="submit" value="Submit Request">
	</form>
</body>
</html>