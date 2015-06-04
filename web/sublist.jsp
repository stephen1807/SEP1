<%--
  Created by IntelliJ IDEA.
  User: Zo
  Date: 5/21/2015
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
  v1.1 change the table css
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class="loading">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=0.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="keywords" content="CSS????? uehtml ???? DIV+CSS Javascript ?? ???? ???? ???? CSS3"/>
    <meta name="description" content="??? ?????">
    <meta name="author" content="???"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=no" name="format-detection">
    <link rel="apple-touch-icon-precomposed" href="http://www.17sucai.com/static/images/favicon.ico">

    <script>
        var logined = 0
    </script>

    <script src="js/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/table-Animation.css">
    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/demo.js"></script>

    <title>Attendance System</title>
</head>

<body>
<script>
    var now_page = 1,
            search_value = '';
</script>

<div id="menu">
    <div class="search_wrap"></div>
    <ul><li class="nav_index"><a href="home.jsp"><i></i><span>Home</span><b></b>
        <div class="clear"></div></a></li>
        <li class="nav_site"><a href="profile.jsp"><i></i><span>Profile</span><b></b>
            <div class="clear"></div></a></li>
        <li class="nav_site menu_cur"><a href="sublist.jsp"><i></i><span>Subordinate</span><b></b>
            <div class="clear"></div></a></li>
    </ul>

</div>
<div id="user">
    <div class="account">
        <div class="login_b_t">
            <div class="pd10">
                <div class="fl">Logout</div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    <div class="pd10">
        <form><a class="login_submit" href="login.html">LOGOUT</a></form>
    </div>
</div>


<div id="header">
    <div class="wrap">
        <i class="menu_open"></i>
        <div class="logo"><a title="uthml????"><img src="css/logo.png"/></a></div>
        <i class="search_open"></i>
    </div>
    <div class="logo_msk"></div>
</div>

<div id="container">
    <div id="sort"></div>
    <div id="content">
        <table id="example" class="display" cellspacing="0" width="50%">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Department</th>
                <th>Salary</th>
                <th>Details</th>
            </tr>
            </thead>

            <tfoot>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Department</th>
                <th>Salary</th>
                <th>Details</th>
            </tr>
            </tfoot>

            <tbody>
            <tr>
                <td>1</td>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>50000</td>
                <td>Edinburgh</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Garrett Winters</td>
                <td>Accountant</td>
                <td>53000</td>
                <td>Tokyo</td>
            </tr>
            <tr>
                <td>3</td>
                <td>Ashton Cox</td>
                <td>Junior Technical Author</td>
                <td>70000</td>
                <td>San Francisco</td>
            </tr>
            <tr>
                <td>4</td>
                <td>Cedric Kelly</td>
                <td>Senior Javascript Developer</td>
                <td>80000</td>
                <td>Edinburgh</td>
            </tr>
            <tr>
                <td>5</td>
                <td>Airi Satou</td>
                <td>Accountant</td>
                <td>90000</td>
                <td>Tokyo</td>
            </tr>
            <tr>
                <td>6</td>
                <td>Brielle Williamson</td>
                <td>Integration Specialist</td>
                <td>150000</td>
                <td>New York</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="push_msk"></div>
</div>
<div class="clear"></div>



<div class="loading_dark"></div>
<div id="loading_mask">
    <div class="loading_mask">
        <ul class="anm">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</div>
<script language="javascript" src="js/zepto.min.js"></script>
<script language="javascript" src="js/fx.js"></script>
<script language="javascript" src="js/script.js"></script>

</body>
</html>
