<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<style type="text/css">
	*{margin:0;padding:0;text-decoration:none}
	body{overflow-x:hidden}
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
 width:124px;
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
 width:123px;
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
input{
 border:1px solid #A5ACB5;
 height:1.5em;
 line-height:1.5em;
}
select{
width:91%;
height:1.5em;
line-height:1.5em;
}
 </style>
</head>
<body>
<form  action="/bank/farmer/saveHouse.do" id="farmerHouse" class="farmerHouse" method="POST">
<div class="topMenu" style="background:linear-gradient(#6DC8E3,white)">
<table cellpadding="0" cellspacing="0"  height="60px">
    <tr>
    	<td class="labelName" width="25%" align="right">姓名:</td>
    	<td width="2%"></td>
    	<td class="labelValue" width="8%">${farmer.farmerName }</td>
    	<td class="labelName" width="12%" align="right">证件号码:</td>
    	<td width="2%"></td>
    	<td class="labelValue" width ="20%">${farmer.farmerIdnum }</td>
    	<td width="50px" align="right">
       	 <input type="submit" id="saveBtn"  value=""/>
        </td>
        <td width="50px"  >
         <input type="button" id="backBtn" onclick="back()" value=""/>
        </td>
    </tr>
</table>
</div>
<fieldset style="width:90%;margin:auto auto">
<legend><label>农户房产基本情况</label></legend>
<div class="fieldset-body">
<table width="100%"><tr><td>
<input name="id" class="mini-hidden" value="${house.id}" />
<input name="farmerId" class="mini-hidden" value="${farmer.id}" />
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr><td style="width:100%">
<table width="100%">
<tr>
	<td style="width:15%"><font color="red">*</font>房产性质:</td>
    <td style="width:35%">
    	<select name="houseProperty">
    		<option value="1">自建房</option> 
			<option value="2">商品房</option> 
			<option value="3">经济适用房</option> 
			<option value="4">集资房</option> 
			<option value="5">商用房</option> 
			<option value="6">其他</option> 
    	</select>
    </td>
   	<td style="width:15%"><font color="red">*</font>房屋类型:</td>
    <td style="width:35%">
   		<select name="houseType">
   			<option value ="1">钢混结构</option>
   			<option value ="2">砖混结构</option>
   			<option value ="3">砖木结构</option>
   			<option value ="4">茅土结构</option>
   			<option value ="9">其他</option>
   		</select>
    </td>
</tr>
<tr>
	<td style="width:15%"><font color="red">*</font>房屋地址:</td>
    <td style="width:35%">
    	<input type="text" id="houseAddress"  name="houseAddress"  class="bank_text" value ="${house.houseAddress}" style="width:90%"/>
    </td>
    <td style="width:15%"><font color="red">*</font>购建年份(年):</td>
    <td style="width:35%">
    	<input id="buildDate" name="buildDate"  value="${house.buildDate}" style="width:90%"/>
	</td>
</tr>
<tr class="err_detail">
	<td colspan="2" id="houseAddress_validate" ></td>
	<td colspan="2" id="buildDate_validate" ></td>
</tr>
<tr>
	 <td style="width:15%"><font color="red">*</font>建筑面积(平方米):</td>
     <td style="width:35%">
    	<input id="buildArea" name="buildArea"  value ="${house.buildArea}" style="width:90%"/>
     </td>
	 <td style="width:15%"><font color="red">*</font>占地面积(平方米):</td>
     <td style="width:35%">
     	<input id="floorArea" name="floorArea"   value="${house.floorArea}" style="width:90%"/>
	 </td>
</tr>
<tr class="err_detail">
	<td colspan="2" id="buildArea_validate" ></td>
	<td colspan="2" id="floorArea_validate" ></td>
