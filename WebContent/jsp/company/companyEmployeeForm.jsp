<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<title>Insert title here</title>
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
	  <form action="/bank/company/savecompanyEmployee.do" method="POST">
	  <input name="capitalId" class="mini-hidden" value="${companyEmployee.employeeId}"/>
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
						   			requiredErrorText="企业名称不能为空" value="${companyEmployee.companyName}"style="width:60%"/>
						  	</td>
						  	<td style="width:10%"><label for="textbox2$text">组织机构代码:</label></td>
						 	 <td style="width:40%" >
						    	<input id="textbox2"  name="organCode" class="mini-textbox" required="true" 
						    		value="${companyEmployee.organCode}"  style="width:60%"/>
						  	</td>
		 			    </tr>
		 			    <tr>
			     	  		<td style="width:10%"><label for="textbox1$text">机构信用代码:</label></td>
						 	<td style="width:40%">
						   		<input id="textbox1"  name="creditCode" class="mini-texbox" required="true" 
						   			requiredErrorText="企业名称不能为空" value="${companyEmployee.creditCode}"style="width:60%"/>
						  	</td>
						  	<td style="width:10%"><label for="textbox2$text">高管人员姓名  :</label></td>
						 	 <td style="width:40%" >
						    	<input id="textbox2"  name="name" class="mini-textbox" required="true" 
						    		value="${companyEmployee.name}"  style="width:60%"/>
						  	</td>
		 			    </tr>
		 			    <tr>
			     	  		<td style="width:10%"><label for="textbox1$text">高管人员性别:</label></td>
						 	<td style="width:40%">
						   		<input id="textbox1"  name="sex" class="mini-combobox" required="true" 
						   			required="true" textField="text" valueField="id" url="/bank/dic/Sex.txt" 
						   			emptyText="请选择..."  requiredErrorText="企业名称不能为空" 
						   			value="${companyEmployee.sex}"style="width:60%"/>
						  	</td>
						  	<td style="width:10%"><label for="textbox2$text">出生日期:</label></td>
						 	 <td style="width:40%" >
						    	<input id="textbox2"  name="birthday" class="mini-datepicker" required="true" 
						    		value="${companyEmployee.birthday}"  style="width:60%"/>
						  	</td>
		 			    </tr>
		 			        <tr>
			     	  		<td style="width:10%"><label for="textbox1$text">高管类别:</label></td>
						 	<td style="width:40%">
						   		<input id="textbox1"  name="category" class="mini-combobox" required="true" 
						   			required="true" textField="text" valueField="id" url="/bank/dic/EmployeeType.txt" 
						   			 emptyText="请选择..."requiredErrorText="企业名称不能为空" value="${companyEmployee.category}"style="width:60%"/>
						  	</td>
						  	<td style="width:10%"><label for="textbox2$text">证件类型:</label></td>
						 	 <td style="width:40%" >
						    	<input id="textbox2"  name="idType" class="mini-combobox" required="true" 
						    		required="true" textField="text" valueField="id" url="/bank/dic/IdType.txt" 
						    		 emptyText="请选择..." value="${companyEmployee.idType}"  style="width:60%"/>
						  	</td>
		 			    </tr>
		 			       <tr>
			     	  		<td style="width:10%"><label for="textbox1$text">证件号码:</label></td>
						 	<td style="width:40%">
						   		<input id="textbox1"  name="idNumber" class="mini-textbox" required="true" 
						   			requiredErrorText="企业名称不能为空" value="${companyEmployee.idNumber}"style="width:60%"/>
						  	</td>
						  	<td style="width:10%"><label for="textbox2$text">职务:</label></td>
						 	 <td style="width:40%" >
						    	<input id="textbox2"  name="post" class="mini-textbox" required="true" 
						    		value="${companyEmployee.post}"  style="width:60%"/>
						  	</td>
		 			    </tr>
		 			      <tr>
			     	  		<td style="width:10%"><label for="textbox1$text">担任本职时间:</label></td>
						 	<td style="width:40%">
						   		<input id="textbox1"  name="postTime" class="mini-datepicker" required="true" 
						   			requiredErrorText="企业名称不能为空" value="${companyEmployee.postTime}"style="width:60%"/>
						  	</td>
						  	<td style="width:10%"><label for="textbox2$text">最高学历:</label></td>
						 	 <td style="width:40%" >
						    	<input id="textbox2"  name="degree" class="mini-textbox" required="true" 
						    		value="${companyEmployee.degree}"  style="width:60%"/>
						  	</td>
		 			    </tr>
		 			      <tr>
			     	  		<td style="width:10%"><label for="textbox1$text">持有企业股份:</label></td>
						 	<td style="width:40%">
						   		<input id="textbox1"  name="stockAmount" class="mini-textabox" required="true" 
						   			requiredErrorText="企业名称不能为空" value="${companyEmployee.stockAmount}"style="width:60%"/>
						  	</td>
						  	<td style="width:10%"><label for="textbox2$text">技能资格:</label></td>
						 	 <td style="width:40%" >
						    	<input id="textbox2"  name="skill" class="mini-textbox" required="true" 
						    		value="${companyEmployee.skill}"  style="width:60%"/>
						  	</td>
		 			    </tr>
		 			      <tr>
			     	  		<td style="width:10%"><label for="textbox1$text">技能资格取得时间:</label></td>
						 	<td style="width:40%">
						   		<input id="textbox1"  name="skillwinTime" class="mini-datepicker" required="true" 
						   			requiredErrorText="企业名称不能为空" value="${companyEmployee.skillwinTime}"style="width:60%"/>
						  	</td>
						  	 	<td style="width:10%"><label for="textbox2$text">个人受奖励情况:</label></td>
						 	 <td style="width:40%" >
						    	<input id="textbox2"  name="award" class="mini-textbox" required="true" 
						    		value="${companyEmployee.award}"  style="width:60%"/>
						  	</td>						  
		 			    </tr>
		 			      <tr>
			     	  		<td style="width:10%"><label for="textbox1$text">工作简历:</label></td>
						 	<td style="width:40%">
						   		<input id="textbox1"  name="workResume" class="mini-textarea" required="true" 
						   			requiredErrorText="企业名称不能为空" value="${companyEmployee.workResume}"style="width:60%"/>
						  	</td>
						 	<td style="width:10%"><label for="textbox2$text">社会兼职:</label></td>
						 	<td style="width:40%" >
						    	<input id="textbox2"  name="parttimeJob" class="mini-textarea" required="true" 
						    		value="${companyEmployee.parttimeJob}"  style="width:60%"/>
						  	</td>
		 			    </tr>
		 		
		 			 </table>
				</div>
				</fieldset>
		  </td>
		  </tr>
		  <tr>
		  <td>
			 <fieldset id="fd1" style="width:100%;margin:auto auto">
			 <legend><label>在其他企业投资或任职情况</label></legend>
			 <div class="fieldset-body">
			 <table>
			 	<tr>
					<td style="width:10%"><label for="textbox3$text">在其他企业投资或任职的企业名称:</label></td>
				    <td style="width:40%" >
				    	<input id="textbox3"  name="othercompanyName" class="mini-textbox" required="true" 
				    		value="${companyEmployee.othercompanyName}" style="width:60%"/>
				    </td>
				    <td style="width:10%"><label for="textbox4$text">在其他企业投资或任职的企业工商登记注册号:</label></td>
				    <td style="width:40%" >
				    	<input id="textbox4"  name="otherregisterCode" class="mini-textbox" required="true" 
				    		value="${companyEmployee.otherregisterCode}" style="width:60%"/>
				    </td>	
	     	   </tr>
	     	   <tr>
				    <td style="width:10%"><label for="textbox3$text">在其投资或任职的其他企业所担任职务:</label></td>
				    <td style="width:40%" >
				    	<input id="textbox3"  name="otherPost" class="mini-textbox" required="true" 
				    		value="${companyEmployee.otherPost}" style="width:60%"/>
				    </td>
				    <td style="width:10%"><label for="textbox4$text">在投资或任职的其他企业的投资额:</label></td>
				    <td style="width:40%" >
				    	<input id="textbox4"  name="otherinvestAmount" class="mini-textbox" required="true" 
				    		value="${companyEmployee.otherinvestAmount}" style="width:60%"/>
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
			    url: "${pageContext.request.contextPath}/company/employee/loadEmployee.do",
			    type: "post",
			    data:{employeeId:"${param.employeeId}"},
			    success: function (text) {
			        var data = mini.decode(text);   //反序列化成对象
			        if(data.employeeId!=null){
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
		        url: "${pageContext.request.contextPath}/company/employee/saveEmployee.do",
		        type: "post",
		        data: { formData: json},
		        contentType: "application/x-www-form-urlencoded; charset=utf-8",
		        success: function (text) {
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