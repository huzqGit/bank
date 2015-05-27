<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/miniuiUtil.js" type="text/javascript"></script>
<title>农户收支情况</title>
<style>
*{margin:0;padding:0;text-decoration:none}
.topMenu{
	border:1px solid #8AD3E9;
    /* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
	endColorstr = 'white' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
	endColorstr = 'white' )"; 
}
.labelName{font-size:15px;font-weight:bold;color:darkgreen;}
.labelValue{font-size:15px;font-weight:bold;color:red;}
#saveBtn{width:100px;height:25px;border:0;background:url(/bank/images/save.png) no-repeat}
#backBtn{width:100px;height:25px;border:0;background:url(/bank/images/back.png) no-repeat}
.addBtn{width:100px;height:25px;border:0;background:url(/bank/images/add.png) no-repeat}
</style>
</head>
<body>
<div class="topMenu" style="background:linear-gradient(#6DC8E3,white)">
<form id="farmer">
<input name="id" class="mini-hidden" value ="${farmer.id}"/>
<table cellpadding="0" cellspacing="0" height="60px">
    <tr>
      	<td class="labelName" width="30%" align="right">客户姓名</td>
    	<td width="2%" align="center">：</td>
    	<td class="labelValue" width="8%">${farmer.farmerName}</td>
    	<td class="labelName" width="15%" align="right">客户身份证号码</td>
    	<td width="2%" align="center">：</td>
    	<td class="labelValue" width ="20%">${farmer.farmerIdnum }</td>
    	<td width="1%"></td>
    	<td width="50px" align="right">
       	 <input type="button" id="saveBtn" onclick="save()"/>
        </td>
        <td width="50px"  >
         <input type="button" id="backBtn" onclick="back()"/>
        </td>
    </tr>
</table>
</form>
</div>
<fieldset id="fd2" style="width:90%;margin:auto auto">
<legend><label>村民委员会对农户家庭评价情况基本信情况</label></legend>
<div class="fieldset-body">
<form id="farmerEvaluate" method="POST">
<input name="id" class="mini-hidden" value ="${evaluate.id}"/>
<input name="recorder" class="mini-hidden" value="管理员"/>
<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
<table border="0" cellpadding="1" cellspacing="5" width="100%" >
<tr><td>
<table width="100%">
<tr>
    <td style="width:15%"><label for="textbox2$text">  家庭和睦情况:</label></td>
    <td style="width:35%" >
    	<input name="harmonyStatus" class="mini-combobox" value ="${evaluate.harmonyStatus}" style="width:90%"
    	url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
    <td style="width:10%"><label for="textbox1$text">    敬老爱幼情况:</label></td>
    <td style="width:40%">
    	<input name="respectStatus" class="mini-combobox" value ="${evaluate.respectStatus}"style="width:90%"
    	url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
    <td style="width:15%"><label for="textbox1$text">  邻里团结情况:</label></td>
    <td style="width:35%">
    	<input name="neighborStatus" class="mini-combobox" value ="${evaluate.neighborStatus}" style="width:90%"
    	url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>是否遵纪守法:</label></td>
    <td style="width:40%">
    	<input name="legalStatus" class="mini-combobox" value ="${evaluate.legalStatus}" required="true"
        	requiredErrorText="是否遵纪守法不能为空" style="width:90%"
            url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..."/>
    </td>
</tr>
<tr>
    <td style="width:15%"><label for="textbox1$text"> 对公益事业关心程度:</label></td>
    <td style="width:35%">
    	<input name="welfareStatus" class="mini-combobox" value ="${evaluate.welfareStatus}" style="width:90%"
    		url="/bank/dic/Evaluate.txt" emptyText="请选择..."/>
    </td>
    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>是否诚实守信:</label></td>
    <td style="width:40%">
    	<input name="honestStatus" class="mini-combobox" value ="${evaluate.honestStatus}"  style="width:90%"
    		required="true" requiredErrorText="不能为空"
        	url="/bank/dic/YesOrNoStatus.txt" emptyText="请选择..."/>
   </td>
</tr>
<tr>
   <td style="width:15%"><label for="textbox1$text">  其他:</label></td>
   <td style="width:35%">
	   <input name="otherStatus" class="mini-textarea" value ="${evaluate.otherStatus}" style="width:90%">
   </td>
</tr>
</table>
</td></tr></table>
 </form>
</div>
</fieldset>
<script type="text/javascript">
mini.parse();
function save(){
    	var farmer,evaluate;
    	farmer= getData("farmer");
    	evaluate= getData("farmerEvaluate");
	    $.ajax({
	    	url: "/bank/farmer/saveEvaluate.do",
	        type: "post",
	        data: {farmer:farmer,evaluate:evaluate},
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        success: function (text) {
	       	var data = mini.decode(text);   //反序列化成对象
		    if(data.evaluate.id!=null){
		    	var obj = new mini.Form("#farmerEvaluate");
		    	obj.setData(data.evaluate);  
		    };
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
</script>
</body>
</html>