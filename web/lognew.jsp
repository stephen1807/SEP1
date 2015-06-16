<%--
  Created by IntelliJ IDEA.
  User: Zo
  Date: 5/21/2015
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class="loading">
<head>
    <base href="<%=basePath%>">
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
<%if (session.getAttribute("userid") == null) { %>
<jsp:forward page="index.jsp"></jsp:forward>
<%} else {%>
<script type="text/javascript">
    function doAdd() {
        var name = document.getElementById("name").value;
        var desc = document.getElementById("desc").value;
        var unit = document.getElementById("unit").value;
        var cost = document.getElementById("cost").value;
        var costpermission = document.getElementById("costpermission").value;
        myform.name.value=name;
        myform.desc.value=desc;
        myform.unit.value=unit;
        myform.cost.value=cost;
        myform.costpermission.value=costpermission;
        alert (name,desc,unit,cost,costpermission);
        myform.action = "/servlet/LoginServlet";
        myform.submit();    }
</script>
<body>
<form id="myform" style="display: none;">
    <input type="hidden" name="name">
    <input type="hidden" name="desc">
    <input type="hidden" name="unit">
    <input type="hidden" name="cost">
    <input type="hidden" name="costpermission">
</form>
<div id="menu">
    <div class="search_wrap">
    </div>
    <ul>
        <li class="nav_index menu_cur"><a href="home.jsp"><i></i><span>Home</span><b></b>

            <div class="clear"></div>
        </a></li>
        <li class="nav_site"><a href="servlet/EmployeeProfileServlet"><i></i><span>Profile</span><b></b>

            <div class="clear"></div>
        </a></li>
        <li class="nav_site"><a href="<%=basePath%>servlet/ListSubordinateServlet"><i></i><span>Subordinate</span><b></b>

            <div class="clear"></div>
        </a></li>
        <%  Integer type = (Integer)session.getAttribute("type");
            if (type == 1) {%>
        <li class="nav_site menu_cur"><a href="<%=basePath%>logcode.jsp"><i></i><span>Log Code</span><b></b>

            <div class="clear"></div>
        </a></li>
        <%}%>
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
            <a class="login_submit" href="<%=basePath%>servlet/LogoutServlet">LOGOUT</a>
        </form>

    </div>
</div>
<div id="header">
    <div class="wrap">
        <i class="menu_open"></i>

        <div class="logo"><a href="http://www.17sucai.com/" title="uthml酷站大全"><img src="css/logo.png"/></a></div>
        <i class="search_open"></i>
    </div>
    <div class="logo_msk"></div>
</div>
<div id="container">
    <div id="sort">
    </div>
    <div id="content">
        <form id="newLogCodeForm" name="newLogCodeForm" method="post">
        </form>
     <table>
         <tr>
             <th align="right">Log Name :</th>
                 <td><input type="text" id="name"></td>
             </tr>
             <tr>
                 <th align="right">Description :</th>
                 <td><input id="desc" type="text"></td>
             </tr>
         <tr>
             <th align="right">Unit :</th>
             <td> <select id="unit">
                 <option value="Once">Once</option>
                 <option value="hour">Hour</option>
                 <option value="day">Day</option>
             </select></td>
         </tr>
         <tr>
             <th align="right">Cost :</th>
             <td> <input id="cost" type="text"></td>
         </tr>
         <tr>
             <th align="right">Cost Permission :</th>
             <td> <input id="costpermission" type="text"></td>
         </tr>
         <tr>
             <th></th>
             <td align="right"><input type="button" value="Save" onclick="doAdd()"/></td>
         </tr>
     </table>
    </div>
</div>

<script language="javascript" src="js/zepto.min.js"></script>
<script language="javascript" src="js/fx.js"></script>
<script language="javascript" src="js/script.js"></script>

</body>
<%} %>
</html>
