package com.bank.controller.farmer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerEvaluate;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerEvaluateService;
import com.bank.service.IFarmerService;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerEvaluateController {
	
	@Resource
	private IFarmerService farmerService;
	@Resource
	private IFarmerEvaluateService farmerEvaluateService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/saveEvaluate",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String farmerData  = request.getParameter("farmer");
		String evaluateData = request.getParameter("evaluate");
		
		Object farmerJsonData = JsonUtil.Decode(farmerData);
		farmerData = JSON.toJSONStringWithDateFormat(farmerJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject farmerJson = JSONObject.parseObject(farmerData);
		Farmer farmer = (Farmer) JSON.toJavaObject(farmerJson, Farmer.class);
		
		Object decodeJsonData = JsonUtil.Decode(evaluateData);
		evaluateData = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject evaluatejsb = JSONObject.parseObject(evaluateData);
		FarmerEvaluate evaluate = (FarmerEvaluate) JSON.toJavaObject(evaluatejsb, FarmerEvaluate.class);
		farmerEvaluateService.saveEvaluate(farmer, evaluate);
		PrintWriter writer = response.getWriter();
		Map map = new HashMap();
		map.put("evaluate", evaluate);
		String json =JSON.toJSONString(map);
		writer.write(json);
		writer.flush();
		return null;	
	
}
@RequestMapping(value="/queryEvaluate",method=RequestMethod.GET)
public ModelAndView queryCompunish(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerEvaluateView1");
		Farmer farmer = null;
		try {
			 farmer = farmerService.findByPK(farmerId);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.addObject("farmer",farmer);
		return view;
}
@RequestMapping(value="/loadEvaluate",method=RequestMethod.POST)
public ModelAndView loadEvaluate(@RequestParam(value="fid") String fid,
		HttpServletRequest request,HttpServletResponse response){
	
	Long farmerId = Long.valueOf(fid);
	Farmer farmer = null;
	FarmerEvaluate evaluate = null;
	try {
		 farmer = farmerService.findByPK(farmerId);
		 evaluate = farmerEvaluateService.findByID(farmerId);
	} catch (DAOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DataNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ModelAndView view = new ModelAndView("/farmer/farmerEvaluateForm1");
	view.addObject("farmer",farmer);
	view.addObject("evaluate", evaluate);
	return view;
}
@RequestMapping(value="/loadEvaluate1",method=RequestMethod.POST)
public ModelAndView loadEvaluate1(@RequestParam(value="fid") String fid,
		HttpServletRequest request,HttpServletResponse response){
	
	Long farmerId = Long.valueOf(fid);
    int pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
    int pageSize = Integer.valueOf(request.getParameter("pageSize"));        
    String sortField = request.getParameter("sortField");
    String sortOrder = request.getParameter("sortOrder");
	List<FarmerEvaluate> evaluates =farmerEvaluateService.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, farmerId);
    String json = JSON.toJSONStringWithDateFormat(evaluates,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
    response.setContentType("text/html;charset=UTF-8");
    try {
		response.getWriter().write(json);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
@RequestMapping(value="/typeInEvaluate",method=RequestMethod.POST)
public ModelAndView typeInEvaluate(@RequestParam(value="farmerName") String farmerName,
		@RequestParam(value="farmerIdNum") String farmerIdNum, 
		HttpServletResponse response) throws Exception{
	//查询条件
	if(StringUtils.isEmpty(farmerIdNum) && StringUtils.isEmpty(farmerName)){
		ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
		view.addObject("msg", "请您填写完农户姓名和身份证号码后录入资产信息!");
		return  view;
	}
	List<Farmer> farmers= farmerService.findByIDAndName(farmerIdNum, farmerName);
	if(farmers.size()== 0){
	    ModelAndView view = new ModelAndView("/farmer/farmerQiTaView");
		view.addObject("farmerIdNum", farmerIdNum);
		view.addObject("farmerName",farmerName);
		view.addObject("msg","未找到相应的农户信息!您可以填写好姓名和身份证号码后录入新的农户信息");
		return view;
	}else{
		ModelAndView view = new ModelAndView("/farmer/farmerQiTaView");
		view.addObject("farmerIdNum",farmerIdNum);
		view.addObject("farmerName",farmerName);
		view.addObject("farmers",farmers);
		return view;
	 }
}	
	@RequestMapping(value = "/loadEvaluate", method = RequestMethod.GET)
	public ModelAndView loadEvaluate(@RequestParam(value="fid") String fid, 
			HttpServletResponse response) throws Exception {
		if(!StringUtils.isEmpty(fid)){
			Long farmerId=Long.valueOf(fid);
			Farmer farmer = farmerService.findByPK(farmerId);
			FarmerEvaluate evaluate = farmerEvaluateService.findByID(farmerId);
			ModelAndView view = new ModelAndView("/farmer/farmerQiTaForm");
			view.addObject("farmer", farmer);
			view.addObject("evaluate", evaluate);
			return view;
		}
		return null;
		
	}
	
	@RequestMapping(value="/loadAllEvaluate",method=RequestMethod.POST)
	public ModelAndView loadAllCompany(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		//查询条件
		String farmerName = request.getParameter("farmerName");
	    String farmerIdNum=request.getParameter("farmerIdNum");
	    String harmonyStatus=request.getParameter("harmonyStatus");
	    String honestStatus=request.getParameter("honestStatus");
	    String recorder=request.getParameter("recorder");
	    String recordTimeBegin=request.getParameter("recordTimeBegin");
	    String recordTimeEnd=request.getParameter("recordTimeEnd");
	    
	    Map<String,String> query = new HashMap<String,String>();
	    query.put("farmerName", farmerName);
	    query.put("farmerIdNum", farmerIdNum);
	    query.put("harmonyStatus", harmonyStatus);
	    query.put("honestStatus", honestStatus);
	    query.put("recorder", recorder);
	    query.put("recordTimeBegin", recordTimeBegin);
	    query.put("recordTimeEnd", recordTimeEnd);
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    List<FarmerEvaluate> data = farmerEvaluateService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, query);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
}
