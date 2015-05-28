package com.bank.controller.economy;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.beans.FarmerCooperation;
import com.bank.beans.FarmerCooperationDebt;
import com.bank.common.util.JsonUtil;
import com.bank.service.ICooperationDebtService;
import com.bank.utils.HttpUtils;

@Controller
@RequestMapping("economy/debt")
public class CooperationDebtController {
	
	private static Logger log = LoggerFactory.getLogger(CooperationDebtController.class);
	
	@Resource
	private ICooperationDebtService cooperationDebtService;
	
	@RequestMapping(value="saveCooperationDebt",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		String formData = request.getParameter("formData");
		
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		FarmerCooperationDebt coo = (FarmerCooperationDebt) JSON.toJavaObject(jsb, FarmerCooperationDebt.class);
		try{
			if(coo.getDebtid()==null){
				if(coo.getRecordtime() == null)
					coo.setRecordtime(new Date());
				cooperationDebtService.save(coo);
			}else{
				cooperationDebtService.update(coo);
			}
		}catch(Exception e){
			log.error(e.getMessage());
			throw e;
		}
		log.info("保存成功");
		String json = JSON.toJSONString(coo);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
	
	@RequestMapping(value="findCooperationDebt",method = RequestMethod.POST)
	public FarmerCooperation findByPK(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String pk = HttpUtils.getParameter(request,"debtid");
		if(pk != null){
			FarmerCooperationDebt entity = cooperationDebtService.findByPK(Long.parseLong(pk));
			String json = JSON.toJSONStringWithDateFormat(entity,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		    response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
	}
	@RequestMapping(value="loadAllFarmerCooperationDebt",method = RequestMethod.POST)
	public void loadAllFarmerCooperation(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		//查询条件
	    String queryStr = HttpUtils.getParameter(request,"queryStr");
	    JSONObject jsonobj = JSON.parseObject(queryStr);
	    Map<String,String> map = new HashMap<String,String>();
	    if(jsonobj != null)
		    for(String s : jsonobj.keySet()){
		    	map.put(s, jsonobj.getString(s));
		    }
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    
	    List<FarmerCooperationDebt> data = cooperationDebtService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder,map);
	    long size = cooperationDebtService.getTotal(map);
	    
	    HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("data", data);
        result.put("total", size);
        String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
//	    String json = JSON.toJSONString(result);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	    
	}
}
