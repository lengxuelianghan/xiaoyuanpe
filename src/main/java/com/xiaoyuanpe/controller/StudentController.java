package com.xiaoyuanpe.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.HasRole;
import com.xiaoyuanpe.units.ResultBean;
import com.xiaoyuanpe.units.Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private ClassesService classesService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private RoleService roleService;

    // 查询当前学期学生成绩
    @RequestMapping("/StudentSportInfo")
    public ResultBean SearchAll(HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        int sid = this.studentService.findStudentByNumber(user.getUserNumber()).getId();
        Student student = this.studentService.findStudentById(sid);
        try {
            if (student.getTerm()!=0) {
                Semester semester = this.semesterService.findSemesterByIds(student.getSchoolId(),
                        student.getCollegeId(), student.getClassesId(), student.getId(), student.getTerm());
                resultBean.setData(semester);
                resultBean.setCode(0);
            }
            else {
                resultBean.setCode(2);
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
            resultBean.setCode(2);
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
            resultBean.setCode(2);
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
            resultBean.setCode(2);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }
    //添加学生
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ResultBean addStudent(@RequestBody Student student, HttpServletRequest servletRequest){
        User user1 = (User) servletRequest.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager"));
        if (HasRole.hasOneRole(booleans)) {
            try {
                student.setSchoolId(user1.getSchoolId());
                student.setTerm(1);
                if (this.studentService.findStudentByNumberAndSchool(student.getStudentNumber(), user1.getSchoolId())==null) {
                    this.studentService.addStudent(student);
                    Semester semester = new Semester();
                    semester.setSudentId(student.getId());
                    semester.setClassesId(student.getClassesId());
                    semester.setScore(0);
                    semester.setTerm(1);
                    semester.setExerciseTime(0);
                    semester.setCollegeId(student.getCollegeId());
                    semester.setSchoolId(student.getSchoolId());
                    int i = 0;
                    for (i = 0; i < 8; i++) {
                        semester.setTerm(i + 1);
                        this.semesterService.addSemester(semester);
                    }
                    User user = new User();
                    user.setUserNumber(student.getStudentNumber());
                    user.setSex(student.getSex());
                    user.setUsername(student.getStudentName());
                    user.setPassword(student.getStudentNumber());
                    user.setSchoolId(student.getSchoolId());
                    user.setIdentity("学生");

                    this.userService.addUser(user);
                    UserRole userRole = new UserRole();
                    userRole.setUserId(user.getId());
                    userRole.setRoleId(5);
                    this.userRoleService.addUserRole(userRole);
                    resultBean.setCode(0);
                }
                else {
                    resultBean.setCode(0);
                    resultBean.setMsg("学号重复");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息插入失败"+e.getMessage());
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
            resultBean.setCode(2);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryStudentInfoBySchool/{columnName}/{searchContent}", method = RequestMethod.POST)
    public ResultBean queryStudentInfoBySchool(@RequestBody Page page, @PathVariable String columnName,
                                               @PathVariable String searchContent, HttpSession session){
        Integer searchContentToInt = 0;
        int label = 0;
        if (columnName.equals("schoolId")||columnName.equals("collegeId")||columnName.equals("classesId")||
                columnName.equals("term")||columnName.equals("gradeNumber")){
            searchContentToInt = Integer.parseInt(searchContent);
            label=1;
        }
        User user = (User) session.getAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                columnName = Utils.camelToUnderline(columnName);
                if (label==0)
                    resultBean.setData(this.studentService.findStudentBySchool(user.getSchoolId(), page, columnName,searchContent));
                else
                    resultBean.setData(this.studentService.findStudentBySchoolInt(user.getSchoolId(), page, columnName,searchContentToInt));
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息查询失败"+e.getMessage());
            }
        }else {
            resultBean.setCode(2);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryStudentInfoBySchool", method = RequestMethod.POST)
    public ResultBean queryStudentInfoBySchool(@RequestBody Page page, HttpSession session){
        User user = (User) session.getAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                resultBean.setData(this.studentService.findStudentBySchoolPure(user.getSchoolId(), page));
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息查询失败"+e.getMessage());
            }
        }else {
            resultBean.setCode(2);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }

    @RequestMapping(value = "/queryStudentInfoByCollege", method = RequestMethod.POST)
    public ResultBean queryStudentInfoByCollege(@RequestBody Page page, HttpSession session){
        User user = (User) session.getAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager"));
        ResultBean resultBean = new ResultBean();
        Student student1 = this.studentService.findStudentByNumber(user.getUserNumber());
        if (HasRole.hasOneRole(booleans)) {
            try {
                resultBean.setData(this.studentService.findStudentByCollege(student1.getCollegeId(),page));
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息查询失败"+e.getMessage());
            }
        }else {
            resultBean.setCode(2);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }
    // 查询本学院所有班级信息
    @RequestMapping(value = "/queryStudentInfoByClass",method = RequestMethod.POST)
    public ResultBean queryStudentInfoByClass(@RequestBody Page page, HttpSession session){
        ResultBean resultBean = new ResultBean();
        User user = (User) session.getAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager","supermanager","classmanager","teacher"));
        if (HasRole.hasOneRole(booleans)) {
            Student student1 = this.studentService.findStudentByNumber(user.getUserNumber());
            try {
                resultBean.setData(this.studentService.findStudentByClass(student1.getClassesId(),page));
                resultBean.setCode(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                resultBean.setCode(1);
                resultBean.setMsg("学生信息查询失败"+e.getMessage());
            }
        }else {
            resultBean.setCode(2);
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
            resultBean.setCode(2);
            resultBean.setMsg("你没有权限");
        }
        return resultBean;
    }

    public StudentInfo toStudentInfo(Student student){
        StudentInfo studentInfo = new StudentInfo();
        try {
            studentInfo.setId(student.getId());
            studentInfo.setName(student.getStudentName());
            studentInfo.setClasses(this.classesService.findClassesById(student.getClassesId()).getClassName());
            studentInfo.setCollege(this.collegeService.findCollegeById(student.getCollegeId()).getCollegeName());
            studentInfo.setSchool(this.schoolService.findSchoolById(student.getSchoolId()).getSchoolName());
            studentInfo.setNumber(student.getStudentNumber());
            studentInfo.setSex(student.getSex());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return studentInfo;
    }

}
