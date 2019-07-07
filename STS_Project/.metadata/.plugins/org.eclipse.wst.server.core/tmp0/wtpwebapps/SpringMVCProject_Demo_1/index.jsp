<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/de_jQuery_3_3_1.js"></script>


<!-- favicon.ico 图标用于收藏夹图标和浏览器标签上的显示，
如果不设置，浏览器会请求网站根目录的这个图标，如果网站根目录也没有这图标会产生 404。
出于优化的考虑，要么就有这个图标，要么就禁止产生这个请求。
在做 H5 混合应用的时候，不希望产生 favicon.ico 的请求。
可以在页面的 <head> 区域，加上如下代码实现屏蔽： -->
<link rel="icon" href="data:image/ico;base64,aWNv">


<script type="text/javascript">
/*      $(document).ready(function(){
    	$("#testJson").click(function(){
    		//通过 ajax 请求  Springmvc 
			$.post(
					"SpringMVC/testJson", // 服务器地址//{"name":"za"},//{"name":"za","age":"23"}
			        function(result){   //服务端 处理完毕后的 回调函数,返回 List<>
						// eval(result);
			          //for(int i=0;i<result){
			        	  alert(124578);
			          });
			
		});
  
	}); 
	 */
	
	
	 // 老师写的 
	 $(document).ready(function() {
	      $("#testJson").click(function(){
	    var url = "SpringMVC/testJson";
	    var args = {};
	    $.post(url, args, function(result){
	     for(var i = 0; i < result.length; i++){
	                       //以JSON的形式处理响应结果
	      var stuId = result[i].id;                 
	      var stuName = result[i].name;
	      var stuAge = result[i].age;
	      alert("编号："+ stuId + "姓名" + stuName + ",年龄" + stuAge);
	     }
	    });
	   });
	   }); 

</script>


</head>
<body>

    <input type="button" value="testJson" id="testJson"><br>
	<a href="SpringMVC/welcome/shiwei"> first springMVC - welcome</a>
	<!--   <form action="SpringMVC/welcome" method="post">
 name:<input name="name"> 
 age <input >
       <input type="submit" value="Post提交">
  </form> -->

	<form action="SpringMVC/testRest/1243" method="post">
		<input type="submit" value="增加">
	</form>
	
	<form action="SpringMVC/testRest/1243" method="get">
		<input type="submit" value="查询">
	</form>



	<form action="SpringMVC/testRest/666666" method="post">
	 <input type="hidden" name="_method" value="DELETE" /> 
		<input type="submit" value="删除">
	</form>

	<form action="SpringMVC/testRest/1243" method="post">
		<input type="hidden" name="_method" value="PUT" />
		 <input  type="submit" value="改变">
	</form> 
	------------------------<br/>
	<form action="SpringMVC/testParam" method="get">
		<input name="uname" type="text">
		<!-- <input name="uage" type="text"> -->
		<input type="submit" value="查值">
	</form>
	
	
	<form action="SpringMVC/testRequestHeader" method="get">
		<input type="submit" value="获取头信息">
	</form>
	


   	<form action="SpringMVC/testCookieValue" method="get">
		<input type="submit" value="获取Cookie">
	</form>
	
	
	<!--在这里体现了 Spring MVC 的强大之处，自动将值对号入座存入对象的属性当中去  -->
	<form action="SpringMVC/testObjectProperties" method="get">
	     age:<input name="age" type="text"><br>
	     name:<input name="name" type="text"><br>
	     homeAddress:<input name="address.homeAddress" type="text"><br>
	     schoolAddress:<input name="address.schoolAddress" type="text"><br>
		<input type="submit" value="获取Cookie">
	</form>
	
	
	<form action="SpringMVC/testServletAPI" method="get">
		<input name="uname" type="text">
		<input type="submit" value="HttpServletRequest">
	</form>

 <a href="SpringMVC/testModelAndView" >ModelAndView</a><br>
 <a href="SpringMVC/testModelMap" >ModelMap</a><br>
 <a href="SpringMVC/testMap" >Map</a><br>
 <a href="SpringMVC/testModel" >Model</a><br>
 


   	<form action="SpringMVC/testModelAttribute" method="get">
         	编号 :<input name="age" type="hidden" value="100"><br>
	     	姓名 :<input name="name" type="text"><br>
		<input type="submit" value="@ModelAttribute">
	</form>
	
	<a href="SpringMVC/direct">direct</a><br>
	
	<a href="SpringMVC/forward">forward</a><br>
	
    <a href="SpringMVC/redirect">redirect</a><br>

    <a href="wang.jsp">传统 的  A  标签</a>
   
   
   <!-- 类型转换器  -->
     <form action="SpringMVC/testConverter" method="get">
         	学生信息：<input name="studentInfo" type="text"><br>
		     <input type="submit" value="学生信息的转换">
	</form>
	
	<br>
	<br>
	<!--数据 格式化  Date   -->
	<form action="SpringMVC/dateFormatting" method="get">
         	编号 :<input name="id" type="text"><br>
	     	姓名 :<input name="name" type="text"><br>
			出生日期:<input name="birthday" type="text"><br>  
			Email: <input name="email" type="text"><br>  
		<input type="submit" value="学生出生日期数据的格式化">
	</form>

      <br>
      <!-- SpringMVC 实现文件的 上传  
      注意点： 1.  必须是 Post  请求 
         2.  enctype="multipart/form-data" -->
      <form action="SpringMVC/testMultipartResolver"
         method="post"  enctype="multipart/form-data">
	     	<input type="file" name="file"><br>
	     	描述：<input name="desc" type="text"><br>
			<input type="submit" value="上传">
	   </form><br>

    <a href="SpringMVC/testInterceptor">拦截测试</a><br>

   <a href="SecondMVC/One">算数异常 </a><br>
   
   <a href="SecondMVC/Three">数组越界 异常 </a><br>
   
   <a href="SpringMVC/testException">其他类中的算数异常</a><br>

     <a href="SecondMVC/defineExcetpion1">自定义 异常类 </a><br>
     
     <a href="SecondMVC/defineExcetpion2?i=3">自定义 异常 方法</a><br>

   <a href="SecondMVC/SimpleMappingExceptionResolver">配置异常类 </a>

    














</body>

</html>