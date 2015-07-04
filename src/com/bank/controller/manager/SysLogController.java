package com.bank.controller.manager;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.beans.Message;
import com.bank.beans.SysLog;
import com.bank.service.ISysLogService;

@Controller
@RequestMapping(value = "/sysLog")
public class SysLogController {
	@Resource
	private ISysLogService sysLogSerivce;
	
	@RequestMapping(value = "/sysLogView", method = RequestMethod.GET)
	public ModelAndView organUserView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView("authorization/sysLog");  
        
        return mav;
	}
	
	@RequestMapping(value = "/loadAllSysLog", method = RequestMethod.POST)
	public Message loadAllMessages(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 查询条件.
		String operateType = request.getParameter("operateType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    if ("logContent".equals(sortField)) {
	  		sortField = "LOG_CONTENT";
	  	} 
	  	if ("operateTime".equals(sortField)) {
	  		sortField = "OPERATE_TIME";
	  	}
	  	if ("userId".equals(sortField)) {
	  		sortField = "USER_ID";
	  	} 
	  	if ("userName".equals(sortField)) {
	  		sortField = "USER_NAME";
	  	}
	    String sortOrder = request.getParameter("sortOrder");
	    
	    List<SysLog> data = sysLogSerivce.loadAllSysLogs(operateType, pageIndex, pageSize, 
	    		sortField, sortOrder, startDate, endDate);
	    
	    List<SysLog> total = sysLogSerivce.getAllEntities();
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", total.size());
        
        String json = JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
}
