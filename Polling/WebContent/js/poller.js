$(window).data('ajaxready', true);
$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip();
	
 $.post('CategoryLoadController',{}, function(responseJSON) {
         
	     for (var i=0;i<responseJSON.length;i++) 
	     {
	            $id=responseJSON[i].category_id;
	            $name=responseJSON[i].category_name;
	            $category='<li class="category text-center" id="'+$id+'"><a>'+$name+'</a></li>';
	            $('#lg-menu').append($category);
	     }

 });
	
 
 if($(window).data('ajaxready')==true)
{
	 $(window).data('ajaxready',false);
		loadPolls($('#lg-menu').attr('currentSelectedCategory'),"false");
		
}
 
 
 
 
	$( document ).ajaxStart(function() {
		$('.loader').show();
		$('.loader-inner').show();
		$('.myloaderbackground').show();
	});
	
	$( document ).ajaxStop(function() {
	    $('.loader').hide();
	    $('.loader-inner').hide();
	    $('.myloaderbackground').hide();
	});
	
	
	scrollHandler=function() {

		
		if($('#main').scrollTop()+800 > ($('#innerBody').prop('scrollHeight'))&&($(window).data('ajaxready')==true)) {
			$(window).data('ajaxready',false);
			loadPolls($('#lg-menu').attr('currentSelectedCategory'),"false");
	
		}
			
	}
	
	$('#main').scroll(scrollHandler);
	
	
	
	
	$('body').on('click','#searchbtn',function(){
		
		
		$('.pollElement').css({"visibility":"hidden",display:'block'}).slideUp().remove();
		
		
		searchPolls($('#srch-term').val());
		
		$('.category').find('.active').removeClass("active");


		
			
		})
	
	
	
	
	$('body').on('click','.category',function(){ $('#nopolls').remove();
	
	$('#main').scroll(scrollHandler);
	if($(window).data('ajaxready')==true)
	{
	
	$('.pollElement').css({"visibility":"hidden",display:'block'}).slideUp().remove();
	$(this).parent().attr('currentSelectedCategory',$(this).attr("id"));
	$(window).data('ajaxready',false);
	loadPolls($('#lg-menu').attr('currentSelectedCategory'),"true");
	$('.category').find('.active').removeClass("active");
	$(this).find('a').addClass("active");
	FB.XFBML.parse();
	if($(window).width()<768)
	$('#categoryclick').click();
	FB.XFBML.parse();
		 
		  
	
	}
	})
	
	
	$('body').on('click', '.answerbox',function(){
	  
		$(this).parent().children().click(function(){return false;});
		$(this).parent().click(function(){return false;});
		$(this).parent().css("pointer-events", "none");
		
		var poll_idJS=$(this).parent().attr("id");
		var selectedoptionJS;
        $answer=$(this);
		switch($answer.attr('id')) 
		{
			    case 'box1':
			        selectedoptionJS=1;
			        break;
			    case 'box2':
			        selectedoptionJS=2;
			        break;
			    case 'box3':
			        selectedoptionJS=3;
			        break;
			    case 'box4':
			        selectedoptionJS=4;
			        break;
			    default:
			     	selectedoptionJS=-1;
			    	break;
		}
			
		$.post('AnswerLoadController', {id:poll_idJS,selectedOption:selectedoptionJS,answeredpoll:"false"}, function(responseJSON) {
		         

		$a=Math.round(responseJSON.optionA);
		$b=Math.round(responseJSON.optionB);
		$c=Math.round(responseJSON.optionC);
		$d=Math.round(responseJSON.optionD);
		
		$answer.parent().find("div[percent='one']").html($a+'%');
		$answer.parent().find("div[percent='two']").html($b+'%');
		$answer.parent().find("div[percent='three']").html($c+'%');
		$answer.parent().find("div[percent='four']").html($d+'%');
		
		
		var temp=$answer.attr('id');
		if(temp==='box1')
		{
			
			$mybar1=$answer.attr('bar1');
			$('[bar="'+$mybar1+'"]',$answer.parent()).css('background-color', 'green');
			$('[bar="'+$mybar1+'"]',$answer.parent()).animate({
			    height: ($a*0.8)+'%'
			}, 1500);
			
			$mybar2=$answer.attr('bar2');
			$('[bar="'+$mybar2+'"]',$answer.parent()).css('background-color', 'white');
			$('[bar="'+$mybar2+'"]',$answer.parent()).animate({
			    height: ($b*0.8)+'%'
			}, 1500);
			
			$mybar3=$answer.attr('bar3');
			$('[bar="'+$mybar3+'"]',$answer.parent()).css('background-color', 'white');
			$('[bar="'+$mybar3+'"]',$answer.parent()).animate({
			    height: ($c*0.8)+'%'
			}, 1500);
			
			$mybar4=$answer.attr('bar4');
			$('[bar="'+$mybar4+'"]',$answer.parent()).css('background-color', 'white');
			$('[bar="'+$mybar4+'"]',$answer.parent()).animate({
			    height: ($d*0.8)+'%'
			}, 1500);
			
		}
		if(temp==='box2')
		{
			$mybar1=$answer.attr('bar1');
			$('[bar="'+$mybar1+'"]',$answer.parent()).css('background-color', 'white');
			$('[bar="'+$mybar1+'"]',$answer.parent()).animate({
			    height: ($a*0.8)+'%'
			}, 1500);
			
			$mybar2=$answer.attr('bar2');
			$('[bar="'+$mybar2+'"]',$answer.parent()).css('background-color', 'green');
			$('[bar="'+$mybar2+'"]',$answer.parent()).animate({
			    height: ($b*0.8)+'%'
			}, 1500);
			
			$mybar3=$answer.attr('bar3');
			$('[bar="'+$mybar3+'"]',$answer.parent()).css('background-color', 'white');
			$('[bar="'+$mybar3+'"]',$answer.parent()).animate({
			    height: ($c*0.8)+'%'
			}, 1500);
			
			$mybar4=$answer.attr('bar4');
			$('[bar="'+$mybar4+'"]',$answer.parent()).css('background-color', 'white');
			$('[bar="'+$mybar4+'"]',$answer.parent()).animate({
			    height: ($d*0.8)+'%'
			}, 1500);
		}
		if(temp==='box3')
		{
			$mybar1=$answer.attr('bar1');
			$('[bar="'+$mybar1+'"]',$answer.parent()).css('background-color', 'white');
			$('[bar="'+$mybar1+'"]',$answer.parent()).animate({
			    height: ($a*0.8)+'%'
			}, 1500);
			
			$mybar2=$answer.attr('bar2');
			$('[bar="'+$mybar2+'"]',$answer.parent()).css('background-color', 'white');
			$('[bar="'+$mybar2+'"]',$answer.parent()).animate({
			    height: ($b*0.8)+'%'
			}, 1500);
			
			$mybar3=$answer.attr('bar3');
			$('[bar="'+$mybar3+'"]',$answer.parent()).css('background-color', 'green');
			$('[bar="'+$mybar3+'"]',$answer.parent()).animate({
			    height: ($c*0.8)+'%'
			}, 1500);
			
			$mybar4=$answer.attr('bar4');
			$('[bar="'+$mybar4+'"]',$answer.parent()).css('background-color', 'white');
			$('[bar="'+$mybar4+'"]',$answer.parent()).animate({
			    height: ($d*0.8)+'%'
			}, 1500);
		}
		if(temp==='box4')
		{
			$mybar1=$answer.attr('bar1');
			$('[bar="'+$mybar1+'"]',$answer.parent()).css('background-color', 'white');
			$('[bar="'+$mybar1+'"]',$answer.parent()).animate({
			    height: ($a*0.8)+'%'
			}, 1500);
			
			$mybar2=$answer.attr('bar2');
			$('[bar="'+$mybar2+'"]',$answer.parent()).css('background-color', 'white');
			$('[bar="'+$mybar2+'"]',$answer.parent()).animate({
			    height: ($b*0.8)+'%'
			}, 1500);
			
			$mybar3=$answer.attr('bar3');
			$('[bar="'+$mybar3+'"]',$answer.parent()).css('background-color', 'white');
			$('[bar="'+$mybar3+'"]',$answer.parent()).animate({
			    height: ($c*0.8)+'%'
			}, 1500);
			
			$mybar4=$answer.attr('bar4');
			$('[bar="'+$mybar4+'"]',$answer.parent()).css('background-color', 'green');
			$('[bar="'+$mybar4+'"]',$answer.parent()).animate({
			    height: ($d*0.8)+'%'
			}, 1500);
		}
		
	$("[percent=one]",$answer.parent()).fadeTo("slow", 1.0, function() {

	  });
	$("[percent=two]",$answer.parent()).fadeTo("slow", 1.0, function() {
	    
	  });
	$("[percent=three]",$answer.parent()).fadeTo("slow", 1.0, function() {
	    
	  });
	$("[percent=four]",$answer.parent()).fadeTo("slow", 1.0, function() {
	    
	  });
	
	
	
	$("[overlay=one]",$answer.parent()).fadeTo("slow", 1.0, function() {
	    
	  });
	$("[overlay=two]",$answer.parent()).fadeTo("slow", 1.0, function() {
	    
	  });
	$("[overlay=three]",$answer.parent()).fadeTo("slow", 1.0, function() {
	    
	  });
	$("[overlay=four]",$answer.parent()).fadeTo("slow", 1.0, function() {
	    
	  });
	
	
	});	
		
	
		});
});


