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
     li{float:left;height:22px;line-height:22px;word-break:break-all;word-wrap:break-word;text-align:left};
   	.labelName{
   		padding-left:12px;
   		width:15%;
   	}
   	.labelValue{
   		width:32%
   	}
   	.label1 li{
   		background:#F5F7CF
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
<div style="width:100%;margin:0px;padding:0px">
<c:forEach items="${farmers}" var="farmer" varStatus="stauts">
	<ul>
		<li style="width:10%">农户类型:</li>
    	<li style="width:15%">${farmer.farmertype} </li>
        <li style="width:10%;">户主姓名:</li>
        <li style="width:15%;">${farmer.farmername}</li>
        <li style="width:10%">性别:</li>
        <li style="width:15%;" >${dic:translate("sex",farmer.sex)}</li>
    	<li style="width:10%">婚姻状况:</li>
        <li style="width:15%;">${dic:translate("marrystatus",farmer.marrystatus)}</li>
    </ul>
    <ul class="label1">
    	<li style="width:10%">政治面貌:</li>
        <li style="width:15%">
        	${dic:translate("politicstatus",farmer.politicstatus)}
        </li>
        <li style="width:10%">邮政编码:</li>
    	<li style="width:15%">${farmer.postcode} </li>
    	<li style="width:10%">家庭人数:</li>
        <li style="width:15%">${farmer.familynum}</li>
    	<li style="width:10%">劳动力人数:</li>
        <li style="width:15%">${farmer.labornum}</li>
        
    </ul>
     <ul class="label0">

        <li style="width:10%">联系电话:</li>
        <li style="width:40%">${farmer.phone}</li>
        <li style="width:10%">户主身份证号:</li>
        <li style="width:40%;" >${farmer.farmeridnum}</li>
    </ul>
    <ul class="label1" >
        <li style="width:15%">现住址:</li>
        <li style="width:85%">${farmer.address}</li>
   </ul>
  </c:forEach>
  </div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:250px;height:74px;background:url(/bank/images/member.png)"> </legend>
<div style="width:100%">
 <c:forEach items="${members}" var="member">
  <ul class="label0">
  	    <li style="width:10%">与户主关系:</li>
        <li style="width:10%">${dic:translate("relation",member.relation)}</li>
  		<li style="width:15%">家庭成员姓名:</li>
        <li style="width:10%">${member.name}</li>
        <li style="width:10%">性别:</li>
        <li style="width:10%">${dic:translate("sex",member.sex)}</li>
        <li style="width:10%">婚姻状况:</li>
	    <li style="width:25%">${dic:translate("marrystatus",member.marrystatus)}</li>

  </ul>
  <ul class="label1">
       <li style="width:10%">文化程度:</li>
       <li style="width:10%">${dic:translate("education",member.education)}</li>
       <li style="width:15%">职业:</li>
       <li style="width:10%">${member.occupation}</li>
       <li style="width:10%">职务:</li>
       <li style="width:10%">${member.job} </li>
       <li style="width:10%">身份证号:</li>
       <li style="width:25%">${member.idnum} </li>
      

  </ul>
  <ul class="label0">
  	   <li style="width:10%">联系电话:</li>
       <li style="width:85%">${member.phone}</li>
   </ul>
   <ul class="label1">
  	   <li style="width:15%">地址:</li>
       <li style="width:85%">${member.address}</li>
  </ul>
 </c:forEach>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/balance.png) no-repeat"></legend>
<div class="fieldset-body">
<ul class="label0">
	<li style="width:15%">年份:</li>
	<li style="width:10%">${balance.year}</li>
	<li style="width:20%">主要农作物收入:</li>
    <li style="width:15%">${balance.farmingincome}</li>
    <li style="width:25%">林、牧、副、渔业收入:</li>
    <li style="width:15%">${balance.avocationincome}</li>
</ul>
<ul class="label1">
	<li style="width:15%">家庭工商业收入:</li>
    <li style="width:10%">${balance.businessincome}</li>
    <li style="width:20%">外出务工收入:</li>
    <li style="width:15%">${balance.otherincome}</li>
    <li style="width:25%">其他收入:</li>
    <li style="width:15%">${balance.otherincome}</li>
