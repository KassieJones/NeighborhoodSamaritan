<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>

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
			<br> <br> <br> <br> <br><br>


	<div style="text-align: center">

		<h2>Register!</h2>
<br>
	</div>

	<div class="container">
	
	<form action="registrationsuccess" method="post">
	<!-- <input type="hidden" name="id" value="${userId}"> -->
	    <label for="uName"><b>User Name</b></label><br>
		<input type="text" placeholder="Enter User Name" name="username" required><br>
		
		<label for="eMail"><b>Email</b></label><br>
		<input type="text" placeholder="Enter Email" name="email" required><br>
		
		<label for="password"><b>Password</b></label><br>
		<input type="password" placeholder="Enter Password" name="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"><br>
		
		<label for="password"><b>Confirm Password</b></label><br>
		<input type="password" placeholder="Confirm Password" name="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"><br>
		
		<label for="fName"><b>First Name</b></label><br>
		<input type="text" placeholder="Enter First Name" name="firstName" required><br>
		
		<label for="lName"><b>Last Name</b></label><br>
		<input type="text" placeholder="Enter Last Name" name="lastName" required><br>
		
		<label for="address"><b>Address</b></label><br>
		<input type="text" placeholder="Enter Address" name="address" required><br>
		
		<label for="city"><b>City</b></label><br>
		<input type="text" placeholder="Enter City" name="city" required><br>
		
		 <label for="pNumber"><b>Phone Number</b></label><br>
		<input type="text" placeholder="Enter Phone Number" name="phone" required><br><br>
		
		<label for="charityPref"><b>Preferred Charity</b></label><br>
		<input type="text" placeholder="Enter a Charity Name" name="charityPref" required><br><br>

		
		<input type="submit" value="Register">
		
		</form>
		</div>
</div>
<!-- ${registration }

<script type="text/javascript">
var x = document.querySelectorAll("input");
console.log(x);
function validate(){
	if(validateName() && validateNumber() && validatePassword() && validateEmail()){
		return true;
	} else {
		return false;
	}
	
}
function validateEmail() {
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(x[2].value)) {
    return true;
  } else {
    alert("You have entered an invalid email address!")
    return false;
}
}
function validatePassword(){
	if(x[5].value !== x[4].value){
		alert("Error! Passwords do not match");
		return false;
	} else{
		return true;
	}
}
	 
function validateName() {
    if (x[0].textLength > 2 && x[1].textLength > 2) {
    		return true;
    } else{
	       alert("First and last name must be more than two letters");
	       return false;
    }
    
} 
function validateNumber(){
	var phoneno = /^\d{10}$/;
	var phoneno2 = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
	if(x[3].value.match(phoneno)||(x[3].value.match(phoneno2))){
	      return true;
	      } else {
	      alert("Error: Invalid phone number");
	      return false;
	        }
	}
</script>
-->
</body>
</html>