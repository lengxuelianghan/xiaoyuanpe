package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Venue;
import com.xiaoyuanpe.pojo.VenueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VenueMapper {
    long countByExample(VenueExample example);

    int deleteByExample(VenueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Venue record);

    int insertSelective(Venue record);

    List<Venue> selectByExampleWithBLOBs(VenueExample example);

    List<Venue> selectByExample(VenueExample example);

    Venue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Venue record, @Param("example") VenueExample example);

    int updateByExampleWithBLOBs(@Param("record") Venue record, @Param("example") VenueExample example);

    int updateByExample(@Param("record") Venue record, @Param("example") VenueExample example);

    int updateByPrimaryKeySelective(Venue record);

    int updateByPrimaryKeyWithBLOBs(Venue record);

    int updateByPrimaryKey(Venue record);
}