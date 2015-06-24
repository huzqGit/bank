package com.bank.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.common.bean.BaseEntity;

public class CooperationProfit extends BaseEntity<Long>{

	private static final long serialVersionUID = 6893191543861951859L;
	
	/**
	 * 字段与备注映射
	 */
	public static Map<String,String> field_remark = new HashMap<String, String>();
	/**
	 * 备注与字段映射
	 */
	public static Map<String,String> remark_field = new HashMap<String, String>();
	
	private String error_label;
	
	//select
	//'private String '||lower(name)||';'
	//from sysibm.syscolumns t where TBNAME='T_COOPERATION_PROFIT'
	//order by t.COLNO

	private Long profitid;
	private String organ_id;
	private String recoder;
	private Date recodertime;
	private String datasendorgan;
	private String taxcode;
	private String organtrustcode;
	private String organcode;
	private String yearmonth;
	private String mainincome;
	private String mainincome_export;
	private String mainincome_import;
	private String discount;
	private String mainincome_netmargin;
	private String maincost;
	private String maincost_export;
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
	private String income_netmargin;
	private String investincome;
	private String futuresincome;
	private String subsidyincome;
	private String subsidyincome_before;
	private String income_o;
	private String income_o_netmargin;
	private String income_o_nonemoney;
	private String income_o_wxzc;
	private String income_o_fk;
	private String income_o_other;
	private String income_o_othersalary;
	private String outcome_o;
	private String outcome_o_netmargin;
	private String outcome_o_zwcz;
	private String outcome_o_fk;
	private String outcome_o_jz;
	private String outcome_o_other;
	private String outcome_o_othersalary;
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
	private String zzzbptgglundisbute_before;

	public String getError_label() {
		return error_label;
	}

	public void setError_label(String error_label) {
		this.error_label = error_label;
	}

	@Override
	public boolean equalsIfIdNull(Object o) {
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}

	public Long getProfitid() {
		return profitid;
	}

	public void setProfitid(Long profitid) {
		this.profitid = profitid;
	}

	public String getOrgan_id() {
		return organ_id;
	}

	public void setOrgan_id(String organ_id) {
		this.organ_id = organ_id;
	}

	public String getRecoder() {
		return recoder;
	}

	public void setRecoder(String recoder) {
		this.recoder = recoder;
	}

	public Date getRecodertime() {
		return recodertime;
	}

	public void setRecodertime(Date recodertime) {
		this.recodertime = recodertime;
	}

	public String getDatasendorgan() {
		return datasendorgan;
	}

	public void setDatasendorgan(String datasendorgan) {
		this.datasendorgan = datasendorgan;
	}

