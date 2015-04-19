<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<title>Insert title here</title>
<style type="text/css">
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
       			<td>
       			<a class="mini-button" iconCls="icon-add" plain="true"  target ="_self" href="/bank/jsp/company/companyEmployeeForm.jsp">新增</a>
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
	            	<span>企业名称：</span><input id="companyName" emptyText="请输入企业名称" class="mini-textbox" />
	            	<span>高管人员名称：</span><input id="name" emptyText="请输入高管人员名称" class="mini-textbox">
	             	<span>高管人员类别：</span><input id="category" emptyText="请输入高管人员类别" class="mini-textbox">
	             	<span>创建人：</span><input id="recorder" emptyText="请输入创建人" class="mini-textbox" />
	             	<span>创建时间从：</span><input id="recordTimeBegin" emptyText="请输入时间" class="mini-datepicker" />
	             	<span>到：</span><input id="recordTimeEnd" emptyText="请输入时间" class="mini-datepicker" />
                </form>
                </td>
            </tr>
        </table>
  </div>
     <div id="datagrid1" class="mini-datagrid" style="width:100%;height:420px" 
            url="${pageContext.request.contextPath}/company/employee/loadEmployees.do" idField="id"
            sizeList="[5,10,20,50]" pageSize="10"
        >
	        <div property="columns">
	             <div type="indexcolumn" ></div>
	             <div field="companyName" width="120" headerAlign="center" allowSort="true" >企业名称</div>
	             <div field="organCode" width="120" headerAlign="center" allowSort="true"  >组织机构编码</div>
	             <div field="creditCode" width="120" headerAlign="center" allowSort="true" >机构信用编码</div>
	             <div field="category" width="120" headerAlign="center" allowSort="true" >高管人员类别</div>    
	             <div field="name" width="120" headerAlign="center" allowSort="true" emptyText="联系电话">高管人员姓名</div>                            
	             <div field="sex" width="100" align="center" headerAlign="center">高管人员性别</div>
	             <div field="post" width="100" align="center" headerAlign="center">高管人员职务</div>
	             <div field="recorder" width="100" align="center" headerAlign="center">创建人</div>
	             <div field="recordTime" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">创建时间</div>                
	        	 <div name="action" width="50" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;"></div>
	         </div>
  		</div> 
</body>
<script type="text/javascript">
	mini.parse();
	var grid = mini.get("datagrid1");
	grid.load();
	function onActionRenderer(e) {
        var record = e.record;
        var employeeId = record.employeeId;
        var s = '<a class="New_Button" target="_self" href="/bank/jsp/company/companyEmployeeForm.jsp?employeeId='+employeeId+'">[查看]</a>';      
        return s;
     }
</script>
</html>