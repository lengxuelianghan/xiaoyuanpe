package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Semester;
import com.xiaoyuanpe.pojo.SemesterEntry;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.pojo.User;
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

    @RequestMapping("/scoreBySchool")
    public ResultBean getScoreBySchool(HttpSession session){
        User user = (User) session.getAttribute("user");
        Integer schoolId = user.getSchoolId();
        ResultBean resultBean = new ResultBean();
        List<SemesterEntry> semesterEntries = new ArrayList<>();
        try {
            List<Semester> semesters = this.semesterService.findSemesterAll();
            for (Semester semester: semesters){
                Student s  =this.studentService.findStudentById(semester.getSudentId());
                if (s.getTerm() == semester.getTerm()
                        &&semester.getSchoolId() == schoolId){
                    SemesterEntry semesterEntry = new SemesterEntry();
                    semesterEntry.setId(semester.getId());
                    semesterEntry.setName(s.getStudentName());
                    resultBean.setData(123);
                    semesterEntry.setCollegeId(collegeService.findCollegeById(semester.getCollegeId()).getCollegeName());
                    resultBean.setData(312);
                    semesterEntry.setScore(semester.getScore());
                    semesterEntries.add(semesterEntry);
                }
            }
            semesterEntries.sort(new Comparator<SemesterEntry>() {
                @Override
                public int compare(SemesterEntry o1, SemesterEntry o2) {
                    return o2.getScore().compareTo(o1.getScore());
                }
            });
            resultBean.setData(semesterEntries);
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
        List<SemesterEntry> semesterEntries = new ArrayList<>();
        try {
            List<Semester> semesters = this.semesterService.findSemesterAll();
            for (Semester semester: semesters){
                Student s  =this.studentService.findStudentById(semester.getSudentId());
                if (s.getTerm() == semester.getTerm()&&student.getClassesId()==semester.getClassesId()){
                    SemesterEntry semesterEntry = new SemesterEntry();
                    semesterEntry.setId(semester.getId());
                    semesterEntry.setName(s.getStudentName());
                    semesterEntry.setCollegeId(collegeService.findCollegeById(semester.getCollegeId()).getCollegeName());
                    semesterEntry.setScore(semester.getScore());
                    semesterEntries.add(semesterEntry);
                }
            }
            semesterEntries.sort(new Comparator<SemesterEntry>() {
                @Override
                public int compare(SemesterEntry o1, SemesterEntry o2) {
                    return o2.getScore().compareTo(o1.getScore());
                }
            });
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
