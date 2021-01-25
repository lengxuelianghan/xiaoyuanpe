package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.HasRole;
import com.xiaoyuanpe.units.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ActivityStudService activityStudService;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private SignInService signInService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectSignInService projectSignInService;
    @Autowired
    private CollegeService collegeService;

//    @PostMapping("/addActivity")
//    public ResultBean addActivity(@RequestParam("pictureFile") MultipartFile pictureFile, Activity activity){
//        ResultBean resultBean = new ResultBean();
//        try {
//            if (pictureFile != null){
//                String filepath = getUploadPath();
//                String filename=pictureFile.getOriginalFilename();
//                String fileName = getFileName(filename);
//                BufferedOutputStream out = new BufferedOutputStream(
//                        new FileOutputStream(new File("C:\\nginx\\img\\"+ fileName)));
//                System.out.println("C:\\nginx\\img\\"+ fileName);
//                activity.setImagePath("C:\\nginx\\img\\"+  fileName);
//                activity.setStatus(0);
//                out.write(pictureFile.getBytes());
//                out.flush();
//            }
//            this.activityService.addActivity(activity);
//            resultBean.setCode(0);
//        }catch (Exception e){
//            resultBean.setCode(1);
//            resultBean.setMsg(e.getMessage());
//            System.out.println(e.getMessage());
//        }
//        return resultBean;
//    }

    private boolean addOrNot(Integer uid){
        boolean b = false;
        List<Activity> activityByUserId = this.activityService.findActivityByUserId(uid);
        if (activityByUserId!=null && !activityByUserId.isEmpty()){
            for (Activity activity: activityByUserId){
                if (activity.getStatus()==5){
                    b=true;
                    break;
                }
            }
        }
        return b;
    }
    //获取当前用户未发布活动
    @GetMapping("/getPreActivity")
    public ResultBean preActivityList(HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            List<Activity> activityByUserId = this.activityService.findActivityByUserId(user.getId());
            List<Activity> activityList = new ArrayList<>();
            if (activityByUserId!=null && !activityByUserId.isEmpty()){
                for (Activity activity: activityByUserId){
                    if (activity.getStatus()==5){
                        List<Project> projects = this.projectService.findProjectByActivityId(activity.getId());
                        if (projects!=null){
                            activity.setProjects(projects);
                        }
                        activityList.add(activity);
                    }
                }
                resultBean.setData(activityList);
                resultBean.setCode(0);
            }
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg("失败");
        }
        return resultBean;
    }
    //添加并发布活动
    @PostMapping("/addActivity")
    public ResultBean addActivity(@RequestParam("pictureFile") MultipartFile pictureFile, Activity activity,
                                  HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        Integer uid = 0;
        if (user!=null)
            uid = user.getId();
        else {
            resultBean.setCode(1);
            resultBean.setMsg("用户不存在");
        }
        try {
            if (pictureFile != null){
                String filepath = getUploadPath();
                String filename=pictureFile.getOriginalFilename();
                String fileName = getFileName(filename);
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File("C:\\nginx\\img\\"+ fileName)));
                System.out.println("C:\\nginx\\img\\"+ fileName);
                activity.setImagePath("C:\\nginx\\img\\"+ fileName);
                activity.setStatus(0);
                activity.setSignNum(0);
                activity.setPublisherId(uid);
                activity.setActivityClass(0);
                activity.setPublishData(new Date());
                activity.setSchoolId(user.getSchoolId());
                activity.setCollegeId(this.studentService.findStudentByNumber(user.getUserNumber()).getCollegeId());
                out.write(pictureFile.getBytes());
                out.flush();
                out.close();
            }
            this.activityService.addActivity(activity);

            if (activity.getProjects()!=null && activity.getProjects().size()>0){
                for (Project project: activity.getProjects()){
                    project.setActivityId(activity.getId());
                    this.projectService.addProject(project);
                }
            }

            ActivityStud activityStud = new ActivityStud();
            String num = this.userService.findUsersById(uid).getUserNumber();
            int id = this.studentService.findStudentByNumber(num).getId();
            activityStud.setStudentId(id);
            activityStud.setActivityId(activity.getId());
            activityStud.setCharacters("发起人");
            this.activityStudService.addActivityStud(activityStud);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getClass().toString());
            if (e.getClass().toString().equals("java.sql.SQLIntegrityConstraintViolationException")){
                resultBean.setMsg("学校信息或用户信息不存在");
            }
        }
        return resultBean;
    }

    //添加并发布比赛
    @PostMapping("/addGame")
    public ResultBean addGame(@RequestParam("pictureFile") MultipartFile pictureFile, Activity activity,
                                  HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        Integer uid = 0;
        if (user!=null)
            uid = user.getId();
        else {
            resultBean.setCode(1);
            resultBean.setMsg("用户不存在");
        }
        if (this.addOrNot(uid)){
            resultBean.setCode(1);
            resultBean.setMsg("您有一个未发布活动，不能新建");
            return resultBean;
        }
        try {
            if (pictureFile != null){
                String filepath = getUploadPath();
                String filename=pictureFile.getOriginalFilename();
                String fileName = getFileName(filename);
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File("C:\\nginx\\img\\"+ fileName)));
                System.out.println("C:\\nginx\\img\\"+ fileName);
                activity.setImagePath("C:\\nginx\\img\\"+ fileName);
                activity.setStatus(0);
                activity.setSignNum(0);
                activity.setPublisherId(uid);
                activity.setPublishData(new Date());
                activity.setSchoolId(user.getSchoolId());
                activity.setActivityClass(1);
                activity.setCollegeId(this.studentService.findStudentByNumber(user.getUserNumber()).getCollegeId());
                out.write(pictureFile.getBytes());
                out.flush();
                out.close();
            }
            this.activityService.addActivity(activity);
            resultBean.setData(activity.getId());

            if (activity.getProjects()!=null && activity.getProjects().size()>0){
                for (Project project: activity.getProjects()){
                    project.setActivityId(activity.getId());
                    this.projectService.addProject(project);
                }
            }

            ActivityStud activityStud = new ActivityStud();
            String num = this.userService.findUsersById(uid).getUserNumber();
            int id = this.studentService.findStudentByNumber(num).getId();
            activityStud.setStudentId(id);
            activityStud.setActivityId(activity.getId());
            activityStud.setCharacters("发起人");
            this.activityStudService.addActivityStud(activityStud);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getClass().toString());
            if (e.getClass().toString().equals("java.sql.SQLIntegrityConstraintViolationException")){
                resultBean.setMsg("学校信息或用户信息不存在");
            }
        }
        return resultBean;
    }

    //点击发布
    @GetMapping("/release/{activityId}")
    public ResultBean release(@PathVariable Integer activityId, HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try{
            Activity activity = this.activityService.findActivityById(activityId);
            if (user.getId() == activity.getPublisherId() && activity.getStatus()==5){
                resultBean.setCode(0);
                activity.setStatus(1);
                this.activityService.ModifyActivity(activity);
            }
            else resultBean.setCode(1);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    //暂存发布数据
    @PostMapping("/preAddActivity")
    public ResultBean preAddActivity(@RequestParam("pictureFile") MultipartFile pictureFile, Activity activity,
                                  HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        ResultBean resultBean = new ResultBean();
        Integer uid = 0;
        if (user!=null)
            uid = user.getId();
        else {
            resultBean.setCode(1);
            resultBean.setMsg("用户不存在");
        }
        if (this.addOrNot(uid)){
            resultBean.setCode(1);
            resultBean.setMsg("您有一个未发布活动，不能新建");
            return resultBean;
        }
        try {
            if (pictureFile != null){
                String filepath = getUploadPath();
                String filename=pictureFile.getOriginalFilename();
                String fileName = getFileName(filename);
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File("C:\\nginx\\img\\"+ fileName)));
                System.out.println("C:\\nginx\\img\\"+ fileName);
                activity.setImagePath("C:\\nginx\\img\\"+ fileName);
                activity.setStatus(5);
                activity.setPublisherId(uid);
                activity.setSignNum(0);
                activity.setActivityClass(1);
                out.write(pictureFile.getBytes());
                out.flush();
                out.close();
            }
            this.activityService.addActivity(activity);

            resultBean.setData(activity.getId());

            if (activity.getProjects()!=null && activity.getProjects().size()>0){
                for (Project project: activity.getProjects()){
                    project.setActivityId(activity.getId());
                    this.projectService.addProject(project);
                }
            }

            ActivityStud activityStud = new ActivityStud();
            String num = this.userService.findUsersById(uid).getUserNumber();
            int id = this.studentService.findStudentByNumber(num).getId();
            activityStud.setStudentId(id);
            activityStud.setActivityId(activity.getId());
            activityStud.setCharacters("发起人");
            this.activityStudService.addActivityStud(activityStud);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getClass().toString());
            if (e.getClass().toString().equals("java.sql.SQLIntegrityConstraintViolationException")){
                resultBean.setMsg("学校信息或用户信息不存在");
            }
        }
        return resultBean;
    }


    @GetMapping("/queryActivity/{id}")
    public ResultBean queryActivity(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.activityService.findActivityById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }
    //查询个人发布的活动
    @GetMapping("/queryActivityList")
    public ResultBean queryActivityList(HttpSession session){
        User user = (User) session.getAttribute("user");
        System.out.println(user.getUsername());
        ResultBean resultBean = new ResultBean();
        try {
            List<Activity> activityList = new ArrayList<>();
            for (Activity activity: this.activityService.findActivityAllList()){
                if (activity.getPublisherId()==user.getId()) {
                    activityList.add(activity);
                }
            }
            resultBean.setData(activityList);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    private ActivityEntry toActivity(Activity activity){
        List<Project> projectList = this.projectService.findProjectByActivityId(activity.getId());
        ActivityEntry activityEntry = new ActivityEntry();
        activityEntry.setId(activity.getId());
        activityEntry.setActivityName(activity.getActivityName());
        activityEntry.setPublisherId(this.userService.findUsersById(activity.getPublisherId()).getUsername());
        activityEntry.setActivityContent(activity.getActivityContent() == null ? "" : activity.getActivityContent());
        activityEntry.setCollegeId(this.collegeService.findCollegeById(activity.getCollegeId()).getCollegeName());
        activityEntry.setCollegeList(activity.getCollegeList() == null ? "" : activity.getCollegeList());
        activityEntry.setContactPhone(activity.getContactPhone() == null ? "" : activity.getContactPhone());
        activityEntry.setEndTime(activity.getEndTime() == null ? new Date() : activity.getEndTime());
        activityEntry.setImagePath(activity.getImagePath() == null ? "" : activity.getImagePath());
        activityEntry.setPeopleNum(activity.getPeopleNum() == null ? 0 : activity.getPeopleNum());
        activityEntry.setPublishData(activity.getPublishData() == null ? new Date() : activity.getPublishData());
        activityEntry.setRegistrationClosingTime(activity.getRegistrationClosingTime() == null ? new Date() : activity.getRegistrationClosingTime());
        activityEntry.setRegistrationStartTime(activity.getRegistrationStartTime() == null ? new Date() : activity.getRegistrationStartTime());
        activityEntry.setSchoolId(activity.getSchoolId() == null ? "" : this.schoolService.findSchoolById(activity.getSchoolId()).getSchoolName());
        activityEntry.setStartTime(activity.getStartTime() == null ? new Date() : activity.getStartTime());
        activityEntry.setStatus(activity.getStatus() == null ? 0 : activity.getStatus());
        activityEntry.setSignNum(activity.getSignNum()==null?0:activity.getSignNum());
        activityEntry.setActivityArea(activity.getActivityArea());
        activityEntry.setReviewTime(activity.getReviewTime());
        activityEntry.setCost(activity.getCost());
        activityEntry.setContact(activity.getContact());
        activityEntry.setActivityClass(activity.getActivityClass());
        activityEntry.setReviewTime(activity.getReviewTime()==null?new Date():activity.getReviewTime());
        activityEntry.setCostDescription(activity.getCostDescription());
        if (projectList != null) {
            activity.setProjects(projectList);
            activityEntry.setProjectList(projectList);
        }
        return activityEntry;
    }
    // 查询所有活动
    @PostMapping("/queryActivityListAll")
    public ResultBean queryActivityListAll(@RequestBody Page page, HttpSession session){
        User userSession = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.activityService.findActivityAll(page,userSession.getSchoolId()));
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }
//    //按条件查找
//    @PostMapping("/queryActivityListAll")
//    public ResultBean queryActivityListAll(@RequestBody Page page, String columnName,Integer searchContent, HttpSession session){
//        User userSession = (User) session.getAttribute("user");
//        ResultBean resultBean = new ResultBean();
//        try {
//            resultBean.setData(this.activityService.findActivityAll(page,userSession.getSchoolId(),columnName,searchContent));
//            resultBean.setCode(0);
//        }catch (Exception e){
//            resultBean.setCode(1);
//            resultBean.setMsg(e.getMessage());
//            System.out.println(e.getMessage());
//        }
//        return resultBean;
//    }

    //获取可报名活动
    @PostMapping("/queryActivityListSignIn")
    public ResultBean queryActivityListSignIn(@RequestBody Page page, HttpSession session){
        User userSession = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.activityService.selectActivityAllSignIn(page,userSession.getSchoolId()));
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @PostMapping("/updateActivity")
    public ResultBean updateActivity(@RequestBody Activity activity){
        ResultBean resultBean = new ResultBean();
        try {
            this.activityService.ModifyActivity(activity);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @PostMapping("/deleteActivity")
    public ResultBean deleteActivity(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {

            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    private String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        final SimpleDateFormat sDateFormate = new SimpleDateFormat("yyyymmddHHmmss");  //设置时间格式
        String nowTimeStr = sDateFormate.format(new Date()); // 当前时间
        fileName = fileName.substring(0, index) + "_" + nowTimeStr + fileName.substring(index);
        return fileName;
    }

    /**
     * 获取当前系统路径
     */
    private String getUploadPath() {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!path.exists()) path = new File("");
        File upload = new File(path.getAbsolutePath(), "static/upload/");
        if (!upload.exists()) upload.mkdirs();
        return upload.getAbsolutePath();
    }
    //表示拒绝或者同意审核
    @GetMapping("/reviewById/{id}/{code}")
    public ResultBean reviewById(@PathVariable Integer id, @PathVariable Integer code){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(1);
        try {
            Activity activity = this.activityService.findActivityById(id);
            if (activity.getStatus()==0){
                if (code==1) {
                    activity.setStatus(1);
                    activity.setReviewTime(new Date());
                    resultBean.setCode(0);
                    this.activityService.ModifyActivity(activity);
                }
                else if (code==6) {
                    activity.setStatus(6);
                    activity.setReviewTime(new Date());
                    resultBean.setCode(0);
                    this.activityService.ModifyActivity(activity);
                }
            }
            else {
                resultBean.setCode(1);
                resultBean.setMsg("状态已审核");
            }
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    @PostMapping("/reviewByIdList")
    public ResultBean reviewByIdList(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try {
            for (Integer id: ids){
                Activity activity = this.activityService.findActivityById(id);
                if (activity.getStatus()==0) {
                    activity.setStatus(1);
                    this.activityService.ModifyActivity(activity);
                }
            }
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    @GetMapping("/selectReview")
    public ResultBean selectReview(HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("schoolmanager"));
        try {
            List<Activity> activitys = this.activityService.findActivityAllList();
            List<ActivityEntry> activityEntries = new ArrayList<>();
            if (HasRole.hasOneRole(booleans)) {
                for (Activity activity : activitys) {
                    if (activity.getSchoolId()==user.getSchoolId() && activity.getStatus() == 0 &&
                            activity.getRegistrationStartTime().compareTo(new Date())>0) {
                        activityEntries.add(this.toActivity(activity));
                    }
                }
                resultBean.setData(activityEntries);
                resultBean.setCode(0);
            }
            else {
                resultBean.setCode(1);
                resultBean.setMsg("您没有权限");
            }
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }
    //个人报名参加活动
    @GetMapping("/signUp/{aid}")
    public ResultBean signUp(@PathVariable Integer aid, HttpSession session){
        ResultBean resultBean = new ResultBean();
        User user = (User) session.getAttribute("user");
        List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (ActivityStud activityStud:activityStuds){
            if (!map.containsKey(activityStud.getActivityId())) {
                map.put(activityStud.getActivityId(), Arrays.asList(activityStud.getStudentId()));
            }
            else {
                List<Integer> list = map.get(activityStud.getActivityId());
                List arrList = new ArrayList(list);
                arrList.add(activityStud.getStudentId());
                map.put(activityStud.getActivityId(),arrList);
            }
        }
        Activity activity = this.activityService.findActivityById(aid);
        if (activity.getSignNum()==null)
            activity.setSignNum(0);
        Date nowDate = new Date();
        try {
            ActivityStud activityStud = new ActivityStud();
            String num = this.userService.findUsersById(user.getId()).getUserNumber();
            int id = this.studentService.findStudentByNumber(num).getId();
            if (map.containsKey(aid) && map.get(aid).contains(id)){
                resultBean.setCode(1);
                resultBean.setMsg("已报名参加！");
            }
            else if (activity.getSignNum()+1>activity.getPeopleNum()){
                resultBean.setCode(1);
                resultBean.setMsg("报名人数已满！");
            }
            else if (activity.getRegistrationStartTime().compareTo(nowDate)<0 &&
                    activity.getRegistrationClosingTime().compareTo(nowDate)>0){
                activityStud.setStudentId(id);
                activityStud.setActivityId(aid);
                activityStud.setCharacters("参与者");
                Signin signin = new Signin();
                signin.setFlag(0);
                signin.setStudentId(id);
                signin.setActivityId(aid);

                activity.setSignNum(activity.getSignNum()+1);
                this.activityService.ModifyActivity(activity);
                this.signInService.addSignin(signin);
                this.activityStudService.addActivityStud(activityStud);
                resultBean.setCode(0);
            }
            else {
                resultBean.setCode(1);
                resultBean.setMsg("报名时间已过！");
            }
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }
    //根据id批量参与活动
    @PostMapping("/signUpList/{aid}")
    public ResultBean signUpList(@RequestBody List<Integer> ids, @PathVariable Integer aid){
        ResultBean resultBean = new ResultBean();
        List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (ActivityStud activityStud:activityStuds){
            if (map.containsKey(activityStud.getActivityId())) {
                map.put(activityStud.getActivityId(), Arrays.asList(activityStud.getStudentId()));
            }
            else
                map.get(activityStud.getActivityId()).add(activityStud.getStudentId());
        }
        try {
            for (Integer id: ids) {
                if (map.containsKey(aid) && map.get(aid).contains(id))
                    continue;
                ActivityStud activityStud = new ActivityStud();
                String num = this.userService.findUsersById(id).getUserNumber();
                int sid = this.studentService.findStudentByNumber(num).getId();
                activityStud.setStudentId(sid);
                activityStud.setActivityId(aid);
                activityStud.setCharacters("参与者");
                Signin signin = new Signin();
                signin.setFlag(0);
                signin.setStudentId(sid);
                signin.setActivityId(aid);
                this.signInService.addSignin(signin);
                this.activityStudService.addActivityStud(activityStud);
            }
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    //根据id批量参与活动和项目
    @PostMapping("/signUpListWithProject/{aid}/{projectId}")
    public ResultBean signUpListWithProject(@RequestBody List<Integer> ids, @PathVariable Integer aid,
                                            @PathVariable Integer projectId){
        ResultBean resultBean = new ResultBean();
        List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (ActivityStud activityStud:activityStuds){
            if (map.containsKey(activityStud.getActivityId())) {
                map.put(activityStud.getActivityId(), Arrays.asList(activityStud.getStudentId()));
            }
            else
                map.get(activityStud.getActivityId()).add(activityStud.getStudentId());
        }
        try {
            for (Integer id: ids) {
                if (map.containsKey(aid) && map.get(aid).contains(id))
                    continue;
                ActivityStud activityStud = new ActivityStud();
                String num = this.userService.findUsersById(id).getUserNumber();
                int sid = this.studentService.findStudentByNumber(num).getId();
                activityStud.setStudentId(sid);
                activityStud.setActivityId(aid);
                activityStud.setCharacters("参与者");
                Signin signin = new Signin();
                signin.setFlag(0);
                signin.setStudentId(sid);
                signin.setActivityId(aid);
                Projectsignin projectsignin = new Projectsignin();
                this.signInService.addSignin(signin);
                this.activityStudService.addActivityStud(activityStud);
                projectsignin.setActivityid(aid);
                projectsignin.setProjectid(projectId);
                projectsignin.setSigninid(signin.getId());
                projectsignin.setStudentid(sid);
                this.projectSignInService.addProjectSignIn(projectsignin);
            }
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    @GetMapping("/assignation/{aid}/{uid}")
    public ResultBean assignation(@PathVariable Integer aid, @PathVariable Integer uid){
        //User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (ActivityStud activityStud:activityStuds){
            if (!map.containsKey(activityStud.getActivityId())) {
                map.put(activityStud.getActivityId(), Arrays.asList(activityStud.getStudentId()));
            }
            else {
                List<Integer> list = map.get(activityStud.getActivityId());
                List arrList = new ArrayList(list);
                arrList.add(activityStud.getStudentId());
                map.put(activityStud.getActivityId(),arrList);
            }
        }

        try {
            String num = this.userService.findUsersById(uid).getUserNumber();
            int id = this.studentService.findStudentByNumber(num).getId();

            if (map.containsKey(aid) && map.get(aid).contains(id)){
                resultBean.setCode(1);
                resultBean.setMsg("已报名参加！");
            }
            else {
                ActivityStud activityStud = new ActivityStud();
                activityStud.setStudentId(id);
                activityStud.setActivityId(aid);
                activityStud.setCharacters("签到员");
                this.activityStudService.addActivityStud(activityStud);
                resultBean.setCode(0);
            }
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }
    //根据活动id获取参与者
    @GetMapping("/getPartner/{aid}")
    public ResultBean getPartner(@PathVariable Integer aid){
        ResultBean resultBean = new ResultBean();
        try {
            List<ActivityStudEntry> activityStudList = new ArrayList<>();
            List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
            for (ActivityStud activityStud: activityStuds){
                if(activityStud.getCharacters().equals("参与者") && activityStud.getActivityId()==aid){
                    ActivityStudEntry activityStudEntry = this.IntegerToString(activityStud);
                    if (activityStudEntry!=null) {
                        activityStudList.add(activityStudEntry);
                    }
                }
            }
            resultBean.setCode(0);
            resultBean.setData(activityStudList);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }
    // 根据活动id获取发起人信息
    @GetMapping("/getOrganizers/{aid}")
    public ResultBean getOrganizers(@PathVariable Integer aid){
        ResultBean resultBean = new ResultBean();
        try {
            List<ActivityStudEntry> activityStudList = new ArrayList<>();
            List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
            for (ActivityStud activityStud: activityStuds){
                if(activityStud.getCharacters().equals("发起人") && activityStud.getActivityId()==aid){
                    ActivityStudEntry activityStudEntry = this.IntegerToString(activityStud);
                    if (activityStudEntry!=null) {
                        activityStudList.add(activityStudEntry);
                    }
                }
            }
            resultBean.setCode(0);
            resultBean.setData(activityStudList);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }
    //根据活动id获取参加活动的人员信息
    @GetMapping("/getSignIn/{aid}")
    public ResultBean getSignIn(@PathVariable Integer aid){
        ResultBean resultBean = new ResultBean();
        try {
            List<ActivityStudEntry> activityStudList = new ArrayList<>();
            List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
            for (ActivityStud activityStud: activityStuds){
                if(activityStud.getCharacters().equals("签到员") && activityStud.getActivityId()==aid){
                    ActivityStudEntry activityStudEntry = this.IntegerToString(activityStud);
                    if (activityStudEntry!=null) {
                        activityStudList.add(activityStudEntry);
                    }
                }
            }
            resultBean.setCode(0);
            resultBean.setData(activityStudList);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    private ActivityStudEntry IntegerToString(ActivityStud activityStud){
        int signStatus = -1;
        int signId = -1;
        try {
            List<Signin> signins = this.signInService.findSigninAll();
            for (Signin signin: signins){
                if (signin.getStudentId()==activityStud.getStudentId()&&
                        signin.getActivityId()==activityStud.getActivityId()){
                    signStatus = signin.getFlag();
                    signId = signin.getId();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Activity activity =  this.activityService.findActivityById(activityStud.getActivityId());
            Student student = this.studentService.findStudentById(activityStud.getStudentId());
            ActivityStudEntry activityStudEntry = new ActivityStudEntry();
            activityStudEntry.setActivityId(activity.getActivityName());
            activityStudEntry.setCharacters(activityStud.getCharacters());
            activityStudEntry.setId(activityStud.getActivityId());
            activityStudEntry.setStudentId(student.getStudentName());
            activityStudEntry.setSportState(activity.getStatus()==null?0:activity.getStatus());
            activityStudEntry.setStudentNumber(student.getStudentNumber());
            activityStudEntry.setSignStatus(signStatus);
            activityStudEntry.setSignId(signId);
            activityStudEntry.setStatus(activity.getStatus());
            activityStudEntry.setStudentIDNum(student.getId());
            return activityStudEntry;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getActivityByOrganizers")
    public ResultBean getActivityByOrganizers(HttpSession session){
        User user = (User) session.getAttribute("user");
        System.out.println(user.getUserNumber());
        ResultBean resultBean = new ResultBean();
        try {
            Student student = this.studentService.findStudentByNumber(user.getUserNumber());
            List<ActivityStudEntry> activityStudList = new ArrayList<>();
            List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
            for (ActivityStud activityStud: activityStuds){
                System.out.println(activityStud.getCharacters()+","+student.getId()+","+activityStud.getStudentId());
                if(activityStud.getCharacters().equals("发起人")&&student.getId()==activityStud.getStudentId()){
                    ActivityStudEntry activityStudEntry = this.IntegerToString(activityStud);
                    if (activityStudEntry!=null) {
                        activityStudList.add(activityStudEntry);
                    }
                }
            }
            resultBean.setCode(0);
            resultBean.setData(activityStudList);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    @GetMapping("/getActivityByPartner")
    public ResultBean getActivityByPartner(HttpSession session){
        User user = (User) session.getAttribute("user");
        System.out.println(user.getUsername());
        ResultBean resultBean = new ResultBean();
        try {
            Student student = this.studentService.findStudentByNumber(user.getUserNumber());
            List<ActivityStudEntry> activityStudList = new ArrayList<>();
            List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
            for (ActivityStud activityStud: activityStuds){
                if(activityStud.getCharacters().equals("参与者")&&student.getId()==activityStud.getStudentId()){
                    ActivityStudEntry activityStudEntry = this.IntegerToString(activityStud);
                    if (activityStudEntry!=null) {
                        List<Projectsignin> projectByActivityId =
                                this.projectSignInService.findProjectByActivityId(activityStud.getActivityId());
                        if (projectByActivityId!=null){
                            activityStudEntry.setProjectsignins(projectByActivityId);
                        }
                        activityStudList.add(activityStudEntry);
                    }
                }
            }
            resultBean.setCode(0);
            resultBean.setData(activityStudList);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    @GetMapping("/getActivityBySignin")
    public ResultBean getActivityBySignin(HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            Student student = this.studentService.findStudentByNumber(user.getUserNumber());
            List<ActivityStudEntry> activityStudList = new ArrayList<>();
            List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
            for (ActivityStud activityStud: activityStuds){
                if(activityStud.getCharacters().equals("签到员")&&student.getId()==activityStud.getStudentId()) {
                    ActivityStudEntry activityStudEntry = this.IntegerToString(activityStud);
                    if (activityStudEntry != null) {
                        List<Projectsignin> projectByActivityId =
                                this.projectSignInService.findProjectByActivityId(activityStud.getActivityId());
                        if (projectByActivityId!=null){
                            activityStudEntry.setProjectsignins(projectByActivityId);
                        }
                        activityStudList.add(activityStudEntry);
                    }
                }
            }
            resultBean.setCode(0);
            resultBean.setData(activityStudList);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

}
