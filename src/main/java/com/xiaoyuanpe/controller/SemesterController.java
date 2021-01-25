package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.CollegeService;
import com.xiaoyuanpe.services.SemesterService;
import com.xiaoyuanpe.services.StudentService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/semester")
public class SemesterController {
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CollegeService collegeService;
    //按学校排名
    @RequestMapping("/scoreBySchool")
    public ResultBean getScoreBySchool(HttpSession session){
        User user = (User) session.getAttribute("user");
        Integer schoolId = user.getSchoolId();
        ResultBean resultBean = new ResultBean();
        Student s  =this.studentService.findStudentByNumber(user.getUserNumber());
        try {
            List<SemesterEntry> semesterEntries = this.semesterService.selectBySchool(schoolId,s.getTerm());
            resultBean.setData(semesterEntries);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setMsg("查询失败"+e.getMessage());
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping("/scoreBySchoolOrder")
    public ResultBean scoreBySchoolOrder(HttpSession session){
        User user = (User) session.getAttribute("user");
        Integer schoolId = user.getSchoolId();
        ResultBean resultBean = new ResultBean();
        Student s  =this.studentService.findStudentByNumber(user.getUserNumber());
        try {
            Integer integer = this.semesterService.selectBySchoolOrder(schoolId, s.getTerm(), s.getId());
            resultBean.setData(integer==null?0:integer);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setMsg("查询失败"+e.getMessage());
            resultBean.setCode(1);
        }
        return resultBean;
    }


    @RequestMapping("/scoreByClass")
    public ResultBean classScore(HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        Student student = this.studentService.findStudentByNumber(user.getUserNumber());
        try {
            List<SemesterEntry> semesterEntries =this.semesterService.selectByClass(student.getClassesId(), student.getTerm());
            resultBean.setData(semesterEntries);
            resultBean.setCode(0);

        }catch (Exception e){
            resultBean.setMsg("查询失败"+e.getMessage());
            resultBean.setCode(1);
        }
        return resultBean;
    }



    @RequestMapping("/singleScore")
    public ResultBean singleScore(HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        Student student = this.studentService.findStudentByNumber(user.getUserNumber());
        try {
            List<Semester> semesters = this.semesterService.findSemesterByStudent(student.getSchoolId(), student.getCollegeId(), student.getClassesId(), student.getId());
            Semester semester = new Semester();
            for (Semester sem: semesters){
                if (student.getTerm() == sem.getTerm()) {
                    semester = sem;
                    break;
                }
            }
            SemesterEntry semesterEntry = new SemesterEntry();
            semesterEntry.setId(semester.getId());
            semesterEntry.setName(student.getStudentName());
            semesterEntry.setCollegeId(collegeService.findCollegeById(semester.getCollegeId()).getCollegeName());
            semesterEntry.setScore(semester.getScore());
            resultBean.setData(semesterEntry);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setMsg("查询失败"+e.getMessage());
            resultBean.setCode(1);
        }
        return resultBean;
    }
}
