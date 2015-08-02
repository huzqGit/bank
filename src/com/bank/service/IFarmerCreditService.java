package com.bank.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;






import com.bank.beans.FarmerCredit;
import com.bank.beans.FarmerCreditExample;

public interface IFarmerCreditService  {
	
    public int countByExample(FarmerCreditExample example);

    int deleteByExample(FarmerCreditExample example);

    int insert(FarmerCredit record);

    int insertSelective(FarmerCredit record);

    List<FarmerCredit> selectByExample(FarmerCreditExample example);

    int updateByExampleSelective(@Param("record") FarmerCredit record, @Param("example") FarmerCreditExample example);

    int updateByExample(@Param("record") FarmerCredit record, @Param("example") FarmerCreditExample example);
   
    @SuppressWarnings("rawtypes")
	public List<FarmerCredit>getPageingEntities(int pageIndex,int pageSize,
    		String sortField,String sortOrder,Map query);
}
