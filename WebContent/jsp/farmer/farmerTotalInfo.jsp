<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="dic" uri="http://gov.jian.bank/dictionary" %> 
<%@taglib prefix="dt" uri="http://gov.jian.bank/dateformat" %>   
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="../common/CurrentTime.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<style type="text/css">
 *{text-decoration:none;}
      body{
      	line-height:100%;
      	font-size:12pt;
      	font-family:"仿宋_GB2312"
      }
      .test{
      table-layout:fixed;
      word-break:break-all;
      word-wrap:break-word
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
     ul{width:100%;list-style-type:none;clear:both}
     ul li{float:left;line-height:20px};
     .label1{list-style-type:none;width:100%}
   	.labelName{
   		padding-left:12px;
   		width:15%;
   	}
   	.labelValue{
   		width:32%
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
<div style="width:100%">
	<ul class="label0">
        <li class="labelName" ><p>户主姓名:</p></li>
        <li class="labelValue" ><p>${farmer.farmerName}</p></li>
        <li class="labelName" ><p>户主身份证号:</p></li>
        <li class="labelValue" ><p>${farmer.farmerIdnum}</p></li>
    </ul>
    <ul class="label1">
		<li class="labelName" ><p>政治面貌:</p></li>
        <li class="labelValue" >
        	<p>${dic:translate("politicstatus",farmer.politicStatus)}</p>
        </li>
        <li class="labelName" ><p>家庭人数:</p></li>
        <li class="labelValue" ><p>${farmer.familyNum}</p></li>
    </ul>
    <ul class="label0" >
        <li class="labelName"><p>联系电话:</p></li>
        <li class="labelValue"><p>${farmer.phone}</p></li>
        <li class="labelName"><p>现住址:</p></li>
        <li class="labelValue"><p>${farmer.address}</p></li>
   </ul>
   <ul class="label1" >
		<li class="labelName"><p>婚姻状况</p></li>
        <li class="labelValue"><p>${dic:translate("marrystatus",farmer.marryStatus)}</p></li>
        <li class="labelName"><p>劳动力人数:</p></li>
        <li class="labelValue"><p>${farmer.laborNum}</p></li>
   </ul>
   <ul class="label0" >
   		<li class="labelName"><p>邮政编码:</p></li>
    	<li class="labelValue"><p>${farmer.postCode}</p> </li>
  </ul>
 <c:forEach items="${members}" var="member">
  <ul class="label1">
  		<li class="labelName"><p>家庭成员姓名:</p></li>
        <li class="labelValue"><p>${member.name}</p></li>
        <li class="labelName"><p>与户主关系:</p></li>
        <li class="labelValue"><p>${dic:translate("relation",member.relation)}</p></li>
  </ul>
  <ul class="label0">
       <li class="labelName"><p>身份证号:</p></li>
       <li class="labelValue"><p>${member.idNum}</p> </li>
       <li class="labelName"><p>文化程度:</p></li>
       <li class="labelValue"><p>${dic:translate("education",member.education)}</p></li>
  </ul>
  <ul class="label1">
  	  <li class="labelName"><p>婚姻状况:</p></li>
      <li class="labelValue"><p>${dic:translate("marrystatus",member.marryStatus)}</p></li>
      <li class="labelName"><p>职业:</p></li>
      <li class="labelValue"><p>${member.occupation}</p></li>
  </ul>
  <ul class="label0">
  	 <li class="labelName"><p>职务:</p></li>
     <li class="labelValue"><p>${member.job}</p> </li>
     <li class="labelName"><p>性别:</p></li>
     <li class="labelValue"><p>${dic:translate("sex",member.sex)}</p></li>
  </ul>
  <ul class="label1">
     <li class="labelName"><p>联系电话:</p></li>
     <li class="labelValue"><p>${member.phone}</p></li>
 </ul>
 </c:forEach>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:260px;height:74px;background:url(/bank/images/unbalance.png) no-repeat"> </legend>
<div class="fieldset-body">
<c:forEach items="${unbalances}" var="unbalance" varStatus="stauts">
<ul class="label0">
	<li class="labelName">
		<p>贷款金融机构</p>
	</li>
	<li class="labelValue">
		<p>${unbalance.organName}</p>	
	</li>
	<li class="labelName">
		<p>业务类别</p>
	</li>
	<li class="labelValue">
		<p>${unbalance.businessType}</p>	
	</li>
</ul>
<ul class="label1">
	<li class="labelName">
		<p>贷款方式</p>
	</li>
	<li class="labelValue">
		<p>${unbalance.provideType}</p>	
	</li>
	<li class="labelName">
		<p>贷款余额</p>
	</li>
	<li class="labelValue">
		<p>${unbalance.balance}</p>	
	</li>
</ul>
<ul class="label1">
	<li class="labelName">
		<p>贷款发放时间</p>
	</li>
	<li class="labelValue">
		<p>${unbalance.loanDate}</p>	
	</li>
	<li class="labelName">
		<p>贷款到期时间</p>
	</li>
	<li class="labelValue">
		<p>${unbalance.limitDate}</p>	
	</li>
</ul>
</c:forEach>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:260px;height:74px;background:url(/bank/images/badbalance.png) no-repeat"> </legend>
<div class="fieldset-body">
<c:forEach items="${badbalances}" var="badbalance" varStatus="stauts">
<ul class="label0">
	<li class="labelName">
		<p>贷款金融机构</p>
	</li>
	<li class="labelValue">
		<p>${badbalance.organName}</p>	
	</li>
	<li class="labelName">
		<p>不良贷款余额</p>
	</li>
	<li class="labelValue">
		<p>${badbalance.balance}</p>	
	</li>
</ul>
<ul class="label1">
	<li class="labelName">
		<p>不良贷款偿还日期</p>
	</li>
	<li class="labelValue">
		<p>${badbalance.limitDate}</p>	
	</li>
</ul>
</c:forEach>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/house.png) no-repeat"> </legend>
<div class="fieldset-body">
<c:forEach items="${houses}" var="house">
<ul class="label0">
	<li class="labelName"><p>房产性质:</p></li>
    <li class="labelValue"> <p>${dic:translate("houseproperties",house.houseProperty)}</p></li>
    <li class="labelName"><p>房屋类型:</p></li>
    <li class="labelValue"><p>${dic:translate("housetype",house.houseType)}</p></li>
</ul>
<ul class="label1">
	<li class="labelName"><p>房屋地址:</p></li>
    <li class="labelValue"><p>${house.houseAddress}</p></li>
    <li class="labelName"><p>建筑面积:</p></li>
    <li class="labelValue"><p>${house.buildArea}</p></li>
</ul>
<ul class="label0">
	<li class="labelName"><p>购建年份:</p></li>
    <li class="labelValue"><p>${house.buildDate}</p></li>
    <li class="labelName"><p>购建价格:</p></li>
    <li class="labelValue"><p>${house.buildPrice}</p></li>
</ul>
 <ul class="label1">
	<li class="labelName"><p>占地面积:</p></li>
    <li class="labelValue"><p>${house.floorArea}</p></li>
    <li class="labelName"><p>当前评估价格:</p></li>
    <li class="labelValue"><p>${house.assessPrice}</p></li>
</ul>
</c:forEach>
 <c:forEach items="${forests}" var="forest">
<ul class="label0">
	<li class="labelName"><p>林权证编号:</p></li>
    <li class="labelValue"><p>${forest.cardNum}</p></li>
    <li class="labelName"><p>林权字号:</p></li>
    <li class="labelValue"><p>${forest.wordNum}</p></li>
</ul>
<ul class="label1">
	<li class="labelName"><p>林权使用人:</p></li>
    <li class="labelValue"><p>${forest.user}</p></li>
    <li class="labelName"><p>林权使用种类:</p></li>
    <li class="labelValue"><p>${forest.useType}</p></li>
</ul>
<ul class="label0">
	<li class="labelName"><p>面积(亩):</p></li>
    <li class="labelValue"><p>${forest.area}</p></li>
    <li class="labelName"><p>蓄积量:</p></li>
    <li class="labelValue"><p>${forest.storeNum}</p></li>
</ul>
<ul class="label1">
	<li class="labelName"><p>使用权期限:</p></li>
    <li class="labelValue"><p>${forest.timeLimit}</p></li>
    <li class="labelName"><p>当前评估价格:</p></li>
    <li class="labelValue"><p>${forest.assessPrice}</p></li>
</ul>
</c:forEach>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/balance.png) no-repeat"></legend>
<div class="fieldset-body">
<ul class="label0">
	<li class="labelName"><p>主要农作物年度净收入合计:</p></li>
    <li class="labelValue"><p>${farmingIncome.farmingIncome}</p></li>
    <li class="labelName"><p>林、牧、副、渔业年度净收入合计:</p></li>
    <li class="labelValue"><p>${balance.avocationIncome}</p></li>
