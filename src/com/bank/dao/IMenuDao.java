package com.bank.dao;

import java.util.List;

import com.bank.beans.Menu;
import com.bank.vo.MenuPrivilegeVO;
import com.common.dao.GenericDAO;
import com.common.exception.DAOException;

public interface IMenuDao extends GenericDAO<Menu, Long> {

	public List<MenuPrivilegeVO> getTopMenusByUserId(String userId) throws DAOException;	
	
	public List<MenuPrivilegeVO> getSubMenusByCondition(String userId, long parMenuId) throws DAOException;
	
}
