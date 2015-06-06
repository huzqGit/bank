package com.bank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.common.util.JsonUtil;
import com.bank.service.IOrganService;
import com.bank.service.IUserService;
import com.common.config.SystemConfig;
import com.common.exception.DAOException;
import com.common.tools.StringUtil;

/**
 * 处理用户的新增、修改、删除等操作
 * @author Huzq
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	private static final String UNIT = "UNIT";
	private static final String SUPERADMIN = "bank.superadmin";
	@Resource
	private IUserService userSerivce;
	@Resource
	private IOrganService organSerivce;
	
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
		
		if (user == null) throw new DAOException("user 不能为空！");
		
		if (StringUtils.isNotEmpty(user.getIsAdmin())) {
			if ("true".equals(user.getIsAdmin())) {
				user.setIsAdmin("1");
			} else {
				user.setIsAdmin("0");
			}
		} else {
			user.setIsAdmin("0");
		}
		
		//unitId
		if (StringUtils.isNotEmpty(user.getOrganId())) {
			Organ organ = organSerivce.loadOrgan(user.getOrganId());
			if (organ != null) {
				if (UNIT.equals(organ.getOrganType())) {
					user.setUnitId(organ.getOrganId());
				} else {
					String unitId = StringUtils.isNotEmpty(organ.getOrganPid()) ? organ.getOrganPid() : organ.getOrganId();
					user.setUnitId(unitId);
				}
			}
		}
		
		String userId = user.getUserId();
		if ("add".equals(actionType)) {//user为空，做新增操作
			User user2 = userSerivce.loadUser(userId);
			if (user2 != null && user2.getUserId().equals(userId)) {
				userId = "false";
			} else {
				userId = userSerivce.saveUser(user);
			}
		} else {//userId不为空，做更新操作
			userSerivce.updateUser(user);
		}
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(userId);
		return null;
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteUser(@RequestParam("userId") String userId, HttpServletResponse response) throws Exception{
		boolean flag = userSerivce.deleteUser(userId);
		response.getWriter().write("1");
		return null;
	}
	
	@RequestMapping(value = "/loadAllUsers", method = RequestMethod.POST)
	public User loadAllUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		//查询条件
	    String key = request.getParameter("key");
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    
	    //超级管理员.
	  	String isSuperAdmin = "";
	  	List<String> superAdmins = SystemConfig.getSystemConfig().getList(SUPERADMIN);
	  	if (superAdmins.contains(user.getUserId())) {
	  		isSuperAdmin = "1";
	  	} 
	  	
	  	List<User> data = new ArrayList<User>();
	  	if ("1".equals(isSuperAdmin)) {
	  		data = userSerivce.loadAllUsers(key, pageIndex, pageSize, sortField, sortOrder);
	  	} else {
	  		Organ unit = (Organ) request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
			if (unit != null) {
				List<String> organIds = organSerivce.getSubOrgansByUnitId(unit.getOrganId());
				
				String tempOrganIds = "";
				for (String organId : organIds) {
					tempOrganIds = StringUtil.connectBySplit(tempOrganIds, "'" + organId + "'", ",");
				}
				
				data = userSerivce.loadAllUsersByOrganIds(key, pageIndex, pageSize, sortField, sortOrder, tempOrganIds);
			}
	  		
	  	}
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONString(result);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
}
