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
	body{
overflow-x:hidden
}
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
	 li{
 border-bottom:2px solid green;
 float:left;
 width:124px;
 list-style-type:none;
 height:31px;
 text-align:center;
 line-height:28px;
 font-weight:bold;
 color:black;
 background-repeat:no-repeat
 }
.active{
 float:left;
 width:123px;
 list-style-type:none;
 text-align:center;
 border-bottom:2px solid #6DC8E3;
 border-top:1px solid gray;
 border-left:1px solid gray;
 border-right:1px solid white;
 	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = 'white', 
	endColorstr = '#6DC8E3' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = 'white', 
	endColorstr = '#6DC8E3' )";  
 height:31px;

 background-repeat:no-repeat
}
 </style>
</head>
<body>
<div id="form1">
<form action="/bank/farmer/saveCompunish1.do" method="POST">
<input name="id" class="mini-hidden" value="${compunish.id}"/>
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
       <input  name="occurtime" class="mini-datepicker" value="${compunish.occurtime}" style="width:90%"
       errorMode="none" required="true" requiredErrorText="表彰或处罚时间不能为空" onvalidation="onValidation"/>
    </td>
    <td class="required_text" width="2%">*</td>
	<td>表彰或处罚内容:</td>
    <td>
    <input name="detail" class="mini-textarea" value="${compunish.detail}"style="width:90%"
     errorMode="none" required="true" requiredErrorText="表彰或处罚内容不能为空" onvalidation="onValidation"/>
   </td>          
</tr>
<tr>
	<td></td>
	<td id="occurtime_error" class="errorText" colspan="2"></td>
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