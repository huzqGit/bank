<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<style type="text/css">
	*{margin:0;padding:0;text-decoration:none}
	body{
overflow-x:hidden
}
    .active{font-size: 15px;font-family: YouYuan;font-weight: bold;color:darkgreen}
     .inactive{font-size: 15px;font-family: YouYuan;font-weight:bold;color:gray}
    .display{display:block;}
    .hidden{display:none;}
    .line{background-color:#CCECF5;}
    .topMenu{
    border:1px solid #8AD3E9;
    /* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
	endColorstr = 'white' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
	endColorstr = 'white' )"; 
    }
	#saveBtn{
		width:100px;
		height:25px;
		border:0;
		background:url(/bank/images/save.png) no-repeat
	}
	#backBtn{
		width:100px;
		height:25px;
		border:0;
		background:url(/bank/images/back.png) no-repeat
	}
	.addBtn{width:100px;height:25px;border:0;background:url(/bank/images/add.png) no-repeat}
	.delBtn{width:100px;height:25px;border:0;background:url(/bank/images/delete.png) no-repeat}
	.labelName{font-size:15px;font-weight:bold;color:darkgreen;}
	.labelValue{font-size:15px;font-weight:bold;color:red;}
	 li{
 border-bottom:2px solid green;
 float:left;
 width:85px;
 list-style-type:none;
 height:31px;
 text-align:center;
 line-height:28px;
 font-weight:bold;
 color:black;
 background-repeat:no-repeat
 }
.active{
 float:left;
 width:100px;
 list-style-type:none;
 text-align:center;
 border-bottom:2px solid #6DC8E3;
 border-top:1px solid gray;
 border-left:1px solid gray;
 border-right:1px solid white;
 	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = 'white', 
	endColorstr = '#6DC8E3' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = 'white', 
	endColorstr = '#6DC8E3' )";  
 height:31px;

 background-repeat:no-repeat
}
 </style>
</head>
<body>
<div class="topMenu">
<ul>
	<li>
		<a href="/bank/farmer/loadFarmer1.do?id=${farmer.id}">基本信息</a>
	</li>
	<li >
		<a href="/bank/loan/queryLoan1.do?fid=${farmer.id}">贷款信息</a>
	</li>
	<li >
		<a href="/bank/farmer/queryBalance.do?fid=${farmer.id}">收支信息</a>
	</li>
	<li >
		<a href="/bank/farmer/queryHouse.do?fid=${farmer.id}">房产信息</a>
	</li>
	<li >
		<a href="/bank/farmer/queryForest.do?fid=${farmer.id}">林权信息</a>
	</li>
	<li >
		<a href="/bank/farmer/queryBreed.do?fid=${farmer.id}">种养殖信息</a>
	</li>
	<li >
		<a href="/bank/farmer/queryDevice.do?fid=${farmer.id}">设备信息</a>
	</li>
	<li  class="active">
		奖惩信息
	</li>
	<li >
		<a href="/bank/farmer/queryInsured.do?fid=${farmer.id}">参保信息</a>
	</li>
	<li >
		<a href="/bank/farmer/queryEvaluate1.do?fid=${farmer.id}">其他信息</a>
	</li>
</ul>
</div>
<div class="topMenu" style="background:linear-gradient(#6DC8E3,white)">
<table width ="100%" height="60px">
	<tr>
		<td class="labelName" width="30%" align="right">姓名</td>
		<td class="labelValue" width="1%" align="center">:</td>
		<td class="labelValue" width="10%">${farmer.farmerName }</td>
		<td class="labelName" width="10%" align="center">身份证号码</td>
		<td class="labelValue" width="1%">:</td>
		<td class="labelValue" align="left">${farmer.farmerIdnum}</td>
		<td width="1%"></td>
		 <td width="50px" align="right">
       	 <input type="button" class="addBtn" onclick="add(${farmer.id})"/>
        </td>
       
	</tr>
</table>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:98%;margin:auto auto;height:320px;background-color:white" 
            url="${pageContext.request.contextPath}/farmer/loadCompunish.do?fid=${farmer.id}"
            sizeList="[5,10,20,50]" pageSize="10" showReloadButton="false">
            		<td align="center">编号</td>
	        <div property="columns">
	             <div type="indexcolumn" width="5%" headerAlign="center">编号</div>
	             <div field="type" width="15%" headerAlign="center" allowSort="true">表彰或处罚</div>
	             <div field="organ" width="25%" headerAlign="center" allowSort="true" >表彰或处罚部门</div>   
	             <div field="occurTime" width="15%" headerAlign="center" allowSort="true" format="yyyy-MM-dd">表彰或处罚时间</div>                                           
	        	 <div field="detail" width="30%" headerAlign="center" allowSort="true" >表彰或处罚内容</div>   
	        	 <div name="action" width="5%" headerAlign="center" align="center" renderer="editRenderer" cellStyle="padding:0;"></div>
	        	 <div name="action" width="5%" headerAlign="center" align="center" renderer="deleteRenderer" cellStyle="padding:0;"></div>
	         </div>
</div>
<script type="text/javascript">
	mini.parse();
	var grid = mini.get("datagrid1");
	grid.load();
	
	function add(fid){
		window.location.href="/bank/farmer/typeInCompunish1.do?fid="+fid;
	}
	function editRenderer(e) {
	    var record = e.record;
	    var id = record.id;
	    var fid = record.farmerId;
	    var s = '<a class="Edit_Button" target="_self" href="/bank/farmer/editCompunish.do?id='+id+'&fid='+fid+'">[编辑]</a>';      
	    return s;
	};
	function deleteRenderer(e) {
	    var record = e.record;
	    var id = record.id;
	    var fid = record.farmerId;
	    var s = '<a class="New_Button" target="_self" href="/bank/farmer/deleteCompunish.do?id='+id+'&fid='+fid+'">[删除]</a>';      
	    return s;
	};
</script>
</body>
</html>