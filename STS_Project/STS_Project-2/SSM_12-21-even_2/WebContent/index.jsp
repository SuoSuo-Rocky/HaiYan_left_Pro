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
		.navbar{
			margin-bottom: 0;
		}
		.col-sm-8{
			height: 700px;
		}
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
					<li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
					<li><a href="deng.jsp"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="搜图书">
					</div>
					<button type="submit" class="btn btn-default">查询</button>
				</form>
			</div>
		</nav>
		
		
		<!-- 轮播 -->
		
		<div id="myCarousel" class="carousel slide">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="imags/s (1).jpg" alt="First slide">
				</div>
				<div class="item">
					<img src="imags/s (2).jpg" alt="Second slide">
				</div>
				<div class="item">
					<img src="imags/s (3).jpg" alt="Third slide">
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="carousel-control left" href="#myCarousel"
				data-slide="next">
				<span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a class="carousel-control right" href="#myCarousel"
				data-slide="prev">
				<span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
		
		<!-- 图书信息 -->
		
		<!-- 左对齐 -->
		<div class="media" >
			<div class="media-left">
				<img src="imags/book/s (1).jpg" class="media-object" style="width:170px">
			</div>
			<div class="media-body">
				<h4 class="media-heading">RUNOOB</h4>
				<p>这是一些示例文本...</p>
			</div>
		</div>
		
		<!-- 右对齐 -->
		<div class="media">
			<div class="media-body">
				<h4 class="media-heading">RUNOOB</h4>
				<p>这是一些示例文本...</p>
			</div>
			<div class="media-right">
				<img src="imags/book/s (2).jpg" class="media-object" style="width:170px">
			</div>
		</div>
	</body>
</html>