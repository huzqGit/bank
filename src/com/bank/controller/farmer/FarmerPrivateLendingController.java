package com.bank.controller.farmer;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
import com.bank.beans.FarmerExample;
import com.bank.beans.FarmerPrivateLending;
import com.bank.beans.FarmerPrivateLendingExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.FarmerPrivateLendingEnum;
import com.bank.service.IFarmerPrivateLendingService;
import com.bank.service.IFarmerService;
import com.bank.utils.ParseDataUtils;
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
				User user  = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				privateLending.setSourcecode(organ.getOrganNo());
				privateLending.setSourcename(organ.getOrganName());
				privateLending.setRunitid(organ.getOrganId());
				privateLending.setRunitname(organ.getOrganName());
				privateLending.setRecorder(user.getUserId());
				privateLending.setRecordtime(new Date());
				farmerPrivateLendingService.save(privateLending);
			}else{
				farmerPrivateLendingService.update(privateLending);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fec = fe.createCriteria();
		fec.andFarmeridnumEqualTo(privateLending.getFarmeridnum());
		fec.andRunitidEqualTo(privateLending.getRunitid());
		List<Farmer> farmers = farmerService.selectByExample(fe);
		if(farmers.size() == 1){
			ModelAndView view = new ModelAndView("/farmer/farmerPrivateLendingView");
			view.addObject("farmer",farmers.get(0));
			return view;
		}else{
			return null;
		}
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
	public ModelAndView queryPrivateLendingByPaging(@RequestParam(value="farmeridnum") String farmeridnum,
			@RequestParam(value="runitid") String runitid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
		
		FarmerPrivateLendingExample fpe = new FarmerPrivateLendingExample();
		FarmerPrivateLendingExample.Criteria fpec = fpe.createCriteria();
		fpec.andFarmeridnumEqualTo(farmeridnum);
		fpec.andRunitidEqualTo(runitid);
		int toatalNumber = farmerPrivateLendingService.countByExample(fpe);
		
		Map paramMap = new HashMap();
		paramMap.put("farmeridnum", farmeridnum);
		paramMap.put("runitid", runitid);
		
		List<FarmerPrivateLending> lendings = null;
		try {
			lendings = farmerPrivateLendingService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	@RequestMapping(value="/importFarmerPrivateLending",method=RequestMethod.POST)
	public ModelAndView importFarmerPrivateLending(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
			HttpServletRequest request,HttpServletResponse response){
		String[][] data = null;
		Organ organ = (Organ)request.getSession().getAttribute("unit");
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String recorder = user.getUserId();
		Date recordTime = new Date();
		List<Map<String,String>> msgs =  null;
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
			msgs = importFarmerPrivateLendingBZ(organId,organName,recorder,recordTime,data);
		}
		ModelAndView view = new ModelAndView("farmer/farmerPrivateLendingImporter");
		view.addObject("msgs",msgs);
		return view;
		
	}
	private List<Map<String,String>> importFarmerPrivateLendingBZ(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for(int row = 1;row<data.length;row++){
			FarmerPrivateLending lending = new FarmerPrivateLending();
			lending.setSourcecode("TYCJ");
			lending.setSourcename("统一采集小组");
			lending.setRunitid(organId);
			lending.setRunitname(organName);
			lending.setRecorder(recorder);
			lending.setRecordtime(recordTime);
			String farmerIdNum = data[row][FarmerPrivateLendingEnum.FARMERIDNUM.getIndex()];
			lending.setFarmeridnum(farmerIdNum);
			if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "身份证号不能为空!");
				msgs.add(msg);
				continue;
			}
			String amount = data[row][FarmerPrivateLendingEnum.AMOUNT.getIndex()];
			if(StringUtils.isEmpty(amount)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "贷款金额不能为空");
				msgs.add(msg);
				continue;
			}else{
				try{
					lending.setAmount(Double.valueOf(amount));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("tip", "info");
					msg.put("msg", "贷款金额必须为数字!");
					msgs.add(msg);
					continue;
				}
			}
			String rate = data[row][FarmerPrivateLendingEnum.RATE.getIndex()];
			if(StringUtils.isEmpty(rate)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "月利率不能为空!");
				msgs.add(msg);
				continue;
			}else{
				try{
					lending.setRate(Double.valueOf(rate));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "月利率必须为数字!");
					msgs.add(msg);
					continue;
				}
			}
			String lendingTime = data[row][FarmerPrivateLendingEnum.LENDINGTIME.getIndex()];
			if(StringUtils.isEmpty(lendingTime)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "贷款日期不能为空!");
				msgs.add(msg);
				continue;
			}else{
				try {
					lending.setLendingtime(format.parse(lendingTime));
				} catch (ParseException e) {
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("row", String.valueOf(row));
					msg.put("tip", "info");
					msg.put("msg", "贷款日期必须为日期格式,如2015-05-10!");
					msgs.add(msg);
					continue;
				}
			}
			String limitTime = data[row][FarmerPrivateLendingEnum.LIMITTIME.getIndex()];
			if(StringUtils.isEmpty(limitTime)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "到期日期不能为空!");
				msgs.add(msg);
				continue;
			}else{
				try {
					lending.setLimittime(format.parse(limitTime));
				} catch (ParseException e) {
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "到期日期必须为日期格式,如2015-05-10!");
					msgs.add(msg);
					continue;
				}
			}
			if(limitTime.compareTo(lendingTime)<0){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "到期日期必须大于贷款日期");
				msgs.add(msg);
				continue;
			}
			FarmerPrivateLendingExample fple = new FarmerPrivateLendingExample();
			FarmerPrivateLendingExample.Criteria fplec= fple.createCriteria();
			fplec.andFarmeridnumEqualTo(farmerIdNum);
			fplec.andAmountEqualTo(lending.getAmount());
			fplec.andRateEqualTo(lending.getRate());
			fplec.andLendingtimeEqualTo(lending.getLendingtime());
			fplec.andLimittimeEqualTo(lending.getLendingtime());
			List<FarmerPrivateLending> lendings = farmerPrivateLendingService.selectByExample(fple);
			if(lendings.size()==0){
				try {
					farmerPrivateLendingService.save(lending);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return msgs;
	}
}