</ul>
<ul class="label0">
	<li style="width:15%">生产支出:</li>
    <li style="width:10%">${balance.productpay}</li>
    <li style="width:20%">生活支出:</li>
    <li style="width:15%">${balance.livingpay}</li>
    <li style="width:25%">医疗支出:</li>
    <li style="width:15%">${balance.medicalpay}</li>

</ul>

<ul class="label1">
	<li style="width:15%">教育支出:</li>
    <li style="width:10%">${balance.educatePay}</li>
	<li style="width:20%">参保支出:</li>
    <li style="width:15%">${balance.insuredpay}</li>
    <li style="width:25%">其他支出:</li>
    <li style="width:15%">${balance.otherpay}</li>
</ul>
<ul class="label0">
	<li style="width:15%">家庭年度总收入合计:</li>
    <li style="width:10%">${balance.totalpncome}</li>
    <li style="width:20%">家庭年度支出总合计:</li>
    <li style="width:55%">${balance.totalpay}</li>
</ul>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:260px;height:74px;background:url(/bank/images/loan.png) no-repeat"> </legend>
<div class="fieldset-body">
<c:forEach items="${loans}" var="loan" varStatus="stauts">
<ul class="label0">
	<li style="width:15%">贷款金融机构:</li>
	<li style="width:25%">${loan.organname}</li>
	<li style="width:10%">贷款金额:</li>
	<li style="width:10%">${loan.amount}</li>
	<li style="width:10%">贷款日期:</li>
	<li style="width:10%">${loan.loandate}</li>
	<li style="width:10%">到期日期:</li>
	<li style="width:10%">${loan.limitdate}</li>
</ul>
<ul class="label1">
	<li style="width:15%">贷款余额:</li>
	<li style="width:85%">${loan.balance}</li>
</ul>
</c:forEach>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:260px;height:74px;background:url(/bank/images/lending.png) no-repeat"> </legend>
<div class="fieldset-body">
<c:forEach items="${insureds}" var="loan" varStatus="stauts">
<ul class="label0">
	<li style="width:15%">贷款金额:</li>
	<li style="width:10%">${insured.type}</li>
	<li style="width:15%">月利率:</li>
	<li style="width:10%">${insured.amount}</li>
	<li style="width:15%">借贷日期:</li>
	<li style="width:10%">${insured.insuredtime}</li>
	<li style="width:15%">到期日期:</li>
	<li style="width:10%">${insured.limittime}</li>
</ul>
</c:forEach>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/house.png) no-repeat"> </legend>
<div class="fieldset-body">
<c:forEach items="${houses}" var="house">
<ul class="label0">
	<li style="width:15%">房产性质:</li>
    <li style="width:10%"> ${dic:translate("houseproperties",house.houseproperty)}</li>
    <li style="width:15%">房屋类型:</li>
    <li style="width:10%">${dic:translate("housetype",house.housetype)}</li>
    <li style="width:15%">购建年份:</li>
    <li style="width:10%">${house.builddate}</li>
    <li style="width:15%">购建价格:</li>
    <li style="width:10%">${house.buildprice}</li>
</ul>
<ul class="label1">
    <li style="width:15%">建筑面积:</li>
    <li style="width:10%">${house.buildarea}</li>
    <li style="width:15%">占地面积:</li>
    <li style="width:10%">${house.floorarea}</li>
    <li style="width:15%">当前评估价格:</li>
    <li style="width:35%">${house.assessprice}</li>
	<li style="width:15%">房屋地址:</li>
    <li style="width:85%">${house.houseaddress}</li>
</ul>
</c:forEach>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/forest.png) no-repeat"> </legend>
<div class="fieldset-body">
<c:forEach items="${forests}" var="forest">
<ul class="label0">
	<li style="width:15%">林权证编号:</li>
    <li style="width:10%">${forest.cardnum}</li>
    <li style="width:15%">林权字号:</li>
    <li style="width:10%">${forest.wordnum}</li>
	<li style="width:15%">林权使用人:</li>
    <li style="width:10%">${forest.user}</li>
    <li style="width:15%">林权使用种类:</li>
    <li style="width:10%">${forest.usetype}</li>
