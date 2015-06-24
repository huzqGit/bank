<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
</head>
<body>
    <div id="datagrid1" class="mini-datagrid" style="width:100%;margin:auto auto;height:140px;background-color:white" 
            allowCellEdit="false" allowCellSelect="true" multiSelect="false" allowResize="true"
        	  editNextOnEnterKey="true"  editNextRowCell="true" frozenStartColumn="0" frozenEndColumn="1"
            url="${pageContext.request.contextPath}/economy/profit/loadFileResult.do" idField="profitid"
            sizeList="[5,10,20,50]" pageSize="20" >
	        <div property="columns">
		          <div type="indexcolumn" >#</div>
		          <div field="error_label" width="450" align="center" headerAlign="center" allowSort="true">失败原因</div>
		          <div field="organcode" width="120" headerAlign="center" allowSort="true" >组织机构编码</div>
		          <div field="yearmonth" width="120" headerAlign="center" allowSort="true" >年月</div>
		          <div field="datasendorgan" width="120" headerAlign="center" allowSort="true" >数据报送机构</div>
				<div field="taxcode" width="120" headerAlign="center" allowSort="true" >税务识别码</div>
				<div field="mainincome" width="120" headerAlign="center" allowSort="true" >主营业务收入</div>
				<div field="mainincome_export" width="120" headerAlign="center" allowSort="true" >主营业务收入出口产品销售收入</div>
				<div field="mainincome_import" width="120" headerAlign="center" allowSort="true" >主营业务收入进口产品销售收入</div>
				<div field="discount" width="120" headerAlign="center" allowSort="true" >折扣与拆让</div>
				<div field="mainincome_netmargin" width="120" headerAlign="center" allowSort="true" >主营业务收入净额</div>
				<div field="maincost" width="120" headerAlign="center" allowSort="true" >主营业务成本</div>
				<div field="maincost_export" width="120" headerAlign="center" allowSort="true" >主营业务成本出口产品销售成本</div>
				<div field="maintaxpay" width="120" headerAlign="center" allowSort="true" >主营业务税金及附加</div>
				<div field="operationcost" width="120" headerAlign="center" allowSort="true" >经营费用</div>
				<div field="othercost" width="120" headerAlign="center" allowSort="true" >其他</div>
				<div field="delayincome" width="120" headerAlign="center" allowSort="true" >递延收益</div>
				<div field="purchasingagent" width="120" headerAlign="center" allowSort="true" >代购代销收入</div>
				<div field="otherpurchasingagent" width="120" headerAlign="center" allowSort="true" >其他</div>
				<div field="mainnetmargin" width="120" headerAlign="center" allowSort="true" >主营业务利润</div>
				<div field="othernetmargin" width="120" headerAlign="center" allowSort="true" >其他业务利润</div>
				<div field="mainexpenses" width="120" headerAlign="center" allowSort="true" >营业费用</div>
				<div field="manageexpense" width="120" headerAlign="center" allowSort="true" >管理费用</div>
				<div field="finaceexpense" width="120" headerAlign="center" allowSort="true" >财务费用</div>
				<div field="otherexpense" width="120" headerAlign="center" allowSort="true" >其他</div>
				<div field="income_netmargin" width="120" headerAlign="center" allowSort="true" >营业利润</div>
				<div field="investincome" width="120" headerAlign="center" allowSort="true" >投资收益</div>
				<div field="futuresincome" width="120" headerAlign="center" allowSort="true" >期货收益</div>
				<div field="subsidyincome" width="120" headerAlign="center" allowSort="true" >补贴收入</div>
				<div field="subsidyincome_before" width="120" headerAlign="center" allowSort="true" >补贴收入补贴前亏损的企业补贴收入</div>
				<div field="income_o" width="120" headerAlign="center" allowSort="true" >营业外收入</div>
				<div field="income_o_netmargin" width="120" headerAlign="center" allowSort="true" >营业外收入处置固定资产净收益</div>
				<div field="income_o_nonemoney" width="120" headerAlign="center" allowSort="true" >营业外收入非货币性交易收益</div>
				<div field="income_o_wxzc" width="120" headerAlign="center" allowSort="true" >营业外收入出售无形资产收益</div>
				<div field="income_o_fk" width="120" headerAlign="center" allowSort="true" >营业外收入罚款净收入</div>
				<div field="income_o_other" width="120" headerAlign="center" allowSort="true" >其他</div>
				<div field="income_o_othersalary" width="120" headerAlign="center" allowSort="true" >其他用以前年度含量工资节余弥补利润</div>
				<div field="outcome_o" width="120" headerAlign="center" allowSort="true" >营业外支出</div>
				<div field="outcome_o_netmargin" width="120" headerAlign="center" allowSort="true" >营业外支出处置固定资产净损失</div>
				<div field="outcome_o_zwcz" width="120" headerAlign="center" allowSort="true" >营业外支出债务重组损失</div>
				<div field="outcome_o_fk" width="120" headerAlign="center" allowSort="true" >营业外支出罚款支出</div>
				<div field="outcome_o_jz" width="120" headerAlign="center" allowSort="true" >营业外支出捐赠支出</div>
				<div field="outcome_o_other" width="120" headerAlign="center" allowSort="true" >其他支出</div>
				<div field="outcome_o_othersalary" width="120" headerAlign="center" allowSort="true" >其他支出结转的含量工资包干节余</div>
				<div field="allprofit" width="120" headerAlign="center" allowSort="true" >利润总额</div>
				<div field="incomdetax" width="120" headerAlign="center" allowSort="true" >所得税</div>
				<div field="fewpartnerincome" width="120" headerAlign="center" allowSort="true" >少数股东损益</div>
				<div field="unsureloss" width="120" headerAlign="center" allowSort="true" >未确认的投资损失</div>
				<div field="netmargin" width="120" headerAlign="center" allowSort="true" >净利润</div>
				<div field="beginofyearundistributed" width="120" headerAlign="center" allowSort="true" >年初未分配利润</div>
				<div field="yygjbk" width="120" headerAlign="center" allowSort="true" >盈余公积补亏</div>
				<div field="qttzys" width="120" headerAlign="center" allowSort="true" >其他调整因素</div>
				<div field="kgfpll" width="120" headerAlign="center" allowSort="true" >可供分配的利润</div>
				<div field="dxlyll" width="120" headerAlign="center" allowSort="true" >单项留用的利润</div>
				<div field="bcldzb" width="120" headerAlign="center" allowSort="true" >补充流动资本</div>
				<div field="tqfdyygj" width="120" headerAlign="center" allowSort="true" >提取法定盈余公积</div>
				<div field="tqfdyygyj" width="120" headerAlign="center" allowSort="true" >提取法定公益金</div>
				<div field="tqzgjljfldy" width="120" headerAlign="center" allowSort="true" >提取职工奖励及福利基金</div>
				<div field="tqcbj" width="120" headerAlign="center" allowSort="true" >提取储备基金</div>
				<div field="tqqyfzjj" width="120" headerAlign="center" allowSort="true" >提取企业发展基金</div>
				<div field="llghtz" width="120" headerAlign="center" allowSort="true" >利润归还投资</div>
				<div field="llghtzother" width="120" headerAlign="center" allowSort="true" >其他</div>
				<div field="kgtzzffll" width="120" headerAlign="center" allowSort="true" >可供投资者分配的利润</div>
				<div field="yfyxggl" width="120" headerAlign="center" allowSort="true" >应付优先股股利</div>
				<div field="tqryyygj" width="120" headerAlign="center" allowSort="true" >提取任意盈余公积</div>
				<div field="yfptggl" width="120" headerAlign="center" allowSort="true" >应付普通股股利</div>
				<div field="zzzbptggl" width="120" headerAlign="center" allowSort="true" >转作资本的普通股股利</div>
				<div field="zzzbptgglother" width="120" headerAlign="center" allowSort="true" >其他</div>
				<div field="zzzbptgglundisbute" width="120" headerAlign="center" allowSort="true" >未分配利润</div>
				<div field="zzzbptgglundisbute_before" width="120" headerAlign="center" allowSort="true" >未分配利润应由以后年度税前利润弥补的亏损</div>
	         </div>
     </div>
</body>
<script type="text/javascript">
mini.parse();
var grid = mini.get("datagrid1");
grid.load()
</script>
</html>