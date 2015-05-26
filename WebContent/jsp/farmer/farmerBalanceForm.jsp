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
<input name="id" class="mini-hidden" value="${farmer.id}" />
<table cellpadding="0" cellspacing="0" height="60px">
    <tr>
    	<td class="labelName" width="15%" align="right">年份</td>
    	<td width="2%" align="center">：</td>
    	<td class="labelValue" width="5%">${balance.year}</td>
      	<td class="labelName" width="10%" align="right">客户姓名</td>
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
、
</form>
</div>
<div id="form2" style="width:90%;margin:auto auto">
<form  id="farmerPay" method="POST">
<input name="id" class="mini-hidden" value="${balance.id}" />
<input name="year" class="mini-hidden" value="${balance.year}"/>
<input name="recorder" class="mini-hidden" value="管理员"/>
<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend><label>农户年度收支基本情况</label></legend>
<div class="fieldset-body">
<table width="100%">
<tr>
	<td style="width:15%"><label for="textbox1$text">主要农业年度净收入合计:</label></td>
    <td style="width:35%">
		<input  name="farmingIncome" class="mini-spinner" value="${balance.farmingIncome}" style="width:90%"
	    	minValue="0" maxValue="999999999" format="n"/>
    </td>
    <td style="width:20%"><label for="textbox2$text">林、牧、副、渔业年度净收入合计:</label></td>
    <td style="width:30%" >
	    <input name="avocationIncome" class="mini-spinner" value ="${balance.avocationIncome}" style="width:90%" 
	 		minValue="0" maxValue="999999999" format="n"/>
    </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox2$text">家庭工商业年度净收入合计:</label></td>
    <td style="width:35%" >
    	<input name="businessIncome" class="mini-spinner" value ="${balance.businessIncome}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>                                   
    <td style="width:20%"><label for="textbox2$text">其他收入年度净收入合计:</label></td>
    <td style="width:30%" >
    	<input name="otherIncome" class="mini-spinner" value ="${balance.otherIncome}" style="width:90%"
        minValue="0" maxValue="999999999" format="n"/>
    </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox1$text">生产支出:</label></td>
    <td style="width:35%">
    	<input  name="productPay" class="mini-spinner" value ="${balance.productPay}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
    <td style="width:20%"><label for="textbox2$text">生活支出:</label></td>
    <td style="width:30%" >
    	<input name="livingPay" class="mini-spinner" value ="${balance.livingPay}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox1$text">医疗支出:</label></td>
    <td style="width:35%">
    	<input  name="medicalPay" class="mini-spinner" value ="${balance.medicalPay}"  style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
    <td style="width:20%"><label for="textbox1$text">教育支出:</label></td>
    <td style="width:30%">
    	<input  name="educatePay" class="mini-spinner" value ="${balance.educatePay}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox1$text">参保支出:</label></td>
    <td style="width:35%">
    	<input  name="insuredPay" class="mini-spinner" value ="${balance.insuredPay}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
    <td style="width:20%"><label for="textbox1$text">其他支出:</label></td>
    <td style="width:30%">
    	<input  name="otherPay" class="mini-spinner" value ="${balance.otherPay}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
</tr>
<tr>
	<td style="width:15%"><label for="textbox2$text"><font color="red">*</font>家庭年度总收入合计:</label></td>
    <td style="width:35%" >
    	<input name="totalIncome" class="mini-spinner" value ="${balance.totalIncome}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
<td style="width:20%"><label for="textbox1$text"><font color="red">*</font>家庭年度支出总合计:</label></td>
	<td style="width:30%">
    	<input  name="totalPay" class="mini-spinner" value ="${balance.totalPay}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
</tr>
</table>
</div>
</fieldset>
</form>
</div>
<fieldset style="width:90%;margin:auto auto">
<legend><label>农户小微收入基本情况</label></legend>
<div class="fieldset-body">
<table width="100%"><tr><td>
<c:forEach items="${incomes}" var="income" varStatus="status">
<form id="farmerIncome${status.index}" class="farmerIncome" method="POST">
<input name="id" class="mini-hidden" value="${income.id}"/>
<input name="recorder" class="mini-hidden" value="管理员"/>
<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
<table width="100%" border="0" cellpadding="1" cellspacing="15" >
<tr><td>
<table width="100%" >
<tr>
	<td style="width:12%"><label for="textbox1$text">家庭收入来源:</label></td>
	<td style="width:38%">
		<input name="incomeType" class="mini-combobox" value="${income.incomeType}" style="width:90%"
			required="true" requiredErrorText="家庭收入来源不能为空" 
            url="/bank/dic/IncomeType.txt" emptyText="请选择..."/>
    </td>
    <td style="width:12%"><label for="textbox2$text">农作物或项目名称:</label></td>
    <td style="width:38%" >
     	<input name="incomeName" class="mini-textbox" value="${income.incomeName}" style="width:90%"
     		required="true" requiredErrorText="名称不能为空"  />
    </td>
</tr>
 <tr>
	<td style="width:12%"><label for="textbox1$text">净收入:</label></td>
    <td style="width:38%">
    	<input name="netIncome" class="mini-spinner" value="${income.netIncome}"  style="width:90%"
    		minValue="0"  maxValue="999999999" format="n" />
    </td>
</tr>
</table>
</td></tr>
</table>
</form>
</c:forEach>
</td></tr>
<tr>
	<td colspan="2" align="center">
		<input type="button" class="addBtn" onClick="addIncome()"/>
	</td>
</tr>
</table>
</div>
</fieldset>
<script type="text/javascript">
mini.parse();
function save(){
    	var farmer,balance,income;
    	farmer = getData("farmer");
    	balance= getData("farmerPay");
    	income=getDataArray("farmerIncome");
	    $.ajax({
	    	url: "/bank/farmer/saveBalance.do",
	        type: "post",
	        data: {farmer:farmer,balance:balance,income:income},
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        success: function (text) {
	       	var data = mini.decode(text);   //反序列化成对象
		    if(data.balance.id!=null){
		    	var obj = new mini.Form("farmerPay");
		    	obj.setData(data.balance);  
		    };
	    	if(data.income.length>0){
	       		for(var i=0;i<data.income.length;i++){
	       			var obj=new mini.Form("#farmerIncome"+i);
	       			obj.setData(data.income[i]);
	      		}
	       	}
	       	mini.alert('保存成功！');
	       },
	       error: function (jqXHR, textStatus, errorThrown) {
	           mini.alert('系统异常！');
	       }
  		});
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
function addIncome(){
 $(".farmerIncome").last().after(FarmerIncome($(".farmerIncome").length));
	  mini.parse();
}
function back(){
	window.history.go(-1);
}
</script>
</body>
</html>