</ul>
<ul class="label1">
	<li style="width:15%">面积(亩):</li>
    <li style="width:10%">${forest.area}</li>
    <li style="width:15%">蓄积量:</li>
    <li style="width:10%">${forest.storenum}</li>
	<li style="width:15%">使用权期限:</li>
    <li style="width:10%">${forest.timelimit}</li>
    <li style="width:15%">当前评估价格(元):</li>
    <li style="width:10%">${forest.assessprice}</li>
</ul>
</c:forEach>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/breed.png) no-repeat"> </legend>
<div class="fieldset-body">
<c:forEach items="${breeds}" var="breed">
<ul class="label0">
	<li style="width:15%">种养殖品种:</li>
    <li style="width:10%">${breed.variety}</li>
    <li style="width:15%">占地面积:</li>
    <li style="width:10%">${breed.floorarea}</li>
	<li style="width:15%">年产量:</li>
    <li style="width:10%">${breed.output}</li>
    <li style="width:15%">年产值(元):</li>
    <li style="width:10%">${breed.outputvalue}</li>
</ul>
<ul class="label1">
    <li style="width:15%">当前评估价格:</li>
    <li style="width:85%">${breed.assessprice}</li>
</ul>
</c:forEach>
</div>
</fieldset>

<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/insured.png) no-repeat"></legend>
<div class="fieldset-body">  
<c:forEach items="${insureds}" var="insured">
<ul class="label0">
	<li style="width:15%">保险种类:</li>
    <li style="width:10%">${insured.type}</li>
    <li style="width:15%">参保金额:</li>
    <li style="width:10%">${insured.amount}</li>
	<li style="width:15%">参保时间:</li>
    <li style="width:10%">${insured.insuretime}</li>
    <li style="width:15%">参保到期日:</li>
    <li style="width:10%">${insured.limittime}</li>
 
</ul>
<ul class="label1">
    <li style="width:20%">表彰或处罚内容:</li>
    <li style="width:80%">${compunish.detail}</li>          
</ul>
</c:forEach>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/compunish.png) no-repeat"></legend>
<div class="fieldset-body">  
<c:forEach items="${compunishs}" var="compunish">
<ul class="label0">
	<li style="width:15%">表彰或处罚:</li>
    <li style="width:10%">${compunish.organ}</li>
    <li style="width:15%">受表彰或处罚时间:</li>
    <li style="width:10%">${dt:format(compunish.occurtime,"yyyy-MM-dd")}</li>
	<li style="width:20%">表彰或处罚部门:</li>
    <li style="width:30%">${compunish.organ}</li>
 
</ul>
<ul class="label1">
    <li style="width:20%">表彰或处罚内容:</li>
    <li style="width:80%">${compunish.detail}</li>          
</ul>
</c:forEach>
</div>
</fieldset>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend style="width:200px;height:74px;background:url(/bank/images/other.png) no-repeat"></legend>
<div class="fieldset-body">
<ul class="label0">
	<li style="width:18%">人品综合评价:</li>
    <li style="width:7%">${evaluate.personality}</li>
    <li style="width:18%">家庭和睦情况:</li>
    <li style="width:7%" >${dic:translate("evaluate",evaluate.harmonystatus)}</li>
	<li style="width:18%">敬老爱幼情况:</li>
    <li style="width:7%">${dic:translate("evaluate",evaluate.respectstatus)}</li>
    <li style="width:18%">邻里团结情况:</li>
    <li style="width:7%">${dic:translate("evaluate",evaluate.neighborstatus)}</li>
</ul>
<ul class="label1">
	<li style="width:18%">是否遵纪守法:</li>
    <li style="width:7%">${dic:translate("yesorno",evaluate.legalstatus)}</li>
    <li style="width:18%">对公益事业关心程度:</li>
    <li style="width:7%">${dic:translate("evaluate",evaluate.welfarestatus)}</li>
	<li style="width:18%">是否诚实守信:</li>
    <li style="width:7%">${dic:translate("yesorno",evaluate.honeststatus)}</li>
	<li style="width:18%">其他:</li>
    <li style="width:7%">${evaluate.otherstatus}</li>
</ul> 
</div>
</fieldset>
</td></tr>
</table>
</body>
</html>