package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import com.bank.beans.Menu;
import com.bank.beans.MenuPrivilege;
import com.common.dao.GenericDAO;
import com.common.exception.DAOException;

public interface IMenuPrivilegeDao  extends GenericDAO<MenuPrivilege, String> {

	void updateMenuPrivilege(ArrayList rows, String roleId, String menuId);
	
	void updateMenuPrivilege(List rows, String roleId, List<Menu> menus) throws DAOException;

}
