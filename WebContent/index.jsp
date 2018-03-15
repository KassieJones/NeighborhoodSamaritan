<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome to Hood Samaritan</title>

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
			<p>Hood Samaritan is a connection hub for those wanting to devote
				their time and skills to others within their community who have
				needs to be filled. The goal is to promote community altruism and
				engagement.</p>

			<p>Have you ever needed some help around the house or with a
				project, but didn't have the resources to hire a professional
				company? Have you ever seen needs in your neighborhood that you just
				knew you had the skills to fill but didn't know how to start? Hood
				Samaritan is looking to bridge that gap between the community and
				the individual. There is no catch, no fine print, and no gimmicks.
				To further the altruistic nature of the program, you now have the
				ability to donate to hundreds of 501(3) charities as a way to
				pay-it-forward after a member donates their time to helping you with
				a project.</p>

			<h3>Are you ready to get started impacting and growing your
				community? Click below to register or log in!</h3>

			<h5>
				Please <a href="registration.html">register</a> or <a
					href="welcome.html">sign in</a> to access the community! <br>
				<br>
			</h5>
		</div>

	</div>
<!-- START OF GOOGLE OAUTH CODE
	<script>
  var GoogleAuth;
  var SCOPE = 'https://www.googleapis.com/auth/userinfo.profile';
  function handleClientLoad() {
	  console.log("Started handleClientLoad")
    // Load the API's client and auth2 modules.
    // Call the initClient function after the modules load.
    gapi.load('client:auth2', initClient);
  }
  

  function initClient() {
	  console.log("Started initClient")
    // Retrieve the discovery document for version 3 of Google Drive API.
    // In practice, your app can retrieve one or more discovery documents.
    var discoveryUrl = 'https://www.googleapis.com/discovery/v1/apis/drive/v3/rest';

    // Initialize the gapi.client object, which app uses to make API requests.
    // Get API key and client ID from API Console.
    // 'scope' field specifies space-delimited list of access scopes.
    gapi.client.init({
        'apiKey': 'AIzaSyC4K4nnt7VvrmV17Fmw6SGVGQKurHtVCqs',
        'discoveryDocs': [discoveryUrl],
        'clientId': '906447998108-t1r626ppoae98keduj4sjbfdto9gb8rr.apps.googleusercontent.com',
        //'redirect_uri':'http://localhost:8080/NeighborhoodSamaritan/mainmenu/',
        //'ux_mode':'redirect',
        'scope': SCOPE
    }).then(function () {
    	console.log("Started function")
      GoogleAuth = gapi.auth2.getAuthInstance();

      // Listen for sign-in state changes.
      GoogleAuth.isSignedIn.listen(updateSigninStatus);

      // Handle initial sign-in state. (Determine if user is already signed in.)
      var user = GoogleAuth.currentUser.get();
     
      setSigninStatus();

      // Call handleAuthClick function when user clicks on
      //      "Sign In/Authorize" button.
      $('#sign-in-or-out-button').click(function() {
        handleAuthClick();
      }); 
      $('#revoke-access-button').click(function() {
        revokeAccess();
      }); 
    },function(error){
    	console.log(error);
    });
  }

  function handleAuthClick() {
    if (GoogleAuth.isSignedIn.get()) {
   
      // User is authorized and has clicked 'Sign out' button.
      GoogleAuth.signOut();
    } else {
    	
      // User is not signed in. Start Google auth flow.
      GoogleAuth.signIn();
    }
  }

  function revokeAccess() {
    GoogleAuth.disconnect();
  }

  function setSigninStatus(isSignedIn) {
	  
    var user = GoogleAuth.currentUser.get();
    var isAuthorized = user.hasGrantedScopes(SCOPE);
    console.log(user.getAuthResponse().id_token);
    var idToken = user.getAuthResponse().id_token;
    
   // console.log(userId);
    if (isAuthorized) {  

    	var userId = user.getBasicProfile().getId();
    	
    
      $('#sign-in-or-out-button').html('Sign out');
      $('#revoke-access-button').css('display', 'inline-block');
      $('#auth-status').html('You are currently signed in and have granted ' +
          'access to this app.');
      //var id_token = currentUser.getAuthResponse().id_token;
      window.location.href = "http://localhost:8080/NeighborhoodSamaritan/mainmenu?idToken="+idToken+"&userId="+userId;
     console.log(user);
    } else {
      $('#sign-in-or-out-button').html('Sign In/Authorize');
      $('#revoke-access-button').css('display', 'none');
      $('#auth-status').html('You have not authorized this app or you are ' +
          'signed out.');
    }
  }

  function updateSigninStatus(isSignedIn) {
    setSigninStatus();
  }
</script>

<button id="sign-in-or-out-button"
        style="margin-left: 25px">Sign In/Authorize</button>
<button id="revoke-access-button"
        style="display: none; margin-left: 25px">Revoke access</button>

<div id="auth-status" style="display: inline; padding-left: 25px"></div><hr>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script async defer src="https://apis.google.com/js/api.js" onload="this.onload=function(){};handleClientLoad()"
	onreadystatechange="if (this.readyState === 'complete') this.onload()">
</script> -->
</body>
</html>