<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
*{
margin:0;
padding:0;
}
 .topMenu{
 	width:100%;
 	margin:auto auto;
 	height:90px;
 	border:1px solid #8AD3E9;
 	background-image:url(/bank/images/FaBu.png);
 	background-repeat:no-repeat;
    /* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
	endColorstr = 'white' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
	endColorstr = 'white' )"; 
    }

</style>
</head>
<body>
<div class="topMenu">
<table width="100%">
<tr>
<td width="70%">
	<fieldset style="width:100%;margin-top:10px;margin-left:auto;margin-right:auto;border:0">
	<legend style="width:100%;height:74px;background:url(/bank/images/msgtips.png) no-repeat"></legend>
	</fieldset>
</td>
<td width="30%">
<form action="/bank/jsp/common/bankPublishForm.jsp" method="GET">
	<input type="submit" value=""  
		style="width:65px;height:30px;line-height:30px;border:0;
		background:url(/bank/images/publish.png) no-repeat"/>
</form>	
</td>
</tr>
</table>
</div>
<div style="width:90%;margin:auto auto">
	<table width="100%"  cellspacing="0" cellpadding="0"> 
		<tr>
			<td >发布人</td>
			<td>发布时间</td>
			<td>发布内容</td>
		</tr>
		
	</table>

</div>
</body>
</html>