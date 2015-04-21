/** 打印object属性 **/
function printObj(obj){
	var s = ""; 
	for (var prop in obj) { 
		s = s + "\n "+prop +": " + obj[prop] ; 
	} 
	alert(s);  
}

/** 适应STRUTS模型驱动 **/
function toModel(obj){
	var model = new Object();
	for (var prop in obj) { 
		model["model." + prop] = obj[prop];
	}
	return model;
}

function toStrutsModel(obj){
	var str="";
	var i=0;
	for (var prop in obj) { 
		if(i==0){
			str +="model." + prop + "=" + obj[prop];
			i = 1;
		}else{
			str +="&model." + prop + "=" + obj[prop];
		}
	}
	return str;
}
function getRequestParam(obj){
	var str="";
	var i=0;
	for (var prop in obj) { 
		if(i==0){
			str +=prop + "=" + obj[prop];
			i = 1;
		}else{
			str +="&" + prop + "=" + obj[prop];
		}
	}
	return str;
}
/** 弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [ERROR,INFO,QUESTION,WARNING] **/
function showMessage(title, msgString, msgType) {
	Edo.MessageBox.show({ title: title, msg: msgString, buttons: Edo.MessageBox.OK, icon: Edo.MessageBox[msgType] });
}

/** Mini UI 弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [Error,Info,Question, Warning] callback：回调函数**/
function miniMessage(title, message, iconCls, callback) {
	var icon = "mini-messagebox-" + iconCls;
	mini.showMessageBox({
        title: title,
        buttons: ["ok"],
        message: message,
        iconCls: icon,
        callback: callback
    });
}

/** 关闭WINDOW窗口 **/
function closeWindow(action) {
    if (window.CloseOwnerWindow) {
    	window.CloseOwnerWindow(action);
    } else {
    	window.close();
    }
}

// 更新校验信息并输出到页面指定位置
function updateError(e) {
    var id = e.sender.name + "_error";
    var el = document.getElementById(id);
    if (el) {
        el.innerHTML = e.errorText;
    }
}

/** 本地时钟 **/
function clockon() {
    var now = new Date();
    var year = now.getFullYear(); //getFullYear getYear
    var month = now.getMonth();
    var date = now.getDate();
    var day = now.getDay();
    var hour = now.getHours();
    var minu = now.getMinutes();
    var sec = now.getSeconds();
    var week;
    month = month + 1;
    if (month < 10) month = "0" + month;
    if (date < 10) date = "0" + date;
    if (hour < 10) hour = "0" + hour;
    if (minu < 10) minu = "0" + minu;
    if (sec < 10) sec = "0" + sec;
    var arr_week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
    week = arr_week[day];
    var time = "";
    time = year + "年" + month + "月" + date + "日" + " " + hour + ":" + minu + ":" + sec + " " + week;

    $("#bgclock").html(time);

    var timer = setTimeout("clockon()", 200);
}

function systemTime() {
	var today = new Date();
	var str;
	var yy = today.getYear();
	if(yy<1900) yy = yy+1900;
	var MM = today.getMonth()+1;
	if(MM<10) MM = '0' + MM;
	var dd = today.getDate();
	if(dd<10) dd = '0' + dd;
	var hh = today.getHours();
	if(hh<10) hh = '0' + hh;
	var mm = today.getMinutes();
	if(mm<10) mm = '0' + mm;
	var ss = today.getSeconds();
	if(ss<10) ss = '0' + ss;
	str = yy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss;
	return(str);
}

// 返回当前页面高度 
function pageHeight(){ 
	if($.browser.msie){ 
		return document.compatMode == "CSS1Compat"? document.documentElement.clientHeight : 
		document.body.clientHeight; 
	}else{ 
		return self.innerHeight; 
	} 
}

//返回当前页面宽度 
function pageWidth(){ 
	if($.browser.msie){ 
	return document.compatMode == "CSS1Compat"? document.documentElement.clientWidth : 
	document.body.clientWidth; 
	}else{ 
	return self.innerWidth; 
	} 
}

