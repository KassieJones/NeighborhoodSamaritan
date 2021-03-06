<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Results</title>

<link rel="stylesheet" type="text/css" href="styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Favicon -->
<link rel="shortcut icon"
	href="https://files.slack.com/files-pri/T04UPFZ31-F9KERJV0T/finalprojecticon.png" />

<style>
body {
	background-color: #000816;
}

h1 {
	color: #fff575;
	text-align: center;
	font-family: georgia;
}

h2 {
	color: white;
	background-color: #00798C;
	opacity: .85;
}

h3 {
	color: white;
	font-family: arial;
}

h5 {
	color: white;
}

a {
	color: #D1495B;
}

p {
	color: white;
}

#container {
	border: 0px solid;
	max-width: 840px;
	padding-left: 50px;
	padding-right: 50px;
	margin: auto;
	display: block;
	overflow-x: hidden;
}

#header {
	top: 0px;
	left: 0px;
	position: fixed;
	color: #ffe375;
	background-image:
		url("https://image.freepik.com/free-vector/abstract-dark-blue-polygonal-background_1035-9700.jpg");
	height: 150px;
	width: 100%;
	z-index: 1;
	text-align: center;
	display: block;
}

#content {
	text-align: center;
	width: 100%;
	background-color: #EDAE49;
	overflow-x: hidden;
	clear: both;
	border: 1px solid;
	margin-top: 50px;
	width: 100%;
}
</style>
</head>
<body>
	<div id="container">
		<div id="header">
			<br>
			<h1>HOOD SAMARITAN</h1>
			<h2>Volunteer  |  Donate  |  Support</h2>
			<br>
		</div>

		<div id="content">
			<br> <br> <br> <br> <br>
			<h2>Task Opportunity Results</h2>
			<br>

			<table border="1" align="center">
				<tr>
					<th>Host</th>
					<th>Title</th>
					<th>Date</th>
					<th>Time (Military Time)</th>
					<th>Task Length (Hrs)</th>
					<th>City</th>
					<th>ID</th>
					<th>  </th>
				</tr>

				<c:forEach var="myVar" items="${localList}">

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

<br><br>
<h2>Volunteer Here</h2>
<br>

	<form action="send" method="post">
Enter Task ID for Volunteer Opportunity:<br> <input type="text" name="id"><br>
Confirm Your Email:<br> <input type="text" name="doerEmail"><br>
Confirm Your Phone Number:<br> <input type="text" name="doerPhone"><br>
Enter Your Preferred Charity:<br> <input type="text" name="charityPref"><br>
		<input type="submit" value="Submit Request">
	</form>
			<br> <br>
			<form action="mainmenu.html">
				<input type="submit" value="Return" />
			</form>
			<br>
			<br>
		</div>

	</div>


<script>
function myFunction() {
	//need to add a phone number contact info to register page, map/link to here.  Don't show above

    alert("Thank you so much! You are truly your brother's keeper. Your contact information has been sent to the host to contact you and arrange the details of your opportunity,");
}
</script>
</body>
</html>

