<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<title>Insert title here</title>
<style type="text/css">
table{
color:#333333;
border-width: 1px;
border-color: black;
border-collapse: collapse;
}
</style>
</head>
<body>
<div style="width:90%;margin:auto auto;text-align:center;">
	<h1>农户总体情况统计</h1>
</div>
<div style="float:right;margin-right:300px" >
单位:<font color="red">(户)</font>
</div>
<table width="90%"border="1" cellspacing="0" cellpadding="0" style="margin:auto auto">

	<tr>
			<th>
			乡镇名称
			</th>
			<th>
			系统农户总数
			</th>
			<th>
			有贷款记录农户数
			</th>
			<th>
			有贷款余额农户数
			</th>
			<th>
			有不良贷款农户数
			</th>
	</tr>
	<c:forEach items="${farmerNums}" var="temp">
		<tr>
		 <td align="center">
		  <c:forEach var="farmerNum" items="${temp}"> 
			<c:if test="${farmerNum.key =='village'}">
				${farmerNum.value}
			</c:if>
			</c:forEach>
		</td>
			<td align="center">
			<c:forEach var="farmerNum" items="${temp}"> 
				<c:if test="${farmerNum.key =='totalNum'}">
				${farmerNum.value}
			</c:if>
			</c:forEach>
			</td>
			<td align="center">
			<c:forEach var="farmerNum" items="${temp}"> 
				<c:if test="${farmerNum.key =='loanNum'}">
				${farmerNum.value}
			</c:if>
			</c:forEach>
			</td>
			<td align="center">
			<c:forEach var="farmerNum" items="${temp}"> 
				<c:if test="${farmerNum.key =='balanceNum'}">
				${farmerNum.value}
			</c:if>
			</c:forEach>
			</td>
			<td align="center">
			<c:forEach var="farmerNum" items="${temp}"> 
				<c:if test="${farmerNum.key =='badloanNum'}">
				${farmerNum.value}
			</c:if>
			</c:forEach>
			</td>
			</tr>
		
	</c:forEach>
	</table>

</body>
</html>