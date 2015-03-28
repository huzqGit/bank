package com.bank.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bank.beans.Role;
import com.bank.dao.IRoleDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;
import com.common.exception.DAOException;
import com.common.exception.DeleteException;

@Repository("roleDao")
public class RoleDaoImpl extends GenericMyBatisDAOSupport<Role, String> implements
		IRoleDao {

	@Override
	public void save(HashMap row) {
		String id = row.get("roleId") == null || row.get("roleId").equals("") ? UUID.randomUUID().toString() : row.get("roleId").toString();
		Role role = new Role();
		role.setRoleId(id);
		role.setRoleName(row.get("roleName").toString());
		role.setRoleDescr(row.get("roleDescr").toString());
		super.getSqlSession().update("role.insertSelective", role);
		
	}

	@Override
	public void update(HashMap row) throws Exception {
		HashMap db_user = getRole(row.get("roleId").toString());
        
        Iterator iter = row.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            
            db_user.put(key, val);
        }         

        delete(row.get("roleId").toString());
        save(db_user);
		
	}

	private HashMap getRole(String roleId) {
		List data = super.getSqlSession().selectList("role.allByRoleId", roleId);
		return data.size() > 0 ? (HashMap)data.get(0) : null;
	}


}
