package com.bank.controller.farmer;

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
import com.bank.beans.FarmerIncome;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerIncomeService;

@Controller
@RequestMapping(value = "/farmerIncome")
public class FarmerIncomeController {
	
	@Resource
	private IFarmerIncomeService farmerIncomeService;
	
	@RequestMapping(value = "/saveFarmerIncome",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

		String formData = request.getParameter("formData");
		//這裡做了時間格式的處理
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		FarmerIncome farmerIncome = (FarmerIncome) JSON.toJavaObject(jsb, FarmerIncome.class);
		if(farmerIncome.getId()!=null){
			farmerIncomeService.update(farmerIncome);
		}else{
			farmerIncomeService.save(farmerIncome);
		}
		String json = JSON.toJSONString(farmerIncome);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
		
	}
	
	@RequestMapping(value = "/loadFarmer", method = RequestMethod.POST)
	public ModelAndView loadCompany(@RequestParam(value="farmerId",required=true) String farmerId, 
			HttpServletResponse response) throws Exception {
		if(StringUtils.isEmpty(farmerId)){
			Long id=Long.valueOf(farmerId);
			FarmerIncome farmerIncome = farmerIncomeService.findByPK(id);
			String json = JsonUtil.Encode(farmerIncome);
			response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
		
	}
	
	@RequestMapping(value="/loadAllFarmers",method=RequestMethod.POST)
	public ModelAndView loadAllCompany(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		//查询条件
		
	    String companyName = request.getParameter("companyName");
	    String organCode=request.getParameter("organCode");
	    String creditCode=request.getParameter("creditCode");
	    String recorder=request.getParameter("recorder");
	    String recordTimeBegin=request.getParameter("recordTimeBegin");
	    String recordTimeEnd=request.getParameter("recordTimeEnd");
	    
	    Map<String,String> query = new HashMap<String,String>();
	    query.put("companyName", companyName);
	    query.put("organCode", organCode);
	    query.put("creditCode", creditCode);
	    query.put("recorder", recorder);
	    query.put("recordTimeBegin", recordTimeBegin);
	    query.put("recordTimeEnd", recordTimeEnd);
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    List<FarmerIncome> data = farmerIncomeService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, query);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
}
