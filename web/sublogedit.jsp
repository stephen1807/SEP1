<%--
  Created by IntelliJ IDEA.
  User: Zo
  Date: 5/21/2015
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
  v1.1 adding content with jquery
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
  <meta name="keywords" content="CSS酷站收录站 uehtml 网页设计 DIV+CSS Javascript 酷站 酷站收录 网站设计 网页设计 CSS3"/>
  <meta name="description" content="优艺客 设计师网站">
  <meta name="author" content="优艺客"/>
  <link rel="stylesheet" type="text/css" href="css/style.css"/>
  <meta content="yes" name="apple-mobile-web-app-capable">
  <meta content="black" name="apple-mobile-web-app-status-bar-style">
  <meta content="telephone=no" name="format-detection">
  <link rel="apple-touch-icon-precomposed" href="http://www.17sucai.com/static/images/favicon.ico">
  <script>
    var logined = 0
  </script>
  <title>Attendance System</title>
</head>

<body>
<script>
  var now_page = 1,
          search_value = '';
</script>

<div id="menu">
  <div class="search_wrap">
  </div>
  <ul>
    <li class="nav_index"><a href="home.jsp"><i></i><span>Home</span><b></b>

      <div class="clear"></div>
    </a></li>
    <li class="nav_site"><a href="profile.jsp"><i></i><span>Profile</span><b></b>

      <div class="clear"></div>
    </a></li>
    <li class="nav_site menu_cur"><a href="sublist.jsp"><i></i><span>Subordinate</span><b></b>

      <div class="clear"></div>
    </a></li>
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
    <form>
      <a class="login_submit" href="login.html">LOGOUT</a>
    </form>

  </div>
</div>
<div id="header">
  <div class="wrap">
    <i class="menu_open"></i>

    <div class="logo"><a title="uthml酷站大全"><img src="css/logo.png"/></a></div>
    <i class="search_open"></i>
  </div>
  <div class="logo_msk"></div>
</div>
<div id="container">
  <div id="sort">
  </div>
  <div id="content">
    <table>
      <tr>
        <th>Employee Name :</th>
          <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <th>Date :</th>
        <td><input id="date_timepicker_start" type="text" > to <input id="date_timepicker_end" type="text" ></td>
      </tr>
      <tr>
        <th>Time :</th>
        <td><input id="timepicker" type="text" > to <input id="timepicker1" type="text" ></td>
      </tr>
      <tr>
        <th>Type</th>
        <td><select>
          <option value="volvo">Volvo</option>
          <option value="saab">Saab</option>
          <option value="mercedes">Mercedes</option>
          <option value="audi">Audi</option>
        </select></td>
      </tr>
    </table>
  </div>
  <div class="push_msk"></div>
</div>

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
<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/ >
<script src="js/jquery.js"></script>
<script src="js/jquery.datetimepicker.js"></script>
<script>
  jQuery('#datetimepicker1').datetimepicker({
    lang:'de',
    i18n:{
      de:{
        months:[
          'Januar','Februar','März','April',
          'Mai','Juni','Juli','August',
          'September','Oktober','November','Dezember',
        ],
        dayOfWeek:[
          "So.", "Mo", "Di", "Mi",
          "Do", "Fr", "Sa.",
        ]
      }
    },
    timepicker:false,
    format:'d.m.Y'
  });
  jQuery(function(){
    jQuery('#date_timepicker_start').datetimepicker({
      format:'Y/m/d',
      onShow:function( ct ){
        this.setOptions({
          maxDate:jQuery('#date_timepicker_end').val()?jQuery('#date_timepicker_end').val():false
        })
      },
      timepicker:false
    });
    jQuery('#date_timepicker_end').datetimepicker({
      format:'Y/m/d',
      onShow:function( ct ){
        this.setOptions({
          minDate:jQuery('#date_timepicker_start').val()?jQuery('#date_timepicker_start').val():false
        })
      },
      timepicker:false
    });
  });

  jQuery('#timepicker').datetimepicker({
    datepicker:false,
    format:'H:i'
  });
  jQuery('#timepicker1').datetimepicker({
    datepicker:true,
    format:'H:i'
  });
</script>
</html>