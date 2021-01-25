package com.xiaoyuanpe.services;

import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.pojo.Page;
import com.xiaoyuanpe.pojo.Signin;
import com.xiaoyuanpe.pojo.StudentInfoEntry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignInService {
    void addSignin(Signin signin);

    List<Signin> findSigninAll();

    Signin findSigninById(Integer id);

    void ModifySignin(Signin school);

    void DeleteSignin(Integer id);

    void DeleteSigninList(List<Integer> ids);

    Integer searchActivityOneWeekActivity(Integer studentId, Integer clazz);

    Integer searchActivityOneWeekSport(Integer studentId);

    PageInfo<StudentInfoEntry> searchSignInSport(Integer sportId, Integer collegeId, Integer classId, Page page);

}
