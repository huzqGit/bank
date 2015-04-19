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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerMember;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerService;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerController {
	
	@Resource
	private IFarmerService farmerService;
	
	@RequestMapping(value = "/saveFarmer",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

		String basicData = request.getParameter("basic");
		String memberData=request.getParameter("member");
		//這裡做了時間格式的處理
		Object basicJsonData = JsonUtil.Decode(basicData);
		basicData = JSON.toJSONStringWithDateFormat(basicJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject basic = JSONObject.parseObject(basicData);
		Farmer farmer = (Farmer) JSON.toJavaObject(basic, Farmer.class);
		//
		Object memberJsonData = JsonUtil.Decode(memberData);
		memberData = JSON.toJSONStringWithDateFormat(memberJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		List<FarmerMember> members = (List<FarmerMember>) JSON.parseArray(memberData, FarmerMember.class);
		farmerService.saveFarmer(farmer, members);
		Map map = new HashMap();
		map.put("farmer",farmer);
		map.put("member", members);
		String json = JSON.toJSONString(map);
		System.out.println(json);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
		
	}
	
	@RequestMapping(value = "/loadFarmer", method = RequestMethod.POST)
	public ModelAndView loadCompany(@RequestParam(value="id",required=true) String id, 
			HttpServletResponse response) throws Exception {
		if(!StringUtils.isEmpty(id)){
			Long farmerId=Long.valueOf(id);
			Farmer farmer = farmerService.findByPK(farmerId);
			String json = JsonUtil.Encode(farmer);
			response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
		
	}
	
	@RequestMapping(value="/loadAllFarmer",method=RequestMethod.POST)
	public ModelAndView loadAllCompany(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		//查询条件
	    String farmerName = request.getParameter("farmerName");
	    String farmerIdNum=request.getParameter("farmerIdNum");
	    String recorder=request.getParameter("recorder");
	    String recordTimeBegin=request.getParameter("recordTimeBegin");
	    String recordTimeEnd=request.getParameter("recordTimeEnd");
	    
	    Map<String,String> query = new HashMap<String,String>();
	    query.put("companyName", farmerName);
	    query.put("organCode", farmerIdNum);
	    query.put("recorder", recorder);
	    query.put("recordTimeBegin", recordTimeBegin);
	    query.put("recordTimeEnd", recordTimeEnd);
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    List<Farmer> data = farmerService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, query);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
}
