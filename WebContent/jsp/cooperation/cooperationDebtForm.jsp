<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农民专业合作经济组织基本概况信息</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
<div class="mini-toolbar" style="padding-top:5px;border-bottom:0;">
	<table style="width:100%;">
    	<tr>
        	<td style="white-space:nowrap;">
        		<span style="${display}">
		        	<a class="mini-button" iconCls="icon-save" plain="true" onclick="submitForm()">保存</a>
		           	<span class="separator"></span>
	            </span>
	            <a class="mini-button" iconCls="icon-upgrade" plain="true" onclick="back()">返回</a>
                <span class="separator"></span>
            </td>
         </tr>
      </table>
</div>
<div id="form1" style="width:90%;margin:auto auto">
	<form action="${pageContext.request.contextPath}/economy/debt/saveCooperationDebt.do" method="POST">
	<input name="debtid" class="mini-hidden" value="${debtid}"/>
	<input name="recorder" class="mini-hidden" value="管理员"/>
	<input name="recordTime" class="mini-hidden" value="${currentTime}"/>
	<table border="0" cellpadding="1" cellspacing="15" width="100%" >
	<tr>
	<td colspan="4" style="width:100%">
	<fieldset id="fd2" style="width:100%;margin:auto auto">
	<legend><label>农民专业合作经济组织主要财务指标数</label></legend>
	<div class="fieldset-body">
	<table width="100%">
	<tr>
		<td style="width:10%"><label for="textbox1$text">合作社名称:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="cooperationname" class="mini-textbox" required="true" 
			requiredErrorText="合作社名称不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">组织机构编码:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="organcode" class="mini-textbox" required="true" 
			requiredErrorText="组织机构编码不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">应付账款:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="accountspayable" class="mini-textbox" required="true" 
			requiredErrorText="应付账款不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">资产合计:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="assetall" class="mini-textbox" required="true" 
			requiredErrorText="资产合计不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">银行借款:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="bankloan" class="mini-textbox" required="true" 
			requiredErrorText="银行借款不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">在建项目:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="buildingproject" class="mini-textbox" required="true" 
			requiredErrorText="在建项目不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">营业利润:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="businessprofit" class="mini-textbox" required="true" 
			requiredErrorText="营业利润不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">资本公积:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="capitalreserve" class="mini-textbox" required="true" 
			requiredErrorText="资本公积不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">货币资金:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="cashcapital" class="mini-textbox" required="true" 
			requiredErrorText="货币资金不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">预收账款:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="depositreceived" class="mini-textbox" required="true" 
			requiredErrorText="预收账款不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">其中折旧:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="deprecication" class="mini-textbox" required="true" 
			requiredErrorText="其中折旧不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">财务费用:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="financialcost" class="mini-textbox" required="true" 
			requiredErrorText="财务费用不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">固定资产原价:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="fixedasset" class="mini-textbox" required="true" 
			requiredErrorText="固定资产原价不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">固定资产合计:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="fixedassetall" class="mini-textbox" required="true" 
			requiredErrorText="固定资产合计不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">其他流动资产:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="floatasset" class="mini-textbox" required="true" 
			requiredErrorText="其他流动资产不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">流动资产合计:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="floatassetall" class="mini-textbox" required="true" 
			requiredErrorText="流动资产合计不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">其他流动负债:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="floatdebt" class="mini-textbox" required="true" 
			requiredErrorText="其他流动负债不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">流动负债合计:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="floatdebtall" class="mini-textbox" required="true" 
			requiredErrorText="流动负债合计不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">管理费用:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="handingcost" class="mini-textbox" required="true" 
			requiredErrorText="管理费用不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">其中利息支出:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="interestexpense" class="mini-textbox" required="true" 
			requiredErrorText="其中利息支出不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">存货:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="inventory" class="mini-textbox" required="true" 
			requiredErrorText="存货不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">投资收益:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="investincome" class="mini-textbox" required="true" 
			requiredErrorText="投资收益不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">无形及递延资产合计:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="invisibleasset" class="mini-textbox" required="true" 
			requiredErrorText="无形及递延资产合计不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">长期负债合计:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="longdebtall" class="mini-textbox" required="true" 
			requiredErrorText="长期负债合计不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">利润净额:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="netprofit" class="mini-textbox" required="true" 
			requiredErrorText="利润净额不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">固定资产净值:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="netvalue" class="mini-textbox" required="true" 
			requiredErrorText="固定资产净值不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">实交增值税:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="paidaddedtax" class="mini-textbox" required="true" 
			requiredErrorText="实交增值税不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">应交增值税:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="payableaddedtax" class="mini-textbox" required="true" 
			requiredErrorText="应交增值税不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">应交所得税:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="payableincometax" class="mini-textbox" required="true" 
			requiredErrorText="应交所得税不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">预付账款:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="prepayment" class="mini-textbox" required="true" 
			requiredErrorText="预付账款"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">以前年度损益调整:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="profitloss" class="mini-textbox" required="true" 
			requiredErrorText="以前年度损益调整不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">实收资本:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="realcapital" class="mini-textbox" required="true" 
			requiredErrorText="实收资本不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">应收账款:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="receivables" class="mini-textbox" required="true" 
			requiredErrorText="实交增值税不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">注册资本:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="registercapital" class="mini-textbox" required="true" 
			requiredErrorText="注册资本不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">短期投资:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="shortinvest" class="mini-textbox" required="true" 
			requiredErrorText="短期投资不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">短期借款:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="shortloan" class="mini-textbox" required="true" 
			requiredErrorText="短期借款不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">国家补贴收入:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="subsidyincome" class="mini-textbox" required="true" 
			requiredErrorText="国家补贴收入不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">盈余公积:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="surplusreserve" class="mini-textbox" required="true" 
			requiredErrorText="盈余公积不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">所有者权益合计:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="totalequity" class="mini-textbox" required="true" 
			requiredErrorText="所有者权益合计不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">负债和所有者权益合计:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="totalequity1" class="mini-textbox" required="true" 
			requiredErrorText="负债和所有者权益合计不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">利润总和:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="totalprofit" class="mini-textbox" required="true" 
			requiredErrorText="利润总和不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">未分配利润:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="unallotprofit" class="mini-textbox" required="true" 
			requiredErrorText="未分配利润不能为空"  style="width:90%"/>
		</td>
	</tr>
	<tr>
		<td style="width:10%"><label for="textbox1$text">营业外支出:</label></td>
		<td style="width:23%">
		<input id="textbox1"  name="unbusinessexpense" class="mini-textbox" required="true" 
			requiredErrorText="营业外支出不能为空" style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox2$text">营业外收入:</label></td>
		<td style="width:23%" >
		<input id="textbox2"  name="unbusinessincome" class="mini-textbox" required="true" 
			requiredErrorText="营业外收入不能为空"  style="width:90%"/>
		</td>
		<td style="width:10%"><label for="textbox3$text">未缴税金:</label></td>
		<td style="width:23%" >
		<input id="textbox3"  name="unpaidtax" class="mini-textbox" required="true" 
			requiredErrorText="未缴税金不能为空"  style="width:90%"/>
		</td>
	</tr>
	
	</table>
	</div>
	</fieldset>
	</td>
	</tr>
	</table>
	</form>
