package com.xiaoyuanpe.mapper;

import com.xiaoyuanpe.pojo.Semester;
import com.xiaoyuanpe.pojo.SemesterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SemesterMapper {
    long countByExample(SemesterExample example);

    int deleteByExample(SemesterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Semester record);

    int insertSelective(Semester record);

    List<Semester> selectByExample(SemesterExample example);

    Semester selectByPrimaryKey(Integer id);

    Semester selectByPrimaryKeys(@Param("schoolId") Integer schoolId,
                                 @Param("collegeId") Integer collegeId,
                                 @Param("classId") Integer classId,
                                 @Param("studentId") Integer studentId,
                                 @Param("term") Integer term);

    List<Semester> selectByPrimaryStudent(@Param("schoolId") Integer schoolId,
                                 @Param("collegeId") Integer collegeId,
                                 @Param("classId") Integer classId,
                                 @Param("studentId") Integer studentId);

    List<Semester> selectByPrimaryClasses(@Param("schoolId") Integer schoolId,
                                    @Param("collegeId") Integer collegeId,
                                    @Param("classId") Integer classId,
                                    @Param("term") Integer term);

    List<Semester>  selectByPrimaryCollege(@Param("schoolId") Integer schoolId,
                                    @Param("collegeId") Integer collegeId,
                                    @Param("term") Integer term);

    List<Semester>  selectByPrimarySchool(@Param("schoolId") Integer schoolId,
                                    @Param("term") Integer term);

    int updateByExampleSelective(@Param("record") Semester record, @Param("example") SemesterExample example);

    int updateByExample(@Param("record") Semester record, @Param("example") SemesterExample example);

    int updateByPrimaryKeySelective(Semester record);

    int updateByPrimaryKey(Semester record);
}