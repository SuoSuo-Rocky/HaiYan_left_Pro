<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="FileLoad/fileLoad.do" method="post" 
enctype="multipart/form-data">
    所要上传的文件：<input type="file" name="file"><br>
    对文件的描述： <input type="text" name="info"><br>
    &nbsp;&nbsp;&nbsp;<input type="submit" value="上传">&nbsp;&nbsp;&nbsp;
    <input type="reset" value="重置">
</form>


   
</body>
</html>