<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="dt" uri="http://gov.jian.bank/dateformat" %>   
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户基本贷款信息</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<style type="text/css">
*{margin:0;padding:0;text-decoration:none}
</style>
</head>
<body>
<div id="form1">
<form action="/bank/farmer/saveInsured1.do" method="POST">
<input name="id" class="mini-hidden" value="${insured.id}"/>
<input name="farmerid" class="mini-hidden" value="${farmer.id}"/>
<input name="farmeridnum" class="mini-hidden" value="${farmer.farmeridnum}"/>
<input name="sourcecode" class="mini-hidden" value="${insured.sourcecode}"/>
<input name="sourcename" class="mini-hidden" value="${insured.sourcename}"/>
<input name="runitid" class="mini-hidden" value="${insured.runitid}"/>
<input name="runitname" class="mini-hidden" value="${insured.runitname}"/>
<input name="recorder" class="mini-hidden" value="${recorder}"/>
<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
<div class="queryPane">
<table cellpadding="0" cellspacing="0"  height="30px">
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
<fieldset style="width:100%;margin:auto auto">
<legend><label>农户参保情况</label></legend>
<div class="fieldset-body">
<table width="100%" >
<tr><td>
<table border="0" cellpadding="1" cellspacing="15" width="100%">
<tr><td>
<table width="100%">
<tr>
	<td class="required_text" width="2%">*</td>
	<td style="width:10%">参加保险种类:</td>
	<td style="width:38%" >
		<input name="type" class="mini-combobox"  value="${insured.type}" style="width:90%"
			errorMode="none" required="true" requiredErrorText="参加保险种类不能为空" onvalidation="onValidation"
			url="/bank/dic/InsuredType.txt" emptyText="请选择..."/>
	</td>
	<td class="required_text" width="2%">*</td>
	<td style="width:10%">保险金额(元):</td>
	<td style="width:38%">
		<input name="amount" class="mini-textbox"  value="${insured.amount}" style="width:90%" 
		errorMode="none" vtype="float" required="true" requiredErrorText="保险金额不能为空" onvalidation="onValidation">
	</td>
</tr>
<tr>
	<td></td>
	<td id="type_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="amount_error" class="errorText" colspan="2"></td>
</tr>
<tr>
	<td class="required_text" width="2%">*</td>	
	<td style="width:10%">参保时间:</td>
	<td style="width:38%">
		<input name="insuretime" class="mini-datepicker" value="${dt:format(insured.insuretime,'yyyy-MM-dd')}" style="width:90%"
			errorMode="none" required="true" requiredErrorText="参保时间不能为空"onvalidation="onValidation" />
	</td>
	<td class="required_text" width="2%">*</td>
	<td>参保到期日:</td>
	<td>
		<input name="limittime" class="mini-datepicker" value="${dt:format(insured.limittime,'yyyy-MM-dd')}" style="width:90%"
			errorMode="none" required="true" requiredErrorText="参保到期日不能为空" onvalidation="onValidation"/>
	</td>
</tr>
<tr>
	<td></td>
	<td id="insuretime_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="limittime_error" class="errorText" colspan="2"></td>
</tr>
</table>
</td></tr>
<tr>
</table>
</td></tr>
</table>
</div>
</fieldset>
</div>
</form>
</div>
<script type="text/javascript">
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