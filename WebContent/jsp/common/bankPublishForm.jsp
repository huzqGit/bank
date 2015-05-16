<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
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
<%
String messageId = request.getParameter("messageId");
String actionType = request.getParameter("actionType");
request.setAttribute("messageId", messageId);
request.setAttribute("actionType", actionType);
%>
<body>
<div class="topMenu">
	发布信息
</div>
<div class="comment_bank">
<div class="comment_wrap">
<div id="form1" style="margin-left: 20px ;margin-right: 20px">
<div class="wrap_area" >
<!-- 	<textarea class="bank_area">领导说两句吧^_^...</textarea> -->
<input name='messageContent' class='mini-textarea' class="bank_area"style='width:100%;height: 300px;' emptyText='' allowInput='true' enabled='true'/>
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
			<button class="comment_publish" onclick="javascript:submitForm()"></button>
		</a>
</div>
</div>
</form>
</div>
	
</div>
</body>
</html>
<script type="text/javascript">
var form = new mini.Form("#form1");
$(document).ready(function(){
	//$("#form1").find("td").addClass("mini-grid-cell");
	if ("${actionType}" != "add") {
		$.ajax({
		    url: "${pageContext.request.contextPath}/message/loadMessage.do?messageId=${messageId}",
		    type: "post",
		    success: function (text) {
		        var data = mini.decode(text);   //反序列化成对象
		        form.setData(data);             //设置多个控件数据
		    }
		});
	}
	
});
function submitForm() {
	//提交表单数据
    var formData = form.getData();      //获取表单多个控件的数据
    var json = mini.encode(formData);   //序列化成JSON
    var actionType = "${actionType}";
    
    $.ajax({
        url: "${pageContext.request.contextPath}/message/saveMessage.do",
        type: "post",
        data: { formData: json, actionType: actionType},
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (text) {
        	window.location.href = "${pageContext.request.contextPath}/jsp/common/bankPublishView.jsp";
            mini.alert('提交成功!');
        },
        error: function (jqXHR, textStatus, errorThrown) {
            mini.alert('系统异常！');
        }
    });
}
</script>