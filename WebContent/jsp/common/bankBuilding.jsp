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
	<li class="active">
		基本信息
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryMember.do?fid=${farmer.id}">家庭成员信息</a>
	</li>
	<li class="inactive" >
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
	<li class="inactive">
		<a href="/bank/farmer/queryBreed.do?fid=${farmer.id}">种养殖信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryDevice.do?fid=${farmer.id}">设备信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryCompunish.do?fid=${farmer.id}">奖惩信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryInsured.do?fid=${farmer.id}">参保信息</a>
	</li>
	<li class="inactive">
		<a href="/bank/farmer/queryEvaluate.do?fid=${farmer.id}">其他信息</a>
	</li>
</ul>
</div>
<form action="/bank/farmer/saveFarmer1.do" id="farmer" name="farmer" method="POST">
<input type="hidden" id="deleteMember" name="deleteMember" value=""/>
<div >
<table >
	<tr>
		<td class="labelName" width=50px" align="right">姓名</td>
		<td class="labelValue" width="10px" align="center">:</td>
		<td class="labelValue" width="100px">${farmer.farmername }</td>
		<td class="labelName" width="100px" align="center">身份证号码</td>
		<td class="labelValue" width="10px">:</td>
		<td class="labelValue" align="left" width="100px">${farmer.farmeridnum}</td>
		<td width="10"></td>
    	<td width="150px" align="right">
       	 <input class="bank-btn" type="button" id="saveBtn" onclick="submitForm()" value="保存"/>
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