<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="zh-CN">
<head>
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

    <style type="text/css">
        .left{
            float:left;
            }
            
       .right{
           float:right;
           }
       #bs-example-navbar-collapse-1{
           color: White;
           }
      ul a{
          color:White!important;
          }
    </style>
  </head>

  <body>
  <form id="form1" runat="server">
            
    <!-- 导航栏  -->
   <nav class="navbar navbar-default" id="mynav">
     <div class="container-fluid" style="background:#222222;">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/Demo01/Default.aspx" style="color:White;">SuoSuo</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
      <ul class="nav navbar-nav">
        <li><a href="/Demo01/Default.aspx">主页 <span class="sr-only">(current)</span></a></li>
        <li><a href="/Demo01/addblog.aspx">ADD Blog</a></li>
        <li><a href="#" style="color:White;">学院</a></li>
        <li><a href="#">下载</a></li>
        <li><a href="#">论坛</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Features <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>


      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">
             <i class="fa fa-envelope-open" aria-hidden="true"></i>
        </a></li>
        <li><a href="/Demo01/register.aspx">
              <i class="fa fa-registered" aria-hidden="true"></i>
        </a></li>
        <li class="dropdown">
          <a href="/Demo01/login.aspx">
             <i class="fa-1x fa fa-user-circle-o" aria-hidden="true"></i>
          </a>
        </li>
       </ul>

       <div class="navbar-form navbar-right">
         <form class="navbar-form navbar-right" action="">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Search" />
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form> 
      </div>


    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


   <!-- 博客主体  -->
  <div class="container" >

      <div class="blog-header">
        <h1 class="blog-title">The SuoSuo Blog</h1>
        <p class="lead blog-description">The harder you work, the luckier you get.</p>
      </div>
      <div class="row">


      <!-- 左侧博客展示   -->
        <div class="col-sm-8 blog-main">
      <asp:DataList ID="DataList1" runat="server" DataSourceID="SqlDataSource1" 
                DataKeyField="id">
          <ItemTemplate>
                  <h3>
                        <a href="/Demo01/detail.aspx?id=<%# Eval("id") %>" style="text-decoration:none;">
                        <asp:Label ID="titleLabel" runat="server" style="color:Black;" Text='<%# Eval("title") %>' />
                        </a>
                        <button type="button" class="btn btn-danger right isRemove" onclick="removeItem('<%# Eval("id") %>')">（危险）Danger</button>
                </h3>
              <br />

                <asp:Label ID="introduceLabel" runat="server" Text='<%# Eval("introduce") %>' />
              <br />
             
<%--                <a style="text-decoration:none;" href="/Demo01/up_add.aspx?id=<%# Eval("id") %>&up_num=<%# Eval("up") %>">--%>
                <a class="up_span" style="text-decoration:none;" num="<%# Eval("up") %>" id_num="<%# Eval("id") %>" add_Type="/Demo01/up_add.aspx" href="/Demo01/up_add.aspx?id=<%# Eval("id") %>&up_num=<%# Eval("up") %>">
                        <i class="fa fa-thumbs-up" aria-hidden="true"></i></a> 
                <asp:Label ID="upLabel" runat="server" Text='<%# Eval("up") %>' />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                <a class="up_span" style="text-decoration:none;" id_num="<%# Eval("id") %>" num="<%# Eval("down") %>"  add_Type="/Demo01/down_add.aspx" href="/Demo01/down_add.aspx?id=<%# Eval("id") %>&down_num=<%# Eval("down") %>">
                        <i class="fa fa-thumbs-down" aria-hidden="true"></i></a>
                <asp:Label ID="downLabel" runat="server" Text='<%# Eval("down") %>' />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


<%--                 href="/Demo01/articles_comments.aspx?id=<%# Eval("id") %>&comments_num=<%# Eval("comments") %>"--%>
                <a class="span_type" style="text-decoration:none;" id_num="<%# Eval("id") %>" num="<%# Eval("comments") %>"  
                    href="/Demo01/articles_comments.aspx?id=<%# Eval("id") %>&comments_num=<%# Eval("comments") %>" >
                        <i class="fa fa-comment" aria-hidden="true"></i></a> 
                <asp:Label ID="commentsLabel" runat="server" Text='<%# Eval("comments") %>' />
                <br />
                <br />

          </ItemTemplate>
      </asp:DataList>
            <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
                ConnectionString="<%$ ConnectionStrings:myblogsConnectionString %>" 
                
                SelectCommand="SELECT [title], [introduce], [id], [up], [down], [comments] FROM [articles]">
            </asp:SqlDataSource>

          <nav>
            <ul class="pager">
              <li><a href="#">Previous</a></li>
              <li><a href="#">Next</a></li>
            </ul>
          </nav>

        </div> <!-- /.blog-main -->


        <!-- 右侧边栏  -->
        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
              <div class="sidebar-module sidebar-module-inset">
                <h4>About</h4>
                <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
              </div>
              <div class="sidebar-module">
                    <h4>Archives</h4>
                    <ol class="list-unstyled">
                      <li><a href="#">March 2014</a></li>
                      <li><a href="#">February 2014</a></li>
                      <li><a href="#">January 2014</a></li>
                      <li><a href="#">December 2013</a></li>
                      <li><a href="#">November 2013</a></li>
                      <li><a href="#">October 2013</a></li>
                      <li><a href="#">September 2013</a></li>
                      <li><a href="#">August 2013</a></li>
                      <li><a href="#">July 2013</a></li>
                      <li><a href="#">June 2013</a></li>
                      <li><a href="#">May 2013</a></li>
                      <li><a href="#">April 2013</a></li>
                    </ol>
              </div>
              <div class="sidebar-module">
                <h4>Elsewhere</h4>
                <ol class="list-unstyled">
                  <li><a href="#">GitHub</a></li>
                  <li><a href="#">Twitter</a></li>
                  <li><a href="#">Facebook</a></li>
                </ol>
              </div>
        </div><!-- /.blog-sidebar -->
      </div><!-- /.row -->

    </div>


    </form>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="static/jQuery.js"></script>
    <script>        window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script type="text/javascript" src="static/bootstrap.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script type="text/javascript" src="static/ie10-viewport-bug-workaround.js"></script>

  

      
      <script type="text/javascript">
      

//          $(function () {
//              $(".up_span").click(function () {
//                  

//              });
//          });

    </script>

</body></html>
