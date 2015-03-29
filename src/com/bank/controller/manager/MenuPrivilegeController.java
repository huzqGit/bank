package com.bank.controller.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
import com.bank.Constants;
import com.bank.beans.MenuPrivilege;
import com.bank.beans.User;
import com.bank.common.util.JsonUtil;
import com.bank.service.IMenuPrivilegeService;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

/**
 * 处理菜单的新增、修改、删除等操作
 * @author Huzq
 *
 */
@Controller
@RequestMapping(value = "/menuPrivilege")
public class MenuPrivilegeController {
	private static Logger log = LoggerFactory.getLogger(MenuPrivilegeController.class);
	private static String ADD = "add";
	
	@Resource
	private IMenuPrivilegeService menuPrivilegeSerivce;
	
	@RequestMapping(value = "/loadMenuPrivileges", method = RequestMethod.POST)
	public MenuPrivilege loadMenuPrivileges(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MenuPrivilege> data = new ArrayList<MenuPrivilege>();
		try {
			data = menuPrivilegeSerivce.getAllEntities();
		} catch (DAOException e) {
			log.error("get menus occurs error . ", e);
		}
	    
	    String arr = JsonUtil.Encode(data);
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(arr);
		} catch (IOException e) {
			log.error("", e);
			throw new IOException("", e);
		}
		return null;
	}
	
	@RequestMapping(value = "/loadMenu", method = RequestMethod.POST)
	public MenuPrivilege loadMenu(@RequestParam(value="pkId",required=true) String pkId, HttpServletResponse response) throws Exception {
		if (StringUtils.isEmpty(pkId)) return null;
		
		MenuPrivilege menuPrivilege = menuPrivilegeSerivce.findByPK(pkId);
		String json = JsonUtil.Encode(menuPrivilege);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public MenuPrivilege save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String formData = request.getParameter("formData");
		String actionType = request.getParameter("actionType");
		
		JSONObject jsb = JSONObject.parseObject(formData);
		MenuPrivilege menuPrivilege = (MenuPrivilege) JSONObject.toJavaObject(jsb, MenuPrivilege.class);
		
		String pkId = "";
		if (ADD.equals(actionType)) {//user为空，做新增操作
			pkId = UUID.randomUUID().toString();
			menuPrivilege.setPkId(pkId);
//			menu.setCreateUser(user);
//			menu.setCreateTime(new Timestamp(System.currentTimeMillis()));
			try {
				menuPrivilegeSerivce.save(menuPrivilege);
			} catch (DAOException e) {
				String msg = "Create menu occurs DAO error";
				log.error(msg, e);
				throw new DAOException(msg, e);
			} catch (CreateException e) {
				String msg = "Create menu occurs error";
				log.error(msg, e);
				throw new CreateException(msg, e);
			}
		} else {//userId不为空，做更新操作
			if (menuPrivilege != null) {
				pkId = menuPrivilege.getPkId();
			}
//			menu.setUpdateUser(user);
//			menu.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			try {
				menuPrivilegeSerivce.update(menuPrivilege);
			} catch (DAOException e) {
				String msg = "update privilege occurs DAO error. ";
				log.error(msg, e);
				throw new DAOException(msg, e);
			} catch (UpdateException e) {
				String msg = "update menu (pk:" + menuPrivilege.getId() + ") occur errors";
				log.error(msg, e);
				throw new UpdateException(msg, e);
			} catch (DataNotFoundException e) {
				String msg = "delete menu not found (pk:" + menuPrivilege.getId() + ")";
				log.error(msg, e);
				throw new UpdateException(msg, e);
			}
		}
		response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(pkId + "");
		} catch (IOException e) {
			log.error("", e);
			throw new IOException("", e);
		}
		return null;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public boolean delete(@RequestParam("pkId") String pkId) throws Exception{
		try {
			if (StringUtils.isEmpty(pkId)) throw new DAOException("主键不能为空!");
			
			menuPrivilegeSerivce.delete(pkId);
			
		} catch (DAOException e) {
			log.error("", e);
			throw new DAOException("", e);
		} catch (DeleteException e) {
			String msg = "delete menu occur errors";
			log.error(msg, e);
			throw new DeleteException(msg, e);
		} catch (DataNotFoundException e) {
			String msg = "delete menu not found (pk:" + pkId + ")";
			log.error(msg, e);
			throw new DataNotFoundException(msg, e);
		}
		return true;
	}
	
	@RequestMapping(value = "/updateMenuPrivilege", method = RequestMethod.POST)
	public MenuPrivilege updateMenuPrivilege(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String data = request.getParameter("data");
		String roleId  = request.getParameter("roleId");
		String menuId  = request.getParameter("menuId");
		ArrayList rows = (ArrayList)JsonUtil.Decode(data);
		menuPrivilegeSerivce.updateMenuPrivilege(rows, roleId, menuId);
		
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write("");
		} catch (IOException e) {
			log.error("", e);
			throw new IOException("", e);
		}
		return null;
	}
	
	
}
