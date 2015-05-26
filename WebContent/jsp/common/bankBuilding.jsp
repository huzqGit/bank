<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
margin:0;
padding:0;
}
body{
overflow-x:hidden
}
.topMenu{
 	width:100%;
 	margin:auto auto;
 	height:10%;
 	background-image:url(/bank/images/FaBu.png);
 	background-repeat:no-repeat;
    /* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
	endColorstr = 'white' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
	endColorstr = 'white' )"; 
 }
 ul{
 
 }
 li{
 border-bottom:2px solid green;
 float:left;
 width:14%;
 list-style-type:none;
 height:30px;
 background-image:url(/bank/images/tab.png);
 background-repeat:no-repeat
 }
</style>
</head>
<body>
<div class="topMenu">
<ul>
	<li>
		<a href="/bank/jsp/common/bankBuilding.jsp?form=basic">基本信息</a>
	</li>
	<li>
		<a href="/bank/jsp/common/bankBuilding.jsp?form=loan">贷款信息</a>
	</li>
	<li>
	收支信息
	</li>
	<li>
		<a href="/bank/jsp/common/bankBuilding.jsp?form=capital">资产信息</a>
	</li>
	<li>
		<a href="/bank/jsp/common/bankBuilding.jsp?form=insured">参保信息</a>
	</li>
	<li>
		<a href="/bank/jsp/common/bankBuilding.jsp?form=compunish">受表彰或处罚信息</a>
	</li>
	<li>
		<a href="/bank/jsp/common/bankBuilding.jsp?form=other">其他信息</a>
	</li>
</ul>
</div>
<div style="width:100%;margin-bottom:0px;padding-bottom:0px">
<c:choose>
	<c:when test="${param.form == 'basic'}">
		<jsp:include page="/jsp/farmer/farmerBasicInfoForm.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.form == 'loan'}">
		<jsp:include page="/jsp/farmer/farmerLoanForm.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.form == 'balance'}">
		<jsp:include page="/jsp/farmer/farmerBalanceForm.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.form == 'capital'}">
		<jsp:include page="/jsp/farmer/farmerChanQuanForm.jsp"></jsp:include>
	</c:when>
		<c:when test="${param.form == 'insured'}">
		<jsp:include page="/jsp/farmer/farmerInsuredForm.jsp"></jsp:include>
	</c:when>
	<c:when test="${param.form == 'compunish'}">
		<jsp:include page="/jsp/farmer/farmerCompunishForm.jsp"></jsp:include>
	</c:when>
		<c:when test="${param.form == 'other'}">
		<jsp:include page="/jsp/farmer/farmerQiTaForm.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="/jsp/farmer/farmerBasicInfoForm.jsp"></jsp:include>
	</c:otherwise>

</c:choose>

</div>
</body>
</html>