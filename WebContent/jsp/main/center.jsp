<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<style> 
.navPoint { 
COLOR: white; CURSOR: hand; FONT-FAMILY: Webdings; FONT-SIZE: 9pt 
} 
</style> 
<script>
function switchSysBar(){ 
var locate=location.href.replace('center.html','');
var ssrc=document.all("img1").src.replace(locate,'');
if (ssrc=="images/main_55.gif")
{ 
document.all("img1").src="images/main_55_1.gif";
document.all("frmTitle").style.display="none" 
} 
else
{ 
document.all("img1").src="images/main_55.gif";
document.all("frmTitle").style.display="" 
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
                iframe.height = 560;
            }
        }
        catch (e) {
            window.status = 'Error: ' + e.number + '; ' + e.description;
        }
    }
</script>

</head>

<body style="overflow:hidden">
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
  <tr>
    <td width="212" id=frmTitle noWrap name="fmTitle" align="center" valign="top" style="display:;">
	<table width="212" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed;">
      <tr>   	         
        <td width="212" align="center" valign="top"><iframe name="leftFrame" onLoad="iframeResize(this)" width="100%" height="100%" border="0" frameborder="0" scrolling="no"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe></td>
      </tr>
    </table></td>
    <td width="9" align="center" valign="middle" style="border-left:1px #0da0d3 solid; border-right:1px #0da0d3 solid; background:url(images/center-bg.jpg) center repeat-y;" onClick="switchSysBar()"><SPAN class=navPoint 
id=switchPoint title=关闭/打开左栏><img src="images/main_55.gif" name="img1" width=7 height=81 id=img1></SPAN></td>
    <td width="100%" align="center" valign="top"><iframe name="rightFrame" id="mainlist" onLoad="iframeResize(this)" width="100%" height="100%" border="0" frameborder="0" scrolling="yes" style="overflow-x:hidden;" src="tool/index.html"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe></td>
    <td width="1" align="center" valign="top" bgcolor="#2fbbba"></td>
  </tr>
</table>
</body>
</html>
