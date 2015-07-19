package test.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.model.Cooperation;
import test.model.CooperationExample;

public interface CooperationMapper {
    int countByExample(CooperationExample example);

    int deleteByExample(CooperationExample example);

    int insert(Cooperation record);

    int insertSelective(Cooperation record);

    List<Cooperation> selectByExample(CooperationExample example);

    int updateByExampleSelective(@Param("record") Cooperation record, @Param("example") CooperationExample example);

    int updateByExample(@Param("record") Cooperation record, @Param("example") CooperationExample example);
}