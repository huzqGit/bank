<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<div style="width:90%;margin:auto auto;text-align:center">
	<h1>农户支出统计表</h1>
</div>
<div style="float:right;margin-right:300px">
单位:<font color="red">(万元)</font>
</div>
<table border="1px"  cellspacing="0" cellpadding="0" width="90%" style="margin:auto auto">
	<tr>
		<th>
		乡镇名称
		</th>
		<th>
		生产支出
		</th>
		<th>
		生活之处
		</th>
		<th>
		医疗支出
		</th>
		<th>
		教育支出
		</th>
		<th>
		参保支出
		</th>
		<th>
		合计
		</th>
	</tr>
	<c:forEach items="${payments}" var="temp">
		<tr>
		 <td align="center">
		  <c:forEach var="payment" items="${temp}"> 
			<c:if test="${payment.key =='VILLAGE'}">
				${payment.value}
			</c:if>
			</c:forEach>
		</td>
			<td align="center">
			<c:forEach var="payment" items="${temp}"> 
				<c:if test="${payment.key =='PRODUCTPAY'}">
				${payment.value}
			</c:if>
			</c:forEach>
			</td>
			<td align="center">
			<c:forEach var="payment" items="${temp}"> 
				<c:if test="${payment.key =='LIVINGPAY'}">
				${payment.value}
			</c:if>
			</c:forEach>
			</td>
			<td align="center">
			<c:forEach var="payment" items="${temp}"> 
				<c:if test="${payment.key =='MEDICALPAY'}">
				${payment.value}
			</c:if>
			</c:forEach>
			</td>
			<td align="center">
			<c:forEach var="payment" items="${temp}"> 
				<c:if test="${payment.key =='EDUCATEPAY'}">
				${payment.value}
			</c:if>
			</c:forEach>
			</td>
			<td align="center">
			<c:forEach var="payment" items="${temp}"> 
				<c:if test="${payment.key =='INSUREDPAY'}">
				${payment.value}
			</c:if>
			</c:forEach>
			</td>
			<td align="center">
			<c:forEach var="payment" items="${temp}"> 
				<c:if test="${payment.key =='TOTALPAY'}">
				${payment.value}
			</c:if>
			</c:forEach>
			</td>
			</tr>
		
	</c:forEach>
</table>
</body>
</html>