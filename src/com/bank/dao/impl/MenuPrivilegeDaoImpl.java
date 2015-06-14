package com.bank.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bank.beans.Menu;
import com.bank.beans.MenuPrivilege;
import com.bank.dao.IMenuPrivilegeDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;
import com.common.exception.DAOException;

@Repository("menuPrivilegeDao")
public class MenuPrivilegeDaoImpl extends GenericMyBatisDAOSupport<MenuPrivilege, String> implements IMenuPrivilegeDao {

	@Override
	public void updateMenuPrivilege(ArrayList rows, String roleId, String menuId) {
		Map map = new HashMap();
		map.put("roleId", roleId);
		map.put("menuId", menuId);
		super.getSqlSession().delete("menuprivilege.deleteByMenuIdAndRoleId", map);
		
	    for(int i=0,l=rows.size(); i<l; i++){
	    	HashMap row = (HashMap)rows.get(i);
	    	
			String pkId = UUID.randomUUID().toString();
			MenuPrivilege menuPrivilege = new MenuPrivilege();
			menuPrivilege.setPkId(pkId);
			menuPrivilege.setMenuId(Integer.valueOf(menuId));
			menuPrivilege.setPrivilegeId(row.get("privilegeId").toString());
			menuPrivilege.setRoleId(roleId);
			if (row.get("checked") != null && row.get("checked").toString().equals("true")) {
				super.getSqlSession().insert("menuprivilege.insertSelective", menuPrivilege);
			}
	    }
	}

	public void updateMenuPrivilege(List rows, String roleId, List<Menu> menus) throws DAOException {
		
		if (menus.isEmpty()) return;
		
		for (Menu menu : menus) {
			
			if (menu.getMenuId() == 0) continue;
			
			Map map = new HashMap();
			map.put("roleId", roleId);
			map.put("menuId", menu.getMenuId());
			super.getSqlSession().delete("menuprivilege.deleteByMenuIdAndRoleId", map);
			
			for(int i=0,l=rows.size(); i<l; i++){
				HashMap row = (HashMap)rows.get(i);
				
				String pkId = UUID.randomUUID().toString();
				MenuPrivilege menuPrivilege = new MenuPrivilege();
				menuPrivilege.setPkId(pkId);
				menuPrivilege.setMenuId(menu.getMenuId());
				menuPrivilege.setPrivilegeId(row.get("privilegeId").toString());
				menuPrivilege.setRoleId(roleId);
				if (row.get("checked") != null && row.get("checked").toString().equals("true")) {
					super.getSqlSession().insert("menuprivilege.insertSelective", menuPrivilege);
				}
			}
		}
		
	}
	
}
