package com.bank.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;





import com.bank.beans.Cooperation;
import com.bank.beans.CooperationExample;
import com.common.dao.GenericDAO;

public interface ICooperationDao extends GenericDAO<Cooperation, Long>{
	
	public long getTotal(Map<String,String> map);
	
	public List<Map<String,Object>> getCooperationTree(Map<String,Object> map);
	
	public Long getUnitId(Map<String,Object> map);
	
    int countByExample(CooperationExample example);

    int deleteByExample(CooperationExample example);

    int insert(Cooperation record);

    int insertSelective(Cooperation record);

    List<Cooperation> selectByExample(CooperationExample example);

    int updateByExampleSelective(@Param("record") Cooperation record, @Param("example") CooperationExample example);

    int updateByExample(@Param("record") Cooperation record, @Param("example") CooperationExample example);
}
