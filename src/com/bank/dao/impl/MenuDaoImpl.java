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
	
	public List<MenuPrivilegeVO> getTopSysMenus(String isSuperAdmin) throws DAOException {
		return super.getSqlSession().selectList("menu.getTopSysMenus", isSuperAdmin);
	}
	
	public List<MenuPrivilegeVO> getTopAllMenus() throws DAOException {
		return super.getSqlSession().selectList("menu.getTopAllMenus");
	}

	public List<MenuPrivilegeVO> getSubMenusByCondition( String userId, long parMenuId) throws DAOException {
		
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("parMenuId", String.valueOf(parMenuId));
		
		return super.getSqlSession().selectList("menu.getSubMenusByCondition", map);
		
	}
	
	public List<MenuPrivilegeVO> getSubSysMenusByCondition(long parMenuId) throws DAOException {
		return super.getSqlSession().selectList("menu.getSubSysMenusByCondition", parMenuId);
	}

	@Override
	public List<?> loadMenuTree() {
		long t1 = System.currentTimeMillis();
		List<?> menuTree = getSqlSession().selectList("menu.menutree");
		long t2 = System.currentTimeMillis();
		System.out.println("loadMenuTree：" + (t2 - t1) + ".ms");
		return menuTree;
	}

	@Override
	public List<Map> privilegeCheckTree(String roleId, String menuId) {
		Map<String, Object> map = new HashMap();
		map.put("roleId", roleId);
		map.put("menuId", Integer.parseInt(menuId));
		List<Map> privilegeCheckTree = getSqlSession().selectList("menu.privilegeCheckTree", map);
		return privilegeCheckTree;
	}
	
}
