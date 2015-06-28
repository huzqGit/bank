<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<META content=IE=EmulateIE7 http-equiv=X-UA-Compatible>
<title>中国人民银行新干县农村信用信息管理系统</title>
<style type="text/css">
body{ margin:0 auto; background:#0a76b0;}
.login{ width:950px; background:url(/bank/jsp/login/images/dn-bg.png) top center; background-repeat:no-repeat;}
img{ border:0px;}
</style>
<!--[if IE 6]>
	<script type="text/javascript" src="js/DD_belatedPNG.js" ></script>	
	<script type="text/javascript">DD_belatedPNG.fix('img,.login');
	</script>
	<![endif]-->

<SCRIPT type=text/JavaScript>
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
$(function(){
    $('#password').bind('keypress',function(event){
        if(event.keyCode == "13")    
        {
        	login_do();
        }
    });
});
function login_do() {
	var userId = $("#userId").val();
	var password = $("#password").val();
	if (userId == "") {
		mini.alert("用户名不能为空!");
	}
	if (password == "") {
		mini.alert("密码不能为空!");
	}
	document.getElementById("form1").submit();
}
function changeFocus() {
	
}
function reset() {
	$("#userId").val("");
	$("#password").val("");
}
</SCRIPT>
</head>

<body onload="MM_preloadImages('/bank/jsp/login/images/login_11_1.gif','/bank/jsp/login/images/login_12_1.gif','/bank/jsp/login/images/login_2_1.jpg','/bank/jsp/login/images/login_1_1.jpg','/bank/jsp/login/images/login_1_1.png','/bank/jsp/login/images/login_2_1.png')">
<div align="center">
<div class="login">
<form id="form1" class="form-signin" action="${pageContext.request.contextPath}/user/login.do" method="post">
<table width="950" height="610" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td height="300" colspan="2"></td>
    </tr>
    <tr>
      <td width="360" height="152" align="right" valign="middle"></td>
      <td width="590" align="left" valign="middle"><table width="240" height="152" cellpadding="0" cellspacing="0" border="0">
        <tr>
          <td width="90" height="44"></td>
          <td width="150" align="left" valign="top"><input id="userId"
                              style="BORDER-BOTTOM: #ffffff 1px solid; BORDER-LEFT: #ffffff 1px solid; WIDTH: 110px; BACKGROUND: #FFFFFF; HEIGHT: 20px; COLOR: #ff0000; FONT-SIZE: 14px; font-family: '微软雅黑'; font-weight:bolder; BORDER-TOP: #ffffff 1px solid; BORDER-RIGHT: #ffffff 1px solid" 
                              onkeypress="changeFocus();" name="userId" /></td>
        </tr>
        <tr>
          <td height="25"></td>
          <td align="left" valign="top"><input id="password"
                              style="BORDER-BOTTOM: #ffffff 1px solid; BORDER-LEFT: #ffffff 1px solid; WIDTH: 110px; BACKGROUND: #ffffff; HEIGHT: 20px; COLOR: #ff0000; FONT-SIZE: 14px; BORDER-TOP: #ffffff 1px solid; BORDER-RIGHT: #ffffff 1px solid" 
                              type="password" 
                              name="password" /></td>
        </tr>
        <tr>
          <td height="92" colspan="2"><table width="100%" height="92" cellpadding="0" cellspacing="0" border="0">
              <tr>
                <td height="36" align="center" valign="middle" style="FILTER: glow(color=#ffffff,strength=1); HEIGHT: 40px; COLOR: #fff; FONT-SIZE: 12px"><input id="checkbox2" type="checkbox" name="checkbox2" />
                  保存用户登录信息&nbsp;&nbsp;&nbsp;&nbsp;</td>
              </tr>
              <tr>
                <td height="52" align="center" valign="top"><a href="javascript:login_do();"><img id="Image1" 
                              onmouseover="MM_swapImage('Image1','','/bank/jsp/login/images/login_1_1.png',1)" 
                              onmouseout="MM_swapImgRestore()" border="0" 
                              name="Image1" src="/bank/jsp/login/images/login_1.png" /></a>&nbsp;&nbsp;&nbsp;&nbsp;<a 
                              href="javascript:reset();"><img id="Image2" 
                              onmouseover="MM_swapImage('Image2','','images/login_2_1.png',1)" 
                              onmouseout="MM_swapImgRestore()" border="0" 
                              name="Image2" src="/bank/jsp/login/images/login_2.png" /></a></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="150" colspan="2"></td>
    </tr>
  </table>
  </form>
</div>
</div>
</body>
</html>