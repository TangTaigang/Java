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
	<title>View Contact Post</title>
	<!--[if lt IE 9]><script src="./js/html5shiv.js"></script><![endif]-->
	<script src="resources/js/jquery-1.7.2.min.js"></script>
	<script src="resources/js/jquery-ui-1.8.21.custom.min.js"></script>
	<script src="resources/js/jquery.menu.pack.js"></script>
	<script src="resources/js/hover.zoom.js"></script>
	<script src="resources/js/settings-inner.js"></script>
</head>
<body>
<!-- HEADER START -->
	<jsp:include page="../header.jsp" />
<!-- HEADER END -->
<!-- MAIN CONTENT START -->
	<section class="main wrapper">
	<article>
			<h1>Admin page !</h1>
			<section class="accordion">
				<h3><a href="#">Lorem ipsum dolor sit amet</a></h3>
				<div>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus molestie turpis 
					et purus auctor ac adipiscing sapien volutpat. Vivamus vitae augue mi. Sed quis 
					leo neque, ac egestas sapien. Mauris ornare, mauris dignissim varius vestibulum, 
					sapien lectus sollicitudin velit, at ultrices erat libero adipiscing metus. Fusce 
					bibendum dolor vitae odio convallis vestibulum. Nunc a orci nibh, in tempus massa.</p>
				</div>
				<h3><a href="#">Curabitur feugiat</a></h3>
				<div>
					<p>Curabitur feugiat mi at ipsum molestie id auctor massa porttitor. Curabitur 
					vehicula arcu eu eros tincidunt accumsan. Class aptent taciti sociosqu ad litora 
					torquent per conubia nostra, per inceptos himenaeos. Aliquam erat volutpat. Nunc 
					velit nulla, mollis in iaculis id, pharetra eu arcu. Vestibulum ac mauris mauris, 
					eu blandit nibh.</p>
				</div>

			</section>
	</article>
		
		<div class="clear"></div>

	</section><!-- .main end -->

<!-- MAIN CONTENT END -->
<!-- FOOTER START -->
<jsp:include page="../footer.jsp" />
<!-- FOOTER END -->
</body>
</html>