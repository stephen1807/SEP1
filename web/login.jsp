<%--
  Created by IntelliJ IDEA.
  User: Zo
  Date: 5/21/2015
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
    <!-- Custom Theme files -->
    <!-- Custom Theme files -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <!--Google Fonts-->
    <link rel="stylesheet" href="css/login.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/slide.css" type="text/css" media="screen" />
    <!--Google Fonts-->
    <script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
    <!-- Sliding effect -->
    <script src="js/slide.js" type="text/javascript"></script>
</head>
<script>
    function dologin() {
        var username = document.getElementById("userid").value;
        var password = document.getElementById("password").value;

        myform.action = "<%=basePath%>servlet/LoginServlet";
        myform.submit();
    }
</script>
<%if (session.getAttribute("userid") == null) { %>
<body>
<form id="myform">
    <<<<<<< HEAD
    <div id="toppanel">
        <div id="panel">
            <div class="content clearfix">
                <div class="left">
                    <h1>Welcome</h1>
                    <h2>This is Company .....</h2>
                    <p class="grey">For registered Employee please type your user name and password and i will make sure u never got your salatry so u can suffer for the rest of your life</p>
                </div>
                <div class="left">
                    <!-- Login Form -->
                    <form class="clearfix" action="#" method="post">
                        <h1>Employee Login</h1>
                        <label class="grey" for="log">Username:</label>
                        <input class="field" type="text" id="userid" value="User Id" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = 'User Id';}"size="23" />
                        <label class="grey" for="pwd">Password:</label>
                        <input class="field" type="password" id="password" value="password" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = 'password';}" size="23" />
                        <input type="submit" value="Login" onclick="dologin()" />
                    </form>
                </div>

            </div>
        </div> <!-- /login -->

        <!-- The tab on top -->
        <div class="tab">
            <ul class="login">
                <li class="left">&nbsp;</li>
                <li>Hello Employee!</li>
                <li class="sep">|</li>
                <li id="toggle">
                    <a id="open" class="open" href="#">Log In | Register</a>
                    <a id="close" style="display: none;" class="close" href="#">Close Panel</a>
                </li>
                <li class="right">&nbsp;</li>
            </ul>
        </div> <!-- / top -->

    </div> <!--panel -->

    <div id="container">
        <div id="content" style="padding-top:100px;">
            <h1>Welcome Employee of the company bLALALALALLA</h1>
            <h2>Work Hard so i can enjoy it</h2>
            <p>............................</p>

            <p>.............</p>

            <p>.............</p>

            <p>.............</p>

            <h2>What is in this company</h2>
            <ul>
                <li>Employee</li>
                <li>Profile</li>
                <li>Setting</li>
                <li>Superior</li>
            </ul>

            <h2>Known Bugs</h2>
            <ul>
                <li>Havent Found it yet </li>
            </ul>


            <h2>and now some bulshit to share</h2>

            <p> I want go to Hongkong</p>

            <p> I want go to Australia</p>
        </div><!-- / content -->
    </div><!-- / container -->
    =======
    <div class="login">
        <h2>Acced Form</h2>

        <div class="login-top">
            <h1>LOGIN FORM</h1>

            <form>
                <input type="text" id="userid" value="User Id" onfocus="this.value = '';"
                       onblur="if (this.value == '') {this.value = 'User Id';}">
                <input type="password" id="password" value="password" onfocus="this.value = '';"
                       onblur="if (this.value == '') {this.value = 'password';}">
            </form>
            <div class="forgot">
                <input type="submit" value="Login" onclick="dologin()">
            </div>
        </div>
    </div>
    <div class="copyright">
        <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="">OUR TEAM</a></p>
    </div>
    >>>>>>> origin/jsp
</form>
</body>
<%} else {%>
<jsp:forward page="home.jsp"></jsp:forward>
<%} %>
</html>
