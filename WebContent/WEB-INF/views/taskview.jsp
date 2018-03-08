<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Favicon -->
<link rel="shortcut icon" href="https://files.slack.com/files-pri/T04UPFZ31-F9KERJV0T/finalprojecticon.png" />
  <style>
      #map {
        height: 400px;
        width: 100%;
       }
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task View</title>
</head>
<body>
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
</body>
</html>