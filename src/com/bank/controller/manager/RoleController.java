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
import com.bank.common.util.JsonUtil;
import com.bank.service.IRoleService;
import com.bank.service.ISysLogService;
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
@RequestMapping(value = "/role")
public class RoleController {
	private static Logger log = LoggerFactory.getLogger(RoleController.class);
	private static String ADD = "add";
	
	@Resource
	private IRoleService roleSerivce;
	
	@Resource
	private ISysLogService sysLogSerivce;
	
	@RequestMapping(value = "/loadRoles", method = RequestMethod.POST)
	public Role loadRoles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Role> data = new ArrayList<Role>();
		try {
			data = roleSerivce.getAllEntities();
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
		Role role = (Role) JSON.toJavaObject(jsb, Role.class);
		String roleId = role.getId();
		
		String message = "";
		if (ADD.equals(actionType)) {
			try {
				roleSerivce.save(role);
				
				// 添加日志.
				message = "角色: " + role.getRoleName() + "被添加成功";
				sysLogSerivce.addLog(message, Constants.LOG_TYPE_INSERT, Constants.LOG_LEAVEL_INFO, user);
				
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
				roleSerivce.update(role);
				
				// 添加日志.
				message = "角色: " + role.getRoleName() + "被更新成功";
				sysLogSerivce.addLog(message, Constants.LOG_TYPE_UPDATE, Constants.LOG_LEAVEL_INFO, user);
				
			} catch (DAOException e) {
				String msg = "update role occurs DAO error. ";
				log.error(msg, e);
				throw new DAOException(msg, e);
			} catch (UpdateException e) {
				String msg = "update role (pk:" + role.getId() + ") occur errors";
				log.error(msg, e);
				throw new UpdateException(msg, e);
			} catch (DataNotFoundException e) {
				String msg = "delete role not found (pk:" + role.getId() + ")";
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
	public boolean delete(@RequestParam("roleId") String roleId, HttpServletRequest request) throws Exception{
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		try {
			if (StringUtils.isEmpty(roleId)) throw new DAOException("主键不能为空!");
			
			roleSerivce.delete(roleId);
			
			// 添加日志.
			String message = "角色: " + roleId + "被删除成功";
			sysLogSerivce.addLog(message, Constants.LOG_TYPE_DEL, Constants.LOG_LEAVEL_INFO, user);
			
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
	
	@RequestMapping(value = "/saveRoles", method = RequestMethod.POST)
	@ResponseBody
	public Role saveRoles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String json = request.getParameter("data");
	    ArrayList rows = (ArrayList)JsonUtil.Decode(json);

	    for(int i=0,l=rows.size(); i<l; i++){
	    	HashMap row = (HashMap)rows.get(i);
	    	
			String id = row.get("roleId") != null ? row.get("roleId").toString() : "";
	        String state = row.get("_state") != null ? row.get("_state").toString() : "";
	        
	        if(state.equals("added") || id.equals(""))	//新增：id为空，或_state为added
	        {
	            //row.put("createtime", new Date());
	        	roleSerivce.save(row);
	        }
	        else if (state.equals("removed") || state.equals("deleted"))
	        {
	            roleSerivce.delete(id);
	        }
	        else if (state.equals("modified") || state.equals(""))	//更新：_state为空，或modified
	        {
	        	roleSerivce.update(row);
	        }
	    }
		return null;
	}
	
}
