<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<style type="text/css">
	*{margin:0;padding:0;text-decoration:none}
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
	#saveBtn{width:100px;height:25px;border:0;background:url(/bank/images/save.png) no-repeat}
	#backBtn{width:100px;height:25px;border:0;background:url(/bank/images/back.png) no-repeat}
	.addBtn{width:100px;height:25px;border:0;background:url(/bank/images/add.png) no-repeat}
	.labelName{font-size:15px;font-weight:bold;color:darkgreen;}
	.labelValue{font-size:15px;font-weight:bold;color:red;}
 </style>
</head>
<body>
<div class="topMenu" style="background:linear-gradient(#6DC8E3,white)">
<table cellpadding="0" cellspacing="0" height="40px">
    <tr>
        <td width="200px" id="guid1" class="active" align="center" onclick="linkUrl(1)">当前未结情况</td>
        <td width="1px" class="line"></td>
        <td width="200px" id="guid2" class="inactive" align="center" onclick="linkUrl(2)">不良贷款情况</td>
        <td width="1px" class="line"></td>
        <td width="200px" id="guid3"  class="inactive" align="center" onclick="linkUrl(3)">对外担保情况</td>
        <td width="1px" class="line"></td>
        <td width="65px">
       	 <button id="saveBtn" onclick="save()"></button>
        </td>
        <td width="65px"  >
         <button id="backBtn" onclick="back()"></button>
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
<form action="/bank/company/save.do" method="POST">
	<input type="hidden" name="deviceId"/>
	<input name="recorder" class="mini-hidden" value="管理员"/>
	<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
	<table border="0" cellpadding="1" cellspacing="15" width="100%" >
	<tr>
	<td >
	<table width="100%">
	<tr>
	<td style="width:10%"><label for="textbox1$text">户主姓名:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="farmerName" class="mini-textbox" required="true" 
		requiredErrorText="户主姓名不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox2$text">户主身份证号:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="farmerIdnum" class="mini-textbox" required="true" 
		requiredErrorText="户主身份证号不能为空"  style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">贷款金融机构:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="bank" class="mini-textbox" required="true" 
		requiredErrorText="贷款金融机构不能为空"style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox2$text">业务类别:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="businessType" class="mini-textbox" required="true" 
		requiredErrorText="业务类别不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">贷款用途:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="loanUse" class="mini-textbox" required="true" 
		requiredErrorText="贷款用途不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox1$text">贷款方式:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="loanWay" class="mini-combobox" required="true" 
		requiredErrorText="贷款方式不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">贷款余额(万元):</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="loanBalance" class="mini-textbox" required="true" 
		requiredErrorText="当前评估价格不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox1$text">贷款发放时间:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="provideTime" class="mini-datepicker" required="true" 
		requiredErrorText="贷款发放时间不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">贷款到期时间:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="limitTime" class="mini-datepicker" required="true" 
		requiredErrorText="贷款到期时间不能为空" style="width:90%"/>
	</td>
	</tr>
	</table>
	</td>
	</tr>
	</table>
	</form>
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
<legend><label>农户不良贷款情况基本信息</label></legend>
<div class="fieldset-body">
<table width="100%"><tr><td>
<form action="/bank/company/save.do" method="POST">
	<input type="hidden" name="badloanId"/>
	<input name="recorder" class="mini-hidden" value="管理员"/>
	<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
	<table border="0" cellpadding="1" cellspacing="15" width="100%" >
	<tr>
	<td colspan="4" style="width:100%">
	<div class="fieldset-body">
	<table width="100%">
	<tr>
	<td style="width:10%"><label for="textbox1$text">户主姓名:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="farmerName" class="mini-textbox" required="true" 
		requiredErrorText="户主姓名不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox2$text">户主身份证号:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="farmerIdNum" class="mini-textbox" required="true" 
		requiredErrorText="户主身份证号不能为空"  style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">贷款金融机构:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="bank" class="mini-textbox" required="true" 
		requiredErrorText="贷款金融机构不能为空"style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox2$text">不良贷款余额:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="balance" class="mini-textbox" required="true" 
		requiredErrorText="不良贷款余额不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">不良贷款偿还日期:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="paymentTime" class="mini-datepicker" required="true" 
		requiredErrorText="不良贷款偿还日期" style="width:90%"/>
	</td>
	</tr>
	</table>
	</td>
	</tr>
	</table>
	</form>
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
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>占地面积(亩)</label></td>
    <td style="width:35%">
    	<input name="floorArea" class="mini-textbox" value="${breed.floorArea}"
    		required="true" requiredErrorText="不能为空" style="width:90%"/>
    </td>
    <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>年平均产值(万元)</label></td>
    <td style="width:35%">
    	<input name="outputValue" class="mini-spinner" value="${breed.outputValue}" style="width:90%"
    		required="true" requiredErrorText="不能为空" minValue="0" maxValue="999999999999" format="n"/>
    </td>
</tr>
<tr>
    <td style="width:15%"><label for="textbox1$text"><font color="red">*</font>当前评估价格:</label></td>
    <td style="width:35%">
    	<input name="assessPrice" class="mini-spinner" value="${breed.assessPrice}" style="width:90%"
    		required="true" requiredErrorText="不能为空" minValue="0" maxValue="999999999999" format="n"/>
    </td>
</tr>
</table>
</td></tr></table>
</form>
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
<form action="/bank/company/save.do" method="POST">
	<input name="id" class="mini-hidden"/>
	<input name="recorder" class="mini-hidden" value="管理员"/>
	<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
	<table width="100%">
	<tr>
	<td style="width:10%"><label for="textbox1$text">户主姓名:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="farmerName" class="mini-textbox" required="true" 
		requiredErrorText="户主姓名不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox2$text">户主身份证号:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="farmerIdNum" class="mini-textbox" required="true" 
		requiredErrorText="户主身份证号不能为空"  style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">被担保人姓名:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="name" class="mini-textbox" required="true" 
		requiredErrorText="被担保人姓名不能为空"style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox2$text">被担保人身份证号:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="idNum" class="mini-textbox" required="true" 
		requiredErrorText="被担保人身份证号不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">未结清担保到期日:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="limitTime" class="mini-textbox" required="true" 
		requiredErrorText="未结清担保到期日能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox1$text">未结清担保金:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="deposit" class="mini-textarea" required="true" 
		requiredErrorText="未结清担保金不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">未结清担保金合计:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="depositAll" class="mini-combobox" required="true" 
		requiredErrorText="未结清担保金合计不能为空" style="width:90%"/>
	</td>
	</tr>
	</table>
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