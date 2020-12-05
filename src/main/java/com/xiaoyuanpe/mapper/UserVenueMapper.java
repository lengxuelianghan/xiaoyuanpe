package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.UserVenue;
import com.xiaoyuanpe.pojo.UserVenueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserVenueMapper {
    long countByExample(UserVenueExample example);

    int deleteByExample(UserVenueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserVenue record);

    int insertSelective(UserVenue record);

    List<UserVenue> selectByExample(UserVenueExample example);

    UserVenue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserVenue record, @Param("example") UserVenueExample example);

    int updateByExample(@Param("record") UserVenue record, @Param("example") UserVenueExample example);

    int updateByPrimaryKeySelective(UserVenue record);

    int updateByPrimaryKey(UserVenue record);
}