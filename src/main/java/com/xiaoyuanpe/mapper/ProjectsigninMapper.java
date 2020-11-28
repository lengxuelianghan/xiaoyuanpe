package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Projectsignin;
import com.xiaoyuanpe.pojo.ProjectsigninExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectsigninMapper {
    long countByExample(ProjectsigninExample example);

    int deleteByExample(ProjectsigninExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Projectsignin record);

    int insertSelective(Projectsignin record);

    List<Projectsignin> selectByExample(ProjectsigninExample example);

    Projectsignin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Projectsignin record, @Param("example") ProjectsigninExample example);

    int updateByExample(@Param("record") Projectsignin record, @Param("example") ProjectsigninExample example);

    int updateByPrimaryKeySelective(Projectsignin record);

    int updateByPrimaryKey(Projectsignin record);
}