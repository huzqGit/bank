package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Menu;
import com.bank.dao.IMenuDao;
import com.bank.service.IMenuService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("menuService")
public class MenuServiceImpl extends GenericServiceImpl<Menu, Long> implements IMenuService {
	
	@Resource
	private IMenuDao menuDao;
	
	

	@Override
	public GenericDAO<Menu, Long> getGenericDAO() {
		return menuDao;
	}



	@Override
	public List<?> loadMenuTree() {
		return menuDao.loadMenuTree();
	}



	@Override
	public List<?> privilegeCheckTree(String roleId, String menuId) {
		// TODO Auto-generated method stub
		return menuDao.privilegeCheckTree(roleId, menuId);
	}
	

}
