<%@ page contentType="text/html;charset=GB2312" %>
<html>
<body>
<center>
  <font face="����" size="6">��ӭ��¼��ϵͳ</font>
  <form action="ex7-04a.jsp" method="post" name="form1" onsubmit="return check1()">
    <table border="0">
      <tr>
        <td>�û���:</td>
        <td><input type="text" name="userName"></td>
      </tr>
      <tr>
        <td>��  ��:</td>
        <td><input type="password" name="password"></td>
      </tr> 
      <tr>
        <td>&nbsp;&nbsp;&nbsp;<input type="submit" value="�ύ" name="submit"></td>
        <td>&nbsp;&nbsp;&nbsp;<input type="reset" value="����" name="reset"></td>
      </tr>
    </table>
  </form> 
</center>
</body>
</html>

<script type="text/javascript">
function check1(){
  if (form1.userName.value==""||form1.password.value==""){
    alert("�û��������벻����Ϊ�� !");
    form1.userName.focus();
    return false;
  }
  return true;
}
</script>
