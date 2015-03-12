package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Menu;
import com.bank.dao.IMenuDao;
import com.bank.service.IMenuService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("menuService")
public class MenuServiceImpl extends GenericServiceImpl<Menu, String> implements IMenuService {
	
	@Resource
	private IMenuDao menuDao;
	
	

	@Override
	public GenericDAO<Menu, String> getGenericDAO() {
		return menuDao;
	}
	
	

}
