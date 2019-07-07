<%@page import="com.jspsmart.upload.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
SmartUpload  su = new  SmartUpload();
su.initialize(pageContext);
su.setMaxFileSize(1000000);
su.setAllowedFilesList("doc,txt");
su.upload();

int count = su.save("/upload");
out.println(count + " 个上传成功！<br><br>");
for(int i = 0; i<su.getFiles().getCount();i++){
	File file = su.getFiles().getFile(i);
	if(file.isMissing()){
		continue;
	}
	out.println("文件名：" + file.getFileName() + "长度为：" + file.getSize() 
	+ "扩展类：" + file.getFileExt()+ "<br><br>" );
}
%>

</body>
</html>