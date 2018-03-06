<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success!</title>
</head>
<body>
<h3>Post a New Request</h3>
<br>
<p>Please enter the information associated with your request.</p>
<br>
	<form action="insertnewpagenamehere" method="post">
		Title: <input type="text" name="taskTitle"><br>
		Date: <input type="text" name="taskDate"><br>
		Time: <input type="text" name="taskTime"><br>
		Estimated Job Length: <input type="text" name="taskLength"><br>
		Required Skills: <input type="text" name="taskSkills"><br>
		<input type="submit" value="Submit Request">
	</form>
</body>
</html>