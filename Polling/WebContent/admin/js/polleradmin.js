$(document).ready(function() {
	
	$('body').on('click','.pageno',function(){
		
		$id=$(this).attr('id');
		 $(this).parent().siblings('li').removeClass('active');
	     $(this).parent().addClass('active');
		
		$('.polltable').children().each(function(i){
			
			if(Math.ceil((i+1)/10)==$id)
				{
				$(this).css("display","");
				}
			else
				$(this).css("display","none");

		})
	
	})
	
	
	$('body').on('click','.adminpollelement',function(){
		
		$pollid=$(this).attr('id');
		 $.post('PollStatsController', {poll_id:$pollid}, function(responseJSON) {
	         
		 $('#votes').text(responseJSON.votes);
		 $('#option').text(responseJSON.option);

	 });
	
	})
	
	$('body').on('click','#searchbutton',function(){
		
		$searchstring=$('#searchstring').val();
		 $.post('PollSearchController', {searchstring:$searchstring}, function() {


	 });
	
	})
	
})



