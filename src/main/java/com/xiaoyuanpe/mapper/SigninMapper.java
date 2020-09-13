package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Signin;
import com.xiaoyuanpe.pojo.SigninExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SigninMapper {
    long countByExample(SigninExample example);

    int deleteByExample(SigninExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Signin record);

    int insertSelective(Signin record);

    List<Signin> selectByExample(SigninExample example);

    Signin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Signin record, @Param("example") SigninExample example);

    int updateByExample(@Param("record") Signin record, @Param("example") SigninExample example);

    int updateByPrimaryKeySelective(Signin record);

    int updateByPrimaryKey(Signin record);
}