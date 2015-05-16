<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Fit Layout</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>

</head>
<title>Insert title here</title>
    <style type="text/css">
    html, body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
    </style>
<style>
*{
margin:0;
padding:0;
}
 .topMenu{
 	width:100%;
 	margin:auto auto;
 	height:90px;
 	border:1px solid #8AD3E9;
 	background-image:url(/bank/images/FaBu.png);
 	background-repeat:no-repeat;
    /* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
	endColorstr = 'white' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
	endColorstr = 'white' )"; 
    }

</style>
<body >   
<div class="topMenu">
<table width="100%">
<tr>
<td width="70%">
	<fieldset style="width:100%;margin-top:10px;margin-left:auto;margin-right:auto;border:0">
	<legend style="width:100%;height:74px;background:url(/bank/images/msgtips.png) no-repeat"></legend>
	</fieldset>
</td>
<td width="30%">
<form action="/bank/jsp/common/bankPublishForm.jsp?actionType=add" method="post">
	<input type="submit" value=""  
		style="width:65px;height:30px;line-height:30px;border:0;
		background:url(/bank/images/publish.png) no-repeat"/>
</form>	
</td>
</tr>
</table>
</div>
<div class="mini-toolbar" style="padding:2px;border-bottom:0;">
        <table style="width:100%;">
            <tr>
            <td style="width:100%;">
                <a class="mini-button" iconCls="icon-add" plain="true" onclick="add();">新增</a>
                <a class="mini-button" iconCls="icon-close" plain="true" onclick="del();">删除</a>
                <span class="separator"></span>
                <a class="mini-button" iconCls="icon-reload" plain="true">刷新</a>
            </td>
            <td style="white-space:nowrap;"><label style="font-family:Verdana;">发布人或内容: </label>
                <input id="key" class="mini-textbox"/>
                <a class="mini-button" iconCls="icon-search" plain="true" onclick="onSearch()">查询</a>
                </td>
            </tr>
        </table>
    </div>
    <!--撑满页面-->
    <div class="mini-fit" >
        
        <div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%;" 
            url="${pageContext.request.contextPath}/message/loadAllMessages.do" idField="id"
            sizeList="[5,10,20,50]" pageSize="10"
        >
            <div property="columns">
                <div type="indexcolumn" ></div>
<!--                 <div field="messageId" width="120" headerAlign="center" allowSort="true" visable="false"></div> -->
<!--                 <div field="userId" width="120" headerAlign="center" allowSort="true" visable="false">帐号</div> -->
                <div field="userName" width="120" headerAlign="center" allowSort="true">发布人</div>    
                <div field="publishDate" width="100" headerAlign="center" dateFormat='yyyy-MM-dd HH:mm:ss' allowSort="true">发布时间</div>                
            	<div field="messageContent" width="120" headerAlign="center" allowSort="true">发布内容</div>  
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
        
        function add() {
        	window.location.href = "${pageContext.request.contextPath}/jsp/common/bankPublishForm.jsp?actionType=add";
        }
        
        function del(){
        	var data = grid.getSelecteds();
		    var messageId = data[0].messageId;
			mini.confirm("确定删除该信息？", "确定？",
	            function (action) {
	                if (action == "ok") {
	                	$.ajax({
	            		    url: "${pageContext.request.contextPath}/message/deleteMessage.do?messageId="+messageId+"",
	            		    type: "post",
	            		    success: function (text) {
	            		        mini.alert('删除成功');
	            		        grid.load();
	            		    }
	            		});
	                } else {
	                    
	                }
			});  
        }
    </script>
</body>
</html>