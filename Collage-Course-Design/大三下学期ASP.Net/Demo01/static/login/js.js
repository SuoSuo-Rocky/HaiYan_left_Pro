var webPages=bxPub.extend(webPages||{},{});webPages.site=bxPub.extend(webPages.site||{},function(){var n=webPages.site.funs;return $.fn.placeholder=function(n,t){function r(n){function s(){t.hide(),n[0].focus()}function u(){var i=n.offset(),r=i.top,u=i.left;t.css({top:r,left:u})}function p(){t.click(function(){s(),setTimeout(function(){n.click()},100)}),n.click(s),n.blur(function(){var i=n.val();i==""&&t.show()})}function w(){t.click(function(){n[0].focus()})}var h=i.word,c=i.color,f=i.evtType,b=i.zIndex,l=i.diffPaddingLeft,a=n.outerWidth(),e=n.outerHeight(),v=n.css("font-size"),y=n.css("font-family"),r=n.css("padding-left"),t,o;r=parseInt(r,10)+l,t=$('<span class="placeholder">'),t.css({position:"absolute",zIndex:"20",color:c,width:a-r+"px",height:e+"px",fontSize:v,paddingLeft:r+"px",fontFamily:y}).text(h).hide(),u(),n.is("input")&&t.css({lineHeight:e+"px"}),t.appendTo(document.body),o=n.val(),o==""&&n.is(":visible")&&t.show(),f=="focus"?p():f=="keydown"&&w(),n.keyup(function(){var i=n.val();i==""?t.show():t.hide()}),$(window).resize(function(){u()}),n.data("el",t),n.data("move",u)}var i=$.extend({word:"",color:"#999",evtType:"focus",zIndex:20,diffPaddingLeft:3},n);return this.each(function(){var n=$(this);r(n),$.isFunction(t)&&t(n)})},function(){var t=n.getLang()=="en"?"This information is required":"熊猫君提醒您",i=n.getLang()=="en"?"en":"cn",u=n.showMessage,r;n.showMessage=function(n,r){var f=bxPub.extend({title:t,lang:i},n,r);return u(f,r)},r=n.confirm,n.confirm=function(n,u){var f=bxPub.extend({title:t,lang:i},n,u);return r(f,u)}}(),{joinus:function(){return{init:function(){this.initShow()},initShow:function(){for(var i=$(".bdjoinus .divPageMainMiddle .divRw2 .divItem"),t=0;t<i.length/3;t++)i.eq(t*3).addClass("row1"),i.eq(t*3+1).addClass("row2"),i.eq(t*3+2).addClass("row3");$(".bdjoinus .divPageMainMiddle .divRw2 .divItem").hover(function(){$(this).find(".jiantou").show(),$(this).find(".divHoverInfo").show()},function(){$(this).find(".jiantou").hide(),$(this).find(".divHoverInfo").hide()}),$(".abtnJl").click(function(){var i=$(this).attr("zw"),t=bxPrompt({title:"请上传简历",inputs:[{name:"file",remark:"请上传简历",type:"file",option:{button_text:'<span class="button">浏览文件<\/span>'}}],callBackOk:function(r){return r.file==""?(alert("请上传简历"),!1):(n.addGBookMessage({name:i,file:"http://www.chinarun.com"+r.file},"jianli",function(i,r){return i==0?(t.setWaiting(!1),t.close(),alert("提交成功")):(t.setWaiting(!1),alert(n.getWords("提交失败："+r,"Submission failed,Please check the input"))),!1}),t.setWaiting(!1),!1)}});return!1})}}}()}}())