function loadPolls(Category,isCatClick)
{
    
	 $.post('PollLoadController', {category:Category,loadedString:Category,isCatClick:isCatClick}, function(responseJSON) {
         
		 if(responseJSON.length==0)
		{
			 var div="<div class='row' id='nopolls'><br><br><h3 style='text-align:center'>Aw Snap! We've run out of Polls. Please check another category or come back later for more Polls.<h3><br><br><br><br></div>";
			 $('#footerrow').before(div).fadeIn();
			 $('#main').off("scroll", scrollHandler);
		}
		 
	     for (var i=0;i<responseJSON.length;i++) 
	     {
	    	 if(responseJSON[i].isbinary==1)
	    		 {
	    		 appendBinaryPoll(responseJSON[i].PollId,responseJSON[i].Title,responseJSON[i].Description,responseJSON[i].ImgSrc,responseJSON[i].Tagged,responseJSON[i].OptionOne,responseJSON[i].OptionTwo,responseJSON[i].OptionThree,responseJSON[i].OptionFour,responseJSON[i].FbCommentId,responseJSON[i].votes);
	    		 }
	    	 else
	    		 {
	            appendPoll(responseJSON[i].PollId,responseJSON[i].Title,responseJSON[i].Description,responseJSON[i].ImgSrc,responseJSON[i].Tagged,responseJSON[i].OptionOne,responseJSON[i].OptionTwo,responseJSON[i].OptionThree,responseJSON[i].OptionFour,responseJSON[i].FbCommentId,responseJSON[i].votes);
	    		 }
	    }

	     if(typeof FB!='undefined')
	     {
	     FB.XFBML.parse();
	     }
	     
	     $(window).data('ajaxready', true);

 });
	
}




