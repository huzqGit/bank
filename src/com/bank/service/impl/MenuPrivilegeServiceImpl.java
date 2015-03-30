package com.bank.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Menu;
import com.bank.beans.MenuPrivilege;
import com.bank.dao.IMenuDao;
import com.bank.dao.IMenuPrivilegeDao;
import com.bank.service.IMenuPrivilegeService;
import com.bank.service.IMenuService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("menuPrivilegeService")
public class MenuPrivilegeServiceImpl extends GenericServiceImpl<MenuPrivilege, String> implements IMenuPrivilegeService {
	
	@Resource
	private IMenuPrivilegeDao menuPrivilegeDao;
	
	

	@Override
	public GenericDAO<MenuPrivilege, String> getGenericDAO() {
		return menuPrivilegeDao;
	}



	@Override
	public void updateMenuPrivilege(ArrayList rows, String roleId, String menuId) {
		menuPrivilegeDao.updateMenuPrivilege(rows, roleId, menuId);
		
	}

	

}
