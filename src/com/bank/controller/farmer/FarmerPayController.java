package com.bank.controller.farmer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerIncome;
import com.bank.beans.FarmerPay;
import com.bank.beans.Organ;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerIncomeService;
import com.bank.service.IFarmerPayService;
import com.bank.service.IFarmerService;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;

@SuppressWarnings("unused")
@Controller
@RequestMapping(value = "/farmer")
public class FarmerPayController {
	
	@Resource
	private IFarmerService farmerService;
	
	@Resource
	private IFarmerPayService farmerPayService;
	
	@Resource
	private IFarmerIncomeService farmerIncomeService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/saveBalance",method = RequestMethod.POST)
	public ModelAndView saveBalance(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		String farmerData= request.getParameter("farmer");
		String balanceData = request.getParameter("balance");
		String incomeData = request.getParameter("income");
		if(StringUtils.isEmpty(farmerData) && StringUtils.isEmpty(balanceData) 
				&& StringUtils.isEmpty(incomeData)){
			//身份证号码不能为空
			return null;
		}
		//农户信息
		Object farmerJsonData = JsonUtil.Decode(farmerData);
		farmerData = JSON.toJSONStringWithDateFormat(farmerJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject farmerJosn = JSONObject.parseObject(farmerData);
		Farmer farmer = (Farmer) JSON.toJavaObject(farmerJosn, Farmer.class);
		
		//年度收支信息
		Object balanceJsonData = JsonUtil.Decode(balanceData);
		balanceData = JSON.toJSONStringWithDateFormat(balanceJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject balanceJosn = JSONObject.parseObject(balanceData);
		FarmerPay balance = (FarmerPay) JSON.toJavaObject(balanceJosn, FarmerPay.class);

		//小微型收入
		Object incomeJsonData = JsonUtil.Decode(incomeData);
		incomeData = JSON.toJSONStringWithDateFormat(incomeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);	
		List<FarmerIncome> income = (List<FarmerIncome>)JSON.parseArray(incomeData, FarmerIncome.class);
		if(farmer.getId() == null){
			//农户信息为空
			return null;
		}
		Farmer dbfarmer = farmerService.findByPK(farmer.getId());
		if(dbfarmer == null){
			//不存在农户信息
			return null;
		}
		farmerPayService.saveBalance(farmer, balance, income);
		Map map = new HashMap();
		map.put("farmer", farmer);
		map.put("balance", balance);
		map.put("income", income);
		String json = JSON.toJSONString(map);
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter writer = response.getWriter();
	    writer.write(json);
	    writer.flush();
		return null;
	}
	@RequestMapping(value="/saveBalance1",method=RequestMethod.POST)
	public ModelAndView saveBalance1(@ModelAttribute(value="balance") FarmerPay balance,
			HttpServletRequest request,HttpServletResponse response)  {
		
		String delIncomes = request.getParameter("deleteIncome");
		if(!StringUtils.isEmpty(delIncomes)){
			String[] incomes = delIncomes.split(",");
			List<Long> incomeIds = new ArrayList<Long>(incomes.length);
			for(String income:incomes){
				incomeIds.add(Long.valueOf(income));
			}
			farmerPayService.deleteIncomes(incomeIds);
		}
	
		try {
			if(balance.getId()==null){
			farmerPayService.save(balance);
			}else{
				farmerPayService.update(balance);
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		List<FarmerIncome> incomes = balance.getIncomes();
		for(FarmerIncome income : incomes){
			income.setPayid(balance.getId());
			try{
				if(income.getId()==null){
					farmerIncomeService.save(income);
				}else{
					farmerIncomeService.update(income);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		Farmer farmer = null;
		try {
			 farmer = farmerService.findByPK(balance.getFarmerid());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerBalanceView");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/editBalance",method=RequestMethod.GET)
	public ModelAndView editBalance(@RequestParam(value="id") String id,@RequestParam(value="fid") String fid,
			HttpServletRequest request,HttpServletResponse response){
		
		Long balanceId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		Farmer farmer = null;
		FarmerPay balance = null;
		List<FarmerIncome> incomes = null;
		try {
			farmer = farmerService.findByPK(farmerId);
			balance = farmerPayService.findByPK(balanceId);
			incomes = farmerPayService.loadTotalIncome(balanceId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ModelAndView view = new ModelAndView("/farmer/farmerBalanceForm1");
		view.addObject("farmer",farmer);
		view.addObject("balance",balance);
		view.addObject("incomes",incomes);
		return view;
	}
	@RequestMapping(value="/deleteBalance",method=RequestMethod.POST)
	public ModelAndView deleteBalance(HttpServletRequest request,HttpServletResponse response){
		
		String id = request.getParameter("id");
		String fid = request.getParameter("fid");
		Long balanceId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		try {
			farmerPayService.delete(balanceId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		ModelAndView view = new ModelAndView("/farmer/farmerBalanceView");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/queryBalance",method=RequestMethod.GET)
	public ModelAndView queryBalance(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerBalanceView");
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
	@RequestMapping(value = "/loadBalance", method = RequestMethod.GET)
	public ModelAndView loadBalance(@RequestParam(value="id",required=true) String id, 
			HttpServletResponse response) throws Exception {
		if(!StringUtils.isEmpty(id)){
			Long payId=Long.valueOf(id);
			FarmerPay balance = farmerPayService.findByPK(payId);
			Farmer farmer = farmerService.findByPK(balance.getFarmerid());
			List<FarmerIncome> incomes = farmerPayService.loadTotalIncome(payId);
			if(incomes.size() ==0 ){
				incomes.add(new FarmerIncome());
			}
			ModelAndView view = new ModelAndView("/farmer/farmerBalanceForm");
			view.addObject("farmer", farmer);
			view.addObject("balance", balance);
			view.addObject("incomes", incomes);
			return view;
		}
		return null;
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/loadBalance1", method = RequestMethod.POST)
	public ModelAndView loadBalance1(@RequestParam(value="fid") Long fid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
		int totalNumber = farmerPayService.findTotalNumberByFarmerId(fid);
		List<FarmerPay> balances = farmerPayService.findPagingByFarmerId(pageIndex, pageSize, sortField, sortOrder, fid);
		Map map= new HashMap();
		map.put("total", totalNumber);
		map.put("data", balances);
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
	@RequestMapping(value="/typeinBalance1",method=RequestMethod.GET)
	public ModelAndView TypeinBalance1(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(farmerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<FarmerIncome> incomes =new ArrayList<FarmerIncome>();
		incomes.add(new FarmerIncome());
		ModelAndView view = new ModelAndView("/farmer/farmerBalanceForm1");
		view.addObject("farmer",farmer);
		view.addObject("incomes",incomes);
		return view;
	}
	
	@RequestMapping(value="/loadAllPay",method=RequestMethod.POST)
	public ModelAndView loadAllCompany(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		//查询条件
		String farmerName = request.getParameter("farmerName");
	    String farmerIdNum=request.getParameter("farmerIdNum");
	    String recorder=request.getParameter("recorder");
	    String recordTimeBegin=request.getParameter("recordTimeBegin");
	    String recordTimeEnd=request.getParameter("recordTimeEnd");
	    
	    Map<String,String> query = new HashMap<String,String>();
	    query.put("farmerName", farmerName);
	    query.put("farmerIdNum", farmerIdNum);
	    query.put("recorder", recorder);
	    query.put("recordTimeBegin", recordTimeBegin);
	    query.put("recordTimeEnd", recordTimeEnd);
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    List<FarmerPay> data = farmerPayService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, query);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
	
}
