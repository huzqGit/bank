<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农民专业合作经济组织基本概况信息</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
<div class="mini-toolbar" style="padding-top:5px;border-bottom:0;">
	<table style="width:100%;">
    	<tr>
        	<td style="white-space:nowrap;">
        		<span style="${display}">
		        	<a class="mini-button" iconCls="icon-save" plain="true" onclick="submitForm()">保存</a>
		           	<span class="separator"></span>
	            </span>
	            <a class="mini-button" iconCls="icon-remove" plain="true" onclick="close()">关闭</a>
                <span class="separator"></span>
            </td>
         </tr>
      </table>
</div>
<div id="form1" style="width:90%;margin:auto auto">
	<form action="/bank/economy/saveCooperation.do" method="POST">
	<input name="cooperationId" class="mini-hidden" value="${cooperationId}"/>
	<input name="recorder" class="mini-hidden" value="管理员"/>
	<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
	<table border="0" cellpadding="1" cellspacing="15" width="100%" >
	<tr>
	<td colspan="4" style="width:100%">
	<fieldset id="fd2" style="width:100%;margin:auto auto">
	<legend><label>农民专业合作经济组织基本概况信息</label></legend>
	<div class="fieldset-body">
	<table width="100%">
	<tr>
	<td style="width:10%"><label for="textbox1$text">合作社名称:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="cooperationName" class="mini-textbox" required="true" 
		requiredErrorText="合作社名称不能为空" style="width:90%" value="${cname}"/>
	</td>
	<td style="width:10%"><label for="textbox2$text">组织机构编码:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="orgaCode" class="mini-textbox" required="true" 
		requiredErrorText="组织机构编码不能为空"  style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">税务登记号:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="taxCode" class="mini-textbox" required="true" 
		requiredErrorText="税务登记号不能为空"style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox1$text">注册时间:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="registerDate" class="mini-datepicker" required="true" 
		requiredErrorText="注册时间不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox2$text">注册地址:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="registerAddress" class="mini-textarea" required="true" 
		requiredErrorText="注册地址不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox1$text">通信地址:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="mailAddress" class="mini-textarea" required="true" 
		requiredErrorText="通信地址不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">注册资金:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="registerCapital" class="mini-textbox" required="true"  vtype="float"
		requiredErrorText="注册资金不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox1$text">实收资金:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="realCapital" class="mini-textbox" required="true"  vtype="float"
		requiredErrorText="实收资金不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">法定代表人:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="legalPerson" class="mini-textbox" required="true" 
		requiredErrorText="法定代表人不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox1$text">身份证号:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="idNum" class="mini-textbox" required="true" 
		requiredErrorText="身份证号不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">联系电话号码:</label></td> 
	<td style="width:40%">
	<input id="textbox1"  name="phone" class="mini-textbox" required="true" 
		requiredErrorText="联系电话号码不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox1$text">社员人数:</label></td> vtype="float"
	<td style="width:40%">
	<input id="textbox1"  name="members" class="mini-textbox" required="true" 
		requiredErrorText="社员人数不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">经营范围:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="businesScope" class="mini-textbox" required="true" 
		requiredErrorText="经营范围不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox1$text">经营场地面积:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="businessArea" class="mini-textbox" required="true" 
		requiredErrorText="社员人数不能为空" style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text">带动农户（户）:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="farmers" class="mini-textbox" required="true" vtype="float"
		requiredErrorText="带动农户不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox1$text">联接基地（亩）:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="connectionBase" class="mini-textbox" required="true" vtype="float"
		requiredErrorText="联接基地不能为空" style="width:90%"/>
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
<script type="text/javascript">
		mini.parse();
		var form = new mini.Form("#form1");
		//查询表单数据
		$(document).ready(function(){
			$.ajax({
			    url: "${pageContext.request.contextPath}/economy/findCooperation.do",
			    type: "post",
			    data:{cooperationId:"${cooperationId}"},
			    success: function (text) {
			        var data = mini.decode(text);   //反序列化成对象
			        if(data.cooperationId!=null){
			       	 	form.setData(data);  //设置多个控件数据   
			        }
			    },
			    error:function(text,arg2){
			    }
			});
			
		});
		
		function back(){
			history.go(-1);
		}
		
		function close(){
			//window.close();
			window.CloseOwnerWindow();
		}
		
		function submitForm(){
			//提交表单数据
		    var formData = form.getData();      //获取表单多个控件的数据'
		   	form.validate();
	      	if (!form.isValid())
	      		return;
		    var json = mini.encode(formData);   //序列化成JSON
		    $.ajax({
		        url: "${pageContext.request.contextPath}/economy/saveCooperation.do",
		        type: "post",
		        data: { formData: json},
		        contentType: "application/x-www-form-urlencoded; charset=utf-8",
		        success: function (text) {
		        	var data = mini.decode(text);   //反序列化成对象
			        if(data.cooperationId!=null){
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
</html>