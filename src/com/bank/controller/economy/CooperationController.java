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
import com.bank.common.util.JsonUtil;
import com.bank.service.ICooperationService;
import com.bank.utils.HttpUtils;

@Controller
@RequestMapping("economy")
public class CooperationController {
	
	private static Logger log = LoggerFactory.getLogger(CooperationController.class);
	
	@Resource
	private ICooperationService cooperationService;
	
	@RequestMapping(value="saveCooperation",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		String formData = request.getParameter("formData");
		
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		FarmerCooperation coo = (FarmerCooperation) JSON.toJavaObject(jsb, FarmerCooperation.class);
		try{
			if(coo.getRecordTime() == null)
				coo.setRecordTime(new Date());
			if(coo.getCooperationId()==null){
				cooperationService.save(coo);
			}else{
				cooperationService.update(coo);
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
	
	@RequestMapping(value="findCooperation",method = RequestMethod.POST)
	public FarmerCooperation findByPK(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String pk = HttpUtils.getParameter(request,"cooperationId");
		if(pk != null){
			FarmerCooperation entity = cooperationService.findByPK(Long.parseLong(pk));
			String json = JSON.toJSONStringWithDateFormat(entity,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		    response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
	}
	@RequestMapping(value="loadAllFarmerCooperation",method = RequestMethod.POST)
	public void loadAllFarmerCooperation(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		//查询条件
	    String cooperationName = HttpUtils.getParameter(request,"cooperationName");
	    String orgaCode = HttpUtils.getParameter(request,"orgaCode");
	    String recorder = HttpUtils.getParameter(request,"recorder");
	    String recordTimeBegin = HttpUtils.getParameter(request,"recordTimeBegin");
	    String recordTimeEnd = HttpUtils.getParameter(request,"recordTimeEnd");

	    Map<String,String> map = new HashMap<String,String>();
	    map.put("cooperationName", cooperationName);
	    map.put("orgaCode", orgaCode);
	    map.put("recorder", recorder);
	    map.put("recordTimeBegin", recordTimeBegin);
	    map.put("recordTimeEnd", recordTimeEnd);
	    
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    
	    List<FarmerCooperation> data = cooperationService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder,map);
	    long size = cooperationService.getTotal(map);
	    
	    HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("data", data);
        result.put("total", size);
        String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
//	    String json = JSON.toJSONString(result);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	}
	
	@RequestMapping(value="getCooperationTree",method = RequestMethod.POST)
	public void getCooperationTree(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		//查询条件
	    String cooperationName = HttpUtils.getParameter(request,"cooperationName");
	    Map<String,Object> map = new HashMap<String,Object>();
	    map.put("cooperationName", cooperationName);
	    
	    List<Map<String,Object>> data = cooperationService.getCooperationTree(map);
//	    HashMap<String,Object> result = new HashMap<String,Object>();
//      result.put("data", data);
	    String json = JSON.toJSONString(data);
//	    System.out.println(json);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	}
	
	@RequestMapping(value="deleteByKey")
	public void deleteByKey(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = HttpUtils.getParameter(request, "id");
		response.setContentType("text/html;charset=UTF-8");
		try {
			cooperationService.delete(Long.parseLong(id));
			response.getWriter().write("{\"success\":\"删除成功\"}");
		} catch (Exception e) {
			response.getWriter().write("{\"success\":\"删除失败\"}");
		}
		return;
	}
}
