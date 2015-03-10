package com.bank.controller.manager;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.bank.beans.Menu;
import com.bank.beans.Organ;
import com.bank.service.IMenuService;
import com.bank.service.IOrganService;

/**
 * 处理菜单的新增、修改、删除等操作
 * @author Huzq
 *
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {
	@Resource
	private IMenuService menuSerivce;
	
	@RequestMapping(value = "/loadMenus", method = RequestMethod.POST)
	public Menu loadMenus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Menu> data = menuSerivce.loadMenus();
	    
	    String json = JSON.toJSONString(data);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
}
