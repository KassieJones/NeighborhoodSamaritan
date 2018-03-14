<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Favicon -->
<link rel="shortcut icon"
	href="https://files.slack.com/files-pri/T04UPFZ31-F9KERJV0T/finalprojecticon.png" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div style="text-align: center">
		<h1>Register!</h1>

	</div>


	<div class="container">
	<form action="registrationsuccess" method="post">
		<input type="hidden" name="id" value="${userId}">
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

${registration }

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

</body>
</html>