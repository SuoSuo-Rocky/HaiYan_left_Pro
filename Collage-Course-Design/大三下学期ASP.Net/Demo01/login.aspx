<%@ Page Language="C#" AutoEventWireup="true" CodeFile="login.aspx.cs" Inherits="login" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<!DOCTYPE html>
<!-- saved from url=(0042)http://www.runff.com/html/memberlogin.html -->
<html class=" htMember_simple htMemberLogin" xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="wap-font-scale" content="no">
<meta name="format-detection" content="telephone=no">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
<title>SuoSuo</title>
<link type="text/css" rel="StyleSheet" href="static/login/website.css">
<link type="text/css" rel="StyleSheet" href="static/login/site.css">
<link type="text/css" rel="StyleSheet" href="static/login/base.css">
<link type="text/css" rel="StyleSheet" href="static/login/runff.css">
<script type="text/javascript" src="static/login/hm.js"></script>
<script type="text/javascript" src="static/login/hm02.js"></script>
<script type="text/javascript" src="static/login/jquery.js"></script>
<script type="text/javascript" src="static/login/bxjslib.js"></script>
<script type="text/javascript" src="static/login/site.js"></script>
<script type="text/javascript" src="static/login/js.js"></script>
<script type="text/javascript" src="static/login/runff.js"></script>

<script>
    var ssGlobal = { jsonp: '' }
    </script>
    <script>
        })();
    </script>

<script type="text/javascript">
             var _hmt = _hmt || [];
             (function () {
                 var hm = document.createElement("script");
                 hm.src = "//hm.baidu.com/hm.js?3de671d246685f9f53214b84803799b6";
                 var s = document.getElementsByTagName("script")[0];
                 s.parentNode.insertBefore(hm, s);
             })();
</script>
<style type="text/css">.divSiteSupport{display:none;}</style>
<meta name="keywords" content="">
<meta name="description" content="">

<style>
   
    #mubody{
          background-image:url("./static/imgs/login.jpg");
        }

</style>
</head>
<body class="bdMember_simple bdMemberLogin" id="mubody">
<form id="form1" runat="server">
<div class="divMemberSimple divMemberLogin divHA" id="back">
        <div class="divForm">
            <div class="divForm_caption">登录</div>
            <div class="divForm_row divForm_row_normal">
                <div class="divForm_cell divForm_cell_head">账号</div>
                <div class="divForm_cell divForm_cell_body">

                <asp:TextBox ID="TextBox1" runat="server" placeholder="用户名/手机/邮箱" class="txt"></asp:TextBox>
                <%--<input type="text" class="txt" id="txtLoginName" placeholder="用户名/手机/邮箱"></div>--%>
                <div class="divForm_cell divForm_cell_remark"><span val="[object Object]"></span></div>
            </div>
            <div class="divForm_row divForm_row_normal">
                <div class="divForm_cell divForm_cell_head">密码</div>
                <div class="divForm_cell divForm_cell_body">
                <asp:TextBox ID="TextBox2" runat="server" type="password" class="txt"></asp:TextBox>
               <%-- <input type="password" class="txt" id="txtLoginPsw"></div>--%>
                <div class="divForm_cell divForm_cell_remark"><span val="[object Object]"></span></div>
            </div>
            <div class="divForm_row divForm_row_mobile">
                <div class="divForm_cell divForm_cell_head">手机号码</div>
                <div class="divForm_cell divForm_cell_body"><input type="text" class="txt" id="txtLoginMobile" placeholder="您的手机号码"></div>
                <div class="divForm_cell divForm_cell_remark"><span val="[object Object]"></span></div>
            </div>
            <div class="divForm_row divForm_row_mobile">
                <div class="divForm_cell divForm_cell_head">短信验证码</div>
                <div class="divForm_cell divForm_cell_body"><input type="text" class="txt txtVcode" id="txtLoginMobileCode">
                <a id="aGetMobileCode" href="#">获取验证码</a>
                  </div>
                <div class="divForm_cell divForm_cell_remark"><span val="[object Object]"></span></div>
            </div>

            <div class="divForm_row">
                <div class="divForm_cell divForm_cell_head"></div>
                <div class="divForm_cell divForm_cell_body">
                <input type="checkbox" class="chk" id="chkRememberPassword" checked="checked"> 
                <label for="chkRememberPassword">自动登录</label></div>
                <div class="divForm_cell divForm_cell_remark"></div>
            </div>
            <div class="divForm_row divForm_row_normal">
                <div class="divForm_cell divForm_cell_btns">
                   <asp:Button ID="Button1" runat="server" Text="登 录" class="aBtn" onclick="Button1_Click" />
                </div>
            </div>
            <div class="divForm_row divForm_row_normal">
                <div class="divForm_cell divForm_cell_head"></div>
                <div class="divForm_cell divForm_cell_body"><div class="divLinks">
                <a >注册账号</a><br>
                <a >找回密码</a>
                </div>
                </div>
                <div class="divForm_cell divForm_cell_remark"></div>
            </div>
            <div class="divForm_row divForm_row_mobile">
                <div class="divForm_cell divForm_cell_head"></div>
                <div class="divForm_cell divForm_cell_body"><div class="divLinks"><br>
                <a href="#" id="aBtnLoginNormal">普通登录</a>
                </div>
                </div>
                <div class="divForm_cell divForm_cell_remark"></div>
            </div>
            <div class="divForm_row divQuckLogin" style="display: block;">
                <div class="divForm_cell divForm_cell_other">
                <div class="divSubTitle">快捷登录</div>
                <div class="divLoginThird divHA">
                <a href="#" class="aItem aItem_weixin aBtnLoginWeixin" title="微信登录"></a>
                </div>
                </div>
            </div>
        </div>
        </div>
        <script>
            webPages.site.userLogin.init({ "wxMpAppId": "wxb5636d699fc1b88b" });
        </script>
     </form>
</body>
</html>
