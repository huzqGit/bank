<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>   
<%@ page import="java.text.SimpleDateFormat"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="dic" uri="http://gov.jian.bank/dictionary" %>
<%@taglib prefix="dt" uri="http://gov.jian.bank/dateformat" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户信用报告</title>
<style type="text/css">
td{text-align:center}
.table_m{width:100%;border-bottom:1px border black}
.table_m td{height:30px;line-height:30px;border-top:1px border black}
.report_title{
font-weight:bold;
font-size:16px;
height:30px;
line-height:25px;
}
</style>
</head>
<body>
<%
	Date date = new Date();
	String year =new SimpleDateFormat("yyyy").format(date);
	String month =new SimpleDateFormat("MM").format(date);
	String day =new SimpleDateFormat("dd").format(date);
%>
<table width="90%" cellpadding="0" cellspacing="0" style="margin-top:20px;margin-left:auto;margin-right:auto">
<tr>
	<td align="center" style="color:red;font-size:25px;font-weight:bold">农户信用报告</td>
</tr>
<tr>
	<td align="center"  style="color:red;font-size:18px;font-weight:bold">报告时间：<%=year%>年—<%=month%>月－<%=day%>日</td>
</tr>
<tr>
	<td align="center" class="report_title">一、基本信息</td>
</tr>
<tr><td>
<table class="table_m" width="100%" border=1 cellpadding="0" cellspacing="0" >
	<tr>
		<td width="10%">家庭成员</td>
		<td width="5%">姓名</td>
		<td width="5%">性别</td>
		<td width="10%">身份证号码</td>
		<td width="10%">婚姻状况</td>
		<td width="10%">文化程度</td>
		<td width="10%">联系电话</td>
		<td width="40%">居住地址</td>
	</tr>
	<c:forEach items="${farmers}" var="farmer" varStatus="status">
	<tr>
		<td width="10%">户主</td>
		<td width="8%">${farmer.farmername}</td>
		<td width="5%">${dic:translate("sex",farmer.sex)}</td>
		<td width="10%">${farmer.farmeridnum}</td>
		<td width="10%">${dic:translate("marrystatus",farmer.marrystatus)}</td>
		<td width="10%">${dic:translate("education",farmer.education)}</td>
		<td width="10%">${farmer.phone}</td>
		<td width="32%">${farmer.address}</td>
	</tr>
	</c:forEach>
	<c:forEach items="${members}" var="member" varStatus="status">
	<tr>
		<td width="10%">${dic:translate("relation",member.relation)}</td>
		<td width="8%">${member.name}</td>
		<td width="5%">${dic:translate("sex",member.sex)}</td>
		<td width="10%">${member.idnum}</td>
		<td width="10%">${dic:translate("marrystatus",member.marrystatus)}</td>
		<td width="10%">${dic:translate("education",member.education)}</td>
		<td width="10%">${member.phone}</td>
		<td width="32%">${member.address}</td>
	</tr>
	</c:forEach>
</table>
</td></tr>
<tr>
	<td class="report_title">二、家庭收支信息</td>
</tr>
<tr>
<td>
	<table width="100%" border=1 cellpadding="0" cellspacing="0">
		<tr>
			<td>年度</td>
			<td>总收入</td>
			<td>总支出</td>
		</tr>
		<c:forEach items="${balances}" var="balance" varStatus="status">
		<tr>
			<td>${balance.year}</td>
			<td>${balance.totalincome}</td>
			<td>${balance.totalpay}</td>
		</tr>
		
		</c:forEach>
		
	</table>
</td>
</tr>
<tr>
	<td class="report_title">三、资产类信息</td>
</tr>
<tr>
	<td>
		<table width="100%" border=1 cellpadding="0" cellspacing="0">
			<tr>
			<td>编号</td>
			<td>房屋性质</td>
			<td>房屋类型</td>
			<td>房屋地址</td>
			<td>构建年份</td>
			<td>建筑面积</td>
			</tr>
			<c:forEach items="${houses}" var="house" varStatus="status">
				<tr>
				<td>${status.index+1}</td>
				<td>${house.houseproperty}</td>
				<td>${house.housetype}</td>
				<td>${house.houseaddress}</td>
				<td>${house.builddate}</td>
				<td>${house.buildarea}</td>
				</tr>
			</c:forEach>
			<tr>
			<td>编号</td>
			<td>种养植品种</td>
			<td>占地面积</td>
			<td>年产量</td>
			<td>年平均产值</td>
			<td>当前评估价格</td>
			</tr>
			<c:forEach items="${breeds}" var="breed" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${breed.variety}</td>
				<td>${breed.floorarea}</td>
				<td>${breed.output}</td>
				<td>${breed.outputvalue}</td>
				<td>${breed.assessprice}</td>
			</tr>
			</c:forEach>
			<tr>
			<td>编号</td>
			<td>使用权种类</td>
			<td colspan="2">使用权面积</td>
			<td>年产量</td>
			<td colspan="2">当前评估价格</td>
			</tr>
			<tr height="20px">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
			<td>编号</td>
			<td>设备名称</td>
			<td>设备型号</td>
			<td>购进时间</td>
			<td>购进价格</td>
			<td>当前评估价格</td>
			</tr>
			<c:forEach items="${devices}" var="device" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${device.name}</td>
				<td>${device.brand}</td>
				<td>${device.buyingdate}</td>
				<td>${device.buyingprice}</td>
				<td>${device.assessprice}</td>
			</tr>
			</c:forEach>
		</table>
	</td>
