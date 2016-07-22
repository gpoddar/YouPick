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
<%@ page import="dto.Area" %>
<%@ page import="dto.University" %>
<%@ page import="java.util.ArrayList" %>

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

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">

</head>

<body style="overflow:hidden">
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
          <a href="home.jsp" style="margin-left:120px" class="navbar-brand logo">P</a>
        </div>
        <nav class="collapse navbar-collapse" role="navigation">
          <form class="navbar-form navbar-left" style="display:none">
            <div class="input-group input-group-sm" style="max-width:360px;">
              <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
              <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
              </div>
            </div>
          </form>

          <ul class="nav navbar-nav navbar-right">
            <li>
              <a href="home.jsp" role="button" >Home</a>
            </li>
            <li>
              <a href="#loginModal" role="button" data-toggle="modal" style="display:none">Login</a>
            </li>
            <li>
              <a href="#signupModal" role="button" data-toggle="modal" style="display:none">SignUp</a>
            </li>
            <li class="dropdown" style="display:block">
              <a href="#" class="active dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i></a>
              <ul class="dropdown-menu">
                <li><a href="myansweredpolls.jsp">My Answered Polls</a></li>
                 <%if(session.getAttribute("fbLogin").toString().equals("false")){ %><li><a href="changepassword.jsp">Change Password</a></li><%} %>
                <li><a href="#logoutModal" data-toggle="modal">Logout</a></li>                   
              </ul>
            </li>
          </ul>
        </nav>
      </div>
      <!-- /top nav -->
      <div class="row row-offcanvas row-offcanvas-left" style="position:static">


        <!-- main right col -->
        <div class="column col-sm-12 col-xs-12" id="main">



          <div class="padding" id="mainscroll">
            <div class="full col-sm-9" id="innerBody">

              <!-- content -->  
              <div class="pollElement">
                <div class="row" >
                  <div class="col-sm-5 col-md-offset-3">
                    <div class="well">
                      <h3 style="font-weight:600" class="center">My Profile</h3>
                      <br>
                      <form class="form-horizontal" id="profileForm" method="POST" role="form" action="ProfileSaveController">
                        <div class="form-group" style="padding:14px">
                          <label for="email">Email address *</label>
                          <input type="email" class="form-control" name="email" id="email" placeholder="Email" value='<%=request.getAttribute("emailID").toString()%>'>
                        </div>
                        <div class="form-group" style="padding:14px">
                          <label for="fullName">Full Name</label>
                          <input type="text" class="form-control" name="name" id="fullName" placeholder="Full Name" value='<%=request.getAttribute("name").toString()%>'>
                        </div>
                        <div class="form-group" style="padding:14px">
                          <label for="university">Age</label>
                          <input type="text" class="form-control" name="age" id="age" placeholder="Age" value='<%=request.getAttribute("age").toString()%>'>
                        </div>
                        
                        <div class="form-group" style="padding:14px">
                          <label for="gender">Gender</label>

                        <select name="gender" class="form-control selectpicker">
						<option value="Male">Male</option> 
						<option value="Female">Female</option> 
						</select>
                        
                        </div>
                        <div class="form-group" style="padding:14px">
                          <label for="area">Area</label>
                         <select name="area" class="form-control selectpicker">
						<%ArrayList<Area> area=(ArrayList<Area>)request.getAttribute("arealist");
						for(Area a:area)
						{
						%><option value="<%=a.getId()%>"><%=a.getName()%></option><%
						}
						 %>
						</select>
                       
                       
                       </div>
                        <div class="form-group" style="padding:14px">
                          <label for="area">School/College</label>
                          
                        <select name="university" class="form-control selectpicker">
						<%ArrayList<University> univ=(ArrayList<University>)request.getAttribute("univlist");
						for(University u:univ)
						{
						%><option value="<%=u.getId()%>"><%=u.getName()%></option><%
						}
						 %>
						</select>
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
                  </div>

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

  <script src="js/scrollingelement.js"></script>
</body>

<script   src="https://code.jquery.com/jquery-2.2.2.js"   integrity="sha256-4/zUCqiq0kqxhZIyp4G0Gk+AOtCJsY1TA00k5ClsZYE="   crossorigin="anonymous"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<script type="text/javascript" src="js/clipboard.js"></script>
<script type="text/javascript" src="js/jquery.waypoints.js"></script>\
<script src="js/modernizr-2.6.2.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/additional-methods.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>

<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "http://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.6&appId=1752061305005986";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
</script>

<script>
$(document).ready(function () {

  $('#profileForm').validate({

    rules: {
      email: {
        required: true,
        email: true
      },
      fullName: {
        lettersonly: true
      }
    },
    messages: {
      email: {
        required: "Please enter an email address",
        email: "Your email address must be in the format of name@domain.com"
      },
      fullName:{
        lettersonly : "Full Name must contain only alphabets",
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
</html>