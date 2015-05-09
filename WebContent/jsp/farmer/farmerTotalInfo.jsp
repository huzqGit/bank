<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="dic" uri="http://gov.jian.bank/dictionary" %>  
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<style type="text/css">
     *{
            text-decoration:none
            
      }
      body{
      	line-height:8px;
      }
     .active{
         font-size: 15px;
         font-family: YouYuan;
         font-weight: bold;
     }
     .display{
     	display:block;
     }
     .hidden{
     	display:none;
     }
     .line{
        background-color: gray;
     }
     .contentPane{
     	background:linear-gradient(white,#6DC8E3,white);
		/* IE6 & IE7 */
		filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
		endColorstr = 'white' ); 
		/* IE8 */
		-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
		endColorstr = 'white' )"; 
     }
     .label0{background:#F5F7CF}
   	.labelName{
   		font-size:12px;
   		padding-left:12px;
   		font-weight:bold;
   		color:darkgreen
   	}
   	.labelValue{
   		font-size:14px;
   		color:black
   	}
	td{
	word-break:break-all;
	height:25px;
	}
	
 </style>
</head>
<body>
<table width="85%" style="margin:auto auto">
<tr><td></td><td></td></tr>
<tr>
<td colspan="2">
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:250px;height:74px;background:url(/bank/images/farmer.png)"> </legend>
<div>
<table border=0 cellspacing=0 width="100%" height="50px">
	<tr class="label0" style="background:#F5F7CF">
        <td class="labelName" style="width:12%">户主姓名 :</td>
        <td class="labelValue" style="width:38%"><p>${farmer.farmerName}</p></td>
        <td class="labelName" style="width:12%">户主身份证号:</td>
        <td class="labelValue" style="width:38%" ><p>${farmer.farmerIdnum}</p></td>
    </tr>
    <tr class="label1">
		<td class="labelName" style="width:12%">政治面貌:</td>
        <td class="labelValue" style="width:38%">
        <p>${dic:translate("politicstatus",farmer.politicStatus)}</p></td>
        <td class="labelName" style="width:12%">家庭人数:</td>
        <td class="labelValue" style="width:38%" ><p>${farmer.familyNum}</p></td>
    </tr>
    <tr class="label0" style="background:#F5F7CF">
        <td class="labelName" style="width:12%">联系电话:</td>
        <td class="labelValue" style="width:38%"><p>${farmer.phone}</p></td>
        <td class="labelName" style="width:12%">现住址:</td>
        <td class="labelValue" style="width:38%" ><p>${farmer.address}</p></td>
   </tr>
   <tr >
		<td class="labelName" style="width:12%">婚姻状况</td>
        <td class="labelValue" style="width:38%">
        <p>${dic:translate("marrystatus",farmer.marryStatus)}</p></td>
        <td class="labelName" style="width:12%">劳动力人数:</td>
        <td class="labelValue" style="width:38%" ><p>${farmer.laborNum}</p></td>
   </tr>
   <tr class="label0" style="background:#F5F7CF">
   		<td class="labelName" style="width:12%">邮政编码:</td>
    	<td class="labelValue" colspan="3" style="width:38%"><p>${farmer.postCode}</p> </td>
  </tr>
 <c:forEach items="${members}" var="member">
  <tr class="label1">
  		<td class="labelName" style="width:12%">家庭成员姓名:</td>
        <td class="labelValue" style="width:38%"><p>${member.name}</p></td>
        <td class="labelName" style="width:12%">与户主关系:</td>
        <td class="labelValue" style="width:38%" >
        <p>${dic:translate("relation",member.relation)}</p></td>
  </tr>
  <tr class="label0">
       <td class="labelName" style="width:12%">身份证号:</td>
       <td class="labelValue" style="width:38%"><p>${member.idNum}</p> </td>
       <td class="labelName" style="width:12%">文化程度:</td>
       <td class="labelValue" style="width:38%" ><p>${dic:translate("education",member.education)}</p></td>
  </tr>
  <tr class="label1">
  	  <td class="labelName" style="width:12%">婚姻状况:</td>
      <td class="labelValue" style="width:38%">
      <p>${dic:translate("marrystatus",member.marryStatus)}</p></td>
      <td class="labelName" style="width:12%">职业:</td>
      <td class="labelValue" style="width:38%" ><p>${member.occupation}</p></td>
  </tr>
  <tr class="label0">
  	 <td class="labelName" style="width:12%">职务:</td>
     <td class="labelValue" style="width:38%"><p>${member.job}</p> </td>
     <td class="labelName" style="width:12%">性别:</td>
     <td class="labelValue" style="width:38%" ><p>${dic:translate("sex",member.sex)}</p></td>
  </tr>
  <tr class="label1">
     <td class="labelName" style="width:12%">联系电话:</td>
     <td class="labelValue" colspan="3" style="width:38%"><p>${member.phone}</p></td>
 </tr>
 </c:forEach>
</table>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/house.png) no-repeat"> </legend>
<div class="fieldset-body">
<table border="0" cellpadding="0" cellspacing="0" width="100%" >
<c:forEach items="${houses}" var="house">
<tr class="label0">
	<td class="labelName" style="width:12%">房产性质:</td>
    <td class="labelValue" style="width:38%"> <p>${house.houseProperty}</p></td>
    <td class="labelName" style="width:12%">房屋类型:</td>
    <td class="labelValue" style="width:38%" >
    <p>${dic:translate("housetype",house.houseType)}</p></td>
