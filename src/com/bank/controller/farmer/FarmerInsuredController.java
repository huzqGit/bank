package com.bank.controller.farmer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerHouse;
import com.bank.beans.FarmerInsured;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerInsuredService;
import com.bank.service.IFarmerService;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerInsuredController {
	
	@Resource
	private IFarmerService farmerService;
	@Resource
	private IFarmerInsuredService farmerInsuredService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/saveInsured",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		//這裡做了時間格式的處理
		String farmerData = request.getParameter("farmer");
		String insuredData=request.getParameter("insured");

		//這裡做了時間格式的處理
		Object basicJsonData = JsonUtil.Decode(farmerData);
		farmerData = JSON.toJSONStringWithDateFormat(basicJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject farmerJson = JSONObject.parseObject(farmerData);
		Farmer farmer = (Farmer) JSON.toJavaObject(farmerJson, Farmer.class);
		//农户家庭成员情况
		Object memberJsonData = JsonUtil.Decode(insuredData);
		insuredData = JSON.toJSONStringWithDateFormat(memberJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		List<FarmerInsured> insureds = (List<FarmerInsured>) JSON.parseArray(insuredData, FarmerInsured.class);
		farmerInsuredService.save(farmer,insureds);
		Map map = new HashMap();
		map.put("insured", insureds);
		String json = JSON.toJSONString(map);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
		
	}
	
	@RequestMapping(value = "/loadCanBao", method = RequestMethod.GET)
	public ModelAndView loadCanBao(@RequestParam(value="fid") String fid, 
			HttpServletResponse response) throws Exception {
		if(!StringUtils.isEmpty(fid)){
			Long farmerId=Long.valueOf(fid);
			Farmer farmer = farmerService.findByPK(farmerId);
			List<FarmerInsured> insureds = farmerInsuredService.findByFarmer(farmerId);
			if(insureds.size() == 0){
				insureds.add(new FarmerInsured());
			}
			ModelAndView view = new ModelAndView("/farmer/farmerCanBaoForm");
			view.addObject("farmer", farmer);
			view.addObject("insureds", insureds);
		    return view;
		}
		return null;
	}
	
	@RequestMapping(value="/loadAllInsured",method=RequestMethod.POST)
	public ModelAndView loadAllCompany(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		//查询条件
		
		String farmerName = request.getParameter("farmerName");
	    String farmerIdNum=request.getParameter("farmerIdNum");
	    String name=request.getParameter("name");
	    String type=request.getParameter("type");
	    String recorder=request.getParameter("recorder");
	    String recordTimeBegin=request.getParameter("recordTimeBegin");
	    String recordTimeEnd=request.getParameter("recordTimeEnd");
	    
	    Map<String,String> query = new HashMap<String,String>();
	    query.put("farmerName", farmerName);
	    query.put("farmerIdNum", farmerIdNum);
	    query.put("name", name);
	    query.put("type", type);
	    query.put("recorder", recorder);
	    query.put("recordTimeBegin", recordTimeBegin);
	    query.put("recordTimeEnd", recordTimeEnd);
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    List<FarmerInsured> data = farmerInsuredService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, query);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
@RequestMapping(value="/typeInCanBao",method=RequestMethod.POST)
public ModelAndView typeInCanBao(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		//查询条件
	String farmerName = request.getParameter("farmerName");
	String farmerIdNum=request.getParameter("farmerIdNum");
	if(StringUtils.isEmpty(farmerName) && StringUtils.isEmpty(farmerIdNum)){
	    ModelAndView view = new ModelAndView("/farmer/farmerCanBaoView");
	    view.addObject("msg","请您填写完农户姓名和身份证号码后录入参保信息!");
	    return view;
	 }
	 List<Farmer> farmers = farmerService.findByIDAndName(farmerIdNum, farmerName);
	 if(farmers.size() == 0){
		  ModelAndView view = new ModelAndView("/farmer/farmerCanBaoView");
		  view.addObject("farmeName",farmerName);
		  view.addObject("farmerIdNum",farmerIdNum);
	      view.addObject("msg","未找到匹配的农户信息!您可以到【农户】-【数据采集】-【基本信息】模块中录入农户信息后再录入农户的参保信息!");
	      return view;
	  }else{
		   ModelAndView view = new ModelAndView("/farmer/farmerCanBaoView");   
		   view.addObject("farmeName",farmerName);
		   view.addObject("farmerIdNum",farmerIdNum);
		   view.addObject("farmers", farmers);
	       return view;
	  }
	}
}
