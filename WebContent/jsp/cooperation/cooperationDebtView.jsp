<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>农民专业合作经济组织主要财务指标数</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/miniui/json2.js" type="text/javascript"></script>
<script type="text/javascript">
var winHeight = 760;
if (window.innerHeight) 
	winHeight = window.innerHeight; 
else if ((document.body) && (document.body.clientHeight)) 
	winHeight = document.body.clientHeight;
//通过深入 Document 内部对 body 进行检测，获取窗口大小 
if (document.documentElement && document.documentElement.clientHeight){ 
	winHeight = document.documentElement.clientHeight; 
}

//alert(winHeight);
</script>
<style type="text/css">
body{
	scrollbar-base-color:#90D5EA;
	line-height:100%;
	font-family:"仿宋_GB2312";
	overfolw:hidden;
	font-size:13pt;
}
*{
	margin:0px;
	padding:0px;
	text-decoration:none;
}
.mini-toolbar{
	background:url(/bank/jsp/main/leftmenu/images/icon-bg.jpg) repeat-x center;
}
.mini-grid-headerCell-nowrap{
	background:url(/bank/jsp/main/leftmenu/images/icon-bg.jpg) repeat-x center;
} 
</style>
</head>
<body>
<div size="60px" showCollapseButton="true">
 <div class="mini-toolbar" style="padding-top:5px;border-bottom:0;">
        <table style="width:100%;">
       		<tr>
       			<td><a class="mini-button" iconCls="icon-add" plain="true"  target ="_self" href="${pageContext.request.contextPath}/common/addForm.do?dest=cooperation/cooperationDebtForm">新增</a>
            		<span class="separator"></span>
            		<a class="mini-button" iconCls="icon-goto" plain="true" href="/bank/common/viewView.do?dest=cooperation/cooperationDebtImportFile">导入</a>
       			<span class="separator"></span>
       			<a class="mini-button" iconCls="icon-redo" plain="true" onclick="reset()">重置</a>
       			<span class="separator"></span>
       			<a class="mini-button" iconCls="icon-search" plain="true" onclick="onSearch()">查询</a>
       			<span class="separator"></span>
       			<a class="mini-button" iconCls="icon-remove" plain="true" onclick="remove()">删除</a>
       			<span class="separator"></span>
       			<a class="mini-button" iconCls="icon-save" plain="true" onclick="save()" >保存</a>
       			<span class="separator"></span>
       			<a class="mini-button" iconCls="icon-unlock" plain="true" id="fixColumn">解锁</a>
       			</td>
       		</tr>
           <tr>
                <td style="white-space:nowrap;">
	                <form id="query" action="" class="queryPane" method="post">
		            	<span>合作社名称：</span><input id="cooperationname" name="cooperationname" emptyText="请输入名称" class="mini-textbox" />&nbsp;
		            	<span>组织机构编码：</span><input id="organcode" name="organcode" emptyText="请输入机构编码" class="mini-textbox" />&nbsp;
		             	<span>创建人：</span><input id="recorder" name="recorder" emptyText="请输入创建人" class="mini-textbox" />&nbsp;
		             	<span>创建时间从：</span><input id="recordTimeBegin" name="recordTimeBegin" emptyText="请输入时间" class="mini-datepicker" />
		             	<span>到：</span><input id="recordTimeEnd" name="recordTimeEnd" emptyText="请输入时间" class="mini-datepicker" />
	                </form>
                </td>
            </tr>
        </table>
  </div>
  </div>
