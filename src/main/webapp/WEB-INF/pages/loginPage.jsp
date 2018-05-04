<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>Credit Login / Register Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Credit Login / Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Custom Theme files -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- //Custom Theme files -->
    <!-- web font -->
    <link href="//fonts.googleapis.com/css?family=Oswald:400,700" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

    <!-- //web font -->
</head>
<body>
<jsp:include page="_menu.jsp" />
<h1>Doctors Prescription</h1>
<div class="main-agileits">
    <!--form-stars-here-->
    <div class="form-w3-agile">
        <h2>Social Login</h2>

        <a href="${pageContext.request.contextPath}/auth/facebook">Face
            Book</a>
        <br />
        <a href="${pageContext.request.contextPath}/auth/google">Google</a>
        <br />

        <h2>Please Login & Identify</h2>
        <!-- /login?error=true -->
        <c:if test="${param.error == 'true'}">
            <div style="color:red;margin:10px 0px;">

                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

            </div>
        </c:if>
        <form action="${pageContext.request.contextPath}/login/authenticate" method="post">
            <div class="form-sub-w3">
                <input type="text" name="username" placeholder="Username " required="" />
                <div class="icon-w3">
                    <i class="fa fa-user" aria-hidden="true"></i>
                </div>
            </div>
            <div class="form-sub-w3">
                <input type="password" name="password" placeholder="Password" required="" />
                <div class="icon-w3">
                    <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                </div>
            </div>
            <p class="p-bottom-w3ls">Are you new here?<a class="w3_play_icon1" href="#small-dialog1">   Register here</a></p>

            <div class="submit-w3l">
                <input type="submit" value="Login">
            </div>
        </form>
    </div>
    <!--//form-ends-here-->
</div>
<div id="small-dialog1" class="mfp-hide">
    <div class="contact-form1">
        <div class="contact-w3-agileits">
            <h3>Register Form</h3>
            <form action="${pageContext.request.contextPath}/signup" method="get">
                <div class="form-sub-w3ls">
                    <input name="username" placeholder="User Name"  type="text" required="">
                    <div class="icon-agile">
                        <i class="fa fa-user" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="form-sub-w3ls">
                    <input name="firstName" placeholder="First name"  type="text" required="">
                    <div class="icon-agile">
                        <i class="fa fa-user" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="form-sub-w3ls">
                    <input name="lastName" placeholder="Last Name"  type="text" required="">
                    <div class="icon-agile">
                        <i class="fa fa-user" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="form-sub-w3ls">
                    <input name="email" placeholder="Email" class="mail" type="email" required="">
                    <div class="icon-agile">
                        <i class="fa fa-envelope-o" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="form-sub-w3ls">
                    <input name="password" placeholder="Password"  type="password" required="">
                    <div class="icon-agile">
                        <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="form-sub-w3ls">
                    <input name="passwordVerification" placeholder="Confirm Password"  type="password" required="">
                    <div class="icon-agile">
                        <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                    </div>
                </div>
        </div>
        <div class="login-check">
            <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><p>I Accept Terms & Conditions</p></label>
        </div>
        <div class="submit-w3l">
            <input type="submit" value="Register">
        </div>
        </form>
    </div>
</div>
</div>
<!-- copyright -->
<!--<div class="copyright w3-agile">
    <p> © 2017 Credit Login / Register Form . All rights reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>
</div>-->
<!-- //copyright -->
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<!-- pop-up-box -->
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<!--//pop-up-box -->
<script>
    $(document).ready(function() {
        $('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
            type: 'inline',
            fixedContentPos: false,
            fixedBgPos: true,
            overflowY: 'auto',
            closeBtnInside: true,
            preloader: false,
            midClick: true,
            removalDelay: 300,
            mainClass: 'my-mfp-zoom-in'
        });

    });
</script>
</body>
</html>