<%@ page contentType="text/html;charset=GB2312" %>
<html>
<body>
<center>
  <font face="隶书" size="6">欢迎登录本系统</font>
  <form action="ex7-04a.jsp" method="post" name="form1" onsubmit="return check1()">
    <table border="0">
      <tr>
        <td>用户名:</td>
        <td><input type="text" name="userName"></td>
      </tr>
      <tr>
        <td>密  码:</td>
        <td><input type="password" name="password"></td>
      </tr> 
      <tr>
        <td>&nbsp;&nbsp;&nbsp;<input type="submit" value="提交" name="submit"></td>
        <td>&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" name="reset"></td>
      </tr>
    </table>
  </form> 
</center>
</body>
</html>

<script type="text/javascript">
function check1(){
  if (form1.userName.value==""||form1.password.value==""){
    alert("用户名或密码不允许为空 !");
    form1.userName.focus();
    return false;
  }
  return true;
}
</script>
