package com.bank.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.common.bean.BaseEntity;

/**
 * 在db2使用该语句进行快速生成字段<br />
 * select 'private String '||lower(name)||';     //',remarks from sysibm.syscolumns where TBNAME='T_COOPERATION_DEBT'
 * @author zkongbai
 * @date 2015年5月27日  下午2:46:30
 */
/**
 *
 * @author zkongbai
 * @date 2015年6月8日  上午9:54:22
 */
public class FarmerCooperationDebt extends BaseEntity<Long>{

	private static final long serialVersionUID = 3563675816402829802L;
	
	/**
	 * 字段与备注映射
	 */
	public static Map<String,String> field_remark = new HashMap<String, String>();
	/**
	 * 备注与字段映射
	 */
	public static Map<String,String> remark_field = new HashMap<String, String>();
	
	
	private String organ_id;
	private Long debtid;
	private String yearmonth;     //	年月
	private String recorder;     //	记录人
	private Date recordtime;     //	记录时间
	private String cooperationname;     //	农村经济合作组织名称
	private String organcode;     //	组织机构编码
	
	//以下字段为期初值
	private String accountspayable;     //	应付账款
	private String assetall;     //	资产合计
	private String bankloan;     //	银行借款
	private String buildingproject;     //	在建项目
	private String businessprofit;     //	营业利润
	private String capitalreserve;     //	资本公积
	private String cashcapital;     //	货币资金
	private String depositreceived;     //	预收账款
	private String deprecication;     //	其中折旧
	private String financialcost;     //	财务费用
	private String fixedasset;     //	固定资产原价
	private String fixedassetall;     //	固定资产合计
	private String floatasset;     //	其他流动资产
	private String floatassetall;     //	流动资产合计
	private String floatdebt;     //	其他流动负债
	private String floatdebtall;     //	流动负债合计
	private String handingcost;     //	管理费用
	private String interestexpense;     //	其中利息支出
	private String inventory;     //	存货
	private String investincome;     //	投资收益
	private String invisibleasset;     //	无形及递延资产合计
	private String longdebtall;     //	长期负债合计
	private String netprofit;     //	利润净额
	private String netvalue;     //	固定资产净值
	private String paidaddedtax;     //	实交增值税
	private String payableaddedtax;     //	应交增值税
	private String payableincometax;     //	应交所得税
	private String prepayment;     //	预付账款
	private String profitloss;     //	以前年度损益调整
	private String realcapital;     //	实收资本
	private String receivables;     //	应收账款
	private String registercapital;     //	注册资本
	private String shortinvest;     //	短期投资
	private String shortloan;     //	短期借款
	private String subsidyincome;     //	国家补贴收入
	private String surplusreserve;     //	盈余公积
	private String totalequity;     //	所有者权益合计
	private String totalequity1;     //	负债和所有者权益合计
	private String totalprofit;     //	利润总和
	private String unallotprofit;     //	未分配利润
	private String unbusinessexpense;     //	营业外支出
	private String unbusinessincome;     //	营业外收入
	private String unpaidtax;     //	未缴税金
	
	//以下字段为期末值
	private String accountspayable2;     //	应付账款
	private String assetall2;     //	资产合计
	private String bankloan2;     //	银行借款
	private String buildingproject2;     //	在建项目
	private String businessprofit2;     //	营业利润
	private String capitalreserve2;     //	资本公积
	private String cashcapital2;     //	货币资金
	private String depositreceived2;     //	预收账款
	private String deprecication2;     //	其中折旧
	private String financialcost2;     //	财务费用
	private String fixedasset2;     //	固定资产原价
	private String fixedassetall2;     //	固定资产合计
	private String floatasset2;     //	其他流动资产
	private String floatassetall2;     //	流动资产合计
	private String floatdebt2;     //	其他流动负债
	private String floatdebtall2;     //	流动负债合计
	private String handingcost2;     //	管理费用
	private String interestexpense2;     //	其中利息支出
	private String inventory2;     //	存货
	private String investincome2;     //	投资收益
	private String invisibleasset2;     //	无形及递延资产合计
	private String longdebtall2;     //	长期负债合计
	private String netprofit2;     //	利润净额
	private String netvalue2;     //	固定资产净值
	private String paidaddedtax2;     //	实交增值税
	private String payableaddedtax2;     //	应交增值税
	private String payableincometax2;     //	应交所得税
	private String prepayment2;     //	预付账款
	private String profitloss2;     //	以前年度损益调整
	private String realcapital2;     //	实收资本
	private String receivables2;     //	应收账款
	private String registercapital2;     //	注册资本
	private String shortinvest2;     //	短期投资
	private String shortloan2;     //	短期借款
	private String subsidyincome2;     //	国家补贴收入
	private String surplusreserve2;     //	盈余公积
	private String totalequity2;     //	所有者权益合计
	private String totalequity12;     //	负债和所有者权益合计
	private String totalprofit2;     //	利润总和
	private String unallotprofit2;     //	未分配利润
	private String unbusinessexpense2;     //	营业外支出
	private String unbusinessincome2;     //	营业外收入
	private String unpaidtax2;     //	未缴税金
	
