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
<title>经济合作组织基本信息</title>
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


.bg {
	background: url(images/toolbar/toolbar.png) #e7eaee repeat-x 0px 0px
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
    	<li name="remove" iconCls="icon-edit" onclick="edit">编辑</li>
	<li name="remove" iconCls="icon-remove" onclick="remove">删除</li>
</ul>
<div class="queryPane">
<form id="farmer" action="" method="POST">
<table width="100%" height="30px" style="vertical-align:middle;">
	<tr>
		<td  width="3%"align="left" >
		</td>
		<td class="labelName" width="11%">
			<font color="red"></font>合作社名称:
		</td>
		<td width="10%" align="left">
			<input id="cooperationName" name="cooperationName" type="text" class="bank-text"  emptyText="请输入合作社名称" />
		</td>
		<td width="3%" ></td>
		<td class="labelName"  width="11%">
			<font color="red"></font>组织机构编码:
		</td>
		<td width="10%">
			<input  id="orgaCode" name="orgaCode" type="text" class="bank-text" ></td>
		<td width="5%"></td>
		<td width="10%" align="left">
			<input type="button" class="bank-btn" value="查询"  onclick="onSearch()"/>
		<td width="10%" align="left">
			<input type="button" class="bank-btn" value="录入"  onclick="add()" >
		</td>
	</tr>
</table>
</form>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:99%;margin:auto auto;height:340px;background-color:white;" 
           url="${pageContext.request.contextPath}/economy/loadAllFarmerCooperation.do" idField="cooperationId"
            sizeList="[5,10,20,50]" pageSize="20"allowCellSelect="true" allowCellEdit="true"
          contextMenu="#treeMenu">
	        <div property="columns">
	             <div type="indexcolumn" ></div>
	             <div field=cooperationName width="120" headerAlign="center" allowSort="true" >合作社名称</div>
	             <div field="orgaCode" width="120" headerAlign="center" allowSort="true"  >组织机构编码</div>
	             <div field="taxCode" width="120" headerAlign="center" allowSort="true" >税务登记号</div>
	             <div field="registerDate" width="120" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true" >注册日期</div>    
	             <div field="registerAddress" width="120" headerAlign="center" allowSort="true">注册地址</div>                            
	             <div field="mailAddress" width="120" headerAlign="center" allowSort="true">通信地址</div>                            
	             <div field="registerCapital" width="100" align="center" headerAlign="center" allowSort="true" >注册资金</div>
	             <div field="realCapital" width="100" align="center" headerAlign="center" allowSort="true" >实收资金</div>
	             <div name="action" width="150" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;"></div> 
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
	  function onSearch() {
		  var cooperationName = $("#cooperationName").val();
		  var orgaCode =$("#orgaCode").val();
       	  grid.load({
      	  	cooperationName : cooperationName,
      	  	orgaCode : orgaCode
      	  });
     }
	  function search() {
		  var cooperationName = mini.get("cooperationName").getValue();
       	  tree.load({
      	  	cooperationName : cooperationName
      	  });
     }
	  
	  function onActionRenderer(e) {
        var record = e.record;
        var cooperationId = record.cooperationId;
        var s = '<a class="New_Button" href="${pageContext.request.contextPath}/common/viewForm.do?dest=cooperation/cooperationForm&sys_key=cooperationId&sys_value='+cooperationId+'">[查看]</a>';      
        s += '<a class="New_Button" href="${pageContext.request.contextPath}/common/editForm.do?dest=cooperation/cooperationForm&sys_key=cooperationId&sys_value='+cooperationId+'">[编辑]</a>';      
        s += '<a class="New_Button" href="javascript:void(0)" onclick="showReport('+cooperationId+')"> [报表展示]</a>';
        return s;
    }
	  
	  function remove() {
        var rows = grid.getSelecteds();
        if (rows.length == 1) {
            mini.confirm("确定删除选中记录？","删除",function(action){
            	if(action=='ok'){
            		var id = rows[0].cooperationId;
                    grid.loading("操作中，请稍后......");
                    $.ajax({
                        url: "${pageContext.request.contextPath}/economy/deleteByKey.do?id=" +id,
                        success: function (text) {
                            grid.reload();
                        },
                        error: function () {
                      	  mini.alert("删除失败");
                      	  grid.reload();
                        }
                    });
            	}
            });
        } else {
        		mini.alert("请选择数据后操作!");
        }
    }
	  
	 function add(){
		var win =  mini.open({
			 url:'${pageContext.request.contextPath}/common/addForm.do?dest=cooperation/cooperationForm&sys_key=rightClick&sys_value=rightClick',
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
				cooperationId = rows[0].cooperationId;
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
		}else{
			mini.alert("请选择数据后操作!");
		}
	}
	 
	 function edit(cooperationId){
		var rows = grid.getSelecteds();
		if (rows.length == 1) {
			if(typeof cooperationId == 'object'){
				cooperationId = rows[0].cooperationId;
			}
			var win =  mini.open({
	           url: '${pageContext.request.contextPath}/common/editForm.do?dest=cooperation/cooperationForm&sys_key=cooperationId;rightClick&sys_value='+cooperationId+';rightClick',
	           title: "编辑", width: 800, height: 500,
	           onload: function () {
	               
	           },
	           ondestroy: function (action) {
	               grid.reload();
	               
	           }
	         });
			win.setHeaderCls("bg topmenu zero");
			win.max();
	 	}else{
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