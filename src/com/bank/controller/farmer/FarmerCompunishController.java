package com.bank.controller.farmer;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerCompunishExample;
import com.bank.beans.FarmerExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.FarmerCompunishBZEnum;
import com.bank.service.IFarmerCompunishService;
import com.bank.service.IFarmerService;
import com.bank.utils.ParseDataUtils;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerCompunishController {
	
	@Resource
	private IFarmerService farmerService;
	@Resource
	private IFarmerCompunishService farmerCompunishService;
	
	@RequestMapping(value = "/saveCompunish1",method = RequestMethod.POST)
	public ModelAndView saveCompunish1(@ModelAttribute(value="compunish") FarmerCompunish compunish,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		if(compunish.getId()==null){
			Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
			compunish.setSourcecode(organ.getOrganNo());
			compunish.setSourcename(organ.getOrganName());
			compunish.setRunitid(organ.getOrganId());
			compunish.setRunitname(organ.getOrganName());
			farmerCompunishService.save(compunish);
		}else{
			farmerCompunishService.update(compunish);
		}
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fec = fe.createCriteria();
		fec.andFarmeridnumEqualTo(compunish.getFarmeridnum());
		fec.andRunitidEqualTo(compunish.getRunitid());
		List<Farmer> farmers = farmerService.selectByExample(fe);
		if(farmers.size() == 1){
			ModelAndView view = new ModelAndView("/farmer/farmerCompunishView1");
			view.addObject("farmer",farmers.get(0));
			return view;
		}else{
			return null;
		}
	}
	@RequestMapping(value="/queryCompunish",method=RequestMethod.GET)
	public ModelAndView queryCompunish(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerCompunishView1");
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
	@RequestMapping(value="/deleteCompunish",method=RequestMethod.GET)
	public ModelAndView deleteCompunish(HttpServletRequest request,HttpServletResponse response){
		
		String id = request.getParameter("id");
		String fid = request.getParameter("fid");
		Long compunishId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		try {
			farmerCompunishService.delete(compunishId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Farmer farmer = null;
		try {
			 farmer = farmerService.findByPK(farmerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerCompunishView1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/editCompunish",method=RequestMethod.GET)
	public ModelAndView editCompunish(@RequestParam(value="id") String id,@RequestParam(value="fid") String fid,
			HttpServletRequest request,HttpServletResponse response){
		
		Long compunishId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		Farmer farmer = null;
		FarmerCompunish compunish = null;
		try {
			farmer = farmerService.findByPK(farmerId);
			compunish = farmerCompunishService.findByPK(compunishId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerCompunishForm1");
		view.addObject("farmer",farmer);
		view.addObject("compunish",compunish);
		return view;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/loadCompunish",method=RequestMethod.POST)
	public ModelAndView loadCompunish(@RequestParam(value="farmeridnum") String farmeridnum,
			@RequestParam(value="runitid") String runitid,
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
		
		FarmerCompunishExample fce = new FarmerCompunishExample();
		FarmerCompunishExample.Criteria fcec = fce.createCriteria();
		fcec.andFarmeridnumEqualTo(farmeridnum);
		fcec.andRunitidEqualTo(runitid);
		int totalNumber = farmerCompunishService.countByExample(fce);
		Map paramMap = new HashMap();
		paramMap.put("farmeridnum", farmeridnum);
		paramMap.put("runitid", runitid);
		List<FarmerCompunish> compunishs = null;
		try {
			compunishs = farmerCompunishService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map map = new HashMap();
		map.put("total", totalNumber);
		map.put("data", compunishs);
		String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadJiangCheng", method = RequestMethod.GET)
	public ModelAndView loadCompany(@RequestParam(value="fid") String fid, 
			HttpServletResponse response) throws Exception {
		Long farmerId =Long.valueOf(fid);
		Farmer farmer = farmerService.findByPK(farmerId);
		List<FarmerCompunish> compunishs = farmerCompunishService.getCompunishByFarmer(farmerId);
		if(compunishs.size() == 0){
			compunishs.add(new FarmerCompunish());
		}
		ModelAndView view = new ModelAndView("/farmer/farmerJiangChengForm");
		view.addObject("farmer",farmer);
		view.addObject("compunishs",compunishs);
		return view;
	}
	
	@RequestMapping(value="/typeInJiangCheng",method=RequestMethod.POST)
	public ModelAndView typeInJiangCheng(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum,  
			HttpServletResponse response) throws Exception{
		if(StringUtils.isEmpty(farmerName) && StringUtils.isEmpty(farmerIdNum)){
			ModelAndView view = new ModelAndView("/farmer/farmerJiangChengView");
			view.addObject("msg","请您填写完农户姓名和身份证号码后录入资产信息!!");
			return view;
		}
		List<Farmer> farmers = farmerService.findByIDAndName(farmerIdNum, farmerName);
		if(farmers.size() == 0){
			ModelAndView view = new ModelAndView("/farmer/farmerJiangChengView");
			view.addObject("farmerName", farmerName);
			view.addObject("farmerIdNum", farmerIdNum);
			view.addObject("msg","未找到匹配的农户信息!您可以到【农户】-【数据采集】-【基本信息】模块中录入农户信息后再录入农户的资产信息!");
			return view;
		}else{
			ModelAndView view = new ModelAndView("/farmer/farmerJiangChengView");
			view.addObject("farmerName", farmerName);
			view.addObject("farmerIdNum", farmerIdNum);
			view.addObject("farmers",farmers);
			return view;
		}
	}
	@RequestMapping(value="/typeInCompunish1",method=RequestMethod.GET)
	public ModelAndView typeCompunish1(@RequestParam(value="fid") String fid, 
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
		ModelAndView view = new ModelAndView("/farmer/farmerCompunishForm1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/importFarmerCompunish",method=RequestMethod.POST)
	public ModelAndView importFarmerCompunish(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
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
			msgs = importFarmerCompunishBZ(organId,organName,recorder,recordTime,data);
		}
		ModelAndView view = new ModelAndView("/farmer/farmerCompunishImporter");
		view.addObject("msgs",msgs);
		return view;
	}
	private List<Map<String,String>> importFarmerCompunishBZ(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row =1;row<data.length;row++){
		   FarmerCompunish compunish = new FarmerCompunish();
		   String farmerIdNum = data[row][FarmerCompunishBZEnum.FARMERIDNUM.getIndex()];
		   compunish.setFarmeridnum(farmerIdNum);
		   if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"身份证号码不能为空");
				continue;
			}
		   String type = data[row][FarmerCompunishBZEnum.TYPE.getIndex()];
		   if(StringUtils.isEmpty(type)){
			   Map<String,String> msg = new HashMap<String,String>();
			   msg.put("msg", "第"+row+"表彰或处罚类型不能为空");
			continue;
		   }else {
			   compunish.setType(Integer.valueOf(type));
		   }
		   String organ = data[row][FarmerCompunishBZEnum.ORGAN.getIndex()];
		   compunish.setOrgan(organ);
		   if(StringUtils.isEmpty(organ)){
			   Map<String,String> msg = new HashMap<String,String>();
			   msg.put("msg", "第"+row+"表彰或处罚部门不能为空");
			   continue;
		   }
		   String occurTime = data[row][FarmerCompunishBZEnum.OCCURTIME.getIndex()];
		   if(StringUtils.isEmpty(occurTime)){
			   Map<String,String> msg = new HashMap<String,String>();
			   msg.put("msg", "第"+row+"表彰或处罚时间不能为空");
			   continue;
		   }else {
			   try {
				   compunish.setOccurtime(format.parse(occurTime));
				} catch (ParseException e) {
					  Map<String,String> msg = new HashMap<String,String>();
					  msg.put("msg", "第"+row+"日期格式不正确");
					  continue;
				}
		   }
		   String compunishLevel = data[row][FarmerCompunishBZEnum.COMPUNISHLEVEL.getIndex()];
		   if(StringUtils.isEmpty(compunishLevel)){
			   Map<String,String> msg = new HashMap<String,String>();
			   msg.put("msg", "第"+row+"表彰或处罚等级不能为空");
			   continue;
		   }else{
			   compunish.setCompunishlevel(Integer.valueOf(compunishLevel));
		   }
		   String detail = data[row][FarmerCompunishBZEnum.DETAIL.getIndex()];
		   compunish.setDetail(detail);
		   FarmerCompunishExample fce = new FarmerCompunishExample();
		   FarmerCompunishExample.Criteria fcec = fce.createCriteria();
		   fcec.andFarmeridnumEqualTo(compunish.getFarmeridnum());
		   fcec.andTypeEqualTo(compunish.getType());
		   fcec.andOrganEqualTo(compunish.getOrgan());
		   fcec.andOccurtimeEqualTo(compunish.getOccurtime());
		   fcec.andCompunishlevelEqualTo(compunish.getCompunishlevel());
		   fcec.andDetailEqualTo(compunish.getDetail());
		   List<FarmerCompunish> compunishs = farmerCompunishService.selectByExample(fce);
		   if(compunishs.size()== 0){
			   try {
				   farmerCompunishService.save(compunish);
			   } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }
		   }
		}
		return msgs;
	}
}
