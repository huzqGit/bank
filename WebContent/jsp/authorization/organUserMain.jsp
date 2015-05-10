<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组织机构</title>
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
            <ul id="tree1" class="mini-tree" url="${pageContext.request.contextPath}/organ/organUserTree.do"
		        showTreeIcon="true" textField="TEXT" idField="ID" parentField="PID" resultAsTree="false"
		        expandOnLoad="true" onnodeclick="onNodeClick" style="width:100%;height:100%;" contextMenu="#treeMenu"
		        iconField='ICONCLS'  
		        
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
    <li name="addOrgan" iconCls="icon-add" onclick="onAddOrganNode">新增机构</li>
	<li name="addUser" iconCls="icon-edit" onclick="onAddUserNode">新增用户</li>
   <!--  <li class="separator"></li> -->
	<li name="removeOrgan" iconCls="icon-remove" onclick="onRemoveOrganNode">删除机构</li>   
	<li name="removeUser" iconCls="icon-remove" onclick="onRemoveUserNode">删除用户</li>
	<li class="separator"></li>
	<li name="managerRole" iconCls="icon-edit" onclick="onManagerRoleNode">维护用户组</li>
</ul>
    <script type="text/javascript">
        mini.parse();
	    var iframe = document.getElementById("mainframe");
	    iframe.src = "${pageContext.request.contextPath}/jsp/authorization/userView.jsp";

		function onNodeClick(e){
			var node = e.node;
			var name = node.TEXT;
			var logtype = node.LOGTYPE;
		    var nodeId = node.ID;
		    
	        if (node.ICONCLS == 'icon-edit') {
		        iframe.src = "${pageContext.request.contextPath}/jsp/authorization/userForm.jsp?actionType=edit&userId="+nodeId+"";
	        } else {
	        	iframe.src = "${pageContext.request.contextPath}/jsp/authorization/organForm.jsp?actionType=edit&organId="+nodeId+"";
		    }
	        
		}
		
		function onBeforeOpen(e) {
		    var menu = e.sender;
		    var tree = mini.get("tree1");

		    var node = tree.getSelectedNode();
		    if (!node) {
		        e.cancel = true;
		        e.htmlEvent.preventDefault();
		        return;
		    }
		    if (node && node.text == "Base") {
		        e.cancel = true;
		        //阻止浏览器默认右键菜单
		        e.htmlEvent.preventDefault();
		        return;
		    }

		    ////////////////////////////////
		    var addOrganItem = mini.getbyName("addOrgan", menu);
		    var removeOrganItem = mini.getbyName("removeOrgan", menu);
		    var addUserItem = mini.getbyName("addUser", menu);
		    var removeUserItem = mini.getbyName("removeUser", menu);
		    var managerRoleItem = mini.getbyName("managerRole", menu);
		    
		    addOrganItem.show();
		    removeOrganItem.show();
	    	addUserItem.show();
	    	removeUserItem.show();
	    	managerRoleItem.show();
	    	
		    if (node.ICONCLS == 'icon-edit') {
		    	addOrganItem.hide();
		    	removeOrganItem.hide();
		    	addUserItem.hide();
		    } else {
		    	removeUserItem.hide();
		    }
		}
		
		//新增机构
		function onAddOrganNode(e) {
			var tree = mini.get("tree1");
            var node = tree.getSelectedNode();
            
			var organPid = node.ID;
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/organForm.jsp?actionType=add&organPid="+organPid+"";
		}
		//新增用户
		function onAddUserNode(e) {
			var tree = mini.get("tree1");
            var node = tree.getSelectedNode();
			var organId = node.ID;
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/userForm.jsp?actionType=add&organId="+organId+"";
		}
		//删除机构
		function onRemoveOrganNode(e) {
			var tree = mini.get("tree1");
            var node = tree.getSelectedNode();
			var organId = node.ID;
			iframe.src = "${pageContext.request.contextPath}/organ/deleteOrgan.do?organId="+organId+"";
			tree.load();
		}
		//删除用户
		function onRemoveUserNode(e) {
			var tree = mini.get("tree1");
            var node = tree.getSelectedNode();
			var userId = node.ID;
			mini.confirm("确定删除用户？", "确定？",
	            function (action) {
	                if (action == "ok") {
	                	$.ajax({
	            		    url: "${pageContext.request.contextPath}/user/deleteUser.do?userId="+userId+"",
	            		    type: "post",
	            		    success: function (text) {
	            		        mini.alert('删除成功');
	            		    }
	            		});
	                } else {
	                    
	                }
	            }
	        );
			iframe.src = "${pageContext.request.contextPath}/user/deleteUser.do?userId="+userId+"";
		}
		
		//维护用户组
		function onManagerRoleNode() {
			iframe.src = "${pageContext.request.contextPath}/jsp/authorization/roleEditGrid.jsp";
		}
		
		function getTree() {
			var tree = mini.get("tree1");
			return tree;
		}
    </script>
    

</body>
</html>