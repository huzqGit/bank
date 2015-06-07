<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
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

function downLoadExcel(){
	window.location.href = '/bank/jsp/cooperation/model/BasicInfoModel.xlsx';
}
function validate(){
	var s = document.getElementById('textfield').value;
	if(s == ''  || s == null){
		alert('请选择文件后操作');
		return false;
	}
	return true;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <style type="text/css">
        *{
         margin:0;
         padding:0;
        }
        body{
            font-size: 14px;
        }
        legend{

            font-weight: bold;
            color: seagreen;
            font-family:"圆幼","宋体" ;
        }
        table{
            margin-top: 10px;
            margin-bottom: 10px;
            width:100%;


        }
        li{
            margin-top: 5px;
            margin-left: 30px;
        }
         input{ vertical-align:middle; margin:0; padding:0}
        .file-box{
         position:relative;
         width:100%;
         margin:auto auto;
         text-align:center;
         background:linear-gradient(white,#6DC8E3,white);
		/* IE6 & IE7 */
		filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
		endColorstr = 'white' ); 
		/* IE8 */
		-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
		endColorstr = 'white' )"; 
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
		.labelName{font-size:15px;font-weight:bold;color:darkgreen;}
		#scanFile{
			width:100px;
			height:25px;
			border:0;
			background:url(/bank/images/scanFile.png) no-repeat;
		}
		#downLoadModel{
			width:100px;
			height:25px;
			border:0;
			background:url(/bank/images/download.png) no-repeat;
		}
		#uploadFile{
			width:100px;
			height:25px;
			border:0;
			background:url(/bank/images/uploadFile.png) no-repeat;
		}
		.success{
			color:green;
			font-weight:bold;
			height:25px;
		}
		.info{
			color:blue;
			font-weight:bold;
			height:25px;
		}
    </style>
</head>
<body>
<div class="file-box">
<form action="/bank/economy/loadFile.do" method="post" enctype="multipart/form-data" onsubmit="return validate();">
<table width="100%" height ="60px" style="border:1px solid #8AD3E9">
 	<tr>
 		<td class="labelName" width="30%" align="right">
        	请选择文件路径：
        </td>
    	<td width="15%" >
        	<input type='text' name='textfield' id='textfield' class='txt' value="" />
        </td>
        <td width="15%" >
        	<div style="position:relative">
	          <input id="scanFile" type='button' class='btn' value=""  />
	        	<input type="file" name="mufile" class="file" id="mufile" size="28" onchange="judgeFile(this)" />
       	</div>
        </td>
        <td align="left" >
            <input id="uploadFile" type="submit" name="submit" value=""/>
            <input id="downLoadModel"  type='button' style="margin-left:25px" class='btn' value="" onclick="downLoadExcel()"/>
        </td>
     </tr>
 </table>
</form>
</div>
<fieldset style="width:90%;margin:auto auto">
<legend style="width:310px;height:74px;background:url(/bank/images/filetips.png) no-repeat"></legend>
<table width="100%">
    <tr>
        <td>
            <div >
                <ol>
                	<li>
                        	请先<a href="/bank/jsp/cooperation/model/BasicInfoModel.xlsx"><font color="red">下载模板</font></a>后,在模板内进行操作
                    </li>
                    <li>
                        	支持EXCEL格式导入[Excel2003,Excel2007 等],本模板为07,需要其余版本请在Excel另存为...
                    </li>
                    <li>
                        	导入文件数据比较大时、可能需要等待一段时间
                    </li>
                </ol>

            </div>
        </td>
    </tr>
</table>
</fieldset>
<c:if test="${!empty msgs}">
<div style="scrollbar-face-color:#6DC8E3;width:90%;height:45px;verflow-y:auto;margin:auto">
<table  id="tips" border="1" cellspacing=0 cellpadding=0 >
<c:forEach items="${msgs}" var="msg">
<tr >
	<c:choose>
		<c:when test="${msg.tip == 'success'}">
			<td class ="success" width="10%" align="center">
				${msg.row}
			</td>
		</c:when>
		<c:when test="${msg.tip == 'error'}">
			<td class="error" width="10%" align="center">
				${msg.row}
			</td>
		</c:when>
		<c:otherwise>
			<td class="info" width="10%" align="center">
			       ${msg.row}
			</td>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${msg.tip == 'success'}">
			<td class ="success" width="10%" align="center">
				成功
			</td>
		</c:when>
		<c:when test="${msg.tip == 'error'}">
			<td class="error" width="10%" align="center">
				失败
			</td>
		</c:when>
		<c:otherwise>
			<td class="info" width="10%" align="center">
			       提示
			</td>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${msg.tip == 'success'}">
			<td class ="success">
				&nbsp;&nbsp;&nbsp;
				${msg.msg}
			</td>
		</c:when>
		<c:when test="${msg.tip == 'error'}">
			<td class="error" >
				&nbsp;&nbsp;&nbsp;
				${msg.msg}
			</td>
		</c:when>
		<c:otherwise>
			<td class="info">
			      &nbsp;&nbsp;&nbsp;
				${msg.msg}
			</td>
		</c:otherwise>
	</c:choose>
	</tr>
</c:forEach>
</table>
</div>
</c:if>
<c:if test="${!empty importError}">
    <iframe src="/bank/common/viewView.do?dest=cooperation/cooperationImportResult" scrolling="no" 
    			width="98%" title="错误记录及原因" frameborder="0" align="center" style="margin-top:-10px">
    </iframe>
</c:if>
 </div>
</body>
</html>