<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title></title>
<meta name="description" content=" ">
<meta name="keywords" content=" ">
<link href=" " rel="stylesheet">
<link rel="stylesheet"
	href="Mlib/bootstrap-3.3.7/dist/css/bootstrap.min.css">
<script src="Mlib/de_jQuery_3_3_1.js"></script>
<script src="Mlib/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
<style>
.navbar {
	margin-bottom: 0;
	position: fixed;
	z-index: 10;
	width: 100%;
	font-size: 25px;
	
}

.dropdown {
	margin-right: 20px;
}

.one {
	padding-top: 60px;
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
				<li><a href="#"><span class=""></span> 我的书架</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <span class="glyphicon glyphicon-cog "></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">账户设置</a></li>
						<li><a href="#">个人中心</a></li>
						<li><a href="#">帮助</a></li>
						<li class="divider"></li>
						<li><a href="#">退出</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">查询</button>
			</form>
		</div>
	</nav>





	<!-- 第一行 -->
	<div class="row" id="one">
		<div class="col-sm-3 col-sm-offset-1">
			<div class="thumbnail">
				<img src="imags/book/s (1).jpg" alt="通用的占位符缩略图">
				<div class="caption">
					<h3 class="text-center" id="name">缩略图标签</h3>
					<p class="text-center">
						<a href="#" class="btn btn-primary text-center" role="button">
							添加到我的书架 </a>
					</p>
				</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="thumbnail">
				<img src="imags/book/s (2).jpg" alt="通用的占位符缩略图">
				<div class="caption">
					<h3 class="text-center" id="name">缩略图标签</h3>
					<p class="text-center">
						<a href="#" class="btn btn-primary text-center" role="button">
							添加到我的书架 </a>
					</p>
				</div>
			</div>
		</div>
		<div class="col-sm-3" id="three">
			<div class="thumbnail">
				<img src="imags/book/s (3).jpg" alt="通用的占位符缩略图">
				<div class="caption">
					<h3 class="text-center" id="name">缩略图标签</h3>
					<p class="text-center">
						<a href="#" class="btn btn-primary" role="button" > 添加到我的书架 </a>
					</p>
				</div>
			</div>
		</div>
	</div>
	${requestScope.log.stuName}
		${requestScope.log.password}
</body>
	<script>
		$(function(){
		/* 	var inner ="<div><img><div ><h3 >缩略图标签</h3><p >
			<a > 添加到我的书架 </a></p></div></div></div>";
	 */
	  var inner = "<div><div><img><h3>缩略图标签</h3><p><a>添加到我的书架</a></p></div></div>";
			var div = document.createElement("div");
			$(div).css({
				"backgroundColor":"red"
				});
		   $("#one").after($(div));
		   $(div).html(inner);
		   $(div).addClass("col-sm-3");
		   $($(div).children("div")[0]).addClass("thumbnail");
		   $($(div).find("img")[0]).attr("src","imags/book/s (3).jpg");
		   $($(div).find("div")[1]).addClass("caption");
		   $($(div).find("h3")[0]).addClass("text-center");
		   $($(div).find("p")[0]).addClass("text-center");
		   $($(div).find("a")[0]).addClass("btn");
		   $($(div).find("a")[0]).addClass("btn-primary");
		   
			
			var sum = $("h3[id='name']").length;
			alert(sum);
		});
	</script>
</html>