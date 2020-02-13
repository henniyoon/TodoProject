(function($) {
	
	var c1 = $('.circle');
	c1.each(function(index, value) {
	
	  $(value).circleProgress({
		startAngle: -Math.PI / 4 * 2,
		value: $(value).attr("percent"),
	    lineCap: 'round',
	    fill: {color: '#e74a3b'}
	  }).on('circle-animation-progress', function(event, progress) {
	    $(this).find('strong').html(Math.round($(this).attr("percent") * 100 * progress) + '<br><i>%</i>');
	  });
	})
})(jQuery);
