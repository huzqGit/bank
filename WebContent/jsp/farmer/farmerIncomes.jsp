<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width:90%;margin:auto auto;text-align:center">
	<h1>农户收入统计表</h1>
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
		家庭农业收入
		</th>
		<th>
		家庭林牧副渔收入
		</th>
		<th>
		家庭工商业收入
		</th>
		<th>
		外出务工
		</th>
		<th>
		其他收入
		</th>
		<th>
		合计
		</th>
	</tr>
	<c:forEach items="${incomes}" var="temp">
	
		<tr>
		 <td align="center">
		  <c:forEach var="income" items="${temp}"> 
			<c:if test="${income.key =='VILLAGE'}">
				${income.value}
			</c:if>
			</c:forEach>
		</td>
		 <td align="center">
		  <c:forEach var="income" items="${temp}"> 
			<c:if test="${income.key =='FARMINGINCOME'}">
				${income.value}
			</c:if>
			</c:forEach>
		</td>
			<td align="center">
			<c:forEach var="income" items="${temp}"> 
				<c:if test="${income.key =='AVOCATIONINCOME'}">
				${income.value}
			</c:if>
			</c:forEach>
			</td>
			<td align="center">
			<c:forEach var="income" items="${temp}"> 
				<c:if test="${income.key =='BUSINESSINCOME'}">
				${income.value}
			</c:if>
			</c:forEach>
			</td>
			<td align="center">
			<c:forEach var="income" items="${temp}"> 
				<c:if test="${income.key =='WORKINCOME'}">
				${income.value}
			</c:if>
			</c:forEach>
			</td>
			<td align="center">
			<c:forEach var="income" items="${temp}"> 
				<c:if test="${income.key =='OTHERINCOME'}">
				${income.value}
			</c:if>
			</c:forEach>
			</td>
			<td align="center">
			<c:forEach var="income" items="${temp}"> 
				<c:if test="${income.key =='TOTALINCOME'}">
				${income.value}
			</c:if>
			</c:forEach>
			</td>
			</tr>
		
	</c:forEach>
</table>
</body>
</html>