<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>
<%@ page import="com.bank.beans.User"%> 
<%@ page import="com.bank.Constants"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户</title>
<%-- <script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script> --%>
<script src="<c:url value="/framework/mask/loadmask.js"/>" type="text/javascript"></script>

<style type="text/css">
       body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
    
    .errorText
    {
        color:red;
    }
   
</style> 
</head>
<%
User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
String userId = request.getParameter("userId");
String organId = request.getParameter("organId");
String actionType = request.getParameter("actionType");
request.setAttribute("user", user);
request.setAttribute("userId", userId);
request.setAttribute("organId", organId);
request.setAttribute("actionType", actionType);
%>
<body style="width: 100%;height: 100%;overflow-x:hidden;overflow-y:auto;" >
<div id="form1" style="margin-left: 20px ;margin-right: 20px">
<input name="organId" class="mini-hidden" value="${organId}"/>
<!-- 获取表单控件 -->
<table style="width: 100%;" cellpadding="0" cellspacing="3px" border="0" >
	<tr>
		<td style='width:15%;' align="right">
			<label style="color:red">*</label>用户名：
		</td>
		<td>
		
			<c:set var="allowInput" value="true"/>
			<c:if test="${actionType == 'edit'}">
				<c:set var="allowInput" value="false"/>
			</c:if>
			<input name="userId" class='mini-textbox' onvalidation="onValidation" errorMode="none" vtype='maxLength:40' style='width:300px;' emptyText='' required='true' requiredErrorText="用户名不能为空" allowInput='${allowInput}' />
		</td>
		<td id="userId_error" class="errorText"></td>
		</tr>
	<tr>
		<td style='width:15%;' align="right">
		<label style="color:red">*</label>姓名：
		</td>
		<td>
			<input name="userName" class='mini-textbox' onvalidation="onValidation" errorMode="none" vtype='maxLength:40' style='width:300px;' emptyText='' required='true' requiredErrorText="姓名不能为空" allowInput='true' />
		</td>
		<td id="userName_error" class="errorText"></td>
	</tr>
	<tr>
		<td style='width:15%;' align="right">
		<label style="color:red">*</label>密码：
		</td>
		<td>
			<input id="password" name="password" class="mini-password" errorMode="none" onvalidation="onValidation" vtype="minLength:8" required="true" minLengthErrorText="密码不能少于8个字符" requiredErrorText="密码不能为空"  style='width:300px;' />
		</td>
		<td id="password_error" class="errorText"></td>
	</tr>
	<tr>
		<td style='width:15%;' align="right">
		<label>性别：</label>
		</td>
		<td style='padding:10px;' colspan="2">
			<input name="sex" class="mini-radiobuttonlist" data="[{id: 1, text: '男'}, {id: 2, text: '女'}]" value="1" style='width:300px;'/>
		</td>
		</tr>
	<tr>
		<td style='width:15%;' align="right">
		<label>生日：</label>
		</td>
		<td colspan="2">
		<input name='birthday' class='mini-datepicker' style='width:300px;' format='yyyy-MM-dd' />
		</td>
	</tr>
	<tr>
		<td style='width:15%;' align="right">
		<label>地址：</label>
		</td>
		
		<td colspan="2">
			<input name='address' class='mini-textarea' style='width:300px;height: 40px;' emptyText='' allowInput='true' enabled='true'/>
		</td>
	</tr>
	<c:if test="${user.userId == 'admin'}">
		<tr>
			<td style='width:15%;' align="right">
			<label>是否为管理员：</label>
			</td>
				<td colspan="2">
					<input name="isAdmin" class="mini-checkbox" style='width:300px;' checked="true" readOnly="true" />
				</td>
		</tr>
	</c:if>
</table>
<div style="text-align:center;padding:10px;">               
    <a class="mini-button" onclick="javascript:submitForm()" style="width:60px;margin-right:20px;">确定</a>       
    <a class="mini-button" onclick="onCancel" style="width:60px;">取消</a>       
</div>   

</div>
<script type="text/javascript">

mini.parse();

var form = new mini.Form("#form1");
$(document).ready(function(){
	//$("#form1").find("td").addClass("mini-grid-cell");
	if ("${actionType}" != "add") {
		$.ajax({
		    url: "${pageContext.request.contextPath}/user/loadUser.do?userId=${userId}",
		    type: "post",
		    success: function (text) {
		        var data = mini.decode(text);   //反序列化成对象
		        form.setData(data);             //设置多个控件数据
		    }
		});
	}
	
});

function onCancel() {
	 window.CloseOwnerWindow();
}

function submitForm() {
	
// 	alert(mini.value('password'));
	
// 	var regLower = /[a-z]/;
// 	 if (!regLower.test(str)) {
// 		 alert("密码至少含有一个字母！");
// 	 }

 	form.validate();

    if (form.isValid() == false) return;
	
	//提交表单数据
    var formData = form.getData();      //获取表单多个控件的数据
    //formData.dutyId = ${dutyId};
    var json = mini.encode(formData);   //序列化成JSON
    var actionType = "${actionType}";
    
    $.ajax({
        url: "${pageContext.request.contextPath}/user/saveUser.do",
        type: "post",
        data: { formData: json, actionType: actionType},
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (text) {
        	var userId = text;
        	if (userId == "false") {
        		mini.alert('用户名已存在！');
        	} else {
	            mini.alert('提交成功!');
	            window.CloseOwnerWindow();
        	}
        },
        error: function (jqXHR, textStatus, errorThrown) {
            mini.alert('系统异常！');
        }
    });
    
}

//////////////////////////////////////////
function updateError(e) {
    var id = e.sender.name + "_error";
    var el = document.getElementById(id);
    if (el) {
        el.innerHTML = e.errorText;
    }
}
function onUserNameValidation(e) {                  
    updateError(e);
}
function onPwdValidation(e) {        
    updateError(e);
}
function onValidation(e) {        
    updateError(e);
}


</script>
</body>
</html>
