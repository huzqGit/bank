<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="reset.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="jquery-1.4.js"></script>
<!--多级抽屉型导航(分离版)start-->
<link href="skins/blue/style.css" rel="stylesheet" type="text/css" id="compStyle"/>
<script type="text/javascript" src="js/ddaccordion_split.js"></script>
<!---多级抽屉型导航(分离版)end-->

<!--去除链接虚线start-->
<script type="text/javascript">
function go2rigth() {
	alert(123);
	//var rightframe = document.getElementById("rightFrame");
	//rightframe.src="${pageContext.request.contextPath}/jsp/authorization/userView.jsp";
}
</script>
<style>
a {
	behavior:url(js/focus.htc)
}
</style>

<!--去除链接虚线end-->
<body>
	<div style="width:200px; margin-left:7px;">
	<div class="arrowlistmenu">
	<div class="menuheader expandable">权限管理</div>
	<ul class="categoryitems">
	<li><a href="javaScript:go2rigth();"><span>人员管理</span></a></li>
	<li><a href="${pageContext.request.contextPath}/jsp/authorization/organView.jsp" target="frmright"><span>机构管理</span></a></li>
	<li><a href="${pageContext.request.contextPath}/jsp/authorization/main.jsp" target="frmright"><span>菜单管理</span></a></li>
	</ul>
	<div class="menuheader expandable">基础数据配置</div>
	<ul class="categoryitems">
	<li><a href="javascript:;" target="frmright"><span>第二级1</span></a></li>
	<li><a href="javascript:;" target="frmright"><span>第二级2</span></a></li>
	</ul>
	<div class="menuheader expandable">计划管理</div>
	<ul class="categoryitems">
	<li><a href="javascript:;" target="frmright"><span>第二级1</span></a></li>
	<li><a href="javascript:;" target="frmright"><span>第二级2</span></a></li>
	</ul>
	<div class="menuheader expandable">监督记录</div>
	<ul class="categoryitems">
	<li><a target="frmright"><span>第二级1</span></a>
		<ul>
			<li><a target="frmright"><span>第三极1</span></a></li>
			<li><a href="javascript:;" target="frmright"><span>第三极2</span></a></li>
			<li><a href="javascript:;" target="frmright"><span>第三极3</span></a></li>
		</ul>
	</li>
	<li><a href="javascript:;" target="frmright"><span>第二级2</span></a></li>
	<li><a href="javascript:;" target="frmright"><span>第二级3</span></a></li>
	</ul>
	<div class="menuheader expandable">专项检查</div>
	<ul class="categoryitems">
	<li><a target="frmright"><span>第二级1</span></a>
		<ul>
			<li><a target="frmright"><span>第三极1</span></a>
				<ul>
					<li><a href="javascript:;" target="frmright"><span>第四级1</span></a></li>
					<li><a href="javascript:;" target="frmright"><span>第四级2</span></a></li>
				</ul>
			</li>
			<li><a href="javascript:;" target="frmright"><span>第三极2</span></a></li>
			<li><a href="javascript:;" target="frmright"><span>第三极3</span></a></li>
		</ul>
	</li>
	<li><a href="javascript:;" target="frmright"><span>第二级2</span></a></li>
	<li><a href="javascript:;" target="frmright"><span>第二级3</span></a></li>
	</ul>
	</div>
</div>
</body>
<!--代码高亮start-->
<script type="text/javascript" src="hl/highlight.js"></script>
<script type="text/javascript" src="hl/lang-xml.js"></script>
<script type="text/javascript" src="hl/lang-html.js"></script>
<link href="hl/style.css" rel="stylesheet" type="text/css"/>
<script>
	$(function(){
		showCode();
	})
	function showCode(){
		$(".code").each(function(){
			var code =$(this).val()
			var hl = new DlHighlight({lang: "html",lineNumbers :false });
			var formatted = hl.doItNow(code);
			$(this).next().addClass("DlHighlight").html("<pre>" + formatted + "</pre>")
		})
	}
</script>
<!--代码高亮end-->
</html>