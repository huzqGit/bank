package com.bank.utils.excel.importer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bank.beans.FarmerCooperationDebt;
import com.bank.dao.ICooperationDebtDao;
import com.bank.utils.PropConfig;
import com.bank.utils.excel.ImportResult;
import com.common.tools.StringUtil;

@Component("cooperationDebtImporter")
public class CooperationDebtImporter extends ExcelImporter<FarmerCooperationDebt> {
	
	private static Logger log = LoggerFactory.getLogger(CooperationDebtImporter.class);
	
	private static String[] labels = {"年月","合作社名称","组织机构编码",
		"货币资金","货币资金(期末值)",
		"短期投资","短期投资(期末值)",
		"应收账款净额","应收账款净额(期末值)",
		"预付账款","预付账款(期末值)",
		"存货","存货(期末值)",
		"其他流动资产","其他流动资产(期末值)",
		"流动资产合计","流动资产合计(期末值)",
		"固定资产原价","固定资产原价(期末值)",
		"其中折旧","其中折旧(期末值)",
		"固定资产净值","固定资产净值(期末值)",
		"在建项目","在建项目(期末值)",
		"固定资产合计","固定资产合计(期末值)",
		"无形及递延资产合计","无形及递延资产合计(期末值)",
		"资产合计","资产合计(期末值)",
		"短期借款","短期借款(期末值)",
		"银行借款","银行借款(期末值)",
		"应付账款","应付账款(期末值)",
		"预收账款","预收账款(期末值)",
		"未缴税金","未缴税金(期末值)",
		"其他流动负债","其他流动负债(期末值)",
		"流动负债合计","流动负债合计(期末值)",
		"长期负债合计","长期负债合计(期末值)",
		"注册资本","注册资本(期末值)",
		"实收资本","实收资本(期末值)",
		"资本公积","资本公积(期末值)",
		"盈余公积","盈余公积(期末值)",
		"未分配利润","未分配利润(期末值)",
		"所有者权益合计","所有者权益合计(期末值)",
		"负债和所有者权益合计","负债和所有者权益合计(期末值)",
		"管理费用","管理费用(期末值)",
		"财务费用","财务费用(期末值)",
		"其中利息支出","其中利息支出(期末值)",
		"营业利润","营业利润(期末值)",
		"投资收益","投资收益(期末值)",
		"国家补贴收入","国家补贴收入(期末值)",
		"营业外收入","营业外收入(期末值)",
		"营业外支出","营业外支出(期末值)",
		"以前年度损益调整","以前年度损益调整(期末值)",
		"利润总和","利润总和(期末值)",
		"应交所得税","应交所得税(期末值)",
		"应交增值税","应交增值税(期末值)",
		"实交增值税","实交增值税(期末值)",
		"利润净额","利润净额(期末值)",
	};
	
	private static String error_label = "错误描述";
	
	
	@Resource(name="cooperationDebtDao")
	private ICooperationDebtDao cooperationDao;
	
	private Map<String, Object> defaultValues;
	
	public CooperationDebtImporter() {
		super(labels);
	}
	
	public CooperationDebtImporter setMapValues(Map<String, Object> defaultValues){
		this.defaultValues = defaultValues;
		return this;
	}
	
	public CooperationDebtImporter(Map<String, Object> defaultValues) {
		super(labels);
		this.defaultValues = defaultValues;
	}

