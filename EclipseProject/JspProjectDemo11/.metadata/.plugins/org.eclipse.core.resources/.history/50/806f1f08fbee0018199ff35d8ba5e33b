<%@ page contentType="text/html;charset=GB2312" %>
<jsp:useBean id ="course" class = "com.mymodel.course.Course"/>
<html>
<body>
<% course.setCname("数据结构");
   course.setChour(64);
   course.setCredit(4);
%>
<h3>获取JavaBean的值如下:</h3>
课程名:
<jsp:getProperty name="course" property="cname"/>
<br>学时:
<jsp:getProperty name="course" property="chour"/>
<br>学分:
<jsp:getProperty name="course" property="credit"/>
</body>
</html>