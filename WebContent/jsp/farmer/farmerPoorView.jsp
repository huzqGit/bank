<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>农户信息单户信息查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
</head>
<body>
<div class="queryPane">
<form id="farmer" action="/bank/farmer/typeInFarmer.do" method="POST">
<table width="100%" height="30px" style="vertical-align:middle;">
	<tr>
		<td  width="5%"align="right" >
		</td>
		<td class="labelName" width="11%">
			<font color="red">*</font>农户姓名:&nbsp;&nbsp;&nbsp; 
		</td>
		<td width="10%" align=center>
			<input id="farmerName" name="farmerName" type="text" class="bank-text" value="${farmerName}"/>
		</td>
		<td width="1%" ></td>
		<td class="labelName"  width="15%">
			<font color="red">*</font>农户身份证号:
		</td>
		<td width="10%">
			<input  id="farmerIdNum" name="farmerIdNum" type="text" class="bank-text" value="${farmerIdNum}"></td>
		<td width="1%"></td>
		<td width="10%" align="left">
			<input class="bank-btn"  type="button" value="查询"  onclick="ChaXun()">
		</td>
		<td width="10%" align="left">
			<input class="bank-btn" type="button" value="录入"  onclick="LuRu()">
		</td>
	</tr>
</table>
</form>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:98%;margin:auto auto;height:340px;background-color:white" 
            url="${pageContext.request.contextPath}/farmer/queryPoorFarmer.do" idField="id"
            sizeList="[5,10,20,50]" pageSize="10" showReloadButton="false">
	        <div property="columns">
	             <div type="indexcolumn" width="5%" headerAlign="center">编号</div>
	             <div field="farmername" width="10%" headerAlign="center" allowSort="true"  >姓名</div>
	             <div field="farmeridnum" width="15%" headerAlign="center" allowSort="true" >身份证号码</div>   
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
	    var s = '<a class="New_Button" target="_self" href="/bank/farmer/loadPoorFarmer.do?id='+id+'">[查看]</a>';      
	    return s;
	}
</script>
</body>
</html>