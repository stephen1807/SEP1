<%@ page import="proj.obj.AttendanceLog" %>
<%@ page import="java.util.List" %>
<%@ page import="proj.obj.Employee" %>
<%@ page import="proj.service.EmployeeService" %>
<%--
  Created by IntelliJ IDEA.
  User: Zo
  Date: 5/21/2015
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
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
    <base href="<%=basePath%>">
    <base src="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=0.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/>
    <meta name="keywords" content="CSS酷站收录站 uehtml 网页设计 DIV+CSS Javascript 酷站 酷站收录 网站设计 网页设计 CSS3"/>
    <meta name="description" content="优艺客 设计师网站">
    <meta name="author" content="优艺客"/>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=no" name="format-detection">
    <link rel="apple-touch-icon-precomposed" href="http://www.17sucai.com/static/images/favicon.ico">
    <script language="javascript" src="js/inactivity.js"></script>
    <title>Attendance System</title>
</head>

<script type="text/javascript">
    function doAdd(employeeID) {
        var idForm = document.getElementById("idForm");
        idForm.employeeID.value=employeeID;
        idForm.action = "/servlet/AddPermissionServlet";
        idForm.submit();
    }
</script>
<%if (session.getAttribute("userid") == null) { %>
<jsp:forward page="index.jsp"></jsp:forward>
<%} else {%>
<body>
<form id="idForm" method="get">
    <input type="hidden" name="employeeID">
</form>
<div id="menu">
    <div class="search_wrap">
    </div>
    <ul>
        <li class="nav_index"><a href="home.jsp"><i></i><span>Home</span><b></b>

            <div class="clear"></div>
        </a></li>
        <li class="nav_site"><a href="<%=basePath%>servlet/EmployeeProfileServlet"><i></i><span>Profile</span><b></b>

            <div class="clear"></div>
        </a></li>
        <li class="nav_site menu_cur"><a href="<%=basePath%>servlet/ListSubordinateServlet"><i></i><span>Subordinate</span><b></b>

            <div class="clear"></div>
        </a></li>
        <%  Integer type = (Integer)session.getAttribute("type");
            if (type == 1) {%>
        <li class="nav_site"><a href="<%=basePath%>logcode.jsp"><i></i><span>Log Code</span><b></b>

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

        <div class="logo"><a title="uthml酷站大全"><img src="css/logo.png"/></a></div>
        <i class="search_open"></i>
    </div>
    <div class="logo_msk"></div>
</div>
<div id="container">
    <div id="sort">
    </div>
    <div id="content">
        Employee Name : <%=request.getAttribute("employeeName")%>


        <td>
            <input type="button" value ="Add Permission" onclick="doAdd(<%=request.getAttribute("employeeID")%>)"/>
        </td>
        <table border="1" style="width:100%; left: 200px;">
            <tr>
                <td>Date and Time</td>
                <td>Type</td>
                <td>Description</td>
            </tr>
            <%
                List<AttendanceLog> attendanceList = (List) request.getAttribute("attendanceList");
                for (int i = 0; i < attendanceList.size(); i++) {
                    AttendanceLog al = attendanceList.get(i);

            %>
            <tr>

                <td><%=al.getEntrydate()%>
                </td>
                <td><%=al.getLogcode()%>
                </td>
                <td>Description</td>
            </tr>
            <%
            }
            %>
        </table>
    </div>
</div>
<script language="javascript" src="js/zepto.min.js"></script>
<script language="javascript" src="js/fx.js"></script>
<script language="javascript" src="js/script.js"></script>

</body>
<%} %>
</html>
