package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Permissions;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    User selectByStudentNum(String num);

    User selectByPrimaryNumber(String unumber);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteByPrimaryKeys(List<Integer> id);

    User findRolesByUsername(String userNumber);

    List<Permissions> findPermsByRoleId(Integer id);

    User selectByStudentNumAndSchool(@Param("num") String num, @Param("id") Integer id);

    int insertBatch(List<User> list);
}