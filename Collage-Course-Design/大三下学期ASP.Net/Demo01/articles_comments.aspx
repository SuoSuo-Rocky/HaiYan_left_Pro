<%@ Page Language="C#" AutoEventWireup="true" CodeFile="articles_comments.aspx.cs" Inherits="articles_comments" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="zh-CN">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
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
     
     <!-- KindEditor  -->
    <link rel="stylesheet" href="static/plugins/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="static/plugins/kindeditor/plugins/code/prettify.css" />
     <script type="text/javascript"  src="static/plugins/kindeditor/lang/zh-CN.js" />
     <script type="text/javascript"  src="static/plugins/kindeditor/kindeditor-all-min.js" />
     <script type="text/javascript"  src="static/plugins/kindeditor/kindeditor-all.js" />
    <script type="text/javascript"   src="static/plugins/kindeditor/plugins/code/prettify.js" />
    <script type="text/javascript"   src="static/plugins/kindeditor/kindeditor.js" />


     <!-- Bootstrap    -->
     <script type="text/javascript" src="static/plugins/Jquery/de_jQuery_3_3_1.js"></script>
     <link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrap.min.css" />
     <link rel="stylesheet" href="static/plugins/bootstrap/css/bootstrap-theme.min.css" />

      <link rel="stylesheet" href="static/plugins/bootstrap/fonts/glyphicons-halflings-regular.woff" />

     <script type="text/javascript" src="static/plugins/bootstrap/js/bootstrap.min.js" />  


    
   
     
    <script type="text/javascript">
        KindEditor.ready(function (K) {
            var editor1 = K.create('#content1', {
            cssPath: 'static/plugins/kindeditor/plugins/code/prettify.css',
            uploadJson: 'static/plugins/kindeditor/asp.net/upload_json.ashx',
            fileManagerJson: 'static/plugins/kindeditor/asp.net/file_manager_json.ashx',
            allowFileManager: true,
            afterCreate: function () {
                var self = this;
                K.ctrl(document, 13, function () {
                    self.sync();
                    K('form[name=example]')[0].submit();
                });
                K.ctrl(self.edit.doc, 13, function () {
                    self.sync();
                    K('form[name=example]')[0].submit();
                });
            }
        });
        prettyPrint();
    });
	</script>


    


    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
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
           <nav class="navbar navbar-default">
                                                                                                                                                                                                                                                                                                                                                                                                                                                                             <div class="container-fluid" style="background:#222222;color:White;">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="/Demo01/Default.aspx" style="color:White;" >SuoSuo</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="color:White;">
              <ul class="nav navbar-nav" style="color:White;">
                <li><a href="/Demo01/Default.aspx">主页 <span class="sr-only">(current)</span></a></li>
                <li><a href="/Demo01/addblog.aspx">ADD Blog</a></li>
                <li><a href="#">学院</a></li>
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
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                     <i class="fa-1x fa fa-user-circle-o" aria-hidden="true"></i>
                   <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">个人信息</a></li>
                    <li><a href="#">Log out</a></li>
                  </ul>
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
          <div class="container">

              <div class="blog-header">
                <h1 class="blog-title">The SuoSuo Blog</h1>
                <p class="lead blog-description">The harder you work, the luckier you get.</p>
              </div>

              <div class="row">

               <!-- 左侧博客展示   -->
                <div class="col-sm-8 blog-main">
              <%--  <textarea cols="" rows="" id="content1" name="content1" style="width: 100%;height:400px;visibility='hidden';"></textarea>--%>
                   <textarea id="content1" cols="100" rows="8" style="width:700px;height:200px;visibility:visible;" runat="server"></textarea>
                   <br />
                   <asp:Button ID="Button1" runat="server" Text="提交内容" onclick="Button1_Click" /> (提交快捷键: Ctrl + Enter)
                                                                                                                                                                                                                                                                                                  <%--<div class="myblock">
			<div class="ke-container ke-container-default" style="width: 95%;">
            <div style="display:block;" class="ke-toolbar" unselectable="on">
            <span class="ke-outline" data-name="source" title="HTML代码" unselectable="on">
            <span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-source" unselectable="on">
            </span></span><span class="ke-inline-block ke-separator"></span>
            <span class="ke-outline" data-name="undo" title="后退(Ctrl+Z)" unselectable="on">
            <span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-undo" unselectable="on"></span>
            </span><span class="ke-outline" data-name="redo" title="前进(Ctrl+Y)" unselectable="on">
            <span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-redo" unselectable="on"></span>
            </span><span class="ke-inline-block ke-separator">
            </span><span class="ke-outline" data-name="preview" title="预览" unselectable="on">
            <span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-preview" unselectable="on"></span>
            </span><span class="ke-outline" data-name="print" title="打印(Ctrl+P)" unselectable="on">
            <span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-print" unselectable="on"></span></span>
            <span class="ke-outline" data-name="template" title="插入模板" unselectable="on">
            <span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-template" unselectable="on"></span></span>
            <span class="ke-outline" data-name="code" title="插入程序代码" unselectable="on">
            <span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-code" unselectable="on"></span></span>
            <span class="ke-outline" data-name="cut" title="剪切(Ctrl+X)" unselectable="on">
            <span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-cut" unselectable="on"></span></span>
            <span class="ke-outline" data-name="copy" title="复制(Ctrl+C)" unselectable="on">
            <span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-copy" unselectable="on"></span></span>
            <span class="ke-outline" data-name="paste" title="粘贴(Ctrl+V)" unselectable="on">
            <span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-paste" unselectable="on"></span></span>
            <span class="ke-outline" data-name="plainpaste" title="粘贴为无格式文本" unselectable="on">
            <span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-plainpaste" unselectable="on"></span></span>
            <span class="ke-outline" data-name="wordpaste" title="从Word粘贴" unselectable="on">
            <span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-wordpaste" unselectable="on"></span></span>
            <span class="ke-inline-block ke-separator"></span><span class="ke-outline" data-name="justifyleft" title="左对齐" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-justifyleft" unselectable="on"></span></span><span class="ke-outline" data-name="justifycenter" title="居中" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-justifycenter" unselectable="on"></span></span><span class="ke-outline" data-name="justifyright" title="右对齐" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-justifyright" unselectable="on"></span></span><span class="ke-outline" data-name="justifyfull" title="两端对齐" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-justifyfull" unselectable="on"></span></span><span class="ke-outline" data-name="insertorderedlist" title="编号" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-insertorderedlist" unselectable="on"></span></span><span class="ke-outline" data-name="insertunorderedlist" title="项目符号" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-insertunorderedlist" unselectable="on"></span></span><span class="ke-outline" data-name="indent" title="增加缩进" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-indent" unselectable="on"></span></span><span class="ke-outline" data-name="outdent" title="减少缩进" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-outdent" unselectable="on"></span></span><span class="ke-outline" data-name="subscript" title="下标" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-subscript" unselectable="on"></span></span><span class="ke-outline" data-name="superscript" title="上标" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-superscript" unselectable="on"></span></span><span class="ke-outline" data-name="clearhtml" title="清理HTML代码" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-clearhtml" unselectable="on"></span></span><span class="ke-outline" data-name="quickformat" title="一键排版" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-quickformat" unselectable="on"></span></span><span class="ke-outline" data-name="selectall" title="全选(Ctrl+A)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-selectall" unselectable="on"></span></span><span class="ke-inline-block ke-separator"></span><span class="ke-outline" data-name="fullscreen" title="全屏显示" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-fullscreen" unselectable="on"></span></span><div class="ke-hr"></div><span class="ke-outline" data-name="formatblock" title="段落" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-formatblock" unselectable="on"></span></span><span class="ke-outline" data-name="fontname" title="字体" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-fontname" unselectable="on"></span></span><span class="ke-outline" data-name="fontsize" title="文字大小" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-fontsize" unselectable="on"></span></span><span class="ke-inline-block ke-separator"></span><span class="ke-outline" data-name="forecolor" title="文字颜色" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-forecolor" unselectable="on"></span></span><span class="ke-outline" data-name="hilitecolor" title="文字背景" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-hilitecolor" unselectable="on"></span></span><span class="ke-outline" data-name="bold" title="粗体(Ctrl+B)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-bold" unselectable="on"></span></span><span class="ke-outline" data-name="italic" title="斜体(Ctrl+I)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-italic" unselectable="on"></span></span><span class="ke-outline" data-name="underline" title="下划线(Ctrl+U)" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-underline" unselectable="on"></span></span><span class="ke-outline" data-name="strikethrough" title="删除线" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-strikethrough" unselectable="on"></span></span><span class="ke-outline" data-name="lineheight" title="行距" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-lineheight" unselectable="on"></span></span><span class="ke-outline" data-name="removeformat" title="删除格式" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-removeformat" unselectable="on"></span></span><span class="ke-inline-block ke-separator"></span><span class="ke-outline" data-name="image" title="图片" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-image" unselectable="on"></span></span><span class="ke-outline" data-name="multiimage" title="批量图片上传" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-multiimage" unselectable="on"></span></span><span class="ke-outline" data-name="flash" title="Flash" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-flash" unselectable="on"></span></span><span class="ke-outline" data-name="media" title="视音频" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-media" unselectable="on"></span></span><span class="ke-outline" data-name="insertfile" title="插入文件" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-insertfile" unselectable="on"></span></span><span class="ke-outline" data-name="table" title="表格" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-table" unselectable="on"></span></span><span class="ke-outline" data-name="hr" title="插入横线" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-hr" unselectable="on"></span></span><span class="ke-outline" data-name="emoticons" title="插入表情" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-emoticons" unselectable="on"></span></span><span class="ke-outline" data-name="baidumap" title="百度地图" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-baidumap" unselectable="on"></span></span><span class="ke-outline" data-name="pagebreak" title="插入分页符" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-pagebreak" unselectable="on"></span></span><span class="ke-outline" data-name="anchor" title="锚点" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-anchor" unselectable="on"></span></span><span class="ke-outline" data-name="link" title="超级链接" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-link" unselectable="on"></span></span><span class="ke-outline" data-name="unlink" title="取消超级链接" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-unlink" unselectable="on"></span></span><span class="ke-inline-block ke-separator"></span><span class="ke-outline" data-name="about" title="关于" unselectable="on"><span class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-about" unselectable="on"></span></span></div><div style="display: block; height: 138px;" class="ke-edit"><iframe class="ke-edit-iframe" hidefocus="true" style="width: 100%; height: 138px;" tabindex="" frameborder="0"></iframe><textarea class="ke-edit-textarea" hidefocus="true" style="width: 100%; height: 138px; display: none;" tabindex=""></textarea></div><div class="ke-statusbar"><span class="ke-inline-block ke-statusbar-center-icon"></span><span class="ke-inline-block ke-statusbar-right-icon"></span></div></div><textarea id="ke_demo" name="content" rows="20" cols="100" style="width: 95%; height: 200px; visibility: hidden; display: none;">&lt;p&gt;Think Different&lt;/p&gt;
&lt;p&gt;Here’s to the crazy ones. The misfits. The rebels. The troublemakers. The round pegs in the square holes. The ones who see things differently. They’re not fond of rules. And they have no respect for the status quo. You can quote them, disagree with them, glorify or vilify them. About the only thing you can’t do is ignore them. Because they change things. They push the human race forward. And while some may see them as the crazy ones, we see genius. Because the people who are crazy enough to think they can change the world, are the ones who do.&nbsp;&lt;/p&gt;
&lt;p&gt;- Apple Inc.&lt;/p&gt;
			</textarea>
		</div>
--%>
                </div>

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
        </div>

            </div>


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



</body>
</html>
