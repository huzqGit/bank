<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
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
<div class="queryPane" style="padding-top:10px;width:100%;height:30px">
<form id="farmer" action="" method="POST">
<table width="100%" height="30px" style="vertical-align:middle;">
	<tr>
		<td width="3%" ></td>
		<td class="labelName"  width="11%">
			组织机构编码:
		</td>
		<td width="10%">
			<input  id="organcode" name="organcode" class="bank-text" ></td>
		<td width="5%"></td>
		<td width="10%" align="left">
			<input type="button" class="bank-btn" onclick="onSearch()" value="查询">
		</td>
		<td width="10%" align="left">
			<input type="button" class="bank-btn"  onclick="add()" value="录入">
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
            sizeList="[5,10,20,50]" pageSize="20" 
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
		  var organcode =$("#organcode").val();
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