package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.SportStud;
import com.xiaoyuanpe.pojo.SportStudExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SportStudMapper {
    long countByExample(SportStudExample example);

    int deleteByExample(SportStudExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SportStud record);

    int insertSelective(SportStud record);

    List<SportStud> selectByExample(SportStudExample example);

    SportStud selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SportStud record, @Param("example") SportStudExample example);

    int updateByExample(@Param("record") SportStud record, @Param("example") SportStudExample example);

    int updateByPrimaryKeySelective(SportStud record);

    int updateByPrimaryKey(SportStud record);

    SportStud findSportStudByStudentId(Integer id);

    void deleteSportStud(@Param("sportId") Integer sportId, @Param("studentId") Integer studentId);
}