<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bank.common.util.DateUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主要财务情况--资产负债表</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js"
	type="text/javascript"></script>
</head>
<style>
td{
	border:1px solid #ccc; 
	margin:0;
	padding:0;
}
tr{border:1px solid #ccc; }
</style>
<body>
	<center style="margin-top:15px"><h2>资产负债表</h2></center>
	<div style='padding-left: 0; padding-right: 0'>
		<div style="font-size:15px;text-align:right;margin-right:100px"><b>币种：人民币  单位：元</b></div>
	</div>
	<!-- 
		select '<tr><td style="text-align:center">'||rn||'</td>','<td><label>'||remarks||'</label></td>','<td><div id="'||name||'" name="'||name||'">&nbsp;</div></td>','<td>&nbsp;</td></tr>' from (select row_number() over()+1 rn,lower(name) name,remarks from sysibm.syscolumns t where TBNAME='T_COOPERATION_DEBT'
		and lower(t.NAME) not in ('debtid','cooperationname','organcode','recorder','recordtime')
		order by t.colno) where rn<=30
		order by rn ;
		reorg table T_COOPERATION_DEBT
	 -->
	<div id="form1" style="width: 90%; margin: auto auto">
		<form action="#" method="POST">
			<tr><td>
			<table width="100%" style="boder-style:solid"  border="0" cellpadding="0" cellspacing="0">
				<tr>
					<th style="width:10%;">编号</th><th style="width:30%">项目</th><th style="width:30%">期初数</th><th style="width:30%">期末数</th>
				</tr>
				<tr>
					<td style="text-align:center">1</td>
					<td><label>年月</label></td>
					<td><div id="yearmonth" name="yearmonth">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">2</td>
					<td><label>货币资金</label></td>
					<td><div id="cashcapital" name="cashcapital">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">3</td>
					<td><label>短期投资</label></td>
					<td><div id="shortinvest" name="shortinvest">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">4</td>
					<td><label>应收账款净额</label></td>
					<td><div id="receivables" name="receivables">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">5</td>
					<td><label>预付账款</label></td>
					<td><div id="prepayment" name="prepayment">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">6</td>
					<td><label>存货</label></td>
					<td><div id="inventory" name="inventory">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">7</td>
					<td><label>其他流动资产</label></td>
					<td><div id="floatasset" name="floatasset">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">8</td>
					<td><label>流动资产合计</label></td>
					<td><div id="floatassetall" name="floatassetall">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">9</td>
					<td><label>固定资产原价</label></td>
					<td><div id="fixedasset" name="fixedasset">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">10</td>
					<td><label>其中折旧</label></td>
					<td><div id="deprecication" name="deprecication">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">11</td>
					<td><label>固定资产净值</label></td>
					<td><div id="netvalue" name="netvalue">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">12</td>
					<td><label>在建项目</label></td>
					<td><div id="buildingproject" name="buildingproject">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">13</td>
					<td><label>固定资产合计</label></td>
					<td><div id="fixedassetall" name="fixedassetall">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">14</td>
					<td><label>无形及递延资产合计</label></td>
					<td><div id="invisibleasset" name="invisibleasset">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">15</td>
					<td><label>资产合计</label></td>
					<td><div id="assetall" name="assetall">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">16</td>
					<td><label>短期借款</label></td>
					<td><div id="shortloan" name="shortloan">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">17</td>
					<td><label>银行借款</label></td>
					<td><div id="bankloan" name="bankloan">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">18</td>
					<td><label>应付账款</label></td>
					<td><div id="accountspayable" name="accountspayable">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">19</td>
					<td><label>预收账款</label></td>
					<td><div id="depositreceived" name="depositreceived">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">20</td>
					<td><label>未缴税金</label></td>
					<td><div id="unpaidtax" name="unpaidtax">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">21</td>
					<td><label>其他流动负债</label></td>
					<td><div id="floatdebt" name="floatdebt">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">22</td>
					<td><label>流动负债合计</label></td>
					<td><div id="floatdebtall" name="floatdebtall">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">23</td>
					<td><label>长期负债合计</label></td>
					<td><div id="longdebtall" name="longdebtall">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">24</td>
					<td><label>注册资本</label></td>
					<td><div id="registercapital" name="registercapital">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">25</td>
					<td><label>实收资本</label></td>
					<td><div id="realcapital" name="realcapital">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">26</td>
					<td><label>资本公积</label></td>
					<td><div id="capitalreserve" name="capitalreserve">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">27</td>
					<td><label>盈余公积</label></td>
					<td><div id="surplusreserve" name="surplusreserve">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">28</td>
					<td><label>未分配利润</label></td>
					<td><div id="unallotprofit" name="unallotprofit">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">29</td>
					<td><label>所有者权益合计</label></td>
					<td><div id="totalequity" name="totalequity">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="text-align: center">30</td>
					<td><label>负债和所有者权益合计</label></td>
					<td><div id="totalequity1" name="totalequity1">&nbsp;</div></td>
					<td>&nbsp;</td>
				</tr>
			</table>
			</td></tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
	mini.parse();
	var form = new mini.Form("#form1");
	//查询表单数据
	$(document).ready(function() {
		$.ajax({
			url : "${pageContext.request.contextPath}/economy/findCooperation.do",
			type : "post",
			data : {cooperationId : "${cooperationId}"},
			success : function(text) {
				var data = mini.decode(text); //反序列化成对象
			},
			error : function(text, arg2) {
			}
		});
	});

	function back() {
		history.go(-1);
	}
</script>
</html>