<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>
<html>
<head>
<title>权限控制主页</title>
</head>
<style type="text/css">
    html, body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
</style>
<body>

 <div id="layout1" class="mini-layout" style="width:100%;height:100%;">
    <div title="用户组" showProxyText="true" region="west" width="200" expanded="true" showSplitIcon="false">
<!--      	<input type="text" id="text" style="width:110px" /> -->
<!--     	<input type="button" value="查询" onclick="filter()" style="margin-left:20px;font-weight:bold;"/> -->
        <ul id="tree110" class="mini-tree" url="${pageContext.request.contextPath}/privilege/roleTree.do"
		        showTreeIcon="true" textField="TEXT" idField="ID" parentField="PID" resultAsTree="false"
		        expandOnLoad="true" onnodeclick="onNodeClick" style="width:100%;height:90%;" 
		        >
	   	</ul>
    </div>
    <div title="center" region="center" style="width:100%;border-bottom:0;padding:0px;">
    	<iframe id="mainframe" frameborder="0" name="main" style="width:100%;height:100%;" border="0"></iframe>
    </div>
    
</div>
    <script type="text/javascript">
    
	    var iframe = document.getElementById("mainframe");
	    
        $(function(){
        	
        	mini.parse();
        	iframe.src = "${pageContext.request.contextPath}/jsp/authorization/privilegeTabs.jsp?roleId=''";
        });
  

		function onNodeClick(e){
			var node = e.node;
			var name = node.TEXT;
			//var logtype = node.LOGTYPE;
		    var isLeaf = e.isLeaf;
		    var roleId = node.ID;
		    
	        if (isLeaf) {
		        iframe.src = "${pageContext.request.contextPath}/jsp/authorization/privilegeTabs.jsp?roleId="+roleId+"";
	        } 
		}
		
		function filter(){
		    var tree = mini.get("tree1")

		    var text = document.getElementById("text").value;
		    
		    var msgid = mini.loading("数据查询中，请稍后......");
		    $.ajax({
		        url: "../data/TreeService.aspx?method=FilterTree",
		        data: { name: text },
		        type: "post",
		        success: function (text) {
		            var data = mini.decode(text);
		            tree.loadList(data);
		            tree.expandAll();
		            mini.hideMessageBox(msgid);
		        },
		        error: function (jqXHR, textStatus, errorThrown) {
		            alert(jqXHR.responseText);
		        }
		    });
		}	
		
		
		function getTree() {
			var tree = mini.get("tree1");
			return tree;
		}
    </script>
    

</body>
</html>