</tr>
<tr>
<td class="report_title">四、贷款担保信息</td>
</tr>
<tr>
<td>
<table width="100%" border=1 cellpadding="0" cellspacing="0">
	<tr>
		<td>编号</td>
		<td>贷款金融机构</td>
		<td>业务类别</td>
		<td>贷款用途</td>
		<td>贷款方式</td>
		<td>贷款发放日期</td>
		<td>贷款到期日</td>
	</tr>
	<c:forEach items="${loans}" var="loan" varStatus="status">
	<tr>
		<td>${status.index+1}</td>
		<td>${loan.organname}</td>
		<td>${loan.businesstype}</td>
		<td>${loan.loanuse}</td>
		<td></td>
		<td>${loan.loandate}</td>
		<td>${loan.limitdate}</td>
	</tr>
	</c:forEach>
	<tr>
		<td>编号</td>
		<td>贷款余额</td>
		<td>担保方式</td>
		<td colspan="2">民间借入金额</td>
		<td colspan="2">民间借出金额</td>
	</tr>
	<c:forEach items="${loans}" var="loan" varStatus="status">
		<tr>
		<td>${status.index+1}</td>
		<td>${loan.amount}</td>
		<td>${loan.guaranteetype}</td>
		<td colspan="2"></td>
		<td colspan="2"></td>
		</tr>
	</c:forEach>
	<tr>
		<td>编号</td>
		<td>被担保人姓名</td>
		<td>被担保人身份证号码</td>
		<td>未结清担保金额</td>
		<td>未结清担保到期日</td>
		<td colspan="2">对他人担保金</td>
	</tr>
		<c:forEach items="${loans}" var="loan" varStatus="status">
		<tr>
		<td>${status.index+1}</td>
		<td>${loan.clientname}</td>
		<td>${loan.idnum}</td>
		<td></td>
		<td></td>
		<td colspan="2"></td>
		</tr>
	</c:forEach>
</table>
</td>
</tr>
<tr>
<td class="report_title">五、表彰与处罚信息</td>
</tr>
<tr>
<td>
<table width="100%" border=1 cellpadding="0" cellspacing="0">
			<tr>
				<td>编号</td>
				<td colspan="2">表彰或处罚部门</td>
				<td colspan="2">表彰或处罚内容</td>
			</tr>
			<c:forEach items="${compunishs}" var="compunish" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td colspan="2">${compunish.organ}</td>
				<td colspan="2">${compunish.detail}</td>
			</tr>
			</c:forEach>
</table>
</td>
</tr>
<tr>
<td class="report_title">六、参保信息</td>
</tr>
<tr>
<td>
	<table width="100%" border=1 cellpadding="0" cellspacing="0">
		<tr>
			<td>编号</td>
<td>参加保险种类</td>
<td>保险金额</td>
<td>参保时间</td>
<td>参保到期日</td>
		
		</tr>
	<c:forEach items="${insureds}" var="insured" varStatus="status">
	<tr>
		<td>${status.index+1 }</td>
		<td>${dic:translate("insure",insured.type)}</td>
		<td>${insured.amount}</td>
		<td>${dt:format(insured.insuretime,"yyyy-MM-dd")}</td>
		<td>${dt:format(insured.limittime,"yyyy-MM-dd")}</td>
</tr>
	
	</c:forEach>
	</table>
</td>

</tr>
<tr>
<td class="report_title">七、其他重要信息</td>
</tr>

<tr>
<td>
	<table width="100%" border=1 cellpadding="0" cellspacing="0">
	<tr>
	<td>家庭和睦</td>
	<td>敬老爱幼</td>
	<td>邻里团结</td>
	<td>遵纪守法</td>
	<td>关心公益事业</td>
	<td>诚实守信</td>
</tr>
	<tr>
	<td>${dic:translate("evaluate",evaluate.harmonystatus)}</td>
	<td>${dic:translate("evaluate",evaluate.respectstatus)}</td>
	<td>${dic:translate("evaluate",evaluate.respectstatus)}</td>
	<td>${dic:translate("evaluate",evaluate.legalstatus)}</td>
	<td>${dic:translate("evaluate",evaluate.welfarestatus)}</td>
	<td>${dic:translate("evaluate",evaluate.honeststatus)}</td>
		</tr>
	
	</table>
</td>

</tr>
<tr>
<td class="report_title">八、农户评价信息</td>
</tr>
<tr>
<td>	
	<table width="100%" border=1 cellpadding="0" cellspacing="0">
		<tr>
	<td>信用户评定时间</td>
	<td>信用户级别</td>
	<td>信用户评定部门</td>
	<td>有效期限</td>
	<td>数据录入单位</td>
		</tr>
		
	</table>

</td>


</tr>
</table>
</body>
</html>