<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>  </title>
		<meta name="description" content=" ">
		<meta name="keywords" content=" ">
		<link href=" " rel="stylesheet">
		<link rel="stylesheet" href="Mlib/bootstrap-3.3.7/dist/css/bootstrap.min.css">
		<script src="Mlib/de_jQuery_3_3_1.js"></script>
		<script src="Mlib/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
		<style>
			.t1{
				font-size: 25px;
			}
			.p1{
				display: block;
				height: : 160px;
				line-height: 160px;
				font-size: 40px;
				/* background-color: green; */
			}
			.su{
				margin: 0 auto;
				margin-top: 50px;
				
			}
			.input-group{
			width:400px;
			
			}
			.input-group-addon,.form-control{
			height:60px;
			}
			.input-group-addon{
			width:50px;
			}
			#one{
			margin-bottom: 30px;
			}
		</style>
	</head>
	<body>
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">S_W</a>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle"
							data-toggle="dropdown">
							<span class="glyphicon glyphicon-cog "></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#">帮助</a></li>
							<li class="divider"></li>
							<li><a href="index.jsp">退出</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>
		
		


		
		<p class="text-center p1">添加账户信息</p>
		<div style="padding: 0px 400px 10px;" class="t1 text-center">
			<form class="bs-example bs-example-form" role="form" action="addlogin.do"
			name="form2" onsubmit="return check()">
				<div class="input-group" id="one">
					<span class="input-group-addon"></span>
					<input type="text" class="form-control" placeholder="注册编号" name="stuId">
				</div>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="text" class="form-control" placeholder="账号名" name="stuName">
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="text" class="form-control" placeholder="密码" name="password">
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="text" class="form-control" placeholder="请再输入密码" name="again">
				</div>
				<div class="input-group text-center">
					<input type="submit" class="btn btn-info btn-lg su text-center" value="提交添加">
				</div>
			</form>
		</div>
	</body>
	<script>
	
	function check(){
		if(form2.stuId.value==""){
			 alert("请输入你的注册编号");
			 form2.stuId.focus();
			 return false;
		}
		
		if(form2.stuName.value==""){
			 alert("请输入你的账户名！");
			 form2.stuName.focus();
			 return false;
		}
		
		if(form2.password.value==""){
			 alert("请输入你的密码");
			 form2.password.focus();
			 return false;
		}
		
		if(form2.again.value==""){
			 alert("请再次输入你的密码！");
			 form2.again.focus();
			 return false;
		}
		
		if(form2.password.value!=form2.again.value){
			 alert("你两次输入的密码不一致！\n 请检查再次输入！");
			 form2.password.focus();
			 return false;
		}
		
		return true;
	}
	
	
	</script>
	
</html>


















