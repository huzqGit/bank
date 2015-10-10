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
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerEvaluate;
import com.bank.beans.FarmerEvaluateExample;
import com.bank.beans.FarmerExample;
import com.bank.beans.Organ;
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
	
	@RequestMapping(value = "/saveEvaluate1",method = RequestMethod.POST)
	public ModelAndView saveEvaluate1(@ModelAttribute(value="evaluate") FarmerEvaluate evaluate,
			HttpServletRequest request,HttpServletResponse response){
		
		try{
			if(evaluate.getId() == null){
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				evaluate.setSourcecode(organ.getOrganNo());
				evaluate.setSourcename(organ.getOrganName());
				evaluate.setRunitid(organ.getOrganId());
				evaluate.setRunitname(organ.getOrganName());
				farmerEvaluateService.save(evaluate);
			}else{
				farmerEvaluateService.update(evaluate);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fec = fe.createCriteria();
		fec.andFarmeridnumEqualTo(evaluate.getFarmeridnum());
		fec.andRunitidEqualTo(evaluate.getRunitid());
		List<Farmer> farmers = farmerService.selectByExample(fe);
		if(farmers.size() == 1){
			ModelAndView view = new ModelAndView("/farmer/farmerEvaluateForm1");
			view.addObject("farmer",farmers.get(0));
			return view;
		}else{
			return null;
		}
	}
@RequestMapping(value="/queryEvaluate",method=RequestMethod.GET)
public ModelAndView queryEvaluate(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerEvaluateForm1");
		Farmer farmer = null;
		FarmerEvaluate evaluate = null;
		try {
			 farmer = farmerService.findByPK(farmerId);
			 evaluate = farmerEvaluateService.findByID(farmerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.addObject("farmer",farmer);
		view.addObject("evaluate",evaluate);
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
@SuppressWarnings({ "unchecked", "rawtypes" })
@RequestMapping(value="/loadEvaluate1",method=RequestMethod.POST)
public ModelAndView loadEvaluate1(@RequestParam(value="farmeridnum") String farmeridnum,
		@RequestParam(value="runitid") String runitid,
		@RequestParam(value="pageIndex") int pageIndex,
		@RequestParam(value="pageSize") int pageSize,
		@RequestParam(value="sortField") String sortField,
		@RequestParam(value="sortOrder") String sortOrder,
		HttpServletRequest request,HttpServletResponse response){

	FarmerEvaluateExample fee = new FarmerEvaluateExample();
	FarmerEvaluateExample.Criteria feec = fee.createCriteria();
	feec.andFarmeridnumEqualTo(farmeridnum);
	feec.andRunitidEqualTo(runitid);
	int totalNumber = farmerEvaluateService.countByExample(fee);
	
	Map paramMap = new HashMap();
	paramMap.put("farmeridnum", farmeridnum);
	paramMap.put("runitid", runitid);
	List<FarmerEvaluate> evaluates = null;
	try {
		evaluates = farmerEvaluateService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
	} catch (DAOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Map map = new HashMap();
	map.put("total", totalNumber);
	map.put("data", evaluates);
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
	public ModelAndView loadAllEvaluate(HttpServletRequest request, 
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
	@RequestMapping(value="/typeInEvaluate",method=RequestMethod.GET)
	public ModelAndView typeInEvaluate(@RequestParam(value="fid") String fid, 
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
		view.addObject("evaluate",evaluate);
		return view;
	}
	
}
