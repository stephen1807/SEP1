<%@ page import="proj.obj.Employee" %>
<%@ page import="java.util.List" %>
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
    <base href="<%=basePath%>">
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
    <script src="/js/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/table-Animation.css">
    <script src="/js/jquery.dataTables.min.js"></script>
    <script src="/js/demo.js"></script>
    <script language="javascript" src="js/inactivity.js"></script>

    <title>Attendance System</title>
</head>
<%if (session.getAttribute("userid") == null) { %>
<jsp:forward page="index.jsp"></jsp:forward>
<%} else {%>
<script type="text/javascript">
    function doView(employeeID) {
        var month = document.getElementById("month").value;
        var idForm= document.getElementById("idForm");
        idForm.employeeID.value=employeeID;
        idForm.month.value=month;
        idForm.action = "/servlet/QueryLogServlet";
        idForm.submit();
    }
</script>
<body>
<form id="idForm" method="get">
    <input type="hidden" name="employeeID"/>
    <input type="hidden" name="month"/>
</form>

<div id="menu">
    <div class="search_wrap"></div>
    <ul><li class="nav_index"><a href="home.jsp"><i></i><span>Home</span><b></b>
        <div class="clear"></div></a></li>
        <li class="nav_site"><a href="<%=basePath%>servlet/EmployeeProfileServlet"><i></i><span>Profile</span><b></b>
            <div class="clear"></div></a></li>
        <li class="nav_site menu_cur"><a href="<%=basePath%>servlet/ListSubordinateServlet"><i></i><span>Subordinate</span><b></b>
            <div class="clear"></div></a></li>
        <%  Integer type = (Integer)session.getAttribute("type");
            if (type == 1) {%>
        <li class="nav_site"><a href="<%=basePath%>servlet/QueryLogCodeServlet"><i></i><span>Log Code</span><b></b>

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
        <form><a class="login_submit" href="<%=basePath%>servlet/LogoutServlet">LOGOUT</a></form>
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
        <select id="month">
            <option value="01">January</option>
            <option value="02">Febuary</option>
            <option value="03">March</option>
            <option value="04">April</option>
            <option value="05">May</option>
            <option value="06">June</option>
            <option value="07">July</option>
            <option value="08">Augustus</option>
            <option value="09">September</option>
            <option value="10">October</option>
            <option value="11">November</option>
            <option value="12">December</option>
        </select>
        <table id="example" class="display" cellspacing="0" width="50%" style="text-align: center">
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
            <%
                List<Employee> emp = (List) request.getAttribute("subordinateList");
                List<Float> salaryList=(List) request.getAttribute("salaryList");
                for (int i = 0; i < emp.size(); i++) {
                    Employee e = emp.get(i);
            %>
            <tbody>
            <tr>
                <td><%=e.getEmployeeID()%></td>
                <td><%=e.getName()%></td>
                <td><%=e.getDepartmentID()%></td>
                <td><%=salaryList.get(i)%></td>
                <td><input type="button" value="View" onclick="doView(<%=e.getEmployeeID()%>)"/></td>
            </tr>
            </tbody>
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