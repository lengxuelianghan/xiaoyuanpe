package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.HasRole;
import com.xiaoyuanpe.units.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;

    // 查询当前学期学生成绩
    @RequestMapping("/StudentSportInfo")
    public ResultBean SearchAll(HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        int sid = this.studentService.findStudentByNumber(user.getUserNumber()).getId();
        Student student = this.studentService.findStudentById(sid);
        try {
            if (student.getAge()!=0) {
                Semester semester = this.semesterService.findSemesterByIds(student.getShcoolId(),
                        student.getCollegeId(), student.getClassesId(), student.getId(), student.getAge());
                resultBean.setData(semester);
                resultBean.setCode(0);
            }
            else {
                resultBean.setCode(1);
                resultBean.setMsg("查询失败，已无信息！");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("查询失败");
            resultBean.setCode(1);
        }
        return resultBean;
    }
    //按照班级信息查询
    @RequestMapping("/queryStudentListByClass/{cId}/{ccId}/{num}")
    public ResultBean queryStudentListByClass(@PathVariable Integer cId, @PathVariable Integer ccId,
                                              @PathVariable Integer num, HttpSession session){
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager","classmanager","teacher"));
        if (HasRole.hasOneRole(booleans)) {
            User user = (User) session.getAttribute("user");
            try {
                List<Semester> semesterByClasses = this.semesterService.findSemesterByClasses(user.getSchoolId(), cId, ccId, num);
                resultBean.setData(semesterByClasses);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息新增失败");
            }
        }else {
            resultBean.setCode(1);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }
    //根据学院查询当前学期成绩
    @RequestMapping("/queryStudentListByCollege/{cId}/{num}")
    public ResultBean queryStudentListByCollege(@PathVariable Integer cId, @PathVariable Integer num,HttpSession session){
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager","teacher"));
        if (HasRole.hasOneRole(booleans)) {
            try {
                User user = (User) session.getAttribute("user");
                resultBean.setData(this.semesterService.findSemesterByCollege(user.getSchoolId(), cId, num));
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息新增失败");
            }
        }else {
            resultBean.setCode(1);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }
    //根据学校查询当前学期信息
    @RequestMapping("/queryStudentListBySchool/{num}")
    public ResultBean queryStudentListBySchool(@PathVariable Integer num, HttpSession session){
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager"));
        if (HasRole.hasOneRole(booleans)) {
            try {
                User user = (User) session.getAttribute("user");
                resultBean.setData(this.semesterService.selectByPrimarySchool(user.getSchoolId(), num));
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息新增失败");
            }
        }else {
            resultBean.setCode(1);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ResultBean addStudent(@RequestBody Student student){
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager"));
        if (HasRole.hasOneRole(booleans)) {
            try {
                this.studentService.addStudent(student);
                Semester semester = new Semester();
                resultBean.setData(student.getId()+"hh");
                semester.setSudentId(student.getId());
                semester.setClassesId(student.getClassesId());
                semester.setScore(0);
                semester.setTerm(1);
                semester.setExerciseTime(0);
                semester.setCollegeId(student.getCollegeId());
                semester.setSchoolId(student.getShcoolId());
                UserRole userRole = new UserRole();
                userRole.setUserId(this.userService.findUsersByStudentNum(this.studentService.findStudentById(student.getId()).getStudentName()).getId());
                userRole.setRoleId(5);
                this.userRoleService.addUserRole(userRole);
                int i = 0;
                for (i = 0; i < 8; i++) {
                    semester.setTerm(i + 1);
                    this.semesterService.addSemester(semester);
                }
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息插入失败");
            }
        }else {
            resultBean.setCode(1);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public ResultBean updateStudent(@RequestBody Student student){
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                this.studentService.ModifyStudent(student);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息修改失败");
            }
        }else {
            resultBean.setCode(1);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }

    @RequestMapping("/queryStudentInfoBySchool/{sid}")
    public ResultBean queryStudentInfoBySchool(@PathVariable Integer sid, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                List<Student> studentList = new ArrayList<>();
                List<Student> students = this.studentService.findStudentAll();
                for (Student student : students) {
                    if (student.getShcoolId() == sid) {
                        studentList.add(student);
                    }
                }
                resultBean.setData(studentList);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息新增失败");
            }
        }else {
            resultBean.setCode(1);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }

    @RequestMapping("/queryStudentInfoByCollege/{sid}/{cid}")
    public ResultBean queryStudentInfoByCollege(@PathVariable Integer sid, @PathVariable Integer cid,
                                                HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                List<Student> studentList = new ArrayList<>();
                List<Student> students = this.studentService.findStudentAll();
                for (Student student : students) {
                    if (student.getShcoolId() == sid && student.getCollegeId() == cid) {
                        studentList.add(student);
                    }
                }
                resultBean.setData(studentList);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息新增失败");
            }
        }else {
            resultBean.setCode(1);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }
    // 查询本学院所有班级信息
    @RequestMapping("/queryStudentInfoByClass/{sid}/{cid}/{ccid}")
    public ResultBean queryStudentInfoByClass(@PathVariable Integer sid, @PathVariable Integer cid,
                                              @PathVariable Integer ccid, HttpSession session){
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager","classmanager","teacher"));
        if (HasRole.hasOneRole(booleans)) {
            try {
                List<Student> studentList = new ArrayList<>();
                List<Student> students = this.studentService.findStudentAll();
                for (Student student : students) {
                    if (student.getShcoolId() == sid && student.getCollegeId() == cid && student.getClassesId() == ccid) {
                        studentList.add(student);
                    }
                }
                resultBean.setData(studentList);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息新增失败");
            }
        }else {
            resultBean.setCode(1);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
    public ResultBean deleteStudent(@RequestBody List<Integer> ids){
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                this.studentService.DeleteStudentList(ids);
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println("错误" + e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生删除失败");
            }
        }else {
            resultBean.setCode(1);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }

}
