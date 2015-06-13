<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>	    

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<style type="text/css">
    html, body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
</style>
<body>
    
<div id="layout1" class="mini-layout" style="width:100%;height:100%;">
    <div title="组织机构" showProxyText="true" region="west" width="200" expanded="true" showSplitIcon="false">
            <ul id="tree1" class="mini-tree" url="${pageContext.request.contextPath}/user/organTree.do"
		        showTreeIcon="true" textField="TEXT" idField="ID" parentField="PID" resultAsTree="false"
		        expandOnLoad="true" onnodeclick="onNodeClick" style="width:100%;height:100%;"
		       >
	   		 </ul>
    </div>
    <div title="center" region="center" style="width:100%;border-bottom:0;padding:0px;">
    	<iframe id="mainframe" frameborder="0" name="main" style="width:100%;height:100%;" border="0"></iframe>
    </div>
</div>
    <script type="text/javascript">
    
        mini.parse();
        
	   var iframe = document.getElementById("mainframe");
	   iframe.src = "${pageContext.request.contextPath}/jsp/authorization/userView.jsp";

		function onNodeClick(e){
			var node = e.node;
			var name = node.TEXT;
			var logtype = node.LOGTYPE;
		    var nodeId = node.ID;
		    
		    iframe.src = "${pageContext.request.contextPath}/jsp/authorization/userView.jsp?organId="+nodeId;
	        
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
	            		    url: "${pageContext.request.contextPath}/user/deleteUser.do",
	            		    type: "post",
	            		    data: { userId: userId},
	            		    success: function (text) {
	            		        mini.alert('删除成功');
	            		        tree.removeNode(node);
	            		    }
	            		});
	                } else {
	                    
	                }
	            }
	        );
		}
		
		function getTree() {
			var tree = mini.get("tree1");
			return tree;
		}
    </script>
    

</body>
</html>