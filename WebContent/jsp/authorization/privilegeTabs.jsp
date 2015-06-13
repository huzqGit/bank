<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>
<html>
<head>
<title>权限控制主页</title>
</head>
<%
	String roleId = request.getParameter("roleId");
	request.setAttribute("roleId", roleId);
%>
<style type="text/css">
    html, body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
</style>
<body>

 <div id="layout1" class="mini-layout" style="width:100%;height:100%;">
    <div title="center" region="center" style="width:100%;border-bottom:0;padding:0px;">
    	<div id="tabs1" class="mini-tabs" activeIndex="0" plain="false" style="height:98%">
    		<div title="人员信息" url="${pageContext.request.contextPath}/jsp/authorization/userRole.jsp?roleId=${roleId}">
    		</div>
    		<div title="菜单资源信息" url="${pageContext.request.contextPath}/jsp/authorization/menuPrivilegeRole.jsp?roleId=${roleId}">
    		</div>
    	</div>
    </div>
    
</div>
    <script type="text/javascript">
        mini.parse();

    </script>
    

</body>
</html>