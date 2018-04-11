   $(document).ready(function($) {
   	var slideIndex=0
  	$('.toslide').each(function(index) {
  		$(this).data("slIndex",slideIndex)
  		$('.swiper-wrapper').append("<div class=\"swiper-slide\"><img  src=\""+ $(this).attr('src') +"\" alt=\"\"></div>");
  		slideIndex++;
  	});

  	 var mySwiper = new Swiper ('.swiper-container', {
      // Optional parameters
     // direction: 'vertical',
		navigation: { 
			nextEl: '.swiper-button-next',
			prevEl: '.swiper-button-prev',
		},
		loop: false
    })
  	 $('.toslide').click(function(e) {
  	 	/* Act on the event */
  	 	$('body').addClass('noScroll');
  	 	mySwiper.slideTo($(this).data("slIndex"), 4,false);
  	 	$('.slideContainer').addClass('show');

  	 });
  	 $('.close').click(function(event) {
  	 	/* Act on the event */
  	 	$('.slideContainer').removeClass('show');
  	 	$('body').removeClass('noScroll');
  	 });
  });

 