	private String error_label;
	private String sourcecode;
	  
	@Override
	public boolean equalsIfIdNull(Object o) {
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}

	public Long getDebtid() {
		return debtid;
	}

	public void setDebtid(Long debtid) {
		this.debtid = debtid;
	}

	public String getAccountspayable() {
		return accountspayable;
	}

	public void setAccountspayable(String accountspayable) {
		this.accountspayable = accountspayable;
	}

	public String getAssetall() {
		return assetall;
	}

	public void setAssetall(String assetall) {
		this.assetall = assetall;
	}

	public String getBankloan() {
		return bankloan;
	}

	public void setBankloan(String bankloan) {
		this.bankloan = bankloan;
	}

	public String getBuildingproject() {
		return buildingproject;
	}

	public void setBuildingproject(String buildingproject) {
		this.buildingproject = buildingproject;
	}

	public String getBusinessprofit() {
		return businessprofit;
	}

	public void setBusinessprofit(String businessprofit) {
		this.businessprofit = businessprofit;
	}

	public String getCapitalreserve() {
		return capitalreserve;
	}

	public void setCapitalreserve(String capitalreserve) {
		this.capitalreserve = capitalreserve;
	}

	public String getCashcapital() {
		return cashcapital;
	}

	public void setCashcapital(String cashcapital) {
		this.cashcapital = cashcapital;
	}

	public String getCooperationname() {
		return cooperationname;
	}

	public void setCooperationname(String cooperationname) {
		this.cooperationname = cooperationname;
	}

	public String getDepositreceived() {
		return depositreceived;
	}

	public void setDepositreceived(String depositreceived) {
		this.depositreceived = depositreceived;
	}

	public String getDeprecication() {
		return deprecication;
	}

	public void setDeprecication(String deprecication) {
		this.deprecication = deprecication;
	}

	public String getFinancialcost() {
		return financialcost;
	}

	public void setFinancialcost(String financialcost) {
		this.financialcost = financialcost;
	}

	public String getFixedasset() {
		return fixedasset;
	}

	public void setFixedasset(String fixedasset) {
		this.fixedasset = fixedasset;
	}

	public String getFixedassetall() {
		return fixedassetall;
	}

	public void setFixedassetall(String fixedassetall) {
		this.fixedassetall = fixedassetall;
	}

	public String getFloatasset() {
		return floatasset;
	}

	public void setFloatasset(String floatasset) {
		this.floatasset = floatasset;
	}

	public String getFloatassetall() {
		return floatassetall;
	}

	public void setFloatassetall(String floatassetall) {
		this.floatassetall = floatassetall;
	}

	public String getFloatdebt() {
		return floatdebt;
	}

	public void setFloatdebt(String floatdebt) {
		this.floatdebt = floatdebt;
	}

	public String getFloatdebtall() {
		return floatdebtall;
	}

	public void setFloatdebtall(String floatdebtall) {
		this.floatdebtall = floatdebtall;
	}

	public String getHandingcost() {
		return handingcost;
	}

	public void setHandingcost(String handingcost) {
		this.handingcost = handingcost;
	}

	public String getInterestexpense() {
		return interestexpense;
	}

