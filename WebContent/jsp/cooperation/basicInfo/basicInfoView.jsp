<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/miniui/json2.js" type="text/javascript"></script>
<title>经济合作组织基本信息</title>
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
.labelName{font-family:"仿宋_GB2312";font-size:14pt;line-height:150%;font-weight:bold;color:darkgreen;}
input{border:1px solid #8AD3E9;background-color:#F5F7CF;height:20px;}
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
.bg{
	background:url(images/toolbar/toolbar.png) #e7eaee repeat-x 0px 0px
}
.topmenu{
	width:100%;
	height:30px;
	background:linear-gradient(#6DC8E3,white);
	/* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
	endColorstr = 'white' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
	endColorstr = 'white' )"; 
}
.zero{
	height:1px;
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
		<td  width="3%"align="left" >
		</td>
		<td class="labelName" width="11%">
			<font color="red"></font>合作社名称:
		</td>
		<td width="10%" align="left">
			<input id="cooperationName" name="cooperationName" class="mini-textbox"  emptyText="请输入合作社名称" style="font-size:9pt;"/>
		</td>
		<td width="3%" ></td>
		<td class="labelName"  width="11%">
			<font color="red"></font>组织机构编码:
		</td>
		<td width="10%">
			<input  id="orgaCode" name="orgaCode" class="mini-textbox"  emptyText="请输入机构编码" style="font-size:9pt"></td>
		<td width="5%"></td>
		<td width="10%" align="left">
			<input type="button" value=""  onclick="onSearch()"style="width:100px;height:25px;border:0;background:url(/bank/images/query.png) no-repeat">
		</td>
		<td width="10%" align="left">
			<input type="button" value=""  onclick="add()" style="width:100px;height:25px;border:0;background:url(/bank/images/LuRu.png) no-repeat">
		</td>
	</tr>
</table>
</form>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:98%;margin:auto auto;height:340px;background-color:white" 
           url="${pageContext.request.contextPath}/economy/loadAllFarmerCooperation.do" idField="cooperationId"
            sizeList="[5,10,20,50]" pageSize="20"allowCellSelect="true" allowCellEdit="true"
            frozenStartColumn="0" frozenEndColumn="1" contextMenu="#treeMenu">
	        <div property="columns">
	             <div type="indexcolumn" ></div>
	             <div field=cooperationName width="120" headerAlign="center" allowSort="true" >合作社名称</div>
	             <div field="orgaCode" width="120" headerAlign="center" allowSort="true"  >组织机构编码</div>
	             <div field="taxCode" width="120" headerAlign="center" allowSort="true" >税务登记号</div>
	             <div field="registerDate" width="120" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true" >注册日期</div>    
	             <div field="registerAddress" width="120" headerAlign="center" allowSort="true">注册地址</div>                            
	             <div field="mailAddress" width="120" headerAlign="center" allowSort="true">通信地址</div>                            
	             <div field="registerCapital" width="100" align="center" headerAlign="center">注册资金</div>
	             <div field="realCapital" width="100" align="center" headerAlign="center">实收资金</div>
	             <div field="recorder" width="100" align="center" headerAlign="center">创建人</div>
	             <div field="recordTime" width="130" headerAlign="center" dateFormat="yyyy-MM-dd hh:mm:ss" allowSort="true">创建时间</div>
	             <div name="action" width="150" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;"></div> 
	          </div>
  </div>
<!-- 
<div id="win1" class="mini-window" title="Window" style="width:400px;height:250px;" 
    showMaxButton="true" showCollapseButton="true" showShadow="true"
    showToolbar="true" showFooter="true" showModal="false" allowResize="true" allowDrag="true">
    <div property="toolbar" style="padding:5px;">
        <input type='button' value='Hide' onclick="hideWindow()" style='vertical-align:middle;'/>
    </div>
    <div property="footer" style="text-align:right;padding:5px;padding-right:15px;">
        <input type='button' value='Hide' onclick="hideWindow()" style='vertical-align:middle;'/>
    </div>
</div>
mini.get("win1").show();
 -->
<script type="text/javascript">
	mini.parse();
	var grid = mini.get("datagrid1");
	grid.load();
	
	function reset(){
		  var query = new mini.Form("#query");
		  query.clear();
	  }
	  function onSearch() {
		  var cooperationName = mini.get("cooperationName").getValue();
		  var orgaCode =mini.get("orgaCode").getValue();
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
            if (confirm("确定删除选中记录？")) {
                var id = rows[0].cooperationId;
                grid.loading("操作中，请稍后......");
                $.ajax({
                    url: "${pageContext.request.contextPath}/economy/deleteByKey.do?id=" +id,
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
	}
	 
	 function edit(cooperationId){
		var rows = grid.getSelecteds();
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