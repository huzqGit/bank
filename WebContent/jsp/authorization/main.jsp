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
            <ul id="tree1" class="mini-tree" url="${pageContext.request.contextPath}/menu/menuList.do"
		        showTreeIcon="true" textField="TEXT" idField="ID" parentField="PID" resultAsTree="false"
		        expandOnLoad="false" onnodeclick="onNodeClick" style="width:100%;height:100%;"
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
    </script>
    

</body>
</html>