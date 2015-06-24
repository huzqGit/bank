<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/miniui/json2.js" type="text/javascript"></script>
<title>利润及利润分配表</title>
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

.zero {
	height: 1px;
}
.btn {
	background-color: #FFF;
	border: 1px solid #CDCDCD;
	height: 24px;
	width: 70px;
	display: inline-block;
	cursor: hand;
}
</style>
</head>
<body>

<ul id="treeMenu" class="mini-contextmenu"  onbeforeopen="onBeforeOpen">        
     <li name="add" iconCls="icon-add" onclick="add">新增</li>
    	<li class="separator"></li>
    	<li name="remove" iconCls="icon-edit" onclick="edit">编辑</li>
	<li name="remove" iconCls="icon-remove" onclick="remove">删除</li>
</ul>
<div class="queryPane" style="padding-top:10px;width:100%;height:80px">
<form id="farmer" action="" method="POST">
<table width="100%" height="60px" style="vertical-align:middle;">
	<tr>
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
		<td class="labelName" width="11%">
			<font color="red"></font>
		</td>
		<td width="10%" align="left">
			<!-- <input id="cooperationName" name="cooperationName" class="mini-textbox"  emptyText="请输入合作社名称" style="font-size:9pt;"/> -->
		</td>
	</tr>
</table>
</form>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:98%;margin:auto auto;height:340px;background-color:white" 
           url="${pageContext.request.contextPath}/economy/profit/loadAllCooperationProfit.do" idField="profitid"
            sizeList="[5,10,20,50]" pageSize="20" frozenStartColumn="0" frozenEndColumn="1"
            allowCellEdit="true" allowCellSelect="true" multiSelect="false" allowResize="true"
        	  editNextOnEnterKey="true"  editNextRowCell="true"  contextMenu="#treeMenu">
	        <div property="columns">
		          <div type="indexcolumn" ></div>
		          <div field="organcode" width="120" headerAlign="center" allowSort="true" >组织机构编码
		          </div>
		          <div field="yearmonth" width="120" headerAlign="center" allowSort="true" >年月
		          </div>
		          <div field="datasendorgan" width="120" headerAlign="center" allowSort="true" >数据报送机构</div>
				<div field="taxcode" width="120" headerAlign="center" allowSort="true" >税务识别码</div>
				<div field="organtrustcode" width="120" headerAlign="center" allowSort="true" >信用机构代码</div>
				<div field="mainincome" width="120" headerAlign="center" allowSort="true" >主营业务收入</div>
				<div field="mainincome_export" width="120" headerAlign="center" allowSort="true" >主营业务收入出口产品销售收入</div>
				<div field="mainincome_import" width="120" headerAlign="center" allowSort="true" >主营业务收入进口产品销售收入</div>
				<div field="discount" width="120" headerAlign="center" allowSort="true" >折扣与拆让</div>
				<div field="mainincome_netmargin" width="120" headerAlign="center" allowSort="true" >主营业务收入净额</div>
				<div field="maincost" width="120" headerAlign="center" allowSort="true" >主营业务成本</div>
				<div field="maincost_export" width="120" headerAlign="center" allowSort="true" >主营业务成本出口产品销售成本</div>
				<div field="maintaxpay" width="120" headerAlign="center" allowSort="true" >主营业务税金及附加</div>
				<div field="operationcost" width="120" headerAlign="center" allowSort="true" >经营费用</div>
				<div field="othercost" width="120" headerAlign="center" allowSort="true" >其他</div>
				<div field="delayincome" width="120" headerAlign="center" allowSort="true" >递延收益</div>
				<div field="purchasingagent" width="120" headerAlign="center" allowSort="true" >代购代销收入</div>
				<div field="otherpurchasingagent" width="120" headerAlign="center" allowSort="true" >其他</div>
				<div field="mainnetmargin" width="120" headerAlign="center" allowSort="true" >主营业务利润</div>
				<div field="othernetmargin" width="120" headerAlign="center" allowSort="true" >其他业务利润</div>
				<div field="mainexpenses" width="120" headerAlign="center" allowSort="true" >营业费用</div>
				<div field="manageexpense" width="120" headerAlign="center" allowSort="true" >管理费用</div>
				<div field="finaceexpense" width="120" headerAlign="center" allowSort="true" >财务费用</div>
				<div field="otherexpense" width="120" headerAlign="center" allowSort="true" >其他</div>
				<div field="income_netmargin" width="120" headerAlign="center" allowSort="true" >营业利润</div>
				<div field="investincome" width="120" headerAlign="center" allowSort="true" >投资收益</div>
				<div field="futuresincome" width="120" headerAlign="center" allowSort="true" >期货收益</div>
				<div field="subsidyincome" width="120" headerAlign="center" allowSort="true" >补贴收入</div>
				<div field="subsidyincome_before" width="120" headerAlign="center" allowSort="true" >补贴收入补贴前亏损的企业补贴收入</div>
				<div field="income_o" width="120" headerAlign="center" allowSort="true" >营业外收入</div>
				<div field="income_o_netmargin" width="120" headerAlign="center" allowSort="true" >营业外收入处置固定资产净收益</div>
				<div field="income_o_nonemoney" width="120" headerAlign="center" allowSort="true" >营业外收入非货币性交易收益</div>
				<div field="income_o_wxzc" width="120" headerAlign="center" allowSort="true" >营业外收入出售无形资产收益</div>
				<div field="income_o_fk" width="120" headerAlign="center" allowSort="true" >营业外收入罚款净收入</div>
				<div field="income_o_other" width="120" headerAlign="center" allowSort="true" >其他</div>
				<div field="income_o_othersalary" width="120" headerAlign="center" allowSort="true" >其他用以前年度含量工资节余弥补利润</div>
				<div field="outcome_o" width="120" headerAlign="center" allowSort="true" >营业外支出</div>
				<div field="outcome_o_netmargin" width="120" headerAlign="center" allowSort="true" >营业外支出处置固定资产净损失</div>
				<div field="outcome_o_zwcz" width="120" headerAlign="center" allowSort="true" >营业外支出债务重组损失</div>
				<div field="outcome_o_fk" width="120" headerAlign="center" allowSort="true" >营业外支出罚款支出</div>
				<div field="outcome_o_jz" width="120" headerAlign="center" allowSort="true" >营业外支出捐赠支出</div>
				<div field="outcome_o_other" width="120" headerAlign="center" allowSort="true" >其他支出</div>
				<div field="outcome_o_othersalary" width="120" headerAlign="center" allowSort="true" >其他支出结转的含量工资包干节余</div>
				<div field="allprofit" width="120" headerAlign="center" allowSort="true" >利润总额</div>
				<div field="incomdetax" width="120" headerAlign="center" allowSort="true" >所得税</div>
				<div field="fewpartnerincome" width="120" headerAlign="center" allowSort="true" >少数股东损益</div>
				<div field="unsureloss" width="120" headerAlign="center" allowSort="true" >未确认的投资损失</div>
				<div field="netmargin" width="120" headerAlign="center" allowSort="true" >净利润</div>
				<div field="beginofyearundistributed" width="120" headerAlign="center" allowSort="true" >年初未分配利润</div>
				<div field="yygjbk" width="120" headerAlign="center" allowSort="true" >盈余公积补亏</div>
				<div field="qttzys" width="120" headerAlign="center" allowSort="true" >其他调整因素</div>
				<div field="kgfpll" width="120" headerAlign="center" allowSort="true" >可供分配的利润</div>
				<div field="dxlyll" width="120" headerAlign="center" allowSort="true" >单项留用的利润</div>
				<div field="bcldzb" width="120" headerAlign="center" allowSort="true" >补充流动资本</div>
				<div field="tqfdyygj" width="120" headerAlign="center" allowSort="true" >提取法定盈余公积</div>
				<div field="tqfdyygyj" width="120" headerAlign="center" allowSort="true" >提取法定公益金</div>
				<div field="tqzgjljfldy" width="120" headerAlign="center" allowSort="true" >提取职工奖励及福利基金</div>
				<div field="tqcbj" width="120" headerAlign="center" allowSort="true" >提取储备基金</div>
				<div field="tqqyfzjj" width="120" headerAlign="center" allowSort="true" >提取企业发展基金</div>
				<div field="llghtz" width="120" headerAlign="center" allowSort="true" >利润归还投资</div>
				<div field="llghtzother" width="120" headerAlign="center" allowSort="true" >其他</div>
				<div field="kgtzzffll" width="120" headerAlign="center" allowSort="true" >可供投资者分配的利润</div>
				<div field="yfyxggl" width="120" headerAlign="center" allowSort="true" >应付优先股股利</div>
				<div field="tqryyygj" width="120" headerAlign="center" allowSort="true" >提取任意盈余公积</div>
				<div field="yfptggl" width="120" headerAlign="center" allowSort="true" >应付普通股股利</div>
				<div field="zzzbptggl" width="120" headerAlign="center" allowSort="true" >转作资本的普通股股利</div>
				<div field="zzzbptgglother" width="120" headerAlign="center" allowSort="true" >其他</div>
				<div field="zzzbptgglundisbute" width="120" headerAlign="center" allowSort="true" >未分配利润</div>
				<div field="zzzbptgglundisbute_before" width="120" headerAlign="center" allowSort="true" >未分配利润应由以后年度税前利润弥补的亏损</div>
				<div field="recoder" width="120" headerAlign="center" allowSort="true" >记录人</div>
				<div field="recodertime" width="150" headerAlign="center" allowSort="true" dateFormat="yyyy-MM-dd HH:mm:ss">记录时间</div>
				<div name="action" width="150" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;"></div>
	         </div>
     </div>
