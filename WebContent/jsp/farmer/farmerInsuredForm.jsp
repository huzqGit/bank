<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农户对外担保情况</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
<div class="mini-toolbar" style="padding-top:5px;border-bottom:0;">
	<table style="width:100%;">
    	<tr>
        	<td style="white-space:nowrap;">
	        	<a class="mini-button" iconCls="icon-save" plain="true" onclick="submitForm()">保存</a>
	           	<span class="separator"></span>
	            <a class="mini-button" iconCls="icon-upgrade" plain="true" onclick="back()">返回</a>
                <span class="separator"></span>
            </td>
         </tr>
      </table>
</div>
<div id="form1" style="width:90%;margin:auto auto">
	<form action="/bank/company/save.do" method="POST">
	<input type="hidden" name="insuredId"/>
	<input name="recorder" class="mini-hidden" value="管理员"/>
	<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
	<table border="0" cellpadding="1" cellspacing="15" width="100%" >
	<tr>
	<td colspan="4" style="width:100%">
	<fieldset id="fd2" style="width:100%;margin:auto auto">
	<legend><label>农户对外担保情况基本信息</label></legend>
	<div class="fieldset-body">
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
		requiredErrorText="参加保险种类不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">保险金额:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="amount" class="mini-textbox" required="true" 
		requiredErrorText="保险金额不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox1$text">参保时间:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="insureTime" class="mini-datepicker" required="true" 
		requiredErrorText="保险金额不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">参保到期日:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="limitTime" class="mini-datepicker" required="true" 
		requiredErrorText="参保到期日不能为空" style="width:90%"/>
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
</body>
</html>