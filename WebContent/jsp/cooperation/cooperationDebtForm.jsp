<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="dt" uri="http://gov.jian.bank/dateformat" %> 
<%@ page import="com.bank.beans.User"%> 
<%@ page import="com.bank.Constants"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农民专业合作经济组织基本概况信息</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/miniui/monthpicker.js" type="text/javascript"></script>
<%
	User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
	//System.out.println(request.getRequestURI());
%>
</head>
<body>
<div id="form1" style="width:100%;margin:auto auto;">
<form action="${pageContext.request.contextPath}/economy/debt/saveCooperationDebt1.do" method="POST">
<input name="id" class="mini-hidden" value="${cooperationdebt.id}"/>
<input name="organ_id" class="mini-hidden" value="<%=user.getOrganId()%>"/>
<input name="organcode" class="mini-hidden" value="${cooperation.organcode}"/>
<input name="sourcecode" class="mini-hidden" value="${cooperation.sourcecode}"/>
<input name="sourcename" class="mini-hidden" value="${cooperation.sourcename }"/>
<input name="recorder" class="mini-hidden" value="<%=user.getUserName()%>"/>
<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
<div class="queryPane">
	<table style="width:100%;height:30px">
		<tr>
			<td class="labelName" width="20%" align="right">经济合作组织名称</td>
			<td class="labelValue" width="20%">:${cooperation.cooperationname }</td>
			<td class="labelName" width="20%" align="right">营业执照</td>
			<td class="labelValue" align="right" width="10%">:${cooperation.businesslicence}</td>
		    <td width="30" align="center">
		       	<input type="button" id="saveBtn" class="bank-btn" onclick="submitForm()" value="保存"/>
		     </td>
		      <td width="30" align="center">
		       	<input type="button"  class="bank-btn" onclick="back()" value="返回"/>
		     </td>
		</tr>
	</table>
