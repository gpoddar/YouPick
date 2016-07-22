	<!DOCTYPE html>
	<%

	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store"); 
	response.setDateHeader("Expires", 0); 
	response.setHeader("Pragma","no-cache");
	Object userName =session.getAttribute("userID");
	Object isadmin =session.getAttribute("isAdmin");
	if( userName==null||isadmin==null) 
		{

	RequestDispatcher rd = request.getRequestDispatcher("loginfail.jsp");
	rd.forward(request, response);
}


%>
<html lang="en">
<head>
<%@ page import="dto.Area" %>
<%@ page import="dto.Category" %>
<%@ page import="dto.University" %>
<%@ page import="java.util.ArrayList" %>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<meta charset="utf-8" />
	<title>Polling AdminPanel</title>
	<meta name="generator" content="Bootply" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<link href="css/bootstrap.min1.css" rel="stylesheet" />
	<!--[if lt IE 9]>
	<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<link href="css/stylesadmin.css" rel="stylesheet" /><script   src="https://code.jquery.com/jquery-2.2.2.js"   integrity="sha256-4/zUCqiq0kqxhZIyp4G0Gk+AOtCJsY1TA00k5ClsZYE="   crossorigin="anonymous"></script>
	
	<script type="text/javascript" src="js/polleradmin.js"></script>
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
												<a style="height:50px" href="addpoll.jsp"><span class="glyphicon glyphicon-plus hidden-xs" aria-hidden="true"></span><span class="text-center glyphicon glyphicon-plus visible-xs"  style ="font-size:medium" aria-hidden="true"> Add Poll</span></a>
											</li>
											<li>
												<a style="height:50px" class="active" href="" role="button"><span class="glyphicon glyphicon-education hidden-xs" aria-hidden="true"></span> <span class="text-center glyphicon glyphicon-education visible-xs" style ="font-size:medium" aria-hidden="true"> Add School/Area</span></a>
											</li>
											<li>
												<a style="height:50px" href="viewpollstats.jsp" role="button"><span class="glyphicon glyphicon-stats hidden-xs" aria-hidden="true"></span><span class="text-center glyphicon glyphicon-stats visible-xs" style ="font-size:medium" aria-hidden="true"> View Poll Stats</span></a></li><li><a href="#logoutModal" class="dropdown-toggle" data-toggle="modal"><i class="glyphicon glyphicon-user"></i></a></li>
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
	<h4 class="center">Choose a Type</h4>
	<div class="text-center">
		<div class="btn-group" style="margin-bottom:20px" role="group">

			<button type="button" style="width:32%" class="btn btn-default btn-lg" onclick="school()">
				<div class="row">

					<span class="glyphicon glyphicon-education" aria-hidden="true"></span>
				</div>
				<span id="glyph-text" aria-hidden="true">School</span></button>

				<button type="button" style="width:40%" class="btn btn-default btn-lg" onclick="category()">
					<div class="row">

						<span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
					</div>
					<span id="glyph-text" aria-hidden="true">Category</span></button>

					<button type="button" style="width:28%" class="btn btn-default btn-lg" onclick="area()">
						<div class="row">

							<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
						</div>
						<span id="glyph-text" aria-hidden="true">Area</span></button>

					</div>
				</div>

				<form class="form-horizontal" role="form" id="form" name="form" action="UnivAreaController" method="POST">
					<input type="hidden" name="actionType" id="actionType" value="school">
					<h4 class="center">Add Info</h4>
					<div class="form-group" id="schoolName">
						<div class="input-group col-sm-12" style="padding:14px;width:100%">
							<input type="text" id="schoolname" name="schoolname" style="border-radius:5px" class="form-control"  placeholder="School Name" />
						</div>
					</div>
					<div class="form-group" id="categoryName" style="display:none">
						<div class="input-group col-sm-12" style="padding:14px;width:100%">
							<input type="text" name="categoryname" style="border-radius:5px" class="form-control"  placeholder="Category Name" />
						</div>
					</div>
					<div class="form-group" id="areaName" style="display:none">
						<div class="input-group col-sm-12" style="padding:14px;width:100%">
							<input type="text" id="areaname" name="areaname" style="border-radius:5px" class="form-control" id="areaName" placeholder="Area Name"/>
						</div>
					</div>
					<input class="btn btn-primary pull-right" type="submit" value="Add"></input>

					<br><br>
					<hr>

					<table class="table table-hover" style="background-color:white;border-radius:10px;border-color:#ccc;border-width:1px;display:none" id="areatable">
						<thead> 
							<tr> 
								<th>#</th> 
								<th>Entry Name</th>
								<th></th>
							</tr>
						</thead>
						<tbody class="polltable">


							<%ArrayList<Area> areaList=(ArrayList<Area>)request.getAttribute("areaList"); 

							int count=1;
							for(Area area:areaList)
								{
							%><tr data-toggle="modal" class="areaelement" id='<%=(long)area.getId()%>' data-target="#deleteModal"> <th scope="row"><%=count%></th> <td><%=area.getName()%></td> <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td> </tr> <%

							count++;
						}

						%>
					</tbody>
				</table>



					<table class="table table-hover" style="background-color:white;border-radius:10px;border-color:#ccc;border-width:1px;" id="univlist">
						<thead> 
							<tr> 
								<th>#</th> 
								<th>Entry Name</th>
								<th></th>
							</tr>
						</thead>
						<tbody class="polltable">


							<%ArrayList<University> univList=(ArrayList<University>)request.getAttribute("univList"); 

							int count1=1;
							for(University university:univList)
								{
							%><tr data-toggle="modal" class="univelement" id='<%=(long)university.getId()%>' data-target="#deleteModal"> <th scope="row"><%=count1%></th> <td><%=university.getName()%></td> <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td> </tr> <%

							count1++;
						}

						%>
					</tbody>
				</table>
				
				
				
				
				
				
				
				
									<table class="table table-hover" style="background-color:white;border-radius:10px;border-color:#ccc;border-width:1px;display:none" id="categorylist">
						<thead> 
							<tr> 
								<th>#</th> 
								<th>Entry Name</th>
								<th></th>
							</tr>
						</thead>
						<tbody class="polltable">


							<%ArrayList<Category> catList=(ArrayList<Category>)request.getAttribute("catList"); 

							int count2=1;
							for(Category category:catList)
								{
							%><tr data-toggle="modal" class="categoryelement" id='<%=(long)category.getCategory_id()%>' data-target="#deleteModal"> <th scope="row"><%=count2%></th> <td><%=category.getCategory_name()%></td> <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td> </tr> <%

							count2++;
						}

						%>
					</tbody>
				</table>


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
<!--delete modal-->
<div id="deleteModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog" style="margin-top:15%">
		<div class="modal-content">
			<div class="modal-body panel-body" style="padding:20px">
				<h4>Are you sure you want to disable this item?</h4>
				<br>
				<a class="btn btn-primary" style="width:45%" id="deletebtn">Yes</a>
				<a href="#" data-dismiss="modal" class="btn btn-primary" style="margin-left:5%;width:45%">Cancel</a>
			</div>
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
function school() {
	$('#areaName').hide();
	$('#categoryName').hide();
	$('#areatable').hide();
	$('#categorylist').hide();
	$('#univlist').show();
	
	$('#schoolName').show();
	$('#actionType').val('school');
}
function category() {
	$('#areaName').hide();
	$('#categoryName').show();
	$('#schoolName').hide();
	$('#actionType').val('category');
	
	$('#areatable').hide();
	$('#categorylist').show();
	$('#univlist').hide();
}
function area() {
	$('#schoolName').hide();
	$('#categoryName').hide();
	$('#areaName').show();
	$('#actionType').val('area');
	
	$('#areatable').show();
	$('#categorylist').hide();
	$('#univlist').hide();
}
</script>
</body>
</html>
