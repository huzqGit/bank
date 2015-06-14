package com.bank.service;

import java.util.List;
import java.util.Map;

import com.bank.beans.Menu;
import com.common.exception.DAOException;
import com.common.service.GenericService;

public interface IMenuService extends GenericService<Menu, Long> {

	List<?> loadMenuTree();

	List<Map> privilegeCheckTree(String roleId, String menuId);
	
	List<?> getMenuTreeByFilterSystem() throws DAOException;
	
	List<Menu> getParMenusByCondition(String childMenuId) throws DAOException;
	
}
