<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
System.out.println(request.getSession().getAttribute("user"));
%>
<html>
<head>
<title>农民专业合作经济组织基本概况信息</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/miniui/themes/blue/skin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
        scrollbar-base-color:#90D5EA;line-height:120%;font-family:"仿宋_GB2312";font-size:13pt;
}
*{
	margin:0px;
	padding:0px;
	text-decoration:none
}
.mini-toolbar{
	background:url(${pageContext.request.contextPath}/jsp/main/leftmenu/images/icon-bg.jpg) repeat-x center;
}
.mini-grid-headerCell-nowrap{
background:url(${pageContext.request.contextPath}/jsp/main/leftmenu/images/icon-bg.jpg) repeat-x center;
} 
</style>
</head>
<body>
<div class="mini-splitter" style="width:100%;height:100%;">
	<div size="240" showCollapseButton="true">
        <div class="mini-toolbar" style="padding:2px;border-top:0;border-left:0;border-right:0;">                
            <span style="padding-left:5px;">名称：</span>
            <input class="mini-textbox" emptyText="请输入合作社名称" id="cooperationName"/>
            <input type="button" class="bank-btn" value="查询" onclick="search()"/>                 
        </div>
        <!-- url="${pageContext.request.contextPath}/jsp/data/deptTree.txt" -->
        <div class="mini-fit">
            <ul id="tree1" class="mini-tree" 
            url="${pageContext.request.contextPath}/economy/getCooperationTree.do"
            style="width:100%;" showTreeIcon="true" textField="name" idField="id" parentField="pid" resultAsTree="false">    
            </ul>
        </div>
    </div>
    <div showCollapseButton="true">
 	<div class="mini-toolbar" style="padding-top:5px;border-bottom:0;">
        <table style="width:100%;">
       		<tr>
       			<td><a class="mini-button" iconCls="icon-add" plain="true" onclick="add()">新增</a>
            		<span class="separator"></span>
            		<a class="mini-button" iconCls="icon-goto" plain="true" href="/bank/common/viewView.do?dest=cooperation/cooperationImportFile">导入</a>
       			<span class="separator"></span>
       			<a class="mini-button" iconCls="icon-redo" plain="true" onclick="reset()">重置</a>
       			<span class="separator"></span>
       			<a class="mini-button" iconCls="icon-search" plain="true" onclick="onSearch()">查询</a>
       			<span class="separator"></span>
       			<a class="mini-button" iconCls="icon-remove" plain="true" onclick="remove()">删除</a>
       			</td>
       		</tr>
           <tr>
                <td style="white-space:nowrap;">
                <form id="query">
	            	<!-- <span>合作社名称：</span><input id="cooperationName" emptyText="请输入名称" class="mini-textbox" />&nbsp; -->
	            	<span>组织机构编码：</span><input id="orgaCode" emptyText="请输入机构编码" class="mini-textbox" />&nbsp;
	             	<span>创建人：</span><input id="recorder" emptyText="请输入创建人" class="mini-textbox" />&nbsp;
	             	<span>创建时间从：</span><input id="recordTimeBegin" emptyText="请输入时间" class="mini-datepicker" />
	             	<span>到：</span><input id="recordTimeEnd" emptyText="请输入时间" class="mini-datepicker" />
                </form>
                </td>
            </tr>
        </table>
      </div>

  <!--撑满页面-->
  	<div class="mini-fit" >
       <div id="datagrid1" class="mini-datagrid" style="width:100%;height:100%" 
            url="${pageContext.request.contextPath}/economy/loadAllFarmerCooperation.do" idField="cooperationId"
            sizeList="[5,10,20,50]" pageSize="20"allowCellSelect="true" allowCellEdit="true"
            frozenStartColumn="0" frozenEndColumn="1">
            
	        <div property="columns">
	             <div type="indexcolumn" ></div>
	             <div name="action" width="150" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;"></div>
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
	         </div>
  		</div>
  		</div>
  	</div>
</div>
</body>
<script type="text/javascript">
	  mini.parse();
	  var grid = mini.get("datagrid1");
	  var tree = mini.get("tree1");
	  //grid.load();
	  var cname = '';
	  tree.on("nodeselect", function (e) {
          if (e.isLeaf) {
        	    cname = e.node.name;
              grid.load({cooperationName: e.node.id });
          } else {
              //grid.setData([]);
              //grid.setTotalCount(0);
              cname = '';
              grid.load();
              
          }
      });
	  
	  function reset(){
		  var query = new mini.Form("#query");
		  query.clear();
	  }
	  function onSearch() {
		  var cooperationName = mini.get("cooperationName").getValue();
		  var orgaCode =mini.get("orgaCode").getValue();
		  var recorder=mini.get("recorder").getValue();
		  var recordTimeBegin=mini.get("recordTimeBegin").getValue();
		  var recordTimeEnd=mini.get("recordTimeEnd").getValue();
		  recordTimeBegin = mini.formatDate ( recordTimeBegin, 'yyyy-MM-dd' );
		  recordTimeEnd = mini.formatDate ( recordTimeEnd, 'yyyy-MM-dd' );
		  if(cname != '')
			  cooperationName = cname;
         	  grid.load({
        	  	cooperationName : cooperationName,
        	  	orgaCode : orgaCode,
        	 	recorder : recorder,
        	 	recordTimeBegin : recordTimeBegin,
        	 	recordTimeEnd : recordTimeEnd
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
          var s = '<a class="New_Button" href="#" onclick="view('+cooperationId+')">[查看]</a>';      
          s += '<a class="New_Button" href="#" onclick="edit('+cooperationId+')">[编辑]</a>';      
          s += '<a class="New_Button" href="#" onclick="showReport('+cooperationId+')"> [报表展示]</a>';
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
                          tree.reload();
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
	  
	 function showReport(cooperationId) {
          var row = grid.getSelected();
          if (row) {
              mini.open({
                  url: '${pageContext.request.contextPath}/common/viewForm.do?dest=cooperation/cooperationReoprt&sys_key=cooperationId&sys_value='+cooperationId,
                  title: "", width: 800, height: 500,
                  onload: function () {
                      
                  },
                  ondestroy: function (action) {
                      grid.reload();
                      tree.reload();
                  }
              });
          } else {
              alert("请选中一条记录");
          }
      }
   </script>
</html>