package com.bank.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bank.beans.Menu;
import com.bank.common.dao.impl.GenericMyBatisDAOSupport;
import com.bank.dao.IMenuDao;

@Repository("menuDao")
public class MenuDaoImpl extends GenericMyBatisDAOSupport<Menu, String> implements IMenuDao {

	@Override
	public Menu load(String menuId) {
		Menu menu = getSqlSession().selectOne("menu.selectByPrimaryKey", menuId);
		return menu;
	}

	@Override
	public String insert(Menu menu) {
		String menuId = (menu.getMenuId() == null || menu.getMenuId().toString().equals(""))? UUID.randomUUID().toString() : menu.getMenuId();
		menu.setMenuId(menuId);
		getSqlSession().insert("menu.insert", menu);
		return menuId;
	}

	@Override
	public void update(Menu menu) {
		getSqlSession().update("menu.update", menu);
		
	}

	@Override
	public boolean delete(String menuId) {
		int flag = getSqlSession().delete("menu.delete", menuId);
		return false;
	}

	@Override
	public List<Menu> loadMenus() {
		List<Menu> menus = getSqlSession().selectList("menu.loadMenus");
		return menus;
	}

}
