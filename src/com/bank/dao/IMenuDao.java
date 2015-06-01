package com.bank.dao;

import java.util.List;
import java.util.Map;

import com.bank.beans.Menu;
import com.bank.vo.MenuPrivilegeVO;
import com.common.dao.GenericDAO;
import com.common.exception.DAOException;

public interface IMenuDao extends GenericDAO<Menu, Long> {

	public List<MenuPrivilegeVO> getTopMenusByUserId(String userId) throws DAOException;	
	
	public List<MenuPrivilegeVO> getTopSysMenus(String isSuperAdmin) throws DAOException;	
	
	public List<MenuPrivilegeVO> getTopAllMenus() throws DAOException;
	
	public List<MenuPrivilegeVO> getSubMenusByCondition(String userId, long parMenuId) throws DAOException;
	
	public List<MenuPrivilegeVO> getSubSysMenusByCondition(long parMenuId) throws DAOException;

	public List<?> loadMenuTree();

	public List<Map> privilegeCheckTree(String roleId, String menuId);
	
}
