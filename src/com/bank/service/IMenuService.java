package com.bank.service;

import java.util.List;

import com.bank.beans.Menu;
import com.common.service.GenericService;

public interface IMenuService extends GenericService<Menu, Long> {

	List<?> loadMenuTree();
	
	
}
