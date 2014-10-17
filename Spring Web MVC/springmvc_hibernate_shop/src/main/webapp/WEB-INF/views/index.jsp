<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Mongo Shop</title>
	<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Signika:400,700|Norican' rel='stylesheet' type='text/css' />
	<script src="resources/js/jquery-1.7.2.min.js"></script>
	<script src="resources/js/jquery.menu.pack.js"></script>
	<script src="resources/js/jquery.asyncslider.min.js"></script>
	<script src="resources/js/jquery.easing.1.3.js"></script>
	<script src="resources/js/jcarousellite_1.0.1.min.js"></script>
	<script src="resources/js/hover.zoom.js"></script>
	<script src="resources/js/settings-home.js"></script>
	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
</head>
<body>

	<!-- HEADER START -->
		<jsp:include page="header.jsp" />
	<!-- HEADER END -->

<!-- MAIN CONTENT START -->

	<section class="main wrapper">
	
		<section class="banner">
			<ul class="slider">
				<li>
					<img src="resources/images/banner1.jpg" width="900" height="470" alt="" />
					<div class="slider-content">
						<h2>Awesome Store Theme!</h2>
						<ul>
							<li>10 different pages</li>
							<li>Built in HTML5 & CSS3</li>
							<li>Plenty of jQuery plugins</li>
							<li>Tested on all modern browsers</li>
							<li>Working perfectly on mobile devices</li>
							<li>Only Google web fonts</li>
							<li>Multi-place Google Map</li>
							<li>Twitter Feed</li>
						</ul>
					</div>
					<h3><span>from only</span>&euro;199.90</h3>
					<h4>-15%</h4>
				</li>
				<li>
					<img src="resources/images/banner2.jpg" width="900" height="470" alt="" />
					<div class="slider-content">
						<h2>Loads of jQuery Plugins!</h2>
						<ul>
							<li>Async Slider for the main banner</li>
							<li>Carousel for the featured offers</li>
							<li>Zoom Hover Effect for the photos</li>
							<li>Dropdown menu for touch screens</li>
							<li>Tabs</li>
							<li>Accordions</li>
						</ul>
					</div>
					<h3><span>from only</span>&euro;229.90</h3>
					<h4>-25%</h4>
				</li>
				<li>
					<img src="resources/images/banner3.jpg" width="900" height="470" alt="" />
					<div class="slider-content">
						<h2>Lot of Useful Styles!</h2>
						<ul>
							<li>All typography styles</li>
							<li>3 different table style</li>
							<li>12 different button styles</li>
							<li>Pricing table styles</li>
							<li>Form element styles</li>
							<li>Google Map markers</li>
						</ul>
					</div>
					<h3><span>from only</span>&euro;99.90</h3>
					<h4>-30%</h4>
				</li>
			</ul>
			<div class="slideNav"></div>
		</section><!-- .banner end -->
		
		<section class="featured-products">
			<h2><span>Featured Products</span></h2>
			<button class="prev">Prev</button>
			<button class="next">Next</button>
			<div class="carousel">
				<ul>
					<li>
						<div class="boxgrid">
							<img src="resources/images/featured-product1.jpg" width="190" height="190" alt="Featured Product" />
							<h3>Product name, brand and model goes here</h3>
							<a href="#" class="more">More Info</a>
							<a href="#" class="buy">Add to Cart</a>
						</div>
						<p>&euro;199.90</p>
					</li>
					<li>
						<div class="boxgrid">
							<img src="resources/images/featured-product2.jpg" width="190" height="190" alt="Featured Product" />
							<h3>Product name, brand and model goes here</h3>
							<a href="#" class="more">More Info</a>
							<a href="#" class="buy">Add to Cart</a>
						</div>
						<p>&euro;199.90</p>
					</li>
					<li>
						<div class="boxgrid">
							<img src="resources/images/featured-product3.jpg" width="190" height="190" alt="Featured Product" />
							<h3>Product name, brand and model goes here</h3>
							<a href="#" class="more">More Info</a>
							<a href="#" class="buy">Add to Cart</a>
						</div>
						<p>&euro;199.90</p>
					</li>
					<li>
						<div class="boxgrid">
							<img src="resources/images/featured-product4.jpg" width="190" height="190" alt="Featured Product" />
							<h3>Product name, brand and model goes here</h3>
							<a href="#" class="more">More Info</a>
							<a href="#" class="buy">Add to Cart</a>
						</div>
						<p>&euro;199.90</p>
					</li>
				</ul>
			</div>
		</section><!-- .featured-products end -->
		
		<section class="latest-products">
			<h2><span>Latest Products</span></h2>
			<ul>
				<li>
					<div class="zoom-image"><a href="#" class="zoom"><img src="resources/images/latest-product1.jpg" alt="Latest Product" /></a></div>
					<h3><a href="#">Product name, brand and model goes here</a></h3>
					<p>&euro;199.90</p>
					<p class="button"><a href="#" class="buy">Add to Cart</a></p>
				</li>
				<li>
					<div class="zoom-image"><a href="#" class="zoom"><img src="resources/images/latest-product2.jpg" alt="Latest Product" /></a></div>
					<h3><a href="#">Product name, brand and model goes here</a></h3>
					<p>&euro;199.90</p>
					<p class="button"><a href="#" class="buy">Add to Cart</a></p>
				</li>
				<li>
					<div class="zoom-image"><a href="#" class="zoom"><img src="resources/images/latest-product3.jpg" alt="Latest Product" /></a></div>
					<h3><a href="#">Product name, brand and model goes here</a></h3>
					<p>&euro;199.90</p>
					<p class="button"><a href="#" class="buy">Add to Cart</a></p>
				</li>
				<li>
					<div class="zoom-image"><a href="#" class="zoom"><img src="resources/images/latest-product4.jpg" alt="Latest Product" /></a></div>
					<h3><a href="#">Product name, brand and model goes here</a></h3>
					<p>&euro;199.90</p>
					<p class="button"><a href="#" class="buy">Add to Cart</a></p>
				</li>
				<li>
					<div class="zoom-image"><a href="#" class="zoom"><img src="resources/images/latest-product5.jpg" alt="Latest Product" /></a></div>
					<h3><a href="#">Product name, brand and model goes here</a></h3>
					<p>&euro;199.90</p>
					<p class="button"><a href="#" class="buy">Add to Cart</a></p>
				</li>
				<li>
					<div class="zoom-image"><a href="#" class="zoom"><img src="resources/images/latest-product6.jpg" alt="Latest Product" /></a></div>
					<h3><a href="#">Product name, brand and model goes here</a></h3>
					<p>&euro;199.90</p>
					<p class="button"><a href="#" class="buy">Add to Cart</a></p>
				</li>
			</ul>
			<div class="clear"></div>
		</section><!-- .latest-products end -->
		
	</section><!-- .main end -->

<!-- MAIN CONTENT END -->

<!-- FOOTER START -->
<jsp:include page="footer.jsp" />
<!-- FOOTER END -->


</body>
</html>