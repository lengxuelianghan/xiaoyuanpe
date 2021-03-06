package com.xiaoyuanpe.controller;

import com.xiaoyuanpe.pojo.SportStud;
import com.xiaoyuanpe.pojo.Sports;
import com.xiaoyuanpe.pojo.User;
import com.xiaoyuanpe.services.SportService;
import com.xiaoyuanpe.services.SportStudService;
import com.xiaoyuanpe.services.StudentService;
import com.xiaoyuanpe.services.UserService;
import com.xiaoyuanpe.units.HasRole;
import com.xiaoyuanpe.units.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {
    @Autowired
    private SportService sportService;
    @Autowired
    private SportStudService sportStudService;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/addSport")
    public ResultBean addSport(@RequestBody Sports sports){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportService.addSports(sports);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动信息添加错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping("/querySport/{id}")
    public ResultBean querySport(@PathVariable Integer id){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.sportService.findSportsById(id));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动查找错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping("/querySportList/{current}/{pageSize}")
    public ResultBean querySportList(@PathVariable Integer current, @PathVariable Integer pageSize){
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setData(this.sportService.findSportsAll(current, pageSize));
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动列表查找错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping(value = "/updateSport", method = RequestMethod.POST)
    public ResultBean updateSport(@RequestBody Sports sports){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportService.ModifySports(sports);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动修改错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }

    @RequestMapping(value = "/deleteSport", method = RequestMethod.POST)
    public ResultBean deleteSport(@RequestBody List ids){
        ResultBean resultBean = new ResultBean();
        try {
            this.sportService.DeleteSportsList(ids);
            resultBean.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resultBean.setMsg("运动修改错误");
            resultBean.setCode(1);
        }
        return resultBean;
    }
    //指定早操签到员
    @RequestMapping("/designateChecker/{sportId}/{studentId}")
    public ResultBean designateChecker(@PathVariable Integer sportId,@PathVariable Integer studentId){
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("teacher","classmanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                User rolesByUsername = this.userService.findUsersByStudentNum(this.studentService.findStudentById(studentId).getStudentNumber());
                if (!rolesByUsername.getIdentity().equals("学生")){
                    resultBean.setMsg("用户是"+rolesByUsername.getIdentity()+"身份"+"，设置失败");
                    resultBean.setCode(2);
                }
                else if (!rolesByUsername.getIdentity().equals("签到员")) {
                    SportStud sportStud = new SportStud();
                    sportStud.setStudentId(studentId);
                    sportStud.setSportId(sportId);
                    sportStud.setCharacters("签到员");
                    rolesByUsername.setIdentity("签到员");
                    this.userService.ModifyUser(rolesByUsername);
                    this.sportStudService.addSportStud(sportStud);
                }
                else {
                    resultBean.setMsg("已经是签到员，设置失败");
                    resultBean.setCode(2);
                }
            }catch (Exception e){
                resultBean.setMsg("设置失败"+e.getMessage());
                resultBean.setCode(1);
            }
        }
        return resultBean;
    }

    //撤销早操签到员
    @RequestMapping("/cancelChecker/{sportId}/{studentId}")
    public ResultBean cancelChecker(@PathVariable Integer sportId,@PathVariable Integer studentId){
        Subject subject = SecurityUtils.getSubject();
        boolean[] booleans = subject.hasRoles(Arrays.asList("teacher","classmanager"));
        ResultBean resultBean = new ResultBean();
        if (HasRole.hasOneRole(booleans)) {
            try {
                User rolesByUsername = this.userService.findUsersByStudentNum(this.studentService.findStudentById(studentId).getStudentNumber());
                if (rolesByUsername.getIdentity().equals("签到员")) {
                    rolesByUsername.setIdentity("学生");
                    this.userService.ModifyUser(rolesByUsername);
                    this.sportStudService.DeleteSportStud(sportId, studentId);
                }
                else {
                    resultBean.setMsg("不是签到员，设置失败");
                    resultBean.setCode(2);
                }
            }catch (Exception e){
                resultBean.setMsg("设置失败"+e.getMessage());
                resultBean.setCode(1);
            }
        }
        return resultBean;
    }
}
