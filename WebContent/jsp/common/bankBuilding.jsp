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
	<li class="active">
		基本信息
	</li>
	<li >
		<a href="/bank/loan/queryLoan1.do?fid=${farmer.id}">贷款信息</a>
	</li>
	<li >
		<a href="/bank/farmer/queryPrivateLending.do?fid=${farmer.id}">民间借贷信息</a>
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
	<li >
		<a href="/bank/farmer/queryEvaluate.do?fid=${farmer.id}">其他信息</a>
	</li>
</ul>
</div>
<form action="/bank/farmer/saveFarmer1.do" id="farmer" name="farmer" method="POST">
<input type="hidden" id="deleteMember" name="deleteMember" value=""/>
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
       	 <input type="button" id="saveBtn" onclick="submitForm()" value=""/>
        </td>
	</tr>
</table>
</div>
<div  style="width:90%;margin:auto auto">
<input name="id" class="mini-hidden" value="${farmer.id}" />
<input name="recorder" class="mini-hidden" value="管理员"/>
<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr><td colspan="4" style="width:100%">
<fieldset style="width:100%;margin:auto auto">
<legend><label>农户基本概况信息</label></legend>
<div class="fieldset-body">
<table width="100%">
<tr>
	<td style="width:10%"><label for="farmerName$text"><font color="red">*</font>户主姓名:</label></td>
    <td style="width:40%"><input type="text" id="farmername" name="farmername" value="${farmer.farmername}" style="width:90%"/></td>
    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>户主身份证号:</label></td>
    <td style="width:40%" ><input type="text" id="farmeridnum" name="farmeridnum" value="${farmer.farmeridnum}" style="width:90%"/></td>
</tr>
<tr>
	<td style="width:10%" id="farmername_validate"></td>
	<td style="width:40%" ></td>
	<td style="width:10%" id="farmeridnum_validate"></td>
	<td style="width:40%" id=></td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>性别:</label></td>
	<td style="width:40%">
	    	<input  name="sex" class="mini-combobox" value="${farmer.sex}" 
	        	style="width:90%" required="true" requiredErrorText="性别不能为空" 
	        	url="/bank/dic/Sex.txt" emptyText="请选择..."/>
	</td>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>婚姻状况:</label></td>
	    <td style="width:40%">
	    	<input  name="marryStatus" class="mini-combobox" value="${farmer.marrystatus}" 
	        	style="width:90%" required="true" requiredErrorText="婚姻状况不能为空" 
	        	url="/bank/dic/MarryStatus.txt" emptyText="请选择..."/>
	</td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>联系电话:</label></td>
    <td style="width:40%">
    	<input name="phone" class="mini-textbox" value="${farmer.phone}"
        	required="true" requiredErrorText="联系电话不能为空" style="width:90%"/>
    </td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox2$text"><font color="red">*</font>所属乡镇:</label></td>
    <td style="width:40%" >
    	<input name="villages" class="mini-combobox"  value="${farmer.villages}" style="width:90%"
   			required="true"  requiredErrorText="现住址不能为空" 
   			url="/bank/dic/Villages.txt" emptyText="请选择..." />
   </td>
    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>住址:</label></td>
    <td style="width:40%" >
    	<input name="address" class="mini-textarea"  value="${farmer.address}" style="width:90%"
   			 />
   </td>
 </tr>
 <tr>
 	<td style="width:10%"><label for="textbox2$text"><font color="red">*</font>家庭人数:</label></td>
    <td style="width:40%" >
    	<input name="familynum" class="mini-textbox"  value="${farmer.familynum}"
        	minValue="1" maxValue="10" style="width:90%"/>
    </td>
    <td style="width:10%"><label for="textbox2$text">&nbsp;&nbsp;劳动力人数:</label></td>
    <td style="width:40%" >
    	<input name="labornum" class="mini-textbox" value="${farmer.labornum}" style="width:90%"
        	minValue="1" maxValue="20"/>

    </td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox1$text">&nbsp;&nbsp;政治面貌:</label></td>
    <td style="width:40%">
    	<input name="politicstatus" class="mini-combobox"  value="${farmer.politicstatus}" style="width:90%"
            url="/bank/dic/PoliticStatus.txt" emptyText="请选择..."/>
    </td>
	<td style="width:10%"><label for="textbox1$text">&nbsp;&nbsp;邮政编码:</label></td>
    <td style="width:40%">
    	<input name="postcode" class="mini-textbox"  value="${farmer.postcode}" style="width:90%"
        	minValue="100000" maxValue="99999"/>
    </td>
