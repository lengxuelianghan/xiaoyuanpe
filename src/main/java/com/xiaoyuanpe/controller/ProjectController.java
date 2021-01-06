package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Project;
import com.xiaoyuanpe.services.ProjectService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ResultBean addProject(@RequestBody List<Project> projects){
        ResultBean resultBean = new ResultBean();
        try {
            for (Project project: projects){
                this.projectService.addProject(project);
            }
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("添加失败: "+e.getMessage());
        }
        return resultBean;
    }
    //查询单个项目
    @RequestMapping("/queryProjectById/{id}")
    public ResultBean queryProjectById(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.projectService.findProjectById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("查询失败："+e.getMessage());
        }
        return resultBean;
    }
    //查询单个活动的所有项目
    @RequestMapping("/queryProjectByActivityId/{activityId}")
    public ResultBean queryProjectByActivityId(@PathVariable Integer activityId){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(0);
            List<Project> projects = this.projectService.findProjectAll();
            List<Project> projectList = new ArrayList<>();
            projects.forEach(project -> {
                if (project.getActivityId()==activityId){
                    projectList.add(project);
                }
            });
            resultBean.setData(projectList);
            resultBean.setTotal(projectList.size());
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("差询失败："+e.getMessage());
        }
        return resultBean;
    }
    @RequestMapping("/deleteProjectById/{id}")
    public ResultBean deleteProjectById(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(0);
            this.projectService.DeleteProject(id);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("删除错误："+e.getMessage());
        }
        return resultBean;
    }
    @RequestMapping(value = "/deleteProjects", method = RequestMethod.POST)
    public ResultBean deleteProjects(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(0);
            ids.forEach(id->this.projectService.DeleteProject(id));
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("删除错误："+e.getMessage());
        }
        return resultBean;
    }
    @RequestMapping(value = "/updateProject", method = RequestMethod.POST)
    public ResultBean updateProject(@RequestBody Project project){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(0);
            this.projectService.ModifyProject(project);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("更新失败:"+e.getMessage());
        }
        return resultBean;
    }
}
