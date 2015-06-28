package com.bank.controller.economy;

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

import com.alibaba.fastjson.JSON;
import com.bank.service.ITMapService;
import com.bank.utils.HttpUtils;

@Controller
@RequestMapping("economy/tMap")
public class TMapController {
	
	private static Logger log = LoggerFactory.getLogger(TMapController.class);
	
	@Resource(name="tMapService")
	private ITMapService cooperationService;

	@RequestMapping(value="getMapTree",method = RequestMethod.POST)
	public void getMapTree(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

	    Map<String,Object> map = new HashMap<String,Object>();
	    String has = HttpUtils.getParameter(request, "t");
	    if(has != null){
	    	map.put("maptypes", has);//此处注意单引号
	    }else{
	    	map.put("maptypes", "'sourcecode_sourcename'");//此处注意单引号
	    }
	    List<Map<String,Object>> data = cooperationService.getMapTree(map);
	    String json = JSON.toJSONString(data);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	}
}
