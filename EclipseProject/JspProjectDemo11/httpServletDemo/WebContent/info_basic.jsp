<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ page import="com.DBUtil" %>
     <%@ page import="java.sql.ResultSet" %>
     <%@ page import="java.sql.*" %>
     <%@ page import="java.sql.SQLException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   
	<title>凤凰集团人事管理系统</title>
	<link rel="stylesheet" type="text/css"  href="info_basic.css"/>
	<link rel="stylesheet" href="css/style.css"><!-- 二级菜单css -->
	<script src="pageJs/jquery-1.10.2.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/lun.css"><!-- 轮播图css -->
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script><!-- 轮播图 JS -->
</head>
<body width="100%"  height="800px" >
<!-- Í·²¿ -->
<div id="one">
      <div id="main"> <a href="LoginSuccess.html">系统主页</a></div>
      <div class="Login"><a href="#"><img src="Picture/Shezhi.png"
       width="70px" height="38px"></a></div>
</div>

<!-- 轮播图 -->
<div class="box">

	<div class="list">
		<ul>
			<li class="p7"><a href="#"><img class="im2" src="img/1.png" alt="" /></a></li>
			<li class="p6"><a href="#"><img class="im2" src="img/2.png" alt="" /></a></li>
			<li class="p5"><a href="#"><img class="im2" src="img/3.png" alt="" /></a></li>
			<li class="p4"><a href="#"><img class="im2" src="img/44.jpg" alt="" /></a></li>
			<li class="p3"><a href="#"><img class="im2" src="img/55.jpg" alt="" /></a></li>
			<li class="p2"><a href="#"><img class="im2" src="img/66.jpg" alt="" /></a></li>
			<li class="p1"><a href="#"><img class="im2" src="img/77.jpg" alt="" /></a></li>
		</ul>
	</div>
	
	<a href="javascript:;" class="prev btn"><</a>
	<a href="javascript:;" class="next btn">></a>
</div>
<div id="gps">
<!--   <div id="gps01"><a href="#">¼¯ÍÅÖ÷Ò³</a></div>
  <div id="gps01"><a href="#">¼¯ÍÅ¼ò½é</a></div>
  <div id="gps01"><a href="#">²¿ÃÅ¸Å¿ö</a></div>
  <div id="gps01"><a href="#">Ö°¹¤ÕÐÄ¼</a></div>
  <div id="gps01"><a href="#">Ð½×Ê¹ÜÀí</a></div>
  <div id="gps01"><a href="#">Ìí¼Ó»ù±¾ÐÅÏ¢</a></div> -->
  <!-- 二级菜单 -->
  <div id="container">
<ul id="menu">
  <li><a href="#">信息修改</a>
		<ul>
			<li><a href="#">部门信息修改</a></li>
			<li><a href="#">职务信息修改</a></li>
			<li><a href="#">学历信息修改</a></li>
			<li><a href="#">调入调出信息修改</a></li>
		</ul>
	</li>
	<li><a href="#">信息添加</a>
		<ul>
			<li><a href="#">部门信息添加</a></li>
			<li><a href="#">职务信息添加</a></li>
			<li><a href="#">学历信息添加</a></li>
			<li><a href="#">调入调出信息添加</a></li>
	
		</ul>
	</li>
	<li><a href="#">信息查看</a>
		<ul>
		    <li><a href="info_basic.jsp">基本信息查看</a></li>
			<li><a href="#">部门信息查看</a></li>
			<li><a href="#">职务信息查看</a></li>
			<li><a href="#">学历信息查看</a></li>
			<li><a href="#">调入调出信息查看</a></li>
	
		</ul>
	</li>
	<li><a href="#">信息删除</a>
		<ul>
			<li><a href="#">Ìí¼Ó»ù±¾ÐÅÏ¢</a></li>
			<li><a href="#">Maecenas dignissim fermentum luctus</a></li>
			<li><a href="#">Suspendisse fringilla</a></li>
		</ul>
	</li>
	<li><a href="#">合同管理</a>
            <ul>
			<li><a href="#">Ìí¼Ó»ù±¾ÐÅÏ¢</a></li>
			<li><a href="#">Maecenas dignissim fermentum luctus</a></li>
			<li><a href="#">Suspendisse fringilla</a></li>
		</ul>
	</li>

	<li><a href="#">绩效考核</a>
        <ul>
			<li><a href="#">Ìí¼Ó»ù±¾ÐÅÏ¢</a></li>
			<li><a href="#">Maecenas dignissim fermentum luctus</a></li>
			<li><a href="#">Suspendisse fringilla</a></li>
		</ul>
	</li>

	<li><a href="#">员工培训</a>
        <ul>
			<li><a href="#">Ìí¼Ó»ù±¾ÐÅÏ¢</a></li>
			<li><a href="#">Maecenas dignissim fermentum luctus</a></li>
			<li><a href="#">Suspendisse fringilla</a></li>
		</ul>
	</li>

	<li><a href="#">工资管理</a>
        <ul>
			<li><a href="#">Ìí¼Ó»ù±¾ÐÅÏ¢</a></li>
			<li><a href="#">Maecenas dignissim fermentum luctus</a></li>
			<li><a href="#">Suspendisse fringilla</a></li>
		</ul>
	</li>

	<li><a href="#">奖惩管理</a>
        <ul>
			<li><a href="#">Ìí¼Ó»ù±¾ÐÅÏ¢</a></li>
			<li><a href="#">Maecenas dignissim fermentum luctus</a></li>
			<li><a href="#">Suspendisse fringilla</a></li>
		</ul>
	</li>
