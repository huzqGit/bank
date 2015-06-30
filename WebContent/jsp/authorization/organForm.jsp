<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>机构</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<%-- <script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script> --%>
<script src="<c:url value="/framework/mask/loadmask.js"/>" type="text/javascript"></script>

<style type="text/css">
            body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
</style>
</head>
<%
String organId = request.getParameter("organId");
String actionType = request.getParameter("actionType");
String organPid = request.getParameter("organPid");
request.setAttribute("organId", organId);
request.setAttribute("organPid", organPid);
request.setAttribute("actionType", actionType);
%>
<body style="width: 100%;height: 100%;overflow-x:hidden;overflow-y:auto;"  onload="">
<!-- 工具栏信息 -->
<div id="toolbar1" class="queryPane" style="padding:2px;">
    <table style="width:100%;">
        <tr>
        	<!-- 按钮 -->
	         <td style="width:100%;">
                    <a style="cursor:default;font-weight:bold;padding:2px;padding-left:5px;">机构维护》</a>
                </td>
	        
        	<!-- 链接界面 -->
	       	<td style="white-space:nowrap;">
	        	<button id='sysSubmitBtn' class="bank-btn" onclick='javascript:submitForm()' enabled='true'>保存</button>
	        </td>
        </tr>
    </table>
</div>
 
<div id="organForm" style="margin-left: 20px ;margin-right: 20px">
<input name="organId" class="mini-hidden"/>
<input name="organPid" class="mini-hidden" value="${organPid}"/>
<!-- 获取表单控件 -->
<table style="width: 100%;" cellpadding="0" cellspacing="3px" border="0"  >
	<tr>
		<td style='width:120px;'>
			<a style="color:red">*</a>机构名称：
		</td>
		<td style='width:90%;' align="left">
			<input name="organName" class='mini-textbox' vtype='maxLength:40' style='width:100%;color: red;' emptyText='' required='true' allowInput='true' />
		</td>
	</tr>
	<tr>	
		<td style='width:120px;'>
			<label><a style="color:red">*</a>机构简称：</label>
		</td>
		<td style='width:90%;'>
			<input name="organShort" class='mini-textbox' vtype='maxLength:40' style='width:100%;color: red;' emptyText='' required='true' allowInput='true' />
		</td>
	</tr>
	<tr>	
		<td style='width:120px;'>
			<label><a style="color:red">*</a>机构编码：</label>
		</td>
		<td style='width:90%;'>
			<input name="organNo" class='mini-textbox' vtype='maxLength:40' style='width:100%;color: red;' emptyText='' required='true' allowInput='true' />
		</td>
	</tr>
	<tr>	
		<td style='width:120px;'>
			<label>机构类型：</label>
		</td>
		<td style='width:90%;'>
			<input name="organType" class="mini-combobox" data="[{id: 'UNIT', text: '单位'}, {id: 'DEPT', text: '部门'}]" value='UNIT' showNullItem="false" style='width:90px;'/>
		</td>
	</tr>
</table>

</div>
<script type="text/javascript">
	mini.parse();

	var form = new mini.Form("#organForm");
	$(document)
			.ready(
					function() {
						//$("#form1").find("td").addClass("mini-grid-cell");
						if ("${actionType}" != "add") {
							$
									.ajax({
										url : "${pageContext.request.contextPath}/organ/loadOrgan.do?organId=${organId}",
										type : "post",
										success : function(text) {
											var data = mini.decode(text); //反序列化成对象
											form.setData(data); //设置多个控件数据
										}
									});
						}
					});

	function submitForm() {
		//提交表单数据
		var formData = form.getData(); //获取表单多个控件的数据
		//formData.dutyId = ${dutyId};
		var json = mini.encode(formData); //序列化成JSON
		var actionType = "${actionType}";

		$
				.ajax({
					url : "${pageContext.request.contextPath}/organ/saveOrgan.do",
					type : "post",
					data : {
						formData : json,
						actionType : actionType
					},
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					success : function(text) {
						var organId = text;
						window.location.href = "${pageContext.request.contextPath}/jsp/authorization/organForm.jsp?actionType=edit&organId="
								+ organId;
						//alert("提交成功，返回结果:" + text);
						var parentTree = window.parent.getTree();
						parentTree.load();
					},
					error : function(jqXHR, textStatus, errorThrown) {
						mini.alert('系统异常！');
					}
				});

	}
</script>
</body>
</html>