</ul>
<ul class="label1">
	<li class="labelName"><p>家庭工商业年度净收入合计:</p></li>
    <li class="labelValue"><p>${balance.businessIncome}</p></li>
    <li class="labelName"><p>其他收入年度净收入合计:</p></li>
    <li class="labelValue"><p>${balance.otherIncome}</p></li>
</ul>
<ul class="label0">
	<li class="labelName"><p>生产支出:</p></li>
    <li class="labelValue"><p>${balance.productPay}</p></li>
    <li class="labelName"><p>生活支出:</p></li>
    <li class="labelValue"><p>${balance.livingPay}</p></li>
</ul>
<ul class="label1">
	<li class="labelName"><p>医疗支出:</p></li>
    <li class="labelValue"><p>${balance.medicalPay}</p></li>
	<li class="labelName"><p>教育支出:</p></li>
    <li class="labelValue"><p>${balance.educatePay}</p></li>
</ul>   
<ul class="label0">
	<li class="labelName"><p>参保支出:</p></li>
    <li class="labelValue"><p>${balance.insuredPay}</p></li>
    <li class="labelName"><p>其他支出:</p></li>
    <li class="labelValue"><p>${balance.otherPay}</p></li>
</ul>
<ul class="label1">
	<li class="labelName"><p>家庭年度总收入合计:</p></li>
    <li class="labelValue"><p>${balance.totalIncome}</p></li>
    <li class="labelName"><p>家庭年度支出总合计:</p></li>
    <li class="labelValue"><p>${balance.totalPay}</p></li>
