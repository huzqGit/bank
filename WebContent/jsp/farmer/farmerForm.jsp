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
<form action="/bank/farmer/saveFarmer1.do" id="form1" name="farmer" method="POST">
<input type="hidden" id="deleteMember" name="deleteMember" value=""/>
<div >
<table style="width:100%;height:30px">
	<tr>
		<td class="labelName" width="30%" align="right">姓名</td>
		<td class="labelValue" width="10%">:${farmer.farmername }</td>
		<td class="labelName" width="20%" align="right">身份证号码</td>
		<td class="labelValue" align="right" width="10%">:${farmer.farmeridnum}</td>
    	<td width="30" align="center">
       		<input type="button" id="saveBtn" class="bank-btn" onclick="submitForm()" value="保存"/>
        </td>
	</tr>
</table>
</div>
<div  style="width:90%;margin:auto auto">
<input name="id" class="mini-hidden" value="${farmer.id}"/>
<input name="bank" class="mini-hidden" value="${farmer.bank}" />
<input name="account" class="mini-hidden" value="${farmer.account}"/>
<input name="farmertype" class="mini-hidden" value="0"/>
<input name="poortype" class="mini-hidden" value="${farmer.poortype}"/>
<input name="poorreason" class="mini-hidden" value="${farmer.poorreason}"/>
<input name="plougharea" class="mini-hidden" value="${farmer.plougharea}"/>
<input name="wateringarea" class="mini-hidden" value="${farmer.wateringarea}"/>
<input name="forestarea" class="mini-hidden" value="${farmer.forestarea}"/>
<input name="forestarea1" class="mini-hidden" value="${farmer.forestarea1}"/>
<input name="fruitarea" class="mini-hidden" value="${farmer.fruitarea}"/>
<input name="meadowarea" class="mini-hidden" value="${farmer.meadowarea}"/>
<input name="waterarea" class="mini-hidden" value="${farmer.waterarea}"/>
<input name="drinkinghard" class="mini-hidden" value="${farmer.drinkinghard}"/>
<input name="drinkingsafe" class="mini-hidden" value="${farmer.drinkingsafe}"/>
<input name="usingelectric" class="mini-hidden" value="${farmer.usingelectric}"/>
<input name="usingtoilet" class="mini-hidden" value="${farmer.usingtoilet}"/>
<input name="usingartel" class="mini-hidden" value="${farmer.usingartel}"/>
<input name="fueltype" class="mini-hidden" value="${farmer.fueltype}"/>
<input name="netincome" class="mini-hidden" value="${farmer.netincome}"/>
<input name="operateincome" class="mini-hidden" value="${farmer.operateincome}"/>
<input name="subsidyincome" class="mini-hidden" value="${farmer.subsidyincome}"/>
<input name="usingtelevision" class="mini-hidden" value="${farmer.usingtelevision}"/>
<input name="roaddistance" class="mini-hidden" value="${farmer.roaddistance}"/>
<input name="roadtype" class="mini-hidden" value="${farmer.roadtype}"/>
<input name="housearea" class="mini-hidden" value="${farmer.housearea}"/>
<input name="unsafehouse" class="mini-hidden" value="${farmer.unsafehouse}"/>
<input name="lowinsure" class="mini-hidden" value="${farmer.lowinsure}"/>
<input name="agedinsure" class="mini-hidden" value="${farmer.agedinsure}"/>
<input name="ecoamount" class="mini-hidden" value="${farmer.ecoamount}"/>
<input name="standard" class="mini-hidden" value="${farmer.standard}"/>
<input name="runitid" class="mini-hidden" value="${farmer.runitid}"/>
<input name="runitname" class="mini-hidden" value="${farmer.runitname}"/>
<input name="sourcecode" class="mini-hidden" value="${farmer.sourcecode}"/>
<input name="sourcename" class="mini-hidden" value="${farmer.sourcename}"/>
<input name="id" class="mini-hidden" value="${farmer.id}"/>
<input name="recorder" class="mini-hidden" value="${recorder}}"/>
<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr><td colspan="4" style="width:100%">
<fieldset style="width:100%;margin:auto auto">
<legend><label>农户基本概况信息</label></legend>
<div class="fieldset-body">
<table width="100%">
<tr>
	<td class="required_text" width="2%">*</td>
	<td style="width:10%"><label for="farmerName$text">户主姓名:</label></td>
    <td style="width:38%">
    	<input type="text" id="farmername" name="farmername" value="${farmer.farmername}" style="width:90%"
    		errorMode="none" onvalidation="onValidation"/>
    </td>
    <td class="required_text" width="2%">*</td>
    <td style="width:10%">户主身份证号:</td>
    <td style="width:38%" >
    	<input type="text" id="farmeridnum" name="farmeridnum" value="${farmer.farmeridnum}" style="width:90%"
    		errorMode="none" onvalidation="onValidation"/>
    </td>
