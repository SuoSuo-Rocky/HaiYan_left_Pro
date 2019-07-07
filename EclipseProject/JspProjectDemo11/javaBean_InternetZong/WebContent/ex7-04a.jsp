<%@ page contentType="text/html;charset=GB2312" %>
<jsp:useBean id="user" class="com.mymodel.user.User"/>  
<jsp:setProperty name="user" property="*"/> 
<jsp:useBean id="userOper" class="com.mymodel.user.UserOper"/>  
<% 
  String name=user.getUserName();
  if(userOper.check(user)){  
    out.println("»¶Ó­Äã£¬"+name+"!"); 
  }else {  
    response.sendRedirect("ex7-04.jsp");  
  }  
%>  
