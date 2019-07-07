<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

     <c:forEach items="${requestScope.errors}" var="error"> 
       				   ${error.getDefaultMessage()}<br>
     </c:forEach>  
    






<br>
<br>


  welcome  to SpringMVC
  ######request<br>
  ${requestScope.student1.age}--${requestScope.student1.name}<br>
  ${requestScope.student2.age}--${requestScope.student2.name} <br>
  ${requestScope.student3.age}--${requestScope.student3.name} <br>
  ${requestScope.student4.age}--${requestScope.student4.name}  <br>
  
  
   ###################session  <br>
  ${sessionScope.student1.age}--${sessionScope.student1.name}<br>
  ${sessionScope.student2.age}--${sessionScope.student2.name} <br>
  ${sessionScope.student3.age}--${sessionScope.student3.name} <br>
  ${sessionScope.student4.age}--${sessionScope.student4.name}  <br>
   ###################session  <br>
</body>
</html>