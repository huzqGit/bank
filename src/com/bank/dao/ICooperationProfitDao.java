package com.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bank.beans.CooperationProfit;
import com.bank.beans.CooperationProfitExample;
import com.common.dao.GenericDAO;

public interface ICooperationProfitDao extends GenericDAO<CooperationProfit, Long>{
	
	public long getTotal(Map<String,String> map);
	
	public Long getUnitId(Map<String,Object> map);
	
	int countByExample(CooperationProfitExample example);
	

    int deleteByExample(CooperationProfitExample example);

    int insert(CooperationProfit record);

    int insertSelective(CooperationProfit record);

    List<CooperationProfit> selectByExample(CooperationProfitExample example);

    int updateByExampleSelective(@Param("record") CooperationProfit record, @Param("example") CooperationProfitExample example);

    int updateByExample(@Param("record") CooperationProfit record, @Param("example") CooperationProfitExample example);
}
