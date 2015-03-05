package com.bank.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.beans.User;
import com.bank.service.IUserService;

@Controller
@RequestMapping(value = "/user")

public class LoginController {
	@Resource
	private IUserService userService;
	
	@RequestMapping(value = "/toLogin")
    public String toLogin() {
       return "login";
    }
	
    //@RequestMapping(value = "/login")
    public ModelAndView login(String username,String password) {
    	//指定要返回的页面为succ.jsp
        ModelAndView mav = new ModelAndView("success");  
        //将参数返回给页面  
        mav.addObject("username", username);  
        mav.addObject("password", password);  
        return mav;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("user") User user) {
    	boolean flag = verifyUser(user);
    	ModelAndView mav = new ModelAndView();
    	if (flag) {
    		//指定要返回的页面为succ.jsp
    		mav.setViewName("success");
    		//将参数返回给页面  
    		mav.addObject("user", user);
    	} else {
    		mav.setViewName("login");
    	}
    	return mav;
    }

	private boolean verifyUser(User user) {
		boolean flag = userService.verifyUser(user);
		return flag;
		
	}

}
