package com.bank.controller.economy;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.bank.beans.CooperationExample;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerCooperation;
import com.bank.beans.FarmerEvaluate;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.CooperationBZEnum;
import com.bank.beans.enums.CooperationNSEnum;
import com.bank.common.util.JsonUtil;
import com.bank.service.ICooperationService;
import com.bank.service.ITMapService;
import com.bank.utils.HttpUtils;
import com.bank.utils.ParseDataUtils;
import com.bank.utils.excel.ExcelExplorer;
import com.bank.utils.excel.ImportResult;
import com.bank.utils.excel.importer.CooperationImporter;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping("economy")
public class CooperationController {
	
	private static Logger log = LoggerFactory.getLogger(CooperationController.class);
	
	@Resource
	private ICooperationService cooperationService;
	
	@Resource(name="cooperationImporter")
	private CooperationImporter cooperationImporter;
	
	@Resource(name="tMapService")
	private ITMapService tMapService;
	
	public static Map<String,List<Map<String, String>>> uMap = new HashMap<String, List<Map<String,String>>>();
			
	@RequestMapping(value="saveCooperation",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		String formData = request.getParameter("formData");
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		Organ organ = (Organ) request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		Cooperation coo = (Cooperation) JSON.toJavaObject(jsb, Cooperation.class);
		try{
			if(coo.getRecordtime() == null)
				coo.setRecordtime(new Date());
			if(coo.getId()==null){
				tMapService.saveSDTMap(organ.getOrganId(),organ.getOrganName());
				coo.setSourcecode(user.getOrganId());
				cooperationService.save(coo);
			}else{
				cooperationService.update(coo);
			}
		}catch(Exception e){
			log.error(e.getMessage());
			throw e;
		}
		log.info("保存成功");
		String json = JSON.toJSONString(coo);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
	@RequestMapping(value = "/saveCooperation1",method = RequestMethod.POST)
	public ModelAndView saveCooperation(@ModelAttribute(value="cooperation") Cooperation cooperation,
			HttpServletRequest request, HttpServletResponse response){
		try{
			if(cooperation.getId() == null){
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				cooperation.setRunitid(organ.getOrganId());
				cooperation.setRunitname(organ.getOrganName());
				cooperation.setSourcecode(organ.getOrganNo());
				cooperation.setSourcename(organ.getOrganName());
				cooperationService.insert(cooperation);
			}else{
				CooperationExample ce = new CooperationExample();
				CooperationExample.Criteria cec = ce.createCriteria();
				cec.andCooperationidEqualTo(cooperation.getId());
				cooperationService.updateByExample(cooperation,ce);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		ModelAndView  view = new ModelAndView("/cooperation/cooperationView");
		return view;
	}
	
	@RequestMapping(value="/editCooperation",method=RequestMethod.GET)
	public ModelAndView loadCooperation(@RequestParam(value="id") Long id,
			HttpServletRequest request,HttpServletResponse response){
		
		CooperationExample ce = new CooperationExample();
		CooperationExample.Criteria cec = ce.createCriteria();
		cec.andCooperationidEqualTo(id);
		List<Cooperation> cooperations = cooperationService.selectByExample(ce);
		Cooperation cooperation = null;
		if(cooperations!=null && cooperations.size()>0){
			 cooperation = cooperations.get(0);
		}
		
		ModelAndView view = new ModelAndView("/cooperation/cooperationForm");
		view.addObject("cooperation",cooperation);
		return view;
	}
	
	@RequestMapping(value="/deleteCooperation",method=RequestMethod.GET)
	public ModelAndView deleteCooperation(@RequestParam(value="id") Long id,
			HttpServletRequest request,HttpServletResponse response){
		
		CooperationExample ce = new CooperationExample();
		CooperationExample.Criteria cec = ce.createCriteria();
		cec.andCooperationidEqualTo(id);
		cooperationService.deleteByExample(ce);
		ModelAndView view = new ModelAndView("/cooperation/cooperationView");
		return view;
	}
	@RequestMapping(value="findCooperation",method = RequestMethod.POST)
	public FarmerCooperation findByPK(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String pk = HttpUtils.getParameter(request,"cooperationId");
		if(pk != null){
			Cooperation entity = cooperationService.findByPK(Long.parseLong(pk));
			String json = JSON.toJSONStringWithDateFormat(entity,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		    response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
	}
	@RequestMapping(value="loadAllFarmerCooperation",method = RequestMethod.POST)
	public void loadAllFarmerCooperation(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		//查询条件
	    String cooperationName = HttpUtils.getParameter(request,"cooperationName");
	    String orgaCode = HttpUtils.getParameter(request,"orgaCode");
	    String recorder = HttpUtils.getParameter(request,"recorder");
	    String recordTimeBegin = HttpUtils.getParameter(request,"recordTimeBegin");
	    String recordTimeEnd = HttpUtils.getParameter(request,"recordTimeEnd");

	    Map<String,String> map = new HashMap<String,String>();
	    map.put("cooperationName", cooperationName);
	    map.put("orgaCode", orgaCode);
	    map.put("recorder", recorder);
	    map.put("recordTimeBegin", recordTimeBegin);
	    map.put("recordTimeEnd", recordTimeEnd);
	    
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    
	    List<Cooperation> data = cooperationService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder,map);
	    long size = cooperationService.getTotal(map);
	    
	    HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("data", data);
        result.put("total", size);
        String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
//	    String json = JSON.toJSONString(result);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	}
	
	@RequestMapping(value="getCooperationTree",method = RequestMethod.POST)
	public void getCooperationTree(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		//查询条件
	    String cooperationName = HttpUtils.getParameter(request,"cooperationName");
	    Map<String,Object> map = new HashMap<String,Object>();
	    map.put("cooperationName", cooperationName);
	    
	    List<Map<String,Object>> data = cooperationService.getCooperationTree(map);
//	    HashMap<String,Object> result = new HashMap<String,Object>();
//      result.put("data", data);
	    String json = JSON.toJSONString(data);
//	    System.out.println(json);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	}
	
	@RequestMapping(value="deleteByKey")
	public void deleteByKey(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = HttpUtils.getParameter(request, "id");
		response.setContentType("text/html;charset=UTF-8");
		try {
			cooperationService.delete(Long.parseLong(id));
			response.getWriter().write("{\"success\":\"删除成功\"}");
		} catch (Exception e) {
			response.getWriter().write("{\"success\":\"删除失败\"}");
		}
		return;
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
				l = Integer.parseInt(map.get("cooperationId"));
				if(l>= (pageIndex * pageSize) && l < (pageIndex * pageSize + pageSize))
					pageList.add(map);
			}
		} catch (Exception e) {
		}
	    
        result.put("data", pageList);
        result.put("total", list==null?0:list.size());
        String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	}
	
	@RequestMapping("loadFile")
	public ModelAndView loadFile(@RequestParam("mufile") MultipartFile muFile,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView model = new ModelAndView("cooperation/cooperationImportFile");
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String sourcecode = HttpUtils.getParameter(request, "t");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		try{
			map.put("sourcecode", sourcecode);
			map.put("organ_id", user.getOrganId());
			map.put("recorder", user.getUserName());
			
			InputStream in = muFile.getInputStream();
			ImportResult result = ExcelExplorer.importExcel(cooperationImporter.setMapValues(map), in);
			List<Map<String, String>> list2 = result.getResult();
			if (list2 != null) {
				String array = JSONArray.toJSONString(list2);
				Map<String,String> msg = new HashMap<String,String>();
				if("[]".equals(array)){
					msg.put("row", "1");
					msg.put("tip", "info");
					msg.put("msg", "操作完成...");
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
				//this.list = list2;
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/loadCooperation",method=RequestMethod.POST)
	public ModelAndView loadCooperation(@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
			
			Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
			
			CooperationExample ce = new CooperationExample();
			CooperationExample.Criteria cec = ce.createCriteria();
			cec.andRunitidEqualTo(organ.getOrganId());
			int totalNumber = cooperationService.countByExample(ce);
			
			Map paramMap = new HashMap();
			paramMap.put("runitid", organ.getOrganId());
			List<Cooperation> cooperations = null;
			try {
				cooperations = cooperationService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Map map = new HashMap();
			map.put("total", totalNumber);
			map.put("data", cooperations);
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
	@RequestMapping(value="/typeInCooperation",method=RequestMethod.POST)
	public ModelAndView typeInCooperation(@RequestParam(value="cooperationname") String cooperationname,
			@RequestParam(value="businesslicence") String businesslicence, 
			HttpServletRequest request,HttpServletResponse response){
		
		if(StringUtils.isEmpty(cooperationname) || StringUtils.isEmpty(businesslicence)){
			ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
			view.addObject("cooperationname",cooperationname);
			view.addObject("businesslicence", businesslicence);
			return  view;
		}
		Organ organ =(Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		CooperationExample ce = new CooperationExample();
		CooperationExample.Criteria cec = ce.createCriteria();
		cec.andBusinesslicenceEqualTo(businesslicence);
		cec.andSourcecodeEqualTo(organ.getOrganNo());
	    List<Cooperation> cooperations= cooperationService.selectByExample(ce);
	    if(cooperations == null || cooperations.size()==0){
	    	Cooperation cooperation = new Cooperation();
	    	cooperation.setBusinesslicence(businesslicence);
	    	cooperation.setCooperationname(cooperationname);
	    	cooperation.setSourcecode(organ.getOrganNo());
	    	cooperation.setSourcename(organ.getOrganName());
	    	cooperation.setRunitid(organ.getOrganId());
	    	cooperation.setRunitname(organ.getOrganName());
	    	ModelAndView view = new ModelAndView("/cooperation/cooperationForm");
			view.addObject("cooperation",cooperation);
			return view;
	    	
	    }else{
	    	ModelAndView view = new ModelAndView("/cooperation/cooperationView");
			return  view;
	    }
	}
	@RequestMapping(value="/importCooperation",method=RequestMethod.POST)
	public ModelAndView importCooperation(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
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
			msgs = importCooperationBZ(organId,organName,recorder,recordTime,data);
		}else if("C3140436000017".equals(sourcecode)){
			msgs = importCooperationNS(organId,organName,recorder,recordTime,data);
		}
		ModelAndView mav = new ModelAndView("/cooperation/cooperationImporter");
		mav.addObject("msgs", msgs);
		return mav;
	
	}
	private List<Map<String,String>> importCooperationBZ(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row =1;row<data.length;row++){
			Cooperation cooperation = new Cooperation();
			cooperation.setSourcecode("TYCJ");
			cooperation.setSourcename("统一采集小组");
			cooperation.setRunitid(organId);
			cooperation.setRunitname(organName);
			cooperation.setRecorder(recorder);
			cooperation.setRecordtime(recordTime);
			String cooperationName = data[row][CooperationBZEnum.COOPERATIONNAME.getIndex()];
			cooperation.setCooperationname(cooperationName);
			if(StringUtils.isEmpty(cooperationName)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "经济合作组织名称不能为空。");
				msgs.add(msg);
				continue;
			}
			String businessLicence = data[row][CooperationBZEnum.BUSINESSLICENCE.getIndex()];
			cooperation.setBusinesslicence(businessLicence);
			if(StringUtils.isEmpty(businessLicence)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "营业执照不能为空。");
				msgs.add(msg);
				continue;
			}
			String organCode  = data[row][CooperationBZEnum.ORGANCODE.getIndex()];
			cooperation.setOrgancode(organCode);
			String taxCode = data[row][CooperationBZEnum.TAXCODE.getIndex()];
			cooperation.setTaxcode(taxCode);
			String registerAddress = data[row][CooperationBZEnum.REGISTERADDRESS.getIndex()];
			cooperation.setRegisteraddress(registerAddress);
			if(StringUtils.isEmpty(registerAddress)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "注册地址不能为空。");
				msgs.add(msg);
				continue;
			}
			cooperation.setMailaddress(data[row][CooperationBZEnum.MAILADDRESS.getIndex()]);
			Date registerDate = null;
			try{
				registerDate = format.parse(data[row][CooperationBZEnum.REGISTERDATE.getIndex()]);
				cooperation.setRegisterdate(registerDate);
			}catch(Exception e){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "注册日期格式不正确！");
				msgs.add(msg);
				continue;
			}
			cooperation.setRegistercapital(data[row][CooperationBZEnum.REGISTERCAPITAL.getIndex()]);
			cooperation.setRealcapital(data[row][CooperationBZEnum.REALCAPITAL.getIndex()]);
			cooperation.setRealcapital(data[row][CooperationBZEnum.LEGALPERSON.getIndex()]);
			cooperation.setIdnum(data[row][CooperationBZEnum.IDNUM.getIndex()]);
			cooperation.setPhone(data[row][CooperationBZEnum.PHONE.getIndex()]);
			Integer members = null;
			try{
				members = Integer.valueOf(data[row][CooperationBZEnum.MEMBERS.getIndex()]);
				cooperation.setMembers(members);
			}catch(Exception e){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "社员人数必须为数字！");
				msgs.add(msg);
				continue;
			}
			cooperation.setBusinesscope(data[row][CooperationBZEnum.BUSINESSCOPE.getIndex()]);
			Integer businessArea = null;
			try{
				businessArea = Integer.valueOf(data[row][CooperationBZEnum.BUSINESSAREA.getIndex()]);
				cooperation.setBusinessarea(businessArea);
			}catch(Exception e){
				e.printStackTrace();
			}
			Integer farmers = null;
			try{
				farmers = Integer.valueOf(data[row][CooperationBZEnum.FARMERS.getIndex()]);
				cooperation.setFarmers(farmers);
			}catch(Exception e){
				e.printStackTrace();
			}
			cooperation.setConnectionbase(data[row][CooperationBZEnum.CONNECTIONBASE.getIndex()]);
			CooperationExample ce = new CooperationExample();
			CooperationExample.Criteria cec = ce.createCriteria();
			cec.andBusinesslicenceEqualTo(businessLicence);
			cec.andSourcecodeEqualTo("TYCJ");
			List<Cooperation> cooperations = cooperationService.selectByExample(ce);
			if(cooperations.size() == 0){
				cooperationService.insert(cooperation);
			}else if (cooperations.size() ==1){
				cooperationService.updateByExampleSelective(cooperation, ce);
			}
		}
		return msgs;
	}
	private List<Map<String,String>> importCooperationNS(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for(int row =2;row<data.length;row++){
			String clientType = data[row][CooperationNSEnum.CLINETTYPE.getIndex()];
			if(!clientType.contains("经济组织")){
				continue;
			}
			Cooperation cooperation = new Cooperation();
			cooperation.setSourcecode("C3140436000017");
			cooperation.setSourcename("新干县农村信用合作联社");
			cooperation.setRunitid(organId);
			cooperation.setRunitname(organName);
			cooperation.setRecorder(recorder);
			cooperation.setRecordtime(recordTime);
			String cooperationName = data[row][CooperationNSEnum.COOPERATIONNAME.getIndex()];
			if(StringUtils.isEmpty(cooperationName)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "经济合作组织名称不能为空。");
				msgs.add(msg);
				continue;
			}
			cooperation.setCooperationname(cooperationName);
			String businessLicence = data[row][CooperationNSEnum.BUSINESSLICENCE.getIndex()];
			if(StringUtils.isEmpty(businessLicence)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "营业执照不能为空。");
				msgs.add(msg);
				continue;
			}
			cooperation.setBusinesslicence(businessLicence);
			String legalPerson = data[row][CooperationNSEnum.LEGALPERSON.getIndex()];
			cooperation.setLegalperson(legalPerson);
			String idNum = data[row][CooperationNSEnum.IDNUM.getIndex()];
			cooperation.setIdnum(idNum);
			String registerDate = data[row][CooperationNSEnum.REGISTERDATE.getIndex()];
			if(!StringUtils.isEmpty(registerDate)){
				Date date;
				try {
					date = format.parse(registerDate);
					cooperation.setRegisterdate(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("tip", "info");
					msg.put("msg", "注册日期必须为日期格式，如:2015-05-12");
					msgs.add(msg);
					continue;
				}
				
			}
			String phone = data[row][CooperationNSEnum.PHONE.getIndex()];
			String phone1 = data[row][CooperationNSEnum.PHONE1.getIndex()];
			String fullPhone = phone+"   "+phone1;
			cooperation.setPhone(fullPhone);
			String registerAddress = data[row][CooperationNSEnum.REGISTERADDRESS.getIndex()];
			cooperation.setRegisteraddress(registerAddress);
			CooperationExample ce = new CooperationExample();
			CooperationExample.Criteria cc = ce.createCriteria();
			cc.andSourcecodeEqualTo(cooperation.getSourcecode());
			cc.andBusinesslicenceEqualTo(cooperation.getBusinesslicence());

			List<Cooperation> cooperations = cooperationService.selectByExample(ce);
			if(cooperations == null || cooperations.size() == 0){
				cooperationService.insert(cooperation);
			}else if(cooperations.size() == 1){
				Cooperation dbCooperation = cooperations.get(0);
				cooperation.setId(dbCooperation.getId());
				CooperationExample ce1 = new CooperationExample();
				CooperationExample.Criteria cc1 = ce1.createCriteria();
				cc1.andCooperationidEqualTo(dbCooperation.getId());
				cooperationService.updateByExampleSelective(cooperation, ce1);
			}
		}
		return msgs;
	
	}
}
