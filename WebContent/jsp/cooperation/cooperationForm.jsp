<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="dt" uri="http://gov.jian.bank/dateformat" %>  
<%@ page import="com.bank.beans.User"%> 
<%@ page import="com.bank.Constants"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
	//System.out.println(user.getUserName());
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农民专业合作经济组织基本概况信息</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
<div class="topMenu">
	<ul>
		<li class="active">
			基本信息
		</li>
		<li class="inactive">
			<a href="/bank/economy/debt/queryCooperation.do?businesslicence=${cooperation.businesslicence}&sourcecode=${cooperation.sourcecode}">资产负债信息</a>
		</li>
	</ul>
</div>
<div id="form1" style="width:97%;margin:auto auto;padding-top:25px">
	<form action="/bank/economy/saveCooperation1.do" method="POST">
		<input name="id" class="mini-hidden" value="${cooperation.id}"/>
		<input name="cooperationname" class="mini-hidden" value="${cooperation.cooperationname}"/>
		<input name="recorder" class="mini-hidden" value="<%=user.getUserName()%>"/>
		<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
	<div >
		<table style="width:100%;height:30px">
			<tr>
				<td class="labelName" width="20%" align="right">经济合作组织名称</td>
				<td class="labelValue" width="20%">:${cooperation.cooperationname}</td>
				<td class="labelName" width="20%" align="right">营业执照</td>
				<td class="labelValue" align="right" width="10%">:${cooperation.businesslicence}</td>
		    	<td width="30" align="center">
		       		<input type="button" id="saveBtn" class="bank-btn" onclick="submitForm()" value="保存"/>
		        </td>
			</tr>
		</table>
	</div>
	<div style="width:90%;margin:auto auto">
	<table border="0" cellpadding="1" cellspacing="15" width="100%" >
		<tr>
		<td colspan="4" style="width:100%">
		<fieldset id="fd2" style="width:100%;margin:auto auto">
		<legend><label>农民专业合作经济组织信息</label></legend>
		<div class="fieldset-body">
		<table width="100%">
		<tr>
			<td class="required_text" width="2%" align="right">*</td>
			<td style="width:15%">营业执照:</td>
			<td style="width:33%">
			<input name="businesslicence" class="mini-textbox"  value="${cooperation.businesslicence}" style="width:90%"
				required="true" errorMode="none" onvalidation="updateError" requiredErrorText="营业执照不能为空"  />
			</td>
		<td class="required_text" width="2%" align="right"></td>
			<td style="width:15%">组织机构编码:</td>
			<td style="width:33%">
			<input name="organcode" class="mini-textbox"  value="${cooperation.organcode}" style="width:90%"
				required="false" errorMode="none" onvalidation="updateError" requiredErrorText="营业执照不能为空"  />
			</td>
		</tr>
		<tr>
			<td class="required_text" width="2%" align="right">*</td>
			<td >税务登记号:</td>
			<td >
			<input  name="taxcode" class="mini-textbox"  value="${cooperation.taxcode}" style="width:90%"
				errorMode="none" required="true" requiredErrorText="税务登记号不能为空" onvalidation="onValidation"/>
			</td>
			<td class="required_text" width="2%" align="right">*</td>
			<td >注册时间:</td>
			<td >
			<input  name="registerdate" class="mini-datepicker"  value="${dt:format(cooperation.registerdate,'yyyy-MM-dd')}" style="width:90%" 
				errorMode="none" required="true" requiredErrorText="注册时间不能为空" onvalidation="onValidation"/>
			</td>
		</tr>
		<tr>
			<td ></td>
			<td id="taxcode_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="registerdate_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text"  align="right">*</td>
			<td >注册地址:</td>
			<td  >
			<input   name="registeraddress" class="mini-textarea" value="${cooperation.registeraddress}" style="width:90%" 
				errorMode="none" required="true" requiredErrorText="注册地址不能为空" onvalidation="onValidation"/>
			</td>
			<td class="required_text"  align="right"></td>
			<td >通信地址:</td>
			<td >
			<input  name="mailaddress" class="mini-textarea"  value="${cooperation.mailaddress}" style="width:90%"
				errorMode="none" required="false" requiredErrorText="通信地址不能为空"  onvalidation="onValidation"/>
			</td>
		</tr>
		<tr>
			<td ></td>
			<td id="registeraddress_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="mailaddress_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text"  align="right">*</td>
			<td >注册资金:</td>
			<td >
			<input   name="registercapital" class="mini-textbox"value="${cooperation.registercapital}" style="width:90%"
				errorMode="none" vtype="float" required="true"  requiredErrorText="注册资金不能为空" onvalidation="onValidation"/>
			</td>
			<td class="required_text"  align="right">*</td>
			<td >实收资金:</td>
			<td >
			<input   name="realcapital" class="mini-textbox"  value="${cooperation.realcapital}" style="width:90%"
				errorMode="none" vtype="float" required="true"  requiredErrorText="实收资金不能为空" onvalidation="onValidation"/>
			</td>
		</tr>
		<tr>
			<td ></td>
			<td id="registercapital_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="realcapital_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text"  align="right">*</td>
			<td >法定代表人:</td>
			<td >
			<input   name="legalperson" class="mini-textbox" value="${cooperation.legalperson}" style="width:90%"
				errorMode="none" required="true" requiredErrorText="法定代表人不能为空" onvalidation="onValidation" />
			</td>
			<td class="required_text"  align="right">*</td>
			<td >身份证号:</td>
			<td >
			<input   name="idnum" class="mini-textbox"  value="${cooperation.idnum}" style="width:90%"
				errorMode="none" required="true" requiredErrorText="身份证号不能为空" onvalidation="onValidation"/>
			</td>
		</tr>
		<tr>
			<td ></td>
			<td id="legalperson_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="idnum_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text"  align="right">*</td>
			<td >联系电话号码:</td> 
			<td >
			<input name="phone" class="mini-textbox"  value="${cooperation.phone}" style="width:90%" 
				errorMode="none" required="false" requiredErrorText="联系电话号码不能为空" onvalidation="onValidation"/>
			</td>
			<td class="phone_text"  align="right">*</td>
			<td >社员人数:</td>
			<td >
			<input   name="members" class="mini-textbox" required="false" value="${cooperation.members}"
				errorMode="none" requiredErrorText="社员人数不能为空" style="width:90%"/>
			</td>
		</tr>
		<tr>
			<td ></td>
			<td id="phone_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="members_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text"  align="right">*</td>
			<td >经营范围:</td>
			<td >
			<input   name="businesscope" class="mini-textbox"  value="${cooperation.businesscope}" style="width:90%"
				errorMode="none" required="false"  requiredErrorText="经营范围不能为空"  onvalidation="onValidation"/>
			</td>
			<td class="required_text"  align="right">*</td>
			<td >经营场地面积(平方米):</td>
			<td >
			<input   name="businessarea" class="mini-textbox" value="${cooperation.businessarea}" style="width:90%"
				vtype="float"  errorMode="none"  required="false" requiredErrorText="社员人数不能为空" onvalidation="onValidation"/>
			</td>
		</tr>
		<tr>
			<td ></td>
			<td id="businesscope_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="businessarea_error" class="errorText" colspan="2"></td>
		</tr>
		<tr>
			<td class="required_text"  align="right"></td>
			<td >带动农户（户）:</td>
			<td >
			<input   name="farmers" class="mini-textbox"  value="${cooperation.farmers}"
				vtype="float" errorMode="none" requiredErrorText="带动农户不能为空" style="width:90%"/>
			</td>
			<td class="required_text"  align="right"></td>
			<td >联接基地（亩）:</td>
			<td >
			<input  name="connectionbase" class="mini-textbox"  value="${cooperation.connectionbase}" style="width:90%"
				vtype="float" errorMode="none" required="false" requiredErrorText="联接基地不能为空" onvalidation="onValidation"/>
			</td>
		</tr>
		<tr>
			<td ></td>
			<td id="farmers_error" class="errorText" colspan="2"></td>
			<td ></td>
			<td id="connectionbase_error" class="errorText" colspan="2"></td>
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
</body>
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
</html>