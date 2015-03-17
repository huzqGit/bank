<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单信息</title>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>

<style type="text/css">
                
</style> 
</head>
<%
String parMenuId = request.getParameter("parMenuId");
request.setAttribute("parMenuId", parMenuId);
String menuId = request.getParameter("menuId");
String actionType = request.getParameter("actionType");
request.setAttribute("menuId", menuId);
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
<!-- 获取表单控件 -->

<table border="0" cellpadding="1" cellspacing="2">
	<tr>
		<td style='width:80px'>
			<label>*菜单名称：</label>
		</td>
		<td style='width:120px'>
			<input name="menuName" class='mini-textbox' vtype='maxLength:40' style='width:100%;color: red;' emptyText='' required='true' allowInput='true' />
		</td>
	</tr>
	<tr>
		<td style='width:80px'>
		<label>菜单描述：</label>
		</td>
		<td style='width:120px'>
			<input name="menuDescr" class='mini-textbox' vtype='maxLength:40' style='width:100%; emptyText='' allowInput='true' />
		</td>
	</tr>
	<tr>
		<td style='width:80px'>
		<label>URL地址：</label>
		</td>
		<td style='width:120px'>
			<input name="menuUrl" class='mini-textbox' vtype='maxLength:40' style='width:100%; emptyText='' allowInput='true' />
		</td>
	</tr>
	<tr>
		<td style='width:80px;padding-left:10px;'>
		<label>叶节点：</label>
		</td>
		<td style='width:120px'>
			<input name="isLeaf" class='mini-textbox' vtype='maxLength:40' style='width:100%; emptyText='' allowInput='true' />
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
		    url: "${pageContext.request.contextPath}/manager/loadMenu.do?menuId=${menuId}",
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
    var parMenuId = "${parMenuId}";
    
    $.ajax({
        url: "${pageContext.request.contextPath}/manager/save.do",
        type: "post",
        data: { formData: json, actionType: actionType, parMenuId: parMenuId},
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (text) {
        	var userId = text;
        	window.location.href = "${pageContext.request.contextPath}/jsp/authorization/menu.jsp?actionType=edit&menuId=" + menuId;
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