</tr>
<tr>
	<td></td>
	<td id="type_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="amount_error" class="errorText" colspan="2"></td>
</tr>
<tr>
	<td class="required_text" width="2%">*</td>
	<td >性别:</td>
	<td >
	    <input  name="sex" class="mini-combobox" value="${farmer.sex}" style="width:90%" 
	    	required="true" requiredErrorText="性别不能为空"  url="/bank/dic/Sex.txt" emptyText="请选择..."
	        errorMode="none"onvalidation="onValidation"/>
	</td>
	<td class="required_text" width="2%">*</td>
	<td >婚姻状况:</td>
	<td >
	    <input  name="marrystatus" class="mini-combobox" value="${farmer.marrystatus}" style="width:90%" 
	    	errorMode="none" required="true" requiredErrorText="婚姻状况不能为空" url="/bank/dic/MarryStatus.txt" 
	    	emptyText="请选择..." onvalidation="onValidation"/>
	</td>
</tr>
<tr>
	<td></td>
	<td id="sex_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="marrystatus_error" class="errorText" colspan="2"></td>
</tr>
<tr>
	<td class="required_text" width="2%">*</td>
	<td >联系电话:</td>

    <td >
    	<input name="phone" class="mini-textbox" value="${farmer.phone}" style="width:90%"
        	errorMode="none" required="true" requiredErrorText="联系电话不能为空" onvalidation="onValidation"/>
    </td>
</tr>
<tr>
	<td></td>
	<td id="phone_error" class="errorText" colspan="2"></td>
</tr>
<tr>
	<td class="required_text" width="2%">*</td>
	<td >所属乡镇:</td>
    <td  >
    	<input name="villages" class="mini-combobox"  value="${farmer.villages}" style="width:90%"
   			errorMode="none" required="true"  requiredErrorText="现住址不能为空" url="/bank/dic/Villages.txt"
   			emptyText="请选择..." onvalidation="onValidation"/>
   </td>
   <td class="required_text" width="2%">*</td>
   <td>住址:</td>
   <td >
    	<input name="address" class="mini-textarea"  value="${farmer.address}" style="width:90%"
    		errorMode="none" onvalidation="onValidation"/>
   </td>
 </tr>
 <tr>
	<td></td>
	<td id="villages_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="address_error" class="errorText" colspan="2"></td>
</tr>
 <tr>
 	<td class="required_text" width="2%"></td>
 	<td >家庭人数:</td>
    <td  >
    	<input name="familynum" class="mini-textbox"  value="${farmer.familynum}"style="width:90%"
    		errorMode="none" onvalidation="onValidation"/>
    </td>
    <td class="required_text" width="2%"></td>
    <td >劳动力人数:</td>
    <td  >
    	<input name="labornum" class="mini-textbox" value="${farmer.labornum}" style="width:90%"
        	errorMode="none" onvalidation="onValidation"/>

    </td>
</tr>
<tr>
	<td></td>
	<td id="familynum_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="labornum_error" class="errorText" colspan="2"></td>
</tr>
<tr>
	<td class="required_text" width="2%"></td>
	<td >政治面貌:</td>
    <td >
    	<input name="politicstatus" class="mini-combobox"  value="${farmer.politicstatus}" style="width:90%"
            errorMode="none" url="/bank/dic/PoliticStatus.txt" emptyText="请选择..." onvalidation="onValidation"/>
    </td>
    <td class="required_text" width="2%"></td>
	<td >邮政编码:</td>
    <td >
    	<input name="postcode" class="mini-textbox"  value="${farmer.postcode}" style="width:90%"
    		errorMode="none" onvalidation="onValidation"/>
    </td>
</tr>
<tr>
	<td></td>
	<td id="politicstatus_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="postcode_error" class="errorText" colspan="2"></td>
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
	function submitForm() {           
		var form = new mini.Form("#form1");
	    form.validate();
		if (form.isValid() == false) return;
		$("form").submit();
	}
	function updateError(e) {
		var id = e.sender.name + "_error";
	    var el = document.getElementById(id);
	    if (el) {
	        el.innerHTML = e.errorText;
	    }
	}
	function onValidation(e) {                  
	    updateError(e);
	}

</script>
</body>
</html>