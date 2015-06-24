<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" class="no-js">
<head>
<script type="text/javascript">
(function(){if(!/*@cc_on!@*/0)return;var e ="abbr,article,aside,audio,canvas,datalist,details,dialog,eventsource,figure,footer,header,hgroup,mark,menu,meter,nav,output,progress,section,time,video".split(','),i=e.length;while(i--){document.createElement(e[i])}})()
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>中国人民银行新干县农村信用信息管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<!-- HTTP 1.1 -->  
<meta http-equiv="pragma" content="no-cache"/>  
<!-- HTTP 1.0 -->  
<meta http-equiv="cache-control" content="no-cache"/>  
<!-- Prevent caching at the proxy server -->  
<meta http-equiv="expires" content="0"/>  
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9"/> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
<meta name="description" content=""></meta>
<meta name="author" content=""></meta>
<!-- CSS -->
<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'></link>
<link rel="stylesheet" href="/bank/jsp/login/assets/css/reset.css"></link>
<link rel="stylesheet" href="/bank/jsp/login/assets/css/supersized.css"></link>
 <link rel="stylesheet" href="/bank/jsp/login/assets/css/style.css"></link>
<style type="text/css">
		.top{
			width:600px;
			height:96px;
			margin-left:100px;
			background-image:url(/bank/jsp/login/assets/img/backgrounds/title.png);
			background-repeat: no-repeat;
		}
		.page1-container{
		margin-right:100px;
			margin-top:120px;
			width:400px;
			height:300px;
			
		}
		/*html5*/
		article,aside,dialog,footer,header,section,footer,nav,figure,menu{display:block}
		.test{
					-webkit-border-radius: 15px;
            -moz-border-radius: 15px;
			filter:alpha(opacity=50);
			-moz-opacity:0.5;
			-khtml-opacity: 0.5;
			opacity: 0.5;
			}
		ul li{
		
		float:left;
		height:50px;
		vertical-align:center;
		margin:0;
		padding:0;
		}
		
		</style>
	
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="/bank/jsp/login/assets/js/html5.js"></script>
        <![endif]-->
    </head>

    <body>
<div class="top"></div>
<div class="center">
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/user/login.do" method="post">
	<ul>
		<li style="width:400px;">	
		<table style="width:100%;height:50px">
		<tr>
			<td width="35%">
				<input style="width:90%" type="text" id="userId" name="userId" class="userId" placeholder="用户名"/>
			</td>
			<td width="2%"></td>
			<td width="35%">
				<input style="width:90%" type="password" id="password" name="password" class="password" placeholder="密码"/>
			</td>
		</tr>
		</table>
		</li >
		<li>
				<input type="submit" value="登录" style="width:80px;height:40px;cursor:handler;color:white;font-weight:bold;background:url(/bank/jsp/login/assets/img/backgrounds/login.png) no-repeat"/>
		</li>
	</ul>
	</form>
	</div>
</div>
 <!-- Javascript -->
<script src="/bank/jsp/login/assets/js/jquery-1.8.2.min.js"></script>
<script src="/bank/jsp/login/assets/js/supersized.3.2.7.min.js"></script>
<script src="/bank/jsp/login/assets/js/supersized-init.js"></script>
<script src="/bank/jsp/login/assets/js/scripts.js"></script>
</body> 
</html>