</div>
</body>
<script type="text/javascript">
		mini.parse();
		var form = new mini.Form("#form1");
		//查询表单数据
		$(document).ready(function(){
			$.ajax({
			    url: "${pageContext.request.contextPath}/economy/debt/findCooperationDebt.do",
			    type: "post",
			    data:{debtid:"${debtid}"},
			    success: function (text) {
			        var data = mini.decode(text);   //反序列化成对象
			        if(data.debtid!=null){
			       	 	form.setData(data);  //设置多个控件数据   
			        }
			    },
			    error:function(text,arg2){
			    }
			});
			
		});
		
		function back(){
			history.go(-1);
		}
		
		function submitForm(){
			//提交表单数据
		    var formData = form.getData();      //获取表单多个控件的数据
		   	form.validate();
	      	if (!form.isValid())
	      		return;
		    var json = mini.encode(formData);   //序列化成JSON
		    $.ajax({
		        url: "${pageContext.request.contextPath}/economy/debt/saveCooperationDebt.do",
		        type: "post",
		        data: { formData: json},
		        contentType: "application/x-www-form-urlencoded; charset=utf-8",
		        success: function (text) {
		        	var data = mini.decode(text);   //反序列化成对象
			        if(data.cooperationId!=null){
			       	 	form.setData(data);
			        }
		        	 mini.alert('保存成功！');
		        },
		        error: function (jqXHR, textStatus, errorThrown) {
		            mini.alert('系统异常！');
		        }
			});
		}
	  </script>
</html>