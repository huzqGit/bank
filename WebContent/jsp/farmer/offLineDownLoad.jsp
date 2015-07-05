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
		#scanFile{
			width:100px;
			height:25px;
			border:0;
			background:url(/bank/images/scanFile.png) no-repeat;
		}
		#uploadFile{
			width:100px;
			height:25px;
			border:0;
			background:url(/bank/images/uploadFile.png) no-repeat;
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
.table_m{width:90%;margin:auto auto}
.table_m table{width:100%;border-bottom:1px dotted #cc9999}
.table_m table td{height:30px;line-height:30px;border-top:1px dotted #cc9999}
</style>
</head>
<body>

<div>
<fieldset style="width:90%;margin-top:50px;margin-left:auto;margin-right:auto">
<legend style="width:310px;height:74px;background:url(/bank/images/tips.png) no-repeat"></legend>
<div class="table_m">
	<table width="90%">
	<c:forEach items="${applys}" var="apply" varStatus="status">
	<tr>
		<td align="center" width="50%">${apply.applyName}</td>
		<td align="center" width="50%"><a href="/bank/farmer/offlineDownload.do?farmerIds=${apply.applyInfo}">下载</a></td>
	</tr>	
	</c:forEach>
</table>
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