<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>
<%
String roleId = request.getParameter("roleId");
request.setAttribute("roleId", roleId);
%>
<html>
<head>
<script src="<c:url value="/framework/mask/loadmask.js"/>" type="text/javascript"></script>
    <title>CheckBoxTree</title>
    <style type="text/css">
	    body{
	        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
	    }
    </style> 
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<%--     <script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script> --%>
</head>
<body style="">
    <div id="layout1" class="mini-layout" style="width:100%;height:100%;"  borderStyle="border:solid 1px #aaa;">
    <div title="菜单" showProxyText="true" region="west" width="200" expanded="true" showSplitIcon="false">
        <ul id="tree2" class="mini-tree" url="${pageContext.request.contextPath}/menu/menuTree.do" style="width:100%;height:100%;" 
	        showTreeIcon="true" onnodeclick="onNodeClick" textField="menuName" idField="menuId" parentField="menuPid" resultAsTree="false"  expandOnLoad="true"
	        onbeforenodecheck="onBeforeNodeCheck" allowSelect="true" enableHotTrack="false" iconField="iconCls">
	    </ul>
    </div>
    <div title="center" region="center" style="height:70%;border-bottom:0;padding:0px;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <a class="mini-button" iconCls="icon-save" onclick="save()">确定</a>
        </div>
	    <div id="datagrid1" class="mini-datagrid" style="" allowResize="false" allowCellEdit="true"
	        url="${pageContext.request.contextPath}/menu/loadCheckedPrivileges.do"  idField="id" multiSelect="true" showPager="false"
	    >
	        <div property="columns">
	            <div type="indexcolumn"></div>       
<!-- 	            <div type="checkcolumn" ></div> -->
	            <div type="checkboxcolumn" field="checked" trueValue="true" falseValue="false" width="60" headerAlign="center" onclick="saveCheck()">授权</div>         
	            <div field="privilegeType" width="120" headerAlign="center" allowSort="true">资源名称</div>    
	        </div>
	 	</div>	
	 </div>
</div>
    
    <script type="text/javascript">
		mini.parse();
		var form = new mini.Form("#layout1");
		var grid = mini.get("datagrid1");
		
		var menuId = '';
        function onNodeClick(e) {
            var node = e.node;
		    menuId = node.menuId;
            $.ajax({
                url: "${pageContext.request.contextPath}/menu/loadCheckedPrivileges.do",
                data: { roleId: '${roleId}', menuId: menuId},
                type: "post",
                success: function (text) {
                	grid.load({
                		menuId: menuId,
						roleId:'${roleId}'
                	});
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
        }
        
        function save() {
        	var data = grid.data;
        	var json = mini.encode(data);
        	$.ajax({
                url: "${pageContext.request.contextPath}/menuPrivilege/updateMenuPrivilege.do",
                data: { data: json, roleId: '${roleId}', menuId: menuId},
                type: "post",
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
                	grid.load();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                	form.unmask();
                    alert(jqXHR.responseText);
                }
            });
        }
        
        //--------------------------------
        function onBeforeNodeCheck(e) {
            var tree = e.sender;
            var node = e.node;
            if (tree.hasChildren(node)) {
                //e.cancel = true;
            }
        }
    </script>
</body>
</html>
