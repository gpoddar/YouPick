<!DOCTYPE html>
<%

response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store"); 
response.setDateHeader("Expires", 0); 
response.setHeader("Pragma","no-cache");
Object userName =session.getAttribute("userID");

if( userName==null) 
  {

RequestDispatcher rd = request.getRequestDispatcher("loginfail.jsp");
rd.forward(request, response);
}
else
{
	session.setAttribute("loadedPolls",new ArrayList<String>());
}


%>
<html lang="en">
<head>
<%@ page import="java.io.*,java.util.*"%>

  <meta property="og:url"           content="http://122.170.82.251:8080/Polling/viewpoll.jsp?param=5" />
  <meta property="og:type"          content="website" />
  <meta property="og:title"         content="Pulse" />
	<meta property="og:description"   content="The best Polling website ever" />
	<meta property="og:image"         content="https://rmsbunkerblog.files.wordpress.com/2011/09/polling-research-firm-syracuse-ny.jpg" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <title>Poller</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  

  
  
  
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/font-awesome.min.css"/>
<!--[if lt IE 9]>
<script type="text/javascript" src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<link href="css/styles.css" rel="stylesheet">
<link href="css/Loader.css" rel="stylesheet">


<link href="css/demo.css" rel="stylesheet">
<script   src="https://code.jquery.com/jquery-2.2.2.js" ></script>



</head>

<body style="overflow:hidden">
<div class=myloaderbackground></div>
<span class="loader"><span class="loader-inner"></span></span>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.6&appId=1752061305005986";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<div class="wrapper">
  <div class="box">
    <!-- top nav -->
    <div class="navbar navbar-blue navbar-static-top" style="position:initial;margin:0px">  
      <div class="navbar-header">
        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a href="#" style="margin-left:120px" class="navbar-brand logo">P</a>
      </div>
      <nav class="collapse navbar-collapse" role="navigation">
        <form class="navbar-form navbar-left" action="SearchPoll.jsp">
          <div class="input-group input-group-sm" style="max-width:360px;">
            <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
            <div class="input-group-btn">
              <button class="btn btn-default" type="submit" id="searchbtn"><i class="glyphicon glyphicon-search"></i></button>
            </div>
          </div>
        </form>

        <ul class="nav navbar-nav navbar-right">
          <li>
            <a href="#" role="button" class="active">Home</a>
          </li>
          <li class="dropdown" style="display:block">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i></a>
            <ul class="dropdown-menu">
              <li><a href="myprofile.jsp">My Profile</a></li>
              <li><a href="myansweredpolls.jsp">My Answered Polls</a></li>
               <%if(session.getAttribute("fbLogin").toString().equals("true")){ %><li><a href="changepassword.jsp">Change Password</a></li><%} %>
              <li><a href="#logoutModal" data-toggle="modal">Logout</a></li>                   
            </ul>
          </li>
        </ul>
      </nav>
    </div>
    <!-- /top nav -->
    <div class="row row-offcanvas row-offcanvas-left">
      <button type="button" id="catTag" data-toggle="showcats" class="visible-xs btn btn-default cat-tag text-center">
        <a href="#"><i class="glyphicon glyphicon-chevron-right"></i></a>
      </button>

      <!-- sidebar -->
      <div class="column col-sm-1 col-xs-1 sidebar-offcanvas hidden-xs" id="sidebar">
        <ul class="nav nav-center" style="width:100%;left:-1px" id="lg-menu" currentSelectedCategory="-1">
          <li><a href="#" id="categoryclick" data-toggle="showcats" class="visible-xs text-center"><i class="glyphicon glyphicon-chevron-left"></i></a></li>
          <li class="text-center"><h5>Categories</h5></li>
          <hr>
          <li class="category text-center" id="-1"><a class="active">All</a></li>

        </ul>

        <!-- tiny only nav-->
<!--
<ul class="nav visible-xs" id="xs-menu">
<li><a href="#featured" class="text-center"><i class="glyphicon glyphicon-list-alt"></i></a></li>
<li><a href="#stories" class="text-center"><i class="glyphicon glyphicon-list"></i></a></li>
<li><a href="#" class="text-center"><i class="glyphicon glyphicon-paperclip"></i></a></li>
<li><a href="#" class="text-center"><i class="glyphicon glyphicon-refresh"></i></a></li>
</ul>
--!>

</div>
<!-- /sidebar -->

<!-- main right col -->
<div class="column col-sm-11 col-xs-12" id="main">



  <div class="padding" id="mainscroll">
    <div class="full col-sm-9" id="innerBody">
      <div id="pagetop"></div>

      <!-- content -->  
      <div id="Logo">
      <div>


      <div class="row" id="footerrow">
        <div class="col-sm-6">

        </div>
      </div>





      <hr>


    </div><!-- /col-9 -->
  </div><!-- /padding -->
</div>
<!-- /main -->

</div>
</div>
</div>

<!--logout modal-->
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

<!--Link copied successfully modal-->
<div id="linkSuccessModal" class="modal fade" style="overflow:hidden" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" id="login-box">
    <div class="modal-content">
      <div class="modal-body panel-body" style="padding:20px">
        <h4>Link Copied Successfully!</h4>
        <a href="#" data-dismiss="modal" class="btn btn-primary facebook modal-login-btn" style="width:100%">OK</a>
      </div>
    </div>
  </div>
</div>

<!--Link copy failed modal-->
<div id="linkFailureModal" class="modal fade" style="overflow:hidden" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" id="login-box">
    <div class="modal-content">
      <div class="modal-body panel-body" style="padding:20px">
        <h4>Sorry! Link could not be copied.</h4>
        <a href="#" data-dismiss="modal" class="btn btn-primary facebook modal-login-btn" style="width:100%">OK</a>
      </div>
    </div>
  </div>
</div>

<script src="js/scrollingelement.js"></script>
</body>


<script type="text/javascript" src="js/clipboard.js"></script>
<script type="text/javascript" src="js/poller.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<script src="js/modernizr-2.6.2.min.js"></script>



</html>