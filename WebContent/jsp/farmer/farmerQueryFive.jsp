<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<title>农户信息条件查询</title>
<style type="text/css">
*{margin:0;padding:0}
body{scrollbar-base-color:#90D5EA;line-height:120%;font-family:"仿宋_GB2312";font-size:13pt;}
.queryPane{
background:linear-gradient(white,#6DC8E3,white);
/* IE6 & IE7 */
filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
endColorstr = 'white' ); 
/* IE8 */
-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
endColorstr = 'white' )"; 
}
.file{
        position:absolute;
        top:0px;
        left:0px;
        width:120px;
        height:24px;
		opacity:0;
		filter:alpha(opacity=0);
	
		}
		#scanFile{
			width:100px;
			height:25px;
			border:0;
			background:url(/bank/images/scanFile.png) no-repeat;
		}
		#uploadFile{
			width:100px;
			height:25px;
			border:0;
			background:url(/bank/images/uploadFile.png) no-repeat;
		}
.labelName{
font-size:15px;
font-weight:bold;
color:darkgreen;
}
input{
border:1px solid #8AD3E9;
background-color:#F5F7CF;
height:20px;
}
li{
margin-top:5px
}
.table_m{width:90%;margin:auto auto}
.table_m table{width:100%;border-bottom:1px dotted #cc9999}
.table_m table td{height:30px;line-height:30px;border-top:1px dotted #cc9999}
</style>
</head>
<body>

<div class="queryPane" style="padding-top:10px;width:100%">
<form id="apply"  method="POST" enctype="multipart/form-data">
<input name="farmerIds" type="hidden" value="${farmerIds}"/>
<input name="apply" type="hidden" value="${apply}"/>
<table width="100%" style="vertical-align:middle;border:1px solid #8AD3E9">
	<tr>
		<td class="labelName"  width="10%" align="right" >贷款金融机构名称</td>
		<td width="2%"></td>
		<td align="left">
			<input name="organName" type="text">
		</td>
		<td width="2%" ></td>
		<td class="labelName" width="10%"align="right" >农户名单:</td>
		<td width="15%" >
        	<input type='text' name='textfield' id='textfield' class='txt' value="不限定农户" />
       	 </td>
       	 <td>
        	<div style="position:relative">
	            <input id="scanFile" type='button' class='btn' value=""  />
	        	<input type="file" name="myfile" class="file" id="myfile" size="28" onchange="document.getElementById('textfield').value=this.value" />
       		</div>
        </td>
	</tr>
	<tr>
		<td class="labelName" width="30%"align="right" >贷款时间从:</td> 
		<td width="2%" ></td>
		<td><input type="text" name="loanDate1"/></td>
		<td width="2%" ></td>
		<td class="labelName"  width="10%" align="right">到:</td>
		<td colspan="2"><input  type="text" name="loanDate2"></td>
	</tr>
	<tr>
		<td class="labelName" width="30%"align="right" >贷款余额范围从:</td> 
		<td width="2%" ></td>
		<td><input type="text" name="balance1"/></td>
		<td width="2%" ></td>
		<td class="labelName"  width="10%" align="right">到:</td>
		<td><input  type="text" name="balance2"></td>
		<td >
			<input type="button" onclick="query()" value ="" 
				style="width:100px;height:25px;margin-top:10px;border:0;background:url(/bank/images/query.png) no-repeat">
		</td>
	</tr>
	<c:if test="${ ! empty farmers}">
	<tr>
		<td colspan="7" align="center">
			<input type="button" onClick="offLineApply()" value="申请下载"/>
		</td>
	</tr>
	</c:if>
</table>
</form>
</div>
<c:choose>
<c:when test="${empty farmers}">
<div>
<fieldset style="width:90%;margin:auto auto">
	 <legend style="width:310px;height:74px;background:url(/bank/images/threetips.png) no-repeat"></legend>
	 <div style="padding:8px 5px 10px 35px">
	 	<p style="font-size:15px;font-family:黑体;font-weight:bold;color:darkgreen;margin-bottom:10px">用户输入农户姓名、身份证号码可以实现二类查询功能:</p>
	 	<ol>
	 		<li>按农户身份证号精确查询、按客户姓名精确查询。</li>
	 		<li>其中按身份证号查询方式跳转至农户概况信息页面，展示农户的概况信息。</li>
	 		<li>其中按姓名查询方式跳转至农户列表信息展示页面，展示负荷条件的多个农户的摘要信息，选择其中的某条记录（通过"详细"按钮）跳转至农户概况信息页面。</li>
	 	</ol>
	 
	 </div>
</fieldset>
</div>
</c:when>
<c:otherwise>
<div>
<fieldset style="width:90%;margin:auto auto">
<legend style="width:310px;height:74px;background:url(/bank/images/tips.png) no-repeat"></legend>
<div class="table_m">
	<table width="90%">
	<tr style="font-weight:bold;color:#ff6666">
		<td align="center">编号</td>
		<td align="center">姓名</td>
		<td align="center">身份证号码</td>
		<td align="center">联系电话</td>
		<td align="center">住址</td>
	</tr>
	<c:forEach items="${farmers}" var="farmer" varStatus="status">
	<tr onclick="detail(${farmer.id})">
		<td align="center">${status.index+1}</td>
		<td align="center">${farmer.farmerName}</td>
		<td align="center">${farmer.farmerIdnum}</td>
		<td align="center">${farmer.phone}</td>
		<td align="center">${farmer.address}</td>
	</tr>	
	</c:forEach>
</table>
</div>
</fieldset>
</div>
</c:otherwise>
</c:choose>
<script type="text/javascript">
function detail(id){
	window.location.href="/bank/farmer/loadChanQuan.do?fid="+id;
};
function query(){
	var form = document.getElementById("apply");
	form.action="/bank/farmer/loadFarmerFive.do";
	form.submit();
};
function offLineApply(){
	var form = document.getElementById("apply");
	form.action="/bank/farmer/offlineApply.do";
	form.submit();
};
</script>
</body>
</html>