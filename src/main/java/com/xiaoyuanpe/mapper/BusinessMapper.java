package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Business;
import com.xiaoyuanpe.pojo.BusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessMapper {
    long countByExample(BusinessExample example);

    int deleteByExample(BusinessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Business record);

    int insertSelective(Business record);

    List<Business> selectByExampleWithBLOBs(BusinessExample example);

    List<Business> selectByExample(BusinessExample example);

    Business selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Business record, @Param("example") BusinessExample example);

    int updateByExampleWithBLOBs(@Param("record") Business record, @Param("example") BusinessExample example);

    int updateByExample(@Param("record") Business record, @Param("example") BusinessExample example);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKeyWithBLOBs(Business record);

    int deleteByPrimaryList(List<Integer> id);

    int updateByPrimaryKey(Business record);
}