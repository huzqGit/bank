<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script> --%>
<title>权限控制主页</title>
</head>
<style type="text/css">
    html, body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
</style>
<body>

 <div id="layout1" class="mini-layout" style="width:100%;height:100%;">
    <div title="菜单" showProxyText="true" region="west" width="200" expanded="true" showSplitIcon="false">
        <ul id="tree1" class="mini-tree" url="${pageContext.request.contextPath}/menu/loadMenuTree.do"
		        showTreeIcon="true" textField="menuName" idField="menuId" parentField="menuPid" resultAsTree="false"
		        expandOnLoad="true" onnodeclick="onNodeClick" style="width:100%;height:100%;" contextMenu="#treeMenu"
		        >
	   		 </ul>
    </div>
    <div title="center" region="center" style="width:100%;border-bottom:0;padding:0px;">
    	<iframe id="mainframe" frameborder="0" name="main" style="width:100%;height:100%;" border="0"></iframe>
    </div>
    
</div>

<ul id="treeMenu" class="mini-contextmenu"  onbeforeopen="onBeforeOpen">        
    <li name="add" iconCls="icon-add" onclick="onAddNode">新增菜单</li>
	<li name="edit" iconCls="icon-edit" onclick="onEditNode">编辑节点</li>
	<li name="remove" iconCls="icon-remove" onclick="onRemoveNode">删除节点</li>
	<li class="separator"></li>
	<li name="editR" iconCls="icon-edit" onclick="onEditRNode">维护资源类型</li>
</ul>
    <script type="text/javascript">
        mini.parse();
	    var iframe = document.getElementById("mainframe");
	    iframe.src = "${pageContext.request.contextPath}/jsp/authorization/menu.jsp";

		function onNodeClick(e){
			var node = e.node;
			var name = node.TEXT;
			var logtype = node.LOGTYPE;
		    var isLeaf = e.isLeaf;
		    var menuId = node.menuId;
	        if (isLeaf) {
		        iframe.src = "${pageContext.request.contextPath}/jsp/authorization/menu.jsp?actionType=edit&menuId="+menuId+"";
	        } else {
	        	iframe.src = "${pageContext.request.contextPath}/jsp/authorization/menu.jsp?actionType=edit&menuId="+menuId+"";
		    }
		}
		
		function onBeforeOpen(e) {
		    var menu = e.sender;
		    var tree = mini.get("tree1");

		    var node = tree.getSelectedNode();
		    if (!node) {
		        e.cancel = true;
		        return;
		    }
		    if (node && node.text == "Base") {
		        e.cancel = true;
		        //阻止浏览器默认右键菜单
		        e.htmlEvent.preventDefault();
		        return;
		    }

		    ////////////////////////////////
		    var addItem = mini.getbyName("add", menu);
		    var editItem = mini.getbyName("edit", menu);
		    var removeItem = mini.getbyName("remove", menu);
		    
		    addItem.show();
	        editItem.show();
	    	removeItem.show();
	    	
		    if (node.isLeaf == 1) {
		    	addItem.hide();
		        editItem.show();
		    	removeItem.show();
		    } else {
		    	addItem.show();
		        editItem.hide();
		    	removeItem.hide();
		    }
		}
		//维护资源类型
		function onEditRNode() {
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/privilegeView.jsp";
		}
		//新增菜单
		function onAddNode() {
			var tree = mini.get("tree1");
		    var node = tree.getSelectedNode();
		    var menuId = node.menuId;
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/menu.jsp?actionType=add&menuPid="+menuId+"";
		}
		//新增父菜单
		/* function onAddPNode() {
			var tree = mini.get("tree1");
		    var node = tree.getSelectedNode();
		    var menuId = node.ID;
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/menu.jsp?actionType=add&menuId="+menuId+"";
		} */
		//编辑菜单
		function onEditNode() {
			var tree = mini.get("tree1");
		    var node = tree.getSelectedNode();
		    var menuId = node.menuId;
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/menu.jsp?actionType=edit&&menuId="+menuId+"";
		}
		//编辑父菜单
		/* function onEditPNode() {
			var tree = mini.get("tree1");
		    var node = tree.getSelectedNode();
		    var menuId = node.ID;
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/menu.jsp?actionType=edit&&menuId="+menuId+"";
		} */
		//删除菜单
		function onRemoveNode() {
			var tree = mini.get("tree1");
		    var node = tree.getSelectedNode();
		    var menuId = node.menuId;
			iframe.src = "${pageContext.request.contextPath}/menu/delete.do?menuId="+menuId+"";
		}
		//删除父菜单
		/* function onRemovePNode() {
			var tree = mini.get("tree1");
		    var node = tree.getSelectedNode();
		    var menuId = node.ID;
			iframe.src = "${pageContext.request.contextPath}/jsp/menu/delete.do?menuId="+menuId+"";
		} */
		
		function getTree() {
			var tree = mini.get("tree1");
			return tree;
		}
    </script>
    

</body>
</html>