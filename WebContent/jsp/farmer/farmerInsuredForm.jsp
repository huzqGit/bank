<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户对外担保情况</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/miniuiUtil.js" type="text/javascript"></script>
<style type="text/css">
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
<div id="form1" style="width:90%;margin:auto auto">
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend><label>农户参保情况</label></legend>
<div class="fieldset-body">
<table width="100%" >
<tr><td>
<c:forEach items="${insureds}" var="insured" varStatus="status">
<form id="${status.index}" class="farmerInsured" action="/bank/company/save.do" method="POST">
<input name="id" class="mini-hidden"/>
<input name="recorder" class="mini-hidden" value="管理员"/>
<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
<table border="0" cellpadding="1" cellspacing="15" width="100%">
<tr><td>
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
	<td style="width:10%"><label for="textbox1$text">参保人姓名:</label></td>
	<td style="width:40%">
		<input id="textbox1"  name="name" class="mini-textbox" required="true" 
			requiredErrorText="参保人姓名不能为空"style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox2$text">参加保险种类:</label></td>
	<td style="width:40%" >
		<input id="textbox2"  name="type" class="mini-combobox" required="true" 
			requiredErrorText="参加保险种类不能为空" style="width:90%"
			url="/bank/dic/InsuredType.txt" emptyText="请选择..."/>
	</td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox1$text">保险金额:</label></td>
	<td style="width:40%">
		<input name="amount" class="mini-textbox" style="width:90%"
		 required="true" requiredErrorText="保险金额不能为空" />
	</td>
	<td style="width:10%"><label for="textbox1$text">参保时间:</label></td>
	<td style="width:40%">
		<input name="insureTime" class="mini-datepicker" style="width:90%"
		 required="true" requiredErrorText="参保时间不能为空" />
	</td>
</tr>
<tr>
	<td style="width:10%"><label for="textbox1$text">参保到期日:</label></td>
	<td style="width:40%">
		<input name="limitTime" class="mini-datepicker" style="width:90%"
		required="true" requiredErrorText="参保到期日不能为空" />
	</td>
</tr>
</table>
</td></tr>
<tr>
</table>
</form>
</c:forEach>
</td></tr>
<tr><td align="center">
	<input class="addBtn" type="button" onclick="addInsured()"/>
</td></tr>
</table>
</div>
</fieldset>
</div>
<script type="text/javascript">
	mini.parse();
	var form = new mini.Form("#form1");
	function back(){
		history.go(-1);
	}
	function submitForm() {
		//提交表单数据
	    var formData = form.getData();      //获取表单多个控件的数据
	    var json = mini.encode(formData);   //序列化成JSON
	    $.ajax({
	        url: "${pageContext.request.contextPath}/farmer/saveInsured.do",
	        type: "post",
	        data: { formData: json},
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        success: function (text) {
	        	var data = mini.decode(text);   //反序列化成对象
	        	if(data.insured.length>0){
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
	function onDrawCell(e) {
         value = e.value;
         e.cellHtml = '<span style="color:red;">'+value+'</span>';   
	}
	function addCompunish(){
		$(".farmerInsured").last().after(FarmerInsured($(".farmerInsured").length));
		mini.parse();
	}
}
</script>
</body>
</html>