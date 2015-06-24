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

import com.bank.beans.CooperationProfit;
import com.bank.dao.ICooperationProfitDao;
import com.bank.utils.PropConfig;
import com.bank.utils.excel.ImportResult;
import com.common.tools.StringUtil;

@Component("profitImporter")
public class ProfitImporter extends ExcelImporter<CooperationProfit> {
	
	private static Logger log = LoggerFactory.getLogger(ProfitImporter.class);
	
	private static String[] labels = {
		"组织机构代码","年月","数据报送机构","税务识别码","机构信用代码","主营业务收入","主营业务收入出口产品销售收入","主营业务收入进口产品销售收入","折扣与拆让","主营业务收入净额","主营业务成本","主营业务成本出口产品销售成本",
		"主营业务税金及附加","经营费用","其他","递延收益","代购代销收入","其他","主营业务利润","其他业务利润","营业费用","管理费用","财务费用","其他","营业利润","投资收益","期货收益","补贴收入",
		"补贴收入补贴前亏损的企业补贴收入","营业外收入","营业外收入处置固定资产净收益","营业外收入非货币性交易收益","营业外收入出售无形资产收益","营业外收入罚款净收入","其他","其他用以前年度含量工资节余弥补利润","营业外支出",
		"营业外支出处置固定资产净损失","营业外支出债务重组损失","营业外支出罚款支出","营业外支出捐赠支出","其他支出","其他支出结转的含量工资包干节余","利润总额","所得税","少数股东损益","未确认的投资损失","净利润","年初未分配利润",
		"盈余公积补亏","其他调整因素","可供分配的利润","单项留用的利润","补充流动资本","提取法定盈余公积","提取法定公益金","提取职工奖励及福利基金","提取储备基金","提取企业发展基金","利润归还投资","其他","可供投资者分配的利润",
		"应付优先股股利","提取任意盈余公积","应付普通股股利","转作资本的普通股股利","其他","未分配利润","未分配利润应由以后年度税前利润弥补的亏损"
	};
	
	private static String error_label = "错误描述";
	
	
	@Resource(name="cooperationProfitDao")
	private ICooperationProfitDao cooperationDao;
	
	private Map<String, Object> defaultValues;
	
	public ProfitImporter() {
		super(labels);
	}
	
	public ProfitImporter setMapValues(Map<String, Object> defaultValues){
		this.defaultValues = defaultValues;
		return this;
	}
	
	public ProfitImporter(Map<String, Object> defaultValues) {
		super(labels);
		this.defaultValues = defaultValues;
	}

