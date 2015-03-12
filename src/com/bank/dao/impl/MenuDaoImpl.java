package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.Menu;
import com.bank.dao.IMenuDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("menuDao")
public class MenuDaoImpl extends GenericMyBatisDAOSupport<Menu, String> implements IMenuDao {

}
