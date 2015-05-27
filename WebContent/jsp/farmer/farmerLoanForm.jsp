<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户基本贷款信息</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<style type="text/css">
*{margin:0;padding:0;text-decoration:none}
.labelName{font-size:15px;font-weight:bold;color:darkgreen;}
.labelValue{font-size:15px;font-weight:bold;color:red;}
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
</style>
</head>
<body>
<div id ="form1">
<form  action="/bank/loan/saveLoan.do" method="POST">
<input name="id" class="mini-hidden" value="${loan.id}"/>
<input name="clientId" class="mini-hidden"  value="${farmer.id}" />
<input name="clientName" class="mini-hidden" value="${farmer.farmerName}"/>
<input name="idNum" class="mini-hidden" value="${farmer.farmerIdnum}"/>
<input name="clientNum" class="mini-hidden" value="${clientNum}"/>
<input name="noteNum" class="mini-hidden" value="${noteNum}"/>
<input name="businessBody" class="mini-hidden"  value="${loan.businessBody}"/>
<input name="clientType" class="mini-hidden" value="1"/>
<input name="recorder" class="mini-hidden" value="管理员"/>
<input name="idType" class="mini-hidden" value="${loan.idType}">
<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
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
       	 <input type="button" id="saveBtn" onclick="submitForm()" value=""/>
        </td>
        <td width="50px"  >
         <input type="button" id="backBtn" onclick="back()" value=""/>
        </td>
    </tr>
    
