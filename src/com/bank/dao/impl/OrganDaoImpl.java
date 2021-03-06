package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bank.beans.Organ;
import com.bank.common.base.BaseDaoImpl;
import com.bank.dao.IOrganDao;
import com.common.exception.DAOException;

@Repository("organDao")
public class OrganDaoImpl extends BaseDaoImpl implements IOrganDao {

	@Override
	public Organ getOrganById(String organId) {
		Organ organ = getSqlSession().selectOne("organ.selectByPrimaryKey", organId);
		return organ;
	}

	public String insertOrgan(Organ organ) {
		String organId = (organ.getOrganId() == null || organ.getOrganId().toString().equals(""))? UUID.randomUUID().toString() : organ.getOrganId();
		organ.setOrganId(organId);
		getSqlSession().insert("organ.insert", organ);
		return organId;
	}
	
	@Override
	public void updateOrgan(Organ organ) {
		getSqlSession().update("organ.update", organ);
		
	}

	public void deleteOrgan(String organId) {
		getSqlSession().delete("organ.delete", organId);
	}

	@Override
	public List<Organ> loadAllOrgans(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder) {
		int start = pageIndex * pageSize, end = start + pageSize;
		List<Organ> organs = getSqlSession().selectList("organ.loadAllOrgans", new Object[]{key, start, end, sortOrder});
		return organs;
	}

	@Override
	public List<?> getOrganUserTree() {
		List<?> organUser = getSqlSession().selectList("organ.organUser");
		return organUser;
	}

	@Override
	public List<?> getOrganCheckedUserTree(String roleId) {
		List<?> organCheckedUser = getSqlSession().selectList("organ.organCheckedUser", roleId);
		return organCheckedUser;
	}
	
	public List<?> getOrganUserTreeByCondition(String unitId) throws DAOException {
		List<?> organUser = getSqlSession().selectList("organ.organUserByCondition", unitId);
		return organUser;
	}

	public List<String> getSubOrgansByUnitId(String unitId) throws DAOException {
		return super.getSqlSession().selectList("organ.getSubOrgansByUnitId", unitId);
	}

	public int getCountByOrganPId(String organPId) throws DAOException {
		return super.getSqlSession().selectOne("organ.getCountByOrganPId", organPId);
	}
	
	public List<Organ> getOrganTreeByUnitId(String unitId) throws DAOException {
		return super.getSqlSession().selectList("organ.organTreeByUnitId", unitId);
	}
	
	public List<?> getOrganCheckedUserByCondition(String organId, String roleId) throws DAOException {
		Map paramMap = new HashMap();
		paramMap.put("organId", organId);
		paramMap.put("roleId", roleId);
		return super.getSqlSession().selectList("organ.organCheckedUserByCondition", paramMap);
	}

}
