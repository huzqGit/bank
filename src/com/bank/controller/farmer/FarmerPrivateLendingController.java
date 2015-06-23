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
import com.bank.beans.FarmerPrivateLending;
import com.bank.service.IFarmerPrivateLendingService;
import com.bank.service.IFarmerService;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerPrivateLendingController {
	
	@Resource
	private IFarmerService farmerService;
	
	@Resource
	private IFarmerPrivateLendingService farmerPrivateLendingService;
	
	@RequestMapping(value="/typeInPrivateLending",method=RequestMethod.GET)
	public ModelAndView typeInHouse(@RequestParam(value="fid") String fid, 
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
		ModelAndView view = new ModelAndView("/farmer/farmerPrivateLendingForm");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value = "/savePrivateLending",method = RequestMethod.POST)
	public ModelAndView savePrivateLending(@ModelAttribute(value="privateLending") FarmerPrivateLending privateLending,
			HttpServletRequest request, HttpServletResponse response){
		try{
			if(privateLending.getId() == null){
				farmerPrivateLendingService.save(privateLending);
			}else{
				farmerPrivateLendingService.update(privateLending);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(privateLending.getFarmerid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerPrivateLendingView");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/deletePrivateLending",method=RequestMethod.GET)
	public ModelAndView deleteBalance(@RequestParam(value="id") Long id,@RequestParam(value="fid") Long fid){
		try {
			farmerPrivateLendingService.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(fid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerPrivateLendingView");
		view.addObject("farmer", farmer);
		return view;
	}

	@RequestMapping(value = "/editPrivateLending",method = RequestMethod.GET)
	public ModelAndView editPrivateLending(@RequestParam(value="id") Long id,@RequestParam(value="fid") Long fid,
			HttpServletRequest request, HttpServletResponse response){
		Farmer farmer = null;
		FarmerPrivateLending privateLending = null;
		try {
			 farmer = farmerService.findByPK(fid);
			 privateLending = farmerPrivateLendingService.findByPK(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerPrivateLendingForm");
		view.addObject("farmer", farmer);
		view.addObject("privateLending",privateLending);
		return view;
	}
	@RequestMapping(value="/queryPrivateLending",method=RequestMethod.GET)
	public ModelAndView queryPrivateLending(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){

		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerPrivateLendingView");
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/queryPrivateLendingByPaging",method=RequestMethod.POST)
	public ModelAndView queryPrivateLendingByPaging(@RequestParam(value="fid") Long fid, 
			@RequestParam(value="pageIndex") int pageIndex,@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){

		int toatalNumber = farmerPrivateLendingService.findTotalNumber(fid);
		List<FarmerPrivateLending> lendings = farmerPrivateLendingService.findByPaging(pageIndex, pageSize, sortField, sortOrder, fid);
		Map map = new HashMap();
		map.put("total", toatalNumber);
		map.put("data", lendings);
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
