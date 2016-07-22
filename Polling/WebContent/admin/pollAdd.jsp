<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Polling AdminPanel</title>
<meta name="generator" content="Bootply" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<link href="css/styles.css" rel="stylesheet" />
<%@ page import="dto.Category" %>
<%@ page import="java.util.ArrayList" %>
</head>
<body>
<div class="wrapper">
<div class="box">
<div class="row row-offcanvas row-offcanvas-left">
<!-- sidebar -->
<div class="column col-sm-2 col-xs-1 sidebar-offcanvas" id="sidebar" style="display:none">
<ul class="nav">
<li>
<a href="#" data-toggle="offcanvas" class="visible-xs text-center"></a>
</li>
</ul>
<ul class="nav hidden-xs" id="lg-menu">
<li class="active">
<a href="#featured">Featured</a>
</li>
<li>
<a href="#stories">Stories</a>
</li>
<li>
<a href="#">Saved</a>
</li>
<li>
<a href="#">Refresh</a>
</li>
</ul>
<ul class="list-unstyled hidden-xs" id="sidebar-footer">
<li>
<a href="">
<h3></h3></a>
</li>
</ul>
<!-- tiny only nav-->
<ul class="nav visible-xs" id="xs-menu">
<li>
<a href="#featured" class="text-center"></a>
</li>
<li>
<a href="#stories" class="text-center"></a>
</li>
<li>
<a href="#" class="text-center"></a>
</li>
<li>
<a href="#" class="text-center"></a>
</li>
</ul>
</div>
<!-- /sidebar -->
<!-- main right col -->
<div class="column col-sm-12 col-xs-12" id="main">
<!-- top nav -->
<div class="navbar navbar-blue navbar-static-top">
<div class="container">
<div class="navbar-header">
<button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
<span class="sr-only">Toggle</span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</button> 
<a href="" class="navbar-brand logo">p</a></div>
<nav class="collapse navbar-collapse" role="navigation">
<ul class="nav navbar-nav navbar-right">
<li >
<a class="active" style="height:50px" href="#"><span class="glyphicon glyphicon-plus hidden-xs" aria-hidden="true"></span><span class="text-center glyphicon glyphicon-plus visible-xs"  style ="font-size:medium" aria-hidden="true"> Add Poll</span></a>
</li>
<li>
<a href="addunivarea.jsp" style="height:50px" role="button"><span class="glyphicon glyphicon-education hidden-xs" aria-hidden="true"></span> <span class="text-center glyphicon glyphicon-education visible-xs" style ="font-size:medium" aria-hidden="true"> Add School/Area</span></a>
</li>
<li>
<a href="viewpollstats.html" style="height:50px" role="button"><span class="glyphicon glyphicon-stats hidden-xs" aria-hidden="true"></span><span class="text-center glyphicon glyphicon-stats visible-xs" style ="font-size:medium" aria-hidden="true"> View Poll Stats</span></a></li><li><a href="#logoutModal" class="dropdown-toggle" data-toggle="modal"><i class="glyphicon glyphicon-user"></i></a></li>
</li>
</ul>
<form class="navbar-form navbar-right" style="display:none">
<div class="input-group input-group-sm" style="max-width:360px;">
<input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term" />
<div class="input-group-btn"></div>
</div>
</form>
</nav>
</div>
</div>
<!-- /top nav -->
<div class="padding">
<div class="full col-sm-9">
<!-- content -->
<div class="row" id="innerBody">
<!-- main col left -->
<div class="col-sm-5 col-sm-offset-3">

<div class="well">
<h4 class="center">Choose a Question Type</h4>
<div class="text-center">
<div class="btn-group" style="margin-bottom:20px" role="group">

<button type="button" style="width:50%" class="btn btn-default btn-lg" onclick="binary()">
<div class="row">

<span class="glyphicon glyphicon-adjust" aria-hidden="true"></span>
</div>
<span id="glyph-text" aria-hidden="true">Binary</span></button>



<button type="button"  style="width:50%" class="btn btn-default btn-lg" onclick="multiple()">
<div class="row">

<span class="glyphicon glyphicon-align-justify" aria-hidden="true"></span>
</div>
<span id="glyph-text" aria-hidden="true">Multiple</span></button>

</div>
</div>

<form class="form-horizontal" enctype="multipart/form-data" role="form" action="PollAddController" method="post">
<h4 class="center">Add Media</h4>
<div class="input-group">
				<span class="input-group-btn">
                    <span class="btn btn-primary btn-file">
                        Browse <input type="file" name="file">
                    </span>
                </span>
                <input type="text" placeholder="No File Chosen" id="uploadPicture" class="form-control" readonly>
            </div>
<h4 class="center">Question</h4>
<div class="form-group" style="padding:14px;">
<textarea class="form-control" placeholder="Start typing" id="question" name="question"></textarea>
</div>
<h4 class="center">Tag Category</h4>
<div class="form-group" style="padding:14px;">
<select name="category">
<%
 ArrayList<Category>categories=(ArrayList<Category>)request.getAttribute("CategoryList");

for(Category c:categories)
{
%>
  <option value="<%=c.getCategory_id()%>"><%=c.getCategory_name()%></option> <%
}
%>
</select>
</div>

