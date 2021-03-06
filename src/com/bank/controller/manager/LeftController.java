package com.bank.controller.manager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.Constants;
import com.bank.beans.User;
import com.bank.controller.base.BaseController;
import com.bank.dao.IMenuDao;
import com.bank.vo.MenuPrivilegeVO;
import com.common.config.SystemConfig;
import com.common.exception.DAOException;

@Controller
@RequestMapping(value = "/user")

public class LeftController extends BaseController {
	private static Logger log = LoggerFactory.getLogger(LeftController.class);
	private static final String ZERO = "0";
	private static final String SUPERADMIN = "bank.superadmin";
	
	@Resource 
	private IMenuDao menuDao;
	private List<MenuPrivilegeVO> subMenus = new ArrayList<MenuPrivilegeVO>();
	
	@RequestMapping(value = "/left")
    public ModelAndView getSubMenus(@ModelAttribute("topMenuId") String topMenuId,HttpServletRequest request) throws Exception{
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		ModelAndView mav = new ModelAndView();
		subMenus.clear();
		if (StringUtils.isEmpty(topMenuId)) throw new DAOException("topMenuId 不能为空!");
		
		// get all subMenus
		//超级管理员.
		String isSuperAdmin = "";
		String isAdmin = user.getIsAdmin();
		List<String> superAdmins = SystemConfig.getSystemConfig().getList(SUPERADMIN);
		if (superAdmins.contains(user.getUserId())) {
			isSuperAdmin = "1";
		} 
		
		if ("1".equals(isSuperAdmin) || "1".equals(isAdmin)) {
			
			getSubMenus(Long.valueOf(topMenuId));
			
		} else {
			
			getSubMenus(user.getUserId(), Long.valueOf(topMenuId));
			
		}
		
		subMenus.add(new MenuPrivilegeVO("0", Long.valueOf(topMenuId)));
		
		request.setAttribute("subMenus", subMenus);
		
		mav.setViewName("main/leftmenu/left");
		return mav;
	}
	
	private void getSubMenus(String userId, long parMenuId) throws DAOException {
		List<MenuPrivilegeVO> subVOs = menuDao.getSubMenusByCondition(userId, parMenuId);
		subMenus.addAll(subVOs);
		if (!subVOs.isEmpty()) {
			for (MenuPrivilegeVO subVO : subVOs) {
				if (ZERO.equals(subVO.getIsLeaf())) { // 非叶子节点.
					getSubMenus(userId, subVO.getMenuId());
				}
			}
		}
	}
	
	private void getSubMenus(long parMenuId) throws DAOException {
		List<MenuPrivilegeVO> subVOs = menuDao.getSubSysMenusByCondition(parMenuId);
		subMenus.addAll(subVOs);
		if (!subVOs.isEmpty()) {
			for (MenuPrivilegeVO subVO : subVOs) {
				if (ZERO.equals(subVO.getIsLeaf())) { // 非叶子节点.
					getSubMenus(subVO.getMenuId());
				}
			}
		}
	}

}
