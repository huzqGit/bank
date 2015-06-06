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
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
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
.addBtn{width:100px;height:25px;border:0;background:url(/bank/images/add.png) no-repeat}
.small_delbtn{width:20px;height:20px;border:0;background:url(/bank/images/s_delbtn.png) no-repeat}
</style>
</head>
<body>
<form  action="/bank/farmer/saveBalance1.do" id="farmerPay" method="POST">
<input name="farmerId" class="mini-hidden" value="${farmer.id}" />
<div class="topMenu" style="background:linear-gradient(#6DC8E3,white)">
<table cellpadding="0" cellspacing="0"  height="60px">
    <tr>
    	<td class="labelName" width="25%" align="right">姓名:</td>
    	<td width="2%"></td>
    	<td class="labelValue" width="8%">${farmer.farmerName }</td>
    	<td class="labelName" width="12%" align="right">证件号码:</td>
    	<td width="2%"></td>
    	<td class="labelValue" width ="15%">${farmer.farmerIdnum }</td>
    	<td width="50px" align="right">
       	 <input type="submit" id="saveBtn"  value=""/>
        </td>
        <td width="50px"  >
         <input type="button" id="backBtn" onclick="back()" value=""/>
        </td>
    </tr>
    
</table>
</div>
<div id="form2" style="width:90%;margin:auto auto">
<input name="deleteIncome" id="deleteIncome" class="mini-hidden"/>
<input name="id" class="mini-hidden" value="${balance.id}" />
<input name="year" class="mini-hidden" value="${balance.year}"/>
<input name="recorder" class="mini-hidden" value="管理员"/>
<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend><label>农户年度收支基本情况</label></legend>
<div class="fieldset-body">
<table width="100%">
<tr>
	<td rowspan="6" style="width:2%"></td>
	<td style="width:18%"><label for="textbox1$text">主要农业年度净收入合计(元):</label></td>
    <td style="width:27%">
		<input  name="farmingIncome" class="mini-spinner" value="${balance.farmingIncome}" style="width:90%"
	    	minValue="0" maxValue="999999999" format="n"/>
    </td>
    <td style="width:22%"><label for="textbox2$text">林、牧、副、渔业年度净收入合计(元):</label></td>
    <td style="width:27%" >
	    <input name="avocationIncome" class="mini-spinner" value ="${balance.avocationIncome}" style="width:90%" 
	 		minValue="0" maxValue="999999999" format="n"/>
    </td>
</tr>
<tr>
	<td style="width:18%"><label for="textbox2$text">家庭工商业年度净收入合计(元):</label></td>
    <td style="width:27%" >
    	<input name="businessIncome" class="mini-spinner" value ="${balance.businessIncome}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>                                   
    <td style="width:22%"><label for="textbox2$text">其他收入年度净收入合计(元):</label></td>
    <td style="width:27%" >
    	<input name="otherIncome" class="mini-spinner" value ="${balance.otherIncome}" style="width:90%"
        minValue="0" maxValue="999999999" format="n"/>
    </td>
</tr>
<tr>
	<td style="width:18%"><label for="textbox1$text">生产支出(元):</label></td>
    <td style="width:27%">
    	<input  name="productPay" class="mini-spinner" value ="${balance.productPay}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
    <td style="width:22%"><label for="textbox2$text">生活支出(元):</label></td>
    <td style="width:27%" >
    	<input name="livingPay" class="mini-spinner" value ="${balance.livingPay}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
</tr>
<tr>
	<td style="width:18%"><label for="textbox1$text">医疗支出(元):</label></td>
    <td style="width:27%">
    	<input  name="medicalPay" class="mini-spinner" value ="${balance.medicalPay}"  style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
    <td style="width:22%"><label for="textbox1$text">教育支出(元):</label></td>
    <td style="width:27%">
    	<input  name="educatePay" class="mini-spinner" value ="${balance.educatePay}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