<h4 class="center">Options</h4>
<div class="form-group">
<div class="input-group col-sm-6" style="padding:14px;">
<div class="input-group-addon">A</div>
<input type="text" class="form-control" id="optionA" name="optionA" placeholder="" />
</div>
<div class="input-group col-sm-6" style="padding:14px;">
<div class="input-group-addon">B</div>
<input type="text" class="form-control" id="optionB" name="optionB" placeholder="" />
</div>
</div>
<div class="form-group" id="multipleOptions" style="display:none">
<div class="input-group col-sm-6" style="padding-left:14px;padding-right:14px;padding-bottom:14px;">
<div class="input-group-addon">C</div>
<input type="text" class="form-control" id="OptionC" name="optionC" placeholder="" />
</div>
<div class="input-group col-sm-6" style="padding-left:14px;padding-right:14px;padding-bottom:14px;">
<div class="input-group-addon">D</div>
<input type="text" class="form-control" id="optionD" name="optionD" placeholder="" />
</div>
</div>
<h4 class="center">Description</h4>
<div class="form-group" style="padding:14px;">
<textarea class="form-control" placeholder="Start typing" id="description" name="description"></textarea>
</div>
<input type="hidden" id="polltype" name="polltype" value="binary"/>
<input type="submit" class="btn btn-primary pull-right" value="Submit"/>
<ul class="list-inline">
<li>
<a href=""></a>
</li>
<li>
<a href=""></a>
</li>
<li>
<a href=""></a>
</li>
</ul>
</form>
</div>
<!--<div class="panel panel-default">
<div class="panel-heading">
<a href="#" class="pull-right">View all</a>
<h4></h4>
</div>
<div class="panel-body">
<img src="http://placehold.it/150x150" class="img-circle pull-right" /> 
<a href="#"></a>
<div class="clearfix"></div>
<hr />
<ul class="list-unstyled">
<li>
<a href="">Dashboard</a>
</li>
<li>
<a href="">Darkside</a>
</li>
<li>
<a href="">Greenfield</a>
</li>
</ul></div>
</div>
<div class="panel panel-default">
<div class="panel-heading">
<h4>What Is Bootstrap?</h4>
</div>
<div class="panel-body"></div>
</div>-->
</div>
</div>
<!--/row-->
<div class="row" style="display:none">
<div class="col-sm-6">
<a href="#">Twitter</a> 
<small class="text-muted">|</small> 
<a href="#">Facebook</a> 
<small class="text-muted">|</small> 
<a href="#">Google+</a></div>
</div>
<div class="row" id="footer">
<div class="col-sm-6"></div>
<div class="col-sm-6">
<p>
<a href="#" class="pull-right">�Copyright 2016</a>
</p>
</div>
</div>
<hr />
</div>
<!-- /col-9 -->
</div>
<!-- /padding -->
</div>
<!-- /main -->
</div>
</div>
</div>
<!--post modal-->
<div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button> Update Status</div>
<div class="modal-body">
<form class="form center-block">
<div class="form-group">
<textarea class="form-control input-lg" autofocus="" placeholder=""></textarea>
</div>
</form>
</div>
<div class="modal-footer">
<div>
<button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true">Post</button>
<ul class="pull-left list-inline">
<li>
<a href=""></a>
</li>
<li>
<a href=""></a>
</li>
<li>
<a href=""></a>
</li>
</ul>
</div>
</div>
</div>
</div>
</div>
<!-- script references -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/scripts.js"></script> 
<!--<script> 
$(document).ready(function(){
	$('#main').scroll(function() {
		if($('#main').scrollTop()*2 > ($('#innerBody').prop('scrollHeight'))) {
			$loading = $("<div class='panel panel-default'><div class='panel-heading'><a href='#' class='pull-right'>View all</a> <h4>More Templates</h4></div><div class='panel-body'><img src=http://placehold.it/150x150 class='img-circle pull-right'> <a href='#'>Free @Bootply</a><div class='clearfix'></div>There a load of new free Bootstrap 3 ready templates at Bootply. All of these templates are free and don't require extensive customization to the Bootstrap baseline.<hr><ul class='list-unstyled'><li><a href='http://www.bootply.com/templates'>Dashboard</a></li><li><a href='http://www.bootply.com/templates'>Darkside</a></li><li><a href='http://www.bootply.com/templates'>Greenfield</a></li></ul></div></div>");
			$('#innerBody').append($loading);
		}
	})
});


</script>-->
<script>
function binary() {
	$('#polltype').val('binary');
	$('#multipleOptions').hide();
}
function multiple() {
	$('#polltype').val('multiple');
	$('#multipleOptions').show();
}
$(document).on('change', '.btn-file :file', function() {
  var input = $(this),
      numFiles = input.get(0).files ? input.get(0).files.length : 1,
      label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
  input.trigger('fileselect', [numFiles, label]);
});

$(document).ready( function() {
    $('.btn-file :file').on('fileselect', function(event, numFiles, label) {
        
        var input = $(this).parents('.input-group').find(':text'),
            log = numFiles > 1 ? numFiles + ' files selected' : label;
        
        if( input.length ) {
            input.val(log);
        } else {
            if( log ) alert(log);
        }
        
    });
});
</script>
</body>
</html>
