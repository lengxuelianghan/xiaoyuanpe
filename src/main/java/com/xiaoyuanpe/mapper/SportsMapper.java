package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Sports;
import com.xiaoyuanpe.pojo.SportsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SportsMapper {
    long countByExample(SportsExample example);

    int deleteByExample(SportsExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(List<Integer> ids);

    int insert(Sports record);

    int insertSelective(Sports record);

    List<Sports> selectByExampleWithBLOBs(SportsExample example);

    List<Sports> selectByExample(SportsExample example);

    Sports selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sports record, @Param("example") SportsExample example);

    int updateByExampleWithBLOBs(@Param("record") Sports record, @Param("example") SportsExample example);

    int updateByExample(@Param("record") Sports record, @Param("example") SportsExample example);

    int updateByPrimaryKeySelective(Sports record);

    int updateByPrimaryKeyWithBLOBs(Sports record);

    int updateByPrimaryKey(Sports record);
}