<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  Welcome  One
  
  <%
  String message = (String)request.getAttribute("info");
  if(message.equals("success")){
  out.print("上传成功 ！");
  out.print("2 秒钟后自动跳转到  上传界面 ");
  response.setHeader("refresh", "2;URL=../index.jsp");
  }
  %>
</body>
</html>