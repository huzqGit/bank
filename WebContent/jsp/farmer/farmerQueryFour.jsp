<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<title>信用报告查询</title>
<style type="text/css">
*{margin:0;padding:0}
body{
line-height:10px;
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
<div class="queryPane" style="padding-top:10px;width:100%;height:80px">
<form action="/bank/farmer/loadFarmerFour.do" method="POST">
<table width="100%" height="60px" style="vertical-align:middle;border:1px solid #8AD3E9">
	<tr>
		<td class="labelName" width="30%"align="right" >农户姓名:&nbsp;&nbsp;&nbsp; <input type="text" name="farmerName"/></td>
		<td width="5%" ></td>
		<td class="labelName"  width="20%">农户身份证号:&nbsp;&nbsp;&nbsp;<input type="text" name="farmerIdNum"></td>
		<td width="1%"></td>
		<td width="20%" align="left">
			<input type="submit" value="" style="width:100px;height:25px;border:0;background:url(/bank/images/query.png) no-repeat">
		</td>
	</tr>
</table>
</form>
</div>
<div>
<fieldset style="width:90%;margin:auto auto">
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
</body>
</html>