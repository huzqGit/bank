<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bank.beans.User"%> 
<%@ page import="com.bank.Constants"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农民专业合作经济组织基本概况信息</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/miniui/monthpicker.js" type="text/javascript"></script>
<style>
html{
	height:90%
}
body {
	height: 100%;
	width: 100%;
	overfolw-x: hidden;
	margin-top: -2px;
	margin-left: -2px;
}

.saveBtn {
	width: 100px;
	height: 25px;
	border: 0;
	background: url(/bank/images/save.png) no-repeat
}

.backBtn {
	width: 100px;
	height: 25px;
	border: 0;
	background: url(/bank/images/back.png) no-repeat
}

.addBtn {
	width: 100px;
	height: 25px;
	border: 0;
	background: url(/bank/images/add.png) no-repeat
}
.bg{
	background:url(images/toolbar/toolbar.png) #e7eaee repeat-x 0px 0px
}
.topmenu{
	width:100%;
	height:40px;
	background:linear-gradient(#6DC8E3,white);
	/* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
	endColorstr = 'white' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
	endColorstr = 'white' )"; 
}
.errorText{
	size:10px;
	color:red;
}
</style>
<%
	User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
	//System.out.println(request.getRequestURI());
%>
</head>
<body>
<div  id="sss">
<div class="mini-toolbar mini-panel-header bg topmenu" style="height:27px;padding-top:5px;border-bottom:0;position: fixed;z-index: 20">
	<table style="width:100%;">
    	<tr>
        	<td style="white-space:nowrap;" align="right">
        		<span style="${display}">
		        	<a class="mini-button" iconCls="icon-save" plain="true" onclick="submitForm()">保存</a>
		           	<span class="separator"></span>
	            </span>
	            <c:if test="${!empty rightClick}">
	            	<a class="mini-button" iconCls="icon-remove" plain="true" onclick="close()">关闭</a>
                	<span  class="separator"></span>
                 </c:if>
                 <c:if test="${empty rightClick}">
                	<a class="mini-button" iconCls="icon-upgrade" plain="true" onclick="back()">返回</a>
                	<span class="separator"></span>
                 </c:if>
            </td>
         </tr>
      </table>
</div>
<div id="form1" style="width:97%;margin:auto auto;padding-top:25px">
	<form action="${pageContext.request.contextPath}/economy/debt/saveCooperationDebt.do" method="POST">
	<input name="debtid" class="mini-hidden" value="${debtid}"/>
	<input name="organ_id" class="mini-hidden" value="<%=user.getOrganId()%>"/>
	<input name="recorder" class="mini-hidden" value="<%=user.getUserName()%>"/>
	<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
	<table border="0" cellpadding="1" cellspacing="15" width="97%" >
	<tr>
	<td colspan="4" style="width:100%">
	<fieldset id="fd2" style="width:100%;">
	<legend><label>农民专业合作经济组织<font color="blue"><b>主要财务指标数</b></font></label></legend>
	<div class="fieldset-body" >
	<div >
	<table width="100%">
		<tr>
			<td style="width:10%"><label for="textbox1$text">年月:</label></td>
			<td style="width:23%">
				<input id="yyearm"  name="yearmonth" class="mini-textbox" required="true" readonly="readonly" errorMode="none" 
					requiredErrorText="年月不能为空" style="width:90%" />
				<div id="yearmonth_error" class="errorText"></div>
			</td>
			<td style="width:10%"><label for="textbox1$text">合作社名称:</label></td>
			<td style="width:20%">
			<input id="textbox1"  name="cooperationname" class="mini-textbox" required="true" errorMode="none" onvalidation="updateError"
				requiredErrorText="合作社名称不能为空" style="width:90%"/>
				<div id="cooperationname_error" class="errorText"></div>
			</td>
			<td style="width:10%"><label for="textbox2$text">组织机构编码:</label></td>
			<td style="width:20%" >
			<input id="textbox2"  name="organcode" class="mini-textbox" required="true" errorMode="none" onvalidation="updateError"
				requiredErrorText="组织机构编码不能为空"  style="width:90%"/>
				<div id="organcode_error" class="errorText"></div>
			</td>
			
		</tr>
	</table>
	<table width="100%" style="margin-bottom:-10px; margin-top:10px ;">
		<tr>
			<th  style="width:10%">&nbsp;</th><th  style="width:20%">期初值</th><th  style="width:20%">期末值</th><th  style="width:10%">&nbsp;</th><th  style="width:20%">期初值</th><th  style="width:20%">期末值</th>
		</tr>
	</table>
	<hr />
	</div>
	<div >
	<table width="100%" >
		<tr>
			<td style="width:10%"><label for="textbox6$text">货币资金:</label></td> <td style="width:20%"><input id="textbox6"  name="cashcapital" class="mini-textbox" required="false" vtype="float" requiredErrorText="货币资金不能为空" style="width:90%"/></td> <td style="width:20%"><input name="cashcapital2" class="mini-textbox" required="false" vtype="float" requiredErrorText="货币资金不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox7$text">短期投资:</label></td> <td style="width:20%"><input id="textbox7"  name="shortinvest" class="mini-textbox" required="false" vtype="float" requiredErrorText="短期投资不能为空" style="width:90%"/></td> <td style="width:20%"><input name="shortinvest2" class="mini-textbox" required="false" vtype="float" requiredErrorText="短期投资不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox8$text">应收账款净额:</label></td> <td style="width:20%"><input id="textbox8"  name="receivables" class="mini-textbox" required="false" vtype="float" requiredErrorText="应收账款净额不能为空" style="width:90%"/></td> <td style="width:20%"><input name="receivables2" class="mini-textbox" required="false" vtype="float" requiredErrorText="应收账款净额不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox9$text">预付账款:</label></td> <td style="width:20%"><input id="textbox9"  name="prepayment" class="mini-textbox" required="false" vtype="float" requiredErrorText="预付账款不能为空" style="width:90%"/></td> <td style="width:20%"><input name="prepayment2" class="mini-textbox" required="false" vtype="float" requiredErrorText="预付账款不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox10$text">存货:</label></td> <td style="width:20%"><input id="textbox10"  name="inventory" class="mini-textbox" required="false" vtype="float" requiredErrorText="存货不能为空" style="width:90%"/></td> <td style="width:20%"><input name="inventory2" class="mini-textbox" required="false" vtype="float" requiredErrorText="存货不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox11$text">其他流动资产:</label></td> <td style="width:20%"><input id="textbox11"  name="floatasset" class="mini-textbox" required="false" vtype="float" requiredErrorText="其他流动资产不能为空" style="width:90%"/></td> <td style="width:20%"><input name="floatasset2" class="mini-textbox" required="false" vtype="float" requiredErrorText="其他流动资产不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox12$text">流动资产合计:</label></td> <td style="width:20%"><input id="textbox12"  name="floatassetall" class="mini-textbox" required="false" vtype="float" requiredErrorText="流动资产合计不能为空" style="width:90%"/></td> <td style="width:20%"><input name="floatassetall2" class="mini-textbox" required="false" vtype="float" requiredErrorText="流动资产合计不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox13$text">固定资产原价:</label></td> <td style="width:20%"><input id="textbox13"  name="fixedasset" class="mini-textbox" required="false" vtype="float" requiredErrorText="固定资产原价不能为空" style="width:90%"/></td> <td style="width:20%"><input name="fixedasset2" class="mini-textbox" required="false" vtype="float" requiredErrorText="固定资产原价不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox14$text">其中折旧:</label></td> <td style="width:20%"><input id="textbox14"  name="deprecication" class="mini-textbox" required="false" vtype="float" requiredErrorText="其中折旧不能为空" style="width:90%"/></td> <td style="width:20%"><input name="deprecication2" class="mini-textbox" required="false" vtype="float" requiredErrorText="其中折旧不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox15$text">固定资产净值:</label></td> <td style="width:20%"><input id="textbox15"  name="netvalue" class="mini-textbox" required="false" vtype="float" requiredErrorText="固定资产净值不能为空" style="width:90%"/></td> <td style="width:20%"><input name="netvalue2" class="mini-textbox" required="false" vtype="float" requiredErrorText="固定资产净值不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox16$text">在建项目:</label></td> <td style="width:20%"><input id="textbox16"  name="buildingproject" class="mini-textbox" required="false" vtype="float" requiredErrorText="在建项目不能为空" style="width:90%"/></td> <td style="width:20%"><input name="buildingproject2" class="mini-textbox" required="false" vtype="float" requiredErrorText="在建项目不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox17$text">固定资产合计:</label></td> <td style="width:20%"><input id="textbox17"  name="fixedassetall" class="mini-textbox" required="false" vtype="float" requiredErrorText="固定资产合计不能为空" style="width:90%"/></td> <td style="width:20%"><input name="fixedassetall2" class="mini-textbox" required="false" vtype="float" requiredErrorText="固定资产合计不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox18$text">无形及递延资产合计:</label></td> <td style="width:20%"><input id="textbox18"  name="invisibleasset" class="mini-textbox" required="false" vtype="float" requiredErrorText="无形及递延资产合计不能为空" style="width:90%"/></td> <td style="width:20%"><input name="invisibleasset2" class="mini-textbox" required="false" vtype="float" requiredErrorText="无形及递延资产合计不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox19$text">资产合计:</label></td> <td style="width:20%"><input id="textbox19"  name="assetall" class="mini-textbox" required="false" vtype="float" requiredErrorText="资产合计不能为空" style="width:90%"/></td> <td style="width:20%"><input name="assetall2" class="mini-textbox" required="false" vtype="float" requiredErrorText="资产合计不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox20$text">短期借款:</label></td> <td style="width:20%"><input id="textbox20"  name="shortloan" class="mini-textbox" required="false" vtype="float" requiredErrorText="短期借款不能为空" style="width:90%"/></td> <td style="width:20%"><input name="shortloan2" class="mini-textbox" required="false" vtype="float" requiredErrorText="短期借款不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox21$text">银行借款:</label></td> <td style="width:20%"><input id="textbox21"  name="bankloan" class="mini-textbox" required="false" vtype="float" requiredErrorText="银行借款不能为空" style="width:90%"/></td> <td style="width:20%"><input name="bankloan2" class="mini-textbox" required="false" vtype="float" requiredErrorText="银行借款不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox22$text">应付账款:</label></td> <td style="width:20%"><input id="textbox22"  name="accountspayable" class="mini-textbox" required="false" vtype="float" requiredErrorText="应付账款不能为空" style="width:90%"/></td> <td style="width:20%"><input name="accountspayable2" class="mini-textbox" required="false" vtype="float" requiredErrorText="应付账款不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox23$text">预收账款:</label></td> <td style="width:20%"><input id="textbox23"  name="depositreceived" class="mini-textbox" required="false" vtype="float" requiredErrorText="预收账款不能为空" style="width:90%"/></td> <td style="width:20%"><input name="depositreceived2" class="mini-textbox" required="false" vtype="float" requiredErrorText="预收账款不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox24$text">未缴税金:</label></td> <td style="width:20%"><input id="textbox24"  name="unpaidtax" class="mini-textbox" required="false" vtype="float" requiredErrorText="未缴税金不能为空" style="width:90%"/></td> <td style="width:20%"><input name="unpaidtax2" class="mini-textbox" required="false" vtype="float" requiredErrorText="未缴税金不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox25$text">其他流动负债:</label></td> <td style="width:20%"><input id="textbox25"  name="floatdebt" class="mini-textbox" required="false" vtype="float" requiredErrorText="其他流动负债不能为空" style="width:90%"/></td> <td style="width:20%"><input name="floatdebt2" class="mini-textbox" required="false" vtype="float" requiredErrorText="其他流动负债不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox26$text">流动负债合计:</label></td> <td style="width:20%"><input id="textbox26"  name="floatdebtall" class="mini-textbox" required="false" vtype="float" requiredErrorText="流动负债合计不能为空" style="width:90%"/></td> <td style="width:20%"><input name="floatdebtall2" class="mini-textbox" required="false" vtype="float" requiredErrorText="流动负债合计不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox27$text">长期负债合计:</label></td> <td style="width:20%"><input id="textbox27"  name="longdebtall" class="mini-textbox" required="false" vtype="float" requiredErrorText="长期负债合计不能为空" style="width:90%"/></td> <td style="width:20%"><input name="longdebtall2" class="mini-textbox" required="false" vtype="float" requiredErrorText="长期负债合计不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox28$text">注册资本:</label></td> <td style="width:20%"><input id="textbox28"  name="registercapital" class="mini-textbox" required="false" vtype="float" requiredErrorText="注册资本不能为空" style="width:90%"/></td> <td style="width:20%"><input name="registercapital2" class="mini-textbox" required="false" vtype="float" requiredErrorText="注册资本不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox29$text">实收资本:</label></td> <td style="width:20%"><input id="textbox29"  name="realcapital" class="mini-textbox" required="false" vtype="float" requiredErrorText="实收资本不能为空" style="width:90%"/></td> <td style="width:20%"><input name="realcapital2" class="mini-textbox" required="false" vtype="float" requiredErrorText="实收资本不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox30$text">资本公积:</label></td> <td style="width:20%"><input id="textbox30"  name="capitalreserve" class="mini-textbox" required="false" vtype="float" requiredErrorText="资本公积不能为空" style="width:90%"/></td> <td style="width:20%"><input name="capitalreserve2" class="mini-textbox" required="false" vtype="float" requiredErrorText="资本公积不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox31$text">盈余公积:</label></td> <td style="width:20%"><input id="textbox31"  name="surplusreserve" class="mini-textbox" required="false" vtype="float" requiredErrorText="盈余公积不能为空" style="width:90%"/></td> <td style="width:20%"><input name="surplusreserve2" class="mini-textbox" required="false" vtype="float" requiredErrorText="盈余公积不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox32$text">未分配利润:</label></td> <td style="width:20%"><input id="textbox32"  name="unallotprofit" class="mini-textbox" required="false" vtype="float" requiredErrorText="未分配利润不能为空" style="width:90%"/></td> <td style="width:20%"><input name="unallotprofit2" class="mini-textbox" required="false" vtype="float" requiredErrorText="未分配利润不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox33$text">所有者权益合计:</label></td> <td style="width:20%"><input id="textbox33"  name="totalequity" class="mini-textbox" required="false" vtype="float" requiredErrorText="所有者权益合计不能为空" style="width:90%"/></td> <td style="width:20%"><input name="totalequity2" class="mini-textbox" required="false" vtype="float" requiredErrorText="所有者权益合计不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox34$text">负债和所有者权益合计:</label></td> <td style="width:20%"><input id="textbox34"  name="totalequity1" class="mini-textbox" required="false" vtype="float" requiredErrorText="负债和所有者权益合计不能为空" style="width:90%"/></td> <td style="width:20%"><input name="totalequity12" class="mini-textbox" required="false" vtype="float" requiredErrorText="负债和所有者权益合计不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox35$text">管理费用:</label></td> <td style="width:20%"><input id="textbox35"  name="handingcost" class="mini-textbox" required="false" vtype="float" requiredErrorText="管理费用不能为空" style="width:90%"/></td> <td style="width:20%"><input name="handingcost2" class="mini-textbox" required="false" vtype="float" requiredErrorText="管理费用不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox36$text">财务费用:</label></td> <td style="width:20%"><input id="textbox36"  name="financialcost" class="mini-textbox" required="false" vtype="float" requiredErrorText="财务费用不能为空" style="width:90%"/></td> <td style="width:20%"><input name="financialcost2" class="mini-textbox" required="false" vtype="float" requiredErrorText="财务费用不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox37$text">其中利息支出:</label></td> <td style="width:20%"><input id="textbox37"  name="interestexpense" class="mini-textbox" required="false" vtype="float" requiredErrorText="其中利息支出不能为空" style="width:90%"/></td> <td style="width:20%"><input name="interestexpense2" class="mini-textbox" required="false" vtype="float" requiredErrorText="其中利息支出不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox38$text">营业利润:</label></td> <td style="width:20%"><input id="textbox38"  name="businessprofit" class="mini-textbox" required="false" vtype="float" requiredErrorText="营业利润不能为空" style="width:90%"/></td> <td style="width:20%"><input name="businessprofit2" class="mini-textbox" required="false" vtype="float" requiredErrorText="营业利润不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox39$text">投资收益:</label></td> <td style="width:20%"><input id="textbox39"  name="investincome" class="mini-textbox" required="false" vtype="float" requiredErrorText="投资收益不能为空" style="width:90%"/></td> <td style="width:20%"><input name="investincome2" class="mini-textbox" required="false" vtype="float" requiredErrorText="投资收益不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox40$text">国家补贴收入:</label></td> <td style="width:20%"><input id="textbox40"  name="subsidyincome" class="mini-textbox" required="false" vtype="float" requiredErrorText="国家补贴收入不能为空" style="width:90%"/></td> <td style="width:20%"><input name="subsidyincome2" class="mini-textbox" required="false" vtype="float" requiredErrorText="国家补贴收入不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox41$text">营业外收入:</label></td> <td style="width:20%"><input id="textbox41"  name="unbusinessincome" class="mini-textbox" required="false" vtype="float" requiredErrorText="营业外收入不能为空" style="width:90%"/></td> <td style="width:20%"><input name="unbusinessincome2" class="mini-textbox" required="false" vtype="float" requiredErrorText="营业外收入不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox42$text">营业外支出:</label></td> <td style="width:20%"><input id="textbox42"  name="unbusinessexpense" class="mini-textbox" required="false" vtype="float" requiredErrorText="营业外支出不能为空" style="width:90%"/></td> <td style="width:20%"><input name="unbusinessexpense2" class="mini-textbox" required="false" vtype="float" requiredErrorText="营业外支出不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox43$text">以前年度损益调整:</label></td> <td style="width:20%"><input id="textbox43"  name="profitloss" class="mini-textbox" required="false" vtype="float" requiredErrorText="以前年度损益调整不能为空" style="width:90%"/></td> <td style="width:20%"><input name="profitloss2" class="mini-textbox" required="false" vtype="float" requiredErrorText="以前年度损益调整不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox44$text">利润总和:</label></td> <td style="width:20%"><input id="textbox44"  name="totalprofit" class="mini-textbox" required="false" vtype="float" requiredErrorText="利润总和不能为空" style="width:90%"/></td> <td style="width:20%"><input name="totalprofit2" class="mini-textbox" required="false" vtype="float" requiredErrorText="利润总和不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox45$text">应交所得税:</label></td> <td style="width:20%"><input id="textbox45"  name="payableincometax" class="mini-textbox" required="false" vtype="float" requiredErrorText="应交所得税不能为空" style="width:90%"/></td> <td style="width:20%"><input name="payableincometax2" class="mini-textbox" required="false" vtype="float" requiredErrorText="应交所得税不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox46$text">应交增值税:</label></td> <td style="width:20%"><input id="textbox46"  name="payableaddedtax" class="mini-textbox" required="false" vtype="float" requiredErrorText="应交增值税不能为空" style="width:90%"/></td> <td style="width:20%"><input name="payableaddedtax2" class="mini-textbox" required="false" vtype="float" requiredErrorText="应交增值税不能为空" style="width:90%"/></td>
			<td style="width:10%"><label for="textbox47$text">实交增值税:</label></td> <td style="width:20%"><input id="textbox47"  name="paidaddedtax" class="mini-textbox" required="false" vtype="float" requiredErrorText="实交增值税不能为空" style="width:90%"/></td> <td style="width:20%"><input name="paidaddedtax2" class="mini-textbox" required="false" vtype="float" requiredErrorText="实交增值税不能为空" style="width:90%"/></td>
		</tr>
		<tr>	
			<td style="width:10%"><label for="textbox48$text">利润净额:</label></td> <td style="width:20%"><input id="textbox48"  name="netprofit" class="mini-textbox" required="false" vtype="float" requiredErrorText="利润净额不能为空" style="width:90%"/></td> <td style="width:20%"><input name="netprofit2" class="mini-textbox" required="false" vtype="float" requiredErrorText="利润净额不能为空" style="width:90%"/></td>
		</tr>
		</table>
	</div>
	</div>
	</fieldset>
	</td>
	</tr>
	</table>
	</form>
</div>
</div>
</body>
<script type="text/javascript">
	mini.parse();
	var form = new mini.Form("#form1");
	if('${accessMethod}'=='viewForm'){
		document.write('<link href="${pageContext.request.contextPath}/miniui/themes/stategrid-skin/skin.css" rel="stylesheet" type="text/css" />');
		form.setEnabled(false);
	}
	if('${accessMethod}' != 'addForm'){
		mini.getbyName("organcode").setEnabled(false);
	}
	
	function updateError(e) {
        var id = e.sender.name + "_error";
        var el = document.getElementById(id);
        if (el) {
            el.innerHTML = e.errorText;
        }
	}
	
	//查询表单数据
	$(document).ready(function(){
		document.getElementById("yyearm$text").onclick=function(){
			setmonth(this);
		};
		$.ajax({
		    url: "${pageContext.request.contextPath}/economy/debt/findCooperationDebt.do",
		    type: "post",
		    data:{debtid:"${debtid}"},
		    success: function (text) {
		        var data = mini.decode(text);   //反序列化成对象
		        if(data.debtid!=null){
		       	 	form.setData(data);  //设置多个控件数据   
		        }
		    },
		    error:function(text,arg2){
		    }
		});
		
	});
	
	function close(){
		if (window.CloseOwnerWindow){
			window.CloseOwnerWindow();
		}else{
			window.close();
		}
	}
	
	function back(){
		history.go(-1);
	}
	/*  window.onerror = function(message, URI, lineNumber,columnNumber,errorObj) { 
	      console.log("错误信息：" , message); 
	      console.log("出错文件：" , URI); 
	      console.log("出错行号：" , lineNumber); 
	      console.log("出错列号：" , columnNumber); 
	      console.dir(errorObj); 
	      return true; 
	 }  */
	
	 function validateYearMonth(){
		var y = document.getElementById("yyearm$text").value;
		mini.get("yyearm").setValue(y);
		var s = mini.get("yyearm").getValue();
		if(s=='' || s==null){
			mini.alert("年月不能为空");
			return false;
		}
		return true;
	 }
	
	function submitForm(){
		if(!validateYearMonth())
			return;
		//提交表单数据
	    var formData = form.getData();      //获取表单多个控件的数据
	     form.validate();
      	if (!form.isValid())
      		return;
	    var json = mini.encode(formData);   //序列化成JSON
	    $.ajax({
	        url: "${pageContext.request.contextPath}/economy/debt/saveCooperationDebt.do",
	        type: "post",
	        data: { formData: json},
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        success: function (text) {
	        	var data = mini.decode(text);   //反序列化成对象
		        if(data.debtid!=null){
		       	 	form.setData(data);
		        }
		      mini.alert('保存成功！');
 			setTimeout(function(){
 				try{
 					close();
 				}catch(e){
 	      			back();
 	      		}
 			},1500);
      		
	        },
	        error: function (jqXHR, textStatus, errorThrown) {
	            mini.alert('系统异常！');
	        }
		});
	}
 
  </script>
</html>