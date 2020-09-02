package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Identities;
import com.xiaoyuanpe.pojo.IdentitiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdentitiesMapper {
    long countByExample(IdentitiesExample example);

    int deleteByExample(IdentitiesExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(List<Integer> ids);

    int insert(Identities record);

    int insertSelective(Identities record);

    List<Identities> selectByExample(IdentitiesExample example);

    Identities selectByPrimaryKey(Integer id);

    Identities selectByPrimaryName(String name);

    int updateByExampleSelective(@Param("record") Identities record, @Param("example") IdentitiesExample example);

    int updateByExample(@Param("record") Identities record, @Param("example") IdentitiesExample example);

    int updateByPrimaryKeySelective(Identities record);

    int updateByPrimaryKey(Identities record);
}