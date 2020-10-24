package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                int dataLen = (int) (signin.getSignoutTime().getTime() - signin.getSignTime().getTime())/(1000 * 60);
                List<Semester> semesters = this.semesterService.findSemesterAll();
                System.out.println(dataLen);
                for (Semester semester: semesters){
                    Student student = this.studentService.findStudentById(signin.getStudentId());
                    resultBean.setData(semester);
                    if (semester.getTerm() == student.getAge()&&signin.getStudentId() == semester.getSudentId()){
                        int ss = semester.getExerciseTime();
                        semester.setExerciseTime(ss + dataLen);
                        int s = semester.getScore() + (int) (dataLen * 0.5);
                        semester.setScore(s);
                        this.semesterService.ModifySemester(semester);
                        System.out.println(s);
                        resultBean.setData(s+","+(ss+dataLen));
                        break;
                    }
                }

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

}
