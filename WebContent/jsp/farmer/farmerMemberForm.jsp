<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户家庭成员信息</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
<div id ="form1">
<form action="/bank/farmer/saveMember.do" method="POST">
<input name="id" class="mini-hidden" value="${member.id}"/>
<input name="farmerid" class="mini-hidden"  value="${farmer.id}" />
<input name="farmeridnum" class="mini-hidden"  value="${farmer.farmeridnum}" />
<input name="sourcecode" class="mini-hidden"  value="${member.sourcecode}" />
<input name="sourcename" class="mini-hidden"  value="${member.sourcename}" />
<input name="runitid" class="mini-hidden"  value="${member.runitid}" />
<input name="runitname" class="mini-hidden"  value="${member.runitname}" />
<input name="recorder" class="mini-hidden" value="${recorder}"/>
<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
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
	<legend><label>家庭成员信息</label></legend>
	<div class="fieldset-body">
	<table width="100%" >
	<tr>
	<td class="required_text" width="2%" align="right">*</td>
	<td style="width:10%">家庭成员姓名:</td>
    <td style="width:39%">
    	<input name="name" class="mini-textbox" value="${member.name }" style="width:90%"
        errorMode="none" required="true" requiredErrorText="家庭成员姓名不能为空" onvalidation="onValidation"/>
    </td>
    <td class="required_text" width="2%" align="right">*</td>
    <td style="width:10%">与户主关系:</td>
    <td style="width:39%" >
       <input name="relation" class="mini-combobox"  value="${member.relation }" style="width:90%" 
       	errorMode="none" required="true" requiredErrorText="与户主关系不能为空" onvalidation="onValidation"
       	url="/bank/dic/Relation.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
	<td width="2%"></td>
	<td id="name_error" class="errorText" colspan="2"></td>
	<td width="2%"></td>
	<td id="relation_error" class="errorText" colspan="2"></td>
</tr>
<tr>
	<td class="required_text" width="2%" align="right">*</td>
	<td style="width:10%">身份证号:</td>
    <td style="width:39%">
    	<input name="idnum" class="mini-textbox" value="${member.idnum }" style="width:90%"
        errorMode="none" required="true"	 requiredErrorText="身份证号不能为空" onvalidation="onValidation   "/>
    </td>
    <td class="required_text" width="2%" align="right">*</td>
    <td style="width:10%">文化程度:</td>
    <td style="width:39%" >
    	<input name="education" class="mini-combobox" value="${member.education}" style="width:90%"
    	errorMode="none" required="true" requiredErrorText="文化程度不能为空" onvalidation="onValidation"
        url="/bank/dic/Education.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
		<td width="2%"></td>
		<td id="idnum_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="education_error" class="errorText" colspan="2"></td>
</tr>
<tr>
	<td class="required_text" width="2%" align="right">*</td>
	<td style="width:10%">性别:</td>
    <td style="width:39%" >
    	<input name="sex" class="mini-combobox" value="${member.sex }" style="width:90%"
       	 errorMode="none" required="true"  requiredErrorText="性别不能为空" onvalidation="onValidation"
         url="/bank/dic/Sex.txt" emptyText="请选择..."/>
   </td>
   <td class="required_text" width="2%" align="right">*</td>
	<td style="width:10%">婚姻状况:</td>
    <td style="width:39%">
	    <input name="marrystatus" class="mini-combobox" value="${member.marrystatus}" style="width:90%"
	     errorMode="none" required="true" requiredErrorText="婚姻状况不能为空" onvalidation="onValidation"
	     url="/bank/dic/MarryStatus.txt" emptyText="请选择..."/>
   </td>
</tr>
<tr>
		<td width="2%"></td>
		<td id="sex_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="marrystatus_error" class="errorText" colspan="2"></td>
</tr>
<tr>
   <td class="required_text" width="2%" align="right"></td>
   <td style="width:10%">职业:</td>
   <td style="width:39%" >
   		<input name="occupation" class="mini-textbox" value="${member.occupation}" style="width:90%"/>
   </td>
   <td class="required_text" width="2%" align="right"></td>
   <td style="width:10%">职务:</td>
   <td style="width:39%">
    	<input name="job" class="mini-textbox" value="${member.job }" style="width:90%"/>
    </td>
    
</tr>
<tr>
		<td width="2%"></td>
		<td id="occupation_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="job_error" class="errorText" colspan="2"></td>
</tr>
<tr>
	<td class="required_text" width="2%" align="right"></td>
	<td style="width:10%">联系电话:</td>
	<td style="width:39%">
    	<input  name="phone" class="mini-textbox" value="${member.phone}" style="width:90%"
         errorMode="none" required="false"  requiredErrorText="联系电话不能为空" onvalidation="onValidation" />
    </td>
    <td class="required_text" width="2%" align="right"></td>
    <td style="width:10%">地址:</td>
	<td style="width:39%">
    	<input  name="address" class="mini-textarea" value="${member.address}" style="width:90%"/>
    </td>
</tr>
<tr>
		<td width="2%"></td>
		<td id="phone_error" class="errorText" colspan="2"></td>
		<td width="2%"></td>
		<td id="address_error" class="errorText" colspan="2"></td>
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