function searchPolls(SearchString)
{
    
	 $.post('SearchPollController', {searchString:SearchString}, function(responseJSON) {
         
	     if(responseJSON.length==0)
	    {
	    	 var resultString='<p>No results found for "'+$('#srch-term').text()+'"<p>';
	    	 
	    	 $('#pagetop').after(resultString).fadeIn();
	    	 $('#main').off("scroll", scrollHandler);
	    }
	     else
	    {
	    	 var resultString='<p>Showing search results for "'+$('#srch-term').text()+'"<p>';
	    	 $('#pagetop').after(resultString).fadeIn();
	    }
		 
		 for (var i=0;i<responseJSON.length;i++) 
	     {
	            appendPoll(responseJSON[i].PollId,responseJSON[i].Title,responseJSON[i].Description,responseJSON[i].ImgSrc,responseJSON[i].Tagged,responseJSON[i].OptionOne,responseJSON[i].OptionTwo,responseJSON[i].OptionThree,responseJSON[i].OptionFour,responseJSON[i].FbCommentId);
	     }

 });
	
}



function appendPoll(pollId,title,description,imgSrc,taggedBy,option1,option2,option3,option4,fbCommentId,votes) {
    
	var poll='<div class="pollElement"><div class="row" ><div class="col-sm-6 col-md-offset-3"><div class="panel panel-default">';
	poll=poll.concat('<div class="panel-thumbnail"><img src="');
	poll=poll.concat(imgSrc);
	poll=poll.concat('" class="img-responsive"></div><div class="panel-body">');
	if(votes >= 100){
	poll=poll.concat('<h5 style="text-align : right">Votes : ');
	poll=poll.concat(votes);
	poll=poll.concat('</h5>');
	}
	poll=poll.concat('<h4>');
	poll=poll.concat(title);
	poll=poll.concat('</h4><div class="clearfix"></div><hr><p>');
	poll=poll.concat(description);
	poll=poll.concat('</p><div class="clearfix"></div><hr><div><div class="answers" id="');
	poll=poll.concat(pollId);
	poll=poll.concat('"><div class="answerbox" id="box1"  bar1="one" bar2="two" bar3="three" bar4="four"><div id="answerboxdiv" ><div id="overlay" overlay="one"></div><div id="answertext">');
	poll=poll.concat(option1);
	poll=poll.concat('</div><div id="value" percent="one"></div><div id="outer" align="center"><div id="inner" bar="one"></div></div></div></div><div class="answerbox" id="box2" bar1="one" bar2="two" bar3="three" bar4="four"><div id="answerboxdiv" ><div id="overlay" overlay="two"></div><div id="answertext">');
	poll=poll.concat(option2);
	poll=poll.concat('</div><div id="value" percent="two"></div><div id="outer" align="center"><div id="inner" bar="two"></div></div></div></div><div class="answerbox" id="box3" bar1="one" bar2="two" bar3="three" bar4="four"><div id="answerboxdiv" ><div id="overlay" overlay="three"></div><div id="answertext">');
	poll=poll.concat(option3);
	poll=poll.concat('</div><div id="value" percent="three"></div><div id="outer" align="center"><div id="inner" bar="three"></div></div></div></div><div class="answerbox" id="box4" bar1="one" bar2="two" bar3="three" bar4="four"><div id="answerboxdiv" ><div id="overlay" overlay="four"></div><div id="answertext">');
	poll=poll.concat(option4);
	poll=poll.concat('</div><div id="value" percent="four"></div><div id="outer" align="center"><div id="inner" bar="four"></div></div></div></div></div></div><hr><br><div class="fb-share-button" style="top:25px;left:5px;" data-href="http://localhost:8080/Polling/viewpoll.jsp?param=');
	poll=poll.concat(pollId);		
	poll=poll.concat('" data-layout="button_count" data-mobile-iframe="true"></div><button class="linkbtn btn btn-primary facebook modal-login-btn pull-right" style="width:auto;background-color:#FFFFFF;border:1px solid #118F62;color: rgb(17, 143, 98);" data-clipboard-text="http://localhost:8080/Polling/viewpoll.jsp?param=');
	poll=poll.concat(pollId);		
	poll=poll.concat('"><span class="glyphicon glyphicon-paperclip" data-toggle="tooltip" title="Copy Share link to clipboard"></span></button>')
	poll=poll.concat('<div class="fb-comments" data-href="http://localhost:8080/Polling/viewpoll.jsp?param=');
	poll=poll.concat(pollId);
	poll=poll.concat('" data-width="100%" data-numposts="5"></div></div></div></div></div></div></div>');
	
	$('#footerrow').before(poll).fadeIn();
	
	var clipboard = new Clipboard('.linkbtn');

	clipboard.on('success', function(e) {
	    //Kartik, please add a success popover here // Gotcha!!
	    $('#linkSuccessModal').modal();
	});

	clipboard.on('error', function(e) {
		//please add a failure popover here Okay // Gotcha!!
		$('#linkFailureModal').modal();
	});
	
	return;
	
}


