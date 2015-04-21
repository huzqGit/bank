var CreatedOKLodop7766=null;
var LODOP; //声明为全局变量
function PrintInFullPREVIEWPage(id,title){
	LODOP=getLodop();  	    
	//LODOP.PRINT_INIT("");	
	//LODOP.ADD_PRINT_HTM("1.5cm","0.5%","99%","100%",document.documentElement.innerHTML);
	//LODOP.setAttribute("Caption",title);	
	LODOP.ADD_PRINT_HTM("15mm","3mm","RightMargin:0.3cm","BottomMargin:5mm",document.getElementById(id).innerHTML);
	LODOP.SET_SHOW_MODE("LANDSCAPE_DEFROTATED",1);//横向时的正向显示
	LODOP.SET_PRINT_MODE("FULL_WIDTH_FOR_OVERFLOW",true);
	LODOP.SET_PRINT_MODE("FULL_HEIGHT_FOR_OVERFLOW",true);
	LODOP.SET_PRINT_PAGESIZE(2,0,0,"A4");
	LODOP.SET_PRINT_MODE("NOCLEAR_AFTER_PRINT",true);
	LODOP.SET_PREVIEW_WINDOW(1,0,1,"100%","100%","");
	LODOP.SET_SHOW_MODE("PREVIEW_NO_MINIMIZE",true);//预览窗口禁止最小化，并始终最前	
	LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口		
	LODOP.SET_SHOW_MODE("HIDE_PAPER_BOARD",1);				
	LODOP.PREVIEW();
	//LODOP.PRINT_DESIGN();
	//LODOP.PRINT_SETUP();      
}
function installprint()
{
	if(getLodopInstallStatus()==false)
	{	
		//getLodopInstallStatus
		//初始化打印控件				
		mini.open({
		    url: "/TBPWeb/app/common/js/print/installprint.jsp",
		    title: "打印机控件安装",
		    width: 500,
		    height: 100
		 });
	}	
}
function getLodopInstallStatus(oOBJECT,oEMBED){
/**************************
  本函数根据浏览器类型决定采用哪个页面元素作为Lodop对象：
  IE系列、IE内核系列的浏览器采用oOBJECT，
  其它浏览器(Firefox系列、Chrome系列、Opera系列、Safari系列等)采用oEMBED,
  如果页面没有相关对象元素，则新建一个或使用上次那个,避免重复生成。
  64位浏览器指向64位的安装程序install_lodop64.exe。
**************************/        
        var LODOP;
        var rtn=true;
	try{	
	     //=====判断浏览器类型:===============
	     var isIE	 = (navigator.userAgent.indexOf('MSIE')>=0) || (navigator.userAgent.indexOf('Trident')>=0);
	     var is64IE  = isIE && (navigator.userAgent.indexOf('x64')>=0);
	     //=====如果页面有Lodop就直接使用，没有则新建:==========
	     if (oOBJECT!=undefined || oEMBED!=undefined) { 
               	 if (isIE) 
	             LODOP=oOBJECT; 
	         else 
	             LODOP=oEMBED;
	     } else { 
		 if (CreatedOKLodop7766==null){
          	 LODOP=document.createElement("object"); 
		     LODOP.setAttribute("width",0); 
                     LODOP.setAttribute("height",0); 
		     LODOP.setAttribute("style","position:absolute;left:0px;top:-100px;width:0px;height:0px;");  		     
                     if (isIE) LODOP.setAttribute("classid","clsid:2105C259-1E0C-4534-8141-A753534CB4CA"); 
		     else LODOP.setAttribute("type","application/x-print-lodop");
		     document.documentElement.appendChild(LODOP); 
	             CreatedOKLodop7766=LODOP;		     
 	         } else 
                 LODOP=CreatedOKLodop7766;
	     };
	     //=====判断Lodop插件是否安装过，没有安装或版本过低就提示下载安装:==========
	     if ((LODOP==null)||(typeof(LODOP.VERSION)=="undefined")) {
	             rtn=false;
	             
	     } else 
	     if (LODOP.VERSION<"6.1.8.3") {
	             rtn=false;	             
	     };
	       
	     return rtn; 
	} catch(err) {
		 rtn=false;
	};
    return rtn; 
}


