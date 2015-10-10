<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="dt" uri="http://gov.jian.bank/dateformat" %>
<%@ include file="../common/CurrentTime.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<style type="text/css">
	*{margin:0;padding:0;text-decoration:none}
	body{
overflow-x:hidden
}
 </style>
</head>
<body>
<div id="form1">
<form action="/bank/farmer/saveCompunish1.do" method="POST">
<input name="id" class="mini-hidden" value="${compunish.id}"/>
<input name="farmerid" class="mini-hidden" value="${farmer.id}"/>
<input name="farmeridnum" class="mini-hidden"  value="${farmer.farmeridnum}" />
<input name="sourcecode" class="mini-hidden"  value="${compunish.sourcecode}" />
<input name="sourcename" class="mini-hidden"  value="${compunish.sourcename}" />
<input name="runitid" class="mini-hidden"  value="${compunish.runitid}" />
<input name="runitname" class="mini-hidden"  value="${compunish.runitname}" />
<input name="recorder" class="mini-hidden" value="${recorder}"/>
<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
<div class="queryPane" >
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
<fieldset style="width:90%;margin:auto auto">
<legend><label>农户受表彰与处罚情况基本情况</label></legend>
<div class="fieldset-body">
<table width="100%">
<tr>
<td>
<table border="0" cellpadding="1" cellspacing="5" width="100%" ><tr><td width="100%">
<table width="100%">
<tr>
	<td class="required_text" width="2%">*</td>
	<td style="width:15%">表彰或处罚:</td>
    <td style="width:33%">
    	<input name="type" class="mini-combobox"  value="${compunish.type}" style="width:90%" 
    		 errorMode="none" required="true" requiredErrorText="表彰或处罚类型不能为空" onvalidation="onValidation"
    		url="/bank/dic/CompunishType.txt" emptyText="请选择..."/>
    </td>
    <td class="required_text" width="2%">*</td>
	<td style="width:15%">表彰或处罚部门:</td>
    <td style="width:35%">
    	<input name="organ" class="mini-textbox"  value="${compunish.organ}" required="true"
        	 errorMode="none" requiredErrorText="表彰或处罚部门不能为空"style="width:90%"onvalidation="onValidation"/>
    </td>
</tr>
<tr>
	<td></td>
	<td id="type_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="organ_error" class="errorText" colspan="2"></td>
</tr>
<tr>
	<td class="required_text" width="2%">*</td>
	<td>表彰或处罚时间:</td>
    <td>
       <input  name="occurtime" class="mini-datepicker" value="${dt:format(compunish.occurtime,'yyyy-MM-dd')}" style="width:90%"
       errorMode="none" required="true" requiredErrorText="表彰或处罚时间不能为空" onvalidation="onValidation"
       url="/bank/dic/CompunishType.txt" emptyText="请选择..."/>
    </td>
    <td class="required_text" width="2%">*</td>
	<td>表彰或处罚等级:</td>
    <td>
       <input  name="compunishlevel" class="mini-combobox" value="${compunish.compunishlevel}" style="width:90%"
       errorMode="none" required="true" requiredErrorText="表彰或处罚等级不能为空" onvalidation="onValidation"
       url="/bank/dic/CompunishLevel.txt" emptyText="请选择..."/>
    </td>       
</tr>
<tr>
	<td></td>
	<td id="occurtime_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="compunishlevel_error" class="errorText" colspan="2"></td>
</tr>
<tr>
    <td class="required_text" width="2%">*</td>
	<td>表彰或处罚内容:</td>
    <td>
    <input name="detail" class="mini-textarea" value="${compunish.detail}"style="width:90%"
     errorMode="none" required="true" requiredErrorText="表彰或处罚内容不能为空" onvalidation="onValidation"/>
   </td>   
</tr>
<tr>
	<td></td>
	<td id="detail_error" class="errorText" colspan="2"></td>
</tr>
</table>
</td></tr></table>
</td>
</tr>
<tr>
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