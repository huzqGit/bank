<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<style type="text/css">
	*{margin:0;padding:0;text-decoration:none}
	body{overflow-x:hidden}
    .active{font-size: 15px;font-family: YouYuan;font-weight: bold;color:darkgreen}
    .inactive{font-size: 15px;font-family: YouYuan;font-weight:bold;color:gray}
    .display{display:block;}
    .hidden{display:none;}
    .line{background-color:#CCECF5;}
    .topMenu{
    border:1px solid #8AD3E9;
    /* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
	endColorstr = 'white' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
	endColorstr = 'white' )"; 
    }
#saveBtn{
		width:100px;
		height:25px;
		border:0;
		background:url(/bank/images/save.png) no-repeat
}
#backBtn{
		width:100px;
		height:25px;
		border:0;
		background:url(/bank/images/back.png) no-repeat
}
.addBtn{width:100px;height:25px;border:0;background:url(/bank/images/add.png) no-repeat}
.delBtn{width:100px;height:25px;border:0;background:url(/bank/images/delete.png) no-repeat}
.labelName{font-size:15px;font-weight:bold;color:darkgreen;}
.labelValue{font-size:15px;font-weight:bold;color:red;}
.required_text,.errorText{color:red}
.required_text{text-align:right}
 </style>
</head>
<body>
<div id="form1">
<form action="/bank/farmer/saveForest1.do"  method="POST">
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
	<fieldset style="width:90%;margin:auto auto">
	<legend><label>农户林权基本情况</label></legend>
	<div class="fieldset-body">
	<table width="100%"><tr><td>
	<input name="id" class="mini-hidden" value="${forest.id}"/>
	<input name="farmerId" class="mini-hidden" value="${farmer.id}" />
	<table border="0" cellpadding="1" cellspacing="15" width="100%" >
	<tr><td style="width:100%">
	<table width="100%">
	<tr>
		<td class="required_text">*</td>
		<td width="15%">林权证编号:</td>
		<td width="33%">
			<input name="cardNum" class="mini-textbox" value="${forest.cardNum}" style="width:90%"
				errorMode="none" required="true" requiredErrorText="房屋地址不能为空!" onvalidation="onValidation"/>
		</td>
	    <td class="required_text">*</td>
	    <td width="15%">林权字号:</td>
	    <td width="33%" >
	    	<input name="wordNum" class="mini-textbox" value="${forest.wordNum}" style="width:90%"
	    		errorMode="none" required="true" requiredErrorText="房屋地址不能为空!" onvalidation="onValidation"/>
	    </td>
	</tr>
	<tr >
		<td></td>
		<td colspan="2" id="cardNum__error" ></td>
		<td></td>
		<td colspan="2" id="wordNum__error" ></td>
	</tr>
	<tr>
		<td class="required_text">*</td>
		<td >林权使用人:</td>
	    <td >
	    	<input name="user" class="mini-textbox" value="${forest.user}" style="width:90%"
	    		errorMode="none" required="true" requiredErrorText="林权使用人不能为空!" onvalidation="onValidation"/>
	    </td>
	    <td class="required_text">*</td>
	    <td >林权使用种类:</td>
	    <td >
	        <input id="useType" name="useType" class="mini-combobox" value="${forest.useType}" 
	        	required="true" requiredErrorText="林权使用种类不能为空" style="width:90%"
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
				errorMode="none" required="true" requiredErrorText="面积不能为空!" onvalidation="onValidation"/>
			</td>
		<td class="required_text"></td>
	    <td >蓄积量:</td>
	    <td >
	    	<input name="storeNum" class="mini-textbox" value="${forest.storeNum}" style="width:90%"/>
	    </td>
	</tr>
	<tr >
		<td ></td>
		<td colspan="2" id="area_error" class="errorText"></td>
		<td ></td>
		<td colspan="2" id="storeNum_error" class="errorText"></td>
	</tr>
	<tr>
		<td class="required_text"></td>
		<td >使用权期限(年):</td>
	    <td >
	   		<input name="timeLimit" class="mini-textbox" value="${forest.timeLimit}" style="width:90%"
	   			errorMode="none" vtype="float" onvalidation="onValidation"/>
	    </td>
	    <td class="required_text"></td>
	    <td >当前评估价格(元):</td>
	    <td >
	    	<input name="assessPrice"  class="mini-textbox" value="${forest.assessPrice}" style="width:90%"
	    		errorMode="none" vtype="float" onvalidation="onValidation"//>
	    </td>
	</tr>
	<tr >
		<td ></td>
		<td colspan="2" id="timeLimit_error" class="errorText"></td>
		<td ></td>
		<td colspan="2" id="assessPrice_error" class="errorText"></td>
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