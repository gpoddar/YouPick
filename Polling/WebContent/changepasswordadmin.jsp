<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<meta charset="utf-8" />
	<title>Polling AdminPanel</title>
	<meta name="generator" content="Bootply" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<link href="css/bootstrap.min1.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<link href="css/stylesadmin.css" rel="stylesheet" />
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
											<li>
												<a style="height:50px" href="addpoll.jsp"><span class="glyphicon glyphicon-plus hidden-xs" aria-hidden="true"></span><span class="text-center glyphicon glyphicon-plus visible-xs"  style ="font-size:medium" aria-hidden="true"> Add Poll</span></a>
											</li>
											<li>
												<a style="height:50px" href="" role="button"><span class="glyphicon glyphicon-education hidden-xs" aria-hidden="true"></span> <span class="text-center glyphicon glyphicon-education visible-xs" style ="font-size:medium" aria-hidden="true"> Add School/Area</span></a>
											</li>
											<li>
												<a style="height:50px" href="viewpollstats.jsp" role="button"><span class="glyphicon glyphicon-stats hidden-xs" aria-hidden="true"></span><span class="text-center glyphicon glyphicon-stats visible-xs" style ="font-size:medium" aria-hidden="true"> View Poll Stats</span></a></li><li><a href="#logoutModal" class="dropdown-toggle" data-toggle="modal"><i class="glyphicon glyphicon-user"></i></a></li>
											</li>
											<li>
												<a style="height:50px" class="active" href="" role="button"><span class="glyphicon glyphicon-lock hidden-xs" aria-hidden="true"></span> <span class="text-center glyphicon glyphicon-lock visible-xs" style ="font-size:medium" aria-hidden="true"> Change Password</span></a>
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
<!--<div class="panel panel-default">
<div class="panel-thumbnail">
<img src="/assets/example/bg_5.jpg" class="img-responsive" />
</div>
<div class="panel-body">
<p class="lead">Urbanization</p>
<p>45 Followers, 13 Posts</p>
<p>
<img src="https://lh3.googleusercontent.com/uFp_tsTJboUY7kue5XAsGA=s28" width="28px" height="28px" />
</p>
</div>
</div>
<div class="panel panel-default">
<div class="panel-heading">
<a href="#" class="pull-right">View all</a>
<h4></h4>
</div>
<div class="panel-body">
<div class="list-group">
<a href="" class="list-group-item">Modal / Dialog</a> 
<a href="" class="list-group-item">Datetime Examples</a> 
<a href="" class="list-group-item">Data Grids</a></div>
</div>
</div>-->
<div class="well">
	<h3 style="font-weight:600" class="center">Change Admin Password</h3>
	<br>
	<form id="changePasswordForm" class="form-horizontal" role="form">
		<div class="form-group" style="padding:14px">
			<label for="oldPass">Old Password *</label>
			<input type="password" class="form-control" name="oldPass" id="oldPass" placeholder="Old Password">
		</div>
		<div class="form-group" style="padding:14px">
			<label for="newPass">New Password *</label>
			<input type="password" class="form-control" name="newPass" id="newPass" placeholder="New Password">
		</div>
		<div class="form-group" style="padding:14px">
			<label for="confirmPass">Confirm Password *</label>
			<input type="password" class="form-control" name="confirmPass" id="confirmPass" placeholder="Confirm Password">
		</div>
		<button class="btn btn-primary pull-right facebook" type="submit">Save</button>
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
				<a href="#" class="pull-right">©Copyright 2016</a>
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
<div id="logoutModal" class="modal fade" style="overflow:hidden" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" id="login-box">
    <div class="modal-content">
      <div class="modal-body panel-body" style="padding:20px">
        <h4>Are you sure you want to logout?</h4>
        <a href="LogoutController.logout" class="btn btn-primary facebook modal-login-btn" style="width:45%">Yes</a>
        <a href="#" data-dismiss="modal" class="btn btn-primary facebook modal-login-btn" style="margin-left:5%;width:45%">Cancel</a>
      </div>
    </div>
  </div>
</div>

<!--post modal-->
<div id="deleteModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog" style="margin-top:15%">
		<div class="modal-content">
			<div class="modal-body panel-body" style="padding:20px">
				<h4>Are you sure you want to delete this item?</h4>
				<br>
				<a href="#" data-dismiss="modal" class="btn btn-primary" style="width:45%">Yes</a>
				<a href="#" data-dismiss="modal" class="btn btn-primary" style="margin-left:5%;width:45%">Cancel</a>
			</div>
		</div>
	</div>
</div>
<!-- script references -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/scripts.js"></script> 
<script type="text/javascript" src="js/clipboard.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/additional-methods.min.js"></script>
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
$(document).ready(function () {

	$('#changePasswordForm').validate({
		rules: {
			oldPass: {
				required: true,
				alphanumeric: true,
				minlength: 5
			},
			newPass: {
				required: true,
				alphanumeric: true,
				minlength: 5
			},
			confirmPass: {
				required: true,
				alphanumeric: true,
				minlength: 5,
				equalTo : newPass
			}
		},
		messages: {
			oldPass:{
				required: "Please enter the old password",
				alphanumeric : "Password must be alphanumeric",
				minlength: "Your password should be at least 5 characters"
			},
			newPass:{
				required: "Please enter a new password",
				alphanumeric : "Password must be alphanumeric",
				minlength: "Your password should be at least 5 characters",
			},
			confirmPass:{
				required: "Please enter the new password again",
				alphanumeric : "Password must be alphanumeric",
				minlength: "Your password should be at least 5 characters",
				equalTo : "Passwords do not match"
			}		

		},
		highlight: function (element) {
			$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
		},
		success: function (element) {
			element.text('Done').addClass('valid')
			.closest('.form-group').removeClass('has-error').addClass('has-success');
		},
		submitHandler: function(form) {
			form.submit();
		}
	});
});
</script>
</body>
</html>
