package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Sportvenue;
import com.xiaoyuanpe.pojo.SportvenueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SportvenueMapper {
    long countByExample(SportvenueExample example);

    int deleteByExample(SportvenueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sportvenue record);

    int insertSelective(Sportvenue record);

    List<Sportvenue> selectByExampleWithBLOBs(SportvenueExample example);

    List<Sportvenue> selectByExample(SportvenueExample example);

    Sportvenue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sportvenue record, @Param("example") SportvenueExample example);

    int updateByExampleWithBLOBs(@Param("record") Sportvenue record, @Param("example") SportvenueExample example);

    int updateByExample(@Param("record") Sportvenue record, @Param("example") SportvenueExample example);

    int updateByPrimaryKeySelective(Sportvenue record);

    int updateByPrimaryKeyWithBLOBs(Sportvenue record);

    int updateByPrimaryKey(Sportvenue record);
}