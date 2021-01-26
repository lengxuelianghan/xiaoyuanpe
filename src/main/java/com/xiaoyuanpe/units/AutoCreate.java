package com.xiaoyuanpe.units;

import com.xiaoyuanpe.pojo.*;
import com.xiaoyuanpe.services.ActivityService;
import com.xiaoyuanpe.services.ReservationService;
import com.xiaoyuanpe.services.SignInService;
import com.xiaoyuanpe.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @Autowired
    private ReservationService reservationService;

    //创建早操签到记录
    @Scheduled(cron = "0 10 5 ? * MON-FRI")
    public void addSignIn(){
        try{
            System.out.println("你好");
            StudentExample studentExample = new StudentExample();
            for (Student student: this.studentService.findStudentAll()){
                Signin signin1 = new Signin();
                signin1.setFlag(0);
                signin1.setCreateTime(new Date());
                signin1.setStudentId(student.getId());
                signin1.setSportId(1);
                this.signInService.addSignin(signin1);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //每天23点将当天的预定记录清空
    @Scheduled(cron = "0 0 23 * * ?")
    public void InitReservation(){
        try{
            int dayInWeek = new Date().getDay();
            for (Reservation reservation: this.reservationService.findReservationAllByDay(dayInWeek)){
                reservation.setStatus(0);
                this.reservationService.ModifyReservation(reservation);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //对活动进行判断是否可以报名，是否可以在进行中
    @Scheduled(cron = "0 */1 * * * ?")
    public void updateStatus(){
        try{
            //System.out.println("123321");
            Date date = new Date();
            date = new Date(date.getTime());
            List<Activity> activityList =  this.activityService.findActivityAllList();
            for (Activity activity: activityList){

                // 0 未审核 1 已审核
                if (activity.getStatus()==1 && date.compareTo(activity.getRegistrationStartTime())>0 && date.compareTo(activity.getRegistrationClosingTime())<0){
                    activity.setStatus(2);//报名阶段
                }
                else if (activity.getStatus()==2 && date.compareTo(activity.getStartTime())>0 && date.compareTo(activity.getEndTime())<0){
                    activity.setStatus(3);//待完结
                }
                else if(activity.getStatus()==3 && date.compareTo(activity.getEndTime())>0){
                    activity.setStatus(4);//完结
                }
                this.activityService.ModifyActivity(activity);
            }
        }
        catch (Exception e){
            System.out.println("错误"+e.getMessage());
        }
    }

    //计算学生学期
    @Scheduled(cron = "0 00 12 20 8 ?")
    public void handleStudentWithTerm(){
        try{
            List<Student> studentAll = this.studentService.findStudentAll();
            for (Student student: studentAll){
                student.setTerm(student.getTerm()+1);
            }
            this.studentService.ModifyBatch(studentAll);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //删除学生
    @Scheduled(cron = "0 00 12 30 6 ?")
    public void handleStudentOverTerm(){
        try{
            List<Integer> ids = new ArrayList<>();
            List<Student> studentAll = this.studentService.findStudentAll();
            for (Student student: studentAll){
                if (student.getTerm()>=8){
                    ids.add(student.getId());
                }
            }
            this.studentService.DeleteStudentList(ids);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
