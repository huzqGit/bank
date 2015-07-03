<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机构</title>

<style type="text/css">
                
</style> 
</head>
<%
String privilegeId = request.getParameter("privilegeId");
String actionType = request.getParameter("actionType");
request.setAttribute("privilegeId", privilegeId);
request.setAttribute("actionType", actionType);
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
<input name="privilegeId" class="mini-hidden"/>
<!-- 获取表单控件 -->
<table cellspacing='0' cellpadding='0' border='0' class='mini-grid-table datagrid-searchform-table'  style="width:100%;table-layout:fixed;border-left: #e7e7e7 1px solid">
	<tr>
		<td style='width:120px;padding-left:10px;border-top: #ddd 1px solid;'>
			<label>*资源名称：</label>
		</td>
		<td style='width:50%;padding:10px;border-top: #ddd 1px solid;'>
			<input name="privilegeType" class='mini-textbox' vtype='maxLength:40' style='width:100%;color: red;' emptyText='' required='true' allowInput='true' />
		</td>
	</tr>
</table>

</div>
<script type="text/javascript">

mini.parse();

var form = new mini.Form("#form1");
$(document).ready(function(){
	$("#form1").find("td").addClass("mini-grid-cell");
	if ("${actionType}" != "add") {
		$.ajax({
		    url: "${pageContext.request.contextPath}/privilege/loadPrivilege.do?privilegeId=${privilegeId}",
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
        url: "${pageContext.request.contextPath}/privilege/savePrivilege.do",
        type: "post",
        data: { formData: json, actionType: actionType},
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (text) {
        	var privilegeId = text;
        	window.location.href = "${pageContext.request.contextPath}/jsp/authorization/privilegeForm.jsp?actionType=edit&privilegeId=" + privilegeId;
            //alert("提交成功，返回结果:" + text);
            var parentTree = window.parent.getTree();
            parentTree.load();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            mini.alert('系统异常！');
        }
    });
    
}


</script>
</body>
</html>
