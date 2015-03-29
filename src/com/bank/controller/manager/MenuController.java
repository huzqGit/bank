package com.bank.controller.manager;

import java.io.IOException;
import java.util.ArrayList;
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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bank.Constants;
import com.bank.beans.Menu;
import com.bank.beans.User;
import com.bank.common.util.JsonUtil;
import com.bank.service.IMenuService;
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
@RequestMapping(value = "/menu")
public class MenuController {
	private static Logger log = LoggerFactory.getLogger(MenuController.class);
	private static String ADD = "add";
	
	@Resource
	private IMenuService menuSerivce;
	
	@RequestMapping(value = "/loadMenus", method = RequestMethod.POST)
	public Menu loadMenus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Menu> data = new ArrayList<Menu>();
		try {
			data = menuSerivce.getAllEntities();
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
	public Menu loadMenu(@RequestParam(value="menuId",required=true) String menuId, HttpServletResponse response) throws Exception {
		if (StringUtils.isEmpty(menuId)) return null;
		
		Menu menu = menuSerivce.findByPK(Long.valueOf(menuId));
		String json = JsonUtil.Encode(menu);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Menu save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String formData = request.getParameter("formData");
		String actionType = request.getParameter("actionType");
		String menuPid = request.getParameter("menuPid");
		
		JSONObject jsb = JSONObject.parseObject(formData);
		Menu menu = (Menu) JSONObject.toJavaObject(jsb, Menu.class);
		
		int menuId = 0;
		
		if (ADD.equals(actionType)) {//user为空，做新增操作
			int parMenuId = (StringUtils.isEmpty(menuPid)) ? 0 : Integer.valueOf(menuPid);
			menu.setMenuPid(parMenuId);
//			menu.setCreateUser(user);
//			menu.setCreateTime(new Timestamp(System.currentTimeMillis()));
			try {
				menuSerivce.save(menu);
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
			if (menu != null) {
				menuId = menu.getMenuId();
			}
//			menu.setUpdateUser(user);
//			menu.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			try {
				menuSerivce.update(menu);
			} catch (DAOException e) {
				String msg = "update privilege occurs DAO error. ";
				log.error(msg, e);
				throw new DAOException(msg, e);
			} catch (UpdateException e) {
				String msg = "update menu (pk:" + menu.getId() + ") occur errors";
				log.error(msg, e);
				throw new UpdateException(msg, e);
			} catch (DataNotFoundException e) {
				String msg = "delete menu not found (pk:" + menu.getId() + ")";
				log.error(msg, e);
				throw new UpdateException(msg, e);
			}
		}
		response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(menuId + "");
		} catch (IOException e) {
			log.error("", e);
			throw new IOException("", e);
		}
		return null;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public boolean delete(@RequestParam("menuId") String menuId) throws Exception{
		try {
			if (StringUtils.isEmpty(menuId)) throw new DAOException("主键不能为空!");
			
			menuSerivce.delete(Long.valueOf(menuId));
			
		} catch (DAOException e) {
			log.error("", e);
			throw new DAOException("", e);
		} catch (DeleteException e) {
			String msg = "delete menu occur errors";
			log.error(msg, e);
			throw new DeleteException(msg, e);
		} catch (DataNotFoundException e) {
			String msg = "delete menu not found (pk:" + menuId + ")";
			log.error(msg, e);
			throw new DataNotFoundException(msg, e);
		}
		return true;
	}
	
	@RequestMapping(value = "/loadMenuTree", method = RequestMethod.POST)
	public Menu loadMenuTree(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<?> data = menuSerivce.loadMenuTree();
		
		JSONArray arr = (JSONArray) JSONArray.toJSON(data);
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(arr.toString());
		} catch (IOException e) {
			log.error("", e);
			throw new IOException("", e);
		}
		return null;
	}
}
