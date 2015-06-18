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
background:linear-gradient(#6DC8E3,white);
/* IE6 & IE7 */
filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
endColorstr = 'white' ); 
/* IE8 */
-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
endColorstr = 'white' )"; 
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
.table_m{width:98%;height:250px;margin:auto auto;overflow-y:auto;overflow-x:hidden;}
.table_m table{width:100%;border-bottom:1px dotted gray}
.table_m tr:hover{background:#90D5EA}
.table_m table td{height:30px;line-height:30px;border-top:1px dotted gray;}
.mini-panel-border{
border-color:#D2D2D2;
}
.mini-grid-headerCell-nowrap{
background:white
}
.mini-grid-headerCell{
background:white;
border-top:0px;
border-color:#D2D2D2
}
.mini-grid-headerCell-inner{
font-family:"仿宋_GB2312";
font-size:12pt;
}
.mini-grid-column-splitter{
background:white
}
.mini-grid-pager{
background:white
}
</style>
</head>
<body>
<div class="queryPane" style="padding-top:10px;width:100%">
<form action="/bank/farmer/loadFarmerThree.do" method="POST">
<table width="100%"  style="vertical-align:middle;">
	<tr>
		<td class="labelName"  width="30%" align="right">贷款金融机构名称:</td>
		<td width="2%" ></td>
		<td align="left" ><input  type="text" id="organName" name="organName"></td>
		<td width="2%" ></td>
		<td class="labelName"  width="30%" align="right">贷款金融机构名称:</td>
		
		<td align="left"><input  type="text" id="organName1" name="organName"></td>
		<td rowspan="3" align="center" style="vertical-align:middle;">
			<input type="button" value=""  onclick="search()"style="width:100px;height:25px;margin-top:auto;margin-bottom:auto;border:0;background:url(/bank/images/query.png) no-repeat">
		</td>
	</tr>
	<tr>
		<td class="labelName" width="30%"align="right" >贷款时间从:</td> 
		<td width="2%" ></td>
		<td><input type="text" id="loanDate1" name="loanDate1"/></td>
		<td width="2%" ></td>
		<td class="labelName"  width="10%" align="right">到:</td>
		<td><input  type="text" id="loandDate2" name="loandDate2"></td>
	</tr>
	<tr>
		<td class="labelName" width="30%"align="right" >贷款余额范围从:</td> 
		<td width="2%" ></td>
		<td><input type="text" id="balance1" name="balance1"/></td>
		<td width="2%" ></td>
		<td class="labelName"  width="10%" align="right">到:</td>
		<td><input  type="text" name="balance2"></td>
		
	</tr>
</table>
</form>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:98%;height:300px;margin:auto auto" 
    url="/bank/farmer/loadFarmerThree.do"  idField="id" allowResize="true"
    sizeList="[20,30,50,100]" pageSize="10"
>
    <div property="columns">
        <div type="indexcolumn" ></div>
        <div field="farmerName" width="10%" headerAlign="center" allowSort="true">姓名</div>    
        <div field="frmerIdnum" width="20%" headerAlign="center" allowSort="true">身份证号码</div>                            
        <div field="sex" width="10%" renderer="onGenderRenderer" align="center" headerAlign="center">性别</div>
        <div field="phone" width="20%" align="right" width="100" allowSort="true">联系方式</div>                                
        <div field="address" width="40%" allowSort="true" decimalPlaces="2" dataType="float">地址</div>
    </div>
</div>   
 <script type="text/javascript">
 mini.parse();
 var grid = mini.get("datagrid1");
 function search() {
     var organName = $("#organName").val();
     var loanDate1 = $("#loanDate1").val();
     var loanDate2 = $("#loanDate2").val();
     var balance1 = $("#balance1").val();
     var balance2 = $("#balance2").val()
     grid.load({organName:organName,loanDate1:loanDate1,loanDate2:loanDate2,
    	 balance1:balance1,balance2:balance2});
 }
 
 </script>
</body>
</html>