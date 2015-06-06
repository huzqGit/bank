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
	<li class="active">
			资产信息
	</li>
	<li >
			<a href="/bank/jsp/common/bankBuilding.jsp?form=compunish">奖惩信息</a>
	</li>
	<li >
			<a href="/bank/jsp/common/bankBuilding.jsp?form=insured">参保信息</a>
	</li>
	<li >
			<a href="/bank/jsp/common/bankBuilding.jsp?form=other">其他信息</a>
	</li>
</ul>
</div>
<div class="topMenu" style="background:linear-gradient(#6DC8E3,white)">
<table cellpadding="0" cellspacing="0" height="40px">
    <tr>
        <td width="200px" id="guid1" class="active" align="center" onclick="linkUrl(1)">房产基本情况</td>
        <td width="1px" class="line"></td>
        <td width="200px" id="guid2" class="inactive" align="center" onclick="linkUrl(2)">林权基本情况</td>
        <td width="1px" class="line"></td>
        <td width="200px" id="guid3"  class="inactive" align="center" onclick="linkUrl(3)">种养殖基本情况</td>
        <td width="1px" class="line"></td>
        <td width="200px" id="guid4"  class="inactive" align="center" onclick="linkUrl(4)">主要设备情况</td>                
        <td width="15px"></td>
        <td width="65px">
       	 <button id="saveBtn" onclick="save()"></button>
        </td>
    </tr>
</table>
<form id="farmer">
<input name="id" class="mini-hidden" value="${farmer.id}" />
<table width ="100%" height="30px">
	<tr>
		<td class="labelName" width="30%" align="right">姓名</td>
		<td class="labelValue" width="1%" align="center">:</td>
		<td class="labelValue" width="10%">${farmer.farmerName }</td>
		<td class="labelName" width="10%" align="center">身份证号码</td>
		<td class="labelValue" width="1%">:</td>
		<td class="labelValue" align="left">${farmer.farmerIdnum}</td>
	</tr>
</table>
</form>
</div>
<div id="tab1" class="display">
<fieldset style="width:90%;margin:auto auto">
<legend><label>农户房产基本情况</label></legend>
<div class="fieldset-body">
<table width="100%"><tr><td>
<c:forEach items="${houses}" var="house" varStatus="status">
<form  id="farmerHouse${status.index}" class="farmerHouse" method="POST">
<input name="id" class="mini-hidden" value="${house.id}" />
<input name="farmerId" class="mini-hidden" value="${house.farmerId}" />
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr><td style="width:100%">
<table width="100%">
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>房产性质:</label></td>
    <td style="width:35%">
    	<input name="houseProperty" class="mini-combobox" value="${house.houseProperty}" 
    	style="width:90%" url="/bank/dic/HouseProperty.txt" emptyText="请选择..."/>
    </td>
   	<td style="width:15%"><label for="textbox2$text"><font color="red">*</font>房屋类型:</label></td>
    <td style="width:35%" >
    	<input name="houseType" class="mini-combobox" value ="${house.houseType}" style="width:90%"
        url="/bank/dic/HouseType.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>房屋地址:</label></td>
    <td style="width:35%">
    	<input name="houseAddress" class="mini-textbox" value ="${house.houseAddress}" style="width:90%"/>
    </td>
    <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>购建年份:</label></td>
    <td style="width:35%">
    	<input name="buildDate" class="mini-textbox" value="${house.buildDate}" style="width:90%"/>
	</td>
</tr>
<tr>
	 <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>建筑面积(平方米):</label></td>
     <td style="width:35%">
    	<input name="buildArea" class="mini-textbox" value ="${house.buildArea}" style="width:90%"/>
     </td>
	 <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>占地面积(平方米):</label></td>
     <td style="width:35%">
     	<input name="floorArea" class="mini-textbox"  value="${house.floorArea}" style="width:90%"/>
	 </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>购建价格(元):</label></td>
    <td style="width:35%">
    	<input name="buildPrice" class="mini-spinner" value="${house.buildPrice}"
    		 style="width:90%" minValue="0"/>
    </td>
     <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>当前评估价格(元):</label></td>
     <td style="width:35%">
     	<input name="assessPrice" class="mini-spinner" value="${house.assessPrice}" 
     		style="width:90%"  minValue="0"/>
     </td>
</tr>
</table>
</td></tr>
</table>
</form>
</c:forEach>
</td></tr>
<tr>
<td align="center">
	<input class="addBtn"  type="button"  value="" onclick="addHouse()"/>