</tr>
<tr>
	<td style="width:18%"><label for="textbox1$text">参保支出(元):</label></td>
    <td style="width:27%">
    	<input  name="insuredPay" class="mini-spinner" value ="${balance.insuredPay}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
    <td style="width:22%"><label for="textbox1$text">其他支出(元):</label></td>
    <td style="width:27%">
    	<input  name="otherPay" class="mini-spinner" value ="${balance.otherPay}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
</tr>
<tr>
	<td style="width:18%"><label for="textbox2$text"><font color="red">*</font>家庭年度总收入合计(元):</label></td>
    <td style="width:27%" >
    	<input name="totalIncome" class="mini-spinner" value ="${balance.totalIncome}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
	<td style="width:22%"><label for="textbox1$text"><font color="red">*</font>家庭年度支出总合计(元):</label></td>
	<td style="width:27%">
    	<input  name="totalPay" class="mini-spinner" value ="${balance.totalPay}" style="width:90%"
        	minValue="0" maxValue="999999999" format="n"/>
    </td>
</tr>
</table>
</div>
</fieldset>
</div>
<fieldset style="width:90%;margin:auto auto">
<legend><label>农户小微收入基本情况</label></legend>
<div class="fieldset-body">
<table width="100%"><tr><td>
<c:forEach items="${incomes}" var="income" varStatus="status">
<div id="farmerIncome${status.index}" class="farmerIncome">
<input name="incomes[${status.index}].id" class="mini-hidden" value="${income.id}"/>
<table width="100%" border="0" cellpadding="1" cellspacing="15" >
<tr><td>
<table width="100%" >
<tr>
    <c:choose>
	<c:when test="${status.index ==0}">
		<td rowspan="2" style="width:2%"></td>
	</c:when>
	<c:otherwise>
		<td rowspan="2" style="width:2%"><input type="button"  class="small_delbtn" value="" onclick="delIncome(${status.index},${farmer.id})"/></td>
	</c:otherwise>
	</c:choose>
	<td style="width:12%">家庭收入来源:</td>
	<td style="width:38%">
		<input name="incomes[${status.index}].incomeType" class="mini-combobox" value="${income.incomeType}" style="width:90%"
			required="true" requiredErrorText="家庭收入来源不能为空" 
            url="/bank/dic/IncomeType.txt" emptyText="请选择..."/>
    </td>
    <td style="width:12%">农作物或项目名称:</td>
    <td style="width:38%" >
     	<input type="text" name="incomes[${status.index}].incomeName" value="${income.incomeName}" style="width:90%"
     		required="true" requiredErrorText="名称不能为空"  />
    </td>
</tr>
 <tr>
	<td style="width:12%">净收入(元):</td>
    <td style="width:38%">
    	<input type="text" name="incomes[${status.index}].netIncome" value="${income.netIncome}"  style="width:90%"/>
    </td>
</tr>
</table>
</td></tr>
</table>
</div>
</c:forEach>
</td></tr>
<tr>
	<td colspan="2" align="center">
		<input type="button" class="addBtn" onClick="addIncome(${farmer.id})"/>
	</td>
</tr>
</table>
</div>
</fieldset>
</form>
<script type="text/javascript">
mini.parse();
var deleteIncome = new Array();
function addIncome(fid){
 $(".farmerIncome").last().after(FarmerIncome($(".farmerIncome").length,fid));
	  mini.parse();
}
function back(){
	window.history.go(-1);
}
function delIncome(index,fid){
	var incomeId = $("input[name^='incomes["+index+"].id'").val();
	$("#farmerIncome"+index).remove();
	deleteIncome.push(incomeId);
	var next = index+1;
	$(".farmerIncome").each(function(){
		var name = $(this).attr("id");
		var n = name.substr(12,name.length);
		if(n>index){
			$("input[name^='incomes["+next+"]']").each(function(){
				var oldName =$(this).attr("name");
				var newName = "incomes["+index+"]"+oldName.substr(oldName.indexOf("."),oldName.length);
				$(this).attr("name",newName);
			});
			$("#delIncome"+next).attr("onclick","delIncome("+index+","+fid+")");
			$(this).attr("id","farmerIncome"+index);
		};
		
	});
}
</script>
</body>
</html>