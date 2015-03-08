package com.bank.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.beans.User;
import com.bank.common.util.JSON;
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
	
	@RequestMapping(value = "/loadUser", method = RequestMethod.GET)
	public User loadUser(@PathVariable String userId, HttpServletResponse response) throws Exception {
		User user = userSerivce.loadUser(userId);
		String json = JSON.Encode(user);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public User saveUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String formData = request.getParameter("json");
		JSONObject jsb = JSONObject.fromObject(formData); //将json串转成JSONObject
		User userdata = (User) JSONObject.toBean(jsb, User.class);
		User user = userSerivce.saveUser(userdata);
		String json = JSON.Encode(user);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public boolean deleteUser(@PathVariable String userId){
		boolean flag = userSerivce.deleteUser(userId);
		return flag;
	}
}
