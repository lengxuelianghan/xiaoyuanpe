package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/addActivity")
    public ResultBean addActivity(@RequestParam("pictureFile") MultipartFile pictureFile, Activity activity){
        ResultBean resultBean = new ResultBean();
        try {
            if (pictureFile != null){
                String filepath = getUploadPath();
                String filename=pictureFile.getOriginalFilename();
                String fileName = getFileName(filename);
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File("C:\\nginx\\img\\"+ fileName)));
                System.out.println("C:\\nginx\\img\\"+ fileName);
                activity.setImagePath("C:\\nginx\\img\\"+  fileName);
                out.write(pictureFile.getBytes());
                out.flush();
            }
            this.activityService.addActivity(activity);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }
        return resultBean;
    }

    @PostMapping("/addActivity/{uid}")
    public ResultBean addActivity(@RequestParam("pictureFile") MultipartFile pictureFile, Activity activity,
                                  @PathVariable Integer uid){
        ResultBean resultBean = new ResultBean();
        try {
            if (pictureFile != null){
                String filepath = getUploadPath();
                String filename=pictureFile.getOriginalFilename();
                String fileName = getFileName(filename);
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File("C:\\nginx\\img\\"+ fileName)));
                System.out.println("C:\\nginx\\img\\"+ fileName);
                activity.setImagePath("C:\\nginx\\img\\"+ fileName);
                out.write(pictureFile.getBytes());
                out.flush();
            }
            this.activityService.addActivity(activity);

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
            System.out.println(e.getMessage());
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

    @GetMapping("/queryActivityListAll")
    public ResultBean queryActivityListAll(){
        ResultBean resultBean = new ResultBean();
        try {
            List<Activity> activityList = this.activityService.findActivityAllList();
            List<User> users = this.userService.findUsersListAll();
            Map<Integer, String> userNameMap = new HashMap<>();
            for (User user: users) {
                userNameMap.put(user.getId(), user.getUsername());
            }
            List<ActivityEntry> activityEntries = new ArrayList<>();
            for (Activity activity: activityList){
                ActivityEntry activityEntry = new ActivityEntry();
                activityEntry.setId(activity.getId());
                activityEntry.setActivityName(activity.getActivityName());
                activityEntry.setContact(activity.getContact()==null?"":activity.getContact());
                activityEntry.setPublisherId(this.userService.findUsersById(activity.getPublisherId()).getUsername());
                activityEntry.setActivityArea(activity.getActivityArea()==null?"":activity.getActivityArea());
                activityEntry.setActivityContent(activity.getActivityContent()==null?"":activity.getActivityContent());
                activityEntry.setActivityClassification(activity.getActivityClassification()==null?"":activity.getActivityClassification());
                activityEntry.setClassList(activity.getClassList()==null?"":activity.getClassList());
                activityEntry.setCollege(activity.getCollege()==null?"":activity.getCollege());
                activityEntry.setCollegeId(activity.getCollegeId()==null?0:activity.getCollegeId());
                activityEntry.setCollegeList(activity.getCollegeList()==null?"":activity.getCollegeList());
                activityEntry.setContactPhone(activity.getContactPhone()==null?"":activity.getContactPhone());
                activityEntry.setEndTime(activity.getEndTime()==null?new Date():activity.getEndTime());
                activityEntry.setEventLocation(activity.getEventLocation()==null?"":activity.getEventLocation());
                activityEntry.setFieldClock(activity.getFieldClock()==null?"":activity.getFieldClock());
                activityEntry.setImagePath(activity.getImagePath()==null?"":activity.getImagePath());
                activityEntry.setParticipationFee(activity.getParticipationFee()==null?"":activity.getParticipationFee());
                activityEntry.setPeopleNum(activity.getPeopleNum()==null?0:activity.getPeopleNum());
                activityEntry.setPublishData(activity.getPublishData()==null?new Date():activity.getPublishData());
                activityEntry.setRegistrationClosingTime(activity.getRegistrationClosingTime()==null?new Date():activity.getRegistrationClosingTime());
                activityEntry.setRegistrationStartTime(activity.getRegistrationStartTime()==null?new Date():activity.getRegistrationStartTime());
                activityEntry.setReviewerId(activity.getReviewerId()==null?"":activity.getReviewerId());
                activityEntry.setSchoolId(activity.getSchoolId()==null?"":this.schoolService.findSchoolById(activity.getSchoolId()).getSchoolName());
                //System.out.println(activityEntry.getActivityName() + activity.getActivityName());
                activityEntry.setSignout(activity.getSignout()==null?"":activity.getSignout());
                activityEntry.setStartTime(activity.getStartTime()==null?new Date():activity.getStartTime());
                activityEntry.setStatus(activity.getStatus()==null?0:activity.getStatus());
                activityEntry.setWayRegistration(activity.getWayRegistration()==null?"":activity.getWayRegistration());
                activityEntries.add(activityEntry);
            }
            resultBean.setData(activityEntries);
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

    @GetMapping("/reviewById/{id}")
    public ResultBean reviewById(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            Activity activity = this.activityService.findActivityById(id);
            if (activity.getStatus()==0){
                activity.setStatus(1);
                resultBean.setCode(0);
                this.activityService.ModifyActivity(activity);
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
        try {
            List<Activity> activityList = new ArrayList<>();
            List<Activity> activitys = this.activityService.findActivityAllList();
            for(Activity activity: activitys){
                System.out.println(activity.getReviewerId()+"."+user.getId());
                if (activity.getReviewerId()!=null && Integer.parseInt(activity.getReviewerId())==user.getId()){
                    activityList.add(activity);
                }
            }
            resultBean.setData(activityList);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }
    @GetMapping("/signUp/{aid}")
    public ResultBean signUp(@PathVariable Integer aid, HttpSession session){
        ResultBean resultBean = new ResultBean();
        User user = (User) session.getAttribute("user");
        try {
            ActivityStud activityStud = new ActivityStud();
            String num = this.userService.findUsersById(user.getId()).getUserNumber();
            int id = this.studentService.findStudentByNumber(num).getId();
            activityStud.setStudentId(id);
            activityStud.setActivityId(aid);
            activityStud.setCharacters("参与者");
            this.activityStudService.addActivityStud(activityStud);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    @PostMapping("/signUpList/{aid}")
    public ResultBean signUpList(@RequestBody List<Integer> ids, @PathVariable Integer aid){
        ResultBean resultBean = new ResultBean();
        try {
            for (Integer id: ids) {
                ActivityStud activityStud = new ActivityStud();
                String num = this.userService.findUsersById(id).getUserNumber();
                int sid = this.studentService.findStudentByNumber(num).getId();
                activityStud.setStudentId(sid);
                activityStud.setActivityId(aid);
                activityStud.setCharacters("参与者");
                this.activityStudService.addActivityStud(activityStud);
            }
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    @GetMapping("/assignation/{aid}/{sid}/{role}")
    public ResultBean assignation(@PathVariable Integer aid, @PathVariable Integer sid, @PathVariable  String role){
        ResultBean resultBean = new ResultBean();
        try {
            ActivityStud activityStud = new ActivityStud();
            String num = this.userService.findUsersById(sid).getUserNumber();
            int id = this.studentService.findStudentByNumber(num).getId();
            activityStud.setStudentId(id);
            activityStud.setActivityId(aid);
            activityStud.setCharacters(role);
            this.activityStudService.addActivityStud(activityStud);
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    @GetMapping("/getPartner/{aid}")
    public ResultBean getPartner(@PathVariable Integer aid){
        ResultBean resultBean = new ResultBean();
        try {
            List<ActivityStud> activityStudList = new ArrayList<>();
            List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
            for (ActivityStud activityStud: activityStuds){
                if(activityStud.getCharacters().equals("参与者") && activityStud.getActivityId()==aid){
                    activityStudList.add(activityStud);
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

    public ActivityStudEntry IntegerToString(ActivityStud activityStud){
        int signStatus = -1;
//        try {
//            List<Signin> signins = this.signInService.findSigninAll();
//            for (Signin signin: signins){
//                if (signin.getStudentId()==activityStud.getStudentId()&&
//                        signin.getActivityId()==activityStud.getActivityId()){
//                    signStatus = signin.getFlag();
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        try {
            Activity activity =  this.activityService.findActivityById(activityStud.getActivityId());
            Student student = this.studentService.findStudentById(activityStud.getStudentId());
            ActivityStudEntry activityStudEntry = new ActivityStudEntry();
            activityStudEntry.setActivityId(activity.getActivityName());
            activityStudEntry.setCharacters(activityStud.getCharacters());
            activityStudEntry.setId(activityStud.getActivityId());
            activityStudEntry.setStudentId(student.getStudentName());
            activityStudEntry.setSportState(activity.getStatus());
            activityStudEntry.setStudentNumber(student.getStudentNumber());
            activityStudEntry.setSignStatus(signStatus);
            return activityStudEntry;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getActivityByOrganizers")
    public ResultBean getActivityByOrganizers(HttpSession session){
        User user = (User) session.getAttribute("user");
        ResultBean resultBean = new ResultBean();
        try {
            Student student = this.studentService.findStudentByNumber(user.getUserNumber());
            List<ActivityStudEntry> activityStudList = new ArrayList<>();
            List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
            for (ActivityStud activityStud: activityStuds){
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
