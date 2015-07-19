<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="dt" uri="http://gov.jian.bank/dateformat" %>  
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户信用参保情况</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
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
<div id="form1" style="width:90%;margin:auto auto">
	<form action="/bank/farmer/saveCredit.do" method="POST">
	<input name="creditid" class="mini-hidden" value="${credit.creditid}"/>
	<input name="farmerid" class="mini-hidden"  value="${farmer.id}" />
	<input name="sourcecode" class="mini-hidden" value="${credit.sourcecode}"/>
	<input name="sourcename" class="mini-hidden"  value="${farmer.sourcename}" />
	<input name="runitid" class="mini-hidden" value="${credit.runitid}"/>
	<input name="runitname" class="mini-hidden"  value="${farmer.runitname}" />
	<input name="recorder" class="mini-hidden" value="${recorder}"/>
	<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
	<table border="0" cellpadding="1" cellspacing="15" width="100%" >
	<tr>
	<td colspan="4" style="width:100%">
	<fieldset id="fd2" style="width:100%;margin:auto auto">
	<legend><label>农户信用户基本信息</label></legend>
	<div class="fieldset-body">
	<table width="100%">
	<tr>
	<td class="required_text" width="2%">*</td>
	<td style="width:10%">信用户评定时间:</td>
	<td style="width:40%">
	<input name="assessdate" class="mini-datepicker" value="${dt:format(credit.assessdate,'yyyy-MM-dd')}" style="width:90%"
		errorMode="none" required="true"  requiredErrorText="信用户评定时间不能为空" onvalidation="onValidation" />
	</td>
	<td class="required_text" width="2%">*</td>
	<td style="width:10%">信用户级别:</td>
	<td style="width:40%" >
		<input name="assessrank" class="mini-combobox"  value="${credit.assessrank}" style="width:90%"
		errorMode="none" required="true" requiredErrorText="信用户级别不能为空" onvalidation="onValidation"
       	url="/bank/dic/CreditType.txt" emptyText="请选择..."/>
	</td>
	</tr>
	<tr>
	<td></td>
	<td id="assessdate_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="assessrank_error" class="errorText" colspan="2"></td>
</tr>
	<tr>
	<td class="required_text" width="2%">*</td>
	<td style="width:10%">信用户评定部门:</td>
	<td style="width:40%">
	<input name="assessorgan" class="mini-textarea"  value="${credit.assessorgan}"style="width:90%" 
		errorMode="none" required="true" requiredErrorText="信用户评定部门不能为空" onvalidation="onValidation" />
	</td>
	<td class="required_text" width="2%">*</td>
	<td style="width:10%">有效期限:</td>
	<td style="width:40%">
	<input name="timelimit" class="mini-datepicker"  value="${credit.timelimit}" style="width:90%" 
		required="true" errorMode="none" requiredErrorText="邻里团结情况不能为空" onvalidation="onValidation"/>
	</td>
	</tr>
	<tr>
	<td></td>
	<td id="assessorgan_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="timelimit_error" class="errorText" colspan="2"></td>
	</tr>
	</table>
	</div>
	</fieldset>
	</td>
	</tr>
	</table>
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