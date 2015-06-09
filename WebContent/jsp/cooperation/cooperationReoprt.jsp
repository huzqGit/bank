<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bank.common.util.DateUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农民专业合作经济组织基本概况</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js"
	type="text/javascript"></script>
</head>
<style>
td{
	border:1px solid #ccc; 
	margin:0;
	padding:0;
}
</style>
<body>
	<div style='padding-left: 0; padding-right: 0'>
		<div align="center" style="font-size:20px;"><b>农民专业合作经济组织信用报告</b></div>
		<div style='margin-left: auto; margin-right: auto; width: 200px;'>报告时间： <%=DateUtil.format(new java.util.Date(),"yyyy年MM月dd日") %></div>
		<div style='margin-left: auto; margin-right: auto; width: 130px;'>一、基本状况</div>
	</div>
	<div id="form1" style="width: 90%; margin: auto auto">
		<form action="#" method="POST">
			<tr><td>
			<table width="100%" style="boder-style:solid"  border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td style="width: 20%"><label>合作社名称:</label></td>
					<td style="width: 80%"><div id="cooperationName"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>注册地址:</label></td>
					<td style="width: 80%"><div id="registerAddress"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>通信地址:</label></td>
					<td style="width: 80%"><div id="mailAddress"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>注册时间:</label></td>
					<td style="width: 80%"><div id="registerDate"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>税务登记号:</label></td>
					<td style="width: 80%"><div id="taxCode"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>组织机构编码:</label></td>
					<td style="width: 80%"><div id="orgaCode"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>注册资金:</label></td>
					<td style="width: 80%"><div id="registerCapital"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>实收资金:</label></td>
					<td style="width: 80%"><div id="realCapital"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>法定代表人:</label></td>
					<td style="width: 80%"><div id="legalPerson"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>身份证号:</label></td>
					<td style="width: 80%"><div id="idNum"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>联系电话号码:</label></td>
					<td style="width: 80%"><div id="phone"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>社员人数:</label></td>
					<td style="width: 80%"><div id="members"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>经营范围:</label></td>
					<td style="width: 80%"><div id="businesScope"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>经营场地面积:</label></td>
					<td style="width: 80%"><div id="businessArea"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>带动农户（户）:</label></td>
					<td style="width: 80%"><div id="farmers"></div></td>
				</tr>
				<tr>
					<td style="width: 20%"><label>联接基地（亩）:</label></td>
					<td style="width: 80%"><div id="connectionBase"></div></td>
				</tr>
			</table>
			</td></tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
	mini.parse();
	var form = new mini.Form("#form1");
	//查询表单数据
	$(document).ready(function() {
		$.ajax({
			url : "${pageContext.request.contextPath}/economy/findCooperation.do",
			type : "post",
			data : {cooperationId : "${cooperationId}"},
			success : function(text) {
				var data = mini.decode(text); //反序列化成对象
				if (data.cooperationId != null) {
					$("#cooperationName").html(data.cooperationName);
					$("#registerAddress").html(data.registerAddress);
					$("#mailAddress").html(data.mailAddress);
					$("#registerDate").html(mini.formatDate (data.registerDate,'yyyy-MM-dd'));
					$("#taxCode").html(data.taxCode);
					$("#orgaCode").html(data.orgaCode);
					$("#registerCapital").html(data.registerCapital);
					$("#realCapital").html(data.realCapital);
					$("#legalPerson").html(data.legalPerson);
					$("#idNum").html(data.idNum);
					$("#phone").html(data.phone);
					$("#members").html(data.members);
					$("#businesScope").html(data.businesScope);
					$("#businessArea").html(data.businessArea);
					$("#farmers").html(data.farmers);
					$("#connectionBase").html(data.connectionBase);
				}
			},
			error : function(text, arg2) {
			}
		});
	});

	function back() {
		history.go(-1);
	}
</script>
</html>