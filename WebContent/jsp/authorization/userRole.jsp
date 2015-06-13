<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>
<%
String roleId = request.getParameter("roleId");
request.setAttribute("roleId", roleId);
%>
<html>
<head>
    <title>CheckBoxTree</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<%--     <script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script> --%>
</head>
<body style="">
<div id="div" style="margin-left: 20px ;margin-right: 20px">
    <div>
    <ul id="tree2" class="mini-tree" url="${pageContext.request.contextPath}/organ/userCheckTree.do?roleId=${roleId}" style="width:auto;padding:5px;height: auto;" 
        showTreeIcon="true" textField="TEXT" idField="ID" parentField="PID" resultAsTree="false"  expandOnLoad="true"
        showCheckBox="true" checkRecursive="true" 
        onbeforenodecheck="onBeforeNodeCheck" allowSelect="false" enableHotTrack="false" iconField="ICONCLS" 
        
        >
    </ul>
    </div>
	<div style="text-align:center;padding:10px;">   		 
    <a class="mini-button" iconCls="icon-add" onclick="checkAll">选择所有</a>
    <a class="mini-button" iconCls="icon-remove" onclick="uncheckAll">取消选择所有</a>
	<a class="mini-button" iconCls="icon-save" onclick="getCheckedNodes">确定</a>
    </div>
    </div>
    <script type="text/javascript">
		mini.parse();
		
        function getCheckedNodes() {
            var tree = mini.get("tree2");
            //var value = tree.getValue(false);
            var nodes = tree.getCheckedNodes();
            var nodeStr = "";
            for (var i = 0; i < nodes.length; i++) {
				if (nodes[i].ICONCLS == 'icon-user') {
					if (i == (nodes.length - 1)) {
						nodeStr += nodes[i].ID;
					} else {
						nodeStr += nodes[i].ID + ",";
					}
				}
			}
            $.ajax({
                url: "${pageContext.request.contextPath}/userRole/saveUserRoles.do?roleId=${roleId}&data="+nodeStr,
                data: { data: nodeStr},
                type: "post",
                success: function (text) {
                	mini.alert("保存成功！");
                	//CloseWindow("save");
                    //window.parent.getGrid().load();
                    
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                    CloseWindow();
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
       
        ///////////////////////////////////
        function CloseWindow(action) {            
            if (action == "close" && form.isChanged()) {
                if (confirm("数据被修改了，是否先保存？")) {
                    return false;
                }
            }
            if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
            else window.close();            
        }
        /* function onOk(e) {
            SaveData();
        } */
        function onCancel(e) {
            CloseWindow("cancel");
        }
    </script>
</body>
</html>