</td></tr></table>
</div>
</fieldset>
</div>
<div id="tab2" class="hidden">
<fieldset style="width:90%;margin:auto auto">
<legend><label>农户林权基本情况</label></legend>
<div class="fieldset-body">
<table width="100%"><tr><td>
<c:forEach items="${forests}" var ="forest" varStatus="status">
<form  id="farmerForest${status.index}" class="farmerForest" method="POST">
<input name="id" class="mini-hidden" value="${forest.id}"/>
<input name="farmerId" class="mini-hidden" value="${house.farmerId}" />
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr><td style="width:100%">
<table width="100%">
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>林权证编号:</label></td>
	<td style="width:35%">
		<input name="cardNum" class="mini-textbox" value="${forest.cardNum}" 
			required="true" requiredErrorText="不能为空" style="width:90%"/>
    </td>
    <td style="width:15%"><label for="textbox2$text"><font color="red">*</font>林权字号:</label></td>
    <td style="width:35%" >
	    <input name="wordNum" class="mini-textbox" value="${forest.wordNum}" 
	    	required="true" requiredErrorText="不能为空" style="width:90%"/>
    </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>林权使用人:</label></td>
    <td style="width:35%">
    	<input name="user" class="mini-textbox"  value="${forest.user}" 
    		required="true" requiredErrorText="不能为空" style="width:90%"/>
    </td>
    <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>林权使用种类:</label></td>
    <td style="width:35%">
        <input name="useType" class="mini-combobox" value="${forest.useType}" 
        	required="true" requiredErrorText="不能为空" style="width:90%"
        	url="/bank/dic/ForestType.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>面积(亩):</label></td>
	<td style="width:35%">
		<input name="area" class="mini-textbox" value="${forest.area}" 
			required="true" requiredErrorText="不能为空" style="width:90%"/>
    </td>
    <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>蓄积量:</label></td>
    <td style="width:35%">
    	<input name="storeNum" class="mini-textbox" value="${forest.storeNum}" 
    		required="true" requiredErrorText="不能为空" style="width:90%"/>
    </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>使用权期限:</label></td>
    <td style="width:35%">
   		<input name="timeLimit" class="mini-textbox"  value="${forest.timeLimit}"
   			required="true" requiredErrorText="不能为空" style="width:90%"/>
    </td>
    <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>当前评估价格(元):</label></td>
    <td style="width:35%">
    	<input name="assessPrice" class="mini-spinner" value="${forest.assessPrice}" 
    		required="true" requiredErrorText="不能为空" style="width:90%"/>
   	</td>
</tr>
</table>
</td></tr>
</table>
</form>
</c:forEach>
</td></tr>
<tr><td align="center">
	<input class="addBtn"  type="button" value="" onclick="addForest()"/>
</td></tr>
</table>
</div>
</fieldset>
</div>
<div id="tab3" class="hidden">
<fieldset style="width:90%;margin:auto auto">
<legend><label>农户种养殖基本情况</label></legend>
<div class="fieldset-body">
<table width="100%" >
<tr><td style="width:100%">
<c:forEach items="${breeds}" var="breed" varStatus="status">
<form  id="farmerBreed${status.index}" class="farmerBreed" method="POST">
<input name="id" class="mini-hidden" value="${breed.id}"/>
<input name="farmerId" class="mini-hidden" value="${house.farmerId}" />
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
    	<input name="output" class="mini-textbox"  value="${breed.output}"
    		required="true"  requiredErrorText="不能为空" style="width:90%"/>
    </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>占地面积(平方米 )</label></td>
    <td style="width:35%">
    	<input name="floorArea" class="mini-textbox" value="${breed.floorArea}"
    		required="true" requiredErrorText="不能为空" style="width:90%"/>
    </td>
    <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>年平均产值(元)</label></td>
    <td style="width:35%">
    	<input name="outputValue" class="mini-spinner" value="${breed.outputValue}" style="width:90%"
    		required="true" requiredErrorText="不能为空" minValue="0" maxValue="999999999999" format="n"/>
    </td>
</tr>
<tr>
    <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>当前评估价格(元):</label></td>
    <td style="width:35%">
    	<input name="assessPrice" class="mini-spinner" value="${breed.assessPrice}" style="width:90%"
    		required="true" requiredErrorText="不能为空" minValue="0" maxValue="999999999999" format="n"/>
    </td>
</tr>
</table>
</td></tr></table>
</form>
</c:forEach>
</td></tr>
<tr><td align="center">
	<input class="addBtn" type="button" value="" onclick="addBreed()"/>
</td></tr></table>
</div>
</fieldset>
</div>
<div id="tab4" class="hidden">
<fieldset style="width:90%;margin:auto auto">
<legend><label>主要设备基本情况</label></legend>
<div class="fieldset-body">
<table width="100%"><tr><td>
<c:forEach items="${devices}" var="device" varStatus="status">
<form  id="farmerDevice${status.index}" class="farmerDevice" method="POST">
<input name="id" class="mini-hidden" value="${device.id}"/>
<input name="farmerId" class="mini-hidden" value="${house.farmerId}" />
<table border="0" cellpadding="1" cellspacing="10" width="100%" >
<tr><td>
<table width="100%">
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>设备名称:</label></td>
    <td style="width:30%">
	    <input name="name" class="mini-textbox"  value="${device.name}" required="true"
	           requiredErrorText="不能为空" style="width:90%"/>
    </td>
    <td style="width:15%"><label for="textbox2$text"><font color="red">*</font>品牌型号:</label></td>
    <td style="width:30%" >
        <input id="textbox2"  name="brand" class="mini-textbox" value="${device.brand}" style="width:90%"/>
    </td>
