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
</style>
</head>
<body>
<div id="form1">
<form action="/bank/farmer/saveInsured1.do" method="POST">
<input name="id" class="mini-hidden" value="${insured.id}"/>
<input name="farmerid" class="mini-hidden" value="${farmer.id}"/>
<input name="recorder" class="mini-hidden" value="${recorder}"/>
<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
<div class="topMenu" style="background:linear-gradient(#6DC8E3,white)">
<table cellpadding="0" cellspacing="0"  height="60px">
    <tr>
    	<td class="labelName" width="25%" align="right">姓名:</td>
    	<td width="2%"></td>
    	<td class="labelValue" width="8%">${farmer.farmername }</td>
    	<td class="labelName" width="12%" align="right">证件号码:</td>
    	<td width="2%"></td>
    	<td class="labelValue" width ="20%">${farmer.farmeridnum }</td>
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
		<input name="insuretime" class="mini-datepicker" value="${insured.insuretime}" style="width:90%"
			errorMode="none" required="true" requiredErrorText="参保时间不能为空"onvalidation="onValidation" />
	</td>
	<td class="required_text" width="2%">*</td>
	<td>参保到期日:</td>
	<td>
		<input name="limittime" class="mini-datepicker" value="${insured.limittime}" style="width:90%"
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