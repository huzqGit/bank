<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>农民专业合作经济组织基本概况信息</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<style type="text/css">
*{
margin:0px;
padding:0px;
text-decoration:none
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
 <div class="mini-toolbar" style="padding-top:5px;border-bottom:0;">
        <table style="width:100%;">
       		<tr>
       			<td><a class="mini-button" iconCls="icon-add" plain="true"  target ="_self" href="${pageContext.request.contextPath}/economy/addForm.do?dest=cooperation/cooperationForm">新增</a>
            		<span class="separator"></span>
            		<a class="mini-button" iconCls="icon-goto" plain="true" href="">导入</a>
       			<span class="separator"></span>
       			<a class="mini-button" iconCls="icon-redo" plain="true" onclick="reset()">重置</a>
       			<span class="separator"></span>
       			<a class="mini-button" iconCls="icon-search" plain="true" onclick="onSearch()">查询</a>
       			</td>
       		</tr>
           <tr>
                <td style="white-space:nowrap;">
                <form id="query">
	            	<span>合作社名称：</span><input id="cooperationName" emptyText="请输入名称" class="mini-textbox" />&nbsp;
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
       <div id="datagrid1" class="mini-datagrid" style="width:100%;height:420px" 
            url="${pageContext.request.contextPath}/economy/loadAllFarmerCooperation.do" idField="cooperationId"
            sizeList="[5,10,20,50]" pageSize="20">
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
	             <div field="recordTime" width="120" headerAlign="center" dateFormat="yyyy-MM-dd hh:mm:ss" allowSort="true">创建时间</div>                
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
	  function onSearch() {
		  var companyName = mini.get("companyName").getValue();
		  var organCode =mini.get("organCode").getValue();
		  var  creditCode=mini.get("creditCode").getValue();
		  var recorder=mini.get("recorder").getValue();
		  var recordTimeBegin=mini.get("recordTimeBegin").getValue();
		  var recordTimeEnd=mini.get("recordTimeEnd").getValue();
		  
          grid.load({companyName:companyName,organCode:organCode,creditCode:creditCode,
        	  recorder:recorder,recordTimeBegin:recordTimeBegin,recordTimeEnd:recordTimeEnd});
       }
	  function onActionRenderer(e) {
          var record = e.record;
          var cooperationId = record.cooperationId;
          var s = '<a class="New_Button" target="_self" href="${pageContext.request.contextPath}/economy/viewForm.do?dest=cooperation/cooperationForm&sys_key=cooperationId&sys_value='+cooperationId+'">[查看]</a>';      
           s += '<a class="New_Button" target="_self" href="${pageContext.request.contextPath}/economy/editForm.do?dest=cooperation/cooperationForm&sys_key=cooperationId&sys_value='+cooperationId+'">[编辑]</a>';      
          return s;
      }
   </script>
</body>
</html>