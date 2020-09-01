package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Semester;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.SemesterService;
import com.xiaoyuanpe.services.StudentService;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private SemesterService semesterService;

    @RequestMapping("/StudentSportInfo/{sid}/{num}")
    public ResultBean SearchAll(@PathVariable Integer sid, @PathVariable Integer num){
        ResultBean resultBean = new ResultBean();
        Student student = this.studentService.findStudentById(sid);
        try {
            if (num!=0) {
                Semester semester = this.semesterService.findSemesterByIds(student.getShcoolId(),
                        student.getCollegeId(), student.getClassesId(), student.getId(), num);
                resultBean.setData(semester);
            }
            else {
                resultBean.setData(this.semesterService.findSemesterByStudent(student.getShcoolId(),
                        student.getCollegeId(),student.getClassesId(),sid));
            }
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("查询失败");
            resultBean.setCode(1);
        }
        return resultBean;
    }
    @RequestMapping("/queryStudentListByClass/{cId}/{ccId}/{num}")
    public ResultBean queryStudentListByClass(@PathVariable Integer cId, @PathVariable Integer ccId,
                                              @PathVariable Integer num, HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            User user = (User) session.getAttribute("user");
            resultBean.setData(this.semesterService.findSemesterByClasses(user.getSchoolId(),cId,ccId,num));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学生信息新增失败");
        }
        return resultBean;
    }

    @RequestMapping("/queryStudentListByCollege/{cId}/{num}")
    public ResultBean queryStudentListByCollege(@PathVariable Integer cId, @PathVariable Integer num,HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            User user = (User) session.getAttribute("user");
            resultBean.setData(this.semesterService.findSemesterByCollege(user.getSchoolId(),cId,num));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学生信息新增失败");
        }
        return resultBean;
    }

    @RequestMapping("/queryStudentListBySchool/{num}")
    public ResultBean queryStudentListBySchool(@PathVariable Integer num, HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            User user = (User) session.getAttribute("user");
            resultBean.setData(this.semesterService.selectByPrimarySchool(user.getSchoolId(),num));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学生信息新增失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ResultBean addStudent(@RequestBody Student student){
        ResultBean resultBean = new ResultBean();
        try {
            this.studentService.addStudent(student);
            Student student1 = this.studentService.findStudentLast();
            Semester semester = new Semester();
            semester.setSudentId(student1.getId()+1);
            semester.setClassesId(student.getClassesId());
            semester.setScore(0);
            semester.setExerciseTime(0);
            semester.setCollegeId(student.getCollegeId());
            semester.setSchoolId(student.getShcoolId());
            int i = 0;
            for (i=0; i<8; i++){
                semester.setTerm(i + 1);
                this.semesterService.addSemester(semester);
            }
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学生信息插入失败");
        }
        return resultBean;
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public ResultBean updateStudent(@RequestBody Student student){
        ResultBean resultBean = new ResultBean();
        try {
            this.studentService.ModifyStudent(student);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学生信息修改失败");
        }
        return resultBean;
    }

    @RequestMapping("/queryStudentInfoBySchool/{sid}")
    public ResultBean queryStudentInfoBySchool(@PathVariable Integer sid, HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            List<Student> studentList = new ArrayList<>();
            List<Student> students = this.studentService.findStudentAll();
            for (Student student : students){
                if (student.getShcoolId()==sid){
                    studentList.add(student);
                }
            }
            resultBean.setData(studentList);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学生信息新增失败");
        }
        return resultBean;
    }

    @RequestMapping("/queryStudentInfoByCollege/{sid}/{cid}")
    public ResultBean queryStudentInfoByCollege(@PathVariable Integer sid, @PathVariable Integer cid,
                                                HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            List<Student> studentList = new ArrayList<>();
            List<Student> students = this.studentService.findStudentAll();
            for (Student student : students){
                if (student.getShcoolId()==sid && student.getCollegeId()==cid){
                    studentList.add(student);
                }
            }
            resultBean.setData(studentList);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学生信息新增失败");
        }
        return resultBean;
    }

    @RequestMapping("/queryStudentInfoByClass/{sid}/{cid}/{ccid}")
    public ResultBean queryStudentInfoByClass(@PathVariable Integer sid, @PathVariable Integer cid,
                                              @PathVariable Integer ccid, HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            List<Student> studentList = new ArrayList<>();
            List<Student> students = this.studentService.findStudentAll();
            for (Student student : students){
                if (student.getShcoolId()==sid && student.getCollegeId()==cid && student.getClassesId()==ccid){
                    studentList.add(student);
                }
            }
            resultBean.setData(studentList);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setCode(1);
            resultBean.setMsg("学生信息新增失败");
        }
        return resultBean;
    }

}
