<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 ">

<title>无标题文档</title>

<head>
<style type="text/css">
html{width:100%;height:100%;}
body {
width:100%;
height:100%;
margin:0px;
padding:0px;
overflow-y:hidden
}

 </style>
<!--[if !IE]><!-->
<style type="text/css">
.test { 
   width:100% ;
 }

 </style> 
 <!--<![endif]-->
<style> 
.navPoint { COLOR: white; CURSOR: hand; FONT-FAMILY: Webdings; FONT-SIZE: 9pt } 
td{
height:100%;
}
</style> 
<script>
function switchSysBar(){ 
	var imgPath =document.getElementById("img11").src;
	var imgEnty = imgPath.substr(imgPath.lastIndexOf("/"),imgPath.length);
	if (imgEnty=="/main_55.gif")
	{ 
		document.all("img1").src="images/main_55_1.gif";
		document.all("frmTitle").style.display="none"; 
	} 
	else
	{ 
		document.all("img1").src="images/main_55.gif";
		document.all("frmTitle").style.display="block" ;
	} 
} 
function iframeResize(iframe) {
        try {
            //var iframe = document.getElementById("contentFrame"); //("contentFrame");
            var idocumentElement = iframe.contentWindow.document.documentElement;
            if (idocumentElement.scrollHeight > 560) {
                iframe.height -= 5;
                iframe.height = idocumentElement.scrollHeight;
            }
            else {
                iframe.height = 450;
            }
        }
        catch (e) {
            window.status = 'Error: ' + e.number + '; ' + e.description;
        }
    }
</script>
</head>
<table style="width:100%;height:100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td style="width:0px"></td>
    <td id="frmTitle" style="display:none;width:212px">
	    <iframe name="leftFrame" width="100%" height="100%" src="left.html" border="0" frameborder="0" scrolling="no"
	        >
	        	 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。
	        </iframe>
    </td>
	<td id="switcher" onclick="switchSysBar()"
    	style="width:9px;display:none;border-left:1px orange solid; border-right:1px orange solid;
     	background:url(images/center-bg.jpg) center repeat-y;">
	    <span class="navPoint" id="switchPoint" title="关闭/打开左栏">
	    	<img id="img11"src="images/main_55.gif" name="img1" width="7" height="81" id="img1"/>
	    </span>
    </td>
    <td class="test">
    	<iframe name="rightFrame" id="mainlist" height="100%" 
    	width="100%" height="100%" border="0" frameborder="0" 
    	scrolling="yes" style="overflow-x:hidden;" src="/bank/message/loadIndexPage.do"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
    </td>
  </tr>
  </table>
</body>
</html>
