package com.bank.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bank.Constants;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.UserRole;
import com.bank.service.IOrganService;
import com.bank.service.IUserRoleService;
import com.common.config.SystemConfig;

/**
 * 处理机构的新增、修改、删除等操作
 * @author Huzq
 *
 */
@Controller
@RequestMapping(value = "/organ")
public class OrganController {
	private static Logger log = LoggerFactory.getLogger(OrganController.class);
	private static final String SUPERADMIN = "bank.superadmin";
	@Resource
	private IOrganService organSerivce;
	
	@Resource
	private IUserRoleService userRoleSerivce;
	
	@RequestMapping(value = "/loadOrgan", method = RequestMethod.POST)
	public Organ loadOrgan(@RequestParam(value="organId",required=true) String organId, HttpServletResponse response) throws Exception {
		Organ organ = organSerivce.loadOrgan(organId);
		String json = JSON.toJSONString(organ);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
	@RequestMapping(value = "/saveOrgan", method = RequestMethod.POST)
	public Organ saveOrgan(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String formData = request.getParameter("formData");
		String actionType = request.getParameter("actionType");
		//Object obj = JSON.toJSONStringWithDateFormat(formData, formData, arg2);
		JSONObject jsb = JSONObject.parseObject(formData); //将json串转成JSONObject
		Organ Organ = (Organ) JSONObject.toJavaObject(jsb, Organ.class);
		String organId = "";
		if ("add".equals(actionType)) {//organId为空，做新增操作
			organId = organSerivce.saveOrgan(Organ);
		} else {//organId不为空，做更新操作
			organSerivce.updateOrgan(Organ);
			organId = Organ.getOrganId();
		}
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(organId);
		return null;
	}
	
	@RequestMapping(value = "/deleteOrgan")
	public String deleteOrgan(@RequestParam("organId") String organId){
		organSerivce.deleteOrgan(organId);
		return null;
	}
	
	@RequestMapping(value = "/loadAllOrgans", method = RequestMethod.POST)
	public Organ loadAllOrgans(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//查询条件
	    String key = request.getParameter("submitData");
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    
	    List<Organ> data = organSerivce.loadAllOrgans(key, pageIndex, pageSize, sortField, sortOrder);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONString(result);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
	@RequestMapping(value = "/organUserTree", method = RequestMethod.POST)
	public Organ organUserTree(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		//超级管理员.
		String isSuperAdmin = "";
		List<String> superAdmins = SystemConfig.getSystemConfig().getList(SUPERADMIN);
		if (superAdmins.contains(user.getUserId())) {
			isSuperAdmin = "1";
		} 
		
		List<?> list = new ArrayList();
		if ("1".equals(isSuperAdmin)) {
			
			list = organSerivce.getOrganUserTree();
			
		} else {
			Organ unit = (Organ) request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
			if (unit != null) {
				list = organSerivce.getOrganUserTreeByCondition(unit.getOrganId());
			}
		}
		
		JSONArray arr = (JSONArray) JSONArray.toJSON(list);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(arr.toString());
		return null;
	}
	
	@RequestMapping(value = "/userCheckTree", method = RequestMethod.POST)
	public Organ userCheckTree(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//第一种方法
		String roleId = request.getParameter("roleId");
		List<?> data = organSerivce.getOrganCheckedUserTree(roleId);
		
		//第二种方法
		/*List<?> organlist = organSerivce.getOrganUserTree();
		List<UserRole> userRolelist = userRoleSerivce.getAllUserRolesById(roleId);
		List data = new ArrayList();
		for (int j = 0; j < organlist.size(); j++) {
			Map organuser = (HashMap) organlist.get(j);
			for (int i = 0; i < userRolelist.size(); i++) {
				UserRole userRole = userRolelist.get(i);
				
				String id = organuser.get("ID").toString();
				if (userRole.getUserId().equals(id)) {
					organuser.put("checked", true);
				}
			}
			data.add(organuser);
		}*/
		JSONArray arr = (JSONArray) JSONArray.toJSON(data);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(arr.toString());
		return null;
	}
}
