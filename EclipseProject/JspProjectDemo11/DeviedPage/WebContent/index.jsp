<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.sql.*" %>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="shi.css">
<title>Insert title here</title>
</head>
<body>
<h2>我的分页显示技术</h2>
<div id="box">
<table>
<tr>
		<th>id</th>  <th>userid</th>  <th>年龄</th>  <th>性别</th>  <th>年龄</th> 
		 <th>QQ号码</th>
  		<th>电话</th>  <th>电子邮箱</th>  <th>家庭地址</th>
 </tr>
  <% 
  String user = "root";
  String password = "666666";
  String sql = "select * from info_io";
  String url = "jdbc:mysql://localhost:3306/mydb";
  Connection conn = null;
  Statement stmt =  null;
  ResultSet rs = null;
  
  int totalsize;
  int pagesize = 10;
  int totalpage;
  int currentpage;
  String  strpage;
  int pages = 0;
  try{
      Class.forName("com.mysql.jdbc.Driver");
      conn=DriverManager.getConnection(url,user,password);
  System.out.println("获取链接对象成功！");
  stmt  =  conn.createStatement();
  System.out.println("获取执行命令对象成功！");
  rs = stmt.executeQuery(sql);
  System.out.println("获得结果集成功！");
  rs.last();
   }catch(Exception e){
	      e.printStackTrace();
	   }
  totalsize = rs.getRow();  //获取总记录数
  System.out.println("总记录数位："+totalsize+url);
  
  
 if(totalsize > 0){
  totalpage = (totalsize + pagesize - 1) / pagesize;   // 计算 总页数
  strpage = request.getParameter("strpage");  // 获取要显示的页数
  if(strpage == null){   //对要显示的页数进行判断
	  currentpage = 1;
  }else{
	   pages = Integer.parseInt(strpage);
	  if(pages >0 &&pages <= pagesize ){
		  currentpage = pages;
	  }else{
		  currentpage = 1;
	  }
  }
  
   int pointer = pagesize * (currentpage - 1) + 1;
   rs.absolute(pointer);
  for(int i = 0;i < pagesize && rs.isAfterLast(); i++){
  %>
<tr>
	<%-- <td><%=(pointer + i)%></td> --%>  
	<td><% rs.getInt(1);%></td>      <td><%rs.getInt(2); %></td>
	<td><% rs.getString(3); %></td>  <td><% rs.getString(4); %></td>
	<td><% rs.getInt(5); %></td>     <td><% rs.getString(6); %></td>
	<td><% rs.getString(7); %></td>  <td><% rs.getString(8); %></td>
	<td><% rs.getString(9); %></td>  	
</tr>
  <%
  rs.next();
  }
  
  }
  %>
  <%
  
  %>

</table>
</div>
</body>
</html>