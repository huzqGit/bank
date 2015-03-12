package com.bank.controller.manager;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
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
	public Menu loadMenus(HttpServletRequest request, HttpServletResponse response) {
		List<Menu> data = new ArrayList<Menu>();
		try {
			data = menuSerivce.getAllEntities();
		} catch (DAOException e) {
			log.error("get menus occurs error . ", e);
		}
	    
	    String json = JSON.toJSONString(data);
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			log.error("", e);
		}
		return null;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Menu save(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String formData = request.getParameter("formData");
		String actionType = request.getParameter("actionType");
		//這裡做了時間格式的處理
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		Menu menu = (Menu) JSON.toJavaObject(jsb, Menu.class);
		String menuId = menu.getId();
		
		if (ADD.equals(actionType)) {//user为空，做新增操作
			menu.setCreateUser(user);
			menu.setCreateTime(new Timestamp(System.currentTimeMillis()));
			try {
				menuSerivce.save(menu);
			} catch (DAOException e) {
				log.error("", e);
			} catch (CreateException e) {
				log.error("Create org group occurs error", e);
			}
		} else {//userId不为空，做更新操作
			menu.setUpdateUser(user);
			menu.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			try {
				menuSerivce.update(menu);
			} catch (DAOException e) {
				log.error("", e);
			} catch (UpdateException e) {
				log.error("update menu (pk:" + menu.getId() + ") occurs error", e);
			} catch (DataNotFoundException e) {
				log.error("delete menu not found (pk:" + menu.getId() + ")", e);
			}
		}
		response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(menuId);
		} catch (IOException e) {
			log.error("", e);
		}
		return null;
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public boolean delete(@RequestParam("menuId") String menuId){
		try {
			menuSerivce.delete(menuId);
		} catch (DAOException e) {
			log.error("", e);
		} catch (DeleteException e) {
			log.error("", e);
		} catch (DataNotFoundException e) {
			log.error("delete menu not found (pk:" + menuId + ")", e);
		}
		return true;
	}
	
}
