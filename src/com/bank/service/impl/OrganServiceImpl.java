package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Organ;
import com.bank.dao.IOrganDao;
import com.bank.service.IOrganService;
import com.common.exception.DAOException;

@Service("organService")
public class OrganServiceImpl implements IOrganService {
	@Resource
	private IOrganDao organDao;
	@Override
	public Organ loadOrgan(String organId) {
		Organ organ = organDao.getOrganById(organId);
		return organ;
	}
	@Override
	public String saveOrgan(Organ organ) {
		String organId = organDao.insertOrgan(organ);
		return organId;
	}
	@Override
	public void updateOrgan(Organ Organ) {
		organDao.updateOrgan(Organ);
		
	}
	@Override
	public void deleteOrgan(String organId) {
		organDao.deleteOrgan(organId);
		
	}
	@Override
	public List<Organ> loadAllOrgans(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder) {
		List<Organ> organs = organDao.loadAllOrgans(key, pageIndex, pageSize, sortField, sortOrder);
		return organs;
	}
	@Override
	public List<?> getOrganUserTree() {
		List<?> organUsers = organDao.getOrganUserTree();
		return organUsers;
	}
	@Override
	public List<?> getOrganCheckedUserTree(String roleId) {
		List<?> organCheckedUsers = organDao.getOrganCheckedUserTree(roleId);
		return organCheckedUsers;
	}
	
	public List<?> getOrganUserTreeByCondition(String unitId) throws DAOException {
		List<?> organUsers = organDao.getOrganUserTreeByCondition(unitId);
		return organUsers;
	}
	
	public List<String> getSubOrgansByUnitId(String unitId) throws DAOException {
		return organDao.getSubOrgansByUnitId(unitId);
	}

}
