<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!  String[] stu={"16401","16402","16403","16404","16405","16406","16407"};
%>
<% String username2=(String)session.getAttribute("login");
if( username2==null){
out.println("<h2>请先登录，谢谢！</h2>");
out.println("<h2> 2 秒后，自动跳转到登录页面</h2>");
response.setHeader("refresh","2;URL=main.jsp");
}else{
	String userid=request.getParameter("userid");
	String username=request.getParameter("username");
	byte[] stuname=username.getBytes("UTF-8");
	username=new String(stuname);
	
	String userclass=request.getParameter("chose");
	byte[] stuclass=username.getBytes("UTF-8");
	username=new String(stuclass);
	
	int i;
	for( i=0;i<stu.length;i++){
		if(userclass.equals(stu[i])){
			String strtemp="欢迎"+userclass+"班的"+username+"同学";
			session.setAttribute("name", username);//存入学生信息
			session.setAttribute("id",userid);
			session.setAttribute("class",userclass);
			session.setAttribute("temp", strtemp);
			response.sendRedirect("test.jsp");
		}
		if(i==stu.length){
			out.println("<h2>学号输入错误，请重新输入！</h2>");
			out.println("<h2>2 秒后，自动跳转到登录界面 </h2>");
			response.setHeader("refresh","2,main.jsp");
		}
			
	}
	
	
	
}
%>

</body>
</html>