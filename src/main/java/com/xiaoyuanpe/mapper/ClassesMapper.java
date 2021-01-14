package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Classes;
import com.xiaoyuanpe.pojo.ClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassesMapper {
    long countByExample(ClassesExample example);

    int deleteByExample(ClassesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Classes record);

    int insertSelective(Classes record);

    List<Classes> selectByExample(ClassesExample example);

    Classes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByExample(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

    void deleteByPrimaryKeys(List<Integer> ids);

    List<Classes> selectBySchool(Integer id);

    List<Classes> selectByCollege(Integer id);

    List<Classes> findClassesByCollege(Integer id);
}