</ul>
<c:forEach items="${incomes}" var="income">
<ul class="label0">
	<li class="labelName"><p>收入来源:</p></li>
    <li class="labelValue"><p>${income.incomeType}</p></li>
    <li class="labelName"><p>农作物或项目名称:</p></li>
    <li class="labelValue"><p>${income.incomeName}</p></li>
</ul>
<ul class="label1">
	<li class="labelName"><p>净收入:</p></li>
    <li class="labelValue"><p>${income.netIncome}</p></li>
</ul>
</c:forEach>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/compunish.png) no-repeat"></legend>
<div class="fieldset-body">
<ul class="label0">
	<li class="labelName"><p>人品综合评价:</p></li>
    <li class="labelValue"><p>${evaluate.personality}</p></li>
    <li class="labelName"><p>家庭和睦情况:</p></li>
    <li class="labelValue" ><p>${dic:translate("evaluate",evaluate.harmonyStatus)}</p></li>
</ul>
<ul class="label1">
	<li class="labelName"><p>敬老爱幼情况:</p></li>
    <li class="labelValue"><p>${dic:translate("evaluate",evaluate.respectStatus)}</p></li>
    <li class="labelName"><p>邻里团结情况:</p></li>
    <li class="labelValue"><p>${dic:translate("evaluate",evaluate.neighborStatus)}</p></li>
</ul>
<ul class="label0">
	<li class="labelName"><p>是否遵纪守法:</p></li>
    <li class="labelValue"><p>${dic:translate("yesorno",evaluate.legalStatus)}</p>
    </li>
    <li class="labelName"><p>对公益事业关心程度:</p></li>
    <li class="labelValue"><p>${dic:translate("evaluate",evaluate.welfareStatus)}</p></li>
</ul>
<ul class="label1">
	<li class="labelName"><p>是否诚实守信:</p></li>
    <li class="labelValue"><p>${dic:translate("yesorno",evaluate.honestStatus)}</p></li>
	<li class="labelName"><p>其他:</p></li>
    <li class="labelValue"><p>${evaluate.otherStatus}</p></li>
</ul>   
<c:forEach items="${compunishs}" var="compunish">
<ul class="label0">
	<li class="labelName"><p>表彰或处罚部门:</p></li>
    <li class="labelValue"><p>${compunish.organ}</p></li>
    <li class="labelName"><p>受表彰或处罚时间:</p></li>
    <li class="labelValue"><p>${dt:format(compunish.occurTime,"yyyy-MM-dd")}</p></li>
</ul>
<ul class="label0">
    <li class="labelName"><p>表彰或处罚内容:</p></li>
    <li class="labelValue"><p>${compunish.detail}</p></li>          
</ul>
</c:forEach>
</div>
</fieldset>
</td></tr>
</table>
</body>
</html>