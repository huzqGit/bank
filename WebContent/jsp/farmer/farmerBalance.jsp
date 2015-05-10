<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<title>农户收支情况</title>
</head>
<body>
<div id="form2" style="width:90%;margin:auto auto">
    <form  id="farmerPay" method="POST">
        <input type="hidden" name="payId"/>
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
            	<td >
            	<fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>农户年度收支情况</label></legend>
                        <div class="fieldset-body">
                        <table>
                        <tr>
		            		<td style="width:10%"><label for="textbox1$text">年份:</label></td>
		                    <td style="width:30%">
		                       <input name="year" class="mini-datepicker" format="yyyy"style="width:90%"/>
		             		</td>
		             		<td style="width:10%"><label for="textbox1$text">户主姓名:</label></td>
		                    <td style="width:20%">
		                       <input name="year" class="mini-textbox" style="width:90%"/>
		             		</td>
		             		<td style="width:10%"><label for="textbox1$text">身份证号:</label></td>
		                    <td style="width:20%">
		                       <input name="year" class="mini-textbox" style="width:90%"/>
		             		</td>
             		</tr>
             		</table>
             		</div>
             		</fieldset>	
               </td>
            </tr>
            <tr>
                <td colspan="4" style="width:100%">
                    <fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>农户年度收支基本情况</label></legend>
                        <div class="fieldset-body">
                            <table width="100%">
                            	<tr>
                                    <td style="width:10%"><label for="textbox1$text">主要农业年度净收入合计:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="farmingIncome" class="mini-spinner" style="width:90%"
                                        	minValue="0" maxValue="999999999" format="n"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">林、牧、副、渔业年度净收入合计:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="avocationIncome" class="mini-spinner" style="width:90%"
                                        	minValue="0" maxValue="999999999" format="n"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox2$text">家庭工商业年度净收入合计:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="businessIncome" class="mini-spinner" style="width:90%"
                                        	minValue="0" maxValue="999999999" format="n"/>
                                    </td>
                                    
                                    <td style="width:10%"><label for="textbox2$text">其他收入年度净收入合计:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="otherIncome" class="mini-spinner" style="width:90%"
                                        	minValue="0" maxValue="999999999" format="n"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">生产支出:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="productPay" class="mini-spinner" style="width:90%"
                                        	minValue="0" maxValue="999999999" format="n"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">生活支出:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="livingPay" class="mini-spinner" style="width:90%"
                                        	minValue="0" maxValue="999999999" format="n"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">医疗支出:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="medicalPay" class="mini-spinner" style="width:90%"
                                        	minValue="0" maxValue="999999999" format="n"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">教育支出:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="educatePay" class="mini-spinner" style="width:90%"
                                        	minValue="0" maxValue="999999999" format="n"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">参保支出:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="insuredPay" class="mini-spinner" style="width:90%"
                                        	minValue="0" maxValue="999999999" format="n"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">其他支出:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="otherPay" class="mini-spinner" style="width:90%"
                                        	minValue="0" maxValue="999999999" format="n"/>
                                    </td>
                                </tr>
                                <tr>
                                	<td style="width:10%"><label for="textbox2$text">家庭年度总收入合计:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="totalIncome" class="mini-spinner" style="width:90%"
                                        	minValue="0" maxValue="999999999" format="n"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>家庭年度支出总合计:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="totalPay" class="mini-spinner" style="width:90%"
                                        	minValue="0" maxValue="999999999" format="n"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </fieldset>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="form1" style="width:90%;margin:auto auto">
<table width="100%">
<tr><td>
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend><label>农户小微收入基本情况</label></legend>
<div class="fieldset-body">
    <form class="farmerIncome" method="POST">
        <input name="id" class="mini-hidden" />
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
                <td colspan="4" style="width:100%">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">家庭收入来源:</label></td>
                                    <td style="width:40%">
                                       <input id="textbox1"  name="incomeType" class="mini-combobox" required="true"
                                               requiredErrorText="家庭收入来源不能为空" style="width:90%"
                                               url="/bank/dic/IncomeType.txt" emptyText="请选择..."/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">农作物或项目名称:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="incomeName" class="mini-textbox" required="true"
                                               requiredErrorText="名称不能为空"  style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">净收入:</label></td>
                                    <td style="width:40%">
                                        <input id="sp1" name="netIncome" class="mini-spinner"  minValue="0"
                                               maxValue="999999999" format="n" style="width:90%"/>
                                    </td>
                                </tr>
                            </table>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>