function getLodop(oOBJECT,oEMBED){
/**************************
  本函数根据浏览器类型决定采用哪个页面元素作为Lodop对象：
  IE系列、IE内核系列的浏览器采用oOBJECT，
  其它浏览器(Firefox系列、Chrome系列、Opera系列、Safari系列等)采用oEMBED,
  如果页面没有相关对象元素，则新建一个或使用上次那个,避免重复生成。
  64位浏览器指向64位的安装程序install_lodop64.exe。
**************************/
	var strHtmInstall="<br><span color='#FF00FF' style='font-size:12px'>打印控件未安装!点击这里<a href='/TBPWeb/app/common/js/print/install/install_lodop32.exe' target='_self'>执行安装</a>,安装后请关闭对话框。</span>";
    var strHtmUpdate="<br><span color='#FF00FF' style='font-size:12px'>打印控件需要升级!点击这里<a href='/TBPWeb/app/common/js/print/install/install_lodop32.exe' target='_self'>执行升级</a>,升级后请关闭对话框。</span>";
    var strHtm64_Install="<br><span color='#FF00FF' style='font-size:12px'>打印控件未安装!点击这里<a href='/TBPWeb/app/common/js/print/install/install_lodop64.exe' target='_self'>执行安装</a>,安装后请关闭对话框。</span>";
    var strHtm64_Update="<br><span color='#FF00FF' style='font-size:12px'>打印控件需要升级!点击这里<a href='/TBPWeb/app/common/js/print/install/install_lodop64.exe' target='_self'>执行升级</a>,升级后请关闭对话框。</span>";
    var strHtmFireFox="<br><br><span color='#FF00FF' style='font-size:12px'>（注意：如曾安装过Lodop旧版附件npActiveXPLugin,请在【工具】->【附加组件】->【扩展】中先卸它）</span>";
    var strHtmChrome="<br><br><span color='#FF00FF' style='font-size:12px'>(如果此前正常，仅因浏览器升级或重安装而出问题，需重新执行以上安装）</font>";
    var LODOP;		
	try{	
	     //=====判断浏览器类型:===============
	     var isIE	 = (navigator.userAgent.indexOf('MSIE')>=0) || (navigator.userAgent.indexOf('Trident')>=0);
	     var is64IE  = isIE && (navigator.userAgent.indexOf('x64')>=0);
	     //=====如果页面有Lodop就直接使用，没有则新建:==========
	     if (oOBJECT!=undefined || oEMBED!=undefined) { 
               	 if (isIE) 
	             LODOP=oOBJECT; 
	         else 
	             LODOP=oEMBED;
	     } else { 
		 if (CreatedOKLodop7766==null){
          	     LODOP=document.createElement("object"); 
		     LODOP.setAttribute("width",0); 
                     LODOP.setAttribute("height",0); 
		     LODOP.setAttribute("style","position:absolute;left:0px;top:-100px;width:0px;height:0px;");  		     
                     if (isIE) LODOP.setAttribute("classid","clsid:2105C259-1E0C-4534-8141-A753534CB4CA"); 
		     else LODOP.setAttribute("type","application/x-print-lodop");
		     document.documentElement.appendChild(LODOP); 
	             CreatedOKLodop7766=LODOP;		     
 	         } else 
                     LODOP=CreatedOKLodop7766;
	     };
	     //=====判断Lodop插件是否安装过，没有安装或版本过低就提示下载安装:==========
	     if ((LODOP==null)||(typeof(LODOP.VERSION)=="undefined")) {
	             if (navigator.userAgent.indexOf('Chrome')>=0)
	                 document.documentElement.innerHTML=strHtmChrome+document.documentElement.innerHTML;
	             if (navigator.userAgent.indexOf('Firefox')>=0)
	                 document.documentElement.innerHTML=strHtmFireFox+document.documentElement.innerHTML;
	             if (is64IE) document.write(strHtm64_Install); else
	             if (isIE)   document.write(strHtmInstall);    else
	                 document.documentElement.innerHTML=strHtmInstall+document.documentElement.innerHTML;
	             return LODOP;
	     } else 
	     if (LODOP.VERSION<"6.1.8.3") {
	             if (is64IE) document.write(strHtm64_Update); else
	             if (isIE) document.write(strHtmUpdate); else
	             document.documentElement.innerHTML=strHtmUpdate+document.documentElement.innerHTML;
	    	     return LODOP;
	     };
	     //=====如下空白位置适合调用统一功能(如注册码、语言选择等):====	     

	     //============================================================	     
	     return LODOP; 
	} catch(err) {
	     if (is64IE)	
            document.documentElement.innerHTML="Error:"+strHtm64_Install+document.documentElement.innerHTML;else
            document.documentElement.innerHTML="Error:"+strHtmInstall+document.documentElement.innerHTML;
	     return LODOP; 
	};
}
