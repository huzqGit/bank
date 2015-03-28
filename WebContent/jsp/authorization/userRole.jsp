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
    <h1></h1>
    <div>
    <ul id="tree2" class="mini-tree" url="${pageContext.request.contextPath}/organ/userCheckTree.do?roleId=${roleId}" style="width:200px;padding:5px;height: 300px;" 
        showTreeIcon="true" textField="TEXT" idField="ID" parentField="PID" resultAsTree="false"  expandOnLoad="true"
        showCheckBox="true" checkRecursive="true" 
        onbeforenodecheck="onBeforeNodeCheck" allowSelect="false" enableHotTrack="false" iconField="ICONCLS" 
        
        >
    </ul>
    </div>
	<div style="" align="center">   		 
    <a class="mini-button" iconCls="icon-add" onclick="checkAll">选择所有</a>
    <a class="mini-button" iconCls="icon-add" onclick="uncheckAll">取消选择所有</a>
	<a class="mini-button" iconCls="icon-save" onclick="getCheckedNodes">确定</a>
	<a class="mini-button" iconCls="icon-remove" onclick="getCheckedNodes">取消</a>
    <br />
    </div>
    <script type="text/javascript">
		mini.parse();
		
        function getCheckedNodes() {
            var tree = mini.get("tree2");
            //var value = tree.getValue(false);
            var nodes = tree.getCheckedNodes();
            var nodeStr = "";
            for (var i = 0; i < nodes.length; i++) {
				if (nodes[i].ICONCLS == 'icon-edit') {
					if (i == (nodes.length - 1)) {
						nodeStr += nodes[i].ID;
					} else {
						nodeStr += nodes[i].ID + ",";
					}
				}
			}
            alert(nodeStr);
            $.ajax({
                url: "${pageContext.request.contextPath}/userRole/saveUserRoles.do?roleId=${roleId}",
                data: { data: nodeStr},
                type: "post",
                success: function (text) {
                    window.parent.getGrid().load();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
        }
        function checkAll() {
            var tree = mini.get("tree2");
            var nodes = tree.getAllChildNodes(tree.getRootNode());
            tree.checkNodes(nodes);
        }
        function uncheckAll() {
            var tree = mini.get("tree2");
            var nodes = tree.getAllChildNodes(tree.getRootNode());
            tree.uncheckNodes(nodes);
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
