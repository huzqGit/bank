/* 邮箱地址 */
function isEmail(v) {
	var pattern =/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	if(v!="") {
		if(!pattern.exec(v)) {
			return false;
		}
	}
	return true;
}

/* 是否数字(int) */
function isNumber(v) {
    var v2 = parseInt(v);
    if (isNaN(v2)) return false;
    return typeof v2 == 'number' && String(v) == String(v2);
}

/* 是否数字(float) */
function isFloat(v) {
    var v2 = parseFloat(v);
    if (isNaN(v2)) return false;
    return typeof v2 == 'number' && String(v) == String(v2);
}

/* 是否英文 */
function isEnglish(v) {
    var re = new RegExp("^[a-zA-Z\_]+$");
    if (re.test(v)) return true;
    return false;
}

/* 是否英文+数字 */
function isEnglishAndNumber(v) {
    var re = new RegExp("^[0-9a-zA-Z\_]+$");
    if (re.test(v)) return true;
    return false;
}

/* 是否汉字 */
function isChinese(v) {
    var re = new RegExp("^[\u4e00-\u9fa5]+$");
    if (re.test(v)) return true;
    return false;
}

/* 是否日期(格式：2010-10-10)*/
function isDate(v) {
    if (!v) return false;
    var d = mini.parseDate(v, "yyyy-MM-dd");
    if (d && d.getFullYear) return true;
    return false;
}

/* 是否日期(格式：2010/10/10)*/
function isDate2(v) {
    if (!v) return false;
    var d = mini.parseDate(v, "yyyy/MM/dd");
    if (d && d.getFullYear) return true;
    return false;
}

/* 是否日期(格式：24/10/2010)*/
function isDate3(v) {
    if (!v) return false;
    var d = mini.parseDate(v, "dd/MM/yyyy");
    if (d && d.getFullYear) return true;
    return false;
}

// 校验电话号码
function isTel(tel) {
	//国家代码(2到3位)-区号(2到3位)-电话号码(7到8位)-分机号(3位)"
	var pattern =/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
	//var pattern =/(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{7,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/; 
	if(tel!="") {
		if(!pattern.exec(tel)) {
			return false;
		}
	}
	return true;
}

// 校验手机号码
function isMobile(mobile) {
	if ((/^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|18[0|6|7|8|9])\d{8}$/.test(mobile) == false) && (/^(013[0-9]|15[0|3|6|7|8|9]|18[6|8|9])\d{8}$/.test(mobile) == false)) {
		return false;
	}
	return true;
}

// 校验文本框空和长度是否等于0
function validationText(e) {
	if (e.isValid) {
   		if (e.value.trim().length == 0) {
   			e.errorText = "不能为空";
   			e.isValid = false;
   		}
   	}
   	updateError(e);
}

// 校验值是否为空或长度是否0
function validationValue(e) {
	if (e.isValid) {
		if (e.value.length == 0) {
			e.errorText = "不能为空";
   			e.isValid = false;
   		}
   	}
   	updateError(e);
}

// 校验手机号码
function validationMobile(e) {
	if (e.isValid) {
      	if (!isMobile(e.value)) {
     		e.errorText = "格式错误";
       		e.isValid = false;
       	}
	}
	updateError(e);
}

// 校验数字
function validationNumber(e) {
	if (!isNumber(e.value)) {
		e.errorText = "格式错误";
    	e.isValid = false;
	}
	updateError(e);
}