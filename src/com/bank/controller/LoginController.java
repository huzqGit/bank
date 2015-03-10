package com.bank.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.Constants;
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
        ModelAndView mav = new ModelAndView("login/success");  
        //将参数返回给页面  
        mav.addObject("username", username);  
        mav.addObject("password", password);  
        return mav;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("user") User user, HttpServletRequest request) {
    	User retrunUser = verifyUser(user);
    	ModelAndView mav = new ModelAndView();
    	if (retrunUser != null) {
    		request.getSession().setAttribute(Constants.SESSION_AUTH_USER, retrunUser);
    		//指定要返回的页面为succ.jsp
    		mav.setViewName("login/index");
    		//将参数返回给页面  
    		mav.addObject("user", retrunUser);
    	} else {
    		mav.setViewName("login/login");
    	}
    	return mav;
    }

	private User verifyUser(User user) {
		User retrunUser = userService.verifyUser(user);
		return retrunUser;
		
	}

}
