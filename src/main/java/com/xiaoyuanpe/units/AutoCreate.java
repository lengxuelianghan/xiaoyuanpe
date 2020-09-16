package com.xiaoyuanpe.units;

import com.xiaoyuanpe.pojo.Activity;
import com.xiaoyuanpe.pojo.Signin;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.pojo.StudentExample;
import com.xiaoyuanpe.services.ActivityService;
import com.xiaoyuanpe.services.SignInService;
import com.xiaoyuanpe.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class AutoCreate {
    @Autowired
    private StudentService studentService;
    @Autowired
    private SignInService signInService;
    @Autowired
    private ActivityService activityService;

    @Scheduled(cron = "0 22 22 * * ?")
    public void addSignIn(){
        try{
            System.out.println("你好");
            StudentExample studentExample = new StudentExample();
            for (Student student: this.studentService.findStudentAll()){
                Signin signin1 = new Signin();
                signin1.setFlag(0);
                signin1.setSignTime(new Date());
                signin1.setStudentId(student.getId());
                this.signInService.addSignin(signin1);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Scheduled(cron = "0 */1 * * * ?")
    public void updateStatus(){
        try{
            //System.out.println("123321");
            Date date = new Date();
            List<Activity> activityList =  this.activityService.findActivityAllList();
            for (Activity activity: activityList){
//                System.out.println(date.compareTo(activity.getEndTime()));
//                System.out.println(date.compareTo(activity.getRegistrationStartTime()));
//                System.out.println(date.compareTo(activity.getRegistrationClosingTime()));
//                System.out.println(date);
//                System.out.println(activity.getEndTime());

                if (activity.getStatus()==1 && date.compareTo(activity.getRegistrationStartTime())>0 && date.compareTo(activity.getRegistrationClosingTime())<0){
                    activity.setStatus(2);
                }
                else if (activity.getStatus()==2 && date.compareTo(activity.getStartTime())>0 && date.compareTo(activity.getEndTime())<0){
                    activity.setStatus(3);
                }
                else if(activity.getStatus()==4 && date.compareTo(activity.getEndTime())>0){
                    activity.setStatus(4);
                }
                this.activityService.ModifyActivity(activity);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
