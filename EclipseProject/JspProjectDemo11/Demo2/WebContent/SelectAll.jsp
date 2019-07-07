<%@page import="java.util.Vector"%>
<%@page import="com.User_1"  %>


<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- //jsp中嵌入java程序 -->
<% Vector Alluser=(Vector)session.getAttribute("Alluser");%>
<h1></h1>
<div align="center">
<form>
<table width="100%" align="center" cellspacing="0">
<tr>
<td>Id号</td>
<td>用户名</td>
<td>密码</td>
</tr>
<%
for(int i=0;i<Alluser.size();i++){
	User_1 u=(User_1)Alluser.get(i);
	%>
	<tr>
	<td><%=u.getUserid()   %></td>
	<td><%=u.getUsername() %></td>
	<td><%=u.getPassword() %></td>
	<td><a href="Update?userid=<%=u.getUserid()%>" >修改</a></td>
	
	</tr>	
<%} %>

</table>
</div>
</form>
</body>
</html>