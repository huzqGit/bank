package com.bank.dao.impl;

import org.springframework.stereotype.Repository;

import com.bank.beans.CompanyInvest;
import com.bank.dao.ICompanyInvestDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("companyInvestDao")
public class CompanyInvestDaoImpl extends GenericMyBatisDAOSupport<CompanyInvest, Long> implements ICompanyInvestDao {
}
