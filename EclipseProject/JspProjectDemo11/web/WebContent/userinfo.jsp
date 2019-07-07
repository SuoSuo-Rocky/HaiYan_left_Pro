<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.bean.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  <%  User u = (User)session.getAttribute("userInfo"); %>
  <form action="UpdateReal" method="post">
  <table>
     <tr>
        <td>用户id</td>
        <td><input type="text" value="<%= u.getId() %>" disabled ></td>
            <input type="hidden" value="<%= u.getId() %>" name="userid">
     </tr>
     <tr>
        <td>用户名</td>
        <td><input type="text" value="<%= u.getUsername() %>" name="username"></td>
     </tr>
     <tr>
        <td>密码</td>
        <td><input type="text" value="<%= u.getUserpassword() %>" name="userpwd"></td>
     </tr>
  </table>
  <p><input type="submit" value="修改">&nbsp;&nbsp;&nbsp;
      <input type="button" value="返回" onclick="javascript:window.history.back(-1);"></p>
  </form>
</body>
</html>