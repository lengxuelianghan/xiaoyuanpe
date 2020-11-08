package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.ResultBean;
import org.apache.xmlbeans.impl.tool.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/SignIn")
public class SignInController {

    @Autowired
    private SignInService signInService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private ActivityStudService activityStudService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private ClassesService classesService;

    @GetMapping("/addSportSignIn/{activityId}")
    public ResultBean addSportSignIn(@PathVariable Integer activityId, HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try{
            Student student = this.studentService.findStudentByNumber(user.getUserNumber());
            List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
            for (ActivityStud activityStud: activityStuds){
                if (activityStud.getActivityId()==activityId && activityStud.getStudentId()==student.getId()){
                    Signin signin = new Signin();
                    signin.setFlag(1);
                    signin.setStudentId(student.getId());
                    signin.setActivityId(activityId);
                    signin.setSignTime(new Date());
                    this.signInService.addSignin(signin);
                    resultBean.setCode(0);
                }
            }
        }
        catch (Exception e){
            resultBean.setMsg(e.getMessage());
            resultBean.setCode(1);
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @PostMapping("/addSportSignInList/{activityId}")
    public ResultBean addSportSignInList(@PathVariable Integer activityId, @RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try{
            for (Integer id: ids) {
                User user = this.userService.findUsersById(id);
                Student student = this.studentService.findStudentByNumber(user.getUserNumber());
                List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
                for (ActivityStud activityStud : activityStuds) {
                    if (activityStud.getActivityId() == activityId && activityStud.getStudentId() == student.getId()) {
                        Signin signin = new Signin();
                            signin.setFlag(1);
                            signin.setStudentId(student.getId());
                            signin.setActivityId(activityId);
                            signin.setSignTime(new Date());
                        //System.out.println(activityStud.getActivityId()+","+student.getId());
                            this.signInService.addSignin(signin);
                        System.out.println(activityStud.getActivityId()+","+student.getId());
                    }
                }
            }
            resultBean.setCode(0);
        }
        catch (Exception e){
            resultBean.setMsg(e.getMessage());
            resultBean.setCode(1);
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @PostMapping("/updateSignOutList/{activityId}")
    public ResultBean updateSignOut(@PathVariable Integer activityId, @RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try{
            for (Integer id: ids){
                User user = this.userService.findUsersById(id);
                Student student = this.studentService.findStudentByNumber(user.getUserNumber());
                List<Signin> signins = this.signInService.findSigninAll();
                for (Signin signin : signins) {
                    if (signin.getFlag() == 1 && signin.getActivityId()==activityId && signin.getStudentId()==student.getId()) {
                            signin.setFlag(2);
                            signin.setSignoutTime(new Date());
                            this.signInService.ModifySignin(signin);
                    }
                }
                resultBean.setCode(0);
            }
        }
        catch (Exception e){
            resultBean.setMsg(e.getMessage());
            resultBean.setCode(1);
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @PostMapping("/updateSignInList")
    public ResultBean updateSignInList(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try{
            for(Integer id: ids){
                Signin signin = this.signInService.findSigninById(id);
                signin.setFlag(1);
                signin.setSignTime(new Date());
                this.signInService.ModifySignin(signin);
            }
            resultBean.setCode(0);
        }
        catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @PostMapping("/updateSignOutList")
    public ResultBean updateSignOutList(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try{
            for(Integer id: ids){
                Signin signin = this.signInService.findSigninById(id);
                if (signin.getSignTime()!=null&&signin.getSignoutTime()==null) {
                    signin.setFlag(2);
                    Date date = new Date();
                    signin.setSignoutTime(date);
                    this.signInService.ModifySignin(signin);

                    int dataLen = (int) (signin.getSignoutTime().getTime() - signin.getSignTime().getTime())/(1000 * 60);
                    List<Semester> semesters = this.semesterService.findSemesterAll();
                    System.out.println(dataLen);
                    for (Semester semester: semesters){
                        Student student = this.studentService.findStudentById(signin.getStudentId());
                        resultBean.setData(semester);
                        if (semester.getTerm() == student.getAge()&&signin.getStudentId() == semester.getSudentId()){
                            int ss = semester.getExerciseTime();
                            semester.setExerciseTime(ss - dataLen);
                            int s = semester.getScore() + (int) (dataLen * 0.5);
                            semester.setScore(s);
                            this.semesterService.ModifySemester(semester);
                            System.out.println(s);
                            resultBean.setData(signin.getSignoutTime()+","+ signin.getSignTime());
                            break;
                        }
                    }

                    this.signInService.ModifySignin(signin);
                }
            }
            resultBean.setCode(0);
        }
        catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @RequestMapping("/querySignInByActivity/{aid}")
    public ResultBean querySignInByOrigination(@PathVariable Integer aid){
        ResultBean resultBean = new ResultBean();
        try{
            List<Signin> signinList = this.signInService.findSigninAll();
            List<Signin> signins = new ArrayList<>();
            for (Signin signin: signinList){
                if(signin.getActivityId()==aid){
                    signins.add(signin);
                }
            }
            resultBean.setData(signins);
            resultBean.setCode(0);
        }
        catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @RequestMapping("/querySignInBySchool/{sid}")
    public ResultBean querySignInBySchool(@PathVariable Integer sid){
        ResultBean resultBean = new ResultBean();
        try{
            System.out.println(sid);
            List<Signin> signinList = this.signInService.findSigninAll();
            List<Signin> signins = new ArrayList<>();
            for (Signin signin: signinList){
                if(this.studentService.findStudentById(signin.getStudentId()).getShcoolId()==sid){
                    signins.add(signin);
                }
            }
            resultBean.setData(signins);
            resultBean.setCode(0);
        }
        catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @RequestMapping("/querySignInByCollege/{cid}")
    public ResultBean querySignInByCollege(@PathVariable Integer cid){
        ResultBean resultBean = new ResultBean();
        try{
            List<Signin> signinList = this.signInService.findSigninAll();
            List<Signin> signins = new ArrayList<>();
            for (Signin signin: signinList){
                Student student = this.studentService.findStudentById(signin.getStudentId());
                if(student.getCollegeId()==cid){
                    signins.add(signin);
                }
            }
            resultBean.setData(signins);
            resultBean.setCode(0);
        }
        catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @RequestMapping("/querySignInByClasses/{ccid}")
    public ResultBean querySignInByClasses(@PathVariable Integer ccid){
        ResultBean resultBean = new ResultBean();
        try{
            List<Signin> signinList = this.signInService.findSigninAll();
            List<Signin> signins = new ArrayList<>();
            for (Signin signin: signinList){
                Student student = this.studentService.findStudentById(signin.getStudentId());
                if(student.getClassesId()==ccid ){
                    signins.add(signin);
                }
            }
            resultBean.setData(signins);
            resultBean.setCode(0);
        }
        catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }
    //签退
    @PostMapping("/updateSignIOutList")
    public ResultBean updateSignIOutList(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try{
            for(Integer id: ids){
                Signin signin = this.signInService.findSigninById(id);
                signin.setFlag(2);
                signin.setSignoutTime(new Date());
            }
            resultBean.setCode(0);
        }
        catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    //运动签到，按照班级来
    @RequestMapping(value = "/getSignInByClass")
    public ResultBean getSignInByClass(HttpServletRequest httpServletRequest){
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        Date date = new Date();
        date = new Date(date.getTime()+8*60*60*1000);
        ResultBean resultBean = new ResultBean();
        Student student = this.studentService.findStudentByNumber(user.getUserNumber());
        List<Signin> signinList = new ArrayList<>();
        try {
            List<Signin> signins = this.signInService.findSigninAll();
            for (Signin signin: signins){
                if (signin.getSportId()!=null && signin.getSportId() == 1 && signin.getFlag() == 0 &&
                        this.studentService.findStudentById(signin.getStudentId()).getClassesId()==student.getClassesId()){
                    Date date1 = signin.getSignTime();
                    if (date1.getYear()==date.getYear()&&date1.getMonth()==date.getMonth()&&date1.getDay()==date.getDay())
                        signinList.add(signin);
                }
            }
            resultBean.setData(signinList);
        }catch (Exception e){
            resultBean.setMsg("失败！");
        }
        return resultBean;
    }
    // 批量签到
    @RequestMapping(value = "/setSignInByClass")
    public ResultBean setSignInByClass(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {
            for (Integer id: ids){
                Signin signin = this.signInService.findSigninById(id);
                if (signin.getFlag()==0){
                    signin.setFlag(1);
                    signin.setSignTime(new Date());
                    this.signInService.ModifySignin(signin);
                }
                else continue;
            }
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setMsg("失败！");
            resultBean.setCode(1);
        }
        return resultBean;
    }
    //运动签退，按照班级来
    @RequestMapping(value = "/getSignOutByClass")
    public ResultBean getSignOutByClass(HttpServletRequest httpServletRequest){
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        Date date = new Date();
        date = new Date(date.getTime()+8*60*60*1000);
        ResultBean resultBean = new ResultBean();
        Student student = this.studentService.findStudentByNumber(user.getUserNumber());
        List<Signin> signinList = new ArrayList<>();
        try {
            List<Signin> signins = this.signInService.findSigninAll();
            for (Signin signin: signins){
                if (signin.getSportId()!=null && signin.getSportId() == 1 && signin.getFlag() == 1 &&
                        this.studentService.findStudentById(signin.getStudentId()).getClassesId()==student.getClassesId()){
                    Date date1 = signin.getSignTime();
                    if (date1.getYear()==date.getYear()&&date1.getMonth()==date.getMonth()&&date1.getDay()==date.getDay())
                        signinList.add(signin);
                }
            }
            resultBean.setData(signinList);
        }catch (Exception e){
            resultBean.setMsg("失败！");
        }
        return resultBean;
    }
    // 批量签退
    @RequestMapping(value = "/setSignOutByClass")
    public ResultBean setSignOutByClass(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {
            for (Integer id: ids){
                Signin signin = this.signInService.findSigninById(id);
                Student student = this.studentService.findStudentById(signin.getStudentId());
                if (signin.getFlag()==1){
                    signin.setFlag(2);
                    signin.setSignoutTime(new Date());
                    int dataLen = (int) (signin.getSignoutTime().getTime() - signin.getSignTime().getTime())/(1000 * 60);
                    Semester semester = this.semesterService.findSemesterByIds(student.getShcoolId(),student.getCollegeId(),
                            student.getClassesId(),student.getId(), student.getAge());
                    if (semester!=null) {
                        int score = semester.getExerciseTime();
                        semester.setExerciseTime(score + dataLen);
                        int s = semester.getScore() + (int) (dataLen * 0.5);
                        semester.setScore(s);
                        this.signInService.ModifySignin(signin);
                        this.semesterService.ModifySemester(semester);
                    }
                }
                else continue;
            }
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setMsg("失败！");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping(value = "/searchActivityOneWeek")
    public ResultBean searchActivityOneWeek(HttpSession session){
        ResultBean resultBean = new ResultBean();
        User user = (User) session.getAttribute("user");
        Student student = this.studentService.findStudentByNumber(user.getUserNumber());
        try {
            List<SinglePeopleInfo> singlePeopleInfos = new ArrayList<>();
            List<Signin> signins = this.signInService.findSigninAll();
            for (Signin signin: signins){
                if (this.studentService.findStudentById(signin.getStudentId()).getClassesId()==student.getClassesId()){
                    Date endTime = signin.getSignoutTime();
                    Date date = new Date();
                    if (signin.getFlag()==2&&endTime.getYear()==date.getYear()&&endTime.getMonth()==date.getMonth()
                            &&date.getDay()-endTime.getDay()<7){
                        SinglePeopleInfo singlePeopleInfo = new SinglePeopleInfo();
                        int dataLen = (int) (signin.getSignoutTime().getTime() - signin.getSignTime().getTime())/(1000 * 60);
                        singlePeopleInfo.setTimeLen(dataLen);
                        singlePeopleInfo.setStartTime(signin.getSignTime());
                        singlePeopleInfo.setEndTime(signin.getSignoutTime());
                        singlePeopleInfo.setScore(dataLen * 0.5f);
                        singlePeopleInfo.setClasz(this.classesService.findClassesById(student.getClassesId()).getClassName());
                        singlePeopleInfos.add(singlePeopleInfo);
                    }
                }
            }
            resultBean.setData(singlePeopleInfos);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setMsg("失败！");
            resultBean.setCode(1);
        }
        return resultBean;
    }
}
