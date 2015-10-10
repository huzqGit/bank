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
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerBreedExample;
import com.bank.beans.FarmerExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.FarmerBreedBZEnum;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerBreedService;
import com.bank.service.IFarmerService;
import com.bank.utils.ParseDataUtils;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerBreedController {
	
	@Resource
	private IFarmerService farmerService;
	
	@Resource
	private IFarmerBreedService farmerBreedService;

	@RequestMapping(value = "/saveBreed1",method = RequestMethod.POST)
	public ModelAndView saveBreed1(@ModelAttribute(value="breed") FarmerBreed breed,
			HttpServletRequest request,HttpServletResponse response){
		try{
			if(breed.getId() ==null){
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				breed.setSourcecode(organ.getOrganNo());
				breed.setSourcename(organ.getOrganName());
				breed.setRunitid(organ.getOrganId());
				breed.setRunitname(organ.getOrganName());
				farmerBreedService.save(breed);
			}else{
				farmerBreedService.update(breed);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fec = fe.createCriteria();
		fec.andFarmeridnumEqualTo(breed.getFarmeridnum());
		fec.andRunitidEqualTo(breed.getRunitid());
		List<Farmer> farmers = farmerService.selectByExample(fe);
		if(farmers.size() == 1){
			ModelAndView view = new ModelAndView("/farmer/farmerBreedView1");
			view.addObject("farmer",farmers.get(0));
			return view;
		}else{
			return null;
		}
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
	public ModelAndView loadBreed(@RequestParam(value="farmeridnum") String farmeridnum,
			@RequestParam(value="runitid") String runitid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response) {
		
		FarmerBreedExample fb = new FarmerBreedExample();
		FarmerBreedExample.Criteria fbc = fb.createCriteria();
		fbc.andFarmeridnumEqualTo(farmeridnum);
		fbc.andRunitidEqualTo(runitid);
		int totalNumber = farmerBreedService.countByExample(fb);
		
		Map paramMap = new HashMap();
		paramMap.put("farmeridnum", farmeridnum);
		paramMap.put("runitid", runitid);
		List<FarmerBreed> breeds = null;
		try {
			breeds = farmerBreedService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	@RequestMapping(value="/importFarmerBreed",method=RequestMethod.POST)
	public ModelAndView importFarmerBreed(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
			HttpServletRequest request,HttpServletResponse response){
		String[][] data = null;
		Organ organ = (Organ)request.getSession().getAttribute("unit");
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String recorder = user.getUserId();
		Date recordTime = new Date();
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
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
			msgs = importFarmerBreedBZ(organId,organName,recorder,recordTime,data);
		}
		ModelAndView view = new ModelAndView("/farmer/farmerBreedImporter");
		view.addObject("msgs",msgs);
		return view;
	}
	
	private List<Map<String,String>> importFarmerBreedBZ(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row = 1;row<data.length;row++){
			FarmerBreed breed = new FarmerBreed();
			String farmerIdNum = data[row][FarmerBreedBZEnum.FARMERIDNUM.getIndex()];
			breed.setFarmeridnum(farmerIdNum);
			if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"身份证号码不能为空。");
				continue;
			}
			String veriety = data[row][FarmerBreedBZEnum.VARIETY.getIndex()];
			breed.setVariety(veriety);
			if(StringUtils.isEmpty(veriety)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"种养殖品种不能为空。");
				continue;
			}
			String output = data[row][FarmerBreedBZEnum.OUTPUT.getIndex()];
			breed.setOutput(output);
			if(StringUtils.isEmpty(output)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"年产量不能为空。");
				continue;
			}
			String floorarea = data[row][FarmerBreedBZEnum.FLOORAREA.getIndex()];
			if(StringUtils.isEmpty(floorarea)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"占地面积不能为空。");
				continue;
			}
			String outputValue = data[row][FarmerBreedBZEnum.OUTPUTVALUE.getIndex()];
			if(StringUtils.isEmpty(outputValue)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"占地面积不能为空。");
				continue;
			}else{
				try{
					breed.setOutputvalue(Double.valueOf(outputValue));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"年平均产值必须为数字");
					continue;
				}
				
			}
			String  assessPrice = data[row][FarmerBreedBZEnum.ASSESSPRICE.getIndex()];
			if(assessPrice.isEmpty()){
				breed.setAssessprice(Double.valueOf(assessPrice));
			}
			FarmerBreedExample fbe = new FarmerBreedExample();
			FarmerBreedExample.Criteria fbec = fbe.createCriteria();
			fbec.andFarmeridnumEqualTo(breed.getFarmeridnum());
			fbec.andVarietyEqualTo(breed.getVariety());
			fbec.andOutputEqualTo(breed.getOutput());
			fbec.andFloorareaEqualTo(breed.getFloorarea());
			fbec.andOutputvalueEqualTo(breed.getOutputvalue());
			fbec.andAssesspriceEqualTo(breed.getAssessprice());
			List<FarmerBreed> breeds = farmerBreedService.selectByExample(fbe);
			if(breeds.size() == 0){
				try {
					farmerBreedService.save(breed);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return msgs;
	}
}
