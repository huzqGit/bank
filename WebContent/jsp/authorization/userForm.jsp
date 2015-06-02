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
<!-- 工具栏信息 -->
<div id="toolbar1" class="mini-toolbar" style="padding:2px;">
    <table style="width:100%;">
        <tr>
        	<!-- 按钮 -->
	        <td style="width:100%;">
                    <a style="cursor:default;padding:2px;padding-left:5px;">人员维护</a>
                </td>
	        
        	<!-- 链接界面 -->
	       	<td style="white-space:nowrap;">
	        	<a id='sysSubmitBtn' class='mini-button' iconCls='icon-save' plain='true' onclick='javascript:submitForm()' enabled='true'>保存</a>
				<a id='sysBackBtn' class='mini-button' iconCls='icon-upgrade' plain='true' onclick='javascript:history.go(-1);' enabled='true'>返回</a>
	        </td>
        </tr>
    </table>
</div>
 
<div id="form1" style="margin-left: 20px ;margin-right: 20px">
<input name="organId" class="mini-hidden" value="${organId}"/>
<!-- 获取表单控件 -->
<table style="width: 100%;" cellpadding="0" cellspacing="3px" border="0" >
	<tr>
		<td style='width:10%;'>
			<label>*用户名：</label>
		</td>
		<td style='width:40%;'>
			<input name="userId" class='mini-textbox' vtype='maxLength:40' style='width:100%;color: red;' emptyText='' required='true' allowInput='true' />
		</td>
		
		<td style='width:10%;'>
		<label>*姓名：</label>
		</td>
		<td style='width:40%;'>
			<input name="userName" class='mini-textbox' vtype='maxLength:40' style='width:100%;color: red;' emptyText='' required='true' allowInput='true' />
		</td>
	</tr>
	<tr>
<!-- 		<td style='width:120px;'> -->
<!-- 		<label>*密码：</label> -->
<!-- 		</td> -->
<!-- 		<td style='width:30%;padding:10px;'> -->
<!-- 			<input name="password" class='mini-textbox' vtype='maxLength:40' style='width:100%;color: red;' emptyText='' required='true' allowInput='true' /> -->
<!-- 		</td> -->
		
		<td style='width:10%;'>
		<label>密码：</label>
		</td>
		<td style='width:40%;' colspan="3">
			<input name="password" class="mini-password" requiredErrorText="密码不能为空" required="true"  style='width:100%;color: red;' />
		</td>
	</tr>
	<tr>
		<td style='width:10%;'>
		<label>性别：</label>
		</td>
		<td style='width:40%;padding:10px;'>
			<input name="sex" class="mini-radiobuttonlist" data="[{id: 1, text: '男'}, {id: 2, text: '女'}]" value="1" style='width:100%;'/>
		</td>
		
		<td style='width:10%;'>
		<label>*生日：</label>
		</td>
		<td style='width:40%;'>
		<input name='birthday' class='mini-datepicker' format='yyyy-MM-dd' style='width:100%;' />
		</td>
	</tr>
	<tr>
		<td style='width:120px;'>
		<label>地址：</label>
		</td>
		
		<td style='width:100%;' colspan='3'>
			<input name='address' class='mini-textarea' style='width:100%;height: 40px;' emptyText='' allowInput='true' enabled='true'/>
		</td>
	</tr>
	<c:if test="${user.userId == 'admin'}">
		<tr>
			<td style='width:210px;'>
			<label>是否为管理员：</label>
			</td>
				<td style='width:100%;' colspan='3'>
					<input name="isAdmin" class="mini-checkbox" checked="true" readOnly="true" />
				</td>
		</tr>
	</c:if>
</table>

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

function submitForm() {
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
	        	window.location.href = "${pageContext.request.contextPath}/jsp/authorization/userForm.jsp?actionType=edit&userId=" + userId;
	            mini.alert('提交成功!');
	            var parentTree = window.parent.getTree();
	            parentTree.load();
        		
        	}
        },
        error: function (jqXHR, textStatus, errorThrown) {
            mini.alert('系统异常！');
        }
    });
    
}


</script>
</body>
</html>
