<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/jquery.ui.tabs.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Signika:400,700|Norican' rel='stylesheet' type='text/css' />
	<title>Contact</title>
	<!--[if lt IE 9]><script src="./js/html5shiv.js"></script><![endif]-->
	<script src="resources/js/jquery-1.7.2.min.js"></script>
	<script src="resources/js/jquery-ui-1.8.21.custom.min.js"></script>
	<script src="resources/js/jquery.menu.pack.js"></script>
	<script src="resources/js/hover.zoom.js"></script>
	<script src="resources/js/settings-inner.js"></script>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=true"></script>
	<script type="text/javascript">
	  function initialize() {
		  var mapOptions = {
			zoom: 3,
			center: new google.maps.LatLng(46.3,-32.4),
			mapTypeId: google.maps.MapTypeId.ROADMAP
		  }
		  var map = new google.maps.Map(document.getElementById("map_canvas"),
										mapOptions);
		
		  setMarkers(map, shops);
		}
		
		/**
		 * Data for the markers consisting of a name, a LatLng and a zIndex for
		 * the order in which these markers should display on top of each
		 * other.
		 */
		var shops = [
		  ['Dublin', 53.344601,-6.259712, 1],
		  ['New York', 40.759473,-73.976304, 2],
		  ['Warsaw', 52.231131,21.013802, 3]
		];
		
		function setMarkers(map, locations) {
		  // Add markers to the map
		
		  // Marker sizes are expressed as a Size of X,Y
		  // where the origin of the image (0,0) is located
		  // in the top left of the image.
		
		  // Origins, anchor positions and coordinates of the marker
		  // increase in the X direction to the right and in
		  // the Y direction down.
		  var image = new google.maps.MarkerImage('resources/images/marker.png',
			  // This marker is 20 pixels wide by 32 pixels tall.
			  new google.maps.Size(21, 24),
			  // The origin for this image is 0,0.
			  new google.maps.Point(0,0),
			  // The anchor for this image is the base of the flagpole at 0,32.
			  new google.maps.Point(0, 24));
		  var shadow = new google.maps.MarkerImage('resources/images/marker-shadow.png',
			  // The shadow image is larger in the horizontal dimension
			  // while the position and offset are the same as for the main image.
			  new google.maps.Size(32, 12),
			  new google.maps.Point(0,0),
			  new google.maps.Point(0, 12));
			  // Shapes define the clickable region of the icon.
			  // The type defines an HTML <area> element 'poly' which
			  // traces out a polygon as a series of X,Y points. The final
			  // coordinate closes the poly by connecting to the first
			  // coordinate.
		  var shape = {
			  coord: [1, 1, 1, 20, 18, 20, 18 , 1],
			  type: 'poly'
		  };
		  for (var i = 0; i < locations.length; i++) {
			var shop = locations[i];
			var myLatLng = new google.maps.LatLng(shop[1], shop[2]);
			var marker = new google.maps.Marker({
				position: myLatLng,
				map: map,
				shadow: shadow,
				icon: image,
				shape: shape,
				title: shop[0],
				zIndex: shop[3]
			});
		  }
		}
	
	</script>
	
</head>
<body  onload="initialize()">
<!-- HEADER START -->
	<jsp:include page="header.jsp" />
<!-- HEADER END -->
<!-- MAIN CONTENT START -->
	<section class="main wrapper">
		<section class="map">
			<div id="map_canvas" style="width:100%; height:100%"></div>
		</section>
		<article class="contact">
			<h2>Contact Form</h2>
				<form:form modelAttribute="contact">
				<dl>
					<dt><label for="firstname">First name:</label></dt>
					<dd><form:input path="firstName" id="firstname" placeholder="John" required="true"/></dd>
					<dt><label for="surname">Surname:</label></dt>
					<dd><form:input path="lastName"  id="surname" placeholder="Doe" required="true"/></dd>
					<dt><label for="email">Email:</label></dt>
					<dd><form:input path="email" type="email" id="email" placeholder="john.doe@email.com" required="true" /></dd>
					<dt><label for="phone">Phone:</label></dt>
					<dd><form:input type="tel" path="phone" id="phone" placeholder="+353 1 9876 543" /></dd>
					<dt><label for="subject">Subject:</label></dt>
					<dd><form:select path="contact_subject" name="Subject" id="subject" items="${contact_subject}">	</form:select></dd>
					<dt><label for="message">Message</label></dt>
					<dd><form:textarea path="user_message" id="message" placeholder="Your message here" ></form:textarea></dd>
					<dt></dt>
					<dd><input type="submit" class="red" value="Submit" /></dd>
				</dl>
				</form:form>	
				<spring:hasBindErrors name="contact">
				<div class="error">
					<spring:bind path="contact.*">
						<c:forEach items="${status.errorMessages}" var="error">
							<h6><a href="#"><c:out value="${error}"/></a></h6>
						</c:forEach>
					</spring:bind>
				</div>
			</spring:hasBindErrors>	
		<h6>Quote</h6>
			<blockquote>We'll keep in touch with you soon.</blockquote>
		</article>
		<jsp:include page="shop_info.jsp" />
		
		<div class="clear"></div>

	</section><!-- .main end -->

<!-- MAIN CONTENT END -->
<!-- FOOTER START -->
<jsp:include page="footer.jsp" />
<!-- FOOTER END -->
</body>
</html>