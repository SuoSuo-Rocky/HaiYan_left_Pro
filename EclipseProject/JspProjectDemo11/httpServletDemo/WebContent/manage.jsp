<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  href="pageCss/logincss.css"/>
</head>
<body>
<h1 align="center" >凤凰集团人事管理系统</h1>
<h1 align="center" >系统维护</h1>
<!--表单标签  用于提交数据到数据库-->
<%-- <%  String flag=(String) session.getAttribute("flag");  %> --%>

<div id="d" align="center">
<h1 align="center"  >管理员登录</h1>
<form action="Manage"  method="post" >
<table>
<tr>
<td class="c1">账号:</td>
<td><input type="text" id="username"  name="username"><br></td>
</tr>
<tr>
<td class="c1">密码:</td>
<td><input type="password" id="password" name="password"></td>
</tr>
</table><br>
<div id="d1">
<div class="d2"><input class="sub" type="submit" value="登录"></div>
<div class="d3"><input class="sub" type="reset" value="重置"></div>
</div>
</form>

</div>
<%-- <%if(flag!=null){%>
<font color="red">用户名或密码错误！！</font>
<% }%> --%>
</body>
</html>