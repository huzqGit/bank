<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户基本贷款信息</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
<div id ="form1">
<form  id="farmerLoan" name="farmerLoan" action="/bank/loan/saveLoan1.do" method="POST">
<input name="id" class="mini-hidden" value="${loan.id}"/>
<input name="farmerid" class="mini-hidden"  value="${farmer.id}" />
<input name="clientname" class="mini-hidden" value="${farmer.farmername}"/>
<input name="idnum" class="mini-hidden" value="${farmer.farmeridnum}"/>
<input name="clientnum" class="mini-hidden" value="${clientnum}"/>
<input name="noteNum" class="mini-hidden" value="${noteNum}"/>
<input name="businessbody" class="mini-hidden"  value="${loan.businessbody}"/>
<input name="clienttype" class="mini-hidden" value="1"/>
<input name="recorder" class="mini-hidden" value="${recorder}"/>
<input name="idtype" class="mini-hidden" value="${loan.idtype}">
<input name="recordtime" class="mini-hidden" value="${currentTime}"/>
<div class="topMenu">
<table cellpadding="0" cellspacing="0">
    <tr>
    	<td class="labelName" width="50px" align="right">姓名:</td>
    	<td width="2%"></td>
    	<td class="labelValue" width="100px">${farmer.farmername }</td>
    	<td class="labelName" width="100px" align="right">证件号码:</td>
    	<td width="2%"></td>
    	<td class="labelValue" width ="100px">${farmer.farmeridnum }</td>
    	<td width="150px" align="right">
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
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">机构名称:</td>
		<td colspan="4" width="87%"><input name="organname" class="mini-textbox" value="${loan.organname}" style="width:96%"/></td>
	</tr>
	<tr>
		<td width="2%"></td>
		<td colspan="5" id="organname_error" class="errorText" ></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">机构号:</td>
		<td width="36%"><input name="organvode" class="mini-textbox" value="${loan.organvode}" style="width:90%"/></td>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">合同号:</td>
		<td width="36%"><input name="compactnum"class="mini-textbox"  value="${loan.compactnum}"  style="width:90%"/></td>	
	</tr>
	<tr>
		<td width="2%"></td>
		<td colspan="2" id="organcode_error" class="errorText"></td>
		<td width="2%"></td>
		<td colspan="2" id="compactnum_error" class="errorText"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">业务种类:</td>
		<td width="36%">
			<input name="businesstype" class="mini-treeselect" value="${loan.businesstype}" style="width:90%"
			url="/bank/dic/BusinessType.txt" multiSelect="false"  valueFromSelect="false"
	        textField="text" valueField="id" parentField="pid" value="control"  allowInput="true"showFolderCheckBox="false"/>
		</td>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">担保方式:</td>
		<td width="36%">
		<input name="guaranteetype" class="mini-combobox" value="${loan.guaranteetype}" style="width:90%"
			url="/bank/dic/EnsureType.txt" emptyText="请选择"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" id="businesstype_validate"></td>
		<td colspan="2" id="guaranteetype_validate"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">贷款日期</td>
		<td width="36%" ><input name="loandate" class="mini-datepicker" value="${loan.loandate}" style="width:90%"/></td>
	</tr>
	<tr>
		<td colspan="6" id="loanDate_validate"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">到期日期:</td>
		<td width="36%"><input name="limitdate" class="mini-datepicker" value="${loan.limitdate}" style="width:90%"/></td>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">原到期日期:</td>
		<td width="36%"><input name="limitdate1" class="mini-datepicker" value="${loan.limitdate1}" style="width:90%"/></td>
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
		<td width="36%"><input type="text" name="currentrate"  value="${loan.currentrate}" style="width:90%"/></td>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">利率类型:</td>
		<td width="36%"><input type="text" name="ratetype" value="${loan.ratetype}" style="width:90%"/></td>
	</tr>
	<tr>
		<td colspan="2" id="currentrate_validate"></td>
		<td colspan="2" id="ratetype_validate"></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right">*</td>
		<td width="12%">贷款用途:</td>
		<td colspan="4" style="width:88%"><input type="text" id="loanUse" name="loanuse"  value="${loan.loanUse}" style="width:96%"/></td>
	</tr>
	<tr>
		<td colspan="6 " id="loanuse_validate"></td>
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
		<input name="settletype" class="mini-combobox" value="${loan.settletype}" style="width:90%"
			url="/bank/dic/SettleType.txt" emptyText="请选择"/>
		</td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">贷款发放类型:</td>
		<td width="36%"><input name="providetype" class="mini-textbox" value="${loan.providetype}" style="width:90%"/></td>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%"><label for="textbox1$text">贷款投向:</label></td>
		<td width="36%"><input name="invest" class="mini-textbox" value="${loan.invest}" style="width:90%"/></td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">贷款期限种类:</td>
		<td width="36%"><input name="termtype" class="mini-textbox"  value="${loan.termtype}" style="width:90%"/></td>
		<td class="required_text" width="1%" align="right"></td>
		<td width="12%">利率浮动范围:</td>
		<td width="36%"><input name="floatscope" class="mini-textbox" value="${loan.floatscope}" style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">利率调整方式:</td>
		<td width="36%">
		<input name="adjusttype" class="mini-textbox" value="${loan.adjusttype}" style="width:90%"/>
		</td>
		<td class="required_text" width="2%" align="right"></td>
		<td width="12%">利率执行方式:</td>
		<td width="36%">
		<input name="runtype" class="mini-combobox" value="${loan.runtype}" style="width:90%"
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
	function submitForm(){
		$("form").submit();
	}
</script>
</body>
</html>