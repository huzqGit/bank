package com.bank.controller.economy;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Cooperation;
import com.bank.beans.CooperationDebt;
import com.bank.beans.CooperationDebtExample;
import com.bank.beans.CooperationExample;
import com.bank.beans.FarmerCooperationDebt;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.CooperationBZEnum;
import com.bank.beans.enums.CooperationDebtBZEnum;
import com.bank.common.util.JsonUtil;
import com.bank.service.ICooperationDebtService;
import com.bank.service.ICooperationService;
import com.bank.service.ITMapService;
import com.bank.utils.HttpUtils;
import com.bank.utils.ParseDataUtils;
import com.bank.utils.excel.ExcelExplorer;
import com.bank.utils.excel.ImportResult;
import com.bank.utils.excel.importer.CooperationDebtImporter;
import com.common.exception.DAOException;

@Controller
@RequestMapping("economy/debt")
public class CooperationDebtController {
	
	private static Logger log = LoggerFactory.getLogger(CooperationDebtController.class);
	
	@Resource
	private ICooperationService cooperationService;
	
	@Resource
	private ICooperationDebtService cooperationDebtService;
	
	@Resource(name="cooperationDebtImporter")
	private CooperationDebtImporter cooperationDebtImporter;
	
	@Resource(name="tMapService")
	private ITMapService tMapService;
	
//	private List<Map<String, String>> list = new ArrayList<Map<String,String>>();
	public static Map<String,List<Map<String, String>>> uMap = new HashMap<String, List<Map<String,String>>>();
	
