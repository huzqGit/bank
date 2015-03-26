package com.bank.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

	public List<MenuPrivilegeVO> getSubMenusByCondition(@Param("userId") String userId,
			@Param("parMenuId") long parMenuId) throws DAOException {
		
		return super.getSqlSession().selectList("menu.getSubMenusByCondition", new Object[]{userId, parMenuId});
		
	}
	
}
