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
				margin-top: 50px;
				margin-left: 200px;
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
				<form class="navbar-form navbar-right" role="search">
					<button type="submit" class="btn btn-default">添加图书</button>
				</form>
			</div>
		</nav>
		<%
		int  boid = Integer.parseInt(request.getParameter("boid"));
		  session.setAttribute("boid", boid);
		  %>
        <p class="text-center p1">修改图书信息 </p>
       <div style="padding: 0px 400px 10px;" class="t1 text-center">
	<form class="bs-example bs-example-form" role="form" action="update.do">
		<div class="input-group">
			<span class="input-group-addon"></span>
			<input type="text" class="form-control" placeholder="书名" name="boName">
		</div>
		<br>
		<div class="input-group">
			<span class="input-group-addon"></span>
			<input type="text" class="form-control" placeholder="等级" name="boRank">
		</div>
		<br>
		<div class="input-group">
			<span class="input-group-addon"></span>
			<input type="text" class="form-control" placeholder="图片文件名" name="boImg">
		</div>
		<div class="input-group">
		<input type="submit" class="btn btn-info btn-lg su" value="提交修改">
		</div>
	</form>
</div>


	</body>
</html>