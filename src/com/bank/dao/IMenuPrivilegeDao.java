package com.bank.dao;

import java.util.ArrayList;

import com.bank.beans.MenuPrivilege;
import com.common.dao.GenericDAO;

public interface IMenuPrivilegeDao  extends GenericDAO<MenuPrivilege, String> {

	void updateMenuPrivilege(ArrayList rows, String roleId, String menuId);

}
