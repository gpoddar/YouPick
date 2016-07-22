$(document).ready(function(){/* off-canvas sidebar toggle */

$('[data-toggle=showcats]').click(function() {
  	$('#catTag').toggleClass('visible-xs text-center hidden-xs');
    $('.row-offcanvas').toggleClass('active');
    $('#sidebar').toggleClass('visible-xs').toggleClass('hidden-xs');
});

//BACKUP TOGGLE FUNCTION
/*
$('[data-toggle=offcanvas]').click(function() {
  	$(this).toggleClass('visible-xs text-center');
    $(this).find('i').toggleClass('glyphicon-chevron-right glyphicon-chevron-left');
    $('.row-offcanvas').toggleClass('active');
    $('#lg-menu').toggleClass('hidden-xs').toggleClass('visible-xs');
    $('#xs-menu').toggleClass('visible-xs').toggleClass('hidden-xs');
    $('#btnShow').toggle();
});
*/

});