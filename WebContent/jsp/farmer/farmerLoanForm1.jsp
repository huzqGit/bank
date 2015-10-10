<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户基本贷款信息</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
<div id ="form1">
<form  id="farmerLoan" name="farmerLoan" action="/bank/loan/saveLoan1.do" method="POST">
<input name="id" class="mini-hidden" value="${loan.id}"/>
<input name="farmerid" class="mini-hidden"  value="${farmer.id}" />
<input name="clientname" class="mini-hidden" value="${farmer.farmername}"/>
<input name="idnum" class="mini-hidden" value="${farmer.farmeridnum}"/>
<input name="sourcecode" class="mini-hidden" value="${loan.sourcecode}"/>
<input name="sourcename" class="mini-hidden" value="${loan.sourcename}"/>
<input name="runitid" class="mini-hidden" value="${loan.runitid}"/>
<input name="runitname" class="mini-hidden" value="${loan.runitname}"/>
<input name="clientnum" class="mini-hidden" value="${clientnum}"/>
<input name="noteNum" class="mini-hidden" value="${noteNum}"/>
<input name="businessbody" class="mini-hidden"  value="${loan.businessbody}"/>
<input name="clienttype" class="mini-hidden" value="1"/>
<input name="recorder" class="mini-hidden" value="${recorder}"/>
<input name="idtype" class="mini-hidden" value="${loan.idtype}">
<input name="recordtime" class="mini-hidden" value="${currenttime}"/>
<input name="providetype" class="mini-hidden" value="${loan.providetype}"/>
<input name="invest" class="mini-hidden" value="${loan.invest}" />
<input name="termtype" class="mini-hidden"  value="${loan.termtype}"/>
<input name="floatscope" class="mini-hidden" value="${loan.floatscope}"/>
<input name="adjusttype" class="mini-hidden" value="${loan.adjusttype}"/>
<input name="runtype" class="mini-hidden" value="${loan.runtype}"/>
<input name="frequeency" class="mini-hidden" value="${loan.frequeency}"/>
<input name="phone" class="mini-hidden" value="${loan.phone}"/>
<input name="settletype" class="mini-hidden" value="${loan.settletype}"/>
<input name="ratetype" class="mini-hidden" value="${loan.ratetype}"/>
<input name="currentrate"  class="mini-hidden" value="${loan.currentrate}"/>
<input name="oweinterest" class="mini-hidden" value="${loan.oweinterest}"/>
<input name="limitdate1" class="mini-hidden" value="${loan.limitdate1}"/>
<div class="queryPane">
<table width="100%" cellpadding="0" cellspacing="0"  height="60px">
    <tr>
    	<td class="labelName" width="30%" align="right">姓名</td>
    	<td class="labelValue" width="10%">:${farmer.farmername }</td>
    	<td class="labelName" width="10%" align="right">证件号码</td>
    	<td class="labelValue" width ="10%">:${farmer.farmeridnum }</td>
    	<td width="10%" align="center">
       		<input type="button" class="bank-btn" onclick="submitForm()" value="保存"/>
        </td>
        <td width="30%" align="left" >
         	<input type="button" class="bank-btn" onclick="back()" value="返回"/>
        </td>
    </tr>
