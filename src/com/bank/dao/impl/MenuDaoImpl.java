package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.Menu;
import com.bank.dao.IMenuDao;
import com.bank.vo.MenuPrivilegeVO;
import com.common.dao.impl.GenericMyBatisDAOSupport;
import com.common.exception.DAOException;

@Repository("menuDao")
public class MenuDaoImpl extends GenericMyBatisDAOSupport<Menu, Long> implements IMenuDao {

	public List<MenuPrivilegeVO> getTopMenusByUserId(String userId) throws DAOException {
		
		return super.getSqlSession().selectList("menu.getTopMenusByUserId", userId);
		
	}

	public List<MenuPrivilegeVO> getSubMenusByCondition( String userId, long parMenuId) throws DAOException {
		
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("parMenuId", String.valueOf(parMenuId));
		
		return super.getSqlSession().selectList("menu.getSubMenusByCondition", map);
		
	}

	@Override
	public List<?> loadMenuTree() {
		List<?> menuTree = getSqlSession().selectList("menu.menutree");
		return menuTree;
	}
	
}
