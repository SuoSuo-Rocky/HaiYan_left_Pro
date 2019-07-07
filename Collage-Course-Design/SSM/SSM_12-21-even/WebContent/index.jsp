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
		</style>
	</head>
	<body>
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">S_W</a>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="addLogin.jsp"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
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
				<h4 class="media-heading">《武则天》</h4>
				<p style="text-indent: 2em;">她展露着自己治国治民的韬略和睿智，信奉豪绅强权专断的统治方式；
				她的脚下累满亲人，朝臣曲冤的尸骨；
				她的左右既有名相贤臣，又要佞臣酷吏，更多无耻男宠，武则天的四周闪耀着令人晕眩的光芒和迷雾<br></p>
				<p style="text-indent: 2em;">一个令人敬畏的神秘的女性。她有14岁入宫，被唐太宗赐封才人的经历，又有被幽闭于尼庵的绝望无助；
				她竟能被新皇再次恩宠，又因妒火争宠而横生残酷杀戮；她有30余岁就贵为皇后、母仪天下的荣耀，
				又有干预朝政进而临朝称制，
				再进而不顾一切罢废李唐大统的狂热，终于在近古稀之年登上了皇帝宝座，成为中国历史上真正的也是唯一的女皇</p>
			</div>
		</div>
		
		<!-- 右对齐 -->
		<div class="media">
			<div class="media-body">
				<h4 class="media-heading">《鬼谷子全书 》</h4>
				<p style="text-indent: 2em;">《鬼谷子全书》是一部研究古代社会政治斗争谋略与权术的智慧之书。每篇由谋略典故、
				现代应用和商海实战三部分组成，对原文进行了通俗易懂的翻译，侧重阐述做人、
				办事、经商这些普通读者极其关心的主题。<br>欧阳修谓《鬼谷子》：
				[因时适变，权事制宜，有足取者。[长孙无忌谓《鬼谷子》：[变辞利口，倾危变诈。]</p>
			</div>
			<div class="media-right">
				<img src="imags/book/s (2).jpg" class="media-object" style="width:170px">
			</div>
		</div>
	</body>
</html>