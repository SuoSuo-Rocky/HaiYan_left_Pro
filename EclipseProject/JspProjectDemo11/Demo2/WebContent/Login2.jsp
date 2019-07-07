<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body >
<h1 align="center">  我的主页</h1>
<div>
<h1 align="center" >用户登录</h1>
</div>
<!--表单标签  用于提交数据到数据库-->
<%  String flag=(String) session.getAttribute("flag");  %>
<div  align="center"">
<form action="Login2"  method="post" >
<table>
<tr>
<td>用户名:<input type="text" id="username"  name="username"><br></td>
</tr>
<tr>
<td>&nbsp;密码:<input type="password" id="password" name="password"></td>
</tr>
</table><br>

<input  type="submit" value="确定" >


</div>
</form>

<%if(flag!=null){%>
<font color="red">用户名或密码错误！！</font>
<% }%>
</body>
</html>