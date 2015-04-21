<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<script src="<c:url value="/framework/mask/loadmask.js"/>" type="text/javascript"></script>
<head>
<%
String menuId = request.getParameter("menuId");
String menuPid = request.getParameter("menuPid");
String actionType = request.getParameter("actionType");
request.setAttribute("menuId", menuId);
request.setAttribute("menuPid", menuPid);
request.setAttribute("actionType", actionType);
%>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>菜单信息</title> 	
<style type="text/css">
    body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }
</style>   
</head>
<body style="width: 100%;height: 100%;overflow-x:hidden;overflow-y:auto;"  onload="">
 <div id="toolbar1" class="mini-toolbar" style="padding:2px;">
         <table style="width:100%;height:100%">
        <tr>
        	<!-- 按钮 -->
	         <td style="width:100%;">
                    <a style="cursor:default;padding:2px;padding-left:5px;">菜单维护</a>
                </td>
	        
        	<!-- 链接界面 -->
	       	<td style="white-space:nowrap;">
	        	<a id='sysSubmitBtn' class='mini-button' iconCls='icon-save' plain='true' onclick='javascript:submitForm()' enabled='true'>保存</a>
				<a id='sysBackBtn' class='mini-button' iconCls='icon-upgrade' plain='true' onclick='javascript:history.go(-1);' enabled='true'>返回</a>
	        </td>
        </tr>
    </table>
    </div>
<div id="form" style="margin-left: 10px ;margin-right: 10px">
<input name="menuPid" class="mini-hidden" value="${menuPid}"/>
<input name="menuId" class="mini-hidden" value="${menuId}"/>
 <table style="width: 100%;" cellpadding="0" cellspacing="3px" border="0" >
	<tr>
		<td width="70px" align="right">菜单名称:</td>
		<td width="180px">
			<input id="menuName" name="menuName" class='mini-textbox' style="width: 100%;" style='width:100%;color: red;' emptyText='' required='true' allowInput='true' />
		</td>
	</tr>
	<tr>
		<td width="70px" align="right">菜单描述:</td>
		<td colspan="3">
			<input id="menuDescr" name="menuDescr" class='mini-textbox' style="width: 100%;" style='width:100%; emptyText='' allowInput='true' />
		</td>
	</tr>
	<tr>
		<td width="70px" align="right">URL地址:</td>
		<td colspan="3">
			<input id="menuUrl" name="menuUrl" class='mini-textbox' style="width: 100%;" style='width:100%; emptyText='' allowInput='true' />
		</td>
	</tr>
	<tr>
		<td width="70px" align="right">叶节点：</td>
		<td colspan="3">
			<input id="isLeaf" name="isLeaf" class='mini-checkbox' value="1" trueValue="1" falseValue="0" style='width:100%; emptyText='' allowInput='true' />
		</td>
	</tr>
</table>
</div>
    <script type="text/javascript">
    mini.parse();

    var form = new mini.Form("#form");
    $(document).ready(function(){
    	$("#form1").find("td").addClass("mini-grid-cell");
    	if ("${actionType}" != "add") {
    		$.ajax({
    		    url: "${pageContext.request.contextPath}/menu/loadMenu.do?menuId=${menuId}",
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
        var menuPId = "${menuPid}";
        $.ajax({
            url: "${pageContext.request.contextPath}/menu/save.do",
            type: "post",
            data: { formData: json, actionType: actionType, menuPid: menuPId},
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend : function() {
            	form.mask("正在保存中...", null, true);
            },
            success: function (text) {
            	form.unmask();
            	form.mask("保存成功...", null, false);
            	window.setTimeout(function() {
            	   form.unmask();
            	   window.close();
            	}, 500);
            	var menuId = text;
            	window.location.href = "${pageContext.request.contextPath}/jsp/authorization/menu.jsp?actionType=edit&menuId=" + menuId;
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