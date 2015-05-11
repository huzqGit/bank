package com.bank.controller.farmer;

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
import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerEvaluate;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerCompunishService;
import com.bank.service.IFarmerService;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerCompunishController {
	
	@Resource
	private IFarmerService farmerService;
	@Resource
	private IFarmerCompunishService farmerCompunishService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/saveJiangCheng",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String farmerData  = request.getParameter("farmer");
		String compunishData = request.getParameter("compunish");
		//這裡做了時間格式的處理
		
		Object farmerJsonData = JsonUtil.Decode(farmerData);
		farmerData = JSON.toJSONStringWithDateFormat(farmerJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject farmerJson = JSONObject.parseObject(farmerData);
		Farmer farmer = (Farmer) JSON.toJavaObject(farmerJson, Farmer.class);
		
		Object compunishJsonData = JsonUtil.Decode(compunishData);
		compunishData = JSON.toJSONStringWithDateFormat(compunishJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);	
		List<FarmerCompunish> compunishs = (List<FarmerCompunish>)JSON.parseArray(compunishData, FarmerCompunish.class);
		
		if(farmer.getId() == null){
			return null;
		}else{
			farmerCompunishService.saveJiangCheng(farmer, compunishs);
			Map map = new HashMap();
			map.put("compunish", compunishs);
			String json = JSON.toJSONString(map);
			PrintWriter writer = response.getWriter();
			writer.write(json);
			writer.flush();
			return null;
		}		
	}
	
	@RequestMapping(value = "/loadCompunish", method = RequestMethod.POST)
	public ModelAndView loadCompany(@RequestParam(value="id",required=true) String id, 
			HttpServletResponse response) throws Exception {
		if(!StringUtils.isEmpty(id)){
			Long compunishId=Long.valueOf(id);
			FarmerCompunish farmer = farmerCompunishService.findByPK(compunishId);
			String json = JsonUtil.Encode(farmer);
			response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
		
	}
	
	@RequestMapping(value="/loadAllCompunish",method=RequestMethod.POST)
	public ModelAndView loadAllCompany(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		//查询条件
		String farmerName = request.getParameter("farmerName");
	    String farmerIdNum=request.getParameter("farmerIdNum");
	    String type = request.getParameter("type");
	    String organ=request.getParameter("organ");
	    String recorder=request.getParameter("recorder");
	    String recordTimeBegin=request.getParameter("recordTimeBegin");
	    String recordTimeEnd=request.getParameter("recordTimeEnd");
	    
	    Map<String,String> query = new HashMap<String,String>();
	    query.put("farmerName", farmerName);
	    query.put("farmerIdNum", farmerIdNum);
	    query.put("type", type);
	    query.put("organ", organ);
	    query.put("recorder", recorder);
	    query.put("recordTimeBegin", recordTimeBegin);
	    query.put("recordTimeEnd", recordTimeEnd);
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    List<FarmerCompunish> data = farmerCompunishService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, query);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	@RequestMapping(value="/typeInJiangCheng",method=RequestMethod.POST)
	public ModelAndView typeInJiangCheng(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum,  
			HttpServletResponse response) throws Exception{
		if(StringUtils.isEmpty(farmerName) && StringUtils.isEmpty(farmerIdNum)){
			ModelAndView view = new ModelAndView("/farmer/farmerJiangChengView");
			view.addObject("msg","请您填写完农户姓名和身份证号码后录入资产信息!!");
			return view;
		}else{
			List<Farmer> farmers = farmerService.findByIDAndName(farmerIdNum, farmerName);
			if(farmers.size() == 0){
				ModelAndView view = new ModelAndView("/farmer/farmerJiangChengView");
				view.addObject("msg","未找到匹配的农户信息!您可以到【农户】-【数据采集】-【基本信息】模块中录入农户信息后再录入农户的资产信息!");
				return view;
			}else if(farmers.size() ==1){
				Farmer farmer = farmers.get(0);
				FarmerEvaluate evaluate = farmerCompunishService.getEvaluateByFarmer(farmer.getId());
				List<FarmerCompunish> compunishs = farmerCompunishService.getCompunishByFarmer(farmer.getId());
				if(compunishs.size() == 0){
					compunishs.add(new FarmerCompunish());
				}
				ModelAndView view = new ModelAndView("/farmer/farmerJiangChengForm");
				view.addObject("farmer",farmer);
				view.addObject("evaluate",evaluate);
				view.addObject("compunishs",compunishs);
				return view;
			}else{
				ModelAndView view = new ModelAndView("/farmer/farmerJiangChengView");
				view.addObject("msg", "找到多个农户信息!");
				view.addObject("farmer",farmers);
			}
		}
		ModelAndView view = new ModelAndView("/farmer/farmerJiangChengView");
		return view;
	}
}
