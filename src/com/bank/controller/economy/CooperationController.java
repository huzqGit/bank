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
		if(coo.getRecordTime() == null)
			coo.setRecordTime(new Date());
		try{
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
	
	@RequestMapping(value="addForm")
	public ModelAndView addForm(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String keys = HttpUtils.getParameter(request, "sys_key");
		String values = HttpUtils.getParameter(request, "sys_value");
		//跳转页面jsp
		String redirectJsp = HttpUtils.getParameter(request, "dest");
		if(redirectJsp.endsWith(".jsp"))
			redirectJsp = redirectJsp.replace(".jsp", "");
		ModelAndView view = new ModelAndView(redirectJsp);
		String[] key = null;
		String[] value = null;
		if(keys !=null && values != null){
			key = keys.split(";");
			value = values.split(";");
			for(int i=0;i<key.length;i++){
				view.addObject(key[i], value[i]);
			}
		}
		view.addObject("display","display:display");
		return view;
	}
	@RequestMapping(value="editForm")
	public ModelAndView editForm(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String keys = HttpUtils.getParameter(request, "sys_key");
		String values = HttpUtils.getParameter(request, "sys_value");
		//跳转页面jsp
		String redirectJsp = HttpUtils.getParameter(request, "dest");
		if(redirectJsp.endsWith(".jsp"))
			redirectJsp = redirectJsp.replace(".jsp", "");
		ModelAndView view = new ModelAndView(redirectJsp);
		String[] key = null;
		String[] value = null;
		if(keys !=null && values != null){
			key = keys.split(";");
			value = values.split(";");
			for(int i=0;i<key.length;i++){
				view.addObject(key[i], value[i]);
			}
		}
		view.addObject("display","display:display");
		return view;
	}
	@RequestMapping(value="viewForm")
	public ModelAndView viewForm(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String keys = HttpUtils.getParameter(request, "sys_key");
		String values = HttpUtils.getParameter(request, "sys_value");
		//跳转页面jsp
		String redirectJsp = HttpUtils.getParameter(request, "dest");
		if(redirectJsp.endsWith(".jsp"))
			redirectJsp = redirectJsp.replace(".jsp", "");
		ModelAndView view = new ModelAndView(redirectJsp);
		String[] key = null;
		String[] value = null;
		if(keys !=null && values != null){
			key = keys.split(";");
			value = values.split(";");
			for(int i=0;i<key.length;i++){
				view.addObject(key[i], value[i]);
			}
		}
		view.addObject("display","display:none");
		return view;
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
	    String key = request.getParameter("key");
	    Map<String,String> map = new HashMap<String,String>();
	    map.put("key", key);
	    
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
}