	@Override
	protected FarmerCooperationDebt convert(Map<String, String> map) throws Exception {
		
		String[] notNullField = PropConfig.getPropValue("CooperationDebtImporter_NotNull_Field").split(";");
		FarmerCooperationDebt p = new FarmerCooperationDebt();
		try{
			p.setSourcecode((String)defaultValues.get("sourcecode"));
		}catch(Exception e){
			throw new Exception("数据来源不能为空");
		}
		try {
			p.setOrgan_id((String)defaultValues.get("organ_id"));
			p.setRecorder((String)defaultValues.get("recorder"));
		} catch (Exception e1) {
			throw new Exception("session失效,请重新登录");
		}
		p.setRecordtime(new Date());
		int labelIndex = 0;
		try {
			p.setYearmonth(map.get(getLabels()[labelIndex++]));
			p.setCooperationname(map.get(getLabels()[labelIndex++]));
			p.setOrgancode(map.get(getLabels()[labelIndex++]));
			/*采取该语句生成下列代码
			 select 'p.set'||initcap(lower(name))||'(map.get(getLabels()[labelIndex++]));','p.set'||initcap(lower(name))||'2(map.get(getLabels()[labelIndex++]));' from sysibm.syscolumns t where TBNAME='T_COOPERATION_DEBT'
			 and t.RE	MARKS not like '%期末值%' and lower(t.NAME) not in('debtid','organcode','recorder','yearmonth','cooperationname','recordtime')
			 order by COLNO;
			 */
			p.setCashcapital(map.get(getLabels()[labelIndex++]));	p.setCashcapital2(map.get(getLabels()[labelIndex++]));
			p.setShortinvest(map.get(getLabels()[labelIndex++]));	p.setShortinvest2(map.get(getLabels()[labelIndex++]));
			p.setReceivables(map.get(getLabels()[labelIndex++]));	p.setReceivables2(map.get(getLabels()[labelIndex++]));
			p.setPrepayment(map.get(getLabels()[labelIndex++]));	p.setPrepayment2(map.get(getLabels()[labelIndex++]));
			p.setInventory(map.get(getLabels()[labelIndex++]));	p.setInventory2(map.get(getLabels()[labelIndex++]));
			p.setFloatasset(map.get(getLabels()[labelIndex++]));	p.setFloatasset2(map.get(getLabels()[labelIndex++]));
			p.setFloatassetall(map.get(getLabels()[labelIndex++]));	p.setFloatassetall2(map.get(getLabels()[labelIndex++]));
			p.setFixedasset(map.get(getLabels()[labelIndex++]));	p.setFixedasset2(map.get(getLabels()[labelIndex++]));
			p.setDeprecication(map.get(getLabels()[labelIndex++]));	p.setDeprecication2(map.get(getLabels()[labelIndex++]));
			p.setNetvalue(map.get(getLabels()[labelIndex++]));	p.setNetvalue2(map.get(getLabels()[labelIndex++]));
			p.setBuildingproject(map.get(getLabels()[labelIndex++]));	p.setBuildingproject2(map.get(getLabels()[labelIndex++]));
			p.setFixedassetall(map.get(getLabels()[labelIndex++]));	p.setFixedassetall2(map.get(getLabels()[labelIndex++]));
			p.setInvisibleasset(map.get(getLabels()[labelIndex++]));	p.setInvisibleasset2(map.get(getLabels()[labelIndex++]));
			p.setAssetall(map.get(getLabels()[labelIndex++]));	p.setAssetall2(map.get(getLabels()[labelIndex++]));
			p.setShortloan(map.get(getLabels()[labelIndex++]));	p.setShortloan2(map.get(getLabels()[labelIndex++]));
			p.setBankloan(map.get(getLabels()[labelIndex++]));	p.setBankloan2(map.get(getLabels()[labelIndex++]));
			p.setAccountspayable(map.get(getLabels()[labelIndex++]));	p.setAccountspayable2(map.get(getLabels()[labelIndex++]));
			p.setDepositreceived(map.get(getLabels()[labelIndex++]));	p.setDepositreceived2(map.get(getLabels()[labelIndex++]));
			p.setUnpaidtax(map.get(getLabels()[labelIndex++]));	p.setUnpaidtax2(map.get(getLabels()[labelIndex++]));
			p.setFloatdebt(map.get(getLabels()[labelIndex++]));	p.setFloatdebt2(map.get(getLabels()[labelIndex++]));
			p.setFloatdebtall(map.get(getLabels()[labelIndex++]));	p.setFloatdebtall2(map.get(getLabels()[labelIndex++]));
			p.setLongdebtall(map.get(getLabels()[labelIndex++]));	p.setLongdebtall2(map.get(getLabels()[labelIndex++]));
			p.setRegistercapital(map.get(getLabels()[labelIndex++]));	p.setRegistercapital2(map.get(getLabels()[labelIndex++]));
			p.setRealcapital(map.get(getLabels()[labelIndex++]));	p.setRealcapital2(map.get(getLabels()[labelIndex++]));
			p.setCapitalreserve(map.get(getLabels()[labelIndex++]));	p.setCapitalreserve2(map.get(getLabels()[labelIndex++]));
			p.setSurplusreserve(map.get(getLabels()[labelIndex++]));	p.setSurplusreserve2(map.get(getLabels()[labelIndex++]));
			p.setUnallotprofit(map.get(getLabels()[labelIndex++]));	p.setUnallotprofit2(map.get(getLabels()[labelIndex++]));
			p.setTotalequity(map.get(getLabels()[labelIndex++]));	p.setTotalequity2(map.get(getLabels()[labelIndex++]));
			p.setTotalequity1(map.get(getLabels()[labelIndex++]));	p.setTotalequity12(map.get(getLabels()[labelIndex++]));
			p.setHandingcost(map.get(getLabels()[labelIndex++]));	p.setHandingcost2(map.get(getLabels()[labelIndex++]));
			p.setFinancialcost(map.get(getLabels()[labelIndex++]));	p.setFinancialcost2(map.get(getLabels()[labelIndex++]));
			p.setInterestexpense(map.get(getLabels()[labelIndex++]));	p.setInterestexpense2(map.get(getLabels()[labelIndex++]));
			p.setBusinessprofit(map.get(getLabels()[labelIndex++]));	p.setBusinessprofit2(map.get(getLabels()[labelIndex++]));
			p.setInvestincome(map.get(getLabels()[labelIndex++]));	p.setInvestincome2(map.get(getLabels()[labelIndex++]));
			p.setSubsidyincome(map.get(getLabels()[labelIndex++]));	p.setSubsidyincome2(map.get(getLabels()[labelIndex++]));
			p.setUnbusinessincome(map.get(getLabels()[labelIndex++]));	p.setUnbusinessincome2(map.get(getLabels()[labelIndex++]));
			p.setUnbusinessexpense(map.get(getLabels()[labelIndex++]));	p.setUnbusinessexpense2(map.get(getLabels()[labelIndex++]));
			p.setProfitloss(map.get(getLabels()[labelIndex++]));	p.setProfitloss2(map.get(getLabels()[labelIndex++]));
			p.setTotalprofit(map.get(getLabels()[labelIndex++]));	p.setTotalprofit2(map.get(getLabels()[labelIndex++]));
			p.setPayableincometax(map.get(getLabels()[labelIndex++]));	p.setPayableincometax2(map.get(getLabels()[labelIndex++]));
			p.setPayableaddedtax(map.get(getLabels()[labelIndex++]));	p.setPayableaddedtax2(map.get(getLabels()[labelIndex++]));
			p.setPaidaddedtax(map.get(getLabels()[labelIndex++]));	p.setPaidaddedtax2(map.get(getLabels()[labelIndex++]));
			p.setNetprofit(map.get(getLabels()[labelIndex++]));	p.setNetprofit2(map.get(getLabels()[labelIndex++]));
			
		} catch (Exception e) {
			if (e.getMessage() != null && !"".equals(e.getMessage()) && !"null".equals(e.getMessage()))
				throw new Exception("【"+getLabels()[--labelIndex]+"】为空 或  格式不正确 "+e.getMessage());
			else
				throw new Exception("【"+getLabels()[--labelIndex]+"】为空 或 格式不正确 ");
		}
		Method[] methods = p.getClass().getDeclaredMethods();
		String name = null;
		boolean flag = false;
		for(Method m : methods){
			flag = false;
			name = m.getName();
			if(name.startsWith("get")){
				for(String s : notNullField){
					s = "get"+StringUtil.toUpperCaseFirstOne(s);
					if(name.equalsIgnoreCase(s)){
						flag = true;
						break;
					}
				}
				if (flag){
					Object o = m.invoke(p);
					if(o == null || "".equals(o)){
						String s = StringUtil.toLowerCaseFirstOne(name.replace("get",""));
						s = FarmerCooperationDebt.field_remark.get(s);
						throw new Exception("【"+s+"】为空 或 格式不正确,获取数据的方法:"+name);
					}
				}
			}
		}
		if(!p.getYearmonth().contains("-") || p.getYearmonth().length() != 7){
			throw new Exception("【年月】格式不正确,只支持yyyy-MM格式[如:2015-05]");
		}
		return p;
	}

