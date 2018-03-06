<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tast View</title>
</head>
<body>
	<h3>Title</h3>
	<p>insert map</p>

	<p>Date</p>
	<p>Time</p>
	<p>Location</p>
	<p>Estimated Length of Task</p>
	<p>Required Skills</p>
	<div id="map"></div>

	<form action="taskaccepted.html">
		<input type="submit" value="Volunteer" />
	</form>
	<br>
	<form action="mainmenu.html">
		<input type="submit" value="Return" />
	</form>
	<script>
      function initMap() {
        var uluru = {lat: 42.335911, lng: -83.0497};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 9,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
    </script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC4K4nnt7VvrmV17Fmw6SGVGQKurHtVCqs&callback=initMap">
    </script>
</body>
</html>