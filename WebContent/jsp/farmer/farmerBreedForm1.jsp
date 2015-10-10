<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
</head>
<body>
<div id="form1">
<form  action="/bank/farmer/saveBreed1.do" method="POST">
<div class="queryPane">
<table width="100%" cellpadding="0" cellspacing="0" height="30px">
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
<legend><label>农户种养殖基本情况</label></legend>
<div class="fieldset-body">
<table width="100%" >
<tr><td style="width:100%">
<input name="id" class="mini-hidden" value="${breed.id}"/>
<input name="farmerid" class="mini-hidden" value="${farmer.id}" />
<input name="farmeridnum" class="mini-hidden" value="${farmer.farmeridnum}" />
<input name="sourcecode" class="mini-hidden" value="${breed.sourcecode}" />
<input name="sourcename" class="mini-hidden" value="${breed.sourcename}" />
<input name="runitid" class="mini-hidden" value="${breed.runitid}" />
<input name="runitname" class="mini-hidden" value="${breed.runitname}" />
<input name="recorder" class="mini-hidden" value="${recorder}"/>
<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr><td style="width:100%">
<table width="100%">
<tr>
	<td class="required_text" width="2%">*</td>
	<td style="width:15%">种养殖品种:</td>
    <td style="width:33%">
    	<input name="variety" class="mini-combobox" value="${breed.variety}" style="width:90%"
    	 	errorMode="none" required="true"  requiredErrorText="种养殖品种不能为空" url="/bank/dic/BreedType.txt"
    	 	 emptyText="请选择..." onvalidation="onValidation"/>
    </td>
    <td class="required_text" width="2%">*</td>
    <td style="width:15%">年产量(或出栏量):</td>
    <td style="width:33%" >
    	<input  name="output" class="mini-textbox"  value="${breed.output}" style="width:90%"
    		errorMode="none"  vtype="float" required="true"  requiredErrorText="年产量(或年出栏量)不能为空" onvalidation="onValidation" />
    </td>
</tr>
<tr>
	<td></td>
	<td id="variety_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="output_error" class="errorText" colspan="2"></td>
</tr>
<tr>
	<td class="required_text">*</td>
	<td>占地面积(平方米 )</td>
    <td >
    	<input name="floorarea" class="mini-textbox" value="${breed.floorarea}" style="width:90%"
    		errorMode="none"  vtype="float" required="true" requiredErrorText="占地不能为空!" onvalidation="onValidation"/>
    </td>
    <td class="required_text">*</td>
    <td>年平均产值(元)</td>
    <td >
    	<input  name="outputvalue" class="mini-textbox" value="${breed.outputvalue}" style="width:90%"
    		errorMode="none"  vtype="float" required="true" requiredErrorText="年平均产值不能为空!" onvalidation="onValidation"/>
    </td>
</tr>
<tr>
	<td></td>
	<td id="floorarea_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="outputvalue_error" class="errorText" colspan="2"></td>
</tr>
<tr>
	<td class="required_text"></td>
    <td>当前评估价格(元):</td>
    <td >
    	<input name="assessprice" class="mini-textbox" value="${breed.assessprice}" style="width:90%"
    		errorMode="none" vtype="float" onvalidation="onValidation"/>
    </td>
</tr>
<tr>
	<td></td>
	<td id="assessprice_error" class="errorText" colspan="2"></td>
</tr>
</table>
</td></tr></table>
</td></tr></table>
</div>
</fieldset>
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