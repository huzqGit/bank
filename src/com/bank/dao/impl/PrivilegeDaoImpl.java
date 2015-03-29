package com.bank.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bank.beans.Privilege;
import com.bank.dao.IPrivilegeDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends GenericMyBatisDAOSupport<Privilege, String> implements
		IPrivilegeDao {

	@Override
	public void save(HashMap row) {
		String id = row.get("privilegeId") == null || row.get("privilegeId").equals("") ? UUID.randomUUID().toString() : row.get("privilegeId").toString();
		Privilege privilege = new Privilege();
		privilege.setPrivilegeId(id);
		privilege.setPrivilegeType(row.get("privilegeType").toString());
		super.getSqlSession().update("privilege.insertSelective", privilege);
		
	}

	@Override
	public void update(HashMap row) throws Exception {
		HashMap db_privilege = getRole(row.get("privilegeId").toString());
        
        Iterator iter = row.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            
            db_privilege.put(key, val);
        }         

        delete(row.get("privilegeId").toString());
        save(db_privilege);
		
	}
	
	private HashMap getRole(String privilegeId) {
		List data = super.getSqlSession().selectList("privilege.allByPrivilegeId", privilegeId);
		return data.size() > 0 ? (HashMap)data.get(0) : null;
	}


}
