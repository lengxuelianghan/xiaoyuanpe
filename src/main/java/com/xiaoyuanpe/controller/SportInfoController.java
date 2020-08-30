package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.CollegeService;
import com.xiaoyuanpe.services.SemesterService;
import com.xiaoyuanpe.services.SportInfoService;
import com.xiaoyuanpe.services.UserService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/sportInfo")
public class SportInfoController {
    @Autowired
    private SportInfoService sportInfoService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private SemesterService semesterService;

    @PostMapping("/addSportInfo")
    public ResultBean addSportInfo(@RequestBody SportInfo sportInfo){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportInfoService.addSportInfo(sportInfo);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("添加运动信息失败！");
        }
        return resultBean;
    }

    @RequestMapping("/querySportInfo/{id}")
    public ResultBean querySportInfo(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.sportInfoService.findSportInfoById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("查找运动信息失败！");
        }
        return resultBean;
    }

    @RequestMapping("/querySportInfoList/{current}/{pageSize}")
    public ResultBean querySportInfoList(@PathVariable Integer current, @PathVariable Integer pageSize){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.sportInfoService.findSportInfoAll(current, pageSize));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("查找运动信息列表失败！");
        }
        return resultBean;
    }

    @RequestMapping(value = "/updateSportInfo/{num}", method = RequestMethod.POST)
    public ResultBean updateSportInfo(@RequestBody SportInfo sportInfo, @PathVariable Integer num, HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportInfoService.ModifySportInfo(sportInfo);
            Semester semester =this.semesterService.findSemesterByIds(sportInfo.getSchoolId(),sportInfo.getCollegeId(),
                    sportInfo.getClassId(),sportInfo.getStudentId(),num);
            semester.setExerciseTime(semester.getExerciseTime()+sportInfo.getSingleExerciseTime());
            if (semester.getScore() < 0){
                if (semester.getExerciseTime()>8000){
                    semester.setScore(this.collegeService.findCollegeById(sportInfo.getCollegeId()).getScore());
                }
            }else {
                resultBean.setMsg("分数已达上限");
            }
            this.sportInfoService.ModifySportInfo(sportInfo);
            this.semesterService.ModifySemester(semester);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("查找运动信息列表失败！"+e.getMessage());
        }
        return resultBean;
    }



}
