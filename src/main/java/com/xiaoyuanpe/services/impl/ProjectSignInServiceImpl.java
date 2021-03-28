package com.xiaoyuanpe.services.impl;

import com.xiaoyuanpe.mapper.ProjectsigninMapper;
import com.xiaoyuanpe.pojo.Project;
import com.xiaoyuanpe.pojo.Projectsignin;
import com.xiaoyuanpe.pojo.ProjectsigninExample;
import com.xiaoyuanpe.services.ProjectSignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectSignInServiceImpl implements ProjectSignInService {
    @Resource
    private ProjectsigninMapper projectsigninMapper;
    @Override
    public void addProjectSignIn(Projectsignin projectsignin) {
        this.projectsigninMapper.insert(projectsignin);
    }

    @Override
    public List<Projectsignin> findProjectsigninAll() {
        return this.projectsigninMapper.selectByExample(new ProjectsigninExample());
    }

    @Override
    public List<Projectsignin> findProjectsByStudentIdAndActivityId(Integer StudentId, Integer ActivityId) {
        List<Projectsignin> projectsignins = this.projectsigninMapper.selectByExample(new ProjectsigninExample());
        List<Projectsignin> projectsigninList = new ArrayList<>();
        for (Projectsignin projectsignin: projectsignins){
            if (projectsignin.getActivityid()==ActivityId&&projectsignin.getStudentid()==StudentId)
                projectsigninList.add(projectsignin);
        }
        return projectsigninList;
    }

    @Override
    public List<Projectsignin> findProjectByActivityId(Integer ActivityId) {
        List<Projectsignin> projectsignins = this.projectsigninMapper.selectByExample(new ProjectsigninExample());
        List<Projectsignin> projectsigninList = new ArrayList<>();
        for (Projectsignin projectsignin: projectsignins){
            if (projectsignin.getActivityid()==ActivityId)
                projectsigninList.add(projectsignin);
        }
        return projectsigninList;
    }

    @Override
    public Projectsignin findProjectBySignInIdAndStudentId(Integer SignInId, Integer StudentId) {
        List<Projectsignin> projectsignins = this.projectsigninMapper.selectByExample(new ProjectsigninExample());
        for (Projectsignin projectsignin: projectsignins){
            if (projectsignin.getActivityid()==SignInId&&projectsignin.getStudentid()==StudentId)
                return projectsignin;
        }
        return null;
    }

    @Override
    public Projectsignin findProjectsigninById(Integer id) {
        return this.projectsigninMapper.selectByPrimaryKey(id);
    }

    @Override
    public void ModifyProjectsignin(Projectsignin projectsignin) {
        this.projectsigninMapper.updateByPrimaryKey(projectsignin);
    }

    @Override
    public void DeleteProjectsignin(Integer id) {
        this.projectsigninMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void DeleteProjectsigninList(List<Integer> ids) {
        for (Integer id: ids){
            this.projectsigninMapper.deleteByPrimaryKey(id);
        }
    }
}
