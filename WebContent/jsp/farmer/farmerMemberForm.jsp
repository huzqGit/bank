<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/CurrentTime.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家庭成员(含户主)基本情况</title>
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
	<input type="hidden" name="id"/>
	<input name="recorder" class="mini-hidden" value="管理员"/>
	<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
	<table border="0" cellpadding="1" cellspacing="15" width="100%" >
	<tr>
	<td colspan="4" style="width:100%">
	<fieldset id="fd2" style="width:100%;margin:auto auto">
	<legend><label>家庭成员(含户主)基本情况</label></legend>
	<div class="fieldset-body">
	<table width="100%">
	<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>户主姓名:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="farmerName" class="mini-textbox" required="true" 
		requiredErrorText="户主姓名不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox2$text"><font color="red">*</font>户主身份证号:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="farmerIdnum" class="mini-textbox" required="true" 
		requiredErrorText="户主身份证号不能为空"  style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>姓名:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="name" class="mini-textbox" required="true"
		requiredErrorText="家庭成员姓名不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox2$text"><font color="red">*</font>与户主关系:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="relation" class="mini-combox" required="true" 
		requiredErrorText="与户主关系不能为空"  style="width:90%"
		url="/bank/dic/Relation.txt" emptyText="请选择..."/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text"><font color="red">*</font>身份证号:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="idNum" class="mini-textbox" required="true" 
		requiredErrorText="身份证号不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox2$text"><font color="red">*</font>文化程度:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="education" class="mini-combobox" required="true" 
		requiredErrorText="文化程度不能为空"  style="width:90%"
		url="/bank/dic/Education.txt" emptyText="请选择..."/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text"> 婚姻状况:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="marryStatus" class="mini-combobox" required="true" 
		requiredErrorText="婚姻状况不能为空" style="width:90%"
		url="/bank/dic/MarryStatus.txt" emptyText="请选择..."/>
	</td>
	<td style="width:10%"><label for="textbox2$text"> 职业:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="occupation" class="mini-textbox" required="true" 
		requiredErrorText="职业不能为空"  style="width:90%"/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text"> 职务:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="job" class="mini-textbox" required="true" 
		requiredErrorText="职务不能为空" style="width:90%"/>
	</td>
	<td style="width:10%"><label for="textbox2$text"> 性别:</label></td>
	<td style="width:40%" >
	<input id="textbox2"  name="sex" class="mini-combobox" required="true" 
		requiredErrorText="性别不能为空" style="width:90%"
		url="/bank/dic/Sex.txt" emptyText="请选择..."/>
	</td>
	</tr>
	<tr>
	<td style="width:10%"><label for="textbox1$text"> 联系电话:</label></td>
	<td style="width:40%">
	<input id="textbox1"  name="phone" class="mini-textbox" required="true" 
		requiredErrorText="联系电话不能为空" style="width:90%"/>
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
		    url: "${pageContext.request.contextPath}/farmer/loadMember.do",
		    type: "post",
		    data:{id:"${param.id}"},
		    success: function (text) {
		        var data = mini.decode(text);   //反序列化成对象
		        form.setData(data);             //设置多个控件数据
		    }
		});
		
	});
	function back(){
		history.go(-1);
	}
	function submitForm() {
		//提交表单数据
	    var formData = form.getData();      //获取表单多个控件的数据
	    var json = mini.encode(formData);   //序列化成JSON
	    $.ajax({
	        url: "${pageContext.request.contextPath}/farmer/saveMember.do",
	        type: "post",
	        data: { formData: json},
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        success: function (text) {
	        	var data = mini.decode(text);   //反序列化成对象
		        if(data.id!=null){
		       	 	form.setData(data);  
		        }
	        	 mini.alert('保存成功！');
	        },
	        error: function (jqXHR, textStatus, errorThrown) {
	            mini.alert('系统异常！');
	        }
	});
	function onDrawCell(e) {
            value = e.value;
            //组织HTML设置给cellHtml
            e.cellHtml = '<span style="color:red;">'+value+'</span>';   
	}
}
</script>
</body>
</html>