package com.bank.controller.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.beans.CompanyEmployee;
import com.bank.common.util.JsonUtil;
import com.bank.service.ICompanyEmployeeService;

@Controller
@RequestMapping(value="/company/employee")
public class CompanyEmployeeController {
	
	@Resource
	private ICompanyEmployeeService companyEmployeeService;
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

		String formData = request.getParameter("formData");
		//這裡做了時間格式的處理
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		CompanyEmployee employee = (CompanyEmployee) JSON.toJavaObject(jsb, CompanyEmployee.class);
		Integer employeeId=companyEmployeeService.saveCompanyEmployee(employee);
		String json = JSON.toJSONString(employeeId);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
		
	}
	@RequestMapping(value = "/loadEmployee", method = RequestMethod.POST)
	public ModelAndView loadEmployee(@RequestParam(value="employeeId",required=true) String employeeId, 
			HttpServletResponse response) throws Exception {
		
		CompanyEmployee companyEmployee = companyEmployeeService.getEmployeeById(employeeId);
		String json = JsonUtil.Encode(companyEmployee);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
		
	}
	@RequestMapping(value="/loadEmployees",method=RequestMethod.POST)
	public ModelAndView loadAllEmployee(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String companyName =request.getParameter("companyName");
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		String recorder =request.getParameter("recorder");
		String recordTimeBegin=request.getParameter("recordTimeBegin");
		String recordTimeEnd =request.getParameter("recordTimeEnd");
		
		Map<String,String> query = new HashMap<String,String>();
		query.put("companyName", companyName);
		query.put("name", name);
		query.put("category", category);
		query.put("recorder", recorder);
		query.put("recordTimeBegin", recordTimeBegin);
		query.put("recordTimeEnd", recordTimeEnd);
		//分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    
	    List<CompanyEmployee> companyEmployee=companyEmployeeService.
	    		loadAllCompanyEmployees(query, pageIndex, pageSize, sortField, sortOrder);
	   
	    HashMap result = new HashMap();
        result.put("data", companyEmployee);
        result.put("total", companyEmployee.size());
        
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	    
	    return null;
	}
}
