<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<title>权限控制主页</title>
</head>
<style type="text/css">
    html, body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
</style>
<body>
    
<div class="mini-splitter" style="width:100%;height:100%;">
    <div size="200" showCollapseButton="true">
        <div class="mini-fit" style="padding:5px;" >
            <ul id="tree1" class="mini-tree" url="${pageContext.request.contextPath}/menu/loadMenus.do"
		        showTreeIcon="true" textField="menuDescr" idField="menuId" parentField="menuPid" resultAsTree="false"
		        expandOnLoad="true" onnodeclick="onNodeClick" style="width:100%;height:100%;" contextMenu="#treeMenu"
		        >
	   		 </ul>
        </div>
    </div>
    <div showCollapseButton="true">
        <div class="mini-fit" style="width:100%;height:100%;">
             <iframe id="mainframe" frameborder="0" name="main" style="width:100%;height:100%;" border="0"></iframe>
        </div>
    </div>
</div>

<ul id="treeMenu" class="mini-contextmenu"  onbeforeopen="onBeforeOpen">        
    <li name="addP" iconCls="icon-add" onclick="onAddPNode">新增父菜单</li>
    <li class="separator"></li>
    <li>
		<span name="add" iconCls="icon-add">新增菜单</span>
		<ul>
		    <li onclick="onAddBefore">插入节点前</li>                
            <li onclick="onAddAfter">插入节点后</li>	
			<li onclick="onAddNode">插入子节点</li>             
		</ul>
	</li>
	<li name="editP" iconCls="icon-edit" onclick="onEditPNode">编辑父节点</li>
	<li name="edit" iconCls="icon-edit" onclick="onEditNode">编辑节点</li>
	<li name="removeP" iconCls="icon-remove" onclick="onRemovePNode">删除父节点</li>   
	<li name="remove" iconCls="icon-remove" onclick="onRemoveNode">删除节点</li>
	<li class="separator"></li>
	<li name="editR" iconCls="icon-edit" onclick="onEditRNode">维护资源类型</li>
</ul>
    <script type="text/javascript">
        mini.parse();
	    var iframe = document.getElementById("mainframe");
	    iframe.src = "${pageContext.request.contextPath}/jsp/authorization/userView.jsp";

		function onNodeClick(e){
			var node = e.node;
			var name = node.TEXT;
			var logtype = node.LOGTYPE;
		    var isLeaf = e.isLeaf;
	        if (isLeaf) {
		        iframe.src = "${pageContext.request.contextPath}/jsp/authorization/userView.jsp?actionType=edit&userId=1";
	        } else {
	        	 
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
		    var addPItem = mini.getbyName("addP", menu);
		    var editPItem = mini.getbyName("editP", menu);
		    var removePItem = mini.getbyName("removeP", menu);
		    
		    addItem.show();
	        editItem.show();
	    	removeItem.show();
	    	addPItem.show();
	        editPItem.show();
	    	removePItem.show();
	    	
		    if (tree.isLeaf(node)) {
		    	addItem.show();
		        editItem.show();
		    	removeItem.show();
		    	addPItem.hide();
		        editPItem.hide();
		    	removePItem.hide();
		    } else {
		    	addPItem.show();
		        editPItem.show();
		    	removePItem.show();
		    	addItem.hide();
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
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/privilegeView.jsp";
		}
		//新增父菜单
		function onAddPNode() {
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/privilegeView.jsp";
		}
		//编辑菜单
		function onEditNode() {
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/privilegeView.jsp";
		}
		//编辑父菜单
		function onEditPNode() {
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/privilegeView.jsp";
		}
		//删除菜单
		function onEditNode() {
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/privilegeView.jsp";
		}
		//删除父菜单
		function onEditPNode() {
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/privilegeView.jsp";
		}
    </script>
    

</body>
</html>