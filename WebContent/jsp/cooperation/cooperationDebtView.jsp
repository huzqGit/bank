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
<div class="topMenu">
	<ul>
		<li class="inactive">
			<a href="/bank/economy/editCooperation.do?id=${cooperation.id}">基本信息</a>
		</li>
		<li class="active">
			资产负债信息
		</li>
	</ul>
</div>
<div>
<table width ="100%" height="60px">
	<tr>
		<td class="labelName" width="30%" align="right">经济合作组织名称</td>
		<td class="labelValue" width="1%" align="center">:</td>
		<td class="labelValue" width="20%">${cooperation.cooperationname }</td>
		<td class="labelName" width="10%" align="center">营业执照</td>
		<td class="labelValue" width="1%">:</td>
		<td class="labelValue" align="left">${cooperation.businesslicence}</td>
		<td width="1%"></td>
		 <td width="50px" align="right">
       	 <input type="button" class="bank-btn" onclick="add(${cooperation.id})" value="新增"/>
        </td>
       
	</tr>
</table>
</div>
<div style="width:100%;position:absolute;top:110px;bottom:0px;left:0px;bottom:0px">
	<div class="mini-fit">
		<div id="datagrid1" class="mini-datagrid" style="width:99%;height:100%;background-color:white" 
	           url="${pageContext.request.contextPath}/economy/debt/loadCooperationDebt.do?businesslicence=${cooperation.businesslicence}" idField="id"
	            sizeList="[5,10,20,50]" pageSize="20" 
	            allowCellEdit="false" allowCellSelect="true" multiSelect="false" allowResize="true"
	        	  editNextOnEnterKey="true"  editNextRowCell="true" contextMenu="#treeMenu">
	       <div property="columns">
	          <div type="indexcolumn" >
	          </div>
	          <div field="yearmonth" width="120" headerAlign="center" allowSort="true" >年月
	          	<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" />
	          </div>
	          <div field="cashcapital" width="120" headerAlign="center" allowSort="true" >货币资金<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>
	          	<div field="cashcapital" width="120" headerAlign="center" allowSort="true" >货币资金</div>
			<div field="shortinvest" width="120" headerAlign="center" allowSort="true" >短期投资<input property="editor" class="mini-textbox" style="width:100%;" minWidth="150" /></div>	
			<div field="shortinvest" width="120" headerAlign="center" allowSort="true" >短期投资</div>
			<div name="action" width="5%" headerAlign="center" align="center" renderer="editRenderer" cellStyle="padding:0;"></div>
			<div name="action" width="5%" headerAlign="center" align="center" renderer="deleteRenderer" cellStyle="padding:0;"></div>
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
	function add(cid){
			window.location.href="/bank/economy/debt/insertCooperationDebt.do?cid="+cid;
	}
		function editRenderer(e) {
		    var record = e.record
		    var cid = "${cooperation.id}";
		    var id = record.id;
		    var s = '<a class="Edit_Button" target="_self" href="/bank/economy/debt/editCooperationDebt.do?cid='+cid+'&id='+id+'">[编辑]</a>';      
		    return s;
		}
		function deleteRenderer(e,cid) {
		    var record = e.record;
		    var id = record.id;
		    var organcode = record.organcode;
		    var sourcecode = record.sourcecode;
		    var s = '<a class="New_Button" target="_self" '
		    +'href="/bank/economy/debt/deleteCooperationDebt.do?id='+id+'&organcode='+organcode+'&sourcecode='+sourcecode+'">[删除]</a>';      
		    return s;
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