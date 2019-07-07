<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>judge</title>
</head>
<body>

<% 
request.setCharacterEncoding("UTF-8");
String  username2=request.getParameter("username");
String password2=request.getParameter("password");
if(username2.equals("shiwei") && password2 == "123456"){
	response.sendRedirect("ex3.jsp");
    out.print("输入正确...");
}else{
	out.print("输入错误，请重新输入....");
	out.print(username2);
	out.print(password2);
}
	
%>


</body>
</html>