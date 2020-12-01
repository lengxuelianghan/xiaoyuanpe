package com.xiaoyuanpe.services;

import com.xiaoyuanpe.mapper.ProjectMapper;
import com.xiaoyuanpe.pojo.Project;
import com.xiaoyuanpe.pojo.ProjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public void addProject(Project project) {
        this.projectMapper.insert(project);
    }

    @Override
    public List<Project> findProjectAll() {
        return this.projectMapper.selectByExample(new ProjectExample());
    }

    @Override
    public Project findProjectById(Integer id) {
        return this.projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Project> findProjectByActivityId(Integer activityId) {
        List<Project> projectList = this.projectMapper.selectByExample(new ProjectExample());
        List<Project> projects = new ArrayList<>();
        for (Project project: projectList){
            if (project.getActivityId()==activityId)
                projects.add(project);
        }
        return projects;
    }

    @Override
    public void ModifyProject(Project project) {
        this.projectMapper.updateByPrimaryKey(project);
    }

    @Override
    public void DeleteProject(Integer id) {
        this.projectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void DeleteProjectList(List<Integer> ids) {
        ids.forEach(id->this.projectMapper.deleteByPrimaryKey(id));
    }
}
