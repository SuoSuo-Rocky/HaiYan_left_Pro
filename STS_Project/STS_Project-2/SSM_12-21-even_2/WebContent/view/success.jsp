<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  welcome  to SpringMVC <br>
 编号：${requestScope.login.stuId }-<br>
 姓名：${requestScope.login.stuName }-<br>
 年龄：${requestScope.login.stuAge }-<br>

</body>
</html>