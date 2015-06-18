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
import com.bank.beans.FarmerDevice;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerDeviceService;
import com.bank.service.IFarmerService;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerDeviceController {
	
	@Resource
	private IFarmerService farmerService;
	
	@Resource
	private IFarmerDeviceService farmerDeviceService;
	
	@RequestMapping(value = "/saveDevice",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

		String formData = request.getParameter("formData");
		//這裡做了時間格式的處理
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		FarmerDevice FarmerDevice = (FarmerDevice) JSON.toJavaObject(jsb, FarmerDevice.class);
		if(FarmerDevice.getId()!=null){
			farmerDeviceService.update(FarmerDevice);
		}else{
			farmerDeviceService.save(FarmerDevice);
		}
		String json = JSON.toJSONString(FarmerDevice);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
		
	}
	
	@RequestMapping(value = "/saveDevice1",method = RequestMethod.POST)
	public ModelAndView saveHouse(@ModelAttribute(value="device") FarmerDevice device,
			HttpServletRequest request,HttpServletResponse response){
		
		try{
			if(device.getId() == null){
				farmerDeviceService.save(device);
			}else{
				farmerDeviceService.update(device);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(device.getFarmerId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		ModelAndView view = new ModelAndView("/farmer/farmerDeviceView1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/deleteDevice",method=RequestMethod.GET)
	public ModelAndView deleteHouse(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		String fid = request.getParameter("fid");
		Long deviceId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		try {
			farmerDeviceService.delete(deviceId);
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
		ModelAndView view = new ModelAndView("/farmer/farmerDeviceView1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/editDevice",method=RequestMethod.GET)
	public ModelAndView editDevice(@RequestParam(value="id") String id,@RequestParam(value="fid") String fid,
			HttpServletRequest request,HttpServletResponse response){
		
		Long deviceId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		Farmer farmer = null;
		FarmerDevice device = null;
		try {
			farmer = farmerService.findByPK(farmerId);
			device = farmerDeviceService.findByPK(deviceId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerDeviceForm1");
		view.addObject("farmer",farmer);
		view.addObject("device",device);
		return view;
	}
	@RequestMapping(value="/queryDevice",method=RequestMethod.GET)
	public ModelAndView queryDevice(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerDeviceView1");
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
	@RequestMapping(value = "/loadDevice", method = RequestMethod.POST)
	public ModelAndView loadDevice(@RequestParam(value="fid") Long fid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response) {
	
			int totalNumber = farmerDeviceService.findTotalNumberByFarmerId(fid);
			List<FarmerDevice> devices = farmerDeviceService.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, fid);
			Map map = new HashMap();
			map.put("total", totalNumber);
			map.put("data", devices);
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
	@RequestMapping(value="/typeInDevice",method=RequestMethod.GET)
	public ModelAndView typeInDevice(@RequestParam(value="fid") String fid, 
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
		ModelAndView view = new ModelAndView("/farmer/farmerDeviceForm1");
		view.addObject("farmer",farmer);
		return view;
	}
	
}
