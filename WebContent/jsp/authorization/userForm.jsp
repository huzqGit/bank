<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户</title>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>

<style type="text/css">
                
</style> 
</head>
<%
String userId = request.getParameter("userId");
request.setAttribute("userId", userId);
%>
<body>
<!-- 工具栏信息 -->
<div id="toolbar1" class="mini-toolbar" style="width:90%; padding: 0px; border-width: 0px; margin:0 auto">
    <table style="width:100%;height:100%">
        <tr>
        	<!-- 按钮 -->
	        <td style="width:100%;">
	       		 <span id='toolTitle' style='float:left; margin:10px 0px 0px 15px; font-size:16px;'></span>
	        </td>
	        
        	<!-- 链接界面 -->
	       	<td style="white-space:nowrap;">
	        	<a id='sysSubmitBtn' class='mini-button' iconCls='icon-save' plain='true' onclick='javascript:submitForm()' enabled='true'>保存</a>
				<a id='sysBackBtn' class='mini-button' iconCls='icon-upgrade' plain='true' onclick='javascript:history.go(-1);' enabled='true'>返回</a>
	        </td>
        </tr>
    </table>
</div>
 
<div id="form1" style="width:90%;margin:0 auto">
<input id='dutyId' name='dutyId'  class='mini-hidden'/>
<input id='tripId' name='tripId'  class='mini-hidden'/>
<input id='eventId' value='' name='eventId'  class='mini-hidden'/>
<!-- 获取表单控件 -->
<table cellspacing='1' cellpadding='2' border='0' class='mini-grid-table'  style="width:100%;table-layout:fixed;">
	<tr >
		<td style='width:120px;padding-left:10px'>
		<label>*用户名：</label>
		</td>
		<td style='width:50%;padding:10px;' colspan="3">
		<input name=userId class='mini-textbox' vtype='maxLength:40' style='width:100%;color: red;' emptyText='' required='true' allowInput='true' />
		</td>
	</tr>
	<tr>
	<tr >
		<td style='width:120px;padding-left:10px'>
		<label>*姓名：</label>
		</td>
		<td style='width:50%;padding:10px;'>
		<input name=username class='mini-textbox' vtype='maxLength:40' style='width:100%;color: red;' emptyText='' required='true' allowInput='true' />
		</td>
		<td style='width:120px;padding-left:10px'>
		<label>密码：</label>
		</td>
		<td style='width:50%;padding:10px;'>
			<input name='password' class="mini-password" requiredErrorText="密码不能为空" required="true"  style='width:100%;color: red;' />
		</td>
	</tr>
	<tr>
		<td style='width:120px;padding-left:10px'>
		<label>性别：</label>
		</td>
		<td style='width:120px;padding:10px'>
			<input name="sex" class="mini-radiobuttonlist" data="[{id: 1, text: '男'}, {id: 2, text: '女'}]"/>
		</td>
		<td style='width:120px;padding-left:10px'>
		<label>*生日：</label>
		</td>
		<td style='width:50%;padding:10px;'>
		<input name='birthday' class='mini-datepicker' format='yyyy-MM-dd' style='width:100%;' />
		</td>
	</tr>
	<tr>
		<td style='width:120px;padding-left:10px'>
		<label>地址：</label>
		</td>
		
		<td style='width:120px;padding:10px' colspan='3'>
			<input name='address' class='mini-textarea' style='width:100%;height: 40px;' emptyText='' allowInput='true' enabled='true'/>
		</td>
	</tr>
</table>

</div>
<script type="text/javascript">

mini.parse();

var form = new mini.Form("#form1");
$(document).ready(function(){
	$.ajax({
	    url: "${pageContext.request.contextPath}/user/loadUser.do?userId=${userId}",
	    type: "post",
	    success: function (text) {
	        var data = mini.decode(text);   //反序列化成对象
	        form.setData(data);             //设置多个控件数据
	    }
	});
	
});

function submitForm() {
	//提交表单数据
    var formData = form.getData();      //获取表单多个控件的数据
    //formData.dutyId = ${dutyId};
    var json = mini.encode(formData);   //序列化成JSON
    
    $.ajax({
        url: "${pageContext.request.contextPath}/user/saveUser.do",
        type: "post",
        data: { formData: json},
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (text) {
        	var tripId = text;
        	window.location.href = "${pageContext.request.contextPath}/products/runlog/nwoms/logtype/transmission.jsp?dutyId=${dutyId}&tripId=" + tripId;
            //alert("提交成功，返回结果:" + text);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            mini.alert('系统异常！');
        }
    });
    
}


</script>
</body>
</html>
