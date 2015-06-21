<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户基本贷款信息</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<style type="text/css">
*{margin:0;padding:0;text-decoration:none}
.labelName{font-size:15px;font-weight:bold;color:darkgreen;}
.labelValue{font-size:15px;font-weight:bold;color:red;}
.topMenu{
	border:1px solid #8AD3E9;
    /* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
	endColorstr = 'white' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
	endColorstr = 'white' )"; 
}
#saveBtn{width:100px;height:25px;border:0;background:url(/bank/images/save.png) no-repeat}
#backBtn{width:100px;height:25px;border:0;background:url(/bank/images/back.png) no-repeat}
.required_text{
color:red
}
.errorText{
color:red
}
</style>
</head>
<body>
<div id ="form1">
<form  id="farmerLoan" name="farmerLoan" action="/bank/farmer/savePrivateLending.do" method="POST">
<input name="id" class="mini-hidden" value="${privateLending.id}"/>
<input name="farmerId" class="mini-hidden"  value="${farmer.id}" />
<input name="recorder" class="mini-hidden" value="管理员"/>
<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
<div class="topMenu" style="background:linear-gradient(#6DC8E3,white)">
<table cellpadding="0" cellspacing="0"  height="60px">
    <tr>
    	<td class="labelName" width="25%" align="right">姓名:</td>
    	<td width="2%"></td>
    	<td class="labelValue" width="8%">${farmer.farmerName }</td>
    	<td class="labelName" width="12%" align="right">证件号码:</td>
    	<td width="2%"></td>
    	<td class="labelValue" width ="20%">${farmer.farmerIdnum }</td>
    	<td width="50px" align="right">
       	 <input type="button" id="saveBtn" onclick="submitForm()" value=""/>
        </td>
        <td width="50px"  >
         <input type="button" id="backBtn" onclick="back()" value=""/>
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
		<td width="36%"><input name="amount" class="mini-textbox" value="${privateLending.amount}" style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="贷款金额不能为空" onvalidation="onValidation"/></td>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">月利率:</td>
		<td width="36%"><input  name="rate" class="mini-textbox"  value="${privateLending.rate}"  style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="利率不能为空" onvalidation="onValidation"/></td>	
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
		<td width="36%"><input name="lendingTime" class="mini-datepicker"   value="${privateLending.lendingTime}" style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="借贷时间不能为空" onvalidation="onValidation"/></td>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">到期时间:</td>
		<td width="36%"><input name="limitTime" class="mini-datepicker" value="${privateLending.limitTime}"  style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="到期时间不能为空" onvalidation="onValidation"/></td>	
	</tr>
	<tr>
		<td width="2%"></td>
		<td id="lendingTime_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="limitTime_error" class="errorText" colspan="2"></td>
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