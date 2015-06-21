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
.required_text,.errorText{
color:red
}
.required_text{
text-align:right
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
		<a href="/bank/farmer/queryCondition.do?fid=${farmer.id}">家庭成员信息</a>
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
       	 <input type="submit" id="saveBtn" value=""/>
        </td>
	</tr>
</table>
</div>
<div  style="width:90%;margin:auto auto">
<input name="id" class="mini-hidden" value="${farmer.id}" />
<input name="recorder" class="mini-hidden" value="管理员"/>
<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr><td colspan="4" style="width:100%">
<fieldset style="width:100%;margin:auto auto">
<legend><label>农户基本概况信息</label></legend>
<div class="fieldset-body">
<table width="100%">
<tr>
	<td class="required_text" width="2%" >*</td>
	<td style="width:10%">户主姓名:</td>
    <td style="width:38%">
    	<input type="text" id="farmername" name="farmerName" value="${farmer.farmername}" style="width:90%"
    		errorMode="none" required="true" requiredErrorText="户主姓名不能为空" onvalidation="onValidation"/>
    </td>
    <td class="required_text" width="2%">*</td>
    <td style="width:10%">户主身份证号:</td>
    <td style="width:38%" >
    	<input type="text" id="farmeridnum" name="farmeridnum" value="${farmer.farmeridnum}" style="width:90%"
    	 errorMode="none"  required="true" requiredErrorText="户主身份证号不能为空" onvalidation="onValidation"/>
    </td>
</tr>
<tr>
	<td></td>
	<td id="farmername_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="farmeridnum_error" class="errorText" colspan="2"></td>	
</tr>
<tr>
	<td class="required_text">*</td>
	<td >性别:</td>
	<td >
	    <input  name="sex" class="mini-combobox" value="${farmer.sex}" style="width:90%" 
	    errorMode="none" vtype="float" required="true" requiredErrorText="性别不能为空" onvalidation="onValidation"
	    url="/bank/dic/Sex.txt" emptyText="请选择..."/>
	</td>
	<td class="required_text">*</td>
	<td >婚姻状况:</td>
	<td >
	    <input  name="marrystatus" class="mini-combobox" value="${farmer.marrystatus}" style="width:90%" 
	    errorMode="none" vtype="float" required="true" requiredErrorText="婚姻状况不能为空" onvalidation="onValidation"
	    url="/bank/dic/MarryStatus.txt" emptyText="请选择..."/>
	</td>
</tr>
<tr>
	<td></td>
	<td id="sex_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="marrystatus_error" class="errorText" colspan="2"></td>	
</tr>
<tr>
	<td class="required_text">*</td>
	<td >开户银行:</td>
    <td  >
    	<input name="bank" class="mini-textbox"  value="${farmer.bank}" style="width:90%"
   		errorMode="none"required="true" requiredErrorText="开户银行不能为空" onvalidation="onValidation"/>
   </td>
	<td class="required_text">*</td>
	<td >银行账户:</td>
    <td >
    	<input name="account" class="mini-textbox" value="${farmer.account}" style="width:90%"/>
    </td>
</tr>
<tr>
	<td></td>
	<td id="bank_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="account_error" class="errorText" colspan="2"></td>	
</tr>
<tr>
	<td class="required_text">*</td>
	<td >所属乡镇:</td>
    <td  >
    	<input name="villages" class="mini-combobox"  value="${farmer.villages}" style="width:90%"
   		errorMode="none" vtype="float" required="true" requiredErrorText="所属乡镇不能为空" onvalidation="onValidation"
   		url="/bank/dic/Villages.txt" emptyText="请选择..." />
   </td>
	<td class="required_text">*</td>
	<td >联系电话:</td>
    <td >
    	<input name="phone" class="mini-textbox" value="${farmer.phone}" style="width:90%"/>
    </td>
</tr>
<tr>
	<td></td>
	<td id="phone_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="villages_error" class="errorText" colspan="2"></td>	
</tr>
<tr>
	<td class="required_text">*</td>
	<td >贫困户类型:</td>
    <td >
    	<input name="poortype" class="mini-textbox" value="${farmer.phone}" style="width:90%"
    	errorMode="none" vtype="float" required="true" requiredErrorText="贫困户类型不能为空" onvalidation="onValidation"/>
    </td>
    <td class="required_text">*</td>
    <td>主要致贫原因:</td>
    <td>
    	<input name="poorreason" class="mini-combobox"  value="${farmer.villages}" style="width:90%"
    	url="/bank/dic/Villages.txt" emptyText="请选择..."/>
   </td>
</tr>
<tr>
	<td></td>
	<td id="poortype_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="poorreason_error" class="errorText" colspan="2"></td>	
</tr>
<tr>
	<td class="required_text">*</td>
    <td >住址:</td>
    <td colspan="4" >
    	<input name="address" class="mini-textbox"  value="${farmer.address}" style="width:96%"
   		errorMode="none" vtype="float" required="true" requiredErrorText="住址不能为空" onvalidation="onValidation"/>
   </td>
 </tr>
 <tr>
	<td></td>
	<td id="required_error" class="errorText" colspan="4"></td>
</tr>
 <tr>
 <td class="required_text">*</td>
 	<td >家庭人数:</td>
    <td  >
    	<input name="familynum" class="mini-textbox"  value="${farmer.familynum}"style="width:90%"
    	errorMode="none" vtype="float" required="true" requiredErrorText="家庭人数不能为空" onvalidation="onValidation"/>
    </td>
    <td class="required_text">*</td>
    <td >劳动力人数:</td>
    <td  >
    	<input name="labornum" class="mini-textbox" value="${farmer.labornum}" style="width:90%"
        errorMode="none" vtype="float" required="true" requiredErrorText="劳动力人数不能为空" onvalidation="onValidation"/>

    </td>
</tr>
<tr>
	<td></td>
	<td id="familynum_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="laborNum_error" class="errorText" colspan="2"></td>	
</tr>
<tr>
<td class="required_text"></td>
	<td >政治面貌:</td>
    <td >
    	<input name="politicstatus" class="mini-combobox"  value="${farmer.politicstatus}" style="width:90%"
            url="/bank/dic/PoliticStatus.txt" emptyText="请选择..."/>
    </td>
    <td class="required_text"></td>
	<td >邮政编码:</td>
    <td >
    	<input name="postcode" class="mini-textbox"  value="${farmer.postcode}" style="width:90%"/>
    </td>
</tr>
<tr>
	<td></td>
	<td id="politicstatus_error" class="errorText" colspan="2"></td>
	<td></td>
	<td id="postcode_error" class="errorText" colspan="2"></td>	
</tr>
<tr>
		<td class="required_text" width="2%" >*</td>
		<td width="15%">饮水是否困难:</td>
		<td width="33%">
			<input name="drinkinghard" class="mini-combobox" value="${privateLending.drinkinghard}"  style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="饮水是否困难不能为空" onvalidation="onValidation"
			url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..." />
		</td>
		<td class="required_text" width="2%" >*</td>
		<td width="15%">饮水是否安全:</td>
		<td width="33%">
			<input name="drinkingsafe" class="mini-combobox"   value="${privateLending.drinkingsafe}" style="width:90%"
			 errorMode="none" vtype="float" required="true" requiredErrorText="饮水是否安全不能为空" onvalidation="onValidation"
			  url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..."/>
	   </td>
</tr>
<tr>
		<td ></td>
		<td id="drinkinghard_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="drinkingsafe_error" class="errorText" colspan="2"></td>
</tr>
<tr>
		<td class="required_text"  >*</td>
		<td >有无卫生厕所:</td>
		<td >
			<input name="usingtoilet" class="mini-combobox"   value="${privateLending.usingtoilet}" style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="有无卫生厕所不能为空" onvalidation="onValidation"
			url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..."/>
		</td>
		<td class="required_text"  >*</td>
		<td >是否通生活用电:</td>
		<td >
			<input name="usingelectric" class="mini-combobox" value="${privateLending.usingelectric}"  style="width:90%"  
			errorMode="none" vtype="float" required="true" requiredErrorText="是否通生活用电不能为空" onvalidation="onValidation"
			url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..."/>
		</td>	
</tr>
<tr>
		<td ></td>
		<td id="usingtoilet_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="usingelectric_error" class="errorText" colspan="2"></td>
</tr>
<tr>
		<td class="required_text"  >*</td>
		<td >主要燃料类型:</td>
		<td >
			<input name="fueltype" class="mini-combobox"   value="${privateLending.fueltype}" style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="主要燃料类型不能为空" onvalidation="onValidation"
			url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..." />
		</td>
		<td class="required_text"  >*</td>
		<td >是否通广播电视:</td>
		<td >
			<input name="usingtelevision" class="mini-combobox" value="${privateLending.usingtelevision}"  style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="是否通广播电视不能为空" onvalidation="onValidation"
			url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..."/>
		</td>	
</tr>
<tr>
		<td ></td>
		<td id="fueltype_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="usingtelevision_error" class="errorText" colspan="2"></td>
</tr>
<tr>
		<td class="required_text"  >*</td>
		<td >是否加入农民合作社:</td>
		<td >
			<input name="usingartel" class="mini-combobox" value="${privateLending.usingartel}"  style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="是否加入农民合作社不能为空" onvalidation="onValidation"
			url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..."/>
		</td>
</tr>
<tr>
		<td ></td>
		<td id="usingartel_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="usingartel_error" class="errorText" colspan="2"></td>
</tr>
<tr>
		<td class="required_text"  >*</td>
		<td >入户路类型:</td>
		<td >
			<input name="roadtype" class="mini-combobox" value="${privateLending.roadtype}"  style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="入户路类型不能为空" onvalidation="onValidation"
			url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..." />
		</td>	
		<td class="required_text"  ></td>
		<td >距离村主干路:</td>
		<td >
			<input name="roaddistance" class="mini-textbox"   value="${privateLending.roaddistance}" style="width:90%"
			errorMode="none" vtype="float" onvalidation="onValidation"/>
		</td>
</tr>
<tr>
		<td ></td>
		<td id="roadtype_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="roaddistance_error" class="errorText" colspan="2"></td>
</tr>
<tr>
		<td class="required_text"  >*</td>
		<td >主要住房是否是危房:</td>
		<td >
			<input name="unsafehouse" class="mini-combobox"   value="${privateLending.unsafehouse}" style="width:90%"
			errorMode="none" vtype="float" required="true" requiredErrorText="主要住房是否是危房不能为空" onvalidation="onValidation"
			url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..." />
		</td>
		<td class="required_text"  ></td>
		<td >住房面积(平方米):</td>
		<td >
			<input name="housearea" class="mini-textbox"   value="${privateLending.housearea}" style="width:90%"
			errorMode="none" vtype="float" onvalidation="onValidation"/>
		</td>
</tr>
<tr>
		<td ></td>
		<td id="unsafehouse_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="housearea_error" class="errorText" colspan="2"></td>
</tr>
<tr>
		<td class="required_text"  ></td>
		<td >耕地面积(亩):</td>
		<td >
			<input name="plougharea" class="mini-textbox" value="${privateLending.plougharea}" style="width:90%"
			errorMode="none" vtype="float" onvalidation="onValidation"/>
		</td>
		<td class="required_text"  ></td>
		<td >有效灌溉面积(亩):</td>
		<td >
			<input  name="wateringarea" class="mini-textbox"  value="${privateLending.wateringarea}"  style="width:90%"
			errorMode="none" vtype="float" onvalidation="onValidation"/>
		</td>	
</tr>
<tr>
		<td ></td>
		<td id="plougharea_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="wateringarea_error" class="errorText" colspan="2"></td>
</tr>
<tr>
		<td class="required_text"  ></td>
		<td >林地面积(亩):</td>
		<td >
			<input name="forestarea" class="mini-textbox"   value="${privateLending.forestarea}" style="width:90%"
			errorMode="none" vtype="float"  onvalidation="onValidation"/>
		</td>
		<td class="required_text"  ></td>
		<td >退耕还林面积(亩):</td>
		<td >
			<input name="forestarea1" class="mini-textbox" value="${privateLending.forestarea1}"  style="width:90%"
			errorMode="none" vtype="float" onvalidation="onValidation"/>
		</td>	
</tr>
<tr>
		<td ></td>
		<td id="forestarea_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="forestarea1_error" class="errorText" colspan="2"></td>
</tr>
<tr>
		<td class="required_text"  ></td>
		<td >林果面积(亩):</td>
		<td >
			<input name="fruitarea" class="mini-textbox"   value="${privateLending.fruitarea}" style="width:90%"
			errorMode="none" vtype="float" onvalidation="onValidation"/>
		</td>
		<td class="required_text"  ></td>
		<td >牧草地面积(亩):</td>
		<td >
			<input name="meadowarea" class="mini-textbox" value="${privateLending.meadowarea}"  style="width:90%"
			errorMode="none" vtype="float"  onvalidation="onValidation"/>
		</td>	
</tr>
<tr>
		<td ></td>
		<td id="fruitarea_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="meadowarea_error" class="errorText" colspan="2"></td>
</tr>
<tr>
		<td class="required_text"  ></td>
		<td >水面面积(亩):</td>
		<td >
			<input name="waterarea" class="mini-textbox"   value="${privateLending.waterarea}" style="width:90%"
			errorMode="none" vtype="float" onvalidation="onValidation"/>
		</td>
		<td class="required_text"  ></td>
		<td >家庭年度纯收入(元 ):</td>
		<td >
			<input name="netincome" class="mini-textbox" value="${privateLending.netincome}"  style="width:90%"
			errorMode="none" vtype="float" onvalidation="onValidation"/>
		</td>	
</tr>
<tr>
		<td ></td>
		<td id="waterarea_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="netincome_error" class="errorText" colspan="2"></td>
</tr>
<tr>
		<td class="required_text"  ></td>
		<td >全家工资性收入(元 ):</td>
		<td >
			<input name="wagesincome" class="mini-textbox"   value="${privateLending.wagesincome}" style="width:90%"
			errorMode="none" vtype="float" onvalidation="onValidation"/>
		</td>
		<td class="required_text"  ></td>
		<td >全家生产经营性收入(元):</td>
		<td >
			<input name="operateincome" class="mini-textbox" value="${privateLending.operateincome}"  style="width:90%"
			errorMode="none" vtype="float" onvalidation="onValidation"/>
		</td>	
</tr>
<tr>
		<td ></td>
		<td id="wagesincome_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="operateincome_error" class="errorText" colspan="2"></td>
</tr>
<tr>
		<td class="required_text"  ></td>
		<td >各类补贴(元):</td>
		<td >
			<input name="subsidyincome" class="mini-textbox"   value="${privateLending.subsidyincome}" style="width:90%"
			errorMode="none" vtype="float" onvalidation="onValidation"/>
		</td>
		<td class="required_text"  ></td>
		<td >领取低保金(元):</td>
		<td >
			<input name="lowinsure" class="mini-textbox" value="${privateLending.lowinsure}"  style="width:90%"
			errorMode="none" vtype="float"  onvalidation="onValidation"/>
		</td>	
</tr>
<tr>
		<td ></td>
		<td id="subsidyincome_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="lowinsure_error" class="errorText" colspan="2"></td>
</tr>
<tr>
		<td class="required_text"  ></td>
		<td >领取养老保险金(元):</td>
		<td >
			<input name="agedinsure" class="mini-textbox"   value="${privateLending.agedinsure}" style="width:90%"
			errorMode="none" vtype="float"  onvalidation="onValidation"/>
		</td>
		<td class="required_text"  ></td>
		<td >生态补偿金:</td>
		<td >
			<input name="ecoamount" class="mini-textbox" value="${privateLending.ecoamount}"  style="width:90%"
			errorMode="none" vtype="float"  onvalidation="onValidation"/>
		</td>	
</tr>
<tr>
		<td ></td>
		<td id="agedinsure_error" class="errorText" colspan="2"></td>
		<td ></td>
		<td id="ecoamount_error" class="errorText" colspan="2"></td>
</tr>
</table>
</div>
</fieldset>
</td></tr>
</table>
</div>
</form>
<script type="text/javascript">
	mini.parse();
	function back(){
		window.history.go(-1);
	}
	function submitForm() {           
	 	var form = new mini.Form("#form1");
	    form.validate();
		if (form.isValid() == false) return;
		$("#farmerLoan").submit();
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