//验证传入值的长度是否大于传入的长度，如果大于返回false，否则返回true
//主要用于检验输入框中英文混合最大长度
function checkLength(value,length){
	var ss = value.replace(/[^x00-\xff]/g,"**").length;
	if(Number(ss) > Number(length))
		return false;
	else
	return true;
}

// 去掉左右空格	add by 徐真 2012-10-29
function trim(m){
	if (m != undefined) {
		while((m.length>0)&&(m.charAt(0)==' '))
			m = m.substring(1, m.length);
		while((m.length>0)&&(m.charAt(m.length-1)==' '))   
			m = m.substring(0, m.length-1);   
		return m;  
	}
}

// 比较时间（比较2个时间的大小，此格式为 yyyy-MM-dd HH:mm:ss） add by 徐真 2012-10-29
// 结果：如果result > 0  endTime时间早于beginTime
// 结果：如果result < 0  endTime时间小于beginTime
// 结果：如果result == 0 endTime时间等于beginTime
function comptime(beginTime, endTime) {
	var beginTimes = beginTime.substring(0, 10).split('-');
	var endTimes = endTime.substring(0, 10).split('-');
	
	beginTime = beginTimes[1] + '-' + beginTimes[2] + '-' + beginTimes[0] + ' ' + beginTime.substring(10, 19);
	endTime = endTimes[1] + '-' + endTimes[2] + '-' + endTimes[0] + ' ' + endTime.substring(10, 19);

	var result = (Date.parse(endTime) - Date.parse(beginTime)) / 3600 / 1000;

	return result;
}

// 计算两个时间的时间差值
// interval ：D表示查询精确到天数的之差 interval ：H表示查询精确到小时之差 interval ：M表示查询精确到分钟之差 
// interval ：S表示查询精确到秒之差 interval ：T表示查询精确到毫秒之差
// 使用：dateDiff("M", "2012-10-29 20:11:46", "2012-10-29 20:12:38")
function dateDiff(interval, date1, date2) {
	var objInterval = {"D":1000 * 60 * 60 * 24,"H":1000 * 60 * 60,"M":1000 * 60,"S":1000,"T":1};
	interval = interval.toUpperCase();
	var dt1 = new Date(Date.parse(date1.replace(/-/g, "/")));
	var dt2 = new Date(Date.parse(date2.replace(/-/g, "/")));
	try {
		return Math.round((dt2.getTime() - dt1.getTime()) / eval("objInterval."+interval));
	}
	catch (e) {
		return e.message;
	}
}

//验证是否包含特殊字符
String.prototype.hasSpecialChar = function(){
	var errTxt = "不允许包含特殊字符：&lt;&gt;&amp;&and;&lowast";
	if(this.indexOf('<')!=-1){
		return errTxt;
	}else if(this.indexOf('>')!=-1){
		return errTxt;
	}else if(this.indexOf('^')!=-1){
		return errTxt;
	}else if(this.indexOf('*')!=-1){
		return errTxt;
	}else if(this.indexOf('&')!=-1){
		return errTxt;
	}
	return null;
}

Date.prototype.format = function(fmt){
    var year    =   this.getFullYear();
    var month   =   this.getMonth()+1;
    var date    =   this.getDate();
    var hour    =   this.getHours();
    var minute  =   this.getMinutes();
    var second  =   this.getSeconds();
    
	fmt = fmt.replace("yyyy",year);
	fmt = fmt.replace("yy",year%100);
	fmt = fmt.replace("MM",fix(month));
	fmt = fmt.replace("dd",fix(this.getDate()));
	fmt = fmt.replace("hh",fix(this.getHours()));
	fmt = fmt.replace("mm",fix(this.getMinutes()));
	fmt = fmt.replace("ss",fix(this.getSeconds()));
	return fmt;
    
	function fix(n){
		return n<10?"0"+n:n;
	}
}