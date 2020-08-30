package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Semester;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.pojo.UserSport;
import com.xiaoyuanpe.pojo.UserSportNum;
import com.xiaoyuanpe.services.CollegeService;
import com.xiaoyuanpe.services.SemesterService;
import com.xiaoyuanpe.services.StudentService;
import com.xiaoyuanpe.services.UserSportService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userSport")
public class UserSportController {
    @Autowired
    private UserSportService userSportService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CollegeService collegeService;

    @PostMapping("/addUserSport")
    public ResultBean addUserSport(@RequestBody UserSport userSport){
        ResultBean resultBean = new ResultBean();
        try {
            this.userSportService.addUserSport(userSport);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("运动信息新增失败");
        }
        return resultBean;
    }
    @RequestMapping("/queryUserSport/{id}")
    public ResultBean queryUserSport(@PathVariable  Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.userSportService.findUserSportById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("运动信息查找失败");
        }
        return resultBean;
    }
    @RequestMapping("/queryUserSportList/{current}/{pageSize}")
    public ResultBean queryUserSportList(@PathVariable Integer current, @PathVariable Integer pageSize){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.userSportService.findUserSportAll(current,pageSize));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("运动信息列表新增失败");
        }
        return resultBean;
    }

    @PostMapping("/updateUserSport")
    public ResultBean updateUserSport(@RequestBody UserSport userSport){
        ResultBean resultBean = new ResultBean();
        try {
            this.userSportService.ModifyUserSport(userSport);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("运动信息新增失败");
        }
        return resultBean;
    }

    @PostMapping("/addSportScore")
    public ResultBean addSportScore(@RequestBody UserSportNum userSport){
        ResultBean resultBean = new ResultBean();
        try {
            Student student = this.studentService.findStudentByNumber(userSport.getStudentNumber());
            Semester semester =this.semesterService.findSemesterByIds(userSport.getSchoolId(),userSport.getCollegeId(),
                    student.getClassesId(),student.getId(), userSport.getNum());
            semester.setExerciseTime(semester.getExerciseTime()+userSport.getTimes());
            if (semester.getScore() < 0){
                if (semester.getExerciseTime()>8000){
                    semester.setScore(this.collegeService.findCollegeById(student.getCollegeId()).getScore());
                }
            }else {
                resultBean.setMsg("分数已达上限");
            }
            this.semesterService.ModifySemester(semester);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("运动信息新增失败");
        }
        return resultBean;
    }
}
