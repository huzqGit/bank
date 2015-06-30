<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>林权信息</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
</head>
<body>
<div id="form1">
<form action="/bank/farmer/saveForest1.do"  method="POST">
<div class="queryPane">
	<table width="100%" cellpadding="0" cellspacing="0"  height="30px">
	    <tr>
	    	<td class="labelName" width="20%" align="right">姓名:</td>
	    	<td class="labelValue" width="10%">${farmer.farmername }</td>
	    	<td class="labelName" width="10%" align="right">证件号码:</td>
	    	<td class="labelValue" width ="10%">${farmer.farmeridnum }</td>
	    	<td width="10%" align="center">
	       	 <input type="button" class="bank-btn" onclick="submitForm()" value="保存"/>
	        </td>
	        <td width="30%"  >
	         <input type="button" class="bank-btn" onclick="back()" value="返回"/>
	        </td>
	    </tr>
	</table>
	</div>
	<fieldset style="width:90%;margin:auto auto">
	<legend><label>农户林权基本情况</label></legend>
	<div class="fieldset-body">
	<table width="100%"><tr><td>
	<input name="id" class="mini-hidden" value="${forest.id}"/>
	<input name="farmerid" class="mini-hidden" value="${farmer.id}" />
	<input name="recorder" class="mini-hidden" value="${recorder}"/>
	<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
	<table border="0" cellpadding="1" cellspacing="15" width="100%" >
	<tr><td style="width:100%">
	<table width="100%">
	<tr>
		<td class="required_text">*</td>
		<td width="15%">林权证编号:</td>
		<td width="33%">
			<input name="cardnum" class="mini-textbox" value="${forest.cardnum}" style="width:90%"
				errorMode="none" required="true" requiredErrorText="林权证号不能为空!" onvalidation="onValidation"/>
		</td>
	    <td class="required_text">*</td>
	    <td width="15%">林权字号:</td>
	    <td width="33%" >
	    	<input name="wordnum" class="mini-textbox" value="${forest.wordnum}" style="width:90%"
	    		errorMode="none" required="true" requiredErrorText="林权字号不能为空!" onvalidation="onValidation"/>
	    </td>
	</tr>
	<tr >
		<td ></td>
		<td colspan="2" id="cardnum_error" class="errorText"></td>
		<td ></td>
		<td colspan="2" id="wordnum_error" class="errorText"></td>
	</tr>
	<tr>
		<td class="required_text">*</td>
		<td >林权使用人:</td>
	    <td >
	    ${forest.user}<h1>22</h1>
	    	<input name="user" class="mini-textbox" value="${forest.user}" style="width:90%"
	    		errorMode="none" required="true" requiredErrorText="林权使用人不能为空!" onvalidation="onValidation"/>
	    </td>
	    <td class="required_text">*</td>
	    <td >林权使用种类:</td>
	    <td >
	        <input id="usetype" name="useType" class="mini-combobox" value="${forest.usetype}" 
	        	errorMode="none" required="true" requiredErrorText="林权使用种类不能为空" style="width:90%"
	        	url="/bank/dic/ForestType.txt" emptyText="请选择..."/>
	    </td>
	</tr>
	<tr >
		<td ></td>
		<td colspan="2" id="user_error" class="errorText"></td>
		<td ></td>
		<td colspan="2" id="useType_error" class="errorText"></td>
	</tr>
	<tr>
		<td class="required_text">*</td>
		<td >面积(亩):</td>
		<td >
			<input name="area" class="mini-textbox" value="${forest.area}" style="width:90%"
				errorMode="none" vtype="float" required="true" requiredErrorText="面积不能为空!" onvalidation="onValidation"/>
			</td>
		<td class="required_text"></td>
	    <td >蓄积量:</td>
	    <td >
	    	<input name="storenum" class="mini-textbox" value="${forest.storenum}" style="width:90%"
	    	errorMode="none" vtype="float" onvalidation="onValidation"/>
	    </td>
	</tr>
	<tr >
		<td ></td>
		<td colspan="2" id="area_error" class="errorText"></td>
		<td ></td>
		<td colspan="2" id="storenum_error" class="errorText"></td>
	</tr>
	<tr>
		<td class="required_text"></td>
		<td >使用权期限(年):</td>
	    <td >
	   		<input name="timelimit" class="mini-textbox" value="${forest.timelimit}" style="width:90%"
	   			errorMode="none" vtype="float" onvalidation="onValidation"/>
	    </td>
	    <td class="required_text"></td>
	    <td >当前评估价格(元):</td>
	    <td >
	    	<input name="assessprice"  class="mini-textbox" value="${forest.assessprice}" style="width:90%"
	    		errorMode="none" vtype="float" onvalidation="onValidation"//>
	    </td>
	</tr>
	<tr >
		<td ></td>
		<td colspan="2" id="timeLimit_error" class="errorText"></td>
		<td ></td>
		<td colspan="2" id="assessprice_error" class="errorText"></td>
	</tr>
	</table>
	</td></tr>
	</table>
	</td></tr>
	</table>
	</div>
	</fieldset>
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