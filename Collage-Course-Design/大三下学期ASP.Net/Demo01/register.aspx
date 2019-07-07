<%@ Page Language="C#" AutoEventWireup="true" CodeFile="register.aspx.cs" Inherits="register" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<!DOCTYPE html>
<!-- saved from url=(0039)https://v3.bootcss.com/examples/signin/ -->
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
     <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>SuoSuo</title>

    <!-- Bootstrap core CSS -->
    <link href="static/bootstrap.css" rel="stylesheet" />

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="static/ie10-viewport-bug-workaround.css" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="static/blog.css" rel="stylesheet" />

    <!-- font-awesome 插件库  -->
     <link rel="stylesheet" href="static/plugins/font-awesome-4.7.0/css/font-awesome.min.css" />

     <!-- Bootstrap    -->
     <script type="text/javascript" src="static/plugins/Jquery/de_jQuery_3_3_1.js"></script>
     <link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrap.min.css" />
     <link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrap-theme.min.css" />

     <!--  self  -->
     <link rel="Stylesheet" href="static/register/signin.css"/>
     <script type="text/javascript" src="static/register/ie-emulation-modes-warning.js"></script>
     <script type="text/javascript" src="static/register/ie10-viewport-bug-workaround.js"></script>

<%--      <link rel="stylesheet" href="static/plugins/bootstrap/fonts/glyphicons-halflings-regular.woff" />--%>

     <script type="text/javascript" src="static/plugins/bootstrap/js/bootstrap.min.js"> 

    


    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!-- [if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="static/ie-emulation-modes-warning.js" type="text/javascript"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <div class="container">

      <form class="form-signin" runat="server">
        <h2 class="form-signin-heading">Please Sign up</h2>
         <label for="inputUsername" class="sr-only">Username</label>

        <asp:TextBox ID="TextBox1" runat="server" class="form-control" placeholder="Username"></asp:TextBox>
      <%--  <input type="Username" id="Username" class="form-control" placeholder="Username" >--%>
        <label for="inputEmail" class="sr-only">Email address</label>

        <asp:TextBox ID="TextBox2" runat="server" class="form-control" placeholder="Email address"  autofocus=""></asp:TextBox>
        <%--<input type="email" id="inputEmail" class="form-control" placeholder="Email address"  autofocus="">--%>
        <label for="inputPassword" class="sr-only">Password</label>

        <asp:TextBox ID="TextBox3" runat="server" class="form-control" placeholder="Password"></asp:TextBox>
        <%--<input type="password" id="inputPassword" class="form-control" placeholder="Password" >--%>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>

            <asp:Button ID="Button1" runat="server" Text="Sign up" 
            class="btn btn-lg btn-primary btn-block" type="submit" onclick="Button1_Click"/>
        <%--<button class="btn btn-lg btn-primary btn-block" type="submit"></button>--%>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./Signin Template for Bootstrap_files/ie10-viewport-bug-workaround.js.下载"></script>
  

</body></html>