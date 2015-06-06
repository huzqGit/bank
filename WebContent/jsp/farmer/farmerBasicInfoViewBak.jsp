<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<title>农户信息单户信息查询</title>
<style type="text/css">
*{margin:0;padding:0}
body{scrollbar-base-color:#90D5EA;line-height:120%;font-family:"仿宋_GB2312";font-size:13pt;}
.queryPane{
background:linear-gradient(white,#6DC8E3,white);
/* IE6 & IE7 */
filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
endColorstr = 'white' ); 
/* IE8 */
-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
endColorstr = 'white' )"; 
}
.labelName{font-family:"仿宋_GB2312";font-size:16pt;line-height:150%;font-weight:bold;color:darkgreen;}
input{border:1px solid #8AD3E9;background-color:#F5F7CF;height:20px;}
.table_m{width:98%;height:250px;margin:auto auto;overflow-y:auto;overflow-x:hidden;}
.table_m table{width:100%;border-bottom:1px dotted gray}
.table_m tr:hover{background:#90D5EA}
.table_m table td{height:30px;line-height:30px;border-top:1px dotted gray;}
</style>
</head>
<body>
<div class="queryPane" style="padding-top:10px;width:100%;height:80px">
<form id="farmer" action="" method="POST">
<table width="100%" height="60px" style="vertical-align:middle;border:1px solid #8AD3E9">
	<tr>
		<td  width="5%"align="right" >
		</td>
		<td class="labelName" width="11%">
			<font color="red">*</font>农户姓名:&nbsp;&nbsp;&nbsp; 
		</td>
		<td width="10%" align=center>
			<input name="farmerName" type="text" value="${farmerName}"/>
		</td>
		<td width="1%" ></td>
		<td class="labelName"  width="15%">
			<font color="red">*</font>农户身份证号:
		</td>
		<td width="10%">
			<input name="farmerIdNum" type="text" value="${farmerIdNum}"></td>
		<td width="1%"></td>
		<td width="10%" align="left">
			<input type="button" value=""  onclick="ChaXun()"style="width:100px;height:25px;border:0;background:url(/bank/images/query.png) no-repeat">
		</td>
		<td width="10%" align="left">
			<input type="button" value=""  onclick="LuRu()" style="width:100px;height:25px;border:0;background:url(/bank/images/LuRu.png) no-repeat">
		</td>
	</tr>
</table>
</form>
</div>
<c:choose>
<c:when test="${empty farmers}">
<div>
<fieldset style="width:90%;margin:auto auto">
	 <legend style="width:310px;height:74px;background:url(/bank/images/tips.png) no-repeat"></legend>
	 <div style="padding:8px 5px 10px 35px">
	 	<p style="font-size:15px;font-family:黑体;font-weight:bold;color:darkgreen;margin-bottom:10px">农户基本信息录入功能:</p>
	 	<ol>
	 		<li>如果系统中存在该农户的基本信息，则跳转至基本信息录入界面，对该农户户的信息进行修改。</li>
	 		<li>如果系统中不存在该农户的基本信息，则跳转至基本信息录入界面，增加新的农户的信息。</li>
	 		<c:if test="${!empty msg}">
	 		<li style="color:red;font-weight:bold">${msg}</li>
	 		</c:if>
	 	</ol>
	 
	 </div>
</fieldset>
</div>
</c:when>
<c:otherwise>
<div>
<fieldset style="width:90%;margin:auto auto">
<legend style="width:310px;height:74px;background:url(/bank/images/ChaXunJieGuo.png) no-repeat"></legend>
<div class="table_m">
	<table width="100%" cellspacing="0" cellpadding="0">
	<tr style="font-weight:bold;color:black">
		<td align="center" width="8%">编号</td>
		<td align="center" width="10%">姓名</td>
		<td align="center" width="15%">身份证号码</td>
		<td align="center" width="15%">联系电话</td>
		<td align="center" width="50%">住址</td>
	</tr>
	<c:forEach items="${farmers}" var="farmer" varStatus="status">
	<tr onclick="detail(${farmer.id})">
		<td align="center">${status.index+1}</td>
		<td align="center">${farmer.farmerName}</td>
		<td align="center">${farmer.farmerIdnum}</td>
		<td align="center">${farmer.phone}</td>
		<td align="left">${farmer.address}</td>
	</tr>	
	</c:forEach>
</table>
</div>
</fieldset>
</div>
</c:otherwise>
</c:choose>
<script type="text/javascript">
function ChaXun(){
	var form = document.getElementById("farmer");
	form.action="/bank/farmer/queryFarmer.do";
	form.submit();
}
function LuRu(){
	var form = document.getElementById("farmer");
	form.action="/bank/farmer/typeInFarmer.do";
	form.submit();
}
function detail(id){
	window.location.href="/bank/farmer/loadFarmer.do?id="+id;
};
</script>
</body>
</html>