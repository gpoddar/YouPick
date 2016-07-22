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


%>
<html lang="en">
<head>
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



</head>

<body style="overflow:hidden">

  <script>
// This is called with the results from from FB.getLoginStatus().
function statusChangeCallback(response) {
  console.log('statusChangeCallback');
  console.log(response);
// The response object is returned with a status field that lets the
// app know the current login status of the person.
// Full docs on the response object can be found in the documentation
// for FB.getLoginStatus().
if (response.status === 'connected') {
// Logged into your app and Facebook.
testAPI();
} else if (response.status === 'not_authorized') {
// The person is logged into Facebook, but not your app.
} else {
// The person is not logged into Facebook, so we're not sure if
// they are logged into this app or not.

}
}

// This function is called when someone finishes with the Login
// Button.  See the onlogin handler attached to it in the sample
// code below.
function checkLoginState() {
  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });
}

function loginFB() {
  FB.login(function(response) {
    if (response.status === 'connected') {
// Logged into your app and Facebook.
console.log(response.authResponse.accessToken);
location.reload();
} else if (response.status === 'not_authorized') {
// The person is logged into Facebook, but not your app.
} else {
// The person is not logged into Facebook, so we're not sure if
// they are logged into this app or not.
}
});
}

window.fbAsyncInit = function() {
  FB.init({
    appId      : '1752061305005986',
cookie     : true,  // enable cookies to allow the server to access 
// the session
xfbml      : true,  // parse social plugins on this page
version    : 'v2.5' // use graph api version 2.5
});
};

