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
       			<a class="mini-button" iconCls="icon-add" plain="true"  target ="_self" href="/bank/jsp/farmer/farmerHouseForm.jsp">新增</a>
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
	            	<span>户主姓名：</span><input id="farmerName" emptyText="请输入户主姓名" class="mini-textbox" />
	            	<span>身份证号：</span><input id="farmerIdNum" emptyText="请输入身份证号" class="mini-textbox">
	            	<span>房产性质：</span><input id="houseProperty" emptyText="请输入房产性质" class="mini-textbox" />
	            	<span>房屋类型：</span><input id="houseType" emptyText="请输入房屋类型" class="mini-textbox">
	             	<span>创建人：</span><input id="recorder" emptyText="请输入创建人" class="mini-textbox" />
	             	<span>创建时间从：</span><input id="recordTimeBegin" emptyText="请输入时间" class="mini-datepicker" />
	             	<span>到：</span><input id="recordTimeEnd" emptyText="请输入时间" class="mini-datepicker" />
                </form>
                </td>
            </tr>
        </table>
  </div>
   <div id="datagrid1" class="mini-datagrid" style="width:100%;height:420px" 
            url="${pageContext.request.contextPath}/farmer/loadAllHouse.do" idField="id"
            sizeList="[5,10,20,50]" pageSize="10"
        >
	        <div property="columns">
	             <div type="indexcolumn" ></div>
	             <div field="farmerName" width="60" headerAlign="center" allowSort="true" >户主姓名</div>
	             <div field="farmerIdNum" width="120" headerAlign="center" allowSort="true"  >户主身份证号</div>
	             <div field="houseProperty" width="60" headerAlign="center" allowSort="true" >房产性质</div>   
	              <div field="houseType" width="90" headerAlign="center" allowSort="true" >房屋类型</div>     
	             <div field="houseAddress" width="90" headerAlign="center" allowSort="true" >房屋地址</div>                            
	             <div field="buildArea" width="90" headerAlign="center" allowSort="true" >建筑面积</div> 
	             <div field="buildDate" width="90" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true" >购建年份</div>
	             <div field="buildPrice" width="90" headerAlign="center" allowSort="true" >购建价格</div>                             
	             <div field="floorArea" width="90" headerAlign="center" allowSort="true" >占地面积</div>                 
	              <div field="assessPrice" width="90" headerAlign="center" allowSort="true" >当前评估价格</div>  
	             <div field="recorder" width="50" align="center" headerAlign="center">创建人</div>
	             <div field="recordTime" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">创建时间</div>                
	        	 <div name="action" width="50" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;"></div>
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
		  var farmerName = mini.get("farmerName").getValue();
		  var farmerIdNum =mini.get("farmerIdNum").getValue();
		  var houseProperty =mini.get("houseProperty").getValue();
		  var houseType=mini.get("houseType").getValue();
		  var recorder=mini.get("recorder").getValue();
		  var recordTimeBegin=mini.get("recordTimeBegin").getValue();
		  var recordTimeEnd=mini.get("recordTimeEnd").getValue();
		  
		  grid.load({farmerName:farmerName,farmerIdNum:farmerIdNum,houseProperty:houseProperty,
			  houseType:houseType,recorder:recorder,recordTimeBegin:recordTimeBegin,
            recordTimeEnd:recordTimeEnd});
       }
	  function onActionRenderer(e) {
          var record = e.record;
          var id = record.id;
          var s = '<a class="New_Button" target="_self" href="/bank/jsp/farmer/farmerHouseForm.jsp?id='+id+'">[查看]</a>';      
          return s;
      }
   </script> 
</body>
</html>