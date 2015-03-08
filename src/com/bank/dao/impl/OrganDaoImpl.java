package com.bank.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bank.beans.Organ;
import com.bank.common.base.BaseDaoImpl;
import com.bank.dao.IOrganDao;

@Repository("organDao")
public class OrganDaoImpl extends BaseDaoImpl implements IOrganDao {

	@Override
	public Organ getOrganById(String organId) {
		Organ Organ = getSqlSession().selectOne("getOrganById", organId);
		return Organ;
	}

	public String insertOrgan(Organ organ) {
		String organId = (organ.getOrganId() == null || organ.getOrganId().toString().equals(""))? UUID.randomUUID().toString() : organ.getOrganId();
		organ.setOrganId(organId);
		getSqlSession().insert("insertOrgan", organ);
		return organId;
	}
	
	@Override
	public void updateOrgan(Organ organ) {
		getSqlSession().update("updateOrgan", organ);
		
	}

	public boolean deleteOrgan(String organId) {
		int flag = getSqlSession().delete("deleteOrgan", organId);
		return false;
	}

	@Override
	public List<Organ> loadAllOrgans(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder) {
		int start = pageIndex * pageSize, end = start + pageSize;
		List<Organ> organs = getSqlSession().selectList("loadAllOrgans", new Object[]{key, start, end, sortOrder});
		return organs;
	}

	@Override
	public List<?> getOrganUserTree() {
		
		return null;
	}



}
