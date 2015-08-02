<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>农户基本贷款信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
<div id ="form1">
<form  id="farmerLoan" name="farmerLoan" action="/bank/farmer/savePrivateLending.do" method="POST">
<input name="id" class="mini-hidden" value="${privateLending.id}"/>
<input name="farmerid" class="mini-hidden"  value="${farmer.id}" />
<input name="farmeridnum" class="mini-hidden"  value="${farmer.farmeridnum}" />
<input name="recorder" class="mini-hidden" value="${recorder}"/>
<input name="recordtime" class="mini-hidden" value="${currenttime}"/>
<div class="queryPane">
<table width="100%" cellpadding="0" cellspacing="0"  height="30px">
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
	<legend><label>农户民间借贷信息</label></legend>
	<div class="fieldset-body">
	<table width="100%" >
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">贷款金额:</td>
		<td width="36%">
			<input name="amount" class="mini-textbox" value="${privateLending.amount}" style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="贷款金额不能为空" onvalidation="onValidation"/>
		</td>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">月利率:</td>
		<td width="36%">
			<input  name="rate" class="mini-textbox"  value="${privateLending.rate}"  style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="利率不能为空" onvalidation="onValidation"/>
		</td>	
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="amount_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="rate_error" class="errorText" colspan="2"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">借贷时间:</td>
		<td width="36%"><input name="lendingtime" class="mini-datepicker"   value="${privateLending.lendingtime}" style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="借贷时间不能为空" onvalidation="onValidation"/></td>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">到期时间:</td>
		<td width="36%"><input name="limittime" class="mini-datepicker" value="${privateLending.limittime}"  style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="到期时间不能为空" onvalidation="onValidation"/></td>	
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="lendingtime_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="limittime_error" class="errorText" colspan="2"></td>
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
		$("#farmerLoan").submit();
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