</ul>
</div>
</div>
<!--ÖÐ²¿ -->
<div class="center" back>
	  <div id="left"></div>
	  
		 <!--  中间的中间部分 -->
	  <div id="center2">
      
      <div class="everyTr">
	       <div id="td">职工工号</div>
	       <div id="td">姓名</div>
	       <div id="td">性别</div>
	       <div id="td">年龄</div>
	       <div id="td">省份证号</div>
	       <div id="td">出生日期</div>
	       <div id="td">家庭地址</div>
	       <div id="td">电话</div>
	  </div>

<%

DBUtil db=new DBUtil();
ResultSet rs=null;
db.conn();
   String sql="select id,name,sex,age,id_card,born,address,phone  from info_basic";
	rs=db.getrs(sql);

	while(rs.next()){
  %> 
	    <div class="everyTr">
	       <div id="td"><%=rs.getString(1)%></div>
	       <div id="td"><%=rs.getString(2) %></div>
	       <div id="td"><%=rs.getString(3) %></div>
	       <div id="td"><%=rs.getString(4) %></div>
	       <div id="td"><%=rs.getString(5) %></div>
	       <div id="td"><%=rs.getString(6) %></div>
	       <div id="td"><%=rs.getString(7) %></div>
	       <div id="td"><%=rs.getString(8) %></div>
	  </div>

	    <%   
	} %>
	 
	  </div>
	    <div id="right"></div>
</div>
<!--Î²²¿-->

<div id="five"></div>
	

<!-- 轮播图 JS 代码 -->

<script type="text/javascript">
var $a=$(".buttons a");
var $s=$(".buttons span");
var cArr=["p7","p6","p5","p4","p3","p2","p1"];
var index=0;
$(".next").click(
	function(){
	nextimg();
	}
)
$(".prev").click(
	function(){
	previmg();
	}
)
//上一张
function previmg(){
	cArr.unshift(cArr[6]);
	cArr.pop();
	//i是元素的索引，从0开始
	//e为当前处理的元素
	//each循环，当前处理的元素移除所有的class，然后添加数组索引i的class
	$("li").each(function(i,e){
		$(e).removeClass().addClass(cArr[i]);
	})
	index--;
	if (index<0) {
		index=6;
	}
	show();
}

//下一张
function nextimg(){
	cArr.push(cArr[0]);
	cArr.shift();
	$("li").each(function(i,e){
		$(e).removeClass().addClass(cArr[i]);
	})
	index++;
	if (index>6) {
		index=0;
	}
	show();
}



//点击class为p2的元素触发上一张照片的函数
$(document).on("click",".p2",function(){
	previmg();
	return false;//返回一个false值，让a标签不跳转
});

//点击class为p4的元素触发下一张照片的函数
$(document).on("click",".p4",function(){
	nextimg();
	return false;
});

//			鼠标移入box时清除定时器
$(".box").mouseover(function(){
	clearInterval(timer);
})

//			鼠标移出box时开始定时器
$(".box").mouseleave(function(){
	timer=setInterval(nextimg,4000);
})

//			进入页面自动开始定时器
timer=setInterval(nextimg,4000);
</script>

</body>
</html>