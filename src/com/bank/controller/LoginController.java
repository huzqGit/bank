package com.bank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.Constants;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.dao.IMenuDao;
import com.bank.service.IOrganService;
import com.bank.service.IUserService;
import com.bank.vo.MenuPrivilegeVO;
import com.common.exception.DAOException;

@Controller
@RequestMapping(value = "/user")

public class LoginController {
	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Resource
	private IUserService userService;
	@Resource
	private IOrganService organService;
	@Resource 
	private IMenuDao menuDao;
	
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
    public ModelAndView login(@ModelAttribute("user") User user, HttpServletRequest request) throws Exception{
    	User returnUser = verifyUser(user);
    	ModelAndView mav = new ModelAndView();
    	if (returnUser != null) {
    		request.getSession().setAttribute(Constants.SESSION_AUTH_USER, returnUser);
    		Organ currentUnit = organService.loadOrgan(returnUser.getUnitId());
    		if (currentUnit != null) {
    			request.getSession().setAttribute(Constants.SESSION_CURRENT_UNIT, currentUnit);
    		}
    		
    		System.out.println("currentUnit  :  " + currentUnit.getOrganId());
    		
    		// topMenus
    		List<MenuPrivilegeVO> topMenus = new ArrayList<MenuPrivilegeVO>();
    		try {
				topMenus = menuDao.getTopMenusByUserId(returnUser.getUserId());
			} catch (DAOException e) {
				String msg = "get MenuPrivilegeVO occurs DAO error";
				log.error(msg, e);
				throw new DAOException(msg, e);
			}
    		
    		request.getSession().setAttribute("topMenus", topMenus);
    		
    		
    		//指定要返回的页面为succ.jsp
    		mav.setViewName("main/main");
    		//将参数返回给页面  
    		mav.addObject("user", returnUser);
//    		mav.addObject("topMenus", topMenus);
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
