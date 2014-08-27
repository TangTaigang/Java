$(function(){
	
// Dropdown menu
// -------------------------------------------------------------------------------------------
	var options = {minWidth: 180, onClick: function(e, menuItem){}};
	$('nav ul').menu(options);
	

// Social network icons animation
// -------------------------------------------------------------------------------------------
	$(".social-networks ul li a").hover(function(){
		$("img", this).stop().animate({top:"-26px"},{queue:false,duration:200});
	}, function() {
		$("img", this).stop().animate({top:"0px"},{queue:false,duration:200});
	});


// Banner slider
// -------------------------------------------------------------------------------------------
	$(".slider").asyncSlider({
		keyboardNavigate: true,
		easing: 'easeInOutExpo',
		minTime: 1000,
		maxTime: 2000,
		autoswitch: 5000,
		prevNextNav: false,
		slidesNav: false
	});


// Featured products carousel
// -------------------------------------------------------------------------------------------
	$(".carousel").jCarouselLite({
        btnNext: ".featured-products .next",
        btnPrev: ".featured-products .prev",
    	speed: 1000,
    	visible: 4
    });


// Featured products sliding
// -------------------------------------------------------------------------------------------
	$('.boxgrid').hover(function(){
		$("img", this).stop().animate({left:'190px'},{queue:false,duration:300});
	}, function() {
		$("img", this).stop().animate({left:'0px'},{queue:false,duration:300});
	});


// Latest product zoom effect
// -------------------------------------------------------------------------------------------
	$('.zoom').hoverZoom({
		overlayColor: '#000',
		overlayOpacity: 0.3,
		zoom: 10
	});


});