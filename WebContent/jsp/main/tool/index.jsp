<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="dt" uri="http://gov.jian.bank/dateformat" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>æ æ é¢ææ¡£</title>
<style type="text/css">
*{ margin:0;padding:0;text-decoration:none;overflow:hidden}
a{
color:blue
}
body{
    font:12px/1.8 Arial;
    color:#666;
    margin:0;
    pading:0;
    background-attachment:fixed;
    background-image: url(/bank/images/bg.png);
    background-repeat: no-repeat;
    background-position:100% 100%;
}

.wrapper{
width:100%;
height:300px;
color:black;
font-size:1.2em

}
ul,li{margin:0;padding:0;list-style:none}
.wp{
    position:relative;
    width:100%;
    height:280px;
    overflow:hidden;
    margin:10px auto;
	
}
.slider{
    position:absolute;
    width:760px;
    padding:0 20px;
    left:0;
    top:0;
}
.slider li{
    padding:10px 0;
    border-bottom:1px dashed #ccc;
    overflow:hidden;
    width:100%;
  
}
em{
    color:red
}
</style>
</head>

<body>
<table width="100%" style="margin-left:50px;margin-top:80px" cellspacing=0 cellpadding=0 style="border-right:1px solid orange">
	<tr >
		<td width="400px"  style="height:30px;">
		
		<div style="width:100%;height:300px;background:orange;float:left;background:url(/bank/jsp/main/tool/images/tt.png) no-repeat"></div>
		</td>
		<td width="15px">
		<div style="width:1px;height:300px;background-image:url(/bank/jsp/main/tool/images/tt1.jpg);background-position:center;background-repeat:no-repeat;float:left"></div>
		
		</td>
		<td >
		<table style="width:80%;border-right:1px solid #FCF3BC;">
		
			<tr>
				<td  style="background-image:url(/bank/jsp/main/tool/images/ww.jpg);font-size:15px;color:black">
					<span style="color:wihte;margin-right:20px">>>></span>
					<span style="font-weight:bold;color:black">最新消息</span>
					<span style="float:right;color:black"><a href="/bank/jsp/common/messageViewAll.jsp" target="_self">更多</a></span>
				</td>
			</tr>
			<tr>
			<td>
			<div class="wrapper">
			    <div class="wp">
			        <ul id="slider" class="slider">
			        <c:forEach var="message" items="${messages}" varStatus="status">
			        	<li>
			        	<c:if test="${message.readnum == 0}">

			        	</c:if>
			        	<span style="width:5%;color:red;height:20px;line-height:20px;display:inline-block">
			        	<c:if test="${message.readnum == 0}">
							New
			        	</c:if>
			        	</span>
			        	<span style="width:75%;height:20px;line-height:20px;overflow:hidden;display:inline-block;white-space:nowrap;text-overflow: ellipsis;margin-right:2px">
			        	<a href="/bank/message/readMessage.do?messageid=${message.messageid}" target="_blank">${message.content}</a>
			        	</span>
			        	<span style="width:20%">${dt:format(message.publishdate,"yyyy-MM-dd")}</span>
			        	 </li>
			        
			        </c:forEach>
			        </ul>
			    </div>
			</div>
			
			</td>
			</tr>
		</table>
		
		</td>
	</tr>


</table>


<script type="text/javascript">
function H$(i){return document.getElementById(i)}function H$$(c,p){return p.getElementsByTagName(c)}var slider=function(){function inits(o){this.id=o.id;this.at=o.auto?o.auto:3;this.o=0;this.pos()}inits.prototype={pos:function(){clearInterval(this.__b);this.o=0;var el=H$(this.id),li=H$$("li",el),l=li.length;var _t=li[l-1].offsetHeight;var cl=li[l-1].cloneNode(true);cl.style.opacity=0;cl.style.filter="alpha(opacity=0)";el.insertBefore(cl,el.firstChild);el.style.top=-_t+"px";this.anim()},anim:function(){var _this=this;this.__a=setInterval(function(){_this.animH()},20)},animH:function(){var _t=parseInt(H$(this.id).style.top),_this=this;if(_t>=-1){clearInterval(this.__a);H$(this.id).style.top=0;var list=H$$("li",H$(this.id));H$(this.id).removeChild(list[list.length-1]);this.__c=setInterval(function(){_this.animO()},20)}else{var __t=Math.abs(_t)-Math.ceil(Math.abs(_t)*0.07);H$(this.id).style.top=-__t+"px"}},animO:function(){this.o+=2;if(this.o==100){clearInterval(this.__c);H$$("li",H$(this.id))[0].style.opacity=1;H$$("li",H$(this.id))[0].style.filter="alpha(opacity=100)";this.auto()}else{H$$("li",H$(this.id))[0].style.opacity=this.o/100;H$$("li",H$(this.id))[0].style.filter="alpha(opacity="+this.o+")"}},auto:function(){var _this=this;this.__b=setInterval(function(){_this.pos()},this.at*1000)}};return inits}();
</script>
<script type="text/javascript">new slider({id:'slider'});</script>
</body>
</html>
