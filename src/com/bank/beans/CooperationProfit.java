package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class CooperationProfit  extends BaseEntity<Long>{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6732059715333840763L;


    private String datasendorgan;

    private String organcode;

    private String taxcode;

    private String businesslicence;

    private String trustcode;

    private String yearmonth;

    private String mainincome;

    private String mainincomeExport;

    private String mainincomeImport;

    private String discount;

    private String mainincomeNetmargin;

    private String maincost;

    private String maincostExport;

    private String maintaxpay;

    private String operationcost;

    private String othercost;

    private String delayincome;

    private String purchasingagent;

    private String otherpurchasingagent;

    private String mainnetmargin;

    private String othernetmargin;

    private String mainexpenses;

    private String manageexpense;

    private String finaceexpense;

    private String otherexpense;

    private String incomeNetmargin;

    private String investincome;

    private String futuresincome;

    private String subsidyincome;

    private String subsidyincomeBefore;

    private String incomeO;

    private String incomeONetmargin;

    private String incomeONonemoney;

    private String incomeOWxzc;

    private String incomeOFk;

    private String incomeOOther;

    private String incomeOOthersalary;

    private String outcomeO;

    private String outcomeONetmargin;

    private String outcomeOZwcz;

    private String outcomeOFk;

    private String outcomeOJz;

    private String outcomeOOther;

    private String outcomeOOthersalary;

    private String allprofit;

    private String incomdetax;

    private String fewpartnerincome;

    private String unsureloss;

    private String netmargin;

    private String beginofyearundistributed;

    private String yygjbk;

    private String qttzys;

    private String kgfpll;

    private String dxlyll;

    private String bcldzb;

    private String tqfdyygj;

    private String tqfdyygyj;

    private String tqzgjljfldy;

    private String tqcbj;

    private String tqqyfzjj;

    private String llghtz;

    private String llghtzother;

    private String kgtzzffll;

    private String yfyxggl;

    private String tqryyygj;

    private String yfptggl;

    private String zzzbptggl;

    private String zzzbptgglother;

    private String zzzbptgglundisbute;

    private String zzzbptgglundisbuteBefore;

    private String sourcecode;

    private String sourcename;

    private String runitid;

    private String runitname;

    private String recoder;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recodertime;


    public String getDatasendorgan() {
        return datasendorgan;
    }

    public void setDatasendorgan(String datasendorgan) {
        this.datasendorgan = datasendorgan == null ? null : datasendorgan.trim();
    }

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

    public String getTrustcode() {
        return trustcode;
    }

    public void setTrustcode(String trustcode) {
        this.trustcode = trustcode == null ? null : trustcode.trim();
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth == null ? null : yearmonth.trim();
    }

    public String getMainincome() {
        return mainincome;
    }

    public void setMainincome(String mainincome) {
        this.mainincome = mainincome == null ? null : mainincome.trim();
    }

    public String getMainincomeExport() {
        return mainincomeExport;
    }

    public void setMainincomeExport(String mainincomeExport) {
        this.mainincomeExport = mainincomeExport == null ? null : mainincomeExport.trim();
    }

    public String getMainincomeImport() {
        return mainincomeImport;
    }

    public void setMainincomeImport(String mainincomeImport) {
        this.mainincomeImport = mainincomeImport == null ? null : mainincomeImport.trim();
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount == null ? null : discount.trim();
    }

    public String getMainincomeNetmargin() {
        return mainincomeNetmargin;
    }

    public void setMainincomeNetmargin(String mainincomeNetmargin) {
        this.mainincomeNetmargin = mainincomeNetmargin == null ? null : mainincomeNetmargin.trim();
    }

    public String getMaincost() {
        return maincost;
    }

    public void setMaincost(String maincost) {
        this.maincost = maincost == null ? null : maincost.trim();
    }

    public String getMaincostExport() {
        return maincostExport;
    }

    public void setMaincostExport(String maincostExport) {
        this.maincostExport = maincostExport == null ? null : maincostExport.trim();
    }

    public String getMaintaxpay() {
        return maintaxpay;
    }

    public void setMaintaxpay(String maintaxpay) {
        this.maintaxpay = maintaxpay == null ? null : maintaxpay.trim();
    }

    public String getOperationcost() {
        return operationcost;
    }

    public void setOperationcost(String operationcost) {
        this.operationcost = operationcost == null ? null : operationcost.trim();
    }

    public String getOthercost() {
        return othercost;
    }

    public void setOthercost(String othercost) {
        this.othercost = othercost == null ? null : othercost.trim();
    }

    public String getDelayincome() {
        return delayincome;
    }

    public void setDelayincome(String delayincome) {
        this.delayincome = delayincome == null ? null : delayincome.trim();
    }

    public String getPurchasingagent() {
        return purchasingagent;
    }

    public void setPurchasingagent(String purchasingagent) {
        this.purchasingagent = purchasingagent == null ? null : purchasingagent.trim();
    }

    public String getOtherpurchasingagent() {
        return otherpurchasingagent;
    }

    public void setOtherpurchasingagent(String otherpurchasingagent) {
        this.otherpurchasingagent = otherpurchasingagent == null ? null : otherpurchasingagent.trim();
    }

    public String getMainnetmargin() {
        return mainnetmargin;
    }

    public void setMainnetmargin(String mainnetmargin) {
        this.mainnetmargin = mainnetmargin == null ? null : mainnetmargin.trim();
    }

    public String getOthernetmargin() {
        return othernetmargin;
    }

    public void setOthernetmargin(String othernetmargin) {
        this.othernetmargin = othernetmargin == null ? null : othernetmargin.trim();
    }

    public String getMainexpenses() {
        return mainexpenses;
    }

    public void setMainexpenses(String mainexpenses) {
        this.mainexpenses = mainexpenses == null ? null : mainexpenses.trim();
    }

    public String getManageexpense() {
        return manageexpense;
    }

    public void setManageexpense(String manageexpense) {
        this.manageexpense = manageexpense == null ? null : manageexpense.trim();
    }

    public String getFinaceexpense() {
        return finaceexpense;
    }

    public void setFinaceexpense(String finaceexpense) {
        this.finaceexpense = finaceexpense == null ? null : finaceexpense.trim();
    }

    public String getOtherexpense() {
        return otherexpense;
    }

    public void setOtherexpense(String otherexpense) {
        this.otherexpense = otherexpense == null ? null : otherexpense.trim();
    }

    public String getIncomeNetmargin() {
        return incomeNetmargin;
    }

    public void setIncomeNetmargin(String incomeNetmargin) {
        this.incomeNetmargin = incomeNetmargin == null ? null : incomeNetmargin.trim();
    }

    public String getInvestincome() {
        return investincome;
    }

    public void setInvestincome(String investincome) {
        this.investincome = investincome == null ? null : investincome.trim();
    }

    public String getFuturesincome() {
        return futuresincome;
    }

    public void setFuturesincome(String futuresincome) {
        this.futuresincome = futuresincome == null ? null : futuresincome.trim();
    }

    public String getSubsidyincome() {
        return subsidyincome;
    }

    public void setSubsidyincome(String subsidyincome) {
        this.subsidyincome = subsidyincome == null ? null : subsidyincome.trim();
    }

    public String getSubsidyincomeBefore() {
        return subsidyincomeBefore;
    }

    public void setSubsidyincomeBefore(String subsidyincomeBefore) {
        this.subsidyincomeBefore = subsidyincomeBefore == null ? null : subsidyincomeBefore.trim();
    }

    public String getIncomeO() {
        return incomeO;
    }

    public void setIncomeO(String incomeO) {
        this.incomeO = incomeO == null ? null : incomeO.trim();
    }

    public String getIncomeONetmargin() {
        return incomeONetmargin;
    }

    public void setIncomeONetmargin(String incomeONetmargin) {
        this.incomeONetmargin = incomeONetmargin == null ? null : incomeONetmargin.trim();
    }

    public String getIncomeONonemoney() {
        return incomeONonemoney;
    }

    public void setIncomeONonemoney(String incomeONonemoney) {
        this.incomeONonemoney = incomeONonemoney == null ? null : incomeONonemoney.trim();
    }

    public String getIncomeOWxzc() {
        return incomeOWxzc;
    }

    public void setIncomeOWxzc(String incomeOWxzc) {
        this.incomeOWxzc = incomeOWxzc == null ? null : incomeOWxzc.trim();
    }

    public String getIncomeOFk() {
        return incomeOFk;
    }

    public void setIncomeOFk(String incomeOFk) {
        this.incomeOFk = incomeOFk == null ? null : incomeOFk.trim();
    }

    public String getIncomeOOther() {
        return incomeOOther;
    }

    public void setIncomeOOther(String incomeOOther) {
        this.incomeOOther = incomeOOther == null ? null : incomeOOther.trim();
    }

    public String getIncomeOOthersalary() {
        return incomeOOthersalary;
    }

    public void setIncomeOOthersalary(String incomeOOthersalary) {
        this.incomeOOthersalary = incomeOOthersalary == null ? null : incomeOOthersalary.trim();
    }

    public String getOutcomeO() {
        return outcomeO;
    }

    public void setOutcomeO(String outcomeO) {
        this.outcomeO = outcomeO == null ? null : outcomeO.trim();
    }

    public String getOutcomeONetmargin() {
        return outcomeONetmargin;
    }

    public void setOutcomeONetmargin(String outcomeONetmargin) {
        this.outcomeONetmargin = outcomeONetmargin == null ? null : outcomeONetmargin.trim();
    }

    public String getOutcomeOZwcz() {
        return outcomeOZwcz;
    }

    public void setOutcomeOZwcz(String outcomeOZwcz) {
        this.outcomeOZwcz = outcomeOZwcz == null ? null : outcomeOZwcz.trim();
    }

    public String getOutcomeOFk() {
        return outcomeOFk;
    }

    public void setOutcomeOFk(String outcomeOFk) {
        this.outcomeOFk = outcomeOFk == null ? null : outcomeOFk.trim();
    }

    public String getOutcomeOJz() {
        return outcomeOJz;
    }

    public void setOutcomeOJz(String outcomeOJz) {
        this.outcomeOJz = outcomeOJz == null ? null : outcomeOJz.trim();
    }

    public String getOutcomeOOther() {
        return outcomeOOther;
    }

    public void setOutcomeOOther(String outcomeOOther) {
        this.outcomeOOther = outcomeOOther == null ? null : outcomeOOther.trim();
    }

    public String getOutcomeOOthersalary() {
        return outcomeOOthersalary;
    }

    public void setOutcomeOOthersalary(String outcomeOOthersalary) {
        this.outcomeOOthersalary = outcomeOOthersalary == null ? null : outcomeOOthersalary.trim();
    }

    public String getAllprofit() {
        return allprofit;
    }

    public void setAllprofit(String allprofit) {
        this.allprofit = allprofit == null ? null : allprofit.trim();
    }

    public String getIncomdetax() {
        return incomdetax;
    }

    public void setIncomdetax(String incomdetax) {
        this.incomdetax = incomdetax == null ? null : incomdetax.trim();
    }

    public String getFewpartnerincome() {
        return fewpartnerincome;
    }

    public void setFewpartnerincome(String fewpartnerincome) {
        this.fewpartnerincome = fewpartnerincome == null ? null : fewpartnerincome.trim();
    }

    public String getUnsureloss() {
        return unsureloss;
    }

    public void setUnsureloss(String unsureloss) {
        this.unsureloss = unsureloss == null ? null : unsureloss.trim();
    }

    public String getNetmargin() {
        return netmargin;
    }

    public void setNetmargin(String netmargin) {
        this.netmargin = netmargin == null ? null : netmargin.trim();
    }

    public String getBeginofyearundistributed() {
        return beginofyearundistributed;
    }

    public void setBeginofyearundistributed(String beginofyearundistributed) {
        this.beginofyearundistributed = beginofyearundistributed == null ? null : beginofyearundistributed.trim();
    }

    public String getYygjbk() {
        return yygjbk;
    }

    public void setYygjbk(String yygjbk) {
        this.yygjbk = yygjbk == null ? null : yygjbk.trim();
    }

    public String getQttzys() {
        return qttzys;
    }

    public void setQttzys(String qttzys) {
        this.qttzys = qttzys == null ? null : qttzys.trim();
    }

    public String getKgfpll() {
        return kgfpll;
    }

    public void setKgfpll(String kgfpll) {
        this.kgfpll = kgfpll == null ? null : kgfpll.trim();
    }

    public String getDxlyll() {
        return dxlyll;
    }

    public void setDxlyll(String dxlyll) {
        this.dxlyll = dxlyll == null ? null : dxlyll.trim();
    }

    public String getBcldzb() {
        return bcldzb;
    }

    public void setBcldzb(String bcldzb) {
        this.bcldzb = bcldzb == null ? null : bcldzb.trim();
    }

    public String getTqfdyygj() {
        return tqfdyygj;
    }

    public void setTqfdyygj(String tqfdyygj) {
        this.tqfdyygj = tqfdyygj == null ? null : tqfdyygj.trim();
    }

    public String getTqfdyygyj() {
        return tqfdyygyj;
    }

    public void setTqfdyygyj(String tqfdyygyj) {
        this.tqfdyygyj = tqfdyygyj == null ? null : tqfdyygyj.trim();
    }

    public String getTqzgjljfldy() {
        return tqzgjljfldy;
    }

    public void setTqzgjljfldy(String tqzgjljfldy) {
        this.tqzgjljfldy = tqzgjljfldy == null ? null : tqzgjljfldy.trim();
    }

    public String getTqcbj() {
        return tqcbj;
    }

    public void setTqcbj(String tqcbj) {
        this.tqcbj = tqcbj == null ? null : tqcbj.trim();
    }

    public String getTqqyfzjj() {
        return tqqyfzjj;
    }

    public void setTqqyfzjj(String tqqyfzjj) {
        this.tqqyfzjj = tqqyfzjj == null ? null : tqqyfzjj.trim();
    }

    public String getLlghtz() {
        return llghtz;
    }

    public void setLlghtz(String llghtz) {
        this.llghtz = llghtz == null ? null : llghtz.trim();
    }

    public String getLlghtzother() {
        return llghtzother;
    }

    public void setLlghtzother(String llghtzother) {
        this.llghtzother = llghtzother == null ? null : llghtzother.trim();
    }

    public String getKgtzzffll() {
        return kgtzzffll;
    }

    public void setKgtzzffll(String kgtzzffll) {
        this.kgtzzffll = kgtzzffll == null ? null : kgtzzffll.trim();
    }

    public String getYfyxggl() {
        return yfyxggl;
    }

    public void setYfyxggl(String yfyxggl) {
        this.yfyxggl = yfyxggl == null ? null : yfyxggl.trim();
    }

    public String getTqryyygj() {
        return tqryyygj;
    }

    public void setTqryyygj(String tqryyygj) {
        this.tqryyygj = tqryyygj == null ? null : tqryyygj.trim();
    }

    public String getYfptggl() {
        return yfptggl;
    }

    public void setYfptggl(String yfptggl) {
        this.yfptggl = yfptggl == null ? null : yfptggl.trim();
    }

    public String getZzzbptggl() {
        return zzzbptggl;
    }

    public void setZzzbptggl(String zzzbptggl) {
        this.zzzbptggl = zzzbptggl == null ? null : zzzbptggl.trim();
    }

    public String getZzzbptgglother() {
        return zzzbptgglother;
    }

    public void setZzzbptgglother(String zzzbptgglother) {
        this.zzzbptgglother = zzzbptgglother == null ? null : zzzbptgglother.trim();
    }

    public String getZzzbptgglundisbute() {
        return zzzbptgglundisbute;
    }

    public void setZzzbptgglundisbute(String zzzbptgglundisbute) {
        this.zzzbptgglundisbute = zzzbptgglundisbute == null ? null : zzzbptgglundisbute.trim();
    }

    public String getZzzbptgglundisbuteBefore() {
        return zzzbptgglundisbuteBefore;
    }

    public void setZzzbptgglundisbuteBefore(String zzzbptgglundisbuteBefore) {
        this.zzzbptgglundisbuteBefore = zzzbptgglundisbuteBefore == null ? null : zzzbptgglundisbuteBefore.trim();
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

    public String getRecoder() {
        return recoder;
    }

    public void setRecoder(String recoder) {
        this.recoder = recoder == null ? null : recoder.trim();
    }

    public Date getRecodertime() {
        return recodertime;
    }

    public void setRecodertime(Date recodertime) {
        this.recodertime = recodertime;
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