<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@page import="com.bank.vo.MenuPrivilegeVO"%>  
<%@page import="com.bank.utils.GenerateMenu"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="reset.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="jquery-1.4.js"></script>
<!--多级抽屉型导航(分离版)start-->
<link href="skins/blue/style.css" rel="stylesheet" type="text/css" id="compStyle"/>
<script type="text/javascript" src="js/ddaccordion_split.js"></script>
<!---多级抽屉型导航(分离版)end-->
<title>左侧菜单</title>
<style type="text/css">
html,body{overflow-y:auto;overflow-x:hidden;}
body {
	margin:0px;
	padding:0px;
	font-size: 12px;
	font-family:"微软雅黑";
}
.item-title{ font-size:14px; color:#fff; font-weight:bold;}
</style>
</head>
<body style="height:100%">
  <table width="214" border="0" height="100%" cellspacing="0" cellpadding="0" style="border-left:1px #0da0d3 solid;">
    <tr>
      <td height="28" align="left" valign="top" style="background:url(../images/left-bg-s.jpg) repeat-x center;"><table width="160" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="40" height="28" align="center" valign="middle"><img src="images/detail.png" /></td>
          <td width="120" align="left" valign="middle" class="item-title">功能菜单</td>
        </tr>
      </table></td>
    </tr>
    <tr>
	  
      <td align="left" valign="top">
      
      	<%
				GenerateMenu gm=new GenerateMenu((List<MenuPrivilegeVO>)request.getAttribute("subMenus")); 
      			out.println(gm.getMenu());
			%>
<!--       	<iframe height="100%" width="100%" border="0" frameborder="0" src="leftmenu/index.html" name="leftFrame" id="leftFrame" title="leftFrame"> -->
<!--       	</iframe> -->
      </td>
    </tr>
  </table>
</body>
</html>
