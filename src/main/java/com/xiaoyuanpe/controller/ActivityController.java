package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Activity;
import com.xiaoyuanpe.pojo.ActivityStud;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.ActivityService;
import com.xiaoyuanpe.services.ActivityStudService;
import com.xiaoyuanpe.services.StudentService;
import com.xiaoyuanpe.services.UserService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @PostMapping("/addActivity")
    public ResultBean addActivity(@RequestParam("imageFile") MultipartFile imageFile, Activity activity){
        ResultBean resultBean = new ResultBean();
        try {
            if (imageFile != null){
                String filepath = getUploadPath();
                String filename=imageFile.getOriginalFilename();
                String fileName = getFileName(filename);
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(filepath + File.separator + fileName)));
                System.out.println(filepath + File.separator + fileName);
                activity.setImagePath(filepath + File.separator + fileName);
                out.write(imageFile.getBytes());
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
            resultBean.setData(this.activityService.findActivityAllList());
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
        try {
            User user = (User) session.getAttribute("user");
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

    @GetMapping("/organizer/{aid}")
    public ResultBean organizer(@PathVariable Integer aid, HttpSession session){
        ResultBean resultBean = new ResultBean();
        try {
            User user = (User) session.getAttribute("user");
            Integer sid = user.getId();
            ActivityStud activityStud = new ActivityStud();
            String num = this.userService.findUsersById(sid).getUserNumber();
            int id = this.studentService.findStudentByNumber(num).getId();
            activityStud.setStudentId(id);
            activityStud.setActivityId(aid);
            if (this.activityService.findActivityById(aid).getPublisherId()==sid) {
                activityStud.setCharacters("发起人");
                this.activityStudService.addActivityStud(activityStud);
            }
            resultBean.setCode(0);
        }catch (Exception e){
            resultBean.setCode(1);
            resultBean.setMsg(e.getMessage());
        }
        return resultBean;
    }

    @GetMapping("/getPartner")
    public ResultBean getPartner(){
        ResultBean resultBean = new ResultBean();
        try {
            List<ActivityStud> activityStudList = new ArrayList<>();
            List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
            for (ActivityStud activityStud: activityStuds){
                if(activityStud.getCharacters().equals("参与者")){
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

    @GetMapping("/getOrganizers")
    public ResultBean getOrganizers(){
        ResultBean resultBean = new ResultBean();
        try {
            List<ActivityStud> activityStudList = new ArrayList<>();
            List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
            for (ActivityStud activityStud: activityStuds){
                if(activityStud.getCharacters().equals("发起人")){
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

    @GetMapping("/getSignIn")
    public ResultBean getSignIn(){
        ResultBean resultBean = new ResultBean();
        try {
            List<ActivityStud> activityStudList = new ArrayList<>();
            List<ActivityStud> activityStuds = this.activityStudService.findActivityStudAllList();
            for (ActivityStud activityStud: activityStuds){
                if(activityStud.getCharacters().equals("签到员")){
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

}