</tr>
<tr class="label1">
	<td class="labelName" style="width:12%">房屋地址:</td>
    <td class="labelValue" style="width:38%"><p>${house.houseAddress}</p></td>
    <td class="labelName" style="width:12%">建筑面积:</td>
    <td class="labelValue" style="width:38%"><p>${house.buildArea}</p></td>
</tr>
<tr class="label0">
	<td class="labelName" style="width:12%">购建年份:</td>
    <td class="labelValue" style="width:38%"><p>${house.buildDate}</p></td>
    <td class="labelName" style="width:12%">购建价格:</td>
    <td class="labelValue" style="width:38%"><p>${house.buildPrice}</p></td>
</tr>
 <tr class="label1">
	<td class="labelName" style="width:12%">占地面积:</td>
    <td class="labelValue" style="width:38%"><p>${house.floorArea}</p></td>
    <td class="labelName" style="width:12%">当前评估价格:</td>
    <td class="labelValue" style="width:38%"><p>${house.assessPrice}</p></td>
</tr>
</c:forEach>
 <c:forEach items="${forests}" var="forest">
<tr class="label0">
	<td class="labelName" style="width:12%">林权证编号:</td>
    <td class="labelValue" style="width:38%"><p>${forest.cardNum}</p></td>
    <td class="labelName" style="width:12%">林权字号:</td>
    <td class="labelValue" style="width:38%" ><p>${forest.wordNum}</p></td>
</tr>
<tr class="label1">
	<td class="labelName" style="width:12%">林权使用人:</td>
    <td class="labelValue" style="width:38%"><p>${forest.user}</p></td>
    <td class="labelName" style="width:12%">林权使用种类:</td>
    <td class="labelValue" style="width:38%"><p>${forest.useType}</p></td>
</tr>
<tr class="label0">
	<td class="labelName" style="width:12%">面积(亩):</td>
    <td class="labelValue" style="width:38%"><p>${forest.area}</p></td>
    <td class="labelName" style="width:12%">蓄积量:</td>
    <td class="labelValue" style="width:38%"><p>${forest.storeNum}</p></td>
</tr>
<tr class="label1">
	<td class="labelName" style="width:12%">使用权期限:</td>
    <td class="labelValue" style="width:38%"><p>${forest.timeLimit}</p></td>
    <td class="labelName" style="width:12%">当前评估价格:</td>
    <td class="labelValue" style="width:38%"><p>${forest.assessPrice}</p></td>
</tr>
</c:forEach>
</table>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/balance.png) no-repeat"></legend>
<div class="fieldset-body">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr class="label0">
	<td class="labelName" style="width:20%">主要农作物年度净收入合计:</td>
    <td class="labelValue" style="width:25%"><p>${farmingIncome.farmingIncome}</p></td>
    <td class="labelName" style="width:25%"> 林、牧、副、渔业年度净收入合计:</td>
    <td class="labelValue" style="width:30%" ><p>${balance.avocationIncome}</p></td>
</tr>
<tr class="label1">
	<td class="labelName" style="width:12%">家庭工商业年度净收入合计:</td>
    <td class="labelValue" style="width:25%"><p>${balance.businessIncome}</p></td>
    <td class="labelName" style="width:12%">其他收入年度净收入合计::</td>
    <td class="labelValue" style="width:30%"><p>${balance.otherIncome}</p></td>
