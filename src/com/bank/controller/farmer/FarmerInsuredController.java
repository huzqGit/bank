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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerExample;
import com.bank.beans.FarmerInsured;
import com.bank.beans.FarmerInsuredExample;
import com.bank.beans.Organ;
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
	
	@RequestMapping(value="/saveInsured1",method=RequestMethod.POST)
	public ModelAndView saveInsured1(@ModelAttribute(value="insured") FarmerInsured insured,
			HttpServletRequest request,HttpServletResponse response) {
		try{
			if(insured.getId()==null){
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				insured.setSourcecode(organ.getOrganNo());
				insured.setSourcename(organ.getOrganName());
				insured.setRunitid(organ.getOrganId());
				insured.setRunitname(organ.getOrganName());
				farmerInsuredService.save(insured);
			}else{
				farmerInsuredService.update(insured);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fec = fe.createCriteria();
		fec.andFarmeridnumEqualTo(insured.getFarmeridnum());
		fec.andRunitidEqualTo(insured.getRunitid());
		List<Farmer> farmers = farmerService.selectByExample(fe);
		if(farmers.size() == 1){
			ModelAndView view = new ModelAndView("/farmer/farmerInsuredView1");
			view.addObject("farmer",farmers.get(0));
			return view;
		}else{
			return null;
		}
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
	public ModelAndView editInsured(@RequestParam(value="id") Long id,@RequestParam(value="fid") Long fid,
			HttpServletRequest request,HttpServletResponse response){

		Farmer farmer = null;
		FarmerInsured insured = null;
		try {
			farmer = farmerService.findByPK(fid);
			insured = farmerInsuredService.findByPK(id);
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/loadInsured",method=RequestMethod.POST)
	public ModelAndView loadInsured(@RequestParam(value="farmeridnum") String farmeridnum,
			@RequestParam(value="runitid") String runitid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response) {
		
			FarmerInsuredExample fie = new FarmerInsuredExample();
			FarmerInsuredExample.Criteria fiec = fie.createCriteria();
			fiec.andFarmeridnumEqualTo(farmeridnum);
			fiec.andRunitidEqualTo(runitid);
			int totalNumber = farmerInsuredService.countByExample(fie);
			
			List<FarmerInsured> insureds = null;
			Map paramMap = new HashMap();
			paramMap.put("farmeridnum", farmeridnum);
			paramMap.put("runitid", runitid);
			try {
				insureds = farmerInsuredService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
		    HashMap result = new HashMap();
	        result.put("data", insureds);
	        result.put("total", totalNumber);
        
		    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		    response.setContentType("text/html;charset=UTF-8");
		    try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
@RequestMapping(value="/importFarmerInsured",method=RequestMethod.POST)
public ModelAndView importFarmerInsured(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
		HttpServletRequest request,HttpServletResponse response){
	return null;
}
}
