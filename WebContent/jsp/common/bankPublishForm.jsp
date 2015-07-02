<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<title>Insert title here</title>
<style type="text/css">
.bank-label{
width:8%;
display:inline-block;
font-size:1.5em;
}

</style>
</head>
<%
String messageId = request.getParameter("messageId");
String actionType = request.getParameter("actionType");
request.setAttribute("messageId", messageId);
request.setAttribute("actionType", actionType);
%>
<body>

<div id="form1" style="margin-left: 20px ;margin-right: 20px">
<form action="/bank/message/saveMessage.do" method="POST">
<input type="hidden" name="messageid" value="${message.messageid}"/>
<div class="queryPane">
<table width="100%">
<tr>
<td style="width:80%;font-size:1.6em;font-weight:bold;color:black"">
发布消息
</td>
<td style="width:10%;align:center">
<input type="submit" class="bank-btn" value="保存"/>
</td>
<td style="width:10%;align:center">
<input type="button" class="bank-btn" onclick="back()" value="返回"/>
</td>
</tr>
</table>
</div>
<c:if test="${empty username}">
	<c:set var="username" value="${recorder}"></c:set>
</c:if>
<c:if test="${empty publishdate}">
	<c:set var="publishdate" value="${currentTime}"></c:set>
</c:if>
<table style="width:100%" >
	<tr>
		<td >
		<span class="bank-label" >发布人:</span>
		<input name="username" class="mini-textbox" style="width:20%"  allowInput="false" value="${username}"/>
		<span class="bank-label">发布时间:</span>
		<input name="publishdate" class="mini-datepicker" style="width:20%" format="yyyy-MM-dd" value="${publishdate}"/>
		</td>
	</tr>
	<tr>
		<td>
		<span class="bank-label">标题:</span>
		<input name='title' class='mini-textbox' value="${message.title}" style="width:80%"/>

		</td>
	</tr>

	<tr>
		
		<td >
		<div style="width:100%;">
		<span class="bank-label" >内容:</span>
		<input name='content' class='mini-textarea' style='width:100%;margin-top:10px;height: 200px;' value="${message.content}"/>
		</div>
		</td>
		
	</tr>
</table>
</form>
</div>
<script type="text/javascript">
function back(){
	history.go(-1);
}

</script>
</body>
</html>