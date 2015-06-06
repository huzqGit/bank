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
 width:185px;
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
<form  action="/bank/farmer/saveBreed1.do" class="farmerBreed" method="POST">
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
<legend><label>农户种养殖基本情况</label></legend>
<div class="fieldset-body">
<table width="100%" >
<tr><td style="width:100%">
<input name="id" class="mini-hidden" value="${breed.id}"/>
<input name="farmerId" class="mini-hidden" value="${farmer.id}" />
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr><td style="width:100%">
<table width="100%">
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>种养殖品种:</label></td>
    <td style="width:35%">
    	<input name="variety" class="mini-combobox" value="${breed.variety}" style="width:90%"
    	 	required="true"  requiredErrorText="不能为空" url="/bank/dic/BreedType.txt" emptyText="请选择..."/>
    </td>
    <td style="width:15%"><label for="textbox2$text"><font color="red">*</font>年产量(或出栏量):</label></td>
    <td style="width:35%" >
    	<input  name="output" class="mini-textbox"  value="${breed.output}"
    		required="true"  requiredErrorText="不能为空" style="width:90%"/>
    </td>
</tr>
<tr>
	<td id="variety_error" class="errorText" colspan="2"></td>
	<td id="output_error" class="errorText" colspan="2"></td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>占地面积(平方米 )</label></td>
    <td style="width:35%">
    	<input name="floorArea" class="mini-textbox" value="${breed.floorArea}"
    		required="true" requiredErrorText="不能为空" style="width:90%"/>
    </td>
    <td style="width:15%"><font color="red">*</font>年平均产值(元)</td>
    <td style="width:35%">
    	<input  name="outputValue" class="mini-spinner" value="${breed.outputValue}" style="width:90%"
    		required="true" requiredErrorText="不能为空" minValue="0" maxValue="999999999999" format="n"/>
    </td>
</tr>
<tr>
    <td style="width:15%"><font color="red">*</font>当前评估价格(元):</td>
    <td style="width:35%">
    	<input name="assessPrice" class="mini-spinner" value="${breed.assessPrice}" style="width:90%"
    		required="true" requiredErrorText="不能为空" minValue="0" maxValue="999999999999" format="n"/>
    </td>
</tr>
</table>
</td></tr></table>
</td></tr></table>
</div>
</fieldset>
</form>
<script type="text/javascript">
	function back(){
		history.go(-1);
	}
</script>
</body>
</html>