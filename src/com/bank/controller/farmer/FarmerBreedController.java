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
import com.bank.beans.FarmerBreed;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerBreedService;
import com.bank.service.IFarmerService;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerBreedController {
	
	@Resource
	private IFarmerService farmerService;
	
	@Resource
	private IFarmerBreedService farmerBreedService;
	
	@RequestMapping(value = "/saveBreed",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

		String formData = request.getParameter("formData");
		//這裡做了時間格式的處理
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		FarmerBreed farmerBreed = (FarmerBreed) JSON.toJavaObject(jsb, FarmerBreed.class);
		if(farmerBreed.getId()!=null){
			farmerBreedService.update(farmerBreed);
		}else{
			farmerBreedService.save(farmerBreed);
		}
		String json = JSON.toJSONString(farmerBreed);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
		
	}

	@RequestMapping(value = "/saveBreed1",method = RequestMethod.POST)
	public ModelAndView saveBreed1(@ModelAttribute(value="breed") FarmerBreed breed,
			HttpServletRequest request,HttpServletResponse response){
		try{
			if(breed.getId() ==null){
				farmerBreedService.save(breed);
			}else{
				farmerBreedService.update(breed);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(breed.getFarmerid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView view = new ModelAndView("/farmer/farmerBreedView1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/deleteBreed",method=RequestMethod.GET)
	public ModelAndView deleteBreed(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		String fid = request.getParameter("fid");
		Long breedId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		try {
			farmerBreedService.delete(breedId);
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
		ModelAndView view = new ModelAndView("/farmer/farmerBreedView1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/editBreed",method=RequestMethod.GET)
	public ModelAndView editBreed(@RequestParam(value="id") String id,@RequestParam(value="fid") String fid,
			HttpServletRequest request,HttpServletResponse response){
		
		Long breedId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		Farmer farmer = null;
		FarmerBreed breed = null;
		try {
			farmer = farmerService.findByPK(farmerId);
			breed = farmerBreedService.findByPK(breedId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerBreedForm1");
		view.addObject("farmer",farmer);
		view.addObject("breed",breed);
		return view;
	}
	@RequestMapping(value="/queryBreed",method=RequestMethod.GET)
	public ModelAndView queryBreed(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerBreedView1");
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/loadBreed", method = RequestMethod.POST)
	public ModelAndView loadBreed(@RequestParam(value="fid") Long fid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response) {

		int totalNumber = farmerBreedService.findTotalNumberByFarmerId(fid);
		List<FarmerBreed> breeds = farmerBreedService.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, fid);
		Map map = new HashMap();
		map.put("total", totalNumber);
		map.put("data", breeds);
		String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer;
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
	
	@RequestMapping(value="/loadAllBreed",method=RequestMethod.POST)
	public ModelAndView loadAllCompany(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		//查询条件
		
		String farmerName = request.getParameter("farmerName");
	    String farmerIdNum=request.getParameter("farmerIdNum");
	    String variety=request.getParameter("variety");
	    String recorder=request.getParameter("recorder");
	    String recordTimeBegin=request.getParameter("recordTimeBegin");
	    String recordTimeEnd=request.getParameter("recordTimeEnd");
	    
	    Map<String,String> query = new HashMap<String,String>();
	    query.put("farmerName", farmerName);
	    query.put("farmerIdNum", farmerIdNum);
	    query.put("variety", variety);
	    query.put("recorder", recorder);
	    query.put("recordTimeBegin", recordTimeBegin);
	    query.put("recordTimeEnd", recordTimeEnd);
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    List<FarmerBreed> data = farmerBreedService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, query);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	@RequestMapping(value="/typeInBreed",method=RequestMethod.GET)
	public ModelAndView typeInBreed(@RequestParam(value="fid") String fid, 
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
		ModelAndView view = new ModelAndView("/farmer/farmerBreedForm1");
		view.addObject("farmer",farmer);
		return view;
	}
	
}
