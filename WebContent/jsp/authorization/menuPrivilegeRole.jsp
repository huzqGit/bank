<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String roleId = request.getParameter("roleId");
request.setAttribute("roleId", roleId);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>CheckBoxTree</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body style="">
    <div id="layout1" class="mini-layout" style="width:600px;height:400px;"  borderStyle="border:solid 1px #aaa;">
    <div title="west" showProxyText="true" region="west" width="200" expanded="true" showSplitIcon="false">
        <ul id="tree2" class="mini-tree" url="${pageContext.request.contextPath}/menu/loadMenuTree.do" style="width:200px;padding:5px;height: 300px;" 
	        showTreeIcon="true" onnodeclick="onNodeClick" textField="menuName" idField="menuId" parentField="menuPid" resultAsTree="false"  expandOnLoad="true"
	        onbeforenodecheck="onBeforeNodeCheck" allowSelect="false" enableHotTrack="false" iconField="iconCls"
	        
	        >
	    </ul>
    </div>
    <div title="center" region="center" style="width:100%;border-bottom:0;padding:0px;">
	        <div class="mini-toolbar" style="width:100%;border-bottom:0;padding:0px;">
	            <a class="mini-button" iconCls="icon-save" onclick="save()">确定</a>
	        </div>
	    <div class="mini-fit" >
	    <div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%;" allowResize="false" allowCellEdit="true"
	        url="${pageContext.request.contextPath}/menu/loadCheckedPrivileges.do?menuId=0&roleId=${roleId}"  idField="id" multiSelect="true" showPager="false"
	    >
	        <div property="columns">
	            <div type="indexcolumn"></div>       
<!-- 	            <div type="checkcolumn" ></div> -->
	            <div type="checkboxcolumn" field="checked" trueValue="true" falseValue="false" width="60" headerAlign="center">授权</div>         
	            <div field="privilegeType" width="120" headerAlign="center" allowSort="true">资源名称</div>    
	        </div>
	    </div>
	 </div>
	 </div>
</div>
    
    <script type="text/javascript">
		mini.parse();
		var grid = mini.get("datagrid1");
		
		var menuId;
        function onNodeClick(e) {
            var node = e.node;
		    menuId = node.menuId;
            $.ajax({
                url: "${pageContext.request.contextPath}/menu/loadCheckedPrivileges.do",
                data: { roleId: '${roleId}', menuId: menuId},
                type: "post",
                success: function (text) {
                	grid.load();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
        }
        
        function save() {
        	var data = grid.data;
        	var json = mini.encode(data);
        	alert(data);
        	$.ajax({
                url: "${pageContext.request.contextPath}/menuPrivilege/updateMenuPrivilege.do",
                data: { data: json, roleId: '${roleId}', menuId: menuId},
                type: "post",
                success: function (text) {
                	grid.load();
                },
                error: function (jqXHR, textStatus, errorThrown) {
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
