<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<title>农户信息条件查询</title>
<style type="text/css">
*{margin:0;padding:0}
body{
line-height:15px;
}
.queryPane{
background:linear-gradient(white,#6DC8E3,white);
/* IE6 & IE7 */
filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
endColorstr = 'white' ); 
/* IE8 */
-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
endColorstr = 'white' )"; 
}
.labelName{
font-size:15px;
font-weight:bold;
color:darkgreen;
}
input{
border:1px solid #8AD3E9;
background-color:#F5F7CF;
height:20px;
}
li{
margin-top:5px
}
</style>
</head>
<body>
<div class="queryPane" style="padding-top:10px;width:100%">
<table width="100%" style="vertical-align:middle;border:1px solid #8AD3E9">
	<tr>
		<td class="labelName" width="30%"align="right" >地区:</td> 
		<td width="2%" ></td>
		<td width="10%"><input type="text"/></td>
		<td width="2%" ></td>
		<td class="labelName"  width="10%" align="right">金融机构名称:</td>
		<td align="left"><input  type="text"></td>
	</tr>
	<tr>
		<td class="labelName" width="30%"align="right" >时间从:</td> 
		<td width="2%" ></td>
		<td><input type="text"/></td>
		<td width="2%" ></td>
		<td class="labelName"  width="10%" align="right">到:</td>
		<td><input  type="text"></td>
	</tr>
	<tr>
		<td class="labelName" width="30%"align="right" >贷款余额范围从:</td> 
		<td width="2%" ></td>
		<td><input type="text"/></td>
		<td width="2%" ></td>
		<td class="labelName"  width="10%" align="right">到:</td>
		<td><input  type="text"></td>
	</tr>
	<tr>
		<td class="labelName" width="30%"align="right" >资产总额范围从:</td>
		<td width="2%" ></td>
		<td><input type="text"/></td>
		<td width="2%" ></td>
		<td class="labelName"  width="10%"  align="right">到:</td>
		<td><input  type="text"></td>
	</tr>
	<tr>
		<td class="labelName" width="30%"align="right" >收入范围从:</td>
		<td width="2%" ></td>
		<td><input type="text"/></td>
		<td width="2%" ></td>
		<td class="labelName"  width="10%"  align="right">到:</td>
		<td><input  type="text"></td>
	</tr>
	<tr>
		<td colspan="5">
		<td  align="center">
			<input type="button"style="width:100px;height:25px;margin-top:10px;border:0;background:url(/bank/images/query.png) no-repeat">
		</td>
	</tr>
</table>
</div>
<div>
<fieldset style="width:90%;margin:auto auto">
	 <legend style="width:310px;height:74px;background:url(/bank/images/threetips.png) no-repeat"></legend>
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
</body>
</html>