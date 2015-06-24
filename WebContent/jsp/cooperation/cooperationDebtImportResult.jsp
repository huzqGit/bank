<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
    <div id="datagrid1" class="mini-datagrid" style="width:100%;height:140px" 
    		frozenStartColumn="0" frozenEndColumn="1"
            url="${pageContext.request.contextPath}/economy/debt/loadFileResult.do" idField="debtid"
            sizeList="[5,10,20,50]" pageSize="10" >
	        <div property="columns">
		          <div type="indexcolumn" >#</div>
           		<div field="error_label" width="450" align="center" headerAlign="center">失败原因</div>
           		<div field="yearmonth" width="120" headerAlign="center" allowSort="true" >年月</div>
		          <div field="cooperationname" width="120" headerAlign="center" allowSort="true" >合作组织名称</div>
		          <div field="organcode" width="120" headerAlign="center" allowSort="true" >组织机构编码</div>
		         	<!--
		         	select 
				'<div field="'||lower(name)||'" width="120" headerAlign="center" allowSort="true" >'||t.REMARKS||'</div>',
				'<div field="'||lower(name)||'2" width="120" headerAlign="center" allowSort="true" >'||t.REMARKS||'(期望值)</div>'
				from sysibm.syscolumns t where TBNAME='T_COOPERATION_DEBT'
				and t.REMARKS not like '%期末值%' and lower(t.NAME) not in('debtid','organcode','recorder','yearmonth','cooperationname','recordtime','organ_id')
				order by COLNO;
		         	-->
		         	<div field="cashcapital" width="120" headerAlign="center" allowSort="true" >货币资金</div>	<div field="cashcapital2" width="120" headerAlign="center" allowSort="true" >货币资金(期望值)</div>
				<div field="shortinvest" width="120" headerAlign="center" allowSort="true" >短期投资</div>	<div field="shortinvest2" width="120" headerAlign="center" allowSort="true" >短期投资(期望值)</div>
				<div field="receivables" width="120" headerAlign="center" allowSort="true" >应收账款净额</div>	<div field="receivables2" width="120" headerAlign="center" allowSort="true" >应收账款净额(期望值)</div>
				<div field="prepayment" width="120" headerAlign="center" allowSort="true" >预付账款</div>	<div field="prepayment2" width="120" headerAlign="center" allowSort="true" >预付账款(期望值)</div>
				<div field="inventory" width="120" headerAlign="center" allowSort="true" >存货</div>	<div field="inventory2" width="120" headerAlign="center" allowSort="true" >存货(期望值)</div>
				<div field="floatasset" width="120" headerAlign="center" allowSort="true" >其他流动资产</div>	<div field="floatasset2" width="120" headerAlign="center" allowSort="true" >其他流动资产(期望值)</div>
				<div field="floatassetall" width="120" headerAlign="center" allowSort="true" >流动资产合计</div>	<div field="floatassetall2" width="120" headerAlign="center" allowSort="true" >流动资产合计(期望值)</div>
				<div field="fixedasset" width="120" headerAlign="center" allowSort="true" >固定资产原价</div>	<div field="fixedasset2" width="120" headerAlign="center" allowSort="true" >固定资产原价(期望值)</div>
				<div field="deprecication" width="120" headerAlign="center" allowSort="true" >其中折旧</div>	<div field="deprecication2" width="120" headerAlign="center" allowSort="true" >其中折旧(期望值)</div>
				<div field="netvalue" width="120" headerAlign="center" allowSort="true" >固定资产净值</div>	<div field="netvalue2" width="120" headerAlign="center" allowSort="true" >固定资产净值(期望值)</div>
				<div field="buildingproject" width="120" headerAlign="center" allowSort="true" >在建项目</div>	<div field="buildingproject2" width="120" headerAlign="center" allowSort="true" >在建项目(期望值)</div>
				<div field="fixedassetall" width="120" headerAlign="center" allowSort="true" >固定资产合计</div>	<div field="fixedassetall2" width="120" headerAlign="center" allowSort="true" >固定资产合计(期望值)</div>
				<div field="invisibleasset" width="120" headerAlign="center" allowSort="true" >无形及递延资产合计</div>	<div field="invisibleasset2" width="120" headerAlign="center" allowSort="true" >无形及递延资产合计(期望值)</div>
				<div field="assetall" width="120" headerAlign="center" allowSort="true" >资产合计</div>	<div field="assetall2" width="120" headerAlign="center" allowSort="true" >资产合计(期望值)</div>
				<div field="shortloan" width="120" headerAlign="center" allowSort="true" >短期借款</div>	<div field="shortloan2" width="120" headerAlign="center" allowSort="true" >短期借款(期望值)</div>
				<div field="bankloan" width="120" headerAlign="center" allowSort="true" >银行借款</div>	<div field="bankloan2" width="120" headerAlign="center" allowSort="true" >银行借款(期望值)</div>
				<div field="accountspayable" width="120" headerAlign="center" allowSort="true" >应付账款</div>	<div field="accountspayable2" width="120" headerAlign="center" allowSort="true" >应付账款(期望值)</div>
				<div field="depositreceived" width="120" headerAlign="center" allowSort="true" >预收账款</div>	<div field="depositreceived2" width="120" headerAlign="center" allowSort="true" >预收账款(期望值)</div>
				<div field="unpaidtax" width="120" headerAlign="center" allowSort="true" >未缴税金</div>	<div field="unpaidtax2" width="120" headerAlign="center" allowSort="true" >未缴税金(期望值)</div>
				<div field="floatdebt" width="120" headerAlign="center" allowSort="true" >其他流动负债</div>	<div field="floatdebt2" width="120" headerAlign="center" allowSort="true" >其他流动负债(期望值)</div>
				<div field="floatdebtall" width="120" headerAlign="center" allowSort="true" >流动负债合计</div>	<div field="floatdebtall2" width="120" headerAlign="center" allowSort="true" >流动负债合计(期望值)</div>
				<div field="longdebtall" width="120" headerAlign="center" allowSort="true" >长期负债合计</div>	<div field="longdebtall2" width="120" headerAlign="center" allowSort="true" >长期负债合计(期望值)</div>
				<div field="registercapital" width="120" headerAlign="center" allowSort="true" >注册资本</div>	<div field="registercapital2" width="120" headerAlign="center" allowSort="true" >注册资本(期望值)</div>
				<div field="realcapital" width="120" headerAlign="center" allowSort="true" >实收资本</div>	<div field="realcapital2" width="120" headerAlign="center" allowSort="true" >实收资本(期望值)</div>
				<div field="capitalreserve" width="120" headerAlign="center" allowSort="true" >资本公积</div>	<div field="capitalreserve2" width="120" headerAlign="center" allowSort="true" >资本公积(期望值)</div>
				<div field="surplusreserve" width="120" headerAlign="center" allowSort="true" >盈余公积</div>	<div field="surplusreserve2" width="120" headerAlign="center" allowSort="true" >盈余公积(期望值)</div>
				<div field="unallotprofit" width="120" headerAlign="center" allowSort="true" >未分配利润</div>	<div field="unallotprofit2" width="120" headerAlign="center" allowSort="true" >未分配利润(期望值)</div>
				<div field="totalequity" width="120" headerAlign="center" allowSort="true" >所有者权益合计</div>	<div field="totalequity2" width="120" headerAlign="center" allowSort="true" >所有者权益合计(期望值)</div>
				<div field="totalequity1" width="120" headerAlign="center" allowSort="true" >负债和所有者权益合计</div>	<div field="totalequity12" width="120" headerAlign="center" allowSort="true" >负债和所有者权益合计(期望值)</div>
				<div field="handingcost" width="120" headerAlign="center" allowSort="true" >管理费用</div>	<div field="handingcost2" width="120" headerAlign="center" allowSort="true" >管理费用(期望值)</div>
				<div field="financialcost" width="120" headerAlign="center" allowSort="true" >财务费用</div>	<div field="financialcost2" width="120" headerAlign="center" allowSort="true" >财务费用(期望值)</div>
				<div field="interestexpense" width="120" headerAlign="center" allowSort="true" >其中利息支出</div>	<div field="interestexpense2" width="120" headerAlign="center" allowSort="true" >其中利息支出(期望值)</div>
				<div field="businessprofit" width="120" headerAlign="center" allowSort="true" >营业利润</div>	<div field="businessprofit2" width="120" headerAlign="center" allowSort="true" >营业利润(期望值)</div>
				<div field="investincome" width="120" headerAlign="center" allowSort="true" >投资收益</div>	<div field="investincome2" width="120" headerAlign="center" allowSort="true" >投资收益(期望值)</div>
				<div field="subsidyincome" width="120" headerAlign="center" allowSort="true" >国家补贴收入</div>	<div field="subsidyincome2" width="120" headerAlign="center" allowSort="true" >国家补贴收入(期望值)</div>
				<div field="unbusinessincome" width="120" headerAlign="center" allowSort="true" >营业外收入</div>	<div field="unbusinessincome2" width="120" headerAlign="center" allowSort="true" >营业外收入(期望值)</div>
				<div field="unbusinessexpense" width="120" headerAlign="center" allowSort="true" >营业外支出</div>	<div field="unbusinessexpense2" width="120" headerAlign="center" allowSort="true" >营业外支出(期望值)</div>
				<div field="profitloss" width="120" headerAlign="center" allowSort="true" >以前年度损益调整</div>	<div field="profitloss2" width="120" headerAlign="center" allowSort="true" >以前年度损益调整(期望值)</div>
				<div field="totalprofit" width="120" headerAlign="center" allowSort="true" >利润总和</div>	<div field="totalprofit2" width="120" headerAlign="center" allowSort="true" >利润总和(期望值)</div>
				<div field="payableincometax" width="120" headerAlign="center" allowSort="true" >应交所得税</div>	<div field="payableincometax2" width="120" headerAlign="center" allowSort="true" >应交所得税(期望值)</div>
				<div field="payableaddedtax" width="120" headerAlign="center" allowSort="true" >应交增值税</div>	<div field="payableaddedtax2" width="120" headerAlign="center" allowSort="true" >应交增值税(期望值)</div>
				<div field="paidaddedtax" width="120" headerAlign="center" allowSort="true" >实交增值税</div>	<div field="paidaddedtax2" width="120" headerAlign="center" allowSort="true" >实交增值税(期望值)</div>
				<div field="netprofit" width="120" headerAlign="center" allowSort="true" >利润净额</div>	<div field="netprofit2" width="120" headerAlign="center" allowSort="true" >利润净额(期望值)</div>
	         </div>
	     </div>
	</div>
</body>
<script type="text/javascript">
mini.parse();
var grid = mini.get("datagrid1");
grid.load()
</script>
</html>