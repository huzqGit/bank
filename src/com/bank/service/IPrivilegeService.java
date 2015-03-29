package com.bank.service;

import java.util.HashMap;

import com.bank.beans.Privilege;
import com.common.service.GenericService;

public interface IPrivilegeService extends GenericService<Privilege, String> {

	void save(HashMap row);

	void update(HashMap row) throws Exception;

}
