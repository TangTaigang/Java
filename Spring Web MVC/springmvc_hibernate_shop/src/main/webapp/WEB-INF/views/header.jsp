<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- HEADER START -->
	<header>
		<div class="wrapper">
			<h1>
				<a href="index">
					MongoDB Shop
					<span>Use Mongo</span>
				</a>
			</h1>
			<nav>
				<ul>
					<li><a href="index">Home</a></li>
					<li class="menumain">About This Theme
						<ul>
							<li><a href="typography.html">Typography</a></li>
							<li><a href="columns.html">Columns &amp; Buttons</a></li>
							<li><a href="tables.html">Tables</a></li>
							<li><a href="pricing.html">Pricing Table</a></li>
							<li><a href="tabs.html">Tabs &amp; Accordion</a></li>
						</ul>
					</li>
					<li class="menumain">Catalog
						<ul>
							<li><a href="./category.html">Category 1</a></li>
							<li><a href="./category.html">Category 2</a></li>
							<li><a href="./category.html">Category 3</a></li>
							<li><a href="./category.html">Category 4</a></li>
						</ul>
					</li>
					<li><a href="review-post">Blog</a></li>
					<li><a href="./contact">Contact Us</a></li>
				</ul>
			</nav>
			
			<section class="cart">
				<ul>
					<li class="cart-title"><a href="cart">Shopping Cart:</a></li>
					<li class="cart-price"><a href="cart">&euro;99.90</a></li>
					<li class="cart-items"><a href="#">8 items</a></li>
					<li class="cart-login"><a href="#">Login</a></li>
				</ul>
			</section><!-- .cart end -->
			
			<section class="social-networks">
				<ul>
					<li><a href="http://facebook.com/coffeecreameu" target="_blank"><img src="resources/images/facebook.png" width="26" height="52" alt="Like me on Facebook" /></a></li>
					<li><a href="http://twitter.com/coffeecreameu" target="_blank"><img src="resources/images/twitter.png" width="26" height="52" alt="Follow me on Twitter" /></a></li>
					<li><a href="http://plus.google.com/111405957653832671873" target="_blank"><img src="resources/images/google.png" width="26" height="52" alt="Add me on Google Plus" /></a></li>
					<li><a href="http://www.linkedin.com/in/banaszek" target="_blank"><img src="resources/images/linkedin.png" width="26" height="52" alt="Find me on LInkedIn" /></a></li>
				</ul>
			</section><!-- .social-networks end -->
			
			<section class="searchbox">
				<form />
					<input type="text" value="Search product" />
					<input type="button" value="Search" />
				</form>
			</section><!-- .searchbox end -->
			<c:set var="location_nav" value="${location}"/>
			<c:choose>
			    <c:when test="${fn:endsWith(location_nav, 'home')}">
			    </c:when>
			    <c:otherwise>
			      <section class="breadcrumb">
						<ul>
							<li class="first"><a href="index">Home</a></li>
								<li>${location}</li>
						</ul>
				  </section>
			    </c:otherwise>
			</c:choose>
			
		</div><!-- .wrapper end -->
		
	</header>

<!-- HEADER END -->