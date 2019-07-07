<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script>

function check(){
	
	var a = document.getElementById("username").value;
	if(a == ""){
		alert("请输入用户名");
		return false;
	}
	return true;
}

</script>

<body>
   <% String flag = (String)session.getAttribute("flag"); %>
   <form action="a" method="post" onsubmit="check()">
   
   
             用户名: <input type="text" id="username" name="username">
         密码:      <input type="password" id="userpwd" name="userpwd">
          <input type="submit" value="确定">
   </form>
   <% if(flag != null && flag.equals("0")){ %>
        <font color="red">用户名或密码错误!!!</font>
   <% } %>
 
</body>
</html>