<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>
<html>
<head>
    <title>系统日志</title>
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
	            <td style="white-space:nowrap;">
	            	<label>日志类型: </label>
	            	<input name="operateType" class="mini-combobox" data="[{id: 1, text: '登录'}, {id: 2, text: '退出'}, {id: 3, text: '插入'}, {id: 4, text: '删除'}, {id: 5, text: '更新'}, {id: 6, text: '其他'}]" 
	            	value="30" style='width:60px;'/>
<!-- 	                <input id="operateType" class="mini-textbox"/> &nbsp; -->
	                <label>操作时间: </label>
	                <input id="startDate" class="mini-datepicker"/>
	                <label>&nbsp;~&nbsp;</label>
	                <input id="endDate" class="mini-datepicker"/>
	                <a class="mini-button" iconCls="icon-search" plain="true" onclick="onSearch()">查询</a>
	            </td>
            </tr>
        </table>
    </div>
    <!--撑满页面-->
    <div class="mini-fit" >
        <div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%;" 
            url="${pageContext.request.contextPath}/sysLog/loadAllSysLog.do" idField="id" 
            sizeList="[5,10,20,50]" pageSize="50"  multiSelect="true" allowResize="true">
            	<div property="columns">
                <div field="logContent" width="120" headerAlign="center" allowSort="true" >日志内容</div>
                <div field="note" width="100" align="center" headerAlign="center">操作IP</div>
                <div field="userIP" width="100" align="center" headerAlign="center">操作人ID</div>
                <div field="userId" width="100" align="center" headerAlign="center">操作人名称</div>
                <div field="userName" width="100" headerAlign="center" allowSort="true">浏览器</div> 
                <div field="operateTime" width="120" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">操作时间</div>    
            </div>
        </div> 

    </div>
    
    <script type="text/javascript">
        mini.parse();
        var grid = mini.get("datagrid1");
        grid.load();
        
        function onSearch() {
        	alert("--------------");
        	var operateType = mini.get("operateType").getValue();
        	var startDate = mini.get("startDate").getValue();
        	var endDate = mini.get("endDate").getValue();
            grid.load({ operateType: operateType, startDate: startDate, endDate: endDate });
        }
        
    </script>

</body>
</html>
