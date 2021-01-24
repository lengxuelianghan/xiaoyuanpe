package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.HasRole;
import com.xiaoyuanpe.units.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.xmlbeans.impl.tool.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    private ActivityService activityService;
    @Autowired
    private SportService sportService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private ProjectSignInService projectSignInService;
    @Autowired
    private SportStudService sportStudService;

    //查找当前活动当前学生的签到信息并签到。
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
    //
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
    //活动签退根据id
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
    //活动签到根据很多id
    @PostMapping("/updateSignInList")
    public ResultBean updateSignInList(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try{
            for(Integer id: ids){
                Signin signin = this.signInService.findSigninById(id);
                signin.setFlag(1);
                signin.setSignTime(new Date());
                this.signInService.ModifySignin(signin);
                Projectsignin projectsignin =
                        this.projectSignInService.findProjectBySignInIdAndStudentId(signin.getId(),signin.getStudentId());
                if (projectsignin!=null&&projectsignin.getSigninstatus()==0){
                    projectsignin.setSigninstatus(1);
                    this.projectSignInService.ModifyProjectsignin(projectsignin);
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
    //活动签退
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
                    Projectsignin projectsignin =
                            this.projectSignInService.findProjectBySignInIdAndStudentId(signin.getId(),signin.getStudentId());
                    if (projectsignin!=null&&projectsignin.getSigninstatus()==1){
                        projectsignin.setSigninstatus(2);
                        this.projectSignInService.ModifyProjectsignin(projectsignin);
                    }
                    int dataLen = (int) (signin.getSignoutTime().getTime() - signin.getSignTime().getTime())/(1000 * 60);
                    List<Semester> semesters = this.semesterService.findSemesterAll();
                    System.out.println(dataLen);
                    resultBean.setTotal(dataLen);
                    for (Semester semester: semesters){
                        Student student = this.studentService.findStudentById(signin.getStudentId());
                        resultBean.setData(semester);
                        if (semester.getTerm() == student.getTerm()&&signin.getStudentId() == semester.getSudentId()){
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
    //根据id信息插叙活动签到信息
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
                if(this.studentService.findStudentById(signin.getStudentId()).getSchoolId()==sid){
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

    private StudentInfoEntry setStudentInfoEntry(Signin signin){
        Student student = this.studentService.findStudentById(signin.getStudentId());
        StudentInfoEntry studentInfoEntry = new StudentInfoEntry();
        studentInfoEntry.setId(signin.getId());
        studentInfoEntry.setClassz(this.classesService.findClassesById(student.getClassesId()).getClassName());
        studentInfoEntry.setCollege(this.collegeService.findCollegeById(student.getCollegeId()).getCollegeName());
        studentInfoEntry.setFlag(signin.getFlag());
        studentInfoEntry.setStudentName(student.getStudentName());
        studentInfoEntry.setStudentId(signin.getStudentId());
        if (signin.getSignTime()!=null)
            studentInfoEntry.setSignTime(new Timestamp(signin.getSignTime().getTime()));
        if (signin.getSignoutTime()!=null)
            studentInfoEntry.setSignOutTime(new Timestamp(signin.getSignoutTime().getTime()));
        return studentInfoEntry;
    }

    //运动签到，按照班级来
    @RequestMapping(value = "/getSignInByClass")
    public ResultBean getSignInByClass(HttpServletRequest httpServletRequest){
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        Student student = this.studentService.findStudentByNumber(user.getUserNumber());
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("classmanager"));
        Date date = new Date();
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)||
                this.sportStudService.findSportStudByStudentId(student.getId()).getCharacters().equals("签到员")) {
            List<StudentInfoEntry> studentInfoEntries = new ArrayList<>();
            try {
                List<Signin> signins = this.signInService.findSigninAll();
                for (Signin signin : signins) {
                    if (signin.getSportId() != null && signin.getSportId() == 1 && signin.getFlag() <= 2 &&
                            this.studentService.findStudentById(signin.getStudentId()).getClassesId() == student.getClassesId()) {
                        Date date1 = signin.getSignTime();
                        //date1 = new Date(date1.getTime()+8*60*60*1000);
                        if (date1.getYear() == date.getYear() && date1.getMonth() == date.getMonth() && date1.getDate() == date.getDate()) {
                            //resultBean.setMsg(date1.getYear()+"-"+date1.getMonth()+"-"+date1.getDate()+",,,"+date.getYear()+"-"+date.getMonth()+"-"+date.getDate());
                            studentInfoEntries.add(this.setStudentInfoEntry(signin));
                        }
                        if (date1.getYear() == date.getYear() && date1.getMonth() == date.getMonth() && (date.getDate() - date1.getDate() == 1)) {
                            //resultBean.setMsg(date1.getYear()+"-"+date1.getMonth()+"-"+date1.getDate()+",,,"+date.getYear()+"-"+date.getMonth()+"-"+date.getDate());
                            signin.setFlag(3);
                            this.signInService.ModifySignin(signin);
                        }

                    }
                }
                resultBean.setData(studentInfoEntries);
                resultBean.setCode(0);
            } catch (Exception e) {
                resultBean.setMsg("失败！");
                resultBean.setCode(1);
            }
        }
        else {
            resultBean.setMsg("没有权限！");
            resultBean.setCode(1);
        }
        return resultBean;
    }
    // 批量签到，运动的
    @RequestMapping(value = "/setSignInByClass")
    public ResultBean setSignInByClass(@RequestBody List<Integer> ids, HttpServletRequest httpServlet){
        User user = (User) httpServlet.getSession().getAttribute("user");
        Student student = this.studentService.findStudentByNumber(user.getUserNumber());
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("classmanager"));
        if (HasRole.hasOneRole(booleans)||
                this.sportStudService.findSportStudByStudentId(student.getId()).getCharacters().equals("签到员")) {
            try {
                for (Integer id : ids) {
                    Signin signin = this.signInService.findSigninById(id);
                    if (signin.getFlag() == 0) {
                        signin.setFlag(1);
                        Date date = new Date();
                        signin.setSignTime(new Date(date.getTime()));
                        this.signInService.ModifySignin(signin);
                    } else continue;
                }
                resultBean.setCode(0);
            } catch (Exception e) {
                resultBean.setMsg("失败！");
                resultBean.setCode(1);
            }
        }
        else {
            resultBean.setMsg("没有权限！");
            resultBean.setCode(1);
        }
        return resultBean;
    }
    //运动签退，按照班级来
    @RequestMapping(value = "/getSignOutByClass")
    public ResultBean getSignOutByClass(HttpServletRequest httpServletRequest){
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        Date date = new Date();
        ResultBean resultBean = new ResultBean();
        Student student = this.studentService.findStudentByNumber(user.getUserNumber());
        List<StudentInfoEntry> studentInfoEntries = new ArrayList<>();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("classmanager"));
        if (HasRole.hasOneRole(booleans)||
                this.sportStudService.findSportStudByStudentId(student.getId()).getCharacters().equals("签到员")) {
            try {
                List<Signin> signins = this.signInService.findSigninAll();
                for (Signin signin : signins) {
                    if (signin.getSportId() != null && signin.getSportId() == 1 && signin.getFlag() == 1 &&
                            this.studentService.findStudentById(signin.getStudentId()).getClassesId() == student.getClassesId()) {
                        Date date1 = signin.getSignTime();
                        if (date1.getYear() == date.getYear() && date1.getMonth() == date.getMonth() && date1.getDay() == date.getDay())
                            studentInfoEntries.add(this.setStudentInfoEntry(signin));
                    }
                }
                resultBean.setData(studentInfoEntries);
            } catch (Exception e) {
                resultBean.setMsg("失败！");
            }
        }
        else {
            resultBean.setMsg("没有权限！");
            resultBean.setCode(1);
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
                    Semester semester = this.semesterService.findSemesterByIds(student.getSchoolId(),student.getCollegeId(),
                            student.getClassesId(),student.getId(), student.getTerm());
                    if (semester!=null) {
                        //resultBean.setMsg(semester.getExerciseTime()+","+semester.getClassesId());
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
    //查询最近一周的活动记录
    @RequestMapping(value = "/searchActivityOneWeek")
    public ResultBean searchActivityOneWeek(HttpSession session){
        ResultBean resultBean = new ResultBean();
        User user = (User) session.getAttribute("user");
        Student student = this.studentService.findStudentByNumber(user.getUserNumber());
        ScorePerWeek activity = new ScorePerWeek("活动",0.0f);
        ScorePerWeek game = new ScorePerWeek("比赛",0.0f);
        ScorePerWeek sport = new ScorePerWeek("运动",0.0f);
        try {
            System.out.println("失败在这");
            Float n1=this.signInService.searchActivityOneWeekActivity(student.getId(), 0) * 0.5f;
            System.out.println("失败在这1");
            Float n2=this.signInService.searchActivityOneWeekActivity(student.getId(), 0) * 0.5f;
            System.out.println("失败在这2");
            Float n3=this.signInService.searchActivityOneWeekSport(student.getId())*0.5f;
            System.out.println("失败在这3");
//            List<SinglePeopleInfo> singlePeopleInfos = new ArrayList<>();
//            List<Signin> signins = this.signInService.findSigninAll();
//            resultBean.setData("s俄式是");
//            for (Signin signin: signins){
//                if (this.studentService.findStudentById(signin.getStudentId()).getClassesId()==student.getClassesId()){
//                    Date endTime = signin.getSignoutTime();
//                    Date date = new Date();
//                    if (signin.getStudentId()==student.getId()&&signin.getFlag()==2&&endTime.getYear()==date.getYear()
//                            &&endTime.getMonth()==date.getMonth()&&date.getDay()-endTime.getDay()<7){
//                        SinglePeopleInfo singlePeopleInfo = new SinglePeopleInfo();
//                        int dataLen = (int) (signin.getSignoutTime().getTime() - signin.getSignTime().getTime())/(1000 * 60);
//                        singlePeopleInfo.setTimeLen(dataLen);
//                        singlePeopleInfo.setStartTime(signin.getSignTime());
//                        singlePeopleInfo.setEndTime(signin.getSignoutTime());
//                        singlePeopleInfo.setScore(dataLen * 0.5f);
//                        singlePeopleInfo.setClasz(this.classesService.findClassesById(student.getClassesId()).getClassName());
//                        if (signin.getActivityId()!=null) {
//                            if (this.activityService.findActivityById(signin.getActivityId()).getActivityClass()==0){
//                                singlePeopleInfo.setClasz("活动");
//                                n1+=dataLen * 0.5f;
//                            }else {
//                                singlePeopleInfo.setClasz("运动");
//                                n2+=dataLen * 0.5f;
//                            }
//                            singlePeopleInfo.setActivityOrSportName(this.activityService.findActivityById(signin.getActivityId()).getActivityName());
//                        }
//                        else if(signin.getSportId()!=null) {
//                            singlePeopleInfo.setClasz("运动");
//                            singlePeopleInfo.setActivityOrSportName(this.sportService.findSportsById(signin.getSportId()).getName());
//                        }
//                        singlePeopleInfos.add(singlePeopleInfo);
//
//                        resultBean.setTotal(dataLen);
//                        if (signin.getActivityId()!=null){
//                            if (this.activityService.findActivityById(signin.getActivityId()).getActivityClass()==0){
//                                n1+=dataLen * 0.5f;
//                            }else {
//                                n2+=dataLen * 0.5f;
//                            }
//                        }
//                        else if (signin.getSportId()!=null){
//                            n3+=dataLen * 0.5f;
//                        }
//                    }
//                }
//            }
            List<ScorePerWeek> scorePerWeeks = new ArrayList<>();
            activity.setScore(n1==null?0f:n1);
            game.setScore(n2==null?0f:n2);
            sport.setScore(n3==null?0f:n3);
            scorePerWeeks.add(activity);
            scorePerWeeks.add(game);
            scorePerWeeks.add(sport);
            resultBean.setData(scorePerWeeks);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setMsg("失败！"+e.getMessage());
            resultBean.setCode(1);
        }
        return resultBean;
    }
}
