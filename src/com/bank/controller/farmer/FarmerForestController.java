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
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerForest;
import com.bank.common.util.JsonUtil;
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
	
	@RequestMapping(value = "/saveForest",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

		String formData = request.getParameter("formData");
		//這裡做了時間格式的處理
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		FarmerForest farmerForest = (FarmerForest) JSON.toJavaObject(jsb, FarmerForest.class);
		if(farmerForest.getId()!=null){
			farmerForestService.update(farmerForest);
		}else{
			farmerForestService.save(farmerForest);
		}
		String json = JSON.toJSONString(farmerForest);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
		
	}
	@RequestMapping(value = "/saveForest1",method = RequestMethod.POST)
	public ModelAndView saveForest(@ModelAttribute(value="house") FarmerForest forest,
			HttpServletRequest request,HttpServletResponse response){
		try{
			if(forest.getId() ==null){
				farmerForestService.save(forest);
			}else{
				farmerForestService.update(forest);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(forest.getFarmerId());
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
	public ModelAndView editForest(@RequestParam(value="id") String id,@RequestParam(value="fid") String fid,
			HttpServletRequest request,HttpServletResponse response){
		
		Long forestId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		Farmer farmer = null;
		FarmerForest forest = null;
		try {
			farmer = farmerService.findByPK(farmerId);
			forest = farmerForestService.findByPK(forestId);
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
	public ModelAndView loadForest(@RequestParam(value="fid") Long fid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
		
		int totalNumber =  farmerForestService.findTotalNumberByFarmerId(fid);
		List<FarmerForest> houses = farmerForestService.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, fid);
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
