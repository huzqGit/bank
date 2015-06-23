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
 border-bottom:1px solid lightgray;
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
 li a{
 color:black
 }
.active{
 float:left;
 width:100px;
 list-style-type:none;
 text-align:center;
 border-bottom:none;
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
	<li >
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
	<li >
		<a href="/bank/farmer/queryCompunish.do?fid=${farmer.id}">奖惩信息</a>
	</li>
	<li >
		<a href="/bank/farmer/queryInsured.do?fid=${farmer.id}">参保信息</a>
	</li>
	<li class="active">
		其他信息
	</li>
</ul>
</div>
<form action="/bank/farmer/saveEvaluate1.do" id="farmerEvaluate" name="farmerEvaluate" method="POST">
<input type="hidden" id="deleteMember" name="deleteMember" value=""/>
<input type="hidden" id="farmerId" name="farmerId" value="${farmer.id}"/>
<div class="topMenu" style="background:linear-gradient(#6DC8E3,white)">
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
       	 <input type="submit" id="saveBtn" value=""/>
        </td>
	</tr>
</table>
</div>
<fieldset id="fd2" style="width:90%;margin:auto auto">
<legend><label>村民委员会对农户家庭评价情况基本信情况</label></legend>
<div class="fieldset-body">
<input name="id" class="mini-hidden" value ="${evaluate.id}"/>
<input name="recorder" class="mini-hidden" value="管理员"/>
<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
<table border="0" cellpadding="1" cellspacing="5" width="100%" >
<tr><td>
<table width="100%">
<tr>
    <td style="width:15%"><label for="textbox2$text">家庭和睦情况:</label></td>
    <td style="width:35%" >
    	<input name="harmonystatus" class="mini-combobox" value ="${evaluate.harmonystatus}" style="width:90%"
    	url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
    <td style="width:10%"><label for="textbox1$text">敬老爱幼情况:</label></td>
    <td style="width:40%">
    	<input name="respectstatus" class="mini-combobox" value ="${evaluate.respectstatus}"style="width:90%"
    	url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
    <td style="width:15%"><label for="textbox1$text">邻里团结情况:</label></td>
    <td style="width:35%">
    	<input name="neighborstatus" class="mini-combobox" value ="${evaluate.neighborstatus}" style="width:90%"
    	url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
    <td style="width:10%"><label for="textbox1$text">是否遵纪守法:</label></td>
    <td style="width:40%">
    	<input name="legalstatus" class="mini-combobox" value ="${evaluate.legalstatus}" required="true"
        	requiredErrorText="是否遵纪守法不能为空" style="width:90%"
            url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
    <td style="width:15%"><label for="textbox1$text">对公益事业关心程度:</label></td>
    <td style="width:35%">
    	<input name="welfarestatus" class="mini-combobox" value ="${evaluate.welfarestatus}" style="width:90%"
    		url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
    <td style="width:10%"><label for="textbox1$text">是否诚实守信:</label></td>
    <td style="width:40%">
    	<input name="honeststatus" class="mini-combobox" value ="${evaluate.honeststatus}"  style="width:90%"
    		required="true" requiredErrorText="不能为空"
        	url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..."/>
   </td>
</tr>
<tr>
   <td style="width:15%"><label for="textbox1$text">其他:</label></td>
   <td style="width:35%">
	   <input name="otherstatus" class="mini-textarea" value ="${evaluate.otherstatus}" style="width:90%">
   </td>
</tr>
</table>
</td></tr></table>
</div>
</fieldset>
</form>
<script type="text/javascript">
  function back(){
	  window.history.go(-1);
  }
</script>
</body>
</html>