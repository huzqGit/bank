<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<title>农户信息条件查询</title>
</head>
<body>
<div style="width:100%;height:120px">
<form action="/bank/farmer/loadFarmerThree.do" method="POST">
<table width="100%"  style="vertical-align:middle;">
	<tr>
		<td class="labelName"  width="30%" align="right">贷款金融机构名称:</td>
		<td width="2%" ></td>
		<td colsapn="4" align="left">
			<input  type="text" class="bank-text" id="organName1" name="organName">
		</td>
	</tr>
	<tr>
		<td class="labelName" width="30%"align="right" >贷款时间从:</td> 
		<td width="2%" ></td>
		<td><input type="text" class="bank-text"  id="loanDate1" name="loanDate1"/></td>
		<td width="2%" ></td>
		<td class="labelName"  width="10%" align="right">到:</td>
		<td><input  type="text" class="bank-text" id="loandDate2" name="loandDate2"></td>
	</tr>
	<tr>
		<td class="labelName" width="30%"align="right" >贷款余额范围从:</td> 
		<td width="2%" ></td>
		<td>
			<input type="text" class="bank-text" id="balance1" name="balance1"/>
		</td>
		<td width="2%" ></td>
		<td class="labelName"  width="10%" align="right">到:</td>
		<td>
			<input id="balance2" name="balance2" class="bank-text" type="text">
		</td>
		
	</tr>
	<tr>
		<td colspan="6" align="center" style="text-alin:center;vertical-align:middle;">
			<input type="button" class="bank-btn" value="查询"  onclick="search()">
		</td>
	</tr>	
</table>
</form>
</div>
<div style="width:100%;position:absolute;top:100px;bottom:0px;left:0px;bottom:0px">
	<div class="mini-fit">
		<div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%" 
		    url="/bank/farmer/loadFarmerThree.do"  idField="id" allowResize="true"
		    sizeList="[20,30,50,100]" pageSize="10">
		    <div property="columns">
		        <div type="indexcolumn" ></div>
		        <div field="farmername" width="45%" headerAlign="center" allowSort="true">姓名</div>    
		        <div field="farmeridnum" width="45%" headerAlign="center" allowSort="true">身份证号码</div> 
		        <div width="10%" headerAlign="center" align="center" renderer="editRenderer" cellStyle="padding:0;"></div>                           
		    </div>
		</div>
		</div>
</div>	   
 <script type="text/javascript">
 mini.parse();
 var grid = mini.get("datagrid1");
 function search() {
     var organName = $("#organName").val();
     var loanDate1 = $("#loanDate1").val();
     var loanDate2 = $("#loanDate2").val();
     var balance1 = $("#balance1").val();
     var balance2 = $("#balance2").val()
     grid.load({organName:organName,loanDate1:loanDate1,loanDate2:loanDate2,
    	 balance1:balance1,balance2:balance2});
 }
 function editRenderer(e) {
	var record = e.record;
	var farmeridnum = record.farmeridnum;
	var farmername = record.farmername;
	var s = '<a class="Edit_Button" target="_self" href="/bank/farmer/loadFarmerThreeTotal.do?farmerName='+farmername+'&farmerIdNum='+farmeridnum+'" target="_self">[查看]</a>';      
	return s;
};

 </script>
</body>
</html>