package test.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.model.FarmerCredit;
import test.model.FarmerCreditExample;

public interface FarmerCreditMapper {
    int countByExample(FarmerCreditExample example);

    int deleteByExample(FarmerCreditExample example);

    int insert(FarmerCredit record);

    int insertSelective(FarmerCredit record);

    List<FarmerCredit> selectByExample(FarmerCreditExample example);

    int updateByExampleSelective(@Param("record") FarmerCredit record, @Param("example") FarmerCreditExample example);

    int updateByExample(@Param("record") FarmerCredit record, @Param("example") FarmerCreditExample example);
}