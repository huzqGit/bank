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
<fieldset style="width:90%;margin:auto auto">
<legend><label>农户受表彰与处罚情况基本情况</label></legend>
<div class="fieldset-body">
<table width="100%">
<tr>
<td>
<c:forEach items="${compunishs}" var="compunish" varStatus="status">
<form id="farmerCompunish${status.index}" class="farmerCompunish" method="POST">
<input name="id" class="mini-hidden" value="${compunish.id}"/>
<input name="recorder" class="mini-hidden" value="管理员"/>
<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
<table border="0" cellpadding="1" cellspacing="5" width="100%" ><tr><td width="100%">
<table width="100%">
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>表彰或处罚:</label></td>
    <td style="width:35%">
    	<input name="organ" class="mini-combobox"  value="" style="width:90%" 
    		required="true" requiredErrorText="表彰或处罚类型不能为空" 
    		url="/bank/dic/CompunishType.txt" emptyText="请选择..."/>
    </td>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>表彰或处罚部门:</label></td>
    <td style="width:35%">
    	<input name="organ" class="mini-textbox"  value="${compunish.organ}" required="true"
        	requiredErrorText="信用户评定时间不能为空"style="width:90%"/>
    </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox1$text"><font color="red">*</font>表彰或处罚时间:</label></td>
    <td style="width:35%">
        	<input  name="occurTime" class="mini-datepicker" value="${compunish.occurTime}" style="width:90%"/>
    </td>
	<td style="width:15%"><label for="textbox2$text"><font color="red">*</font>表彰或处罚内容:</label></td>
    <td style="width:35%" >
    <input name="detail" class="mini-textarea" value="${compunish.detail}" required="true"
    	 requiredErrorText="表彰或处罚内容不能为空" style="width:90%"/>
   </td>          
</tr>
</table>
</td></tr></table>
</form>
</c:forEach>
</td>
</tr>
<tr>
<td align="center">
	<input class="addBtn" type="button" onclick="addCompunish()"/>
</td>
</tr>

</table>
 </div>
</fieldset>
<script type="text/javascript">
mini.parse();
function save(){
    	var farmer,compunish;
    	farmer= getData("farmer");
    	compunish=getDataArray("farmerCompunish");
	    $.ajax({
	    	url: "/bank/farmer/saveJiangCheng.do",
	        type: "post",
	        data: {farmer:farmer,compunish:compunish},
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        success: function (text) {
	       	var data = mini.decode(text);   //反序列化成对象
	    	if(data.compunish.length>0){
	       		for(var i=0;i<data.compunish.length;i++){
	       			var obj=new mini.Form("#farmerCompunish"+i);
	       			obj.setData(data.compunish[i]);
	      		}
	       	}
	       	mini.alert('保存成功！');
	       },
	       error: function (jqXHR, textStatus, errorThrown) {
	           mini.alert('系统异常！');
	       }
  		});
}
function addCompunish(){
 $(".farmerCompunish").last().after(FarmerCompunish($(".farmerCompunish").length));
	  mini.parse();
}
function back(){
	window.history.go(-1);
}
</script>
</body>
</html>