</tr>
<tr>
	<td style="width:15%"><font color="red">*</font>购建价格(元):</td>
    <td style="width:35%">
    	<input id="buildPrice" name="buildPrice"  value="${house.buildPrice}" style="width:90%"/>
    </td>
     <td style="width:15%"><font color="red">*</font>当前评估价格(元):</td>
     <td style="width:35%">
     	<input id="assessPrice" name="assessPrice"  value="${house.assessPrice}" style="width:90%"/>
     </td>
</tr>
<tr class="err_detail">
	<td colspan="2" id="buildPrice_validate" ></td>
	<td colspan="2" id="assessPrice_validate" ></td>
</tr>
</table>
</td></tr>
</table>
</td></tr>
</table>
</div>
</fieldset>
</form>
<script type="text/javascript">
	function back(){
		history.go(-1);
	}
	$(document).ready(function(){
		
		function _valid_HouseAddress(value){
			return  notBlankValid("#houseAddress",value,"不能为空!");
		}
		function _valid_buildDate(value){
			return notBlankValid("#buildDate",value,"不能为空!") && numberValid("#buildDate",value,"无效的年份!")
			&& notZeroStartNumberValid("#buildDate",value,"不能以0开头!") && lengthValid("#buildDate",value,4,"长度不准确!");
		}
		function _valid_buildArea(value){
			return notBlankValid("#buildArea",value,"不能为空!") && numberValid("#buildArea",value,"必须为数字类型!")
		}
		function _valid_floorArea(value){
			return notBlankValid("#floorArea",value,"不能为空!") && numberValid("#floorArea",value,"必须为数字类型!");
		}
		function _valid_buildPrice(value){
			return notBlankValid("#buildPrice",value,"不能为空!") && numberValid("#buildPrice",value,"必须为数字类型!");
		}
		function _valid_assessPrice(value){
			return notBlankValid("#assessPrice",value,"不能为空!") && numberValid("#assessPrice",value,"必须为数字类型!");
		}
		$("#farmerHouse").submit(function(){
			if(_valid_HouseAddress($("#houseAddress").val()) 
				&& _valid_buildDate($("#buildDate").val())
			 	&& _valid_buildArea($("#buildArea").val())
				&& _valid_floorArea($("#floorArea").val())
				&& _valid_buildPrice($("#buildPrice").val())
				&& _valid_assessPrice($("#assessPrice").val()
			)){
				return true;
			}else{
				alert("未通过校验!");
				return false;
			}
		});
		$("#houseAddress").keyup(function(){
			_valid_HouseAddress($(this).val());
		});
		$("#buildDate").keyup(function(){
			_valid_buildDate($(this).val());
		});
		$("#buildArea").keyup(function(){
			_valid_buildArea($(this).val());
		});
		$("#floorArea").keyup(function(){
			_valid_floorArea($(this).val());
		});
		$("#buildPrice").keyup(function(){
			_valid_buildPrice($(this).val());
		});
		$("#assessPrice").keyup(function(){
			_valid_assessPrice($(this).val());
		});

	});
	function notBlankValid(name,value,msg){
		if(value == '' || value == null){
			showMsg(name,false,msg);
			return false;
		}else{
			showMsg(name,true,null);
			return true;
		}
	}
	function numberValid(name,input,msg){
		var reg = /^[0-9]+?[0-9]*$/;
		if(!reg.test(input)){
			showMsg(name,false,msg);
			return false;
		}else{
			showMsg(name,true,null);
			return true;
		}
	}
	function notZeroStartNumberValid(name,value,msg){
		if(value.substr(0,1) =='0'){
			showMsg(name,false,msg);
			return false;
		}else{
			showMsg(name,true,null);
			return true;
		}
	}
	function lengthValid(name,value,len,msg){
		if(value.length != len){
			showMsg(name,false,msg);
			return false;
		}else{
			showMsg(name,true,null);
			return true;
		}
	};
	function showMsg(name,valid,msg){
		if(valid){
			$(name+"_validate").html("");
		}else{
			$(name+"_validate").css("color","red");
			$(name+"_validate").html(msg);
		}
	}

</script>
</body>
</html>