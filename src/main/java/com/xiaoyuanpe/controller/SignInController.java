package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.Signin;
import com.xiaoyuanpe.pojo.Student;
import com.xiaoyuanpe.services.*;
import com.xiaoyuanpe.units.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private SchoolService schoolService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private ClassesService classesService;

    @PostMapping("/updateSignIn")
    public ResultBean updateSignIn(@RequestBody Signin signin){
        ResultBean resultBean = new ResultBean();
        try{
            if (signin.getFlag()==2){
                signin.setSignoutTime(new Date());
            }
            this.signInService.ModifySignin(signin);
        }
        catch (Exception e){
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
                if (signin.getSignTime()!=null) {
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

    @PostMapping("/updateSignIOutList")
    public ResultBean updateSignIOutList(@RequestBody List<Integer> ids){
        ResultBean resultBean = new ResultBean();
        try{
            for(Integer id: ids){
                Signin signin = this.signInService.findSigninById(id);
                signin.setFlag(2);
                signin.setSignoutTime(new Date());
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
