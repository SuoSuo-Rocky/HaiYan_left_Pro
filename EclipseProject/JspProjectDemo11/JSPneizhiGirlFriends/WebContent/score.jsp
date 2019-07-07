<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >
<font size=3>
<%int m=0,score=0;
String strName="";
String r1="",r2="",r3="";
String c1[];
String word="";
String result="";
String strUser=(String)session.getAttribute("name");
if( strUser==null){
out.println("<h2>请先登录，谢谢！</h2>");
out.println("<h2> 2 秒后，自动跳转到登录页面</h2>");
response.setHeader("refresh","2;URL=main.jsp");
}else{
	strName=strUser+"同学：";
	r1=request.getParameter("r1");
	r2=request.getParameter("r2");
	r3=request.getParameter("r3");
	c1=request.getParameterValues("r4");
	if(r1==""){r1="";}
	if(r1.equals("C")){score+=25;}
	
	if(r2==""){r2="";}
	if(r2.equals("C")){score+=25;}
	
	if(r3==""){r3="";}
	if(r3.equals("B")){score+=25;}
	
	if(c1==null){c1=null;}
	else{
	for(int i=0;i<c1.length;i++ ){
		word+=c1[i].toString();
	}
		if(word.equals("ABD")){
			score+=25;
		}
		
	}
	if(score==100){
		result="成绩优异，祝贺你！";
	}else if(score==75){
		result="成绩不错，继续努力！";
	}else if(score==50){
		result="成绩不理想，加油！";
	}else if(score==25){
		result="成绩不好，但是你的潜力最大！";
	}else{
		result="It's so bad! Come on....";
	}
	String id=(String)session.getAttribute("id");
	String classmate=(String)session.getAttribute("classmate");
	String msg=classmate+","+id+","+strUser+","+score;
	Vector<String> v = (Vector)application.getAttribute("grade");
	if(v== null){
		v=new Vector<String>();
	}
	v.add(msg);
	application.setAttribute("grade",v);

%>
<%= strName %><br><br>
你提交的答案为：
1-<%=r1 %>&nbsp;2-<%=r2 %>&nbsp;3-<%=r3 %>&nbsp;4-<%=word %>&nbsp;<br>
你的成绩是：<%=score %>
<br>说明：1-4小题每小题25分，答案部分正确不得分！
<br><hr>
标准答案：&nbsp;<br>
&nbsp;&nbsp;&nbsp;&nbsp; 1-C&nbsp;2-C&nbsp;3-B&nbsp;4-ABD&nbsp;
<br><br>成绩点评： <%=result %>
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="Main.jsp">返回主页</a>
<br><hr>
<h3>请留言：</h3>
    <form action="message.jsp" method="post" name="form3" >
    <textarea rows="6" cols=60 wrap="physical"></textarea>
    <br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="提交留言" name="submit">
    </form><br>
<% }%>
</font>
</body>
</html>