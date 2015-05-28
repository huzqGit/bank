package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

/**
 * 在db2使用该语句进行快速生成字段<br />
 * select 'private String '||lower(name)||';     //',remarks from sysibm.syscolumns where TBNAME='T_COOPERATION_DEBT'
 * @author zkongbai
 * @date 2015年5月27日  下午2:46:30
 */
public class FarmerCooperationDebt extends BaseEntity<Long>{

	private static final long serialVersionUID = 3563675816402829802L;
	
	private Long debtid;
	private String accountspayable;     //	应付账款
	private String assetall;     //	资产合计
	private String bankloan;     //	银行借款
	private String buildingproject;     //	在建项目
	private String businessprofit;     //	营业利润
	private String capitalreserve;     //	资本公积
	private String cashcapital;     //	货币资金
	private String cooperationname;     //	农村经济合作组织名称
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
	private String organcode;     //	组织机构编码
	private String paidaddedtax;     //	实交增值税
	private String payableaddedtax;     //	应交增值税
	private String payableincometax;     //	应交所得税
	private String prepayment;     //	预付账款
	private String profitloss;     //	以前年度损益调整
	private String realcapital;     //	实收资本
	private String receivables;     //	应收账款
	private String recorder;     //	记录人
	private Date recordtime;     //	记录时间
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
	
}
