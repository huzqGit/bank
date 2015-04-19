package com.bank.controller.company;

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
import com.bank.beans.CompanyEmployee;
import com.bank.beans.CompanyInvest;
import com.bank.common.util.JsonUtil;
import com.bank.service.ICompanyInvestService;

@Controller
@RequestMapping(value="/company/invest")
public class CompanyInvestController {
	
	@Resource
	private ICompanyInvestService companyInvestService;
	
	@RequestMapping(value = "/saveInvest",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

		String formData = request.getParameter("formData");
		//這裡做了時間格式的處理
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		CompanyInvest companyInvest = (CompanyInvest) JSON.toJavaObject(jsb, CompanyInvest.class);
		if(companyInvest.getInvestAmount()!=null){
			companyInvestService.save(companyInvest);
		}else{
			companyInvestService.update(companyInvest);
		}
		String json = JSON.toJSONString(companyInvest);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
		
	}
	@RequestMapping(value = "/loadInvest", method = RequestMethod.POST)
	public ModelAndView loadInvest(@RequestParam(value="investId",required=true) String investId, 
			HttpServletResponse response) throws Exception {
		
		if(!StringUtils.isEmpty(investId)){
			
			Long companyInvestId=Long.valueOf(investId);
			CompanyInvest companyInvest = companyInvestService.findByPK(companyInvestId);
			String json = JsonUtil.Encode(companyInvest);
			response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
		
	}
	@RequestMapping(value="/loadInvests",method=RequestMethod.POST)
	public ModelAndView loadInvests(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String companyName =request.getParameter("companyName");
		String organCode=request.getParameter("organCode");
		String investedcompanyName=request.getParameter("investedcompanyName");
		String recorder =request.getParameter("recorder");
		String recordTimeBegin=request.getParameter("recordTimeBegin");
		String recordTimeEnd =request.getParameter("recordTimeEnd");
		
		Map<String,String> query = new HashMap<String,String>();
		query.put("companyName", companyName);
		query.put("organCode", organCode);
		query.put("investedcompanyName", investedcompanyName);
		query.put("recorder", recorder);
		query.put("recordTimeBegin", recordTimeBegin);
		query.put("recordTimeEnd", recordTimeEnd);
		//分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    
	    List<CompanyInvest> companyInvests=companyInvestService.getPageingEntities(
	    			pageIndex, pageSize, sortField, sortOrder, query);
	    HashMap result = new HashMap();
        result.put("data", companyInvests);
        result.put("total", companyInvests.size());
        
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	    
	    return null;
	}
}
