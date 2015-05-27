package com.bank.controller.farmer;

import java.io.PrintWriter;
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
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerHouseService;
import com.bank.service.IFarmerService;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerHouseController {
	
	@Resource
	private IFarmerService farmerService;
	@Resource
	private IFarmerHouseService farmerHouseService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/saveChanQuan",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

		String farmerData = request.getParameter("farmer");
		String houseData = request.getParameter("house");
		String forestData = request.getParameter("forest");
		String breedData = request.getParameter("breed");
		String deviceData = request.getParameter("device");
		//這裡做了時間格式的處理
		Object decodeJsonData = JsonUtil.Decode(farmerData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		Farmer farmer = (Farmer) JSON.toJavaObject(jsb, Farmer.class);
		
		Object houseJsonData = JsonUtil.Decode(houseData);
		houseData = JSON.toJSONStringWithDateFormat(houseJsonData, "yyyy", SerializerFeature.WriteDateUseDateFormat);	
		List<FarmerHouse> house = (List<FarmerHouse>)JSON.parseArray(houseData, FarmerHouse.class);
		
		Object forestJsonData = JsonUtil.Decode(forestData);
		forestData = JSON.toJSONStringWithDateFormat(forestJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);	
		List<FarmerForest> forest = (List<FarmerForest>)JSON.parseArray(forestData, FarmerForest.class);
		
		Object breedJsonData = JsonUtil.Decode(breedData);
		breedData = JSON.toJSONStringWithDateFormat(breedJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);	
		List<FarmerBreed> breed = (List<FarmerBreed>)JSON.parseArray(breedData, FarmerBreed.class);
		
		Object deviceJsonData = JsonUtil.Decode(deviceData);
		deviceData = JSON.toJSONStringWithDateFormat(deviceJsonData, "yyyy", SerializerFeature.WriteDateUseDateFormat);	
		List<FarmerDevice> device = (List<FarmerDevice>)JSON.parseArray(deviceData, FarmerDevice.class);
		
		if(farmer.getId() == null){
			return null;
		}else{
			farmerHouseService.saveChanQuan(farmer, house, forest, breed, device);
		}
		Map map = new HashMap();
		map.put("farmer",farmer);
		map.put("house",house);
		map.put("forest",forest);
		map.put("breed",breed);
		map.put("device",device);
		String json =JSON.toJSONString(map);
		System.out.println(json);
		PrintWriter writer = response.getWriter();
		writer.write(json);
		writer.flush();
		return null;
		
	}
	@RequestMapping(value="/loadChanQuan",method=RequestMethod.GET)
	public ModelAndView loadChanQuan(@RequestParam(value="fid") String fid,
			HttpServletResponse response) throws Exception{
		//查询条件
	   Long farmerId = Long.valueOf(fid);
	   Farmer farmer = farmerService.findByPK(farmerId);
	   List<FarmerHouse> houses = farmerHouseService.findHouseByFarmer(farmerId);
	   if(houses.size() == 0){
	    	FarmerHouse house= new FarmerHouse();
	    	houses.add(house);
	   }
	   List<FarmerForest> forests = farmerHouseService.findForestByFarmer(farmerId);
	   if(forests.size() == 0){
		   FarmerForest forest = new FarmerForest();
	       forests.add(forest);
	   }
	   List<FarmerBreed> breeds = farmerHouseService.findBreedByFarmer(farmerId);
	   if(breeds.size() == 0){
		   FarmerBreed breed = new FarmerBreed();
	       breeds.add(breed);
	   }
	   List<FarmerDevice>  devices = farmerHouseService.findDeviceByFarmer(farmerId);
	   if(devices.size() == 0){
		   FarmerDevice device = new FarmerDevice();
	       devices.add(device);
	   }
	   ModelAndView view = new ModelAndView("/farmer/farmerChanQuanForm");
	   view.addObject("farmer", farmer);
	   view.addObject("houses",houses);
	   view.addObject("forests",forests);
	   view.addObject("breeds",breeds);
	   view.addObject("devices",devices);
	   return view;
	}
	@RequestMapping(value = "/loadHouse", method = RequestMethod.POST)
	public ModelAndView loadCompany(@RequestParam(value="id",required=true) String id, 
			HttpServletResponse response) throws Exception {
		if(!StringUtils.isEmpty(id)){
			Long houseId=Long.valueOf(id);
			FarmerHouse farmerHouse = farmerHouseService.findByPK(houseId);
			String json = JsonUtil.Encode(farmerHouse);
			response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
		
	}
	
	@RequestMapping(value="/loadAllHouse",method=RequestMethod.POST)
	public ModelAndView loadAllCompany(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		//查询条件
		String farmerName = request.getParameter("farmerName");
	    String farmerIdNum=request.getParameter("farmerIdNum");
	    String recorder=request.getParameter("recorder");
	    String houseProperty=request.getParameter("houseProperty");
	    String houseType=request.getParameter("houseType");
	    String recordTimeBegin=request.getParameter("recordTimeBegin");
	    String recordTimeEnd=request.getParameter("recordTimeEnd");
	    
	    Map<String,String> query = new HashMap<String,String>();
	    query.put("farmerName", farmerName);
	    query.put("farmerIdNum", farmerIdNum);
	    query.put("houseProperty", houseProperty);
	    query.put("houseType", houseType);
	    query.put("recorder", recorder);
	    query.put("recordTimeBegin", recordTimeBegin);
	    query.put("recordTimeEnd", recordTimeEnd);
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    List<FarmerHouse> data = farmerHouseService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, query);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	@RequestMapping(value="/typeInChanQuan",method=RequestMethod.POST)
	public ModelAndView typeInChanQuan(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		//查询条件
		String farmerName = request.getParameter("farmerName");
	    String farmerIdNum=request.getParameter("farmerIdNum");
	    if(StringUtils.isEmpty(farmerName) && StringUtils.isEmpty(farmerIdNum)){
	    	ModelAndView view = new ModelAndView("/farmer/farmerChanQuanView");
	    	view.addObject("msg","请您填写完农户姓名和身份证号码后录入资产信息!");
	    	return view;
	    }
	   List<Farmer> farmers = farmerService.findByIDAndName(farmerIdNum, farmerName);
	   if(farmers.size() == 0){
		   ModelAndView view = new ModelAndView("/farmer/farmerChanQuanView");
		   view.addObject("farmerName", farmerName);
		   view.addObject("farmerIdNum", farmerIdNum);
	       view.addObject("msg","未找到匹配的农户信息!您可以到【农户】-【数据采集】-【基本信息】模块中录入农户信息后再录入农户的资产信息!");
	       return view;
	   }else{
		   ModelAndView view = new ModelAndView("/farmer/farmerChanQuanView");
		   view.addObject("farmerName", farmerName);
		   view.addObject("farmerIdNum", farmerIdNum);
		   view.addObject("farmers",farmers);
	       return view;
	   }
	}
}
