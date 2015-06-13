package com.bank.dao;

import java.util.List;

import com.bank.beans.Organ;
import com.common.exception.DAOException;

public interface IOrganDao {

	Organ getOrganById(String organId);

	String insertOrgan(Organ organ);

	void updateOrgan(Organ organ);

	void deleteOrgan(String organId);

	List<Organ> loadAllOrgans(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder);

	List<?> getOrganUserTree();

	List<?> getOrganCheckedUserTree(String roleId);
	
	List<?> getOrganUserTreeByCondition(String unitId) throws DAOException;
	
	List<String> getSubOrgansByUnitId(String unitId) throws DAOException;
	
	int getCountByOrganPId(String organPId) throws DAOException;
	
	List<Organ> getOrganTreeByUnitId(String unitId) throws DAOException;
	
	List<?> getOrganCheckedUserByCondition(String organId, String roleId) throws DAOException;

}