<script type="text/javascript">
	mini.parse();
	var grid = mini.get("datagrid1");
	grid.loading("数据加载中...");
	grid.load();
	
	function reset(){
		  var query = new mini.Form("#query");
		  query.clear();
	  }
    function onSearch() {
		  var organcode =mini.get("organcode").getValue();
		  var json = {organcode:organcode};
		  var queryStr = JSON.stringify(json);//JSON.parse();
       	  grid.load({
       		 queryStr:queryStr
      	  });
     }
	function save() {
          var data = grid.getChanges();
          var json = mini.encode(data);
          grid.loading("保存中，请稍后......");
          $.ajax({
              url: "${pageContext.request.contextPath}/economy/profit/saveCooperationProfit.do",
              data: { formData: json },
              type: "post",
              success: function (text) {
                  grid.reload();
              },
              error: function (jqXHR, textStatus, errorThrown) {
                  //alert(jqXHR.responseText);
                  mini.alert('保存失败');
                  grid.reload();
              }
          });
      }
	  
	  function onActionRenderer(e) {
        var record = e.record;
        var cooperationId = record.profitid;
        var s = '<a class="New_Button" href="${pageContext.request.contextPath}/common/viewForm.do?dest=cooperation/cooperationProfitForm&sys_key=profitid&sys_value='+cooperationId+'">[查看]</a>';      
        s += '<a class="New_Button" href="${pageContext.request.contextPath}/common/editForm.do?dest=cooperation/cooperationProfitForm&sys_key=profitid&sys_value='+cooperationId+'">[编辑]</a>';      
        return s;
    }
	  
	  function remove() {
        var rows = grid.getSelecteds();
        if (rows.length == 1) {
        	 mini.confirm("确定删除选中记录？","删除",function(action){
              	if(action=='ok'){
                var id = rows[0].profitid;
                grid.loading("操作中，请稍后......");
                $.ajax({
                    url: "${pageContext.request.contextPath}/economy/profit/deleteByKey.do?id=" +id,
                    success: function (text) {
                        grid.reload();
                    },
                    error: function () {
                  	  mini.alert("删除失败");
                  	  grid.reload();
                    }
                });
              	}});
        } else {
        		mini.alert("请选择数据后操作!");
        }
    }
	  
	 function add(){
		var win =  mini.open({
			 url:'${pageContext.request.contextPath}/common/addForm.do?dest=cooperation/cooperationProfitForm&sys_key=rightClick&sys_value=rightClick',
			 title: "新增", width: 800, height: 500,
	           onload: function () {
	                 
	           },
	           ondestroy: function (action) {
	               grid.reload();
	           }
		 });
		win.setHeaderCls("bg topmenu zero ");
		win.max();
	 }
	 
	 function showReport(cooperationId){
		var rows = grid.getSelecteds();
		if (rows.length == 1) {
			if(typeof cooperationId == 'object'){
				cooperationId = rows[0].profitid;
			}
			var win =  mini.open({
	           url: '${pageContext.request.contextPath}/common/viewForm.do?dest=cooperation/cooperationReoprt&sys_key=cooperationId;rightClick&sys_value='+cooperationId+';rightClick',
	           title: "", width: 800, height: 500,
	           onload: function () {
	               
	           },
	           ondestroy: function (action) {
	               //grid.reload();
	           }
	         });
			win.setHeaderCls("bg topmenu");
			win.max();
		}
	}
	 
	 function edit(cooperationId){
		var rows = grid.getSelecteds();
		if(rows.length == 1){
			if(typeof cooperationId == 'object'){
				cooperationId = rows[0].profitid;
			}
			var win =  mini.open({
	           url: '${pageContext.request.contextPath}/common/editForm.do?dest=cooperation/cooperationProfitForm&sys_key=profitid;rightClick&sys_value='+cooperationId+';rightClick',
	           title: "编辑", width: 800, height: 500,
	           onload: function () {
	               
	           },
	           ondestroy: function (action){
	               grid.reload();
	               
	           }
	         });
			win.setHeaderCls("bg topmenu zero");
			win.max();
		}else{
			mini.alert("请选择数据后操作!");
		}
		
	 }
	  
	
 	function onBeforeOpen(e) {
	   var menu = e.sender;
	   var row = grid.getSelected();
        if (row) {
	        e.htmlEvent.preventDefault();
        }
	}
</script>
</body>
</html>