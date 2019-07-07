<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.User_1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
   <% User_1  user=(User_1)session.getAttribute("userinfo"); %>

<form  action="Login2" method="post">

<table>
<tr>
<td>用户ID</td>
<td><input type="text" value="<%= user.getUserid()%>" ></td>
<input  type="hidden"  value="<%=user.getUserid()%>" name="userid">    <!-- 隐藏标签，只要放在form里面就好 -->
</tr>
<tr>
<td>用户名</td>
<td><input type="text" value="<%= user.getUsername()%>"  name="username"></td>
</tr>
<tr>
<td>密码</td>
<td><input type="text" value="<%= user.getPassword()%>" name="password"></td>
</tr>


</table>
<p>  <input type="submit" value="修改">&nbsp;&nbsp;&nbsp;
     
     
     <input type="button" value="返回"  onclick="javascript:window.history.back(-1);"></p>
</form>
</body>
</html>