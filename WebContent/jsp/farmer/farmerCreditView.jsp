<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<title>Insert title here</title>
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
	<li class="inactive">
		<a href="/bank/farmer/queryBalance.do?fid=${farmer.id}">收支信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryHouse.do?fid=${farmer.id}">房产信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryForest.do?fid=${farmer.id}">林权信息</a>
	</li>
	<li  class="inactive">
			<a href="/bank/farmer/queryBreed.do?fid=${farmer.id}">种养殖信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryDevice.do?fid=${farmer.id}">设备信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryCompunish.do?fid=${farmer.id}">奖惩信息</a>
	</li>
	<li class="active">
		信用户信息
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryInsured.do?fid=${farmer.id}">参保信息</a>
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
<div style="width:100%;position:absolute;top:110px;bottom:0px;left:0px;bottom:0px">
<div class="mini-fit">
   <div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%" 
            url="${pageContext.request.contextPath}/farmer/loadAllCredit.do?farmeridnum=${farmer.farmeridnum}&runitid=${farmer.runitid}" idField="id"
            sizeList="[5,10,20,50]" pageSize="10" >
	        <div property="columns">
	             <div type="indexcolumn" ></div>
	             <div field="assessdate" width="60" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true" >信用户评定时间</div>   
	             <div field="assessrank" width="60" headerAlign="center" allowSort="true" renderer="assessrankRenderer">信用户级别</div>     
	             <div field="timelimit" width="60" headerAlign="center" allowSort="true" >有效期限</div>                            
	             <div field="assessorgan" width="120" headerAlign="center" allowSort="true" >信用户评定部门</div>                    
	        	 <div name="action" width="50" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;"></div>
	         </div>
  		</div>
  </div>
  </div>
  <script type="text/javascript">
   
	  mini.parse();
	  
	  var grid = mini.get("datagrid1");

	  grid.load();
	  function reset(){
		  var query = new mini.Form("#query");
		  query.clear();
	  }
	function assessrankRenderer(e){
		var assessrank = e.record.assessrank;
		var s;
		if(assessrank=='1'){
			s="县级信用户";
		}else if(assessrank =="2"){
			s="乡镇级信用户";
		}else if(assessrank=="3"){
			s="村级信信用户";
		}else if(assessrank=="9"){
			s="非信用户";
		}
		return s;
	}
	function onActionRenderer(e) {
        var record = e.record;
        var id = record.creditid;
        var fid = record.farmerid;
  	   	var s = '<a class="Edit_Button" target="_self" href="/bank/farmer/editCredit.do?id='+id+'&fid='+fid+'">[编辑]</a>';   
         return s;
    };
	function add(fid){
		window.location.href="/bank/farmer/insertCredit.do?fid="+fid;
	};
   </script> 
</body>
</html>