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
.required_text{
color:red
}
</style>
</head>
<body>
<div id ="form1">
<form  id="farmerLoan" name="farmerLoan" action="/bank/loan/saveLoan1.do" method="POST">
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
       	 <input type="submit" id="saveBtn"  value=""/>
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
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">机构名称:</td>
		<td colspan="4" width="87%"><input name="organName" class="mini-textbox" value="${loan.organName}" style="width:96%"/></td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td colspan="5" id="organName_error" class="errorText" ></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">机构号:</td>
		<td width="36%"><input name="organCode" class="mini-textbox" value="${loan.organCode}" style="width:90%"/></td>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">合同号:</td>
		<td width="36%"><input name="compactNum"class="mini-textbox"  value="${loan.compactNum}"  style="width:90%"/></td>	
	</tr>
	<tr>
		<td width="2%"></td>
		<td colspan="2" id="organCode_error" class="errorText"></td>
		<td width="2%"></td>
		<td colspan="2" id="compactNum_error" class="errorText"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">业务种类:</td>
		<td width="36%">
			<input name="businessType" class="mini-treeselect" value="${loan.businessType}" style="width:90%"
			url="/bank/dic/BusinessType.txt" multiSelect="false"  valueFromSelect="false"
	        textField="text" valueField="id" parentField="pid" value="control"  allowInput="true"showFolderCheckBox="false"/>
		</td>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">担保方式:</td>
		<td width="36%">
		<input name="guaranteeType" class="mini-combobox" value="${loan.guaranteeType}" style="width:90%"
			url="/bank/dic/EnsureType.txt" emptyText="请选择"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" id="businessType_validate"></td>
		<td colspan="2" id="guaranteeType_validate"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">贷款日期</td>
		<td width="36%" ><input id="loanDate"  name="loanDate" class="mini-datepicker" value="${loan.loanDate}" style="width:90%"/></td>
	</tr>
	<tr>
		<td colspan="6" id="loanDate_validate"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">到期日期:</td>
		<td width="36%"><input id="limitDate" name="limitDate" class="mini-datepicker" value="${loan.limitDate}" style="width:90%"/></td>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">原到期日期:</td>
		<td width="36%"><input name="limitDate1" class="mini-datepicker" value="${loan.limitDate1}" style="width:90%"/></td>
	</tr>
	<tr>
		<td colspan="2" id="limitDate_validate"></td>
		<td colspan="2" id="limitDate1_validate"></td>
	</tr>
	<tr>	
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">币种:</td>
		<td width="36%"><input name="currency" class="mini-combobox" value="${loan.currency}" style="width:90%" url="/bank/dic/Currency.txt" emptyText="请选择"/></td>
		<td class="required_text" width="1%" align="right">*</td>
		<td width="12%">贷款金额(元):</td>
		<td width="36%"><input type="text" id="amount" name="amount"  style="width:90%" value="${loan.amount}"/></td>
	</tr>
	<tr>
		<td colspan="2" id="currency_validate"></td>
		<td colspan="2" id="amount_validate"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">贷款余额(元):</td>
		<td width="36%"><input type="text" id="balance" name="balance" value="${loan.balance}" style="width:90%"/></td>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">结欠利息:</td>
		<td width="36%"><input type="text" id ="oweInterest" name="oweInterest"  value="${loan.balance}" style="width:90%"/></td>
	</tr>
	<tr>
		<td colspan="3" id="balance_validate"></td>
		<td colspan="3" id="oweInterest_validate"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">当前利率:</td>
		<td width="36%"><input type="text" name="currentRate"  value="${loan.currentRate}" style="width:90%"/></td>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">利率类型:</td>
		<td width="36%"><input type="text" name="rateType" value="${loan.rateType}" style="width:90%"/></td>
	</tr>
	<tr>
		<td colspan="2" id="currentRate_validate"></td>
		<td colspan="2" id="rateType_validate"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">贷款用途:</td>
		<td colspan="4" style="width:88%"><input type="text" id="loanUse" name="loanUse"  value="${loan.loanUse}" style="width:96%"/></td>
	</tr>
	<tr>
		<td colspan="6 " id="loanUse_validate"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%"><label for="textbox1$text">贷款五级分类形态:</label></td>
		<td width="36%">
		<input name="grade" class="mini-combobox" value="${loan.grade}" style="width:90%"
			url="/bank/dic/FiveGrade.txt"/>
		</td>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">结息方式:</td>
		<td width="36%">
		<input name="settleType" class="mini-combobox" value="${loan.settleType}" style="width:90%"
			url="/bank/dic/SettleType.txt" emptyText="请选择"/>
		</td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">贷款发放类型:</td>
		<td width="36%"><input name="provideType" class="mini-textbox" value="${loan.provideType}" style="width:90%"/></td>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%"><label for="textbox1$text">贷款投向:</label></td>
		<td width="36%"><input name="invest" class="mini-textbox" value="${loan.invest}" style="width:90%"/></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">贷款期限种类:</td>
		<td width="36%"><input name="termType" class="mini-textbox"  value="${loan.termType}" style="width:90%"/></td>
		<td class="required_text" width="1%" align="right"></td>
		<td width="12%">利率浮动范围:</td>
		<td width="36%"><input name="floatScope" class="mini-textbox" value="${loan.floatScope}" style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">利率调整方式:</td>
		<td width="36%">
		<input name="adjustType" class="mini-textbox" value="${loan.adjustType}" style="width:90%"/>
		</td>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">利率执行方式:</td>
		<td width="36%">
		<input name="runType" class="mini-combobox" value="${loan.runType}" style="width:90%"
			url="/bank/dic/RunType.txt"/>
		</td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">还款频率:</td>
		<td width="36%"><input name="frequeency" class="mini-textbox" value="${loan.frequeency}" style="width:90%"/></td>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">联系电话:</td>
		<td width="36%" ><input id="textbox2"  name="phone" class="mini-textbox" value="${loan.phone}" style="width:90%"/></td>
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
	function back(){
		history.go(-1);
	}
	$(document).ready(function(){
		function _valid_organCode(value){
			return  notBlankValid("#organCode",value,"不能为空!");
		}
		function _valid_organName(value){
			return  notBlankValid("#organName",value,"不能为空!");
		}
		function _valid_compactNum(value){
			return  notBlankValid("#compactNum",value,"不能为空!");
		}
		function _valid_amount(value1,value2){
			return notBlankValid("#amount",value1,"不能为空!")
			&& numberValid("#amount",value1,"必须 为数字类型!")
			&& compareBigEqualValid("#amount",value1,value2,"贷款金额必须大于贷款金额!");
		}
		function _valid_loanUse(value){
			return notBlankValid("#loanUse",value,"不能为空!");
		}
		function _valid_form(){
			var v1 = _valid_organCode($("#organCode").val());
			var v2 = _valid_organName($("#organName").val());
			var v3 = _valid_compactNum($("#compactNum").val());
			var v4 = _valid_amount($("#amount").val(),$("#balance").val());
			var v5 = _valid_loanUse($("#loanUse").val());
			return v1&&v2&&v3&&v4&&v5;
		}
		$("#farmerLoan").submit(function(){
			if(_valid_form()){
				return true;
			}else{
				return false;
			}
		});
		$("#organCode").keyup(function(){
			_valid_organCode($(this).val());
		});
		$("#organName").keyup(function(){
			_valid_organName($(this).val());
		});
		$("#compactNum").keyup(function(){
			_valid_compactNum($(this).val());
		});
		$("#loanUse").keyup(function(){
			_valid_loanUse($(this).val());
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
	function compareBigEqualValid(name,value1,value2,msg){
		if(parseFloat(value1)<parseFloat(value2)){
			showMsg(name,false,msg);
			return false;
		}else{
			showMsg(name,true,null);
			return true;
		}
	};
	function compareSmallEqualValid(name,value1,value2,msg){
		if(parseFloat(valu1)>parseFloat(value2)){
			showMsg(name,false,msg);
			return false;
		}else{
			showMsg(name,true,null);
			return true;
		}
	}
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