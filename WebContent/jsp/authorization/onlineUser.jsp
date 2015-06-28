<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>
<html>
<head>
    <title>在线用户统计</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
</head>
    <style type="text/css">
    html, body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
    </style>
<body > 
    <!--撑满页面-->
    <div class="mini-fit" >
        <div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%;" 
            url="${pageContext.request.contextPath}/user/onLineUser.do?" idField="id" 
            sizeList="[5,10,20,50]" pageSize="50"  multiSelect="true" allowResize="true">
            	<div property="columns">
                <div field="user.userName" width="120" headerAlign="center"  allowSort="true" >登录名</div>
                <div field="curData" width="120" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">登录时间</div>    
                <div field="userIP" width="100" align="center" headerAlign="center">IP地址</div>
                <div field="unit.organName" width="100" headerAlign="center" allowSort="true">所在单位</div>                
            </div>
        </div> 

    </div>
    
    <script type="text/javascript">
        mini.parse();
        var grid = mini.get("datagrid1");
        grid.load();
        
    </script>

</body>
</html>