</tr>
</table>
</div>
</fieldset>
</td></tr>
</table>
</div>
<div style="width:90%;margin:auto auto">
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr><td colspan="4" style="width:100%">
<fieldset style="width:100%;margin:auto auto">
<legend><label>家庭成员基本情况</label></legend>
<div class="fieldset-body">
<table width="100%" >
<c:forEach items="${members}" var="member" varStatus="status">
<tr><td>
<div id ="farmerMember${status.index}" class="farmerMember" >
<input class="mini-hidden" id="member_id${status.index}" name="members[${status.index}].id" value="${member.id}"/>
<input class="mini-hidden" name="members[${status.index}].farmerId" value="${member.farmerId}"/>
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr>
<td colspan="4" style="width:100%">
<table width="100%">
<tr>
	<c:choose>
	<c:when test="${status.index ==0}">
		<td rowspan="5" style="width:2%"></td>
	</c:when>
	<c:otherwise>
		<td rowspan="5" style="width:2%"><input type="button" value="×" onclick="delMember(${status.index},${farmer.id})"/></td>
	</c:otherwise>
	</c:choose>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>家庭成员姓名:</label></td>
    <td style="width:39%">
    	<input name="members[${status.index}].name" class="mini-textbox" value="${member.name }"
         	required="true" requiredErrorText="家庭成员姓名不能为空" style="width:90%"/>
    </td>
    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>与户主关系:</label></td>
    <td style="width:39%" >
       <input name="members[${status.index}].relation" class="mini-combobox"  value="${member.relation }"
  			style="width:90%" url="/bank/dic/Relation.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>身份证号:</label></td>
    <td style="width:39%">
    	<input name="members[${status.index}].idNum" class="mini-textbox" value="${member.idNum }"
        	required="true"	 requiredErrorText="身份证号不能为空" style="width:90%"/>
    </td>
    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>文化程度:</label></td>
    <td style="width:39%" >
    	<input name="members[${status.index}].education" class="mini-combobox" value="${member.education}" style="width:90%"
        	url="/bank/dic/Education.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox2$text"><font color="red">*</font>性别:</label></td>
    <td style="width:39%" >
    	<input name="members[${status.index}].sex" class="mini-combobox" value="${member.sex }" style="width:90%"
        	required="true"  requiredErrorText="性别不能为空" url="/bank/dic/Sex.txt" emptyText="请选择..."/>
   </td>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>婚姻状况:</label></td>
    <td style="width:39%">
	    <input name="members[${status.index}].marryStatus" class="mini-combobox" value="${member.marryStatus}" style="width:90%"
	    	required="true" requiredErrorText="婚姻状况不能为空" url="/bank/dic/MarryStatus.txt" emptyText="请选择..."/>
   </td>
</tr>
<tr>
   <td style="width:10%"><label for="textbox2$text">&nbsp;&nbsp;职业:</label></td>
   <td style="width:39%" >
   		<input name="members[${status.index}].occupation" class="mini-textbox" value="${member.occupation}" style="width:90%"/>
   </td>
	<td style="width:10%"><label for="textbox1$text">&nbsp;&nbsp;职务:</label></td>
    <td style="width:39%">
    	<input name="members[${status.index}].job" class="mini-textbox" value="${member.job }" style="width:90%"/>
    </td>
    
</tr>
<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>联系电话:</label></td>
	<td style="width:39%">
    	<input  name="members[${status.index}].phone" class="mini-textbox" value="${member.phone}" style="width:90%"
        	required="true"  requiredErrorText="联系电话不能为空" />
    </td>
    <td style="width:10%"><label for="textbox1$text">&nbsp;&nbsp;地址:</label></td>
	<td style="width:39%">
    	<input  name="members[${status.index}].address" class="mini-textarea" value="${member.address}" style="width:90%"/>
    </td>
</tr>
</table>
</td>
</tr>
</table>
</div>
</td>
</tr>
</c:forEach> 
<tr>
   <td align="center" >
     <input type="button" class="addBtn" onclick="addMember(${farmer.id})"/>
   </td>
</tr>
</table>
</div>
</fieldset>
</td></tr></table>
</div>
</form>
<script type="text/javascript">
	var deleteMember = new Array();
	function back(){
		  window.history.go(-1);
	}
	function addMember(fid){
		  $(".farmerMember").last().after(FarmerMember($(".farmerMember").length,fid));
		  mini.parse(); 
	}
	function delMember(index,fid){
		var memberId = $("input[name^='members["+index+"].id'").val();
		$("#farmerMember"+index).remove();
		deleteMember.push(memberId);
		$("#deleteMember").val(deleteMember.join(","));
		var next = index+1;
		$(".farmerMember").each(function(){
			var name = $(this).attr("id");
			var n = name.substr(12,name.length);
			if(n>index){
				$("input[name^='members["+next+"]']").each(function(){
					var oldName =$(this).attr("name");
					var newName = "members["+index+"]"+oldName.substr(oldName.indexOf("."),oldName.length);
					$(this).attr("name",newName);
				});
				$("#delMember"+next).attr("onclick","delMember("+index+","+fid+")");
				$(this).attr("id","farmerMember"+index);
			};
			
		});
	}
	function back(){
		history.go(-1);
	}
	function submitForm(){
		$("#farmer").submit();

	};
</script>
</body>
</html>