// Load the SDK asynchronously
(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "http://connect.facebook.net/en_US/sdk.js";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

// Here we run a very simple test of the Graph API after login is
// successful.  See statusChangeCallback() for when this call is made.
function testAPI() {
  console.log('Welcome!  Fetching your information.... ');
  FB.api('/me', function(response) {
    console.log('Successful login for: ' + response.name);
    document.getElementById('myName').innerHTML =
    '  ' + response.name;
  });
}
</script>

<div class=myloaderbackground></div>
<span class="loader"><span class="loader-inner"></span></span>

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
            <a href="home.jsp" role="button" class="active">Home</a>
          </li>
          <li class="dropdown" style="display:block">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i></a>
            <ul class="dropdown-menu">
              <li><a href="myprofile.jsp">My Profile</a></li>
              <li><a href="myansweredpolls.jsp">My Answered Polls</a></li>
               <%if(session.getAttribute("fbLogin").toString().equals("false")){ %><li><a href="changepassword.jsp">Change Password</a></li><%} %>
              <li><a href="#logoutModal" data-toggle="modal">Logout</a></li>                   
            </ul>
          </li>
        </ul>
      </nav>
    </div>
    <!-- /top nav -->
    <div class="row row-offcanvas row-offcanvas-left">


      <!-- sidebar -->
      <div >


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
<div class="column col-sm-12 col-xs-12" id="main">



  <div class="padding" id="mainscroll">
    <div class="full col-sm-9" id="innerBody">
      <div id="pagetop"></div>

      <!-- content -->  
      <div class="pollElement">
        <div class="row" >
          <div class="col-sm-6 col-md-offset-3">
            <div class="panel panel-default">

              <div class="panel-thumbnail"><img src="img/img.jpg" class="img-responsive"></div>
              <div class="panel-body">
                <h4>Title here</h4>

                <div class="clearfix"></div>
                <hr>



                <p>Description here</p>


                <div class="clearfix"></div>
                <hr>
                <div>


                  <div class="answers" id="123">
                    <div class="answerbox" id="box1"  bar1="one" bar2="two" bar3="three" bar4="four">
                      <div id="answerboxdiv" >
                        <div id="overlay" overlay="one"></div>
                        <div id="answertext">Answer</div>
                        <div id="value" percent="one"></div>
                        <div id="outer" align="center">
                          <div id="inner" bar="one"></div>
                        </div>
                      </div>
                    </div>
                    <div class="answerbox" id="box2" bar1="one" bar2="two" bar3="three" bar4="four">
                      <div id="answerboxdiv" >
                        <div id="overlay" overlay="two"></div>
                        <div id="answertext">Answer</div>
                        <div id="value" percent="two"></div>
                        <div id="outer" align="center">
                          <div id="inner" bar="two"></div>
                        </div>
                      </div>

                    </div>
                    <div class="answerbox" id="box3" bar1="one" bar2="two" bar3="three" bar4="four">


                      <div id="answerboxdiv" >
                        <div id="overlay" overlay="three"></div>
                        <div id="answertext">Answer</div>
                        <div id="value" percent="three"></div>
                        <div id="outer" align="center">
                          <div id="inner" bar="three"></div>
                        </div>
                      </div>

                    </div>
                    <div class="answerbox" id="box4" bar1="one" bar2="two" bar3="three" bar4="four">

                      <div id="answerboxdiv" >
                        <div id="overlay" overlay="four"></div>
                        <div id="answertext">Answer</div>

                        <div id="value" percent="four"></div>
                        <div id="outer" align="center">
                          <div id="inner" bar="four"></div>
                        </div>
                      </div>
                    </div>
                  </div>






                </div>



                <hr>

                <div class="fb-comments" data-href="http://122.170.79.72:8080/Project5/poll/demos/demo.html" data-width="100%" data-numposts="5"></div>


              </div>
            </div>
          </div>

        </div>
      </div>







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

<!--login modal-->
<div id="loginModal" class="modal fade" style="overflow:hidden" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" id="login-box">
    <div class="modal-content">
      <div class="modal-body panel-body" style="padding:20px">
        <div class='modal-body-left'>
          <div class="modal-social-icons">
            <a href='#' onclick="loginFB()" class="btn btn-default facebook" style="padding:6px 12px;"> <i class="fa fa-facebook modal-icons"></i> <h6 class="my-hidden-xs" style="margin-top:0px">Continue with Facebook</h6> <h6 class="my-visible-xs" style="margin-top:0px">FB Login</h6> </a>
          </div>
          <br><br>
          <h4 class="text-center">OR</h4>
          <br><br>
          <h4 class="text-center"><a href="#signupModal" data-toggle="modal" data-dismiss="modal" class="login-link text-xs">Continue with Email</a></h4>
        </div>

        <div class='modal-body-right'>
          <h4>Login</h4>
          <div class="form-group">
            <input type="email" id="email" placeholder="Email" value="" class="form-control login-field">
            <i class="fa fa-user login-field-icon"></i>
          </div>

          <div class="form-group">
            <input type="password" id="pass" placeholder="Password" value="" class="form-control login-field">
            <i class="fa fa-lock login-field-icon"></i>
          </div>
          <a href="#" class="login-link text-center">Forgot your password?</a>
        </br></br>
        <a href="#" class="btn btn-primary facebook modal-login-btn">Login</a>
      </div>	
    </div>
  </div>
</div>
</div>

<!--logout modal-->
<div id="logoutModal" class="modal fade" style="overflow:hidden" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" id="login-box">
    <div class="modal-content">
      <div class="modal-body panel-body" style="padding:20px">
        <h4>Are you sure you want to logout?</h4>
        < <a href="LogoutController.logout" class="btn btn-primary facebook modal-login-btn" style="width:45%">Yes</a>
        <a href="#" data-dismiss="modal" class="btn btn-primary facebook modal-login-btn" style="margin-left:5%;width:45%">Cancel</a>
      </div>
    </div>
  </div>
</div>

<!--signup modal-->
<div id="signupModal" class="modal fade" style="overflow:hidden" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" id="login-box">
    <div class="modal-content">
      <div class="modal-body panel-body" style="padding:20px">
        <h4>Sign Up</h4>
        <form action="UserSignupController" method="post">
          <div class="form-group">
            <input type="email" id="email" placeholder="Email" value="" class="form-control login-field">
            <i class="fa fa-user login-field-icon"></i>
          </div>

          <div class="form-group">
            <input type="password" id="pass" placeholder="Password" value="" class="form-control login-field">
            <i class="fa fa-lock login-field-icon"></i>
          </div>

          <div class="form-group">
            <input type="password" id="confirm-pass" placeholder="Confirm Password" value="" class="form-control login-field">
            <i class="fa fa-lock login-field-icon"></i>
          </div>
          <input type="submit" class="btn btn-primary facebook modal-login-btn">
        </form>
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

<script   src="https://code.jquery.com/jquery-2.2.2.js" ></script>
<script type="text/javascript" src="js/pollersearch.js"></script>
<script type="text/javascript" src="js/clipboard.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<script src="js/modernizr-2.6.2.min.js"></script>


<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "http://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.6&appId=1752061305005986";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
</script>
</html>