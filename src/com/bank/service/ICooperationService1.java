package com.bank.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bank.beans.Cooperation;
import com.bank.beans.CooperationExample;



public interface ICooperationService1 {
	
    int countByExample(CooperationExample example);

    int deleteByExample(CooperationExample example);

    int insert(Cooperation record);

    int insertSelective(Cooperation record);

    List<Cooperation> selectByExample(CooperationExample example);

    int updateByExampleSelective(@Param("record") Cooperation record, @Param("example") CooperationExample example);

    int updateByExample(@Param("record") Cooperation record, @Param("example") CooperationExample example);
}
