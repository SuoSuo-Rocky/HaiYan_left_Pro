<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 String name = (String)request.getAttribute("shi");
  JOptionPane.showMessageDialog(null,"我的名字叫：" + name);
  %>
</body>
</html>