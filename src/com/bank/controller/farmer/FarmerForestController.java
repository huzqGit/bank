package com.bank.controller.farmer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerForestExample;
import com.bank.beans.Organ;
import com.bank.service.IFarmerForestService;
import com.bank.service.IFarmerService;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerForestController {
	
	@Resource
	private IFarmerService farmerService;
	
	@Resource
	private IFarmerForestService farmerForestService;
	
	@RequestMapping(value = "/saveForest1",method = RequestMethod.POST)
	public ModelAndView saveForest(@ModelAttribute(value="forest") FarmerForest forest,
			HttpServletRequest request,HttpServletResponse response){
		try{
			if(forest.getId() ==null){
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				forest.setRunitid(organ.getOrganId());
				forest.setRunitname(organ.getOrganName());
				forest.setSourcecode(organ.getOrganNo());
				forest.setSourcename(organ.getOrganName());
				farmerForestService.save(forest);
			}else{
				farmerForestService.update(forest);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(forest.getFarmerid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView view = new ModelAndView("/farmer/farmerForestView1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/queryForest",method=RequestMethod.GET)
	public ModelAndView queryForest(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerForestView1");
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(farmerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/deleteForest",method=RequestMethod.GET)
	public ModelAndView deleteForest(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		String fid = request.getParameter("fid");
		Long forestId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		try {
			farmerForestService.delete(forestId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(farmerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerForestView1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/editForest",method=RequestMethod.GET)
	public ModelAndView editForest(@RequestParam(value="id") Long id,@RequestParam(value="fid") Long fid,
			HttpServletRequest request,HttpServletResponse response){
		Farmer farmer = null;
		FarmerForest forest = null;
		try {
			farmer = farmerService.findByPK(fid);
			forest = farmerForestService.findByPK(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerForestForm1");
		view.addObject("farmer",farmer);
		view.addObject("forest",forest);
		return view;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/loadForest", method = RequestMethod.POST)
	public ModelAndView loadForest(@RequestParam(value="farmeridnum") String farmeridnum,
			@RequestParam(value="runitid") String runitid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
		
		FarmerForestExample ffe = new FarmerForestExample();
		FarmerForestExample.Criteria ffec= ffe.createCriteria();
		ffec.andFarmeridnumEqualTo(farmeridnum);
		ffec.andRunitidEqualTo(runitid);
		int totalNumber =  farmerForestService.countByExample(ffe);
		
		Map paramMap = new HashMap();
		paramMap.put("farmeridnum", farmeridnum);
		paramMap.put("runitid", runitid);
		List<FarmerForest> houses = null;
		try {
			houses = farmerForestService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Map map = new HashMap();		
		map.put("total", totalNumber);
		map.put("data", houses);
		String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.write(json);
		writer.flush();
		return null;
		
	}
	
	@RequestMapping(value="/typeInForest",method=RequestMethod.GET)
	public ModelAndView typeInForest(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
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
		ModelAndView view = new ModelAndView("/farmer/farmerForestForm1");
		view.addObject("farmer",farmer);
		return view;
	}
	
}
