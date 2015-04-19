<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>企业概况信息</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<style type="text/css">
html body{
   margin:0;padding:0;border:0;width:100%;height:100%;overflow-y:scroll;
}
.mini-toolbar{
background:url(/bank/jsp/main/leftmenu/images/icon-bg.jpg) repeat-x center;
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
<div>
<div id="form1" style="width:90%;margin:auto auto">
<form action="/bank/company/save.do" method="POST">
<input type="hidden" name="companyId" value="${company.companyId}"/>
<table border="0" cellpadding="1" cellspacing="15" width="100%" >
<tr>
<tr>
	<td colspan="4" style="width:100%">
	 <fieldset id="fd2" style="width:100%;margin:auto auto">
	         <legend><label>企业基本信息</label></legend>
	     <div class="fieldset-body">
	     	<table>
	     		<tr>
 	<td style="width:10%"><label for="textbox1$text">企业名称:</label></td>
    <td style="width:40%">
    	<input id="textbox1"  name="companyName" class="mini-textarea" required="true" requiredErrorText="企业名称不能为空"value="${company.companyName}"style="width:90%"/>
    </td>
    <td style="width:10%"><label for="textbox2$text">企业注册地址:</label></td>
    <td style="width:40%" >
    	<input id="textbox2"  name="registerAddress" class="mini-textarea" required="true" value="${company.registerAddress}" style="width:90%"/>
    </td>
 </tr>
  <tr>
    <td style="width:10%"><label for="textbox3$text">企业通信地址:</label></td>
    <td style="width:40%" >
    	<input id="textbox3"  name="mailingAddress" class="mini-textarea" required="true" value="${company.mailingAddress}" style="width:90%"/>
    </td>
    <td style="width:10%"><label for="textbox4$text">基本户开户行:</label></td>
    <td style="width:40%" >
    	<input id="textbox4"  name="depositbank" class="mini-textarea" required="true" value="${company.depositBank}" style="width:90%"/>
    </td>
 </tr>
 <tr>
    <td style="width:10%"><label for="textbox5$text">组织机构代码:</label></td>
    <td style="width:40%">
    	<input id="textbox5"  name="organCode" class="mini-textbox" required="true" value="${company.organCode}"  style="width:90%"/>
    </td>
  	<td style="width:10%"><label for="textbox6$text">机构信用代码:</label></td>
    <td style="width:40%">
    	<input id="textbox6"  name="creditCode" class="mini-textbox" required="true"  value="${company.creditCode}"style="width:90%"/>
    </td>
 </tr>
  <tr>
  	<td style="width:10%"><label for="textbox7$text">贷款卡编码:</label></td>
     <td style="width:40%">
    	<input id="textbox7"  name="loancardCode" class="mini-textbox" required="true"  value="${company.loancardCode}" style="width:40%"/>
    </td>
    <td style="width:10%"><label for="textbox8$text">邮政编码:</label></td>
    <td style="width:40%">
    	<input id="textbox8"  name="postCode" class="mini-textbox" required="true" value="${company.postCode}" style="width:40%"/>
    </td>
 </tr>
  <tr>
  	<td style="width:10%"><label for="textbox7$text">地区识别码:</label></td>
     <td style="width:40%">
    	<input id="textbox7"  name="localIdentifer" class="mini-textbox" required="true" value="${company.localIdentifer}"  style="width:40%"/>
    </td>
    <td style="width:10%"><label for="textbox8$text">税务识别码:</label></td>
    <td style="width:40%">
    	<input id="textbox8"  name="taxIdentifer" class="mini-textbox" required="true" value="${company.taxIdentifer}" style="width:40%"/>
    </td>
 </tr>
  <tr>
  	<td style="width:10%"><label for="textbox7$text">行政区划:</label></td>
     <td style="width:40%">
    	<input id="textbox7"  name="regionalism" class="mini-textbox" required="true"  value="${company.regionalism}" style="width:40%"/>
    </td>
    <td style="width:10%"><label for="textbox8$text">行业分类:</label></td>
    <td style="width:40%">
    	<input id="textbox8"  name="companyCategory" class="mini-combobox"   value="${company.companyCategory}" style="width:40%"
    		 required="true" textField="text" valueField="id" url="/bank/dic/IndustryCategory.txt"  emptyText="请选择..."/>
    </td>
 </tr>
   <tr>
  	<td style="width:10%"><label for="date$text">企业登记注册日期:</label></td>
     <td style="width:40%">
    	<input id="date1"  name="registerDate" class="mini-datepicker" required="true"  value="${company.registerDate}" style="width:40%"/>
    </td>
    <td style="width:10%"><label for="textbox9$text">企业注册登记类型:</label></td>
    <td style="width:40%">
    	<input id="textbox9"  name="registerType" class="mini-treeselect"  value="${company.registerType}" required="true" style="width:40%" 
    	textField="text" valueField="id" parentField="pid"  url="/bank/dic/RegisterType.txt" emptyText="请选择..."/>
    </td>
 </tr>
  <tr>
  	<td style="width:10%"><label for="date$text">企业特征:</label></td>
     <td style="width:40$">
    	<input id="date1"  name="companyFeature" class="mini-combobox" required="true" value="${company.companyFeature}" style="width:40%"
    		required="true" textField="text" valueField="id" url="/bank/dic/CompanyFeature.txt"  emptyText="请选择..."//>
    </td>
    <td style="width:10%"><label for="textbox9$text">企业性质:</label></td>
    <td style="width:40%">
    	<input id="textbox9"  name="companyNature" class="mini-combobox" value="${company.companyNature}" required="true" style="width:40%" 
    	required="true" textField="text" valueField="id" url="/bank/dic/CompanyNature.txt"  emptyText="请选择..."
    	/>
    </td>
 </tr>
   <tr>
  	<td style="width:10%"><label for="date$text">联系电话:</label></td>
     <td style="width:40%">
    	<input id="date1"  name="telephone" class="mini-textbox" required="true"  value="${company.telephone}" style="width:40%"/>
    </td>
    <td style="width:10%"><label for="textbox9$text">传真号码:</label></td>
    <td style="width:40%">
    	<input id="textbox9"  name="fax" class="mini-textbox" required="true" value="${company.fax}" style="width:40%"/>
    </td>
 </tr>
    <tr>
  	<td style="width:10%"><label for="date$text">电子邮箱:</label></td>
     <td style="width:40%">
    	<input id="date1"  name="email" class="mini-textbox" required="true" value ="${company.email}" style="width:40%"/>
    </td>
    <td style="width:10%"><label for="textbox9$text">从业人数:</label></td>
    <td style="width:40%">
    	<input id="textbox9"  name="employees" class="mini-textbox" required="true" value="${company.employees}" style="width:40%"/>
    </td>
 </tr>
   <tr>
  	<td style="width:10%"><label for="date$text">经营范围:</label></td>
     <td style="width:40%">
    	<input id="date1"  name="businessScope" class="mini-textbox" required="true"  value="${company.businessScope}" style="width:40%"/>
    </td>
    <td style="width:10%"><label for="textbox9$text">主要产品:</label></td>
    <td style="width:40%">
    	<input id="textbox9"  name="products" class="mini-textbox" required="true" value="${company.products }"style="width:40%"/>
    </td>
 </tr>
  <tr>
  	<td style="width:10%"><label for="date$text">经营场地面积:</label></td>
     <td style="width:40%">
    	<input id="date1"  name="locationArea" class="mini-textbox" required="true"  value="${company.locationArea}" style="width:40%"/>
    </td>
    <td style="width:10%"><label for="textbox9$text">经营场地房产所有权:</label></td>
    <td style="width:40%">
    	<input id="textbox9"  name="registeraddress" class="mini-textbox" required="true" style="width:40%"/>
    </td>
    </tr>
    </table>
    </div>
    </fieldset>
 </tr>
  <tr>
   <td colspan="4">
   		<fieldset id="fd2" style="width:100%;margin:auto auto">
	         <legend><label>地税信息</label></legend>
	         <div class="fieldset-body">
	         	<table>
	         		<tr>
	         			<td style="width:10%"><label for="date$text">工商登记注册号:</label></td>
    					<td style="width:40$">
    						<input id="date1"  name="businessCode" class="mini-textbox" required="true"  value="${company.businessCode}" style="width:40%"/>
    					</td>
						<td style="width:10%"><label for="textbox9$text">工商登记注册号发证机关:</label></td>
						<td style="width:40%" >
    						<input id="textbox9"  name="businessIssuer" class="mini-textarea" required="true" value="${company.businessIssuer}" style="width:80%"/>
    					</td>
	         		</tr>
	         		<tr>
	         			<td style="width:10%"><label for="textbox9$text">工商登记注册号上次年检时间:</label></td>
    					<td style="width:40%">
    						<input id="textbox9"  name="businesschkDate" class="mini-datepicker" required="true" value="${company.businesschkDate}" style="width:40%"/>
    					</td>
					    <td style="width:10%"><label for="textbox9$text">营业执照到期日:</label></td>
						<td style="width:40%">
						   	<input id="textbox9"  name="businesslicenceEnd" class="mini-datepicker" value="${company.businesslicenceEnd }" required="true" style="width:40%"/>
						</td>
	         		</tr>
	         	</table>
	         </div>
	   </fieldset>	
   </td>
 </tr>
    <tr>
    <td colspan="4">
    	 <fieldset id="fd2" style="width:100%;">
	         <legend><label>地税信息</label></legend>
	         <div class="fieldset-body">
		         <table>
			         <tr>
			           	<td style="width:10%"><label for="date$text">地税登记证号码:</label></td>
			     		<td style="width:40%">
			    			<input id="date1"  name="localTaxCode" class="mini-textbox" required="true"  value="${company.localTaxCode}"  style="width:40%"/>
			    	
			    		</td>
					  	<td style="width:10%"><label for="date$text">地税登记证发证机关:</label></td>
					    <td style="width:40%">
					    	<input id="date1"  name="localTaxIssuer" class="mini-textarea" required="true"  value="${company.localTaxIssuer}" style="width:90%"/>
					    </td>
			    	</tr>
				    <tr>
				  		<td style="width:10%"><label for="date$text">地税登记证到期日:</label></td>
				    	<td style="width:40%" >
				    		<input id="date1"  name="localtaxEnd" class="mini-datepicker" required="true" value="${company.localtaxEnd}"style="width:40%"/>
				    </td>
				 	</tr>
		    	</table>
	     	</div>
        </fieldset>  
    </td>
 </tr>
  <tr>
  <td colspan="4">
     <fieldset id="fd2" style="width:100%;margin:auto;auto">
         <legend><label>国税信息</label></legend>
	     <div class="fieldset-body">
	     	<table>
	     		<tr>
	     			<td style="width:10%"><label for="chinataxCode$text">国税登记证号码:</label></td>
    				<td style="width:40%">
    					<input id="chinataxCode"  name="chinataxCode" class="mini-textbox" required="true"  value="${company.chinataxCode}" style="width:40%"/>
				    </td>
				  	<td style="width:10%"><label for="date$text">国税登记证发证机关:</label></td>
				    <td style="width:40%" colspan="3">
				    	<input id="chinataxIssuer"  name="chinataxIssuer" class="mini-textarea" required="true" value="${company.chinataxIssuer}" style="width:90%"/>
				    </td>
	     		</tr>
	     		   <tr>
				  	<td style="width:10%"><label for="date$text">国税登记证到期日:</label></td>
				     <td style="width:40%" >
				    	<input id="chinataxEnd"  name="chinataxEnd" class="mini-datepicker" required="true"  value="${company.chinataxEnd}" style="width:40%"/>
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
</div>
<script type="text/javascript">

	mini.parse();
	var form = new mini.Form("#form1");

	$(document).ready(function(){
		$.ajax({
		    url: "${pageContext.request.contextPath}/company/loadCompany.do",
		    type: "post",
		    data:{companyId:"${param.companyId}"},
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
	    //formData.dutyId = ${dutyId};
	    var json = mini.encode(formData);   //序列化成JSON
	    $.ajax({
	        url: "${pageContext.request.contextPath}/company/saveCompany.do",
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
	function onDrawCell(e) {
		alert('no');
            value = e.value;
            //组织HTML设置给cellHtml
            e.cellHtml = '<span style="color:red;">'+value+'</span>';   
	}
}

</script>
</body>
</html>