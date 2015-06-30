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
<input name="clientnum" class="mini-hidden" value="${clientnum}"/>
<input name="noteNum" class="mini-hidden" value="${noteNum}"/>
<input name="businessbody" class="mini-hidden"  value="${loan.businessbody}"/>
<input name="clienttype" class="mini-hidden" value="1"/>
<input name="recorder" class="mini-hidden" value="${recorder}"/>
<input name="idtype" class="mini-hidden" value="${loan.idtype}">
<input name="recordtime" class="mini-hidden" value="${currenttime}"/>
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
			<input name="organname" class="mini-textbox" value="${loan.organname}" style="width:96%"
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
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="loandate_error" class="errorText" colspan="5"></td>
	</tr>
	<tr>
		<td class="required_text" >*</td>
		<td >到期日期:</td>
		<td >
			<input name="limitdate" class="mini-datepicker" value="${loan.limitdate}" style="width:90%"
			errorMode="none" required="true"  requiredErrorText="到期日期不能为空" onvalidation="onValidation"/>
		</td>
		<td class="required_text" ></td>
		<td >原到期日期:</td>
		<td >
			<input name="limitdate1" class="mini-datepicker" value="${loan.limitdate1}" style="width:90%"
			errorMode="none" required="true"  requiredErrorText="原到期日期不能为空" onvalidation="onValidation"/>
		</td>
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
		<td class="required_text" ></td>
		<td >结欠利息:</td>
		<td >
			<input name="oweinterest" class="mini-textbox" value="${loan.oweinterest}" style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="balance_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="oweinterest_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" ></td>
		<td >当前利率:</td>
		<td >
			<input name="currentrate"  class="mini-textbox" value="${loan.currentrate}" style="width:90%"/>
		</td>
		<td class="required_text" ></td>
		<td >利率类型:</td>
		<td >
			<input name="ratetype" class="mini-textbox" value="${loan.ratetype}" style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="currentrate_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="ratetype_error" class="errorText" colspan="2"></td>
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
	<tr>
		<td class="required_text" >*</td>
		<td ><label for="textbox1$text">贷款五级分类形态:</label></td>
		<td >
		<input name="grade" class="mini-combobox" value="${loan.grade}" style="width:90%"
			errorMode="none" required="true"  requiredErrorText="贷款五级分类形态不能为空" onvalidation="onValidation"
			url="/bank/dic/FiveGrade.txt"/>
		</td>
		<td class="required_text" ></td>
		<td >结息方式:</td>
		<td >
		<input name="settletype" class="mini-combobox" value="${loan.settletype}" style="width:90%"
			url="/bank/dic/SettleType.txt" emptyText="请选择"/>
		</td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="grade_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="settletype_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" ></td>
		<td >贷款发放类型:</td>
		<td ><input name="providetype" class="mini-textbox" value="${loan.providetype}" style="width:90%"/></td>
		<td class="required_text" ></td>
		<td ><label for="textbox1$text">贷款投向:</label></td>
		<td ><input name="invest" class="mini-textbox" value="${loan.invest}" style="width:90%"/></td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="grade_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="settletype_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" ></td>
		<td >贷款期限种类:</td>
		<td ><input name="termtype" class="mini-textbox"  value="${loan.termtype}" style="width:90%"/></td>
		<td class="required_text" width="1%" align="right"></td>
		<td >利率浮动范围:</td>
		<td ><input name="floatscope" class="mini-textbox" value="${loan.floatscope}" style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="termtype_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="floatscope_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" ></td>
		<td >利率调整方式:</td>
		<td >
		<input name="adjusttype" class="mini-textbox" value="${loan.adjusttype}" style="width:90%"/>
		</td>
		<td class="required_text" ></td>
		<td >利率执行方式:</td>
		<td >
		<input name="runtype" class="mini-combobox" value="${loan.runtype}" style="width:90%"
			url="/bank/dic/RunType.txt"/>
		</td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="adjusttype_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="runtype_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" ></td>
		<td >还款频率:</td>
		<td >
			<input name="frequeency" class="mini-textbox" value="${loan.frequeency}" style="width:90%"/>
		</td>
		<td class="required_text"></td>
		<td >联系电话:</td>
		<td  >
			<input name="phone" class="mini-textbox" value="${loan.phone}" style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="frequeency_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="phone_error" class="errorText" colspan="2"></td>
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