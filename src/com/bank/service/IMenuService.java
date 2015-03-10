package com.bank.service;

import java.util.List;

import com.bank.beans.Menu;

public interface IMenuService {

	Menu load(String userId);

	String save(Menu menu);

	void update(Menu menu);

	boolean delete(String userId);

	List<Menu> loadMenus();
}
