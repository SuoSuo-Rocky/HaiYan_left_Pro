<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title> </title>
		<meta name="description" content=" ">
		<meta name="keywords" content=" ">
		<link href=" " rel="stylesheet">
		<link rel="stylesheet" href="Mlib/bootstrap-3.3.7/dist/css/bootstrap.min.css">
		<script src="Mlib/de_jQuery_3_3_1.js"></script>
		<script src="Mlib/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
		<style>
		.row{
			position: relative;
			background-image: url("imags/book/blank.jpg");
		}

		.deng{
			position: absolute;
			height: 400px;
			width: 500px;
			top: 20px;
			left: 350px;
			font-size: 25px;
		}
		#deng {
		}
		#id {
			margin-top: 100px;
			margin-bottom: 20px;
		}
		#name {
			margin-bottom: 20px;
		}
		</style>
	</head>
	<body>
		<div class="jumbotron text-center" style="margin-bottom: 0px;">
			<h1>Welcome!</h1>
		</div>
		
		<div class="row">
			<div class="col-sm-5" style="height: 600px;">
				
			</div>
			<div class="col-sm-7" style="height: 600px;">
				
			</div>
			<div class="deng text-center" style="height: 350px; font-size: 26px;">
				<%
			 	session.setAttribute("news", 3); 
				%>
				<form action="deng.do" name="form1" onsubmit="return check()">
					编号：<input type="text" name="stuId" id="id"><br>
					姓名：<input type="text" name="stuName" id="name"><br>
					密码：<input type="password" name="password" id="password"><br>
					<input type="submit" value="登录" class="btn btn-info dengs">
					<input type="reset" value="重置" class="btn btn-info chong">
				</form>
				
			</div>
		</div>
	</body>
	<script type="text/javascript">
	function check(){
		if(form1.stuId.value == ""){
			alert("请输入你的编号！");
			form1.stuId.focus();
			return false;
		}
		
		if(form1.stuName.value == ""){
			alert("请输入你的姓名！");
			form1.stuName.focus();
			return false;
		}
		
		if(form1.password.value == ""){
			alert("请输入你的密码！");
			form1.password.focus();
			return false;
		}
		return true;
		
	}
	
	

	
	</script>
</html>



