	@Override
	protected CooperationProfit convert(Map<String, String> map) throws Exception {
		
		String[] notNullField = PropConfig.getPropValue("CooperationProfitImporter_NotNull_Field").split(";");
		CooperationProfit p = new CooperationProfit();
		try {
			p.setOrgan_id((String)defaultValues.get("organ_id"));
			p.setRecoder((String)defaultValues.get("recorder"));
		} catch (Exception e1) {
			throw new Exception("session失效,请重新登录");
		}
		p.setRecodertime(new Date());
		int labelIndex = 0;
		try {
			/*采取该语句生成下列代码//注意大小写
			 select t.remarks,'p.set'||initcap(lower(name))||'(map.get(getLabels()[labelIndex++]));'
			from sysibm.syscolumns t where TBNAME='T_COOPERATION_PROFIT'
			and lower(t.NAME) not in('profitid','organ_id','recodertime','recoder')
			order by COLNO;
			 */
			p.setOrgancode(map.get(getLabels()[labelIndex++]));
			p.setYearmonth(map.get(getLabels()[labelIndex++]));
			p.setDatasendorgan(map.get(getLabels()[labelIndex++]));
			p.setTaxcode(map.get(getLabels()[labelIndex++]));
			p.setOrgantrustcode(map.get(getLabels()[labelIndex++]));
			p.setMainincome(map.get(getLabels()[labelIndex++]));
			p.setMainincome_export(map.get(getLabels()[labelIndex++]));
			p.setMainincome_import(map.get(getLabels()[labelIndex++]));
			p.setDiscount(map.get(getLabels()[labelIndex++]));
			p.setMainincome_netmargin(map.get(getLabels()[labelIndex++]));
			p.setMaincost(map.get(getLabels()[labelIndex++]));
			p.setMaincost_export(map.get(getLabels()[labelIndex++]));
			p.setMaintaxpay(map.get(getLabels()[labelIndex++]));
			p.setOperationcost(map.get(getLabels()[labelIndex++]));
			p.setOthercost(map.get(getLabels()[labelIndex++]));
			p.setDelayincome(map.get(getLabels()[labelIndex++]));
			p.setPurchasingagent(map.get(getLabels()[labelIndex++]));
			p.setOtherpurchasingagent(map.get(getLabels()[labelIndex++]));
			p.setMainnetmargin(map.get(getLabels()[labelIndex++]));
			p.setOthernetmargin(map.get(getLabels()[labelIndex++]));
			p.setMainexpenses(map.get(getLabels()[labelIndex++]));
			p.setManageexpense(map.get(getLabels()[labelIndex++]));
			p.setFinaceexpense(map.get(getLabels()[labelIndex++]));
			p.setOtherexpense(map.get(getLabels()[labelIndex++]));
			p.setIncome_netmargin(map.get(getLabels()[labelIndex++]));
			p.setInvestincome(map.get(getLabels()[labelIndex++]));
			p.setFuturesincome(map.get(getLabels()[labelIndex++]));
			p.setSubsidyincome(map.get(getLabels()[labelIndex++]));
			p.setSubsidyincome_before(map.get(getLabels()[labelIndex++]));
			p.setIncome_o(map.get(getLabels()[labelIndex++]));
			p.setIncome_o_netmargin(map.get(getLabels()[labelIndex++]));
			p.setIncome_o_nonemoney(map.get(getLabels()[labelIndex++]));
			p.setIncome_o_wxzc(map.get(getLabels()[labelIndex++]));
			p.setIncome_o_fk(map.get(getLabels()[labelIndex++]));
			p.setIncome_o_other(map.get(getLabels()[labelIndex++]));
			p.setIncome_o_othersalary(map.get(getLabels()[labelIndex++]));
			p.setOutcome_o(map.get(getLabels()[labelIndex++]));
			p.setOutcome_o_netmargin(map.get(getLabels()[labelIndex++]));
			p.setOutcome_o_zwcz(map.get(getLabels()[labelIndex++]));
			p.setOutcome_o_fk(map.get(getLabels()[labelIndex++]));
			p.setOutcome_o_jz(map.get(getLabels()[labelIndex++]));
			p.setOutcome_o_other(map.get(getLabels()[labelIndex++]));
			p.setOutcome_o_othersalary(map.get(getLabels()[labelIndex++]));
			p.setAllprofit(map.get(getLabels()[labelIndex++]));
			p.setIncomdetax(map.get(getLabels()[labelIndex++]));
			p.setFewpartnerincome(map.get(getLabels()[labelIndex++]));
			p.setUnsureloss(map.get(getLabels()[labelIndex++]));
			p.setNetmargin(map.get(getLabels()[labelIndex++]));
			p.setBeginofyearundistributed(map.get(getLabels()[labelIndex++]));
			p.setYygjbk(map.get(getLabels()[labelIndex++]));
			p.setQttzys(map.get(getLabels()[labelIndex++]));
			p.setKgfpll(map.get(getLabels()[labelIndex++]));
			p.setDxlyll(map.get(getLabels()[labelIndex++]));
			p.setBcldzb(map.get(getLabels()[labelIndex++]));
			p.setTqfdyygj(map.get(getLabels()[labelIndex++]));
			p.setTqfdyygyj(map.get(getLabels()[labelIndex++]));
			p.setTqzgjljfldy(map.get(getLabels()[labelIndex++]));
			p.setTqcbj(map.get(getLabels()[labelIndex++]));
			p.setTqqyfzjj(map.get(getLabels()[labelIndex++]));
			p.setLlghtz(map.get(getLabels()[labelIndex++]));
			p.setLlghtzother(map.get(getLabels()[labelIndex++]));
			p.setKgtzzffll(map.get(getLabels()[labelIndex++]));
			p.setYfyxggl(map.get(getLabels()[labelIndex++]));
			p.setTqryyygj(map.get(getLabels()[labelIndex++]));
			p.setYfptggl(map.get(getLabels()[labelIndex++]));
			p.setZzzbptggl(map.get(getLabels()[labelIndex++]));
			p.setZzzbptgglother(map.get(getLabels()[labelIndex++]));
			p.setZzzbptgglundisbute(map.get(getLabels()[labelIndex++]));
			p.setZzzbptgglundisbute_before(map.get(getLabels()[labelIndex++]));
			
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
						s = CooperationProfit.field_remark.get(s);
						throw new Exception("【"+s+"】为空 或 格式不正确,获取数据的方法:"+name);
					}
				}
			}
		}
		return p;
	}

	@Override
	public ImportResult save(List<Map<String, String>> saveList) {
		List<Map<String, String>> errorList = new ArrayList<Map<String, String>>();
		CooperationProfit fc = null;
		Map<String,Object> hm = null;
		Long id = null;
		int i = 0;
		for(Map<String,String> map : saveList){
			try {
				fc = convert(map);
				hm = new HashMap<String,Object>();
				hm.put("organ_id", fc.getOrgan_id());
				hm.put("organcode", fc.getOrgancode());
				id = cooperationDao.getUnitId(hm);
				if(id != null){
					fc.setProfitid(id);
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
				for(Map.Entry<String, String> entry : map.entrySet()){
					map2.put(CooperationProfit.remark_field.get(entry.getKey()), entry.getValue());
//					if(CooperationProfit.remark_field.get(entry.getKey())==null)
//						System.out.println(entry.getKey());
				}
					
				map2.put("profitid", (i++)+"");
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
