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
	<li class="active">
		家庭成员信息
	</li>
	<li class="inactive">
		<a href="/bank/loan/queryLoan1.do?fid=${farmer.id}">贷款信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryPrivateLending.do?fid=${farmer.id}">民间借贷信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryBalance.do?fid=${farmer.id}">收支信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryHouse.do?fid=${farmer.id}">房产信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryForest.do?fid=${farmer.id}">林权信息</a>
	</li>
	<li class="inactive" >
		<a href="/bank/farmer/queryBreed.do?fid=${farmer.id}">种养殖信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryDevice.do?fid=${farmer.id}">设备信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryCompunish.do?fid=${farmer.id}">奖惩信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryCredit.do?fid=${farmer.id}">信用户信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryInsured.do?fid=${farmer.id}">参保信息</a>
	</li>
	<li class="inactive" >
		<a href="/bank/farmer/queryEvaluate1.do?fid=${farmer.id}">其他信息</a>
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
<div style="width:100%;position:absolute;top:100px;bottom:0px;left:0px;bottom:0px">
	<div class="mini-fit">
		<div id="datagrid1" class="mini-datagrid" style="width:100%;;height:100%;background-color:white" 
		            url="${pageContext.request.contextPath}/farmer/loadMember.do?farmeridnum=${farmer.farmeridnum}&runitid=${farmer.runitid}" idField="id"
		            sizeList="[5,10,20,50]" pageSize="10" showReloadButton="false">
			        <div property="columns">
			             <div type="indexcolumn" width="5%" headerAlign="center"></div>
			             <div field="name" width="10%" headerAlign="center" allowSort="true">姓名</div>
			             <div field="relation" width="10%" headerAlign="center" allowSort="true" renderer="relationRenderer">与户主关系</div>   
			             <div field="idnum" width="15%" headerAlign="center" allowSort="true">身份证号码 </div>     
			             <div field="marrystatus" width="8%" headerAlign="center" allowSort="true" renderer="marrystatusRenderer">婚姻状况</div>
			             <div field="sex" width="8%" headerAlign="center" allowSort="true" renderer="sexRenderer">性别</div>    
			             <div field="phone" width="15%" headerAlign="center" allowSort="true" >联系电话</div> 
			             <div field="address" width="19%" headerAlign="center" allowSort="true" >地址</div>                                      
			        	 <div width="5%" headerAlign="center" align="center" renderer="editRenderer" cellStyle="padding:0;"></div>
			         	 <div width="5%" headerAlign="center" align="center" renderer="deleteRenderer" cellStyle="padding:0;"></div>
			         </div>
		</div>
	</div>
</div>
<script type="text/javascript">
	mini.parse();
	var grid = mini.get("datagrid1");
	grid.load();
	
	function relationRenderer(e){
		var relation = e.record.relation;
		var s;
		if(relation=='1'){
			s="配偶";
		}else if(relation =="2"){
			s="父子";
		}else if(relation=="3"){
			s="父女";
		}else if(relation=="4"){
			s="母子";
		}else if(relation=="5"){
			s="母女";
		}else if(relation=="9"){
			s="其他";
		}
		return s;
	}
	function marrystatusRenderer(e){
		var marrystatus = e.record.marrystatus;
		var s;
		if(marrystatus=='1'){
			s="已婚";
		}else if(marrystatus =="2"){
			s="离异";
		}else if(marrystatus=="3"){
			s="未婚";
		}else if(marrystatus=="9"){
			s="未知";
		}
		return s;
	}
	
	function sexRenderer(e){
		var sex = e.record.sex;
		var s;
		if(sex=='1'){
			s="男性";
		}else if(sex =="2"){
			s="女性";
		}else if(sex=="9"){
			s="未说明性别";
		}
		return s;
	}
	function add(fid){
		window.location.href="/bank/farmer/insertMember.do?fid="+fid;
	}
	function editRenderer(e) {
	    var record = e.record;
	    var id = record.id;
	    var fid = record.farmerid;
	    var s = '<a class="Edit_Button" target="_self" href="/bank/farmer/editMember.do?id='+id+'&fid='+fid+'">[编辑]</a>';      
	    return s;
	};
	function deleteRenderer(e) {
	    var record = e.record;
	    var id = record.id;
	    var fid = record.farmerid;
	    var s = '<a class="New_Button" target="_self" href="/bank/farmer/deleteMember.do?id='+id+'&fid='+fid+'">[删除]</a>';      
	    return s;
	};
</script>
</body>
</html>