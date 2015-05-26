<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户基本信息</title>
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
	.labelName{font-size:15px;font-weight:bold;color:darkgreen;}
	.labelValue{font-size:15px;font-weight:bold;color:red;}
 </style>
</head>
<body>
<div class="topMenu" style="background:linear-gradient(#6DC8E3,white)">
<table width ="100%" height="60px">
	<tr>
		<td class="labelName" width="30%" align="right">姓名</td>
		<td class="labelValue" width="1%" align="center">:</td>
		<td class="labelValue" width="10%">${farmer.farmerName }</td>
		<td class="labelName" width="10%" align="center">身份证号码</td>
		<td class="labelValue" width="1%">:</td>
		<td class="labelValue" align="left">${farmer.farmerIdnum}</td>
		<td width="1%"></td>
    	<td width="50px" align="right">
       	 <input type="button" id="saveBtn" onclick="save()"/>
        </td>
        <td width="50px"  >
         <input type="button" id="backBtn" onclick="back()"/>
        </td>
	</tr>
</table>
</div>
<div  style="width:90%;margin:auto auto">
<form id="farmer" method="POST">
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
    <td style="width:40%">
    	<input name="farmerName" class="mini-textbox" value="${farmer.farmerName}" style="width:90%"
        	 enabled="false" required="true" requiredErrorText="户主姓名不能为空" />
    </td>
    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>户主身份证号:</label></td>
    <td style="width:40%" >
    	<input name="farmerIdnum" class="mini-textbox"  value="${farmer.farmerIdnum}" style="width:90%"
        	enabled="false" required="true" requiredErrorText="户主身份证号不能为空" />
   </td>
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
	    	<input  name="marryStatus" class="mini-combobox" value="${farmer.marryStatus}" 
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
   			required="true"  requiredErrorText="现住址不能为空"  />
   </td>
 </tr>
 <tr>
 	<td style="width:10%"><label for="textbox2$text"><font color="red">*</font>家庭人数:</label></td>
    <td style="width:40%" >
    	<input name="familyNum" class="mini-spinner"  value="${farmer.familyNum}"
        	minValue="1" maxValue="10" style="width:90%"/>
    </td>
    <td style="width:10%"><label for="textbox2$text">&nbsp;&nbsp;劳动力人数:</label></td>
    <td style="width:40%" >
    	<input name="laborNum" class="mini-spinner" value="${farmer.laborNum}" style="width:90%"
        	minValue="1" maxValue="20"/>

    </td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox1$text">&nbsp;&nbsp;政治面貌:</label></td>
    <td style="width:40%">
    	<input name="politicStatus" class="mini-combobox"  value="${farmer.politicStatus}" style="width:90%"
            url="/bank/dic/PoliticStatus.txt" emptyText="请选择..."/>
    </td>
	<td style="width:10%"><label for="textbox1$text">&nbsp;&nbsp;邮政编码:</label></td>
    <td style="width:40%">
    	<input name="postCode" class="mini-spinner"  value="${farmer.postCode}" style="width:90%"
        	minValue="100000" maxValue="99999"/>
    </td>
</tr>
</table>
</div>
</fieldset>
</td></tr>
</table>
</form>
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
<form id ="farmerMember${status.index}" class="farmerMember" method="POST">
<input class="mini-hidden" name="id" value="${member.id}"/>
<input class="mini-hidden" name="farmerId" value="${member.farmerId}"/>
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr>
<td colspan="4" style="width:100%">
<table width="100%">
<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>家庭成员姓名:</label></td>
    <td style="width:40%">
    	<input name="name" class="mini-textbox" value="${member.name }"
         	required="true" requiredErrorText="家庭成员姓名不能为空" style="width:90%"/>
    </td>
    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>与户主关系:</label></td>
    <td style="width:40%" >
       <input name="relation" class="mini-combobox"  value="${member.relation }"
            required="true" requiredErrorText="与户主关系不能为空"  style="width:90%"
        	url="/bank/dic/Relation.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>身份证号:</label></td>
    <td style="width:40%">
    	<input name="idNum" class="mini-textbox" value="${member.idNum }"
        	required="true"	 requiredErrorText="身份证号不能为空" style="width:90%"/>
    </td>
    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>文化程度:</label></td>
    <td style="width:40%" >
    	<input name="education" class="mini-combobox" value="${member.education}" style="width:90%"
        	url="/bank/dic/Education.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox2$text"><font color="red">*</font>性别:</label></td>
    <td style="width:40%" >
    	<input name="sex" class="mini-combobox" value="${member.sex }" style="width:90%"
        	required="true"  requiredErrorText="性别不能为空" url="/bank/dic/Sex.txt" emptyText="请选择..."/>
   </td>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>婚姻状况:</label></td>
    <td style="width:40%">
	    <input name="marryStatus" class="mini-combobox" value="${member.marryStatus}" style="width:90%"
	    	required="true" requiredErrorText="婚姻状况不能为空" url="/bank/dic/MarryStatus.txt" emptyText="请选择..."/>
   </td>
</tr>
<tr>
   <td style="width:10%"><label for="textbox2$text">&nbsp;&nbsp;职业:</label></td>
   <td style="width:40%" >
   		<input name="occupation" class="mini-textbox" value="${member.occupation}" style="width:90%"/>
   </td>
	<td style="width:10%"><label for="textbox1$text">&nbsp;&nbsp;职务:</label></td>
    <td style="width:40%">
    	<input name="job" class="mini-textbox" value="${member.job }" style="width:90%"/>
    </td>
    
</tr>
<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>联系电话:</label></td>
	<td style="width:40%">
    	<input  name="phone" class="mini-textbox" value="${member.phone}" style="width:90%"
        	required="true"  requiredErrorText="联系电话不能为空" />
    </td>
    <td style="width:10%"><label for="textbox1$text">&nbsp;&nbsp;地址:</label></td>
	<td style="width:40%">
    	<input  name="address" class="mini-textarea" value="${member.address}" style="width:90%"/>
    </td>
</tr>
</table>
</td>
</tr>
</table>
</form>
</td>
</tr>
</c:forEach> 
<tr>
   <td align="center" >
       <button class="addBtn" onclick="addMember()" ></button>
   </td>
</tr>
</table>
</div>
</fieldset>
</td></tr></table>
</div>
<script type="text/javascript">
	mini.parse();
    function save(){
    	var farmer,member;
    	farmer= getData("farmer");
    	member=getDataArray("farmerMember");
	    $.ajax({
	    	url: "/bank/farmer/saveFarmer.do",
	        type: "post",
	        data: { farmer:farmer,member:member},
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        success: function (text) {
	       	var data = mini.decode(text);   //反序列化成对象
		    if(data.farmer.id!=null){
		    	var form = new mini.Form("#farmer");
		    	form.setData(data.farmer);  
		    };
	       	if(data.member.length>0){
	       		for(var i=0;i<data.member.length;i++){
	       			var form=new mini.Form("#farmerMember"+i);
	       			form.setData(data.member[i]);
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