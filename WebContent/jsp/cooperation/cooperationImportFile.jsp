<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/jsp/farmer/form.css"  rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/miniui/jquery-1.6.2.min.js" type="text/javascript"></script>
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
    <script type="text/javascript">
    	function test(){
    		$(".load").css("display","block");
    		return true;
    	}
    </script>
</head>
<body>

<div class="queryPane">
<form action="/bank/economy/importFile.do" method="post" enctype="multipart/form-data" onsubmit="test()">
<table width="100%" height ="30px" >
 	<tr>
 		<td class="labelName" width="30%" align="right">
        	请选择文件路径：
        </td>
    	<td width="15%" >
        	<input type='text' name='textfield' id='textfield' class='bank-text' value="" />
        </td>
        <td width="15%" >
        	<div style="position:relative">
	            <input class="bank-btn" type="button" value="浏览"  />
	        	<input type="file" name="myfile" class="file" id="myfile" size="28" onchange="document.getElementById('textfield').value=this.value" />
       		</div>
        </td>
        <td align="left">
            <input id="uploadFile" class="bank-btn" type="submit" name="submit" value="上传"/>
        </td>
     </tr>
 </table>
</form>
</div>
<fieldset style="width:90%;margin:auto auto;border:1px solid orange">
<legend style="width:310px;height:74px;background:url(/bank/images/filetips.png) no-repeat"></legend>
<div style="width:100%;height:20px;">
                <ol>
                    <li>
                        	支持EXCEL格式导入
                    </li>
                    <li>
                        	导入文件数据比较大时、可能需要等待一段时间
                    </li>
                </ol>

 </div>
</fieldset>
<div class="load" style="display:none;text-align:center;padding-top:50px">
	<span>正在上传文件</span>
	<img src="${pageContext.request.contextPath}/images/loading.gif"/>
</div>
<c:if test="${!empty msgs}">
<div style="scrollbar-face-color:#6DC8E3;width:90%;height:200px;overflow-y:auto;margin-top:20px;margin-left:auto;margin-right:auto">
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
</body>
</html>