package com.bank.service;

import java.util.ArrayList;

import com.bank.beans.MenuPrivilege;
import com.common.service.GenericService;

public interface IMenuPrivilegeService extends GenericService<MenuPrivilege, String> {

	void updateMenuPrivilege(ArrayList rows, String roleId, String menuId);


}
