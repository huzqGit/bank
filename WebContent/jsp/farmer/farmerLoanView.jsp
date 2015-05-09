<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<title>农户信息单户信息查询</title>
<style type="text/css">
*{margin:0;padding:0}
body{line-height:10px;}
.queryPane{
background:linear-gradient(white,#6DC8E3,white);
/* IE6 & IE7 */
filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
endColorstr = 'white' ); 
/* IE8 */
-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
endColorstr = 'white' )"; 
}
.labelName{font-size:15px;font-weight:bold;color:darkgreen;}
input{border:1px solid #8AD3E9;background-color:#F5F7CF;height:20px;}
li{margin-top:5px}
</style>
</head>
<body>
<div class="queryPane" style="padding-top:10px;width:100%;height:80px">
<form action="/bank/loan/typeInLoan.do" method="POST">
<table width="100%" height="60px" style="vertical-align:middle;border:1px solid #8AD3E9">
	<tr>
		<td class="labelName" width="25%"align="right" >
			<font color="red">*</font>农户姓名
		</td>
		<td class="labelName" width="2%" align="center">:</td>
		<td><input name="farmerName" type="text"/></td>
		<td class="labelName"  width="10%">
			<font color="red">*</font>农户身份证号
		</td>
		<td class="labelName" width="2%" align="center">:</td>
		<td>
			<input name="farmerIdNum" type="text"></td>
		<td width="12%" align="left">
			<input type="submit" value="" style="width:100px;height:25px;border:0;background:url(/bank/images/typein.png) no-repeat">
		</td>
	</tr>
</table>
</form>
</div>
<div>
<fieldset style="width:90%;margin:auto auto">
	 <legend style="width:310px;height:74px;background:url(/bank/images/tips.png) no-repeat"></legend>
	 <div style="padding:8px 5px 10px 35px">
	 	<p style="font-size:15px;font-family:黑体;font-weight:bold;color:darkgreen;margin-bottom:10px">农户基本信息录入功能:</p>
	 	<ol>
	 		<li>农户姓名及农户身份证号码必须填写，已用红色星号标明提醒。</li>
	 		<li>如果系统中存在该用户，则跳转至该用户基本信息的录入界面。</li>
	 		<li>如果系统中不存在该用户，则跳转值用户基本信息录入界面。</li>
	 	</ol>
	 
	 </div>
</fieldset>
</div>
<div>
<table>
	<tr>
		<td></td>
	</tr>
</table>
</div>
</body>
</html>