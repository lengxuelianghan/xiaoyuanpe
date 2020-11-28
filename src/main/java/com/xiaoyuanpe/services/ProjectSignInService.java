package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Project;
import com.xiaoyuanpe.pojo.Projectsignin;

import java.util.List;

public interface ProjectSignInService {
    void addProjectSignIn(Projectsignin projectsignin);

    List<Projectsignin> findProjectsigninAll();

    List<Projectsignin> findProjectsByStudentIdAndActivityId(Integer StudentId, Integer ActivityId);

    List<Projectsignin> findProjectByActivityId(Integer ActivityId);

    Projectsignin findProjectBySignInIdAndStudentId(Integer SignInI, Integer StudentId);

    Projectsignin findProjectsigninById(Integer id);

    void ModifyProjectsignin(Projectsignin projectsignin);

    void DeleteProjectsignin(Integer id);

    void DeleteProjectsigninList(List<Integer> ids);
}
