package com.bank.controller.farmer;

import java.io.IOException;
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
import com.bank.beans.FarmerInsured;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerInsuredService;
import com.bank.service.IFarmerService;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

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
	@RequestMapping(value="/saveInsured1",method=RequestMethod.POST)
	public ModelAndView saveInsured1(@ModelAttribute(value="insured") FarmerInsured insured,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		if(insured.getId()==null){
			farmerInsuredService.save(insured);
		}else{
			farmerInsuredService.update(insured);
		}
		ModelAndView view = new ModelAndView("/farmer/farmerInsuredView1");
		Farmer farmer = null;
		try {
			 farmer = farmerService.findByPK(insured.getFarmerId());
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
	@RequestMapping(value="/deleteInsured",method=RequestMethod.GET)
	public ModelAndView deleteInsured(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		String fid = request.getParameter("fid");
		Long insuredId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		try {
			farmerInsuredService.delete(insuredId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		ModelAndView view = new ModelAndView("/farmer/farmerInsuredView1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/editInsured",method=RequestMethod.GET)
	public ModelAndView editInsured(@RequestParam(value="id") String id,@RequestParam(value="fid") String fid,
			HttpServletRequest request,HttpServletResponse response){
		
		Long insuredId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		Farmer farmer = null;
		FarmerInsured insured = null;
		try {
			farmer = farmerService.findByPK(farmerId);
			insured = farmerInsuredService.findByPK(insuredId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerInsuredForm1");
		view.addObject("farmer",farmer);
		view.addObject("insured",insured);
		return view;
	}
	@RequestMapping(value="/queryInsured",method=RequestMethod.GET)
	public ModelAndView queryCompunish(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerInsuredView1");
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
	@RequestMapping(value="/loadInsured",method=RequestMethod.POST)
	public ModelAndView loadInsured(@RequestParam(value="fid") String fid,
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
	    int pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
	    int pageSize = Integer.valueOf(request.getParameter("pageSize"));        
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
		List<FarmerInsured> insureds =farmerInsuredService.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, farmerId);
	    String json = JSON.toJSONStringWithDateFormat(insureds,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
@RequestMapping(value="/typeInInsured1",method=RequestMethod.GET)
public ModelAndView typeInInsured1(@RequestParam(value="fid") String fid, 
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
	ModelAndView view = new ModelAndView("/farmer/farmerInsuredForm1");
	view.addObject("farmer",farmer);
	return view;
}
}
