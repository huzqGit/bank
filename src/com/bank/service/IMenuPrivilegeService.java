package com.bank.service;

import java.util.ArrayList;
import java.util.List;

import com.bank.beans.Menu;
import com.bank.beans.MenuPrivilege;
import com.common.exception.DAOException;
import com.common.service.GenericService;

public interface IMenuPrivilegeService extends GenericService<MenuPrivilege, String> {

	void updateMenuPrivilege(ArrayList rows, String roleId, String menuId);
	
	void updateMenuPrivilege(List rows, String roleId, List<Menu> menus) throws DAOException;


}
