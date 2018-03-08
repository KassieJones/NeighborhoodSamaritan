<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>View Task</title>

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
	text-align: center; width : 100%;
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
			<h2>Engage | Donate | Inspire</h2>
			<br>
		</div>

		<div id="content">
			<br> <br> <br> <br> <br>
	<h3>Title</h3>

	<p>Date</p>
	<p>Time</p>
	<p>Location</p>
	<p>Estimated Length of Task</p>
	<p>Required Skills</p>
	

	<form action="taskaccepted.html">
		<input type="submit" value="Volunteer" />
	</form>
	<br>
	<form action="mainmenu.html">
		<input type="submit" value="Return" />
	</form>
		<div id="map"></div>

	    <script>
	 
      function initMap() {
    	var taskMarker = {lat: 44.5752311, lng: -84.1244802};
        var uluru = {lat: 42.335911, lng: -83.0497};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 9,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: taskMarker,
          map: map
        });
      }
    </script>
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key= AIzaSyC4K4nnt7VvrmV17Fmw6SGVGQKurHtVCqs&callback=initMap">
    </script>
   <!-- https://maps.googleapis.com/maps/api/geocode/json?address=####+street,+city,+mi&key=AIzaSyC4K4nnt7VvrmV17Fmw6SGVGQKurHtVCqs -->
</div>
</div>
</body>
</html>