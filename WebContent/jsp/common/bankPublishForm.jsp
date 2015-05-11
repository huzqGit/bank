<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
margin:0;
padding:0;
}
.topMenu{
	width:100%;
 	height:60px;
 	line-height:60px;
 	text-align:center;
 	color:red;
 	font-size:25px;
 	font-weight:bold;
 	border:1px solid #8AD3E9;
 	background:linear-gradient(#6DC8E3,white);
    /* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
	endColorstr = 'white' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
	endColorstr = 'white' )";
}
.comment_bank{
width:80%;
margin:auto auto;
border-radius:3px;
border:2px solid #CCD4D8;
}
.comment_wrap{
width:100%;
margin:auto auto;

}
.bank_area{
color:#B8B8B8;
width:100%;
height:200px;
overflow-x:hidden;
overflow-y:auto;
}
.wrap_action{
border-top-color:#E6EAED;
border-top-width:1px;
height:42px;
}
.action_function{
float:left;
}
.action_function ul{
width:32px;
}
.action_function ul li{
list-style-type:none;
width:42px;
height:42px;
border-right: 1px solid #E6EAED;
}
.comment_publish{
cursor:pointer;
width:92px;
height:42px;
line-height:42px;
border:0;
background-image:url(/bank/images/FaBu_B.png);
background-repeat:no-repeat;
}
.wrap_uploadimg{
clear:both;
width:42px;
height:40px;
cursor:pointer;
line-height:40px;
display:block;
}
.uploadimg{
display:block;
cursor:pointer;
margin:auto auto;
width:20px;
height:16px;
padding-top:auto;
background-image:url(/bank/images/FuJian.png);
background-repeat:no-repeat;
}
</style>
</head>
<body>
<div class="topMenu">
	发布信息
</div>
<div class="comment_bank">
<div class="comment_wrap">
<div class="wrap_area" >
	<textarea class="bank_area">领导说两句吧^_^...</textarea>
</div>
<div class="wrap_action">
<div class="action_function">
	<ul>
		<li class="function_uploadimg">
		<a class="wrap_uploadimg" href="javascript:void(0)">
			<i class="uploadimg"></i>
		</a>
		</li>
	</ul>

</div>
<div class="issue_btn" style="float:right">
		<a href="javascript:void(0)">
			<button class="comment_publish"></button>
		</a>
</div>
</div>
</div>
	
</div>
</body>
</html>