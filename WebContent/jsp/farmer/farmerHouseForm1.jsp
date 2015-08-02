<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房产信息</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
<div  id ="form1">
<form  action="/bank/farmer/saveHouse.do" method="POST">
<div class="queryPane">
<table width="100%"cellpadding="0" cellspacing="0" style="height:30px">
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
<legend><label>农户房产基本情况</label></legend>
<div class="fieldset-body">
<table width="100%"><tr><td>
<input name="id" class="mini-hidden" value="${house.id}" />
<input name="farmerid" class="mini-hidden" value="${farmer.id}" />
<input name="farmeridnum" class="mini-hidden"  value="${farmer.farmeridnum}" />
<input name="recorder" class="mini-hidden" value="${recorder}"/>
<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr><td style="width:100%">
<table width="100%">
<tr>
	<td class="required_text" width="2%">*</td>
	<td width="15%">房产性质:</td>
    <td width="33%">
    	<input name="houseproperty" class="mini-combobox" value="${house.houseproperty}" style="width:90%"
    	 	errorMode="none" required="true"  requiredErrorText="房产性质不能为空" url="/bank/dic/HouseProperty.txt" emptyText="请选择..."
    	 	onvalidation="onValidation"/>
    </td>
    <td class="required_text" width="2%">*</td>
   	<td width="15%">房屋类型:</td>
    <td width="33%">
   		<input name="housetype" class="mini-combobox" value="${house.housetype}" style="width:90%"
    	 	errorMode="none" required="true"  requiredErrorText="房屋类型不能为空" url="/bank/dic/HouseType.txt" emptyText="请选择..."
    	 	onvalidation="onValidation"/>
    </td>
</tr>
<tr>
	<td></td>
	<td colspan="2" id="houseproperty_error" class="errorText"></td>
	<td></td>
	<td colspan="2" id="houseType_error" class="errorText"></td>
</tr>
<tr>
	<td class="required_text">*</td>
	<td>房屋地址:</td>
    <td>
    	<input name="houseaddress" class="mini-textbox" class="bank_text" value ="${house.houseaddress}" style="width:90%"
    		errorMode="none" required="true" requiredErrorText="房屋地址不能为空!" onvalidation="onValidation"/>
    </td>
    <td class="required_text">*</td>
    <td>购建年份(年):</td>
    <td>
    	<input name="builddate" class="mini-textbox"  value="${house.builddate}" style="width:90%"
    		errorMode="none" vtype="float" required="true" requiredErrorText="构建年份不能为空!" onvalidation="onValidation"/>
	</td>
</tr>
<tr>
	<td></td>
	<td colspan="2" id="houseaddress_error" class="errorText"></td>
	<td></td>
	<td colspan="2" id="builddate_error" class="errorText"></td>
</tr>
<tr>
	 <td class="required_text">*</td>
	 <td >建筑面积(平方米):</td>
     <td>
    	<input name="buildarea" class="mini-textbox" value ="${house.buildarea}" style="width:90%"
    		errorMode="none" vtype="float" required="true" requiredErrorText="建筑面积不能为空!" onvalidation="onValidation"/>
     </td>
     <td class="required_text">*</td>
	 <td>占地面积(平方米):</td>
     <td>
     	<input name="floorarea" class="mini-textbox"  value="${house.floorarea}" style="width:90%"
     		errorMode="none" vtype="float" required="true" requiredErrorText="建筑面积不能为空!" onvalidation="onValidation"/>
	 </td>
</tr>
<tr>
	<td></td>
	<td colspan="2" id="buildarea_error" class="errorText"></td>
	<td></td>
	<td colspan="2" id="floorarea_error" class="errorText"></td>
</tr>
<tr>
	 <td class="required_text">*</td>
	<td>购建价格(元):</td>
    <td>
    	<input name="buildprice" class="mini-textbox" value="${house.buildprice}" style="width:90%"
    		errorMode="none" vtype="float" required="true" requiredErrorText="购建价格不能为空!" onvalidation="onValidation"/>
    </td>
    <td class="required_text">*</td>
    <td>当前评估价格(元):</td>
    <td>
     	<input name="assessprice" class="mini-textbox" value="${house.assessprice}" style="width:90%"
     		errorMode="none" vtype="float" required="true" requiredErrorText="当前评估价格不能为空!" onvalidation="onValidation"/>
    </td>
</tr>
<tr>
	<td></td>
	<td colspan="2" id="buildprice_error" class="errorText"></td>
	<td></td>
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