package com.bank.dao;

import java.util.List;

import com.bank.beans.Menu;
import com.common.dao.GenericDAO;

public interface IMenuDao extends GenericDAO<Menu, String> {

	Menu load(String menuId);

	String insert(Menu menu);

	void update(Menu menu);

	boolean delete(String menuId);

	List<Menu> loadMenus();

}