</table>
</div>
<div style="width:90%;margin:auto auto">
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr>
	<td colspan="4" style="width:100%">
	<fieldset id="fd2" style="width:100%;margin:auto auto">
	<legend><label>农户基本概况信息</label></legend>
	<div class="fieldset-body">
	<table width="100%">
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="13%">机构号:</td>
		<td width="35%">
			<input name="organcode" class="mini-textbox" value="${loan.organcode}" style="width:90%"
			errorMode="none" required="true"  requiredErrorText="机构号不能为空" onvalidation="onValidation"/>
		</td>
		<td class="required_text" width="2%">*</td>
		<td width="13%">机构名称:</td>
		<td width="35%">
			<input name="organname" class="mini-textbox" value="${loan.organname}" style="width:90%"
			errorMode="none" required="true"  requiredErrorText="机构名称不能为空" onvalidation="onValidation"/>
		</td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="organcode_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="organname_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" >*</td>
		<td>借据号:</td>
		<td>
			<input name="notenum" class="mini-textbox" value="${loan.notenum}" style="width:90%"
			errorMode="none" required="true"  requiredErrorText="借据号不能为空" onvalidation="onValidation"/>
		</td>
		<td class="required_text">*</td>
		<td>合同号:</td>
		<td>
		<input name="compactnum"class="mini-textbox"  value="${loan.compactnum}"  style="width:90%"
		errorMode="none" required="true"  requiredErrorText="合同号不能为空" onvalidation="onValidation"/>
		</td>	
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="notenum_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="compactnum_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text">*</td>
		<td >业务种类:</td>
		<td >
			<input name="businesstype" class="mini-treeselect" value="${loan.businesstype}" style="width:90%"
			url="/bank/dic/BusinessType.txt" multiSelect="false"  valueFromSelect="false"
	        textField="text" valueField="id" parentField="pid" value="control"  allowInput="true"showFolderCheckBox="false"/>
		</td>
		<td class="required_text" >*</td>
		<td >担保方式:</td>
		<td >
		<input name="guaranteetype" class="mini-combobox" value="${loan.guaranteetype}" style="width:90%"
			errorMode="none" required="true"  requiredErrorText="担保方式不能为空" onvalidation="onValidation"
			url="/bank/dic/EnsureType.txt" emptyText="请选择"/>
		</td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="businesstype_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="guaranteetype_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" >*</td>
		<td >贷款日期</td>
		<td  >
			<input name="loandate" class="mini-datepicker" value="${loan.loandate}" style="width:90%"
			errorMode="none" required="true"  requiredErrorText="贷款日期不能为空" onvalidation="onValidation"/>
		</td>
		<td class="required_text" >*</td>
		<td >到期日期:</td>
		<td >
			<input name="limitdate" class="mini-datepicker" value="${loan.limitdate}" style="width:90%"
			errorMode="none" required="true"  requiredErrorText="到期日期不能为空" onvalidation="onValidation"/>
		</td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="loandate_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="limitdate_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="limitdate_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="limitdate1_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>	
		<td class="required_text" >*</td>
		<td >币种:</td>
		<td >
			<input name="currency" class="mini-combobox" value="${loan.currency}" style="width:90%" 
				url="/bank/dic/Currency.txt" emptyText="请选择"/>
		</td>
		<td class="required_text" width="1%" align="right">*</td>
		<td >贷款金额(元):</td>
		<td >
			<input name="amount" class="mini-textbox" style="width:90%" value="${loan.amount}"
			errorMode="none" required="true"  requiredErrorText="贷款金额不能为空" onvalidation="onValidation"/>
		</td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="currency_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="amount_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" >*</td>
		<td >贷款余额(元):</td>
		<td >
			<input name="balance" class="mini-textbox" value="${loan.balance}" style="width:90%"
			errorMode="none" required="true"  requiredErrorText="贷款余额不能为空" onvalidation="onValidation"/>
		</td>
		<td class="required_text" >*</td>
		<td >贷款五级分类形态:</td>
		<td >
		<input name="grade" class="mini-combobox" value="${loan.grade}" style="width:90%"
			errorMode="none" required="true"  requiredErrorText="贷款五级分类形态不能为空" onvalidation="onValidation"
			url="/bank/dic/FiveGrade.txt"/>
		</td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="balance_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="grade_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" >*</td>
		<td >贷款用途:</td>
		<td colspan="4" style="width:88%">
			<input name="loanuse"  class="mini-textbox"value="${loan.loanuse}" style="width:96%"/>
		</td>
	</tr>
		<tr>
		<td width="2%"></td>
		<td id="loanuse_error" class="errorText" colspan="5"></td>
	</tr>
	</table>
	</div>
	</fieldset>
	</td>
	</tr>
	</table>
</div>
</form>
</div>
<script type="text/javascript">
mini.parse();
function back(){
	history.go(-1);
}
function submitForm() {           
	var form = new mini.Form("#form1");
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
function onValidation(e) {                  
    updateError(e);
}
</script>
</body>
</html>