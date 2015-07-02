<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
    <div id="datagrid1" class="mini-datagrid" style="width:100%;height:140px" 
    		frozenStartColumn="0" frozenEndColumn="1"
         url="${pageContext.request.contextPath}/economy/loadFileResult.do" idField="cooperationId"
         sizeList="[5,10,20,50]" pageSize="10">
      	<div property="columns">
           <div type="indexcolumn" >#</div>
           <div field="error_label" width="450" align="center" headerAlign="center" allowSort="true">失败原因</div>
           <div field=cooperationName width="120" headerAlign="center" allowSort="true" >合作社名称</div>
           <div field="businesslicence" width="120" headerAlign="center" allowSort="true" >营业执照</div>
           <div field="orgaCode" width="120" headerAlign="center" allowSort="true"  >组织机构编码</div>
           <div field="taxCode" width="120" headerAlign="center" allowSort="true" >税务登记号</div>
           <div field="registerDate" width="120" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true" >注册日期</div>    
           <div field="registerAddress" width="120" headerAlign="center" allowSort="true">注册地址</div>                            
           <div field="mailAddress" width="120" headerAlign="center" allowSort="true">通信地址</div>                            
           <div field="registerCapital" width="100" align="center" headerAlign="center" allowSort="true">注册资金</div>
           <div field="realCapital" width="100" align="center" headerAlign="center" allowSort="true">实收资金</div>
       </div>
	</div>
</body>
<script type="text/javascript">
mini.parse();
var grid = mini.get("datagrid1");
grid.load()
</script>
</html>