<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Fit Layout</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
	<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>

</head>
<title>Insert title here</title>

<body >   

    <!--撑满页面-->
        <div class="queryPane">
<table width="100%">
<tr>
<td width="80%" style="text-align:center;font-size:26px;font-weight:bold;color:black">
消息管理
</td>
<td width="20%" align="center">
<form action="/bank/jsp/common/bankPublishForm.jsp?actionType=add" method="post">
	<input type="button" value="新增" onclick="add()" class="bank-btn"/>
</form>	
</td>
</tr>
</table>
</div>
        <div id="datagrid1" class="mini-datagrid mini-fit" style="width:100%;height:400px;" 
            url="${pageContext.request.contextPath}/message/loadAllMessages.do" idField="id"
            sizeList="[5,10,20,50]" pageSize="10"
        >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <div field="title" width="120" headerAlign="center" allowSort="true">标题</div> 
                <div field="username" width="120" headerAlign="center" allowSort="true">发布人</div>    
                <div field="publishdate" width="100" headerAlign="center" dateFormat='yyyy-MM-dd' allowSort="true">发布时间</div>                
            	<div field="content" width="120" headerAlign="center" allowSort="true">发布内容</div>  
          		<div name="action" width="5%" headerAlign="center" align="center" renderer="editRenderer" cellStyle="padding:0;"></div>
	        	<div name="action" width="5%" headerAlign="center" align="center" renderer="deleteRenderer" cellStyle="padding:0;"></div>
            </div>
        </div> 
     <script type="text/javascript">
        mini.parse();
        var grid = mini.get("datagrid1");
        grid.load();
        
        function add() {
        	window.location.href = "${pageContext.request.contextPath}/jsp/common/bankPublishForm.jsp?actionType=add";
        }
        
        function del(id){
			mini.confirm("确定删除该信息？", "确定？",
	            function (action) {
	                if (action == "ok") {
	                	$.ajax({
	            		    url: "${pageContext.request.contextPath}/message/deleteMessage.do?messageid="+id+"",
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
        function editRenderer(e) {
    	    var record = e.record;
    	    var messageid = record.messageid;
    	    var s = '<a class="Edit_Button" target="_self" href="/bank/message/editMessage.do?messageid='+messageid+'">[编辑]</a>';      
    	    return s;
    	};
    	function deleteRenderer(e) {
    	    var record = e.record;
    	    var messageid = record.messageid;
    	    var s = '<a class="New_Button" target="_self" href="javascript:del('+messageid+')">[删除]</a>';      
    	    return s;
    	};
    </script>
</body>
</html>