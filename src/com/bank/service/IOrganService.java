package com.bank.service;

import java.util.List;

import com.bank.beans.Organ;

public interface IOrganService {

	Organ loadOrgan(String organId);

	String saveOrgan(Organ organ);

	void updateOrgan(Organ organ);

	boolean deleteOrgan(String organId);

	List<Organ> loadAllOrgans(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder);

	List<?> getOrganUserTree();

}
