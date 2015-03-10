package com.bank.dao;

import java.util.List;

import com.bank.beans.Organ;

public interface IOrganDao {

	Organ getOrganById(String organId);

	String insertOrgan(Organ organ);

	void updateOrgan(Organ organ);

	boolean deleteOrgan(String organId);

	List<Organ> loadAllOrgans(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder);

	List<?> getOrganUserTree();

}
