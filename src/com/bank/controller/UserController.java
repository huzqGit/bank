package com.bank.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.beans.User;
import com.bank.common.util.JsonUtil;
import com.bank.service.IUserService;

/**
 * 处理用户的新增、修改、删除等操作
 * @author Huzq
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Resource
	private IUserService userSerivce;
	
	@RequestMapping(value = "/loadUser", method = RequestMethod.POST)
	public User loadUser(@RequestParam(value="userId",required=true) String userId, HttpServletResponse response) throws Exception {
		User user = userSerivce.loadUser(userId);
		String json = JsonUtil.Encode(user);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public User saveUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String formData = request.getParameter("formData");
		String actionType = request.getParameter("actionType");
		//這裡做了時間格式的處理
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		User user = (User) JSON.toJavaObject(jsb, User.class);
		String userId = user.getUserId();
		if ("add".equals(actionType)) {//user为空，做新增操作
			userId = userSerivce.saveUser(user);
		} else {//userId不为空，做更新操作
			userSerivce.updateUser(user);
		}
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(userId);
		return null;
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public boolean deleteUser(@RequestParam("userId") String userId){
		boolean flag = userSerivce.deleteUser(userId);
		return flag;
	}
	
	@RequestMapping(value = "/loadAllUsers", method = RequestMethod.POST)
	public User loadAllUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//查询条件
	    String key = request.getParameter("submitData");
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    
	    List<User> data = userSerivce.loadAllUsers(key, pageIndex, pageSize, sortField, sortOrder);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONString(result);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
}
