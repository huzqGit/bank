function paramString2obj (serializedParams) {
    var obj={};
    function evalThem (str) {
        var attributeName = str.split("=")[0];
        var attributeValue = str.split("=")[1];
        if(!attributeValue){
            return ;
        }
         
        var array = attributeName.split(".");
        for (var i = 1; i < array.length; i++) {
            var tmpArray = Array();
            tmpArray.push("obj");
            for (var j = 0; j < i; j++) {
                tmpArray.push(array[j]);
            };
            var evalString = tmpArray.join(".");
            if(!eval(evalString)){
                eval(evalString+"={};");                
            }
        };
     
        eval("obj."+attributeName+"='"+attributeValue+"';");
         
    };
 
    var properties = serializedParams.split("&");
    for (var i = 0; i < properties.length; i++) {
        evalThem(properties[i]);
    };
    return obj;
};
$.fn.form2json = function(){
    var serializedParams = this.serialize();
    var obj = paramString2obj(serializedParams);
    return JSON.stringify(obj);
};
$.fn.form2jsonArray = function(){
	var jsonArray="[";
	this.each(function(){
		jsonArray=jsonArray+$(this).form2json()+",";
	});
	jsonArray=jsonArray.substr(0,jsonArray.length-1);
	jsonArray=jsonArray+"]";
	return jsonArray;
};
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
function FarmerCompunish(index){
	var str="<form id=\"farmerCompunish"+index+"\" class=\"farmerCompunish\" method=\"POST\">"
		+"<input name=\"id\" class=\"mini-hidden\"/>"
		+"<table border=\"0\" cellpadding=\"1\" cellspacing=\"5\" width=\"100%\" >"
		+"<tr>"
		+"<td colspan=\"4\" style=\"width:100%\">"
		+"<table width=\"100%\">"
		+"<tr>"
		+"<td style=\"width:15%\"><label for=\"textbox1$text\">表彰或处罚部门:</label></td>"
		+"<td style=\"width:35%\">"
		+"<input id=\"textbox1\"  name=\"organ\" class=\"mini-combobox\" required=\"true\""
		+"requiredErrorText=\"信用户评定时间不能为空\"style=\"width:90%\"" 
		+"url=\"/bank/dic/CompunishType.txt\" emptyText=\"请选择...\"/>"
		+"</td>"
		+"<td style=\"width:15%\"><label for=\"textbox1$text\">表彰或处罚时间:</label></td>"
		+"<td style=\"width:35%\">"
		+"<input  name=\"occurTime\" class=\"mini-datepicker\" style=\"width:90%\"/>"
		+"</td>"
		+"</tr>"
		+"<tr>"
		+"<td style=\"width:15%\"><label for=\"textbox2$text\">表彰或处罚内容:</label></td>"
		+"<td style=\"width:35%\" >"
		+"<input id=\"textbox2\"  name=\"detail\" class=\"mini-textarea\" required=\"true\""
		+"requiredErrorText=\"表彰或处罚内容不能为空\" style=\"width:90%\"/>"
		+"</td>"          
		+"</tr>"
		+"</table>"          
		+"</td>"
		+"</tr>"
		+"</table>"
		+"</form>";
	return str;
}
function FarmerMember(index){
	var str="<form id=\"farmerMember"+index+"\"class=\"farmerMember\" method=\"POST\">"
	    +"<input class=\"mini-hidden\" name=\"id\"/>"
	    +"<table border=\"0\" cellpadding=\"1\" cellspacing=\"15\" width=\"100%\" >"
	    +"<tr>"
	    +"<td colspan=\"4\" style=\"width:100%\">"
	    +"<table width=\"100%\">"
	    +"<tr>"
	    +"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>家庭成员姓名:</label></td>"
	    +"<td style=\"width:40%\">"
	    +"<input name=\"name\" class=\"mini-textbox\" required=\"true\""
	    +"requiredErrorText=\"家庭成员姓名不能为空\" style=\"width:90%\"/>"
	    +"</td>"
	    +"<td style=\"width:10%\"><label for=\"textbox2$text\"><font color=\"red\">*</font>与户主关系:</label></td>"
	    +"<td style=\"width:40%\" >"
	    +"<input name=\"relation\" class=\"mini-combobox\" required=\"true\""
	    +"requiredErrorText=\"与户主关系不能为空\"  style=\"width:90%\""
	    +"url=\"/bank/dic/Relation.txt\" emptyText=\"请选择...\"/>"
	    +"</td>"
	    +"</tr>"
	    +"<tr>"
	    +"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>身份证号:</label></td>"
	    +"<td style=\"width:40%\">"
	    +"<input id=\"textbox1\"  name=\"idNum\" class=\"mini-textbox\" required=\"true\""
	    +"requiredErrorText=\"身份证号不能为空\" style=\"width:90%\"/>"
	    +"</td>"
	    +"<td style=\"width:10%\"><label for=\"textbox2$text\"><font color=\"red\">*</font>文化程度:</label></td>"
	    +"<td style=\"width:40%\" >"
	    +"<input name=\"education\" class=\"mini-combobox\" required=\"true\""
	    +"requiredErrorText=\"文化程度不能为空\"  style=\"width:90%\""
	    +"url=\"/bank/dic/Education.txt\" emptyText=\"请选择...\"/>"
	    +"</td>"
	    +"</tr>"
	    +"<tr>"
	    +"<td style=\"width:10%\"><label for=\"textbox1$text\">  婚姻状况:</label></td>"
	    +"<td style=\"width:40%\">"
	    +"<input id=\"textbox1\"  name=\"marryStatus\" class=\"mini-combobox\" required=\"true\""
	    +"requiredErrorText=\"婚姻状况不能为空\" style=\"width:90%\""
	    +"url=\"/bank/dic/MarryStatus.txt\" emptyText=\"请选择...\"/>"
	    +"</td>"
	    +"<td style=\"width:10%\"><label for=\"textbox2$text\">  职业:</label></td>"
	    +"<td style=\"width:40%\" >"
	    +"<input id=\"textbox2\"  name=\"occupation\" class=\"mini-textbox\" required=\"true\""
	    +"requiredErrorText=\"职业不能为空\"  style=\"width:90%\"/>"
	    +"</td>"
	    +"</tr>"
	    +"<tr>"
	    +"<td style=\"width:10%\"><label for=\"textbox1$text\"> 职务:</label></td>"
	    +"<td style=\"width:40%\">"
	    +"<input id=\"textbox1\"  name=\"job\" class=\"mini-textbox\" required=\"true\""
	    +"requiredErrorText=\"职务不能为空\" style=\"width:90%\"/>"
	    +"</td>"
	    +"<td style=\"width:10%\"><label for=\"textbox2$text\">  性别:</label></td>"
	    +"<td style=\"width:40%\" >"
	    +"<input id=\"textbox2\"  name=\"sex\" class=\"mini-combobox\" required=\"true\""
	    +"requiredErrorText=\"性别不能为空\" style=\"width:90%\""
	    +"url=\"/bank/dic/Sex.txt\" emptyText=\"请选择...\"/>"
	    +"</td>"
	    +"</tr>"
	    +"<tr>"
	    +"<td style=\"width:10%\"><label for=\"textbox1$text\">  联系电话:</label></td>"
	    +"<td style=\"width:40%\">"
	    +"<input id=\"textbox1\"  name=\"phone\" class=\"mini-textbox\" required=\"true\""
	    +"requiredErrorText=\"联系电话不能为空\" style=\"width:90%\"/>"
	    +"</td>"
	    +"</tr>"
	    +"</table>"
	    +"</td>"
	    +"</tr>"
	    +"</table>"
	    +"</form>";
	return str;
}
function FarmerHouse(index){
   var str="<form id=\"farmerHouse"+index+"\" class=\"farmerHouse\" method=\"POST\">"
	   +"<input name=\"id\" class=\"mini-hidden\" />"
	   +"<input name=\"recorder\" class=\"mini-hidden\" value=\"管理员\"/>"
	   +"<input name=\"recordTime\" class=\"mini-hidden\" value=\"${currentTime}\"/>"
	   +"<table border=\"0\" cellpadding=\"1\" cellspacing=\"15\" width=\"100%\" >"
	   +"<tr>"
	   +"<td colspan=\"4\" style=\"width:100%\">"
	   +"<table width=\"100%\">"
	   +"<tr>"
	   +"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>房产性质:</label></td>"
	   +"<td style=\"width:40%\">"
	   +"<input id=\"textbox1\"  name=\"houseProperty\" class=\"mini-textbox\" style=\"width:90%\"/>"
	   +"</td>"
	   +"<td style=\"width:10%\"><label for=\"textbox2$text\"><font color=\"red\">*</font>房屋类型:</label></td>"
	   +"<td style=\"width:40%\" >"
	   +"<input id=\"textbox2\"  name=\"houseType\" class=\"mini-combobox\" style=\"width:90%\""
	   +"url=\"/bank/dic/HouseType.txt\" emptyText=\"请选择...\"/>"
	   +"</td>"
	   +"</tr>"
	   +"<tr>"
	   +"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>房屋地址:</label></td>"
	   +"<td style=\"width:40%\">"
	   +"<input id=\"textbox1\"  name=\"houseAddress\" class=\"mini-textbox\" style=\"width:90%\"/>"
	   +"</td>"
	   +"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>建筑面积:</label></td>"
	   +"<td style=\"width:40%\">"
	   +"<input id=\"textbox1\"  name=\"buildArea\" class=\"mini-textbox\" style=\"width:90%\"/>"
	   +"</td>"
	   +"</tr>"
	   +"<tr>"
	   +"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>购建年份:</label></td>"
	   +"<td style=\"width:40%\">"
	   +"<input id=\"textbox1\"  name=\"buildDate\" class=\"mini-datepicker\" style=\"width:90%\"/>"
	   +"</td>"
	   +"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>购建价格:</label></td>"
	   +"<td style=\"width:40%\">"
	   +"<input id=\"textbox1\"  name=\"buildPrice\" class=\"mini-textbox\" style=\"width:90%\"/>"
	   +"</td>"
	   +"</tr>"
	   +"<tr>"
	   +"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>占地面积:</label></td>"
	   +"<td style=\"width:40%\">"
	   +"<input id=\"textbox1\"  name=\"floorArea\" class=\"mini-textbox\" style=\"width:90%\"/>"
	   +"</td>"
	   +"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>当前评估价格:</label></td>"
	   +"<td style=\"width:40%\">"
	   +"<input id=\"textbox1\"  name=\"assessPrice\" class=\"mini-textbox\" style=\"width:90%\"/>"
	   +"</td>"
	   +"</tr>"
	   +"</table>"
	   +"</td>"
	   +"</tr>"
	   +"</table>"
	   +"</form>";
  return str;
}
function FarmerForest(index){
	var str="<form  id=\"farmerForest"+index+"\" class=\"farmerForest\" method=\"POST\">"
		+"<input type=\"hidden\" name=\"forestId\"/>"
		+"<input name=\"recorder\" class=\"mini-hidden\" value=\"管理员\"/>"
		+"<input name=\"recordTime\" class=\"mini-hidden\" value=\"${currentTime}\"/>"
		+"<table border=\"0\" cellpadding=\"1\" cellspacing=\"15\" width=\"100%\" >"
		+"<tr>"
		+"<td colspan=\"4\" style=\"width:100%\">"
		+"<table width=\"100%\">"
		+"<tr>"
		+"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>林权证编号:</label></td>"
		+"<td style=\"width:40%\">"
		+"<input id=\"textbox1\"  name=\"cardNum\" class=\"mini-textbox\" required=\"true\""
		+"requiredErrorText=\"林权证编号不能为空\"style=\"width:90%\"/>"
		+"</td>"
		+"<td style=\"width:10%\"><label for=\"textbox2$text\"><font color=\"red\">*</font>林权字号:</label></td>"
		+"<td style=\"width:40%\" >"
		+"<input id=\"textbox2\"  name=\"wordNum\" class=\"mini-textbox\" required=\"true\""
		+"requiredErrorText=\"林权字号不能为空\" style=\"width:90%\"/>"
		+"</td>"
		+"</tr>"
		+"<tr>"
		+"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>林权使用人:</label></td>"
		+"<td style=\"width:40%\">"
		+"<input id=\"textbox1\"  name=\"user\" class=\"mini-textbox\" required=\"true\""
		+"requiredErrorText=\"林权使用人不能为空\" style=\"width:90%\"/>"
		+"</td>"
		+"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>林权使用种类:</label></td>"
		+"<td style=\"width:40%\">"
		+"<input id=\"textbox1\"  name=\"useType\" class=\"mini-textbox\" required=\"true\""
		+"requiredErrorText=\"林权使用种类不能为空\" style=\"width:90%\"/>"
		+"</td>"
		+"</tr>"
		+"<tr>"
		+"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>面积(亩):</label></td>"
		+"<td style=\"width:40%\">"
		+"<input id=\"textbox1\"  name=\"area\" class=\"mini-textbox\" required=\"true\""
		+"requiredErrorText=\"面积不能为空\" style=\"width:90%\"/>"
		+"</td>"
		+"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>蓄积量:</label></td>"
		+"<td style=\"width:40%\">"
		+"<input id=\"textbox1\"  name=\"storeNum\" class=\"mini-textbox\" required=\"true\""
		+"requiredErrorText=\"蓄积量不能为空\" style=\"width:90%\"/>"
		+"</td>"
		+"</tr>"
		+"<tr>"
		+"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>使用权期限:</label></td>"
		+"<td style=\"width:40%\">"
		+"<input id=\"textbox1\"  name=\"timeLimit\" class=\"mini-textbox\" required=\"true\""
		+"requiredErrorText=\"使用权期限不能为空\" style=\"width:90%\"/>"
		+"</td>"
		+"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>当前评估价格:</label></td>"
		+"<td style=\"width:40%\">"
		+"<input id=\"textbox1\"  name=\"assessPrice\" class=\"mini-textbox\" required=\"true\""
		+"requiredErrorText=\"当前评估价格不能为空\" style=\"width:90%\"/>"
		+"</td>"
		+"</tr>"
		+"</table>"
		+"</td>"
		+"</tr>"
		+"</table>"
		+"</form>";
	return str;
}
function FarmerIncome(index){
	var str="<form id=\"farmerIncome"+index+"\" class=\"farmerIncome\" method=\"POST\">"
        +"<input name=\"id\" class=\"mini-hidden\" />"
        +"<table border=\"0\" cellpadding=\"1\" cellspacing=\"15\" width=\"100%\" >"
        +"<tr>"
        +"<td>"
        +"<table width=\"100%\" >"
        +"<tr>"
        +"<td style=\"width:12%\"><label for=\"textbox1$text\">家庭收入来源:</label></td>"
        +"<td style=\"width:38%\">"
        +"<input id=\"textbox1\"  name=\"incomeType\" class=\"mini-combobox\" required=\"true\""
        +"requiredErrorText=\"家庭收入来源不能为空\" style=\"width:90%\""
        +"url=\"/bank/dic/IncomeType.txt\" emptyText=\"请选择...\"/>"
        +"</td>"
        +"<td style=\"width:12%\"><label for=\"textbox2$text\">农作物或项目名称:</label></td>"
        +"<td style=\"width:38%\" >"
        +"<input id=\"textbox2\"  name=\"incomeName\" class=\"mini-textbox\" required=\"true\""
        +"requiredErrorText=\"名称不能为空\"  style=\"width:90%\"/>"
        +"</td>"
        +"</tr>"
        +"<tr>"
        +"<td style=\"width:12%\"><label for=\"textbox1$text\">净收入:</label></td>"
        +"<td style=\"width:38%\">"
        +"<input id=\"sp1\" name=\"netIncome\" class=\"mini-spinner\"  minValue=\"0\""
        +"maxValue=\"99999999\" format=\"n\" style=\"width:90%\"/>"
        +"</td>"
        +"</tr>"
        +"</table>"
        +"</td>"
        +"</tr>"
        +"</table>"
        +"</form>";
	return str;
}
function FarmerDevice(index){
	var str="<form  id=\"farmerDevice"+index+"\" class=\"farmerDevice\" method=\"POST\">"
		+"<input type=\"hidden\" name=\"id\"/>"
		+"<table border=\"0\" cellpadding=\"1\" cellspacing=\"10\" width=\"100%\" >"
		+"<tr><td style=\"width:100%\">"
		+"<table width=\"100%\">"
		+"<tr>"
		+"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>设备名称:</label></td>"
		+"<td style=\"width:40%\">"
		+"<input id=\"textbox1\"  name=\"name\" class=\"mini-textbox\" required=\"true\""
		+"requiredErrorText=\"设备名称不能为空\" style=\"width:90%\"/>"
		+"</td>"
		+"<td style=\"width:10%\"><label for=\"textbox2$text\"><font color=\"red\">*</font>品牌型号:</label></td>"
		+"<td style=\"width:40%\">"
		+"<input id=\"textbox2\"  name=\"brand\" class=\"mini-textbox\" style=\"width:90%\"/>"
		+"</td>"
		+"</tr>"
		+"<tr>"
		+"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>构建价格:</label></td>"
		+"<td style=\"width:40%\">"
		+"<input id=\"textbox1\"  name=\"price\" class=\"mini-spinner\" required=\"true\""
		+"requiredErrorText=\"购建价格不能为空\" style=\"width:90%\""
		+"minValue=\"0\" maxValue=\"9999999\"/>"
		+"</td>"
		+"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>购进年份:</label></td>"
		+"<td style=\"width:40%\">"
		+"<input id=\"textbox1\"  name=\"year\" class=\"mini-textbox\" required=\"true\""
		+"requiredErrorText=\"购进年份不能为空\" style=\"width:90%\"/>"
		+"</td>"
		+"</tr>"
		+"<tr>"
		+"<td style=\"width:10%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>当前评估价格:</label></td>"
		+"<td style=\"width:40%\">"
		+"<input id=\"textbox1\"  name=\"assessPrice\" class=\"mini-spinner\" required=\"true\""
		+"requiredErrorText=\"当前评估价格不能为空\" style=\"width:90%\""
		+"minValue=\"0\" maxValue=\"9999999\"/>"
		+"</td>"
		+"</tr>"
		+"</table>"
		+"</td>"
		+"</tr>"
		+"</table>"
		+"</form>";
		return str;
	
}
function FarmerBreed(index){
	var str="<form  id=\"farmerBreed"+index+"\" class=\"farmerBreed\" method=\"POST\">"
	+"<input type=\"hidden\" name=\"id\"/>"
	+"<table border=\"0\" cellpadding=\"1\" cellspacing=\"15\" width=\"100%\" >"
	+"<tr><td style=\"width:100%\">"
	+"<table width=\"100%\">"
	+"<tr>"
	+"<td style=\"width:15%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>种养殖品种:</label></td>"
	+"<td style=\"width:35%\">"
	+"<input name=\"variety\" class=\"mini-textbox\""
	+"required=\"true\"  requiredErrorText=\"不能为空\" style=\"width:90%\"/>"
	+"</td>"
	+"<td style=\"width:15%\"><label for=\"textbox2$text\"><font color=\"red\">*</font>年产量(或出栏量):</label></td>"
	+"<td style=\"width:35%\">"
	+"<input name=\"output\" class=\"mini-textbox\""
	+"required=\"true\"  requiredErrorText=\"不能为空\" style=\"width:90%\"/>"
	+"</td>"
	+"</tr>"
	+"<tr>"
	+"<td style=\"width:15%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>占地面积(亩)</label></td>"
	+"<td style=\"width:35%\">"
	+"<input name=\"floorArea\" class=\"mini-spinner\""
	+"required=\"true\" requiredErrorText=\"不能为空\" style=\"width:90%\"/>"
	+"</td>"
	+"<td style=\"width:15%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>年平均产值(万元)</label></td>"
	+"<td style=\"width:35%\">"
	+"<input name=\"outputValue\" class=\"mini-spinner\""
	+"required=\"true\" requiredErrorText=\"不能为空\" style=\"width:90%\"/>"
	+"</td>"
	+"</tr>"
	+"<tr>"
	+"<td style=\"width:15%\"><label for=\"textbox1$text\"><font color=\"red\">*</font>当前评估价格:</label></td>"
	+"<td style=\"width:35%\">"
	+"<input name=\"assessPrice\" class=\"mini-spinner\""
	+"required=\"true\" requiredErrorText=\"不能为空\" style=\"width:90%\"/>"
	+"</td>"
	+"</tr>"
	+"</table>"
	+"</td>"
	+"</tr>"
	+"</table>"
	+"</form>";
	return str;
}