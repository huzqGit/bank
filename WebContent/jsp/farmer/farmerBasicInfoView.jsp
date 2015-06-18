<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<title>农户信息单户信息查询</title>
<style type="text/css">
*{margin:0;padding:0}
body{line-height:120%;font-family:"仿宋_GB2312";font-size:13pt;}
.queryPane{
background:linear-gradient(#6DC8E3,white);
/* IE6 & IE7 */
filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
endColorstr = 'white' ); 
/* IE8 */
-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
endColorstr = 'white' )"; 
}
.labelName{font-family:"仿宋_GB2312";font-size:14pt;line-height:150%;font-weight:bold;color:darkgreen;}
input{border:1px solid #8AD3E9;background-color:#F5F7CF;height:20px;}
.table_m{width:98%;height:250px;margin:auto auto;overflow-y:auto;overflow-x:hidden;}
.table_m table{width:100%;border-bottom:1px dotted gray}
.table_m tr:hover{background:#90D5EA}
.table_m table td{height:30px;line-height:30px;border-top:1px dotted gray;}
.mini-panel-border{
border-color:#D2D2D2;
}
.mini-grid-headerCell-nowrap{
background:white
}
.mini-grid-headerCell{
background:white;
border-top:0px;
border-color:#D2D2D2
}
.mini-grid-headerCell-inner{
font-family:"仿宋_GB2312";
font-size:12pt;
}
.mini-grid-column-splitter{
background:white
}
.mini-grid-pager{
background:white
}
</style>
</head>
<body>
<div class="queryPane" style="padding-top:10px;width:100%;height:80px">
<form id="farmer" action="/bank/farmer/typeInFarmer.do" method="POST">
<table width="100%" height="60px" style="vertical-align:middle;">
	<tr>
		<td  width="5%"align="right" >
		</td>
		<td class="labelName" width="11%">
			<font color="red">*</font>农户姓名:&nbsp;&nbsp;&nbsp; 
		</td>
		<td width="10%" align=center>
			<input id="farmerName" name="farmerName" value="${farmerName}"/>
		</td>
		<td width="1%" ></td>
		<td class="labelName"  width="15%">
			<font color="red">*</font>农户身份证号:
		</td>
		<td width="10%">
			<input  id="farmerIdNum" name="farmerIdNum" type="text" value="${farmerIdNum}"></td>
		<td width="1%"></td>
		<td width="10%" align="left">
			<input type="button" value=""  onclick="ChaXun()"style="width:100px;height:25px;border:0;background:url(/bank/images/query.png) no-repeat">
		</td>
		<td width="10%" align="left">
			<input type="button" value=""  onclick="LuRu()" style="width:100px;height:25px;border:0;background:url(/bank/images/LuRu.png) no-repeat">
		</td>
	</tr>
</table>
</form>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:98%;margin:auto auto;height:340px;background-color:white" 
            url="${pageContext.request.contextPath}/farmer/queryFarmer.do" idField="id"
            sizeList="[5,10,20,50]" pageSize="10" showReloadButton="false">
	        <div property="columns">
	             <div type="indexcolumn" width="5%" headerAlign="center">编号</div>
	             <div field="farmerName" width="10%" headerAlign="center" allowSort="true"  >姓名</div>
	             <div field="farmerIdnum" width="15%" headerAlign="center" allowSort="true" >身份证号码</div>   
	             <div field="phone" width="25%" headerAlign="center" allowSort="true" >联系电话</div>     
	             <div field="address" width="40%" headerAlign="center" allowSort="true" >住址</div>                                         
	        	 <div name="action" width="5%" headerAlign="center" align="center" renderer="onActionRenderer1" cellStyle="padding:0;"></div>
	         </div>
</div>
<script type="text/javascript">
	mini.parse();
	var grid = mini.get("datagrid1");
	grid.load();
	function ChaXun() {
    	var farmerName = $("#farmerName").val();
		var farmerIdNum = $("#farmerIdNum").val();
	    grid.load({farmerName:farmerName,farmerIdNum:farmerIdNum});
	}
	function LuRu(){
		var form = document.getElementById("farmer");
		form.submit();
	}
	function onActionRenderer1(e) {
	    var record = e.record;
	    var id = record.id;
	    var s = '<a class="New_Button" target="_self" href="/bank/farmer/loadFarmer1.do?id='+id+'">[查看]</a>';      
	    return s;
	}
</script>
</body>
</html>