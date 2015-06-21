<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户基本贷款信息</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<style type="text/css">
*{margin:0;padding:0;text-decoration:none}
.labelName{font-size:15px;font-weight:bold;color:darkgreen;}
.labelValue{font-size:15px;font-weight:bold;color:red;}
.topMenu{
	border:1px solid #8AD3E9;
    /* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
	endColorstr = 'white' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
	endColorstr = 'white' )"; 
}
#saveBtn{width:100px;height:25px;border:0;background:url(/bank/images/save.png) no-repeat}
#backBtn{width:100px;height:25px;border:0;background:url(/bank/images/back.png) no-repeat}
.required_text{
color:red
}
.errorText{
color:red
}
</style>
</head>
<body>
<div id ="form1">
<form  id="farmerLoan" name="farmerLoan" action="/bank/farmer/savePrivateLending.do" method="POST">
<input name="id" class="mini-hidden" value="${privateLending.id}"/>
<input name="farmerId" class="mini-hidden"  value="${farmer.id}" />
<input name="recorder" class="mini-hidden" value="管理员"/>
<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
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
<div style="width:90%;margin:auto auto">
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr>
	<td colspan="4" style="width:100%">
	<fieldset id="fd2" style="width:100%;margin:auto auto">
	<legend><label>农户民间借贷信息</label></legend>
	<div class="fieldset-body">
	<table width="100%" >
	<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>家庭成员姓名:</label></td>
    <td style="width:39%">
    	<input name="members[${status.index}].name" class="mini-textbox" value="${member.name }"
         	required="true" requiredErrorText="家庭成员姓名不能为空" style="width:90%"/>
    </td>
    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>与户主关系:</label></td>
    <td style="width:39%" >
       <input name="members[${status.index}].relation" class="mini-combobox"  value="${member.relation }"
  			style="width:90%" url="/bank/dic/Relation.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>身份证号:</label></td>
    <td style="width:39%">
    	<input name="members[${status.index}].idNum" class="mini-textbox" value="${member.idNum }"
        	required="true"	 requiredErrorText="身份证号不能为空" style="width:90%"/>
    </td>
    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>文化程度:</label></td>
    <td style="width:39%" >
    	<input name="members[${status.index}].education" class="mini-combobox" value="${member.education}" style="width:90%"
        	url="/bank/dic/Education.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox2$text"><font color="red">*</font>性别:</label></td>
    <td style="width:39%" >
    	<input name="members[${status.index}].sex" class="mini-combobox" value="${member.sex }" style="width:90%"
        	required="true"  requiredErrorText="性别不能为空" url="/bank/dic/Sex.txt" emptyText="请选择..."/>
   </td>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>婚姻状况:</label></td>
    <td style="width:39%">
	    <input name="members[${status.index}].marryStatus" class="mini-combobox" value="${member.marryStatus}" style="width:90%"
	    	required="true" requiredErrorText="婚姻状况不能为空" url="/bank/dic/MarryStatus.txt" emptyText="请选择..."/>
   </td>
</tr>
<tr>
   <td style="width:10%"><label for="textbox2$text">&nbsp;&nbsp;职业:</label></td>
   <td style="width:39%" >
   		<input name="members[${status.index}].occupation" class="mini-textbox" value="${member.occupation}" style="width:90%"/>
   </td>
	<td style="width:10%"><label for="textbox1$text">&nbsp;&nbsp;职务:</label></td>
    <td style="width:39%">
    	<input name="members[${status.index}].job" class="mini-textbox" value="${member.job }" style="width:90%"/>
    </td>
    
</tr>
<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>联系电话:</label></td>
	<td style="width:39%">
    	<input  name="members[${status.index}].phone" class="mini-textbox" value="${member.phone}" style="width:90%"
        	required="true"  requiredErrorText="联系电话不能为空" />
    </td>
    <td style="width:10%"><label for="textbox1$text">&nbsp;&nbsp;地址:</label></td>
	<td style="width:39%">
    	<input  name="members[${status.index}].address" class="mini-textarea" value="${member.address}" style="width:90%"/>
    </td>
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
		$("#farmerLoan").submit();
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