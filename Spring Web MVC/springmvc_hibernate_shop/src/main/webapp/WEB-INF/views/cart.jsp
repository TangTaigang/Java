<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Mongo Shop</title>
	
	<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Signika:400,700|Norican' rel='stylesheet' type='text/css' />
	<script src="resources/js/jquery-1.7.2.min.js"></script>
	<script src="resources/js/jquery-ui-1.8.21.custom.min.js"></script>
	<script src="resources/js/jquery.menu.pack.js"></script>
	<script src="resources/js/hover.zoom.js"></script>
	<script src="resources/js/settings-inner.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
</head>
<body>

<!-- HEADER START -->
	<jsp:include page="header.jsp" />
<!-- HEADER END -->

<!-- MAIN CONTENT START -->

	<section class="main wrapper">
	
		<article>
			<h1>Shopping Cart</h1>
			<table class="round">
				<tr>
					<th scope="col">Code</th>
					<th scope="col">Name</th>
					<th scope="col">Quantity</th>
					<th scope="col">Unit Price</th>
					<th scope="col">Total</th>
				</tr>
				<tr>
					<td>1</td>
					<td>Spring In Actions</td>
					<td><input type="text" onchange="" size="2" value="1"/></td>
					<td>1000 $</td>
					<td>1000 $</td>
				</tr>
				
			</table>
			<p>&nbsp;</p>
		</article>
		
		<aside>
		
			<section class="categories">
				<h2>About This Theme</h2>
				<div class="accordion">
					<h3><a href="#">Typography</a></h3>
					<div>
						<ul>
							<li><a href="./typography.html">Submenu 1</a></li>
							<li><a href="./typography.html">Submenu 2</a></li>
							<li><a href="./typography.html">Submenu 3</a></li>
						</ul>
					</div>
					<h3><a href="#">Columns &amp; Buttons</a></h3>
					<div>
						<ul>
							<li><a href="./columns.html">Submenu 1</a></li>
							<li><a href="./columns.html">Submenu 2</a></li>
							<li><a href="./columns.html">Submenu 3</a></li>
						</ul>
					</div>
					<h3><a href="#">Tables</a></h3>
					<div>
						<ul>
							<li><a href="./tables.html">Submenu 1</a></li>
							<li><a href="./tables.html">Submenu 2</a></li>
							<li><a href="./tables.html">Submenu 3</a></li>
						</ul>
					</div>
					<h3><a href="#">Pricing Table</a></h3>
					<div>
						<ul>
							<li><a href="./pricing.html">Submenu 1</a></li>
							<li><a href="./pricing.html">Submenu 2</a></li>
							<li><a href="./pricing.html">Submenu 3</a></li>
						</ul>
					</div>
					<h3><a href="#">Tabs &amp; Accordion</a></h3>
					<div>
						<ul>
							<li><a href="./tabs.html">Submenu 1</a></li>
							<li><a href="./tabs.html">Submenu 2</a></li>
							<li><a href="./tabs.html">Submenu 3</a></li>
						</ul>
					</div>
				</div><!-- .accordion end -->
			</section><!-- .categories end -->
			
			<section class="about">
				<h2>About Us</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ac massa nulla, sed laoreet tellus. Proin feugiat rhoncus massa in faucibus. Duis et orci nunc. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
				<p><a href="http://coffeecream.eu/templates/shopshifter-html/about.html" class="more">Read More</a></p>
				<p>&nbsp;</p>
			</section><!-- .about end -->
		
		</aside>
		
		<div class="clear"></div>

	</section><!-- .main end -->

<!-- MAIN CONTENT END -->

<!-- FOOTER START -->
<jsp:include page="footer.jsp" />
<!-- FOOTER END -->

</body>
</html>