</table>
</div>
<div style="width:90%;margin:auto auto">
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr>
	<td colspan="4" style="width:100%">
	<fieldset id="fd2" style="width:100%;margin:auto auto">
	<legend><label>农户基本概况信息</label></legend>
	<div class="fieldset-body">
	<table width="100%">
	<tr>
		<td style="width:12%"><label for="textbox1$text"><font color="red">*</font>机构名称:</label></td>
		<td colspan="3" style="width:88%">
			<input name="organName" class="mini-textbox" value="${loan.organName}"  style="width:96%"/>
		</td>
	</tr>
	<tr>
		<td style="width:12%"><label for="textbox1$text"><font color="red">*</font>机构号:</label></td>
		<td style="width:38%">
			<input name="organCode" class="mini-textbox" value="${loan.organCode}" style="width:90%"/>
		</td>
		<td style="width:12%"><label for="textbox1$text"><font color="red">*</font>合同号:</label></td>
		<td style="width:38%">
		<input id="textbox1"  name="compactNum" class="mini-textbox" value="${loan.compactNum}" 
			 style="width:90%"/>
		</td>	
	</tr>
	<tr>
		<td style="width:12%"><label for="textbox1$text">业务种类:</label></td>
		<td style="width:38%">
			<input name="businessType" class="mini-treeselect" value="${loan.businessType}" style="width:90%"
			url="/bank/dic/BusinessType.txt" multiSelect="false"  valueFromSelect="false"
	        textField="text" valueField="id" parentField="pid" value="control"  allowInput="true"showFolderCheckBox="false"/>
		</td>
		<td style="width:12%"><label for="textbox1$text">担保方式:</label></td>
		<td style="width:38%">
		<input name="guaranteeType" class="mini-combobox" value="${loan.guaranteeType}" style="width:90%"
			url="/bank/dic/EnsureType.txt" emptyText="请选择"/>
		</td>
	</tr>
	<tr>
		<td style="width:12%"><label for="textbox2$text"><font color="red">*</font>贷款日期</label></td>
		<td style="width:38%" >
			<input name="loanDate" class="mini-datepicker" value="${loan.loanDate}" style="width:90%"/>
		</td>
	</tr>
	<tr>
	<td style="width:12%"><label for="textbox1$text"><font color="red">*</font>到期日期:</label></td>
	<td style="width:38%">
	<input name="limitDate" class="mini-datepicker" value="${loan.limitDate}" style="width:90%"/>
	</td>
	<td style="width:12%"><label for="textbox2$text">&nbsp;&nbsp;原到期日期:</label></td>
	<td style="width:38%" >
	<input name="limitDate1" class="mini-datepicker" value="${loan.limitDate1}" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:12%"><label for="textbox1$text"><font color="red">*</font>币种:</label></td>
	<td style="width:38%">
	<input name="currency" class="mini-combobox" value="${loan.currency}" style="width:90%"
		url="/bank/dic/Currency.txt" emptyText="请选择"/>
	</td>
	<td style="width:12%"><label for="textbox2$text"><font color="red">*</font>贷款金额:</label></td>
	<td style="width:38%" >
	<input name="amount" class="mini-spinner" style="width:90%" value="${loan.amount}"  
		minValue="0" format="n"/>
	</td>
	</tr>
	<tr>
	<td style="width:12%"><label for="textbox1$text">&nbsp;&nbsp;贷款余额:</label></td>
	<td style="width:38%">
	<input name="balance" class="mini-spinner" value="${loan.balance}" style="width:90%"/>
	</td>
	<td style="width:12%"><label for="textbox1$text">&nbsp;&nbsp;结欠利息:</label></td>
	<td style="width:38%">
	<input name="oweInterest" class="mini-spinner" value="${loan.balance}" style="width:90%"
		minValue="0" maxValue="999999999999999999" format="n"/>
	</td>
	</tr>
		<tr>
	<td style="width:12%"><label for="textbox1$text">&nbsp;&nbsp;当前利率:</label></td>
	<td style="width:38%">
	<input name="currentRate" class="mini-spinner" value="${loan.currentRate}" style="width:90%"
		format="n"/>
	</td>
	<td style="width:12%"><label for="textbox1$text">&nbsp;&nbsp;利率类型:</label></td>
	<td style="width:38%">
	<input name="rateType" class="mini-textbox" value="${loan.rateType}" style="width:90%"/>
	</td>
	</tr>
		<tr>
		<td style="width:12%"><label for="textbox1$text"><font color="red">*</font>贷款用途:</label></td>
	<td colspan="3" style="width:88%">
	<input name="loanUse" class="mini-textbox"  value="${loan.loanUse}" style="width:96%"/>
	</td>
	</tr>
	<tr>
	<td style="width:12%"><label for="textbox1$text"><font color="red">*</font>贷款五级分类形态:</label></td>
	<td style="width:38%">
	<input name="grade" class="mini-combobox" value="${loan.grade}" style="width:90%"
		url="/bank/dic/FiveGrade.txt"/>
	</td>
	<td style="width:12%"><label for="textbox1$text"><font color="red">*</font>结息方式:</label></td>
	<td style="width:38%">
	<input name="settleType" class="mini-combobox" value="${loan.settleType}" style="width:90%"
		url="/bank/dic/SettleType.txt" emptyText="请选择"/>
	</td>
	</tr>
	<tr>
	<td style="width:12%"><label for="textbox1$text">贷款发放类型:</label></td>
	<td style="width:38%">
	<input name="provideType" class="mini-textbox" value="${loan.provideType}" style="width:90%"/>
	</td>
	<td style="width:12%"><label for="textbox1$text">贷款投向:</label></td>
	<td style="width:38%">
	<input name="invest" class="mini-textbox" value="${loan.invest}" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:12%"><label for="textbox1$text">贷款期限种类:</label></td>
	<td style="width:38%">
	<input name="termType" class="mini-textbox"  value="${loan.termType}" style="width:90%"/>
	</td>
	<td style="width:12%"><label for="textbox1$text">利率浮动范围:</label></td>
	<td style="width:38%">
	<input name="floatScope" class="mini-spinner" value="${loan.floatScope}" style="width:90%"
		format="n"/>
	</td>
	</tr>
	<tr>
	<td style="width:12%"><label for="textbox1$text">利率调整方式:</label></td>
	<td style="width:38%">
	<input name="adjustType" class="mini-textbox" value="${loan.adjustType}" style="width:90%"/>
	</td>
	<td style="width:12%"><label for="textbox1$text">利率执行方式:</label></td>
	<td style="width:38%">
	<input name="runType" class="mini-combobox" value="${loan.runType}" style="width:90%"
		url="/bank/dic/RunType.txt"/>
	</td>
	</tr>
	<tr>
	<td style="width:12%"><label for="textbox1$text">还款频率:</label></td>
	<td style="width:38%">
	<input name="frequeency" class="mini-textbox" value="${loan.frequeency}" style="width:90%"/>
	</td>
	<td style="width:12%"><label for="textbox2$text"><font color="red">*</font>联系电话:</label></td>
	<td style="width:38%" >
	<input id="textbox2"  name="phone" class="mini-textbox" value="${loan.phone}" 
		required="true" requiredErrorText="劳动力人数不能为空"  style="width:90%"/>
	</td>
	</tr>
	</table>
	</div>
	</fieldset>
	</td>
	</tr>
	</table>
</div>
</form>
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
	        url: "${pageContext.request.contextPath}/loan/saveLoan.do",
	        type: "post",
	        data: { loan: json},
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        success: function (text) {
	        	var data = mini.decode(text);   //反序列化成对象
		        if(data.payId!=null){
		       	 	form.setData(data);  
		        }
	        	 mini.alert('保存成功！');
	        },
	        error: function (jqXHR, textStatus, errorThrown) {
	            mini.alert('系统异常！');
	        }
	});
	}
	function onDrawCell(e) {
        value = e.value;
        //组织HTML设置给cellHtml
        e.cellHtml = '<span style="color:red;">'+value+'</span>';   
	}
	function back(){
		window.history.go(-1);
	}
</script>
</body>
</html>