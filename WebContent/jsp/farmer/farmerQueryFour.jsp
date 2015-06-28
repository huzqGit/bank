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
<title>信用报告查询</title>
<style type="text/css">
*{margin:0;padding:0}
body{line-height:120%;font-family:"仿宋_GB2312";font-size:13pt;}
</style>
</head>
<body>
<div class="queryPane">
<form action="/bank/farmer/loadFarmerFour.do" method="POST">
<table  style="width:100%">
	<tr>
		<td class="labelName"  width="20%" style="text-align:right">农户身份证号:&nbsp;&nbsp;&nbsp;
		<input type="text" name="farmerIdNum" class="bank-text">
		</td>
		<td width="1%"></td>
		<td width="20%" align="left">
			<input type="submit" class="bank-btn" value="查询">
		</td>
	</tr>
</table>
</form>
</div>
<c:choose>
<c:when test="${empty farmers}">
<div>
<fieldset class="bank-view-fieldset" style="width:90%;margin:auto auto">
	 <legend style="width:310px;height:74px;background:url(/bank/images/tips.png) no-repeat"></legend>
	 <div style="padding:8px 5px 10px 35px">
	 	<p style="font-size:15px;font-family:黑体;font-weight:bold;color:darkgreen;margin-bottom:10px">用户输入农户姓名、身份证号码可以实现二类查询功能:</p>
	 	<ol>
	 		<li>按农户身份证号精确查询、按客户姓名精确查询。</li>
	 		<li>其中按身份证号查询方式跳转至农户概况信息页面，展示农户的概况信息。</li>
	 		<li>其中按姓名查询方式跳转至农户列表信息展示页面，展示负荷条件的多个农户的摘要信息，选择其中的某条记录（通过"详细"按钮）跳转至农户概况信息页面。</li>
	 	</ol>
	 
	 </div>
</fieldset>
</div>
</c:when>
<c:otherwise>
<div>
<fieldset style="width:90%;margin:auto auto">
<legend style="width:310px;height:74px;background:url(/bank/images/tips.png) no-repeat"></legend>
<div class="table_m">
	<table width="90%">
	<tr style="font-weight:bold;color:#ff6666">
		<td align="center">编号</td>
		<td align="center">姓名</td>
		<td align="center">身份证号码</td>
		<td align="center">联系电话</td>
		<td align="center">住址</td>
	</tr>
	<c:forEach items="${farmers}" var="farmer" varStatus="status">
	<tr onclick="detail(${farmer.id})">
		<td align="center">${status.index+1}</td>
		<td align="center">${farmer.farmername}</td>
		<td align="center">${farmer.farmeridnum}</td>
		<td align="center">${farmer.phone}</td>
		<td align="center">${farmer.address}</td>
	</tr>	
	</c:forEach>
</table>
</div>
</fieldset>
</div>
</c:otherwise>
</c:choose>
<script type="text/javascript">
function detail(id){
	window.location.href="/bank/farmer/loadFarmerReport.do?id="+id;
};
</script>
</body>
</html>