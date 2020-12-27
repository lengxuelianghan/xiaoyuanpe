package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.SportvenueItem;
import com.xiaoyuanpe.pojo.SportvenueItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SportvenueItemMapper {
    long countByExample(SportvenueItemExample example);

    int deleteByExample(SportvenueItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SportvenueItem record);

    int insertSelective(SportvenueItem record);

    List<SportvenueItem> selectByExample(SportvenueItemExample example);

    SportvenueItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SportvenueItem record, @Param("example") SportvenueItemExample example);

    int updateByExample(@Param("record") SportvenueItem record, @Param("example") SportvenueItemExample example);

    int updateByPrimaryKeySelective(SportvenueItem record);

    int updateByPrimaryKey(SportvenueItem record);
}