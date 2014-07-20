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

// Latest product zoom effect
// -------------------------------------------------------------------------------------------
	$('.zoom').hoverZoom({
		overlayColor: '#000',
		overlayOpacity: 0.3,
		zoom: 10
	});
	
// Accordion
// -------------------------------------------------------------------------------------------
	$( ".accordion" ).accordion({
			autoHeight: false,
			navigation: true,
			collapsible: true,
			active: false
	});
	
// Tabs
// -------------------------------------------------------------------------------------------
	$( ".tabs" ).tabs();

// Classes
// -------------------------------------------------------------------------------------------
	$("tr:even").addClass('even')

});