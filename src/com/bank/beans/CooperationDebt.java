package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class CooperationDebt extends BaseEntity<Long>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2703826949761667442L;

    private String organcode;

    private String taxcode;

    private String businesslicence;

    private String yearmonth;

    private String cashcapital;

    private String shortinvest;

    private String receivables;

    private String prepayment;

    private String inventory;

    private String floatasset;

    private String floatassetall;

    private String fixedasset;

    private String deprecication;

    private String netvalue;

    private String buildingproject;

    private String fixedassetall;

    private String invisibleasset;

    private String assetall;

    private String shortloan;

    private String bankloan;

    private String accountspayable;

    private String depositreceived;

    private String unpaidtax;

    private String floatdebt;

    private String floatdebtall;

    private String longdebtall;

    private String registercapital;

    private String realcapital;

    private String capitalreserve;

    private String surplusreserve;

    private String unallotprofit;

    private String totalequity;

    private String totalequity1;

    private String handingcost;

    private String financialcost;

    private String interestexpense;

    private String businessprofit;

    private String investincome;

    private String subsidyincome;

    private String unbusinessincome;

    private String unbusinessexpense;

    private String profitloss;

    private String totalprofit;

    private String payableincometax;

    private String payableaddedtax;

    private String paidaddedtax;

    private String netprofit;

    private String cooperationname;

    private String cashcapital2;

    private String shortinvest2;

    private String receivables2;

    private String prepayment2;

    private String inventory2;

    private String floatasset2;

    private String floatassetall2;

    private String fixedasset2;

    private String deprecication2;

    private String netvalue2;

    private String buildingproject2;

    private String fixedassetall2;

    private String invisibleasset2;

    private String assetall2;

    private String shortloan2;

    private String bankloan2;

    private String accountspayable2;

    private String depositreceived2;

    private String unpaidtax2;

    private String floatdebt2;

    private String floatdebtall2;

    private String longdebtall2;

    private String registercapital2;

    private String realcapital2;

    private String capitalreserve2;

    private String surplusreserve2;

    private String unallotprofit2;

    private String totalequity2;

    private String totalequity12;

    private String handingcost2;

    private String financialcost2;

    private String interestexpense2;

    private String businessprofit2;

    private String investincome2;

    private String subsidyincome2;

    private String unbusinessincome2;

    private String unbusinessexpense2;

    private String profitloss2;

    private String totalprofit2;

    private String payableincometax2;

    private String payableaddedtax2;

    private String paidaddedtax2;

    private String netprofit2;

    private String sourcecode;

    private String sourcename;

    private String runitid;

    private String runitname;

    private String recorder;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordtime;


    public String getOrgancode() {
        return organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode == null ? null : organcode.trim();
    }

    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode == null ? null : taxcode.trim();
    }

    public String getBusinesslicence() {
        return businesslicence;
    }

    public void setBusinesslicence(String businesslicence) {
        this.businesslicence = businesslicence == null ? null : businesslicence.trim();
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth == null ? null : yearmonth.trim();
    }

    public String getCashcapital() {
        return cashcapital;
    }

    public void setCashcapital(String cashcapital) {
        this.cashcapital = cashcapital == null ? null : cashcapital.trim();
    }

    public String getShortinvest() {
        return shortinvest;
    }

    public void setShortinvest(String shortinvest) {
        this.shortinvest = shortinvest == null ? null : shortinvest.trim();
    }

    public String getReceivables() {
        return receivables;
    }

    public void setReceivables(String receivables) {
        this.receivables = receivables == null ? null : receivables.trim();
    }

    public String getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(String prepayment) {
        this.prepayment = prepayment == null ? null : prepayment.trim();
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory == null ? null : inventory.trim();
    }

    public String getFloatasset() {
        return floatasset;
    }

    public void setFloatasset(String floatasset) {
        this.floatasset = floatasset == null ? null : floatasset.trim();
    }

    public String getFloatassetall() {
        return floatassetall;
    }

    public void setFloatassetall(String floatassetall) {
        this.floatassetall = floatassetall == null ? null : floatassetall.trim();
    }

    public String getFixedasset() {
        return fixedasset;
    }

    public void setFixedasset(String fixedasset) {
        this.fixedasset = fixedasset == null ? null : fixedasset.trim();
    }

    public String getDeprecication() {
        return deprecication;
    }

    public void setDeprecication(String deprecication) {
        this.deprecication = deprecication == null ? null : deprecication.trim();
    }

    public String getNetvalue() {
        return netvalue;
    }

    public void setNetvalue(String netvalue) {
        this.netvalue = netvalue == null ? null : netvalue.trim();
    }

    public String getBuildingproject() {
        return buildingproject;
    }

    public void setBuildingproject(String buildingproject) {
        this.buildingproject = buildingproject == null ? null : buildingproject.trim();
    }

    public String getFixedassetall() {
        return fixedassetall;
    }

    public void setFixedassetall(String fixedassetall) {
        this.fixedassetall = fixedassetall == null ? null : fixedassetall.trim();
    }

    public String getInvisibleasset() {
        return invisibleasset;
    }

    public void setInvisibleasset(String invisibleasset) {
        this.invisibleasset = invisibleasset == null ? null : invisibleasset.trim();
    }

    public String getAssetall() {
        return assetall;
    }

    public void setAssetall(String assetall) {
        this.assetall = assetall == null ? null : assetall.trim();
    }

    public String getShortloan() {
        return shortloan;
    }

    public void setShortloan(String shortloan) {
        this.shortloan = shortloan == null ? null : shortloan.trim();
    }

    public String getBankloan() {
        return bankloan;
    }

    public void setBankloan(String bankloan) {
        this.bankloan = bankloan == null ? null : bankloan.trim();
    }

    public String getAccountspayable() {
        return accountspayable;
    }

    public void setAccountspayable(String accountspayable) {
        this.accountspayable = accountspayable == null ? null : accountspayable.trim();
    }

    public String getDepositreceived() {
        return depositreceived;
    }

    public void setDepositreceived(String depositreceived) {
        this.depositreceived = depositreceived == null ? null : depositreceived.trim();
    }

    public String getUnpaidtax() {
        return unpaidtax;
    }

    public void setUnpaidtax(String unpaidtax) {
        this.unpaidtax = unpaidtax == null ? null : unpaidtax.trim();
    }

    public String getFloatdebt() {
        return floatdebt;
    }

    public void setFloatdebt(String floatdebt) {
        this.floatdebt = floatdebt == null ? null : floatdebt.trim();
    }

    public String getFloatdebtall() {
        return floatdebtall;
    }

    public void setFloatdebtall(String floatdebtall) {
        this.floatdebtall = floatdebtall == null ? null : floatdebtall.trim();
    }

    public String getLongdebtall() {
        return longdebtall;
    }

    public void setLongdebtall(String longdebtall) {
        this.longdebtall = longdebtall == null ? null : longdebtall.trim();
    }

    public String getRegistercapital() {
        return registercapital;
    }

    public void setRegistercapital(String registercapital) {
        this.registercapital = registercapital == null ? null : registercapital.trim();
    }

    public String getRealcapital() {
        return realcapital;
    }

    public void setRealcapital(String realcapital) {
        this.realcapital = realcapital == null ? null : realcapital.trim();
    }

    public String getCapitalreserve() {
        return capitalreserve;
    }

    public void setCapitalreserve(String capitalreserve) {
        this.capitalreserve = capitalreserve == null ? null : capitalreserve.trim();
    }

    public String getSurplusreserve() {
        return surplusreserve;
    }

    public void setSurplusreserve(String surplusreserve) {
        this.surplusreserve = surplusreserve == null ? null : surplusreserve.trim();
    }

    public String getUnallotprofit() {
        return unallotprofit;
    }

    public void setUnallotprofit(String unallotprofit) {
        this.unallotprofit = unallotprofit == null ? null : unallotprofit.trim();
    }

    public String getTotalequity() {
        return totalequity;
    }

    public void setTotalequity(String totalequity) {
        this.totalequity = totalequity == null ? null : totalequity.trim();
    }

    public String getTotalequity1() {
        return totalequity1;
    }

    public void setTotalequity1(String totalequity1) {
        this.totalequity1 = totalequity1 == null ? null : totalequity1.trim();
    }

    public String getHandingcost() {
        return handingcost;
    }

    public void setHandingcost(String handingcost) {
        this.handingcost = handingcost == null ? null : handingcost.trim();
    }

    public String getFinancialcost() {
        return financialcost;
    }

    public void setFinancialcost(String financialcost) {
        this.financialcost = financialcost == null ? null : financialcost.trim();
    }

    public String getInterestexpense() {
        return interestexpense;
    }

    public void setInterestexpense(String interestexpense) {
        this.interestexpense = interestexpense == null ? null : interestexpense.trim();
    }

    public String getBusinessprofit() {
        return businessprofit;
    }

    public void setBusinessprofit(String businessprofit) {
        this.businessprofit = businessprofit == null ? null : businessprofit.trim();
    }

    public String getInvestincome() {
        return investincome;
    }

    public void setInvestincome(String investincome) {
        this.investincome = investincome == null ? null : investincome.trim();
    }

    public String getSubsidyincome() {
        return subsidyincome;
    }

    public void setSubsidyincome(String subsidyincome) {
        this.subsidyincome = subsidyincome == null ? null : subsidyincome.trim();
    }

    public String getUnbusinessincome() {
        return unbusinessincome;
    }

    public void setUnbusinessincome(String unbusinessincome) {
        this.unbusinessincome = unbusinessincome == null ? null : unbusinessincome.trim();
    }

    public String getUnbusinessexpense() {
        return unbusinessexpense;
    }

    public void setUnbusinessexpense(String unbusinessexpense) {
        this.unbusinessexpense = unbusinessexpense == null ? null : unbusinessexpense.trim();
    }

    public String getProfitloss() {
        return profitloss;
    }

    public void setProfitloss(String profitloss) {
        this.profitloss = profitloss == null ? null : profitloss.trim();
    }

    public String getTotalprofit() {
        return totalprofit;
    }

    public void setTotalprofit(String totalprofit) {
        this.totalprofit = totalprofit == null ? null : totalprofit.trim();
    }

    public String getPayableincometax() {
        return payableincometax;
    }

    public void setPayableincometax(String payableincometax) {
        this.payableincometax = payableincometax == null ? null : payableincometax.trim();
    }

    public String getPayableaddedtax() {
        return payableaddedtax;
    }

    public void setPayableaddedtax(String payableaddedtax) {
        this.payableaddedtax = payableaddedtax == null ? null : payableaddedtax.trim();
    }

    public String getPaidaddedtax() {
        return paidaddedtax;
    }

    public void setPaidaddedtax(String paidaddedtax) {
        this.paidaddedtax = paidaddedtax == null ? null : paidaddedtax.trim();
    }

    public String getNetprofit() {
        return netprofit;
    }

    public void setNetprofit(String netprofit) {
        this.netprofit = netprofit == null ? null : netprofit.trim();
    }

    public String getCooperationname() {
        return cooperationname;
    }

    public void setCooperationname(String cooperationname) {
        this.cooperationname = cooperationname == null ? null : cooperationname.trim();
    }

    public String getCashcapital2() {
        return cashcapital2;
    }

    public void setCashcapital2(String cashcapital2) {
        this.cashcapital2 = cashcapital2 == null ? null : cashcapital2.trim();
    }

    public String getShortinvest2() {
        return shortinvest2;
    }

    public void setShortinvest2(String shortinvest2) {
        this.shortinvest2 = shortinvest2 == null ? null : shortinvest2.trim();
    }

    public String getReceivables2() {
        return receivables2;
    }

    public void setReceivables2(String receivables2) {
        this.receivables2 = receivables2 == null ? null : receivables2.trim();
    }

    public String getPrepayment2() {
        return prepayment2;
    }

    public void setPrepayment2(String prepayment2) {
        this.prepayment2 = prepayment2 == null ? null : prepayment2.trim();
    }

    public String getInventory2() {
        return inventory2;
    }

    public void setInventory2(String inventory2) {
        this.inventory2 = inventory2 == null ? null : inventory2.trim();
    }

    public String getFloatasset2() {
        return floatasset2;
    }

    public void setFloatasset2(String floatasset2) {
        this.floatasset2 = floatasset2 == null ? null : floatasset2.trim();
    }

    public String getFloatassetall2() {
        return floatassetall2;
    }

    public void setFloatassetall2(String floatassetall2) {
        this.floatassetall2 = floatassetall2 == null ? null : floatassetall2.trim();
    }

    public String getFixedasset2() {
        return fixedasset2;
    }

    public void setFixedasset2(String fixedasset2) {
        this.fixedasset2 = fixedasset2 == null ? null : fixedasset2.trim();
    }

    public String getDeprecication2() {
        return deprecication2;
    }

    public void setDeprecication2(String deprecication2) {
        this.deprecication2 = deprecication2 == null ? null : deprecication2.trim();
    }

    public String getNetvalue2() {
        return netvalue2;
    }

    public void setNetvalue2(String netvalue2) {
        this.netvalue2 = netvalue2 == null ? null : netvalue2.trim();
    }

    public String getBuildingproject2() {
        return buildingproject2;
    }

    public void setBuildingproject2(String buildingproject2) {
        this.buildingproject2 = buildingproject2 == null ? null : buildingproject2.trim();
    }

    public String getFixedassetall2() {
        return fixedassetall2;
    }

    public void setFixedassetall2(String fixedassetall2) {
        this.fixedassetall2 = fixedassetall2 == null ? null : fixedassetall2.trim();
    }

    public String getInvisibleasset2() {
        return invisibleasset2;
    }

    public void setInvisibleasset2(String invisibleasset2) {
        this.invisibleasset2 = invisibleasset2 == null ? null : invisibleasset2.trim();
    }

    public String getAssetall2() {
        return assetall2;
    }

    public void setAssetall2(String assetall2) {
        this.assetall2 = assetall2 == null ? null : assetall2.trim();
    }

    public String getShortloan2() {
        return shortloan2;
    }

    public void setShortloan2(String shortloan2) {
        this.shortloan2 = shortloan2 == null ? null : shortloan2.trim();
    }

    public String getBankloan2() {
        return bankloan2;
    }

    public void setBankloan2(String bankloan2) {
        this.bankloan2 = bankloan2 == null ? null : bankloan2.trim();
    }

    public String getAccountspayable2() {
        return accountspayable2;
    }

    public void setAccountspayable2(String accountspayable2) {
        this.accountspayable2 = accountspayable2 == null ? null : accountspayable2.trim();
    }

    public String getDepositreceived2() {
        return depositreceived2;
    }

    public void setDepositreceived2(String depositreceived2) {
        this.depositreceived2 = depositreceived2 == null ? null : depositreceived2.trim();
    }

    public String getUnpaidtax2() {
        return unpaidtax2;
    }

    public void setUnpaidtax2(String unpaidtax2) {
        this.unpaidtax2 = unpaidtax2 == null ? null : unpaidtax2.trim();
    }

    public String getFloatdebt2() {
        return floatdebt2;
    }

    public void setFloatdebt2(String floatdebt2) {
        this.floatdebt2 = floatdebt2 == null ? null : floatdebt2.trim();
    }

    public String getFloatdebtall2() {
        return floatdebtall2;
    }

    public void setFloatdebtall2(String floatdebtall2) {
        this.floatdebtall2 = floatdebtall2 == null ? null : floatdebtall2.trim();
    }

    public String getLongdebtall2() {
        return longdebtall2;
    }

    public void setLongdebtall2(String longdebtall2) {
        this.longdebtall2 = longdebtall2 == null ? null : longdebtall2.trim();
    }

    public String getRegistercapital2() {
        return registercapital2;
    }

    public void setRegistercapital2(String registercapital2) {
        this.registercapital2 = registercapital2 == null ? null : registercapital2.trim();
    }

    public String getRealcapital2() {
        return realcapital2;
    }

    public void setRealcapital2(String realcapital2) {
        this.realcapital2 = realcapital2 == null ? null : realcapital2.trim();
    }

    public String getCapitalreserve2() {
        return capitalreserve2;
    }

    public void setCapitalreserve2(String capitalreserve2) {
        this.capitalreserve2 = capitalreserve2 == null ? null : capitalreserve2.trim();
    }

    public String getSurplusreserve2() {
        return surplusreserve2;
    }

    public void setSurplusreserve2(String surplusreserve2) {
        this.surplusreserve2 = surplusreserve2 == null ? null : surplusreserve2.trim();
    }

    public String getUnallotprofit2() {
        return unallotprofit2;
    }

    public void setUnallotprofit2(String unallotprofit2) {
        this.unallotprofit2 = unallotprofit2 == null ? null : unallotprofit2.trim();
    }

    public String getTotalequity2() {
        return totalequity2;
    }

    public void setTotalequity2(String totalequity2) {
        this.totalequity2 = totalequity2 == null ? null : totalequity2.trim();
    }

    public String getTotalequity12() {
        return totalequity12;
    }

    public void setTotalequity12(String totalequity12) {
        this.totalequity12 = totalequity12 == null ? null : totalequity12.trim();
    }

    public String getHandingcost2() {
        return handingcost2;
    }

    public void setHandingcost2(String handingcost2) {
        this.handingcost2 = handingcost2 == null ? null : handingcost2.trim();
    }

    public String getFinancialcost2() {
        return financialcost2;
    }

    public void setFinancialcost2(String financialcost2) {
        this.financialcost2 = financialcost2 == null ? null : financialcost2.trim();
    }

    public String getInterestexpense2() {
        return interestexpense2;
    }

    public void setInterestexpense2(String interestexpense2) {
        this.interestexpense2 = interestexpense2 == null ? null : interestexpense2.trim();
    }

    public String getBusinessprofit2() {
        return businessprofit2;
    }

    public void setBusinessprofit2(String businessprofit2) {
        this.businessprofit2 = businessprofit2 == null ? null : businessprofit2.trim();
    }

    public String getInvestincome2() {
        return investincome2;
    }

    public void setInvestincome2(String investincome2) {
        this.investincome2 = investincome2 == null ? null : investincome2.trim();
    }

    public String getSubsidyincome2() {
        return subsidyincome2;
    }

    public void setSubsidyincome2(String subsidyincome2) {
        this.subsidyincome2 = subsidyincome2 == null ? null : subsidyincome2.trim();
    }

    public String getUnbusinessincome2() {
        return unbusinessincome2;
    }

    public void setUnbusinessincome2(String unbusinessincome2) {
        this.unbusinessincome2 = unbusinessincome2 == null ? null : unbusinessincome2.trim();
    }

    public String getUnbusinessexpense2() {
        return unbusinessexpense2;
    }

    public void setUnbusinessexpense2(String unbusinessexpense2) {
        this.unbusinessexpense2 = unbusinessexpense2 == null ? null : unbusinessexpense2.trim();
    }

    public String getProfitloss2() {
        return profitloss2;
    }

    public void setProfitloss2(String profitloss2) {
        this.profitloss2 = profitloss2 == null ? null : profitloss2.trim();
    }

    public String getTotalprofit2() {
        return totalprofit2;
    }

    public void setTotalprofit2(String totalprofit2) {
        this.totalprofit2 = totalprofit2 == null ? null : totalprofit2.trim();
    }

    public String getPayableincometax2() {
        return payableincometax2;
    }

    public void setPayableincometax2(String payableincometax2) {
        this.payableincometax2 = payableincometax2 == null ? null : payableincometax2.trim();
    }

    public String getPayableaddedtax2() {
        return payableaddedtax2;
    }

    public void setPayableaddedtax2(String payableaddedtax2) {
        this.payableaddedtax2 = payableaddedtax2 == null ? null : payableaddedtax2.trim();
    }

    public String getPaidaddedtax2() {
        return paidaddedtax2;
    }

    public void setPaidaddedtax2(String paidaddedtax2) {
        this.paidaddedtax2 = paidaddedtax2 == null ? null : paidaddedtax2.trim();
    }

    public String getNetprofit2() {
        return netprofit2;
    }

    public void setNetprofit2(String netprofit2) {
        this.netprofit2 = netprofit2 == null ? null : netprofit2.trim();
    }

    public String getSourcecode() {
        return sourcecode;
    }

    public void setSourcecode(String sourcecode) {
        this.sourcecode = sourcecode == null ? null : sourcecode.trim();
    }

    public String getSourcename() {
        return sourcename;
    }

    public void setSourcename(String sourcename) {
        this.sourcename = sourcename == null ? null : sourcename.trim();
    }

    public String getRunitid() {
        return runitid;
    }

    public void setRunitid(String runitid) {
        this.runitid = runitid == null ? null : runitid.trim();
    }

    public String getRunitname() {
        return runitname;
    }

    public void setRunitname(String runitname) {
        this.runitname = runitname == null ? null : runitname.trim();
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder == null ? null : recorder.trim();
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

	@Override
	public boolean equalsIfIdNull(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}