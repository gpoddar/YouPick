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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<meta charset="utf-8" />
	<title>Polling AdminPanel</title>
	<meta name="generator" content="Bootply" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<link href="css/bootstrap.min1.css" rel="stylesheet" />
	<script   src="https://code.jquery.com/jquery-2.2.2.js"   integrity="sha256-4/zUCqiq0kqxhZIyp4G0Gk+AOtCJsY1TA00k5ClsZYE="   crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/polleradmin.js"></script>
	<script src="js/Chart.js"></script>
<!--[if lt IE 9]>
<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<link href="css/stylesadmin.css" rel="stylesheet" />

<%@ page import="dto.Poll" %>
<%@ page import="dto.Area" %>
<%@ page import="dto.University" %>
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
												<a style="height:50px" href="addpoll.jsp"><span class="glyphicon glyphicon-plus hidden-xs" aria-hidden="true"></span><span class="text-center glyphicon glyphicon-plus visible-xs"  style ="font-size:medium" aria-hidden="true"> Add Poll</span></a>
											</li>
											<li>
												<a style="height:50px" href="addunivarea.jsp" role="button"><span class="glyphicon glyphicon-education hidden-xs" aria-hidden="true"></span> <span class="text-center glyphicon glyphicon-education visible-xs" style ="font-size:medium" aria-hidden="true"> Add School/Area</span></a>
											</li>
											<li>
												<a style="height:50px" class="active" href="#" role="button"><span class="glyphicon glyphicon-stats hidden-xs" aria-hidden="true"></span><span class="text-center glyphicon glyphicon-stats visible-xs" style ="font-size:medium" aria-hidden="true"> View Poll Stats</span></a></li><li><a href="#logoutModal" class="dropdown-toggle" data-toggle="modal"><i class="glyphicon glyphicon-user"></i></a></li>
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
										<div class="col-sm-10 col-sm-offset-1">
											<div class="row">
												<div class="col-sm-12" style="min-height: 20px;
												padding: 19px;
												margin-bottom: 20px;
												background-color: #f5f5f5;
												border: 1px solid #e3e3e3;
												border-radius: 4px;
												-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);
												box-shadow: inset 0 1px 1px rgba(0,0,0,0.05);">
												<h4 class="center" style="margin-bottom:10px">Choose a Poll Question</h4>
												<form class="form-horizontal" role="form" action="PollSearchController" method="POST">
													<div class="form-group">
														<div class="input-group col-sm-12" style="padding:14px;">
															<input type="text" class="form-control" id="searchstring" name="searchstring" placeholder="Search" />
															<div class="input-group-btn">
              <button class="btn btn-default" type="submit" id="searchbtn"><i class="glyphicon glyphicon-search"></i></button>
            </div>
															
															
															</div>
													</div>
												</form>
												<div>
													<%
													if(request.getAttribute("isSearch")!=null)
														{
													String searchstring=request.getAttribute("isSearch").toString();
													%>
													Showing search results for "<%=searchstring%>"
													<%
												}
												%>
											</div>
											<table class="table table-hover" style="background-color:white;border-radius:10px;border-color:#ccc;border-width:1px">
												<thead> 
													<tr> 
														<th>#</th> 
														<th>Poll Question</th>
														<th>Votes</th>
														<th>Category</th>
														<th>Created At</th>
														<th>Score</th>
													</tr>
												</thead>
												<tbody class="polltable">


													<%ArrayList<Poll> pollList=(ArrayList<Poll>)request.getAttribute("pollList"); 

													int count=1;
													for(Poll poll:pollList)
														{
														String title;
														if(poll.getTitle().length()>=40)
															title=poll.getTitle().substring(0,40)+"... ";
														else
															title=poll.getTitle();
				
																
														
													%><tr data-toggle="modal" class="adminpollelement" id='<%=(long)poll.getPollId()%>' data-target="#postModal" <%if(count>10){%>style="display:none;"<%} %>> <th scope="row"><%=count%></th> <td><%=title%></td> <td><%=poll.getVotes()%></td><td><%=poll.getCategoryName()%></td><td><%=poll.getCreatedAt() %></td><td><%=poll.getScore()%></td></tr> <%

													count++;
												}

												%>
											</tbody>
										</table>
										<nav class="text-center">
											<ul class="pagination">
												<li>
													<a href="#" aria-label="Previous" class="pageno" id=1>
														<span aria-hidden="true">&laquo;</span>
													</a>
												</li>

												<%int pollcount=pollList.size();
												int i;
												for(i=1;i<=Math.ceil(pollcount/10.0);i++){%>

												<li <%if(i==1){%>class="active"<%} %> ><a href="#" class="pageno" id="<%=i%>"><%=i%></a></li>

												<%} %>

												<li>
													<a href="#" aria-label="Next" class="pageno" id='<%=i-1%>'>
														<span aria-hidden="true">&raquo;</span>
													</a>
												</li>
											</ul>
										</nav>
									</div>
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
			
				<p><a href="#" class="pull-right">ęCopyright 2016</a></p>
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
<div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			  	<form action="PollEditPrefetchController" method="post">
			  	<input type="hidden" id="pollid_edit" name="pollid">
			    <input type="submit" class="btn btn-primary pull-left" value="Edit Poll"></input>
				</form>
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button><h4 class="text-center"> Poll Stats</h4></div>
				<div class="modal-body">
				
				<div class="row">
				<div class="col-sm-10 col-sm-offset-1 ">
				<h3 class="text-center">Poll Information</h3>
				<hr>
				<div id="infotitle"> </div>
				<div id="infodesc"></div>
				<div id="infoa"></div>
				<div id="infob"></div>
				<div id="infoc"></div>
				<div id="infod"></div>
				
				</div>
				</div>
				
				<br>
					<div class="row">
						<div class="col-sm-6 text-center">
							<h3><b>Times Answered</b></h3>
							<h4 id='votes'></h4>
						</div>
						<div class="col-sm-6 text-center">
							<h3><b>Most Chosen Answer</b></h3>
							<h4 id='option'></h4>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-6 col-sm-offset-3 text-center">
							<h3>Answer Ratio</h3>
					<div id="answerchartdiv">
							<canvas id="answerchart" width="400" height="400"></canvas>
							</div>
						</div>
					</div>
					
					<br><br>
					<hr>
					<div class="row">
						<div class="col-sm-4 text-center">
							<h4><b>Gender Ratio</b></h4>
				<div id="genderchartdiv">
							<canvas id="genderchart" width="400" height="400"></canvas>
							</div>
						</div>
												<div class="col-sm-4 text-center">
							<h4><b>Male Vote Ratio</b></h4>
				<div id="malechartdiv">
							<canvas id="malechart" width="400" height="400"></canvas>
							</div>
						</div>
						<div class="col-sm-4 text-center">
							<h4><b>Female Vote Ratio</b></h4>
					<div id="femalechartdiv">
							<canvas id="femalechart" width="400" height="400"></canvas>
							</div>
						</div>
						
						
						
						
						
					</div>
					<hr>
					<br><br>
					
					

					
					
					
					

					
					
					
					
				<div class="row">
				
										<div class="col-sm-6 text-center">
							<h3>Age Group Variance</h3>
							<br><br><br><br><br>
					<div id="agechartdiv">
							<canvas id="agechart" width="400" height="400"></canvas>
							</div>
						</div>
					
				
				
				
						<div class="col-sm-6 text-center">
							<h3>Age Based Vote Distribution</h3>
					<form>
					<div class="form-group" style="padding:14px">
                          <label for="age">Select Age</label>
                         <select class="form-control selectpicker"  name="ageselect" class="form-control" id="ageselect">
                         <option selected disabled>Choose One</option>
						<%ArrayList<Integer> ages=(ArrayList<Integer>)request.getAttribute("agelist");
						for(Integer a:ages)
						{
							if(a.intValue()!=0)
							{
						%><option value="<%=a.intValue()%>"><%=a.intValue()%></option><%
							}
						}
						 %>
						</select>
                       
                       
                       </div>
					
					
					
					</form>
					<div id="agedistchartdiv">
							<canvas id="agedistchart" width="400" height="400"></canvas>
							</div>
					</div>
					</div>
										<div class="row">
					
					<div class="col-sm-10 col-sm-offset-1 ">
					<h3 style="text-align:center">Age Vote Table</h3>
					
					<table class="table table-hover" style="background-color:white;border-radius:10px;border-color:#ccc;border-width:1px">
												<thead> 
													<tr> 
														<th>Age Group</th> 
														<th>Option A</th>
														<th>Option B</th>
														<th>Option C</th>
														<th>Option D</th>
														<th>Total</th>
													</tr>
												</thead>
												<tbody id="agetable">
														

											</tbody>
										</table>
					
					
					
					
					
					</div>
					
					</div>
					
					
					
					<hr>
					<br><br>
					
					
					
					<div class="row">
					<div class="col-sm-6 text-center">
							<h3>Area Based Variance</h3>
							<br><br><br><br><br>
					<div id="areachartdiv">
							<canvas id="areachart" width="400" height="400"></canvas>
							</div>
						</div>
					
					
					
						<div class="col-sm-6 text-center">
							<h3>Area Based Vote Distribution</h3>
					<form>
					<div class="form-group" style="padding:14px">
                          <label for="areaselect">Select Area</label>
                         <select class="form-control selectpicker"  name="areaselect" class="form-control" id="areaselect">
                         <option selected disabled>Choose One</option>
						<%ArrayList<Area> areas=(ArrayList<Area>)request.getAttribute("arealist");
						for(Area a:areas)
						{
						%><option value="<%=a.getId()%>"><%=a.getName()%></option><%
						}
						 %>
						</select>
                       
                       
                       </div>
					
					
					
					</form>
					<div id="areadistchartdiv">
							<canvas id="areadistchart" width="400" height="400"></canvas>
							</div>
					</div>
					</div>
					
										<br><br>

					
					
					<br><br>
					<div class="row">
					
					<div class="col-sm-10 col-sm-offset-1 ">
					<h3 style="text-align:center">Area Vote Table</h3>
					
					<table class="table table-hover" style="background-color:white;border-radius:10px;border-color:#ccc;border-width:1px">
												<thead> 
													<tr> 
														<th>Name</th> 
														<th>Option A</th>
														<th>Option B</th>
														<th>Option C</th>
														<th>Option D</th>
														<th>Total</th>
													</tr>
												</thead>
												<tbody id="areatable">
														

											</tbody>
										</table>
					
					
					
					
					
					</div>
					
					</div>
					
					
					<hr>
					<br><br>
					
					
					
					
					
					
					<div class="row">
						
					<div class="col-sm-6 text-center">
							<h3>University Based Variance</h3>
							<br><br><br><br><br>
					<div id="univchartdiv">
							<canvas id="univchart" width="400" height="400"></canvas>
							</div>
						</div>
						
						
						
						
						<div class="col-sm-6 text-center">
							<h3>University Based Vote Distribution</h3>
					<form>
					<div class="form-group" style="padding:14px">
                          <label for="univselect">Select University</label>
                         <select class="form-control selectpicker"  name="univselect" class="form-control" id="univselect">
                         <option selected disabled>Choose One</option>
						<%ArrayList<University> univs=(ArrayList<University>)request.getAttribute("univlist");
						for(University u:univs)
						{
						%><option value="<%=u.getId()%>"><%=u.getName()%></option><%
						}
						 %>
						</select>
                       
                       
                       </div>
					
					
					
					</form>
					<div id="univdistchartdiv">
							<canvas id="univdistchart" width="400" height="400"></canvas>
							</div>
					</div>
					</div>
					<br><br>
					<div class="row">
					
					<div class="col-sm-10 col-sm-offset-1 ">
					<h3 style="text-align:center">University Vote Table</h3>
					
					<table class="table table-hover" style="background-color:white;border-radius:10px;border-color:#ccc;border-width:1px">
												<thead> 
													<tr> 
														<th>Name</th> 
														<th>Option A</th>
														<th>Option B</th>
														<th>Option C</th>
														<th>Option D</th>
														<th>Total</th>
													</tr>
												</thead>
												<tbody id="schooltable">
														

											</tbody>
										</table>
					
					
					
					
					
					</div>
					
					</div>
					
					<hr>
					<br><br>
					
					
					
					
					
					<div class="row">
						<div class="col-sm-6 text-center">
							<h3>Combinational Distribution</h3>
					<form>
					
					<div class="form-group" style="padding:14px">
                          <label for="age">Select Gender</label>
                         <select class="form-control selectpicker"  name="genderselect" class="form-control" id="gendercombselect">
                         <option selected disabled>Choose One</option>
                          <option value="-1">None</option>
							<option value="0">Male</option>
							<option value="1">Female</option>

						</select>
                       
                       
                       </div>
					
					
					
					<div class="form-group" style="padding:14px">
                          <label for="age">Select Age</label>
                         <select class="form-control selectpicker"  name="ageselect" class="form-control" id="agecombselect">
                         <option selected disabled>Choose One</option>
                          <option value="-1">None</option>
						<%ages=(ArrayList<Integer>)request.getAttribute("agelist");
						for(Integer a:ages)
						{
						if(a.intValue()!=0)
						{
						%><option value="<%=a.intValue()%>"><%=a.intValue()%></option><%
						}
						}
						 %>
						</select>
                       
                       
                       </div>
					
					<div class="form-group" style="padding:14px">
                          <label for="areaselect">Select Area</label>
                         <select class="form-control selectpicker"  name="areaselect" class="form-control" id="areacombselect">
                         <option selected disabled>Choose One</option>
                          <option value="-1">None</option>
						<%areas=(ArrayList<Area>)request.getAttribute("arealist");
						for(Area a:areas)
						{
						%><option value="<%=a.getId()%>"><%=a.getName()%></option><%
						}
						 %>
						</select>
                       
                       
                       </div>
					
					
					<div class="form-group" style="padding:14px">
                          <label for="univselect">Select University</label>
                         <select class="form-control selectpicker"  name="univselect" class="form-control" id="univcombselect">
                         <option selected disabled value="-2">Choose One</option>
                         <option value="-1">None</option>
						<%univs=(ArrayList<University>)request.getAttribute("univlist");
						for(University u:univs)
						{
						%><option value="<%=u.getId()%>"><%=u.getName()%></option><%
						}
						 %>
						</select>
                       
                       
                       </div>
					
					

					</form>
					<button class="btn btn-primary btn-lg" aria-hidden="true" id="generate">Generate!</button>

					</div>
					
					<div class="col-sm-6 text-center">
					<br><br><br>
										<div id="combdistchartdiv">
							<canvas id="combdistchart" width="400" height="400"></canvas>
							</div>
							</div>
					
					
					
					</div>
					<br><br>
					
					
					
					
					
					
					
						
						
					
					
					
					
					
				</div>
				
				
				
				
				<div class="modal-footer">
					<div>
						<button class="btn btn-primary btn-lg" data-dismiss="modal" aria-hidden="true">Ok</button>
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

</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
</body>
</html>