function appendBinaryPoll(pollId,title,description,imgSrc,taggedBy,option1,option2,option3,option4,fbCommentId,votes) {
    
	var poll='<div class="pollElement"><div class="row" ><div class="col-sm-6 col-md-offset-3"><div class="panel panel-default">';
	poll=poll.concat('<div class="panel-thumbnail"><img src="');
	poll=poll.concat(imgSrc);
	poll=poll.concat('" class="img-responsive"></div><div class="panel-body">');
	if(votes >= 100){
	poll=poll.concat('<h5 style="text-align : right">Votes : ');
	poll=poll.concat(votes);
	poll=poll.concat('</h5>');
	}
	poll=poll.concat('<h4>');
	poll=poll.concat(title);
	poll=poll.concat('</h4><div class="clearfix"></div><hr><p>');
	poll=poll.concat(description);
	poll=poll.concat('</p><div class="clearfix"></div><hr><div><div class="answers" id="');
	poll=poll.concat(pollId);
	poll=poll.concat('"><div class="answerbox" id="box1"  bar1="one" bar2="two" bar3="three" bar4="four"><div id="answerboxdiv" ><div id="overlay" overlay="one"></div><div id="answertext">');
	poll=poll.concat(option1);
	poll=poll.concat('</div><div id="value" percent="one"></div><div id="outer" align="center"><div id="inner" bar="one"></div></div></div></div><div class="answerbox" id="box2" bar1="one" bar2="two" bar3="three" bar4="four"><div id="answerboxdiv" ><div id="overlay" overlay="two"></div><div id="answertext">');
	poll=poll.concat(option2);
	poll=poll.concat('</div><div id="value" percent="two"></div><div id="outer" align="center"><div id="inner" bar="two"></div></div></div></div></div></div> <hr><br><div class="fb-share-button" style="top:25px;left:5px;" data-href="http://localhost:8080/Polling/viewpoll.jsp?param=');
	poll=poll.concat(pollId);		
	poll=poll.concat('" data-layout="button_count" data-mobile-iframe="true"></div><button class="linkbtn btn btn-primary facebook modal-login-btn pull-right" style="width:auto;background-color:#FFFFFF;border:1px solid #118F62;color: rgb(17, 143, 98);" data-clipboard-text="http://localhost:8080/Polling/viewpoll.jsp?param=');
	poll=poll.concat(pollId);		
	poll=poll.concat('"><span class="glyphicon glyphicon-paperclip" data-toggle="tooltip" title="Copy Share link to clipboard"></span></button>')
	poll=poll.concat('<div class="fb-comments" data-href="http://localhost:8080/Polling/home.jsp/comments#');
	poll=poll.concat(fbCommentId);
	poll=poll.concat('" data-width="100%" data-numposts="5"></div></div></div></div></div></div></div>');
	
	$('#footerrow').before(poll).fadeIn();
	
	var clipboard = new Clipboard('.linkbtn');

	clipboard.on('success', function(e) {
	    //Kartik, please add a success popover here // Gotcha!!
	    $('#linkSuccessModal').modal();
	});

	clipboard.on('error', function(e) {
		//please add a failure popover here Okay // Gotcha!!
		$('#linkFailureModal').modal();
	});

	return;
}