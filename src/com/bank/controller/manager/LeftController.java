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
import com.common.exception.DAOException;

@Controller
@RequestMapping(value = "/user")

public class LeftController extends BaseController {
	private static Logger log = LoggerFactory.getLogger(LeftController.class);
	private static final String ZERO = "0";
	
	@Resource 
	private IMenuDao menuDao;
	private List<MenuPrivilegeVO> subMenus = new ArrayList<MenuPrivilegeVO>();
	
	@RequestMapping(value = "/left")
    public ModelAndView getSubMenus(@ModelAttribute("topMenuId") String topMenuId,HttpServletRequest request) throws Exception{
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		ModelAndView mav = new ModelAndView();
		
		if (StringUtils.isEmpty(topMenuId)) throw new DAOException("topMenuId 不能为空!");
		
		// get all subMenus
		getSubMenus(user.getUserId(), Long.valueOf(topMenuId));
		
		request.setAttribute("subMenus", subMenus);
		
		mav.setViewName("main/left");
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

}
