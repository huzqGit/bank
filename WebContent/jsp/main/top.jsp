<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="com.bank.beans.Organ"%>
<%@page import="com.bank.beans.User"%>
<%
String root = request.getContextPath();
List topMenus = (List)request.getSession().getAttribute("topMenus");
Organ organ =(Organ)request.getSession().getAttribute("unit");
User user =(User)request.getSession().getAttribute("user");
String userName = user.getUserName();
String organName = organ.getOrganName();
request.setAttribute("root", root);
request.setAttribute("topMenus", topMenus);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
body {margin-left: 0px;	margin-top: 0px; margin-right: 0px;	margin-bottom: 0px;	font-size:14px;	color:#666; font-family:"å¾®è½¯éé»";}
a {font-size: 14px; text-decoration: none ;outline:none;}
a:link { text-decoration: none;color:#666; }
a:visited { text-decoration: none;color:#666; }
a:hover { text-decoration: none; color:#0b8594; }
a:active { text-decoration: none; }
a img {	border:none; }

.top-link {font-size:14px; color:#666; background:url(images/quick.png) bottom; width:100px; height:28px; text-align:center;}
.top-link span {font-size:14px; padding-top:3px; height:25px; overflow:hidden; display:block;}
.top-link a { font-size:14px; text-decoration: none;  color:#666;}
.top-link a:link { text-decoration: none;}
.top-link a:visited { text-decoration: none; }
.top-link a:hover { text-decoration: none; color:#fff; background:url(images/quick-on.png) bottom; width:100px; display:block;}
.menu a:active{ text-decoration: none; }

.menu {font-size:14px; font-weight:bold;color:#ffff00; background:url(images/menu-bg.png) top; width:80px; height:25px;}
.menu a { font-size:14px; text-decoration: none;  color:#000;}
.menu a:link { text-decoration: none;}
.menu a:visited { text-decoration: none; }
.menu a:hover { text-decoration: none; color:#fff; background:url(images/menu-bg-on.png) top; width:80px; height:22px; display:block; padding-top:3px; font-weight:bolder;}
.menu a:active{ text-decoration: none; }

.user-man{ float:left; width:66px; height:60px; background:url(images/man.jpg) center no-repeat;}
.user-women{ float:left; width:66px; height:60px; background:url(images/women.jpg) center no-repeat;}
.user-p{ width:66px; text-align:center; height:20px; padding-top:40px;}

.clock{ background:url(images/clock.gif) left no-repeat; padding-left:24px;}

.font{ padding:0 5px 0 5px; color:#FFFFFF; font-size:12px;  font-family:"微软雅黑"; font-weight:bolder;}
.font a {font-size: 12px; text-decoration: none ;}
.font a:link { text-decoration: none;color:#fff; }
.font a:visited { text-decoration: none;color:#fff; }
.font a:hover { text-decoration: none; color:#ffff00; }
.font a:active { text-decoration: none; }
</style>
<!--[if lt IE 7]>
<script type="text/javascript" src="js/unitpngfix.js"></script>
<![endif]-->
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script type='text/javascript'>
	window.onbeforeunload = function(){
		outAction();
		//var warning="===========确认离开该页面?=================";
		//return warning;
	}
	/* window.onunload = function(){
		var warning="谢谢光临";
		alert(warning);
	}; */
	function go2Login(){
		outAction();
		window.parent.location.href="/bank/jsp/login/login.jsp";
	}
	function outAction(){
		$.ajax({
			url: "/bank/user/logoutAction.do",
			type:'post',
			async:false,
			error:function(){},
			success:function(){}
		});
	}
	//左侧链接方法
	function linkToLeft(url,menuid){

		if(menuid==1){
			parent.mainFrame.document.getElementById("frmTitle").style.display="none";
			parent.mainFrame.document.getElementById("switcher").style.display="none";
			parent.mainFrame.rightFrame.window.location.href = "/bank/message/loadIndexPage.do";
		}else{
			parent.mainFrame.document.getElementById("frmTitle").style.display="block";
			parent.mainFrame.document.getElementById("switcher").style.display="";
			parent.mainFrame.leftFrame.leftFrame.window.location.href = url;
			parent.mainFrame.rightFrame.window.location.href = "/bank/jsp/main/blank.html";

		}
		
		
	}
		
</script>
</head>

<body>
<table width="100%" style="border-bottom:2px solid orange;background-repeat:repeat-x; background:url(images/top.jpg); background-position: top left;" cellspacing="0" cellpadding="0">
  <tr> 
    <td height="72"  align="left" valign="middle" style="border-left:1px #0da0d3 solid; border-right:1px #0da0d3 solid;">
	<table width="100%"  cellspacing="0" cellpadding="0">
      <tr>
        <td width="50%" height="72" align="left" valign="top" >
        	<div style="float:right;width:400px;height:40px;background:url(/bank/jsp/main/images/systitle.png) no-repeat"></div>
        
        </td>
        <td width="50%" height="72" align="right" valign="bottom">
		<table width="400"  border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td colspan="7" align="center">
				<span  style="font-size:15px;color:black"><%=organName %>的</span>
				<span style="font-size:15px;font-weight:bold;color:red"><%=userName %></span>
				<span  style="font-size:15px;color:black">&nbsp;&nbsp;您好!</span>
			</td>
		</tr>
          <tr >
          	<td width="40" height="40px" style="background:url(/bank/jsp/main/images/tab_l.png) no-repeat"></td>
            <td width="25"  style="background:url(/bank/jsp/main/images/tab_c.png) repeat-x" align="center"><img src="images/clear.png" /></td>
            <td width="80" align="left" style="background:url(/bank/jsp/main/images/tab_c.png) repeat-x" class="font"><a href="#">清除缓存</a></td>
            <td width="25"style="background:url(/bank/jsp/main/images/tab_c.png) repeat-x"  align="center"><img src="images/user2.png" width="16" height="16" /></td>
            <td width="80"align="left"style="background:url(/bank/jsp/main/images/tab_c.png) repeat-x"  class="font"><a href="#">修改密码</a></td>
            <td width="25"  style="background:url(/bank/jsp/main/images/tab_c.png) no-repeat" align="center"><img src="images/out.png" /></td>
            <td width="175" align="left" style="background:url(/bank/jsp/main/images/tab_c.png) repeat-x"  class="font"><a href="javascript: go2Login();">注销登录</a></td>
          </tr>
        </table>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="25" align="left" valign="middle" style="border-left:1px #0da0d3 solid; border-right:1px #0da0d3 solid;">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="96%" align="left" valign="middle">
        <table border="0" cellspacing="0" cellpadding="0">
          <tr>
          	<c:forEach items="${topMenus}" var="topMenu">
            	<td  height="25" align="center" valign="middle" class="menu"><a href="javascript:linkToLeft('${root}/user/left.do?topMenuId=${topMenu.menuId}',${topMenu.menuId});">${topMenu.menuDescr}</a></td>
            </c:forEach>
          </tr>
        </table>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
