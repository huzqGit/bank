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
<div class="queryPane" style="padding-top:10px;width:100%;height:30px">
<form id="farmer" action="" method="POST">
<table width="100%" height="30px" style="vertical-align:middle;">
	<tr>
		<td width="3%" ></td>
		<td class="labelName" width="11%">
			<font color="red"></font>合作社名称:&nbsp;
		</td>
		<td width="10%" align=center>
			<input id="cooperationname" name="cooperationname" class="bank-text"/>
		</td>
		<td width="3%" ></td>
		<td class="labelName"  width="11%">
			<font color="red"></font>组织机构编码:
		</td>
		<td width="10%">
			<input  id="organcode" name="organcode" class="bank-text"  ></td>
		<td width="5%"></td>
		<td width="10%" align="left">
			<input type="button"  class="bank-btn"value="查询"  onclick="onSearch()">
		</td>
		<td width="10%" align="left">
			<input type="button" class="bank-btn" value="录入"  onclick="add()">
		</td>
	</tr>
</table>
</form>
</div>
<div style="width:100%;position:absolute;top:110px;bottom:0px;left:0px;bottom:0px">
	<div class="mini-fit">
		<div id="datagrid1" class="mini-datagrid" style="width:99%;height:100%;background-color:white" 
	           url="${pageContext.request.contextPath}/economy/debt/loadAllFarmerCooperationDebt.do" idField="debtid"
	            sizeList="[5,10,20,50]" pageSize="20" 
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
			<div name="action" width="70" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;"></div>
	        </div>
	  </div>
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