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
import com.bank.beans.FarmerPayExample;
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
	
	@RequestMapping(value="/saveBalance1",method=RequestMethod.POST)
	public ModelAndView saveBalance1(@ModelAttribute(value="balance") FarmerPay balance,
			HttpServletRequest request,HttpServletResponse response)  {
		
		String delIncomes = request.getParameter("deleteIncome");
		Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
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
				balance.setRunitid(organ.getOrganId());
				balance.setRunitname(organ.getOrganName());
				balance.setSourcecode(organ.getOrganNo());
				balance.setSourcename(organ.getOrganName());
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
	public ModelAndView loadBalance1(@RequestParam(value="farmeridnum") String farmeridnum, 
			@RequestParam(value="runitid") String runitid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
		FarmerPayExample fpe = new FarmerPayExample();
		FarmerPayExample.Criteria fpec = fpe.createCriteria();
		fpec.andFarmeridnumEqualTo(farmeridnum);
		fpec.andRunitidEqualTo(runitid);
		int totalNumber = farmerPayService.countByExample(fpe);
		
		Map paramMap = new HashMap();
		paramMap.put("farmeridnum", farmeridnum);
		paramMap.put("runitid", runitid);
		List<FarmerPay> balances = null;
		try {
			balances = farmerPayService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
