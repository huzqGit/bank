<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<title>Insert title here</title>
<style type="text/css">
html body{
   margin:0;padding:0;border:0;width:100%;height:100%
}
</style>
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
	  <form action="/bank/company/saveCompanyCapital.do" method="POST">
	  <input name="capitalId" class="mini-hidden" value="${companyCapital.capitalId}"/>
	  <input name="recorder" class="mini-hidden" value="管理员"/>
	  <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
	  <table border="0" cellpadding="1" cellspacing="15" width="100%" >
		<tr>
		  <td>
			<fieldset id="fd1" style="width:100%;margin:auto auto">
			<legend><label>基本信息</label></legend>
			<div class="fieldset-body">
			<table width="100%">
	     	  <tr>
	     	  	  <td style="width:10%"><label for="textbox1$text">企业名称:</label></td>
				  <td style="width:40%">
				   		<input id="textbox1"  name="companyName" class="mini-textarea" required="true" 
				   			requiredErrorText="企业名称不能为空" value="${companyCapital.companyName}"style="width:60%"/>
				  </td>
				  <td style="width:10%"><label for="textbox2$text">组织机构代码:</label></td>
				  <td style="width:40%" >
				    	<input id="textbox2"  name="organCode" class="mini-textbox" required="true" 
				    		value="${companyCapital.organCode}"  style="width:60%"/>
				  </td>
 			  </tr>
			  <tr>
				  <td style="width:10%"><label for="textbox3$text">机构信用代码:</label></td>
				  <td style="width:40%" >
				   	  <input id="textbox3"  name="creditCode" class="mini-textbox" required="true" 
				   	  	value="${companyCapital.creditCode}"  style="width:60%"/>
				  </td>
				   <td style="width:10%"><label for="textbox1$text">币种:</label></td>
				    <td style="width:40%">
				    	<input id="textbox1"  name="currency" class="mini-combobox" value="${companyCapital.currency}"
				    		style="width:60%" textField="text" valueField="id" url="/bank/dic/Currency.txt" 
					        required="true"  requiredErrorText="企业名称不能为空" emptyText="请选择..."/>
				    </td>

	     	  </tr>
	     	  <tr>
	     	  	 
				    <td style="width:10%"><label for="textbox2$text">注册资本金额（万元):<</label></td>
				    <td style="width:40%" >
				    	<input id="textbox2"  name="registerCapital" class="mini-textbox" required="true" value="${companyCapital.registerCapital}" 
				    		style="width:60%"/>
				    </td>
				    <td style="width:10%"><label for="textbox2$text">实缴资本金额（万元):<</label></td>
				    <td style="width:40%" >
				    	<input id="textbox2"  name="realCapital" class="mini-textbox" required="true" value="${companyCapital.realCapital}" 
				    		style="width:60%"/>
				    </td>
 				</tr>
 				<tr>
 					
					<td style="width:10%"><label for="textbox3$text">最近一次验资报告文号</label></td>
				 	<td style="width:40%" >
				    	<input id="textbox3"  name="capitalchkNum" class="mini-textbox" required="true" value="${companyCapital.capitalchkNum}" 
				    		style="width:60%"/>
				    </td>
				</tr>
	     	 </table>
	     	 </div>
	       </fieldset>
		 </td>
	  </tr>
		 <tr>
		 <td>
			<fieldset id="fd2" style="width:100%;margin:auto auto">
			<legend><label>出资人信息</label></legend>
			<div class="fieldset-body">
			<table width="100%">
			    <tr>
				    <td style="width:10%"><label for="textbox3$text">出资人名称:</label></td>
				    <td style="width:40%" >
				    	<input id="textbox3"  name="invester" class="mini-textbox" required="true" 
				    		value="${companyCapital.invester}" style="width:60%"/>
				    </td>
				    <td style="width:10%"><label for="textbox4$text">工商登记注册号:</label></td>
				    <td style="width:40%" >
				    	<input id="textbox4"  name="businessCode" class="mini-textbox" required="true"
				    	 value="${companyCapital.businessCode}" style="width:60%"/>
				    </td>	
	     	  </tr>
	     	   <tr>
				    <td style="width:10%"><label for="textbox3$text">证件类型:</label></td>
				    <td style="width:40%" >
				    	<input id="textbox3"  name="idType" class="mini-combobox" required="true" 
				    		required="true" textField="text" valueField="id" url="/bank/dic/IdType.txt" 
				    		emptyText="请选择..."value="${companyCapital.idType}" style="width:60%"/>
				    </td>
				    <td style="width:10%"><label for="textbox4$text">证件号码:</label></td>
				    <td style="width:40%" >
				    	<input id="textbox4"  name="idNumber" class="mini-textbox" required="true" 
				    		value="${companyCapital.idNumber}" style="width:60%"/>
				    </td>	
	     	  </tr>
	     	  <tr>
				    <td style="width:10%"><label for="textbox3$text">出资方式:</label></td>
				    <td style="width:40%" >
				    	<input id="textbox3"  name="investStyle" class="mini-textbox" required="true"
				    	 	value="${companyCapital.investStyle}" style="width:60%"/>
				    </td>
				    <td style="width:10%"><label for="textbox4$text">出资金额:</label></td>
				    <td style="width:40%" >
				    	<input id="textbox4"  name="investAmount" class="mini-textbox" required="true" 
				    	value="${companyCapital.investAmount}" style="width:60%"/>
				    </td>	
	     	  </tr>
	     	  <tr>
				    <td style="width:10%"><label for="textbox3$text">出资日期:</label></td>
				    <td style="width:40%" >
				    	<input id="textbox3"  name="investDate" class="mini-datepicker" required="true" 
				    		value="${companyCapital.investStle}" style="width:60%"/>
				    </td>
				    <td style="width:10%"><label for="textbox4$text">资产评估机构:</label></td>
				    <td style="width:40%" >
				    	<input id="textbox4"  name="evaluateorgan" class="mini-textarea" required="true" 
				    		value="${companyCapital.investAmount}" style="width:60%"/>
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
	  <script type="text/javascript">
		mini.parse();
		var form = new mini.Form("#form1");
		
		$(document).ready(function(){
			$.ajax({
			    url: "${pageContext.request.contextPath}/company/capital/loadCapital.do",
			    type: "post",
			    data:{capitalId:"${param.capitalId}"},
			    success: function (text) {
			        var data = mini.decode(text);   //反序列化成对象
			        if(data.capitalId!=null){
			       	 	form.setData(data);  //设置多个控件数据   
			        }
			    }
			});
			
		});
		
		function back(){
			history.go(-1);
		}
		
		function submitForm(){
			//提交表单数据
		    var formData = form.getData();      //获取表单多个控件的数据'
		   // form.validate();
	      // if (form.isValid() == false) return;
		    var json = mini.encode(formData);   //序列化成JSON
		    $.ajax({
		        url: "${pageContext.request.contextPath}/company/capital/saveCapital.do",
		        type: "post",
		        data: { formData: json},
		        contentType: "application/x-www-form-urlencoded; charset=utf-8",
		        success: function (text) {
		        	var data = mini.decode(text);   //反序列化成对象
			        if(data.capitalId!=null){
			       	 	form.setData(data);  
			        }
		        	 mini.alert('保存成功！');
		        },
		        error: function (jqXHR, textStatus, errorThrown) {
		            mini.alert('系统异常！');
		        }
			});
		}
	  </script>
</body>
</html>