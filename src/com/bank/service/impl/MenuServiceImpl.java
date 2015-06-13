package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Menu;
import com.bank.dao.IMenuDao;
import com.bank.service.IMenuService;
import com.common.dao.GenericDAO;
import com.common.exception.DAOException;
import com.common.service.impl.GenericServiceImpl;

@Service("menuService")
public class MenuServiceImpl extends GenericServiceImpl<Menu, Long> implements IMenuService {
	
	@Resource
	private IMenuDao menuDao;
	
	

	@Override
	public GenericDAO<Menu, Long> getGenericDAO() {
		return menuDao;
	}



	public List<?> loadMenuTree() {
		List<?> list = menuDao.loadMenuTree();
		return list;
	}



	@Override
	public List<Map> privilegeCheckTree(String roleId, String menuId) {
		return menuDao.privilegeCheckTree(roleId, menuId);
	}


	public List<?> getMenuTreeByFilterSystem() throws DAOException {
		return menuDao.getMenuTreeByFilterSystem();
	}
	
	

}
