<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Fit Layout</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
	<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<style type="text/css">
html body{
width:100%;
height:100%;
margin:0;
padding:0;
}
.mini-grid-headerCell{
background:orange;
border-left:0px;
border-right:0px;
border-bottom:0px;
} 
.mini-grid-bottomCell{
background:orange;
}
.mini-grid-headerCell-inner{
font-size:1.5em;
font-weight:bold;
background:orange;
color:white;

}
.mini-grid-cell{
border-left:0px;
border-right:0px;
border-bottom:1px solid #F5F7CF;
height:1.6em;
font-size:1.5em;
}
.mini-grid-cell-inner{
font-size:1em;
}
.mini-grid-pager{
background:white
}
.Edit_Button{
color:blue
}
</style>
</head>
<title>Insert title here</title>

<body >   

    <!--撑满页面-->
    <div class="mini-fit">
        <div id="datagrid1" class="mini-datagrid mini-fit" style="width:100%;height:100%;" 
            url="${pageContext.request.contextPath}/message/loadAllMessagesByUser.do" idField="id"
            sizeList="[5,10,20,50]" pageSize="20"
        >
            <div property="columns">
            	<div field="readnum" width="5%" align="center" renderer="readRenderer"></div>
            	<div type="indexcolumn" width="5%" >序号</div>
                <div field="title" width="20%" headerAlign="center" allowSort="true">标题</div> 
                <div field="content" width="50%" headerAlign="center" allowSort="true">发布内容</div>  
                <div field="username" width="10%" headerAlign="center" align="center" allowSort="true">发布人</div>    
                <div field="publishdate" width="10%" headerAlign="center" align="center"dateFormat='yyyy-MM-dd' allowSort="true">发布时间</div>                
            	<div name="action" width="5%" headerAlign="center" align="center" renderer="editRenderer" cellStyle="padding:0;"></div>
            </div>
        </div> 
        </div>
     <script type="text/javascript">
        mini.parse();
        var grid = mini.get("datagrid1");
        grid.load();
        mini.layout() ;
        function readRenderer(e) {
    	    var record = e.record;
    	    var readnum = record.readnum;
    	    if(readnum ==0){
    	    	return '<font color="red">New</font>';
    	    }else{
    	    	return "";
    	    }
    	};
        function editRenderer(e) {
    	    var record = e.record;
    	    var messageid = record.messageid;
    	    var s = '<a class="Edit_Button" target="_blank" href="/bank/message/readMessage.do?messageid='+messageid+'">[查看]</a>';      
    	    return s;
    	};
    </script>
</body>
</html>