	@RequestMapping(value="saveCooperationDebt",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		String formData = request.getParameter("formData");
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		Organ organ = (Organ) request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONArray jsa = null;
		JSONObject[] jsons = new JSONObject[1];
		CooperationDebt coo = null;
		if(formData != null && formData.startsWith("[")){
			jsa = JSONArray.parseArray(formatdata);
			jsons = new JSONObject[jsa.size()];
			for(int i = 0;i<jsa.size();i++){
				jsons[i] = jsa.getJSONObject(i);
			}
		}else{
			jsons[0] = JSONObject.parseObject(formatdata);
		}
		for (JSONObject jsb : jsons){
			coo = (CooperationDebt) JSON.toJavaObject(jsb, CooperationDebt.class);
			try{
				if(coo.getId()==null){
					if(coo.getRecordtime() == null)
						coo.setRecordtime(new Date());
					tMapService.saveSDTMap(organ.getOrganId(),organ.getOrganName());
					coo.setSourcecode(user.getOrganId());
					cooperationDebtService.save(coo);
				}else{
					cooperationDebtService.update(coo);
				}
			}catch(Exception e){
				log.error(e.getMessage());
				throw e;
			}
			log.info("保存成功");
			String json = JSON.toJSONString(coo);
			response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
	}
	@RequestMapping(value = "/saveCooperationDebt1",method = RequestMethod.POST)
	public ModelAndView saveCooperationDebt1(@ModelAttribute(value="cooperation") CooperationDebt debt,
			HttpServletRequest request, HttpServletResponse response){
		try{
			if(debt.getId() == null){
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				debt.setRunitid(organ.getOrganId());
				debt.setRunitname(organ.getOrganName());
				debt.setSourcecode(organ.getOrganNo());
				debt.setSourcename(organ.getOrganName());
				cooperationDebtService.insert(debt);
			}else{
				CooperationDebtExample cde = new CooperationDebtExample();
				CooperationDebtExample.Criteria cdec = cde.createCriteria();
				cdec.andDebtidEqualTo(debt.getId());
				cooperationDebtService.updateByExample(debt,cde);
			}
			return this.queryCooperation(debt.getOrgancode(),debt.getSourcecode(), request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		ModelAndView  view = new ModelAndView("/cooperation/cooperationDebtView");
		view.addObject("cooperationdebt", debt);
		return view;
	}
	
	@RequestMapping(value="findCooperationDebt",method = RequestMethod.POST)
	public FarmerCooperationDebt findByPK(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String pk = HttpUtils.getParameter(request,"debtid");
		if(pk != null){
			CooperationDebt entity = cooperationDebtService.findByPK(Long.parseLong(pk));
			String json = JSON.toJSONStringWithDateFormat(entity,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		    response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
	}
	@RequestMapping(value="loadAllFarmerCooperationDebt",method = RequestMethod.POST)
	public void loadAllFarmerCooperation(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		//查询条件
	    String queryStr = HttpUtils.getParameter(request,"queryStr");
	    JSONObject jsonobj = JSON.parseObject(queryStr);
	    Map<String,String> map = new HashMap<String,String>();
	    if(jsonobj != null)
		    for(String s : jsonobj.keySet()){
		    	map.put(s, jsonobj.getString(s));
		    }
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    
	    List<CooperationDebt> data = cooperationDebtService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder,map);
	    long size = cooperationDebtService.getTotal(map);
	    
	    HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("data", data);
        result.put("total", size);
        String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
//	    String json = JSON.toJSONString(result);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	}
	
	@RequestMapping(value="deleteByKey")
	public void deleteByKey(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = HttpUtils.getParameter(request, "id");
		response.setContentType("text/html;charset=UTF-8");
		try {
			cooperationDebtService.delete(Long.parseLong(id));
			response.getWriter().write("{\"success\":\"删除成功\"}");
		} catch (Exception e) {
			response.getWriter().write("{\"success\":\"删除失败\"}");
		}
		return;
	}
	
	@RequestMapping("loadFile")
	public ModelAndView loadFile(@RequestParam("mufile") MultipartFile muFile,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView model = new ModelAndView("cooperation/cooperationDebtImportFile");
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String sourcecode = HttpUtils.getParameter(request, "t");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		try{
			map.put("sourcecode", sourcecode);
			map.put("organ_id", user.getOrganId());
			map.put("recorder", user.getUserName());
			
			InputStream in = muFile.getInputStream();
			ImportResult result = ExcelExplorer.importExcel(cooperationDebtImporter.setMapValues(map), in);
			List<Map<String, String>> list2 = result.getResult();
			if (list2 != null) {
				String array = JSONArray.toJSONString(list2);
				Map<String,String> msg = new HashMap<String,String>();
				if("[]".equals(array)){
					msg.put("row", "1");
					msg.put("tip", "info");
					msg.put("msg", "操作完成...,无数据需要导入");
					list.add(msg);
					model.addObject("msgs",list);
					return model;
				}
				msg.put("row", "1");
				msg.put("tip", "info");
				msg.put("msg", result.getMessage());
				list.add(msg);
				model.addObject("msgs",list);
				model.addObject("importError","importError");
//				this.list = list2;
				uMap.put(user.getOrganId()+"$"+user.getUserId(), list2);
				return model;
			} else {
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("row", "1");
				msg.put("tip", "info");
				msg.put("msg", "无数据");
				list.add(msg);
				model.addObject("msgs",list);
				return model;
			}
		}catch(Exception e){
			Map<String,String> msg = new HashMap<String,String>();
			msg.put("row", String.valueOf(1));
			msg.put("tip", "error");
			msg.put("msg", "不支持的");
			list.add(msg);
			model.addObject("msgs",list);
			return model;
		}
	}
	
	@RequestMapping(value="loadFileResult",method = RequestMethod.POST)
	public void loadFileResult(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		HashMap<String,Object> result = new HashMap<String,Object>();
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));   
	    List<Map<String,String>> pageList = new ArrayList<Map<String,String>>();
	    int l = 0;
	    List<Map<String, String>> list = uMap.get(user.getOrganId()+"$"+user.getUserId());
	    try {
			for(Map<String,String> map : list){
				l = Integer.parseInt(map.get("debtid"));
				if(l>= (pageIndex * pageSize) && l < (pageIndex * pageSize + pageSize))
					pageList.add(map);
			}
		} catch (Exception e) {
		}
	    
        result.put("data", pageList);
        result.put("total", list.size());
        String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/loadCooperationDebt",method=RequestMethod.POST)
	public ModelAndView loadCooperationDebt(@RequestParam(value="businesslicence") String businesslicence,
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
			
			Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
			
			CooperationDebtExample cde = new CooperationDebtExample();
			CooperationDebtExample.Criteria cdec = cde.createCriteria();
			cdec.andRunitidEqualTo(organ.getOrganId());
			cdec.andBusinesslicenceEqualTo(businesslicence);
			int totalNumber = cooperationDebtService.countByExample(cde);
			
			Map paramMap = new HashMap();
			paramMap.put("runitid", organ.getOrganId());
			paramMap.put("businesslicence", businesslicence);
			List<CooperationDebt> debts = null;
			try {
				debts = cooperationDebtService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Map map = new HashMap();
			map.put("total", totalNumber);
			map.put("data", debts);
		    String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		    response.setContentType("text/html;charset=UTF-8");
		    try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return null;
	}
	@RequestMapping(value="/queryCooperation",method=RequestMethod.GET)
	public ModelAndView queryCooperation(@RequestParam(value="businesslicence") String businesslicence, 
			@RequestParam(value="sourcecode") String sourcecode, 
			HttpServletRequest request,HttpServletResponse response){

		CooperationExample ce = new CooperationExample();
		CooperationExample.Criteria cec = ce.createCriteria();
		cec.andBusinesslicenceEqualTo(businesslicence);
		cec.andSourcecodeEqualTo(sourcecode);
		List<Cooperation> cooperations = cooperationService.selectByExample(ce);
		Cooperation cooperation = null;
		if(cooperations!=null && cooperations.size()>0){
			cooperation = cooperations.get(0);
			ModelAndView view = new ModelAndView("/cooperation/cooperationDebtView");
			view.addObject("cooperation",cooperation);
			return view;
		}else{
			return null;
		}
		
	}
	@RequestMapping(value="/insertCooperationDebt",method=RequestMethod.GET)
	public ModelAndView insertCooperationDebt(@RequestParam(value="cid") Long cid, 
			HttpServletRequest request,HttpServletResponse response){
		
		CooperationExample cde = new CooperationExample();
		CooperationExample.Criteria  cdec = cde.createCriteria();
		cdec.andCooperationidEqualTo(cid);
		List<Cooperation> cooperations = cooperationService.selectByExample(cde);
		Cooperation cooperation = cooperations.get(0);
		
		ModelAndView view = new ModelAndView("/cooperation/cooperationDebtForm");
		view.addObject("cooperation",cooperation);
		return view;
	}
	@RequestMapping(value="/editCooperationDebt",method=RequestMethod.GET)
	public ModelAndView editCooperationDebt(@RequestParam(value="id") Long id, 
			@RequestParam(value="cid") Long cid, 
			HttpServletRequest request,HttpServletResponse response){

		CooperationExample ce = new CooperationExample();
		CooperationExample.Criteria cec = ce.createCriteria();
		cec.andCooperationidEqualTo(cid);
		List<Cooperation> cooperations = cooperationService.selectByExample(ce);
		Cooperation cooperation = null;
		if(cooperations!=null && cooperations.size()>0){
			cooperation = cooperations.get(0);
		}
		CooperationDebtExample cde = new CooperationDebtExample();
		CooperationDebtExample.Criteria cdec = cde.createCriteria();
		cdec.andDebtidEqualTo(id);
		CooperationDebt cooperationdebt = null;
		List<CooperationDebt> cooperationdebts = cooperationDebtService.selectByExample(cde);
		if(cooperationdebts!=null && cooperationdebts.size()>0){
			cooperationdebt = cooperationdebts.get(0);
		}
		ModelAndView view = new ModelAndView("/cooperation/cooperationDebtForm");
		view.addObject("cooperation",cooperation);
		view.addObject("cooperationdebt",cooperationdebt);
		return view;
	}
	@RequestMapping(value="/deleteCooperationDebt",method=RequestMethod.GET)
	public ModelAndView deleteCooperationDebt(@RequestParam(value="id") Long id,
			@RequestParam(value="organcode") String organcode, 
			@RequestParam(value="sourcecode") String sourcecode, 
			HttpServletRequest request,HttpServletResponse response){
		
		CooperationDebtExample cde = new CooperationDebtExample();
		CooperationDebtExample.Criteria cdec = cde.createCriteria();
		cdec.andDebtidEqualTo(id);
		cooperationDebtService.deleteByExample(cde);
		
		return this.queryCooperation(organcode, sourcecode, request, response);
	}
	@RequestMapping(value="/importCooperationDebt",method=RequestMethod.POST)
	public ModelAndView importCooperationDebt(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
			HttpServletRequest request,HttpServletResponse response){
		String[][] data = null;
		Organ organ = (Organ)request.getSession().getAttribute("unit");
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String recorder = user.getUserId();
		Date recordTime = new Date();
		List<Map<String,String>> msgs =  null;
		try{
			 InputStream in = myfile.getInputStream();
			 if( myfile.getOriginalFilename().endsWith(".xls")){
				 data = ParseDataUtils.readXls(in, 0);
			 }else{
				 data = ParseDataUtils.readXlsx(in, 0);
			 }
		}catch(IOException e){
			Map<String,String> msg = new HashMap<String,String>();
			msg.put("row", String.valueOf(1));
			msg.put("tip", "error");
			msg.put("msg", "不支持的");
		}
		if("TYCJ".equals(sourcecode)){
			msgs = importCooperationDebtBZ(organId,organName,recorder,recordTime,data);
		}
		ModelAndView mav = new ModelAndView("/cooperation/cooperationDebtImporter");
		mav.addObject("msgs", msgs);
		return mav;
	}
	private List<Map<String,String>> importCooperationDebtBZ(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row =1;row<data.length;row++){
			CooperationDebt debt = new CooperationDebt();
			debt.setSourcecode("TYCJ");
			debt.setSourcename("统一采集小组");
			debt.setRunitid(organId);
			debt.setRunitname(organName);
			debt.setRecorder(recorder);
			debt.setRecordtime(recordTime);
			String yearMonth = data[row][CooperationDebtBZEnum.YEARMONTH.getIndex()];
			debt.setYearmonth(yearMonth);
			if(StringUtils.isEmpty(yearMonth)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "第<font color='red'>"+row+"</font>行,年月不能为空！");
				msgs.add(msg);
				continue;
			}
			String cooperationName  = data[row][CooperationDebtBZEnum.COOPERATIONNAME.getIndex()];
			debt.setCooperationname(cooperationName);
			if(StringUtils.isEmpty(cooperationName)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "第<font color='red'>"+row+"</font>行,经济合作组织名称不能为空！");
				msgs.add(msg);
				continue;
			}
			String organCode = data[row][CooperationBZEnum.ORGANCODE.getIndex()];
			debt.setOrgancode(organCode);
			String businessLicence = data[row][CooperationDebtBZEnum.BUSINESSLICENCE.getIndex()];
			debt.setBusinesslicence(businessLicence);
			if(StringUtils.isEmpty(businessLicence)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "第<font color='red'>"+row+"</font>行,营业执照不能为空！");
				msgs.add(msg);
				continue;
			}
			debt.setCashcapital(data[row][CooperationDebtBZEnum.CASHCAPITAL.getIndex()]);
			debt.setShortinvest(data[row][CooperationDebtBZEnum.SHORTINVEST.getIndex()]);
			debt.setReceivables(data[row][CooperationDebtBZEnum.REALCAPITAL.getIndex()]);
			debt.setPrepayment(data[row][CooperationDebtBZEnum.PREPAYMENT.getIndex()]);
			debt.setInventory(data[row][CooperationDebtBZEnum.INVENTORY.getIndex()]);
			debt.setFloatasset(data[row][CooperationDebtBZEnum.FLOATASSET.getIndex()]);
			debt.setFloatassetall(data[row][CooperationDebtBZEnum.FLOATASSETALL.getIndex()]);
			debt.setFixedasset(data[row][CooperationDebtBZEnum.FIXEDASSET.getIndex()]);
			debt.setDeprecication(data[row][CooperationDebtBZEnum.DEPRECICATION.getIndex()]);
			debt.setNetvalue(data[row][CooperationDebtBZEnum.NETVALUE.getIndex()]);
			debt.setBuildingproject(data[row][CooperationDebtBZEnum.BUILDINGPROJECT.getIndex()]);
			debt.setFixedassetall(data[row][CooperationDebtBZEnum.FIXEDASSETALL.getIndex()]);
			debt.setAssetall(data[row][CooperationDebtBZEnum.ASSETALL.getIndex()]);
			debt.setShortloan(data[row][CooperationDebtBZEnum.SHORTLOAN.getIndex()]);
			debt.setBankloan(data[row][CooperationDebtBZEnum.BANKLOAN.getIndex()]);
			debt.setAccountspayable(data[row][CooperationDebtBZEnum.ACCOUNTSPAYABLE.getIndex()]);
			debt.setDepositreceived(data[row][CooperationDebtBZEnum.DEPOSITRECEIVED.getIndex()]);
			debt.setUnpaidtax(data[row][CooperationDebtBZEnum.UNPAIDTAX.getIndex()]);
			debt.setFloatdebt(data[row][CooperationDebtBZEnum.FLOATDEBT.getIndex()]);
			debt.setFloatdebtall(data[row][CooperationDebtBZEnum.FLOATDEBTALL.getIndex()]);
			debt.setLongdebtall(data[row][CooperationDebtBZEnum.LONGDEBTALL.getIndex()]);
			debt.setRegistercapital(data[row][CooperationDebtBZEnum.REALCAPITAL.getIndex()]);
			debt.setRealcapital(data[row][CooperationDebtBZEnum.REALCAPITAL.getIndex()]);
			debt.setCapitalreserve(data[row][CooperationDebtBZEnum.CAPITALRESERVE.getIndex()]);
			debt.setSurplusreserve(data[row][CooperationDebtBZEnum.SURPLUSRESERVE.getIndex()]);
			debt.setUnallotprofit(data[row][CooperationDebtBZEnum.UNALLOTPROFIT.getIndex()]);
			debt.setTotalequity(data[row][CooperationDebtBZEnum.TOTALEQUITY.getIndex()]);
			debt.setTotalequity1(data[row][CooperationDebtBZEnum.TOTALEQUITY1.getIndex()]);
			debt.setHandingcost(data[row][CooperationDebtBZEnum.HANDINGCOST.getIndex()]);
			debt.setFinancialcost(data[row][CooperationDebtBZEnum.FINANCIALCOST.getIndex()]);
			debt.setInterestexpense(data[row][CooperationDebtBZEnum.INTERESTEXPENSE.getIndex()]);
			debt.setBusinessprofit(data[row][CooperationDebtBZEnum.BUSINESSPROFIT.getIndex()]);
			debt.setInvestincome(data[row][CooperationDebtBZEnum.INVESTINCOME.getIndex()]);
			debt.setSubsidyincome(data[row][CooperationDebtBZEnum.SUBSIDYINCOME.getIndex()]);
			debt.setUnbusinessincome(data[row][CooperationDebtBZEnum.UNBUSINESSINCOME.getIndex()]);
			debt.setUnbusinessexpense(data[row][CooperationDebtBZEnum.BUSINESSLICENCE.getIndex()]);
			debt.setProfitloss(data[row][CooperationDebtBZEnum.PROFITLOSS.getIndex()]);
			debt.setTotalprofit(data[row][CooperationDebtBZEnum.TOTALPROFIT.getIndex()]);
			CooperationDebtExample cde = new CooperationDebtExample();
			CooperationDebtExample.Criteria cdec= cde.createCriteria();
			cdec.andBusinesslicenceEqualTo(businessLicence);
			cdec.andSourcecodeEqualTo("TYCJ");
			List<CooperationDebt> debts = cooperationDebtService.selectByExample(cde);
			if(debts.size() ==0){
				cooperationDebtService.insert(debt);
			}else if(debts.size() ==1){
				debt.setId(debts.get(0).getId());
				CooperationDebtExample cde1 = new CooperationDebtExample();
				CooperationDebtExample.Criteria cdec1 = cde1.createCriteria();
				cdec1.andDebtidEqualTo(debt.getId());
				cooperationDebtService.updateByExampleSelective(debt, cde1);
			}
		}
		return msgs;
	}
}
