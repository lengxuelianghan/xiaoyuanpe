package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.UserSport;
import com.xiaoyuanpe.pojo.UserSportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSportMapper {
    long countByExample(UserSportExample example);

    int deleteByExample(UserSportExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(List<Integer> ids);

    int insert(UserSport record);

    int insertSelective(UserSport record);

    List<UserSport> selectByExample(UserSportExample example);

    UserSport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserSport record, @Param("example") UserSportExample example);

    int updateByExample(@Param("record") UserSport record, @Param("example") UserSportExample example);

    int updateByPrimaryKeySelective(UserSport record);

    int updateByPrimaryKey(UserSport record);
}