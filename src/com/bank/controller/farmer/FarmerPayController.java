package com.bank.controller.farmer;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerIncome;
import com.bank.beans.FarmerPay;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerPayService;
import com.bank.service.IFarmerService;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerPayController {
	
	@Resource
	private IFarmerService farmerService;
	
	@Resource
	private IFarmerPayService farmerPayService;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/saveBalance",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
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
	
	@RequestMapping(value = "/loadPay", method = RequestMethod.POST)
	public ModelAndView loadBalance(@RequestParam(value="id",required=true) String id, 
			HttpServletResponse response) throws Exception {
		if(!StringUtils.isEmpty(id)){
			Long payId=Long.valueOf(id);
			FarmerPay farmer = farmerPayService.findByPK(payId);
			String json = JsonUtil.Encode(farmer);
			response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
		
	}
	@RequestMapping(value = "/typeInBalance", method = RequestMethod.POST)
	public ModelAndView TypeinBalance(@RequestParam(value="year") String year, 
			@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum,
			HttpServletResponse response) throws Exception {
		
		if(StringUtils.isEmpty(year) && StringUtils.isEmpty(farmerName) && StringUtils.isEmpty(farmerIdNum)){
			//身份证号码不能为空
			ModelAndView view = new ModelAndView("/farmer/farmerBalanceInfoView");
			view.addObject("msg","请您填写完农户姓名和身份证号码后录入收支信息!");
			return view;
		}
		List<Farmer> farmers = farmerService.findByIDAndName(farmerIdNum, farmerName);
		if(farmers.size() == 0){
			ModelAndView view = new ModelAndView("/farmer/farmerBalanceInfoView");
			view.addObject("msg","未找到匹配的农户信息!您可以到【农户】-【数据采集】-【基本信息】模块中录入农户信息后再录入农户的资产信息!");
			return view;
		}else if(farmers.size() == 1){
			Farmer farmer = farmers.get(0);
			List<FarmerPay> balances=farmerPayService.loadPayByDateAndFarmer(farmer.getId(), year);
			if(balances.size() == 0){
				if(StringUtils.isEmpty(year)){
					ModelAndView view = new ModelAndView("/farmer/farmerBalanceInfoView");
					view.addObject("year",year);
					view.addObject("farmerIdNum",farmerIdNum);
					view.addObject("farmerName",farmerName);
					view.addObject("msg", "未找到对应的收支信息!您可以填写完年份后再录入收支信息");
					return view;	
				}else{
					FarmerPay balance = new FarmerPay();
					balance.setFarmerId(farmer.getId());
					balance.setYear(year);
					List<FarmerIncome> incomes =new ArrayList<FarmerIncome>();
					incomes.add(new FarmerIncome());
					ModelAndView view = new ModelAndView("/farmer/farmerBalanceForm");
					view.addObject("farmer",farmer);
					view.addObject("balance",balance);
					view.addObject("incomes",incomes);
					return view;	
				}
			
			}else if(balances.size() == 1){
				FarmerPay balance = balances.get(0);
				List<FarmerIncome> incomes =farmerPayService.loadTotalIncome(balance.getId());
				ModelAndView view = new ModelAndView("/farmer/farmerBalanceForm");
				view.addObject("farmer",farmer);
				view.addObject("balance",balance);
				view.addObject("incomes",incomes);
				return view;
			}else{
				ModelAndView view = new ModelAndView("/farmer/farmerBalanceView");
				return view;
			}
		}else{
			ModelAndView view = new ModelAndView("/farmer/farmerBalanceInfoView");
			view.addObject("msg", "找到多个农户信息!");
			return view;
		}
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
