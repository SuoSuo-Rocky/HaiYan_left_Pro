<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title> </title>
<meta name="description" content=" ">
<meta name="keywords" content=" ">
<link href=" " rel="stylesheet">
<link rel="stylesheet" href="<%=basePath%>/mylib/css/bootstrap.min.css">
<!-- <script type="text/javascript" src="mylib/de_jQuery_3_3_1.js"></script>
<script type="text/javascript" src="mylib/js/bootstrap.min.js"></script> -->

  <script type="text/javascript" src="<%=basePath%>/mylib/js/bootstrap.min.js"></script>
  
  <script type="text/javascript" src="<%=basePath%>/mylib/de_jQuery_3_3_1.js"></script>
<style>
	#deng{

	}
	#id{
		margin-top: 100px;
		margin-bottom: 20px;
	}
	#name{
	   margin-bottom: 20px;
	}
</style>
  
</head>
<body>
	
	
	<div class="jumbotron" style="height: 150px;"></div>
    <div class="row" id="deng">
    	<div class="col-md-4 col-md-offset-4 text-center" style="height: 350px;background-color: red; font-size: 26px; ">
    		<form action="one.do">
    		          工号：<input type="text" name="userid" id="id"><br>
    			姓名：<input type="text" name="username" id="name"><br>
    			密码：<input type="password" name="pwd" id="pwd"><br>
    			<input type="submit" value="登录" class="btn btn-info" >
    			<input type="reset" value="重置" class="btn btn-info">
    		</form>
    	</div>
    </div>
</body>
<script>
	$(function(){
  $("input[class='btn btn-info']").css({
  	"marginLeft":"50px",
  	"fontSize":"20px",
  	"marginTop":"10px"
  });
  
  
	});
</script>
</html>