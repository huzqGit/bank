<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>

<%
String organId = request.getParameter("organId");
request.setAttribute("organId", organId);
%>
<html>
<head>
    <title>Fit Layout</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<%-- 	<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script> --%>

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
                <a class="mini-button" iconCls="icon-add" plain="true" onclick="add();">新增</a>
                <a class="mini-button" iconCls="icon-add" plain="true" onclick="edit()">编辑</a>
                <a class="mini-button" iconCls="icon-remove" plain="true" onclick="remove()">删除</a>
            </td>
            <td style="white-space:nowrap;"><label style="font-family:Verdana;">名称: </label>
                <input id="key" class="mini-textbox"/>
                <a class="mini-button" iconCls="icon-search" plain="true" onclick="onSearch()">查询</a>
                </td>
            </tr>
        </table>
    </div>
    <!--撑满页面-->
    <div class="mini-fit" >
        <div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%;" 
            url="${pageContext.request.contextPath}/user/loadAllUsers.do?selectOrganId=${organId}" idField="id" 
            sizeList="[5,10,20,50]" pageSize="50"  multiSelect="true" allowResize="true">
            	<div property="columns">
                <div type="checkcolumn"></div> 
                <div field="userId" width="120" headerAlign="center"  allowSort="true" >员工帐号</div>
                <div field="userName" width="120" headerAlign="center" allowSort="true">员工姓名</div>    
                <div field="sex" width="100" renderer="onGenderRenderer" headerAlign="center">性别</div>
                <div field="birthday" width="100" headerAlign="center" align="center" renderer="onBirthdayRenderer"  allowSort="true">生日</div>                
            </div>
        </div> 

    </div>
    
    <script type="text/javascript">
        mini.parse();
        var grid = mini.get("datagrid1");
        grid.load();

        function onSearch() {
        	var key = mini.get("key").getValue();
            grid.load({ key: key });
        }
        ///////////////////////////////////////////////////////
        var Genders = [{ id: 1, text: '男' }, { id: 2, text: '女'}];
        function onGenderRenderer(e) {
            for (var i = 0, l = Genders.length; i < l; i++) {
                var g = Genders[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }
        
        function onBirthdayRenderer(e) {
            var value = e.value;
            if (value) return mini.formatDate(value, 'yyyy-MM-dd');
            return "";
        }
        
        function add() {
        	var organId = '${organId}';
        	 mini.open({
        		 url : "${pageContext.request.contextPath}/jsp/authorization/userForm.jsp?actionType=add&organId="+organId+"",
                 title: "新增用户", width: 700, height: 500,
                 ondestroy: function (action) {
                     grid.reload();
                 }
             });
        	
        }
        
        function edit() {
        	var organId = '${organId}';
            var row = grid.getSelected();
            if (row) {
                mini.open({
                	url : "${pageContext.request.contextPath}/jsp/authorization/userForm.jsp?actionType=edit&userId="+row.userId+"&organId="+organId+"",
                    title: "编辑用户", width: 700, height: 500,
                    ondestroy: function (action) {
                        grid.reload();
                    }
                });
                
            } else {
                alert("请选中一条记录");
            }
            
        }
        function remove() {
            
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
                if (confirm("确定删除选中记录？")) {
                    var ids = [];
                    for (var i = 0, l = rows.length; i < l; i++) {
                        var r = rows[i];
                        ids.push(r.userId);
                    }
                    var id = ids.join(',');
                    grid.loading("操作中，请稍后......");
                    $.ajax({
                        url: "${pageContext.request.contextPath}/user/deleteUser.do",
                        type: "post",
                        data : {userId : id},
                        success: function (text) {
                            grid.reload();
                        },
                        error: function () {
                        }
                    });
                }
            } else {
                alert("请选中一条记录");
            }
        }
        
    </script>

</body>
</html>
