<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jsp/farmer/farmer.js" type="text/javascript"></script>
<title>农户信息批量查询</title>
 <style type="text/css">
	*{ margin:0;padding:0;}
	body{line-height:120%;font-family:"仿宋_GB2312";font-size:13pt;}
    a{text-decoration:none}
    a:link{text-decoration:none;}
    legend{font-weight: bold;color: seagreen;font-family:"圆幼","宋体" ;}
        .file{
        position:absolute;
        top:0px;
        left:0px;
        width:120px;
        height:24px;
		opacity:0;
		filter:alpha(opacity=0);
	
		}
		.success{
			color:green;
			font-weight:bold;
			height:25px;
		}
		.info{
			color:blue;
			font-weight:bold;
			height:25px;
		}
		.table-b table{border-bottom:1px dotted #cc9999
		}
		.table-b table td{height:30px;line-height:30px;border-top:1px dotted #cc9999}
		.ChaKan_Btn{
			width:50px;
			background-position:0% 50%;
			background-image:url(/bank/images/ChaKan_B.png);
			background-repeat:no-repeat
		}
		.ChaKan_Btn:hover{
			width:50px;
			height:30px;
			line-height:30px;
			background-position:0% 50%;
			background-image:url(/bank/images/ChaKan_A.png);
			background-repeat:no-repeat
		}
    </style>
</head>
<body>
<div class="queryPane">
<form action="/bank/farmer/loadFarmerTwo.do" method="post" enctype="multipart/form-data">
<table width="100%" height ="60px">
 	<tr>
 		<td class="labelName" width="30%" align="right">
        	请选择农户名单：
        </td>
    	<td width="15%" >
        	<input type='text' name='textfield' id='textfield' class='bank-text' value="" />
        </td>
        <td width="15%" >
        	<div style="position:relative">
	            <input id="scanFile" type='button' class='bank-btn' value="浏览"  />
	        	<input type="file" name="myfile" class="file" id="myfile" size="28" onchange="document.getElementById('textfield').value=this.value" />
       		</div>
        </td>
        <td align="left">
            <input id="uploadFile" type="submit" name="submit" class="bank-btn" value="上传"/>
        </td>
     </tr>
 </table>
</form>
</div>
<div>
<c:choose>
	<c:when test="${!empty farmers}">
		<div class="table-b" style="width:90%;margin:auto auto;height:320px;overflow-y:auto">
			<table class="table" width="100%" cellspacing=0 cellpadding=0>
				<tr style="font-weight:bold;color:#ff6666">
					<td align="center">编号</td>
					<td align="center">姓名</td>
					<td align="center">身份证号码</td>
					<td></td>
				</tr>
				<c:forEach items="${farmers}" var="farmer" varStatus="status">
					<tr height="30px">
					<td align="center">${status.index}</td>
					<td align="center">${farmer.farmername}</td>			
					<td align="center">${farmer.farmeridnum}</td>
					<td align="right" class="ChaKan_Btn"><a  href="/bank/farmer/loadFarmerTwoTotal.do?farmerName=${farmer.farmername}&farmerIdNum=${farmer.farmeridnum}" target="_self">查看</a></td>
				</tr>
				</c:forEach>
			
			</table>
		
		</div>
	</c:when>
	<c:otherwise>
	<fieldset class="bank-view-fieldset"style="width:90%;margin:auto auto">
	 <legend style="width:310px;height:74px;background:url(/bank/images/twotips.png) no-repeat"></legend>
	 <div style="padding:8px 5px 10px 35px">
	 	<p style="font-size:15px;font-family:黑体;font-weight:bold;color:darkgreen;margin-bottom:10px">用户输入农户姓名、身份证号码可以实现二类查询功能:</p>
	 	<ol>
	 		<li>按农户身份证号精确查询、按客户姓名精确查询。</li>
	 		<li>其中按身份证号查询方式跳转至农户概况信息页面，展示农户的概况信息。</li>
	 		<li>其中按姓名查询方式跳转至农户列表信息展示页面，展示负荷条件的多个农户的摘要信息，选择其中的某条记录（通过"详细"按钮）跳转至农户概况信息页面。</li>
	 	</ol>
	 </div>
	</fieldset>
	</c:otherwise>
</c:choose>
</div>
</body>
</html>