</div>
<table border="0" cellpadding="1" cellspacing="15" width="97%" >
<tr>
	<td colspan="4" style="width:100%">
	<fieldset id="fd2" style="width:100%;">
	<legend><label>资产负债信息</label></legend>
	<div class="fieldset-body" >
	<table width="100%" >
	<tr>	
		<td class="required_text" width="2%" align="right">*</td>
		<td style="width:15%">年月:</td>
		<td style="width:33%">
			<input name="yearmonth" class="mini-datepicker" style="width:90%"  value="${cooperationdebt.yearmonth}"
			format="yyyy-MM"
			errorMode="none" required="true"  requiredErrorText="年月不能为空"  onvalidation="onValidation"/>
		</td>
		<td style="width:2%"></td>
		<td style="width:15%"></td>
		<td style="width:33%"></td>
	</tr>
	<tr>
		<td ></td>
		<td id="yearmonth_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td  colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>
		<td >货币资金:</td> 
		<td >
			<input  name="cashcapital" class="mini-textbox" value="${cooperationdebt.cashcapital}" style="width:90%" 
			vtype="float" errorMode="none"  required="false"  requiredErrorText="货币资金不能为空" onvalidation="onValidation"/>
		</td>
		<td class="required_text" width="2%" align="right"></td>
		<td >短期投资:</td> 
		<td >
		<input name="shortinvest" class="mini-textbox" value="${cooperationdebt.shortinvest}" style="width:90%"
			vtype="float" errorMode="none"  required="false" requiredErrorText="短期投资不能为空" onvalidation="onValidation"/>
		</td>
	</tr>
	<tr>
		<td ></td>
		<td id="cashcapital_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="shortinvest_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>	
		<td >应收账款净额:</td>
		 <td >
		 <input name="receivables" class="mini-textbox" value="${cooperationdebt.receivables}"style="width:90%"
			 vtype="float" errorMode="none"  required="false" requiredErrorText="应收账款净额不能为空" onvalidation="onValidation" />
		</td> 
		<td class="required_text" width="2%" align="right"></td>
		<td >预付账款:</td>
			<td >
			 <input  name="prepayment" class="mini-textbox" value="${cooperationdebt.prepayment}" style="width:90%"
				vtype="float" errorMode="none"  required="false" requiredErrorText="预付账款不能为空" onvalidation="onValidation"/>
			</td> 
	</tr>
	<tr>
		<td ></td>
		<td id="receivables_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="prepayment_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>	
		<td >存货:</td> 
		<td >
			<input name="inventory" class="mini-textbox"  value="${cooperationdebt.inventory}" style="width:90%"
				vtype="float" errorMode="none"  required="false" requiredErrorText="存货不能为空" onvalidation="onValidation" />
		</td> 
		<td class="required_text" width="2%" align="right"></td>
		<td >其他流动资产:</td> 
		<td >
			<input name="floatasset" class="mini-textbox" value="${cooperationdebt.floatasset}" style="width:90%"
				vtype="float" errorMode="none"  required="false" requiredErrorText="其他流动资产不能为空" onvalidation="onValidation"/>
		</td> 
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>	
		<td >流动资产合计:</td> 
		<td >
			<input  name="floatassetall" class="mini-textbox" value="${cooperationdebt.floatassetall}" style="width:90%"
			vtype="float" errorMode="none"  required="false" requiredErrorText="流动资产合计不能为空" onvalidation="onValidation"/>
		</td> 
		<td class="required_text" width="2%" align="right"></td>
		<td  >固定资产原价:</td> <td >
			<input  name="fixedasset" class="mini-textbox" value="${cooperationdebt.fixedasset}" style="width:90%"
			vtype="float" errorMode="none"  required="false" requiredErrorText="固定资产原价不能为空" onvalidation="onValidation"/>
		</td> 
	</tr>
	<tr>
		<td ></td>
		<td id="floatassetall_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="fixedasset_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>	
		<td >其中折旧:</td> <td >
			<input name="deprecication" class="mini-textbox"  value="${cooperationdebt.deprecication}" style="width:90%"
				 vtype="float" errorMode="none"  required="false"  requiredErrorText="其中折旧不能为空" onvalidation="onValidation"/>
		</td>
		<td class="required_text" width="2%" align="right"></td> 
		<td >固定资产净值:</td>
		<td >
				<input  name="netvalue" class="mini-textbox" value="${cooperationdebt.netvalue}" style="width:90%"
			vtype="float" errorMode="none"  required="false"  requiredErrorText="固定资产净值不能为空" onvalidation="onValidation"/>
		</td> 
	</tr>
			<tr>
			<td ></td>
			<td id="deprecication_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="netvalue_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >在建项目:</td> 
			<td >
				<input name="buildingproject" class="mini-textbox" value="${cooperationdebt.buildingproject}" style="width:90%"
				required="false" requiredErrorText="在建项目不能为空" onvalidation="onValidation"/>
			</td>
			<td class="required_text" width="2%" align="right"></td>
			<td >固定资产合计:</td> <td >
			<input  name="fixedassetall" class="mini-textbox" value="${cooperationdebt.fixedassetall}" style="width:90%"
			 vtype="float" errorMode="none"  required="false" requiredErrorText="固定资产合计不能为空" onvalidation="onValidation"/>
			</td> 
			
		</tr>
			<tr>
			<td ></td>
			<td id="buildingproject_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="fixedassetall_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>		
			<td >无形及递延资产合计:</td> 
			<td >
				<input name="invisibleasset" class="mini-textbox" value="${cooperationdebt.fixedassetall}" style="width:90%"
				vtype="float" errorMode="none"  required="false"  requiredErrorText="无形及递延资产合计不能为空" onvalidation="onValidation"/>
				</td> 
			<td class="required_text" width="2%" align="right"></td>		
			<td >资产合计:</td> 
				<td >
					<input name="assetall" class="mini-textbox" value="${cooperationdebt.assetall}" style="width:90%"
					vtype="float" errorMode="none"  required="false"  requiredErrorText="资产合计不能为空" onvalidation="onValidation"/>
					 </td> 
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >短期借款:</td> <td >
				<input name="shortloan" class="mini-textbox" value="${cooperationdebt.shortloan}" style="width:90%"
				 vtype="float" errorMode="none"  required="false" requiredErrorText="短期借款不能为空"  onvalidation="onValidation"/></td>
			<td class="required_text" width="2%" align="right"></td>
			<td >银行借款:</td> <td >
				<input  name="bankloan" class="mini-textbox" value="${cooperationdebt.bankloan}" style="width:90%"
				vtype="float" errorMode="none"  required="false"  requiredErrorText="银行借款不能为空"  onvalidation="onValidation"/>
				</td> 
			</td>
		</tr>
			<tr>
			<td ></td>
			<td id="shortloan_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="bankloan_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >应付账款:</td> 
				<td >
					<input  name="accountspayable" class="mini-textbox" value="${cooperationdebt.accountspayable}" style="width:90%"
					vtype="float" errorMode="none"  required="false" requiredErrorText="应付账款不能为空"  onvalidation="onValidation"/>
					 </td>
				<td class="required_text" width="2%" align="right"></td>
				<td >预收账款:</td> 
				<td >
				<input name="depositreceived" class="mini-textbox" value="${cooperationdebt.accountspayable}" style="width:90%"
				 vtype="float" errorMode="none"  required="false" requiredErrorText="预收账款不能为空"  onvalidation="onValidation"/>
				 </td>
		</tr>
			<tr>
			<td ></td>
			<td id="accountspayable_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="depositreceived_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >未缴税金:</td> 
			<td >
			<input name="unpaidtax" class="mini-textbox" value="${cooperationdebt.unpaidtax}" style="width:90%"
			vtype="float" errorMode="none"  required="false" requiredErrorText="未缴税金不能为空" onvalidation="onValidation"/>
			</td>
			<td class="required_text" width="2%" align="right"></td>
			<td >其他流动负债:</td> <td >
			<input id="textbox25"  name="floatdebt" class="mini-textbox" value="${cooperationdebt.floatdebt}" style="width:90%"
			vtype="float" errorMode="none"  required="false"  requiredErrorText="其他流动负债不能为空"  onvalidation="onValidation"/>
			</td> 
		</tr>
			<tr>
			<td ></td>
			<td id="unpaidtax_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="registerdate_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>	
			<td class="required_text" width="2%" align="right"></td>
			<td >流动负债合计:</td> 
			<td >
			<input name="floatdebtall" class="mini-textbox "value="${cooperationdebt.floatdebtall}" style="width:90%"
			 vtype="float" errorMode="none"  required="false" requiredErrorText="流动负债合计不能为空"  onvalidation="onValidation"/>
			</td>
			<td class="required_text" width="2%" align="right"></td>
			<td >长期负债合计:</td>
			 <td >
			 	<input name="longdebtall" class="mini-textbox" value="${cooperationdebt.longdebtall}" style="width:90%"
			 	vtype="float" errorMode="none"  required="false" requiredErrorText="长期负债合计不能为空"  onvalidation="onValidation"/>
			 	</td> 

		</tr>
			<tr>
			<td ></td>
			<td id="floatdebtall_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="longdebtall_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >注册资本:</td> <td >
			<input id="textbox28"  name="registercapital" class="mini-textbox" value="${cooperationdebt.registercapital}" style="width:90%" 
			 vtype="float" errorMode="none"  required="false" requiredErrorText="注册资本不能为空" onvalidation="onValidation"/>
			</td> 
		<td class="required_text" width="2%" align="right"></td>
			<td >实收资本:</td> 
			<td >
			<input  name="realcapital" class="mini-textbox" value="${cooperationdebt.realcapital}" style="width:90%" 
			vtype="float" errorMode="none"  required="false"requiredErrorText="实收资本不能为空" onvalidation="onValidation"/>
			</td> 
		</tr>
			<tr>
			<td ></td>
			<td id="registercapital_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="realcapital_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >资本公积:</td> <td >
			<input name="capitalreserve" class="mini-textbox" value="${cooperationdebt.capitalreserve}" style="width:90%"
			vtype="float" errorMode="none"  required="false"requiredErrorText="资本公积不能为空"  onvalidation="onValidation"/>
			</td>
			<td class="required_text" width="2%" align="right"></td>
			<td >盈余公积:</td> <td >
			<input  name="surplusreserve" class="mini-textbox" value="${cooperationdebt.surplusreserve}" style="width:90%"
			vtype="float" errorMode="none"  required="false" requiredErrorText="盈余公积不能为空"  onvalidation="onValidation"/>
			</td>
		
		</tr>
			<tr>
			<td ></td>
			<td id="taxcode_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="registerdate_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >未分配利润:</td> <td >
				<input   name="unallotprofit" class="mini-textbox" value="${cooperationdebt.unallotprofit}" style="width:90%"
				 vtype="float" errorMode="none"  required="false"requiredErrorText="未分配利润不能为空" onvalidation="onValidation"/>
				</td> 
			<td class="required_text" width="2%" align="right"></td>
			<td >所有者权益合计:</td> <td >
			<input  name="totalequity" class="mini-textbox" value="${cooperationdebt.totalequity}" style="width:90%"
			 vtype="float" errorMode="none"  required="false" requiredErrorText="所有者权益合计不能为空" onvalidation="onValidation"/>
			 </td>
			
		</tr>
			<tr>
			<td ></td>
			<td id="taxcode_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="registerdate_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >负债和所有者权益合计:</td> <td >
				<input name="totalequity1" class="mini-textbox" value="${cooperationdebt.totalequity1}" style="width:90%"
				vtype="float" errorMode="none"  required="false" requiredErrorText="负债和所有者权益合计不能为空" onvalidation="onValidation"/>
				</td>
			<td class="required_text" width="2%" align="right"></td>
			<td >管理费用:</td> <td >
			<input name="handingcost" class="mini-textbox" value="${cooperationdebt.handingcost}" style="width:90%"
			 vtype="float" errorMode="none"  required="false"requiredErrorText="管理费用不能为空" onvalidation="onValidation"/>
			</td> 
		
		</tr>
			<tr>
			<td ></td>
			<td id="taxcode_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="registerdate_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >财务费用:</td>
				 <td >
				 	<input name="financialcost" class="mini-textbox" value="${cooperationdebt.financialcost}" style="width:90%"
				 	vtype="float" errorMode="none"  required="false" requiredErrorText="财务费用不能为空" onvalidation="onValidation"/>
				 	</td>
			<td class="required_text" width="2%" align="right"></td>	
			<td >其中利息支出:</td> <td >
				<input  name="interestexpense" class="mini-textbox" value="${cooperationdebt.interestexpense}" style="width:90%"
				vtype="float" errorMode="none"  required="false" requiredErrorText="其中利息支出不能为空" onvalidation="onValidation"/>
				</td> 
		
		</tr>
			<tr>
			<td ></td>
			<td id="financialcost_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="interestexpense_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >营业利润:</td>
			 <td >
			 <input name="businessprofit" class="mini-textbox"  value="${cooperationdebt.businessprofit}" style="width:90%"
			 vtype="float" errorMode="none"  required="false" requiredErrorText="营业利润不能为空" onvalidation="onValidation"/></td>
			<td class="required_text" width="2%" align="right"></td>
			<td >投资收益:</td>
			 <td >
			 <input name="investincome" class="mini-textbox" value="${cooperationdebt.investincome}" style="width:90%"
			 vtype="float" errorMode="none"  required="false"requiredErrorText="投资收益不能为空" onvalidation="onValidation"/>
			 </td>
		
		</tr>
			<tr>
			<td ></td>
			<td id="businessprofit_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="investincome_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >国家补贴收入:</td> 
			<td >
			<input  name="subsidyincome" class="mini-textbox"  value="${cooperationdebt.subsidyincome}" style="width:90%"
			vtype="float" errorMode="none"  required="false"requiredErrorText="国家补贴收入不能为空" onvalidation="onValidation"/>
			</td> 
			<td class="required_text" width="2%" align="right"></td>
			<td >营业外收入:</td> 
			<td >
			<input name="unbusinessincome" class="mini-textbox" value="${cooperationdebt.unbusinessincome}" style="width:90%"
			vtype="float" errorMode="none"  required="false"requiredErrorText="营业外收入不能为空" style="width:90%"onvalidation="onValidation"/>
			</td> 
		</tr>
			<tr>
			<td ></td>
			<td id="subsidyincome_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="unbusinessincome_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >营业外支出:</td> 
				<td >
					<input name="unbusinessexpense" class="mini-textbox" value="${cooperationdebt.unbusinessexpense}" style="width:90%"
					vtype="float" errorMode="none"  required="false"requiredErrorText="营业外支出不能为空" onvalidation="onValidation"/>
					</td> 
			<td class="required_text" width="2%" align="right"></td>
			<td >以前年度损益调整:</td>
			 <td >
			 	<input name="profitloss" class="mini-textbox" value="${cooperationdebt.profitloss}" style="width:90%"
			 	vtype="float" errorMode="none"  required="false" requiredErrorText="以前年度损益调整不能为空" onvalidation="onValidation"/>
			 	</td> 
		
		</tr>
			<tr>
			<td ></td>
			<td id="unbusinessexpense_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="profitloss_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >利润总和:</td> 
			<td >
			<input name="totalprofit" class="mini-textbox" value="${cooperationdebt.totalprofit}" style="width:90%"
		vtype="float" errorMode="none"  required="false"requiredErrorText="利润总和不能为空" onvalidation="onValidation"/>
			</td> 
			<td class="required_text" width="2%" align="right"></td>
			<td >应交所得税:</td> 
			<td >
			<input name="payableincometax" class="mini-textbox" value="${cooperationdebt.payableincometax}" style="width:90%"
			vtype="float" errorMode="none"  required="false" requiredErrorText="应交所得税不能为空"  onvalidation="onValidation"/>
			</td> 
		
		</tr>
			<tr>
			<td ></td>
			<td id="taxcode_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="registerdate_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >应交增值税:</td> 
			<td >
			<input name="payableaddedtax" class="mini-textbox" value="${cooperationdebt.payableaddedtax}" style="width:90%"
			vtype="float" errorMode="none"  required="false" requiredErrorText="应交增值税不能为空" onvalidation="onValidation"/>
			</td>
		<td class="required_text" width="2%" align="right"></td>
			<td >实交增值税:</td> 
			<td >
				<input name="paidaddedtax" class="mini-textbox" value="${cooperationdebt.payableaddedtax}" style="width:90%"
				vtype="float" errorMode="none"  required="false" requiredErrorText="实交增值税不能为空" onvalidation="onValidation"/></td> 
			
		</tr>
			<tr>
			<td ></td>
			<td id="payableaddedtax_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="paidaddedtax_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right"></td>	
			<td >利润净额:</td>
			 <td >
			 <input id="textbox48"  name="netprofit" class="mini-textbox" value="${cooperationdebt.netprofit}"
			 required="false" vtype="float" requiredErrorText="利润净额不能为空" style="width:90%"/>
			 </td> 
			
		</tr>
		</table>
	</div>
	</fieldset>
	</td>
	</tr>
	</table>
	</form>
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
	
		function submitForm() {           
			var form = new mini.Form("#form1");
			alert('ee');
		    form.validate();
			if (form.isValid() == false) return;
			$("form").submit();
		}
		function updateError(e) {
	    	var id = e.sender.name + "_error";
	        var el = document.getElementById(id);
	        if (el) {
	            el.innerHTML = e.errorText;
	        }
	    }
	   function updateError(e) {
	    	var id = e.sender.name + "_error";
	        var el = document.getElementById(id);
	        if (el) {
	            el.innerHTML = e.errorText;
	        }
	    }
	    function onValidation(e) {                  
	        updateError(e);
	    }
  </script>
</html>