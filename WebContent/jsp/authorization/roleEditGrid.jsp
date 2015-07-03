<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>
<html>
<head>
    <title>用户组维护</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />

</head>
    <style type="text/css">
    html, body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
    </style>
<body >   
    <div class="mini-toolbar" style="padding:2px;border-bottom:0;">
        <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-add" onclick="addRow()" plain="true">增加</a>
                        <a class="mini-button" iconCls="icon-remove" onclick="removeRow()" plain="true">删除</a>
                        <span class="separator"></span>
                        <a class="mini-button" iconCls="icon-save" onclick="saveData()" plain="true">保存</a>            
                    </td>
                    <td style="white-space:nowrap;">
                        <input id="key" class="mini-textbox" emptyText="请输入" style="width:150px;" onenter="onKeyEnter"/>   
                        <a class="mini-button" onclick="search()">查询</a>
                    </td>
                </tr>
            </table>   
    </div>
    <!--撑满页面-->
    <div class="mini-fit" >
        
         <div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%;" 
		        url="${pageContext.request.contextPath}/role/loadRoles.do" idField="id"
		        allowResize="true" pageSize="20" showPager="false"
		        allowCellEdit="true" allowCellSelect="true" multiSelect="true" 
		        editNextOnEnterKey="true" 
		        
		    >
            <div property="columns">
                <div type="indexcolumn"></div>
                <div type="checkcolumn"></div>
                <div field="roleId" allowResize="false" width="120" headerAlign="center" visible="false" allowSort="true">用户组ID
	            </div>
	            <div field="roleName" allowResize="false" width="120" headerAlign="center" allowSort="true">用户组名称
	                <input property="editor" class="mini-textbox" style="width:100%;" required="true" requiredErrorText="不能为空"/>
	            </div>
                <div field="roleDescr" allowResize="false" width="120" headerAlign="center" allowSort="true">用户组描述
	                <input property="editor" class="mini-textbox" style="width:100%;" required="true" requiredErrorText="不能为空"/>
	            </div>
<!--                 <div name="action" width="120" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;">维护人员 -->
<!--                 </div> -->
            </div>
        </div> 

    </div>
    
    <script type="text/javascript">
        mini.parse();
        var grid = mini.get("datagrid1");
        grid.load();
		
        function onActionRenderer(e) {
            var grid = e.sender;
            var record = e.record;
            var uid = record._uid;
           // alert(uid + "==========" + record.roleId);
            var rowIndex = e.rowIndex;

            var s = '<a class="mini-button" iconCls="icon-edit" href="javascript:editUsers(\'' + record.roleId + '\')">维护用户</a> <a class="mini-button" iconCls="icon-edit" href="javascript:editMenus(\'' + record.roleId + '\')">维护菜单</a> ';
                       
            return s;
        }
        
        function search() {       
            var key = mini.get("key").getValue();
            grid.load({ key: key });
        }

        function onKeyEnter(e) {
            search();
        }
        
        function addRow() {          
            var newRow = { name: "New Row" };
            grid.addRow(newRow, 0);
        }
        
        function removeRow() {
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
                grid.removeRows(rows, true);
            }
        }
        
        function saveData() {
            var data = grid.getChanges();
            var json = mini.encode(data);
            grid.loading("保存中，请稍后......");
            $.ajax({
                url: "${pageContext.request.contextPath}/role/saveRoles.do",
                data: { data: json },
                type: "post",
                success: function (text) {
                    grid.reload();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
        }
        
        function editUsers(roleId) {
        	var win = mini.open({
                title: '维护用户',
                url: '${pageContext.request.contextPath}/jsp/authorization/userRole.jsp?roleId=' + roleId,
                showModal: false,
                width: 400,
                height: 400
            });
        }
        
        function editMenus(roleId) {
        	var win = mini.open({
                title: '维护菜单',
                url: '${pageContext.request.contextPath}/jsp/authorization/menuPrivilegeRole.jsp?roleId=' + roleId,
                showModal: false,
                width: 800,
                height: 600
            });
        }
        
        function getGrid() {
        	var grid = mini.get("datagrid1");
        	return grid;
        }
    </script>

</body>
</html>