<div style="width:100%;position:absolute;top:110px;bottom:0px;left:0px;bottom:0px">
<div class="mini-fit">
  <div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%" 
            url="${pageContext.request.contextPath}/economy/debt/loadAllFarmerCooperationDebt.do" idField="debtid"
            sizeList="[5,10,20,50]" pageSize="20" frozenStartColumn="0" frozenEndColumn="3"
            allowCellEdit="true" allowCellSelect="true" multiSelect="true" allowResize="true"
        	  editNextOnEnterKey="true"  editNextRowCell="true">
	        <div property="columns">
		          <div type="indexcolumn" ></div>
		          <div name="action" width="70" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;"></div>
		          <div field="cooperationname" width="120" headerAlign="center" allowSort="true" >合作组织名称
		          </div>
		          <div field="organcode" width="120" headerAlign="center" allowSort="true" >组织机构编码
		          </div>
		          <div field="yearmonth" width="120" headerAlign="center" allowSort="true" >年月
		          	<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
		          </div>
		          <div field="cashcapital" width="120" headerAlign="center" allowSort="true" >货币资金</div>	<div field="cashcapital2" width="120" headerAlign="center" allowSort="true" >货币资金(期望值)</div>
				<div field="shortinvest" width="120" headerAlign="center" allowSort="true" >短期投资</div>	<div field="shortinvest2" width="120" headerAlign="center" allowSort="true" >短期投资(期望值)</div>
				<div field="receivables" width="120" headerAlign="center" allowSort="true" >应收账款净额</div>	<div field="receivables2" width="120" headerAlign="center" allowSort="true" >应收账款净额(期望值)</div>
				<div field="prepayment" width="120" headerAlign="center" allowSort="true" >预付账款</div>	<div field="prepayment2" width="120" headerAlign="center" allowSort="true" >预付账款(期望值)</div>
				<div field="inventory" width="120" headerAlign="center" allowSort="true" >存货</div>	<div field="inventory2" width="120" headerAlign="center" allowSort="true" >存货(期望值)</div>
				<div field="floatasset" width="120" headerAlign="center" allowSort="true" >其他流动资产</div>	<div field="floatasset2" width="120" headerAlign="center" allowSort="true" >其他流动资产(期望值)</div>
				<div field="floatassetall" width="120" headerAlign="center" allowSort="true" >流动资产合计</div>	<div field="floatassetall2" width="120" headerAlign="center" allowSort="true" >流动资产合计(期望值)</div>
				<div field="fixedasset" width="120" headerAlign="center" allowSort="true" >固定资产原价</div>	<div field="fixedasset2" width="120" headerAlign="center" allowSort="true" >固定资产原价(期望值)</div>
				<div field="deprecication" width="120" headerAlign="center" allowSort="true" >其中折旧</div>	<div field="deprecication2" width="120" headerAlign="center" allowSort="true" >其中折旧(期望值)</div>
				<div field="netvalue" width="120" headerAlign="center" allowSort="true" >固定资产净值</div>	<div field="netvalue2" width="120" headerAlign="center" allowSort="true" >固定资产净值(期望值)</div>
				<div field="buildingproject" width="120" headerAlign="center" allowSort="true" >在建项目</div>	<div field="buildingproject2" width="120" headerAlign="center" allowSort="true" >在建项目(期望值)</div>
				<div field="fixedassetall" width="120" headerAlign="center" allowSort="true" >固定资产合计</div>	<div field="fixedassetall2" width="120" headerAlign="center" allowSort="true" >固定资产合计(期望值)</div>
				<div field="invisibleasset" width="120" headerAlign="center" allowSort="true" >无形及递延资产合计</div>	<div field="invisibleasset2" width="120" headerAlign="center" allowSort="true" >无形及递延资产合计(期望值)</div>
				<div field="assetall" width="120" headerAlign="center" allowSort="true" >资产合计</div>	<div field="assetall2" width="120" headerAlign="center" allowSort="true" >资产合计(期望值)</div>
				<div field="shortloan" width="120" headerAlign="center" allowSort="true" >短期借款</div>	<div field="shortloan2" width="120" headerAlign="center" allowSort="true" >短期借款(期望值)</div>
				<div field="bankloan" width="120" headerAlign="center" allowSort="true" >银行借款</div>	<div field="bankloan2" width="120" headerAlign="center" allowSort="true" >银行借款(期望值)</div>
				<div field="accountspayable" width="120" headerAlign="center" allowSort="true" >应付账款</div>	<div field="accountspayable2" width="120" headerAlign="center" allowSort="true" >应付账款(期望值)</div>
				<div field="depositreceived" width="120" headerAlign="center" allowSort="true" >预收账款</div>	<div field="depositreceived2" width="120" headerAlign="center" allowSort="true" >预收账款(期望值)</div>
				<div field="unpaidtax" width="120" headerAlign="center" allowSort="true" >未缴税金</div>	<div field="unpaidtax2" width="120" headerAlign="center" allowSort="true" >未缴税金(期望值)</div>
				<div field="floatdebt" width="120" headerAlign="center" allowSort="true" >其他流动负债</div>	<div field="floatdebt2" width="120" headerAlign="center" allowSort="true" >其他流动负债(期望值)</div>
				<div field="floatdebtall" width="120" headerAlign="center" allowSort="true" >流动负债合计</div>	<div field="floatdebtall2" width="120" headerAlign="center" allowSort="true" >流动负债合计(期望值)</div>
				<div field="longdebtall" width="120" headerAlign="center" allowSort="true" >长期负债合计</div>	<div field="longdebtall2" width="120" headerAlign="center" allowSort="true" >长期负债合计(期望值)</div>
				<div field="registercapital" width="120" headerAlign="center" allowSort="true" >注册资本</div>	<div field="registercapital2" width="120" headerAlign="center" allowSort="true" >注册资本(期望值)</div>
				<div field="realcapital" width="120" headerAlign="center" allowSort="true" >实收资本</div>	<div field="realcapital2" width="120" headerAlign="center" allowSort="true" >实收资本(期望值)</div>
				<div field="capitalreserve" width="120" headerAlign="center" allowSort="true" >资本公积</div>	<div field="capitalreserve2" width="120" headerAlign="center" allowSort="true" >资本公积(期望值)</div>
				<div field="surplusreserve" width="120" headerAlign="center" allowSort="true" >盈余公积</div>	<div field="surplusreserve2" width="120" headerAlign="center" allowSort="true" >盈余公积(期望值)</div>
				<div field="unallotprofit" width="120" headerAlign="center" allowSort="true" >未分配利润</div>	<div field="unallotprofit2" width="120" headerAlign="center" allowSort="true" >未分配利润(期望值)</div>
				<div field="totalequity" width="120" headerAlign="center" allowSort="true" >所有者权益合计</div>	<div field="totalequity2" width="120" headerAlign="center" allowSort="true" >所有者权益合计(期望值)</div>
				<div field="totalequity1" width="120" headerAlign="center" allowSort="true" >负债和所有者权益合计</div>	<div field="totalequity12" width="120" headerAlign="center" allowSort="true" >负债和所有者权益合计(期望值)</div>
				<div field="handingcost" width="120" headerAlign="center" allowSort="true" >管理费用</div>	<div field="handingcost2" width="120" headerAlign="center" allowSort="true" >管理费用(期望值)</div>
				<div field="financialcost" width="120" headerAlign="center" allowSort="true" >财务费用</div>	<div field="financialcost2" width="120" headerAlign="center" allowSort="true" >财务费用(期望值)</div>
				<div field="interestexpense" width="120" headerAlign="center" allowSort="true" >其中利息支出</div>	<div field="interestexpense2" width="120" headerAlign="center" allowSort="true" >其中利息支出(期望值)</div>
				<div field="businessprofit" width="120" headerAlign="center" allowSort="true" >营业利润</div>	<div field="businessprofit2" width="120" headerAlign="center" allowSort="true" >营业利润(期望值)</div>
				<div field="investincome" width="120" headerAlign="center" allowSort="true" >投资收益</div>	<div field="investincome2" width="120" headerAlign="center" allowSort="true" >投资收益(期望值)</div>
				<div field="subsidyincome" width="120" headerAlign="center" allowSort="true" >国家补贴收入</div>	<div field="subsidyincome2" width="120" headerAlign="center" allowSort="true" >国家补贴收入(期望值)</div>
				<div field="unbusinessincome" width="120" headerAlign="center" allowSort="true" >营业外收入</div>	<div field="unbusinessincome2" width="120" headerAlign="center" allowSort="true" >营业外收入(期望值)</div>
				<div field="unbusinessexpense" width="120" headerAlign="center" allowSort="true" >营业外支出</div>	<div field="unbusinessexpense2" width="120" headerAlign="center" allowSort="true" >营业外支出(期望值)</div>
				<div field="profitloss" width="120" headerAlign="center" allowSort="true" >以前年度损益调整</div>	<div field="profitloss2" width="120" headerAlign="center" allowSort="true" >以前年度损益调整(期望值)</div>
				<div field="totalprofit" width="120" headerAlign="center" allowSort="true" >利润总和</div>	<div field="totalprofit2" width="120" headerAlign="center" allowSort="true" >利润总和(期望值)</div>
				<div field="payableincometax" width="120" headerAlign="center" allowSort="true" >应交所得税</div>	<div field="payableincometax2" width="120" headerAlign="center" allowSort="true" >应交所得税(期望值)</div>
				<div field="payableaddedtax" width="120" headerAlign="center" allowSort="true" >应交增值税</div>	<div field="payableaddedtax2" width="120" headerAlign="center" allowSort="true" >应交增值税(期望值)</div>
				<div field="paidaddedtax" width="120" headerAlign="center" allowSort="true" >实交增值税</div>	<div field="paidaddedtax2" width="120" headerAlign="center" allowSort="true" >实交增值税(期望值)</div>
				<div field="netprofit" width="120" headerAlign="center" allowSort="true" >利润净额</div>	<div field="netprofit2" width="120" headerAlign="center" allowSort="true" >利润净额(期望值)</div>
				<div field="recorder" width="120" headerAlign="center" allowSort="true" >记录人</div>
	               <div field="recordtime" width="150" headerAlign="center" dateFormat="yyyy-MM-dd hh:mm:ss" allowSort="true">创建时间</div>                
	         </div>
	     </div>
	</div>
