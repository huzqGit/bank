package com.bank.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Organ;
import com.bank.dao.IOrganDao;
import com.bank.service.IOrganService;

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
	public boolean deleteOrgan(String organId) {
		boolean flag = organDao.deleteOrgan(organId);
		return flag;
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
	

}
