package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.RolePerm;
import com.xiaoyuanpe.pojo.RolePermExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermMapper {
    long countByExample(RolePermExample example);

    int deleteByExample(RolePermExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePerm record);

    int insertSelective(RolePerm record);

    List<RolePerm> selectByExample(RolePermExample example);

    RolePerm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePerm record, @Param("example") RolePermExample example);

    int updateByExample(@Param("record") RolePerm record, @Param("example") RolePermExample example);

    int updateByPrimaryKeySelective(RolePerm record);

    int updateByPrimaryKey(RolePerm record);
}