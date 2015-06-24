<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bank.beans.User"%> 
<%@ page import="com.bank.Constants"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农民专业合作经济组织利润及利润分配</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<style>
html{
	height:90%
}
body{
	height:100%;width:100%;
	overfolw-x:hidden;
	margin-top:-2px;
	margin-left:-2px;
}
.addBtn {
	width: 100px;
	height: 25px;
	border: 0;
	background: url(/bank/images/add.png) no-repeat
}
.bg{
	background:url(images/toolbar/toolbar.png) #e7eaee repeat-x 0px 0px
}
.topmenu{
	width:100%;
	height:60px;
	background:linear-gradient(#6DC8E3,white);
	/* IE6 & IE7 */
	filter: progid:DXImageTransform.Microsoft.gradient( GradientType= 0 , startColorstr = '#6DC8E3', 
	endColorstr = 'white' ); 
	/* IE8 */
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient( GradientType = 0,startColorstr = '#6DC8E3', 
	endColorstr = 'white' )"; 
}
</style>
<%
	User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
	//System.out.println(user.getUserName());
%>
</head>
<body style="overflow-x:hidden;overflow-y:scroll">
<div  id="sss">
<div class="mini-toolbar mini-panel-header bg topmenu" style="height:27px;padding-top:5px;border-bottom:0;position: fixed;z-index: 20">
	<table style="width:97%;">
    	<tr>
        	<td style="white-space:nowrap;" align="right">
        		<span style="${display}">
		        	<a class="mini-button" iconCls="icon-save" plain="true" onclick="submitForm()">保存</a>
		           	<span class="separator"></span>
	            </span>
	            <c:if test="${!empty rightClick}">
	            	<a class="mini-button" iconCls="icon-remove" plain="true" onclick="close()">关闭</a>
                	<span  class="separator"></span>
                 </c:if>
                 <c:if test="${empty rightClick}">
                	<a class="mini-button" iconCls="icon-upgrade" plain="true" onclick="back()">返回</a>
                	<span class="separator"></span>
                 </c:if>
            </td>
         </tr>
      </table>
</div>
<div id="form1" style="width:97%;margin:auto auto;padding-top:25px">
	<form action="${pageContext.request.contextPath}/economy/profit/saveCooperationProfit.do" method="POST">
	<input name="profitid" class="mini-hidden" value="${profitid}"/>
	<input name="organ_id" class="mini-hidden" value="<%=user.getOrganId()%>"/>
	<input name="recoder" class="mini-hidden" value="<%=user.getUserName()%>"/>
	<input name="recodertime" class="mini-hidden" value="${currentTime}"/>
	<table border="0" cellpadding="1" cellspacing="15" width="97%" >
	<tr>
	<td colspan="4" style="width:100%">
	<fieldset id="fd2" style="width:100%;margin:auto auto;">
	<legend><label>农民专业合作经济组织利润及利润分配表</label></legend>
	<div class="fieldset-body" >
	<table width="100%">
		<tr>
			<td style="width:10%"><label for="textbox1$text">年月:</label></td>
			<td style="width:23%">
			<input id="textbox1"  name="yearmonth" class="mini-textbox" required="true" 
				requiredErrorText="年月不能为空" style="width:90%"/>
			</td>
			<td style="width:10%"><label for="textbox2$text">组织机构编码:</label></td>
			<td style="width:20%" >
			<input id="textbox2"  name="organcode" class="mini-textbox" required="true" 
				requiredErrorText="组织机构编码不能为空"  style="width:90%"/>
			</td>
			
		</tr>
	</table>
	<hr />
	<div >
	<table width="97%" >
	<tr>
		<td style="width:15%" ><label for="textbox7$text">数据报送机构</label></td><td style="width:15%"><input id="textbox7" name="datasendorgan"  class="mini-textbox" required="false" requiredErrorText="数据报送机构不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox8$text">税务识别码</label></td><td style="width:20%"><input id="textbox8" name="taxcode"  class="mini-textbox" required="false" requiredErrorText="税务识别码不能为空" style="width:90%"/></td>
		<td style="width:15%"><label for="textbox9$text">机构信用代码</label></td><td style="width:15%"><input id="textbox9" name="organtrustcode"  class="mini-textbox" required="false" requiredErrorText="机构信用代码不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox12$text">主营业务收入</label></td><td style="width:20%"><input id="textbox12" name="mainincome"  class="mini-textbox" required="false" requiredErrorText="主营业务收入不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox13$text">主营业务收入出口产品销售收入</label></td><td style="width:20%"><input id="textbox13" name="mainincome_export"  class="mini-textbox" required="false" requiredErrorText="主营业务收入出口产品销售收入不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox14$text">主营业务收入进口产品销售收入</label></td><td style="width:20%"><input id="textbox14" name="mainincome_import"  class="mini-textbox" required="false" requiredErrorText="主营业务收入进口产品销售收入不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox15$text">折扣与拆让</label></td><td style="width:20%"><input id="textbox15" name="discount"  class="mini-textbox" required="false" requiredErrorText="折扣与拆让不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox16$text">主营业务收入净额</label></td><td style="width:20%"><input id="textbox16" name="mainincome_netmargin"  class="mini-textbox" required="false" requiredErrorText="主营业务收入净额不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox17$text">主营业务成本</label></td><td style="width:20%"><input id="textbox17" name="maincost"  class="mini-textbox" required="false" requiredErrorText="主营业务成本不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox18$text">主营业务成本出口产品销售成本</label></td><td style="width:20%"><input id="textbox18" name="maincost_export"  class="mini-textbox" required="false" requiredErrorText="主营业务成本出口产品销售成本不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox19$text">主营业务税金及附加</label></td><td style="width:20%"><input id="textbox19" name="maintaxpay"  class="mini-textbox" required="false" requiredErrorText="主营业务税金及附加不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox20$text">经营费用</label></td><td style="width:20%"><input id="textbox20" name="operationcost"  class="mini-textbox" required="false" requiredErrorText="经营费用不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox21$text">其他</label></td><td style="width:20%"><input id="textbox21" name="othercost"  class="mini-textbox" required="false" requiredErrorText="其他不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox22$text">递延收益</label></td><td style="width:20%"><input id="textbox22" name="delayincome"  class="mini-textbox" required="false" requiredErrorText="递延收益不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox23$text">代购代销收入</label></td><td style="width:20%"><input id="textbox23" name="purchasingagent"  class="mini-textbox" required="false" requiredErrorText="代购代销收入不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox24$text">其他</label></td><td style="width:20%"><input id="textbox24" name="otherpurchasingagent"  class="mini-textbox" required="false" requiredErrorText="其他不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox25$text">主营业务利润</label></td><td style="width:20%"><input id="textbox25" name="mainnetmargin"  class="mini-textbox" required="false" requiredErrorText="主营业务利润不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox26$text">其他业务利润</label></td><td style="width:20%"><input id="textbox26" name="othernetmargin"  class="mini-textbox" required="false" requiredErrorText="其他业务利润不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox27$text">营业费用</label></td><td style="width:20%"><input id="textbox27" name="mainexpenses"  class="mini-textbox" required="false" requiredErrorText="营业费用不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox28$text">管理费用</label></td><td style="width:20%"><input id="textbox28" name="manageexpense"  class="mini-textbox" required="false" requiredErrorText="管理费用不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox29$text">财务费用</label></td><td style="width:20%"><input id="textbox29" name="finaceexpense"  class="mini-textbox" required="false" requiredErrorText="财务费用不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox30$text">其他</label></td><td style="width:20%"><input id="textbox30" name="otherexpense"  class="mini-textbox" required="false" requiredErrorText="其他不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox31$text">营业利润</label></td><td style="width:20%"><input id="textbox31" name="income_netmargin"  class="mini-textbox" required="false" requiredErrorText="营业利润不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox32$text">投资收益</label></td><td style="width:20%"><input id="textbox32" name="investincome"  class="mini-textbox" required="false" requiredErrorText="投资收益不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox33$text">期货收益</label></td><td style="width:20%"><input id="textbox33" name="futuresincome"  class="mini-textbox" required="false" requiredErrorText="期货收益不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox34$text">补贴收入</label></td><td style="width:20%"><input id="textbox34" name="subsidyincome"  class="mini-textbox" required="false" requiredErrorText="补贴收入不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox35$text">补贴收入补贴前亏损的企业补贴收入</label></td><td style="width:20%"><input id="textbox35" name="subsidyincome_before"  class="mini-textbox" required="false" requiredErrorText="补贴收入补贴前亏损的企业补贴收入不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox36$text">营业外收入</label></td><td style="width:20%"><input id="textbox36" name="income_o"  class="mini-textbox" required="false" requiredErrorText="营业外收入不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox37$text">营业外收入处置固定资产净收益</label></td><td style="width:20%"><input id="textbox37" name="income_o_netmargin"  class="mini-textbox" required="false" requiredErrorText="营业外收入处置固定资产净收益不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox38$text">营业外收入非货币性交易收益</label></td><td style="width:20%"><input id="textbox38" name="income_o_nonemoney"  class="mini-textbox" required="false" requiredErrorText="营业外收入非货币性交易收益不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox39$text">营业外收入出售无形资产收益</label></td><td style="width:20%"><input id="textbox39" name="income_o_wxzc"  class="mini-textbox" required="false" requiredErrorText="营业外收入出售无形资产收益不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox40$text">营业外收入罚款净收入</label></td><td style="width:20%"><input id="textbox40" name="income_o_fk"  class="mini-textbox" required="false" requiredErrorText="营业外收入罚款净收入不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox41$text">其他</label></td><td style="width:20%"><input id="textbox41" name="income_o_other"  class="mini-textbox" required="false" requiredErrorText="其他不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox42$text">其他用以前年度含量工资节余弥补利润</label></td><td style="width:20%"><input id="textbox42" name="income_o_othersalary"  class="mini-textbox" required="false" requiredErrorText="其他用以前年度含量工资节余弥补利润不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox43$text">营业外支出</label></td><td style="width:20%"><input id="textbox43" name="outcome_o"  class="mini-textbox" required="false" requiredErrorText="营业外支出不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox44$text">营业外支出处置固定资产净损失</label></td><td style="width:20%"><input id="textbox44" name="outcome_o_netmargin"  class="mini-textbox" required="false" requiredErrorText="营业外支出处置固定资产净损失不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox45$text">营业外支出债务重组损失</label></td><td style="width:20%"><input id="textbox45" name="outcome_o_zwcz"  class="mini-textbox" required="false" requiredErrorText="营业外支出债务重组损失不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox46$text">营业外支出罚款支出</label></td><td style="width:20%"><input id="textbox46" name="outcome_o_fk"  class="mini-textbox" required="false" requiredErrorText="营业外支出罚款支出不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox47$text">营业外支出捐赠支出</label></td><td style="width:20%"><input id="textbox47" name="outcome_o_jz"  class="mini-textbox" required="false" requiredErrorText="营业外支出捐赠支出不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox48$text">其他支出</label></td><td style="width:20%"><input id="textbox48" name="outcome_o_other"  class="mini-textbox" required="false" requiredErrorText="其他支出不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox49$text">其他支出结转的含量工资包干节余</label></td><td style="width:20%"><input id="textbox49" name="outcome_o_othersalary"  class="mini-textbox" required="false" requiredErrorText="其他支出结转的含量工资包干节余不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox50$text">利润总额</label></td><td style="width:20%"><input id="textbox50" name="allprofit"  class="mini-textbox" required="false" requiredErrorText="利润总额不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox51$text">所得税</label></td><td style="width:20%"><input id="textbox51" name="incomdetax"  class="mini-textbox" required="false" requiredErrorText="所得税不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox52$text">少数股东损益</label></td><td style="width:20%"><input id="textbox52" name="fewpartnerincome"  class="mini-textbox" required="false" requiredErrorText="少数股东损益不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox53$text">未确认的投资损失</label></td><td style="width:20%"><input id="textbox53" name="unsureloss"  class="mini-textbox" required="false" requiredErrorText="未确认的投资损失不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox54$text">净利润</label></td><td style="width:20%"><input id="textbox54" name="netmargin"  class="mini-textbox" required="false" requiredErrorText="净利润不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox55$text">年初未分配利润</label></td><td style="width:20%"><input id="textbox55" name="beginofyearundistributed"  class="mini-textbox" required="false" requiredErrorText="年初未分配利润不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox56$text">盈余公积补亏</label></td><td style="width:20%"><input id="textbox56" name="yygjbk"  class="mini-textbox" required="false" requiredErrorText="盈余公积补亏不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox57$text">其他调整因素</label></td><td style="width:20%"><input id="textbox57" name="qttzys"  class="mini-textbox" required="false" requiredErrorText="其他调整因素不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox58$text">可供分配的利润</label></td><td style="width:20%"><input id="textbox58" name="kgfpll"  class="mini-textbox" required="false" requiredErrorText="可供分配的利润不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox59$text">单项留用的利润</label></td><td style="width:20%"><input id="textbox59" name="dxlyll"  class="mini-textbox" required="false" requiredErrorText="单项留用的利润不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox60$text">补充流动资本</label></td><td style="width:20%"><input id="textbox60" name="bcldzb"  class="mini-textbox" required="false" requiredErrorText="补充流动资本不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox61$text">提取法定盈余公积</label></td><td style="width:20%"><input id="textbox61" name="tqfdyygj"  class="mini-textbox" required="false" requiredErrorText="提取法定盈余公积不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox62$text">提取法定公益金</label></td><td style="width:20%"><input id="textbox62" name="tqfdyygyj"  class="mini-textbox" required="false" requiredErrorText="提取法定公益金不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox63$text">提取职工奖励及福利基金</label></td><td style="width:20%"><input id="textbox63" name="tqzgjljfldy"  class="mini-textbox" required="false" requiredErrorText="提取职工奖励及福利基金不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox64$text">提取储备基金</label></td><td style="width:20%"><input id="textbox64" name="tqcbj"  class="mini-textbox" required="false" requiredErrorText="提取储备基金不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox65$text">提取企业发展基金</label></td><td style="width:20%"><input id="textbox65" name="tqqyfzjj"  class="mini-textbox" required="false" requiredErrorText="提取企业发展基金不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox66$text">利润归还投资</label></td><td style="width:20%"><input id="textbox66" name="llghtz"  class="mini-textbox" required="false" requiredErrorText="利润归还投资不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox67$text">其他</label></td><td style="width:20%"><input id="textbox67" name="llghtzother"  class="mini-textbox" required="false" requiredErrorText="其他不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox68$text">可供投资者分配的利润</label></td><td style="width:20%"><input id="textbox68" name="kgtzzffll"  class="mini-textbox" required="false" requiredErrorText="可供投资者分配的利润不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox69$text">应付优先股股利</label></td><td style="width:20%"><input id="textbox69" name="yfyxggl"  class="mini-textbox" required="false" requiredErrorText="应付优先股股利不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox70$text">提取任意盈余公积</label></td><td style="width:20%"><input id="textbox70" name="tqryyygj"  class="mini-textbox" required="false" requiredErrorText="提取任意盈余公积不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox71$text">应付普通股股利</label></td><td style="width:20%"><input id="textbox71" name="yfptggl"  class="mini-textbox" required="false" requiredErrorText="应付普通股股利不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox72$text">转作资本的普通股股利</label></td><td style="width:20%"><input id="textbox72" name="zzzbptggl"  class="mini-textbox" required="false" requiredErrorText="转作资本的普通股股利不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox73$text">其他</label></td><td style="width:20%"><input id="textbox73" name="zzzbptgglother"  class="mini-textbox" required="false" requiredErrorText="其他不能为空" style="width:90%"/></td>
	</tr><tr>
		<td style="width:10%"><label for="textbox74$text">未分配利润</label></td><td style="width:20%"><input id="textbox74" name="zzzbptgglundisbute"  class="mini-textbox" required="false" requiredErrorText="未分配利润不能为空" style="width:90%"/></td>
		<td style="width:10%"><label for="textbox75$text">未分配利润应由以后年度税前利润弥补的亏损</label></td><td style="width:20%"><input id="textbox75" name="zzzbptgglundisbute_before"  class="mini-textbox" required="false" requiredErrorText="未分配利润应由以后年度税前利润弥补的亏损不能为空" style="width:90%"/></td>
	</tr>
		</table>
	</div>
	</div>
	</fieldset>
	</td>
	</tr>
	</table>
	</form>
</div>
</div>
</body>
<script type="text/javascript">
		mini.parse();
		var form = new mini.Form("#form1");
		if('${accessMethod}'=='viewForm'){
			document.write('<link href="${pageContext.request.contextPath}/miniui/themes/stategrid-skin/skin.css" rel="stylesheet" type="text/css" />');
			form.setEnabled(false);
		}
		if('${accessMethod}' != 'addForm'){
			mini.getbyName("organcode").setEnabled(false);
		}
		//查询表单数据
		$(document).ready(function(){
			$.ajax({
			    url: "${pageContext.request.contextPath}/economy/profit/findCooperationProfit.do",
			    type: "post",
			    data:{profitid:"${profitid}"},
			    success: function (text) {
			        var data = mini.decode(text);   //反序列化成对象
			        if(data.profitid!=null){
			       	 	form.setData(data);  //设置多个控件数据   
			        }
			    },
			    error:function(text,arg2){
			    }
			});
			
		});
		
		function close(){
			//window.close();
			window.CloseOwnerWindow();
		}
		
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
		        url: "${pageContext.request.contextPath}/economy/profit/saveCooperationProfit.do",
		        type: "post",
		        data: { formData: json},
		        contentType: "application/x-www-form-urlencoded; charset=utf-8",
		        success: function (text) {
		        	var data = mini.decode(text);   //反序列化成对象
			        if(data.profitid!=null){
			       	 	form.setData(data);
			        }
			      mini.alert('保存成功！');
			      setTimeout(function(){
     				try{
     					close();
     				}catch(e){
     	      			back();
     	      		}
     			},1500);
		        },
		        error: function (jqXHR, textStatus, errorThrown) {
		            mini.alert('系统异常！');
		        }
			});
		}
	$("#sss").height(20);
	  </script>
</html>