	@Override
	public ImportResult save(List<Map<String, String>> saveList) {
		List<Map<String, String>> errorList = new ArrayList<Map<String, String>>();
		FarmerCooperationDebt fc = null;
		Map<String,Object> hm = null;
		Long id = null;
		int i = 0;
		for(Map<String,String> map : saveList){
			try {
				fc = convert(map);
				hm = new HashMap<String,Object>();
				hm.put("organ_id", fc.getOrgan_id());
				hm.put("sourcecode", fc.getSourcecode());
				hm.put("yearmonth", fc.getYearmonth());
				id = cooperationDao.getUnitId(hm);
				if(id != null){
					fc.setDebtid(id);
					cooperationDao.update(fc);
				}else
					cooperationDao.save(fc);
			} catch (Exception e) {
				String s = e.getMessage();
				try {
					if(s.startsWith("###") || s.startsWith("\r\n###") || s.startsWith("\n###")){
						s = s.replaceAll("\r\n", "").replaceAll("\n", "");
						s = s.substring(0,s.indexOf("###",1));
						if(s.contains("DB2 SQL Error"))
							s = s.substring(s.indexOf("DB2 SQL Error"));
						s="【数据长度过长 或 格式不正确】"+s;
					}
				} catch (Exception e1) {}
				Map<String,String> map2 = new HashMap<String, String>();
//				System.err.println(e.getMessage());
				map.put(error_label, s);
				log.info("error_label"+s);
				for(Map.Entry<String, String> entry : map.entrySet())
					map2.put(FarmerCooperationDebt.remark_field.get(entry.getKey()), entry.getValue());
				map2.put("debtid", (i++)+"");
				errorList.add(map2);
			}
		}
		try {
			int successCount = saveList.size() - errorList.size();
			return new ImportResult("操作成功,共成功导入 " + successCount + " 条记录,如有失败记录,请查看错误描述", errorList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