</div>
   <script type="text/javascript">
   	 $("#sph").css("height",winHeight);
   	 $("#datagrid1").css("height",winHeight-60-5);
   	
	  mini.parse();
	  var grid = mini.get("datagrid1");
	  grid.load();
	  
	  function reset(){
		  var query = new mini.Form("#query");
		  query.clear();
	  }
	  
	  function save() {
          var data = grid.getChanges();
          var json = mini.encode(data);
          grid.loading("保存中，请稍后......");
          $.ajax({
              url: "${pageContext.request.contextPath}/economy/debt/saveCooperationDebt.do",
              data: { formData: json },
              type: "post",
              success: function (text) {
                  grid.reload();
              },
              error: function (jqXHR, textStatus, errorThrown) {
                  //alert(jqXHR.responseText);
                  alert('保存失败');
                  grid.reload();
              }
          });
      }
	  
	  function onSearch() {
		  var cooperationname = mini.get("cooperationname").getValue();
		  var organcode =mini.get("organcode").getValue();
		  var recorder=mini.get("recorder").getValue();
		  var recordTimeBegin=mini.get("recordTimeBegin").getValue();
		  var recordTimeEnd=mini.get("recordTimeEnd").getValue();
		  recordTimeBegin = mini.formatDate ( recordTimeBegin, 'yyyy-MM-dd' );
		  recordTimeEnd = mini.formatDate ( recordTimeEnd, 'yyyy-MM-dd' );
		  var json = {cooperationname:cooperationname,organcode:organcode,recorder:recorder,recordTimeBegin:recordTimeBegin,recordTimeEnd:recordTimeEnd};
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
              if (confirm("确定删除选中记录？")) {
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
              }
          } else {
              alert("请选中一条记录");
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
		 mini.open({
			 url:'${pageContext.request.contextPath}/common/addForm.do?dest=cooperation/cooperationForm&sys_key=cname&sys_value='+cname,
			 title: "编辑", width: 800, height: 500,
	           onload: function () {
	                 
	           },
	           ondestroy: function (action) {
	               grid.reload();
	               tree.reload();
	           }
		 });
	 }
	 function edit(cooperationId){
		 mini.open({
             url: '${pageContext.request.contextPath}/common/editForm.do?dest=cooperation/cooperationForm&sys_key=cooperationId&sys_value='+cooperationId,
             title: "编辑", width: 800, height: 500,
             onload: function () {
                 
             },
             ondestroy: function (action) {
                 grid.reload();
                 tree.reload();
             }
         });
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

   </script>
</body>
</html>