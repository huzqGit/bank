<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="dic" uri="http://gov.jian.bank/dictionary" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户信用报告</title>
<style type="text/css">
td{text-align:center}
</style>
</head>
<body>
<table width="90%" cellpadding="0" cellspacing="0" style="margin-top:20px;margin-left:auto;margin-right:auto">
<tr>
	<td align="center" style="color:red;font-size:25px;font-weight:bold">农户信用报告</td>
</tr>
<tr>
	<td align="center"  style="color:red;font-size:18px;font-weight:bold">报告时间：XXXX年—XX月－XX日</td>
</tr>
<tr>
	<td align="center">一、基本信息</td>
</tr>
<tr>
	<td>
		<table width="100%" border=1 cellpadding="0" cellspacing="0" >
			<tr>
			<td>家庭成员</td>
			<td>姓名</td>
			<td>性别</td>
			<td>身份证号码</td>
			<td>婚姻状况</td>
			<td>文化程度</td>
			<td>联系电话</td>
			<td>居住地址</td>
			<td>数据录入单位</td>
			</tr>
			<tr>
			<td>户主</td>
			<td>${farmer.farmerName}</td>
			<td>${dic:translate("sex",farmer.sex)}</td>
			<td>${farmer.farmerIdnum}</td>
			<td>${dic:translate("marrystatus",farmer.marryStatus)}</td>
			<td>${dic:translate("education",farmer.education)}</td>
			<td>${farmer.phone}</td>
			<td>${farmer.address}</td>
			<td></td>
			</tr>
			<c:forEach items="${members}" var="member" varStatus="status">
			<tr>
			<td>${dic:translate("relation",member.relation)}</td>
			<td>${member.name}</td>
			<td>${dic:translate("sex",member.sex)}</td>
			<td>${member.idNum}</td>
			<td>${dic:translate("marrystatus",member.marryStatus)}</td>
			<td>${dic:translate("education",member.education)}</td>
			<td>${member.phone}</td>
			<td></td>
			<td></td>
			</tr>
			</c:forEach>
		</table>
	</td>
</tr>
<tr>
	<td>二、家庭收支信息</td>
</tr>
<tr>
<td>
	<table width="100%" border=1 cellpadding="0" cellspacing="0">
		<tr>
			<td>年度</td>
			<td>总收入</td>
			<td>总支出</td>
			<td>数据录入单位</td>
		</tr>
		<tr>
			<td>${balance.year}</td>
			<td>${balance.totalIncome}</td>
			<td>${balance.totalPay}</td>
			<td></td>
		</tr>
	</table>
</td>
</tr>
<tr>
	<td>三、资产类信息</td>
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
			<td>数据录入单位</td>
			</tr>
			<c:forEach items="${houses}" var="house" varStatus="status">
				<tr>
				<td>${status.index+1}</td>
				<td>${house.houseProperty}</td>
				<td>${house.houseType}</td>
				<td>${house.houseAddress}</td>
				<td>${house.buildDate}</td>
				<td>${house.buildArea}</td>
				<td></td>
				</tr>
			</c:forEach>
			<tr>
			<td>编号</td>
			<td>种养植品种</td>
			<td>占地面积</td>
			<td>年产量</td>
			<td>年平均产值</td>
			<td>当前评估价格</td>
			<td>数据录入单位</td>
			</tr>
			<c:forEach items="${breeds}" var="breed" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${breed.variety}</td>
				<td>${breed.floorArea}</td>
				<td>${breed.output}</td>
				<td>${breed.outputValue}</td>
				<td>${breed.assessPrice}</td>
				<td></td>
			</tr>
			</c:forEach>
			<tr>
			<td>编号</td>
			<td>设备名称</td>
			<td>设备型号</td>
			<td>购进时间</td>
			<td>购进价格</td>
			<td>当前评估价格</td>
			<td>数据录入单位</td>
			</tr>
			<c:forEach items="${devices}" var="device" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${device.name}</td>
				<td>${device.brand}</td>
				<td>${device.buyingDate}</td>
				<td>${device.buyingPrice}</td>
				<td>${device.assessPrice}</td>
				<td></td>
			</tr>
			</c:forEach>
		</table>
	</td>
</tr>
</table>
</body>
</html>