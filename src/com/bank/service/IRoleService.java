package com.bank.service;

import java.util.HashMap;

import com.bank.beans.Role;
import com.common.service.GenericService;

public interface IRoleService extends GenericService<Role, String> {

	void save(HashMap row);

	void update(HashMap row) throws Exception;

}
