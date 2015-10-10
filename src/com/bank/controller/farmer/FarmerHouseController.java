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
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerExample;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerHouse;
import com.bank.beans.FarmerHouseExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.FarmerHouseBZEnum;
import com.bank.service.IFarmerHouseService;
import com.bank.service.IFarmerService;
import com.bank.utils.ParseDataUtils;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerHouseController {
	
	@Resource
	private IFarmerService farmerService;
	@Resource
	private IFarmerHouseService farmerHouseService;
	
	@RequestMapping(value = "/saveHouse",method = RequestMethod.POST)
	public ModelAndView saveHouse(@ModelAttribute(value="house") FarmerHouse house,
			HttpServletRequest request,HttpServletResponse response){
		
		try{
			if(house.getId() == null){
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				house.setRunitid(organ.getOrganId());
				house.setRunitname(organ.getOrganName());
				house.setSourcecode(organ.getOrganNo());
				house.setSourcename(organ.getOrganName());
				farmerHouseService.save(house);
			}else{
				farmerHouseService.update(house);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fec = fe.createCriteria();
		fec.andFarmeridnumEqualTo(house.getFarmeridnum());
		fec.andRunitidEqualTo(house.getRunitid());
		List<Farmer> farmers = farmerService.selectByExample(fe);
		if(farmers.size() == 1){
			ModelAndView view = new ModelAndView("/farmer/farmerHouseView1");
			view.addObject("farmer",farmers.get(0));
			return view;
		}else{
			return null;
		}
	}
	@RequestMapping(value="/deleteHouse",method=RequestMethod.GET)
	public ModelAndView deleteHouse(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		String fid = request.getParameter("fid");
		Long houseId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		try {
			farmerHouseService.delete(houseId);
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
		ModelAndView view = new ModelAndView("/farmer/farmerHouseView1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/queryCapital",method=RequestMethod.GET)
	public ModelAndView queryCapital(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerCapital");
		Farmer farmer = null;
		List<FarmerHouse> houses = null;
		List<FarmerForest> forests = null;
		List<FarmerBreed> breeds = null;
		List<FarmerDevice>  devices = null;
		try {
			 farmer = farmerService.findByPK(farmerId);
			 houses = farmerHouseService.findHouseByFarmer(farmerId);
			 if(houses.size() == 0){
			    	FarmerHouse house= new FarmerHouse();
			    	houses.add(house);
			 }
			 forests = farmerHouseService.findForestByFarmer(farmerId);
			 if(forests.size() == 0){
				   FarmerForest forest = new FarmerForest();
			       forests.add(forest);
			 }
			 breeds = farmerHouseService.findBreedByFarmer(farmerId);
			 if(breeds.size() == 0){
				   FarmerBreed breed = new FarmerBreed();
			       breeds.add(breed);
			 }
			 devices = farmerHouseService.findDeviceByFarmer(farmerId);
			 if(devices.size() == 0){
				   FarmerDevice device = new FarmerDevice();
			       devices.add(device);
			 }
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.addObject("farmer",farmer);
		view.addObject("houses",houses);
		view.addObject("forests",forests);
		view.addObject("breeds",breeds);
		view.addObject("devices",devices);
		return view;
	}
	@RequestMapping(value="/queryHouse",method=RequestMethod.GET)
	public ModelAndView queryHouse(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerHouseView1");
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
	@RequestMapping(value="/editHouse",method=RequestMethod.GET)
	public ModelAndView editHouse(@RequestParam(value="id") String id,@RequestParam(value="fid") String fid,
			HttpServletRequest request,HttpServletResponse response){
		
		Long houseId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		Farmer farmer = null;
		FarmerHouse house = null;
		try {
			farmer = farmerService.findByPK(farmerId);
			house = farmerHouseService.findByPK(houseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerHouseForm1");
		view.addObject("farmer",farmer);
		view.addObject("house",house);
		return view;
	}
	@RequestMapping(value="/loadChanQuan",method=RequestMethod.GET)
	public ModelAndView loadChanQuan(@RequestParam(value="fid") String fid,
			HttpServletResponse response) throws Exception{
		//查询条件
	   Long farmerId = Long.valueOf(fid);
	   Farmer farmer = farmerService.findByPK(farmerId);
	   List<FarmerHouse> houses = farmerHouseService.findHouseByFarmer(farmerId);
	   if(houses.size() == 0){
	    	FarmerHouse house= new FarmerHouse();
	    	houses.add(house);
	   }
	   List<FarmerForest> forests = farmerHouseService.findForestByFarmer(farmerId);
	   if(forests.size() == 0){
		   FarmerForest forest = new FarmerForest();
	       forests.add(forest);
	   }
	   List<FarmerBreed> breeds = farmerHouseService.findBreedByFarmer(farmerId);
	   if(breeds.size() == 0){
		   FarmerBreed breed = new FarmerBreed();
	       breeds.add(breed);
	   }
	   List<FarmerDevice>  devices = farmerHouseService.findDeviceByFarmer(farmerId);
	   if(devices.size() == 0){
		   FarmerDevice device = new FarmerDevice();
	       devices.add(device);
	   }
	   ModelAndView view = new ModelAndView("/farmer/farmerChanQuanForm");
	   view.addObject("farmer", farmer);
	   view.addObject("houses",houses);
	   view.addObject("forests",forests);
	   view.addObject("breeds",breeds);
	   view.addObject("devices",devices);
	   return view;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/loadHouse", method = RequestMethod.POST)
	public ModelAndView loadHouse(@RequestParam(value="farmeridnum") String farmeridnum,
			@RequestParam(value="runitid") String runitid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response) {
			
			FarmerHouseExample fhe = new FarmerHouseExample();
			FarmerHouseExample.Criteria fhec = fhe.createCriteria();
			fhec.andFarmeridnumEqualTo(farmeridnum);
			fhec.andRunitidEqualTo(runitid);
			
			int totalNumber = farmerHouseService.countByExample(fhe);
			Map paramMap = new HashMap();
			paramMap.put("farmeridnum", farmeridnum);
			paramMap.put("runitid", runitid);
			List<FarmerHouse> houses = null;
			try {
				houses = farmerHouseService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
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
				writer.write(json);
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return null;

	}
	
	@RequestMapping(value="/typeInChanQuan",method=RequestMethod.POST)
	public ModelAndView typeInChanQuan(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		//查询条件
		String farmerName = request.getParameter("farmerName");
	    String farmerIdNum=request.getParameter("farmerIdNum");
	    if(StringUtils.isEmpty(farmerName) && StringUtils.isEmpty(farmerIdNum)){
	    	ModelAndView view = new ModelAndView("/farmer/farmerChanQuanView");
	    	view.addObject("msg","请您填写完农户姓名和身份证号码后录入资产信息!");
	    	return view;
	    }
	   List<Farmer> farmers = farmerService.findByIDAndName(farmerIdNum, farmerName);
	   if(farmers.size() == 0){
		   ModelAndView view = new ModelAndView("/farmer/farmerChanQuanView");
		   view.addObject("farmerName", farmerName);
		   view.addObject("farmerIdNum", farmerIdNum);
	       view.addObject("msg","未找到匹配的农户信息!您可以到【农户】-【数据采集】-【基本信息】模块中录入农户信息后再录入农户的资产信息!");
	       return view;
	   }else{
		   ModelAndView view = new ModelAndView("/farmer/farmerChanQuanView");
		   view.addObject("farmerName", farmerName);
		   view.addObject("farmerIdNum", farmerIdNum);
		   view.addObject("farmers",farmers);
	       return view;
	   }
	}
	@RequestMapping(value="/typeInHouse",method=RequestMethod.GET)
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
		ModelAndView view = new ModelAndView("/farmer/farmerHouseForm1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/importFarmerHouse",method=RequestMethod.POST)
	public ModelAndView importFarmerHouse(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
			HttpServletRequest request,HttpServletResponse response){
		String[][] data = null;
		Organ organ = (Organ)request.getSession().getAttribute("unit");
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String recorder = user.getUserId();
		Date recordTime = new Date();
		List<Map<String,String>> msgs = null;
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
			msgs = importFarmerHouseBZ(organId,organName,recorder,recordTime,data);
		}
		ModelAndView view = new ModelAndView("/farmer/farmerHouseImporter");
		view.addObject("msgs",msgs);
		return view;
	}
	
	private List<Map<String,String>> importFarmerHouseBZ(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row =1;row<data.length;row++){
			FarmerHouse house = new FarmerHouse();
			String farmerIdNum = data[row][FarmerHouseBZEnum.FARMERIDNUM.getIndex()];
			house.setFarmeridnum(farmerIdNum); 
			if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行身份证号码不能为空!");
				msgs.add(msg);
				continue;
			}
			String houseProperty = data[row][FarmerHouseBZEnum.HOUSEPROPERTY.getIndex()];
			house.setHouseproperty(houseProperty);
			String houseType = data[row][FarmerHouseBZEnum.HOUSETYPE.getIndex()];
			house.setHousetype(houseType);
			String houseAddress = data[row][FarmerHouseBZEnum.HOUSEADDRESS.getIndex()];
			if(StringUtils.isEmpty(houseAddress)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行房屋地址不能为空!");
				msgs.add(msg);
				continue;
			}
			String  buildDate = data[row][FarmerHouseBZEnum.BUILDDATE.getIndex()];
			house.setBuilddate(buildDate);
			if(StringUtils.isEmpty(buildDate)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"身构建日期不能为空!");
				msgs.add(msg);
				continue;
			}
			String buildPrice = data[row][FarmerHouseBZEnum.BUILDPRICE.getIndex()];
			house.setBuildprice(buildPrice);
			if(StringUtils.isEmpty(buildDate)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行构建价格不能为空!");
				msgs.add(msg);
				continue;
			}
			String floorArea = data[row][FarmerHouseBZEnum.FLOORAREA.getIndex()];
			house.setFloorarea(floorArea);
			if(StringUtils.isEmpty(floorArea)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行占地面积不能为空!");
				msgs.add(msg);
				continue;
			}
			String assessPrice = data[row][FarmerHouseBZEnum.ASSESSPRICE.getIndex()];
			house.setAssessprice(assessPrice);
			FarmerHouseExample fhe =  new FarmerHouseExample();
			FarmerHouseExample.Criteria fhec = fhe.createCriteria();
			fhec.andFarmeridnumEqualTo(farmerIdNum);
			fhec.andHousepropertyEqualTo(houseProperty);
			fhec.andHousetypeEqualTo(houseType);
			fhec.andBuilddateEqualTo(buildDate);
			fhec.andBuildpriceEqualTo(buildPrice);
			fhec.andHouseaddressEqualTo(houseAddress);
			fhec.andFloorareaEqualTo(floorArea);
			fhec.andAssesspriceEqualTo(assessPrice);
			fhec.andSourcecodeEqualTo("TYCJ");
			List<FarmerHouse> houses = farmerHouseService.selectByExample(fhe);
			if(houses.size() ==0){
				try {
					farmerHouseService.save(house);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			}
		return msgs;
	}
}
