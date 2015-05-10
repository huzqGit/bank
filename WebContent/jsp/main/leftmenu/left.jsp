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
<script type="text/javascript" src="/bank/jsp/main/leftmenu/jquery-1.4.js"></script>
<!--多级抽屉型导航(分离版)start-->
<link href="/bank/jsp/main/leftmenu/skins/blue/style.css" rel="stylesheet" type="text/css" id="compStyle"/>
<script type="text/javascript" src="/bank/jsp/main/leftmenu/js/ddaccordion_split.js"></script>
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
<script type="text/javascript">
	function linkurl(isleaf,url,menuid,menuname){
		top.mainFrame.rightFrame.window.location.href=url;
	}
</script>
</head>
<body style="height:100%">
	<%
				GenerateMenu gm=new GenerateMenu((List<MenuPrivilegeVO>)request.getAttribute("subMenus")); 
      			out.println(gm.getMenu());
	%>
</body>
</html>
