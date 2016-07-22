
$(document).ready(function() {

	
	$('[data-toggle="tooltip"]').tooltip();
	
	$('.pollElement').css({"visibility":"hidden",display:'block'}).slideUp().remove();
	
    var parameters = location.search.substring(1).split("&");
    var temp = parameters[0].split("=");
    var searchstring = unescape(temp[1].replace("+"," "));
	
	searchPolls(searchstring);
	
	$('.category').find('.active').removeClass("active");

	
	
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
	
	

	
	

	
	
	
	
	$('body').on('click','.category',function(){ $('#nopolls').remove();
		
	$(this).parent().attr('currentSelectedCategory',$(this).attr("id"));
	$('.pollElement').css({"visibility":"hidden",display:'block'}).slideUp().remove();
	loadPolls($('#lg-menu').attr('currentSelectedCategory'));
	$('.category').find('.active').removeClass("active");
	$(this).find('a').addClass("active");
	if($(window).width()<768)
	$('#categoryclick').click();
	
		
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
		
		$("[percent=one]").html($a+'%');
		$("[percent=two]").html($b+'%');
		$("[percent=three]").html($c+'%');
		$("[percent=four]").html($d+'%');
		
		
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







function searchPolls(SearchString)
{
    
	 $.post('SearchPollController', {searchString:SearchString}, function(responseJSON) {
         
	     if(responseJSON.length==0)
	    {
	    	 var resultString='<h2 style="text-align:center;">No results found for "'+SearchString+'"</h2><hr>';
	    	 $('#pagetop').after(resultString).fadeIn();
	    }
	     else if(responseJSON.length==1)
		    {
		    	 var resultString='<h2 style="text-align:center;">Showing '+responseJSON.length+' result for "'+SearchString+'"<h2><hr>';
		    	 $('#pagetop').after(resultString).fadeIn();
		    }
	     
	     else
	    {
	    	 var resultString='<h2 style="text-align:center;">Showing '+responseJSON.length+' results for "'+SearchString+'"<h2><hr>';
	    	 $('#pagetop').after(resultString).fadeIn();
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
		     FB.XFBML.parse();

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

function replaceAll(str, find, replace) {
	  return str.replace(new RegExp(find, 'g'), replace);
	}