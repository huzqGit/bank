<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<title>农户信息条件查询</title>
<style type="text/css">
.file{
        position:absolute;
        top:0px;
        left:0px;
        width:120px;
        height:24px;
		opacity:0;
		filter:alpha(opacity=0);
	
		}
li{
margin-top:5px;
width:100%;
text-align:left;
float:left;
}
</style>
</head>
<body>

<div style="padding-top:10px;width:100%">
<form id="apply"  method="POST" enctype="multipart/form-data">
<input name="farmerIds" type="hidden" value="${farmerIds}"/>
<input name="apply" type="hidden" value="${apply}"/>
<table width="100%" style="vertical-align:middle">
	<tr>
		<td class="labelName"  width="40%" align="right" >身份证号码</td>
		<td width="2%"></td>
		<td width="15%"align="left">
			<input name="farmeridnum" type="text" class="bank-text">
		</td>
		<td align="left">		
			<input type="button" onclick="query()" class="bank-btn" value ="申请" />
		</td>
	</tr>
	<tr>
	<td colspan="4" style="text-align:center;height:30px;font-size:16px;color:red">
		${msg}
	</td>
	</tr>
</table>
</form>
</div>
<div>
<fieldset style="width:90%;margin:auto auto">
	 <legend style="width:310px;height:74px;background:url(/bank/images/threetips.png) no-repeat"></legend>
	 <div style="padding:8px 5px 10px 35px">
	 	<p style="font-size:15px;font-family:黑体;font-weight:bold;margin-bottom:10px">用户输入农户姓名、身份证号码可以实现二类查询功能:</p>
	 	<ol>
	 		<li>输入身份证号码后点击"申请"按钮。</li>
	 		<li>如果不存在相应身份证号码的农户，页面将返回并提示未找到匹配的农户。</li>
	 		<li>如果存在相应身份证号码的农户，则用户可在一个工作日后下载该农户的信用信息。</li>
	 	</ol>
	 
	 </div>
</fieldset>
</div>
<script type="text/javascript">
function detail(id){
	window.location.href="/bank/farmer/loadChanQuan.do?fid="+id;
};
function query(){
	var form = document.getElementById("apply");
	form.action="/bank/farmer/loadFarmerFive.do";
	form.submit();
};
function offLineApply(){
	var form = document.getElementById("apply");
	form.action="/bank/farmer/offlineApply.do";
	form.submit();
};
</script>
</body>
</html>