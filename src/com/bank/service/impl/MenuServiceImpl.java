package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Menu;
import com.bank.dao.IMenuDao;
import com.bank.service.IMenuService;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {
	@Resource
	private IMenuDao menuDao;
	@Override
	public Menu load(String menuId) {
		Menu Menu = menuDao.load(menuId);
		return Menu;
	}
	@Override
	public String save(Menu menu) {
		String menuId = menuDao.insert(menu);
		return menuId;
	}
	@Override
	public void update(Menu menu) {
		menuDao.update(menu);
		
	}
	@Override
	public boolean delete(String menuId) {
		boolean flag = menuDao.delete(menuId);
		return flag;
	}
	@Override
	public List<Menu> loadMenus() {
		List<Menu> menus = menuDao.loadMenus();
		return menus;
	}
	

}
