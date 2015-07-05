<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="dt" uri="http://gov.jian.bank/dateformat" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>最新信息</title>
<style type="text/css">
html body{
height:97%;
margin:0px;
font-family:"仿宋";
font-size:1.5em;
background:lightgray;
line-height:1.6em;
overflow-y:hidden
}
.content-wrapper{
width:80%;
margin:auto auto;

}
.content{
width:90%;
padding-bottom:100px;
height:800px;
padding-bottom:0px;
margin-left:auto;
margin-right:auto;
margin-bottom:2px;
float:left;
background:white
}

</style>
</head>
<body>

	<div class="content-wrapper">
	<div class="content">
		<div style="width:100%;text-align:center;font-weight:bold;font-size:1.5em;margin-top:50px;margin-left:auto;margin-right:auto;margin-bottom:10px">
		${message.title }
		</div>
		<div style="width:100%;text-align:center;margin:20px">
		
				<span>发布人:</span>
				<span style="margin-right:25px">${message.username }</span>
				<span style="margin-left:25px">发布时间:</span><span>${dt:format(message.publishdate,"yyyy年MM月dd日")}</span>
		</div>
		<div style="width:80%;margin-left:auto;margin-right:auto;margin-bottom:30px;height:2px;background:red;"></div>
		<div style="width:80%;margin:auto auto">
			${message.content }
		</div>
	</div>
	</div>
<div>


</div>
</body>
</html>