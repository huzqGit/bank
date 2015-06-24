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

import com.bank.beans.FarmerCooperation;
import com.bank.dao.ICooperationDao;
import com.bank.utils.PropConfig;
import com.bank.utils.excel.ImportResult;
import com.common.tools.DateUtils;
import com.common.tools.StringUtil;

@Component("cooperationImporter")
public class CooperationImporter extends ExcelImporter<FarmerCooperation> {
	
	private static Logger log = LoggerFactory.getLogger(CooperationImporter.class);
	
	private static String[] labels = {
		"合作社名称","组织机构代码","税务登记号","注册地址","通信地址","注册时间","注册资本","实收资本",
		"法定代表人","身份证号","联系电话","社员人数","经营范围","经营场地面积","带动农户(户)","连接基地"
	};
	private static String error_label = "错误描述";
	/**
	 * labels与bean实体的对应关系
	 */
	public static Map<String,String> labels_En = new HashMap<String, String>();
	public static Map<String,String> En_labels = new HashMap<String, String>();
	static{
		int oi = 0;
		labels_En.put(labels[oi++], "cooperationName");
		labels_En.put(labels[oi++], "orgaCode");
		labels_En.put(labels[oi++], "taxCode");
		labels_En.put(labels[oi++], "registerAddress");
		labels_En.put(labels[oi++], "mailAddress");
		labels_En.put(labels[oi++], "registerDate");
		labels_En.put(labels[oi++], "registerCapital");
		labels_En.put(labels[oi++], "realCapital");
		labels_En.put(labels[oi++], "legalPerson");
		labels_En.put(labels[oi++], "idNum");
		labels_En.put(labels[oi++], "phone");
		labels_En.put(labels[oi++], "members");
		labels_En.put(labels[oi++], "businesScope");
		labels_En.put(labels[oi++], "businessArea");
		labels_En.put(labels[oi++], "farmers");
		labels_En.put(labels[oi++], "connectionBase");
		labels_En.put(error_label, "error_label");
		for(Map.Entry<String, String> entry :labels_En.entrySet()){
			En_labels.put(entry.getValue(), entry.getKey());
		}
	}
	
	@Resource(name="cooperationDao")
	private ICooperationDao cooperationDao;
	
	private Map<String, Object> defaultValues;
	
	public CooperationImporter() {
		super(labels);
	}
	
	public CooperationImporter setMapValues(Map<String, Object> defaultValues){
		this.defaultValues = defaultValues;
		return this;
	}
	
	public CooperationImporter(Map<String, Object> defaultValues) {
		super(labels);
		this.defaultValues = defaultValues;
	}

	@Override
	protected FarmerCooperation convert(Map<String, String> map) throws Exception {
		String[] notNullField = PropConfig.getPropValue("CooperationImporter_NotNull_Field").split(";");
		FarmerCooperation p = new FarmerCooperation();
		try {
			p.setOrgan_id((String)defaultValues.get("organ_id"));
			p.setRecorder((String)defaultValues.get("recorder"));
		} catch (Exception e1) {
			throw new Exception("session失效,请重新登录");
		}
		p.setRecordTime(new Date());
		int labelIndex = 0;
		try {
			p.setCooperationName(map.get(getLabels()[labelIndex++]));
			p.setOrgaCode(map.get(getLabels()[labelIndex++]));
			p.setTaxCode(map.get(getLabels()[labelIndex++]));
			p.setRegisterAddress(map.get(getLabels()[labelIndex++]));
			p.setMailAddress(map.get(getLabels()[labelIndex++]));
			p.setRegisterDate(DateUtils.parseDateFullPattern(map.get(getLabels()[labelIndex++])));
			p.setRegisterCapital(map.get(getLabels()[labelIndex++]));
			p.setRealCapital(map.get(getLabels()[labelIndex++]));
			p.setLegalPerson(map.get(getLabels()[labelIndex++]));
			p.setIdNum(map.get(getLabels()[labelIndex++]));
			p.setPhone(map.get(getLabels()[labelIndex++]));
			p.setMembers(map.get(getLabels()[labelIndex++]));
			p.setBusinesScope(map.get(getLabels()[labelIndex++]));
			p.setBusinessArea(Integer.parseInt(map.get(getLabels()[labelIndex++])));
			p.setFarmers(Integer.parseInt(map.get(getLabels()[labelIndex++])));
			p.setConnectionBase(map.get(getLabels()[labelIndex++]));
		} catch (Exception e) {
			if (e.getMessage() != null && !"".equals(e.getMessage()) && !"null".equals(e.getMessage()))
				throw new Exception("【"+getLabels()[--labelIndex]+"】为空 或 格式不正确 "+e.getMessage());
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
				//判断数据是否不为空
				if (flag){
					Object o = m.invoke(p);
					if(o == null || "".equals(o)){
						String s = StringUtil.toLowerCaseFirstOne(name.replace("get",""));
						s = En_labels.get(s);
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
		FarmerCooperation fc = null;
		Map<String,Object> hm = null;
		Long id = null;
		int i = 0;
		for(Map<String,String> map : saveList){
			try {
				fc = convert(map);
				hm = new HashMap<String,Object>();
				hm.put("organ_id", fc.getOrgan_id());
				hm.put("orgaCode", fc.getOrgaCode());
				id = cooperationDao.getUnitId(hm);
				if(id != null){
					fc.setCooperationId(id);
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
				map.put(error_label, s);
				log.info("error_label"+s);
				for(Map.Entry<String, String> entry : map.entrySet())
					map2.put(labels_En.get(entry.getKey()), entry.getValue());
				map2.put("cooperationId", (i++)+"");
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
