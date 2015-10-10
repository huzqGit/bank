package com.bank.service;


import java.util.List;
import java.util.Map;



import org.apache.ibatis.annotations.Param;

import com.bank.beans.CooperationDebt;
import com.bank.beans.CooperationDebtExample;
import com.common.service.GenericService;

public interface ICooperationDebtService extends GenericService<CooperationDebt, Long>{
	
	public long getTotal(Map<String,String> map);
	
	public Long getUnitId(Map<String,Object> map);
	
	int countByExample(CooperationDebtExample example);

	int deleteByExample(CooperationDebtExample example);

	int insert(CooperationDebt record);

	int insertSelective(CooperationDebt record);

	List<CooperationDebt> selectByExample(CooperationDebtExample example);

	int updateByExampleSelective(@Param("record") CooperationDebt record, @Param("example") CooperationDebtExample example);

	int updateByExample(@Param("record") CooperationDebt record, @Param("example") CooperationDebtExample example);	

}
