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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerCompunish;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerCompunishService;
import com.bank.service.IFarmerService;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

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
	@RequestMapping(value = "/saveCompunish1",method = RequestMethod.POST)
	public ModelAndView saveCompunish1(@ModelAttribute(value="compunish") FarmerCompunish compunish,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		if(compunish.getId()==null){
			farmerCompunishService.save(compunish);
		}else{
			farmerCompunishService.update(compunish);
		}
		ModelAndView view = new ModelAndView("/farmer/farmerCompunishView1");
		Farmer farmer = null;
		try {
			 farmer = farmerService.findByPK(compunish.getFarmerId());
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
	@RequestMapping(value="/queryCompunish",method=RequestMethod.GET)
	public ModelAndView queryCompunish(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerCompunishView1");
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
	@RequestMapping(value="/deleteCompunish",method=RequestMethod.GET)
	public ModelAndView deleteCompunish(HttpServletRequest request,HttpServletResponse response){
		
		String id = request.getParameter("id");
		String fid = request.getParameter("fid");
		Long compunishId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		try {
			farmerCompunishService.delete(compunishId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Farmer farmer = null;
		try {
			 farmer = farmerService.findByPK(farmerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerCompunishView1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/editCompunish",method=RequestMethod.GET)
	public ModelAndView editCompunish(@RequestParam(value="id") String id,@RequestParam(value="fid") String fid,
			HttpServletRequest request,HttpServletResponse response){
		
		Long compunishId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		Farmer farmer = null;
		FarmerCompunish compunish = null;
		try {
			farmer = farmerService.findByPK(farmerId);
			compunish = farmerCompunishService.findByPK(compunishId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerCompunishForm1");
		view.addObject("farmer",farmer);
		view.addObject("compunish",compunish);
		return view;
	}
	@RequestMapping(value="/loadCompunish",method=RequestMethod.POST)
	public ModelAndView loadCompunish(@RequestParam(value="fid") String fid,
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
	    int pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
	    int pageSize = Integer.valueOf(request.getParameter("pageSize"));        
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
		List<FarmerCompunish> compunishs =farmerCompunishService.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, farmerId);
	    String json = JSON.toJSONStringWithDateFormat(compunishs,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadJiangCheng", method = RequestMethod.GET)
	public ModelAndView loadCompany(@RequestParam(value="fid") String fid, 
			HttpServletResponse response) throws Exception {
		Long farmerId =Long.valueOf(fid);
		Farmer farmer = farmerService.findByPK(farmerId);
		List<FarmerCompunish> compunishs = farmerCompunishService.getCompunishByFarmer(farmerId);
		if(compunishs.size() == 0){
			compunishs.add(new FarmerCompunish());
		}
		ModelAndView view = new ModelAndView("/farmer/farmerJiangChengForm");
		view.addObject("farmer",farmer);
		view.addObject("compunishs",compunishs);
		return view;
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
		}
		List<Farmer> farmers = farmerService.findByIDAndName(farmerIdNum, farmerName);
		if(farmers.size() == 0){
			ModelAndView view = new ModelAndView("/farmer/farmerJiangChengView");
			view.addObject("farmerName", farmerName);
			view.addObject("farmerIdNum", farmerIdNum);
			view.addObject("msg","未找到匹配的农户信息!您可以到【农户】-【数据采集】-【基本信息】模块中录入农户信息后再录入农户的资产信息!");
			return view;
		}else{
			ModelAndView view = new ModelAndView("/farmer/farmerJiangChengView");
			view.addObject("farmerName", farmerName);
			view.addObject("farmerIdNum", farmerIdNum);
			view.addObject("farmers",farmers);
			return view;
		}
	}
	@RequestMapping(value="/typeInCompunish1",method=RequestMethod.GET)
	public ModelAndView typeCompunish1(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		Long farmerId = Long.valueOf(fid);
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
		ModelAndView view = new ModelAndView("/farmer/farmerCompunishForm1");
		view.addObject("farmer",farmer);
		return view;
	}
}