	public void setInterestexpense(String interestexpense) {
		this.interestexpense = interestexpense;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getInvestincome() {
		return investincome;
	}

	public void setInvestincome(String investincome) {
		this.investincome = investincome;
	}

	public String getInvisibleasset() {
		return invisibleasset;
	}

	public void setInvisibleasset(String invisibleasset) {
		this.invisibleasset = invisibleasset;
	}

	public String getLongdebtall() {
		return longdebtall;
	}

	public void setLongdebtall(String longdebtall) {
		this.longdebtall = longdebtall;
	}

	public String getNetprofit() {
		return netprofit;
	}

	public void setNetprofit(String netprofit) {
		this.netprofit = netprofit;
	}

	public String getNetvalue() {
		return netvalue;
	}

	public void setNetvalue(String netvalue) {
		this.netvalue = netvalue;
	}

	public String getOrgancode() {
		return organcode;
	}

	public void setOrgancode(String organcode) {
		this.organcode = organcode;
	}

	public String getPaidaddedtax() {
		return paidaddedtax;
	}

	public void setPaidaddedtax(String paidaddedtax) {
		this.paidaddedtax = paidaddedtax;
	}

	public String getPayableaddedtax() {
		return payableaddedtax;
	}

	public void setPayableaddedtax(String payableaddedtax) {
		this.payableaddedtax = payableaddedtax;
	}

	public String getPayableincometax() {
		return payableincometax;
	}

	public void setPayableincometax(String payableincometax) {
		this.payableincometax = payableincometax;
	}

	public String getPrepayment() {
		return prepayment;
	}

	public void setPrepayment(String prepayment) {
		this.prepayment = prepayment;
	}

	public String getProfitloss() {
		return profitloss;
	}

	public void setProfitloss(String profitloss) {
		this.profitloss = profitloss;
	}

	public String getRealcapital() {
		return realcapital;
	}

	public void setRealcapital(String realcapital) {
		this.realcapital = realcapital;
	}

	public String getReceivables() {
		return receivables;
	}

	public void setReceivables(String receivables) {
		this.receivables = receivables;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}

	public Date getRecordtime() {
		return recordtime;
	}

	public void setRecordtime(Date recordtime) {
		this.recordtime = recordtime;
	}

	public String getRegistercapital() {
		return registercapital;
	}

	public void setRegistercapital(String registercapital) {
		this.registercapital = registercapital;
	}

	public String getShortinvest() {
		return shortinvest;
	}

	public void setShortinvest(String shortinvest) {
		this.shortinvest = shortinvest;
	}

	public String getShortloan() {
		return shortloan;
	}

	public void setShortloan(String shortloan) {
		this.shortloan = shortloan;
	}

	public String getSubsidyincome() {
		return subsidyincome;
	}

	public void setSubsidyincome(String subsidyincome) {
		this.subsidyincome = subsidyincome;
	}

	public String getSurplusreserve() {
		return surplusreserve;
	}

	public void setSurplusreserve(String surplusreserve) {
		this.surplusreserve = surplusreserve;
	}

	public String getTotalequity() {
		return totalequity;
	}

	public void setTotalequity(String totalequity) {
		this.totalequity = totalequity;
	}

	public String getTotalequity1() {
		return totalequity1;
	}

	public void setTotalequity1(String totalequity1) {
		this.totalequity1 = totalequity1;
	}

	public String getTotalprofit() {
		return totalprofit;
	}

	public void setTotalprofit(String totalprofit) {
		this.totalprofit = totalprofit;
	}

	public String getUnallotprofit() {
		return unallotprofit;
	}

	public void setUnallotprofit(String unallotprofit) {
		this.unallotprofit = unallotprofit;
	}

	public String getUnbusinessexpense() {
		return unbusinessexpense;
	}

	public void setUnbusinessexpense(String unbusinessexpense) {
		this.unbusinessexpense = unbusinessexpense;
	}

	public String getUnbusinessincome() {
		return unbusinessincome;
	}

	public void setUnbusinessincome(String unbusinessincome) {
		this.unbusinessincome = unbusinessincome;
	}

	public String getUnpaidtax() {
		return unpaidtax;
	}

	public void setUnpaidtax(String unpaidtax) {
		this.unpaidtax = unpaidtax;
	}

	public String getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(String yearmonth) {
		this.yearmonth = yearmonth;
	}

	public String getAccountspayable2() {
		return accountspayable2;
	}

	public void setAccountspayable2(String accountspayable2) {
		this.accountspayable2 = accountspayable2;
	}

	public String getAssetall2() {
		return assetall2;
	}

	public void setAssetall2(String assetall2) {
		this.assetall2 = assetall2;
	}

	public String getBankloan2() {
		return bankloan2;
	}

	public void setBankloan2(String bankloan2) {
		this.bankloan2 = bankloan2;
	}

	public String getBuildingproject2() {
		return buildingproject2;
	}

	public void setBuildingproject2(String buildingproject2) {
		this.buildingproject2 = buildingproject2;
	}

	public String getBusinessprofit2() {
		return businessprofit2;
	}

	public void setBusinessprofit2(String businessprofit2) {
		this.businessprofit2 = businessprofit2;
	}

	public String getCapitalreserve2() {
		return capitalreserve2;
	}

	public void setCapitalreserve2(String capitalreserve2) {
		this.capitalreserve2 = capitalreserve2;
	}

	public String getCashcapital2() {
		return cashcapital2;
	}

	public void setCashcapital2(String cashcapital2) {
		this.cashcapital2 = cashcapital2;
	}

	public String getDepositreceived2() {
		return depositreceived2;
	}

	public void setDepositreceived2(String depositreceived2) {
		this.depositreceived2 = depositreceived2;
	}

	public String getDeprecication2() {
		return deprecication2;
	}

	public void setDeprecication2(String deprecication2) {
		this.deprecication2 = deprecication2;
	}

	public String getFinancialcost2() {
		return financialcost2;
	}

	public void setFinancialcost2(String financialcost2) {
		this.financialcost2 = financialcost2;
	}

	public String getFixedasset2() {
		return fixedasset2;
	}

	public void setFixedasset2(String fixedasset2) {
		this.fixedasset2 = fixedasset2;
	}

	public String getFixedassetall2() {
		return fixedassetall2;
	}

	public void setFixedassetall2(String fixedassetall2) {
		this.fixedassetall2 = fixedassetall2;
	}

	public String getFloatasset2() {
		return floatasset2;
	}

	public void setFloatasset2(String floatasset2) {
		this.floatasset2 = floatasset2;
	}

	public String getFloatassetall2() {
		return floatassetall2;
	}

	public void setFloatassetall2(String floatassetall2) {
		this.floatassetall2 = floatassetall2;
	}

	public String getFloatdebt2() {
		return floatdebt2;
	}

	public void setFloatdebt2(String floatdebt2) {
		this.floatdebt2 = floatdebt2;
	}

	public String getFloatdebtall2() {
		return floatdebtall2;
	}

	public void setFloatdebtall2(String floatdebtall2) {
		this.floatdebtall2 = floatdebtall2;
	}

	public String getHandingcost2() {
		return handingcost2;
	}

	public void setHandingcost2(String handingcost2) {
		this.handingcost2 = handingcost2;
	}

	public String getInterestexpense2() {
		return interestexpense2;
	}

	public void setInterestexpense2(String interestexpense2) {
		this.interestexpense2 = interestexpense2;
	}

	public String getInventory2() {
		return inventory2;
	}

	public void setInventory2(String inventory2) {
		this.inventory2 = inventory2;
	}

	public String getInvestincome2() {
		return investincome2;
	}

	public void setInvestincome2(String investincome2) {
		this.investincome2 = investincome2;
	}

	public String getInvisibleasset2() {
		return invisibleasset2;
	}

	public void setInvisibleasset2(String invisibleasset2) {
		this.invisibleasset2 = invisibleasset2;
	}

	public String getLongdebtall2() {
		return longdebtall2;
	}

	public void setLongdebtall2(String longdebtall2) {
		this.longdebtall2 = longdebtall2;
	}

	public String getNetprofit2() {
		return netprofit2;
	}

	public void setNetprofit2(String netprofit2) {
		this.netprofit2 = netprofit2;
	}

	public String getNetvalue2() {
		return netvalue2;
	}

	public void setNetvalue2(String netvalue2) {
		this.netvalue2 = netvalue2;
	}

	public String getPaidaddedtax2() {
		return paidaddedtax2;
	}

	public void setPaidaddedtax2(String paidaddedtax2) {
		this.paidaddedtax2 = paidaddedtax2;
	}

	public String getPayableaddedtax2() {
		return payableaddedtax2;
	}

	public void setPayableaddedtax2(String payableaddedtax2) {
		this.payableaddedtax2 = payableaddedtax2;
	}

	public String getPayableincometax2() {
		return payableincometax2;
	}

	public void setPayableincometax2(String payableincometax2) {
		this.payableincometax2 = payableincometax2;
	}

	public String getPrepayment2() {
		return prepayment2;
	}

	public void setPrepayment2(String prepayment2) {
		this.prepayment2 = prepayment2;
	}

	public String getProfitloss2() {
		return profitloss2;
	}

	public void setProfitloss2(String profitloss2) {
		this.profitloss2 = profitloss2;
	}

	public String getRealcapital2() {
		return realcapital2;
	}

	public void setRealcapital2(String realcapital2) {
		this.realcapital2 = realcapital2;
	}

	public String getReceivables2() {
		return receivables2;
	}

	public void setReceivables2(String receivables2) {
		this.receivables2 = receivables2;
	}

	public String getRegistercapital2() {
		return registercapital2;
	}

	public void setRegistercapital2(String registercapital2) {
		this.registercapital2 = registercapital2;
	}

	public String getShortinvest2() {
		return shortinvest2;
	}

	public void setShortinvest2(String shortinvest2) {
		this.shortinvest2 = shortinvest2;
	}

	public String getShortloan2() {
		return shortloan2;
	}

	public void setShortloan2(String shortloan2) {
		this.shortloan2 = shortloan2;
	}

	public String getSubsidyincome2() {
		return subsidyincome2;
	}

	public void setSubsidyincome2(String subsidyincome2) {
		this.subsidyincome2 = subsidyincome2;
	}

	public String getSurplusreserve2() {
		return surplusreserve2;
	}

	public void setSurplusreserve2(String surplusreserve2) {
		this.surplusreserve2 = surplusreserve2;
	}

	public String getTotalequity2() {
		return totalequity2;
	}

	public void setTotalequity2(String totalequity2) {
		this.totalequity2 = totalequity2;
	}

	public String getTotalequity12() {
		return totalequity12;
	}

	public void setTotalequity12(String totalequity12) {
		this.totalequity12 = totalequity12;
	}

	public String getTotalprofit2() {
		return totalprofit2;
	}

	public void setTotalprofit2(String totalprofit2) {
		this.totalprofit2 = totalprofit2;
	}

	public String getUnallotprofit2() {
		return unallotprofit2;
	}

	public void setUnallotprofit2(String unallotprofit2) {
		this.unallotprofit2 = unallotprofit2;
	}

	public String getUnbusinessexpense2() {
		return unbusinessexpense2;
	}

	public void setUnbusinessexpense2(String unbusinessexpense2) {
		this.unbusinessexpense2 = unbusinessexpense2;
	}

	public String getUnbusinessincome2() {
		return unbusinessincome2;
	}

	public void setUnbusinessincome2(String unbusinessincome2) {
		this.unbusinessincome2 = unbusinessincome2;
	}

	public String getUnpaidtax2() {
		return unpaidtax2;
	}

	public void setUnpaidtax2(String unpaidtax2) {
		this.unpaidtax2 = unpaidtax2;
	}
	
	static {
//		select 'field_remark.put("'||lower(name)||'","'||t.remarks||'");'
//		from sysibm.syscolumns t where TBNAME='T_COOPERATION_PROFIT'
//		order by t.COLNO
		
		field_remark.put("organ_id","组织机构id");
		field_remark.put("accountspayable","应付账款");
		field_remark.put("accountspayable2","应付账款(期末值)");
		field_remark.put("assetall","资产合计");
		field_remark.put("assetall2","资产合计(期末值)");
		field_remark.put("bankloan","银行借款");
		field_remark.put("bankloan2","银行借款(期末值)");
		field_remark.put("buildingproject","在建项目");
		field_remark.put("buildingproject2","在建项目(期末值)");
		field_remark.put("businessprofit","营业利润");
		field_remark.put("businessprofit2","营业利润(期末值)");
		field_remark.put("capitalreserve","资本公积");
		field_remark.put("capitalreserve2","资本公积(期末值)");
		field_remark.put("cashcapital","货币资金");
		field_remark.put("cashcapital2","货币资金(期末值)");
		field_remark.put("cooperationname","合作社名称");
		field_remark.put("debtid","农村经济合作组织资产负债表主键");
		field_remark.put("depositreceived","预收账款");
		field_remark.put("depositreceived2","预收账款(期末值)");
		field_remark.put("deprecication","其中折旧");
		field_remark.put("deprecication2","其中折旧(期末值)");
		field_remark.put("financialcost","财务费用");
		field_remark.put("financialcost2","财务费用(期末值)");
		field_remark.put("fixedasset","固定资产原价");
		field_remark.put("fixedasset2","固定资产原价(期末值)");
		field_remark.put("fixedassetall","固定资产合计");
		field_remark.put("fixedassetall2","固定资产合计(期末值)");
		field_remark.put("floatasset","其他流动资产");
		field_remark.put("floatasset2","其他流动资产(期末值)");
		field_remark.put("floatassetall","流动资产合计");
		field_remark.put("floatassetall2","流动资产合计(期末值)");
		field_remark.put("floatdebt","其他流动负债");
		field_remark.put("floatdebt2","其他流动负债(期末值)");
		field_remark.put("floatdebtall","流动负债合计");
		field_remark.put("floatdebtall2","流动负债合计(期末值)");
		field_remark.put("handingcost","管理费用");
		field_remark.put("handingcost2","管理费用(期末值)");
		field_remark.put("interestexpense","其中利息支出");
		field_remark.put("interestexpense2","其中利息支出(期末值)");
		field_remark.put("inventory","存货");
		field_remark.put("inventory2","存货(期末值)");
		field_remark.put("investincome","投资收益");
		field_remark.put("investincome2","投资收益(期末值)");
		field_remark.put("invisibleasset","无形及递延资产合计");
		field_remark.put("invisibleasset2","无形及递延资产合计(期末值)");
		field_remark.put("longdebtall","长期负债合计");
		field_remark.put("longdebtall2","长期负债合计(期末值)");
		field_remark.put("netprofit","利润净额");
		field_remark.put("netprofit2","利润净额(期末值)");
		field_remark.put("netvalue","固定资产净值");
		field_remark.put("netvalue2","固定资产净值(期末值)");
		field_remark.put("organcode","组织机构编码");
		field_remark.put("paidaddedtax","实交增值税");
		field_remark.put("paidaddedtax2","实交增值税(期末值)");
		field_remark.put("payableaddedtax","应交增值税");
		field_remark.put("payableaddedtax2","应交增值税(期末值)");
		field_remark.put("payableincometax","应交所得税");
		field_remark.put("payableincometax2","应交所得税(期末值)");
		field_remark.put("prepayment","预付账款");
		field_remark.put("prepayment2","预付账款(期末值)");
		field_remark.put("profitloss","以前年度损益调整");
		field_remark.put("profitloss2","以前年度损益调整(期末值)");
		field_remark.put("realcapital","实收资本");
		field_remark.put("realcapital2","实收资本(期末值)");
		field_remark.put("receivables","应收账款净额");
		field_remark.put("receivables2","应收账款净额(期末值)");
		field_remark.put("recorder","记录人");
		field_remark.put("recordtime","记录时间");
		field_remark.put("registercapital","注册资本");
		field_remark.put("registercapital2","注册资本(期末值)");
		field_remark.put("shortinvest","短期投资");
		field_remark.put("shortinvest2","短期投资(期末值)");
		field_remark.put("shortloan","短期借款");
		field_remark.put("shortloan2","短期借款(期末值)");
		field_remark.put("subsidyincome","国家补贴收入");
		field_remark.put("subsidyincome2","国家补贴收入(期末值)");
		field_remark.put("surplusreserve","盈余公积");
		field_remark.put("surplusreserve2","盈余公积(期末值)");
		field_remark.put("totalequity","所有者权益合计");
		field_remark.put("totalequity1","负债和所有者权益合计");
		field_remark.put("totalequity12","负债和所有者权益合计(期末值)");
		field_remark.put("totalequity2","所有者权益合计(期末值)");
		field_remark.put("totalprofit","利润总和");
		field_remark.put("totalprofit2","利润总和(期末值)");
		field_remark.put("unallotprofit","未分配利润");
		field_remark.put("unallotprofit2","未分配利润(期末值)");
		field_remark.put("unbusinessexpense","营业外支出");
		field_remark.put("unbusinessexpense2","营业外支出(期末值)");
		field_remark.put("unbusinessincome","营业外收入");
		field_remark.put("unbusinessincome2","营业外收入(期末值)");
		field_remark.put("unpaidtax","未缴税金");
		field_remark.put("unpaidtax2","未缴税金(期末值)");
		field_remark.put("yearmonth","年月");
		field_remark.put("error_label", "错误描述");
		
		for(Map.Entry<String, String> entry : field_remark.entrySet()){
			remark_field.put(entry.getValue(), entry.getKey());
		}
	}

	public String getError_label() {
		return error_label;
	}

	public void setError_label(String error_label) {
		this.error_label = error_label;
	}

	public String getOrgan_id() {
		return organ_id;
	}

	public void setOrgan_id(String organ_id) {
		this.organ_id = organ_id;
	}

	public String getSourcecode() {
		return sourcecode;
	}

	public void setSourcecode(String sourcecode) {
		this.sourcecode = sourcecode;
	}
	
}
