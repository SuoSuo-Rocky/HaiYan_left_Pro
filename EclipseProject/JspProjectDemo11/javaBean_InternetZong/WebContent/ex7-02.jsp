<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="com.mymodel.course.Course"%>
<html>
<body>
<% Course course=new Course();
   course.setCname("数据结构");
   course.setChour(64);
   course.setCredit(4);
   //out.println(course.getCname());
%>
<h3>获取JavaBean的值如下:</h3>
课程名:<%=course.getCname()%>
<br>学时:<%=course.getChour()%>
<br>学分:<%=course.getCredit()%>
</body>
</html>