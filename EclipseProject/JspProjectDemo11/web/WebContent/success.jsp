<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bean.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<body>
   <h1>登录成功</h1>
   <% 
      ArrayList list = (ArrayList)session.getAttribute("userList");
   %>
   <table width="500" align="center" cellspacing="0">
       <tr>
           <td>编号</td>
           <td>用户名</td>
           <td>密码</td>
       </tr>
       <%  for(int i=0; i<list.size(); i++) { 
             User u = (User)list.get(i);
       %>
         <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getUsername() %></td>
            <td><%= u.getUserpassword() %></td>
            <td><a href="Update?id=<%=u.getId() %>">修改</a></td>
         </tr>
       <% } %>

   </table>
   
</body>
</html>