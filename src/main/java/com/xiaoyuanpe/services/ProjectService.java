package com.xiaoyuanpe.services;

import com.xiaoyuanpe.pojo.Project;

import java.util.List;

public interface ProjectService {
    void addProject(Project project);

    List<Project> findProjectAll();

    Project findProjectById(Integer id);

    void ModifyProject(Project project);

    void DeleteProject(Integer id);

    void DeleteProjectList(List<Integer> ids);

    public List<Project> findProjectByActivityId(Integer activityId);
}
