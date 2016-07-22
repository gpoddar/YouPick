<!DOCTYPE html>
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
          <a href="index.html" style="margin-left:120px" class="navbar-brand logo">P</a>
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
              <a href="index.html" role="button" >Home</a>
            </li>

          </ul>
        </nav>
      </div>
      <!-- /top nav -->
      <div class="row row-offcanvas row-offcanvas-left">
        <button type="button" id="catTag" data-toggle="showcats" class="visible-xs btn btn-default cat-tag text-center">
          <a href="#"><i class="glyphicon glyphicon-chevron-right"></i></a>
        </button>

        <!-- main right col -->
        <div class="column col-sm-12 col-xs-12" id="main">



          <div class="padding" id="mainscroll">
            <div class="full col-sm-9" id="innerBody">

              <!-- content -->  
              <div class="pollElement">
                <div class="row" >
                  <div class="col-sm-5 col-md-offset-3">
                    <div class="well">
                      <h3 style="font-weight:600" class="center">Forgot Password</h3>
                      <br>
                      <form id="forgotPasswordForm" class="form-horizontal" method="POST" role="form">
                        <div class="form-group" style="padding:14px">
                          <label for="emailPass">Email Password *</label>
                          <input type="password" class="form-control" name="emailPass" id="emailPass" placeholder="Email Password">
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
          <a href="#" data-dismiss="modal" class="btn btn-primary facebook modal-login-btn" style="width:45%">Yes</a>
          <a href="#" data-dismiss="modal" class="btn btn-primary facebook modal-login-btn" style="margin-left:5%;width:45%">Cancel</a>
        </div>
      </div>
    </div>
  </div>

  <script src="js/scrollingelement.js"></script>
</body>

<script   src="https://code.jquery.com/jquery-2.2.2.js"   integrity="sha256-4/zUCqiq0kqxhZIyp4G0Gk+AOtCJsY1TA00k5ClsZYE="   crossorigin="anonymous"></script>
<script type="text/javascript" src="js/poller.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<script type="text/javascript" src="js/jquery.waypoints.js"></script>
<script src="js/modernizr-2.6.2.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/additional-methods.min.js"></script>


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

  $('#forgotPasswordForm').validate({
    rules: {
      emailPass: {
        required: true,
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
      emailPass:{
        required: "Please enter the email password",
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
</html>