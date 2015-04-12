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
import com.bank.beans.FarmerForest;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerForestService;

@Controller
@RequestMapping(value = "/farmer/forest")
public class FarmerForestController {
	
	@Resource
	private IFarmerForestService farmerForestService;
	
	@RequestMapping(value = "/saveForest",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

		String formData = request.getParameter("formData");
		//這裡做了時間格式的處理
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		FarmerForest farmerForest = (FarmerForest) JSON.toJavaObject(jsb, FarmerForest.class);
		if(farmerForest.getId()!=null){
			farmerForestService.update(farmerForest);
		}else{
			farmerForestService.save(farmerForest);
		}
		String json = JSON.toJSONString(farmerForest);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
		
	}
	
	@RequestMapping(value = "/loadForest", method = RequestMethod.POST)
	public ModelAndView loadCompany(@RequestParam(value="id",required=true) String id, 
			HttpServletResponse response) throws Exception {
		if(StringUtils.isEmpty(id)){
			Long forestId=Long.valueOf(id);
			FarmerForest farmerForest = farmerForestService.findByPK(forestId);
			String json = JsonUtil.Encode(farmerForest);
			response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
		
	}
	
	@RequestMapping(value="/loadAllForests",method=RequestMethod.POST)
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
	    List<FarmerForest> data = farmerForestService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, query);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
}
