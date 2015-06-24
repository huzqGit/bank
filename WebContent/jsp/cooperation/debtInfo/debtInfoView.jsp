<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/miniui/json2.js" type="text/javascript"></script>
<title>企业主要财务指标</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0
}

body {
	scrollbar-base-color: #90D5EA;
	line-height: 120%;
	font-family: "仿宋_GB2312";
	font-size: 13pt;
}

.queryPane {
	background: linear-gradient(#6DC8E3, white);
	/* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0,
		startColorstr= '#6DC8E3', endColorstr= 'white');
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType= 0,
		startColorstr= '#6DC8E3', endColorstr= 'white')";
}

.labelName {
	font-family: "仿宋_GB2312";
	font-size: 14pt;
	line-height: 150%;
	font-weight: bold;
	color: darkgreen;
}

input {
	border: 1px solid #8AD3E9;
	background-color: #F5F7CF;
	height: 20px;
}

.table_m {
	width: 98%;
	height: 250px;
	margin: auto auto;
	overflow-y: auto;
	overflow-x: hidden;
}

.table_m table {
	width: 100%;
	border-bottom: 1px dotted gray
}

.table_m tr:hover {
	background: #90D5EA
}

.table_m table td {
	height: 30px;
	line-height: 30px;
	border-top: 1px dotted gray;
}

.mini-panel-border {
	border-color: #D2D2D2;
}

.mini-grid-headerCell-nowrap {
	background: white
}

.mini-grid-headerCell {
	background: white;
	border-top: 0px;
	border-color: #D2D2D2
}

.mini-grid-headerCell-inner {
	font-family: "仿宋_GB2312";
	font-size: 12pt;
}

.mini-grid-column-splitter {
	background: white
}

.mini-grid-pager {
	background: white
}

.bg {
	background: url(images/toolbar/toolbar.png) #e7eaee repeat-x 0px 0px
}

.topmenu {
	width: 100%;
	height: 30px;
	background: linear-gradient(#6DC8E3, white);
	/* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0,
		startColorstr= '#6DC8E3', endColorstr= 'white');
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType= 0,
		startColorstr= '#6DC8E3', endColorstr= 'white')";
}

.btn {
	background-color: #FFF;
	border: 1px solid #CDCDCD;
	height: 24px;
	width: 70px;
	display: inline-block;
	cursor: hand;
}

.zero {
	height: 1px;
}
</style>
</head>
<body>
<ul id="treeMenu" class="mini-contextmenu"  onbeforeopen="onBeforeOpen">        
     <li name="add" iconCls="icon-add" onclick="add">新增</li>
    	<li class="separator"></li>
    	<!-- <li name="save" iconCls="icon-save" onclick="save">保存</li> -->
    	<li name="remove" iconCls="icon-edit" onclick="edit">编辑</li>
	<li name="remove" iconCls="icon-remove" onclick="remove">删除</li>
</ul>
<div class="queryPane" style="padding-top:10px;width:100%;height:80px">
<form id="farmer" action="" method="POST">
<table width="100%" height="60px" style="vertical-align:middle;">
	<tr>
		<td width="3%" ></td>
		<td class="labelName" width="11%">
			<font color="red"></font>合作社名称:&nbsp;
		</td>
		<td width="10%" align=center>
			<input id="cooperationname" name="cooperationname" class="mini-textbox"  emptyText="请输入合作社名称" style="font-size:9pt"/>
		</td>
		<td width="3%" ></td>
		<td class="labelName"  width="11%">
			<font color="red"></font>组织机构编码:
		</td>
		<td width="10%">
			<input  id="organcode" name="organcode" class="mini-textbox"  emptyText="请输入机构编码" style="font-size:9pt"></td>
		<td width="5%"></td>
		<td width="10%" align="left">
			<input type="button" value=""  onclick="onSearch()"style="width:100px;height:25px;border:0;background:url(/bank/images/query.png) no-repeat" class="btn">
		</td>
		<td width="10%" align="left">
			<input type="button" value=""  onclick="add()" style="width:100px;height:25px;border:0;background:url(/bank/images/LuRu.png) no-repeat" class="btn">
		</td>
	</tr>
</table>
</form>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:98%;margin:auto auto;height:340px;background-color:white" 
           url="${pageContext.request.contextPath}/economy/debt/loadAllFarmerCooperationDebt.do" idField="debtid"
            sizeList="[5,10,20,50]" pageSize="20" frozenStartColumn="0" frozenEndColumn="1"
            allowCellEdit="false" allowCellSelect="true" multiSelect="false" allowResize="true"
        	  editNextOnEnterKey="true"  editNextRowCell="true" contextMenu="#treeMenu">
       <div property="columns">
          <div type="indexcolumn" >
          </div>
          <div field="cooperationname" width="120" headerAlign="center" allowSort="true" >合作组织名称
          </div>
          <div field="organcode" width="120" headerAlign="center" allowSort="true" >组织机构编码
          </div>
          <div field="yearmonth" width="120" headerAlign="center" allowSort="true" >年月
          	<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
          </div>
          <div field="cashcapital" width="120" headerAlign="center" allowSort="true" >货币资金<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="cashcapital2" width="120" headerAlign="center" allowSort="true" >货币资金(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="shortinvest" width="120" headerAlign="center" allowSort="true" >短期投资<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="shortinvest2" width="120" headerAlign="center" allowSort="true" >短期投资(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="receivables" width="120" headerAlign="center" allowSort="true" >应收账款净额<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="receivables2" width="120" headerAlign="center" allowSort="true" >应收账款净额(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="prepayment" width="120" headerAlign="center" allowSort="true" >预付账款<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="prepayment2" width="120" headerAlign="center" allowSort="true" >预付账款(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="inventory" width="120" headerAlign="center" allowSort="true" >存货<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="inventory2" width="120" headerAlign="center" allowSort="true" >存货(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="floatasset" width="120" headerAlign="center" allowSort="true" >其他流动资产<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="floatasset2" width="120" headerAlign="center" allowSort="true" >其他流动资产(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="floatassetall" width="120" headerAlign="center" allowSort="true" >流动资产合计<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="floatassetall2" width="120" headerAlign="center" allowSort="true" >流动资产合计(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="fixedasset" width="120" headerAlign="center" allowSort="true" >固定资产原价<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="fixedasset2" width="120" headerAlign="center" allowSort="true" >固定资产原价(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="deprecication" width="120" headerAlign="center" allowSort="true" >其中折旧<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="deprecication2" width="120" headerAlign="center" allowSort="true" >其中折旧(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="netvalue" width="120" headerAlign="center" allowSort="true" >固定资产净值<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="netvalue2" width="120" headerAlign="center" allowSort="true" >固定资产净值(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="buildingproject" width="120" headerAlign="center" allowSort="true" >在建项目<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="buildingproject2" width="120" headerAlign="center" allowSort="true" >在建项目(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="fixedassetall" width="120" headerAlign="center" allowSort="true" >固定资产合计<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="fixedassetall2" width="120" headerAlign="center" allowSort="true" >固定资产合计(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="invisibleasset" width="120" headerAlign="center" allowSort="true" >无形及递延资产合计<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="invisibleasset2" width="120" headerAlign="center" allowSort="true" >无形及递延资产合计(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="assetall" width="120" headerAlign="center" allowSort="true" >资产合计<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="assetall2" width="120" headerAlign="center" allowSort="true" >资产合计(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="shortloan" width="120" headerAlign="center" allowSort="true" >短期借款<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="shortloan2" width="120" headerAlign="center" allowSort="true" >短期借款(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="bankloan" width="120" headerAlign="center" allowSort="true" >银行借款<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="bankloan2" width="120" headerAlign="center" allowSort="true" >银行借款(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="accountspayable" width="120" headerAlign="center" allowSort="true" >应付账款<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="accountspayable2" width="120" headerAlign="center" allowSort="true" >应付账款(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="depositreceived" width="120" headerAlign="center" allowSort="true" >预收账款<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="depositreceived2" width="120" headerAlign="center" allowSort="true" >预收账款(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="unpaidtax" width="120" headerAlign="center" allowSort="true" >未缴税金<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="unpaidtax2" width="120" headerAlign="center" allowSort="true" >未缴税金(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="floatdebt" width="120" headerAlign="center" allowSort="true" >其他流动负债<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="floatdebt2" width="120" headerAlign="center" allowSort="true" >其他流动负债(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="floatdebtall" width="120" headerAlign="center" allowSort="true" >流动负债合计<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="floatdebtall2" width="120" headerAlign="center" allowSort="true" >流动负债合计(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="longdebtall" width="120" headerAlign="center" allowSort="true" >长期负债合计<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="longdebtall2" width="120" headerAlign="center" allowSort="true" >长期负债合计(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="registercapital" width="120" headerAlign="center" allowSort="true" >注册资本<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="registercapital2" width="120" headerAlign="center" allowSort="true" >注册资本(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="realcapital" width="120" headerAlign="center" allowSort="true" >实收资本<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="realcapital2" width="120" headerAlign="center" allowSort="true" >实收资本(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="capitalreserve" width="120" headerAlign="center" allowSort="true" >资本公积<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="capitalreserve2" width="120" headerAlign="center" allowSort="true" >资本公积(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="surplusreserve" width="120" headerAlign="center" allowSort="true" >盈余公积<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="surplusreserve2" width="120" headerAlign="center" allowSort="true" >盈余公积(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="unallotprofit" width="120" headerAlign="center" allowSort="true" >未分配利润<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="unallotprofit2" width="120" headerAlign="center" allowSort="true" >未分配利润(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="totalequity" width="120" headerAlign="center" allowSort="true" >所有者权益合计<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="totalequity2" width="120" headerAlign="center" allowSort="true" >所有者权益合计(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="totalequity1" width="120" headerAlign="center" allowSort="true" >负债和所有者权益合计<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="totalequity12" width="120" headerAlign="center" allowSort="true" >负债和所有者权益合计(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="handingcost" width="120" headerAlign="center" allowSort="true" >管理费用<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="handingcost2" width="120" headerAlign="center" allowSort="true" >管理费用(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="financialcost" width="120" headerAlign="center" allowSort="true" >财务费用<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="financialcost2" width="120" headerAlign="center" allowSort="true" >财务费用(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="interestexpense" width="120" headerAlign="center" allowSort="true" >其中利息支出<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="interestexpense2" width="120" headerAlign="center" allowSort="true" >其中利息支出(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="businessprofit" width="120" headerAlign="center" allowSort="true" >营业利润<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="businessprofit2" width="120" headerAlign="center" allowSort="true" >营业利润(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="investincome" width="120" headerAlign="center" allowSort="true" >投资收益<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="investincome2" width="120" headerAlign="center" allowSort="true" >投资收益(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="subsidyincome" width="120" headerAlign="center" allowSort="true" >国家补贴收入<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="subsidyincome2" width="120" headerAlign="center" allowSort="true" >国家补贴收入(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="unbusinessincome" width="120" headerAlign="center" allowSort="true" >营业外收入<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="unbusinessincome2" width="120" headerAlign="center" allowSort="true" >营业外收入(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="unbusinessexpense" width="120" headerAlign="center" allowSort="true" >营业外支出<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="unbusinessexpense2" width="120" headerAlign="center" allowSort="true" >营业外支出(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="profitloss" width="120" headerAlign="center" allowSort="true" >以前年度损益调整<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="profitloss2" width="120" headerAlign="center" allowSort="true" >以前年度损益调整(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="totalprofit" width="120" headerAlign="center" allowSort="true" >利润总和<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="totalprofit2" width="120" headerAlign="center" allowSort="true" >利润总和(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="payableincometax" width="120" headerAlign="center" allowSort="true" >应交所得税<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="payableincometax2" width="120" headerAlign="center" allowSort="true" >应交所得税(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="payableaddedtax" width="120" headerAlign="center" allowSort="true" >应交增值税<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="payableaddedtax2" width="120" headerAlign="center" allowSort="true" >应交增值税(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="paidaddedtax" width="120" headerAlign="center" allowSort="true" >实交增值税<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="paidaddedtax2" width="120" headerAlign="center" allowSort="true" >实交增值税(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="netprofit" width="120" headerAlign="center" allowSort="true" >利润净额<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	<div field="netprofit2" width="120" headerAlign="center" allowSort="true" >利润净额(期望值)<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
		<div field="recorder" width="120" headerAlign="center" allowSort="true" >记录人</div>
          <div field="recordtime" width="150" headerAlign="center" dateFormat="yyyy-MM-dd HH:mm:ss" allowSort="true">创建时间</div>                
        	<div name="action" width="70" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;"></div>
        </div>
  </div>
<script type="text/javascript">
	mini.parse();
	var grid = mini.get("datagrid1");
	grid.load();
	
	function reset(){
		  var query = new mini.Form("#query");
		  query.clear();
	  }
	  
	  function save() {
		  if(grid.isChanged ( )){
			  var data = grid.getChanges();
		        var json = mini.encode(data);
		        grid.loading("保存中，请稍后......");
		        $.ajax({
		            url: "${pageContext.request.contextPath}/economy/debt/saveCooperationDebt.do",
		            data: { formData: json },
		            type: "post",
		            success: function (text) {
		            	 showTips("保存成功!");
		                grid.reload();
		            },
		            error: function (jqXHR, textStatus, errorThrown) {
		                //alert(jqXHR.responseText);
		                showTips("数据保存失败!");
		                grid.reload();
		            }
		        });
		  }else{
		  }
     }
	  function showTips(msg) {
		  mini.showMessageBox({
			  title:'提示',
			  message: msg,
	            state: 'info',
	            timeout: 2000
	        });
	    }
	  
	  function onSearch() {
		  var cooperationname = mini.get("cooperationname").getValue();
		  var organcode =mini.get("organcode").getValue();
		  var json = {cooperationname:cooperationname,organcode:organcode};
		  var queryStr = JSON.stringify(json);//JSON.parse();
       	  grid.load({
       		 queryStr:queryStr
      	  });
     }
	  function onActionRenderer(e) {
        var record = e.record;
        var debtid = record.debtid;
        var s = '<a class="New_Button" target="_self" href="${pageContext.request.contextPath}/common/viewForm.do?dest=cooperation/cooperationDebtForm&sys_key=debtid&sys_value='+debtid+'">[查看]</a>';      
         s += '<a class="New_Button" target="_self" href="${pageContext.request.contextPath}/common/editForm.do?dest=cooperation/cooperationDebtForm&sys_key=debtid&sys_value='+debtid+'">[编辑]</a>';      
        return s;
    }
	  
	  function remove() {
        var rows = grid.getSelecteds();
        if (rows.length == 1) {
        	 mini.confirm("确定删除选中记录？","删除",function(action){
             	if(action=='ok'){
                var id = rows[0].debtid;
                grid.loading("操作中，请稍后......");
                $.ajax({
                    url: "${pageContext.request.contextPath}/economy/debt/deleteByKey.do?id=" +id,
                    success: function (text) {
                        grid.reload();
                    },
                    error: function () {
                  	  alert("删除失败");
                  	  grid.reload();
                    }
                });
             	}});
        } else {
        		mini.alert("请选择数据后操作!");
        }
    }
	 $("#fixColumn").toggle(
		 function unfixColumns() {
			 $(this).html('<span class="mini-button-text  mini-button-icon icon-lock">锁定</span>');
	           grid.unFrozenColumns();
	      },
	      function fixColumns() {
	    	  $(this).html('<span class="mini-button-text  mini-button-icon icon-unlock">解锁</span>');
	          grid.frozenColumns(0, 3);
	      }	 
	);
	
	 function add(){
		 location.href = "${pageContext.request.contextPath}/common/addForm.do?dest=cooperation/cooperationDebtForm";
		 /*mini.open({
			 url:'${pageContext.request.contextPath}/common/addForm.do?dest=cooperation/cooperationForm',
			 title: "新增", width: 800, height: 500,
	           onload: function () {
	                 
	           },
	           ondestroy: function (action) {
	               grid.reload();
	               tree.reload();
	           }
		 });*/
	 }
	 function edit(cooperationId){
		var rows = grid.getSelecteds();
		if (rows.length == 1) {
			if(typeof cooperationId == 'object'){
				cooperationId = rows[0].debtid;
			}
			 var win =  mini.open({
		           url: '${pageContext.request.contextPath}/common/editForm.do?dest=cooperation/cooperationDebtForm&sys_key=debtid;rightClick&sys_value='+cooperationId+';rightClick',
		           title: "编辑", width: 800, height: 500,
		           onload: function () {
		               
		           },
		           ondestroy: function (action) {
		               grid.reload();
		           }
	       	});
			win.setHeaderCls("bg topmenu zero ");
			win.max();
		} else {
    			mini.alert("请选择数据后操作!");
    		}
	 }
	 
	 function view(cooperationId){
		 mini.open({
           url: '${pageContext.request.contextPath}/common/viewForm.do?dest=cooperation/cooperationForm&sys_key=cooperationId&sys_value='+cooperationId,
           title: "查阅", width: 800, height: 500,
           onload: function () {
               
           },
           ondestroy: function (action) {
               grid.reload();
               tree.reload();
           }
       });
	 }
	 function onBeforeOpen(e) {
		   var menu = e.sender;
		   var row = grid.getSelected();
	        if (row) {
	             //e.cancel = true;
		        e.htmlEvent.preventDefault();
		        //var addItem = mini.getbyName("add", menu);
		        //var removeItem = mini.getbyName("remove", menu);
		        //addItem.show();
		        //removeItem.enable();
	        }
		}
</script>
</body>
</html>