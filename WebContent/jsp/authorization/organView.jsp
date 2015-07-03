<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>	
<html>
<head>
    <title>Fit Layout</title>
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
                <a class="mini-button" iconCls="icon-add" plain="true" onclick="add();">新增</a>
                <a class="mini-button" iconCls="icon-close" plain="true">关闭</a>
                <span class="separator"></span>
                <a class="mini-button" iconCls="icon-reload" plain="true">刷新</a>
            </td>
            <td style="white-space:nowrap;"><label style="font-family:Verdana;">名称: </label>
                <input class="mini-textbox" />
                <a class="mini-button" iconCls="icon-search" plain="true" onclick="onSearch()">查询</a>
                </td>
            </tr>
        </table>
    </div>
    <!--撑满页面-->
    <div class="mini-fit" >
        
        <div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%;" 
            url="${pageContext.request.contextPath}/user/loadAllUsers.do" idField="id"
            sizeList="[5,10,20,50]" pageSize="10"
        >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div field="userId" width="120" headerAlign="center" allowSort="true" >员工帐号</div>
                <div field="username" width="120" headerAlign="center" allowSort="true">员工姓名</div>    
                <div field="sex" width="100" renderer="onGenderRenderer" align="center" headerAlign="center">性别</div>
                <div field="birthday" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">生日</div>                
            </div>
        </div> 

    </div>
    
    <script type="text/javascript">
        mini.parse();
        var grid = mini.get("datagrid1");
        grid.hideColumn("userId");
        grid.load();

        function onSearch() {
            mini.open({
                url: bootPATH + "../demo/CommonLibs/SelectGridWindow.html"
            });
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
        
        function add() {
        	window.location.href = "${pageContext.request.contextPath}/jsp/authorization/userForm.jsp?actionType=add";
        }
    </script>

</body>
</html>