	public String getTaxcode() {
		return taxcode;
	}

	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}

	public String getOrgantrustcode() {
		return organtrustcode;
	}

	public void setOrgantrustcode(String organtrustcode) {
		this.organtrustcode = organtrustcode;
	}

	public String getOrgancode() {
		return organcode;
	}

	public void setOrgancode(String organcode) {
		this.organcode = organcode;
	}

	public String getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(String yearmonth) {
		this.yearmonth = yearmonth;
	}

	public String getMainincome() {
		return mainincome;
	}

	public void setMainincome(String mainincome) {
		this.mainincome = mainincome;
	}

	public String getMainincome_export() {
		return mainincome_export;
	}

	public void setMainincome_export(String mainincome_export) {
		this.mainincome_export = mainincome_export;
	}

	public String getMainincome_import() {
		return mainincome_import;
	}

	public void setMainincome_import(String mainincome_import) {
		this.mainincome_import = mainincome_import;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getMainincome_netmargin() {
		return mainincome_netmargin;
	}

	public void setMainincome_netmargin(String mainincome_netmargin) {
		this.mainincome_netmargin = mainincome_netmargin;
	}

	public String getMaincost() {
		return maincost;
	}

	public void setMaincost(String maincost) {
		this.maincost = maincost;
	}

	public String getMaincost_export() {
		return maincost_export;
	}

	public void setMaincost_export(String maincost_export) {
		this.maincost_export = maincost_export;
	}

	public String getMaintaxpay() {
		return maintaxpay;
	}

	public void setMaintaxpay(String maintaxpay) {
		this.maintaxpay = maintaxpay;
	}

	public String getOperationcost() {
		return operationcost;
	}

	public void setOperationcost(String operationcost) {
		this.operationcost = operationcost;
	}

	public String getOthercost() {
		return othercost;
	}

	public void setOthercost(String othercost) {
		this.othercost = othercost;
	}

	public String getDelayincome() {
		return delayincome;
	}

	public void setDelayincome(String delayincome) {
		this.delayincome = delayincome;
	}

	public String getPurchasingagent() {
		return purchasingagent;
	}

	public void setPurchasingagent(String purchasingagent) {
		this.purchasingagent = purchasingagent;
	}

	public String getOtherpurchasingagent() {
		return otherpurchasingagent;
	}

	public void setOtherpurchasingagent(String otherpurchasingagent) {
		this.otherpurchasingagent = otherpurchasingagent;
	}

	public String getMainnetmargin() {
		return mainnetmargin;
	}

	public void setMainnetmargin(String mainnetmargin) {
		this.mainnetmargin = mainnetmargin;
	}

	public String getOthernetmargin() {
		return othernetmargin;
	}

	public void setOthernetmargin(String othernetmargin) {
		this.othernetmargin = othernetmargin;
	}

	public String getMainexpenses() {
		return mainexpenses;
	}

	public void setMainexpenses(String mainexpenses) {
		this.mainexpenses = mainexpenses;
	}

	public String getManageexpense() {
		return manageexpense;
	}

	public void setManageexpense(String manageexpense) {
		this.manageexpense = manageexpense;
	}

	public String getFinaceexpense() {
		return finaceexpense;
	}

	public void setFinaceexpense(String finaceexpense) {
		this.finaceexpense = finaceexpense;
	}

	public String getOtherexpense() {
		return otherexpense;
	}

	public void setOtherexpense(String otherexpense) {
		this.otherexpense = otherexpense;
	}

	public String getIncome_netmargin() {
		return income_netmargin;
	}

	public void setIncome_netmargin(String income_netmargin) {
		this.income_netmargin = income_netmargin;
	}

	public String getInvestincome() {
		return investincome;
	}

	public void setInvestincome(String investincome) {
		this.investincome = investincome;
	}

	public String getFuturesincome() {
		return futuresincome;
	}

	public void setFuturesincome(String futuresincome) {
		this.futuresincome = futuresincome;
	}

	public String getSubsidyincome() {
		return subsidyincome;
	}

	public void setSubsidyincome(String subsidyincome) {
		this.subsidyincome = subsidyincome;
	}

	public String getSubsidyincome_before() {
		return subsidyincome_before;
	}

	public void setSubsidyincome_before(String subsidyincome_before) {
		this.subsidyincome_before = subsidyincome_before;
	}

	public String getIncome_o() {
		return income_o;
	}

	public void setIncome_o(String income_o) {
		this.income_o = income_o;
	}

	public String getIncome_o_netmargin() {
		return income_o_netmargin;
	}

	public void setIncome_o_netmargin(String income_o_netmargin) {
		this.income_o_netmargin = income_o_netmargin;
	}

	public String getIncome_o_nonemoney() {
		return income_o_nonemoney;
	}

	public void setIncome_o_nonemoney(String income_o_nonemoney) {
		this.income_o_nonemoney = income_o_nonemoney;
	}

	public String getIncome_o_wxzc() {
		return income_o_wxzc;
	}

	public void setIncome_o_wxzc(String income_o_wxzc) {
		this.income_o_wxzc = income_o_wxzc;
	}

	public String getIncome_o_fk() {
		return income_o_fk;
	}

	public void setIncome_o_fk(String income_o_fk) {
		this.income_o_fk = income_o_fk;
	}

	public String getIncome_o_other() {
		return income_o_other;
	}

	public void setIncome_o_other(String income_o_other) {
		this.income_o_other = income_o_other;
	}

	public String getIncome_o_othersalary() {
		return income_o_othersalary;
	}

	public void setIncome_o_othersalary(String income_o_othersalary) {
		this.income_o_othersalary = income_o_othersalary;
	}

	public String getOutcome_o() {
		return outcome_o;
	}

	public void setOutcome_o(String outcome_o) {
		this.outcome_o = outcome_o;
	}

	public String getOutcome_o_netmargin() {
		return outcome_o_netmargin;
	}

	public void setOutcome_o_netmargin(String outcome_o_netmargin) {
		this.outcome_o_netmargin = outcome_o_netmargin;
	}

	public String getOutcome_o_zwcz() {
		return outcome_o_zwcz;
	}

	public void setOutcome_o_zwcz(String outcome_o_zwcz) {
		this.outcome_o_zwcz = outcome_o_zwcz;
	}

	public String getOutcome_o_fk() {
		return outcome_o_fk;
	}

	public void setOutcome_o_fk(String outcome_o_fk) {
		this.outcome_o_fk = outcome_o_fk;
	}

	public String getOutcome_o_jz() {
		return outcome_o_jz;
	}

	public void setOutcome_o_jz(String outcome_o_jz) {
		this.outcome_o_jz = outcome_o_jz;
	}

	public String getOutcome_o_other() {
		return outcome_o_other;
	}

	public void setOutcome_o_other(String outcome_o_other) {
		this.outcome_o_other = outcome_o_other;
	}

	public String getOutcome_o_othersalary() {
		return outcome_o_othersalary;
	}

	public void setOutcome_o_othersalary(String outcome_o_othersalary) {
		this.outcome_o_othersalary = outcome_o_othersalary;
	}

	public String getAllprofit() {
		return allprofit;
	}

	public void setAllprofit(String allprofit) {
		this.allprofit = allprofit;
	}

	public String getIncomdetax() {
		return incomdetax;
	}

	public void setIncomdetax(String incomdetax) {
		this.incomdetax = incomdetax;
	}

	public String getFewpartnerincome() {
		return fewpartnerincome;
	}

	public void setFewpartnerincome(String fewpartnerincome) {
		this.fewpartnerincome = fewpartnerincome;
	}

	public String getUnsureloss() {
		return unsureloss;
	}

	public void setUnsureloss(String unsureloss) {
		this.unsureloss = unsureloss;
	}

	public String getNetmargin() {
		return netmargin;
	}

	public void setNetmargin(String netmargin) {
		this.netmargin = netmargin;
	}

	public String getBeginofyearundistributed() {
		return beginofyearundistributed;
	}

	public void setBeginofyearundistributed(String beginofyearundistributed) {
		this.beginofyearundistributed = beginofyearundistributed;
	}

	public String getYygjbk() {
		return yygjbk;
	}

	public void setYygjbk(String yygjbk) {
		this.yygjbk = yygjbk;
	}

	public String getQttzys() {
		return qttzys;
	}

	public void setQttzys(String qttzys) {
		this.qttzys = qttzys;
	}

	public String getKgfpll() {
		return kgfpll;
	}

	public void setKgfpll(String kgfpll) {
		this.kgfpll = kgfpll;
	}

	public String getDxlyll() {
		return dxlyll;
	}

	public void setDxlyll(String dxlyll) {
		this.dxlyll = dxlyll;
	}

	public String getBcldzb() {
		return bcldzb;
	}

	public void setBcldzb(String bcldzb) {
		this.bcldzb = bcldzb;
	}

	public String getTqfdyygj() {
		return tqfdyygj;
	}

	public void setTqfdyygj(String tqfdyygj) {
		this.tqfdyygj = tqfdyygj;
	}

	public String getTqfdyygyj() {
		return tqfdyygyj;
	}

	public void setTqfdyygyj(String tqfdyygyj) {
		this.tqfdyygyj = tqfdyygyj;
	}

	public String getTqzgjljfldy() {
		return tqzgjljfldy;
	}

	public void setTqzgjljfldy(String tqzgjljfldy) {
		this.tqzgjljfldy = tqzgjljfldy;
	}

	public String getTqcbj() {
		return tqcbj;
	}

	public void setTqcbj(String tqcbj) {
		this.tqcbj = tqcbj;
	}

	public String getTqqyfzjj() {
		return tqqyfzjj;
	}

	public void setTqqyfzjj(String tqqyfzjj) {
		this.tqqyfzjj = tqqyfzjj;
	}

	public String getLlghtz() {
		return llghtz;
	}

	public void setLlghtz(String llghtz) {
		this.llghtz = llghtz;
	}

	public String getLlghtzother() {
		return llghtzother;
	}

	public void setLlghtzother(String llghtzother) {
		this.llghtzother = llghtzother;
	}

	public String getKgtzzffll() {
		return kgtzzffll;
	}

	public void setKgtzzffll(String kgtzzffll) {
		this.kgtzzffll = kgtzzffll;
	}

	public String getYfyxggl() {
		return yfyxggl;
	}

	public void setYfyxggl(String yfyxggl) {
		this.yfyxggl = yfyxggl;
	}

	public String getTqryyygj() {
		return tqryyygj;
	}

	public void setTqryyygj(String tqryyygj) {
		this.tqryyygj = tqryyygj;
	}

	public String getYfptggl() {
		return yfptggl;
	}

	public void setYfptggl(String yfptggl) {
		this.yfptggl = yfptggl;
	}

	public String getZzzbptggl() {
		return zzzbptggl;
	}

	public void setZzzbptggl(String zzzbptggl) {
		this.zzzbptggl = zzzbptggl;
	}

	public String getZzzbptgglother() {
		return zzzbptgglother;
	}

	public void setZzzbptgglother(String zzzbptgglother) {
		this.zzzbptgglother = zzzbptgglother;
	}

	public String getZzzbptgglundisbute() {
		return zzzbptgglundisbute;
	}

	public void setZzzbptgglundisbute(String zzzbptgglundisbute) {
		this.zzzbptgglundisbute = zzzbptgglundisbute;
	}

	public String getZzzbptgglundisbute_before() {
		return zzzbptgglundisbute_before;
	}

	public void setZzzbptgglundisbute_before(String zzzbptgglundisbute_before) {
		this.zzzbptgglundisbute_before = zzzbptgglundisbute_before;
	}
	
	static {
		field_remark.put("profitid","主键");
		field_remark.put("organ_id","组织机构id");
		field_remark.put("recoder","记录人");
		field_remark.put("recodertime","记录时间");
		field_remark.put("datasendorgan","数据报送机构");
		field_remark.put("taxcode","税务识别码");
		field_remark.put("organtrustcode","机构信用代码");
		field_remark.put("organcode","组织机构代码");
		field_remark.put("yearmonth","年月");
		field_remark.put("mainincome","主营业务收入");
		field_remark.put("mainincome_export","主营业务收入出口产品销售收入");
		field_remark.put("mainincome_import","主营业务收入进口产品销售收入");
		field_remark.put("discount","折扣与拆让");
		field_remark.put("mainincome_netmargin","主营业务收入净额");
		field_remark.put("maincost","主营业务成本");
		field_remark.put("maincost_export","主营业务成本出口产品销售成本");
		field_remark.put("maintaxpay","主营业务税金及附加");
		field_remark.put("operationcost","经营费用");
		field_remark.put("othercost","其他");
		field_remark.put("delayincome","递延收益");
		field_remark.put("purchasingagent","代购代销收入");
		field_remark.put("otherpurchasingagent","其他");
		field_remark.put("mainnetmargin","主营业务利润");
		field_remark.put("othernetmargin","其他业务利润");
		field_remark.put("mainexpenses","营业费用");
		field_remark.put("manageexpense","管理费用");
		field_remark.put("finaceexpense","财务费用");
		field_remark.put("otherexpense","其他");
		field_remark.put("income_netmargin","营业利润");
		field_remark.put("investincome","投资收益");
		field_remark.put("futuresincome","期货收益");
		field_remark.put("subsidyincome","补贴收入");
		field_remark.put("subsidyincome_before","补贴收入补贴前亏损的企业补贴收入");
		field_remark.put("income_o","营业外收入");
		field_remark.put("income_o_netmargin","营业外收入处置固定资产净收益");
		field_remark.put("income_o_nonemoney","营业外收入非货币性交易收益");
		field_remark.put("income_o_wxzc","营业外收入出售无形资产收益");
		field_remark.put("income_o_fk","营业外收入罚款净收入");
		field_remark.put("income_o_other","其他");
		field_remark.put("income_o_othersalary","其他用以前年度含量工资节余弥补利润");
		field_remark.put("outcome_o","营业外支出");
		field_remark.put("outcome_o_netmargin","营业外支出处置固定资产净损失");
		field_remark.put("outcome_o_zwcz","营业外支出债务重组损失");
		field_remark.put("outcome_o_fk","营业外支出罚款支出");
		field_remark.put("outcome_o_jz","营业外支出捐赠支出");
		field_remark.put("outcome_o_other","其他支出");
		field_remark.put("outcome_o_othersalary","其他支出结转的含量工资包干节余");
		field_remark.put("allprofit","利润总额");
		field_remark.put("incomdetax","所得税");
		field_remark.put("fewpartnerincome","少数股东损益");
		field_remark.put("unsureloss","未确认的投资损失");
		field_remark.put("netmargin","净利润");
		field_remark.put("beginofyearundistributed","年初未分配利润");
		field_remark.put("yygjbk","盈余公积补亏");
		field_remark.put("qttzys","其他调整因素");
		field_remark.put("kgfpll","可供分配的利润");
		field_remark.put("dxlyll","单项留用的利润");
		field_remark.put("bcldzb","补充流动资本");
		field_remark.put("tqfdyygj","提取法定盈余公积");
		field_remark.put("tqfdyygyj","提取法定公益金");
		field_remark.put("tqzgjljfldy","提取职工奖励及福利基金");
		field_remark.put("tqcbj","提取储备基金");
		field_remark.put("tqqyfzjj","提取企业发展基金");
		field_remark.put("llghtz","利润归还投资");
		field_remark.put("llghtzother","其他");
		field_remark.put("kgtzzffll","可供投资者分配的利润");
		field_remark.put("yfyxggl","应付优先股股利");
		field_remark.put("tqryyygj","提取任意盈余公积");
		field_remark.put("yfptggl","应付普通股股利");
		field_remark.put("zzzbptggl","转作资本的普通股股利");
		field_remark.put("zzzbptgglother","其他");
		field_remark.put("zzzbptgglundisbute","未分配利润");
		field_remark.put("zzzbptgglundisbute_before","未分配利润应由以后年度税前利润弥补的亏损");
		field_remark.put("error_label", "错误描述");
		
		for(Map.Entry<String, String> entry : field_remark.entrySet()){
			remark_field.put(entry.getValue(), entry.getKey());
		}
	}
	
}
