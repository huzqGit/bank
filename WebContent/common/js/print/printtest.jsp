<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>在线打印</title>
<script type="text/javascript" src="/TBPWeb/app/common/js/print/LodopFuncs.js"  charset="utf-8"></script>
<script type="text/javascript">
var LODOP; //声明为全局变量
function PrintInFullPREVIEWPage(id){
	LODOP=getLodop();  	    
	LODOP.PRINT_INIT("电检单打印");	
	//LODOP.ADD_PRINT_HTM("1.5cm","0.5%","99%","100%",document.documentElement.innerHTML);
	LODOP.ADD_PRINT_HTM("15mm","3mm","RightMargin:0.3cm","BottomMargin:5mm",document.getElementById(id).innerHTML);
	LODOP.SET_SHOW_MODE("LANDSCAPE_DEFROTATED",1);//横向时的正向显示
	LODOP.SET_PRINT_MODE("FULL_WIDTH_FOR_OVERFLOW",true);
	LODOP.SET_PRINT_MODE("FULL_HEIGHT_FOR_OVERFLOW",true);
	LODOP.SET_PRINT_PAGESIZE(2,0,0,"A4");
	LODOP.SET_PRINT_MODE("NOCLEAR_AFTER_PRINT",true);
	LODOP.SET_PREVIEW_WINDOW(0,0,1,930,700,"电检单打印");
	LODOP.SET_SHOW_MODE("PREVIEW_NO_MINIMIZE",true);//预览窗口禁止最小化，并始终最前	
	LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口		
	LODOP.SET_SHOW_MODE("HIDE_PAPER_BOARD",1);				
	LODOP.PREVIEW();	
	//showEemToolBar();
}
</script>
</head>
<body>
<p><button class=btn title="打印" onclick="PrintInFullPREVIEWPage('printcontent')">打印</button></p>
<!-- Table goes in the document BODY -->
<div id="printcontent">
<link rel="stylesheet" href="/TBPWeb/app/common/css/print.css" type="text/css" />
<table class="gridtable">
<tr>
	<th>Info Header 1</th><th>Info Header 2</th><th>Info Header 3</th>
</tr>
<tr>
	<td>Text 1A</td><td>Text 1B</td><td>Text 1C</td>
</tr>
<tr>
	<td>Text 2A</td><td>Text 2B</td><td>Text 2C</td>
</tr>
</table>
</div>
</body>
</html>