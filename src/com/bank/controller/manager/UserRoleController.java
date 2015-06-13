package com.bank.controller.manager;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Role;
import com.bank.beans.User;
import com.bank.beans.UserRole;
import com.bank.common.util.JsonUtil;
import com.bank.service.IRoleService;
import com.bank.service.IUserRoleService;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

/**
 * 处理角色的新增、修改、删除等操作
 *
 */
@Controller
@RequestMapping(value = "/userRole")
public class UserRoleController {
	private static Logger log = LoggerFactory.getLogger(UserRoleController.class);
	private static String ADD = "add";
	
	@Resource
	private IUserRoleService userRoleSerivce;
	
	@RequestMapping(value = "/loadUserRoles", method = RequestMethod.POST)
	public Role loadRoles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<UserRole> data = new ArrayList<UserRole>();
		try {
			data = userRoleSerivce.getAllEntities();
		} catch (DAOException e) {
			log.error("get menus occurs error . ", e);
		}
	    
	    String json = JSON.toJSONString(data);
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			log.error("", e);
			throw new IOException("", e);
		}
		return null;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Role save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String formData = request.getParameter("formData");
		String actionType = request.getParameter("actionType");
		//這裡做了時間格式的處理
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		UserRole userRole = (UserRole) JSON.toJavaObject(jsb, UserRole.class);
		String roleId = userRole.getId();
		
		if (ADD.equals(actionType)) {
			try {
				userRoleSerivce.save(userRole);
			} catch (DAOException e) {
				String msg = "Create role occurs DAO error";
				log.error(msg, e);
				throw new DAOException(msg, e);
			} catch (CreateException e) {
				String msg = "Create role occurs error";
				log.error(msg, e);
				throw new CreateException(msg, e);
			}
		} else {
			try {
				userRoleSerivce.update(userRole);
			} catch (DAOException e) {
				String msg = "update role occurs DAO error. ";
				log.error(msg, e);
				throw new DAOException(msg, e);
			} catch (UpdateException e) {
				String msg = "update role (pk:" + userRole.getId() + ") occur errors";
				log.error(msg, e);
				throw new UpdateException(msg, e);
			} catch (DataNotFoundException e) {
				String msg = "delete role not found (pk:" + userRole.getId() + ")";
				log.error(msg, e);
				throw new UpdateException(msg, e);
			}
		}
		response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(roleId);
		} catch (IOException e) {
			log.error("", e);
			throw new IOException("", e);
		}
		return null;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public boolean delete(@RequestParam("roleId") String roleId) throws Exception{
		try {
			if (StringUtils.isEmpty(roleId)) throw new DAOException("主键不能为空!");
			
			userRoleSerivce.delete(roleId);
			
		} catch (DAOException e) {
			log.error("", e);
			throw new DAOException("", e);
		} catch (DeleteException e) {
			String msg = "delete role occur errors";
			log.error(msg, e);
			throw new DeleteException(msg, e);
		} catch (DataNotFoundException e) {
			String msg = "delete role not found (pk:" + roleId + ")";
			log.error(msg, e);
			throw new DataNotFoundException(msg, e);
		}
		return true;
	}
	
	@RequestMapping(value = "/saveUserRoles", method = RequestMethod.POST)
	@ResponseBody
	public Role saveRoles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//保存前先删除
		String data = request.getParameter("data");
		String roleId = request.getParameter("roleId");
		userRoleSerivce.delete(roleId);
		String[] userIds = data.split(",");
		for (int i = 0; i < userIds.length; i++) {
			String userId = userIds[i];
			UserRole userRole = new UserRole();
			userRole.setRoleId(roleId);
			userRole.setUserId(userId);
			userRoleSerivce.save(userRole);
		}
		return null;
		
	}
}
