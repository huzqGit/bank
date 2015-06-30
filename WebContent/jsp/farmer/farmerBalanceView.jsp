<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
</head>
<body>
<div class="topMenu">
<ul>
	<li class="inactive">
		<a href="/bank/farmer/loadFarmer1.do?id=${farmer.id}">基本信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryMember.do?fid=${farmer.id}">家庭成员信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/loan/queryLoan1.do?fid=${farmer.id}">贷款信息</a>
	</li>
	<li class="inactive" >
		<a href="/bank/farmer/queryPrivateLending.do?fid=${farmer.id}">民间借贷信息</a>
	</li>
	<li class="active">
			收支信息
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryHouse.do?fid=${farmer.id}">房产信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryForest.do?fid=${farmer.id}">林权信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryBreed.do?fid=${farmer.id}">种养殖信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryDevice.do?fid=${farmer.id}">设备信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/jsp/common/bankBuilding.jsp?form=compunish">奖惩信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/jsp/common/bankBuilding.jsp?form=insured">参保信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryEvaluate.do?fid=${farmer.id}">其他信息</a>
	</li>
</ul>
</div>
<div>
<table width ="100%" height="60px">
	<tr>
		<td class="labelName" width="30%" align="right">姓名</td>
		<td class="labelValue" width="1%" align="center">:</td>
		<td class="labelValue" width="10%">${farmer.farmername }</td>
		<td class="labelName" width="10%" align="center">身份证号码</td>
		<td class="labelValue" width="1%">:</td>
		<td class="labelValue" align="left">${farmer.farmeridnum}</td>
		<td width="1%"></td>
		 <td width="50px" align="right">
       	 <input type="button" class="bank-btn" onclick="add(${farmer.id})" value="新增"/>
        </td>
       
	</tr>
</table>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:98%;margin:auto auto;height:340px;background-color:white" 
            url="${pageContext.request.contextPath}/farmer/loadBalance1.do?fid=${farmer.id}" idField="id"
            sizeList="[5,10,20,50]" pageSize="10" showReloadButton="false">
            		<td align="center">编号</td>
	        <div property="columns">
	             <div type="indexcolumn" width="5%" headerAlign="center">编号</div>
	             <div field="year" width="15%" headerAlign="center" allowSort="true">年份</div>
	             <div field="totalincome" width="35%" headerAlign="center" allowSort="true" >家庭年度总收入合计</div>   
	             <div field="totalpay" width="35%" headerAlign="center" allowSort="true" >家庭年度总支出合计</div>                                           
	        	 <div width="5%" headerAlign="center" align="center" renderer="editRenderer" cellStyle="padding:0;"></div>
	        	 <div width="5%" headerAlign="center" align="center" renderer="deleteRenderer" cellStyle="padding:0;"></div>
	         </div>
</div>
<script type="text/javascript">
	mini.parse();
	var grid = mini.get("datagrid1");
	grid.load();
	
	function add(fid){
		window.location.href="/bank/farmer/typeinBalance1.do?fid="+fid;
	}
	function editRenderer(e) {
	    var record = e.record;
	    var id = record.id;
	    var fid = record.farmerid;
	    var s = '<a class="Edit_Button" target="_self" href="/bank/farmer/editBalance.do?id='+id+'&fid='+fid+'">[编辑]</a>';      
	    return s;
	};
	function deleteRenderer(e) {
	    var record = e.record;
	    var id = record.id;
	    var fid = record.farmerid;
	    var s = '<a class="New_Button" target="_self" href="/bank/farmer/deleteBalance.do?id='+id+'&fid='+fid+'">[删除]</a>';      
	    return s;
	};
</script>
</body>
</html>