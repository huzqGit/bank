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
import com.bank.beans.Farmer;
import com.bank.beans.FarmerCondition;
import com.bank.service.IFarmerConditionService;
import com.bank.service.IFarmerService;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerConditionController {
	
	@Resource
	private IFarmerService farmerService;
	@Resource
	private IFarmerConditionService conditionService;
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute(value="condition") FarmerCondition condition,
			HttpServletRequest request,HttpServletResponse response){
		try {
			if(condition.getId() == null){
				conditionService.save(condition);
			}else{
				conditionService.update(condition);
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CreateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(condition.getFarmerid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerConditionView");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/queryCondition",method=RequestMethod.GET)
	public ModelAndView queryHouse(@RequestParam(value="fid") Long fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView view = new ModelAndView("/farmer/farmerConditionView");
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(fid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.addObject("farmer",farmer);
		return view;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/loadCondition", method = RequestMethod.POST)
	public ModelAndView loadCondition(@RequestParam(value="fid") Long fid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response) {
		
			int totalNumber =0;
			List<FarmerCondition> houses = null;
			Map map = new HashMap();
			map.put("farmerId", fid);
			try {
				totalNumber = conditionService.findTotalNumberByFarmerId(fid);
				houses = conditionService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, map);
			} catch (DAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			map.put("total", totalNumber);
			map.put("data", houses);
			String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = null;
			try {
				writer = response.getWriter();
				writer.write(json);
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return null;

	}

}
