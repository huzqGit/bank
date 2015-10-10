<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<style type="text/css">
 *{ margin:0;padding:0;}
body{font-size: 14px; }
legend{

            font-weight: bold;
            color: seagreen;
            font-family:"圆幼","宋体" ;
        }
        li{
            margin-top: 5px;
            text-align:left;
            width:100%;
            margin-left: 30px;
        }
        .txt{ height:22px; border:1px solid #cdcdcd; width:180px;}
        .btn{ background-color:#FFF; 
        border:1px solid #CDCDCD;height:24px; width:70px;
        display:inline-block;
        }
        .file{
        position:absolute;
        top:0px;
        left:0px;
        width:120px;
        height:24px;
		opacity:0;
		filter:alpha(opacity=0);
	
		}
		table{
			color:#333333;
			border-width: 1px;
			border-color: darkgray;
			border-collapse: collapse;
		}
    </style>
    <script type="text/javascript">
    	function test(){
    		$(".load").css("display","block");
    		return true;
    	}
    </script>
</head>
<body>

<div class="queryPane">
<form action="/bank/farmer/importFarmerCompunish.do" method="post" enctype="multipart/form-data" onsubmit="return validateSubmit();">
<table width="100%">
	<tr>
		<td class="labelName" width="15%" align="right">请选择数据来源：</td>
		<td  width="15%">
			<input id="sourcecode" name="sourcecode" class="mini-buttonedit txt" onbuttonclick="onButtonEdit"/>
		</td>
 		<td class="labelName" width="15%" align="right">请选择文件路径：</td>
    		<td width="15%" >
        		<input type='text' name='textfield' id='textfield' class='bank-text' value="" />
        	</td>
        	<td width="15%" >
        	<div style="position:relative">
	          <input id="scanFile" type='button' class='bank-btn' value="浏览"  />
	        	<input type="file" name="myfile" class="file" id="mufile" size="28" onchange="judgeFile(this)" />
       	</div>
        </td>
        <td align="left" >
            <input id="uploadFile" type="submit" name="submit" class='bank-btn' value="上传"/>
        </td>
        
     </tr>
 </table>
</form>
</div>
<c:choose>
	<c:when test="${empty msgs}">
	<fieldset style="width:90%;margin:auto auto;border:1px solid orange">
	<legend style="width:310px;height:74px;background:url(/bank/images/filetips.png) no-repeat"></legend>
	<div style="width:100%;height:20px;">
		<ol>
			<li>数据采集小组使用标准模版<a href="/bank/jsp/farmer/model/farmerCompunish.xls"><font color="red">奖惩信息</font></a>采集数据后导入系统。</li>
	        <li> 导入文件数据比较大时、可能需要等待一段时间 </li>
	    </ol>
	 </div>
	</fieldset>
	</c:when>
	<c:otherwise>
	<div style="scrollbar-face-color:#6DC8E3;width:90%;height:200px;overflow-y:auto;margin-top:20px;margin-left:auto;margin-right:auto">
	<table  id="tips" border="1" cellspacing=0 cellpadding=0 >
	<c:forEach items="${msgs}" var="msg" varStatus="status" >
		<tr >
			<td width="10%" align="center"> ${status.index}</td>
			<td >${msg.msg}</td>
		</tr>
	</c:forEach>
	</table>
	</div>
	</c:otherwise>
</c:choose>
<div class="load" style="display:none;text-align:center;padding-top:50px">
	<span>正在上传文件</span>
	<img src="${pageContext.request.contextPath}/images/loading.gif"/>
</div>
<script type="text/javascript">
mini.parse();
function judgeFile(htmlEl){
	if(htmlEl){
		var v = htmlEl.value;
		var str = v.substr(v.lastIndexOf(".")+1).toUpperCase();
		if(str != "XLS" && str != "XLSX"){
			alert("文件格式不正确,请选择Excel文件");
			document.getElementById('textfield').value = '';
		}else{
			document.getElementById('textfield').value=v;
		}
	}
}
function validateSubmit(){
	var ls = mini.get("sourcecode").getValue();
	if(ls =='' || ls==null){
		mini.alert("请选择数据来源");
		return false;
	}
	
	var s = document.getElementById('textfield').value;
	if(s == ''  || s == null){
		mini.alert('请选择文件后操作');
		return false;
	}
	$(".load").css("display","block");
	return true;;
}
function onButtonEdit(e) {
   var btnEdit = this;
    mini.open({
        url: "/bank/common/viewView.do?dest=cooperation/mapt/mapt",
        showMaxButton: false,
        title: "选择树",
        width: 450,
        height: 353,
        ondestroy: function (action) {                    
            if (action == "ok") {
                var iframe = this.getIFrameEl();
                var data = iframe.contentWindow.GetData();
                data = mini.clone(data);
                if (data) {
                    btnEdit.setValue(data.id);
                    btnEdit.setText(data.text);
                }
            }
        }
    });            
     
}
</script>
</body>
</html>