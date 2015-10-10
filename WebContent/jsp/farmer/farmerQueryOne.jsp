<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>农户信息单户信息查询</title>
<style type="text/css">
*{margin:0;padding:0}
body{ine-height:120%;font-family:"仿宋_GB2312";font-size:13pt;}
</style>
</head>
<body>
<div class="queryPane">
<form action="/bank/farmer/loadFarmerOne.do" method="POST">
<table width="100%" height="30px" style="vertical-align:middle">
	<tr>
		<td class="labelName" width="30%"align="right" >农户姓名:&nbsp;&nbsp;&nbsp; 
		<input id="farmerName" name="farmerName" type="text" class="bank-text"/>
		</td>
		<td width="5%" ></td>
		<td class="labelName"  width="20%">农户身份证号:&nbsp;&nbsp;&nbsp;
		<input id="farmerIdNum" name="farmerIdNum" type="text" class="bank-text">
		</td>
		<td width="1%"></td>
		<td width="20%" align="left">
			<input type="button"  onclick="search()"class="bank-btn" value="查询">
		</td>
	</tr>
</table>
</form>
</div>

	<div id="bank_grid" style="width:100%;position:absolute;top:50px;bottom:0px;left:0px;">
		<div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%;background-color:white" 
			            url="${pageContext.request.contextPath}/farmer/queryFarmerOne.do" idField="id"
			            sizeList="[5,10,20,50]" pageSize="20" showReloadButton="false">
				        <div property="columns">
				             <div type="indexcolumn" width="10%" headerAlign="center" align="center">编号</div>
				             <div field="farmername" width="40%" headerAlign="center" align="center" >姓名</div>
				             <div field="farmeridnum" width="40%" headerAlign="center" align="center">身份证号码</div>
				             <div name="action" width="10%" headerAlign="center" align="center" renderer="onActionRenderer1" cellStyle="padding:0;"></div>   
				         </div>
		</div>
	</div>
<script type="text/javascript">
mini.parse();
var grid = mini.get("datagrid1");
grid.load();
function detail(id){
	window.location.href="/bank/farmer/loadFarmerTotal.do?id="+id;
};
function search() {
	var farmerName = $("#farmerName").val();
	var farmerIdNum = $("#farmerIdNum").val();
    grid.load({farmerName:farmerName,farmerIdNum:farmerIdNum});
};
function onActionRenderer1(e) {
    var record = e.record;
    var fameridnum = record.farmeridnum;
    var s = '<a class="New_Button" target="_self" href="/bank/farmer/loadFarmerTotal.do?farmeridnum='+fameridnum+'">[查看]</a>';      
    return s;
}
</script>
</body>
</html>