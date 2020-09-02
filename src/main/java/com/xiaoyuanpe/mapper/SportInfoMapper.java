package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.SportInfo;
import com.xiaoyuanpe.pojo.SportInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SportInfoMapper {
    long countByExample(SportInfoExample example);

    int deleteByExample(SportInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(List<Integer> ids);

    int insert(SportInfo record);

    int insertSelective(SportInfo record);

    List<SportInfo> selectByExample(SportInfoExample example);

    SportInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SportInfo record, @Param("example") SportInfoExample example);

    int updateByExample(@Param("record") SportInfo record, @Param("example") SportInfoExample example);

    int updateByPrimaryKeySelective(SportInfo record);

    int updateByPrimaryKey(SportInfo record);
}