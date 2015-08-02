<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    .active{font-size: 15px;font-family: YouYuan;font-weight: bold;color:darkgreen}
     .inactive{font-size: 15px;font-family: YouYuan;font-weight:bold;color:gray}
    .display{display:block;}
    .hidden{display:none;}
    .line{background-color:#CCECF5;}
	.addBtn{width:100px;height:25px;border:0;background:url(/bank/images/add.png) no-repeat}
	.delBtn{width:100px;height:25px;border:0;background:url(/bank/images/delete.png) no-repeat}
	.labelName{font-size:15px;font-weight:bold;color:darkgreen;}
	.labelValue{font-size:15px;font-weight:bold;color:red;}
	 li{
 border-bottom:1px solid lightgray;
 float:left;
 width:85px;
 list-style-type:none;
 height:31px;
 text-align:center;
 line-height:28px;
 font-weight:bold;
 color:black;
 background-repeat:no-repeat
 }
 li a{
 color:black
 }
 </style>
</head>
<body>
<form action="/bank/farmer/saveEvaluate1.do" id="farmerEvaluate" name="farmerEvaluate" method="POST">
<input name="id" class="mini-hidden" value ="${evaluate.id}"/>
<input name="farmerid" class="mini-hidden" value="${farmer.id}"/>
<input name="recorder" class="mini-hidden" value="${recorder}"/>
<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
<div class="queryPane">
<table width ="100%" height="60px">
	<tr>
		<td class="labelName" width="30%" align="right">姓名</td>
		<td class="labelValue" width="1%" align="center">:</td>
		<td class="labelValue" width="10%">${farmer.farmername }</td>
		<td class="labelName" width="10%" align="center">身份证号码</td>
		<td class="labelValue" width="1%">:</td>
		<td class="labelValue" align="left">${farmer.farmeridnum}</td>
		<td width="1%"></td>
    	<td width="50px" align="right">
       	 <input type="submit" class="bank-btn" value="保存"/>
        </td>
	</tr>
</table>
</div>
<fieldset id="fd2" style="width:90%;margin:auto auto">
<legend><label>村民委员会对农户家庭评价情况基本信情况</label></legend>
<div class="fieldset-body">
<table border="0" cellpadding="1" cellspacing="5" width="100%" >
<tr><td>
<table width="100%">
<tr>
	<td class="required_text" width="2%"></td>
    <td style="width:15%">人品综合评价:</td>
    <td style="width:33%" >
    	<input name="personality" class="mini-combobox" value ="${evaluate.harmonystatus}" style="width:90%"
    	url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
	<td class="required_text" width="2%"></td>
    <td style="width:15%">家庭和睦情况:</td>
    <td style="width:33%" >
    	<input name="harmonystatus" class="mini-combobox" value ="${evaluate.harmonystatus}" style="width:90%"
    	url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
    <td class="required_text"></td>
    <td >敬老爱幼情况:</td>
    <td >
    	<input name="respectstatus" class="mini-combobox" value ="${evaluate.respectstatus}"style="width:90%"
    	url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
	<td class="required_text"></td>
    <td>邻里团结情况:</td>
    <td>
    	<input name="neighborstatus" class="mini-combobox" value ="${evaluate.neighborstatus}" style="width:90%"
    	url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
	<td class="required_text"></td>
    <td >是否遵纪守法</td>
    <td >
    	<input name="legalstatus" class="mini-combobox" value ="${evaluate.legalstatus}" required="true"
        	requiredErrorText="是否遵纪守法不能为空" style="width:90%"
            url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..."/>
    </td>
	<td class="required_text" width="2%"></td>
    <td>对公益事业关心程度:</td>
    <td>
    	<input name="welfarestatus" class="mini-combobox" value ="${evaluate.welfarestatus}" style="width:90%"
    		url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
  <td class="required_text"></td>
    <td>是否诚实守信:</td>
    <td>
    	<input name="honeststatus" class="mini-combobox" value ="${evaluate.honeststatus}"  style="width:90%"
    		required="true" requiredErrorText="不能为空"
        	url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..."/>
   </td>
   <td class="required_text" width="2%"></td>
   <td >其他:</td>
   <td style="width:35%">
	   <input name="otherstatus" class="mini-textarea" value ="${evaluate.otherstatus}" style="width:90%">
   </td>
</tr>
</table>
</td></tr></table>
</div>
</fieldset>
</form>
<script type="text/javascript">
  	function back(){
		  window.history.go(-1);
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