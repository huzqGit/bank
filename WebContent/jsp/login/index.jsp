<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>系统主界面</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script> 
    <style type="text/css">
    body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
    .header
    {
        background:url(../header.gif) repeat-x 0 -1px;
    }
    </style>
</head>
<body>    
    
<!--Layout-->
<div id="layout1" class="mini-layout" style="width:100%;height:100%;">
    <div class="header" region="north" height="70" showSplit="false" showHeader="false">
        <h1 style="margin:0;padding:15px;cursor:default;font-family:'Trebuchet MS',Arial,sans-serif;">新安县农村信用信息管理系统</h1>
        <div style="position:absolute;top:48px;left:20px;">
        	欢迎您：${user.userName}
        </div>
        <div style="position:absolute;top:18px;right:10px;">
            <a class="mini-button mini-button-iconTop" iconCls="icon-add" onclick="onQuickClick" plain="true">快捷</a>    
            <a class="mini-button mini-button-iconTop" iconCls="icon-edit" onclick="onClick"  plain="true" >首页</a>        
            <a class="mini-button mini-button-iconTop" iconCls="icon-date" onclick="onClick"  plain="true" >消息</a>        
            <a class="mini-button mini-button-iconTop" iconCls="icon-edit" onclick="onClick"  plain="true" >设置</a>        
            <a class="mini-button mini-button-iconTop" iconCls="icon-close" onclick="onClick"  plain="true" >退出</a>        
            
        </div>
    </div>
    <div title="south" region="south" showSplit="false" showHeader="false" height="30" >
        <div style="line-height:28px;text-align:center;cursor:default">Copyright ©  天下无双</div>
    </div>
    <div title="center" region="center" bodyStyle="overflow:hidden;" style="border:0;">
        <!--Splitter-->
        <div class="mini-splitter" style="width:100%;height:100%;" borderStyle="border:0;">
            <div size="180" maxSize="250" minSize="100" showCollapseButton="true" style="border-width:1px;">
                <!--Tree-->
                <ul id="leftTree" class="mini-tree" url="${pageContext.request.contextPath}/menu/loadMenus.do" style="width:100%;height:100%;" 
                    showTreeIcon="true" textField="menuDescr" idField="menuId" resultAsTree="false" parentField="menuPid"
                    onnodeselect="onNodeSelect" 
                >        
                </ul>
            </div>
            <div showCollapseButton="false" style="border:0px;" >
                <!--Tabs-->
                <div id="mainTabs" class="mini-tabs bg-toolbar" activeIndex="0" style="width:100%;height:100%;"      
                    onactivechanged="onTabsActiveChanged"
                >        
                    <div title="首页" url="../../docs/api/overview.html" >        
                    </div>
                    <div title="子页面关闭" url="../tabs/pages/page1.html" >        
                    </div>
                    <div title="弹出面板" url="../datagrid/datagrid.html" >        
                    </div>
                </div>
            </div>        
        </div>
    </div>
</div>
 
    <script type="text/javascript">
        mini.parse();
 
        var tree = mini.get("leftTree");
 
        function showTab(node) {
            var tabs = mini.get("mainTabs");
 
            var id = "tab$" + node.menuId;
            var tab = tabs.getTab(id);
            if (!tab) {
                tab = {};
                tab._nodeid = node.menuId;
                tab.name = id;
                tab.title = node.menuDescr;
                tab.showCloseButton = true;
 
                //这里拼接了url，实际项目，应该从后台直接获得完整的url地址
                tab.url = "${pageContext.request.contextPath}/" + node.menuUrl;
 
                tabs.addTab(tab);
            }
            tabs.activeTab(tab);
        }
 
        function onNodeSelect(e) {
        
            var node = e.node;
            var isLeaf = e.isLeaf;
 
            if (isLeaf) {
                showTab(node);
            }
        }
 
        function onClick(e) {
            var text = this.getText();
            alert(text);
        }
        function onQuickClick(e) {
            tree.expandPath("datagrid");
            tree.selectNode("datagrid");
        }
 
        function onTabsActiveChanged(e) {
            var tabs = e.sender;
            var tab = tabs.getActiveTab();
            if (tab && tab._nodeid) {
 
                var node = tree.getNode(tab._nodeid);
                if (node && !tree.isSelectedNode(node)) {
                    tree.selectNode(node);
                }
            }
        }
    </script>
 
</body>
</html>