</tr>
<tr class="label0">
	<td class="labelName" style="width:12%">生产支出::</td>
    <td class="labelValue" style="width:25%"><p>${balance.productPay}</p></td>
    <td class="labelName" style="width:12%;word-break:break-all"> 生活支出::</td>
    <td class="labelValue" style="width:30%"><p>${balance.livingPay}</p></td>
</tr>
<tr class="label1">
	<td class="labelName" style="width:12%">医疗支出:</td>
    <td class="labelValue" style="width:25%"><p>${balance.medicalPay}</p></td>
	<td class="labelName" style="width:12%">教育支出:</td>
    <td class="labelValue" style="width:30%"><p>${balance.educatePay}</p></td>
</tr>   
<tr class="label0">
	<td class="labelName" style="width:12%">参保支出:</td>
    <td class="labelValue" style="width:25%"><p>${balance.insuredPay}</p></td>
    <td class="labelName" style="width:12%">其他支出:</td>
    <td class="labelValue" style="width:30%"><p>${balance.otherPay}</p></td>
</tr>
<tr class="label1">
	<td class="labelName" style="width:12%">家庭年度总收入合计:</td>
    <td class="labelValue" style="width:25%"><p>${balance.totalIncome}</p></td>
    <td class="labelName" style="width:12%;word-break:break-all">家庭年度支出总合计:</td>
    <td class="labelValue" style="width:30%"><p>${balance.totalPay}</p></td>
</tr>
<c:forEach items="${incomes}" var="income">
<tr class="label0">
	<td class="labelName" style="width:12%">收入来源:</td>
    <td class="labelValue" style="width:25%"><p>${income.incomeType}</p></td>
    <td class="labelName" style="width:12%;word-break:break-all">农作物或项目名称:</td>
    <td class="labelValue" style="width:30%"><p>${income.incomeName}</p></td>
</tr>
<tr class="label1">
	<td class="labelName" style="width:12%">净收入:</td>
    <td class="labelValue" colspan="3" style="width:25%"><p>${income.netIncome}</p></td>
</tr>
</c:forEach>
</table>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/compunish.png) no-repeat"></legend>
<div class="fieldset-body">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr class="label0">
	<td class="labelName" style="width:20%">人品综合评价:</td>
    <td class="labelValue" style="width:25%"><p>${evaluate.personality}</p></td>
    <td class="labelName" style="width:25%">家庭和睦情况:</td>
    <td class="labelValue" style="width:30%" ><p>${evaluate.harmonyStatus}</p></td>
</tr>
<tr class="label1">
	<td class="labelName" style="width:15%">敬老爱幼情况:</td>
    <td class="labelValue" style="width:25%"><p>${evaluate.respectStatus}</p></td>
    <td class="labelName" style="width:20%">邻里团结情况:</td>
    <td class="labelValue" style="width:30%"><p>${evaluate.neighborStatus}</p></td>
</tr>
<tr class="label0">
	<td class="labelName" style="width:15%">是否遵纪守法:</td>
    <td class="labelValue" style="width:25%">
    <p>${dic:translate("yesorno",evaluate.legalStatus)}</p>
    </td>
    <td class="labelName" style="width:20%;word-break:break-all"> 对公益事业关心程度:</td>
    <td class="labelValue" style="width:30%"><p>${evaluate.welfareStatus}</p></td>
</tr>
<tr class="label1">
	<td class="labelName" style="width:15%">是否诚实守信:</td>
    <td class="labelValue" style="width:25%">
    <p>${dic:translate("yesorno",evaluate.honestStatus)}</p>
    </td>
	<td class="labelName" style="width:20%">  其他:</td>
    <td class="labelValue" style="width:30%"><p>${evaluate.otherStatus}</p></td>
</tr>   
<c:forEach items="${compunishs}" var="compunish">
<tr class="label0">
	<td class="labelName" style="width:15%">表彰或处罚部门:</td>
    <td class="labelValue" style="width:25%"><p>${compunish.organ}</p></td>
    <td class="labelName" style="width:20%">受表彰或处罚时间:</td>
    <td class="labelValue" style="width:30%"><p>${compunish.occurTime}</p></td>
</tr>
<tr class="label0">
    <td class="labelName" style="width:15%">表彰或处罚内容:</td>
    <td class="labelValue" colspan="3" style="width:30%" ><p>${compunish.detail}</p></td>          
</tr>
</c:forEach>
</table>
</div>
</fieldset>
</td></tr>
</table>
</body>
</html>