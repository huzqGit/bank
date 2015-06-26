package com.bank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alisoft.xplatform.asf.cache.ICache;
import com.bank.Constants;
import com.bank.beans.OnLineUser;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.controller.economy.CooperationController;
import com.bank.controller.economy.CooperationDebtController;
import com.bank.controller.economy.CooperationProfitController;
import com.bank.dao.IMenuDao;
import com.bank.service.IOrganService;
import com.bank.service.IUserService;
import com.bank.spring.BeanFactory;
import com.bank.vo.MenuPrivilegeVO;
import com.common.config.SystemConfig;
import com.common.exception.DAOException;
import com.common.tools.IpUtil;

@Controller
@RequestMapping(value = "/user")

public class LoginController {
	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	private static final String SUPERADMIN = "bank.superadmin";
	
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
    		
    		// 在线用户监听.
    		returnUser.setUnit(currentUnit);
    		OnLineUser onlineUser = new OnLineUser(returnUser);
			onlineUser.setUserIP(IpUtil.getIpAddr(request));
			request.getSession().setAttribute(Constants.SESSION_ONLINEUSER, onlineUser);
    		
    		// topMenus
    		List<MenuPrivilegeVO> topMenus = new ArrayList<MenuPrivilegeVO>();
    		try {
    			
    			//超级管理员.
    			String isSuperAdmin = "";
    			String isAdmin = returnUser.getIsAdmin();
    			List<String> superAdmins = SystemConfig.getSystemConfig().getList(SUPERADMIN);
    			if (superAdmins.contains(returnUser.getUserId())) {
    				isSuperAdmin = "1";
    			} 
    			
    			if ("0".equals(isAdmin) || "".equals(isAdmin)) {
    				topMenus = menuDao.getTopMenusByUserId(returnUser.getUserId());
    			} else {
    				if ("1".equals(isSuperAdmin)) {
    					topMenus = menuDao.getTopAllMenus();
    				} else {
    					topMenus = menuDao.getTopSysMenus(isSuperAdmin);
    				}
    			}
				
				
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
	
	/**
	 * 用户退出进行额外操作
	 * @author zkongbai
	 * @date 2015年6月23日  下午4:28:03
	 * @version 1.0
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/logoutAction", method = RequestMethod.POST)
    public void logoutAction(HttpServletResponse response, HttpServletRequest request) throws Exception{
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String key = user.getOrganId()+"$"+user.getUserId();
		CooperationController.uMap.remove(key);
		CooperationDebtController.uMap.remove(key);
		CooperationProfitController.uMap.remove(key);
    }

}