</tr>
<tr>
    <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>构建价格(元):</label></td>
    <td style="width:30%">
    	<input name="buyingPrice" class="mini-spinner" value="${device.buyingPrice}" required="true"
        	requiredErrorText="购建价格不能为空" style="width:90%" minValue="0" />
    </td>
    <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>购进年份:</label></td>
    <td style="width:30%">
    	<input name="buyingDate" class="mini-textbox" value="${device.buyingDate}" required="true"
        	requiredErrorText="购进年份不能为空" style="width:90%" />
    </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>当前评估价格(元):</label></td>
    <td style="width:30%">
   		<input id="textbox1"  name="assessPrice" class="mini-spinner" value="${device.assessPrice}" style="width:90%"
   			required="true" requiredErrorText="当前评估价格不能为空" minValue="0" />
    </td>
</tr>
</table>
</td></tr></table>
</form>
</c:forEach>
<tr><td align="center">
	<input class="addBtn" type="button" value="" onclick="addDevice()"/>
</td></tr>
</table>
</div>
</fieldset>
</div>
<script type="text/javascript">
	mini.parse();
    function save(){
    	var farmer,house,forest,breed,device;
    	farmer= getData("farmer");
    	house=getDataArray("farmerHouse");
    	forest=getDataArray("farmerForest"); 
    	breed=getDataArray("farmerBreed");
    	device=getDataArray("farmerDevice");
	    $.ajax({
	    	url: "/bank/farmer/saveChanQuan.do",
	        type: "post",
	        data: { farmer:farmer,house:house,forest:forest,breed:breed,device:device},
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        success: function (text) {
	       	var data = mini.decode(text);   //反序列化成对象
		    if(data.farmer.id!=null){
		    	var obj = new mini.Form("#farmer");
		    	obj.setData(data.farmer);  
		    };

	       	if(data.house.length>0){
	       		for(var i=0;i<data.house.length;i++){
	       			var obj=new mini.Form("#farmerHouse"+i);
	       			obj.setData(data.house[i]);
	      		}
	       	}
	    	if(data.forest.length>0){
	       		for(var i=0;i<data.forest.length;i++){
	       			var obj=new mini.Form("#farmerForest"+i);
	       			obj.setData(data.forest[i]);
	      		}
	       	}
	    	if(data.breed.length>0){
	       		for(var i=0;i<data.breed.length;i++){
	       			var obj=new mini.Form("#farmerBreed"+i);
	       			obj.setData(data.breed[i]);
	      		}
	       	}
	    	if(data.device.length>0){
	       		for(var i=0;i<data.device.length;i++){
	       			var obj=new mini.Form("#farmerDevice"+i);
	       			obj.setData(data.device[i]);
	      		}
	       	}
	       	mini.alert('保存成功！');
	       },
	       error: function (jqXHR, textStatus, errorThrown) {
	           mini.alert('系统异常！');
	       }
  		});
   }
  function back(){
	  window.history.go(-1);
  }
  function getData(name){
	 return  mini.encode(new mini.Form(name).getData());
  }
  function getDataArray(name){
	var size=$("."+name).length;
  	var array=new Array();
  	for(var i=0;i<size;i++){
  		var id=name+i;
  		var form=new mini.Form(id);
  	    var data=form.getData();
  	  	array.push(data);
  	};
	return mini.encode(array);
  }
  function addMember(){
	  $(".farmerMember").last().after(FarmerMember($(".farmerMember").length));
	  mini.parse(); 
  }
  function addHouse(){
	  $(".farmerHouse").last().after(FarmerHouse($(".farmerHouse").length));
	  mini.parse(); 
  };
  function addForest(){
	  $(".farmerForest").last().after(FarmerForest($(".farmerForest").length));
	  mini.parse(); 
  }
  function addIncome(){
	  $(".farmerIncome").last().after(FarmerMember($(".farmerIncome").length));
	  mini.parse();  
  }
  function addCompunish(){
	  $(".farmerCompunish").last().after(FarmerCompunish($(".farmerCompunish").length));
	  mini.parse();  
  };
  function addDevice(){
	  $(".farmerDevice").last().after(FarmerDevice($(".farmerDevice").length));
	  mini.parse();  
  };
  function addBreed(){
	  $(".farmerBreed").last().after(FarmerBreed($(".farmerBreed").length));
	  mini.parse();  
  }

  function linkUrl(index){
	  var tab="tab"+index;
	  var guid="#guid"+index;
	  if($(".display")[0].id!=tab){
		  tab="#"+tab;
		  $(".display").addClass("hidden");
		  $(".display").removeClass("display");
		  $(".active").removeClass("active");
		  $(".active").addClass("inactive");
		  $(tab).addClass("display");
		  $(tab).removeClass("hidden");
		  $(guid).addClass("active");
		  $(guid).removeClass("inactive");
	  }
  }

</script>
</body>
</html>