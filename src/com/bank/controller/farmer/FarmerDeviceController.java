package com.bank.controller.farmer;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerDeviceExample;
import com.bank.beans.FarmerExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.FarmerDeviceBZEnum;
import com.bank.service.IFarmerDeviceService;
import com.bank.service.IFarmerService;
import com.bank.utils.ParseDataUtils;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerDeviceController {
	
	@Resource
	private IFarmerService farmerService;
	
	@Resource
	private IFarmerDeviceService farmerDeviceService;
	
	@RequestMapping(value = "/saveDevice1",method = RequestMethod.POST)
	public ModelAndView saveDevice(@ModelAttribute(value="device") FarmerDevice device,
			HttpServletRequest request,HttpServletResponse response){
		
		try{
			if(device.getId() == null){
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				device.setRunitid(organ.getOrganId());
				device.setRunitname(organ.getOrganName());
				device.setSourcecode(organ.getOrganNo());
				device.setSourcename(organ.getOrganName());
				farmerDeviceService.save(device);
			}else{
				farmerDeviceService.update(device);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fec = fe.createCriteria();
		fec.andFarmeridnumEqualTo(device.getFarmeridnum());
		fec.andRunitidEqualTo(device.getRunitid());
		List<Farmer> farmers = farmerService.selectByExample(fe);
		if(farmers.size() == 1){
			ModelAndView view = new ModelAndView("/farmer/farmerDeviceView1");
			view.addObject("farmer",farmers.get(0));
			return view;
		}else{
			return null;
		}
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
	public ModelAndView loadDevice(@RequestParam(value="farmeridnum") String farmeridnum,
			@RequestParam(value="runitid") String runitid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response) {
	
			FarmerDeviceExample fde = new FarmerDeviceExample();
			FarmerDeviceExample.Criteria fdec = fde.createCriteria();
			fdec.andFarmeridnumEqualTo(farmeridnum);
			fdec.andRunitidEqualTo(runitid);
			int totalNumber = farmerDeviceService.countByExample(fde);
			Map paramMap = new HashMap();
			paramMap.put("farmeridnum", farmeridnum);
			paramMap.put("runitid", runitid);
			List<FarmerDevice> devices = null;
			try {
				devices = farmerDeviceService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
			} catch (DAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

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
	@RequestMapping(value="/importFarmerDevice",method=RequestMethod.POST)
	public ModelAndView importFarmerDevice(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
			HttpServletRequest request,HttpServletResponse response){
		String[][] data = null;
		Organ organ = (Organ)request.getSession().getAttribute("unit");
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String recorder = user.getUserId();
		Date recordTime = new Date();
		List<Map<String,String>> msgs = null;
		//异常输入流及不可解析的文件格式
		try{
			 InputStream in = myfile.getInputStream();
			 if( myfile.getOriginalFilename().endsWith(".xls")){
				 data = ParseDataUtils.readXls(in, 0);
			 }else{
				 data = ParseDataUtils.readXlsx(in, 0);
			 }
		}catch(IOException e){
			Map<String,String> msg = new HashMap<String,String>();
			msg.put("row", String.valueOf(1));
			msg.put("tip", "error");
			msg.put("msg", "不支持的");
		}
		if("TYCJ".equals(sourcecode)){
			msgs = importFarmerForestBZ(organId,organName,recorder,recordTime,data);
		}
		ModelAndView view = new ModelAndView("/farmer/farmerForestImporter");
		view.addObject("msgs", msgs);
		return view;
	}
	private List<Map<String,String>> importFarmerForestBZ(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row =1;row<data.length;row++){
			FarmerDevice device = new FarmerDevice();
			device.setSourcecode("TYCJ");
			device.setSourcename("统一采集小组");
			device.setRunitid(organId);
			device.setRunitname(organName);
			device.setRecorder(recorder);
			device.setRecordtime(recordTime);
			String farmerIdNum = data[row][FarmerDeviceBZEnum.FARMERIDNUM.getIndex()];
			device.setFarmeridnum(farmerIdNum);
			if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行身份证号不能为空。");
				msgs.add(msg);
				continue;
			}
			String name = data[row][FarmerDeviceBZEnum.NAME.getIndex()];
			device.setName(name);
			if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行设备名称不能为空。");
				msgs.add(msg);
				continue;
			}
			String brand = data[row][FarmerDeviceBZEnum.BRAND.getIndex()];
			device.setBrand(brand);
			String buyingPirce = data[row][FarmerDeviceBZEnum.BUYINGPRICE.getIndex()];
			if(StringUtils.isEmpty(buyingPirce)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行购买价格不能为空。");
				msgs.add(msg);
				continue;
			}
			String buyingDate = data[row][FarmerDeviceBZEnum.BUYINGDATE.getIndex()];
			if(StringUtils.isEmpty(buyingDate)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行购买日期不能为空。");
				msgs.add(msg);
				continue;
			}
			String buyingPrice = data[row][FarmerDeviceBZEnum.BUYINGPRICE.getIndex()];
			String assessPrice = data[row][FarmerDeviceBZEnum.ASSESSPRICE.getIndex()];
			FarmerDeviceExample fde = new FarmerDeviceExample();
			FarmerDeviceExample.Criteria fdec = fde.createCriteria();
			fdec.andFarmeridnumEqualTo(farmerIdNum);
			fdec.andNameEqualTo(name);
			fdec.andBrandEqualTo(brand);
			fdec.andBuyingdateEqualTo(buyingDate);
			fdec.andBuyingpriceEqualTo(buyingPrice);
			fdec.andAssesspriceEqualTo(assessPrice);
			fdec.andSourcecodeEqualTo("TYCJ");
			List<FarmerDevice> deivices = farmerDeviceService.selectByExample(fde);
			if(deivices.size() == 0){
				try {
					farmerDeviceService.save(device);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return msgs;
	}
}
